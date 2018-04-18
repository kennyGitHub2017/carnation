package com.sinco.carnation.resource.web.response.aio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.aio.AioBindingMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class AioBindingInfoResponse extends BaseJsonResult {

	@JsonProperty("aioBinding")
	@ReturnMapping(desc = "绑定信息")
	private AioBindingMO aioBindingInfo;

	public AioBindingMO getAioBindingInfo() {
		return aioBindingInfo;
	}

	public void setAioBindingInfo(AioBindingMO aioBindingInfo) {
		this.aioBindingInfo = aioBindingInfo;
	}

}
