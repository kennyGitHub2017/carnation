package com.sinco.carnation.resource.bo.elong;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ElongOrder", desc = "艺龙订单列表")
public class ElongOrderMO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;
	@JsonProperty("orderId")
	@FieldMapping(desc = "订单编号")
	private Long orderId;
	@JsonProperty("hotelId")
	@FieldMapping(desc = "酒店编号")
	private String hotelId;
	@JsonProperty("hotelName")
	@FieldMapping(desc = "酒店名称")
	private String hotelName;
	@JsonProperty("intervalDay")
	@FieldMapping(desc = "日期差值（单位：天）")
	private Integer intervalDay;
	@JsonProperty("phone")
	@FieldMapping(desc = "酒店电话")
	private String phone;
	@JsonProperty("latitude")
	@FieldMapping(desc = "纬度")
	private String latitude;
	@JsonProperty("longitude")
	@FieldMapping(desc = "经度")
	private String longitude;
	@JsonProperty("thumbnailUrl")
	@FieldMapping(desc = "酒店缩略图")
	private String thumbnailUrl;
	@JsonProperty("roomTypeId")
	@FieldMapping(desc = "房型编号")
	private String roomTypeId;
	@JsonProperty("roomTypeName")
	@FieldMapping(desc = "房型名称")
	private String roomTypeName;
	@JsonProperty("arrivalDate")
	@FieldMapping(desc = "入住日期")
	private Date arrivalDate;
	@JsonProperty("departureDate")
	@FieldMapping(desc = "离店日期")
	private Date departureDate;
	@JsonProperty("status")
	@FieldMapping(desc = "订单状态(A-已确认,B-NOSHOW,B1-有预定未查到,B2-待查,B3-暂不确定,C-已结帐,D-删除,E-取消,F-已入住,G-变价,H-变更,N-新单,O-满房,S-特殊,U-特殊满房,V-已审,Z-删除,另换酒店)")
	private String status;
	@JsonProperty("showStatus")
	@FieldMapping(desc = "对用户展示的订单状态(V1.12新增。请将这个状态展示给客人；某些状态下的详细信息会出现在NoteToGuest。1 -- 担保失败,2 -- 等待担保,4 -- 等待确认,8 -- 等待支付,16 -- 等待核实入住,32 -- 酒店拒绝订单,64 -- 未入住,128 -- 已经离店,256 -- 已经取消,512 -- 已经确认,1024 -- 已经入住,2048 -- 正在担保-处理中,4096 -- 正在支付-处理中,8192 - 支付失败)")
	private String showStatus;
	@JsonProperty("paymentType")
	@FieldMapping(desc = "付款类型")
	private String paymentType;
	@JsonProperty("earliestArrivalTime")
	@FieldMapping(desc = "最早到店时间")
	private Date earliestArrivalTime;
	@JsonProperty("latestArrivalTime")
	@FieldMapping(desc = "最晚到店时间")
	private Date latestArrivalTime;
	@JsonProperty("currencyCode")
	@FieldMapping(desc = "货币类型")
	private String currencyCode;
	@JsonProperty("totalPrice")
	@FieldMapping(desc = "总价")
	private BigDecimal totalPrice;
	@JsonProperty("isCancelable")
	@FieldMapping(desc = "当前是否可以取消")
	private Boolean isCancelable;
	@JsonProperty("cancelTime")
	@FieldMapping(desc = "最晚取消时间")
	private Date cancelTime;
	@JsonProperty("creationDate")
	@FieldMapping(desc = "预订时间")
	private Date creationDate;
	@JsonProperty("numberOfRooms")
	@FieldMapping(desc = "房间数量")
	private int numberOfRooms;
	@JsonProperty("numberOfCustomers")
	@FieldMapping(desc = "客人数量")
	private int numberOfCustomers;
	@JsonProperty("valueAdds")
	@FieldMapping(desc = "增值服务")
	private String valueAdds;
	@JsonProperty("address")
	@FieldMapping(desc = "酒店详细地址")
	private String address;
	@JsonProperty("orderHotel")
	@FieldMapping(desc = "订单关联的酒店信息")
	private String orderHotel;
	@JsonProperty("userName")
	@FieldMapping(desc = "用户名称")
	private String userName;
	@JsonProperty("mobile")
	@FieldMapping(desc = "用户电话")
	private String mobile;
	@JsonProperty("paymentDeadlineTime")
	@FieldMapping(desc = "最晚支付时间")
	private Date paymentDeadlineTime;
	@JsonProperty("guaranteeAmount")
	@FieldMapping(desc = "担保金额")
	private BigDecimal guaranteeAmount;
	@JsonProperty("creditCard")
	@FieldMapping(desc = "信用卡")
	private String creditCard;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getEarliestArrivalTime() {
		return earliestArrivalTime;
	}

	public void setEarliestArrivalTime(Date earliestArrivalTime) {
		this.earliestArrivalTime = earliestArrivalTime;
	}

	public Date getLatestArrivalTime() {
		return latestArrivalTime;
	}

	public void setLatestArrivalTime(Date latestArrivalTime) {
		this.latestArrivalTime = latestArrivalTime;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Boolean getIsCancelable() {
		return isCancelable;
	}

	public void setIsCancelable(Boolean isCancelable) {
		this.isCancelable = isCancelable;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public Integer getIntervalDay() {
		return intervalDay;
	}

	public void setIntervalDay(Integer intervalDay) {
		this.intervalDay = intervalDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(String showStatus) {
		this.showStatus = showStatus;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}

	public void setNumberOfCustomers(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}

	public String getValueAdds() {
		return valueAdds;
	}

	public void setValueAdds(String valueAdds) {
		this.valueAdds = valueAdds;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrderHotel() {
		return orderHotel;
	}

	public void setOrderHotel(String orderHotel) {
		this.orderHotel = orderHotel;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getPaymentDeadlineTime() {
		return paymentDeadlineTime;
	}

	public void setPaymentDeadlineTime(Date paymentDeadlineTime) {
		this.paymentDeadlineTime = paymentDeadlineTime;
	}

	public BigDecimal getGuaranteeAmount() {
		return guaranteeAmount;
	}

	public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
		this.guaranteeAmount = guaranteeAmount;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

}
