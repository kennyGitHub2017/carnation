package com.sinco.carnation.user.bo;

import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.user.model.Address;
import com.sinco.dic.client.annotation.DicMappingModel;
import com.sinco.dic.client.annotation.DicNameMapping;

/**
 * 
 * BO 用于返回数据
 * 
 */
@DicMappingModel
public class AddressBO extends Address {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2489797031818976233L;
	@DicNameMapping(codeField = "areaId", isFull = true, mergeChar = " ", type = Area.class)
	private String areaName;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}