package com.sinco.carnation.resource.web.response.aio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.aio.EcgMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class AioEcgResponse extends BaseJsonResult {

	@JsonProperty("ecgList")
	@ReturnMapping(desc = "心率列表")
	private List<EcgMO> ecgList;

	public List<EcgMO> getEcgList() {
		return ecgList;
	}

	public void setEcgList(List<EcgMO> ecgList) {
		this.ecgList = ecgList;
	}

}
