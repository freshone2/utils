package com.common.model.dao.redis;

import com.common.model.bo.stock.AppStockUpsertBo;
import org.apache.commons.collections4.MapUtils;
import redis.clients.jedis.SharingJedisCluster;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Package: com.common.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/7/16 下午3:51
 */
public class StockRedisDao extends BaseRedisDao {
    public static final String STOCK_KEY = "stock";

    public static final String STOCK_WRITE_LOCK = "lock:w:stock";

    /**
     * 扣减库存
     *
     * @return
     */
    public int deductStock(String appCode, Map<Integer,Integer> specIdStockMap) {
        SharingJedisCluster redis = getRedis();
        //TODO 扣减库存传参逻辑变更
        redis.deductStock(appCode,null);
        return 0;
    }

    public int lockStock(String appCode, Map<Integer,Integer> specIdStockMap
            ,Map<Integer,Integer> activityStockMap){
        //TODO 锁库存
        SharingJedisCluster redis = getRedis();
        redis.lockStock(appCode,null);
        return 0;
    }

    /**
     * 更新商品库存
     *
     * @return
     */
    public int upsertStock(AppStockUpsertBo appStockUpsertBo){
        Map<String,String> setMap = new LinkedHashMap<>();

        if (null != appStockUpsertBo.getShareStock()) {
            setMap.put(buildString("-", appStockUpsertBo
                    .getSpecId().toString(), "app"), appStockUpsertBo.getShareStock().toString());
        }

        if (null != appStockUpsertBo.getPlatformStock()) {
            setMap.put(buildString("-", appStockUpsertBo
                    .getSpecId().toString(), "platform"), appStockUpsertBo.getPlatformStock().toString());
        }

        if (MapUtils.isNotEmpty(appStockUpsertBo.getExclusiveStockMap())){
            for (Map.Entry<String,Integer> entry : appStockUpsertBo
                    .getExclusiveStockMap().entrySet()){
                setMap.put(buildString("-",appStockUpsertBo
                        .getSpecId().toString(),"app",entry.getKey()),entry.getValue().toString());
            }
        }

        if (MapUtils.isNotEmpty(appStockUpsertBo.getActivityStockMap())){
            for (Map.Entry<String,Integer> entry : appStockUpsertBo
                    .getExclusiveStockMap().entrySet()){
                setMap.put(buildString("-",appStockUpsertBo
                        .getSpecId().toString(),"activity",entry.getKey()),entry.getValue().toString());
            }
        }

        SharingJedisCluster redis = getRedis();
        redis.hmset(STOCK_KEY,setMap);
        return 0;
    }

    /**
     * 释放被锁商品库存
     *
     * @return
     */
    public int unlockStock(String appCode, Map<Integer,Integer> specIdStockMap
            ,Map<Integer,Integer> activityStockMap){
        SharingJedisCluster redis = getRedis();
        //TODO 释放被锁商品库存
        redis.unlockStock(appCode,null);
        return 0;
    }
}
