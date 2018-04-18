package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ShareInvitationDetailsVO extends BasicParamVO {

	@Param(desc = "invnId")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long invnId;

	@Param(desc = "帖子访问来源(app原生与其他分享的区别标志,1:jg app)")
	private int jgyes_app;

	@Param(desc = "分享人邀请码信息")
	private String invitationCode;

	public Long getInvnId() {
		return invnId;
	}

	public void setInvnId(Long invnId) {
		this.invnId = invnId;
	}

	public int getJgyes_app() {
		return jgyes_app;
	}

	public void setJgyes_app(int jgyes_app) {
		this.jgyes_app = jgyes_app;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

}
