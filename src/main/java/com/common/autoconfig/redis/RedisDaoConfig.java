package com.common.autoconfig.redis;

import com.common.model.dao.redis.ActivityRedisDao;
import com.common.model.dao.redis.CommodityRedisDao;
import com.common.model.dao.redis.FreightRedisDao;
import com.common.model.dao.redis.VirtualCoinRedisDao;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.SharingJedisCluster;

/**
 * @Package: com.common.autoconfig.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/5/25 下午1:56
 */
@Configuration
@ConditionalOnClass(SharingJedisCluster.class)
@ConditionalOnBean(SharingJedisCluster.class)
public class RedisDaoConfig {

    @Bean
    @ConditionalOnProperty(value = "utils.dao.redis.activity.enable",havingValue = "true")
    public ActivityRedisDao createdActivityRedisDao(SharingJedisCluster jedisCluster){
        ActivityRedisDao activityRedisDao = new ActivityRedisDao();
        activityRedisDao.setSharingJedisCluster(jedisCluster);
        return activityRedisDao;
    }

    @Bean
    @ConditionalOnProperty(value = "utils.dao.redis.commodity.enable",havingValue = "true")
    public CommodityRedisDao createdCommodityRedisDao(SharingJedisCluster jedisCluster){
        CommodityRedisDao commodityRedisDao = new CommodityRedisDao();
        commodityRedisDao.setSharingJedisCluster(jedisCluster);
        return commodityRedisDao;
    }

    @Bean
    @ConditionalOnProperty(value = "utils.dao.redis.freight.enable",havingValue = "true")
    public FreightRedisDao createdFreightRedisDao(SharingJedisCluster jedisCluster){
        FreightRedisDao freightRedisDao = new FreightRedisDao();
        freightRedisDao.setSharingJedisCluster(jedisCluster);
        return freightRedisDao;
    }

    @Bean
    @ConditionalOnProperty(value = "utils.dao.redis.virtualCoin.enable",havingValue = "true")
    public VirtualCoinRedisDao createdVirtualCoinRedisDao(SharingJedisCluster jedisCluster){
        VirtualCoinRedisDao virtualCoinRedisDao = new VirtualCoinRedisDao();
        virtualCoinRedisDao.setSharingJedisCluster(jedisCluster);
        return virtualCoinRedisDao;
    }

}
