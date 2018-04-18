package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.CheckGroupBO;

public class CheckGroupResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("checkGruops")
	@ReturnMapping(desc = "自测题列表")
	private List<CheckGroupBO> checkGruops;

	@JsonProperty("totalCount")
	@ReturnMapping(desc = "总记录")
	private Long totalCount;

	public List<CheckGroupBO> getCheckGruops() {
		return checkGruops;
	}

	public void setCheckGruops(List<CheckGroupBO> checkGruops) {
		this.checkGruops = checkGruops;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
