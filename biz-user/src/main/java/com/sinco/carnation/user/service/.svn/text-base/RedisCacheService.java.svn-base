package com.sinco.carnation.user.service;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import com.sinco.biz.common.service.BaseService;

/***
 * 缓存service
 * 
 * @author
 * 
 */

@Service
public class RedisCacheService extends BaseService {

	@Resource(name = "bizRedisPool")
	private JedisPool bizRedisPool;

	public void setSmsCode(Long userId, String code, String mobile) {
		Jedis jedis = bizRedisPool.getResource();
		try {
			jedis.setex("USER_SMS_CODE_" + userId + "_" + mobile + "_count", 20 * 60, "0");
			jedis.setex("USER_SMS_CODE_" + userId + "_" + mobile, 20 * 60, code);
		} finally {
			bizRedisPool.returnResource(jedis);
		}
	}

	public String getSmsCode(Long userId, String mobile) {
		Jedis jedis = bizRedisPool.getResource();
		try {
			jedis.setex("USER_SMS_CODE_" + userId + "_" + mobile + "_count", 20 * 60, "0");
			String count = jedis.get("USER_SMS_CODE_" + userId + "_" + mobile + "_count");
			if (StringUtils.isNotBlank(count)) {
				int nextCount = Integer.parseInt(count) + 1;
				if (nextCount >= 10) {
					jedis.del("USER_SMS_CODE_" + userId + "_" + mobile + "_count");
					jedis.del("USER_SMS_CODE_" + userId + "_" + mobile);
				}
				jedis.setex("USER_SMS_CODE_" + userId + "_" + mobile + "_count", 20 * 60,
						String.valueOf(nextCount));
			} else {
				jedis.setex("USER_SMS_CODE_" + userId + "_" + mobile + "_count", 20 * 60, "0");
			}

			String code = jedis.get("USER_SMS_CODE_" + userId + "_" + mobile);
			return code;
		} finally {
			bizRedisPool.returnResource(jedis);
		}
	}

	/**
	 * 删除验证码
	 * 
	 * @param userId
	 * @param mobile
	 */
	public void delSmsCode(Long userId, String mobile) {
		Jedis jedis = bizRedisPool.getResource();
		try {
			jedis.del("USER_SMS_CODE_" + userId + "_" + mobile + "_count");
			jedis.del("USER_SMS_CODE_" + userId + "_" + mobile);
		} finally {
			bizRedisPool.returnResource(jedis);
		}
	}

	/**
	 * 缓存用户邀请总人数
	 * 
	 * @param userId
	 */
	public void setUserLevelCount(Long userId, String count, int seconds) {
		Jedis jedis = bizRedisPool.getResource();
		try {
			jedis.setex("USER_LEVEL_COUNT_" + userId, seconds, count);
		} finally {
			bizRedisPool.returnResource(jedis);
		}
	}

	/**
	 * 获取缓存用户邀请总人数
	 * 
	 * @param userId
	 */
	public String getUserLevelCount(Long userId) {
		String key = "USER_LEVEL_COUNT_" + userId;
		String resultValue = null;
		Jedis jedis = bizRedisPool.getResource();
		try {
			resultValue = jedis.get(key);
		} finally {
			bizRedisPool.returnResource(jedis);
		}
		return resultValue;
	}

	/**
	 * 删除缓存用户邀请总人数
	 * 
	 * @param userId
	 */
	public void delUserLevelCount(Long userId) {

	}

	/**
	 * 缓存用户注册总人数
	 * 
	 * @param userId
	 */
	public void setUserRegisterCount(String count, int seconds) {
		Jedis jedis = bizRedisPool.getResource();
		try {
			jedis.setex("USER_REGISTER_TOTAL_COUNT", seconds, count);
		} finally {
			bizRedisPool.returnResource(jedis);
		}
	}

	/**
	 * 获取缓存用户注册请总人数
	 * 
	 * @param userId
	 */
	public String getUserRegisterCount() {
		String key = "USER_REGISTER_TOTAL_COUNT";
		String resultValue = null;
		Jedis jedis = bizRedisPool.getResource();
		try {
			resultValue = jedis.get(key);
		} finally {
			bizRedisPool.returnResource(jedis);
		}
		return resultValue;
	}

	/**
	 * 删除缓存用户注册总人数
	 * 
	 * @param userId
	 */
	public void delUserRegisterCount() {
		Jedis jedis = bizRedisPool.getResource();
		try {
			jedis.del("USER_REGISTER_TOTAL_COUNT");
		} finally {
			bizRedisPool.returnResource(jedis);
		}
	}
}
