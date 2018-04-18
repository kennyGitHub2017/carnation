package com.sinco.carnation.sys.vo;

import com.sinco.carnation.user.model.UserExperts;

public class ExpertsVO extends UserExperts {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String loginName;

	private String password;

	public String getLoginName() {
		return loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
