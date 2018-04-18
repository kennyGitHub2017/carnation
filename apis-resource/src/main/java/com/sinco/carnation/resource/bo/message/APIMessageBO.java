package com.sinco.carnation.resource.bo.message;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(desc = "个人消息", domainName = "APIMessageBO")
public class APIMessageBO {
	/**  **/
	@JsonProperty("id")
	@FieldMapping(desc = "消息ID")
	private Long id;

	/**  **/
	@JsonProperty("addTime")
	@FieldMapping(desc = "添加时间")
	private Date addTime;

	/**  **/
	@JsonProperty("deleteStatus")
	@FieldMapping(desc = "删除状态")
	private Integer deleteStatus;

	/** 短信回复第一次 0为第一次发送短信，1为短信回复 **/
	@JsonProperty("msgCat")
	@FieldMapping(desc = "短信回复第一次 0为第一次发送短信，1为短信回复")
	private Integer msgCat;

	/** 短信回复状态 0为没有回复，1为有新回复 **/
	@JsonProperty("replyStatus")
	@FieldMapping(desc = "短信回复状态 0为没有回复，1为有新回复")
	private Integer replyStatus;

	/** 短信状态0是未读，1为已读 **/
	@JsonProperty("status")
	@FieldMapping(desc = "短信状态0是未读，1为已读")
	private Integer status;

	/** 短信标题 **/
	@JsonProperty("title")
	@FieldMapping(desc = "短信标题")
	private String title;

	/** 短信类型 0为系统短信，1为用户之间的短信 **/
	@JsonProperty("type")
	@FieldMapping(desc = "短信类型 0为系统短信，1为用户之间的短信")
	private Integer type;

	/** 发送用户 **/
	@JsonProperty("fromUserId")
	@FieldMapping(desc = "发送用户")
	private Long fromUserId;

	/** 父级 **/
	@JsonProperty("parentId")
	@FieldMapping(desc = "父级")
	private Long parentId;

	/** 接收用户 **/
	@JsonProperty("toUserId")
	@FieldMapping(desc = "接收用户")
	private Long toUserId;

	/** 短信内容 **/
	@JsonProperty("content")
	@FieldMapping(desc = "短信内容")
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Integer getMsgCat() {
		return msgCat;
	}

	public void setMsgCat(Integer msgCat) {
		this.msgCat = msgCat;
	}

	public Integer getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(Integer replyStatus) {
		this.replyStatus = replyStatus;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getToUserId() {
		return toUserId;
	}

	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
