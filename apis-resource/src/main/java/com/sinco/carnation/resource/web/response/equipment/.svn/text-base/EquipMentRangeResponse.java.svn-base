package com.sinco.carnation.resource.web.response.equipment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.StepRecordBO;

public class EquipMentRangeResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	public List<StepRecordBO> getRangeSteps() {
		return rangeSteps;
	}

	public void setRangeSteps(List<StepRecordBO> rangeSteps) {
		this.rangeSteps = rangeSteps;
	}

}
