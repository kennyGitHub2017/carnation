package com.sinco.carnation.store.vo;

public class PayoffLogVO {
	private String plSn;
	private String orderId;
	private Long sellerId;
	private String type;
	private String typeData;
	private String beginTime;
	private String endTime;
	private String beginPrice;
	private String endPrice;
	private String status;
	private String tempStatus;
	private Integer dayCount;

	public Integer getDayCount() {
		return dayCount;
	}

	public void setDayCount(Integer dayCount) {
		this.dayCount = dayCount;
	}

	public String getTempStatus() {
		return tempStatus;
	}

	public void setTempStatus(String tempStatus) {
		this.tempStatus = tempStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getPlSn() {
		return plSn;
	}

	public void setPlSn(String plSn) {
		this.plSn = plSn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeData() {
		return typeData;
	}

	public void setTypeData(String typeData) {
		this.typeData = typeData;
	}

	public String getBeginPrice() {
		return beginPrice;
	}

	public void setBeginPrice(String beginPrice) {
		this.beginPrice = beginPrice;
	}

	public String getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(String endPrice) {
		this.endPrice = endPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}