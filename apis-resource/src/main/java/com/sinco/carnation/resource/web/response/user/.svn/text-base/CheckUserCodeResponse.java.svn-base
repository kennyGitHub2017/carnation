package com.sinco.carnation.resource.web.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;

public class CheckUserCodeResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("isExist")
	@ReturnMapping(desc = "是否邀请过")
	private boolean isExist;

	@JsonProperty("invitationCode")
	@ReturnMapping(desc = "是否邀请成功")
	private String invitationCode;

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

}
