package com.sinco.carnation.resource.vo.register;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class RegisterUsersCreateVO extends BasicParamVO {

	@Param(desc = "昵称")
	// @NotBlank(message=MsgCodeConstant.ERROR_PARAM)
	private String nickname;

	@Param(desc = "验证码|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String verifyCode;

	@Param(desc = "手机|必须")
	@Pattern(regexp = "^((13[0-9])|(14[0-9])|(15([0-9]))|(17([0-9]))|(18[0-9]))\\d{8}$")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String mobile;

	@Param(desc = "密码|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String password;

	@Param(desc = "邀请码")
	private String invitationCode;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

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

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
}
