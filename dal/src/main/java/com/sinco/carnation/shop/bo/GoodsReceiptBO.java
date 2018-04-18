package com.sinco.carnation.shop.bo;

import java.util.Date;

import com.sinco.carnation.shop.model.GoodsReceipt;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class GoodsReceiptBO extends GoodsReceipt {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1269901928165935118L;

	private String buyerName;

	private String sellerName;

	private Date registerTime;

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

}