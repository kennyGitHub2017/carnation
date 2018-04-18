package com.sinco.carnation.resource.vo.register;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class RegisterThirdAccountVO extends BasicParamVO {

	@Param(desc = "用户名")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String longName;

	@Param(desc = "用户类型 3:QQ ，4：微信，5:微博")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String loginType;

	@Param(desc = "用户昵称")
	private String nickName;

	public String getLongName() {
		return longName;
	}

	public String getLoginType() {
		return loginType;
	}

	public String getNickName() {
		return nickName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
