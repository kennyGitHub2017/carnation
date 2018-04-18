package com.sinco.carnation.user.vo;

import com.sinco.carnation.user.model.UserExperts;

public class UserExpertsVO extends UserExperts {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5886503275531627515L;
	private Integer experType;

	public Integer getExperType() {
		return experType;
	}

	public void setExperType(Integer experType) {
		this.experType = experType;
	}

}