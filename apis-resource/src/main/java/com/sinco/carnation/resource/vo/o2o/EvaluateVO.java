package com.sinco.carnation.resource.vo.o2o;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class EvaluateVO extends BasicParamVO {

	@Param(desc = "订单id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long orderId;

	@Param(desc = "评价内容")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String context;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
