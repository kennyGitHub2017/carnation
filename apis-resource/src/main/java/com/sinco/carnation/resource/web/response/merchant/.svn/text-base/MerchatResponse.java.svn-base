package com.sinco.carnation.resource.web.response.merchant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

public class MerchatResponse extends ApiResponse{

	private static final long serialVersionUID = -57778270275289025L;

	@JsonProperty("result")
	@ReturnMapping(desc = "返回状态：200：成功   500：失败")
	private Integer result;
	
	@JsonProperty("content")
	@ReturnMapping(desc = "状态描述")
	private String content;

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
