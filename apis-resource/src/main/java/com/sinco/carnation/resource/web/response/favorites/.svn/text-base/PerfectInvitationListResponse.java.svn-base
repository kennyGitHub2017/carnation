package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.LookInvitationBO;

public class PerfectInvitationListResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("circle")
	@ReturnMapping(desc = "推荐帖子列表")
	private List<LookInvitationBO> circle;

	public List<LookInvitationBO> getCircle() {
		return circle;
	}

	public void setCircle(List<LookInvitationBO> circle) {
		this.circle = circle;
	}

}
