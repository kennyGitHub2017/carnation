package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ExpertsVO extends BasicPageParamVo {
	@Param(desc = "专家类型:1抗衰老专家，2健康管理师")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer experType;

	public Integer getExperType() {
		return experType;
	}

	public void setExperType(Integer experType) {
		this.experType = experType;
	}

}