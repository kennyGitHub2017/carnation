package com.sinco.carnation.resource.web.response.elong;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.elong.ElongOrderMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class ElongOrderResponse extends BaseJsonResult {

	@JsonProperty("elongOrderList")
	@ReturnMapping(desc = "订单列表")
	private List<ElongOrderMO> elongOrderList;

	@JsonProperty("elongOrder")
	@ReturnMapping(desc = "订单信息")
	private ElongOrderMO elongOrder;

	public List<ElongOrderMO> getElongOrderList() {
		return elongOrderList;
	}

	public void setElongOrderList(List<ElongOrderMO> elongOrderList) {
		this.elongOrderList = elongOrderList;
	}

	public ElongOrderMO getElongOrder() {
		return elongOrder;
	}

	public void setElongOrder(ElongOrderMO elongOrder) {
		this.elongOrder = elongOrder;
	}

}
