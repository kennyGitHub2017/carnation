/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sinco.biz.common.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

/**
 * Service基类
 * 
 * @author ThinkGem
 * @version 2013-05-15
 */
public abstract class BaseService {

	protected List<Long> getIdList(String ids) {
		List<Long> idList = Lists.newArrayList();
		if (StringUtils.isNotBlank(ids)) {
			ids = ids.trim().replace("　", ",").replace(" ", ",").replace("，", ",");
			String[] arrId = ids.split(",");
			for (String id : arrId) {
				if (id.matches("\\d*")) {
					idList.add(Long.valueOf(id));
				}
			}
		}
		return idList;
	}
}
