package vc.thinker.b2b2c.action.market;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.service.SysConfigService;

public class BaseAction {

	private final Logger log = LoggerFactory.getLogger(BaseAction.class);

	@Autowired
	protected SysConfigService configService;

	/**
	 * response 返回给客户端的文本消息
	 * 
	 * @param msg
	 */
	public void returnBodyMsg(String msg, HttpServletResponse response) {

		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ModelAndView returnError(String msg, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("op_title", msg);
		return mv;
	}

	/**
	 * 
	 * @param response
	 * @param json
	 */
	public void returnJson(HttpServletResponse response, String json) {
		response.reset();
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(json);
		} catch (IOException e) {
			e.printStackTrace();
			log.error(String.format("returnJson错误:%s", CommUtil.getStackTrace(e)));
		}

	}

}
