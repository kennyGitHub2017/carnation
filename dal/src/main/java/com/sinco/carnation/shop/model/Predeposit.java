package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class Predeposit extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7582380095378561116L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 充值金额 **/
	private BigDecimal pdAmount;

	/** 交易流水号,在线支付时每次随机生成唯一的号码，重复提交时替换当前订单的交易流水号 **/
	private String pdNo;

	/** 支付状态，0为等待支付，1为线下提交支付完成申请，2为支付成功 **/
	private Integer pdPayStatus;

	/** 充值方式 **/
	private String pdPayment;

	/** 汇款银行 **/
	private String pdRemittanceBank;

	/** 汇款日期 **/
	private Date pdRemittanceTime;

	/** 汇款人姓名 **/
	private String pdRemittanceUser;

	/** 充值唯一编号记录，使用pd为前缀 **/
	private String pdSn;

	/** 预存款状态，0为未完成，1为成功，-1已关闭 **/
	private Integer pdStatus;

	/** 充值请求处理的管理员 **/
	private Long pdAdminId;

	/** 充值会员 **/
	private Long pdUserId;

	/** 请求处理备注 **/
	private String pdAdminInfo;

	/** 汇款备注 **/
	private String pdRemittanceInfo;

	/**
	 * 订单id,如果有值该充值完成后进行订单支付
	 */
	private Long pdOrderId;

	/**
	 * 订单的类型: 商品: goods 积分商品:integral
	 */
	private String pdOrderType;

	public String getPdOrderType() {
		return pdOrderType;
	}

	public void setPdOrderType(String pdOrderType) {
		this.pdOrderType = pdOrderType;
	}

	public Long getPdOrderId() {
		return pdOrderId;
	}

	public void setPdOrderId(Long pdOrderId) {
		this.pdOrderId = pdOrderId;
	}

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

	public BigDecimal getPdAmount() {
		return pdAmount;
	}

	public void setPdAmount(BigDecimal pdAmount) {
		this.pdAmount = pdAmount;
	}

	public String getPdNo() {
		return pdNo;
	}

	public void setPdNo(String pdNo) {
		this.pdNo = pdNo;
	}

	public Integer getPdPayStatus() {
		return pdPayStatus;
	}

	public void setPdPayStatus(Integer pdPayStatus) {
		this.pdPayStatus = pdPayStatus;
	}

	public String getPdPayment() {
		return pdPayment;
	}

	public void setPdPayment(String pdPayment) {
		this.pdPayment = pdPayment;
	}

	public String getPdRemittanceBank() {
		return pdRemittanceBank;
	}

	public void setPdRemittanceBank(String pdRemittanceBank) {
		this.pdRemittanceBank = pdRemittanceBank;
	}

	public Date getPdRemittanceTime() {
		return pdRemittanceTime;
	}

	public void setPdRemittanceTime(Date pdRemittanceTime) {
		this.pdRemittanceTime = pdRemittanceTime;
	}

	public String getPdRemittanceUser() {
		return pdRemittanceUser;
	}

	public void setPdRemittanceUser(String pdRemittanceUser) {
		this.pdRemittanceUser = pdRemittanceUser;
	}

	public String getPdSn() {
		return pdSn;
	}

	public void setPdSn(String pdSn) {
		this.pdSn = pdSn;
	}

	public Integer getPdStatus() {
		return pdStatus;
	}

	public void setPdStatus(Integer pdStatus) {
		this.pdStatus = pdStatus;
	}

	public Long getPdAdminId() {
		return pdAdminId;
	}

	public void setPdAdminId(Long pdAdminId) {
		this.pdAdminId = pdAdminId;
	}

	public Long getPdUserId() {
		return pdUserId;
	}

	public void setPdUserId(Long pdUserId) {
		this.pdUserId = pdUserId;
	}

	public String getPdAdminInfo() {
		return pdAdminInfo;
	}

	public void setPdAdminInfo(String pdAdminInfo) {
		this.pdAdminInfo = pdAdminInfo;
	}

	public String getPdRemittanceInfo() {
		return pdRemittanceInfo;
	}

	public void setPdRemittanceInfo(String pdRemittanceInfo) {
		this.pdRemittanceInfo = pdRemittanceInfo;
	}
}