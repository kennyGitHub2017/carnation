package com.sinco.carnation.resource.vo.personal;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class RecommendStoreVO extends BasicPageParamVo {

	@Param(desc = "城市id")
	private Long areaId;

	@Param(desc = "纬度")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Double storeLon;

	@Param(desc = "经度")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Double storeLat;

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
