package com.sinco.carnation.resource.web.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;

public class InvitationUserResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("verfiySuccess")
	@ReturnMapping(desc = "是否邀请成功")
	private boolean verfiySuccess;

	public boolean isVerfiySuccess() {
		return verfiySuccess;
	}

	public void setVerfiySuccess(boolean verfiySuccess) {
		this.verfiySuccess = verfiySuccess;
	}

}
