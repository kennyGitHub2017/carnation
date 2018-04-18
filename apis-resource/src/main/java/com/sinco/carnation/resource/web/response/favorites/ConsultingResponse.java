package com.sinco.carnation.resource.web.response.favorites;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.ConsultingBO;

public class ConsultingResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("consultingBO")
	@ReturnMapping(desc = "提问对象")
	private ConsultingBO consultingBO;

	public ConsultingBO getConsultingBO() {
		return consultingBO;
	}

	public void setConsultingBO(ConsultingBO consultingBO) {
		this.consultingBO = consultingBO;
	}

}
