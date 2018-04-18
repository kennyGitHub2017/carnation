package vc.thinker.b2b2c.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.AuthenticationEntryPoint;

public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.AuthenticationException authException) throws IOException,
			ServletException {
		String contentType = request.getContentType();
		logger.info(contentType);
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}

}