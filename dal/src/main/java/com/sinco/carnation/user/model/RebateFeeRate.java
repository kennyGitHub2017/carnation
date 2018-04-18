package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class RebateFeeRate extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8415442429431471757L;

	/**  **/
	private Long id;

	/** 代码 **/
	private String code;

	/** 描述 **/
	private String description;

	/** 区域级手续费返润比率 **/
	private BigDecimal regionalRate;

	/** 运营商推荐人 **/
	private BigDecimal regionalRefereeRate;

	/** 区级手续费返润比率 **/
	private BigDecimal districtRate;

	/** 市级手续费返润比率 **/
	private BigDecimal cityRate;

	/** 平台返润比率 */
	private BigDecimal shopRate;

	/**  **/
	private Date updateTime;

	/**  **/
	private Date createTime;

	public BigDecimal getShopRate() {
		return shopRate;
	}

	public void setShopRate(BigDecimal shopRate) {
		this.shopRate = shopRate;
	}

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

	public BigDecimal getRegionalRate() {
		return regionalRate;
	}

	public void setRegionalRate(BigDecimal regionalRate) {
		this.regionalRate = regionalRate;
	}

	public BigDecimal getRegionalRefereeRate() {
		return regionalRefereeRate;
	}

	public void setRegionalRefereeRate(BigDecimal regionalRefereeRate) {
		this.regionalRefereeRate = regionalRefereeRate;
	}

	public BigDecimal getDistrictRate() {
		return districtRate;
	}

	public void setDistrictRate(BigDecimal districtRate) {
		this.districtRate = districtRate;
	}

	public BigDecimal getCityRate() {
		return cityRate;
	}

	public void setCityRate(BigDecimal cityRate) {
		this.cityRate = cityRate;
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