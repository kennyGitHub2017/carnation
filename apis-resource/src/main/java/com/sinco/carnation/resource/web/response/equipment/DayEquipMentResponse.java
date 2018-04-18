package com.sinco.carnation.resource.web.response.equipment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.StepRecordBO;
import com.sinco.carnation.resource.bo.WeekOfMonthRecordBO;

public class DayEquipMentResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("stepNumber")
	@ReturnMapping(desc = "总步数")
	private Integer stepNumber;

	@JsonProperty("calories")
	@ReturnMapping(desc = "卡路里")
	private Long calories;

	@JsonProperty("distance")
	@ReturnMapping(desc = "总里程")
	private double distance;

	@JsonProperty("weekStep")
	@ReturnMapping(desc = "一周数据")
	private List<StepRecordBO> weekStep;

	@JsonProperty("weekOfMonDataList")
	@ReturnMapping(desc = "月中的周数据")
	private List<WeekOfMonthRecordBO> weekOfMonDataList;

	@JsonProperty("totalStepNumber")
	@ReturnMapping(desc = "日期范围内的总步数记录")
	private Integer totalStepNumber;

	@JsonProperty("totalCalories")
	@ReturnMapping(desc = "日期范围内的总卡路里记录")
	private Long totalCalories;

	@JsonProperty("totalDistance")
	@ReturnMapping(desc = "日期范围内的总里程记录")
	private Float totalDistance;

	@JsonProperty("rangeSteps")
	@ReturnMapping(desc = "范围期间的记录")
	private List<StepRecordBO> rangeSteps;

	@JsonProperty("monthRecordList")
	@ReturnMapping(desc = "一年中个月的统计记录")
	private List<StepRecordBO> monthRecordList;

	public Integer getStepNumber() {
		return stepNumber;
	}

	public void setStepNumber(Integer stepNumber) {
		this.stepNumber = stepNumber;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(Long calories) {
		this.calories = calories;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public List<StepRecordBO> getWeekStep() {
		return weekStep;
	}

	public void setWeekStep(List<StepRecordBO> weekStep) {
		this.weekStep = weekStep;
	}

	public Integer getTotalStepNumber() {
		return totalStepNumber;
	}

	public void setTotalStepNumber(Integer totalStepNumber) {
		this.totalStepNumber = totalStepNumber;
	}

	public Long getTotalCalories() {
		return totalCalories;
	}

	public void setTotalCalories(Long totalCalories) {
		this.totalCalories = totalCalories;
	}

	public Float getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(Float totalDistance) {
		this.totalDistance = totalDistance;
	}

	public List<WeekOfMonthRecordBO> getWeekOfMonDataList() {
		return weekOfMonDataList;
	}

	public void setWeekOfMonDataList(List<WeekOfMonthRecordBO> weekOfMonDataList) {
		this.weekOfMonDataList = weekOfMonDataList;
	}

	public List<StepRecordBO> getRangeSteps() {
		return rangeSteps;
	}

	public void setRangeSteps(List<StepRecordBO> rangeSteps) {
		this.rangeSteps = rangeSteps;
	}

	public List<StepRecordBO> getMonthRecordList() {
		return monthRecordList;
	}

	public void setMonthRecordList(List<StepRecordBO> monthRecordList) {
		this.monthRecordList = monthRecordList;
	}

}
