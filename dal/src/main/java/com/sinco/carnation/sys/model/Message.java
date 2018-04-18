package com.sinco.carnation.sys.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class Message extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1153393445117877400L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/** 短信回复第一次 0为第一次发送短信，1为短信回复 **/
	private Integer msgCat;

	/** 短信回复状态 0为没有回复，1为有新回复 **/
	private Integer replyStatus;

	/** 短信状态0是未读，1为已读 **/
	private Integer status;

	/** 短信标题 **/
	private String title;

	/** 短信类型 0为系统短信，1为用户之间的短信 **/
	private Integer type;

	/** 发送用户 **/
	private Long fromUserId;

	/** 父级 **/
	private Long parentId;

	/** 接收用户 **/
	private Long toUserId;

	/** 短信内容 **/
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