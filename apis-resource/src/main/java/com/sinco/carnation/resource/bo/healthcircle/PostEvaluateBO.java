package com.sinco.carnation.resource.bo.healthcircle;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

/**
 * 
 * BO 用于返回数据
 * 
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "PostEvaluateBO", desc = "健康圈评论")
public class PostEvaluateBO {
	@JsonProperty("id")
	@FieldMapping(desc = "帖子id")
	private Long id;

	@JsonProperty("content")
	@FieldMapping(desc = "评论内容")
	private String content;

	@JsonProperty("toUserName")
	@FieldMapping(desc = "被回复者姓名")
	private String toUserName;

	@JsonProperty("fromUserName")
	@FieldMapping(desc = "回复者姓名")
	private String fromUserName;

	@JsonProperty("toUserid")
	@FieldMapping(desc = "被回复者id")
	private Long toUserid;

	@JsonProperty("fromUserid")
	@FieldMapping(desc = "回复者id")
	private Long fromUserid;

	@JsonProperty("replyList")
	@FieldMapping(desc = "评论回复集合")
	private List<PostEvaluateBO> replyList;

	@JsonProperty("headImgPath")
	@FieldMapping(desc = "评论者头像")
	private String headImgPath;

	/** 时间格式显示 **/
	@JsonProperty("addtiemFormat")
	@FieldMapping(desc = "时间格式")
	public String addtiemFormat;

	public String getAddtiemFormat() {
		return addtiemFormat;
	}

	@JsonProperty("currentIndex")
	@FieldMapping(desc = "当前索引状态")
	private String currentIndex;

	public String getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(String currentIndex) {
		this.currentIndex = currentIndex;
	}

	public void setAddtiemFormat(String addtiemFormat) {
		this.addtiemFormat = addtiemFormat;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public List<PostEvaluateBO> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<PostEvaluateBO> replyList) {
		this.replyList = replyList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getToUserid() {
		return toUserid;
	}

	public void setToUserid(Long toUserid) {
		this.toUserid = toUserid;
	}

	public Long getFromUserid() {
		return fromUserid;
	}

	public void setFromUserid(Long fromUserid) {
		this.fromUserid = fromUserid;
	}

}