package com.sinco.carnation.resource.vo.shop;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ShopTradeReturnShipSaveVO extends BasicParamVO {

	@Param(desc = "退货记录id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long returnGoodsLogId;

	@Param(desc = "物流公司id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long expressId;

	@Param(desc = "订单号")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String expressCode;

	public Long getReturnGoodsLogId() {
		return returnGoodsLogId;
	}

	public void setReturnGoodsLogId(Long returnGoodsLogId) {
		this.returnGoodsLogId = returnGoodsLogId;
	}

	public Long getExpressId() {
		return expressId;
	}

	public void setExpressId(Long expressId) {
		this.expressId = expressId;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}
}
