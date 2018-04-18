package com.sinco.carnation.user.vo;

import com.sinco.carnation.user.model.UserCustomerFavorites;

public class UserCustomerFavoritesVO extends UserCustomerFavorites {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5873279318223430324L;
	private Integer goodsType;

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

}