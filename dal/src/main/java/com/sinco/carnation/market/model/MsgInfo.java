package com.sinco.carnation.market.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class MsgInfo extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7010343414748213204L;

	/** 主键id **/
	private Long id;

	/** 消息标题 **/
	private String title;

	/** 通知栏内容 **/
	private String noticeTitle;

	/** 接受类型 1-只读,2-链接,3-富文本 **/
	private Byte receiveType;

	/** 消息内容 **/
	private String linkUrl;

	/** 接受位置 2^0:云尚APP;2^1:云e店APP;2^2:云e商APP;2^3:pc商家管理中心;2^4:pc商户管理中心;2^5:pc运营商;2^6:pc会员个人中心; **/
	private Long receiveLocation;

	/** 权重 **/
	private Integer priority;

	/** 置顶 **/
	private Integer topIndex;

	/** 发送消息数量 **/
	private Byte sendCount;

	/** 发送状态 0-未发送,1-已发送 **/
	private Long sendStatus;

	/** 发送时间 **/
	private Date sendTime;

	/** 删除状态 0 正常数据(默认值),1 删除状态' **/
	private Byte deleteStatus;

	/**  **/
	private Long createBy;

	/**  **/
	private Date createTime;

	/**  **/
	private Long modifyBy;

	/**  **/
	private Date modifyTime;

	/** 消息内容 **/
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public Byte getReceiveType() {
		return receiveType;
	}

	public void setReceiveType(Byte receiveType) {
		this.receiveType = receiveType;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public Long getReceiveLocation() {
		return receiveLocation;
	}

	public void setReceiveLocation(Long receiveLocation) {
		this.receiveLocation = receiveLocation;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getTopIndex() {
		return topIndex;
	}

	public void setTopIndex(Integer topIndex) {
		this.topIndex = topIndex;
	}

	public Byte getSendCount() {
		return sendCount;
	}

	public void setSendCount(Byte sendCount) {
		this.sendCount = sendCount;
	}

	public Long getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(Long sendStatus) {
		this.sendStatus = sendStatus;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Byte getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Byte deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}