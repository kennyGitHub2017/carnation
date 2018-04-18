package com.sinco.carnation.resource.web.response.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

public class CnBindMobileResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	@JsonProperty("isBindMobile")
	@ReturnMapping(desc = "Cn账号是否绑定手机账号")
	private Boolean isBindMobile;

	@JsonProperty("isCn")
	@ReturnMapping(desc = "是否是CN账号")
	private Boolean isCn;

	@JsonProperty("isLogin")
	@ReturnMapping(desc = "是否需要重新登录标识")
	private Boolean isLogin;

	@JsonProperty("mobile")
	@ReturnMapping(desc = "已绑定的手机号")
	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Boolean getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}

	public Boolean getIsCn() {
		return isCn;
	}

	public void setIsCn(Boolean isCn) {
		this.isCn = isCn;
	}

	public Boolean getIsBindMobile() {
		return isBindMobile;
	}

	public void setIsBindMobile(Boolean isBindMobile) {
		this.isBindMobile = isBindMobile;
	}
}
