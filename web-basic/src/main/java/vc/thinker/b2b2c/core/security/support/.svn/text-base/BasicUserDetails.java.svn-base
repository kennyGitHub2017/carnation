package vc.thinker.b2b2c.core.security.support;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sinco.carnation.sys.bo.UserBO;

/**
 * Basic User Details
 * 
 * @author james
 * 
 */
public abstract class BasicUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2567038825306107862L;

	private UserBO user;

	private String password;

	private String username;

	/** 运营商登录密码 */
	private String operatorPassword;

	// 角色标记
	private String source;

	private Collection<GrantedAuthority> authorities;

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * 得到登陆用户名称
	 * 
	 * @return
	 */
	public abstract String getName();

	/**
	 * 得到用户id
	 * 
	 * @return
	 */
	public Long getId() {
		return user.getId();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getOperatorPassword() {
		return operatorPassword;
	}

	public void setOperatorPassword(String operatorPassword) {
		this.operatorPassword = operatorPassword;
	}

}
