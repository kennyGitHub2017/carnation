package com.sinco.carnation.o2o.vo;

import com.sinco.carnation.o2o.model.GroupFloor;

public class GroupFloorVO extends GroupFloor {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5514322666547426281L;

	private String caseContent;

	private Long groupFloorStoreCityId;

	private String groupFloorStores;

	public String getCaseContent() {
		return caseContent;
	}

	public void setCaseContent(String caseContent) {
		this.caseContent = caseContent;
	}

	public Long getGroupFloorStoreCityId() {
		return groupFloorStoreCityId;
	}

	public void setGroupFloorStoreCityId(Long groupFloorStoreCityId) {
		this.groupFloorStoreCityId = groupFloorStoreCityId;
	}

	public String getGroupFloorStores() {
		return groupFloorStores;
	}

	public void setGroupFloorStores(String groupFloorStores) {
		this.groupFloorStores = groupFloorStores;
	}

}