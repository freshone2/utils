package com.common.model.dao.redis;

import com.common.config.conf.AppConfigEnum;
import com.common.model.bo.config.RedisAppConfigBo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.SharingJedisCluster;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Package: com.common.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/7/3 下午4:14
 */
public class ConfigRedisDao extends BaseRedisDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigRedisDao.class);

    private static final String APP_CONFIG = "app:config";

    public boolean upsertAppConfigItem(String appCode, AppConfigEnum configKey ,Object configValue ){
        SharingJedisCluster redis = getRedis();
        String configString = redis.hget(APP_CONFIG,appCode);
        RedisAppConfigBo appConfigBo = null;
        if (StringUtils.isNotBlank(configString)) {
            appConfigBo = GSON.fromJson(configString, RedisAppConfigBo.class);
        }else {
            appConfigBo = new RedisAppConfigBo();
        }
        try {
            BeanUtils.setProperty(appConfigBo,configKey.CODE,configValue);
        } catch (IllegalAccessException e) {
            LOGGER.error("错误：{}",e);
            return false;
        } catch (InvocationTargetException e) {
            LOGGER.error("错误：{}",e);
            return false;
        }
        redis.hset(APP_CONFIG,appCode,GSON.toJson(appConfigBo));
        return true;
    }

    public boolean removeAppConfigItem(String appCode,AppConfigEnum appConfigEnum ){
        SharingJedisCluster redis = getRedis();
        String configString = redis.hget(APP_CONFIG,appCode);
        RedisAppConfigBo appConfigBo = null;
        if (StringUtils.isBlank(configString)) {
            return true;
        }
        try {
            BeanUtils.setProperty(appConfigBo,appConfigEnum.CODE,null);
        } catch (IllegalAccessException e) {
            LOGGER.error("错误：{}",e);
            return false;
        } catch (InvocationTargetException e) {
            LOGGER.error("错误：{}",e);
            return false;
        }
        redis.hset(APP_CONFIG,appCode,GSON.toJson(appConfigBo));
        return true;
    }

    public Object findAppConfigItem(String appCode,AppConfigEnum appConfigEnum ){
        SharingJedisCluster redis = getRedis();
        String config = redis.hget(APP_CONFIG,appCode);
        if (StringUtils.isBlank(config)){
            return null;
        }
        RedisAppConfigBo appConfigBo = GSON.fromJson(config,RedisAppConfigBo.class);
        try {
            Object result = PropertyUtils.getProperty(appConfigBo,appConfigEnum.CODE);
            return result;
        } catch (IllegalAccessException e) {
            LOGGER.error("错误：{}",e);
        } catch (InvocationTargetException e) {
            LOGGER.error("错误：{}",e);
        } catch (NoSuchMethodException e) {
            LOGGER.error("错误：{}",e);
        }
        return null;
    }

    public RedisAppConfigBo findAppConfig(String appCode){
        SharingJedisCluster redis = getRedis();
        String config = redis.hget(APP_CONFIG,appCode);
        if (StringUtils.isBlank(config)){
            return null;
        }
        RedisAppConfigBo appConfigBo = GSON.fromJson(config,RedisAppConfigBo.class);
        return appConfigBo;
    }
}
