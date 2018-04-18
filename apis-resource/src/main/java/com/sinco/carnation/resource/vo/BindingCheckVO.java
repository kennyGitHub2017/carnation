package com.sinco.carnation.resource.vo;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class BindingCheckVO extends BasicParamVO {

	@Param(desc = "平台id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String openId;

	@Param(desc = "类型|3:QQ 4:微信5:微博")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer type;

	@Param(desc = "平台unionid")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String unionId;

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
