package com.sinco.carnation.resource.web.response.physical;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.PhysicalBO;
import com.sinco.carnation.resource.bo.PhysicalTypeApiBO;

/**
 * 体检报
 * 
 * @author king
 * 
 */
public class PhysicalResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("physical")
	@ReturnMapping(desc = "某天某项体检结果")
	private PhysicalBO physical;

	@JsonProperty("physicalArr")
	@ReturnMapping(desc = "某天所有项体检结果")
	private List<PhysicalBO> physicalArr;

	@JsonProperty("physicalType")
	@ReturnMapping(desc = "体检类型信息")
	private PhysicalTypeApiBO physicalType;

	public PhysicalBO getPhysical() {
		return physical;
	}

	public List<PhysicalBO> getPhysicalArr() {
		return physicalArr;
	}

	public void setPhysical(PhysicalBO physical) {
		this.physical = physical;
	}

	public void setPhysicalArr(List<PhysicalBO> physicalArr) {
		this.physicalArr = physicalArr;
	}

	public PhysicalTypeApiBO getPhysicalType() {
		return physicalType;
	}

	public void setPhysicalType(PhysicalTypeApiBO physicalType) {
		this.physicalType = physicalType;
	}

}
