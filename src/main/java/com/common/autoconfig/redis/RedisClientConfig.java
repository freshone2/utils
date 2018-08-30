package com.common.autoconfig.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.common.redis.RedisClient;
import com.common.redis.RedisClientJedis;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.SharingJedisCluster;

/**
 * redis客户端配置
 * 
 * @author xiangshuo
 *
 */
@Configuration
@ConditionalOnClass(JedisCluster.class)
@ConditionalOnProperty(prefix = "utils.redis", value = "enable", havingValue = "true")
public class RedisClientConfig {

	@Bean
    public RedisClient redisClient(SharingJedisCluster sharingJedisCluster){
    	return new RedisClientJedis(sharingJedisCluster);
    }
}
