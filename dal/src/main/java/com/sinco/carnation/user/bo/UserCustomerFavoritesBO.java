package com.sinco.carnation.user.bo;

import java.math.BigDecimal;

import com.sinco.carnation.user.model.UserCustomerFavorites;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class UserCustomerFavoritesBO extends UserCustomerFavorites {

	/**
	 * 
	 */
	private static final long serialVersionUID = 233423604989112885L;
	/** 商品当前价格 **/
	private BigDecimal goodsCurrentPrice;
	private String goodsName;
	/** 商品主图片 **/
	private String goodsMainPhotoPath;
	private Integer goodsType;
	private String storeName;
	private String storeAddress;
	private String storeLogoId;
	private Long goodsId;
	private Boolean hasExchangeIntegral;
	private BigDecimal goodsIntegralPrice;
	private Boolean hasMobilePrice;
	private BigDecimal goodsMobilePrice;
	private String storeLogoPath;
	/**
	 * 店铺收藏人气
	 */
	private Integer favoriteCount;

	public BigDecimal getGoodsCurrentPrice() {
		return goodsCurrentPrice;
	}

	public void setGoodsCurrentPrice(BigDecimal goodsCurrentPrice) {
		this.goodsCurrentPrice = goodsCurrentPrice;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsMainPhotoPath() {
		return goodsMainPhotoPath;
	}

	public void setGoodsMainPhotoPath(String goodsMainPhotoPath) {
		this.goodsMainPhotoPath = goodsMainPhotoPath;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreLogoId() {
		return storeLogoId;
	}

	public void setStoreLogoId(String storeLogoId) {
		this.storeLogoId = storeLogoId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public Boolean getHasExchangeIntegral() {
		return hasExchangeIntegral;
	}

	public BigDecimal getGoodsIntegralPrice() {
		return goodsIntegralPrice;
	}

	public Boolean getHasMobilePrice() {
		return hasMobilePrice;
	}

	public BigDecimal getGoodsMobilePrice() {
		return goodsMobilePrice;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public void setHasExchangeIntegral(Boolean hasExchangeIntegral) {
		this.hasExchangeIntegral = hasExchangeIntegral;
	}

	public void setGoodsIntegralPrice(BigDecimal goodsIntegralPrice) {
		this.goodsIntegralPrice = goodsIntegralPrice;
	}

	public void setHasMobilePrice(Boolean hasMobilePrice) {
		this.hasMobilePrice = hasMobilePrice;
	}

	public void setGoodsMobilePrice(BigDecimal goodsMobilePrice) {
		this.goodsMobilePrice = goodsMobilePrice;
	}

	public String getStoreLogoPath() {
		return storeLogoPath;
	}

	public void setStoreLogoPath(String storeLogoPath) {
		this.storeLogoPath = storeLogoPath;
	}

	public Integer getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

}