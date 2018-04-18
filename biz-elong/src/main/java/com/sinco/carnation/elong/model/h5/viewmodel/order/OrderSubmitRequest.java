/**   
 * @(#)OrderSubmitRequest.java	2016年12月1日	下午2:48:45	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.viewmodel.order;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.sinco.carnation.elong.model.elong.Invoice;

/**
 * 提交订单请求实体
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月1日 下午2:48:45   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class OrderSubmitRequest{

	/**
	 * 酒店ID
	 */
	private String hotelId;
	
	/**
	 * 产品ID
	 */
	private int ratePlanId;
	
	/**
	 * 房型ID,用于创建订单
	 */
	private String roomTypeId;
	
	/**
	 * 入住日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date arrivalDate;

    /**
     * 离店日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date departureDate;
	
	/**
	 * 预订的房间数
	 */
	private int numberOfRooms;
	
	/**
	 * 最晚入住时间
	 * 格式：yyyy-MM-dd hh:mm
	 * eg:2016-12-12 15:00
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm", iso = ISO.DATE_TIME)
	private Date latestArrivalTime;
	
	/**
	 * 最晚入住时间
	 * 格式：yyyy-MM-dd hh:mm
	 * eg:2016-12-12 15:00
	 */
	private String latestArrivalTimeString;
	
	/**
	 * 用户IP
	 */
	private String customerIPAddress;
	
	/**
	 * 客人信息
	 */
	private List<CustomerInfo> guesterList;
	
	/**
	 * 联系人信息
	 */
	private CustomerInfo contact;
	
	/**
	 * 平台订单号
	 */
	private String affiliateConfirmationId;
	
	/**
	 * 订单拥有者
	 */
	private Long userId;
	
	/**
	 * 支付类型  SelfPay-前台现付、Prepay-预付
	 */
	private String paymentType;
	
	/**
	 * 是否需要开发票
	 */
	private boolean isNeedInvoice;
	
	/**
	 * 发票信息
	 */
	private Invoice invoice;

	/**   
	 * 得到hotelId的值   
	 *   
	 * @return hotelId的值
	 */
	public String getHotelId() {
		return hotelId;
	}

	/**
	 * 设置hotelId的值
	 *   
	 * @param hotelId 被设置的值
	 */
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	/**   
	 * 得到ratePlanId的值   
	 *   
	 * @return ratePlanId的值
	 */
	public int getRatePlanId() {
		return ratePlanId;
	}

	/**
	 * 设置ratePlanId的值
	 *   
	 * @param ratePlanId 被设置的值
	 */
	public void setRatePlanId(int ratePlanId) {
		this.ratePlanId = ratePlanId;
	}

	/**   
	 * 得到roomTypeId的值   
	 *   
	 * @return roomTypeId的值
	 */
	public String getRoomTypeId() {
		return roomTypeId;
	}

	/**
	 * 设置roomTypeId的值
	 *   
	 * @param roomTypeId 被设置的值
	 */
	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	/**   
	 * 得到arrivalDate的值   
	 *   
	 * @return arrivalDate的值
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * 设置arrivalDate的值
	 *   
	 * @param arrivalDate 被设置的值
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**   
	 * 得到departureDate的值   
	 *   
	 * @return departureDate的值
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * 设置departureDate的值
	 *   
	 * @param departureDate 被设置的值
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**   
	 * 得到numberOfRooms的值   
	 *   
	 * @return numberOfRooms的值
	 */
	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	/**
	 * 设置numberOfRooms的值
	 *   
	 * @param numberOfRooms 被设置的值
	 */
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	/**   
	 * 得到latestArrivalTime的值   
	 *   
	 * @return latestArrivalTime的值
	 */
	public Date getLatestArrivalTime() {
		return latestArrivalTime;
	}

	/**
	 * 设置latestArrivalTime的值
	 *   
	 * @param latestArrivalTime 被设置的值
	 */
	public void setLatestArrivalTime(Date latestArrivalTime) {
		this.latestArrivalTime = latestArrivalTime;
	}

	/**   
	 * 得到customerIPAddress的值   
	 *   
	 * @return customerIPAddress的值
	 */
	public String getCustomerIPAddress() {
		return customerIPAddress;
	}

	/**
	 * 设置customerIPAddress的值
	 *   
	 * @param customerIPAddress 被设置的值
	 */
	public void setCustomerIPAddress(String customerIPAddress) {
		this.customerIPAddress = customerIPAddress;
	}

	/**   
	 * 得到guesterList的值   
	 *   
	 * @return guesterList的值
	 */
	public List<CustomerInfo> getGuesterList() {
		return guesterList;
	}

	/**
	 * 设置guesterList的值
	 *   
	 * @param guesterList 被设置的值
	 */
	public void setGuesterList(List<CustomerInfo> guesterList) {
		this.guesterList = guesterList;
	}

	/**   
	 * 得到contact的值   
	 *   
	 * @return contact的值
	 */
	public CustomerInfo getContact() {
		return contact;
	}

	/**
	 * 设置contact的值
	 *   
	 * @param contact 被设置的值
	 */
	public void setContact(CustomerInfo contact) {
		this.contact = contact;
	}

	/**   
	 * 得到latestArrivalTimeString的值   
	 *   
	 * @return latestArrivalTimeString的值
	 */
	public String getLatestArrivalTimeString() {
		return latestArrivalTimeString;
	}

	/**
	 * 设置latestArrivalTimeString的值
	 *   
	 * @param latestArrivalTimeString 被设置的值
	 */
	public void setLatestArrivalTimeString(String latestArrivalTimeString) {
		this.latestArrivalTimeString = latestArrivalTimeString;
	}

	public String getAffiliateConfirmationId() {
		return affiliateConfirmationId;
	}

	public void setAffiliateConfirmationId(String affiliateConfirmationId) {
		this.affiliateConfirmationId = affiliateConfirmationId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public boolean isNeedInvoice() {
		return isNeedInvoice;
	}

	public void setNeedInvoice(boolean isNeedInvoice) {
		this.isNeedInvoice = isNeedInvoice;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
