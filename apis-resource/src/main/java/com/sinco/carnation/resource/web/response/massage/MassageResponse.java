package com.sinco.carnation.resource.web.response.massage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.massage.MassageMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class MassageResponse extends BaseJsonResult {

	@JsonProperty("massage")
	@ReturnMapping(desc = "按摩数据")
	private MassageMO massage;

	public MassageMO getMassage() {
		return massage;
	}

	public void setMassage(MassageMO massage) {
		this.massage = massage;
	}

}
