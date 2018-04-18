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
public class PhysicalSevenTimesResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("physicalBloodPressure")
	@ReturnMapping(desc = "血压")
	private List<PhysicalBO> physicalBloodPressure;

	@JsonProperty("physicalHeartRate")
	@ReturnMapping(desc = "心率")
	private List<PhysicalBO> physicalHeartRate;

	@JsonProperty("physicalVision")
	@ReturnMapping(desc = "视力")
	private List<PhysicalBO> physicalVision;

	@JsonProperty("physicalHearing")
	@ReturnMapping(desc = "听力")
	private List<PhysicalBO> physicalHearing;

	@JsonProperty("physicalVitalCapacity")
	@ReturnMapping(desc = "肺活量")
	private List<PhysicalBO> physicalVitalCapacity;

	@JsonProperty("physicalBloodOxygen")
	@ReturnMapping(desc = "血氧")
	private List<PhysicalBO> physicalBloodOxygen;

	public List<PhysicalBO> getPhysicalBloodPressure() {
		return physicalBloodPressure;
	}

	public void setPhysicalBloodPressure(List<PhysicalBO> physicalBloodPressure) {
		this.physicalBloodPressure = physicalBloodPressure;
	}

	public List<PhysicalBO> getPhysicalHeartRate() {
		return physicalHeartRate;
	}

	public void setPhysicalHeartRate(List<PhysicalBO> physicalHeartRate) {
		this.physicalHeartRate = physicalHeartRate;
	}

	public List<PhysicalBO> getPhysicalVision() {
		return physicalVision;
	}

	public void setPhysicalVision(List<PhysicalBO> physicalVision) {
		this.physicalVision = physicalVision;
	}

	public List<PhysicalBO> getPhysicalHearing() {
		return physicalHearing;
	}

	public void setPhysicalHearing(List<PhysicalBO> physicalHearing) {
		this.physicalHearing = physicalHearing;
	}

	public List<PhysicalBO> getPhysicalVitalCapacity() {
		return physicalVitalCapacity;
	}

	public void setPhysicalVitalCapacity(List<PhysicalBO> physicalVitalCapacity) {
		this.physicalVitalCapacity = physicalVitalCapacity;
	}

	public List<PhysicalBO> getPhysicalBloodOxygen() {
		return physicalBloodOxygen;
	}

	public void setPhysicalBloodOxygen(List<PhysicalBO> physicalBloodOxygen) {
		this.physicalBloodOxygen = physicalBloodOxygen;
	}

}
