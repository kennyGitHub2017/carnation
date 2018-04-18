package com.sinco.carnation.resource.web.response.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.PageQueryResponse;
import com.sinco.carnation.resource.bo.shop.ReturnGoodsLogBO;

@SuppressWarnings("serial")
public class ShopTradeReturnListResponse extends PageQueryResponse {

	@ReturnMapping(desc="主订单对象")
	@JsonProperty("list")
	private List<ReturnGoodsLogBO> list;

	public List<ReturnGoodsLogBO> getList() {
		return list;
	}

	public void setList(List<ReturnGoodsLogBO> list) {
		this.list = list;
	}
	
}
