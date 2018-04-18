package com.sinco.carnation.goods.model;

import com.sinco.mybatis.dal.model.BaseModel;

@SuppressWarnings("serial")
public class GoodsTypeBrand extends BaseModel {
	/**  **/
	private Long brandId;

	/**  **/
	private Long typeId;

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
}