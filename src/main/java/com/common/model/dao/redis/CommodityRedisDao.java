package com.common.model.dao.redis;

import com.common.model.bo.biz.RedisSpecificationBo;
import com.common.model.bo.cache.RedisCommodityBo;
import com.common.model.bo.commodity.CommodityBo;
import com.common.model.bo.commodity.CommoditySpecificationBo;
import com.common.model.bo.redis.JedisClusterPipeline;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: pecker.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/3/26 上午11:35
 */
@ConditionalOnClass({AssemblyRedisDao.class, JedisPool.class})
@ConditionalOnBean({AssemblyRedisDao.class, JedisPool.class})
public class CommodityRedisDao extends BaseRedisDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommodityRedisDao.class);

    private static final int ZIP_LIST_NUM = 512;

    private static final String COMMODITY_PLATFORM_PREFIX_KEY = "platform_commodity";

    private static final String COMMODITY_NO_TO_ID = "commodity_no_to_id";

    public static final String COMMODITY_PREFIX_KEY = "commodity";

    public static final String COMMODITY_STOCK_KEY = "stock";

    /**
     * 查询单商品缓存
     *
     * @param commodityId
     * @param appCode
     * @return
     */
    public CommodityBo findCommodityBo(Integer commodityId, String appCode) {
        SharingJedisCluster redis = getRedis();
        String content = redis.hget(buildString(":", COMMODITY_PREFIX_KEY
                , appCode, commodityId.toString()), RedisCommodityBo.CONTENT);
        return GSON.fromJson(content, CommodityBo.class);
    }

    /**
     * 查询商品缓存信息
     *
     * @param commodityId
     * @param appCode
     * @return
     */
    public RedisCommodityBo findRedisCommodityBo(Integer commodityId, String appCode) {
        SharingJedisCluster redis = getRedis();
        Map<String, String> commodityBo = redis.hgetAll(buildString(":", COMMODITY_PREFIX_KEY
                , appCode, commodityId.toString()));
        if (MapUtils.isEmpty(commodityBo)) {
            return null;
        }
        return new RedisCommodityBo(commodityBo);
    }

    /**
     * 批量更新或插入商品数据
     *
     * @param appCode
     * @param commodityBos
     * @return
     */
    public long upsertCommodityBos(String appCode, List<CommodityBo> commodityBos) {
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = redis.pipelined();
        try {
            for (CommodityBo commodityBo : commodityBos) {
                RedisCommodityBo redisCommodityBo = new RedisCommodityBo();
                redisCommodityBo.setContent(GSON.toJson(commodityBo));
                redisCommodityBo.setPurchasesCount(commodityBo.getPurchasesCount() == null ? "0"
                        : commodityBo.getPurchasesCount().toString());
                pipeline.hmset(buildString(":", COMMODITY_PREFIX_KEY
                        , appCode, commodityBo.getCommodityId().toString()), redisCommodityBo);
            }
            List<Object> result = pipeline.syncAndReturnAll();
            return result.size();
        }finally {
            if (pipeline != null) {
                pipeline.close();
            }
        }
    }

    /**
     * 更新或插入商品数据
     *
     * @param appCode
     * @param commodityBo
     * @return
     */
    public boolean upsertCommodityBo(String appCode, CommodityBo commodityBo) {
        SharingJedisCluster redis = getRedis();
        RedisCommodityBo redisCommodityBo = new RedisCommodityBo();
        redisCommodityBo.setContent(GSON.toJson(commodityBo));
        redisCommodityBo.setPurchasesCount(commodityBo.getPurchasesCount() == null ? "0"
                : commodityBo.getPurchasesCount().toString());
        String result = redis.hmset(buildString(":", COMMODITY_PREFIX_KEY
                , appCode, commodityBo.getCommodityId().toString()), redisCommodityBo);
        return "OK".equalsIgnoreCase(result);
    }

    /**
     * 删除商品缓存数据
     *
     * @param appCode
     * @param commodityId
     * @return
     */
    public boolean removeCommodityBo(String appCode, Integer commodityId) {
        SharingJedisCluster redis = getRedis();
        redis.del(buildString(":", COMMODITY_PREFIX_KEY
                , appCode, commodityId.toString()));
        return true;
    }

    /**
     * 批量删除商品缓存
     *
     * @param appCode
     * @param commodityIds
     * @return
     */
    public long removeCommodityBos(String appCode, List<Integer> commodityIds) {
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = null;
        try {
            pipeline = redis.pipelined();
            for (Integer commodityId : commodityIds) {
                pipeline.del(buildString(":", COMMODITY_PREFIX_KEY
                        , appCode, commodityId.toString()));
            }
            List<Object> result = pipeline.syncAndReturnAll();
            return result.size();
        } finally {
            if (pipeline != null) {
                pipeline.close();
            }
        }
    }

    /**
     * 查询商品列表
     *
     * @param commodityIds
     * @param appCode
     * @return
     */
    public List<CommodityBo> findCommodityBoList(List<Integer> commodityIds, String appCode) {
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = null;
        try {
            pipeline = redis.pipelined();
            List<Response<String>> responseList = new ArrayList<>(commodityIds.size());
            for (Integer commodityId : commodityIds) {
                Response<String> response = pipeline.hget(buildString(":", COMMODITY_PREFIX_KEY
                        , appCode, commodityId.toString()), RedisCommodityBo.CONTENT);
                responseList.add(response);
            }
            pipeline.sync();
            List<CommodityBo> resultList = new ArrayList<>(commodityIds.size());
            for (Response<String> response : responseList) {
                String responseString = response.get();
                if (StringUtils.isBlank(responseString)) {
                    continue;
                }
                resultList.add(GSON.fromJson(responseString, CommodityBo.class));
            }
            return resultList;
        } finally {
            if (pipeline != null) {
                pipeline.close();
            }
        }
    }

    /**
     * 查询缓存商品列表
     *
     * @param commodityIds
     * @param appCode
     * @return
     */
    public List<RedisCommodityBo> findRedisCommodityBoList(List<Integer> commodityIds, String appCode) {
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = null;
        try {
            pipeline = redis.pipelined();
            List<Response<Map<String, String>>> responseList = new ArrayList<>(commodityIds.size());
            for (Integer commodityId : commodityIds) {
                Response<Map<String, String>> response = pipeline.hgetAll(buildString(":", COMMODITY_PREFIX_KEY
                        , appCode, commodityId.toString()));
                responseList.add(response);
            }
            pipeline.sync();
            List<RedisCommodityBo> resultList = new ArrayList<>(commodityIds.size());
            for (Response<Map<String, String>> response : responseList) {
                Map<String, String> map = response.get();
                if (null == map) {
                    continue;
                }
                RedisCommodityBo commodityBo = new RedisCommodityBo(map);

                resultList.add(commodityBo);
            }
            return resultList;
        } finally {
            if (pipeline != null) {
                pipeline.close();
            }
        }
    }

    /**
     * 扣除库存,仅供下单使用
     *
     * @param specId
     * @param appCode
     * @param num
     * @return
     */
    public boolean deductStock(Integer commodityId, Integer specId, String appCode, int num) {
        String lockKey = buildString(AssemblyRedisDao.LOCK_SPLIT_CODE, AssemblyRedisDao.COMMODITY_LOCK, specId.toString());
        String lockValue = String.valueOf(System.currentTimeMillis());
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = null;
        try {
            redis.lock(lockKey, lockValue);
            int keySerial = specId / ZIP_LIST_NUM;
            String stockKey = buildString(":", COMMODITY_STOCK_KEY, String.valueOf(keySerial));
            int stock = NumberUtils.toInt(redis.hget(stockKey, specId.toString()), 0);
            if (stock <= 0) {
                //TODO 后期如果还需要判断预留库存值
                return false;
            }
            pipeline = redis.pipelined();
            pipeline.hincrBy(stockKey, specId.toString(), -num);
            pipeline.hincrBy(buildString(":", COMMODITY_PREFIX_KEY
                    , appCode, commodityId.toString()), RedisCommodityBo.PURCHASES_COUNT, num);
            pipeline.sync();
            return true;
        }catch (Exception e){
            LOGGER.error("错误：{}",e);
            if (pipeline != null) {
                pipeline.close();
            }
            return false;
        } finally {
            if (pipeline != null) {
                pipeline.close();
            }
        }
    }

    /**
     * 更新库存
     *
     * @param specId
     * @param appCode
     * @param num
     * @return
     */
    public boolean upsertStock(Integer specId, String appCode, int num) {
        String lockKey = buildString(AssemblyRedisDao.LOCK_SPLIT_CODE, AssemblyRedisDao.COMMODITY_LOCK, specId.toString());
        String lockValue = String.valueOf(System.currentTimeMillis());
        SharingJedisCluster redis = getRedis();
        try {
            redis.lock(lockKey, lockValue);
            int keySerial = specId / ZIP_LIST_NUM;
            String stockKey = buildString(":", COMMODITY_STOCK_KEY, String.valueOf(keySerial));
            redis.hset(stockKey, specId.toString(), String.valueOf(num));
            return true;
        } finally {
            redis.unlock(lockKey, lockValue);
        }
    }

    /**
     * 增加库存,仅供下单使用
     *
     * @param specId
     * @param appCode
     * @param num
     * @return
     */
    public boolean increaseStock(Integer specId, String appCode, int num) {
        String lockKey = buildString(AssemblyRedisDao.LOCK_SPLIT_CODE, AssemblyRedisDao.COMMODITY_LOCK, specId.toString());
        String lockValue = String.valueOf(System.currentTimeMillis());
        SharingJedisCluster redis = getRedis();
        try {
            redis.lock(lockKey, lockValue);
            int keySerial = specId / ZIP_LIST_NUM;
            String stockKey = buildString(":", COMMODITY_STOCK_KEY, String.valueOf(keySerial));
            redis.hincrBy(stockKey, specId.toString(), num);

            return true;
        } finally {
            redis.unlock(lockKey, lockValue);
        }
    }

    /**
     * 查询库存
     *
     * @param specId
     * @param appCode
     * @return
     */
    public int findStock(Integer specId, String appCode) {
        SharingJedisCluster redis = getRedis();
        int keySerial = specId / ZIP_LIST_NUM;
        String stockKey = buildString(":", COMMODITY_STOCK_KEY, String.valueOf(keySerial));
        String numString = redis.hget(stockKey, specId.toString());
        return NumberUtils.toInt(numString);
    }

    /**
     * 批量查询库存
     *
     * @param specIds
     * @param appCode
     * @return
     */
    public Map<Integer, Integer> findStocks(List<Integer> specIds, String appCode) {
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = null;
        try {
            pipeline = redis.pipelined();
            Map<Integer, Response<String>> responseMap = new HashMap<>(specIds.size());
            for (Integer specId : specIds) {
                int keySerial = specId / ZIP_LIST_NUM;
                String stockKey = buildString(":", COMMODITY_STOCK_KEY, String.valueOf(keySerial));
                Response<String> numResponse = pipeline.hget(stockKey, specId.toString());
                responseMap.put(specId, numResponse);
            }
            pipeline.sync();
            Map<Integer, Integer> resultMap = new HashMap<>(specIds.size());
            for (Map.Entry<Integer, Response<String>> entry : responseMap.entrySet()) {
                resultMap.put(entry.getKey(), NumberUtils.toInt(entry.getValue().get()));
            }

            return resultMap;
        } finally {
            if (pipeline != null) {
                pipeline.close();
            }
        }
    }

    /**
     * 创建或更新仓库编码
     *
     * @param commodityBo
     * @return
     */
    public boolean upsertPlatformCommodity(CommodityBo commodityBo) {
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = null;
        try {
            pipeline = redis.pipelined();
            pipeline.hset(COMMODITY_PLATFORM_PREFIX_KEY, commodityBo.getCommodityId().toString(), GSON.toJson(commodityBo));
            pipeline.hset(COMMODITY_NO_TO_ID, commodityBo.getCommodityId().toString(), commodityBo.getCommodityNo());
            List<Object> objects = pipeline.syncAndReturnAll();
            if (CollectionUtils.isEmpty(objects)) {
                return false;
            }
            return true;
        }catch (Exception e){
            LOGGER.error("错误：{}",e);
            if (pipeline != null) {
                pipeline.close();
            }
            return false;
        }
    }

    /**
     * 删除仓库编码
     *
     * @param commodityId
     * @return
     */
    public boolean removePlatformCommodity(Integer commodityId) {
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = null;
        try {
            pipeline = redis.pipelined();
            pipeline.hdel(COMMODITY_PLATFORM_PREFIX_KEY, commodityId.toString());
            pipeline.hdel(COMMODITY_NO_TO_ID, commodityId.toString());
            List<Object> objects = pipeline.syncAndReturnAll();
            if (CollectionUtils.isEmpty(objects)) {
                return false;
            }
            return true;
        } finally {
            if (pipeline != null) {
                pipeline.close();
            }
        }
    }

    /**
     * 获取所有平台商品缓存，ID map
     *
     * @return
     */
    public Map<Integer, CommodityBo> findPlatformCommodityMap() {
        SharingJedisCluster redis = getRedis();
        Map<String, String> response = redis.hgetAll(COMMODITY_PLATFORM_PREFIX_KEY);
        if (MapUtils.isEmpty(response)) {
            return null;
        }
        Map<Integer, CommodityBo> result = new HashMap<>(response.size());
        for (Map.Entry<String, String> entry : response.entrySet()) {
            result.put(NumberUtils.toInt(entry.getKey()), GSON.fromJson(entry.getValue(), CommodityBo.class));
        }
        return result;
    }

    /**
     * 获取所有平台商品缓存，编码map
     *
     * @return
     */
    public Map<String, CommodityBo> findPlatformWithCommodityNoMap() {
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = null;
        try {
            pipeline = redis.pipelined();
            Response<Map<String, String>> commodityResponse = pipeline.hgetAll(COMMODITY_PLATFORM_PREFIX_KEY);
            Response<Map<String, String>> idToNoResponse = pipeline.hgetAll(COMMODITY_NO_TO_ID);
            pipeline.sync();
            Map<String, CommodityBo> result = new HashMap<>(16);
            Map<String, String> idToNoMap = idToNoResponse.get();
            for (Map.Entry<String, String> entry : commodityResponse.get().entrySet()) {
                result.put(idToNoMap.get(entry.getKey()), GSON.fromJson(entry.getValue(), CommodityBo.class));
            }
            return result;
        } finally {
            if (pipeline != null) {
                pipeline.close();
            }
        }
    }

    /**
     * 查询指定平台商品信息
     *
     * @param commodityId
     * @return
     */
    public String findPlatformCommodity(Integer commodityId) {
        SharingJedisCluster redis = getRedis();
        return redis.hget(COMMODITY_PLATFORM_PREFIX_KEY, commodityId.toString());
    }
}