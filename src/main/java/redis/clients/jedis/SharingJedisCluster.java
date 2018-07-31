package redis.clients.jedis;

import com.common.model.bo.redis.JedisClusterPipeline;
import com.common.model.dao.redis.AssemblyRedisDao;
import com.google.gson.Gson;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.util.JedisClusterCRC16;
import redis.clients.util.SafeEncoder;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: com.common.model.bo.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/5/23 下午3:51
 */
public class SharingJedisCluster extends JedisCluster {
    private static final Logger LOGGER = LoggerFactory.getLogger(SharingJedisCluster.class);
    
    private static final String luaOrderScript = "local value = redis.call('hget', KEYS[1], ARGV[1]) if not value then return false end value = tonumber(value) local decrby = tonumber(ARGV[2]) if value >= decrby then return redis.call('hincrby', KEYS[1], ARGV[1], -decrby) end return false";

    private static final String luaLockStockScript = "";

    private static final String luaUnlockStockScript = "";

    private static final String luaReadLockScript = "local writemode = redis.call('hget', KEYS[1], 'writemode'); if (writemode == false) or (writemode == '1' and redis.call('hexists', KEYS[1], ARGV[2]) == 1) then redis.call('hincrby', KEYS[1], 'readmode', 1); redis.call('hincrby', KEYS[1], ARGV[1], 1); redis.call('pexpire', KEYS[1], ARGV[3]); return nil; end; return redis.call('pttl', KEYS[1]);";

    private static final String luaWriteLockScript = "local readmode = redis.call('hget', KEYS[1], 'readmode'); local writemode = redis.call('hget', KEYS[1], 'writemode'); if (readmode == false and writemode == false) then redis.call('hset', KEYS[1], 'writemode', 1); redis.call('hset', KEYS[1], ARGV[1], 1); redis.call('pexpire', KEYS[1], ARGV[2]); return nil; end; if (writemode == '1') and (redis.call('hexists', KEYS[1], ARGV[1]) == 1) then redis.call('hincrby', KEYS[1], ARGV[1], 1); local currentExpire = redis.call('pttl', KEYS[1]); redis.call('pexpire', KEYS[1], currentExpire + ARGV[2]); return nil;  end;return redis.call('pttl', KEYS[1]);";

    private static final String luaReleaseReadLockScript = "local readmode = redis.call('hget', KEYS[1], 'readmode'); local writemode = redis.call('hget', KEYS[1], 'writemode'); if (readmode == false and writemode == false) then return 1; end; local lockExists = redis.call('hexists', KEYS[1], ARGV[1]); if (lockExists == 0) then return 0; end; local counter = redis.call('hincrby', KEYS[1], ARGV[1], -1); local totalReadCount = redis.call('hincrby', KEYS[1], 'readmode', -1); if (counter <= 0) then redis.call('hdel', KEYS[1], ARGV[1]); end; if (redis.call('hlen', KEYS[1]) > 1) then if (totalReadCount <= 0) then redis.call('del', KEYS[1]); return 1; end if writemode == '1' then return 0; end; end; if (totalReadCount <= 0) then redis.call('del', KEYS[1]); return 1; end return 1;";

    private static final String luaReleaseWriteLockScript = "local readmode = redis.call('hget', KEYS[1], 'readmode'); local writemode = redis.call('hget', KEYS[1], 'writemode'); if (readmode == false and writemode == false) then return 1; end; if (writemode == '1') then local lockExists = redis.call('hexists', KEYS[1], ARGV[1]); if (lockExists == 0) then return nil; else local counter = redis.call('hincrby', KEYS[1], ARGV[1], -1); if (counter > 0) then redis.call('pexpire', KEYS[1], ARGV[2]); return 0; else redis.call('hdel', KEYS[1], ARGV[1]); if (redis.call('hlen', KEYS[1]) == 1) then redis.call('del', KEYS[1]); else redis.call('hdel', KEYS[1], 'writemode'); end; return 1; end; end; end; return nil;";

    private static final Gson GSON = new Gson();
    public static final String WRITE_LOCK_FIELD_PREFIX = "write";
    public static final String READ_LOCK_FIELD_PREFIX = "read";

