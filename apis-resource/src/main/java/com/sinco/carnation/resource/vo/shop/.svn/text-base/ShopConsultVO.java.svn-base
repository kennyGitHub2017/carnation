package com.sinco.carnation.resource.vo.shop;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ShopConsultVO extends BasicParamVO {

	@Param(desc = "商品id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long goodsId;

	@Param(desc = "商品咨询内容")
	// @Pattern(regexp="^[a-zA-Z0-9\u4E00-\u9FA5]+$")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String content;

	public Long getGoodsId() {
		return goodsId;
	}

	public String getContent() {
		return content;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
