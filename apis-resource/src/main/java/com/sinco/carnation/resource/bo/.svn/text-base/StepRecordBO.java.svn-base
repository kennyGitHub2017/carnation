package com.sinco.carnation.resource.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "StepRecordBO", desc = "步数")
public class StepRecordBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("uid")
	@FieldMapping(desc = "用户id")
	private Long uid;

	@JsonProperty("stepNumber")
	@FieldMapping(desc = "步数")
	private Integer stepNumber;

	@JsonProperty("recordDate")
	@FieldMapping(desc = "时间")
	private Date recordDate;

	@JsonProperty("totalKm")
	@FieldMapping(desc = "里程")
	private Float totalKm;

	@JsonProperty("calories")
	@FieldMapping(desc = "卡路里")
	private Long calories;

	@JsonProperty("week")
	@FieldMapping(desc = "星期")
	private Integer week;

	@JsonProperty("startDate")
	@FieldMapping(desc = "开始时间")
	private String startDate;

	@JsonProperty("endDate")
	@FieldMapping(desc = "结束时间")
	private String endDate;

	@JsonProperty("stepTotalMonth")
	@FieldMapping(desc = "步数月统计记录")
	private Integer stepTotalMonth;

	@JsonProperty("kmTotalMonth")
	@FieldMapping(desc = "里程月统计记录")
	private Float kmTotalMonth;

	@JsonProperty("calTotalMonth")
	@FieldMapping(desc = "卡路里月月记录")
	private Long calTotalMonth;

	@JsonProperty("month")
	@FieldMapping(desc = "月份")
	private Integer month;

	public Long getId() {
		return id;
	}

	public Long getUid() {
		return uid;
	}

	public Integer getStepNumber() {
		return stepNumber;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public Float getTotalKm() {
		return totalKm;
	}

	public Long getCalories() {
		return calories;
	}

	public Integer getWeek() {
		return week;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public void setStepNumber(Integer stepNumber) {
		this.stepNumber = stepNumber;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public void setTotalKm(Float totalKm) {
		this.totalKm = totalKm;
	}

	public void setCalories(Long calories) {
		this.calories = calories;
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

	public Integer getStepTotalMonth() {
		return stepTotalMonth;
	}

	public void setStepTotalMonth(Integer stepTotalMonth) {
		this.stepTotalMonth = stepTotalMonth;
	}

	public Float getKmTotalMonth() {
		return kmTotalMonth;
	}

	public void setKmTotalMonth(Float kmTotalMonth) {
		this.kmTotalMonth = kmTotalMonth;
	}

	public Long getCalTotalMonth() {
		return calTotalMonth;
	}

	public void setCalTotalMonth(Long calTotalMonth) {
		this.calTotalMonth = calTotalMonth;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

}
