package com.sinco.carnation.resource.bo.personal;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "MyselfGroupOrderLine", desc = "个人线下订单列表")
public class MyselfGroupOrderLineBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("status")
	@FieldMapping(desc = "状态|默认为0，使用后为1，过期为-1，审核中为3，审核通过为5，审核不通过为6，退款完成为7")
	private Integer status;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	@JsonProperty("groupAccPath")
	@FieldMapping(desc = "店铺图片")
	private String groupAccPath;

	@JsonProperty("localGroupName")
	@FieldMapping(desc = "线下服务名称")
	private String localGroupName;

	@JsonProperty("totalPrice")
	@FieldMapping(desc = "订单总价格")
	private BigDecimal totalPrice;

	@JsonProperty("originalPrice")
	@FieldMapping(desc = "订单原价")
	private BigDecimal originalPrice;

	@JsonProperty("orderStatus")
	@FieldMapping(desc = "订单状态  订单状态，0为订单取消，10为已提交待付款，20为已付款，30为买家已使用，全部使用后更新该值,50买家评价完毕 ,65订单不可评价，到达设定时间，系统自动关闭订单相互评价功能")
	private Integer orderStatus;

	/** 线下服务退款状态 **/
	@JsonProperty("localReturnStatus")
	@FieldMapping(desc = "线下服务退款状态|1为未退款   2为已退款")
	private Integer localReturnStatus;

	@JsonProperty("userNickname")
	@FieldMapping(desc = "用户昵称,非会员的就显示手机号码 ")
	private String userNickname;

	@JsonProperty("mobile")
	@FieldMapping(desc = "手机号码")
	private String mobile;

	/** 订单号 **/
	@JsonProperty("orderId")
	@FieldMapping(desc = "订单号 ")
	private String orderId;

	/**  **/
	@JsonProperty("addTime")
	@FieldMapping(desc = "下单时间 ")
	private Date addTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLocalGroupName() {
		return localGroupName;
	}

	public void setLocalGroupName(String localGroupName) {
		this.localGroupName = localGroupName;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getLocalReturnStatus() {
		return localReturnStatus;
	}

	public void setLocalReturnStatus(Integer localReturnStatus) {
		this.localReturnStatus = localReturnStatus;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getGroupAccPath() {
		return groupAccPath;
	}

	public void setGroupAccPath(String groupAccPath) {
		this.groupAccPath = groupAccPath;
	}

}
