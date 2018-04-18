package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.LookInvitationBO;

public class SearchInvitationResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("invitation")
	@ReturnMapping(desc = "帖子列表")
	private List<LookInvitationBO> invitation;

	@JsonProperty("total")
	@ReturnMapping(desc = "总记录")
	private Long total;

	@JsonProperty("times")
	@ReturnMapping(desc = "最后一条记录时间")
	private Long times;

	public List<LookInvitationBO> getInvitation() {
		return invitation;
	}

	public void setInvitation(List<LookInvitationBO> invitation) {
		this.invitation = invitation;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}

}
