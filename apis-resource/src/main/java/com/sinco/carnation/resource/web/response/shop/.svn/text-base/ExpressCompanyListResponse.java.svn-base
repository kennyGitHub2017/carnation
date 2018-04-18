package com.sinco.carnation.resource.web.response.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.express.ExpressCompanyBO;

public class ExpressCompanyListResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5493638793227966000L;
	@JsonProperty("list")
	@ReturnMapping(desc = "快递公司列表")
	private List<ExpressCompanyBO> list;

	public List<ExpressCompanyBO> getList() {
		return list;
	}

	public void setList(List<ExpressCompanyBO> list) {
		this.list = list;
	}
}
