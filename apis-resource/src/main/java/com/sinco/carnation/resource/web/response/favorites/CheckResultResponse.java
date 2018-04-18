package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.o2o.RecommendStoreBO;
import com.sinco.carnation.resource.bo.shop.RecommendGoodsBO;

public class CheckResultResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("groupId")
	@ReturnMapping(desc = "自测题套题ID")
	private Long groupId;

	@JsonProperty("checkResult")
	@ReturnMapping(desc = "自测题结果")
	private String checkResult;

	@JsonProperty("integral")
	@ReturnMapping(desc = "积分")
	private Integer integral;

	@JsonProperty("recommedGoodsList")
	@ReturnMapping(desc = "推荐的商品")
	private List<RecommendGoodsBO> recommedGoodsList;

	@JsonProperty("recommedStoreList")
	@ReturnMapping(desc = "推荐的店铺")
	private List<RecommendStoreBO> recommedStoreList;

	@JsonProperty("resultId")
	@ReturnMapping(desc = "测试id")
	private Long resultId;

	@JsonProperty("getDayIntegralFlag")
	@ReturnMapping(desc = "用户当天是否已获得自测题积分")
	private boolean getDayIntegralFlag;

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public List<RecommendGoodsBO> getRecommedGoodsList() {
		return recommedGoodsList;
	}

	public void setRecommedGoodsList(List<RecommendGoodsBO> recommedGoodsList) {
		this.recommedGoodsList = recommedGoodsList;
	}

	public List<RecommendStoreBO> getRecommedStoreList() {
		return recommedStoreList;
	}

	public void setRecommedStoreList(List<RecommendStoreBO> recommedStoreList) {
		this.recommedStoreList = recommedStoreList;
	}

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	public boolean isGetDayIntegralFlag() {
		return getDayIntegralFlag;
	}

	public void setGetDayIntegralFlag(boolean getDayIntegralFlag) {
		this.getDayIntegralFlag = getDayIntegralFlag;
	}

}
