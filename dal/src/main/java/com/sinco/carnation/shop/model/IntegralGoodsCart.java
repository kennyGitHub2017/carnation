package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class IntegralGoodsCart extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 479086950514167685L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 数量 **/
	private Integer count;

	/** 积分小计 **/
	private Integer integral;

	/** 购物车运费 **/
	private BigDecimal transFee;

	/**  **/
	private String userId;

	/** 兑换的礼品 **/
	private Long goodsId;

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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public BigDecimal getTransFee() {
		return transFee;
	}

	public void setTransFee(BigDecimal transFee) {
		this.transFee = transFee;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
}