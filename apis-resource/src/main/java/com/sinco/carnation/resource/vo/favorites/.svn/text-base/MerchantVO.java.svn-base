package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class MerchantVO extends BasicPageParamVo {

	@Param(desc = "分类id")
	private Long ugcId;

	@Param(desc = "店铺id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long id;

	@Param(desc = "orderBy|销量:goods_salenum;好评:well_evaluate;价格:goods_current_price")
	private String orderBy;

	@Param(desc = "orderType|升序:desc;降序:asc")
	private String orderType;

	public Long getUgcId() {
		return ugcId;
	}

	public Long getId() {
		return id;
	}

	public void setUgcId(Long ugcId) {
		this.ugcId = ugcId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

}
