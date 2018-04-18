package com.sinco.carnation.resource.vo.o2o;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class OrderDetailsVO extends BasicPageParamVo {

	@Param(desc = "订单类型，1 线上订单  2 线下刷卡订单")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer orderType;

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

}
