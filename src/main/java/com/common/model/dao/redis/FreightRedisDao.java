package com.common.model.dao.redis;

import com.common.model.bo.freight.FreightBo;
import com.google.gson.Gson;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SharingJedisCluster;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.common.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/5/8 下午8:55
 */
public class FreightRedisDao extends BaseRedisDao {
    private static final int FREIGHT_DB = 7;

    private static final Gson GSON = new Gson();

    private static final String FREIGHT_KEY = "freight";

    /**
     * 获取单个运费模板值
     *
     * @param appCode
     * @return
     */
    public FreightBo findFreight(String appCode){
        SharingJedisCluster redis = getRedis();
        String result = redis.hget(FREIGHT_KEY,appCode);
        if (StringUtils.isBlank(result)){
            return null;
        }
        return GSON.fromJson(result, FreightBo.class);
    }

    /**
     * 获取所有运费模板值
     *
     * @return
     */
    public Map<String,FreightBo> findAllFreight(){
         SharingJedisCluster redis = getRedis();
         Map<String,String> result = redis.hgetAll(FREIGHT_KEY);
         if (MapUtils.isEmpty(result)){
             return null;
         }

         Map<String,FreightBo> freightBoMap = new HashMap<>(result.size());
         for (Map.Entry<String,String> entry : result.entrySet()) {
             freightBoMap.put(entry.getKey(),GSON.fromJson(entry.getValue(),FreightBo.class));
         }
         return freightBoMap;
    }

    /**
     * 更新或新增运费模板
     *
     * @param appCode
     * @param freightBo
     * @return
     */
    public boolean upsertFreight(String appCode,FreightBo freightBo){
          SharingJedisCluster redis = getRedis();
          long result = redis.hset(FREIGHT_KEY,appCode,GSON.toJson(freightBo));
          if (result<=0){
              return false;
          }
          return true;
    }

}
