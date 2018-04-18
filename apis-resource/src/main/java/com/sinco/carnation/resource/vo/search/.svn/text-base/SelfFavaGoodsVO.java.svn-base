package com.sinco.carnation.resource.vo.search;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class SelfFavaGoodsVO extends BasicPageParamVo {

	@Param(desc = "收藏类型3商品|4商铺")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer type;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
