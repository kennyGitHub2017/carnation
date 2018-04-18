package com.sinco.carnation.user.vo;

public class SellerVO {
	private String storeName;
	private Long operatorId;
	private Long operatorUserId;
	/**
	 * 0 辖区 , 1 隶属
	 */
	private String isOwn;
	/**
	 * 1市 2区 3vip 7金卡 9银卡
	 */
	private String userLevel;
	private String implementNumber;
	private Long storeId;
	private String gcId;
	private String startTime;
	private String endTime;
	private Long uid;
	private String operatorAreaId;

	public String getOperatorAreaId() {
		return operatorAreaId;
	}

	public void setOperatorAreaId(String operatorAreaId) {
		this.operatorAreaId = operatorAreaId;
	}

	public String getGcId() {
		return gcId;
	}

	public void setGcId(String gcId) {
		this.gcId = gcId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Long getOperatorUserId() {
		return operatorUserId;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getIsOwn() {
		return isOwn;
	}

	public void setIsOwn(String isOwn) {
		this.isOwn = isOwn;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getImplementNumber() {
		return implementNumber;
	}

	public void setImplementNumber(String implementNumber) {
		this.implementNumber = implementNumber;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

}