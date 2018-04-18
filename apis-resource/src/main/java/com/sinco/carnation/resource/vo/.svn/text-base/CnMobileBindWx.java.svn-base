package com.sinco.carnation.resource.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

public class CnMobileBindWx extends ApiResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("binding")
	@ReturnMapping(desc = "判断是否绑定，0未绑定，1已绑定 0|1")
	private int binding;

	@JsonProperty("unionID")
	@ReturnMapping(desc = "微信unionID")
	private String unionID;

	public String getUnionID() {
		return unionID;
	}

	public void setUnionID(String unionID) {
		this.unionID = unionID;
	}

	public int getBinding() {
		return binding;
	}

	public void setBinding(int binding) {
		this.binding = binding;
	}
}
