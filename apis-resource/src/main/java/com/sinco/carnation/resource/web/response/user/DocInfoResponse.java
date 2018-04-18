package com.sinco.carnation.resource.web.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;

public class DocInfoResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("specContent")
	@ReturnMapping(desc = "积分|云豆规则说明")
	private String specContent;

	public String getSpecContent() {
		return specContent;
	}

	public void setSpecContent(String specContent) {
		this.specContent = specContent;
	}

}
