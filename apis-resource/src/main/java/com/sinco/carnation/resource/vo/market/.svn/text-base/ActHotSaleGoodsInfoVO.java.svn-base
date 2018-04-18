package com.sinco.carnation.resource.vo.market;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ActHotSaleGoodsInfoVO extends BasicPageParamVo {

	@Param(desc = "促销活动id|必须")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long actHotSaleId;

	public Long getActHotSaleId() {
		return actHotSaleId;
	}

	public void setActHotSaleId(Long actHotSaleId) {
		this.actHotSaleId = actHotSaleId;
	}

}
