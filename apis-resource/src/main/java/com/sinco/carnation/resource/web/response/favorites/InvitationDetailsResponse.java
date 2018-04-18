package com.sinco.carnation.resource.web.response.favorites;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.Param;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

public class InvitationDetailsResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@ReturnMapping(desc = "帖子id")
	private Long id;

	@JsonProperty("thumbnail")
	@ReturnMapping(desc = "帖子图片")
	private String thumbnail;

	@JsonProperty("content")
	@ReturnMapping(desc = "帖子内容")
	private String content;

	@JsonProperty("jgAppType")
	@ReturnMapping(desc = "app分享类型(1：android ,2 ： ios)")
	private int jgAppType;

	@Param(desc = "分享人邀请码信息")
	private String invitationCode;

	public String getThumbnail() {
		return thumbnail;
	}

	public String getContent() {
		return content;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getJgAppType() {
		return jgAppType;
	}

	public void setJgAppType(int jgAppType) {
		this.jgAppType = jgAppType;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

}
