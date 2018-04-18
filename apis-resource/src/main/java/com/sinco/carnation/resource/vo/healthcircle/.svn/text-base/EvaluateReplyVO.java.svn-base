package com.sinco.carnation.resource.vo.healthcircle;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;

public class EvaluateReplyVO extends BasicParamVO {
	@Param(desc = "帖子postId|必传")
	private Long postId;
	@Param(desc = "评论内容|必传")
	private String content;
	@Param(desc = "被回复者用户id|必传")
	private Long toUserId;
	@Param(desc = "回复评论的id|必传")
	private Long PID;

	public Long getPID() {
		return PID;
	}

	public void setPID(Long pID) {
		PID = pID;
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
