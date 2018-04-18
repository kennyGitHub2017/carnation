/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sinco.dal.common.persistence.mybatis;

import java.io.Serializable;
import java.util.Date;

import com.sinco.data.core.entity.PrePersistEntity;
import com.sinco.mybatis.dal.model.BaseModel;

/**
 * 数据Model类
 * 
 * 主要提交添加和修改时 createBy，createTime，updateBy，updateTime 字段的自动化处理
 * 
 * @author ThinkGem
 * @version 2013-05-28
 */
public abstract class AddTimeModel extends BaseModel implements Serializable, PrePersistEntity {

	private static final long serialVersionUID = 1L;

	private Date addTime;

	public AddTimeModel() {
		super();
	}

	/**
	 * 添加方法的前置调用方法
	 */
	public void prePersist() {
		this.addTime = new Date();

	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
}
