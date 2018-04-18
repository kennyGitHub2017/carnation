package vc.thinker.b2b2c.core.security.support;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.Assert;

import vc.thinker.b2b2c.core.constant.Globals;

/**
 * 
 * <p>
 * Title: ShopAuthenticationProvider.java
 * </p>
 * 
 * <p>
 * Description: 重写SpringSecurityAbstractUserDetailsAuthenticationProvider，用来控制第三方账号登陆 ，第三方账号登录可以使用MD5后密码进行登录
 * ,MD5密码登录使用Globals.THIRD_ACCOUNT_LOGIN作为前缀标识，系统自动不进行处理
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
@SuppressWarnings("deprecation")
public class ShopAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	private PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
	private SaltSource saltSource;
	private UserDetailsService userDetailsService;
	private boolean includeDetailsObject = true;

	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		Object salt = null;
		if (this.saltSource != null) {
			salt = this.saltSource.getSalt(userDetails);
		}
		if (authentication.getCredentials() == null) {
			throw new BadCredentialsException(this.messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"),
					this.includeDetailsObject ? userDetails : null);
		}
		String presentedPassword = authentication.getCredentials().toString();
		if (presentedPassword.indexOf(Globals.THIRD_ACCOUNT_LOGIN) >= 0) {
			presentedPassword = presentedPassword.substring(Globals.THIRD_ACCOUNT_LOGIN.length());
			if (!presentedPassword.equals(userDetails.getPassword())) {
				throw new BadCredentialsException(this.messages.getMessage(
						"AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"),
						this.includeDetailsObject ? userDetails : null);
			}
		} else {
			if (!this.passwordEncoder.isPasswordValid(userDetails.getPassword(), presentedPassword, salt))
				throw new BadCredentialsException(this.messages.getMessage(
						"AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"),
						this.includeDetailsObject ? userDetails : null);
		}
	}

	protected void doAfterPropertiesSet() throws Exception {
		Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
	}

	protected final UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		UserDetails loadedUser;
		try {
			loadedUser = getUserDetailsService().loadUserByUsername(username);
		} catch (DataAccessException repositoryProblem) {
			throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
		}

		if (loadedUser == null) {
			throw new AuthenticationServiceException(
					"UserDetailsService returned null, which is an interface contract violation");
		}

		return loadedUser;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	protected PasswordEncoder getPasswordEncoder() {
		return this.passwordEncoder;
	}

	public void setSaltSource(SaltSource saltSource) {
		this.saltSource = saltSource;
	}

	protected SaltSource getSaltSource() {
		return this.saltSource;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	protected UserDetailsService getUserDetailsService() {
		return this.userDetailsService;
	}

	protected boolean isIncludeDetailsObject() {
		return this.includeDetailsObject;
	}

	/** @info */
	public void setIncludeDetailsObject(boolean includeDetailsObject) {
		this.includeDetailsObject = includeDetailsObject;
	}

}
