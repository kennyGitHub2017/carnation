package com.sinco.api.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.sinco.api.auth.AuthenticationToken;
import com.sinco.api.response.ApiResponse;

public class ActionsUtil {

	public static final String ERROR_PARAM = "3.error_param";

	/**
	 * 得到当前token 用户使用角色id
	 * 
	 * @return
	 */
	public static String getOwnerRid() {
		AuthenticationToken a = (AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		return a.getUseRid();
	}

	/**
	 * 得到当前auth
	 * 
	 * @return
	 */
	public static AuthenticationToken getOwnerAuth() {
		AuthenticationToken a = (AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		return a;
	}

	/**
	 * 得到当前token 的用户id
	 * 
	 * @return
	 */
	public static Long getOwnerUid() {
		Object p = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (p.equals("anonymousUser")) {
			return null;
		}
		return Long.parseLong((String) p);
	}

	/**
	 * 得到登录的角色标识
	 * 
	 * @return
	 */
	public static String getOwnerSource() {
		AuthenticationToken authenticationToken = (AuthenticationToken) SecurityContextHolder.getContext()
				.getAuthentication();
		if (null == authenticationToken) {
			return null;
		}
		return authenticationToken.getSource();
	}

	/**
	 * 得到当前token
	 * 
	 * @return
	 */
	public static String getOwnerToken() {
		return (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
	}

	/**
	 * 处理参数错误
	 * 
	 * @param errors
	 * @param response
	 * @return
	 */
	public static ApiResponse handleParamError(List<ObjectError> errors, ApiResponse response) {
		for (ObjectError obj : errors) {
			if (obj instanceof FieldError) {
				FieldError fieldError = (FieldError) obj;
				Map<String, String> msgParams = new HashMap<String, String>();
				msgParams.put("param", fieldError.getField());
				if (isSystemFieldError(fieldError.getCode())) {
					response.putErrorMessage(ERROR_PARAM, msgParams);
				} else {
					response.putErrorMessage(fieldError.getDefaultMessage(), msgParams);
				}
			} else {
				response.putErrorMessage(obj.getDefaultMessage());
			}
			break;
		}
		return response;
	}

	private static boolean isSystemFieldError(String code) {
		switch (code) {
			case "typeMismatch":
				return true;
			default:
				return false;
		}
	}
}
