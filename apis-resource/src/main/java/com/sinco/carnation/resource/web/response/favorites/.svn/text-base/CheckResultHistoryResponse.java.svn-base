package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.CheckResultHistoryBO;

public class CheckResultHistoryResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("checkResults")
	@ReturnMapping(desc = "自测历史结果列表")
	private List<CheckResultHistoryBO> checkResults;

	@JsonProperty("totalCount")
	@ReturnMapping(desc = "总记录")
	private Long totalCount;

	public List<CheckResultHistoryBO> getCheckResults() {
		return checkResults;
	}

	public void setCheckResults(List<CheckResultHistoryBO> checkResults) {
		this.checkResults = checkResults;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
