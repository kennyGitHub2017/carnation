package com.sinco.carnation.resource.bo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UserYunGouMoney", desc = "云购币明细")
public class UserYunGouMoneyBO {

	@JsonProperty("dateTime")
	@FieldMapping(desc = "添加时间")
	private Date dateTime;

	@JsonProperty("type")
	@FieldMapping(desc = "0购物 1 退款")
	private Integer type;

	@JsonProperty("payType")
	@FieldMapping(desc = "1奖金 3云购币")
	private Integer payType;

	@JsonProperty("usedRepeatMoney")
	@FieldMapping(desc = "使用的云购币")
	private BigDecimal usedRepeatMoney;

	@JsonProperty("usedBonusPrice")
	@FieldMapping(desc = "使用的奖金")
	private BigDecimal usedBonusPrice;

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public BigDecimal getUsedRepeatMoney() {
		return usedRepeatMoney;
	}

	public void setUsedRepeatMoney(BigDecimal usedRepeatMoney) {
		this.usedRepeatMoney = usedRepeatMoney;
	}

	public BigDecimal getUsedBonusPrice() {
		return usedBonusPrice;
	}

	public void setUsedBonusPrice(BigDecimal usedBonusPrice) {
		this.usedBonusPrice = usedBonusPrice;
	}

}
