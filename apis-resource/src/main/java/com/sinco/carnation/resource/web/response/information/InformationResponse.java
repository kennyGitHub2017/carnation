package com.sinco.carnation.resource.web.response.information;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.InformationBO;

public class InformationResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("informations")
	@ReturnMapping(desc = "文章列表")
	private List<InformationBO> informations;

	@JsonProperty("totalCount")
	@ReturnMapping(desc = "总记录")
	private Long totalCount;

	public List<InformationBO> getInformations() {
		return informations;
	}

	public void setInformations(List<InformationBO> informations) {
		this.informations = informations;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
