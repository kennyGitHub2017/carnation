package com.sinco.carnation.shop.bo;

import org.apache.commons.lang3.StringUtils;

import com.sinco.carnation.shop.model.Evaluate;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class EvaluateBO extends Evaluate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String headImgPath;
	// 买家昵称
	private String nickName;
	// 商品名称
	private String goodsName;
	// 商品店铺
	private String storeName;
	// 评价用户名
	private String loginName;
	// 商品id
	private Long goodsId;
	// 商品主图
	private String goodsMainPhotoPath;

	public String[] getPhotosList() {
		if (StringUtils.isNotBlank(getEvaluatePhotos())) {
			return getEvaluatePhotos().split(";");
		}
		return null;
	}

	public String[] getAddevaPhotosList() {
		if (StringUtils.isNotBlank(getAddevaPhotos())) {
			return getAddevaPhotos().split(";");
		}
		return null;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public String getNickName() {
		return nickName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsMainPhotoPath() {
		return goodsMainPhotoPath;
	}

	public void setGoodsMainPhotoPath(String goodsMainPhotoPath) {
		this.goodsMainPhotoPath = goodsMainPhotoPath;
	}

}