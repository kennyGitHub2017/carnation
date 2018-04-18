package com.sinco.carnation.resource.bo.o2o;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GroupClass", desc = "商铺主营类目")
public class GroupClassBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("gcName")
	@FieldMapping(desc = "类目名称")
	private String gcName;

	@JsonProperty("mobileIcon")
	@FieldMapping(desc = "图标")
	private String mobileIcon;

	public String getGcName() {
		return gcName;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
	}

	public String getMobileIcon() {
		return mobileIcon;
	}

	public void setMobileIcon(String mobileIcon) {
		this.mobileIcon = mobileIcon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
