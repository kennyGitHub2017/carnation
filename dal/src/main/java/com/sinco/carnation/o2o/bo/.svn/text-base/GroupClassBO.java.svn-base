package com.sinco.carnation.o2o.bo;

import java.util.Collection;

import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.dic.client.model.DicParentBase;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class GroupClassBO extends GroupClass implements DicParentBase<GroupClassBO>, Comparable<GroupClassBO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2247686281046285308L;

	private Collection<GroupClassBO> childs;

	private GroupClassBO parent;

	@Override
	public String getCode() {
		return this.getId() != null ? this.getId().toString() : null;
	}

	@Override
	public String getName() {
		return this.getGcName();
	}

	@Override
	public int compareTo(GroupClassBO o) {
		return this.getGcSequence().compareTo(o.getGcSequence());
	}

	@Override
	public String getParentCode() {
		return this.getParentId() != null ? this.getParentId().toString() : null;
	}

	@Override
	public Collection<GroupClassBO> getChilds() {
		return childs;
	}

	@Override
	public void setChilds(Collection<GroupClassBO> childs) {
		this.childs = childs;
	}

	public GroupClassBO getParent() {
		return parent;
	}

	public void setParent(GroupClassBO parent) {
		this.parent = parent;
	}

}