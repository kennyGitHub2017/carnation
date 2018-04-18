package com.sinco.carnation.resource.web.response.aio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.aio.CholMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class AioCholResponse extends BaseJsonResult {

	@JsonProperty("cholList")
	@ReturnMapping(desc = "胆固醇列表")
	private List<CholMO> cholList;

	public List<CholMO> getCholList() {
		return cholList;
	}

	public void setCholList(List<CholMO> cholList) {
		this.cholList = cholList;
	}

}
