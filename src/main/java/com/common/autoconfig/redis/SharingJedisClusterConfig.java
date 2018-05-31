package com.common.autoconfig.redis;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(SharingJedisClusterConfig.class);

    @Value("${utils.redis.nodes:}")
    private String nodes;

    @Value("${utils.redis.timeout:1000}")
    private int timeout;

    @Value("${utils.redis.maxAttempts:2000}")
    private int maxAttempts;

    @Value("${utils.redis.maxIdle:8}")
    private int maxIdle;

    @Value("${utils.redis.minIdle:0}")
    private int minIdle;

    @Value("${utils.redis.maxTotal:8}")
    private int maxTotal;

    @Value("${utils.redis.maxWaitMills:10000}")
    private long maxWaitMills;

    @Value("${utils.redis.testOnBorrow:true}")
    private boolean testOnBorrow;

    @Value("${utils.redis.testOnCreate:true}")
    private boolean testOnCreate;

    @Value("${utils.redis.testWhileIdle:true}")
    private boolean testWhileIdle;

    @Value("${utils.redis.password:}")
    private String password;

    @Value("${utils.redis.connectionTimeout:1000}")
    private int connectionTimeout;

    @Bean
    public SharingJedisCluster createdSharingJedisCluster(){
        LOGGER.info("{},{}",timeout,maxAttempts);
        if (StringUtils.isEmpty(nodes)){
            throw new NullPointerException();
        }

        Set<HostAndPort> nodeSet = new HashSet<>();
        for (String ipPort : nodes.split(",")) {
            String[] ipPortPair = ipPort.split(":");
            LOGGER.info(ipPortPair[0].trim()+"---"+ipPortPair[1].trim());
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
        SharingJedisCluster cluster = null;
        if ( StringUtils.isNotBlank(password)){
            cluster = new SharingJedisCluster(nodeSet,connectionTimeout,timeout,maxAttempts,password,jedisPoolConfig);
        }
        cluster = new SharingJedisCluster(nodeSet,connectionTimeout,timeout,maxAttempts,jedisPoolConfig);
        return cluster;
    }
}
