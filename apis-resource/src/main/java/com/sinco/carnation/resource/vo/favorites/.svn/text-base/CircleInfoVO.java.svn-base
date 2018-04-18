package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class CircleInfoVO extends BasicParamVO {

	@Param(desc = "圈子id|必填")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long circleId;

	public Long getCircleId() {
		return circleId;
	}

	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}
}
