package com.sinco.api.auth;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

import com.sinco.api.exception.AuthTokenException;

/**
 * 得到 token 的过滤器
 * 
 * @author dengwei
 * @date 2014年6月17日 上午10:31:01
 * 
 */
public class CustomTokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	@Autowired
	private AccessDecisionManager accessDecisionManager;

	@Autowired
	private FilterSecurityInterceptor securityMetadataSource;

	private static final Logger logger = LoggerFactory.getLogger(CustomTokenAuthenticationFilter.class);

	public CustomTokenAuthenticationFilter(String defaultFilterProcessesUrl,
			AuthenticationManager authenticationManager, AuthenticationFailureHandler failureHandler) {
		super("/");
		// 先使用正则做url过滤
		super.setRequiresAuthenticationRequestMatcher(new RegexRequestMatcher(defaultFilterProcessesUrl, null));
		logger.info("[authorized] fileter processes url :" + defaultFilterProcessesUrl);
		setAuthenticationManager(authenticationManager);
		setAuthenticationFailureHandler(failureHandler);
		setAuthenticationSuccessHandler(new TokenSimpleUrlAuthenticationSuccessHandler());
	}

	@SuppressWarnings("unused")
	private static final String HEADER_NAME = "WWW-Authenticate";

	public static final String AUTHORIZATION = "Authorization";

	@SuppressWarnings("unused")
	private static final String HEADER_VALUE = "Bearer realm=\"%s\"";

	private static final String PREFIX = "bearer";

	/**
	 * Attempt to authenticate request - basically just pass over to another method to authenticate request
	 * headers
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		String url = request.getServletPath();
		String header = request.getHeader(AUTHORIZATION);
		logger.debug("[authorized] request header : " + header + ",request url :" + url);
		if (header != null) {
			final int space = header.indexOf(' ');
			if (space > 0) {
				final String method = header.substring(0, space);
				if (PREFIX.equalsIgnoreCase(method)) {
					final String credentials = header.substring(space + 1);
					AbstractAuthenticationToken userAuthenticationToken = authUserByToken(credentials);
					if (userAuthenticationToken == null) {
						logger.error("[unauthorized] access token is empty in header ,request header : "
								+ header + ",request url :" + url);
						throw new AuthTokenException("2.404",
								MessageFormat.format("Error | {0}", "Bad Token"));
					}
					return this.getAuthenticationManager().authenticate(userAuthenticationToken);

				}
			}
		}
		return new AnonymousAuthenticationToken(UUID.randomUUID().toString(), "anonymousUser",
				AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS"));
	}

	/**
	 * authenticate the user based on token
	 * 
	 * @return
	 */
	private AbstractAuthenticationToken authUserByToken(String token) {
		if (StringUtils.isBlank(token)) {
			logger.debug("[unauthorized] access token is empty");
			return null;
		}
		AbstractAuthenticationToken authToken = new AuthenticationToken(token);
		try {
			return authToken;
		} catch (Exception e) {
			logger.error("Authenticate user by token error: ", e);
		}
		return authToken;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String authToken = request.getHeader(AUTHORIZATION);

		if (!requiresAuthentication(request, response)) {
			chain.doFilter(request, response);
			return;
		}
		Authentication authResult;
		try {
			authResult = attemptAuthentication(request, response);
			FilterInvocation fi = new FilterInvocation(request, response, chain);
			Collection<ConfigAttribute> attributes = this.securityMetadataSource
					.obtainSecurityMetadataSource().getAttributes(fi);
			logger.debug("[authorized] access token=" + authToken);
			accessDecisionManager.decide(authResult, fi, attributes);
		} catch (InternalAuthenticationServiceException failed) {
			logger.error("An internal error occurred while trying to authenticate the user.", failed);
			unsuccessfulAuthentication(request, response, failed);

			return;
		} catch (AuthenticationException failed) {
			logger.error("[unauthorized] access token is error,token=" + authToken);
			// Authentication failed
			unsuccessfulAuthentication(request, response, failed);
			return;
		} catch (AccessDeniedException failed) {
			logger.error("[unauthorized] access token access denied,token=" + authToken);
			unsuccessfulAuthentication(request, response,
					new AuthTokenException("2.401", MessageFormat.format("Error | {0}", failed.getMessage())));
			return;
		}
		successfulAuthentication(request, response, chain, authResult);
	}

}
