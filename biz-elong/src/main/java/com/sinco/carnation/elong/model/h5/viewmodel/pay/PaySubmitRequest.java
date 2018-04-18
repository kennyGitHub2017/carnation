/**   
 * @(#)PaySubmitRequest.java	2016年12月7日	下午4:01:02	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.viewmodel.pay;

import java.math.BigDecimal;

/**
 * 支付请求参数
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月7日 下午4:01:02   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class PaySubmitRequest {
	/**
	 * 数据库主键ID
	 */
	private Long id;
	
	/**
	 * 订单号
	 */
	private Long orderId;
	
	/**
	 * 支付金额
	 */
	private BigDecimal amount;
	
	/**
	 * 卡号
	 */
	private String cardNo;
	
	/**
	 * CVV
	 */
	private String cvv;
	
	/**
	 * 信用卡过期时间：4位年+2位月
	 */
	private String expiration;
	
	/**
	 * 持卡人名称
	 */
	private String holderName;
	
	/**
	 * 证件类型
	 */
	private String idType;
	
	/**
	 * 证件号码
	 */
	private String idNo;

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
	 * 得到amount的值   
	 *   
	 * @return amount的值
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * 设置amount的值
	 *   
	 * @param amount 被设置的值
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**   
	 * 得到cardNo的值   
	 *   
	 * @return cardNo的值
	 */
	public String getCardNo() {
		return cardNo;
	}

	/**
	 * 设置cardNo的值
	 *   
	 * @param cardNo 被设置的值
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	/**   
	 * 得到cvv的值   
	 *   
	 * @return cvv的值
	 */
	public String getCvv() {
		return cvv;
	}

	/**
	 * 设置cvv的值
	 *   
	 * @param cvv 被设置的值
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	/**   
	 * 得到expiration的值   
	 *   
	 * @return expiration的值
	 */
	public String getExpiration() {
		return expiration;
	}

	/**
	 * 设置expiration的值
	 *   
	 * @param expiration 被设置的值
	 */
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	/**   
	 * 得到holderName的值   
	 *   
	 * @return holderName的值
	 */
	public String getHolderName() {
		return holderName;
	}

	/**
	 * 设置holderName的值
	 *   
	 * @param holderName 被设置的值
	 */
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	/**   
	 * 得到idType的值   
	 *   
	 * @return idType的值
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * 设置idType的值
	 *   
	 * @param idType 被设置的值
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**   
	 * 得到idNo的值   
	 *   
	 * @return idNo的值
	 */
	public String getIdNo() {
		return idNo;
	}

	/**
	 * 设置idNo的值
	 *   
	 * @param idNo 被设置的值
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
