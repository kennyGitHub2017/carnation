package com.sinco.carnation.user.model;

import java.util.Date;

import com.sinco.mybatis.dal.model.BaseModel;

public class RebateLog extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4790804279828690095L;

	/**  **/
	private Long id;

	/** 订单id **/
	private Long orderId;

	private String rebateCode;
	/**  **/
	private String rebateType;

	/** 1成功，0失败 **/
	private Boolean rebateStatus;

	/** 错误描述 **/
	private String errorMsg;

	/**  **/
	private Date createTime;

	public String getRebateCode() {
		return rebateCode;
	}

	public void setRebateCode(String rebateCode) {
		this.rebateCode = rebateCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getRebateType() {
		return rebateType;
	}

	public void setRebateType(String rebateType) {
		this.rebateType = rebateType;
	}

	public Boolean getRebateStatus() {
		return rebateStatus;
	}

	public void setRebateStatus(Boolean rebateStatus) {
		this.rebateStatus = rebateStatus;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}