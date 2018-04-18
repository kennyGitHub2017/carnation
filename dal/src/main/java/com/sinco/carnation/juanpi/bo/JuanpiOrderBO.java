package com.sinco.carnation.juanpi.bo;


import java.util.List;

import com.sinco.carnation.juanpi.model.JuanpiOrder;
/**
 * 
 * BO 用于返回数据
 *
 */
public class JuanpiOrderBO extends JuanpiOrder{
	private static final long serialVersionUID = 5402818311871259196L;
	private List<JuanpiOrderGoodsBO> goodss;


	public List<JuanpiOrderGoodsBO> getGoodss() {
		return goodss;
	}

	public void setGoodss(List<JuanpiOrderGoodsBO> goodss) {
		this.goodss = goodss;
	}
	
}