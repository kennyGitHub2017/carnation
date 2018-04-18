package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.util.Date;

public class UserGoodsClass extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**  **/
	private Long id;

	/**  **/
	private Date addtime;

	/**  **/
	private Integer deletestatus;

	/**  **/
	private String classname;

	/**  **/
	private Boolean display;

	/**  **/
	private Integer level;

	/**  **/
	private Integer sequence;

	/**  **/
	private Long userId;

	/**  **/
	private Long parentId;

	/** 系统图标 **/
	private String iconSys;

	/** web上传图标 **/
	private String iconAccId;

	/** 是否是云购分类 **/
	private Boolean isyg;

	/** 图标显示类型 0表示系统图片，1表示上传图标 **/
	private Integer iconType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(Integer deletestatus) {
		this.deletestatus = deletestatus;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getIconSys() {
		return iconSys;
	}

	public void setIconSys(String iconSys) {
		this.iconSys = iconSys;
	}

	public String getIconAccId() {
		return iconAccId;
	}

	public void setIconAccId(String iconAccId) {
		this.iconAccId = iconAccId;
	}

	public Boolean getIsyg() {
		return isyg;
	}

	public void setIsyg(Boolean isyg) {
		this.isyg = isyg;
	}

	public Integer getIconType() {
		return iconType;
	}

	public void setIconType(Integer iconType) {
		this.iconType = iconType;
	}
}