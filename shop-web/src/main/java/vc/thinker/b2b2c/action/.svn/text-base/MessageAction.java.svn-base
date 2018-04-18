package vc.thinker.b2b2c.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.market.bo.MsgInfoBO;
import com.sinco.carnation.market.enums.EmReceiveType;
import com.sinco.carnation.market.service.MsgInfoService;
import com.sinco.carnation.sys.service.SysConfigService;

import vc.thinker.b2b2c.core.mv.JModelAndView;

@Controller
public class MessageAction {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(MessageAction.class);
	@Autowired
	private SysConfigService configService;
	@Autowired
	private MsgInfoService msgInfoService;

	/**
	 * 调整注册用户的所属地
	 * 
	 * @param request
	 * @param response
	 * @param key
	 */
	@RequestMapping("/messgae_get_content.htm")
	public ModelAndView messgae_get_content(HttpServletRequest request, HttpServletResponse response, Long id) {

		ModelAndView mv = new JModelAndView("message/message_content.html", configService.getSysConfig(), 1,
				request, response);

		if (id == null) {
			mv.addObject("content", "参数错误");
			return mv;
		}

		MsgInfoBO bo = this.msgInfoService.findOne(id);

		if (bo != null && bo.getReceiveType() == (byte) EmReceiveType.Html.getValue()) {
			mv.addObject("content", bo.getContent());
			return mv;
		} else {
			mv.addObject("content", "消息不存在！！");
			return mv;
		}

	}
}
