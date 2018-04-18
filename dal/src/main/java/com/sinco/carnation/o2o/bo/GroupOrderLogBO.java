package com.sinco.carnation.o2o.bo;

import com.sinco.carnation.o2o.model.GroupOrderLog;
import com.sinco.carnation.user.model.UserCustomer;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class GroupOrderLogBO extends GroupOrderLog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2456531510021585803L;
	private UserCustomer userCustomer;

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

}