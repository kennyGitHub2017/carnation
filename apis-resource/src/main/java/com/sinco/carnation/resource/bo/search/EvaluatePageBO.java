package com.sinco.carnation.resource.bo.search;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "EvaluatePage", desc = "评论列表")
public class EvaluatePageBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("descriptionEvaluate")
	@FieldMapping(desc = "描述相符评价 对卖家描述相符评价")
	private BigDecimal descriptionEvaluate;

	@JsonProperty("evaluateBuyerVal")
	@FieldMapping(desc = "买家评价  买家评价，评价类型，1为好评，0为中评，-1为差评 ")
	private Integer evaluateBuyerVal;

	@JsonProperty("evaluatePhotos")
	@FieldMapping(desc = "晒单图片")
	private String evaluatePhotos;

	@JsonProperty("evaluateStatus")
	@FieldMapping(desc = "评价状态  0为正常，1为禁止显示，2为取消评价")
	private Integer evaluateStatus;

	@JsonProperty("goodsNum")
	@FieldMapping(desc = "购买的数量")
	private Integer goodsNum;

	@JsonProperty("serviceEvaluate")
	@FieldMapping(desc = "服务态度评价 对卖家服务态度评价")
	private BigDecimal serviceEvaluate;

	@JsonProperty("shipEvaluate")
	@FieldMapping(desc = "发货速度评价  对卖家发货速度评价")
	private BigDecimal shipEvaluate;

	@JsonProperty("ofId")
	@FieldMapping(desc = "对应的订单")
	private Long ofId;

	@JsonProperty("replyStatus")
	@FieldMapping(desc = "评价回复状态 0为未回复，1为已回复")
	private Integer replyStatus;

	@JsonProperty("addevaStatus")
	@FieldMapping(desc = "addevaStatus")
	private Integer addevaStatus;

	@JsonProperty("追评时间")
	@FieldMapping(desc = "addevaTime")
	private Date addevaTime;

	@JsonProperty("evaluateAdminInfo")
	@FieldMapping(desc = "管理员操作备注")
	private String evaluateAdminInfo;

	@JsonProperty("evaluateInfo")
	@FieldMapping(desc = "买家评价信息")
	private String evaluateInfo;

	@JsonProperty("reply")
	@FieldMapping(desc = "评价回复")
	private String reply;

	@JsonProperty("addevaInfo")
	@FieldMapping(desc = "addevaInfo")
	private String addevaInfo;

	@JsonProperty("addevaPhotos")
	@FieldMapping(desc = "addevaPhotos")
	private String addevaPhotos;

	@JsonProperty("nickName")
	@FieldMapping(desc = "买家昵称")
	private String nickName;

	@JsonProperty("goodsName")
	@FieldMapping(desc = "商品名称")
	private String goodsName;

	@JsonProperty("storeName")
	@FieldMapping(desc = "商品店铺")
	private String storeName;

	@JsonProperty("goodsSpec")
	@FieldMapping(desc = "商品属性值 ")
	private String goodsSpec;

	@JsonProperty("goodsMainPhotoPath")
	@FieldMapping(desc = "商品主图")
	private String goodsMainPhotoPath;

	@JsonProperty("addTime")
	@FieldMapping(desc = "评论时间")
	private Date addTime;

	public String getGoodsSpec() {
		return goodsSpec;
	}

	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getDescriptionEvaluate() {
		return descriptionEvaluate;
	}

	public Integer getEvaluateBuyerVal() {
		return evaluateBuyerVal;
	}

	public String getEvaluatePhotos() {
		return evaluatePhotos;
	}

	public Integer getEvaluateStatus() {
		return evaluateStatus;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public BigDecimal getServiceEvaluate() {
		return serviceEvaluate;
	}

	public BigDecimal getShipEvaluate() {
		return shipEvaluate;
	}

	public Long getOfId() {
		return ofId;
	}

	public Integer getReplyStatus() {
		return replyStatus;
	}

	public Integer getAddevaStatus() {
		return addevaStatus;
	}

	public Date getAddevaTime() {
		return addevaTime;
	}

	public String getEvaluateAdminInfo() {
		return evaluateAdminInfo;
	}

	public String getEvaluateInfo() {
		return evaluateInfo;
	}

	public String getReply() {
		return reply;
	}

	public String getAddevaInfo() {
		return addevaInfo;
	}

	public String getAddevaPhotos() {
		return addevaPhotos;
	}

	public String getNickName() {
		return nickName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescriptionEvaluate(BigDecimal descriptionEvaluate) {
		this.descriptionEvaluate = descriptionEvaluate;
	}

	public void setEvaluateBuyerVal(Integer evaluateBuyerVal) {
		this.evaluateBuyerVal = evaluateBuyerVal;
	}

	public void setEvaluatePhotos(String evaluatePhotos) {
		this.evaluatePhotos = evaluatePhotos;
	}

	public void setEvaluateStatus(Integer evaluateStatus) {
		this.evaluateStatus = evaluateStatus;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public void setServiceEvaluate(BigDecimal serviceEvaluate) {
		this.serviceEvaluate = serviceEvaluate;
	}

	public void setShipEvaluate(BigDecimal shipEvaluate) {
		this.shipEvaluate = shipEvaluate;
	}

	public void setOfId(Long ofId) {
		this.ofId = ofId;
	}

	public void setReplyStatus(Integer replyStatus) {
		this.replyStatus = replyStatus;
	}

	public void setAddevaStatus(Integer addevaStatus) {
		this.addevaStatus = addevaStatus;
	}

	public void setAddevaTime(Date addevaTime) {
		this.addevaTime = addevaTime;
	}

	public void setEvaluateAdminInfo(String evaluateAdminInfo) {
		this.evaluateAdminInfo = evaluateAdminInfo;
	}

	public void setEvaluateInfo(String evaluateInfo) {
		this.evaluateInfo = evaluateInfo;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public void setAddevaInfo(String addevaInfo) {
		this.addevaInfo = addevaInfo;
	}

	public void setAddevaPhotos(String addevaPhotos) {
		this.addevaPhotos = addevaPhotos;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getGoodsMainPhotoPath() {
		return goodsMainPhotoPath;
	}

	public void setGoodsMainPhotoPath(String goodsMainPhotoPath) {
		this.goodsMainPhotoPath = goodsMainPhotoPath;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}
