package com.sinco.carnation.store.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class StorePoint extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8165946210796306746L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 描述相符评价 **/
	private BigDecimal descriptionEvaluate;

	/** 服务态度评价 **/
	private BigDecimal serviceEvaluate;

	/** 发货速度评价 **/
	private BigDecimal shipEvaluate;

	/** 统计时间 **/
	private Date statTime;

	/** 商品综合评分=（描述相符评价+服务态度评价+发货速度评价)/3 **/
	private BigDecimal storeEvaluate;

	/** 对应的店铺 **/
	private Long storeId;

	/** 评价自营商品时，会评价点击确认发货的管理员 **/
	private Long userId;

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

	public BigDecimal getDescriptionEvaluate() {
		return descriptionEvaluate;
	}

	public void setDescriptionEvaluate(BigDecimal descriptionEvaluate) {
		this.descriptionEvaluate = descriptionEvaluate;
	}

	public BigDecimal getServiceEvaluate() {
		return serviceEvaluate;
	}

	public void setServiceEvaluate(BigDecimal serviceEvaluate) {
		this.serviceEvaluate = serviceEvaluate;
	}

	public BigDecimal getShipEvaluate() {
		return shipEvaluate;
	}

	public void setShipEvaluate(BigDecimal shipEvaluate) {
		this.shipEvaluate = shipEvaluate;
	}

	public Date getStatTime() {
		return statTime;
	}

	public void setStatTime(Date statTime) {
		this.statTime = statTime;
	}

	public BigDecimal getStoreEvaluate() {
		return storeEvaluate;
	}

	public void setStoreEvaluate(BigDecimal storeEvaluate) {
		this.storeEvaluate = storeEvaluate;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}