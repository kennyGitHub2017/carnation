package com.sinco.carnation.resource.web.response.aio;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.aio.SysDiaMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class AioSysDiaResponse extends BaseJsonResult {

	@JsonProperty("sysDiaList")
	@ReturnMapping(desc = "血压列表")
	private List<SysDiaMO> sysDiaList;

	public List<SysDiaMO> getSysDiaList() {
		return sysDiaList;
	}

	public void setSysDiaList(List<SysDiaMO> sysDiaList) {
		this.sysDiaList = sysDiaList;
	}

}
