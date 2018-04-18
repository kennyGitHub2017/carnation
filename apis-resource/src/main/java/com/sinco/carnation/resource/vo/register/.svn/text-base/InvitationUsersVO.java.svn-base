package com.sinco.carnation.resource.vo.register;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class InvitationUsersVO extends BasicParamVO {

	/*	@Param(desc="用户id")
		@NotNull(message=MsgCodeConstant.ERROR_PARAM)
		private Long uid;*/

	@Param(desc = "推荐人邀请码")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String invitationCode;

	/*public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}*/

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

}
