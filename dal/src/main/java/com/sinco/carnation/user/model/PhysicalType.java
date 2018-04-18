package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class PhysicalType extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6016484510832912103L;

	/**  **/
	private Long id;

	/** 类别名称 **/
	private String typeName;

	/** 单位 **/
	private String unit;

	/** 排序 **/
	private Integer sortIndex;

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

	/** 类别简介 **/
	private String profile;

	/** 详细内容 **/
	private String memo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
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

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}