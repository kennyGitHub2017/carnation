package com.sinco.carnation.resource.web.response.favorites;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.LookInvitationBO;

public class LookInvitationResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("invitation")
	@ReturnMapping(desc = "帖子信息")
	private LookInvitationBO invitation;

	public LookInvitationBO getInvitation() {
		return invitation;
	}

	public void setInvitation(LookInvitationBO invitation) {
		this.invitation = invitation;
	}

}
