package com.sinco.carnation.resource.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class BindingRegisterVO extends BasicParamVO {

	@Param(desc = "手机号码")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	@Pattern(regexp = "^((13[0-9])|(14[0-9])|(15([0-9]))|(17([0-9]))|(18[0-9]))\\d{8}$")
	private String mobile;

	@Param(desc = "用户昵称")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String nickName;

	@Param(desc = "密码")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String password;

	@Param(desc = "邀请码")
	private String InvitationCode;

	@Param(desc = "第三方平台id")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String openId;

	@Param(desc = "平台unionid")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String unionId;

	@Param(desc = "token")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String token;

	@Param(desc = "类型|3:QQ 4:微信5:微博")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer type;

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInvitationCode() {
		return InvitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		InvitationCode = invitationCode;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
