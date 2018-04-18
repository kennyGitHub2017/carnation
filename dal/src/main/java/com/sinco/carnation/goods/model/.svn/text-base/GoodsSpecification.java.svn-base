package com.sinco.carnation.goods.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.util.Date;

@SuppressWarnings("serial")
public class GoodsSpecification extends BaseModel {
	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/**  **/
	private String name;

	/**  **/
	private Integer sequence;

	/** 规格类型，0为平台自营规格，1为商家规格，商家规格时需要有对应的店铺 **/
	private Integer specType;

	/** 规格类型(文字或图片) **/
	private String type;

	/** 规格对应的主营商品分类,该分类为平台二级商品分类（level=1） **/
	private Long goodsClassId;

	/** 当规格类型为商家规格时对应的店铺 **/
	private Long storeId;
	
	private Integer display;//0显示 1不显示

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

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getSpecType() {
		return specType;
	}

	public void setSpecType(Integer specType) {
		this.specType = specType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getGoodsClassId() {
		return goodsClassId;
	}

	public void setGoodsClassId(Long goodsClassId) {
		this.goodsClassId = goodsClassId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Integer getDisplay() {
		return display;
	}

	public void setDisplay(Integer display) {
		this.display = display;
	}
	
}