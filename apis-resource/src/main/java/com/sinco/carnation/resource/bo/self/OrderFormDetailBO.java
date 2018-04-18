package com.sinco.carnation.resource.bo.self;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OrderForfDetail", desc = "订单详情")
public class OrderFormDetailBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("orderId")
	@FieldMapping(desc = "订单号")
	private String orderId;

	@JsonProperty("orderStatus")
	@FieldMapping(desc = "订单状态  订单状态，0为订单取消，10为已提交待付款，15为线下付款提交申请，16为货到付款，20为已付款待发货，30为已发货待收货，40为已收货，50买家评价完毕 ,65订单不可评价，到达设定时间，系统自动关闭订单相互评价功能")
	private Integer orderStatus;

	@JsonProperty("receiverMobile")
	@FieldMapping(desc = "收货人手机号码")
	private String receiverMobile;

	@JsonProperty("storeId")
	@FieldMapping(desc = "订单对应店铺id")
	private String storeId;

	@JsonProperty("receiverName")
	@FieldMapping(desc = "收货人姓名")
	private String receiverName;

	@JsonProperty("receiverArea")
	@FieldMapping(desc = "收货人地区 ")
	private String receiverArea;

	@JsonProperty("receiverAreaInfo")
	@FieldMapping(desc = "收货人详细地址")
	private String receiverAreaInfo;

	@JsonProperty("couponAmount")
	@FieldMapping(desc = "优惠券金额")
	private double couponAmount;

	@JsonProperty("addTime")
	@FieldMapping(desc = "下单时间")
	private Date addTime;

	@JsonProperty("shipPrice")
	@FieldMapping(desc = "配送价格 ")
	private double shipPrice;

	@JsonProperty("orderFormList")
	@FieldMapping(desc = "订单列表 ")
	private List<SelfOrderBO> orderFormList;

	@JsonProperty("storeName")
	@FieldMapping(desc = "订单对应店铺名称")
	private String storeName;

	@JsonProperty("goodsAmount")
	@FieldMapping(desc = "商品总价格")
	private double goodsAmount;

	@JsonProperty("expressCompanyId")
	@FieldMapping(desc = "快递公司id")
	private Integer expressCompanyId;

	@JsonProperty("shipCode")
	@FieldMapping(desc = "物流单号")
	private String shipCode;

	@JsonProperty("totalPrice")
	@FieldMapping(desc = "订单总价")
	private BigDecimal totalPrice;

	@JsonProperty("price")
	@FieldMapping(desc = "订单实付总价")
	private BigDecimal price;

	@JsonProperty("allygPrice")
	@FieldMapping(desc = "云购币总和")
	private BigDecimal allygPrice;
	@JsonProperty("allCashPrice")
	@FieldMapping(desc = "云购产品现金总和")
	private BigDecimal allCashPrice;

	@JsonProperty("actualygPrice")
	@FieldMapping(desc = "云购币订单实际支付云购币")
	private BigDecimal actualygPrice;
	@JsonProperty("actualPrice")
	@FieldMapping(desc = "云购币订单实际支付现金  ")
	private BigDecimal actualPrice;
	
	@JsonProperty("actualIntegral")
	@FieldMapping(desc = "实际支付积分")
	private BigDecimal actualIntegral;
	
	@JsonProperty("allIntegral")
	@FieldMapping(desc = "订单需要积分总和")
	private BigDecimal allIntegral;
	
	@JsonProperty("commissionAmount")
	@FieldMapping(desc = "佣金总费用/BV")
	private BigDecimal commissionAmount;

	@JsonProperty("orderTypeFlag")
	@FieldMapping(desc = "0普通 1零元购 2云购币[非专区] 3云购币专区 ")
	private Integer orderTypeFlag;
	
	@JsonProperty("payTypeFlag")
	@FieldMapping(desc = "1重消+现金 2积分+现金   ")
	private Integer payTypeFlag;

	@JsonProperty("paymentName")
	@FieldMapping(desc = "支付类型")
	private String paymentName;
	
	@JsonProperty("leftTime")
	@FieldMapping(desc = "订单剩余时间")
	private Long leftTime;

	public String getStoreName() {
		return storeName;
	}

	public double getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(double goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getId() {
		return id;
	}

	public String getOrderId() {
		return orderId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public String getStoreId() {
		return storeId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverArea() {
		return receiverArea;
	}

	public String getReceiverAreaInfo() {
		return receiverAreaInfo;
	}

	public double getCouponAmount() {
		return couponAmount;
	}

	public Date getAddTime() {
		return addTime;
	}

	public double getShipPrice() {
		return shipPrice;
	}

	public List<SelfOrderBO> getOrderFormList() {
		return orderFormList;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiverArea(String receiverArea) {
		this.receiverArea = receiverArea;
	}

	public void setReceiverAreaInfo(String receiverAreaInfo) {
		this.receiverAreaInfo = receiverAreaInfo;
	}

	public void setCouponAmount(double couponAmount) {
		this.couponAmount = couponAmount;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public void setShipPrice(double shipPrice) {
		this.shipPrice = shipPrice;
	}

	public void setOrderFormList(List<SelfOrderBO> orderFormList) {
		this.orderFormList = orderFormList;
	}

	public Integer getExpressCompanyId() {
		return expressCompanyId;
	}

	public void setExpressCompanyId(Integer expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getAllygPrice() {
		return allygPrice;
	}

	public void setAllygPrice(BigDecimal allygPrice) {
		this.allygPrice = allygPrice;
	}

	public BigDecimal getAllCashPrice() {
		return allCashPrice;
	}

	public void setAllCashPrice(BigDecimal allCashPrice) {
		this.allCashPrice = allCashPrice;
	}

	public BigDecimal getActualygPrice() {
		return actualygPrice;
	}

	public void setActualygPrice(BigDecimal actualygPrice) {
		this.actualygPrice = actualygPrice;
	}

	public BigDecimal getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(BigDecimal actualPrice) {
		this.actualPrice = actualPrice;
	}

	public BigDecimal getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(BigDecimal commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public Integer getOrderTypeFlag() {
		return orderTypeFlag;
	}

	public void setOrderTypeFlag(Integer orderTypeFlag) {
		this.orderTypeFlag = orderTypeFlag;
	}

	public Integer getPayTypeFlag() {
		return payTypeFlag;
	}

	public void setPayTypeFlag(Integer payTypeFlag) {
		this.payTypeFlag = payTypeFlag;
	}

	public BigDecimal getActualIntegral() {
		return actualIntegral;
	}

	public void setActualIntegral(BigDecimal actualIntegral) {
		this.actualIntegral = actualIntegral;
	}

	public BigDecimal getAllIntegral() {
		return allIntegral;
	}

	public void setAllIntegral(BigDecimal allIntegral) {
		this.allIntegral = allIntegral;
	}

	public Long getLeftTime() {
		return leftTime;
	}

	public void setLeftTime(Long leftTime) {
		this.leftTime = leftTime;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}



}
