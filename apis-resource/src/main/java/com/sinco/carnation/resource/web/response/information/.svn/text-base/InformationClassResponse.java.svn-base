package com.sinco.carnation.resource.web.response.information;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.HumanBodyBO;
import com.sinco.carnation.resource.bo.InformationClassBO;

public class InformationClassResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("informationClasses")
	@ReturnMapping(desc = "资讯分类列表")
	private List<InformationClassBO> informationClasses;

	@JsonProperty("boyList")
	@ReturnMapping(desc = "男性部位列表")
	private List<HumanBodyBO> boyList;

	public List<InformationClassBO> getInformationClasses() {
		return informationClasses;
	}

	public void setInformationClasses(List<InformationClassBO> informationClasses) {
		this.informationClasses = informationClasses;
	}

	public List<HumanBodyBO> getBoyList() {
		return boyList;
	}

	public void setBoyList(List<HumanBodyBO> boyList) {
		this.boyList = boyList;
	}

}
