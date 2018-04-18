package com.sinco.carnation.resource.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "CircleInvitationReply", desc = "回复信息")
public class ReplyBO {

	/** 用户id **/
	@JsonProperty("uid")
	@FieldMapping(desc = "用户Id")
	private Long uid;

	/**  **/
	@JsonProperty("addTime")
	@FieldMapping(desc = "评论时间")
	private Date addTime;

	/** 楼层号 **/
	@JsonProperty("levelCount")
	@FieldMapping(desc = "楼层号")
	private Integer levelCount;

	/**  **/
	@JsonProperty("deleteStatus")
	@FieldMapping(desc = "用户Id")
	private Integer deleteStatus;

	/** 对应的帖子id **/
	@JsonProperty("invitationId")
	@FieldMapping(desc = "对应的帖子Id")
	private Long invitationId;

	/** 上级回复信息id **/
	@JsonProperty("parentId")
	@FieldMapping(desc = "上级回复信息id")
	private Long parentId;

	/** 回复数量，当作为上级回复信息时 **/
	@JsonProperty("replyCount")
	@FieldMapping(desc = "回复数量")
	private Integer replyCount;

	/** 对应的回复人id **/
	@JsonProperty("userId")
	@FieldMapping(desc = "回复人Id")
	private Long userId;

	/** 对应的回复人姓名 **/
	@JsonProperty("userName")
	@FieldMapping(desc = "回复人Id")
	private String userName;

	/** 对应的回复人头像路径“upload/” **/
	@JsonProperty("userPhoto")
	@FieldMapping(desc = "回复人头像路径")
	private String userPhoto;

	/** 回复信息 **/
	@JsonProperty("content")
	@FieldMapping(desc = "回复信息")
	private String content;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Long getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(Long invitationId) {
		this.invitationId = invitationId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getLevelCount() {
		return levelCount;
	}

	public void setLevelCount(Integer levelCount) {
		this.levelCount = levelCount;
	}

}
