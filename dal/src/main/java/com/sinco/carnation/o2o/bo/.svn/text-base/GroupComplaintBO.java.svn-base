package com.sinco.carnation.o2o.bo;

import java.math.BigDecimal;
import java.util.Date;

import com.sinco.carnation.o2o.model.GroupComplaint;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.dic.client.annotation.DicMappingModel;
import com.sinco.dic.client.annotation.DicNameMapping;

/**
 * 
 * BO 用于返回数据
 * 
 */
@SuppressWarnings("serial")
@DicMappingModel
public class GroupComplaintBO extends GroupComplaint {
	String nickname;
	String storeName;
	String handleNickName;
	UserBO handleUser;
	String mobile;
	Store store;
	String storeId;

	@DicNameMapping(type = Area.class, codeField = "areaId", mergeChar = "", isFull = true)
	String areaText;
	Integer createUserId;
	String storeMobile;// 商家电话

	private String areaId;// 服务地址ID

	private Long id;
	private Integer orderStatus;// 订单状态
	private String orderId; // 订单编号

	private Date payTime; // 下单时间
	private BigDecimal goodsAmount; // 订单总额

	private String storeTelephone;// 商户电话
	private String storeAddress; // 商户地址
	private String name;
	// private Integer status; //投诉状态

	private Date addTime; // 投诉时间

	// 投诉证据图片
	private String fromAcc1;
	private String fromAcc2;
	private String fromAcc3;

	private String groupInfo; // 商户所在址
	private String problemDesc; // 问题描述
	private String fromUserContent; // 投诉内容

	private Long groupOrderId;
	private String toUserName;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public Long getGroupOrderId() {
		return groupOrderId;
	}

	public void setGroupOrderId(Long groupOrderId) {
		this.groupOrderId = groupOrderId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
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

//	public Integer getStatus() {
//		return status;
//	}
//
//	public void setStatus(Integer status) {
//		this.status = status;
//	}

	public String getStoreMobile() {
		return storeMobile;
	}

	public void setStoreMobile(String storeMobile) {
		this.storeMobile = storeMobile;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public UserBO getHandleUser() {
		return handleUser;
	}

	public void setHandleUser(UserBO handleUser) {
		this.handleUser = handleUser;
	}

	public String getHandleNickName() {
		return handleNickName;
	}

	public void setHandleNickName(String handleNickName) {
		this.handleNickName = handleNickName;
	}

	public String getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
}