    private static JedisSlotBasedConnectionHandler cacheConnectionHandler;

    private static JedisClusterInfoCache cacheClusterInfoCache;

    private static final Map<JedisPool,String> luaOrderMap = new ConcurrentHashMap<>();

    private static final Map<JedisPool,String> luaLockStockMap = new ConcurrentHashMap<>();

    private static final Map<JedisPool,String> luaReadLockMap = new ConcurrentHashMap<>();

    private static final Map<JedisPool,String> luaWriteLockMap = new ConcurrentHashMap<>();

    private static final Map<JedisPool,String> luaReleaseReadLockMap = new ConcurrentHashMap<>();

    private static final Map<JedisPool,String> luaReleaseWriteLockMap = new ConcurrentHashMap<>();

    private static final Map<JedisPool,String> luaUnlockStockMap = new ConcurrentHashMap<>();

    private ThreadLocal<JedisClusterPipeline> jedisClusterPipelineThreadLocal = new ThreadLocal<>();
    
    private String localServerIp ;

    public SharingJedisCluster(HostAndPort node,String localServerIp) {
        super(node);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(HostAndPort node, int timeout,String localServerIp) {
        super(node, timeout);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(HostAndPort node, int timeout, int maxAttempts,String localServerIp) {
        super(node, timeout, maxAttempts);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(HostAndPort node, GenericObjectPoolConfig poolConfig,String localServerIp) {
        super(node, poolConfig);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(HostAndPort node, int timeout, GenericObjectPoolConfig poolConfig,String localServerIp) {
        super(node, timeout, poolConfig);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(HostAndPort node, int timeout, int maxAttempts, GenericObjectPoolConfig poolConfig,String localServerIp) {
        super(node, timeout, maxAttempts, poolConfig);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(HostAndPort node, int connectionTimeout, int soTimeout, int maxAttempts, GenericObjectPoolConfig poolConfig,String localServerIp) {
        super(node, connectionTimeout, soTimeout, maxAttempts, poolConfig);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(HostAndPort node, int connectionTimeout, int soTimeout, int maxAttempts, String password, GenericObjectPoolConfig poolConfig,String localServerIp) {
        super(node, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(Set<HostAndPort> nodes,String localServerIp) {
        super(nodes);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(Set<HostAndPort> nodes, int timeout,String localServerIp) {
        super(nodes, timeout);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(Set<HostAndPort> nodes, int timeout, int maxAttempts,String localServerIp) {
        super(nodes, timeout, maxAttempts);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(Set<HostAndPort> nodes, GenericObjectPoolConfig poolConfig,String localServerIp) {
        super(nodes, poolConfig);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(Set<HostAndPort> nodes, int timeout, GenericObjectPoolConfig poolConfig,String localServerIp) {
        super(nodes, timeout, poolConfig);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(Set<HostAndPort> jedisClusterNode, int timeout, int maxAttempts, GenericObjectPoolConfig poolConfig,String localServerIp) {
        super(jedisClusterNode, timeout, maxAttempts, poolConfig);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(Set<HostAndPort> jedisClusterNode, int connectionTimeout, int soTimeout, int maxAttempts, GenericObjectPoolConfig poolConfig,String localServerIp) {
        super(jedisClusterNode, connectionTimeout, soTimeout, maxAttempts, poolConfig);
        this.localServerIp = localServerIp;
    }

    public SharingJedisCluster(Set<HostAndPort> jedisClusterNode, int connectionTimeout, int soTimeout, int maxAttempts, String password, GenericObjectPoolConfig poolConfig,String localServerIp) {
        super(jedisClusterNode, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);
        this.localServerIp = localServerIp;
    }

    public void initLuaOrder(){
         Map<String, JedisPool> nodeMap = getClusterNodes();
        for (Map.Entry<String,JedisPool> entry : nodeMap.entrySet()){
            Jedis redis = entry.getValue().getResource();
            String sha1OrderKey =redis.scriptLoad(luaOrderScript);
            luaOrderMap.put(entry.getValue(),sha1OrderKey);
            String sha1LockStockKey =redis.scriptLoad(luaLockStockScript);
            luaLockStockMap.put(entry.getValue(),sha1LockStockKey);
            String sha1UnlockStockKey =redis.scriptLoad(luaUnlockStockScript);
            luaUnlockStockMap.put(entry.getValue(),sha1UnlockStockKey);
        }
    }

    public Integer deductStock(String key,Map<String,Integer> stockMap){
        //TODO 扣减库存lua脚本
        Object result = evalScriptSha(key,luaOrderMap,luaOrderScript,GSON.toJson(stockMap));
        if (result == null){
            return null;
        }
        return NumberUtils.toInt(result.toString());
    }

    public Integer lockStock(String key,Map<String,Integer> stockMap){
        //TODO 锁库存lua脚本
        Object result = evalScriptSha(key,luaLockStockMap,luaLockStockScript,GSON.toJson(stockMap));
        if (result == null){
            return null;
        }
        return NumberUtils.toInt(result.toString());
    }

    public Integer unlockStock(String key,Map<String,Integer> stockMap){
        //TODO 释放被锁库存lua脚本
        Object result = evalScriptSha(key,luaUnlockStockMap,luaUnlockStockScript,GSON.toJson(stockMap));
        if (result == null){
            return null;
        }
        return NumberUtils.toInt(result.toString());
    }

    public Set<String> keys(String pattern) {
        Set<String> keys = new HashSet<>();
        Map<String, JedisPool> clusterNodes = this.getClusterNodes();
        for(JedisPool jedisPool : clusterNodes.values() ) {
            Jedis jedis = jedisPool.getResource();
            try {
                keys.addAll(jedis.keys(pattern));
            } catch (Exception e) {
                LOGGER.error("获取keys发生异常！{}",e);
            } finally {
                jedis.close();
            }
        }
        return keys;
    }

    public JedisClusterPipeline pipelined(){
        JedisClusterPipeline pipeline =  jedisClusterPipelineThreadLocal.get();
        if (pipeline == null) {
            pipeline = new JedisClusterPipeline();
            pipeline.setJedisCluster(this);
        }
//        pipeline.refreshCluster();
        return pipeline;
    }

    public Jedis getJedis(String key){
        byte[] bKey = SafeEncoder.encode(key);
        int slot = JedisClusterCRC16.getSlot(bKey);
        Jedis jedis = connectionHandler.getConnectionFromSlot(slot);
        return jedis;
    }

    public boolean lock(String key,String value){
        return lock(key,value,System.currentTimeMillis()+ AssemblyRedisDao
                .DEFAULT_TIMEOUT,AssemblyRedisDao.DEFAULT_EXPIRE);
    }

    public boolean lock(String key, String value
            , long timeout , long expire){
        Jedis redis = getJedis(key);
        try{
            return lock(redis,key,value,timeout,expire);
        }catch (Exception e){
            LOGGER.error("错误：{}",e);
        }finally {
            if (null != redis) {
                redis.close();
            }
        }
        return false;
    }

    /**
     * 获取写锁
     *
     * @param key
     * @param timeout
     * @param expire
     * @return
     */
    public boolean writeLock(String key, long timeout , long expire){
        while (System.currentTimeMillis()<=timeout) {
            Object result = evalScriptSha(key, luaWriteLockMap, luaWriteLockScript
                    , buildString("-", WRITE_LOCK_FIELD_PREFIX, localServerIp
                            , String.valueOf(Thread.currentThread().getId())), String.valueOf(expire));
            if (result == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取写锁
     *
     * @param key
     * @return
     */
    public boolean writeLock(String key){
        return writeLock(key,System.currentTimeMillis()+ AssemblyRedisDao
                .DEFAULT_TIMEOUT,AssemblyRedisDao.DEFAULT_EXPIRE);
    }

    /**
     * 释放写锁
     *
     * @param key
     */
    public void writeReleaseLock(String key ){
        evalScriptSha(key, luaReleaseWriteLockMap, luaReleaseWriteLockScript
                , buildString("-", WRITE_LOCK_FIELD_PREFIX, localServerIp
                        , String.valueOf(Thread.currentThread().getId())), String.valueOf(AssemblyRedisDao.DEFAULT_EXPIRE));
    }

    /**
     * 获取读锁
     *
     * @param key
     * @param timeout
     * @param expire
     * @return
     */
    public boolean readLock(String key, long timeout , long expire){
        while (System.currentTimeMillis()<=timeout) {
            Object result = evalScriptSha(key, luaReadLockMap, luaReadLockScript
                    , buildString("-", READ_LOCK_FIELD_PREFIX, localServerIp
                            , String.valueOf(Thread.currentThread().getId()))
                    , buildString("-", WRITE_LOCK_FIELD_PREFIX, localServerIp
                            , String.valueOf(Thread.currentThread().getId())), String.valueOf(expire));
            if (result == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取读锁
     *
     * @param key
     * @return
     */
    public boolean readLock(String key){
        return readLock(key,System.currentTimeMillis()+ AssemblyRedisDao
                .DEFAULT_TIMEOUT,AssemblyRedisDao.DEFAULT_EXPIRE);
    }

    /**
     * 释放读锁
     *
     * @param key
     */
    public void readReleaseLock(String key){
        evalScriptSha(key, luaReleaseReadLockMap, luaReleaseReadLockScript
                , buildString("-", READ_LOCK_FIELD_PREFIX, localServerIp
                        , String.valueOf(Thread.currentThread().getId())));
    }

    public boolean unlock(String key,String value){
        Jedis redis = getJedis(key);
        try {
            return unlock(redis,key,value);
        }catch (Exception e){
            LOGGER.error("错误：{}",e);
        }finally {
            if (null != redis) {
                redis.close();
            }
        }
        return false;
    }

    public boolean lock(Jedis redis,String key,String value
            ,long timeout ,long expire){
        try{
            while (System.currentTimeMillis()<timeout){
                long result = redis.setnx(key,value);
                if (result == 1){
                    redis.pexpire(key,expire);
                    return true;
                }
                Thread.sleep(3);
            }
        }catch (Exception e){
            LOGGER.error("错误:{}",e);
        }
        return false;
    }

    public boolean unlock(Jedis redis,String key,String value){
        try {
            while (true){
                redis.watch(key);
                if (StringUtils.equals(redis.get(key),value)){
                    Transaction transaction = redis.multi();
                    transaction.del(key);
                    List<Object> result = transaction.exec();
                    if (CollectionUtils.isEmpty(result)){
                        continue;
                    }
                }
                return true;
            }
        }catch (Exception e){
            LOGGER.error("错误：{}",e);
        }
        return false;
    }

    public boolean canUseOrder(String key){
        return canUseOrder(key,AssemblyRedisDao.DEFAULT_EXPIRE);
    }

    public boolean canUseOrder(String key,long expire){
        Jedis redis = getJedis(key);
        long result = redis.setnx(key,"1");
        if (result == 1){
            redis.pexpire(key, expire);
            redis.close();
            return true;
        }
        redis.close();
        return false;
    }

    private Object evalScriptSha(String key,Map<JedisPool,String> luaMap
            ,String luaScript,String... params){
        byte[] bKey = SafeEncoder.encode(key);
        int slot = JedisClusterCRC16.getSlot(bKey);
        JedisPool pool = connectionHandler.cache.getSlotPool(slot);
        Object result = null;
        Jedis redis = null;
        try {
            String luaOrderSha1 = luaMap.get(pool);
            if (StringUtils.isBlank(luaOrderSha1)){
                redis = pool.getResource();
                luaOrderSha1 =redis.scriptLoad(luaScript);
                luaMap.put(pool,luaOrderSha1);
            }
            if (redis == null) {
                redis = pool.getResource();
            }

            result = redis.evalsha(luaOrderSha1, Arrays.asList(key),Arrays.asList(params));
        }finally {
            if (redis != null){
                redis.close();
            }
        }
        return result;
    }

    private String buildString(String separator,String... strings){
        StringBuilder builder = new StringBuilder("");
        for (int i = 0 ; i<strings.length-1;i++){
            builder.append(strings[i]).append(separator);
        }
        if (strings.length-1>0){
            builder.append(strings[strings.length-1]);
        }
        return builder.toString();
    }
}
