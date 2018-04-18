package com.sinco.carnation.resource.bo.personal;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "Pservice", desc = "服务")
public class PserviceBO {

	@JsonProperty("groupAccPath")
	@FieldMapping(desc = "服务图片")
	private String groupAccPath;

	@JsonProperty("groupId")
	@FieldMapping(desc = "服务Id")
	private Long groupId;

	@JsonProperty("groupName")
	@FieldMapping(desc = "服务名称")
	private String groupName;

	/** 订单总价格 **/
	@JsonProperty("totalPrice")
	@FieldMapping(desc = "服务价格")
	private BigDecimal totalPrice;

	@JsonProperty("groupSn")
	@FieldMapping(desc = "消费码")
	private String groupSn;// 消费码

	@JsonProperty("status")
	@FieldMapping(desc = "默认为0，使用后为1，过期为-1，审核中为3，审核通过为5，审核不通过为6，退款完成为7")
	private Integer status;

    /** 审核说明 **/
	@JsonProperty("checkReasion")
	@FieldMapping(desc = "审核说明 ")
    private String checkReasion;
    
    /** 0.未读1.已读 **/
	@JsonProperty("readStatus")
	@FieldMapping(desc = "0.未读1.已读")
    private Integer readStatus;

    /** 拒绝原因 **/
	@JsonProperty("refusedInfo")
	@FieldMapping(desc = "拒绝原因")
    private String refusedInfo;

	/** 结束时间 **/
	@JsonProperty("endTime")
	@FieldMapping(desc = "结束时间 ")
	private Date endTime;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupAccPath() {
		return groupAccPath;
	}

	public void setGroupAccPath(String groupAccPath) {
		this.groupAccPath = groupAccPath;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getGroupSn() {
		return groupSn;
	}

	public void setGroupSn(String groupSn) {
		this.groupSn = groupSn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCheckReasion() {
		return checkReasion;
	}

	public void setCheckReasion(String checkReasion) {
		this.checkReasion = checkReasion;
	}

	public Integer getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}

	public String getRefusedInfo() {
		return refusedInfo;
	}

	public void setRefusedInfo(String refusedInfo) {
		this.refusedInfo = refusedInfo;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
