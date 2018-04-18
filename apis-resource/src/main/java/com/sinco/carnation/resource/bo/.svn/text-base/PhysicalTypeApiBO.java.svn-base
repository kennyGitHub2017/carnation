package com.sinco.carnation.resource.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "PhysicalTypeApiBO", desc = "体检类型")
public class PhysicalTypeApiBO {

	@JsonProperty("profile")
	@FieldMapping(desc = "类别简介")
	private String profile;

	@JsonProperty("memo")
	@FieldMapping(desc = "详细内容")
	private String memo;

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}