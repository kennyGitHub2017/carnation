package com.sinco.carnation.operation.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class ZTCGoldLog extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -124219563855773267L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/**  **/
	private String goodsName;

	/**  **/
	private String storeName;

	/**  **/
	private String userName;

	/** 描述 **/
	private String zglContent;

	/** 金币数量 **/
	private Integer zglGold;

	/** 日志商品id **/
	private Long zglGoodsId;

	/** 0为增加，1为减少 **/
	private Integer zglType;

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

	public String getGoodsName() {
		return goodsName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getZglContent() {
		return zglContent;
	}

	public void setZglContent(String zglContent) {
		this.zglContent = zglContent;
	}

	public Integer getZglGold() {
		return zglGold;
	}

	public void setZglGold(Integer zglGold) {
		this.zglGold = zglGold;
	}

	public Long getZglGoodsId() {
		return zglGoodsId;
	}

	public void setZglGoodsId(Long zglGoodsId) {
		this.zglGoodsId = zglGoodsId;
	}

	public Integer getZglType() {
		return zglType;
	}

	public void setZglType(Integer zglType) {
		this.zglType = zglType;
	}
}