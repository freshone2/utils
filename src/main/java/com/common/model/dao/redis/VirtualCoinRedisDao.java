package com.common.model.dao.redis;

import com.common.model.bo.platform.RedisPlatformBo;
import com.common.model.bo.redis.JedisClusterPipeline;
import com.common.model.bo.virtualcoin.TimeSharingItem;
import com.common.model.bo.virtualcoin.VirtualCoinSerialBo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Package: com.common.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/5/19 上午10:42
 */
public class VirtualCoinRedisDao extends BaseRedisDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(VirtualCoinRedisDao.class);

    public static final int VIRTUAL_COIN_DB = 9;

    /**
     * 用户总积分值Key:this+appCode+userID
     */
    public static final String USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX = "u:v:t";

    /**
     * 用户分时积分值Key:this+appCode+userID
     */
    public static final String USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX = "u:v:s";

    public double findUserVirtualCoin(String userId,String appCode){
        SharingJedisCluster redis = getRedis();

        String numString = redis.get(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX,appCode,userId));
        return NumberUtils.toDouble(numString,0);
    }

    public Map<String,String> findSharingVirtualCoin(String userId,String appCode){
        SharingJedisCluster redis = getRedis();
        Map<String,String> response = redis.hgetAll(buildString(":"
                ,USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX,appCode,userId));
        return response;
    }

    public boolean distributeVirtualCoin(String userId,String appCode
            ,double addVirtualCoin,Long timeout){
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = null;
        try{
            pipeline = redis.pipelined();
            pipeline.incrByFloat(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX
                    ,appCode,userId),addVirtualCoin);
            pipeline.hincrByFloat(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX
                    ,appCode,userId),timeout.toString(),addVirtualCoin);
            List<Object> result = pipeline.syncAndReturnAll();
            if (CollectionUtils.isEmpty(result)){
                return false;
            }
            return true;
        }catch (Exception e){
            LOGGER.error("错误:{}",e);
            if (pipeline != null ){
                pipeline.close();
            }
        }
        return false;
    }

    public boolean distributeVirtualCoins(List<String> userIds,String appCode
            ,double addVirtualCoin,Long timeout){
        SharingJedisCluster redis = getRedis();
        JedisClusterPipeline pipeline = null;
        try{
            pipeline = redis.pipelined();
            for (String userId : userIds){
                pipeline.incrByFloat(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX
                        ,appCode,userId),addVirtualCoin);
                pipeline.hincrByFloat(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX
                        ,appCode,userId),timeout.toString(),addVirtualCoin);
            }
            List<Object> result = pipeline.syncAndReturnAll();
            if (CollectionUtils.isEmpty(result)){
                return false;
            }
            return true;
        }catch (Exception e){
            LOGGER.error("错误:{}",e);
            if (pipeline != null ){
                pipeline.close();
            }
        }
        return false;
    }

    public List<TimeSharingItem> usedVirtualCoin(String userId,String appCode,double usedVirtualCoin){
        SharingJedisCluster redis = getRedis();
        String lockKey = buildString(AssemblyRedisDao.LOCK_SPLIT_CODE,AssemblyRedisDao.VIRTUAL_COIN_LOCK,userId);
        String lockValue = String.valueOf(System.currentTimeMillis());
        JedisClusterPipeline pipeline = null;
            redis.lock(lockKey,lockValue);
            pipeline = redis.pipelined();
            Response<String> totalResponse = pipeline.get(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX
                    ,appCode,userId));
            Response<Map<String,String>> timeSharingResponse = pipeline.hgetAll(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX
                    ,appCode,userId));
            pipeline.sync();
            double total = NumberUtils.toDouble(totalResponse.get());
            if (total<usedVirtualCoin){
                return null;
            }
            Map<String,String> timeSharingStringMap = timeSharingResponse.get();
            TreeMap<Long,Double> timeSharingMap = new TreeMap<>();
            List<TimeSharingItem> timeSharingItemList = new LinkedList<>();
            for (Map.Entry<String,String> entry : timeSharingStringMap.entrySet()){
                timeSharingMap.put(NumberUtils.toLong(entry.getKey()),NumberUtils.toDouble(entry.getValue()));
            }
            BigDecimal usedVirtualCoinBig = BigDecimal.valueOf(usedVirtualCoin);
            for (Map.Entry<Long,Double> entry : timeSharingMap.entrySet()){
                BigDecimal timeCoinValue = BigDecimal.valueOf(entry.getValue());
                TimeSharingItem timeSharingItem = new TimeSharingItem();
                timeSharingItem.setTimeout(entry.getKey());
                timeSharingItemList.add(timeSharingItem);
                if (usedVirtualCoinBig.compareTo(timeCoinValue) == -1){
                    entry.setValue(timeCoinValue.subtract(usedVirtualCoinBig)
                            .setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
                    timeSharingItem.setVirtualCoin(usedVirtualCoin);
                    timeSharingStringMap.put(entry.getKey().toString()
                            ,timeCoinValue.subtract(usedVirtualCoinBig)
                            .setScale(2,BigDecimal.ROUND_HALF_UP).toString());
                    usedVirtualCoinBig = BigDecimal.ZERO;
                }else {
                    usedVirtualCoinBig = usedVirtualCoinBig.subtract(timeCoinValue)
                            .setScale(2,BigDecimal.ROUND_HALF_UP);
                    timeSharingItem.setVirtualCoin(entry.getValue());
                    timeSharingStringMap.remove(entry.getKey().toString());
                }
                if (usedVirtualCoinBig.compareTo(BigDecimal.ZERO)<1){
                    break;
                }
            }
            pipeline = redis.pipelined();
            pipeline.incrByFloat(buildString(":"
                    ,USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX,appCode,userId),-usedVirtualCoin);
            pipeline.del(buildString(":"
                    ,USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX,appCode,userId));
            pipeline.hmset(buildString(":"
                    ,USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX,appCode,userId),timeSharingStringMap);
            List<Object> result = pipeline.syncAndReturnAll();
            if (CollectionUtils.isEmpty(result)){
                return null;
            }
            return timeSharingItemList;
    }

    public TimeSharingItem removeExpireVirtualCoin(String userId,String appCode){
        SharingJedisCluster redis = getRedis();
        String lockKey = buildString(AssemblyRedisDao.LOCK_SPLIT_CODE,AssemblyRedisDao.VIRTUAL_COIN_LOCK,userId);
        String lockValue = String.valueOf(System.currentTimeMillis());
        JedisClusterPipeline pipeline = null;
        try{
            redis.lock(lockKey,lockValue);
            Map<String,String> timeSharingStringMap = redis.hgetAll(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX
                    ,appCode,userId));
            TreeMap<Long,Double> timeSharingMap = new TreeMap<>();
            for (Map.Entry<String,String> entry : timeSharingStringMap.entrySet()){
                timeSharingMap.put(NumberUtils.toLong(entry.getKey()),NumberUtils.toDouble(entry.getValue()));
            }

            pipeline = redis.pipelined();
            pipeline.incrByFloat(buildString(":"
                    ,USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX,appCode,userId),timeSharingMap.firstEntry().getValue());
            pipeline.hdel(buildString(":"
                    ,USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX,appCode,userId),timeSharingMap.firstEntry().toString());
            List<Object> result = pipeline.syncAndReturnAll();
            if (CollectionUtils.isEmpty(result)){
                return null;
            }
            TimeSharingItem timeSharingItem = new TimeSharingItem();
            timeSharingItem.setTimeout(timeSharingMap.firstEntry().getKey());
            timeSharingItem.setVirtualCoin(timeSharingMap.firstEntry().getValue());
            return timeSharingItem;
        }catch (Exception e){
            LOGGER.error("错误:{}",e);
            if (pipeline != null ){
                pipeline.close();
            }
            return null;
        }finally {
            redis.unlock(lockKey,lockValue);
        }
    }

    public boolean restorationVirtualCoin(String userId,String appCode,List<TimeSharingItem> sharingItemList){
        SharingJedisCluster redis = getRedis();
        long nowTime = System.currentTimeMillis();
        JedisClusterPipeline pipeline = redis.pipelined();
        BigDecimal restorationCoin = BigDecimal.ZERO;
        for (TimeSharingItem timeSharingItem : sharingItemList){
            if (nowTime >= timeSharingItem.getTimeout()){
                continue;
            }
            restorationCoin = restorationCoin.add(BigDecimal.valueOf(timeSharingItem.getVirtualCoin()));
            pipeline.hincrByFloat(buildString(":"
                    ,USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX,appCode,userId)
                    ,timeSharingItem.getTimeout().toString(),timeSharingItem.getVirtualCoin());
        }
        pipeline.incrByFloat(buildString(":"
                ,USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX,appCode,userId),restorationCoin.doubleValue());
        List<Object> result = pipeline.syncAndReturnAll();
        if (CollectionUtils.isEmpty(result)){
            return false;
        }
        return true;
    }
}
