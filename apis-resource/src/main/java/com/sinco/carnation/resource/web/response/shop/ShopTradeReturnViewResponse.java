package com.sinco.carnation.resource.web.response.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.shop.ReturnGoodsLogBO;

@SuppressWarnings("serial")
public class ShopTradeReturnViewResponse extends ApiResponse {

	@ReturnMapping(desc = "退货信息")
	@JsonProperty("returnGoodsLog")
	private ReturnGoodsLogBO returnGoodsLog;

	public ReturnGoodsLogBO getReturnGoodsLog() {
		return returnGoodsLog;
	}

	public void setReturnGoodsLog(ReturnGoodsLogBO returnGoodsLog) {
		this.returnGoodsLog = returnGoodsLog;
	}
}
