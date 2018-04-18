package com.sinco.carnation.user.bo;

import java.util.List;

import com.sinco.carnation.user.model.UserGoodsClass;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class UserGoodsClassBO extends UserGoodsClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 210247555961898660L;
	private List<UserGoodsClass> childs;

	public List<UserGoodsClass> getChilds() {
		return childs;
	}

	public void setChilds(List<UserGoodsClass> childs) {
		this.childs = childs;
	}

}