package com.sinco.carnation.resource.vo.register;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class RegisterNicknameExistsVO extends BasicParamVO {

	@Param(desc = "昵称")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
