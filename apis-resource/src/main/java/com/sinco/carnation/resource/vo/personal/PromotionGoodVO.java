package com.sinco.carnation.resource.vo.personal;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PromotionGoodVO extends BasicPageParamVo {

	@Param(desc = "城市id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long cityId;

	@Param(desc = "纬度")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Double storeLon;

	@Param(desc = "经度")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Double storeLat;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
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
