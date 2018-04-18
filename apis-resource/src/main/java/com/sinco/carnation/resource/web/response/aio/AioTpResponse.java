package com.sinco.carnation.resource.web.response.aio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.aio.TpMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class AioTpResponse extends BaseJsonResult {

	@JsonProperty("tpList")
	@ReturnMapping(desc = "体温列表")
	private List<TpMO> tpList;

	public List<TpMO> getTpList() {
		return tpList;
	}

	public void setTpList(List<TpMO> tpList) {
		this.tpList = tpList;
	}

}
