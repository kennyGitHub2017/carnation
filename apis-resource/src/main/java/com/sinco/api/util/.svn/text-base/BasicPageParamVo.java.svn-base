package com.sinco.api.util;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class BasicPageParamVo extends BasicParamVO {

	@Param(desc = "每页记录数|必须")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer pageSize;

	@Param(desc = "页数|必须")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer pageNum;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
}
