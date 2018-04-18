package com.sinco.carnation.resource.vo.personal;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;

public class MyselfGroupOrderVO extends BasicPageParamVo {

	@Param(desc = "状态|0已取消,10未付款20未使用,30已使用100退款|")
	private Integer status;

	@Param(desc = "订单类型1|线上订单2|扫码支付3|优惠买单4|套餐券5代金券")
	private Integer orderType;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

}
