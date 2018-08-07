package com.common.model.dao.redis;

import com.common.model.bo.buygift.RedisBuyGiftSpecificationBo;
import com.common.model.bo.presale.RedisPreSaleActivityBo;
import com.common.model.bo.presale.RedisPreSaleSpecificationBo;
import com.common.model.bo.redis.JedisClusterPipeline;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.SharingJedisCluster;

import java.util.ArrayList;
import java.util.List;

public class PreSaleRedisDao extends BaseActivityRedisDao {

    /**
     * 上线预售活动
     * @param activityBo
     * @param specificationBos
     * @return
     */
    public boolean insertPreSaleActivity(RedisPreSaleActivityBo activityBo, List<RedisPreSaleSpecificationBo> specificationBos){
        if(CollectionUtils.isEmpty(specificationBos)){
            return false;
        }

        List<String> specificationStringList = new ArrayList<>();
        for (RedisPreSaleSpecificationBo specificationBo : specificationBos){
            specificationStringList.add(String.valueOf(specificationBo.getSpecificationId()));
        }

        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = redis.pipelined();
        try{
            pipeline = redis.pipelined();
            pipeline.hmset(buildString(":",PRE_SALE_ACTIVITY_PREFIX
                    ,activityBo.getAppCode() , String.valueOf(activityBo.getId())),activityBo);
            pipeline.sadd(buildString(":",ACTIVITY_SPECIFICATION_PREFIX
                    ,activityBo.getAppCode(), String.valueOf(activityBo
                            .getId())),specificationStringList.toArray(new String[0]));
            for (RedisPreSaleSpecificationBo specificationBo : specificationBos) {
                pipeline.hmset(buildString(":",PRE_SALE_ACTIVITY_CONTENT_PREFIX
                        ,activityBo.getAppCode(),String.valueOf(activityBo
                                .getId()), String.valueOf(specificationBo
                                .getSpecificationId())),specificationBo);
            }

            for (String specificationId : specificationStringList){
                pipeline.sadd(buildString(":",SPECIFICATION_ACTIVITY_PREFIX,activityBo
                        .getAppCode(),specificationId),buildString(":",BUY_GIFT_ACTIVITY_PREFIX
                        ,String.valueOf(activityBo.getId()).toString()));
            }
            pipeline.sadd(buildString(":",ONLINE_PRE_SALE_ACTIVITY,activityBo.getAppCode())
                    ,buildString(":",PRE_SALE_ACTIVITY_PREFIX, activityBo.getAppCode(),String.valueOf(activityBo.getId())));
            pipeline.sync();
        }finally {
            if (pipeline != null){
                pipeline.close();
            }
        }
        return true;
    }

    /**
     * 下线预售活动
     * @param appCode
     * @param activityId
     * @return
     */
    public boolean offlinePreSaleActivity(String appCode,int activityId){
        return offlineActivityBo(appCode,activityId,PRE_SALE_ACTIVITY_PREFIX,ONLINE_PRE_SALE_ACTIVITY);
    }

    /**
     * 更新阶段
     * @param appCode
     * @param activityId
     * @param stage
     * @return
     */
    public boolean updateStage(String appCode,int activityId,int stage){
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = redis.pipelined();
        redis.hset(buildString(":",PRE_SALE_ACTIVITY_PREFIX
                ,appCode , String.valueOf(activityId)),RedisPreSaleActivityBo.STAGE,String.valueOf(stage));
        return true;
    }


}
