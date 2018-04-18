package com.sinco.carnation.resource.bo.o2o;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GroupInfo", desc = "消费券详情")
public class OGroupInfoBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("groupSn")
	@FieldMapping(desc = "消息码")
	private String groupSn;

	@JsonProperty("refundReasion")
	@FieldMapping(desc = "退款说明 ")
	private String refundReasion;

	@JsonProperty("status")
	@FieldMapping(desc = "团购信息状态，默认为0，,使用后为1,-1为过期,3申请退款、5退款中、7退款完成")
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupSn() {
		return groupSn;
	}

	public void setGroupSn(String groupSn) {
		this.groupSn = groupSn;
	}

	public String getRefundReasion() {
		return refundReasion;
	}

	public void setRefundReasion(String refundReasion) {
		this.refundReasion = refundReasion;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
