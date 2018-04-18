package com.sinco.carnation.resource.bo.o2o;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "Rebate", desc = "分润统计")
public class RebateBO {

	@JsonProperty("totalRebateAmout")
	@FieldMapping(desc = "分润总收入")
	private BigDecimal totalRebateAmout;

	@JsonProperty("rebateAmount")
	@FieldMapping(desc = "分润金额")
	private BigDecimal rebateAmount;// 分润金额

	@JsonProperty("years")
	@FieldMapping(desc = "年")
	private Integer years;// 年

	@JsonProperty("months")
	@FieldMapping(desc = "月")
	private Integer months;// 月

	@JsonProperty("localGroupName")
	@FieldMapping(desc = "线下服务名称")
	private String localGroupName;// 线下服务名称

	@JsonProperty("nickname")
	@FieldMapping(desc = "消费者昵称")
	private String nickname;// 消费者昵称

	@JsonProperty("mobile")
	@FieldMapping(desc = "消费者电话")
	private String mobile;// 消费者电话

	@JsonProperty("groupSn")
	@FieldMapping(desc = "消费码")
	private String rebateCode;// 消费码

	@JsonProperty("userNickName")
	@FieldMapping(desc = "如果是会员则是昵称否则电话号码")
	private String userNickName;

	@JsonProperty("createTime")
	@FieldMapping(desc = "创建时间")
	private Date createTime;

	@JsonProperty("monthTotalPrice")
	@FieldMapping(desc = "月总收入")
	private BigDecimal monthTotalPrice;

	@JsonProperty("ggName")
	@FieldMapping(desc = "服务名称")
	private String ggName;// 服务名称

	@JsonProperty("rabate")
	@FieldMapping(desc = "分润类型")
	private String rabate;

	/** 返利类型 **/
	@JsonProperty("rebateType")
	@FieldMapping(desc = "返利类型")
	private String rebateType;

	@JsonProperty("orderType")
	@FieldMapping(desc = "分润名称——订单/消费码")
	private String orderType;

	public BigDecimal getTotalRebateAmout() {
		return totalRebateAmout;
	}

	public void setTotalRebateAmout(BigDecimal totalRebateAmout) {
		this.totalRebateAmout = totalRebateAmout;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public String getLocalGroupName() {
		return localGroupName;
	}

	public void setLocalGroupName(String localGroupName) {
		this.localGroupName = localGroupName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRebateCode() {
		return rebateCode;
	}

	public void setRebateCode(String rebateCode) {
		this.rebateCode = rebateCode;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getRebateAmount() {
		return rebateAmount;
	}

	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	public BigDecimal getMonthTotalPrice() {
		return monthTotalPrice;
	}

	public void setMonthTotalPrice(BigDecimal monthTotalPrice) {
		this.monthTotalPrice = monthTotalPrice;
	}

	public String getGgName() {
		return ggName;
	}

	public void setGgName(String ggName) {
		this.ggName = ggName;
	}

	public String getRabate() {
		return rabate;
	}

	public void setRabate(String rabate) {
		this.rabate = rabate;
	}

	public String getRebateType() {
		return rebateType;
	}

	public void setRebateType(String rebateType) {
		this.rebateType = rebateType;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

}
