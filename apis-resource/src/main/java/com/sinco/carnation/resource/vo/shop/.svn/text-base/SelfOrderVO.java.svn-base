package com.sinco.carnation.resource.vo.shop;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;

public class SelfOrderVO extends BasicPageParamVo {

	@Param(desc = "订单类型 order_submit:为已提交待付款 order_pay:为已付款待发货，order_shipping:为已发货待收货 order_receive:为已收货order_finish:买家评价完毕")
	private String orderStatus;

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
