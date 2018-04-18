package com.sinco.carnation.sys.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class VersionControl extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**  **/
	private Integer id;

	/**  **/
	private Date addTime;

	/** 11.IOS appStore 12 IOS 蒲公英 21.安卓 **/
	private Integer vcType;

	/** 版本号 **/
	private String vcNumber;

	/** 版本描述 **/
	private String vcDescribe;

	/** 是否开启 **/
	private Boolean ifOpen;

	/** 是否强制 **/
	private Boolean ifMandatory;

	/** 下载次数 **/
	private Integer downloads;

	/** 下载地址 **/
	private String downloadUrl;

	/**  **/
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