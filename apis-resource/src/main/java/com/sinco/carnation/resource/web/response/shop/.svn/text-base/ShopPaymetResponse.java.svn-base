package com.sinco.carnation.resource.web.response.shop;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.paymet.WeiXinPaymetBO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

/**
 * 
 * @author james
 * 
 */
public class ShopPaymetResponse extends  BaseJsonResult{

	@JsonProperty("isCompletePay")
	@ReturnMapping(desc = "是否已经完成了支付")
	private Boolean isCompletePay;

	@JsonProperty("paymetType")
	@ReturnMapping(desc = "支付方式")
	private String paymetType;

	@JsonProperty("paySignature")
	@ReturnMapping(desc = "支付密文,支付宝用")
	private String paySignature;

	@JsonProperty("weiXinPaymet")
	@ReturnMapping(desc = "weixin 支付相关")
	private WeiXinPaymetBO weiXinPaymet;

	@JsonProperty("orderStatus")
	@ReturnMapping(desc = "订单状态")
	private Integer orderStatus;

	@JsonProperty("predepositId")
	@ReturnMapping(desc = "云豆充值id")
	private Long predepositId;

	@JsonProperty("pdAmount")
	@ReturnMapping(desc = "云豆充值金额")
	private BigDecimal pdAmount;

	@JsonProperty("addTime")
	@ReturnMapping(desc = "云豆创建时间")
	private Date addTime;

	@JsonProperty("cashBank")
	@ReturnMapping(desc = "收款银行")
	private String cashBank;

	@JsonProperty("cashAccount")
	@ReturnMapping(desc = "银行帐号")
	private String cashAccount;

	@JsonProperty("cashSubbranch")
	@ReturnMapping(desc = "银行支行")
	private String cashSubbranch;

	public String getCashAccount() {
		return cashAccount;
	}

	public void setCashAccount(String cashAccount) {
		this.cashAccount = cashAccount;
	}

	public String getCashBank() {
		return cashBank;
	}

	public void setCashBank(String cashBank) {
		this.cashBank = cashBank;
	}

	public String getCashSubbranch() {
		return cashSubbranch;
	}

	public void setCashSubbranch(String cashSubbranch) {
		this.cashSubbranch = cashSubbranch;
	}

	public BigDecimal getPdAmount() {
		return pdAmount;
	}

	public void setPdAmount(BigDecimal pdAmount) {
		this.pdAmount = pdAmount;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Long getPredepositId() {
		return predepositId;
	}

	public void setPredepositId(Long predepositId) {
		this.predepositId = predepositId;
	}

	public WeiXinPaymetBO getWeiXinPaymet() {
		return weiXinPaymet;
	}

	public void setWeiXinPaymet(WeiXinPaymetBO weiXinPaymet) {
		this.weiXinPaymet = weiXinPaymet;
	}

	public Boolean getIsCompletePay() {
		return isCompletePay;
	}

	public void setIsCompletePay(Boolean isCompletePay) {
		this.isCompletePay = isCompletePay;
	}

	public String getPaymetType() {
		return paymetType;
	}

	public void setPaymetType(String paymetType) {
		this.paymetType = paymetType;
	}

	public String getPaySignature() {
		return paySignature;
	}

	public void setPaySignature(String paySignature) {
		this.paySignature = paySignature;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
}
