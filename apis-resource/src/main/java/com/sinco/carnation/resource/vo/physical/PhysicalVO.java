package com.sinco.carnation.resource.vo.physical;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

/**
 * 体检宝
 * 
 * @author king
 * 
 */
public class PhysicalVO extends BasicParamVO {

	@Param(desc = "体检最小值|视力检查")
	private Float minValue;

	@Param(desc = "体检最大值|如果只有一个值或者体检最大值|色盲测试")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Float maxValue;

	@Param(desc = "散光测试")
	private Float middleValue;

	@Param(desc = "类型|1视力表2视力检测3色盲测试4散光测试5听力6血压7心率8肺活量9血氧")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer type;

	@Param(desc = "时间|如：2015-07-08")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String time;

	@Param(desc = "终端类型：0:PC,1:android,2:ios")
	private Integer terminalType;// 终端类型：0:PC，1:android，2:ios

	@Param(desc = "地区id|市级")
	private Long areaId;

	@Param(desc = "纬度")
	private Double storeLon;

	@Param(desc = "经度")
	private Double storeLat;

	public Float getMinValue() {
		return minValue;
	}

	public Float getMaxValue() {
		return maxValue;
	}

	public Integer getType() {
		return type;
	}

	public void setMinValue(Float minValue) {
		this.minValue = minValue;
	}

	public void setMaxValue(Float maxValue) {
		this.maxValue = maxValue;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Float getMiddleValue() {
		return middleValue;
	}

	public void setMiddleValue(Float middleValue) {
		this.middleValue = middleValue;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(Integer terminalType) {
		this.terminalType = terminalType;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Double getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(Double storeLon) {
		this.storeLon = storeLon;
	}

	public Double getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(Double storeLat) {
		this.storeLat = storeLat;
	}

}
