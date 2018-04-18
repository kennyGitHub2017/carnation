package com.sinco.carnation.shop.model;

import java.util.Collection;
import java.util.Date;

import com.sinco.dic.client.model.DicParentBase;
import com.sinco.mybatis.dal.model.BaseModel;

public class TransArea extends BaseModel implements DicParentBase<TransArea> {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7227357579701884238L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/**  **/
	private String areaName;

	/**  **/
	private Integer level;

	/**  **/
	private Integer sequence;

	/**  **/
	private Long parentId;

	private Collection<TransArea> childs;

	private TransArea parent;

	public TransArea getParent() {
		return parent;
	}

	public void setParent(TransArea parent) {
		this.parent = parent;
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

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
		return this.getAreaName();
	}

	@Override
	public String getParentCode() {
		return this.getParentId() != null ? String.valueOf(this.getParentId()) : null;
	}

	@Override
	public Collection<TransArea> getChilds() {
		return childs;
	}

	@Override
	public void setChilds(Collection<TransArea> childs) {
		this.childs = childs;
	}
}