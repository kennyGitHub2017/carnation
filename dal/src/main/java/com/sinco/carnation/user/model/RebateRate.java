package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class RebateRate extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4393711224562409843L;

	/**  **/
	private Long id;

	/** 代码 **/
	private String code;

	/** 描述 **/
	private String description;

	/** 自己所得比率 **/
	private BigDecimal ownRate;

	/** 推荐人比率 **/
	private BigDecimal referenceRate;

	/** 所属商户比率 **/
	private BigDecimal ownSellerRate;

	/** 所属商户推荐人比率 **/
	private BigDecimal ownSellerReferenceRate;

	/** 所属区域比例 **/
	private BigDecimal ownRegionalRate;

	/** 区域级推荐人返利 **/
	private BigDecimal ownRegionalReferenceRate;

	/** 所属区比率 **/
	private BigDecimal ownDistrictRate;

	/** 所属市比率 **/
	private BigDecimal ownCityRate;

	/** 购买商户推荐人比率 **/
	private BigDecimal buySellerReferenceRate;

	/** 购买区域比率 **/
	private BigDecimal buyRegionalRate;

	/** 购买区比率 **/
	private BigDecimal buyDistrictRate;

	/** 购买市比率 **/
	private BigDecimal buyCityRate;

	/** 平台比率 **/
	private BigDecimal shopRate;

	/** 更新时间 **/
	private Date updateTime;

	/**  **/
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getOwnRate() {
		return ownRate;
	}

	public void setOwnRate(BigDecimal ownRate) {
		this.ownRate = ownRate;
	}

	public BigDecimal getReferenceRate() {
		return referenceRate;
	}

	public void setReferenceRate(BigDecimal referenceRate) {
		this.referenceRate = referenceRate;
	}

	public BigDecimal getOwnSellerRate() {
		return ownSellerRate;
	}

	public void setOwnSellerRate(BigDecimal ownSellerRate) {
		this.ownSellerRate = ownSellerRate;
	}

	public BigDecimal getOwnSellerReferenceRate() {
		return ownSellerReferenceRate;
	}

	public void setOwnSellerReferenceRate(BigDecimal ownSellerReferenceRate) {
		this.ownSellerReferenceRate = ownSellerReferenceRate;
	}

	public BigDecimal getOwnRegionalRate() {
		return ownRegionalRate;
	}

	public void setOwnRegionalRate(BigDecimal ownRegionalRate) {
		this.ownRegionalRate = ownRegionalRate;
	}

	public BigDecimal getOwnRegionalReferenceRate() {
		return ownRegionalReferenceRate;
	}

	public void setOwnRegionalReferenceRate(BigDecimal ownRegionalReferenceRate) {
		this.ownRegionalReferenceRate = ownRegionalReferenceRate;
	}

	public BigDecimal getOwnDistrictRate() {
		return ownDistrictRate;
	}

	public void setOwnDistrictRate(BigDecimal ownDistrictRate) {
		this.ownDistrictRate = ownDistrictRate;
	}

	public BigDecimal getOwnCityRate() {
		return ownCityRate;
	}

	public void setOwnCityRate(BigDecimal ownCityRate) {
		this.ownCityRate = ownCityRate;
	}

	public BigDecimal getBuySellerReferenceRate() {
		return buySellerReferenceRate;
	}

	public void setBuySellerReferenceRate(BigDecimal buySellerReferenceRate) {
		this.buySellerReferenceRate = buySellerReferenceRate;
	}

	public BigDecimal getBuyRegionalRate() {
		return buyRegionalRate;
	}

	public void setBuyRegionalRate(BigDecimal buyRegionalRate) {
		this.buyRegionalRate = buyRegionalRate;
	}

	public BigDecimal getBuyDistrictRate() {
		return buyDistrictRate;
	}

	public void setBuyDistrictRate(BigDecimal buyDistrictRate) {
		this.buyDistrictRate = buyDistrictRate;
	}

	public BigDecimal getBuyCityRate() {
		return buyCityRate;
	}

	public void setBuyCityRate(BigDecimal buyCityRate) {
		this.buyCityRate = buyCityRate;
	}

	public BigDecimal getShopRate() {
		return shopRate;
	}

	public void setShopRate(BigDecimal shopRate) {
		this.shopRate = shopRate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}