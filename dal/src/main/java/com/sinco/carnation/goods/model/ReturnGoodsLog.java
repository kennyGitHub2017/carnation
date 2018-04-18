package com.sinco.carnation.goods.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class ReturnGoodsLog extends BaseModel {
	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 快递号 **/
	private String expressCode;

	/** 商品总价格 **/
	private String goodsAllPrice;

	/** （原退货商品的佣金比例）,直接改成平台加价 **/
	private BigDecimal goodsCommissionRate;

	/** 商品数量 **/
	private String goodsCount;

	/** 退货的商品id **/
	private Long goodsId;

	/** 退货的商品的sku ids **/
	private String goodsGspIds;

	/** 商品图片路径 **/
	private String goodsMainphotoPath;

	/** 商品的名称 **/
	private String goodsName;

	/** 商品价格 **/
	private String goodsPrice;

	/** 退货商品状态 -2为超过退货时间未能输入退货物流 -1为申请被拒绝，1为可以退货 5为退货申请中 6为审核通过可进行退货 7为退货中，10为退货完成,等待退款，11为平台退款完成 **/
	private String goodsReturnStatus;

	/** 商品的类型 0为自营 1为第三方经销商 **/
	private Integer goodsType;

	/** 退款状态 0为未退款 1为退款完成 **/
	private Integer refundStatus;

	/** 退货描述 **/
	private String returnContent;

	/** 商品对应的订单id **/
	private Long returnOrderId;

	/** 退货服务单号 **/
	private String returnServiceId;

	/** 收货时向买家发送的收货地址，买家通过此将货物发送给卖家 **/
	private String selfAddress;

	/** 商品对应的店铺id **/
	private Long storeId;

	/** 所属用户id **/
	private Long userId;

	/** 申请退货的用户姓名 **/
	private String userName;

	/**
	 * 退货物流公司信息json{"express_company_id":1,"express_company_name":"顺丰快递","express_company_mark":"shunfeng",
	 * "express_company_type":"EXPRESS"}
	 **/
	private String returnExpressInfo;

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

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getGoodsAllPrice() {
		return goodsAllPrice;
	}

	public void setGoodsAllPrice(String goodsAllPrice) {
		this.goodsAllPrice = goodsAllPrice;
	}

	public BigDecimal getGoodsCommissionRate() {
		return goodsCommissionRate;
	}

	public void setGoodsCommissionRate(BigDecimal goodsCommissionRate) {
		this.goodsCommissionRate = goodsCommissionRate;
	}

	public String getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(String goodsCount) {
		this.goodsCount = goodsCount;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsMainphotoPath() {
		return goodsMainphotoPath;
	}

	public void setGoodsMainphotoPath(String goodsMainphotoPath) {
		this.goodsMainphotoPath = goodsMainphotoPath;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsReturnStatus() {
		return goodsReturnStatus;
	}

	public void setGoodsReturnStatus(String goodsReturnStatus) {
		this.goodsReturnStatus = goodsReturnStatus;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
	}

	public String getReturnContent() {
		return returnContent;
	}

	public void setReturnContent(String returnContent) {
		this.returnContent = returnContent;
	}

	public Long getReturnOrderId() {
		return returnOrderId;
	}

	public void setReturnOrderId(Long returnOrderId) {
		this.returnOrderId = returnOrderId;
	}

	public String getReturnServiceId() {
		return returnServiceId;
	}

	public void setReturnServiceId(String returnServiceId) {
		this.returnServiceId = returnServiceId;
	}

	public String getSelfAddress() {
		return selfAddress;
	}

	public void setSelfAddress(String selfAddress) {
		this.selfAddress = selfAddress;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReturnExpressInfo() {
		return returnExpressInfo;
	}

	public void setReturnExpressInfo(String returnExpressInfo) {
		this.returnExpressInfo = returnExpressInfo;
	}

	public String getGoodsGspIds() {
		return goodsGspIds;
	}

	public void setGoodsGspIds(String goodsGspIds) {
		this.goodsGspIds = goodsGspIds;
	}
}