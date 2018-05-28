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
public class ActivityRedisDao extends BaseRedisDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityRedisDao.class);

    public static final int ACTIVITY_DB = 5;

    /**
     * 优惠券key:this+appCode+ID
     */
    public static final String COUPON_PREFIX = "a:c";

    /**
     * 活动关联的商品Key:this+appCode+userID
     */
    public static final String ACTIVITY_SPECIFICATION_PREFIX = "a:s";

    /**
     * 上线的优惠券活动key:this+appCode
     */
    public static final String ONLINE_COUPON_ACTIVITY = "ooca";

    /**
     * 平台活动key:this+appCode+ID
     */
    public static final String PLATFORM_PREFIX = "a:p";

    /**
     * 上线的平台活动key:this+appCode
     */
    public static final String ONLINE_PLATFORM_ACTIVITY = "oopa";

    /**
     * 规格反向关联活动key:this+appCode+规格ID
     */
    public static final String SPECIFICATION_ACTIVITY_PREFIX = "s:a";

    /**
     * 用户优惠券列表key:this+appCode+userId
     */
    public static final String USER_COUPON = "u:c";

    public static final String USER_COUPON_SPLIT_CODE = "-";

    public static final String USER_COUPON_USED_SUFFIX = "used";

    public static final String USER_COUPON_OVERTIME_SUFFIX = "overtime";

    /**
     * 券ID自增
     */
    public static final String COUPON_ID_PREFIX = "c:i";

    /**
     * 用户券领取次数：this+券类型ID+userId
     */
    public static final String COUPON_USER_GIVE = "c:g";

    /**
     * 用户参与平台活动次数：this+平台活动ID+userId
     */
    public static final String PLATFORM_USER_USED = "p:g";

    public static final String USER_COUPON_GIVE_TOTAL = "total";

    public static final String USER_PLATFORM_TOTAL = "total";

    /**
     * 限时折扣：this+appCode+商品ID
     */
    public static final String SPECIAL_ACTIVITY_PREFIX = "a:sp";

    /**
     * 用户参与限时折扣次数：this+appCode+商品ID
     */
    public static final String USER_SPECIAL_COMMODITY_PREFIX = "u:sp";

    public static final String USER_SPECIAL_COMMODITY_SPLIT_CODE = "-";

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
     * 判断商品是否存在于某活动
     *
     * @param appCode
     * @param activityId
     * @param specIds
     * @return
     */
    public Map<Integer,Boolean> existSpecIds(String appCode, Integer activityId, Integer... specIds){
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = redis.pipelined();
        try{
            for (Integer specId : specIds) {
                pipeline.sismember(buildString(":", ACTIVITY_SPECIFICATION_PREFIX
                        , appCode, activityId.toString()),specId.toString());
            }
            List<Object> response = pipeline.syncAndReturnAll();
            if (CollectionUtils.isEmpty(response)){
                return null;
            }
            Map<Integer,Boolean> result = new HashMap<>(response.size());
            for (int i = 0 ; i < specIds.length;i++ ) {
                result.put( specIds[i] , (Boolean) response.get(i) );
            }
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
     * 判断多个活动对象存在的规格值
     *
     * @param appCode
     * @param activityMap
     * @return
     */
    public Map< Integer , Map<Integer,Boolean> > existActivitySpecIds(String appCode, Map<Integer,List<Integer>> activityMap){
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = redis.pipelined();
        try{
            Map<Integer,Map<Integer,Response<Boolean>>> responseMap = new HashMap<>(activityMap.size());
            for (Map.Entry<Integer , List<Integer> > entry : activityMap.entrySet() ){
                Map<Integer,Response<Boolean>> item = new HashMap<>(entry.getValue().size());
                responseMap.put(entry.getKey(),item);
                for (Integer specId : entry.getValue()) {
                    Response<Boolean> response = pipeline.sismember(buildString(":", ACTIVITY_SPECIFICATION_PREFIX
                            , appCode, entry.getKey().toString()), specId.toString());
                    item.put(specId,response);
                }
            }
            pipeline.sync();

            Map<Integer,Map<Integer,Boolean>> result = new HashMap<>(responseMap.size());
            for (Map.Entry<Integer , Map<Integer,Response<Boolean>> > entry
                    : responseMap.entrySet()) {
                Map<Integer,Boolean> item = new HashMap<>(entry.getValue().size());
                result.put(entry.getKey(),item);
                for (Map.Entry<Integer,Response<Boolean>> responseEntry : entry.getValue().entrySet()) {
                    if (responseEntry.getValue() == null){
                        item.put(responseEntry.getKey(),null);
                    }else {
                        item.put(responseEntry.getKey(),responseEntry.getValue().get());
                    }

                }
            }

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
        }catch (Exception e){
            LOGGER.error("错误：{}",e);
            if (pipeline != null) {
                pipeline.close();
            }
            return false;
        }
    }

    private boolean offlineActivityBo(String appCode,Integer activityId
            ,String activityPrefix
            ,String onlinePrefix ){
        SharingJedisCluster redis = getRedis();
        String activityKey = buildString(":",ACTIVITY_SPECIFICATION_PREFIX,appCode,activityId.toString());
        Set<String> specSet = redis.smembers(activityKey);
        JedisClusterPipeline pipeline = redis.pipelined();
        try{
            pipeline.srem(buildString(":",onlinePrefix,appCode)
                    ,buildString(":",activityPrefix,appCode,activityId.toString()));
            for (String specString : specSet){
                pipeline.srem(buildString(":",SPECIFICATION_ACTIVITY_PREFIX,appCode,specString)
                        ,activityKey);
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

    private  <T> T findActivityBo(String appCode, Integer activityId
            ,String activityPrefix ,Class<T> tClass){
        SharingJedisCluster redis = getRedis();
        String content = redis.hget(buildString(":",activityPrefix,appCode,activityId.toString()),RedisActivityCouponBo.CONTENT);
        if (StringUtils.isEmpty(content)){
            return null;
        }
        return GSON.fromJson(content,tClass);
    }


}
