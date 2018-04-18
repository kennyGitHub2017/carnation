package com.sinco.carnation.goods.bo;

import java.util.List;

import com.sinco.carnation.goods.model.GoodsType;

/**
 * 
 * BO 用于返回数据
 * 
 */
@SuppressWarnings("serial")
public class GoodsTypeBO extends GoodsType {

	private List<GoodsBrandBO> gbs = null;

	private List<GoodsTypePropertyBO> properties;

	public List<GoodsBrandBO> getGbs() {
		return gbs;
	}

	public void setGbs(List<GoodsBrandBO> gbs) {
		this.gbs = gbs;
	}

	public List<GoodsTypePropertyBO> getProperties() {
		return properties;
	}

	public void setProperties(List<GoodsTypePropertyBO> properties) {
		this.properties = properties;
	}

}