package com.sinco.carnation.resource.vo.shop;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ShopAddCartVO extends BasicParamVO {

	@Param(desc = "商品id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private long goodId;

	@Param(desc = "商品数量")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer count;

	@Param(desc = "商品的属性值，这里传递id值，如12,1,21")
	// @NotBlank(message=MsgCodeConstant.ERROR_PARAM)
	private String gsp;

	public long getGoodId() {
		return goodId;
	}

	public Integer getCount() {
		return count;
	}

	public String getGsp() {
		return gsp;
	}

	public void setGoodId(long goodId) {
		this.goodId = goodId;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setGsp(String gsp) {
		this.gsp = gsp;
	}

}
