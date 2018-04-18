package com.sinco.carnation.resource.web.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

public class MoneyFreePoundageResponse extends ApiResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("freePoundage")
	@ReturnMapping(desc = "剩余免费额度")
	private double freePoundage;
	
	@JsonProperty("line")
	@ReturnMapping(desc = "当月提现次数")
	private int line;

	public double getFreePoundage() {
		return freePoundage;
	}

	public void setFreePoundage(double freePoundage) {
		this.freePoundage = freePoundage;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

}
