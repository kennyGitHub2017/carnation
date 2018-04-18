package com.sinco.carnation.shop.bo;

import java.math.BigDecimal;

import com.sinco.carnation.shop.model.ZeroGoods;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class ZeroGoodsBO extends ZeroGoods {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3318960597089306977L;

	/*	
		goods_main_photo_path
		store_price
		old_goods_price
		self_add_price
		goods_current_price
		all_inventory
	*/
	/**
	 * 商品主图
	 */
	private String goodsMainPhotoPath;
	/**
	 * 原店铺价格
	 */
	private BigDecimal storePrice;
	/**
	 * 原商品价格
	 */
	private BigDecimal oldGoodsPrice;
	/**
	 * 平台加价
	 */
	private BigDecimal selfAddPrice;
	/**
	 * 当前价格
	 */
	private BigDecimal goodsCurrentPrice;
	/**
	 * 该商品库存
	 */
	private Integer allInventory;

	public String getGoodsMainPhotoPath() {
		return goodsMainPhotoPath;
	}

	public void setGoodsMainPhotoPath(String goodsMainPhotoPath) {
		this.goodsMainPhotoPath = goodsMainPhotoPath;
	}

	public BigDecimal getStorePrice() {
		return storePrice;
	}

	public void setStorePrice(BigDecimal storePrice) {
		this.storePrice = storePrice;
	}

	public BigDecimal getOldGoodsPrice() {
		return oldGoodsPrice;
	}

	public void setOldGoodsPrice(BigDecimal oldGoodsPrice) {
		this.oldGoodsPrice = oldGoodsPrice;
	}

	public BigDecimal getSelfAddPrice() {
		return selfAddPrice;
	}

	public void setSelfAddPrice(BigDecimal selfAddPrice) {
		this.selfAddPrice = selfAddPrice;
	}

	public BigDecimal getGoodsCurrentPrice() {
		return goodsCurrentPrice;
	}

	public void setGoodsCurrentPrice(BigDecimal goodsCurrentPrice) {
		this.goodsCurrentPrice = goodsCurrentPrice;
	}

	public Integer getAllInventory() {
		return allInventory;
	}

	public void setAllInventory(Integer allInventory) {
		this.allInventory = allInventory;
	}

}