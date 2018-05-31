package redis.clients.jedis;

import com.common.model.bo.redis.JedisClusterPipeline;
import com.common.model.dao.redis.AssemblyRedisDao;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.util.JedisClusterCRC16;
import redis.clients.util.SafeEncoder;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Package: com.common.model.bo.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/5/23 下午3:51
 */
public class SharingJedisCluster extends JedisCluster {
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

    public JedisClusterPipeline pipelined(){
        JedisClusterPipeline pipeline = new JedisClusterPipeline();
        pipeline.setJedisCluster(this);
        pipeline.refreshCluster();
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
            e.printStackTrace();
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
