package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.PositionAdvertBO;

@SuppressWarnings("serial")
public class RecommendResponse extends ApiResponse {

	@JsonProperty("advList")
	@ReturnMapping(desc = "推荐位对应的所有推荐")
	private List<PositionAdvertBO> advList;

	public List<PositionAdvertBO> getAdvList() {
		return advList;
	}

	public void setAdvList(List<PositionAdvertBO> advList) {
		this.advList = advList;
	}
}
