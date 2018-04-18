package com.sinco.carnation.resource.bo.operator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "Operator", desc = "营运商信息")
public class UserOperatorBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("operatorName")
	@FieldMapping(desc = "营运商名称")
	private String operatorName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

}
