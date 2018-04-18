package com.sinco.carnation.resource.web.response.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;
import com.sinco.carnation.resource.bo.UserIntegralDetailBO;

public class UserIntegralListResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("userIntegralDetailBO")
	@ReturnMapping(desc = "用户积分明细")
	private List<UserIntegralDetailBO> userIntegralList;

	@JsonProperty("userIntegralCount")
	@ReturnMapping(desc = "用户积分明细记录总数")
	private Long userIntegralCount;

	@JsonProperty("integralBalance")
	@ReturnMapping(desc = "用户积分总数")
	private Integer integralBalance;

	public List<UserIntegralDetailBO> getUserIntegralList() {
		return userIntegralList;
	}

	public void setUserIntegralList(List<UserIntegralDetailBO> userIntegralList) {
		this.userIntegralList = userIntegralList;
	}

	public Long getUserIntegralCount() {
		return userIntegralCount;
	}

	public void setUserIntegralCount(Long userIntegralCount) {
		this.userIntegralCount = userIntegralCount;
	}

	public Integer getIntegralBalance() {
		return integralBalance;
	}

	public void setIntegralBalance(Integer integralBalance) {
		this.integralBalance = integralBalance;
	}

}
