package com.sinco.carnation.resource.web.response.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.message.APIMessageBO;

public class UserMessageListResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("messages")
	@ReturnMapping(desc = "个人消息集合")
	private List<APIMessageBO> messages;

	@JsonProperty("unreadMessageNo")
	@ReturnMapping(desc = "未读消息数目")
	private int unreadMessageNo;

	@JsonProperty("readMessageNo")
	@ReturnMapping(desc = "已读消息数目")
	private int readMessageNo;

	public List<APIMessageBO> getMessages() {
		return messages;
	}

	public void setMessages(List<APIMessageBO> messages) {
		this.messages = messages;
	}

	public int getUnreadMessageNo() {
		return unreadMessageNo;
	}

	public void setUnreadMessageNo(int unreadMessageNo) {
		this.unreadMessageNo = unreadMessageNo;
	}

	public int getReadMessageNo() {
		return readMessageNo;
	}

	public void setReadMessageNo(int readMessageNo) {
		this.readMessageNo = readMessageNo;
	}

}
