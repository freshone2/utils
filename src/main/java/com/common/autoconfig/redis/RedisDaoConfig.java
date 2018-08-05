package com.common.autoconfig.redis;

import com.common.model.dao.redis.*;
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
        jedisCluster.initLuaOrder();
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

    @Bean
    @ConditionalOnProperty(value = "utils.dao.redis.virtualRate.enable",havingValue = "true")
    public BrandVirtualCoinUsedRateRedisDao createdBrandVirtualCoinUsedRateRedisDao(SharingJedisCluster jedisCluster){
        BrandVirtualCoinUsedRateRedisDao coinUsedRateRedisDao = new BrandVirtualCoinUsedRateRedisDao();
        coinUsedRateRedisDao.setSharingJedisCluster(jedisCluster);
        return coinUsedRateRedisDao;
    }

    @Bean
    @ConditionalOnProperty(value = "utils.dao.redis.config.enable",havingValue = "true")
    public ConfigRedisDao createdConfigRedisDao(SharingJedisCluster jedisCluster){
        ConfigRedisDao configRedisDao = new ConfigRedisDao();
        configRedisDao.setSharingJedisCluster(jedisCluster);
        return configRedisDao;
    }

    @Bean
    @ConditionalOnProperty(value = "utils.dao.redis.buyGift.enable",havingValue = "true")
    public BuyGiftRedisDao createdBuyGiftRedisDao(SharingJedisCluster jedisCluster){
        BuyGiftRedisDao configRedisDao = new BuyGiftRedisDao();
        configRedisDao.setSharingJedisCluster(jedisCluster);
        return configRedisDao;
    }

    @Bean
    @ConditionalOnProperty(value = "utils.dao.redis.stock.enable",havingValue = "true")
    public StockRedisDao createdStockRedisDao(SharingJedisCluster jedisCluster){
        StockRedisDao stockRedisDao = new StockRedisDao();
        stockRedisDao.setSharingJedisCluster(jedisCluster);
        return stockRedisDao;
    }

    @Bean
    @ConditionalOnProperty(value = "utils.dao.redis.preSale.enable",havingValue = "true")
    public PreSaleRedisDao createdPreSaleRedisDao(SharingJedisCluster jedisCluster){
        PreSaleRedisDao preSaleRedisDao = new PreSaleRedisDao();
        preSaleRedisDao.setSharingJedisCluster(jedisCluster);
        return preSaleRedisDao;
    }


}
