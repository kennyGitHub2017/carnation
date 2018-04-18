package com.sinco.carnation.recommend.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class RecommendItem extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1698035778900892491L;

	/** id **/
	private Long id;

	/** 显示文字 **/
	private String showText;

	/** 显示概述 **/
	private String showDesc;

	/** 图片地址 **/
	private String imgPath;

	/** 1:资讯（链接），2商品，3商户，4云尚项目（链接） **/
	private String recommendType;

	/** 不同广告类型，存储不同，链接存url，不是存id **/
	private String link;

	/**  **/
	private Long udpateBy;

	/**  **/
	private Date updateTime;

	/**  **/
	private Long createBy;

	/**  **/
	private Date createTime;

	/**  **/
	private Boolean isDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShowText() {
		return showText;
	}

	public void setShowText(String showText) {
		this.showText = showText;
	}

	public String getShowDesc() {
		return showDesc;
	}

	public void setShowDesc(String showDesc) {
		this.showDesc = showDesc;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getRecommendType() {
		return recommendType;
	}

	public void setRecommendType(String recommendType) {
		this.recommendType = recommendType;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Long getUdpateBy() {
		return udpateBy;
	}

	public void setUdpateBy(Long udpateBy) {
		this.udpateBy = udpateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}