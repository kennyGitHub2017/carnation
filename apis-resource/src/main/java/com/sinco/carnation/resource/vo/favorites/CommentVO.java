package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class CommentVO extends BasicParamVO {

	@Param(desc = "图片|必须")
	private String pic;

	@Param(desc = "帖子Id|必须")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long invitationId;

	@Param(desc = "回复内容|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String content;

	public Long getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(Long invitationId) {
		this.invitationId = invitationId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}
