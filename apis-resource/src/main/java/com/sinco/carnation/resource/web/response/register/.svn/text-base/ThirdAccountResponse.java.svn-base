package com.sinco.carnation.resource.web.response.register;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.APIAccountBO;

public class ThirdAccountResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4135955168866208334L;
	/**
	 * 
	 */
	@JsonProperty("accounts")
	@ReturnMapping(desc = "第三方帐号绑定的信息集合, 具体值的含义 3:QQ4:微信5:微博  ")
	private List<APIAccountBO> accounts;

	public List<APIAccountBO> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<APIAccountBO> accounts) {
		this.accounts = accounts;
	}
}
