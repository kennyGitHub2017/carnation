package com.sinco.carnation.resource.vo.shop;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ShopTradeReturnApplyVO extends BasicParamVO {

	@Param(desc = "订单id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long orderId;

	@Param(desc = "退货原因")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String returnGoodsContent;

	@Param(desc = "商品id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long goodsId;

	@Param(desc = "商品sku ids")
	private String goodsGspIds;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getReturnGoodsContent() {
		return returnGoodsContent;
	}

	public void setReturnGoodsContent(String returnGoodsContent) {
		this.returnGoodsContent = returnGoodsContent;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsGspIds() {
		return goodsGspIds;
	}

	public void setGoodsGspIds(String goodsGspIds) {
		this.goodsGspIds = goodsGspIds;
	}

}
