package com.sinco.carnation.resource.vo.personal;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class YouLikeGoodsVO extends BasicParamVO {

	@Param(desc = "服务id|以逗号隔开")
	private String gId;

	@Param(desc = "纬度")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Double storeLon;

	@Param(desc = "经度")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Double storeLat;

	@Param(desc = "地区id")
	private Long areaId;

	public String getgId() {
		return gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
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

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
}
