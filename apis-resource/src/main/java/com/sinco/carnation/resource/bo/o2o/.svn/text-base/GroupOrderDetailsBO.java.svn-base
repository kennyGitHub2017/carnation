package com.sinco.carnation.resource.bo.o2o;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GroupOrderDetails", desc = "团购订单详情")
public class GroupOrderDetailsBO {

	@JsonProperty("orderId")
	@FieldMapping(desc = "订单号")
	private String orderId;

	@JsonProperty("addTime")
	@FieldMapping(desc = "下单时间")
	private Date addTime;

	@JsonProperty("nickName")
	@FieldMapping(desc = "昵称")
	private String nickName;

	@JsonProperty("mobile")
	@FieldMapping(desc = "手机号码")
	private String mobile;

	@JsonProperty("serviceBO")
	@FieldMapping(desc = "商品信息")
	private GroupServiceBO serviceBO;

	@JsonProperty("groupInfo")
	@FieldMapping(desc = "券列表")
	private List<OGroupInfoBO> groupInfo;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public GroupServiceBO getServiceBO() {
		return serviceBO;
	}

	public void setServiceBO(GroupServiceBO serviceBO) {
		this.serviceBO = serviceBO;
	}

	public List<OGroupInfoBO> getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(List<OGroupInfoBO> groupInfo) {
		this.groupInfo = groupInfo;
	}

}
