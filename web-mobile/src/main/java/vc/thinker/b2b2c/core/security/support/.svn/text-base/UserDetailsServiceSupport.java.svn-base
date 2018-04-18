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
import redis.clients.jedis.JedisPool;
import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Role;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.OrclUserBaseService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;

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
	private UserCustomerService customerService;

	@Autowired
	private SellerService sellerService;

	@Autowired
	private JedisPool jedisPool;

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
//		UserAccount account= userAccountService.findByLoginName(userName);
		if (userName != null && userName.startsWith(UserContant.ACCOUNT_TYPE_CN)) {
			String password = list[3];
			account = orclUserBaseService.user_login(userName, password);
		} else {
			account = userAccountService.fetchByLoginName(userName);
		}
		if (account == null) {
			throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
		}
		if (account.getIsDeleted())
			throw new LockedException("User " + userName + "is locked");

		UserBO user = userService.findById(account.getUid());

		// 判断用户是否为 个人用户
		/*if(user == null || !UserContant.USER_TYPE_1.equals(user.getUserType())){
		throw new UsernameNotFoundException("User " + userName
					+ " has no GrantedAuthority");
		}  update by 2017.2.21 */
		//add by 2017.4.18
		if(user == null)  
		{
			throw new UsernameNotFoundException("User " + userName
						+ " has no GrantedAuthority");
		}

		CustomerUserDetails userDetails = new CustomerUserDetails();
		userDetails.setUsername(userName);
		userDetails.setPassword(account.getPassword());
		userDetails.setUser(user);

		UserCustomerBO customer = customerService.findSessionUser(user.getId());

		if (customer == null) {
			throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
		}
		userDetails.setCustomer(customer);

		// 如果是商户，加载商户
		SellerBO seller = sellerService.findSessionById(user.getId(),true,null);
		userDetails.setSeller(seller);
		if (seller != null) {
			customer.setStoreId(seller.getStoreId());
		}

		List<RoleBO> roles = userService.findRoleByUid(account.getUid());
		user.setRoles(roles);
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		if (roles != null && !roles.isEmpty()) {

			Iterator<RoleBO> roleIterator = roles.iterator();
			while (roleIterator.hasNext()) {
				Role role = roleIterator.next();
				if (loginRole.equalsIgnoreCase("USER")) {// 普通买家登录，不加载商家和管理员权限
					if (role.getType().equals(UserContant.ROLE_TYPE_BUYER)) {
						GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleCode()
								.toUpperCase());
						authorities.add(grantedAuthority);
						// System.out.println("普通用户登录:" + role.getType()
						// + "   " + role.getRoleCode().toUpperCase()
						// + "-------------"
						// + grantedAuthority.getAuthority());
					}
					if (seller != null) {
						if (role.getType().equals(UserContant.ROLE_TYPE_SELLER)) {
							GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleCode()
									.toUpperCase());
							authorities.add(grantedAuthority);
							// System.out.println("普通用户登录:" + role.getType()
							// + "   " + role.getRoleCode().toUpperCase()
							// + "-------------"
							// + grantedAuthority.getAuthority());
						}
					}
				}
			}
		}
		// GrantedAuthority[] auths = new GrantedAuthority[authorities.size()];
		userDetails.setAuthorities(authorities);
		return userDetails;

	}
}
