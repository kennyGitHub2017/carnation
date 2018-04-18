package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.LookInvitationBO;

public class MyselfInvitationResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("invitations")
	@ReturnMapping(desc = "圈子列表")
	private List<LookInvitationBO> invitations;

	@JsonProperty("totalCount")
	@ReturnMapping(desc = "总记录")
	private Long totalCount;

	public List<LookInvitationBO> getInvitations() {
		return invitations;
	}

	public void setInvitations(List<LookInvitationBO> invitations) {
		this.invitations = invitations;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

}
