package com.sinco.carnation.resource.bo.o2o;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GoodsRefund", desc = "服务退款列表")
public class GoodsRefundBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("nickName")
	@FieldMapping(desc = "昵称")
	private String nickName;

	@JsonProperty("groupSn")
	@FieldMapping(desc = "消费码")
	private String groupSn;

	@JsonProperty("orderTime")
	@FieldMapping(desc = "下单时间")
	private Date orderTime;

	@JsonProperty("costPrice")
	@FieldMapping(desc = "原价")
	private BigDecimal costPrice;

	@JsonProperty("ggName")
	@FieldMapping(desc = "商品名称 ")
	private String ggName;

	@JsonProperty("ggRebate")
	@FieldMapping(desc = "团购折扣")
	private BigDecimal ggRebate;

	@JsonProperty("groupPrice")
	@FieldMapping(desc = "团队价")
	private BigDecimal groupPrice;

	@JsonProperty("mobile")
	@FieldMapping(desc = "手机号")
	private String mobile;

	@JsonProperty("status")
	@FieldMapping(desc = "团购信息状态，默认为0，使用后为1，过期为-1，审核中为3，审核通过为5，审核不通过为6，退款完成为7")
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGroupSn() {
		return groupSn;
	}

	public void setGroupSn(String groupSn) {
		this.groupSn = groupSn;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public String getGgName() {
		return ggName;
	}

	public void setGgName(String ggName) {
		this.ggName = ggName;
	}

	public BigDecimal getGgRebate() {
		return ggRebate;
	}

	public void setGgRebate(BigDecimal ggRebate) {
		this.ggRebate = ggRebate;
	}

	public BigDecimal getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
