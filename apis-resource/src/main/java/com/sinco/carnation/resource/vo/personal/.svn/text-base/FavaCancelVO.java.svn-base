package com.sinco.carnation.resource.vo.personal;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class FavaCancelVO extends BasicParamVO {

	@Param(desc = "取消id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long fid;

	@Param(desc = "类型|4商城5服务6商户")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer type;

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
