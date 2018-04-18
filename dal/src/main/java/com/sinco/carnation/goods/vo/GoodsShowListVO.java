package com.sinco.carnation.goods.vo;

import java.util.List;

/**
 * 用于商城商品列表数据
 * 
 * @author james
 * 
 */
public class GoodsShowListVO {

	private List<Long> ids;

	private Long notId;

	private Long gcId;

	private Integer goodsStatus;

	private Boolean storeRecommend;

	private String orderBy;

	private String orderType;

	private Integer count;

	private Long goodsStoreId;
	private Long goodsBrandId;
	private String likebBrandName;

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Long getGoodsStoreId() {
		return goodsStoreId;
	}

	public void setGoodsStoreId(Long goodsStoreId) {
		this.goodsStoreId = goodsStoreId;
	}

	public Boolean getStoreRecommend() {
		return storeRecommend;
	}

	public void setStoreRecommend(Boolean storeRecommend) {
		this.storeRecommend = storeRecommend;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getNotId() {
		return notId;
	}

	public void setNotId(Long notId) {
		this.notId = notId;
	}

	public Long getGcId() {
		return gcId;
	}

	public void setGcId(Long gcId) {
		this.gcId = gcId;
	}

	public Integer getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public Long getGoodsBrandId() {
		return goodsBrandId;
	}

	public void setGoodsBrandId(Long goodsBrandId) {
		this.goodsBrandId = goodsBrandId;
	}

	public String getLikebBrandName() {
		return likebBrandName;
	}

	public void setLikebBrandName(String likebBrandName) {
		this.likebBrandName = likebBrandName;
	}

}