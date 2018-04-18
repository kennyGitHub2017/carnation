package com.sinco.carnation.resource.vo;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class NoticesVO extends BasicPageParamVo {

	@Param(desc = "类型|0营运商公告1平台公告")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer type;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
