package com.sinco.carnation.elong.model;

import java.util.Collection;
import java.util.Date;

import com.sinco.carnation.sys.model.Area;
import com.sinco.mybatis.dal.model.BaseModel;

public class ElongGeo extends BaseModel {
	private static final long serialVersionUID = -4414831963676171769L;
	// 地域编号
	private Long id;
	// 是否删除（0未删除，1已删除）
	private Integer deleteStatus;
	// 地域名称
	private String areaName;
	// 地域编号
	private Long areaCode;
	// 级别
	private Integer level;
	// 父类ID
	private Long parentCode;
	// 是否热门城市
	private Boolean isGroupHot;
	// 子类数据列表
	private Collection<Area> childs;
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

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Long getParentCode() {
		return parentCode;
	}

	public void setParentCode(Long parentCode) {
		this.parentCode = parentCode;
	}

	public Boolean getIsGroupHot() {
		return isGroupHot;
	}

	public void setIsGroupHot(Boolean isGroupHot) {
		this.isGroupHot = isGroupHot;
	}

	public Collection<Area> getChilds() {
		return childs;
	}

	public void setChilds(Collection<Area> childs) {
		this.childs = childs;
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

	public Long getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Long areaCode) {
		this.areaCode = areaCode;
	}

	

}