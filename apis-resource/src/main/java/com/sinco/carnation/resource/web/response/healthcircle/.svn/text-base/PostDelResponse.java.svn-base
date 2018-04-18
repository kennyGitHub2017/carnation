package com.sinco.carnation.resource.web.response.healthcircle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;

public class PostDelResponse extends ApiResponse implements Utf8mb4ToJson {

	private static final long serialVersionUID = 1L;
	@JsonProperty("isdelete")
	@ReturnMapping(desc = "删除标志")
	private Integer isdelete;

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

}
