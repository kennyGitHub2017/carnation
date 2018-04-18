package com.sinco.carnation.resource.vo.personal;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PGroupGoodsVO extends BasicParamVO {

	@Param(desc = "店铺id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long storeId;

	@Param(desc = "纬度")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Double storeLon;

	@Param(desc = "经度")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Double storeLat;

//	@Param(desc = "类型|1为套餐券 2为代金券")
//	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
//	private Integer goodsType;
//
//	@Param(desc = "商品状态   0为上架，1为在仓库中，2为定时自动上架，3为店铺过期自动下架，-1为手动下架状态，-2为违规下架状态,-3被举报禁售")
//	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
//	private Integer status;

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Double getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(Double storeLon) {
		this.storeLon = storeLon;
	}

	public Double getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(Double storeLat) {
		this.storeLat = storeLat;
	}
}
