package com.sinco.carnation.o2o.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class GroupEvaluation extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1195017651259316383L;

	/** 被评价订单 **/
	private Long orderId;

	/** 评分：1~5 **/
	private Integer score;

	/** 评价人 **/
	private Long evaluateUserId;

	/**  **/
	private Long evaluateSellerId;

	/** 客户评价内容 **/
	private String content;

	/** 商户回复内容 **/
	private String replyContent;

	/** 评价图片，以';'分隔，最多六张 **/
	private String photoUrls;

	/** 客户评价时间 **/
	private Date evaluateTime;

	/** 商户回复时间 **/
	private Date replyTime;

	/** 评价状态(1:图片上传/尚未评价 2:客户已评价 3:商户已评价/评价完成) **/
	private Integer status;

	/** 创建时间 **/
	private Date createTime;

	/** 最后修改时间 **/
	private Date updateTime;

	/** 删除时间 **/
	private Date deleteTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getEvaluateUserId() {
		return evaluateUserId;
	}

	public void setEvaluateUserId(Long evaluateUserId) {
		this.evaluateUserId = evaluateUserId;
	}

	public Long getEvaluateSellerId() {
		return evaluateSellerId;
	}

	public void setEvaluateSellerId(Long evaluateSellerId) {
		this.evaluateSellerId = evaluateSellerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(String photoUrls) {
		this.photoUrls = photoUrls;
	}

	public Date getEvaluateTime() {
		return evaluateTime;
	}

	public void setEvaluateTime(Date evaluateTime) {
		this.evaluateTime = evaluateTime;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
}