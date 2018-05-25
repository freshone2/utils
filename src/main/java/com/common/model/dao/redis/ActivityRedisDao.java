package com.common.model.dao.redis;


import com.common.model.bo.commodity.CommodityBo;
import com.common.model.bo.coupon.ActivityCouponContentBo;
import com.common.model.bo.coupon.RedisActivityCouponBo;
import com.common.model.bo.order.HashMapList;
import com.common.model.bo.platform.PlatformContentBo;
import com.common.model.bo.platform.RedisPlatformBo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.*;

/**
 * @Package: pecker.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/5/14 下午2:51
 */
public class ActivityRedisDao extends BaseRedisDao {

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
        Jedis redis = getRedis(ACTIVITY_DB);
        try{
            Map<String,String> redisActivityCouponBo = redis.hgetAll(buildString(":",COUPON_PREFIX,appCode,activityId.toString()));
            if (MapUtils.isEmpty(redisActivityCouponBo)){
                return null;
            }
            return new RedisActivityCouponBo(redisActivityCouponBo);
        }finally {
            if (redis != null ){
                redis.close();
            }
        }
    }

    /**
     * 获取redis平台活动对象
     *
     * @param appCode
     * @param activityId
     * @return
     */
    public  RedisPlatformBo findRedisPlatformBo(String appCode, Integer activityId){
        Jedis redis = getRedis(ACTIVITY_DB);
        try{
            Map<String,String> redisPlatformBo = redis.hgetAll(buildString(":",PLATFORM_PREFIX
                    ,appCode,activityId.toString()));
            if (MapUtils.isEmpty(redisPlatformBo)){
                return null;
            }
            return new RedisPlatformBo(redisPlatformBo);
        }finally {
            if (redis != null ){
                redis.close();
            }
        }
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
        Jedis redis = getRedis(ACTIVITY_DB);
        try{
            Transaction transaction = redis.multi();
            transaction.hget(buildString(":",COUPON_PREFIX,appCode,activityId.toString()),RedisActivityCouponBo.CONTENT);
            transaction.smembers(buildString(":",ACTIVITY_SPECIFICATION_PREFIX,appCode,activityId.toString()));
            List<Object> response = transaction.exec();
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
        }finally {
            if (redis != null ){
                redis.close();
            }
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
        Jedis redis = getRedis(ACTIVITY_DB);
        try{
            Transaction transaction = redis.multi();
            transaction.hget(buildString(":",PLATFORM_PREFIX,appCode,activityId.toString()),RedisPlatformBo.CONTENT);
            transaction.smembers(buildString(":",ACTIVITY_SPECIFICATION_PREFIX,appCode,activityId.toString()));
            List<Object> response = transaction.exec();
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
        }finally {
            if (redis != null ){
                redis.close();
            }
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
        Jedis redis = getRedis(ACTIVITY_DB);
        try{
            Transaction transaction = redis.multi();
            for (Integer specId : specIds) {
                transaction.sismember(buildString(":", ACTIVITY_SPECIFICATION_PREFIX
                        , appCode, activityId.toString()),specId.toString());
            }
            List<Object> response = transaction.exec();
            if (CollectionUtils.isEmpty(response)){
                return null;
            }
            Map<Integer,Boolean> result = new HashMap<>(response.size());
            for (int i = 0 ; i < specIds.length;i++ ) {
                result.put( specIds[i] , (Boolean) response.get(i) );
            }
            return result;
        }finally {
            if (redis != null ){
                redis.close();
            }
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
        Jedis redis = getRedis(ACTIVITY_DB);
        try{
            Map<Integer,Map<Integer,Response<Boolean>>> responseMap = new HashMap<>(activityMap.size());

            Transaction transaction = redis.multi();
            for (Map.Entry<Integer , List<Integer> > entry : activityMap.entrySet() ){
                Map<Integer,Response<Boolean>> item = new HashMap<>(entry.getValue().size());
                responseMap.put(entry.getKey(),item);
                for (Integer specId : entry.getValue()) {
                    Response<Boolean> response = transaction.sismember(buildString(":", ACTIVITY_SPECIFICATION_PREFIX
                            , appCode, entry.getKey().toString()), specId.toString());
                    item.put(specId,response);
                }
            }
            transaction.exec();

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
        }finally {
            if (redis != null ){
                redis.close();
            }
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
        Jedis redis = getRedis(ACTIVITY_DB);
        try{
            Transaction transaction = redis.multi();
            for (String field : fields) {
                transaction.hincrBy(buildString(":", COUPON_PREFIX, appCode, activityId.toString()),field, num);
            }
            List<Object> result = transaction.exec();
            if (CollectionUtils.isEmpty(result)){
                return false;
            }
            return true;
        }finally {
            if (redis != null ){
                redis.close();
            }
        }
    }

    private boolean upsertActivityBo(String appCode, Integer activityId,String activityPrefix
            ,String onlinePrefix, Map<String,String> activityBo , List<String> specIds){
        Jedis redis = getRedis(ACTIVITY_DB);
        try{
            if (CollectionUtils.isEmpty(specIds)){
                return false;
            }
            Transaction transaction = redis.multi();
            transaction.hmset(buildString(":",activityPrefix,appCode,activityId.toString()),activityBo);
            transaction.del(buildString(":",ACTIVITY_SPECIFICATION_PREFIX,appCode,activityId.toString()));
            transaction.sadd(buildString(":",ACTIVITY_SPECIFICATION_PREFIX,appCode,activityId.toString()),specIds.toArray(new String[specIds.size()]));
            for (String specId : specIds){
                transaction.sadd(buildString(":",SPECIFICATION_ACTIVITY_PREFIX,appCode,specId.toString())
                        ,buildString(":",activityPrefix,appCode,activityId.toString()));
            }
            transaction.sadd(buildString(":",onlinePrefix,appCode)
                    ,buildString(":",activityPrefix,appCode,activityId.toString()));
            List<Object> response = transaction.exec();
            if (CollectionUtils.isEmpty(response)){
                return false;
            }
            return true;
        }finally {
            if (redis != null ){
                redis.close();
            }
        }
    }

    private boolean offlineActivityBo(String appCode,Integer activityId
            ,String activityPrefix
            ,String onlinePrefix ){
        Jedis redis = getRedis(ACTIVITY_DB);
        try{
            String activityKey = buildString(":",ACTIVITY_SPECIFICATION_PREFIX,appCode,activityId.toString());
            Set<String> specSet = redis.smembers(activityKey);
            Transaction transaction = redis.multi();
            transaction.srem(buildString(":",onlinePrefix,appCode)
                    ,buildString(":",activityPrefix,appCode,activityId.toString()));
            for (String specString : specSet){
                transaction.srem(buildString(":",SPECIFICATION_ACTIVITY_PREFIX,appCode,specString)
                        ,activityKey);
            }
            List<Object> result = transaction.exec();
            if (CollectionUtils.isEmpty(result)){
                return false;
            }
            return true;
        }finally {
            if (redis != null ){
                redis.close();
            }
        }
    }

    private  <T> T findActivityBo(String appCode, Integer activityId
            ,String activityPrefix ,Class<T> tClass){
        Jedis redis = getRedis(ACTIVITY_DB);
        try{
            String content = redis.hget(buildString(":",activityPrefix,appCode,activityId.toString()),RedisActivityCouponBo.CONTENT);
            if (StringUtils.isEmpty(content)){
                return null;
            }
            return GSON.fromJson(content,tClass);
        }finally {
            if (redis != null ){
                redis.close();
            }
        }
    }


}
