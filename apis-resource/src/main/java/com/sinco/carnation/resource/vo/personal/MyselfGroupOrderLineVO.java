package com.sinco.carnation.resource.vo.personal;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;

public class MyselfGroupOrderLineVO extends BasicPageParamVo {

	@Param(desc = "订单类型|1线上2线下")
	// @NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer orderType;

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
}
