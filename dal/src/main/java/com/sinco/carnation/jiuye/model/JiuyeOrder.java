package com.sinco.carnation.jiuye.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 酒业订单类
 * 
 * @author yuanming
 * 
 */
public class JiuyeOrder extends BaseModel {

	private static final long serialVersionUID = 4292713018237027394L;

	// 主键ID
	private Long id;
	// 酒业订单ID
	private Long orderId;
	// 是否评价YES NO
	private String isComment;
	// 订单详情
	private String orderDetailDto;
	// 订单时间
	private Date orderDt;
	// 订单状态【1.待付款；2.待发货;3.已发货【配送中】;4.已完成【已收货】;5.退款中;6.已取消;7.已关闭;8.退货中;9.已退款;
	private int orderStatus;
	// 订单类型
	private int orderType;
	// 订单编号
	private String orderNo;
	// 支付金额
	private BigDecimal payMoney;
	// 手机号
	private String phone;
	// 平台支付编号
	private String platPayNo;
	// 真实支付金额
	private BigDecimal realPayMoney;
	// 商品总数量
	private int totalCount;
	// 总优惠券
	private BigDecimal totalFree;
	// 运费
	private BigDecimal transFee;
	// 用户ID
	private Long ysuserId;
	// 地址
	private String address;
	// 优惠券编号
	private String couponNo;
	// 创建时间
	private Date addTime;
	// 最后修改时间
	private Date lastUpdateTime;
	// 支付方式
	private int paymentId;
	// 流水号 在线支付每次随机生成
	private String tradeNo;
	// 支付时间
	private Date payTime;
	// 收货人姓名
	private String receiver;
	
	//显示状态
	private Integer showStatus;

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

	public Long getYsuserId() {
		return ysuserId;
	}

	public void setYsuserId(Long ysuserId) {
		this.ysuserId = ysuserId;
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

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Integer getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Integer showStatus) {
		this.showStatus = showStatus;
	}

}