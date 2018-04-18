package com.sinco.carnation.resource.vo;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class HumanVO extends BasicParamVO {

	@Param(desc = "类型|0形体1症状")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer type;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
