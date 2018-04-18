package com.sinco.carnation.resource.vo.shop;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ShopGoodsDetailsVO extends BasicParamVO {

	@Param(desc = "购物车商品id，用逗号隔开|1,2,3,4,5,6,7")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String gcs;

	@Param(desc = "giftids")
	private String giftids;

	public String getGcs() {
		return gcs;
	}

	public String getGiftids() {
		return giftids;
	}

	public void setGcs(String gcs) {
		this.gcs = gcs;
	}

	public void setGiftids(String giftids) {
		this.giftids = giftids;
	}
}
