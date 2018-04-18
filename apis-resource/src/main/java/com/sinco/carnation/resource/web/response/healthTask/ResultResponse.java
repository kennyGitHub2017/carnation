package com.sinco.carnation.resource.web.response.healthTask;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

public class ResultResponse extends ApiResponse {

	private static final long serialVersionUID = -100119397440728456L;

	@JsonProperty("result")
	@ReturnMapping(desc = "返回结果 | succ failt")
	private String result;

	@JsonProperty("content")
	@ReturnMapping(desc = "返回内容")
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
