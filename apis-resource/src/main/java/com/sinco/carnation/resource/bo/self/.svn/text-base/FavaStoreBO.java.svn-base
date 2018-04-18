package com.sinco.carnation.resource.bo.self;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "FavaStore", desc = "我收藏的店铺")
public class FavaStoreBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	@JsonProperty("storeLogoPath")
	@FieldMapping(desc = "店铺logo")
	private String storeLogoPath;

	public Long getId() {
		return id;
	}

	public String getStoreName() {
		return storeName;
	}

	public String getStoreLogoPath() {
		return storeLogoPath;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setStoreLogoPath(String storeLogoPath) {
		this.storeLogoPath = storeLogoPath;
	}
}
