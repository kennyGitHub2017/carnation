package com.sinco.carnation.goods.model;

import com.sinco.mybatis.dal.model.BaseModel;

@SuppressWarnings("serial")
public class GoodsUgc extends BaseModel {
	/**  **/
	private Long classId;

	/**  **/
	private Long goodsId;

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
}