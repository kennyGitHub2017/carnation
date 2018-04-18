package com.sinco.carnation.resource.bo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UserYunMoneyBO", desc = "用户积分|云豆明细")
public class UserYunMoneyBO {

	@JsonProperty("pdOpType")
	@FieldMapping(desc = "操作类型，分为充值、提现、消费、兑换金币、人工操作")
	private String pdOpType;

	@JsonProperty("addTime")
	@FieldMapping(desc = "添加时间")
	private Date addTime;

	@JsonProperty("pdLogAmount")
	@FieldMapping(desc = "金额")
	private BigDecimal pdLogAmount;

	@JsonProperty("pdLogInfo")
	@FieldMapping(desc = "云豆详情描述")
	private String pdLogInfo;

	@JsonProperty("balance")
	@FieldMapping(desc = "云豆余额")
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPdOpType() {
		return pdOpType;
	}

	public void setPdOpType(String pdOpType) {
		this.pdOpType = pdOpType;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public BigDecimal getPdLogAmount() {
		return pdLogAmount;
	}

	public void setPdLogAmount(BigDecimal pdLogAmount) {
		this.pdLogAmount = pdLogAmount;
	}

	public String getPdLogInfo() {
		return pdLogInfo;
	}

	public void setPdLogInfo(String pdLogInfo) {
		this.pdLogInfo = pdLogInfo;
	}

}
