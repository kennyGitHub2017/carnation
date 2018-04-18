package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.SleepRecordBO;

public class SleepRecordResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("sleepRecordBO")
	@ReturnMapping(desc = "睡眠信息")
	private SleepRecordBO sleepRecordBO;

	@JsonProperty("sleeps")
	@ReturnMapping(desc = "一周睡眠信息")
	private List<SleepRecordBO> sleeps;

	public SleepRecordBO getSleepRecordBO() {
		return sleepRecordBO;
	}

	public void setSleepRecordBO(SleepRecordBO sleepRecordBO) {
		this.sleepRecordBO = sleepRecordBO;
	}

	public List<SleepRecordBO> getSleeps() {
		return sleeps;
	}

	public void setSleeps(List<SleepRecordBO> sleeps) {
		this.sleeps = sleeps;
	}

}
