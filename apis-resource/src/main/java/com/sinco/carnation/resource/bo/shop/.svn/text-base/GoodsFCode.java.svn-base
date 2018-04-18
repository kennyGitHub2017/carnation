package com.sinco.carnation.resource.bo.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GoodsFCode", desc = "F码信息")
public class GoodsFCode {

	@JsonProperty("status")
	@FieldMapping(desc = "状态")
	private String status;

	@JsonProperty("code")
	@FieldMapping(desc = "code")
	private String code;

	public String getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
