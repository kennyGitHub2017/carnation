package com.sinco.carnation.resource.vo.search;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class CancelOrderVO extends BasicParamVO {

	@Param(desc = "订单id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long orderId;

	@Param(desc = "取消原因")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String stateInfo;

	public Long getOrderId() {
		return orderId;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
}
