package com.sinco.carnation.resource.web.response.favorites;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;

public class AddInvitationResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@ReturnMapping(desc = "帖子ID")
	private Long id;

	@JsonProperty("uid")
	@ReturnMapping(desc = "用户ID")
	private Long uid;

	@JsonProperty("title")
	@ReturnMapping(desc = "帖子标题")
	private String title;

	@JsonProperty("userName")
	@ReturnMapping(desc = "用户昵称")
	private String userName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
