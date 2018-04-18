package com.sinco.carnation.resource.bo.check;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UserSign", desc = "用户签到")
public class UserSignBO {

	@JsonProperty("isSign")
	@FieldMapping(desc = "当天是否已签到|true已签到false签到成功返回签到积分和天数")
	private Boolean isSign;

	@JsonProperty("integral")
	@FieldMapping(desc = "签到所得积分")
	private Integer integral;

	@JsonProperty("day")
	@FieldMapping(desc = "连续签到几天")
	private Integer day;

	public Boolean getIsSign() {
		return isSign;
	}

	public void setIsSign(Boolean isSign) {
		this.isSign = isSign;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

}
