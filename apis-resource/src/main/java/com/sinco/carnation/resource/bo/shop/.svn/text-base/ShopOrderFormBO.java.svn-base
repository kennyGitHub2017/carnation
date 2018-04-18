package com.sinco.carnation.resource.bo.shop;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OrderForm", desc = "订单")
public class ShopOrderFormBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("goodsAmount")
	@FieldMapping(desc = "商品总价格")
	private BigDecimal goodsAmount;

	@JsonProperty("orderForm")
	@FieldMapping(desc = "订单种类 0为商家，1为自营商品订单")
	private Integer orderForm;

	@JsonProperty("orderId")
	@FieldMapping(desc = "订单号")
	private String orderId;

	@JsonProperty("orderStatus")
	@FieldMapping(desc = "订单状态")
	private Integer orderStatus;

	@JsonProperty("storeName")
	@FieldMapping(desc = "订单对应店铺名称")
	private String storeName;

	/** 订单对应店铺id **/
	@JsonProperty("storeId")
	@FieldMapping(desc = "订单对应店铺id")
	private String storeId;

	/** 订单总价格 **/
	@JsonProperty("totalPrice")
	@FieldMapping(desc = "订单总价格")
	private BigDecimal totalPrice;

	@JsonProperty("infoList")
	@FieldMapping(desc = "订单商品信息对象")
	private List<ShopGoodsInfo> infoList;

	/** 云购币订单字段 **/
	@JsonProperty("allygPrice")
	@FieldMapping(desc = "云购币总和")
	private BigDecimal allygPrice;

	@JsonProperty("allCashPrice")
	@FieldMapping(desc = "现金总和")
	private BigDecimal allCashPrice;

	@JsonProperty("actualPrice")
	@FieldMapping(desc = "已支付现金")
	private BigDecimal actualPrice;

	@JsonProperty("actualygPrice")
	@FieldMapping(desc = "已支付云购币")
	private BigDecimal actualygPrice;

	@JsonProperty("orderTypeFlag")
	@FieldMapping(desc = "订单特殊标识 0 普通 1 元购订单 2 云购币[非专区]")
	private Integer orderTypeFlag;
	
	@JsonProperty("isygOrder")
	@FieldMapping(desc = "是否是云购币专区订单")
	private Boolean isygOrder;
	
	@JsonProperty("payTypeFlag")
	@FieldMapping(desc = "订单支付方式 1重消 2积分")
	private Integer payTypeFlag;
	
	@JsonProperty("orderDetailUrl")
	@FieldMapping(desc = "订单详情URL")
	private String orderDetailUrl;

	public Long getId() {
		return id;
	}

	public BigDecimal getGoodsAmount() {
		return goodsAmount;
	}

	public Integer getOrderForm() {
		return orderForm;
	}

	public String getOrderId() {
		return orderId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public String getStoreName() {
		return storeName;
	}

	public String getStoreId() {
		return storeId;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGoodsAmount(BigDecimal goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public void setOrderForm(Integer orderForm) {
		this.orderForm = orderForm;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ShopGoodsInfo> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<ShopGoodsInfo> infoList) {
		this.infoList = infoList;
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

	public BigDecimal getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(BigDecimal actualPrice) {
		this.actualPrice = actualPrice;
	}

	public BigDecimal getActualygPrice() {
		return actualygPrice;
	}

	public void setActualygPrice(BigDecimal actualygPrice) {
		this.actualygPrice = actualygPrice;
	}

	public Integer getOrderTypeFlag() {
		return orderTypeFlag;
	}

	public void setOrderTypeFlag(Integer orderTypeFlag) {
		this.orderTypeFlag = orderTypeFlag;
	}

	public Boolean getIsygOrder() {
		if (null != isygOrder) {
			return false;
		}
		return isygOrder;
	}

	public void setIsygOrder(Boolean isygOrder) {
		this.isygOrder = isygOrder;
	}

	public Integer getPayTypeFlag() {
		return payTypeFlag;
	}

	public void setPayTypeFlag(Integer payTypeFlag) {
		this.payTypeFlag = payTypeFlag;
	}

	public String getOrderDetailUrl() {
		return orderDetailUrl;
	}

	public void setOrderDetailUrl(String orderDetailUrl) {
		this.orderDetailUrl = orderDetailUrl;
	}

}
