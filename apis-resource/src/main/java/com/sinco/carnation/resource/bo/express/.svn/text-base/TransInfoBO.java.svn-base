package com.sinco.carnation.resource.bo.express;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "TransInfo", desc = "快递信息结果")
public class TransInfoBO {

	@JsonProperty("expressEompanyName")
	@FieldMapping(desc = "快递公司信息")
	private String expressEompanyName;

	@JsonProperty("expressShipCode")
	@FieldMapping(desc = " 快递单号")
	private String expressShipCode;

	@JsonProperty("data")
	@FieldMapping(desc = "详细信息")
	private List<TransContentBO> data;

	@JsonProperty("expressName")
	@FieldMapping(desc = "快递公司名称")
	private String expressName;

	public String getExpressEompanyName() {
		return expressEompanyName;
	}

	public void setExpressEompanyName(String expressEompanyName) {
		this.expressEompanyName = expressEompanyName;
	}

	public String getExpressShipCode() {
		return expressShipCode;
	}

	public void setExpressShipCode(String expressShipCode) {
		this.expressShipCode = expressShipCode;
	}

	public List<TransContentBO> getData() {
		return data;
	}

	public void setData(List<TransContentBO> data) {
		this.data = data;
	}

	public String getExpressName() {
		return expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

}
