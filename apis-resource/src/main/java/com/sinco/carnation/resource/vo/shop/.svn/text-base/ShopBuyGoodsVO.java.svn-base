package com.sinco.carnation.resource.vo.shop;

import javax.validation.constraints.NotNull;
import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ShopBuyGoodsVO extends BasicParamVO {

	@Param(desc = "商品id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long goodsId;

	@Param(desc = "数量")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer count;

	@Param(desc = "属性")
	private String gsp;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getGsp() {
		return gsp;
	}

	public void setGsp(String gsp) {
		this.gsp = gsp;
	}
}
