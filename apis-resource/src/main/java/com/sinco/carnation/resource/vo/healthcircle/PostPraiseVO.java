package com.sinco.carnation.resource.vo.healthcircle;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;

public class PostPraiseVO extends BasicParamVO {
	@Param(desc = "帖子postId|必传")
	private Integer postId;

	@Param(desc = "点赞用户|必传")
	private Long fromUserid;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Long getFromUserid() {
		return fromUserid;
	}

	public void setFromUserid(Long fromUserid) {
		this.fromUserid = fromUserid;
	}

}