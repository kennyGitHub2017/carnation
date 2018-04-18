package com.sinco.carnation.sys.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinco.biz.utils.RedisCacheUtils;
import com.sinco.carnation.sys.bo.NavigationBO;
import com.sinco.carnation.sys.contants.SysContants;
import com.sinco.carnation.sys.dao.NavigationDao;

/**
 * 
 * <p>
 * Title: NavViewTools.java
 * </p>
 * 
 * <p>
 * Description:前台导航工具类，查询显示对应的导航信息
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-8-25
 * 
 * @version 1.0.1
 */
@Component
public class NavViewTools {
	@Autowired
	private NavigationDao navDao;

	@Autowired
	private RedisCacheUtils cacheUtils;

	private static String nav_cached_key = "nav_cached";

	/**
	 * 查询页面导航
	 * 
	 * @param position
	 *            导航位置，-1为顶部，0为中间，1为底部
	 * @param count
	 *            导航数目，查询导航数目，-1为查询所有
	 * @return
	 */
	public List<NavigationBO> queryNav(int location, int count) {
		String cacheKey = makeKey(location, count);
		List<NavigationBO> navs = cacheUtils.get(cacheKey, new TypeReference<List<NavigationBO>>() {});
		// 强制导航条从数据库读取数据
		navs = null;
		if (navs == null) {
			navs = navDao.findByLocation(location, count, SysContants.NAV_TYPE_SPAREGOODS);
			cacheUtils.set(cacheKey, navs);
		}
		return navs;
	}

	/**
	 * 清理缓存
	 */
	public void clearNavCache() {
		cacheUtils.delAll(nav_cached_key + ":*");
	}

	private String makeKey(int location, int count) {
		return new StringBuilder(nav_cached_key).append(":").append(location).append(":").append(count)
				.toString();
	}
}
