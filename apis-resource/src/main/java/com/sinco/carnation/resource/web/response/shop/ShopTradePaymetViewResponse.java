package com.sinco.carnation.resource.web.response.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.shop.ShopOrderFormBO;
import com.sinco.carnation.resource.bo.shop.YgPayModeBO;

/**
 * 
 * @author james
 * 
 */
public class ShopTradePaymetViewResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ReturnMapping(desc = "主订单对象")
	@JsonProperty("order")
	private ShopOrderFormBO order;

	@ReturnMapping(desc = "订单总价")
	@JsonProperty("totalPrice")
	private double totalPrice;
	
	
	@ReturnMapping(desc = "云购币专区订单支付相关")
	@JsonProperty("ygPayMode")
	private YgPayModeBO ygPayMode;

	public ShopOrderFormBO getOrder() {
		return order;
	}

	public void setOrder(ShopOrderFormBO order) {
		this.order = order;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public YgPayModeBO getYgPayMode() {
		return ygPayMode;
	}

	public void setYgPayMode(YgPayModeBO ygPayMode) {
		this.ygPayMode = ygPayMode;
	}
	
	
	
}
