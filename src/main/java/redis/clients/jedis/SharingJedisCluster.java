package redis.clients.jedis;

import com.common.model.bo.redis.JedisClusterPipeline;
import com.common.model.dao.redis.AssemblyRedisDao;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.util.JedisClusterCRC16;
import redis.clients.util.SafeEncoder;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: com.common.model.bo.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/5/23 下午3:51
 */
public class SharingJedisCluster extends JedisCluster {
    private static final String luaScript = "local value = redis.call('hget', KEYS[1], ARGV[1]) if not value then return false end value = tonumber(value) local decrby = tonumber(ARGV[2]) if value >= decrby then return redis.call('hincrby', KEYS[1], ARGV[1], -decrby) end return false";

    private static JedisSlotBasedConnectionHandler cacheConnectionHandler;

    private static JedisClusterInfoCache cacheClusterInfoCache;

    private static final Map<JedisPool,String> luaOrderMap = new ConcurrentHashMap<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(SharingJedisCluster.class);

    private ThreadLocal<JedisClusterPipeline> jedisClusterPipelineThreadLocal = new ThreadLocal<>();

    public SharingJedisCluster(HostAndPort node) {
        super(node);
    }

    public SharingJedisCluster(HostAndPort node, int timeout) {
        super(node, timeout);
    }

    public SharingJedisCluster(HostAndPort node, int timeout, int maxAttempts) {
        super(node, timeout, maxAttempts);
    }

    public SharingJedisCluster(HostAndPort node, GenericObjectPoolConfig poolConfig) {
        super(node, poolConfig);
    }

    public SharingJedisCluster(HostAndPort node, int timeout, GenericObjectPoolConfig poolConfig) {
        super(node, timeout, poolConfig);
    }

    public SharingJedisCluster(HostAndPort node, int timeout, int maxAttempts, GenericObjectPoolConfig poolConfig) {
        super(node, timeout, maxAttempts, poolConfig);
    }

    public SharingJedisCluster(HostAndPort node, int connectionTimeout, int soTimeout, int maxAttempts, GenericObjectPoolConfig poolConfig) {
        super(node, connectionTimeout, soTimeout, maxAttempts, poolConfig);
    }

    public SharingJedisCluster(HostAndPort node, int connectionTimeout, int soTimeout, int maxAttempts, String password, GenericObjectPoolConfig poolConfig) {
        super(node, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);
    }

    public SharingJedisCluster(Set<HostAndPort> nodes) {
        super(nodes);
    }

    public SharingJedisCluster(Set<HostAndPort> nodes, int timeout) {
        super(nodes, timeout);
    }

    public SharingJedisCluster(Set<HostAndPort> nodes, int timeout, int maxAttempts) {
        super(nodes, timeout, maxAttempts);
    }

    public SharingJedisCluster(Set<HostAndPort> nodes, GenericObjectPoolConfig poolConfig) {
        super(nodes, poolConfig);
    }

    public SharingJedisCluster(Set<HostAndPort> nodes, int timeout, GenericObjectPoolConfig poolConfig) {
        super(nodes, timeout, poolConfig);
    }

    public SharingJedisCluster(Set<HostAndPort> jedisClusterNode, int timeout, int maxAttempts, GenericObjectPoolConfig poolConfig) {
        super(jedisClusterNode, timeout, maxAttempts, poolConfig);
    }

    public SharingJedisCluster(Set<HostAndPort> jedisClusterNode, int connectionTimeout, int soTimeout, int maxAttempts, GenericObjectPoolConfig poolConfig) {
        super(jedisClusterNode, connectionTimeout, soTimeout, maxAttempts, poolConfig);
    }

    public SharingJedisCluster(Set<HostAndPort> jedisClusterNode, int connectionTimeout, int soTimeout, int maxAttempts, String password, GenericObjectPoolConfig poolConfig) {
        super(jedisClusterNode, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);
    }

    public void initLuaOrder(){
         Map<String, JedisPool> nodeMap = getClusterNodes();
        for (Map.Entry<String,JedisPool> entry : nodeMap.entrySet()){
            Jedis redis = entry.getValue().getResource();
            String sha1Key =redis.scriptLoad(luaScript);
            luaOrderMap.put(entry.getValue(),sha1Key);
        }
    }

    public Integer deductStock(String key,String field,Integer num){
        byte[] bKey = SafeEncoder.encode(key);
        int slot = JedisClusterCRC16.getSlot(bKey);
        JedisPool pool = connectionHandler.cache.getSlotPool(slot);
        Object result = null;
        Jedis redis = null;
        try {
            String luaOrderSha1 = luaOrderMap.get(pool);
            if (StringUtils.isBlank(luaOrderSha1)){
                redis = pool.getResource();
                luaOrderSha1 =redis.scriptLoad(luaScript);
                luaOrderMap.put(pool,luaOrderSha1);
            }
            if (redis == null) {
                redis = pool.getResource();
            }
            result = redis.evalsha(luaOrderSha1,1,key,field,num.toString());
        }finally {
            if (redis != null){
                redis.close();
            }
        }

        if (result == null ){
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
            , long timeout , int expire){
        Jedis redis = getJedis(key);
        try{
            return lock(redis,key,value,timeout,expire);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != redis) {
                redis.close();
            }
        }
        return false;
    }


    public boolean unlock(String key,String value){
        Jedis redis = getJedis(key);
        try {
            return unlock(redis,key,value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != redis) {
                redis.close();
            }
        }
        return false;
    }

    public boolean lock(Jedis redis,String key,String value
            ,long timeout ,int expire){
        try{
            while (System.currentTimeMillis()<timeout){
                long result = redis.setnx(key,value);
                if (result == 1){
                    redis.expire(key,expire);
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
            e.printStackTrace();
        }
        return false;
    }

    public boolean canUseOrder(String key){
        return canUseOrder(key,AssemblyRedisDao.DEFAULT_EXPIRE);
    }

    public boolean canUseOrder(String key,Integer expire){
        Jedis redis = getJedis(key);
        long result = redis.setnx(key,"1");
        if (result == 1){
            redis.expire(key, expire);
            redis.close();
            return true;
        }
        redis.close();
        return false;
    }
}
