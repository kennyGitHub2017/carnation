package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;
import com.sinco.carnation.resource.bo.ExpertsBO;

public class ExpertsResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("experts")
	@ReturnMapping(desc = "专家列表")
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

	@JsonProperty("expertsDetail")
	@ReturnMapping(desc = "专家详情")
	private ExpertsBO expertsDetail;

	public ExpertsBO getExpertsDetail() {
		return expertsDetail;
	}

	public void setExpertsDetail(ExpertsBO expertsDetail) {
		this.expertsDetail = expertsDetail;
	}

}
