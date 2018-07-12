package com.common.model.dao.redis;

import com.common.model.bo.buygift.*;
import com.common.model.bo.commodity.CommodityBo;
import com.common.model.bo.coupon.RedisActivityCouponBo;
import com.common.model.bo.redis.JedisClusterPipeline;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.SharingJedisCluster;

import java.util.*;

/**
 * @Package: com.common.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/7/11 上午10:05
 */
public class BuyGiftRedisDao extends BaseActivityRedisDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BuyGiftRedisDao.class);

    /**
     * 上线买赠活动
     *
     * @param activityBo
     * @param buySpecificationIds
     * @param giftSpecificationBos
     * @return
     */
    public boolean insertBuyGiftActivityBo(RedisBuyGiftActivityBo activityBo
            ,List<Integer> buySpecificationIds, List<RedisBuyGiftSpecificationBo> giftSpecificationBos ){
        if (CollectionUtils.isEmpty(giftSpecificationBos) || CollectionUtils.isEmpty(buySpecificationIds)){
            return false;
        }

        List<String> specificationStringList = new ArrayList<>();
        for (Integer buySpecificationId : buySpecificationIds){
            specificationStringList.add(String.valueOf(buySpecificationId));
        }

        SharingJedisCluster redis = getRedis();

        JedisClusterPipeline pipeline = null;

        try{
            pipeline = redis.pipelined();
            pipeline.hmset(buildString(":",BUY_GIFT_ACTIVITY_PREFIX
                    ,activityBo.getAppCode() , String.valueOf(activityBo.getID())),activityBo);
            pipeline.sadd(buildString(":",ACTIVITY_SPECIFICATION_PREFIX
                    ,activityBo.getAppCode(), String.valueOf(activityBo
                            .getID())),specificationStringList.toArray(new String[0]));
            for (RedisBuyGiftSpecificationBo specificationBo : giftSpecificationBos) {
                pipeline.hmset(buildString(":",BUY_GIFT_ACTIVITY_GIFT_PREFIX
                        ,activityBo.getAppCode(),String.valueOf(activityBo
                                .getID()), String.valueOf(specificationBo
                                .getSpecificationId())),specificationBo);
            }

            for (String specificationId : specificationStringList){
                pipeline.sadd(buildString(":",SPECIFICATION_ACTIVITY_PREFIX,activityBo
                                .getAppCode(),specificationId),buildString(":",BUY_GIFT_ACTIVITY_PREFIX
                                ,String.valueOf(activityBo.getID()).toString()));
            }
            pipeline.sadd(buildString(":",ONLINE_BUY_GIFT_ACTIVITY,activityBo.getAppCode())
                    ,buildString(":",BUY_GIFT_ACTIVITY_PREFIX, String.valueOf(activityBo.getID())));
            pipeline.sync();
        }finally {
            if (pipeline != null){
                pipeline.close();
            }
        }
        return true;
    }

    /**
     * 移除买赠活动
     *
     * @param activityId
     * @return
     */
    public boolean removeBuyGiftActivityBo(String appCode,int activityId){
        SharingJedisCluster redis = getRedis();
        String redisActivityId = buildString(":",BUY_GIFT_ACTIVITY_PREFIX
               , appCode, String.valueOf(activityId));
         Map<String,String> responseMap = redis.hgetAll(redisActivityId);
         if (MapUtils.isEmpty(responseMap)){
             return true;
         }
         RedisBuyGiftActivityBo buyGiftActivityBo = new RedisBuyGiftActivityBo(responseMap);
         List<Integer> giftIds = buyGiftActivityBo.getGiftIds();
         if (CollectionUtils.isEmpty(giftIds)){
             redis.del(redisActivityId);
             return true;
         }
        JedisClusterPipeline pipeline = null;
        try {
            pipeline = redis.pipelined();
            pipeline.del(redisActivityId);
            pipeline.del(buildString(":",ACTIVITY_SPECIFICATION_PREFIX
                   ,appCode , String.valueOf(activityId)));

            for (Integer specificationId : giftIds){
                pipeline.del(buildString(":",BUY_GIFT_ACTIVITY_GIFT_PREFIX
                        , appCode ,String.valueOf(activityId) ,String.valueOf(specificationId)));
                pipeline.srem(buildString(":",SPECIFICATION_ACTIVITY_PREFIX,appCode
                        ,specificationId.toString()),redisActivityId);
            }
            pipeline.sync();
        }finally {
            if (pipeline != null){
                pipeline.close();
            }
        }
        return true;
    }

    /**
     * 更新买赠活动基本信息
     *
     * @param activityBo
     * @return
     */
    public boolean updateBuyGiftActivityInfo(RedisBuyGiftActivityBo activityBo){
        SharingJedisCluster redis = getRedis();
        redis.hmset(buildString(":",BUY_GIFT_ACTIVITY_PREFIX
                , activityBo.getAppCode(), String.valueOf(activityBo.getID())),activityBo);
        return true;
    }

    /**
     * 新增或更新买赠活动
     *
     * @param activityBo
     * @param buySpecificationIds
     * @param giftSpecificationBos
     * @return
     */
    public boolean upsertBuyGiftActivityBo(RedisBuyGiftActivityBo activityBo
            ,List<Integer> buySpecificationIds, List<RedisBuyGiftSpecificationBo> giftSpecificationBos){
        removeBuyGiftActivityBo(activityBo.getAppCode(),activityBo.getID());
        return insertBuyGiftActivityBo(activityBo, buySpecificationIds, giftSpecificationBos);
    }

    /**
     * 下线买赠活动
     *
     * @param appCode
     * @param activityId
     * @return
     */
    public boolean offlineBuyGiftActivityBo(String appCode,Integer activityId){
        return offlineActivityBo(appCode,activityId,BUY_GIFT_ACTIVITY_PREFIX,ONLINE_BUY_GIFT_ACTIVITY);
    }

    public BuyGiftActivityDetailBo findBuyGiftActivityDetailBo(String appCode,Integer activityId){
        SharingJedisCluster redis = getRedis();
        List<String> activityList = redis.hmget(buildString(":",BUY_GIFT_ACTIVITY_PREFIX
                ,appCode,activityId.toString()), RedisBuyGiftActivityBo.CONTENT,RedisBuyGiftActivityBo.GIFT_IDS);
        if (CollectionUtils.isEmpty(activityList)){
            return null;
        }
        BuyGiftActivityDetailBo buyGiftActivityDetailBo = GSON.fromJson(activityList
                .get(0),BuyGiftActivityDetailBo.class);

        List<Integer> giftIds = GSON.fromJson(activityList.get(1),RedisBuyGiftActivityBo.INTEGER_LIST_TYPE);

        if (CollectionUtils.isEmpty(giftIds)){
            return buyGiftActivityDetailBo;
        }

        JedisClusterPipeline pipeline = null;
        List<Object> giftResult = null;
        try{
            pipeline = redis.pipelined();
            for (Integer giftId : giftIds){
                pipeline.hgetAll(buildString(":",BUY_GIFT_ACTIVITY_GIFT_PREFIX
                        , appCode ,String.valueOf(activityId) ,String
                                .valueOf(giftId)));
            }
            giftResult = pipeline.syncAndReturnAll();
        }finally {
            if (pipeline != null){
                pipeline.close();
            }
        }
        if (CollectionUtils.isEmpty(giftResult)){
            return buyGiftActivityDetailBo;
        }

        List<GiftCommodityBo> giftList = new ArrayList<>(giftResult.size());

        for (Object obj : giftResult){
            if (null == obj){
                continue;
            }
            RedisBuyGiftSpecificationBo buyGiftSpecificationBo = new RedisBuyGiftSpecificationBo((Map<String, String>) obj);
            GiftCommodityBo giftCommodityBo = buyGiftSpecificationBo.getCONTENT();
            giftCommodityBo.setGiftNum(buyGiftSpecificationBo.getGiftNum());
            giftCommodityBo.setInventory(buyGiftSpecificationBo.getInventory());
            giftList.add(giftCommodityBo);
        }
        buyGiftActivityDetailBo.setGifts(giftList);
        return buyGiftActivityDetailBo;
    }

    BuyGiftActivityContentBo findBuyGiftActivityContent(String appCode,Integer activityId){
        return findActivityBo(appCode,activityId,BUY_GIFT_ACTIVITY_PREFIX,BuyGiftActivityContentBo.class);
    }

    public boolean decGiftSales(String appCode ,int activityId,int num){
        //TODO 扣减库存
        return true;
    }
}
