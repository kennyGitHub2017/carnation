package com.sinco.carnation.resource.bo.personal;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "POrderDetails", desc = "个人订单详情")
public class POrderDetailsBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("orderId")
	@FieldMapping(desc = "订单号")
	private String orderId;

	@JsonProperty("groupSn")
	@FieldMapping(desc = "消费码")
	private String groupSn;

	@JsonProperty("mobile")
	@FieldMapping(desc = "购买人手机号码")
	private String mobile;

	@JsonProperty("paymentMark")
	@FieldMapping(desc = "支付方式")
	private String paymentMark;

	@JsonProperty("payTime")
	@FieldMapping(desc = "付款时间 ")
	private Date payTime;

	@JsonProperty("totalPrice")
	@FieldMapping(desc = "订单总价格")
	private BigDecimal totalPrice;

	@JsonProperty("endTime")
	@FieldMapping(desc = "结束时间")
	private Date endTime;

	@JsonProperty("userNickname")
	@FieldMapping(desc = "用户昵称,非会员的就显示手机号码")
	private String userNickname;

	@JsonProperty("storeAddress")
	@FieldMapping(desc = "详细地址")
	private String storeAddress;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	@JsonProperty("storeTelephone")
	@FieldMapping(desc = "店铺电话")
	private String storeTelephone;

	@JsonProperty("serviceList")
	@FieldMapping(desc = "服务列表")
	private List<PserviceBO> serviceList;

	@JsonProperty("orderStatus")
	@FieldMapping(desc = "订单状态|订单状态，0为订单取消，10为已提交待付款，20为已付款，30为买家已使用，全部使用后更新该值,50买家评价完毕 ,60卖家已评价,65订单不可评价")
	private Integer orderStatus;

	@JsonProperty("localGroupName")
	@FieldMapping(desc = "线下服务名称")
	private String localGroupName;

	@JsonProperty("distance")
	@FieldMapping(desc = "距离")
	private Double distance;

	@JsonProperty("storeLat")
	@FieldMapping(desc = "纬度")
	private Double storeLat;

	@JsonProperty("storeLon")
	@FieldMapping(desc = "经度")
	private Double storeLon;

	@JsonProperty("orderType")
	@FieldMapping(desc = "订单类型，1 线上订单  2 线下刷卡订单")
	private Integer orderType;

	@JsonProperty("groupId")
	@FieldMapping(desc = "服务id")
	private Long groupId;
	
	@JsonProperty("originalPrice")
	@FieldMapping(desc = "原始价格（折扣前）")
	private BigDecimal originalPrice;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getGroupSn() {
		return groupSn;
	}

	public void setGroupSn(String groupSn) {
		this.groupSn = groupSn;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPaymentMark() {
		return paymentMark;
	}

	public void setPaymentMark(String paymentMark) {
		this.paymentMark = paymentMark;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public List<PserviceBO> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<PserviceBO> serviceList) {
		this.serviceList = serviceList;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getLocalGroupName() {
		return localGroupName;
	}

	public void setLocalGroupName(String localGroupName) {
		this.localGroupName = localGroupName;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

	public Double getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(Double storeLat) {
		this.storeLat = storeLat;
	}

	public Double getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(Double storeLon) {
		this.storeLon = storeLon;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

}
