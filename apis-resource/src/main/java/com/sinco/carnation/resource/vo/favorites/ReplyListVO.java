package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ReplyListVO extends BasicPageParamVo {

	@Param(desc = "帖子id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long invitationId;

	@Param(desc = "帖子访问来源(app原生与其他分享的区别标志,1:jg app)")
	private int jgyes_app;

	@Param(desc = "分享人的邀请码")
	private String invitationCode;

	private Integer start;

	private Long maxId;

	public Long getMaxId() {
		return maxId;
	}

	public void setMaxId(Long maxId) {
		this.maxId = maxId;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Long getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(Long invitationId) {
		this.invitationId = invitationId;
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
