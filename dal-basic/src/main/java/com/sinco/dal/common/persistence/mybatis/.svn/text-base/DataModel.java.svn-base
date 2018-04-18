/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sinco.dal.common.persistence.mybatis;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinco.data.core.entity.PrePersistEntity;
import com.sinco.data.core.entity.PreUpdateEntity;
import com.sinco.mybatis.dal.model.BaseModel;

/**
 * 数据Model类
 * 
 * 主要提交添加和修改时 createBy，createTime，updateBy，updateTime 字段的自动化处理
 * 
 * @author ThinkGem
 * @version 2013-05-28
 */
public abstract class DataModel extends BaseModel implements Serializable, PrePersistEntity, PreUpdateEntity {

	private static final long serialVersionUID = 1L;

	protected String createBy; // 创建者
	protected Date createTime;// 创建日期
	protected String updateBy; // 更新者
	protected Date updateTime;// 更新日期

	public DataModel() {
		super();
	}

	/**
	 * 添加方法的前置调用方法
	 */
	public void prePersist() {
		this.updateTime = new Date();
		this.updateBy = this.getCurrentUserId();
		this.createTime = this.updateTime;
		this.createBy = this.getCurrentUserId();
	}

	/**
	 * 修改方法的前置调用方法
	 */
	public void preUpdate() {
		this.updateTime = new Date();
		this.updateBy = this.getCurrentUserId();
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
