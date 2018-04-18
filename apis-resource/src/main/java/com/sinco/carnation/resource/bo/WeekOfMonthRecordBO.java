package com.sinco.carnation.resource.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "WeekOfMonthRecordBO", desc = "每月中每周的统计记录|跑步|睡眠")
public class WeekOfMonthRecordBO {

	@JsonProperty("stepNumSumOfWeek")
	@FieldMapping(desc = "步数")
	private Integer stepNumSumOfWeek;

	@JsonProperty("totalKmSumOfWeek")
	@FieldMapping(desc = "里程")
	private Long totalKmSumOfWeek;

	@JsonProperty("caloriesSumOfWeek")
	@FieldMapping(desc = "卡路里")
	private Long caloriesSumOfWeek;

	/** 一周的睡眠时长 **/
	@JsonProperty("sleepSecondSumOfWeek")
	@FieldMapping(desc = "睡眠时长")
	private Integer sleepSecondSumOfWeek;

	/** 一周的深睡时长 **/
	@JsonProperty("deepSleepSecondSumOfWeek")
	@FieldMapping(desc = "深睡时长")
	private Integer deepSleepSecondSumOfWeek;

	/** 一周的浅睡时长 **/
	@JsonProperty("shallowSleepSecondSumOfWeek")
	@FieldMapping(desc = "浅睡时长 ")
	private Integer shallowSleepSecondSumOfWeek;

	public Integer getStepNumSumOfWeek() {
		return stepNumSumOfWeek;
	}

	public void setStepNumSumOfWeek(Integer stepNumSumOfWeek) {
		this.stepNumSumOfWeek = stepNumSumOfWeek;
	}

	public Long getTotalKmSumOfWeek() {
		return totalKmSumOfWeek;
	}

	public void setTotalKmSumOfWeek(Long totalKmSumOfWeek) {
		this.totalKmSumOfWeek = totalKmSumOfWeek;
	}

	public Long getCaloriesSumOfWeek() {
		return caloriesSumOfWeek;
	}

	public void setCaloriesSumOfWeek(Long caloriesSumOfWeek) {
		this.caloriesSumOfWeek = caloriesSumOfWeek;
	}

	public Integer getSleepSecondSumOfWeek() {
		return sleepSecondSumOfWeek;
	}

	public void setSleepSecondSumOfWeek(Integer sleepSecondSumOfWeek) {
		this.sleepSecondSumOfWeek = sleepSecondSumOfWeek;
	}

	public Integer getDeepSleepSecondSumOfWeek() {
		return deepSleepSecondSumOfWeek;
	}

	public void setDeepSleepSecondSumOfWeek(Integer deepSleepSecondSumOfWeek) {
		this.deepSleepSecondSumOfWeek = deepSleepSecondSumOfWeek;
	}

	public Integer getShallowSleepSecondSumOfWeek() {
		return shallowSleepSecondSumOfWeek;
	}

	public void setShallowSleepSecondSumOfWeek(Integer shallowSleepSecondSumOfWeek) {
		this.shallowSleepSecondSumOfWeek = shallowSleepSecondSumOfWeek;
	}

}
