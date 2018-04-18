package com.sinco.carnation.resource.web.response.personal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.o2o.GroupAreaBO;

public class HotCityResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("hotCity")
	@ReturnMapping(desc = "热门城市")
	private List<GroupAreaBO> hotCity;

	public List<GroupAreaBO> getHotCity() {
		return hotCity;
	}

	public void setHotCity(List<GroupAreaBO> hotCity) {
		this.hotCity = hotCity;
	}

}
