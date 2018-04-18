package com.sinco.carnation.goods.model;

import com.sinco.mybatis.dal.model.BaseModel;

@SuppressWarnings("serial")
public class GoodsPhoto extends BaseModel {
	/**  **/
	private Long goodsId;

	/**  **/
	private Long photoId;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}
}