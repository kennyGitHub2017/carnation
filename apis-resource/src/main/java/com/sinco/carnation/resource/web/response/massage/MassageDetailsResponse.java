package com.sinco.carnation.resource.web.response.massage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.massage.MassageDetailsMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class MassageDetailsResponse extends BaseJsonResult {

	@JsonProperty("massageDetails")
	@ReturnMapping(desc = "按摩详细数据")
	private MassageDetailsMO massageDetails;

	public MassageDetailsMO getMassageDetails() {
		return massageDetails;
	}

	public void setMassageDetails(MassageDetailsMO massageDetails) {
		this.massageDetails = massageDetails;
	}

}
