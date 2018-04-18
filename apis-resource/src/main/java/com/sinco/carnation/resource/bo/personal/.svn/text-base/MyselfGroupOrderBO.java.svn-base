package com.sinco.carnation.resource.bo.personal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;
import com.sinco.carnation.resource.bo.o2o.GroupServiceBO;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "MyselfGroupOrder", desc = "个人订单列表")
public class MyselfGroupOrderBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("groupAccPath")
	@FieldMapping(desc = "服务图片")
	private String groupAccPath;

	@JsonProperty("ggName")
	@FieldMapping(desc = "服务名称")
	private String ggName;

	@JsonProperty("totalPrice")
	@FieldMapping(desc = "总价")
	private BigDecimal totalPrice;

	@JsonProperty("status")
	@FieldMapping(desc = "状态|默认为0，使用后为1，过期为-1")
	private Integer status;

	@JsonProperty("orderStatus")
	@FieldMapping(desc = "订单状态  订单状态，0为订单取消，10为已提交待付款，20为已付款，30为买家已使用，全部使用后更新该值,50买家评价完毕 ,60卖家已评价,65订单不可评价")
	private Long orderStatus;

	@JsonProperty("goodsCount")
	@FieldMapping(desc = "商品数量")
	private Integer goodsCount;

	@JsonProperty("groupInfo")
	@FieldMapping(desc = "groupInfo")
	private String groupInfo;

	@JsonProperty("service")
	@FieldMapping(desc = "服务信息")
	private GroupServiceBO service;

	@JsonProperty("localGroupName")
	@FieldMapping(desc = "线下服务名称")
	private String localGroupName;

	@JsonProperty("storeId")
	@FieldMapping(desc = "对应店铺")
	private String storeId;

	@JsonProperty("originalPrice")
	@FieldMapping(desc = "订单原价")
	private BigDecimal originalPrice;

	/** 订单类型，1 线上订单 2 扫码支付 3 套餐券 4 代金券 **/
	@JsonProperty("orderType")
	@FieldMapping(desc = "订单类型1|线上订单2|扫码支付3|套餐券4代金券")
	private Integer orderType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupAccPath() {
		return groupAccPath;
	}

	public void setGroupAccPath(String groupAccPath) {
		this.groupAccPath = groupAccPath;
	}

	public String getGgName() {
		return ggName;
	}

	public void setGgName(String ggName) {
		this.ggName = ggName;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	public String getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
	}

	public GroupServiceBO getService() {
		return service;
	}

	public void setService(GroupServiceBO service) {
		this.service = service;
	}

	public Long getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Long orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getLocalGroupName() {
		return localGroupName;
	}

	public void setLocalGroupName(String localGroupName) {
		this.localGroupName = localGroupName;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

}
