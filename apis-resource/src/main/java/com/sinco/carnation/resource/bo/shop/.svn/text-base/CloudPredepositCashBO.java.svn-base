package com.sinco.carnation.resource.bo.shop;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "CloudForm", desc = "云豆")
public class CloudPredepositCashBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("addTime")
	@FieldMapping(desc = "创建时间")
	private Date addTime;

	@JsonProperty("deleteStatus")
	@FieldMapping(desc = "删除状态")
	private Boolean deleteStatus;

	@JsonProperty("cashAccount")
	@FieldMapping(desc = "收款账号")
	private String cashAccount;

	@JsonProperty("cashAmount")
	@FieldMapping(desc = "提现金额")
	private BigDecimal cashAmount;

	@JsonProperty("cashBank")
	@FieldMapping(desc = "收款银行")
	private String cashBank;

	@JsonProperty("cashPayStatus")
	@FieldMapping(desc = "收款支付状态，0为等待支付，1为支付完成 ")
	private Integer cashPayStatus;

	@JsonProperty("cashPayment")
	@FieldMapping(desc = "提现方式")
	private String cashPayment;

	@JsonProperty("cashSn")
	@FieldMapping(desc = "提现编号以cash开头")
	private String cashSn;

	@JsonProperty("cashStatus")
	@FieldMapping(desc = "提现状态 0为审核中，1为已经完成, -1为审核拒绝")
	private Integer cashStatus;

	@JsonProperty("cashUserName")
	@FieldMapping(desc = "收款人姓名")
	private String cashUserName;

	@JsonProperty("cashAdminId")
	@FieldMapping(desc = "充值请求处理的管理员 ")
	private Long cashAdminId;

	@JsonProperty("cashUserId")
	@FieldMapping(desc = "申请用户")
	private Long cashUserId;

	@JsonProperty("cashAdminInfo")
	@FieldMapping(desc = "请求处理备注")
	private String cashAdminInfo;

	@JsonProperty("cashInfo")
	@FieldMapping(desc = "提现备注")
	private String cashInfo;

	@JsonProperty("cashSubbranch")
	@FieldMapping(desc = "银行支行")
	private String cashSubbranch;

	@JsonProperty("cashRelation")
	@FieldMapping(desc = "提现类型0,web端1,APP端")
	private Integer cashRelation;

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

	public String getCashAccount() {
		return cashAccount;
	}

	public void setCashAccount(String cashAccount) {
		this.cashAccount = cashAccount;
	}

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public String getCashBank() {
		return cashBank;
	}

	public void setCashBank(String cashBank) {
		this.cashBank = cashBank;
	}

	public Integer getCashPayStatus() {
		return cashPayStatus;
	}

	public void setCashPayStatus(Integer cashPayStatus) {
		this.cashPayStatus = cashPayStatus;
	}

	public String getCashPayment() {
		return cashPayment;
	}

	public void setCashPayment(String cashPayment) {
		this.cashPayment = cashPayment;
	}

	public String getCashSn() {
		return cashSn;
	}

	public void setCashSn(String cashSn) {
		this.cashSn = cashSn;
	}

	public Integer getCashStatus() {
		return cashStatus;
	}

	public void setCashStatus(Integer cashStatus) {
		this.cashStatus = cashStatus;
	}

	public String getCashUserName() {
		return cashUserName;
	}

	public void setCashUserName(String cashUserName) {
		this.cashUserName = cashUserName;
	}

	public Long getCashAdminId() {
		return cashAdminId;
	}

	public void setCashAdminId(Long cashAdminId) {
		this.cashAdminId = cashAdminId;
	}

	public Long getCashUserId() {
		return cashUserId;
	}

	public void setCashUserId(Long cashUserId) {
		this.cashUserId = cashUserId;
	}

	public String getCashAdminInfo() {
		return cashAdminInfo;
	}

	public void setCashAdminInfo(String cashAdminInfo) {
		this.cashAdminInfo = cashAdminInfo;
	}

	public String getCashInfo() {
		return cashInfo;
	}

	public void setCashInfo(String cashInfo) {
		this.cashInfo = cashInfo;
	}
}