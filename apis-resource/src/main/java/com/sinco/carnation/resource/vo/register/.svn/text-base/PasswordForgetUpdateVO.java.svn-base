package com.sinco.carnation.resource.vo.register;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PasswordForgetUpdateVO extends BasicParamVO {

	@Param(desc = "登录用户名（手机号）|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String mobile;

	@Param(desc = "新密码|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String password;

	@Param(desc = "验证码|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String verifyCode;

	@Param(desc = "角色标识|可选")
	private String source;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}