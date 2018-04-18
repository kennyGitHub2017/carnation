package com.sinco.carnation.resource.bo.shop;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ReturnGoodsLog", desc = "退货日志")
public class ReturnGoodsLogBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("addTime")
	@FieldMapping(desc = "申请时间")
	private Date addTime;

	@JsonProperty("expressCode")
	@FieldMapping(desc = "快递号")
	private String expressCode;

	@JsonProperty("expressCompanyName")
	@FieldMapping(desc = "快递公司名称")
	private String expressCompanyName;

	@JsonProperty("expressCompanyId")
	@FieldMapping(desc = "快递公司 id")
	private Long expressCompanyId;

	@JsonProperty("goodsAllPrice")
	@FieldMapping(desc = "商品总价格")
	private String goodsAllPrice;

	@JsonProperty("goodsId")
	@FieldMapping(desc = "退货的商品id")
	private Long goodsId;

	@JsonProperty("goodsGspIds")
	@FieldMapping(desc = "退货的商品 sku ids")
	private String goodsGspIds;

	@JsonProperty("goodsMainphotoPath")
	@FieldMapping(desc = " 商品图片路径 ")
	private String goodsMainphotoPath;

	@JsonProperty("goodsName")
	@FieldMapping(desc = "商品的名称")
	private String goodsName;

	@JsonProperty("goodsPrice")
	@FieldMapping(desc = "商品价格")
	private String goodsPrice;

	@JsonProperty("goodsReturnStatus")
	@FieldMapping(desc = "退货商品状态 -2为超过退货时间未能输入退货物流 -1为申请被拒绝，1为可以退货 5为退货申请中 6为审核通过可进行退货 7为退货中，10为退货完成,等待退款，11为平台退款完成")
	private String goodsReturnStatus;

	@JsonProperty("goodsType")
	@FieldMapping(desc = "商品的类型 0为自营 1为第三方经销商")
	private Integer goodsType;

	@JsonProperty("refundStatus")
	@FieldMapping(desc = "退款状态 0为未退款 1为退款完成")
	private Integer refundStatus;

	@JsonProperty("returnContent")
	@FieldMapping(desc = "退货描述")
	private String returnContent;

	@JsonProperty("returnOrderId")
	@FieldMapping(desc = "商品对应的订单id ")
	private Long returnOrderId;

	@JsonProperty("returnServiceId")
	@FieldMapping(desc = "退货服务单号")
	private String returnServiceId;

	@JsonProperty("selfAddress")
	@FieldMapping(desc = "收货时向买家发送的收货地址，买家通过此将货物发送给卖家")
	private String selfAddress;

	@JsonProperty("storeId")
	@FieldMapping(desc = "商品对应的店铺id")
	private Long storeId;

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

	public String getGoodsGspIds() {
		return goodsGspIds;
	}

	public void setGoodsGspIds(String goodsGspIds) {
		this.goodsGspIds = goodsGspIds;
	}

	public String getExpressCompanyName() {
		return expressCompanyName;
	}

	public void setExpressCompanyName(String expressCompanyName) {
		this.expressCompanyName = expressCompanyName;
	}

	public Long getExpressCompanyId() {
		return expressCompanyId;
	}

	public void setExpressCompanyId(Long expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}
}
