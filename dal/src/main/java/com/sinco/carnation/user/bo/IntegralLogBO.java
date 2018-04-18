package com.sinco.carnation.user.bo;

import com.sinco.carnation.user.model.IntegralLog;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class IntegralLogBO extends IntegralLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	// 会员名
	private String loginName;
	// 操作用户名
	private String operateName;

	// 类型名
	private String typeName;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}