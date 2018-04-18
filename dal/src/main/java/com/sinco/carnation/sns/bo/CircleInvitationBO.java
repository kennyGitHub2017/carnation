package com.sinco.carnation.sns.bo;

import java.util.Date;

import com.sinco.carnation.sns.model.CircleInvitation;
import com.sinco.carnation.sns.model.CircleInvitationReply;
import com.sinco.dal.utils.DateUtils;

/**
 * 
 * BO 用于返回数据
 * 
 */
@SuppressWarnings("unused")
public class CircleInvitationBO extends CircleInvitation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 用户头像
	private String headImgPath;
	private String publicTime;
	private String replyTime;
	private Boolean isPraise;
	private Boolean isFavo;
	// 用户昵称
	private String nickName;
	private CircleInvitationReply reply;
	private Date createTime;
	private String[] picList;

	public String[] getPicList() {
		if (org.apache.commons.lang3.StringUtils.isNotBlank(getPic())) {
			return getPic().split("\\|");
		}
		return null;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAddTimeString() {
		if (getAddTime() != null) {
			return DateUtils.formatTime((new Date().getTime()) - getAddTime().getTime());
		} else {
			return null;
		}
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public CircleInvitationReply getReply() {
		return reply;
	}

	public void setReply(CircleInvitationReply reply) {
		this.reply = reply;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public String getPublicTime() {
		return getAddTimeString();
	}

	public void setPublicTime(String publicTime) {
		this.publicTime = publicTime;
	}

	public String getReplyTime() {
		if (getUpdateTime() != null) {
			return DateUtils.formatTime((new Date().getTime()) - getUpdateTime().getTime());
		} else {
			return null;
		}
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public Boolean getIsPraise() {
		return isPraise;
	}

	public Boolean getIsFavo() {
		return isFavo;
	}

	public void setIsPraise(Boolean isPraise) {
		this.isPraise = isPraise;
	}

	public void setIsFavo(Boolean isFavo) {
		this.isFavo = isFavo;
	}

}