package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;

public class UserGroupRole extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6888888346146375817L;

	/**  **/
	private Long roleId;

	/**  **/
	private Long userGroupId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}
}