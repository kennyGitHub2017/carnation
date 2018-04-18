package com.sinco.carnation.resource.web.response.jiuye;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.jiuye.JiuyeOrderMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class JiuyeOrderResponse extends BaseJsonResult {

	@JsonProperty("jiuyeOrder")
	@ReturnMapping(desc = "订单信息")
	private JiuyeOrderMO jiuyeOrder;

	public JiuyeOrderMO getJiuyeOrder() {
		return jiuyeOrder;
	}

	public void setJiuyeOrder(JiuyeOrderMO jiuyeOrder) {
		this.jiuyeOrder = jiuyeOrder;
	}

}
