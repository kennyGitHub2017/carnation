package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class GoodsReceipt extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4725820477760727014L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 对应的订单 **/
	private Long ofId;

	/** 商品id **/
	private Long goodsId;

	/** 购买的数量 **/
	private Integer goodsNum;

	/** 购买时的价格 **/
	private BigDecimal goodsPrice;

	/** 对应规格id **/
	private Long goodsSpecIds;

	/** 对应规格描述 **/
	private String goodsSpecVs;

	/** 买家id **/
	private Long userId;

	/** 订单对应店铺id **/
	private String storeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Long getOfId() {
		return ofId;
	}

	public void setOfId(Long ofId) {
		this.ofId = ofId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Long getGoodsSpecIds() {
		return goodsSpecIds;
	}

	public void setGoodsSpecIds(Long goodsSpecIds) {
		this.goodsSpecIds = goodsSpecIds;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getGoodsSpecVs() {
		return goodsSpecVs;
	}

	public void setGoodsSpecVs(String goodsSpecVs) {
		this.goodsSpecVs = goodsSpecVs;
	}

}