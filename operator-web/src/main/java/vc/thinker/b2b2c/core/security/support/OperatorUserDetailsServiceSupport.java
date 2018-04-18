package vc.thinker.b2b2c.core.security.support;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Role;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.OrclUserBaseService;

/**
 * 
 * <p>
 * Title: SecurityManagerSupport.java
 * </p>
 * 
 * <p>
 * Description: 用户登录管理器，用户名、密码验证完成后进入该验证器，该验证器用来获取用户权限获取及外部系统同步登录,该控制用来控制用户权限加载
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2015-5-20
 * 
 * @version 1.0.1
 */
public class OperatorUserDetailsServiceSupport implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private OrclUserBaseService orclUserBaseService;

	public UserDetails loadUserByUsername(String data) throws UsernameNotFoundException, DataAccessException {
		String[] list = data.split(",");
		String userName = list[0];
		String loginRole = "user";
		if (list.length == 2) {
			loginRole = list[1];
		}
		UserAccount account = null;
		if (userName != null && userName.startsWith(UserContant.ACCOUNT_TYPE_CN)) {
			String password = list[2];
			account = orclUserBaseService.operator_login(userName, password);
		} else {
			account = userAccountService.fetchByLoginName(userName);
		}
		if (account == null) {
			throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
		}

		UserBO user = userService.findById(account.getUid());

		if (!user.getStatus().equals(1))
			throw new LockedException("User " + userName + "is locked");

		// 判断用户是否为运营商
		if (user == null || !UserContant.USER_TYPE_4.equals(user.getUserType())) {
			throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
		}

		OperatorUserDetails userDetails = new OperatorUserDetails();
		userDetails.setUsername(userName);
		userDetails.setPassword(account.getPassword());
		userDetails.setOperatorPassword(account.getOperatorPassword());
		userDetails.setUser(user);

		System.out.println("ID11===============" + user.getId());
		OperatorBO operatorBO = operatorService.getOperatorBOByUserId(user.getId());
		if (operatorBO == null) {
			throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
		}
		userDetails.setOperatorBO(operatorBO);;

		// List<RoleBO> roles=userService.findRoleByUid(account.getUid());
		List<RoleBO> roles = userService.findRoleByType(UserContant.ROLE_TYPE_OPERATOR);
		user.setRoles(roles);
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		if (roles != null && !roles.isEmpty()) {

			Iterator<RoleBO> roleIterator = roles.iterator();
			while (roleIterator.hasNext()) {
				Role role = roleIterator.next();
				if (loginRole.equalsIgnoreCase("USER")) {
					if (role.getType().equals(UserContant.ROLE_TYPE_OPERATOR)) {
						GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleCode()
								.toUpperCase());
						authorities.add(grantedAuthority);
					}
					if (operatorBO != null) {
						if (role.getType().equals(UserContant.ROLE_TYPE_OPERATOR)) {
							GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleCode()
									.toUpperCase());
							authorities.add(grantedAuthority);
						}
					}
				}
			}
		}
		userDetails.setAuthorities(authorities);
		return userDetails;

	}
}
