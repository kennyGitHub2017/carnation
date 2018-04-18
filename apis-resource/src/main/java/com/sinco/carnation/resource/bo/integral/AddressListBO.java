package com.sinco.carnation.resource.bo.integral;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "AddressListBO", desc = "我的收货地址列表")
public class AddressListBO {
	/** 收货地址ID **/
	@JsonProperty("id")
	@FieldMapping(desc = "收货地址ID")
	private Long id;

	/** 收货人详细地址 **/
	@JsonProperty("areaInfo")
	@FieldMapping(desc = "收货人详细地址")
	private String areaInfo;

	/** 是否是默认地址 **/
	@JsonProperty("defaultVal")
	@FieldMapping(desc = "是否是默认地址")
	private Boolean defaultVal;

	/** 联系手机 **/
	@JsonProperty("mobile")
	@FieldMapping(desc = "联系手机")
	private String mobile;

	/** 收货人姓名 **/
	@JsonProperty("trueName")
	@FieldMapping(desc = "收货人姓名")
	private String trueName;

	/** 收货人地区 **/
	@JsonProperty("areaName")
	@FieldMapping(desc = "收货人地区")
	private String areaName;

	/** 收货人地区ID **/
	private Long areaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAreaInfo() {
		return areaInfo;
	}

	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}

	public Boolean getDefaultVal() {
		return defaultVal;
	}

	public void setDefaultVal(Boolean defaultVal) {
		this.defaultVal = defaultVal;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
}
