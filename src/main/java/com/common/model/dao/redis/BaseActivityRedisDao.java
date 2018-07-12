package com.common.model.dao.redis;

import com.common.model.bo.coupon.RedisActivityCouponBo;
import com.common.model.bo.redis.JedisClusterPipeline;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Response;
import redis.clients.jedis.SharingJedisCluster;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Package: com.common.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/7/12 上午10:59
 */
public abstract class BaseActivityRedisDao extends BaseRedisDao implements ActivityPrefix {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseActivityRedisDao.class);

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

    protected  <T> T findActivityBo(String appCode, Integer activityId
            ,String activityPrefix ,Class<T> tClass){
        SharingJedisCluster redis = getRedis();
        String content = redis.hget(buildString(":",activityPrefix,appCode,activityId.toString()), RedisActivityCouponBo.CONTENT);
        if (StringUtils.isEmpty(content)){
            return null;
        }
        return GSON.fromJson(content,tClass);
    }

    protected boolean offlineActivityBo(String appCode,Integer activityId
            ,String activityPrefix
            ,String onlinePrefix ){
        SharingJedisCluster redis = getRedis();
        String activitySpecificationKey = buildString(":",ACTIVITY_SPECIFICATION_PREFIX,appCode,activityId.toString());
        String activityKey = buildString(":",activityPrefix,appCode,activityId.toString());
        Set<String> specSet = redis.smembers(activitySpecificationKey);
        JedisClusterPipeline pipeline = redis.pipelined();
        try{
            pipeline.srem(buildString(":",onlinePrefix,appCode)
                    ,activityKey);
            for (String specString : specSet){
                pipeline.srem(buildString(":",SPECIFICATION_ACTIVITY_PREFIX,appCode,specString)
                        ,activityKey);
            }
            List<Object> result = pipeline.syncAndReturnAll();
            if (CollectionUtils.isEmpty(result)){
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
