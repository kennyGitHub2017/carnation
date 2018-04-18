/**   
 * @(#)OrderSubmitResult.java	2016年12月1日	下午4:11:45	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.viewmodel.order;

import java.math.BigDecimal;
import java.util.Date;

import com.sinco.carnation.elong.model.h5.viewmodel.hotel.HotelDetailViewModel;

/**
 * 创建订单结果实体
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月1日 下午4:11:45   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class OrderSubmitResult {
	/**
	 * 本地数据库ID
	 */
	private Long id;
	
	/**
	 * 订单ID
	 */
	private Long orderId;
	
	/**
	 * 最晚取消时间
	 */
	private Date cancelTime;
	
	/**
	 * 最晚支付时间
	 */
	private Date paymentDeadlineTime;
	
	/**
	 * 是否需要支付
	 */
	private Boolean isNeedPay;
	
	/**
	 * 担保金额
	 */
	private BigDecimal guaranteeAmount;
	
	private HotelDetailViewModel hotelDetail;

	/**   
	 * 得到orderId的值   
	 *   
	 * @return orderId的值
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * 设置orderId的值
	 *   
	 * @param orderId 被设置的值
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**   
	 * 得到cancelTime的值   
	 *   
	 * @return cancelTime的值
	 */
	public Date getCancelTime() {
		return cancelTime;
	}

	/**
	 * 设置cancelTime的值
	 *   
	 * @param cancelTime 被设置的值
	 */
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	/**   
	 * 得到paymentDeadlineTime的值   
	 *   
	 * @return paymentDeadlineTime的值
	 */
	public Date getPaymentDeadlineTime() {
		return paymentDeadlineTime;
	}

	/**
	 * 设置paymentDeadlineTime的值
	 *   
	 * @param paymentDeadlineTime 被设置的值
	 */
	public void setPaymentDeadlineTime(Date paymentDeadlineTime) {
		this.paymentDeadlineTime = paymentDeadlineTime;
	}

	/**   
	 * 得到isNeedPay的值   
	 *   
	 * @return isNeedPay的值
	 */
	public Boolean getIsNeedPay() {
		return isNeedPay;
	}

	/**
	 * 设置isNeedPay的值
	 *   
	 * @param isNeedPay 被设置的值
	 */
	public void setIsNeedPay(Boolean isNeedPay) {
		this.isNeedPay = isNeedPay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getGuaranteeAmount() {
		return guaranteeAmount;
	}

	public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
		this.guaranteeAmount = guaranteeAmount;
	}

	public HotelDetailViewModel getHotelDetail() {
		return hotelDetail;
	}

	public void setHotelDetail(HotelDetailViewModel hotelDetail) {
		this.hotelDetail = hotelDetail;
	}
	
}
