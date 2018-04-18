package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.util.BasicPageResponse;
import com.sinco.carnation.resource.bo.LookInvitationBO;

public class CircleResponse extends BasicPageResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("circle")
	@ReturnMapping(desc = "圈子列表")
	private List<LookInvitationBO> circle;

	@JsonProperty("totalCount")
	@ReturnMapping(desc = "总记录")
	private Long totalCount;

	@JsonProperty("times")
	@ReturnMapping(desc = "最后一条记录时间")
	private Long times;

	public List<LookInvitationBO> getCircle() {
		return circle;
	}

	public void setCircle(List<LookInvitationBO> circle) {
		this.circle = circle;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}

}
