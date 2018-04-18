package com.sinco.carnation.o2o.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class GroupCaseContent extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2413570040108702420L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/** 团购商品id **/
	private Long goodsId;

	/** 城市id **/
	private Long cityId;

	/**  **/
	private Long caseId;

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

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
}