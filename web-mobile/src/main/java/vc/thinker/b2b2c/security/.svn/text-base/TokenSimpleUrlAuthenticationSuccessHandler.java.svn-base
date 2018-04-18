package vc.thinker.b2b2c.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.service.UserService;

public class TokenSimpleUrlAuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String uid = String.valueOf(authentication.getPrincipal());
		if(StringUtils.isNumeric(uid)){
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			UserService userService = wac.getBean(UserService.class);
			if(userService != null){
				UserBO userBO = userService.findById(Long.valueOf(uid));
				request.getSession().setAttribute("user", userBO);
			}
		}
	}
}