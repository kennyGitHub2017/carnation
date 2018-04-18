package com.sinco.carnation.resource.vo.register;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PasswordUpdateVO extends BasicParamVO {

	@Param(desc = "旧密码|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String odlPassword;

	@Param(desc = "新密码|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String newPassword;

	public String getOdlPassword() {
		return odlPassword;
	}

	public void setOdlPassword(String odlPassword) {
		this.odlPassword = odlPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
