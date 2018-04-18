package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class CheckGroupVO extends BasicPageParamVo {

	@Param(desc = "自测题分类id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long classId;

	@Param(desc = "自测题是否关闭|1:关闭  ，0：开启")
	private Byte isClosed;

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Byte getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Byte isClosed) {
		this.isClosed = isClosed;
	}

}
