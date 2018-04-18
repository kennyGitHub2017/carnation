package com.sinco.carnation.resource.bo.jiuye;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ElongOrder", desc = "艺龙订单列表")
public class JiuyeOrderMO {

	@JsonProperty("orderId")
	@FieldMapping(desc = "酒业订单ID")
	private Long orderId;
	@JsonProperty("isComment")
	@FieldMapping(desc = "是否评价YES NO")
	private String isComment;
	@JsonProperty("orderDetailDto")
	@FieldMapping(desc = "订单详情")
	private String orderDetailDto;
	@JsonProperty("orderDt")
	@FieldMapping(desc = "订单时间")
	private Date orderDt;
	@JsonProperty("orderStatus")
	@FieldMapping(desc = "订单状态【1.待付款；2.待发货;3.已发货【配送中】;4.已完成【已收货】;5.退款中;6.已取消;7.已关闭;8.退货中;9.已退款;")
	private int orderStatus;
	@JsonProperty("orderType")
	@FieldMapping(desc = "订单类型")
	private int orderType;
	@JsonProperty("orderNo")
	@FieldMapping(desc = "订单编号")
	private String orderNo;
	@JsonProperty("payMoney")
	@FieldMapping(desc = "支付金额")
	private BigDecimal payMoney;
	@JsonProperty("phone")
	@FieldMapping(desc = "手机号")
	private String phone;
	@JsonProperty("platPayNo")
	@FieldMapping(desc = "平台支付编号")
	private String platPayNo;
	@JsonProperty("realPayMoney")
	@FieldMapping(desc = "真实支付金额")
	private BigDecimal realPayMoney;
	@JsonProperty("totalCount")
	@FieldMapping(desc = "商品总数量")
	private int totalCount;
	@JsonProperty("totalFree")
	@FieldMapping(desc = "总优惠券")
	private BigDecimal totalFree;
	@JsonProperty("transFee")
	@FieldMapping(desc = "运费")
	private BigDecimal transFee;
	@JsonProperty("userId")
	@FieldMapping(desc = "用户ID")
	private Long userId;
	@JsonProperty("address")
	@FieldMapping(desc = "地址")
	private String address;
	@JsonProperty("couponNo")
	@FieldMapping(desc = "优惠券编号")
	private String couponNo;
	@JsonProperty("addTime")
	@FieldMapping(desc = "创建时间")
	private Date addTime;
	@JsonProperty("lastUpdateTime")
	@FieldMapping(desc = "最后修改时间")
	private Date lastUpdateTime;
	@JsonProperty("paymentId")
	@FieldMapping(desc = "支付方式")
	private int paymentId;
	@JsonProperty("tradeNo")
	@FieldMapping(desc = "流水号 在线支付每次随机生成")
	private String tradeNo;
	@JsonProperty("orderDetailUrl")
	@FieldMapping(desc = "酒业订单详情H5页面URL")
	private String orderDetailUrl;
	@JsonProperty("payTime")
	@FieldMapping(desc = "支付时间")
	private Date payTime;
	@JsonProperty("indexUrl")
	@FieldMapping(desc = "酒业首页URL")
	private String indexUrl;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getIsComment() {
		return isComment;
	}

	public void setIsComment(String isComment) {
		this.isComment = isComment;
	}

	public String getOrderDetailDto() {
		return orderDetailDto;
	}

	public void setOrderDetailDto(String orderDetailDto) {
		this.orderDetailDto = orderDetailDto;
	}

	public Date getOrderDt() {
		return orderDt;
	}

	public void setOrderDt(Date orderDt) {
		this.orderDt = orderDt;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlatPayNo() {
		return platPayNo;
	}

	public void setPlatPayNo(String platPayNo) {
		this.platPayNo = platPayNo;
	}

	public BigDecimal getRealPayMoney() {
		return realPayMoney;
	}

	public void setRealPayMoney(BigDecimal realPayMoney) {
		this.realPayMoney = realPayMoney;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public BigDecimal getTotalFree() {
		return totalFree;
	}

	public void setTotalFree(BigDecimal totalFree) {
		this.totalFree = totalFree;
	}

	public BigDecimal getTransFee() {
		return transFee;
	}

	public void setTransFee(BigDecimal transFee) {
		this.transFee = transFee;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(String couponNo) {
		this.couponNo = couponNo;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getOrderDetailUrl() {
		return orderDetailUrl;
	}

	public void setOrderDetailUrl(String orderDetailUrl) {
		this.orderDetailUrl = orderDetailUrl;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getIndexUrl() {
		return indexUrl;
	}

	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}

}
