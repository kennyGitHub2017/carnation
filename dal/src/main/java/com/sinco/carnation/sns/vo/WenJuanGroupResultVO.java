package com.sinco.carnation.sns.vo;

import com.sinco.carnation.sns.model.WenJuanGroupResult;

public class WenJuanGroupResultVO extends WenJuanGroupResult {

	private static final long serialVersionUID = -3989301232121790577L;

	private Long wjThemeID;

	private String healthStatus;

	public String getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	public Long getWjThemeID() {
		return wjThemeID;
	}

	public void setWjThemeID(Long wjThemeID) {
		this.wjThemeID = wjThemeID;
	}

}