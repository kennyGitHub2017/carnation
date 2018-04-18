package com.sinco.carnation.resource.bo.o2o;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GroupOrder", desc = "商户订单列表")
public class GroupOrderBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("nickName")
	@FieldMapping(desc = "用户昵称")
	private String nickName;

	@JsonProperty("mobile")
	@FieldMapping(desc = "手机")
	private String mobile;

	@JsonProperty("groupSn")
	@FieldMapping(desc = "消费码")
	private String groupSn;

	@JsonProperty("totalPrice")
	@FieldMapping(desc = "订单总价格")
	private BigDecimal totalPrice;

	@JsonProperty("addTime")
	@FieldMapping(desc = "下单时间")
	private Date addTime;

	@JsonProperty("orderStatus")
	@FieldMapping(desc = "订单状态|0为订单取消，10为已提交待付款，20为已付款，30为买家已使用，全部使用后更新该值,50买家评价完毕 ,65订单不可评价")
	private Integer orderStatus;
	
	@JsonProperty("orderType")
	@FieldMapping(desc = "订单类型|1线上订单，2扫码支付，3优惠买单，4套餐券,5代金券")
	private Integer orderType;

	@JsonProperty("groupInfo")
	@FieldMapping(desc = "团购商品详情")
	private String groupInfo;

	@JsonProperty("localReturnStatus")
	@FieldMapping(desc = "线下服务退款状态|1为未退款   2为已退款")
	private Integer localReturnStatus;

	@JsonProperty("localGroupName")
	@FieldMapping(desc = "线下服务名称")
	private String localGroupName;

	@JsonProperty("orderId")
	@FieldMapping(desc = "订单号 ")
	private String orderId;

	@JsonProperty("groupService")
	@FieldMapping(desc = "服务")
	private GroupServiceBO service;

	@JsonProperty("groupInfoBOs")
	@FieldMapping(desc = "券列表")
	private List<OGroupInfoBO> groupInfoBOs;

	@JsonProperty("paymentMark")
	@FieldMapping(desc = "支付方式 ")
	private String paymentMark;

	public String getNickName() {
		return nickName;
	}

	public String getMobile() {
		return mobile;
	}

	public String getGroupSn() {
		return groupSn;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setGroupSn(String groupSn) {
		this.groupSn = groupSn;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public GroupServiceBO getService() {
		return service;
	}

	public void setService(GroupServiceBO service) {
		this.service = service;
	}

	public String getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
	}

	public List<OGroupInfoBO> getGroupInfoBOs() {
		return groupInfoBOs;
	}

	public void setGroupInfoBOs(List<OGroupInfoBO> groupInfoBOs) {
		this.groupInfoBOs = groupInfoBOs;
	}

	public Integer getLocalReturnStatus() {
		return localReturnStatus;
	}

	public void setLocalReturnStatus(Integer localReturnStatus) {
		this.localReturnStatus = localReturnStatus;
	}

	public String getLocalGroupName() {
		return localGroupName;
	}

	public void setLocalGroupName(String localGroupName) {
		this.localGroupName = localGroupName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

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

	public String getPaymentMark() {
		return paymentMark;
	}

	public void setPaymentMark(String paymentMark) {
		this.paymentMark = paymentMark;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
}
