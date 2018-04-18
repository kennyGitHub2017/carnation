package com.sinco.carnation.resource.web.response.shop;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.shop.ShopGoodsCartBO;
import com.sinco.carnation.resource.bo.shop.ShopOrderListDetailBO;
import com.sinco.carnation.resource.bo.shop.ShopUserAddressBO;
import com.sinco.carnation.resource.bo.shop.TransBO;

public class ShopCartResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("cartList")
	@ReturnMapping(desc = "平台购物车列表")
	private List<ShopGoodsCartBO> cartList;

	@JsonProperty("cnCartList")
	@ReturnMapping(desc = "cn购物车列表")
	private List<ShopGoodsCartBO> cnCartList;

	@JsonProperty("ygbCartList")
	@ReturnMapping(desc = "云购币购物车列表")
	private List<ShopGoodsCartBO> ygbCartList;

	@JsonProperty("cartListSize")
	@ReturnMapping(desc = "cn购物车Size")
	private Integer cartListSize;

	@JsonProperty("cnCartListSize")
	@ReturnMapping(desc = "cn购物车Size")
	private Integer cnCartListSize;

	@JsonProperty("ygbCartListSize")
	@ReturnMapping(desc = "cn购物车Size")
	private Integer ygbCartListSize;

	@JsonProperty("gcId")
	@ReturnMapping(desc = "购物车商品id")
	private Long gcId;

	@JsonProperty("totalPrice")
	@ReturnMapping(desc = "商品总价")
	private BigDecimal totalPrice;

	@JsonProperty("orderList")
	@ReturnMapping(desc = "订单列表")
	private ShopOrderListDetailBO orderList;

	@JsonProperty("userAddressAll")
	@ReturnMapping(desc = "用户所有收货地址列表")
	private List<ShopUserAddressBO> userAddressAll;

	@JsonProperty("defaultAddress")
	@ReturnMapping(desc = "用户默认地址")
	private ShopUserAddressBO defaultAddress;

	@JsonProperty("trans")
	@ReturnMapping(desc = "运送方式")
	private List<TransBO> trans;

	@JsonProperty("shopCartSize")
	@ReturnMapping(desc = "购物车商品数量")
	private Integer shopCartSize;

	@JsonProperty("allGoodsFree")
	@ReturnMapping(desc = "精品专区总邮费")
	private BigDecimal allGoodsFree;
	
	@JsonProperty("freeShipAmount")
	@ReturnMapping(desc = "精品专区积分购买包邮")
	private Integer freeShipAmount;
	
	
	public List<ShopGoodsCartBO> getCnCartList() {
		return cnCartList;
	}

	public void setCnCartList(List<ShopGoodsCartBO> cnCartList) {
		this.cnCartList = cnCartList;
	}

	public List<ShopGoodsCartBO> getYgbCartList() {
		return ygbCartList;
	}

	public void setYgbCartList(List<ShopGoodsCartBO> ygbCartList) {
		this.ygbCartList = ygbCartList;
	}

	public Integer getCartListSize() {
		return cartListSize;
	}

	public void setCartListSize(Integer cartListSize) {
		this.cartListSize = cartListSize;
	}

	public Integer getCnCartListSize() {
		return cnCartListSize;
	}

	public void setCnCartListSize(Integer cnCartListSize) {
		this.cnCartListSize = cnCartListSize;
	}

	public Integer getYgbCartListSize() {
		return ygbCartListSize;
	}

	public void setYgbCartListSize(Integer ygbCartListSize) {
		this.ygbCartListSize = ygbCartListSize;
	}

	public ShopOrderListDetailBO getOrderList() {
		return orderList;
	}

	public void setOrderList(ShopOrderListDetailBO orderList) {
		this.orderList = orderList;
	}

	public List<ShopGoodsCartBO> getCartList() {
		return cartList;
	}

	public void setCartList(List<ShopGoodsCartBO> cartList) {
		this.cartList = cartList;
	}

	public Long getGcId() {
		return gcId;
	}

	public void setGcId(Long gcId) {
		this.gcId = gcId;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ShopUserAddressBO> getUserAddressAll() {
		return userAddressAll;
	}

	public void setUserAddressAll(List<ShopUserAddressBO> userAddressAll) {
		this.userAddressAll = userAddressAll;
	}

	public ShopUserAddressBO getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(ShopUserAddressBO defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public List<TransBO> getTrans() {
		return trans;
	}

	public void setTrans(List<TransBO> trans) {
		this.trans = trans;
	}

	public Integer getShopCartSize() {
		return shopCartSize;
	}

	public void setShopCartSize(Integer shopCartSize) {
		this.shopCartSize = shopCartSize;
	}

	public BigDecimal getAllGoodsFree() {
		return allGoodsFree;
	}

	public void setAllGoodsFree(BigDecimal allGoodsFree) {
		this.allGoodsFree = allGoodsFree;
	}

	public Integer getFreeShipAmount() {
		return freeShipAmount;
	}

	public void setFreeShipAmount(Integer freeShipAmount) {
		this.freeShipAmount = freeShipAmount;
	}


}
