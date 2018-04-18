package com.sinco.carnation.resource.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "SysVersionControlBO", desc = "最新版本信息")
public class SysVersionControlBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Integer id;

	@JsonProperty("addTime")
	@FieldMapping(desc = "添加时间")
	private Date addTime;

	@JsonProperty("vcType")
	@FieldMapping(desc = "11.IOS appStore 12 IOS 蒲公英  21.安卓 ")
	private Integer vcType;

	@JsonProperty("vcNumber")
	@FieldMapping(desc = "版本号")
	private String vcNumber;

	@JsonProperty("vcDescribe")
	@FieldMapping(desc = "版本描述")
	private String vcDescribe;

	@JsonProperty("ifOpen")
	@FieldMapping(desc = "是否开启")
	private Boolean ifOpen;

	@JsonProperty("ifMandatory")
	@FieldMapping(desc = "是否强制")
	private Boolean ifMandatory;

	@JsonProperty("downloads")
	@FieldMapping(desc = "下载次数")
	private Integer downloads;

	@JsonProperty("downloadUrl")
	@FieldMapping(desc = "下载地址")
	private String downloadUrl;

	@JsonProperty("vcState")
	@FieldMapping(desc = "状态")
	private Boolean vcState;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getVcType() {
		return vcType;
	}

	public void setVcType(Integer vcType) {
		this.vcType = vcType;
	}

	public String getVcNumber() {
		return vcNumber;
	}

	public void setVcNumber(String vcNumber) {
		this.vcNumber = vcNumber;
	}

	public String getVcDescribe() {
		return vcDescribe;
	}

	public void setVcDescribe(String vcDescribe) {
		this.vcDescribe = vcDescribe;
	}

	public Boolean getIfOpen() {
		return ifOpen;
	}

	public void setIfOpen(Boolean ifOpen) {
		this.ifOpen = ifOpen;
	}

	public Boolean getIfMandatory() {
		return ifMandatory;
	}

	public void setIfMandatory(Boolean ifMandatory) {
		this.ifMandatory = ifMandatory;
	}

	public Integer getDownloads() {
		return downloads;
	}

	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public Boolean getVcState() {
		return vcState;
	}

	public void setVcState(Boolean vcState) {
		this.vcState = vcState;
	}

}
