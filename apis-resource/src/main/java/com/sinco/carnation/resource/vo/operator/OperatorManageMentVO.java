package com.sinco.carnation.resource.vo.operator;

import javax.validation.constraints.NotNull;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class OperatorManageMentVO extends BasicPageParamVo {

	@Param(desc = "所属类型|0隶属1辖区")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer isBeLong;

	@Param(desc = "时间类型｜1周2月3季4年")
	private Integer timeType;

	public Integer getIsBeLong() {
		return isBeLong;
	}

	public void setIsBeLong(Integer isBeLong) {
		this.isBeLong = isBeLong;
	}

	public Integer getTimeType() {
		return timeType;
	}

	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}

}
