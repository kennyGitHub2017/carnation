package com.sinco.carnation.goods.bo;

import java.util.ArrayList;
import java.util.List;

import com.sinco.carnation.goods.model.GoodsSpecification;

/**
 * 
 * BO 用于返回数据
 * 
 */
@SuppressWarnings("serial")
public class GoodsSpecificationBO extends GoodsSpecification {

	private List<GoodsSpecPropertyBO> properties = new ArrayList<GoodsSpecPropertyBO>();

	private List<GoodsClassBO> specGoodsClassDetail;// 规格对应的详细商品分类,该分类为平台三级商品分类（level=2）

	private GoodsClassBO goodsClass;

	public GoodsClassBO getGoodsClass() {
		return goodsClass;
	}

	public void setGoodsClass(GoodsClassBO goodsClass) {
		this.goodsClass = goodsClass;
	}

	public List<GoodsSpecPropertyBO> getProperties() {
		return properties;
	}

	public void setProperties(List<GoodsSpecPropertyBO> properties) {
		this.properties = properties;
	}

	public List<GoodsClassBO> getSpecGoodsClassDetail() {
		return specGoodsClassDetail;
	}

	public void setSpecGoodsClassDetail(List<GoodsClassBO> specGoodsClassDetail) {
		this.specGoodsClassDetail = specGoodsClassDetail;
	}

}