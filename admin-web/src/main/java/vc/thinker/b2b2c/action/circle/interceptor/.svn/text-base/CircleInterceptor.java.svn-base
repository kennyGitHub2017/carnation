package vc.thinker.b2b2c.action.circle.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.sys.service.SysConfigService;

import vc.thinker.b2b2c.core.tools.CommUtil;

public class CircleInterceptor implements HandlerInterceptor {
	@Autowired
	private SysConfigService configService;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj)
			throws Exception {
		// TODO Auto-generated method stub
		boolean ret = false;
		if (configService.getSysConfig().getCircleOpen() == 1) {
			ret = true;
		} else {
			response.sendRedirect(CommUtil.getURL(request) + "/404.htm");
		}
		return ret;
	}

}
