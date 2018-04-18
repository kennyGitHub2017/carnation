/**   
 * @(#)HotelDetailRequest.java	2016年11月24日	下午6:41:48	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.viewmodel.hotel;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 酒店详情页的请求实体
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年11月24日 下午6:41:48   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class HotelDetailRequest {
	
	/**
	 * 城市ID
	 */
	private String cityId;
	
	/**
	 * 酒店ID
	 */
	private String hotelId;
	
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

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
}
