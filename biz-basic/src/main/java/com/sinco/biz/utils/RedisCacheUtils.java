/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sinco.biz.utils;

import java.io.IOException;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Cache工具类
 * 
 * @author james
 * @version 2013-5-29
 */
public class RedisCacheUtils {

	private JedisPool pool;

	public ObjectMapper mapper;

	private String SYS_CACHE;

	public RedisCacheUtils(String prefix, JedisPool pool) {
		SYS_CACHE = prefix;
		this.pool = pool;
		initMapper();
	}

	public RedisCacheUtils(String prefix, JedisPool pool, ObjectMapper mapper) {
		SYS_CACHE = prefix;
		this.pool = pool;
		this.mapper = mapper;
	}

	private void initMapper() {
		mapper = new ObjectMapper();
		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	/**
	 * get
	 * 
	 * @param key
	 * @param type
	 * @return
	 */
	public <T> T get(String key, TypeReference<T> type) {
		String str = get(key);
		if (StringUtils.isBlank(str)) {
			return null;
		}
		try {
			return mapper.readValue(str, type);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * get
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {

		Jedis jedis = pool.getResource();
		try {
			return jedis.get(makeKey(key));
		} finally {
			pool.returnResource(jedis);
		}
	}

	/**
	 * incr 原子加1
	 * 
	 * @param key
	 * @return
	 */
	public Long incr(String key) {

		Jedis jedis = pool.getResource();
		try {
			return jedis.incr(makeKey(key));
		} finally {
			pool.returnResource(jedis);
		}
	}

	public void set(String key, Object value) {
		try {
			set(key, mapper.writeValueAsString(value));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public void set(String key, String value) {
		Jedis jedis = pool.getResource();
		try {
			jedis.set(makeKey(key), value);
		} finally {
			pool.returnResource(jedis);
		}
	}

	public void set(String key, Object value, int expire) {
		try {
			set(key, mapper.writeValueAsString(value), expire);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public void set(String key, String value, int expire) {
		Jedis jedis = pool.getResource();
		try {
			jedis.setex(makeKey(key), expire, value);
		} finally {
			pool.returnResource(jedis);
		}
	}

	public void sadd(String key, String[] value, int expire) {
		Jedis jedis = pool.getResource();
		try {
			jedis.sadd(makeKey(key), value);
			expire(key, expire);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			pool.returnResource(jedis);
		}
	}

	public void expire(String key, int expire) {
		Jedis jedis = pool.getResource();
		try {
			if (expire != 0) {
				jedis.expire(makeKey(key), expire);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			pool.returnResource(jedis);
		}
	}

	public void del(String key) {
		Jedis jedis = pool.getResource();
		try {
			Long i = jedis.del(makeKey(key));
			System.out.println(i);
		} finally {
			pool.returnResource(jedis);
		}
	}

	/**
	 * 根据规则删除所有
	 * 
	 * @param pattern
	 */
	public void delAll(String pattern) {
		Jedis jedis = pool.getResource();
		try {
			StringBuilder patternSb = new StringBuilder().append(SYS_CACHE).append(":").append(pattern);
			Set<String> keys = jedis.keys(patternSb.toString());
			for (String key : keys) {
				jedis.del(key);
			}
		} finally {
			pool.returnResource(jedis);
		}
	}

	/**
	 * 得到最终key名称
	 * 
	 * @param key
	 * @return
	 */
	private String makeKey(String key) {
		return new StringBuilder().append(SYS_CACHE).append(":").append(key).toString();
	}

	public Set<String> keys(String pattern) {

		Jedis jedis = pool.getResource();
		try {
			return jedis.keys(pattern);
		} finally {
			pool.returnResource(jedis);
		}
	}
}
