package com.sinco.carnation.healthcircle.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sinco.mybatis.dal.model.BaseModel;

public class PostEvaluate extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 对应的帖子id **/
	private Long postId;

	/** 评价回复信息 **/
	private String content;

	/** 评价回复状态 0为未回复，1为已回复 **/
	private Integer replyStatus;

	/** 回复用户id **/
	private Long toUserid;

	/** 评论人id **/
	private Long fromUserid;
	private String toUserName;
	private String fromUserName;

	/** type类型 **/
	private Integer type;
	/** 回复的父id **/
	private Long pid;
	/** 回复集合 **/
	private List<PostEvaluate> replyList;
	/** 用户评论对象 **/
	private String headImgPath;
	/** 时间格式显示 **/
	public String addtiemFormat;
	/** 是否已添加积分 **/
	private Integer isAddIntegral;

	public String getAddtiemFormat() {
		return addtiemFormat;
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

	@SuppressWarnings({"unchecked", "rawtypes"})
	public List<PostEvaluate> getReplyList() {
		if (replyList == null) {
			replyList = new ArrayList();
		}
		return replyList;
	}

	public void setReplyList(List<PostEvaluate> replyList) {
		this.replyList = replyList;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
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

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
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

	public Integer getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(Integer replyStatus) {
		this.replyStatus = replyStatus;
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

	public Integer getIsAddIntegral() {
		return isAddIntegral;
	}

	public void setIsAddIntegral(Integer isAddIntegral) {
		this.isAddIntegral = isAddIntegral;
	}
}