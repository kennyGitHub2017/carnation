package com.sinco.carnation.resource.vo;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class BindingWeiXinCheckVO extends BasicParamVO {

	@Param(desc = "微信unionid")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String unionId;

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
}
