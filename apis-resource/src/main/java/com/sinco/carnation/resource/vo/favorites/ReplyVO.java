package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ReplyVO extends BasicParamVO {

	@Param(desc = "帖子id|必须")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long invitationId;

	@Param(desc = "回复id|必须")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long replyId;

	@Param(desc = "回复内容|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String content;

	@Param(desc = "发表图片|必须")
	private String pic;

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Long getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(Long invitationId) {
		this.invitationId = invitationId;
	}

	public Long getReplyId() {
		return replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
