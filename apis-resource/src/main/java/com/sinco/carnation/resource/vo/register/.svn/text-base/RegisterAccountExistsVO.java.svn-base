package com.sinco.carnation.resource.vo.register;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class RegisterAccountExistsVO extends BasicParamVO {

	/**
	 * 账号
	 */

	@Param(desc = "账号|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String loginName;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}
