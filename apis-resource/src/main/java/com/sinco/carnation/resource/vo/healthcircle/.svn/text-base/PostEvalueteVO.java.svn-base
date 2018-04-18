package com.sinco.carnation.resource.vo.healthcircle;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PostEvalueteVO extends BasicParamVO {
	@Param(desc = "帖子postId|必传")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long postId;
	@Param(desc = "评论或者回复内容|必传")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String content;
	@Param(desc = "被评论者id|回复时必传")
	private Long toUserId;
	@Param(desc = "回复某条评论的pid|回复时必传")
	private Long pid;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getToUserId() {
		return toUserId;
	}

	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

}
