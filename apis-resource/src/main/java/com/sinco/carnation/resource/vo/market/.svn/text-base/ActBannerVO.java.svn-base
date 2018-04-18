package com.sinco.carnation.resource.vo.market;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ActBannerVO extends BasicPageParamVo {

	@Param(desc = "积分活动代码")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String actCode;

	public String getActCode() {
		return actCode;
	}

	public void setActCode(String actCode) {
		this.actCode = actCode;
	}

}
