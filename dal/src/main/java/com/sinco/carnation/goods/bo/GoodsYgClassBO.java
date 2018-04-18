package com.sinco.carnation.goods.bo;

import java.util.Collection;

import com.sinco.carnation.user.model.UserGoodsClass;
import com.sinco.dic.client.model.DicParentBase;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class GoodsYgClassBO extends UserGoodsClass implements DicParentBase<GoodsYgClassBO>,
		Comparable<GoodsYgClassBO> {

	private static final long serialVersionUID = 46547498796143213L;
	private Collection<GoodsYgClassBO> childs;

	// 父父级id
	private Long parentParentId;

	private GoodsYgClassBO parent;

	public Long getParentParentId() {
		return parentParentId;
	}

	public void setParentParentId(Long parentParentId) {
		this.parentParentId = parentParentId;
	}

	public Collection<GoodsYgClassBO> getChilds() {
		return childs;
	}

	public void setChilds(Collection<GoodsYgClassBO> childs) {
		this.childs = childs;
	}

	@Override
	public String getCode() {
		return String.valueOf(this.getId());
	}

	@Override
	public String getName() {
		return this.getClassname();
	}

	@Override
	public String getParentCode() {
		return this.getParentId() != null ? String.valueOf(this.getParentId()) : null;
	}

	@Override
	public int compareTo(GoodsYgClassBO o) {
		return 1;
	}

	public GoodsYgClassBO getParent() {
		return parent;
	}

	public void setParent(GoodsYgClassBO parent) {
		this.parent = parent;
	}
}