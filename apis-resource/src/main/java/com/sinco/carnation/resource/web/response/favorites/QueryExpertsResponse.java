package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.ExpertsBO;

public class QueryExpertsResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("experts")
	@ReturnMapping(desc = "收藏的专家列表")
	private List<ExpertsBO> experts;

	@JsonProperty("totalCount")
	@ReturnMapping(desc = "总记录")
	private Long totalCount;

	public List<ExpertsBO> getExperts() {
		return experts;
	}

	public void setExperts(List<ExpertsBO> experts) {
		this.experts = experts;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
