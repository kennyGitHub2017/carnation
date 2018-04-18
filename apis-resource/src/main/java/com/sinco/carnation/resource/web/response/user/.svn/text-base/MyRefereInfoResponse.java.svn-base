package com.sinco.carnation.resource.web.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;

public class MyRefereInfoResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("userId")
	@ReturnMapping(desc = "用户id")
	private Long userId;

	@JsonProperty("nickName")
	@ReturnMapping(desc = "用户昵称")
	private String nickName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
