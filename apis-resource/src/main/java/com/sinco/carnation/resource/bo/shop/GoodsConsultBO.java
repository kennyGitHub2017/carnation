package com.sinco.carnation.resource.bo.shop;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GoodsConsult", desc = "商品咨询")
public class GoodsConsultBO {

	/**  **/
	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	/**  **/
	@JsonProperty("addTime")
	@FieldMapping(desc = "咨询时间")
	private Date addTime;

	/** 咨询用户id **/
	@JsonProperty("consultUserId")
	@FieldMapping(desc = "咨询用户id")
	private Long consultUserId;

	/** 咨询用户名 **/
	@JsonProperty("consultUserName")
	@FieldMapping(desc = "咨询用户名")
	private String consultUserName;

	/** 回复时间 **/
	@JsonProperty("replyTime")
	@FieldMapping(desc = "回复时间")
	private Date replyTime;

	/** 回复用户名 **/
	@JsonProperty("replyUserName")
	@FieldMapping(desc = "回复用户名")
	private String replyUserName;

	/** 满意数 **/
	@JsonProperty("satisfy")
	@FieldMapping(desc = "满意数")
	private Integer satisfy;

	/** 店铺名称 **/
	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称 ")
	private String storeName;

	/** 不满意数量 **/
	@JsonProperty("unsatisfy")
	@FieldMapping(desc = "不满意数量")
	private Integer unsatisfy;

	/** 是否为自营商品咨询 0为第三方 1为自营 **/
	@JsonProperty("whetherSelf")
	@FieldMapping(desc = "是否为自营商品咨询 0为第三方 1为自营")
	private Integer whetherSelf;

	/** 咨询内容 **/
	@JsonProperty("consultContent")
	@FieldMapping(desc = "咨询内容 ")
	private String consultContent;

	/** 回复内容 **/
	@JsonProperty("consultReply")
	@FieldMapping(desc = "回复内容 ")
	private String consultReply;

	/**
	 * [{"goods_id":"1","goods_name":"鳄鱼褐色纯皮裤腰带",store_domainPath这个是店铺二级域名路径,
	 * goods_domainPath商品二级域名路径"goods_main_photo": "upload/store/1/938a670f-081f-4e37-b355-142a551ef0bb.jpg"
	 * ,"goods_price":"54.30"}]
	 **/
	@JsonProperty("goodsInfo")
	@FieldMapping(desc = "商品信息")
	private String goodsInfo;

	public Long getId() {
		return id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public Long getConsultUserId() {
		return consultUserId;
	}

	public String getConsultUserName() {
		return consultUserName;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public String getReplyUserName() {
		return replyUserName;
	}

	public Integer getSatisfy() {
		return satisfy;
	}

	public String getStoreName() {
		return storeName;
	}

	public Integer getUnsatisfy() {
		return unsatisfy;
	}

	public Integer getWhetherSelf() {
		return whetherSelf;
	}

	public String getConsultContent() {
		return consultContent;
	}

	public String getConsultReply() {
		return consultReply;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public void setConsultUserId(Long consultUserId) {
		this.consultUserId = consultUserId;
	}

	public void setConsultUserName(String consultUserName) {
		this.consultUserName = consultUserName;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}

	public void setSatisfy(Integer satisfy) {
		this.satisfy = satisfy;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setUnsatisfy(Integer unsatisfy) {
		this.unsatisfy = unsatisfy;
	}

	public void setWhetherSelf(Integer whetherSelf) {
		this.whetherSelf = whetherSelf;
	}

	public void setConsultContent(String consultContent) {
		this.consultContent = consultContent;
	}

	public void setConsultReply(String consultReply) {
		this.consultReply = consultReply;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
}
