package com.sinco.carnation.shop.bo;

import com.sinco.carnation.shop.model.ShipAddress;
import com.sinco.carnation.sys.model.Area;
import com.sinco.dic.client.annotation.DicMappingModel;
import com.sinco.dic.client.annotation.DicNameMapping;

/**
 * 
 * BO 用于返回数据
 * 
 */
@DicMappingModel
public class ShipAddressBO extends ShipAddress {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@DicNameMapping(codeField = "saAreaId", isFull = true, type = Area.class, mergeChar = "")
	private String areaName;

	private String parentId;

	private Long areaId;

	public String getAreaName() {
		return areaName;
	}

	public String getParentId() {
		return parentId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

}