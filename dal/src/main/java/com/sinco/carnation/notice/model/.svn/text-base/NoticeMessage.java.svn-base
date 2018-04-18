package com.sinco.carnation.notice.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class NoticeMessage extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5302435833763021146L;

	/**  **/
	private Long id;

	/** 用户id **/
	private Long uid;

	/** 消息创建时间 **/
	private Date createTime;

	/** 消息内容 **/
	private String noticeMessage;

	/** 消息类型 **/
	private Integer noticeType;

	/** 是否推送过。默认：0没推送，1：已推送 **/
	private Integer pushStatus;

	/** 数量 **/
	private BigDecimal notcieLogAmount;

	/** 消息相关的记录id，例如该消息是活动id **/
	private Long relateId;

	/** 向所有用户推送 **/
	private Integer pushtoall;

	/** 推送的消息类型 **/
	private String pushType;
	
	/** 消息状态 1已读0未读 **/
	private Integer messageStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNoticeMessage() {
		return noticeMessage;
	}

	public void setNoticeMessage(String noticeMessage) {
		this.noticeMessage = noticeMessage;
	}

	public Integer getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}

	public Integer getPushStatus() {
		return pushStatus;
	}

	public void setPushStatus(Integer pushStatus) {
		this.pushStatus = pushStatus;
	}

	public BigDecimal getNotcieLogAmount() {
		return notcieLogAmount;
	}

	public void setNotcieLogAmount(BigDecimal notcieLogAmount) {
		this.notcieLogAmount = notcieLogAmount;
	}

	public Long getRelateId() {
		return relateId;
	}

	public void setRelateId(Long relateId) {
		this.relateId = relateId;
	}

	public Integer getPushtoall() {
		return pushtoall;
	}

	public void setPushtoall(Integer pushtoall) {
		this.pushtoall = pushtoall;
	}

	public String getPushType() {
		return pushType;
	}

	public void setPushType(String pushType) {
		this.pushType = pushType;
	}

	public Integer getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(Integer messageStatus) {
		this.messageStatus = messageStatus;
	}

}