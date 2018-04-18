package com.sinco.carnation.resource.bo.o2o;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OrderDetails", desc = "订单详情")
public class OrderDetailsBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("nickname")
	@FieldMapping(desc = "昵称")
	private String nickName;

	@JsonProperty("mobile")
	@FieldMapping(desc = "手机号码")
	private String mobile;

	@JsonProperty("groupSn")
	@FieldMapping(desc = "消费码")
	private String groupSn;//

	@JsonProperty("addTime")
	@FieldMapping(desc = "下单时间")
	private Date addTime;

	@JsonProperty("totalPrice")
	@FieldMapping(desc = "订单总价格 ")
	private BigDecimal totalPrice;

	@JsonProperty("groupInfo")
	@FieldMapping(desc = "groupInfo")
	private String groupInfo;

	@JsonProperty("groupService")
	@FieldMapping(desc = "服务")
	private GroupServiceBO service;

	/** 用户昵称,非会员的就显示手机号码 **/
	@JsonProperty("userNickname")
	@FieldMapping(desc = "用户昵称,非会员的就显示手机号码")
	private String userNickname;

	/** 线下服务名称 **/
	@JsonProperty("localGroupName")
	@FieldMapping(desc = "线下服务名称 ")
	private String localGroupName;

	@JsonProperty("groupPrice")
	@FieldMapping(desc = "消费码价格")
	private BigDecimal groupPrice;

	@JsonProperty("profitPrice")
	@FieldMapping(desc = "收益")
	private BigDecimal profitPrice;

	/** 买家id **/
	@JsonProperty("userId")
	@FieldMapping(desc = "买家id")
	private Long userId;

	@JsonProperty("proportion")
	@FieldMapping(desc = "返润比例")
	private BigDecimal proportion;// 返润比例(下线刷卡用)

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGroupSn() {
		return groupSn;
	}

	public void setGroupSn(String groupSn) {
		this.groupSn = groupSn;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getLocalGroupName() {
		return localGroupName;
	}

	public void setLocalGroupName(String localGroupName) {
		this.localGroupName = localGroupName;
	}

	public BigDecimal getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}

	public BigDecimal getProfitPrice() {
		return profitPrice;
	}

	public void setProfitPrice(BigDecimal profitPrice) {
		this.profitPrice = profitPrice;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getProportion() {
		return proportion;
	}

	public void setProportion(BigDecimal proportion) {
		this.proportion = proportion;
	}
}
