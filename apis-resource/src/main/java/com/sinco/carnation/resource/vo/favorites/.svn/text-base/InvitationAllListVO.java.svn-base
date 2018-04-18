package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class InvitationAllListVO extends BasicPageParamVo {

	@Param(desc = "帖子类型|必须")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long invitationType;

	@Param(desc = "查询时间")
	private Long times;

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
