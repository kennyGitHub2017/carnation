package com.sinco.carnation.user.model;

import com.sinco.carnation.sys.model.Area;
import com.sinco.mybatis.dal.model.BaseModel;

import java.util.Date;

public class Address extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8085123675736309201L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 收货人详细地址 **/
	private String areaInfo;

	/**  **/
	private Boolean defaultVal;

	/**  **/
	private String mobile;

	/**  **/
	private String telephone;

	/** 收货人姓名 **/
	private String trueName;

	/** 邮政编码 **/
	private String zip;

	/** 收货人地区 **/
	private Long areaId;

	/**  **/
	private Long userId;

	private Area area;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getAreaInfo() {
		return areaInfo;
	}

	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}

	public Boolean getDefaultVal() {
		return defaultVal;
	}

	public void setDefaultVal(Boolean defaultVal) {
		this.defaultVal = defaultVal;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}