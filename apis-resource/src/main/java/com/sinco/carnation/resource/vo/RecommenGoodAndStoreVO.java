package com.sinco.carnation.resource.vo;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class RecommenGoodAndStoreVO extends BasicParamVO {

	@Param(desc = "套题id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long groupId;

	@Param(desc = "纬度")
	private Double storeLon;

	@Param(desc = "经度")
	private Double storeLat;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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
