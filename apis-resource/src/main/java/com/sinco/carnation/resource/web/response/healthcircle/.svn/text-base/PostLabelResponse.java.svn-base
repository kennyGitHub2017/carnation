package com.sinco.carnation.resource.web.response.healthcircle;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.healthcircle.healthLabelBO;

public class PostLabelResponse extends ApiResponse {

	private static final long serialVersionUID = 1L;
	@JsonProperty("labelList")
	@ReturnMapping(desc = "标签列表")
	private List<healthLabelBO> labellist;

	public List<healthLabelBO> getLabellist() {
		return labellist;
	}

	public void setLabellist(List<healthLabelBO> labellist) {
		this.labellist = labellist;
	}

	@JsonProperty("labelBO")
	@ReturnMapping(desc = "标签对象")
	private healthLabelBO labelBO;

	public healthLabelBO getLabelBO() {
		return labelBO;
	}

	public void setLabelBO(healthLabelBO labelBO) {
		this.labelBO = labelBO;
	}

}
