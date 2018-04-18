package com.sinco.carnation.resource.vo;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ReportReplyDetailsVO extends BasicParamVO {

	@Param(desc = "报告id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
