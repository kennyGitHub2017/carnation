package com.sinco.carnation.o2o.vo;

import java.util.Set;

import com.sinco.mybatis.dal.model.BaseModel;

public class GroupGoodsVO extends BaseModel {

	private static final long serialVersionUID = 1L;

	/** 商品名称 **/
	private String ggName;

	/** 团购类型，1为套餐券 2为代金券 **/
	private Integer goodsType;

	/** 商品状态 0为上架，1为在仓库中，3为店铺过期自动下架，-2为违规下架状态 **/
	private Integer ggStatus;

	/** 团购审核状态 1为通过,已开始 -1为未通过 0为待审核 -2为过期 **/
	private Integer groupStatus;

	/** 服务地区id **/
	private Long ggGaId;

	/** 服务分类id **/
	private Long ggGcId;

	/** 商户id **/
	private Long storeId;

	/** 商户名称 **/
	private String storeName;

	private String target;

	private Set<Long> groupClassIds;

	private Long operatorId;

	private String yysFlag;

	private Set<Integer> ggStatusList;
	private Integer ownType;

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getGgName() {
		return ggName;
	}

	public void setGgName(String ggName) {
		this.ggName = ggName;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getGgStatus() {
		return ggStatus;
	}

	public void setGgStatus(Integer ggStatus) {
		this.ggStatus = ggStatus;
	}

	public Integer getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(Integer groupStatus) {
		this.groupStatus = groupStatus;
	}

	public Long getGgGaId() {
		return ggGaId;
	}

	public void setGgGaId(Long ggGaId) {
		this.ggGaId = ggGaId;
	}

	public Long getGgGcId() {
		return ggGcId;
	}

	public void setGgGcId(Long ggGcId) {
		this.ggGcId = ggGcId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Set<Long> getGroupClassIds() {
		return groupClassIds;
	}

	public void setGroupClassIds(Set<Long> groupClassIds) {
		this.groupClassIds = groupClassIds;
	}

	public Set<Integer> getGgStatusList() {
		return ggStatusList;
	}

	public void setGgStatusList(Set<Integer> ggStatusList) {
		this.ggStatusList = ggStatusList;
	}

	public String getYysFlag() {
		return yysFlag;
	}

	public void setYysFlag(String yysFlag) {
		this.yysFlag = yysFlag;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Integer getOwnType() {
		return ownType;
	}

	public void setOwnType(Integer ownType) {
		this.ownType = ownType;
	}

}