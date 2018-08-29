package com.common.model.dao.redis;

import com.common.model.bo.cache.RedisCommodityBo;
import com.common.model.bo.redis.JedisClusterPipeline;
import com.common.model.bo.stock.AppStockUpsertBo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.SharingJedisCluster;

import java.util.*;

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
    public int deductStock(String appCode, Map<Integer, Integer> specIdStockMap) {
        SharingJedisCluster redis = getRedis();
        //TODO 扣减库存传参逻辑变更
        redis.deductStock(appCode, null);
        return 0;
    }

    public int lockStock(String appCode, Map<Integer, Integer> specIdStockMap
            , Map<Integer, Integer> activityStockMap) {
        //TODO 锁库存
        SharingJedisCluster redis = getRedis();
        redis.lockStock(appCode, null);
        return 0;
    }

    /**
     * 更新商品库存
     *
     * @return
     */
    public boolean upsertStock(AppStockUpsertBo appStockUpsertBo) {
        Map<String, String> setMap = new LinkedHashMap<>();

        if (null != appStockUpsertBo.getShareStock()) {
            setMap.put(buildString("-", appStockUpsertBo
                    .getSpecId().toString(), appStockUpsertBo.getAppCode()), appStockUpsertBo.getShareStock().toString());
        }

//        if (null != appStockUpsertBo.getPlatformStock()) {
//            setMap.put(buildString("-", appStockUpsertBo
//                    .getSpecId().toString(), "platform"), appStockUpsertBo.getPlatformStock().toString());
//        }

        if (MapUtils.isNotEmpty(appStockUpsertBo.getExclusiveStockMap())) {
            for (Map.Entry<String, Integer> entry : appStockUpsertBo
                    .getExclusiveStockMap().entrySet()) {
                setMap.put(buildString("-", appStockUpsertBo
                        .getSpecId().toString(), appStockUpsertBo.getAppCode(), entry.getKey()), entry.getValue().toString());
            }
        }

        if (MapUtils.isNotEmpty(appStockUpsertBo.getActivityStockMap())) {
            for (Map.Entry<Integer, Integer> entry : appStockUpsertBo
                    .getActivityStockMap().entrySet()) {
                setMap.put(buildString("-", appStockUpsertBo
                        .getSpecId().toString(), appStockUpsertBo.getAppCode(), "activity", entry.getKey().toString()), entry.getValue().toString());
            }
        }

        SharingJedisCluster redis = getRedis();
        String result = redis.hmset(STOCK_KEY, setMap);
        return "OK".equalsIgnoreCase(result);
    }

    /**
     * 更新渠道库存
     *
     * @param appCode
     * @param specIdStockMap
     * @return
     */
    public boolean upsertAppStock(String appCode, Map<Integer, Integer> specIdStockMap) {
        Map<String, String> setMap = new LinkedHashMap<>();

        if (null != specIdStockMap) {
            for (Map.Entry<Integer, Integer> entry : specIdStockMap.entrySet()) {
                setMap.put(buildString("-", entry.getKey().toString(), appCode), entry.getValue().toString());
            }
        }
        if (MapUtils.isNotEmpty(setMap)) {
            SharingJedisCluster redis = getRedis();
            String result = redis.hmset(STOCK_KEY, setMap);
            return "OK".equalsIgnoreCase(result);
        }
        return true;
    }

    /**
     * 查找仓库下的规格库存
     *
     * @param warehouseCode
     * @param specIds
     * @return
     */
    public Map<Integer, Integer> findPlatformStocks(List<String> warehouseCode, List<Integer> specIds) {
        if (CollectionUtils.isEmpty(warehouseCode) || CollectionUtils.isEmpty(specIds)) {
            return new HashMap<>();
        }

        List<String> keys = new ArrayList<>(warehouseCode.size() * specIds.size());
        for (int j = 0; j < specIds.size(); j++) {
            for (int i = 0; i < warehouseCode.size(); i++) {
                keys.add(buildString("-", "platform", warehouseCode.get(i), specIds.get(j).toString()));
            }
        }
        SharingJedisCluster redis = getRedis();
        List<String> values = redis.hmget(STOCK_KEY, keys.toArray(new String[0]));
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < values.size(); i += warehouseCode.size()) {
            int loopSize = warehouseCode.size();
            Integer count = 0;
            while (loopSize > 0) {
                if (StringUtils.isBlank(values.get(i))) {
                    continue;
                }
                count += Integer.valueOf(values.get(i));
            }
            resultMap.put(specIds.get(i / warehouseCode.size()), count);
        }
        return resultMap;
    }

    /**
     * 更新平台库存
     *
     * @param warehouseCode
     * @param specIdStockMap
     * @return
     */
    public boolean upsertStocks(String warehouseCode, Map<Integer, Integer> specIdStockMap) {
        if (MapUtils.isEmpty(specIdStockMap)) {
            return true;
        }

        Map<String, String> setMap = new LinkedHashMap<>();
        if (null != specIdStockMap) {
            for (Map.Entry<Integer, Integer> entry : specIdStockMap.entrySet()) {
                setMap.put(buildString("-", "platform", warehouseCode, entry.getKey().toString()), entry.getValue().toString());
            }
        }
        SharingJedisCluster redis = getRedis();
        String result = redis.hmset(STOCK_KEY, setMap);
        return "OK".equalsIgnoreCase(result);
    }

    /**
     * 批量查询渠道库存
     *
     * @param specIds
     * @param appCode
     * @return
     */
    public Map<Integer, Integer> findAppStocks(List<Integer> specIds, String appCode) {
        SharingJedisCluster redis = getRedis();
        String[] keys = new String[specIds.size()];
        for (int i = 0; i < specIds.size(); i++) {
            keys[i] = buildString("-", specIds.get(i).toString(), appCode);
        }
        List<String> values = redis.hmget(STOCK_KEY, keys);
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < specIds.size(); i++) {
            int stock = 0;
            if (values.get(i) != null) {
                stock = Integer.valueOf(values.get(i));
            }
            resultMap.put(specIds.get(i), stock);
        }
        return resultMap;
    }

    /**
     * 更新活动库存
     * @param appCode
     * @param activityId
     * @param specIdStockMap
     * @return
     */
//    public boolean upsertActivityStocks(String appCode,Integer activityId,Map<Integer,Integer> specIdStockMap){
//        if(MapUtils.isEmpty(specIdStockMap)){
//            return true;
//        }
//        //TODO lock
//        for (Map.Entry<Integer,Integer> entry : specIdStockMap.entrySet()){
//            buildString("-",entry.getKey().toString(),appCode,"activity",activityId.toString());
//            buildString("-", entry.getKey().toString(), appCode);
//        }
//        buildString("-", entry.getKey().toString(), appCode
//    }

    /**
     * 释放被锁商品库存
     *
     * @return
     */
    public int unlockStock(String appCode, Map<Integer, Integer> specIdStockMap
            , Map<Integer, Integer> activityStockMap) {
        SharingJedisCluster redis = getRedis();
        //TODO 释放被锁商品库存
        redis.unlockStock(appCode, null);
        return 0;
    }

    public boolean deductAppStockSingle(String appCode,Integer commodityId ,Integer specId,Integer stock) {
        SharingJedisCluster redis = getRedis();
        redis.hincrBy(STOCK_KEY, buildString("-", specId.toString(), appCode), -stock);
        redis.hincrBy(this.buildString(":", new String[]{"commodity", appCode, commodityId.toString()}), "purchasesCount", (long)stock);
        return true;
    }
}
