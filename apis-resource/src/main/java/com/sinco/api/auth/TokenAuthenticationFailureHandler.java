/*
 * Copyright 2012 SURFnet bv, The Netherlands
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sinco.api.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.sinco.api.error.ErrorResource;
import com.sinco.api.error.Node;
import com.sinco.api.exception.AuthTokenException;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.util.ServletUtils;

/**
 * token 异常处理
 * 
 * @author dengwei
 * @date 2014年6月17日 上午10:41:51
 * 
 */
public class TokenAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private final static Logger logger = LoggerFactory.getLogger(TokenAuthenticationFailureHandler.class);

	private ErrorResource errorResource;

	public TokenAuthenticationFailureHandler() {
		super();
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authenticationException) throws IOException, ServletException {

		if (authenticationException instanceof AuthTokenException) {

			AuthTokenException tokenException = (AuthTokenException) authenticationException;

			ApiResponse errorResponse = new ErrorAipResponse();

			if (StringUtils.isNotBlank(tokenException.getCode())) {
				if (errorResource.containsCode(tokenException.getCode())) {

					Node node = errorResource.findNode(tokenException.getCode());

					errorResponse.setErrorCode(node.getRootNode());
					errorResponse.setMsg(node.getRootMsg());
					errorResponse.setSubCode(node.getKey());
					errorResponse.setSubMsg(node.getValue());

					// 发送错误
					ServletUtils.renderJson(response, errorResponse);
				} else {
					logger.warn(tokenException.getCode() + " Error is not find");
					// 返回服务器500
					response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), tokenException.getCode()
							+ " Error is not find");
				}
			}

		} else {
			response.sendError(HttpStatus.UNAUTHORIZED.value(), authenticationException.getMessage());
		}
	}

	public ErrorResource getErrorResource() {
		return errorResource;
	}

	public void setErrorResource(ErrorResource errorResource) {
		this.errorResource = errorResource;
	}
}
