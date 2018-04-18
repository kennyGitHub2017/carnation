package com.sinco.carnation.resource.vo.personal;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class GroupStoreCommentVO extends BasicParamVO {

	@Param(desc = "服务id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long gId;

	@Param(desc = "纬度")
	private Double storeLon;

	@Param(desc = "经度")
	private Double storeLat;

	public Long getgId() {
		return gId;
	}

	public void setgId(Long gId) {
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
}
