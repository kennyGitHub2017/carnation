package com.sinco.carnation.resource.bo.o2o;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UPrepositLog", desc = "提现记录")
public class UPrepositCashBO {

	@JsonProperty("addTime")
	@FieldMapping(desc = "提现时间")
	private Date addTime;

	@JsonProperty("cashAmount")
	@FieldMapping(desc = "提现金额")
	private BigDecimal cashAmount;

	@JsonProperty("cashStatus")
	@FieldMapping(desc = "提现状态 0为审核中，1为已经完成")
	private Integer cashStatus;

	@JsonProperty("cashAdminInfo")
	@FieldMapping(desc = "管理员操作备注|拒绝审核原因")
	private String cashAdminInfo;

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public Integer getCashStatus() {
		return cashStatus;
	}

	public void setCashStatus(Integer cashStatus) {
		this.cashStatus = cashStatus;
	}

	public String getCashAdminInfo() {
		return cashAdminInfo;
	}

	public void setCashAdminInfo(String cashAdminInfo) {
		this.cashAdminInfo = cashAdminInfo;
	}

}
