package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class InformationVO extends BasicPageParamVo {

	@Param(desc = "资讯分类|必须")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long classId;

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}
}
