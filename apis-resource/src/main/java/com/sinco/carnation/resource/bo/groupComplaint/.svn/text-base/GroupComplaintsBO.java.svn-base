package com.sinco.carnation.resource.bo.groupComplaint;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;
import com.sinco.dic.client.annotation.DicMappingModel;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GroupComplaint", desc = "运营商我的投诉列表")
@DicMappingModel
public class GroupComplaintsBO {

	@JsonProperty("orderStatus")
	@FieldMapping(desc = "订单状态")
	private Integer orderStatus;

	@JsonProperty("orderId")
	@FieldMapping(desc = "订单编号")
	private String orderId;

	@JsonProperty("payTime")
	@FieldMapping(desc = "下单时间")
	private Date payTime;

	@JsonProperty("goodsAmount")
	@FieldMapping(desc = "订单总额")
	private BigDecimal goodsAmount;

	@JsonProperty("groupInfo")
	@FieldMapping(desc = "商户名称")
	private String groupInfo;

	@JsonProperty("storeTelephone")
	@FieldMapping(desc = "商户电话")
	private String storeTelephone;

	@JsonProperty("areaId")
	@FieldMapping(desc = "地区id")
	private String areaId;
	// @DicNameMapping(codeField="areaId",isFull=true,mergeChar="",type=Area.class)

	@JsonProperty("areaText")
	@FieldMapping(desc = "商户所在址")
	private String areaText; // 商户所在址

	@JsonProperty("storeAddress")
	@FieldMapping(desc = "商户详细地址")
	private String storeAddress;

	@JsonProperty("name")
	@FieldMapping(desc = "投诉人|买家名称")
	private String name;

	@JsonProperty("status")
	@FieldMapping(desc = "投诉状态")
	private String status;

	@JsonProperty("mobile")
	@FieldMapping(desc = "投诉人手机")
	private String mobile;

	@JsonProperty("addTime")
	@FieldMapping(desc = "投诉时间")
	private Date addTime;

	@JsonProperty("id")
	@FieldMapping(desc = "投诉id")
	private Long id;

	@JsonProperty("problemDesc")
	@FieldMapping(desc = "问题描述")
	private String problemDesc;

	@JsonProperty("fromUserContent")
	@FieldMapping(desc = "投诉内容")
	private String fromUserContent;

	@JsonProperty("storeName")
	@FieldMapping(desc = "被投诉商户|服务商家")
	private String storeName;

	@JsonProperty("fromAcc1")
	@FieldMapping(desc = "投诉证据1")
	private String fromAcc1;

	@JsonProperty("fromAcc2")
	@FieldMapping(desc = "投诉证据2")
	private String fromAcc2;

	@JsonProperty("fromAcc3")
	@FieldMapping(desc = "投诉证据3")
	private String fromAcc3;

	@JsonProperty("groupName")
	@FieldMapping(desc = "服务名称")
	private String groupName;

	@JsonProperty("groupPhoto")
	@FieldMapping(desc = "服务图片")
	private String groupPhoto;

	@JsonProperty("price")
	@FieldMapping(desc = "服务价格")
	private BigDecimal price;

	@JsonProperty("fromAccArry")
	@FieldMapping(desc = "投诉证据数组")
	private List<String> fromAccArry;

	@JsonProperty("nickname")
	@FieldMapping(desc = "昵称")
	private String nickname;

	/** 仲裁意见 **/
	@JsonProperty("handleContent")
	@FieldMapping(desc = "仲裁意见 ")
	private String handleContent;

//	@JsonProperty("groupComplaintBOs")
//	@ReturnMapping(desc = "投诉列表")
//	private List<GroupComplaintsBO> groupComplaintBOs; 
//	public List<GroupComplaintsBO> getGroupComplaintBOs() {
//		return groupComplaintBOs;
//	}
//
//	public void setGroupComplaintBOs(List<GroupComplaintsBO> groupComplaintBOs) {
//		this.groupComplaintBOs = groupComplaintBOs;
//	}

	public String getAreaId() {
		return areaId;
	}

	public String getHandleContent() {
		return handleContent;
	}

	public void setHandleContent(String handleContent) {
		this.handleContent = handleContent;
	}

	public List<String> getFromAccArry() {
		return fromAccArry;
	}

	public void setFromAccArry(List<String> fromAccArry) {
		this.fromAccArry = fromAccArry;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaText() {
		return areaText;
	}

	public void setAreaText(String areaText) {
		this.areaText = areaText;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public BigDecimal getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(BigDecimal goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
	}

	public String getProblemDesc() {
		return problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}

	public String getFromUserContent() {
		return fromUserContent;
	}

	public void setFromUserContent(String fromUserContent) {
		this.fromUserContent = fromUserContent;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getFromAcc1() {
		return fromAcc1;
	}

	public void setFromAcc1(String fromAcc1) {
		this.fromAcc1 = fromAcc1;
	}

	public String getFromAcc2() {
		return fromAcc2;
	}

	public void setFromAcc2(String fromAcc2) {
		this.fromAcc2 = fromAcc2;
	}

	public String getFromAcc3() {
		return fromAcc3;
	}

	public void setFromAcc3(String fromAcc3) {
		this.fromAcc3 = fromAcc3;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupPhoto() {
		return groupPhoto;
	}

	public void setGroupPhoto(String groupPhoto) {
		this.groupPhoto = groupPhoto;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
