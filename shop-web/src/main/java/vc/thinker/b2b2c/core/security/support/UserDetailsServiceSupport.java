package vc.thinker.b2b2c.core.security.support;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import redis.clients.jedis.JedisPool;
import vc.thinker.b2b2c.tools.exception.AccountException;

import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
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
	Logger logger = LoggerFactory.getLogger(this.getClass());
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
	private StoreService storeService;

	@Autowired
	private OrclUserBaseService orclUserBaseService;

	public UserDetails loadUserByUsername(String data) throws UsernameNotFoundException, DataAccessException {
		
		String[] list = data.split(",");
		String userName = list[0];
		logger.info("username========" + userName);
		String loginRole = "user";
		String source = null;
		String password = null;
		if (list.length >= 2) {
			loginRole = list[1];
		}
		if (list.length >= 3) {
			password = list[2];
		}
		if (list.length >= 4) {
			source = list[3];
		}
		UserAccount account = null;
		userName = userName.trim();
//		UserAccount account= userAccountService.findByLoginName(userName);                     
		if (userName != null && userName.startsWith(UserContant.ACCOUNT_TYPE_CN)) {
			logger.info("username========" + userName + "--------start");
			account = orclUserBaseService.user_login(userName, password);
		} else if(userName != null && userName.startsWith(UserContant.ACCOUNT_TYPE_AN)){//增加AN验证
			
			 account = orclUserBaseService.user_seven_login(userName, password);
			 if (account == null) {
				 logger.debug("userName- {} 登录失败", userName);
				 throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
				}
			 
			 CustomerUserDetails userDetails1 = new CustomerUserDetails();
			 userDetails1.setUsername(userName);
			 userDetails1.setPassword(password);
			 return userDetails1;
			
		}else {
			account = userAccountService.fetchByLoginName(userName);
		}
		boolean isCNAccount = false;
		if (account == null) {
			throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
		} else {
			// 判断该手机是否绑定CN账号，如绑定则提示到CN入口登录
			if (userName.length() == 11 && !userName.startsWith(UserContant.ACCOUNT_TYPE_CN)) {
				UserAccountBO vo = new UserAccountBO();
				vo.setAccountType(UserContant.ACCOUNT_TYPE_8);
				vo.setUid(account.getUid());
				UserAccountBO account_ = userAccountService.findAccountByVo(vo);
				if (account_ != null) {
					account = orclUserBaseService.user_login(account_.getLoginName(), password);
					isCNAccount = true;
					if (null == account) {
						throw new UsernameNotFoundException("User " + userName + "");
					}
				}
			}
		}
		UserBO user = userService.findById(account.getUid());
		if (user != null && !user.getStatus().equals(1))
			throw new LockedException("User " + userName + "is locked");

		// 判断用户是否为 个人用户
		if (user == null || !UserContant.USER_TYPE_1.equals(user.getUserType())) {
			if (!UserContant.USER_TYPE_10.equals(user.getUserType())) {// 增加云购币商家用户判断
				if (!UserContant.USER_TYPE_4.equals(user.getUserType())) {// 增加CN运营商级别
					throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
				} else if (userName.startsWith("YY") || userName.startsWith("yy")) {
					throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
				}
			}
		}

		CustomerUserDetails userDetails = new CustomerUserDetails();
		userDetails.setUsername(userName);
		if (null == source || userName.startsWith(UserContant.ACCOUNT_TYPE_CN) || isCNAccount) {
			userDetails.setPassword(account.getPassword());
		} else {
			setPasswordToSource(account, source, userDetails);
		}
		userDetails.setUser(user);

		//UserCustomerBO customer = customerService.findSessionUser(user.getId());
		UserCustomerBO customer = this.customerService.findOneByUserId(user.getId());
		if (customer == null) {
			throw new UsernameNotFoundException("User " + userName + " has no GrantedAuthority");
		}
		userDetails.setCustomer(customer);
		
		
		SellerBO seller = null;
		if (UserContant.ACCOUNT_TYPE_SUPPLIER.equals(source)) {
			seller = sellerService.findSessionById(user.getId(),null,true);
		}else if (UserContant.ACCOUNT_TYPE_MERCHANT.equals(source)) {
			seller = sellerService.findSessionById(user.getId(),true,null);
		}else {
			try {
				seller = this.sellerService.findByUid(user.getId());
			} catch (Exception e) {
				logger.info("【seller info】",e);
			}
			
		}
		

	
		userDetails.setSeller(seller);

		// 判断该用户是商户还是供应商。
		StoreBO store = null;
		if (seller != null) {
			customer.setStoreId(seller.getStoreId());
			store = storeService.getObjById(userDetails.getStoreId());

		}

		// 判断不同角色间的登录，防止商户界面登录供应商，供应商界面登录商户
		if (!UserContant.ACCOUNT_TYPE_RESOURCE.equals(source)) {
			if ((null == store || !store.getIsShop()) && UserContant.ACCOUNT_TYPE_SUPPLIER.equals(source)) {
				throw new AccountException("供应商身份不存在，请先入驻");
			}
			if ((null == store || !store.getIsO2o()) && UserContant.ACCOUNT_TYPE_MERCHANT.equals(source)) {
				throw new AccountException("商户身份不存在，请先入驻");

			}
		}

		// List<RoleBO> roles=userService.findRoleByUid(account.getUid());
		List<RoleBO> roles = userService.findRoleByType(UserContant.ROLE_TYPE_SELLER,
				UserContant.ROLE_TYPE_BUYER);

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
		// 添加标识
		if (StringUtils.isNotBlank(source)) {
			userDetails.setSource(source);
		}
		return userDetails;

	}

	private void setPasswordToSource(UserAccount account, String source, CustomerUserDetails userDetails) {
		// 不同角色验证对应的密码
		switch (source) {
			case UserContant.ACCOUNT_TYPE_RESOURCE:
				userDetails.setPassword(account.getPassword());
				break;
			case UserContant.ACCOUNT_TYPE_MERCHANT:
				userDetails.setPassword(account.getSellerPassword());
				break;
			case UserContant.ACCOUNT_TYPE_SUPPLIER:
				userDetails.setPassword(account.getSupplierPassword());
				break;
			case UserContant.ACCOUNT_TYPE_YY:
				userDetails.setPassword(account.getOperatorPassword());
				break;
		}
	}
}
