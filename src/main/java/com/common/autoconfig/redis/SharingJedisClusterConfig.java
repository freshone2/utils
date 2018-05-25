package com.common.autoconfig.redis;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.SharingJedisCluster;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Package: com.common.autoconfig.feign
 * @Description:
 * @author: jklofs
 * @date: 2018/5/23 下午4:16
 */
@Configuration
@ConditionalOnClass(JedisCluster.class)
@ConditionalOnProperty(prefix = "utils.redis",value = "enable",havingValue = "true")
public class SharingJedisClusterConfig {

    @Value("nodes")
    private Set<String> nodes;

    @Value("timeout:1000")
    private int timeout;

    @Value("maxAttempts:2000")
    private int maxAttempts;

    @Value("maxIdle:8")
    private int maxIdle;

    @Value("minIdle:0")
    private int minIdle;

    @Value("maxTotal:8")
    private int maxTotal;

    @Value("maxWaitMills:10000")
    private long maxWaitMills;

    @Value("testOnBorrow:true")
    private boolean testOnBorrow;

    @Value("testOnCreate:true")
    private boolean testOnCreate;

    @Value("testWhileIdle:true")
    private boolean testWhileIdle;

    @Bean
    public SharingJedisCluster createdSharingJedisCluster(){
        if (CollectionUtils.isEmpty(nodes)){
            throw new NullPointerException();
        }

        Set<HostAndPort> nodeSet = new HashSet<>();
        for (String ipPort : nodes) {
            String[] ipPortPair = ipPort.split(":");
            nodeSet.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMills);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnCreate(testOnCreate);
        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        SharingJedisCluster cluster = new SharingJedisCluster(nodeSet,timeout,maxAttempts,jedisPoolConfig);
        return cluster;
    }
}
