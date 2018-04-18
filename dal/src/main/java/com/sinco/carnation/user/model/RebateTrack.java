package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class RebateTrack extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2925858363452465416L;

	/**  **/
	private Long id;

	/** 订单号，代表该订单返利的时候的隶属关系 **/
	private Long orderId;

	/** 返润消费码 **/
	private String rebateCode;

	/** 返利类型 **/
	private String rebateType;

	/**  **/
	private Long sellerUserId;

	/**  **/
	private Long ownOperatorUserId;

	/**  **/
	private Date createTime;

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

	public String getRebateCode() {
		return rebateCode;
	}

	public void setRebateCode(String rebateCode) {
		this.rebateCode = rebateCode;
	}

	public String getRebateType() {
		return rebateType;
	}

	public void setRebateType(String rebateType) {
		this.rebateType = rebateType;
	}

	public Long getSellerUserId() {
		return sellerUserId;
	}

	public void setSellerUserId(Long sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	public Long getOwnOperatorUserId() {
		return ownOperatorUserId;
	}

	public void setOwnOperatorUserId(Long ownOperatorUserId) {
		this.ownOperatorUserId = ownOperatorUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}