package com.sinco.carnation.resource.web.response.groupComplaint;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.util.BasicPageResponse;
import com.sinco.carnation.resource.bo.groupComplaint.GroupComplaintsBO;

public class GroupComplaintResponse extends BasicPageResponse {

	private static final long serialVersionUID = 1L;

	@JsonProperty("totalCount")
	@ReturnMapping(desc = "总记录")
	private Long totalCount;

	@JsonProperty("groupComplaintBOs")
	@ReturnMapping(desc = "投诉列表")
	private List<GroupComplaintsBO> groupComplaintBOs;

	@JsonProperty("groupComplaintsBO")
	@ReturnMapping(desc = "投诉详情")
	private GroupComplaintsBO groupComplaintsBO;

	public List<GroupComplaintsBO> getGroupComplaintBOs() {
		return groupComplaintBOs;
	}

	public void setGroupComplaintBOs(List<GroupComplaintsBO> groupComplaintBOs) {
		this.groupComplaintBOs = groupComplaintBOs;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public GroupComplaintsBO getGroupComplaintsBO() {
		return groupComplaintsBO;
	}

	public void setGroupComplaintsBO(GroupComplaintsBO groupComplaintsBO) {
		this.groupComplaintsBO = groupComplaintsBO;
	}

}
