package com.sinco.carnation.shop.vo;

import com.sinco.carnation.shop.model.Evaluate;

public class EvaluateVO extends Evaluate {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7357865584256332046L;
	private String goodsEva;
	private Long storeId;
	private Long userId;
	private String goodsName;
	private String nickName;

	public String getGoodsEva() {
		return goodsEva;
	}

	public void setGoodsEva(String goodsEva) {
		this.goodsEva = goodsEva;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}