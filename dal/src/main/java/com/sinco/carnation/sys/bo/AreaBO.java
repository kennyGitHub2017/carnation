package com.sinco.carnation.sys.bo;

import com.sinco.carnation.sys.model.Area;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class AreaBO extends Area {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8511103706541209482L;
	/** 省 **/
	private String provinceName;
	/** 市 **/
	private String cityName;
	/** 区 **/
	private String CountyName;

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return CountyName;
	}

	public void setCountyName(String countyName) {
		CountyName = countyName;
	}

}