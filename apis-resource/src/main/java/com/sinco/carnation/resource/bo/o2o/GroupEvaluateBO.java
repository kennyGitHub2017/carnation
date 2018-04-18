package com.sinco.carnation.resource.bo.o2o;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GroupEvaluates", desc = "商户评论")
public class GroupEvaluateBO {

	@JsonProperty("orderId")
	@FieldMapping(desc = "被评价订单")
	private Long orderId;

	@JsonProperty("content")
	@FieldMapping(desc = "客户评价内容")
	private String content;

	@JsonProperty("replyContent")
	@FieldMapping(desc = "商户回复内容")
	private String replyContent;

	@JsonProperty("photoUrls")
	@FieldMapping(desc = "评价图片，以';'分隔，最多六张")
	private String photoUrls;

	@JsonProperty("evaluateTime")
	@FieldMapping(desc = "客户评价时间 ")
	private Date evaluateTime;

	@JsonProperty("replyTime")
	@FieldMapping(desc = "商户回复时间 ")
	private Date replyTime;

	@JsonProperty("status")
	@FieldMapping(desc = "评价状态(1:图片上传/尚未评价 2:客户已评价  3:商户已评价/评价完成)")
	private Integer status;

	@JsonProperty("goodsName")
	@FieldMapping(desc = "服务名称")
	private String goodsName;

	@JsonProperty("nickName")
	@FieldMapping(desc = "评论者昵称")
	private String nickName;

	@JsonProperty("avatarUrl")
	@FieldMapping(desc = "用户头像")
	private String avatarUrl;

	/** 评分：1~5 **/
	@JsonProperty("score")
	@FieldMapping(desc = "评分：1~5")
	private Integer score;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
