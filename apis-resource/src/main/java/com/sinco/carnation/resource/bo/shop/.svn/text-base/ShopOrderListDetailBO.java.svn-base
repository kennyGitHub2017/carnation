package com.sinco.carnation.resource.bo.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ShopOrderListDetail", desc = "订单详情列表")
public class ShopOrderListDetailBO {

	@JsonProperty("shopUserAddress")
	@FieldMapping(desc = "默认地址对象")
	private ShopUserAddressBO shopUserAddress;

	@JsonProperty("orderList")
	@FieldMapping(desc = "订单列表")
	private List<ShopOrderListBO> orderList;

	public ShopUserAddressBO getShopUserAddress() {
		return shopUserAddress;
	}

	public List<ShopOrderListBO> getOrderList() {
		return orderList;
	}

	public void setShopUserAddress(ShopUserAddressBO shopUserAddress) {
		this.shopUserAddress = shopUserAddress;
	}

	public void setOrderList(List<ShopOrderListBO> orderList) {
		this.orderList = orderList;
	}
}
