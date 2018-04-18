package com.sinco.carnation.user.bo;

import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.user.model.Manager;
import com.sinco.carnation.user.model.UserGroup;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class ManagerBO extends Manager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6183658186537892072L;

	private User user;

	private UserAccount userAccount;

	private UserGroup userGroup;

	public User getUser() {
		return user;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}