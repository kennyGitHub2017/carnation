package com.sinco.carnation.sys.model;

import java.util.Collection;
import java.util.Date;

import com.sinco.dic.client.model.DicParentBase;
import com.sinco.mybatis.dal.model.BaseModel;

public class Area extends BaseModel implements DicParentBase<Area>, Comparable<Area> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7498053225055556004L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/**  **/
	private String areaName;

	/**  **/
	private Boolean common;

	/**  **/
	private Integer level;

	/**  **/
	private Integer sequence;

	/**  **/
	private Long parentId;

	/**
	 * 是否服务热门城市
	 */
	private Boolean isGroupHot;

	private Collection<Area> childs;

	/**
	 * 地区名称首字母
	 */
	private String firstChar;

	private Area parent;

	public Boolean getIsGroupHot() {
		return isGroupHot;
	}

	public void setIsGroupHot(Boolean isGroupHot) {
		this.isGroupHot = isGroupHot;
	}

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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Boolean getCommon() {
		return common;
	}

	public void setCommon(Boolean common) {
		this.common = common;
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String getCode() {
		return String.valueOf(this.getId());
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.getAreaName();
	}

	@Override
	public String getParentCode() {
		return this.getParentId() != null ? String.valueOf(this.getParentId()) : null;
	}

	@Override
	public Collection<Area> getChilds() {
		return childs;
	}

	@Override
	public void setChilds(Collection<Area> childs) {
		this.childs = childs;
	}

	public Area getParent() {
		return parent;
	}

	public void setParent(Area parent) {
		this.parent = parent;
	}

	@Override
	public int compareTo(Area o) {
		return this.getSequence().compareTo(o.getSequence());
	}

	public String getFirstChar() {
		return firstChar;
	}

	public void setFirstChar(String firstChar) {
		this.firstChar = firstChar;
	}

}