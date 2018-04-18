package com.sinco.carnation.resource.web.response.register;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.IntegerTodayBO;
import com.sinco.carnation.resource.bo.UserIntegralBO;

public class IntegerTodayResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("integral")
	@ReturnMapping(desc = "用户积分信息")
	private UserIntegralBO integral;

	@JsonProperty("integralToday")
	@ReturnMapping(desc = "用户今日积分任务情况")
	private List<IntegerTodayBO> integralToday;

	@JsonProperty("integralOther")
	@ReturnMapping(desc = "用户一次性积分任务情况")
	private List<IntegerTodayBO> integralOther;

	public UserIntegralBO getIntegral() {
		return integral;
	}

	public void setIntegral(UserIntegralBO integral) {
		this.integral = integral;
	}

	public List<IntegerTodayBO> getIntegralToday() {
		return integralToday;
	}

	public void setIntegralToday(List<IntegerTodayBO> integralToday) {
		this.integralToday = integralToday;
	}

	public List<IntegerTodayBO> getIntegralOther() {
		return integralOther;
	}

	public void setIntegralOther(List<IntegerTodayBO> integralOther) {
		this.integralOther = integralOther;
	}

}
