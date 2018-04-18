package com.sinco.carnation.resource.web.response.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

/**
 *
 *
 */
public class CodeSendIfMobileResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("isBinding")
	@ReturnMapping(desc = "是否是平台用户  是 true /不是 false")
	private Boolean isBinding;

	public Boolean getIsBinding() {
		return isBinding;
	}

	public void setIsBinding(Boolean isBinding) {
		this.isBinding = isBinding;
	}

}
