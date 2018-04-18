package com.sinco.carnation.resource.web.response.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;
import com.sinco.carnation.resource.bo.market.ActivityHotSaleApiBO;

public class SaleActivityMainResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("activityHotSaleApiBO")
	@ReturnMapping(desc = "促销活动信息")
	ActivityHotSaleApiBO activityHotSaleApiBO;

	public ActivityHotSaleApiBO getActivityHotSaleApiBO() {
		return activityHotSaleApiBO;
	}

	public void setActivityHotSaleApiBO(ActivityHotSaleApiBO activityHotSaleApiBO) {
		this.activityHotSaleApiBO = activityHotSaleApiBO;
	}

}
