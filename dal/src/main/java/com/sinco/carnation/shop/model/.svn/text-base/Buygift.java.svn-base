package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class Buygift extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4049099794840698070L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 开始时间 **/
	private Date beginTime;

	/** 满足满就送条件金额 需要大于此金额才可满足满就送条件 **/
	private BigDecimal conditionAmount;

	/** 开始时间 **/
	private Date endTime;

	/** 审核状态 默认为0待审核 10为 审核通过 -10为审核未通过 20为已结束。 **/
	private Integer giftStatus;

	/** 0为自营满就送 1为第三方满就送 **/
	private Integer giftType;

	/** 开启满就送店铺 **/
	private Long storeId;

	/** 店铺名称 **/
	private String storeName;

	/** 审核失败原因 **/
	private String failedReason;

	/**
	 * [{"goods_id":"1" ,"goods_name":"鳄鱼纯棉袜子", store_domainPath这个是店铺二级域名路径
	 * goods_domainPath商品二级域名路径"goods_main_photo"
	 * :"upload/store/1/938a670f-081f-4e37-b355-142a551ef0bb.jpg","goods_price"
	 * :"3.30","goods_count":"200","storegoods_count":"0或1"}] 赠品goods_count为赠送数量 需要小于当前库存。storegoods_count为0时则
	 * 使用 goods_count为赠送数量 即在goods_count 确认后会同时扣除当前商品的库存 如库存为200赠送数量100 当前商品库存变为100 storegoods_count为1时
	 * 使用商品当前库存为赠送数量 如库存为200 则赠送个数为200 当正常出售1个赠送商品 后库存为199 赠送数量也为199 赠送数与库存数同步 此时没有goods_count
	 **/
	private String giftInfo;

	/**
	 * [{"goods_id":"1" ,"goods_name":"鳄鱼褐色纯皮裤腰带",store_domainPath这个是店铺二级域名路径
	 * goods_domainPath商品二级域名路径"goods_main_photo"
	 * :"upload/store/1/938a670f-081f-4e37-b355-142a551ef0bb.jpg","goods_price":"54.30"}] 参加的商品
	 **/
	private String goodsInfo;

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

	public BigDecimal getConditionAmount() {
		return conditionAmount;
	}

	public void setConditionAmount(BigDecimal conditionAmount) {
		this.conditionAmount = conditionAmount;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getGiftStatus() {
		return giftStatus;
	}

	public void setGiftStatus(Integer giftStatus) {
		this.giftStatus = giftStatus;
	}

	public Integer getGiftType() {
		return giftType;
	}

	public void setGiftType(Integer giftType) {
		this.giftType = giftType;
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

	public String getFailedReason() {
		return failedReason;
	}

	public void setFailedReason(String failedReason) {
		this.failedReason = failedReason;
	}

	public String getGiftInfo() {
		return giftInfo;
	}

	public void setGiftInfo(String giftInfo) {
		this.giftInfo = giftInfo;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
}