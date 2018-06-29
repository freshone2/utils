package com.common.autoconfig.controller;

import com.common.controller.HealthController;
import com.common.model.dao.redis.ActivityRedisDao;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.SharingJedisCluster;

/**
 * @Package: com.common.autoconfig.controller
 * @Description:
 * @author: jklofs
 * @date: 2018/6/29 下午4:38
 */
@Configuration
public class ControllerConfig {
    @Bean
    public HealthController createdHealthController(){
        return new HealthController();
    }
}
