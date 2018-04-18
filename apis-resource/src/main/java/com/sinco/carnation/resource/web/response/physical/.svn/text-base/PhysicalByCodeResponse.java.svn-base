package com.sinco.carnation.resource.web.response.physical;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.PhysicalBO;

/**
 * 体检报
 * 
 * @author king
 * 
 */
public class PhysicalByCodeResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("physicalSeven")
	@ReturnMapping(desc = "某项体检最后七次结果")
	private List<PhysicalBO> physicalSeven;

	@JsonProperty("physicalAll")
	@ReturnMapping(desc = "某项体检所有结果")
	private List<PhysicalBO> physicalAll;

	public List<PhysicalBO> getPhysicalSeven() {
		return physicalSeven;
	}

	public void setPhysicalSeven(List<PhysicalBO> physicalSeven) {
		this.physicalSeven = physicalSeven;
	}

	public List<PhysicalBO> getPhysicalAll() {
		return physicalAll;
	}

	public void setPhysicalAll(List<PhysicalBO> physicalAll) {
		this.physicalAll = physicalAll;
	}

}
