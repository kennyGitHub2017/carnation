package com.sinco.carnation.goods.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.util.Date;

@SuppressWarnings("serial")
public class GoodsFloor extends BaseModel {
	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** css名称 目前系统提供四种样式 **/
	private String gfCss;

	/** 是否显示 true为显示，false为不显示 **/
	private Boolean gfDisplay;

	/** 显示商品个数 **/
	private Integer gfGoodsCount;

	/** 层级 **/
	private Integer gfLevel;

	/** 分类名称 分类名称，如：服饰>女装>大衣 **/
	private String gfName;

	/** 分类序号 按升序排序 **/
	private Integer gfSequence;

	/** 楼层样式 目前提供两种 **/
	private String gfStyle;

	/** 楼层导航小图标 楼层导航小图标24*24 **/
	private String iconId;

	/**  **/
	private Long parentId;

	/** 楼层品牌信息 使用json管理{"brand_id1":1,"brand_id2":2} **/
	private String gfBrandList;

	/** 楼层显示分类商品 使用JSON管理{"goods_id1":1,"goods_id2":32768} **/
	private String gfGcGoods;

	/** 楼层显示分类商品列表 使用json管理[{"pid":1,"gc_id":1,"gc_id":2},{"pid":1,"gc_id":1,"gc_id":2}] **/
	private String gfGcList;

	/** 楼层左侧广告 使用json管理{"acc_id":1,"acc_url":"www.thinker.vc","adv_id":1} **/
	private String gfLeftAdv;

	/**  **/
	private String gfListGoods;

	/** 楼层右侧广告 使用json管理{"acc_id":1,"acc_url":"www.thinker.vc","adv_id":1} **/
	private String gfRightAdv;

	/**
	 * style2样式显示9个图像
	 * style2样式显示9个图像,可以是商品，图片，广告，格式为[{"module_id":1,"type":"goods","goods_id":1,"img_url":"xxxx"
	 * ,"goods_price"
	 * :xxx,"store_price":xxxx,"href_url":"xxxx"},{"type":"adv","adv_id":1},{"type":"img","img_id"
	 * :1,"img_url":"xxxx"}]
	 **/
	private String gfStyle2Goods;

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

	public String getGfCss() {
		return gfCss;
	}

	public void setGfCss(String gfCss) {
		this.gfCss = gfCss;
	}

	public Boolean getGfDisplay() {
		return gfDisplay;
	}

	public void setGfDisplay(Boolean gfDisplay) {
		this.gfDisplay = gfDisplay;
	}

	public Integer getGfGoodsCount() {
		return gfGoodsCount;
	}

	public void setGfGoodsCount(Integer gfGoodsCount) {
		this.gfGoodsCount = gfGoodsCount;
	}

	public Integer getGfLevel() {
		return gfLevel;
	}

	public void setGfLevel(Integer gfLevel) {
		this.gfLevel = gfLevel;
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

	public String getGfStyle() {
		return gfStyle;
	}

	public void setGfStyle(String gfStyle) {
		this.gfStyle = gfStyle;
	}

	public String getIconId() {
		return iconId;
	}

	public void setIconId(String iconId) {
		this.iconId = iconId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getGfBrandList() {
		return gfBrandList;
	}

	public void setGfBrandList(String gfBrandList) {
		this.gfBrandList = gfBrandList;
	}

	public String getGfGcGoods() {
		return gfGcGoods;
	}

	public void setGfGcGoods(String gfGcGoods) {
		this.gfGcGoods = gfGcGoods;
	}

	public String getGfGcList() {
		return gfGcList;
	}

	public void setGfGcList(String gfGcList) {
		this.gfGcList = gfGcList;
	}

	public String getGfLeftAdv() {
		return gfLeftAdv;
	}

	public void setGfLeftAdv(String gfLeftAdv) {
		this.gfLeftAdv = gfLeftAdv;
	}

	public String getGfListGoods() {
		return gfListGoods;
	}

	public void setGfListGoods(String gfListGoods) {
		this.gfListGoods = gfListGoods;
	}

	public String getGfRightAdv() {
		return gfRightAdv;
	}

	public void setGfRightAdv(String gfRightAdv) {
		this.gfRightAdv = gfRightAdv;
	}

	public String getGfStyle2Goods() {
		return gfStyle2Goods;
	}

	public void setGfStyle2Goods(String gfStyle2Goods) {
		this.gfStyle2Goods = gfStyle2Goods;
	}
}