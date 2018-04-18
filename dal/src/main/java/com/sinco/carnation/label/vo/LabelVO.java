package com.sinco.carnation.label.vo;

public class LabelVO {
	private String labelName;
	private Integer ispush;
	private Integer serviceType;
	private Integer state;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public Integer getIspush() {
		return ispush;
	}

	public void setIspush(Integer ispush) {
		this.ispush = ispush;
	}

}