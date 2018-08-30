package com.common.redis;

import java.io.IOException;

import org.msgpack.MessagePack;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.SharingJedisCluster;
import redis.clients.jedis.exceptions.JedisException;

@Slf4j
public class RedisClientJedis implements RedisClient {

	private SharingJedisCluster sharingJedisCluster;
	
	private MessagePack messagePack = new MessagePack();

	public RedisClientJedis(SharingJedisCluster sharingJedisCluster) {
		this.sharingJedisCluster = sharingJedisCluster;
	}
	
	@Override
	public void set(String key, Object value) {
		try {
			sharingJedisCluster.set(messagePack.write(key), messagePack.write(value));
		} catch (IOException e) {
			log.error("jedis fail to set({}, {})", key, value);
			throw new JedisException("jedis异常", e);
		}
	}
	
	@Override
	public void setex(String key, Object value, int seconds) {
		try {
			sharingJedisCluster.setex(messagePack.write(key), seconds, messagePack.write(value));
		} catch (IOException e) {
			log.error("jedis fail to setex({}, {}, {})", key, value, seconds);
			throw new JedisException("jedis异常", e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		try {
			return (T) messagePack.read(sharingJedisCluster.get(messagePack.write(key)));
		} catch (IOException e) {
			log.error("jedis fail to get({})", key);
			throw new JedisException("jedis异常", e);
		}
	}
	
	@Override
	public long del(String key) {
		try {
			return sharingJedisCluster.del(messagePack.write(key));
		} catch (IOException e) {
			log.error("jedis fail to del({})", key);
			throw new JedisException("jedis异常", e);
		}
	}
	
	@Override
	public void hset(String key, String field, Object value) {
		try {
			sharingJedisCluster.hset(messagePack.write(key), messagePack.write(field), messagePack.write(value));
		} catch (IOException e) {
			log.error("jedis fail to hset({}, {}, {})", key, field, value);
			throw new JedisException("jedis异常", e);
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T hget(String key, String field) {
		try {
			return (T) messagePack.read(sharingJedisCluster.hget(messagePack.write(key), messagePack.write(field)));
		} catch (IOException e) {
			log.error("jedis fail to hget({}, {})", key, field);
			throw new JedisException("jedis异常", e);
		}
	}
	
	@Override
	public long hdel(String key, String field) {
		try {
			return sharingJedisCluster.hdel(messagePack.write(key), messagePack.write(field));
		} catch (IOException e) {
			log.error("jedis fail to hdel({}, {})", key, field);
			throw new JedisException("jedis异常", e);
		}
	}

	@Override
	public long sadd(String key, Object... members) {
		try {
			return sharingJedisCluster.sadd(messagePack.write(key), toByteArrs(members));
		} catch (IOException e) {
			log.error("jedis fail to sadd({}, {})", key, members);
			throw new JedisException("jedis异常", e);
		}
	}
	
	@Override
	public long srem(String key, Object... members) {
		try {
			return sharingJedisCluster.srem(messagePack.write(key), toByteArrs(members));
		} catch (IOException e) {
			log.error("jedis fail to srem({}, {})", key, members);
			throw new JedisException("jedis异常", e);
		}
	}
	
	private byte[][] toByteArrs(Object... members) throws IOException {
		byte[][] byteArrs = new byte[members.length][];
		for (int i = 0; i < members.length; i++) {
			byteArrs[i] = messagePack.write(members[i]);
		}
		return byteArrs;
	}
}
