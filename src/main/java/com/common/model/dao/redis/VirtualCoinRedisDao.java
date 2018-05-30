package com.common.model.dao.redis;

import com.common.model.bo.platform.RedisPlatformBo;
import com.common.model.bo.virtualcoin.TimeSharingItem;
import com.common.model.bo.virtualcoin.VirtualCoinSerialBo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

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

    @Autowired
    private AssemblyRedisDao assemblyRedisDao;

    public double findUserVirtualCoin(String userId,String appCode){
        Jedis redis = getRedis(VIRTUAL_COIN_DB);
        try{
            String numString = redis.get(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX,appCode,userId));
            return NumberUtils.toDouble(numString,0);
        }finally {
            if (redis != null ){
                redis.close();
            }
        }
    }

    public Map<String,String> findSharingVirtualCoin(String userId,String appCode){
        Jedis redis = getRedis(VIRTUAL_COIN_DB);
        try{
            Map<String,String> response = redis.hgetAll(buildString(":"
                    ,USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX,appCode,userId));
            return response;
        }finally {
            if (redis != null ){
                redis.close();
            }
        }
    }

    public boolean distributeVirtualCoin(String userId,String appCode
            ,double addVirtualCoin,Long timeout){
        Jedis redis = getRedis(VIRTUAL_COIN_DB);
        try{
            Transaction transaction = redis.multi();
            transaction.incrByFloat(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX
                    ,appCode,userId),addVirtualCoin);
            transaction.hincrByFloat(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX
                    ,appCode,userId),timeout.toString(),addVirtualCoin);
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

    public boolean distributeVirtualCoins(List<String> userIds,String appCode
            ,double addVirtualCoin,Long timeout){
        Jedis redis = getRedis(VIRTUAL_COIN_DB);
        try{
            Transaction transaction = redis.multi();
            for (String userId : userIds){
                transaction.incrByFloat(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX
                        ,appCode,userId),addVirtualCoin);
                transaction.hincrByFloat(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX
                        ,appCode,userId),timeout.toString(),addVirtualCoin);
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

    public List<TimeSharingItem> usedVirtualCoin(String userId,String appCode,double usedVirtualCoin){
        Jedis redis = getRedis(VIRTUAL_COIN_DB);
        String lockKey = buildString(AssemblyRedisDao.LOCK_SPLIT_CODE,AssemblyRedisDao.VIRTUAL_COIN_LOCK,userId);
        String lockValue = String.valueOf(System.currentTimeMillis());
        try{
            assemblyRedisDao.lock(lockKey,lockValue);
            Pipeline pipeline = redis.pipelined();
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
            Transaction transaction = redis.multi();
            transaction.incrByFloat(buildString(":"
                    ,USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX,appCode,userId),-usedVirtualCoin);
            transaction.del(buildString(":"
                    ,USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX,appCode,userId));
            transaction.hmset(buildString(":"
                    ,USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX,appCode,userId),timeSharingStringMap);
            List<Object> result = transaction.exec();
            if (CollectionUtils.isEmpty(result)){
                return null;
            }
            return timeSharingItemList;
        }finally {
            assemblyRedisDao.unlock(lockKey,lockValue);
            if (redis != null ){
                redis.close();
            }
        }
    }

    public TimeSharingItem removeExpireVirtualCoin(String userId,String appCode){
        Jedis redis = getRedis(VIRTUAL_COIN_DB);
        String lockKey = buildString(AssemblyRedisDao.LOCK_SPLIT_CODE,AssemblyRedisDao.VIRTUAL_COIN_LOCK,userId);
        String lockValue = String.valueOf(System.currentTimeMillis());
        try{
            assemblyRedisDao.lock(lockKey,lockValue);
            Map<String,String> timeSharingStringMap = redis.hgetAll(buildString(":",USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX
                    ,appCode,userId));
            if (MapUtils.isEmpty(timeSharingStringMap)){
                return null;
            }
            TreeMap<Long,Double> timeSharingMap = new TreeMap<>();
            for (Map.Entry<String,String> entry : timeSharingStringMap.entrySet()){
                timeSharingMap.put(NumberUtils.toLong(entry.getKey()),NumberUtils.toDouble(entry.getValue()));
            }
            if (System.currentTimeMillis()>=timeSharingMap.firstEntry().getKey()) {
                Transaction transaction = redis.multi();
                transaction.incrByFloat(buildString(":"
                        , USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX, appCode, userId), -timeSharingMap.firstEntry().getValue());
                transaction.hdel(buildString(":"
                        , USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX, appCode, userId), timeSharingMap.firstEntry().getKey().toString());
                List<Object> result = transaction.exec();
                if (CollectionUtils.isEmpty(result)) {
                    return null;
                }
                TimeSharingItem timeSharingItem = new TimeSharingItem();
                timeSharingItem.setTimeout(timeSharingMap.firstEntry().getKey());
                timeSharingItem.setVirtualCoin(timeSharingMap.firstEntry().getValue());
                return timeSharingItem;
            }
            return null;
        }finally {
            assemblyRedisDao.unlock(lockKey,lockValue);
            if (redis != null ){
                redis.close();
            }
        }
    }

    public boolean restorationVirtualCoin(String userId,String appCode,List<TimeSharingItem> sharingItemList){
        Jedis redis = getRedis(VIRTUAL_COIN_DB);
        try{
            long nowTime = System.currentTimeMillis();
            Transaction transaction = redis.multi();
            BigDecimal restorationCoin = BigDecimal.ZERO;
            for (TimeSharingItem timeSharingItem : sharingItemList){
                if (nowTime >= timeSharingItem.getTimeout()){
                    continue;
                }
                restorationCoin = restorationCoin.add(BigDecimal.valueOf(timeSharingItem.getVirtualCoin()));
                LOGGER.info("累加返还金额：{}",restorationCoin.doubleValue());
                transaction.hincrByFloat(buildString(":"
                        ,USER_VIRTUAL_COIN_ACCOUNT_SHARING_PREFIX,appCode,userId)
                        ,timeSharingItem.getTimeout().toString(),timeSharingItem.getVirtualCoin());
            }
            transaction.incrByFloat(buildString(":"
                    ,USER_VIRTUAL_COIN_ACCOUNT_TOTAL_PREFIX,appCode,userId),restorationCoin.doubleValue());
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


    public AssemblyRedisDao getAssemblyRedisDao() {
        return assemblyRedisDao;
    }

    public void setAssemblyRedisDao(AssemblyRedisDao assemblyRedisDao) {
        this.assemblyRedisDao = assemblyRedisDao;
    }
}
