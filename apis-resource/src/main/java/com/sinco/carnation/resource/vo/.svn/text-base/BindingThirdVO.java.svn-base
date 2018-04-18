package com.sinco.carnation.resource.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class BindingThirdVO extends BasicParamVO {

	@Param(desc = "第三方平台id 微信的unionID当成openId传过来")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String openId;

	@Param(desc = "token")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String token;

	@Param(desc = "类型|3:QQ 4:微信5:微博")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer type;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
