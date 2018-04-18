package com.sinco.carnation.resource.web.response.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

public class BaseResponse extends ApiResponse {

	private static final long serialVersionUID = -8046391931535394348L;

	@JsonProperty("result")
	@ReturnMapping(desc = "返回状态")
	private String result;

	@JsonProperty("content")
	@ReturnMapping(desc = "返回描述")
	private String content;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
