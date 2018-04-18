package com.sinco.carnation.resource.web.response.check;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.check.CheckReportBO;
import com.sinco.carnation.resource.bo.check.ResultDetailsBO;
import com.sinco.carnation.resource.bo.check.ResultGroupBO;
import com.sinco.carnation.resource.bo.check.ResultItemBO;

public class CheckReportResponse extends ApiResponse {

	private static final long serialVersionUID = 1L;

	@JsonProperty("circle")
	@ReturnMapping(desc = "我的体检报告")
	private List<CheckReportBO> circle;

	@JsonProperty("totalCount")
	@ReturnMapping(desc = "总记录")
	private Long totalCount;

	@JsonProperty("resultGroupBOs")
	@ReturnMapping(desc = "分类列表")
	private List<ResultGroupBO> resultGroupBOs;

	@JsonProperty("usingResultItemBOs")
	@ReturnMapping(desc = "常用体检项")
	private List<ResultItemBO> usingResultItemBOs;

	@JsonProperty("resultItemBOs")
	@ReturnMapping(desc = "体检项目")
	private List<ResultItemBO> resultItemBOs;

	@JsonProperty("resultItem")
	@ReturnMapping(desc = "体检项信息")
	private ResultItemBO resultItem;

	@JsonProperty("report")
	@ReturnMapping(desc = "添加体检报告")
	private CheckReportBO report;

	@JsonProperty("userDetails")
	@ReturnMapping(desc = "用户体检项信息")
	private ResultDetailsBO userDetails;

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public List<CheckReportBO> getCircle() {
		return circle;
	}

	public void setCircle(List<CheckReportBO> circle) {
		this.circle = circle;
	}

	public List<ResultGroupBO> getResultGroupBOs() {
		return resultGroupBOs;
	}

	public void setResultGroupBOs(List<ResultGroupBO> resultGroupBOs) {
		this.resultGroupBOs = resultGroupBOs;
	}

	public List<ResultItemBO> getUsingResultItemBOs() {
		return usingResultItemBOs;
	}

	public void setUsingResultItemBOs(List<ResultItemBO> usingResultItemBOs) {
		this.usingResultItemBOs = usingResultItemBOs;
	}

	public List<ResultItemBO> getResultItemBOs() {
		return resultItemBOs;
	}

	public void setResultItemBOs(List<ResultItemBO> resultItemBOs) {
		this.resultItemBOs = resultItemBOs;
	}

	public ResultItemBO getResultItem() {
		return resultItem;
	}

	public void setResultItem(ResultItemBO resultItem) {
		this.resultItem = resultItem;
	}

	public CheckReportBO getReport() {
		return report;
	}

	public void setReport(CheckReportBO report) {
		this.report = report;
	}

	public ResultDetailsBO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(ResultDetailsBO userDetails) {
		this.userDetails = userDetails;
	}

}
