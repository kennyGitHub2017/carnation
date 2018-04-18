package com.sinco.api.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 自定义错误
 * 
 * @author dengwei
 * @date 2014年6月17日 上午10:11:55
 * 
 */
public class AuthTokenException extends AuthenticationException {

	/**
	 * 错误码
	 */
	private String code;

	public AuthTokenException(String msg) {
		super(msg);
	}

	public AuthTokenException(String code, String msg) {
		super(msg);
		this.code = code;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1215400378743161863L;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
