package com.sinco.carnation.sys.bo;

import com.sinco.carnation.sys.model.Accessory;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class AccessoryBO extends Accessory {

	private Long groupGoodsId;

	public Long getGroupGoodsId() {
		return groupGoodsId;
	}

	public void setGroupGoodsId(Long groupGoodsId) {
		this.groupGoodsId = groupGoodsId;
	}

}