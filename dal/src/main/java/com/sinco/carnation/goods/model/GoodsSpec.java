package com.sinco.carnation.goods.model;

import com.sinco.mybatis.dal.model.BaseModel;

@SuppressWarnings("serial")
public class GoodsSpec extends BaseModel {
	/**  **/
	private Long goodsId;

	/**  **/
	private Long specId;//规格属性ID
	
	private Long specificationId;//规格Id
	
	private String name;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getSpecId() {
		return specId;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public Long getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(Long specificationId) {
		this.specificationId = specificationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}