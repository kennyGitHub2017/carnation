package com.sinco.carnation.resource.vo.personal;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PGroupDetailsVO extends BasicParamVO {

	@Param(desc = "订单id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long orderId;

	@Param(desc = "纬度")
	private Double storeLon;

	@Param(desc = "经度")
	private Double storeLat;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(Double storeLon) {
		this.storeLon = storeLon;
	}

	public Double getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(Double storeLat) {
		this.storeLat = storeLat;
	}
}
