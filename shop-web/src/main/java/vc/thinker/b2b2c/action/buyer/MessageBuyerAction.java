package vc.thinker.b2b2c.action.buyer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.bo.MessageBO;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: MessageBuyerAction.java
 * </p>
 * 
 * <p>
 * Description:用户中心站内短信控制器
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-10-15
 * 
 * @version 1.0.1
 */
@Controller
public class MessageBuyerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserCustomerService userCustomerService;

	@SecurityMapping(title = "站内短信", value = "/buyer/message.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/message.htm")
	public ModelAndView message(HttpServletRequest request, HttpServletResponse response, String type,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/message.html",
				configService.getSysConfig(), 0, request, response);
		if (CommUtil.null2String(type).equals("sys") || CommUtil.null2String(type).equals("my")
				|| CommUtil.null2String(type).equals("")) {
			MyPage<MessageBO> page = new MyPage<MessageBO>();
			page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
			type = "pc";
			messageService.selectByUser(SecurityUserHolder.getCurrentUser().getId(), type, page);
			type = "sys";
			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
			this.cal_msg_info(mv);
			if (!CommUtil.null2String(type).equals("my") && !CommUtil.null2String(type).equals("sys")) {
				type = "";
			}
			mv.addObject("type", type);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "您所访问的地址不存在");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}

		return mv;
	}

	@SecurityMapping(title = "站内短信删除", value = "/buyer/message_del.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/message_del.htm")
	public String message_del(HttpServletRequest request, HttpServletResponse response, String type,
			String mulitId) {
		String[] ids = mulitId.split(",");
		User user = SecurityUserHolder.getCurrentUser();
		for (String id : ids) {
			if (!id.equals("")) {
				Message msg = messageService.getObjById(CommUtil.null2Long(id));
				if (user.getId().equals(msg.getFromUserId()) || user.getId().equals(msg.getToUserId()))
					messageService.delete(CommUtil.null2Long(id));
			}
		}

		return "redirect:message.htm?type=" + type;
	}

	@SecurityMapping(title = "站内短信查看", value = "/buyer/message_info.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/message_info.htm")
	public ModelAndView message_info(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/message_info.html",
				configService.getSysConfig(), 0, request, response);
		MessageBO obj = messageService.getObjById(CommUtil.null2Long(id));
		if (obj != null) {
			messageService.markRead(CommUtil.null2Long(id), SecurityUserHolder.getCurrentUser().getId());
			MyPage<MessageBO> page = new MyPage<MessageBO>();
			page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
			messageService.selectByParent(obj.getId(), page);
			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
			mv.addObject("obj", obj);
			cal_msg_info(mv);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "参数错误，站内信查看失败");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/message.htm");
		}

		return mv;
	}

	@SecurityMapping(title = "站内短信发送", value = "/buyer/message_send.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/message_send.htm")
	public ModelAndView message_send(HttpServletRequest request, HttpServletResponse response, String userName) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/message_send.html",
				configService.getSysConfig(), 0, request, response);
		cal_msg_info(mv);
		if (StringUtils.isNotEmpty(userName))
			mv.addObject("userName", userName);

		return mv;
	}

	@SecurityMapping(title = "站内短信保存", value = "/buyer/message_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/message_save.htm")
	public void message_save(HttpServletRequest request, HttpServletResponse response, String users,
			String content) {
		String[] userNames = users.split(",");
		for (String userName : userNames) {
			UserCustomerBO toUser = userCustomerService.selectByNickname(userName);
			if (toUser != null) {
				Message msg = new Message();
				msg.setAddTime(new Date());
				content = content.replaceAll("\n", "thinkervc_br");
				msg.setContent(Jsoup.clean(content, Whitelist.basic()).replaceAll("thinkervc_br", "\n"));
				msg.setFromUserId(SecurityUserHolder.getCurrentUser().getId());
				msg.setToUserId(toUser.getUid());
				msg.setType(1);
				msg.setStatus(0);
				messageService.save(msg);
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "站内短信回复", value = "/buyer/message_reply.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/message_reply.htm")
	public void message_reply(HttpServletRequest request, HttpServletResponse response, String pid,
			String content) {
		Message parent = messageService.getObjById(Long.parseLong(pid));
		boolean ret = false;
		if (userService.findById(parent.getFromUserId()).getUserType() != 9) {
			Message reply = new Message();
			reply.setAddTime(new Date());
			reply.setContent(content);
			reply.setFromUserId(SecurityUserHolder.getCurrentUser().getId());
			reply.setToUserId(parent.getFromUserId());
			reply.setType(1);
			reply.setStatus(0);
			reply.setParentId(parent.getId());
			reply.setMsgCat(1);// 设置该信息为回复信息
			messageService.save(reply);
			if (!parent.getFromUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
				parent.setReplyStatus(1);
			}
			ret = messageService.update(parent);
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "发送信息用户验证", value = "/buyer/message_validate_user.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/message_validate_user.htm")
	public void message_validate_user(HttpServletRequest request, HttpServletResponse response, String users) {
		String[] userNames = users.replaceAll("，", ",").trim().split(",");
		boolean ret = true;
		for (String userName : userNames) {
			if (!userName.trim().equals("")) {
				UserCustomerBO user = userCustomerService.selectByNickname(userName);
				if (user == null) {
					ret = false;
				} else {
					if (userService.findById(user.getUid()).getUserType() == 9)
						ret = false;
					else if (SecurityUserHolder.getCurrentUser().getId().equals(user.getUid()))
						ret = false;
				}
			}
		}

		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void cal_msg_info(ModelAndView mv) {
		long userId = SecurityUserHolder.getCurrentUser().getId();
		// 查询当前用户收到的未读站内信
		List<MessageBO> user_msgs = messageService.forCountA(userId);

		// 查询系统发送给当前用户且未读的站内信
		List<MessageBO> sys_msgs = messageService.forCountB(userId);

		// 查询当前用户发送且有新回复的站内信
		List<MessageBO> replys = messageService.forCountC(userId);

		List<MessageBO> allmsg = messageService.forCountAll(userId);

		mv.addObject("msg_size", allmsg);
		mv.addObject("user_msgs", user_msgs);
		mv.addObject("sys_msgs", sys_msgs);
		mv.addObject("reply_msgs", replys);
	}
}
