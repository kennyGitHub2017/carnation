package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class CircleVO extends BasicPageParamVo {

	@Param(desc = "圈子id|必须")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long circleId;

	@Param(desc = "帖子类型|必须")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long invitationType;

	@Param(desc = "开始查询时间")
	private Long times;

	public Long getCircleId() {
		return circleId;
	}

	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}

	public Long getInvitationType() {
		return invitationType;
	}

	public void setInvitationType(Long invitationType) {
		this.invitationType = invitationType;
	}

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}

}
