package com.sinco.carnation.resource.bo.express;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "TransContent", desc = "快递信息详情")
public class TransContentBO {
	@JsonProperty("time")
	@FieldMapping(desc = "快递处理时间")
	private String time;

	@JsonProperty("context")
	@FieldMapping(desc = "快递处理的详细信息")
	private String context;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}
