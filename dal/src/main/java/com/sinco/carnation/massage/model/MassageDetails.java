package com.sinco.carnation.massage.model;

import java.util.Date;

import com.sinco.mybatis.dal.model.BaseModel;

public class MassageDetails extends BaseModel {
	private static final long serialVersionUID = 294785418871900580L;
	private Long id;
	// 用户ID
	private Long userId;
	// 日期
	private String date;
	// 按摩时长（单位分钟）
	private Integer time;
	// 备注
	private String remark;
	// 创建人
	private String createUser;
	// 创建时间
	private Date createTime;
	// 最后更新人
	private String lastUpdateUser;
	// 最后更新时间
	private Date lastUpdateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}