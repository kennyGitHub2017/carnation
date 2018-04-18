package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class QueryExpertsVO extends BasicPageParamVo {

	@Param(desc = "专家类型1专家2健康管理师")
	private Integer expertsType;

	@Param(desc = "收藏类型1帖子2专家")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String type;

	public Integer getExpertsType() {
		return expertsType;
	}

	public void setExpertsType(Integer expertsType) {
		this.expertsType = expertsType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
