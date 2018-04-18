package com.sinco.carnation.resource.vo.operator;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class UserCloudVO extends BasicParamVO {

	@Param(desc = "旧密码")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String oldPassword;

	@Param(desc = "新密码")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String newPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
