package com.sinco.carnation.resource.web.response.aio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.aio.SpoMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class AioSpoResponse extends BaseJsonResult {

	@JsonProperty("spoList")
	@ReturnMapping(desc = "血氧列表")
	private List<SpoMO> spoList;

	public List<SpoMO> getSpoList() {
		return spoList;
	}

	public void setSpoList(List<SpoMO> spoList) {
		this.spoList = spoList;
	}

}
