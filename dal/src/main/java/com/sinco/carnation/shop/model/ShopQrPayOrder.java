package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class ShopQrPayOrder extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7565967075584712838L;

	/**  **/
	private Long id;

	/** 卖家Id **/
	private Long sellerId;

	/** 本次支付订单号 **/
	private String payOrderNo;

	/** 微信订单号 **/
	private String wxTransactionId;

	/** 总金额 **/
	private BigDecimal totalFee;

	/** 微信预付订单号 **/
	private String prepayId;

	/** 关联订单 **/
	private String orderId;

	/** 支付状态，0-未支付，1-支付成功，2-支付失败 **/
	private Byte payStatus;

	/**  **/
	private Date createTime;

	/**  **/
	private Date modifyTime;

	/** 支付方式Id **/
	private Long paymentId;

	/** 支付方式 1-微信支付 2-支付宝 0-云豆 **/
	private Byte paymentType;

	/** 手机 **/
	private String phone;

	/** 服务名称 **/
	private String serverName;

	/**
	 * 微信扫码支付时需要记录用户信息，做分润处理
	 */
	private Long userId;

	/**
	 * 订单原始价格
	 */
	private BigDecimal originalPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getPayOrderNo() {
		return payOrderNo;
	}

	public void setPayOrderNo(String payOrderNo) {
		this.payOrderNo = payOrderNo;
	}

	public String getWxTransactionId() {
		return wxTransactionId;
	}

	public void setWxTransactionId(String wxTransactionId) {
		this.wxTransactionId = wxTransactionId;
	}

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Byte getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Byte payStatus) {
		this.payStatus = payStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Byte getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Byte paymentType) {
		this.paymentType = paymentType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}
}