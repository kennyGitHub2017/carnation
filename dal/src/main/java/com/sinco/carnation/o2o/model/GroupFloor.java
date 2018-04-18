package com.sinco.carnation.o2o.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class GroupFloor extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8924379787140232068L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 是否显示 true为显示，false为不显示 **/
	private Boolean display;

	/** 显示商品个数 **/
	private Integer goodsCount;

	/** 楼层名 **/
	private String gfName;

	/** 分类序号 按升序排序 **/
	private Integer gfSequence;

	/** 楼层导航小图标 楼层导航小图标24*24 **/
	private String iconPath;

	/** 分类id,只能选择1级 **/
	private Long classId;

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

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	public String getGfName() {
		return gfName;
	}

	public void setGfName(String gfName) {
		this.gfName = gfName;
	}

	public Integer getGfSequence() {
		return gfSequence;
	}

	public void setGfSequence(Integer gfSequence) {
		this.gfSequence = gfSequence;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}
}