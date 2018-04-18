package com.sinco.carnation.resource.vo.shop;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ShopGoodsVO extends BasicPageParamVo {

	@Param(desc = "商品分类id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long classId;

	@Param(desc = "搜索关键字")
	private String keyword;

	@Param(desc = "是否有商品库存")
	private Boolean isGoodsInventory;

//	@Param(desc = "商品类型，0为自营商品，1为第三方经销商 ")
//	private Integer goodsType;
//	
//	@Param(desc = "商品运费承担方式 0为买家承担，1为卖家承担 ")
//    private Integer goodsTransfee;
//	
//	@Param(desc = "是否支持货到付款 0为支持，-1为不支持")
//    private Integer goodsCod;

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

}
