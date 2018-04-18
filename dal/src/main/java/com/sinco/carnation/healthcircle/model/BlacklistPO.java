package com.sinco.carnation.healthcircle.model;

import java.util.Date;

import com.sinco.mybatis.dal.model.BaseModel;

public class BlacklistPO extends BaseModel {

	private static final long serialVersionUID = 6330812368160448109L;

	private Long id;
	// 用户ID
	private Long userId;
	// 删除状态（0 未删除 1 已删除）
	private Long deleteStatus;
	// 备注
	private String remark;
	// 创建时间
	private Date createTime;
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

	public Long getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Long deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}