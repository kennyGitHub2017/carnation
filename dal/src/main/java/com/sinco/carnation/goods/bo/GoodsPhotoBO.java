package com.sinco.carnation.goods.bo;

import com.sinco.carnation.goods.model.GoodsPhoto;
import com.sinco.carnation.sys.model.Accessory;

/**
 * 
 * BO 用于返回数据
 * 
 */
@SuppressWarnings("serial")
public class GoodsPhotoBO extends GoodsPhoto {

	private Accessory accessory;

	public Accessory getAccessory() {
		return accessory;
	}

	public void setAccessory(Accessory accessory) {
		this.accessory = accessory;
	}

}