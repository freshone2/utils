package com.common.model.dao.redis;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * @Package: pecker.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/3/30 下午2:37
 */
@ConditionalOnClass(JedisPool.class)
@ConditionalOnBean(JedisPool.class)
public class AssemblyRedisDao extends BaseRedisDao {

    public static final int LOCK_DB = 11;

    public static final int ORDER_DB = 11;

    public static final int DEFAULT_EXPIRE = 1;

    public static final long DEFAULT_TIMEOUT = 1000;

    public static final String LOCK_SPLIT_CODE = ":";

    public static final String USER_ORDER_LOCK = "lock:user:order";

    public static final String ORDER_LOCK = "lock:order";

    public static final String ADJUST_ORDER_LOCK = "lock:order_adjust";

    public static final String VIRTUAL_COIN_LOCK = "lock:virtual_coin";

    public static final String COMMODITY_LOCK = "lock:commodity";

    public static final String ACTIVITY_LOCK = "lock:activity";
}
