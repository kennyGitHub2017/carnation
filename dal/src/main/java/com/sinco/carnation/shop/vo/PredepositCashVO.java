package com.sinco.carnation.shop.vo;

public class PredepositCashVO{

	private Double cashAmount;

	private String cashPayment;

	private String cashUserName;

	private String cashBank;

	private String cashAccount;

	private String cashPassword;

	private String cashInfo;

	private Integer userType;
	
	private String endTime;
	
	private String beginTime;

	/** 银行支行 **/
	private String cashSubbranch;

	/** 提现类型0,web端1,APP端 **/
	private Integer cashRelation;
	
	/** 用户角色标识 0.个人 1.供应商 2.商户 3.运营商 **/
	private Integer userCode;
	
	/** 申请用户 **/
	private Long cashUserId;
	
	/** 提现状态 0为审核中，1为已经完成, -1为审核拒绝 **/
	private Integer cashStatus;
	
	/** 提现类型  0免费提现 1.所有提现**/
	private int cashType;

	public String getCashSubbranch() {
		return cashSubbranch;
	}

	public void setCashSubbranch(String cashSubbranch) {
		this.cashSubbranch = cashSubbranch;
	}

	public Integer getCashRelation() {
		return cashRelation;
	}

	public void setCashRelation(Integer cashRelation) {
		this.cashRelation = cashRelation;
	}

	public Double getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public String getCashPayment() {
		return cashPayment;
	}

	public void setCashPayment(String cashPayment) {
		this.cashPayment = cashPayment;
	}

	public String getCashUserName() {
		return cashUserName;
	}

	public void setCashUserName(String cashUserName) {
		this.cashUserName = cashUserName;
	}

	public String getCashBank() {
		return cashBank;
	}

	public void setCashBank(String cashBank) {
		this.cashBank = cashBank;
	}

	public String getCashAccount() {
		return cashAccount;
	}

	public void setCashAccount(String cashAccount) {
		this.cashAccount = cashAccount;
	}

	public String getCashPassword() {
		return cashPassword;
	}

	public void setCashPassword(String cashPassword) {
		this.cashPassword = cashPassword;
	}

	public String getCashInfo() {
		return cashInfo;
	}

	public void setCashInfo(String cashInfo) {
		this.cashInfo = cashInfo;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getUserCode() {
		return userCode;
	}

	public void setUserCode(Integer userCode) {
		this.userCode = userCode;
	}

	public Long getCashUserId() {
		return cashUserId;
	}

	public void setCashUserId(Long cashUserId) {
		this.cashUserId = cashUserId;
	}

	public Integer getCashStatus() {
		return cashStatus;
	}

	public void setCashStatus(Integer cashStatus) {
		this.cashStatus = cashStatus;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public int getCashType() {
		return cashType;
	}

	public void setCashType(int cashType) {
		this.cashType = cashType;
	}

}