package com.sinco.carnation.resource.bo.operator;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "CashMoneyDetails", desc = "营运商提现明细")
public class CashMoneyDetailsBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("cashAmount")
	@FieldMapping(desc = "提现金额")
	private BigDecimal cashAmount;

	@JsonProperty("addTime")
	@FieldMapping(desc = "提现时间")
	private Date addTime;

	@JsonProperty("cashStatus")
	@FieldMapping(desc = "提现状态 0为审核中，1为已经完成 ")
	private Integer cashStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getCashStatus() {
		return cashStatus;
	}

	public void setCashStatus(Integer cashStatus) {
		this.cashStatus = cashStatus;
	}

}
