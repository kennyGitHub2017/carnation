package com.sinco.carnation.goods.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.util.Date;

@SuppressWarnings("serial")
public class GoodsFormat extends BaseModel {
	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/** 版式分类 **/
	private Integer gfCat;

	/** 版式名称 **/
	private String gfName;

	/** 版式对应的店铺 **/
	private Long gfStoreId;

	/** 版式位置 0为顶部版式，1为底部版式 **/
	private Integer gfType;

	/** 版式内容 **/
	private String gfContent;

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

	public Integer getGfCat() {
		return gfCat;
	}

	public void setGfCat(Integer gfCat) {
		this.gfCat = gfCat;
	}

	public String getGfName() {
		return gfName;
	}

	public void setGfName(String gfName) {
		this.gfName = gfName;
	}

	public Long getGfStoreId() {
		return gfStoreId;
	}

	public void setGfStoreId(Long gfStoreId) {
		this.gfStoreId = gfStoreId;
	}

	public Integer getGfType() {
		return gfType;
	}

	public void setGfType(Integer gfType) {
		this.gfType = gfType;
	}

	public String getGfContent() {
		return gfContent;
	}

	public void setGfContent(String gfContent) {
		this.gfContent = gfContent;
	}
}