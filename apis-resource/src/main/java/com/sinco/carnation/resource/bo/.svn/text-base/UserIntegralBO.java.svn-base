package com.sinco.carnation.resource.bo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UserIntegral", desc = "用户积分|云豆")
public class UserIntegralBO {
	@JsonProperty("uid")
	@FieldMapping(desc = "用户id")
	private Long uid;

	@JsonProperty("freezeBlance")
	@FieldMapping(desc = "冻结余额 ")
	private BigDecimal freezeBlance;

	@JsonProperty("integral")
	@FieldMapping(desc = "用户积分")
	private Integer integral;

	/** 金币 **/
	@JsonProperty("gold")
	@FieldMapping(desc = "金币")
	private Integer gold;

	@JsonProperty("integralToday")
	@FieldMapping(desc = "用户今日已获取积分")
	private Integer integralToday;

	@JsonProperty("integralCeiling")
	@FieldMapping(desc = "用户今日剩余积分数")
	private Integer integralCeiling;

	public Long getUid() {
		return uid;
	}

	public BigDecimal getFreezeBlance() {
		return freezeBlance;
	}

	public Integer getIntegral() {
		return integral;
	}

	public Integer getGold() {
		return gold;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public void setFreezeBlance(BigDecimal freezeBlance) {
		this.freezeBlance = freezeBlance;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public Integer getIntegralToday() {
		return integralToday;
	}

	public void setIntegralToday(Integer integralToday) {
		this.integralToday = integralToday;
	}

	public Integer getIntegralCeiling() {
		return integralCeiling;
	}

	public void setIntegralCeiling(Integer integralCeiling) {
		this.integralCeiling = integralCeiling;
	}

}
