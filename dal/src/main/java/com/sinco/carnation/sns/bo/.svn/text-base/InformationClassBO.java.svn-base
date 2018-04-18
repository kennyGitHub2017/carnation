package com.sinco.carnation.sns.bo;

import java.util.ArrayList;
import java.util.List;

import com.sinco.carnation.sns.model.InformationClass;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class InformationClassBO extends InformationClass {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7462648282739317037L;

	private List<InformationClassBO> childs = new ArrayList<InformationClassBO>();

	private List<InformationClassBO> grandchildren = new ArrayList<InformationClassBO>();

	private String IsParent;

	private Long parentParentId;

	public Long getParentParentId() {
		return parentParentId;
	}

	public void setParentParentId(Long parentParentId) {
		this.parentParentId = parentParentId;
	}

	public List<InformationClassBO> getGrandchildren() {
		return grandchildren;
	}

	public void setGrandchildren(List<InformationClassBO> grandchildren) {
		this.grandchildren = grandchildren;
	}

	public List<InformationClassBO> getChilds() {
		return childs;
	}

	public void setChilds(List<InformationClassBO> childs) {
		this.childs = childs;
	}

	public String getIsParent() {
		return IsParent;
	}

	public void setIsParent(String isParent) {
		IsParent = isParent;
	}
}