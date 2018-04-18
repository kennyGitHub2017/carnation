package com.sinco.carnation.resource.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "IntegerTodayBO", desc = "用户今日可赚取积分")
public class IntegerTodayBO {
	@JsonProperty("today_times")
	@FieldMapping(desc = "今日完成次数")
	private int today_times;

	@JsonProperty("UFtimes")
	@FieldMapping(desc = "今日剩余次数")
	private int UFtimes;

	@JsonProperty("UF")
	@FieldMapping(desc = "今日完成情况")
	private int UF;

	@JsonProperty("name")
	@FieldMapping(desc = "积分名称")
	private String name;

	@JsonProperty("type")
	@FieldMapping(desc = "积分标识 ")
	private String type;

	@JsonProperty("timesLimitType")
	@FieldMapping(desc = "积分完成次数限制类型（1：无次数限制 2：总次数限制 3：日次数限制）")
	private Integer timesLimitType;

	@JsonProperty("times")
	@FieldMapping(desc = "完成次数限制")
	private Integer times;

	@JsonProperty("integral")
	@FieldMapping(desc = "积分数 ")
	private Integer integral;

	public int getToday_times() {
		return today_times;
	}

	public void setToday_times(int today_times) {
		this.today_times = today_times;
	}

	public int getUFtimes() {
		return UFtimes;
	}

	public void setUFtimes(int uFtimes) {
		UFtimes = uFtimes;
	}

	public int getUF() {
		return UF;
	}

	public void setUF(int uF) {
		UF = uF;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTimesLimitType() {
		return timesLimitType;
	}

	public void setTimesLimitType(Integer timesLimitType) {
		this.timesLimitType = timesLimitType;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

}
