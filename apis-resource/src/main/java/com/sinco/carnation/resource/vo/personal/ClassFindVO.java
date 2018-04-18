package com.sinco.carnation.resource.vo.personal;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ClassFindVO extends BasicPageParamVo {

	@Param(desc = "分类id")
	private Long classId;

	@Param(desc = "城市id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long cityId;

	@Param(desc = "地区id")
	private Long areaId;

	@Param(desc = "距离|米")
	private Integer distance;

	@Param(desc = "智能排序类型|1距离2好评3智能")
	private Integer orderType;

	@Param(desc = "纬度")
	private Double storeLat;

	@Param(desc = "经度")
	private Double storeLon;

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Double getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(Double storeLat) {
		this.storeLat = storeLat;
	}

	public Double getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(Double storeLon) {
		this.storeLon = storeLon;
	}

}
