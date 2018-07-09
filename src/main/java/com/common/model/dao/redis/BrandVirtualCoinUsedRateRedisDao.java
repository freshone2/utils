package com.common.model.dao.redis;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import redis.clients.jedis.JedisCluster;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.common.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/7/2 下午2:42
 */
public class BrandVirtualCoinUsedRateRedisDao extends BaseRedisDao{

    private static final String BRAND_VIRTUAL_COIN_USED_RATE_PREFIX = "b:vc:u:r";

    public Map<Integer,BigDecimal> findBrandVirtualCoinUsedRateMap(String appCode){
        JedisCluster redis = getRedis();

        Map<String,String> result = redis.hgetAll(buildString(":"
                ,BRAND_VIRTUAL_COIN_USED_RATE_PREFIX,appCode));
        if (MapUtils.isEmpty(result)){
            return null;
        }
        Map<Integer,BigDecimal> bigDecimalMap = new HashMap<>(result.size());
        for (Map.Entry<String,String> entry : result.entrySet()){
            bigDecimalMap.put(NumberUtils.toInt(entry.getKey()),new BigDecimal(entry.getValue()));
        }
        return bigDecimalMap;
    }

    public boolean upsertBrandVirtualCoinUsedRate(String appCode , Integer brandId , Double rate){
        JedisCluster redis = getRedis();
        redis.hset(buildString(":"
                ,BRAND_VIRTUAL_COIN_USED_RATE_PREFIX,appCode),brandId.toString(),rate.toString());
        return true;
    }

    public boolean removeBrandVirtualCoinUsedRate(String appCode , Integer brandId ){
        JedisCluster redis = getRedis();
        redis.hdel(buildString(":"
                ,BRAND_VIRTUAL_COIN_USED_RATE_PREFIX,appCode),brandId.toString());
        return true;
    }

    public boolean upsertAllBrandVirtualCoinUsedRate(String appCode , Map<Integer,Double> rateMap){
        if (MapUtils.isEmpty(rateMap)){
            return true;
        }
        Map<String,String> rateStringMap = new HashMap<>(rateMap.size());
        for (Map.Entry<Integer,Double> entry : rateMap.entrySet() ){
            rateStringMap.put(entry.getKey().toString(),entry.getValue().toString());
        }
        JedisCluster redis = getRedis();
        redis.hmset(buildString(":"
                ,BRAND_VIRTUAL_COIN_USED_RATE_PREFIX,appCode),rateStringMap);
        return true;
    }

    public BigDecimal findBrandVirtualCoinUsedRate(String appCode , Integer brandId ){
        JedisCluster redis = getRedis();
        String rate = redis.hget(buildString(":"
                ,BRAND_VIRTUAL_COIN_USED_RATE_PREFIX,appCode),brandId.toString());
        if (StringUtils.isBlank(rate)){
            return null;
        }
        return new BigDecimal(rate);
    }
}
