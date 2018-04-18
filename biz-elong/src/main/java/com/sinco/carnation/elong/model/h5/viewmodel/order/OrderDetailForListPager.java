/**
 * @(#)OderDetailForListPagerResult.java	2016年11月28日	上午09:35:35
 * 
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.viewmodel.order;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sinco.carnation.elong.model.elong.EnumCurrencyCode;

/**
 * 订单列表页的返回实体
 * 为了减少页面返回数据，织田家需要展示的页面属性
 * 
 * <p>
 * 修改历史：												<br>
 * 修改日期			修改人员		版本				修改内容<br>
 * -----------------------------------------------------<br>
 * 2016年11月28日 上午09:25:25		user	1.0			初始化创建<br>
 * </p>
 * 
 * @author		user
 * @version		1.0
 * @since 		JDK1.7
 */
public class OrderDetailForListPager {
	
	/**
	 * 订单ID
	 */
	private long orderId;
	
	/**
	 * 订单状态
	 */
	private String status;
	
	/**
	 * 总价
	 */
	private BigDecimal totalPrice;
	
	/**
	 * 货币标识
	 */
	private String currencyFlag;
	
	/**
	 * 货币类型
	 */
	private EnumCurrencyCode currencyCode;
	
	/**
	 * 酒店编号
	 */
	private String hotelId;
	
	/**
	 * 酒店名称
	 */
	private String hotelName;
	
	/**
	 * 房型编号
	 */
	private String roomTypeId;
	
	/**
	 * 房型名称
	 */
	private String roomTypeName;
	
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
	 * 中文入住日期
	 */
	private String arrivalDateCh;
	
	/**
	 * 中文离店日期
	 */
	private String departureDateCh;

	/**
	 * 共几晚
	 */
	private Long nightNumber;

	/**
	 * 获取orderId的值
	 * 
	 * @return orderId的值
	 */
	public long getOrderId() {
		return orderId;
	}

	/**
	 * 设置orderId的值
	 * 
	 * @param orderId
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	/**
	 * 获取status的值
	 * 
	 * @return status的值
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置status的值
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取totalPrice的值
	 * 
	 * @return totalPrice的值
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * 设置totalPrice的值
	 * 
	 * @param totalPrice
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * 获取currencyCode的值
	 * 
	 * @return currencyCode的值
	 */
	public EnumCurrencyCode getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * 设置currencyCode的值
	 * 
	 * @param currencyCode
	 */
	public void setCurrencyCode(EnumCurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
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
	 * 获取arrivalDate的值
	 * 
	 * @return arrivalDate的值
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * 设置arrivalDate的值
	 * 
	 * @param arrivalDate
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * 获取departureDate的值
	 * 
	 * @return departureDate的值
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * 设置departureDate的值
	 * 
	 * @param departureDate
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * 获取arrivalDateCh的值
	 * 
	 * @return arrivalDateCh的值
	 */
	public String getArrivalDateCh() {
		return arrivalDateCh;
	}

	/**
	 * 设置arrivalDateCh的值
	 * 
	 * @param arrivalDateCh
	 */
	public void setArrivalDateCh(String arrivalDateCh) {
		this.arrivalDateCh = arrivalDateCh;
	}

	/**
	 * 获取departureDateCh的值
	 * 
	 * @return departureDate的值
	 */ 
	public String getDepartureDateCh() {
		return departureDateCh;
	}

	/**
	 * 设置departureDate的值
	 * 
	 * @param departureDateCh
	 */
	public void setDepartureDateCh(String departureDateCh) {
		this.departureDateCh = departureDateCh;
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
	 * 得到currencyFlag的值   
	 *   
	 * @return currencyFlag的值
	 */
	public String getCurrencyFlag() {
		return currencyFlag;
	}

	/**
	 * 设置currencyFlag的值
	 *   
	 * @param currencyFlag 被设置的值
	 */
	public void setCurrencyFlag(String currencyFlag) {
		this.currencyFlag = currencyFlag;
	}
	
}
