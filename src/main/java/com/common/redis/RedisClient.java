package com.common.redis;

/**
 * redis客户端统一接口
 * 
 * @author xiangshuo
 *
 */
public interface RedisClient {

	void set(String key, Object value);
	
	<T> T get(String key);

	long del(String key);
	
	/**
	 * 设置键值对，包含过期时间（单位：秒）
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 */
	void setex(String key, Object value, int seconds);

	void hset(String key, String field, Object value);

	<T> T hget(String key, String field);
	
	long hdel(String key, String field);
	
	long sadd(String key, Object... members);

	long srem(String key, Object... members);



}
