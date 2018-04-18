package com.sinco.carnation.resource.web.response.count;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

/**
 * 统计返回参数
 * 
 * @author Administrator
 * 
 */
public class CountResponse extends ApiResponse {

	private static final long serialVersionUID = 8424993033937849897L;

	@JsonProperty("userRegisterCount")
	@ReturnMapping(desc = "注册会员总数")
	private Long userRegisterCount;

	@JsonProperty("result")
	@ReturnMapping(desc = "返回标签")
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getUserRegisterCount() {
		return userRegisterCount;
	}

	public void setUserRegisterCount(Long userRegisterCount) {
		this.userRegisterCount = userRegisterCount;
	}

}
