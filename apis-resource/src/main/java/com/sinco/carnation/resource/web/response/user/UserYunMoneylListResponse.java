package com.sinco.carnation.resource.web.response.user;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;
import com.sinco.carnation.resource.bo.UserYunMoneyBO;

public class UserYunMoneylListResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("UserYunMoneyBO")
	@ReturnMapping(desc = "用户云豆明细")
	private List<UserYunMoneyBO> userYunMoneyBOList;

	@JsonProperty("userYunMoneyCount")
	@ReturnMapping(desc = "用户云豆明细记录总数")
	private Long userYunMoneyCount;

	@JsonProperty("availableBalance")
	@ReturnMapping(desc = "用户云豆总数")
	private double availableBalance;

	@JsonProperty("listMap")
	@ReturnMapping(desc = "用户云豆明细")
	private Map<Integer, List<UserYunMoneyBO>> listMap;

	public List<UserYunMoneyBO> getUserYunMoneyBOList() {
		return userYunMoneyBOList;
	}

	public void setUserYunMoneyBOList(List<UserYunMoneyBO> userYunMoneyBOList) {
		this.userYunMoneyBOList = userYunMoneyBOList;
	}

	public Map<Integer, List<UserYunMoneyBO>> getListMap() {
		return listMap;
	}

	public void setListMap(Map<Integer, List<UserYunMoneyBO>> listMap) {
		this.listMap = listMap;
	}

	public Long getUserYunMoneyCount() {
		return userYunMoneyCount;
	}

	public void setUserYunMoneyCount(Long userYunMoneyCount) {
		this.userYunMoneyCount = userYunMoneyCount;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

}
