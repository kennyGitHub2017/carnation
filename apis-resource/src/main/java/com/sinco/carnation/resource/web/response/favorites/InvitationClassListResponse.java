package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.InvitationClassBO;

public class InvitationClassListResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("invitationClasses")
	@ReturnMapping(desc = "帖子分类列表")
	private List<InvitationClassBO> invitationClasses;

	public List<InvitationClassBO> getInvitationClasses() {
		return invitationClasses;
	}

	public void setInvitationClasses(List<InvitationClassBO> invitationClasses) {
		this.invitationClasses = invitationClasses;
	}

}
