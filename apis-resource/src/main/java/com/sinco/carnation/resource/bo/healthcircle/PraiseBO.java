package com.sinco.carnation.resource.bo.healthcircle;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "PraiseBO", desc = "健康圈点赞信息")
public class PraiseBO {
	@JsonProperty("postId")
	@FieldMapping(desc = "帖子postId")
	private Long postId;

	@JsonProperty("fromUserid")
	@FieldMapping(desc = "点赞人id")
	private Long fromUserid;

	@JsonProperty("fromUserName")
	@FieldMapping(desc = "点赞人名字")
	private String fromUserName;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getFromUserid() {
		return fromUserid;
	}

	public void setFromUserid(Long fromUserid) {
		this.fromUserid = fromUserid;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

}
