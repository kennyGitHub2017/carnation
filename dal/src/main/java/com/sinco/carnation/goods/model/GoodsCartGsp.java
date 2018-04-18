package com.sinco.carnation.goods.model;

import com.sinco.mybatis.dal.model.BaseModel;

@SuppressWarnings("serial")
public class GoodsCartGsp extends BaseModel {
	/**  **/
	private Long cartId;

	/**  **/
	private Long gspId;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getGspId() {
		return gspId;
	}

	public void setGspId(Long gspId) {
		this.gspId = gspId;
	}
}