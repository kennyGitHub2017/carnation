package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.UserConsultingListBO;

public class UserConsultingListResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("consultingResult")
	@ReturnMapping(desc = "用户咨询问题列表")
	private List<UserConsultingListBO> consultingResult;

	@JsonProperty("totalCount")
	@ReturnMapping(desc = "总记录")
	private Long totalCount;

	public List<UserConsultingListBO> getConsultingResult() {
		return consultingResult;
	}

	public void setConsultingResult(List<UserConsultingListBO> consultingResult) {
		this.consultingResult = consultingResult;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
