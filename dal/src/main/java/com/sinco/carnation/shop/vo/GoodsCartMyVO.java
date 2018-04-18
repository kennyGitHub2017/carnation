package com.sinco.carnation.shop.vo;

import java.util.List;

/**
 * 查找
 * 
 * @author james
 * 
 */
public class GoodsCartMyVO {

	private String cartSessionId;

	private Integer cartStatus;

	private Long userId;

	private List<Long> ids;

	private Integer isYgb;

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public String getCartSessionId() {
		return cartSessionId;
	}

	public void setCartSessionId(String cartSessionId) {
		this.cartSessionId = cartSessionId;
	}

	public Integer getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(Integer cartStatus) {
		this.cartStatus = cartStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getIsYgb() {
		return isYgb;
	}

	public void setIsYgb(Integer isYgb) {
		this.isYgb = isYgb;
	}

}
