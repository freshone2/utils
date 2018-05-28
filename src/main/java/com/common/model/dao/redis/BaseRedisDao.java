package com.common.model.dao.redis;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.SharingJedisCluster;

import java.lang.annotation.Inherited;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: pecker.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/3/20 上午11:06
 */
public class BaseRedisDao {
    protected static final Gson GSON = new Gson();
    public static final int MAX_RETRY_COUNT = 5;

    private SharingJedisCluster sharingJedisCluster;

    protected SharingJedisCluster getRedis(){
        return sharingJedisCluster;
    }

    protected String buildString(String separator,String... strings){
        StringBuilder builder = new StringBuilder("");
        for (int i = 0 ; i<strings.length-1;i++){
            builder.append(strings[i]).append(separator);
        }
        if (strings.length-1>0){
            builder.append(strings[strings.length-1]);
        }
        return builder.toString();
    }

    public SharingJedisCluster getSharingJedisCluster() {
        return sharingJedisCluster;
    }

    public void setSharingJedisCluster(SharingJedisCluster sharingJedisCluster) {
        this.sharingJedisCluster = sharingJedisCluster;
    }
}
