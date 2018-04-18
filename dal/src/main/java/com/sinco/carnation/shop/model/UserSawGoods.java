package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;

public class UserSawGoods extends BaseModel {
	private static final long serialVersionUID = 5889581031240079085L;

	/**  **/
	private Long id;

	/** 用户ID **/
	private Long userId;

	/** 浏览的商品三级类 **/
	private String class3id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getClass3id() {
		return class3id;
	}

	public void setClass3id(String class3id) {
		this.class3id = class3id;
	}
}