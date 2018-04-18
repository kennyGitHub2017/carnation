package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class Combinplan extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6902527250285589773L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 组合开始时间 **/
	private Date beginTime;

	/** 组合类型，0为平台组合，1为商家组合，商家组合需要平台审核 **/
	private Integer combinForm;

	/** 审核失败信息 **/
	private String combinRefuseMsg;

	/** 组合状态，0为未审核，1为审核通过，-1为审核失败,-2已过期,-5商家手动下架，只有通过审核的组合才可以自由上架下架 **/
	private Integer combinStatus;

	/** 组合方式，0为组合套装，1为组合配件，购买组合套装时，订单价钱为组合销售价钱，购买组合配件时，用户可以任意选择该组合中的配件，且所有商品价格为商品的原价格 **/
	private Integer combinType;

	/** 组合结束时间 **/
	private Date endTime;

	/** 主体商品id **/
	private Long mainGoodsId;

	/** 主体商品名称 **/
	private String mainGoodsName;

	/** 组合对应的店铺id，只有combin_form为1时才有值 **/
	private Long storeId;

	/**
	 * 组合信息，组合信息中包含多个组合方案信息，每个组合方案中包含一组组合商品信息，使用json管理[{"all_goods_price":567.0,"plan_goods_price":"500",
	 * "goods_list"
	 * :[{"id":7,"name":"123"},{"id":8,"name":"测试商品5"}]},{"all_goods_price":920.0,"plan_goods_price"
	 * :"400","goods_list":[{"id":9,"name":"123"},{"id":8,"name":"测试商品5"}]}]
	 **/
	private String combinPlanInfo;

	/** 组合销售主商品,使用json管理{"id":1,"name":"测试商品"} **/
	private String mainGoodsInfo;

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

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Integer getCombinForm() {
		return combinForm;
	}

	public void setCombinForm(Integer combinForm) {
		this.combinForm = combinForm;
	}

	public String getCombinRefuseMsg() {
		return combinRefuseMsg;
	}

	public void setCombinRefuseMsg(String combinRefuseMsg) {
		this.combinRefuseMsg = combinRefuseMsg;
	}

	public Integer getCombinStatus() {
		return combinStatus;
	}

	public void setCombinStatus(Integer combinStatus) {
		this.combinStatus = combinStatus;
	}

	public Integer getCombinType() {
		return combinType;
	}

	public void setCombinType(Integer combinType) {
		this.combinType = combinType;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getMainGoodsId() {
		return mainGoodsId;
	}

	public void setMainGoodsId(Long mainGoodsId) {
		this.mainGoodsId = mainGoodsId;
	}

	public String getMainGoodsName() {
		return mainGoodsName;
	}

	public void setMainGoodsName(String mainGoodsName) {
		this.mainGoodsName = mainGoodsName;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getCombinPlanInfo() {
		return combinPlanInfo;
	}

	public void setCombinPlanInfo(String combinPlanInfo) {
		this.combinPlanInfo = combinPlanInfo;
	}

	public String getMainGoodsInfo() {
		return mainGoodsInfo;
	}

	public void setMainGoodsInfo(String mainGoodsInfo) {
		this.mainGoodsInfo = mainGoodsInfo;
	}
}