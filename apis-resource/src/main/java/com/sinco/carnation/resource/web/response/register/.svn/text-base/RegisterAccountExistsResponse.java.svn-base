package com.sinco.carnation.resource.web.response.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

/**
 * 
 * @author dengwei
 * @date 2014年6月17日 下午9:01:26
 * 
 */
public class RegisterAccountExistsResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7888111865985714186L;

	@JsonProperty("is_exists")
	@ReturnMapping(desc = "是否存在")
	private Boolean isExists;

	@JsonProperty("existsCode")
	@ReturnMapping(desc = "邀请码")
	private boolean existsCode;

	public Boolean getIsExists() {
		return isExists;
	}

	public void setIsExists(Boolean isExists) {
		this.isExists = isExists;
	}

	public boolean isExistsCode() {
		return existsCode;
	}

	public void setExistsCode(boolean existsCode) {
		this.existsCode = existsCode;
	}

}
