package vc.thinker.b2b2c.core.security.support;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import redis.clients.jedis.JedisPool;

import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Role;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.ManagerBO;
import com.sinco.carnation.user.bo.UserExpertsBO;
import com.sinco.carnation.user.service.ExpertsService;
import com.sinco.carnation.user.service.ManagerService;

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
public class UserDetailsServiceSupport implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private ManagerService managerService;

	@Autowired
	private ExpertsService expertsService;

	@Autowired
	private JedisPool jedisPool;

	public UserDetails loadUserByUsername(String data) throws UsernameNotFoundException, DataAccessException {
		String[] list = data.split(",");
		String userName = list[0];
		String loginRole = "user";
		String source = null;
		if (list.length >= 2) {
			loginRole = list[1];
		}

		UserAccount account = userAccountService.findByLoginName(userName);

		if (account == null) {
			throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
		}

		UserBO user = userService.findById(account.getUid());

		if (user == null
				|| (!UserContant.USER_TYPE_9.equals(user.getUserType()) && !UserContant.USER_TYPE_3
						.equals(user.getUserType()))) {
			throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
		}
		AdminUserDetails userDetails = new AdminUserDetails();
		userDetails.setUsername(userName);

		userDetails.setPassword(account.getPassword());

		userDetails.setUser(user);

		// 后台目前有管理员和专家可以登陆
		if (UserContant.USER_TYPE_3.equals(user.getUserType())) {
			UserExpertsBO experts = expertsService.selectById(user.getId());
			if (experts == null || experts.getIsDeleted()) {
				throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
			}
			userDetails.setExperts(experts);
		} else if (UserContant.USER_TYPE_9.equals(user.getUserType())) {
			ManagerBO manager = managerService.getObjById(user.getId());

			if (manager == null || manager.getIsDeleted()) { // 逻辑删除的用户也不能登录
				throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
			}
			userDetails.setManager(manager);
		} else {
			throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
		}

		List<RoleBO> roles = userService.findRoleByUid(account.getUid());
		user.setRoles(roles);
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		if (roles != null && !roles.isEmpty()) {

			Iterator<RoleBO> roleIterator = roles.iterator();
			while (roleIterator.hasNext()) {
				Role role = roleIterator.next();
				if (loginRole.equalsIgnoreCase("ADMIN")) {
					if (role.getType().equals("ADMIN") || role.getType().equals("BUYER")) {// 超级管理员仅仅加载超级管理员权限和买家权限
						GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleCode()
								.toUpperCase());
						authorities.add(grantedAuthority);
						// System.out.println("管理员登录:" + role.getType() + "   "
						// + role.getRoleCode().toUpperCase()
						// + "-------------"
						// + grantedAuthority.getAuthority());
					}
				} else {
					if (loginRole.equalsIgnoreCase("USER")) {// 普通买家登录，不加载商家和管理员权限
						if (role.getType().equals("BUYER")) {
							GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleCode()
									.toUpperCase());
							authorities.add(grantedAuthority);
							// System.out.println("普通用户登录:" + role.getType()
							// + "   " + role.getRoleCode().toUpperCase()
							// + "-------------"
							// + grantedAuthority.getAuthority());
						}
					}
					if (loginRole.equalsIgnoreCase("SELLER")) {// 商家登录，不加载管理员和买家权限
						if (role.getType().equals("SELLER")) {
							GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleCode()
									.toUpperCase());
							authorities.add(grantedAuthority);
							// System.out.println("商家登录:" + role.getType() +
							// "   "
							// + role.getRoleCode().toUpperCase()
							// + "-------------"
							// + grantedAuthority.getAuthority());
						}
					}
					if (loginRole.equalsIgnoreCase("DELIVERY")) {// 自提点用户登录，加载普通买家及自提点权限
						if (role.getType().equals("DELIVERY")) {
							GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleCode()
									.toUpperCase());
							authorities.add(grantedAuthority);
							// System.out.println("自提点用户登录:" + role.getType() +
							// "   "
							// + role.getRoleCode().toUpperCase()
							// + "-------------"
							// + grantedAuthority.getAuthority());
						}
					}
				}
			}
		}
		// GrantedAuthority[] auths = new GrantedAuthority[authorities.size()];
		userDetails.setAuthorities(authorities);
		// 添加标识
		if (StringUtils.isNotBlank(source)) {
			userDetails.setSource(source);
		}
		return userDetails;

	}

}
