package com.sinco.carnation.resource.bo.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GoodsChildInfo", desc = "子订单信息")
public class GoodsChildInfo {

	@JsonProperty("orderId")
	@FieldMapping(desc = "id")
	private String order_id;

	@JsonProperty("orderGoodsInfo")
	@FieldMapping(desc = "子订单信息")
	private List<ShopGoodsInfo> order_goods_info;

	public String getOrder_id() {
		return order_id;
	}

	public List<ShopGoodsInfo> getOrder_goods_info() {
		return order_goods_info;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public void setOrder_goods_info(List<ShopGoodsInfo> order_goods_info) {
		this.order_goods_info = order_goods_info;
	}

}
