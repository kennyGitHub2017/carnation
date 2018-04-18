package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class LookInvitationVO extends BasicParamVO {

	@Param(desc = "帖子id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long fid;

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

}
