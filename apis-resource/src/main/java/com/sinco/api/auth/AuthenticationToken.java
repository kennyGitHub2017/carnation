package com.sinco.api.auth;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class AuthenticationToken extends AbstractAuthenticationToken {
	private static final long serialVersionUID = 1L;

	private Object principal;

	private String source;

	private final Object credentials;

	@SuppressWarnings("rawtypes")
	Collection authorities;

	// 使用的角色id
	private String useRid;

	// 兴趣id
	private String interestId;

	public AuthenticationToken(String token) {
		super(null);
		super.setAuthenticated(true); // must use super, as we override
		this.principal = null;
		this.credentials = token;
	}

	public AuthenticationToken() {
		super(null);
		super.setAuthenticated(false); // must use super, as we override
		this.principal = null;
		this.credentials = null;
	}

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public Collection getAuthorities() {
		return authorities;
	}

	public void setPrincipal(Object principal) {
		this.principal = principal;
	}

	public String getUseRid() {
		return useRid;
	}

	public void setUseRid(String useRid) {
		this.useRid = useRid;
	}

	public String getInterestId() {
		return interestId;
	}

	public void setInterestId(String interestId) {
		this.interestId = interestId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}