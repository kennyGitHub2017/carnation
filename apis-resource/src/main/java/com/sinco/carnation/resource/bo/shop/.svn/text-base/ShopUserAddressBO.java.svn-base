package com.sinco.carnation.resource.bo.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ShopUserAddress", desc = "用户地址")
public class ShopUserAddressBO {

	/**  **/
	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("areaName")
	@FieldMapping(desc = "地址|省+市+区")
	private String areaName;

	@JsonProperty("areaInfo")
	@FieldMapping(desc = "详细地址")
	private String areaInfo;

	@JsonProperty("trueName")
	@FieldMapping(desc = "收件人姓名")
	private String trueName;

	@JsonProperty("mobile")
	@FieldMapping(desc = "收件人手机")
	private String mobile;

	@JsonProperty("zip")
	@FieldMapping(desc = "邮编")
	private String zip;

	@JsonProperty("areaId")
	@FieldMapping(desc = "收货人地区 ")
	private Long areaId;

	@JsonProperty("defaultVal")
	@FieldMapping(desc = "是否是默认地址")
	private Boolean defaultVal;

	public String getAreaName() {
		return areaName;
	}

	public String getAreaInfo() {
		return areaInfo;
	}

	public String getTrueName() {
		return trueName;
	}

	public String getMobile() {
		return mobile;
	}

	public String getZip() {
		return zip;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getId() {
		return id;
	}

	public Boolean getDefaultVal() {
		return defaultVal;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDefaultVal(Boolean defaultVal) {
		this.defaultVal = defaultVal;
	}

}
