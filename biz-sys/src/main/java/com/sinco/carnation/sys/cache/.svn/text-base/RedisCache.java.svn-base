package com.sinco.carnation.sys.cache;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 缓存工具类
 * 
 * @author muxi
 * 
 */
public class RedisCache {

	@Resource(name = "bizRedisPool")
	private static JedisPool bizRedisPool;

	public static void setSmsCode(Long userId, String code, String mobile) {
		Jedis jedis = bizRedisPool.getResource();
		try {
			jedis.setex("USER_SMS_CODE_" + userId + "_" + mobile + "_count", 10 * 60, "0");
			jedis.setex("USER_SMS_CODE_" + userId + "_" + mobile, 10 * 60, code);
		} finally {
			bizRedisPool.returnResource(jedis);
		}
	}

	public static String getSmsCode(Long userId, String mobile) {
		Jedis jedis = bizRedisPool.getResource();
		try {
			jedis.setex("USER_SMS_CODE_" + userId + "_" + mobile + "_count", 10 * 60, "0");
			String count = jedis.get("USER_SMS_CODE_" + userId + "_" + mobile + "_count");
			if (StringUtils.isNotBlank(count)) {
				int nextCount = Integer.parseInt(count) + 1;
				if (nextCount >= 10) {
					jedis.del("USER_SMS_CODE_" + userId + "_" + mobile + "_count");
					jedis.del("USER_SMS_CODE_" + userId + "_" + mobile);
				}
				jedis.setex("USER_SMS_CODE_" + userId + "_" + mobile + "_count", 10 * 60,
						String.valueOf(nextCount));
			} else {
				jedis.setex("USER_SMS_CODE_" + userId + "_" + mobile + "_count", 10 * 60, "0");
			}

			String code = jedis.get("USER_SMS_CODE_" + userId + "_" + mobile);
			return code;
		} finally {
			bizRedisPool.returnResource(jedis);
		}
	}
}
