package com.sinco.carnation.resource.web.response.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.shop.CloudPredepositCashBO;

public class CloudMoneyResponse extends ApiResponse {

	private static final long serialVersionUID = 1L;

	@ReturnMapping(desc = "提现对象")
	@JsonProperty("cloudPredepositCash")
	private CloudPredepositCashBO cloudPredepositCash;

	@ReturnMapping(desc = "登陆帐号")
	@JsonProperty("loginName")
	private String loginName;

	@ReturnMapping(desc = "云豆验证")
	@JsonProperty("ret")
	private boolean ret;

	public CloudPredepositCashBO getCloudPredepositCash() {
		return cloudPredepositCash;
	}

	public void setCloudPredepositCash(CloudPredepositCashBO cloudPredepositCash) {
		this.cloudPredepositCash = cloudPredepositCash;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public boolean isRet() {
		return ret;
	}

	public void setRet(boolean ret) {
		this.ret = ret;
	}

}
