package com.common.model.dao.redis;

import com.common.model.bo.redis.JedisClusterPipeline;
import com.common.model.bo.stock.AppStockUpsertBo;
import org.apache.commons.collections4.MapUtils;
import redis.clients.jedis.SharingJedisCluster;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
    public boolean upsertStock(AppStockUpsertBo appStockUpsertBo){
        Map<String,String> setMap = new LinkedHashMap<>();

        if (null != appStockUpsertBo.getShareStock()) {
            setMap.put(buildString("-", appStockUpsertBo
                    .getSpecId().toString(), appStockUpsertBo.getAppCode()), appStockUpsertBo.getShareStock().toString());
        }

//        if (null != appStockUpsertBo.getPlatformStock()) {
//            setMap.put(buildString("-", appStockUpsertBo
//                    .getSpecId().toString(), "platform"), appStockUpsertBo.getPlatformStock().toString());
//        }

        if (MapUtils.isNotEmpty(appStockUpsertBo.getExclusiveStockMap())){
            for (Map.Entry<String,Integer> entry : appStockUpsertBo
                    .getExclusiveStockMap().entrySet()){
                setMap.put(buildString("-",appStockUpsertBo
                        .getSpecId().toString(),appStockUpsertBo.getAppCode(),entry.getKey()),entry.getValue().toString());
            }
        }

        if (MapUtils.isNotEmpty(appStockUpsertBo.getActivityStockMap())){
            for (Map.Entry<Integer,Integer> entry : appStockUpsertBo
                    .getActivityStockMap().entrySet()){
                setMap.put(buildString("-",appStockUpsertBo
                        .getSpecId().toString(),appStockUpsertBo.getAppCode(),"activity",entry.getKey().toString()),entry.getValue().toString());
            }
        }

        SharingJedisCluster redis = getRedis();
        String result=redis.hmset(STOCK_KEY,setMap);
        return "OK".equalsIgnoreCase(result);
    }

    /**
     * 更新渠道库存
     * @param appCode
     * @param specIdStockMap
     * @return
     */
    public boolean upsertAppStock(String appCode,Map<Integer,Integer> specIdStockMap){
        Map<String,String> setMap = new LinkedHashMap<>();

        if (null != specIdStockMap) {
            for (Map.Entry<Integer,Integer> entry : specIdStockMap.entrySet()) {
                setMap.put(buildString("-", entry.getKey().toString(), appCode), entry.getValue().toString());
            }
        }
        if(MapUtils.isNotEmpty(setMap)){
            SharingJedisCluster redis = getRedis();
            String result=redis.hmset(STOCK_KEY,setMap);
            return "OK".equalsIgnoreCase(result);
        }
        return true;
    }

    /**
     * 批量查询渠道库存
     * @param specIds
     * @param appCode
     * @return
     */
    public Map<Integer, Integer> findAppStocks(List<Integer> specIds, String appCode) {
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = null;
        try {
            String[] keys=new String[specIds.size()];
            for (int i=0;i<specIds.size();i++){
                keys[i]=buildString("-", specIds.get(i).toString(), appCode);
            }
            List<String> values= redis.hmget(STOCK_KEY, keys);
            Map<Integer,Integer> resultMap=new HashMap<>();
            for (int i=0;i<specIds.size();i++){
                resultMap.put(specIds.get(i),Integer.valueOf(values.get(i)));
            }
            return resultMap;
        } finally {
            if (pipeline != null) {
                pipeline.close();
            }
        }
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
