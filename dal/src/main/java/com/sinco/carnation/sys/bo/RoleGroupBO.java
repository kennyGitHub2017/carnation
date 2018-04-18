package com.sinco.carnation.sys.bo;

import java.util.List;

import com.sinco.carnation.sys.model.RoleGroup;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class RoleGroupBO extends RoleGroup {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5324904090663811206L;
	private List<RoleBO> roles;

	public List<RoleBO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleBO> roles) {
		this.roles = roles;
	}

}