package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class GoldLog extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4954877405330034751L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 审核时间 **/
	private Date glAdminTime;

	/** 数量 **/
	private Integer glCount;

	/** 支付金额 **/
	private Integer glMoney;

	/** 支付方式 **/
	private String glPayment;

	/** 类型，分为0增加、减少-1 **/
	private Integer glType;

	/** 审核管理员 **/
	private Long glAdminId;

	/** 操作用户 **/
	private Long glUserId;

	/** 金币充值记录管理 **/
	private Long grId;

	/** 审核意见 **/
	private String glAdminContent;

	/** 说明 **/
	private String glContent;

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

	public Date getGlAdminTime() {
		return glAdminTime;
	}

	public void setGlAdminTime(Date glAdminTime) {
		this.glAdminTime = glAdminTime;
	}

	public Integer getGlCount() {
		return glCount;
	}

	public void setGlCount(Integer glCount) {
		this.glCount = glCount;
	}

	public Integer getGlMoney() {
		return glMoney;
	}

	public void setGlMoney(Integer glMoney) {
		this.glMoney = glMoney;
	}

	public String getGlPayment() {
		return glPayment;
	}

	public void setGlPayment(String glPayment) {
		this.glPayment = glPayment;
	}

	public Integer getGlType() {
		return glType;
	}

	public void setGlType(Integer glType) {
		this.glType = glType;
	}

	public Long getGlAdminId() {
		return glAdminId;
	}

	public void setGlAdminId(Long glAdminId) {
		this.glAdminId = glAdminId;
	}

	public Long getGlUserId() {
		return glUserId;
	}

	public void setGlUserId(Long glUserId) {
		this.glUserId = glUserId;
	}

	public Long getGrId() {
		return grId;
	}

	public void setGrId(Long grId) {
		this.grId = grId;
	}

	public String getGlAdminContent() {
		return glAdminContent;
	}

	public void setGlAdminContent(String glAdminContent) {
		this.glAdminContent = glAdminContent;
	}

	public String getGlContent() {
		return glContent;
	}

	public void setGlContent(String glContent) {
		this.glContent = glContent;
	}
}