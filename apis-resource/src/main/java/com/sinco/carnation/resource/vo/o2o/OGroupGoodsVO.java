package com.sinco.carnation.resource.vo.o2o;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class OGroupGoodsVO extends BasicPageParamVo {

	@Param(desc = "商品状态|  0为上架，1为在仓库中，2为定时自动上架，3为店铺过期自动下架，-1为手动下架状态，-2为违规下架状态,-3被举报禁售',")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer ggStatus;

	@Param(desc = "商品类型|1为套餐券 2为代金券")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer goodsType;

	public Integer getGgStatus() {
		return ggStatus;
	}

	public void setGgStatus(Integer ggStatus) {
		this.ggStatus = ggStatus;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

}
