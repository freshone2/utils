package com.common.model.dao.redis;


import com.common.model.bo.commodity.CommodityBo;
import com.common.model.bo.coupon.ActivityCouponContentBo;
import com.common.model.bo.coupon.RedisActivityCouponBo;
import com.common.model.bo.order.HashMapList;
import com.common.model.bo.platform.PlatformContentBo;
import com.common.model.bo.platform.RedisPlatformBo;
import com.common.model.bo.redis.JedisClusterPipeline;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.SharingJedisCluster;
import redis.clients.jedis.Transaction;

import java.util.*;

/**
 * @Package: pecker.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/5/14 下午2:51
 */
public class ActivityRedisDao extends BaseActivityRedisDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityRedisDao.class);



    /**
     * 更新或新增优惠券
     *
     * @param appCode
     * @param activityId
     * @param couponBo
     * @param specIds
     * @return
     */
    public boolean upsertCouponBo(String appCode,Integer activityId,RedisActivityCouponBo couponBo , List<String> specIds){
        return upsertActivityBo(appCode,activityId,COUPON_PREFIX,ONLINE_COUPON_ACTIVITY,couponBo,specIds);
    }

    /**
     * 更新或新增平台活动
     *
     * @param appCode
     * @param activityId
     * @param redisPlatformBo
     * @param specIds
     * @return
     */
    public boolean upsertPlatformBo(String appCode, Integer activityId, RedisPlatformBo redisPlatformBo , List<String> specIds){
        return upsertActivityBo(appCode,activityId,PLATFORM_PREFIX,ONLINE_PLATFORM_ACTIVITY,redisPlatformBo,specIds);
    }

    /**
     * 下线优惠券活动
     *
     * @param appCode
     * @param activityId
     * @return
     */
    public boolean offlineCouponBo(String appCode,Integer activityId){
        return offlineActivityBo(appCode,activityId,COUPON_PREFIX,ONLINE_COUPON_ACTIVITY);
    }

    /**
     * 下线优惠券活动
     *
     * @param appCode
     * @param activityId
     * @return
     */
    public boolean offlinePlatformBo(String appCode,Integer activityId){
        return offlineActivityBo(appCode,activityId,PLATFORM_PREFIX,ONLINE_PLATFORM_ACTIVITY);
    }

    /**
     * 获取优惠券活动content
     *
     * @param appCode
     * @param activityId
     * @return
     */
    public ActivityCouponContentBo findCouponBo(String appCode, Integer activityId){
        return findActivityBo(appCode,activityId,COUPON_PREFIX,ActivityCouponContentBo.class);
    }

    /**
     * 获取平台活动content
     *
     * @param appCode
     * @param activityId
     * @return
     */
    public PlatformContentBo findPlatformBo(String appCode, Integer activityId){
        return findActivityBo(appCode,activityId,PLATFORM_PREFIX,PlatformContentBo.class);
    }

    /**
     * 获取redis优惠券对象
     *
     * @param appCode
     * @param activityId
     * @return
     */
    public  RedisActivityCouponBo findRedisCouponBo(String appCode, Integer activityId){
        SharingJedisCluster redis = getRedis();
        Map<String,String> redisActivityCouponBo = redis.hgetAll(buildString(":",COUPON_PREFIX,appCode,activityId.toString()));
        if (MapUtils.isEmpty(redisActivityCouponBo)){
            return null;
        }
        return new RedisActivityCouponBo(redisActivityCouponBo);
    }

    /**
     * 获取redis平台活动对象
     *
     * @param appCode
     * @param activityId
     * @return
     */
    public  RedisPlatformBo findRedisPlatformBo(String appCode, Integer activityId){
        SharingJedisCluster redis = getRedis();
        Map<String,String> redisPlatformBo = redis.hgetAll(buildString(":",PLATFORM_PREFIX
                ,appCode,activityId.toString()));
        if (MapUtils.isEmpty(redisPlatformBo)){
            return null;
        }
        return new RedisPlatformBo(redisPlatformBo);
    }

    /**
     * 获取优惠券对象和关联规格
     * 0 优惠券对象
     * 1 关联ID 的set
     *
     * @param appCode
     * @param activityId
     * @return
     */
    public List<Object> findCouponBoAndSpecId(String appCode, Integer activityId){
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = redis.pipelined();
        try{
            pipeline.hget(buildString(":",COUPON_PREFIX,appCode,activityId.toString()),RedisActivityCouponBo.CONTENT);
            pipeline.smembers(buildString(":",ACTIVITY_SPECIFICATION_PREFIX,appCode,activityId.toString()));
            List<Object> response = pipeline.syncAndReturnAll();
            if (CollectionUtils.isEmpty(response)){
                return null;
            }
            List<Object> result = new ArrayList<>(2);
            String content = (String) response.get(0);
            if (StringUtils.isBlank(content)){
                result.add(null);
            }else {
                result.add(GSON.fromJson(content,ActivityCouponContentBo.class));
            }
            result.add(response.get(1));
            return result;
        }catch (Exception e){
            LOGGER.error("错误：{}",e);
            if (pipeline != null) {
                pipeline.close();
            }
            return null;
        }
    }

    /**
     * 获取平台对象和关联规格
     * 0 优惠券对象
     * 1 关联ID 的set
     *
     * @param appCode
     * @param activityId
     * @return
     */
    public List<Object> findPlatformBoAndSpecId(String appCode, Integer activityId){
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = redis.pipelined();
        try{
            pipeline.hget(buildString(":",PLATFORM_PREFIX,appCode,activityId.toString()),RedisPlatformBo.CONTENT);
            pipeline.smembers(buildString(":",ACTIVITY_SPECIFICATION_PREFIX,appCode,activityId.toString()));
            List<Object> response = pipeline.syncAndReturnAll();
            if (CollectionUtils.isEmpty(response)){
                return null;
            }
            List<Object> result = new ArrayList<>(2);
            String content = (String) response.get(0);
            if (StringUtils.isBlank(content)){
                result.add(null);
            }else {
                result.add(GSON.fromJson(content,PlatformContentBo.class));
            }
            result.add(response.get(1));
            return result;
        }catch (Exception e){
            LOGGER.error("错误：{}",e);
            if (pipeline != null) {
                pipeline.close();
            }
            return null;
        }
    }

    /**
     * 查询规格参加的活动
     *
     * @param appCode 渠道code
     * @param specIds 规格ids
     * @return
     */
    public Map<Integer,Set<String>> findSpecJoinActivities(String appCode,List<Integer> specIds) {
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = null;
        try {
            Map<Integer,Response<Set<String>>> responseMap = new HashMap<>(specIds.size());
            pipeline = redis.pipelined();
            for (Integer specId : specIds) {
                Response<Set<String>> response = pipeline.smembers(buildString(":",SPECIFICATION_ACTIVITY_PREFIX,appCode,specId.toString()));
                responseMap.put(specId,response);
            }
            pipeline.sync();
            Map<Integer,Set<String>> result = new HashMap<>(specIds.size());
            for (Map.Entry<Integer,Response<Set<String>>> entry : responseMap.entrySet()) {
                result.put(entry.getKey(),entry.getValue().get());
            }
            return result;
        }catch (Exception e){
            LOGGER.error("redis报错：{}",e);
            if (pipeline != null) {
                pipeline.close();
            }
            return null;
        }
    }

    /**
     * 递增红包活动值
     *
     * @param appCode
     * @param activityId
     * @param num
     * @param fields
     * @return
     */
    public boolean incrementCouponFields(String appCode , Integer activityId ,int num,String... fields ){
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = redis.pipelined();
        try{
            for (String field : fields) {
                pipeline.hincrBy(buildString(":", COUPON_PREFIX, appCode, activityId.toString()),field, num);
            }
            List<Object> result = pipeline.syncAndReturnAll();
            if (CollectionUtils.isEmpty(result)){
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

    private boolean upsertActivityBo(String appCode, Integer activityId,String activityPrefix
            ,String onlinePrefix, Map<String,String> activityBo , List<String> specIds){
        if (CollectionUtils.isEmpty(specIds)){
            return false;
        }

        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = redis.pipelined();
        try{
            pipeline.hmset(buildString(":",activityPrefix,appCode,activityId.toString()),activityBo);
            pipeline.del(buildString(":",ACTIVITY_SPECIFICATION_PREFIX,appCode,activityId.toString()));
            pipeline.sadd(buildString(":",ACTIVITY_SPECIFICATION_PREFIX,appCode,activityId.toString()),specIds.toArray(new String[specIds.size()]));
            for (String specId : specIds){
                pipeline.sadd(buildString(":",SPECIFICATION_ACTIVITY_PREFIX,appCode,specId.toString())
                        ,buildString(":",activityPrefix,appCode,activityId.toString()));
            }
            pipeline.sadd(buildString(":",onlinePrefix,appCode)
                    ,buildString(":",activityPrefix,appCode,activityId.toString()));
            List<Object> response = pipeline.syncAndReturnAll();
            if (CollectionUtils.isEmpty(response)){
                return false;
            }
            return true;
        }finally {
            if (pipeline != null) {
                pipeline.close();
            }
            return false;
        }
    }
}
