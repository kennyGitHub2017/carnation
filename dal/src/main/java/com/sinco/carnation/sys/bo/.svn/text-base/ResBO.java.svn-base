package com.sinco.carnation.sys.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sinco.carnation.sys.model.Res;
import com.sinco.carnation.sys.model.Role;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class ResBO extends Res {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6130953206227307661L;
	private List<RoleBO> roles;

	public List<RoleBO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleBO> roles) {
		this.roles = roles;
	}

	public static String getRoleAuthorities(List<Role> roles) {
		List<String> roleAuthorities = new ArrayList<String>();
		for (Role role : roles) {
			roleAuthorities.add(role.getRoleCode());
		}
		return StringUtils.join(roleAuthorities.toArray(), ",");
	}
}