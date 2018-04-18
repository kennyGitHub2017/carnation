package com.sinco.carnation.goods.bo;

import java.util.List;

import com.sinco.carnation.goods.model.GoodsFloor;

/**
 * 
 * BO 用于返回数据
 * 
 */
@SuppressWarnings("serial")
public class GoodsFloorBO extends GoodsFloor {

	private List<GoodsFloorBO> childs;

	public List<GoodsFloorBO> getChilds() {
		return childs;
	}

	public void setChilds(List<GoodsFloorBO> childs) {
		this.childs = childs;
	}

}