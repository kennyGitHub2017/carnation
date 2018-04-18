package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class PhysicalKeyWord extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1725028476678926308L;

	/**  **/
	private Long id;

	/** 名称 **/
	private String name;

	/** 关键字类型 **/
	private Integer type;

	/** 是否推荐 1：是 0：否 **/
	private Integer isTop;

	/** 是否系统标签 1：是 0：否 **/
	private Integer isSystem;

	/** 是否启用 1：是 0：否 **/
	private Integer isEnabled;

	/** 权重 **/
	private Integer priority;

	/** 删除状态 0 正常数据(默认值),1 删除状态 **/
	private Byte deleteStatus;

	/**  **/
	private Long createBy;

	/**  **/
	private Date createTime;

	/**  **/
	private Long modifyBy;

	/**  **/
	private Date modifyTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	public Integer getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(Integer isSystem) {
		this.isSystem = isSystem;
	}

	public Integer getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Byte getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Byte deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}