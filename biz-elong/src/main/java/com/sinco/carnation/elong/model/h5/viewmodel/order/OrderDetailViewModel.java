/**   
 * @(#)HotelDetailForDetailPager.java	2016年11月28日	下午02:45:35	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.viewmodel.order;

import java.math.BigDecimal;

//import java.util.List;

/**
 * 酒店详情页数据模型
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年11月24日 下午6:56:53   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class OrderDetailViewModel{
	/**
	 * 订单ID
	 */
	private Long orderId;

	/**
	 * 系统用的订单状态
	 */
	private String status;
	
	/**
	 * 房间数量
	 */
	private Integer numberOfRooms;

	/**
	 * 向用户展示的订单状态id
	 */
	private Long showStatus;
	
	/**
	 * 向用户展示的订单状态字符串
	 */
	private String showStatusString;

	/**
	 * 酒店ID
	 */
	private String hotelId;
	
	/**
	 * 酒店名称
	 */
	private String hotelName;

	/**
	 * 酒店地址
	 */
	private String hotelAddress;
	
	/**
	 * 酒店电话
	 */
	private String hotelPhone;

	/**
	 * 房型ID
	 */
	private String roomTypeId;
	
	/**
	 * 房型名称
	 */
	private String roomTypeName;
	
	/**
	 * 产品编号
	 */
	private Integer ratePlanId;
	
	/**
	 * 产品名称
	 */
	private String ratePlanName;
	
	/**
	 * 入住日期
	 */
	private String arrivalDate;
	
	/**
	 * 离店日期
	 */
	private String departureDate;
	
	/**
	 * 共几晚
	 */
	private Long nightNumber;

	/**
	 * 最早到店时间
	 */
	private String earliestArrivalTime;
	
	/**
	 * 最晚到店时间
	 */
	private String latestArrivalTime;
	
	/**
	 * 预定时间
	 */
	private String creationDate;
	
	/**
	 * 是否可以取消（是否显示取消订单按钮）
	 */
	private Boolean isCancelable;
	
	/**
	 * 是否可以支付（是否显示支付按钮）
	 */
	private Boolean isPay;

	/**
	 * 最晚取消时间
	 */
	private String cancelTime;
	
	/**
	 * 联系人（入住人）姓名
	 */
	private String contactName;
	
	/**
	 * 联系人电话
	 */
	private String contactMobile;
	
	/**
	 * 早餐信息
	 */
	private String breakfastCount;
	
	/**
	 * 货币类型
	 */
	private String currencyType;

	/**
	 * 订单金额
	 */
	private BigDecimal totalPriceExchanged;

	/**
	 * 支付方式
	 */
	private String paymentType;

	/**
	 * 获取orderId的值
	 * 
	 * @return orderId的值
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * 设置 orderId的值
	 * 
	 * @param orderId
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * 获取 status的值
	 * 
	 * @return status的值
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置 status的值
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取 numberOfRooms的值
	 * 
	 * @return numberOfRooms的值
	 */
	public Integer getNumberOfRooms() {
		return numberOfRooms;
	}

	/**
	 * 设置 numberOfRooms的值
	 * 
	 * @param numberOfRooms
	 */
	public void setNumberOfRooms(Integer numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	/**
	 * 获取showStatus的值
	 * 
	 * @return showStatus的值
	 */
	public Long getShowStatus() {
		return showStatus;
	}

	/**
	 * 设置showStatus的值
	 * 
	 * @param showStatus
	 */
	public void setShowStatus(Long showStatus) {
		this.showStatus = showStatus;
	}

	/**
	 * 获取showStatusString的值
	 * 
	 * @return showStatusString的值
	 */
	public String getShowStatusString() {
		return showStatusString;
	}

	/**
	 * 设置showStatusString的值
	 * 
	 * @param showStatusString
	 */
	public void setShowStatusString(String showStatusString) {
		this.showStatusString = showStatusString;
	}

	/**
	 * 获取hotelId的值
	 * 
	 * @return hotelId的值
	 */
	public String getHotelId() {
		return hotelId;
	}

	/**
	 * 设置hotelId的值
	 * 
	 * @param hotelId
	 */
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * 获取hotelName的值
	 * 
	 * @return hotelName的值
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * 设置hotelName的值
	 * 
	 * @param hotelName
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * 获取hotelAddress的值
	 * 
	 * @return hotelAddress的值
	 */
	public String getHotelAddress() {
		return hotelAddress;
	}

	/**
	 * 设置hotelAddress的值
	 * 
	 * @param hotelAddress
	 */
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	/**
	 * 获取hotelPhone的值
	 * 
	 * @return hotelPhone的值
	 */
	public String getHotelPhone() {
		return hotelPhone;
	}

	/**
	 * 设置hotelPhone的值
	 * 
	 * @param hotelPhone
	 */
	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}

	/**
	 * 获取roomTypeId的值
	 * 
	 * @return roomTypeId的值
	 */
	public String getRoomTypeId() {
		return roomTypeId;
	}

	/**
	 * 设置roomTypeId的值
	 * 
	 * @param roomTypeId
	 */
	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	/**
	 * 获取roomTypeName的值
	 * 
	 * @return roomTypeName的值
	 */
	public String getRoomTypeName() {
		return roomTypeName;
	}

	/**
	 * 设置roomTypeName的值
	 * 
	 * @param roomTypeName
	 */
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	/**
	 * 获取ratePlanId的值
	 * 
	 * @return ratePlanId的值
	 */
	public Integer getRatePlanId() {
		return ratePlanId;
	}

	/**
	 * 设置ratePlanId的值
	 * 
	 * @param ratePlanId
	 */
	public void setRatePlanId(Integer ratePlanId) {
		this.ratePlanId = ratePlanId;
	}

	/**
	 * 获取ratePlanName的值
	 * 
	 * @return ratePlanName
	 */
	public String getRatePlanName() {
		return ratePlanName;
	}

	/**
	 * 设置ratePlanName的值
	 * 
	 * @param ratePlanName
	 */
	public void setRatePlanName(String ratePlanName) {
		this.ratePlanName = ratePlanName;
	}

	/**
	 * 获取arrivalDate的值
	 * 
	 * @return arrivalDate的值
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * 设置arrivalDate的值
	 * 
	 * @param arrivalDate
	 */
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * 获取departureDate的值
	 * 
	 * @return departureDate的值
	 */
	public String getDepartureDate() {
		return departureDate;
	}

	/**
	 * 设置departureDate的值
	 * 
	 * @param departureDate
	 */
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * 获取nightNumber的值
	 * 
	 * @return nightNumber的值
	 */
	public Long getNightNumber() {
		return nightNumber;
	}

	/**
	 * 设置nightNumber的值
	 * 
	 * @param nightNumber
	 */
	public void setNightNumber(Long nightNumber) {
		this.nightNumber = nightNumber;
	}

	/**
	 * 获取earliestArrivalTime的值
	 * 
	 * @return earliestArrivalTiem的值
	 */
	public String getEarliestArrivalTime() {
		return earliestArrivalTime;
	}

	/**
	 * 设置earliestArrivalTime的值
	 * 
	 * @param earliestArrivalTime
	 */
	public void setEarliestArrivalTime(String earliestArrivalTime) {
		this.earliestArrivalTime = earliestArrivalTime;
	}

	/**
	 * 获取latestArrivalTime的值
	 * 
	 * @return latestArrivalTime的值
	 */
	public String getLatestArrivalTime() {
		return latestArrivalTime;
	}

	/**
	 * 设置latestArrivalTime的值
	 * 
	 * @param latestArrivalTime
	 */
	public void setLatestArrivalTime(String latestArrivalTime) {
		this.latestArrivalTime = latestArrivalTime;
	}

	/**
	 * 获取creationDate的值
	 * 
	 * @return creationDate的值
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * 设置creationDate的值
	 * 
	 * @param creationDate
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * 获取isCancelable的值
	 * 
	 * @return isCancelable的值
	 */
	public Boolean getIsCancelable() {
		return isCancelable;
	}

	/**
	 * 设置isCancelable的值
	 * 
	 * @param isCancelable
	 */
	public void setIsCancelable(Boolean isCancelable) {
		this.isCancelable = isCancelable;
	}

	/**
	 * 获取isPay的值
	 * 
	 * @return isPay的值
	 */
	public Boolean getIsPay() {
		return isPay;
	}

	/**
	 * 设置isPay的值
	 * 
	 * @param isPay
	 */
	public void setIsPay(Boolean isPay) {
		this.isPay = isPay;
	}

	/**
	 * 获取cancelTime的值
	 * 
	 * @return cancelTime的值
	 */
	public String getCancelTime() {
		return cancelTime;
	}

	/**
	 * 设置cancelTime的值
	 * 
	 * @param cancelTime
	 */
	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}

	/**
	 * 获取contactName的值
	 * 
	 * @return contactName的值
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * 设置contactName的值
	 * 
	 * @param contactName
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * 获取contactMobile的值
	 * 
	 * @return contactMobile的值
	 */
	public String getContactMobile() {
		return contactMobile;
	}

	/**
	 * 设置contactMobile的值
	 * 
	 * @param contactMobile
	 */
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	/**
	 * 获取breakfastCount的值
	 * 
	 * @return breakfaCount的值
	 */
	public String getBreakfastCount() {
		return breakfastCount;
	}

	/**
	 * 设置breakfastCount的值
	 * 
	 * @param breakfastCount
	 */
	public void setBreakfastCount(String breakfastCount) {
		this.breakfastCount = breakfastCount;
	}

	/**
	 * 获取currencyType的值
	 * 
	 * @return currencyType的值
	 */
	public String getCurrencyType() {
		return currencyType;
	}

	/**
	 * 设置currencyType的值
	 * 
	 * @param currencyType
	 */
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	/**
	 * 获取totalPriceExchanged的值
	 * 
	 * @return totalPriceExchanged的值
	 */
	public BigDecimal getTotalPriceExchanged() {
		return totalPriceExchanged;
	}

	/**
	 * 设置totalPriceExchanged的值
	 * 
	 * @param totalPriceExchanged
	 */
	public void setTotalPriceExchanged(BigDecimal totalPriceExchanged) {
		this.totalPriceExchanged = totalPriceExchanged;
	}

	/**
	 * 获取paymentType的值
	 * 
	 * @return paymentType的值
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * 设置paymentType的值
	 * 
	 * @param paymentType
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
