package vc.thinker.b2b2c.security;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import vc.thinker.b2b2c.exception.AuthTokenException;

/**
 * 得到 token 的过滤器
 * 
 * @author Tivan
 * @date 2017年6月23日 上午15:31:01
 * 
 */
public class CustomTokenAuthenticationFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(CustomTokenAuthenticationFilter.class);

	@SuppressWarnings("unused")
	private static final String HEADER_NAME = "WWW-Authenticate";

	public static final String AUTHORIZATION = "Authorization";

	@SuppressWarnings("unused")
	private static final String HEADER_VALUE = "Bearer realm=\"%s\"";

	private static final String PREFIX = "bearer";
	
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		String url = request.getServletPath();
		String header = request.getHeader(AUTHORIZATION);
		if(StringUtils.isEmpty(header)){
			//測試用
			header = request.getParameter(AUTHORIZATION);
		}
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
					WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
					TokenAuthenticationManager tokenAuthenticationManager = wac.getBean(TokenAuthenticationManager.class);
					return tokenAuthenticationManager.authenticate(userAuthenticationToken);
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
		if (StringUtils.isEmpty(token)) {
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

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		Authentication auth = attemptAuthentication(req, res);
		new TokenSimpleUrlAuthenticationSuccessHandler().onAuthenticationSuccess(req, res, auth);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
