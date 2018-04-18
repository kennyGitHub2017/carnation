package com.sinco.carnation.resource.bo.self;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;
import com.sinco.carnation.resource.bo.shop.ShopGoodsBo;
import com.sinco.carnation.resource.bo.shop.ShopGoodsInfo;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "SelfOrder", desc = "用户订单列表")
public class SelfOrderBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("orderId")
	@FieldMapping(desc = "订单号")
	private String orderId;

	@JsonProperty("childOrderDetail")
	@FieldMapping(desc = "子订单")
	private String childOrderDetail;

	@JsonProperty("orderStatus")
	@FieldMapping(desc = "订单状态  订单状态，0为订单取消，10为已提交待付款，15为线下付款提交申请，16为货到付款，20为已付款待发货，30为已发货待收货，40为已收货，50买家评价完毕 ,65订单不可评价，到达设定时间，系统自动关闭订单相互评价功能")
	private Integer orderStatus;

	@JsonProperty("shipPrice")
	@FieldMapping(desc = "配送价格 ")
	private BigDecimal shipPrice;

	@JsonProperty("goods")
	@FieldMapping(desc = "商品信息")
	private ShopGoodsBo goods;

	@JsonProperty("receiverName")
	@FieldMapping(desc = "收货人姓名")
	private String receiverName;

	@JsonProperty("receiverArea")
	@FieldMapping(desc = "收货人地区 ")
	private String receiverArea;

	@JsonProperty("receiverAreaInfo")
	@FieldMapping(desc = "收货人详细地址")
	private String receiverAreaInfo;

	@JsonProperty("goodsInfos")
	@FieldMapping(desc = "商品信息")
	private List<ShopGoodsInfo> goodsInfos;

	@JsonProperty("goodsInfo")
	@FieldMapping(desc = "订单商品详情 订单商品信息")
	private String goodsInfo;

	@JsonProperty("totalPrice")
	@FieldMapping(desc = "订单总价")
	private BigDecimal totalPrice;

	@JsonProperty("receiverMobile")
	@FieldMapping(desc = "收货人手机号码")
	private String receiverMobile;

	@JsonProperty("storeId")
	@FieldMapping(desc = "订单对应店铺id")
	private String storeId;

	@JsonProperty("storeName")
	@FieldMapping(desc = "订单对应店铺名称")
	private String storeName;

	@JsonProperty("couponAmount")
	@FieldMapping(desc = "优惠券金额")
	private double couponAmount;

	@JsonProperty("addTime")
	@FieldMapping(desc = "下单时间")
	private Date addTime;

	@JsonProperty("goodsAmount")
	@FieldMapping(desc = "商品总价格")
	private BigDecimal goodsAmount;

	@JsonProperty("expressCompanyId")
	@FieldMapping(desc = "快递公司id")
	private Long expressCompanyId;

	@JsonProperty("shipCode")
	@FieldMapping(desc = "物流单号")
	private String shipCode;

	/** 订单种类 0为商家，1为自营商品订单 **/
	@JsonProperty("orderForm")
	@FieldMapping(desc = "订单种类 0为商家，1为自营商品订单")
	private Integer orderForm;

	@JsonProperty("payWay")
	@FieldMapping(desc = "支付方式")
	private String payWay;

	@JsonProperty("allygPrice")
	@FieldMapping(desc = "云购币总和")
	private BigDecimal allygPrice;
	@JsonProperty("allCashPrice")
	@FieldMapping(desc = "云购产品现金总和")
	private BigDecimal allCashPrice;

	@JsonProperty("actualygPrice")
	@FieldMapping(desc = "云购币订单实际支付云购币")
	private BigDecimal actualygPrice;
	@JsonProperty("actualPrice")
	@FieldMapping(desc = "云购币订单实际支付现金  ")
	private BigDecimal actualPrice;

	@JsonProperty("commissionAmount")
	@FieldMapping(desc = "佣金总费用/BV")
	private BigDecimal commissionAmount;

	@JsonProperty("orderTypeFlag")
	@FieldMapping(desc = "0普通 1零元购 2云购币[非专区] 3云购币专区")
	private Integer orderTypeFlag;

	@JsonProperty("payTypeFlag")
	@FieldMapping(desc = "支付方式 ，1重消 2积分")
	private Integer payTypeFlag;
	
	@JsonProperty("actualIntegral")
	@FieldMapping(desc = "实际支付积分")
	private BigDecimal actualIntegral;
	
	@JsonProperty("allIntegral")
	@FieldMapping(desc = "订单需要积分总和")
	private BigDecimal allIntegral;
	
	@JsonProperty("juanpiOrder")
	@FieldMapping(desc = "卷皮订单0否 1是")
	private Integer juanpiOrder;
	
	@JsonProperty("targetUrlM")
	@FieldMapping(desc = "订单明细跳转链接")
	private String targetUrlM;
	
	@JsonProperty("isDelete")
	@FieldMapping(desc = "卷皮是否可以删除")
	private boolean isDelete;
	

	public Long getExpressCompanyId() {
		return expressCompanyId;
	}

	public void setExpressCompanyId(Long expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getChildOrderDetail() {
		return childOrderDetail;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public ShopGoodsBo getGoods() {
		return goods;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverArea() {
		return receiverArea;
	}

	public String getReceiverAreaInfo() {
		return receiverAreaInfo;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setChildOrderDetail(String childOrderDetail) {
		this.childOrderDetail = childOrderDetail;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setGoods(ShopGoodsBo goods) {
		this.goods = goods;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiverArea(String receiverArea) {
		this.receiverArea = receiverArea;
	}

	public void setReceiverAreaInfo(String receiverAreaInfo) {
		this.receiverAreaInfo = receiverAreaInfo;
	}

	public List<ShopGoodsInfo> getGoodsInfos() {
		return goodsInfos;
	}

	public void setGoodsInfos(List<ShopGoodsInfo> goodsInfos) {
		this.goodsInfos = goodsInfos;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(BigDecimal shipPrice) {
		this.shipPrice = shipPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public String getStoreId() {
		return storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public double getCouponAmount() {
		return couponAmount;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public BigDecimal getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(BigDecimal goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setCouponAmount(double couponAmount) {
		this.couponAmount = couponAmount;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public Integer getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(Integer orderForm) {
		this.orderForm = orderForm;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public BigDecimal getAllygPrice() {
		if (null == allygPrice) {
			return  new BigDecimal(0);
		}
		return allygPrice;
	}

	public void setAllygPrice(BigDecimal allygPrice) {
		this.allygPrice = allygPrice;
	}

	public BigDecimal getAllCashPrice() {
		if (null == allCashPrice) {
			return  new BigDecimal(0);
		}
		return allCashPrice;
	}

	public void setAllCashPrice(BigDecimal allCashPrice) {
		this.allCashPrice = allCashPrice;
	}

	public BigDecimal getActualygPrice() {
		if (null == actualygPrice) {
			return new BigDecimal(0);
		}
		return actualygPrice;
	}

	public void setActualygPrice(BigDecimal actualygPrice) {
		this.actualygPrice = actualygPrice;
	}

	public BigDecimal getActualPrice() {
		if (null == actualPrice) {
			return new BigDecimal(0);
		}
		return actualPrice;
	}

	public void setActualPrice(BigDecimal actualPrice) {
		this.actualPrice = actualPrice;
	}

	public BigDecimal getCommissionAmount() {
		if (null == commissionAmount) {
			return new BigDecimal(0);
		}
		return commissionAmount;
	}

	public void setCommissionAmount(BigDecimal commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public Integer getOrderTypeFlag() {
		if (null == orderTypeFlag) {
			return 0;
		}
		return orderTypeFlag;
	}

	public void setOrderTypeFlag(Integer orderTypeFlag) {
		this.orderTypeFlag = orderTypeFlag;
	}

	public Integer getPayTypeFlag() {
		if (null == payTypeFlag) {
			return 0;
		}
		return payTypeFlag;
	}

	public void setPayTypeFlag(Integer payTypeFlag) {
		this.payTypeFlag = payTypeFlag;
	}

	public BigDecimal getActualIntegral() {
		if (null == actualIntegral) {
			return new BigDecimal(0);
		}
		return actualIntegral;
	}

	public void setActualIntegral(BigDecimal actualIntegral) {
		this.actualIntegral = actualIntegral;
	}

	public BigDecimal getAllIntegral() {
		if (null == allIntegral) {
			return new BigDecimal(0);
		}
		return allIntegral;
	}

	public void setAllIntegral(BigDecimal allIntegral) {
		this.allIntegral = allIntegral;
	}

	public Integer getJuanpiOrder() {
		if (null == juanpiOrder) {
			return 0;
		}
		return juanpiOrder;
	}

	public void setJuanpiOrder(Integer juanpiOrder) {
		this.juanpiOrder = juanpiOrder;
	}

	public String getTargetUrlM() {
		return targetUrlM;
	}

	public void setTargetUrlM(String targetUrlM) {
		this.targetUrlM = targetUrlM;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	
}
