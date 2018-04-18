package com.sinco.carnation.resource.web.response.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.express.TransInfoBO;

public class ExpressTransViewResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5493638793227966000L;
	@JsonProperty("trans")
	@ReturnMapping(desc = "快递详情")
	private TransInfoBO trans;

	public TransInfoBO getTrans() {
		return trans;
	}

	public void setTrans(TransInfoBO trans) {
		this.trans = trans;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
