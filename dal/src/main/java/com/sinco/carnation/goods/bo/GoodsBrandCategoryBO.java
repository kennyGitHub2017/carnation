package com.sinco.carnation.goods.bo;

import java.util.List;

import com.sinco.carnation.goods.model.GoodsBrandCategory;

/**
 * 
 * BO 用于返回数据
 * 
 */
@SuppressWarnings("serial")
public class GoodsBrandCategoryBO extends GoodsBrandCategory {

	private List<GoodsBrandBO> brands;

	public List<GoodsBrandBO> getBrands() {
		return brands;
	}

	public void setBrands(List<GoodsBrandBO> brands) {
		this.brands = brands;
	}

}