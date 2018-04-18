package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.CircleListBO;

public class CircleListResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("circle")
	@ReturnMapping(desc = "圈子列表")
	private List<CircleListBO> circleListBOs;

	@JsonProperty("circleInfo")
	@ReturnMapping(desc = "圈子信息")
	private CircleListBO circleInfo;

	public List<CircleListBO> getCircleListBOs() {
		return circleListBOs;
	}

	public void setCircleListBOs(List<CircleListBO> circleListBOs) {
		this.circleListBOs = circleListBOs;
	}

	public CircleListBO getCircleInfo() {
		return circleInfo;
	}

	public void setCircleInfo(CircleListBO circleInfo) {
		this.circleInfo = circleInfo;
	}

}
