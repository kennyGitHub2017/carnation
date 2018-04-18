package com.sinco.carnation.user.bo;

import java.util.List;

import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.user.model.UserGroup;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class UserGroupBO extends UserGroup {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3919503215973259423L;

	private List<RoleBO> roles;

	public List<RoleBO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleBO> roles) {
		this.roles = roles;
	}

}