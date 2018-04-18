package com.sinco.carnation.resource.web.response.aio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.aio.GluMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class AioGluResponse extends BaseJsonResult {

	@JsonProperty("gluList")
	@ReturnMapping(desc = "血糖列表")
	private List<GluMO> gluList;

	public List<GluMO> getGluList() {
		return gluList;
	}

	public void setGluList(List<GluMO> gluList) {
		this.gluList = gluList;
	}

}
