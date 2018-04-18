package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.ReplyBO;

public class ReplyListResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("replyList")
	@ReturnMapping(desc = "回复列表")
	private List<ReplyBO> replyList;

	public List<ReplyBO> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyBO> replyList) {
		this.replyList = replyList;
	}
}
