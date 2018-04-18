/**   
 * @(#)CreateOrderRequest.java	2016年11月30日	下午3:53:18	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.viewmodel.order;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * (类型功能说明描述)
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年11月30日 下午3:53:18   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class CreateOrderRequest {
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
	 * 酒店编码
	 */
	private String hotelCode;
	
	/**
	 * 总价
	 */
	private BigDecimal totalPrice;
	
	/**
	 * 入职日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date arrivalDate;

    /**
     * 离店日期
     */
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date departureDate;
	
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
	 * 得到hotelCode的值   
	 *   
	 * @return hotelCode的值
	 */
	public String getHotelCode() {
		return hotelCode;
	}

	/**
	 * 设置hotelCode的值
	 *   
	 * @param hotelCode 被设置的值
	 */
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
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
	 * 得到totalPrice的值   
	 *   
	 * @return totalPrice的值
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * 设置totalPrice的值
	 *   
	 * @param totalPrice 被设置的值
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}
