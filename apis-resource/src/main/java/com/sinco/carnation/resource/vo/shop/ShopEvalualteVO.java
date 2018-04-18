package com.sinco.carnation.resource.vo.shop;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;

public class ShopEvalualteVO extends BasicPageParamVo {

	@Param(desc = "评论类型|goods:商品")
	@NotBlank
	private String evaluateType;

	@Param(desc = "商品id")
	@NotNull
	private Long goodsId;

	@Param(desc = "100:晒单图片  |买家评价，评价类型，1为好评，0为中评，-1为差评 ，100 晒单")
	private String goodsEva;

	public String getEvaluateType() {
		return evaluateType;
	}

	public String getGoodsEva() {
		return goodsEva;
	}

	public void setEvaluateType(String evaluateType) {
		this.evaluateType = evaluateType;
	}

	public void setGoodsEva(String goodsEva) {
		this.goodsEva = goodsEva;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
}
