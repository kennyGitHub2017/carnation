package com.sinco.carnation.resource.web.response.aio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.aio.UaMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class AioUaResponse extends BaseJsonResult {

	@JsonProperty("uaList")
	@ReturnMapping(desc = "尿酸列表")
	private List<UaMO> uaList;

	public List<UaMO> getUaList() {
		return uaList;
	}

	public void setUaList(List<UaMO> uaList) {
		this.uaList = uaList;
	}

}
