package com.sinco.carnation.resource.web.response.jiuye;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class PayStateCheckResponse extends BaseJsonResult {

	@JsonProperty("hasPay")
	@ReturnMapping(desc = "是否已支付，false 未支付 true 已支付")
	private boolean hasPay;

	@JsonProperty("payTime")
	@ReturnMapping(desc = "支付时间")
	private String payTime;

	public boolean isHasPay() {
		return hasPay;
	}

	public void setHasPay(boolean hasPay) {
		this.hasPay = hasPay;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

}
