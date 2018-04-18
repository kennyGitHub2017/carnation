package com.sinco.carnation.resource.web.response.personal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.o2o.GroupOrderBO;

/**
 * 
 * @author james
 * 
 */
public class GroupTradePaymetViewResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ReturnMapping(desc = "主订单对象")
	@JsonProperty("order")
	private GroupOrderBO order;

	public GroupOrderBO getOrder() {
		return order;
	}

	public void setOrder(GroupOrderBO order) {
		this.order = order;
	}

}
