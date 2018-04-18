package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.FoodClassBO;

public class InvitationExtendResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@ReturnMapping(desc = "帖子id")
	private Long id;

	@JsonProperty("isPraise")
	@ReturnMapping(desc = "是否点赞信息")
	private boolean isPraise;

	@JsonProperty("isFavorites")
	@ReturnMapping(desc = "是否收藏信息")
	private boolean isFavorites;

	@JsonProperty("reportList")
	@ReturnMapping(desc = "举报类型列表|以逗号隔开,")
	private String reportList;

	@JsonProperty("flag")
	@ReturnMapping(desc = "是否举报成功")
	private Boolean flag;

	@JsonProperty("foodClassList")
	@ReturnMapping(desc = "食物分类列表")
	private List<FoodClassBO> foodClassList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPraise() {
		return isPraise;
	}

	public void setPraise(boolean isPraise) {
		this.isPraise = isPraise;
	}

	public boolean isFavorites() {
		return isFavorites;
	}

	public void setFavorites(boolean isFavorites) {
		this.isFavorites = isFavorites;
	}

	public String getReportList() {
		return reportList;
	}

	public void setReportList(String reportList) {
		this.reportList = reportList;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public List<FoodClassBO> getFoodClassList() {
		return foodClassList;
	}

	public void setFoodClassList(List<FoodClassBO> foodClassList) {
		this.foodClassList = foodClassList;
	}

}
