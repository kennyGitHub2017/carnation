package com.sinco.carnation.resource.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "SleepRecord", desc = "睡眠")
public class SleepRecordBO {

	/** id **/
	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	/** 用户id **/
	@JsonProperty("uid")
	@FieldMapping(desc = "用户id")
	private Long uid;

	/** 睡眠时长 **/
	@JsonProperty("sleepSecond")
	@FieldMapping(desc = "睡眠时长")
	private Integer sleepSecond;

	/** 深睡时长 **/
	@JsonProperty("deepSleepSecond")
	@FieldMapping(desc = "深睡时长")
	private Integer deepSleepSecond;

	/** 浅睡时长 **/
	@JsonProperty("shallowSleepSecond")
	@FieldMapping(desc = "浅睡时长 ")
	private Integer shallowSleepSecond;

	@JsonProperty("week")
	@FieldMapping(desc = "星期 ")
	private Integer week;

	@JsonProperty("startDate")
	@FieldMapping(desc = "开始日期|yyyy/MM/dd")
	private String startDate;

	@JsonProperty("endDate")
	@FieldMapping(desc = "结束日期 |yyyy/MM/dd")
	private String endDate;

	public Long getId() {
		return id;
	}

	public Long getUid() {
		return uid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Integer getSleepSecond() {
		return sleepSecond;
	}

	public Integer getDeepSleepSecond() {
		return deepSleepSecond;
	}

	public Integer getShallowSleepSecond() {
		return shallowSleepSecond;
	}

	public void setSleepSecond(Integer sleepSecond) {
		this.sleepSecond = sleepSecond;
	}

	public void setDeepSleepSecond(Integer deepSleepSecond) {
		this.deepSleepSecond = deepSleepSecond;
	}

	public void setShallowSleepSecond(Integer shallowSleepSecond) {
		this.shallowSleepSecond = shallowSleepSecond;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
