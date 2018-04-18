package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class ShipAddress extends BaseModel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5228871643468328466L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 发货地址的详细信息，指的是完整地址 **/
	private String saAddr;

	/** 发货地址id，对应系统区域管理类Area **/
	private Long saAreaId;

	/** 发货公司 **/
	private String saCompany;

	/** 是否默认发货地址,1为默认 **/
	private Boolean saDefault;

	/** 发货地址名称 **/
	private String saName;

	/**  **/
	private Integer saSequence;

	/** 发货人联系电话 **/
	private String saTelephone;

	/** 发货地址类型，0为商家发货地址，1为管理员发货地址,默认为0 **/
	private Integer saType;

	/** 发货人姓名 **/
	private String saUser;

	/** 发货地址的用户 **/
	private Long saUserId;

	/** 发货人区号或者邮编 **/
	private String saZip;

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

	public String getSaAddr() {
		return saAddr;
	}

	public void setSaAddr(String saAddr) {
		this.saAddr = saAddr;
	}

	public Long getSaAreaId() {
		return saAreaId;
	}

	public void setSaAreaId(Long saAreaId) {
		this.saAreaId = saAreaId;
	}

	public String getSaCompany() {
		return saCompany;
	}

	public void setSaCompany(String saCompany) {
		this.saCompany = saCompany;
	}

	public Boolean getSaDefault() {
		return saDefault;
	}

	public void setSaDefault(Boolean saDefault) {
		this.saDefault = saDefault;
	}

	public String getSaName() {
		return saName;
	}

	public void setSaName(String saName) {
		this.saName = saName;
	}

	public Integer getSaSequence() {
		return saSequence;
	}

	public void setSaSequence(Integer saSequence) {
		this.saSequence = saSequence;
	}

	public String getSaTelephone() {
		return saTelephone;
	}

	public void setSaTelephone(String saTelephone) {
		this.saTelephone = saTelephone;
	}

	public Integer getSaType() {
		return saType;
	}

	public void setSaType(Integer saType) {
		this.saType = saType;
	}

	public String getSaUser() {
		return saUser;
	}

	public void setSaUser(String saUser) {
		this.saUser = saUser;
	}

	public Long getSaUserId() {
		return saUserId;
	}

	public void setSaUserId(Long saUserId) {
		this.saUserId = saUserId;
	}

	public String getSaZip() {
		return saZip;
	}

	public void setSaZip(String saZip) {
		this.saZip = saZip;
	}
}