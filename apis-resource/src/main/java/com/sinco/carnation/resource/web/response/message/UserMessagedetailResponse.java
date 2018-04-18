package com.sinco.carnation.resource.web.response.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.message.APIMessageBO;

public class UserMessagedetailResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("message")
	@ReturnMapping(desc = "消息详情")
	private APIMessageBO message;

	public APIMessageBO getMessage() {
		return message;
	}

	public void setMessage(APIMessageBO message) {
		this.message = message;
	}

}
