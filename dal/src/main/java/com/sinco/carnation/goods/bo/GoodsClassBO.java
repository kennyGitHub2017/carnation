package com.sinco.carnation.goods.bo;

import java.util.Collection;
import java.util.List;

import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.dic.client.model.DicParentBase;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class GoodsClassBO extends GoodsClass implements DicParentBase<GoodsClassBO>, Comparable<GoodsClassBO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5706220530332453402L;

	private String goodsTypeName;

	// 父父级id
	private Long parentParentId;

	private Accessory iconAcc;

	private Collection<GoodsClassBO> childs;

	private GoodsClassBO parent;

	private List<GoodsTypePropertyBO> goodsTypeProperty;

	private GoodsTypeBO goodsType;

	private String parentClassName;

	public String getParentClassName() {
		return parentClassName;
	}

	public void setParentClassName(String parentClassName) {
		this.parentClassName = parentClassName;
	}

	public GoodsClassBO getParent() {
		return parent;
	}

	public void setParent(GoodsClassBO parent) {
		this.parent = parent;
	}

	public GoodsTypeBO getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsTypeBO goodsType) {
		this.goodsType = goodsType;
	}

	public List<GoodsTypePropertyBO> getGoodsTypeProperty() {
		return goodsTypeProperty;
	}

	public void setGoodsTypeProperty(List<GoodsTypePropertyBO> goodsTypeProperty) {
		this.goodsTypeProperty = goodsTypeProperty;
	}

	public Collection<GoodsClassBO> getChilds() {
		return childs;
	}

	public void setChilds(Collection<GoodsClassBO> childs) {
		this.childs = childs;
	}

	public Accessory getIconAcc() {
		return iconAcc;
	}

	public void setIconAcc(Accessory iconAcc) {
		this.iconAcc = iconAcc;
	}

	public Long getParentParentId() {
		return parentParentId;
	}

	public void setParentParentId(Long parentParentId) {
		this.parentParentId = parentParentId;
	}

	public String getGoodsTypeName() {
		return goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}

	@Override
	public String getCode() {
		return String.valueOf(this.getId());
	}

	@Override
	public String getName() {
		return this.getClassName();
	}

	@Override
	public String getParentCode() {
		return this.getParentId() != null ? String.valueOf(this.getParentId()) : null;
	}

	@Override
	public int compareTo(GoodsClassBO o) {
		return this.getSequence().compareTo(o.getSequence());
	}
}