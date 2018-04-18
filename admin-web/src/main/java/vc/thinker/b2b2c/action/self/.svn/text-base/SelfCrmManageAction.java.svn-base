package vc.thinker.b2b2c.action.self;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.service.ConsultService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;

/**
 * 
 * 
 * <p>
 * Title: SelfCrmManageAction.java
 * </p>
 * 
 * <p>
 * Description: 商家中心crm管理控制器
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
 * @date 2014年11月5日
 * 
 * @version 1.0.1
 */
@Controller
public class SelfCrmManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserService userService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private ConsultService consultService;

//	@Autowired
//	private CustomerRelManaService customerRelManaService;
//	@Autowired
//	private MsgTools msgTools;

	@SuppressWarnings("unused")
	@SecurityMapping(title = "自营crm管理", value = "/admin/crm_list.htm*", rtype = "admin", rname = "客户管理", rcode = "crm_admin", rgroup = "商城管理")
	@RequestMapping("/admin/crm_list.htm")
	public ModelAndView crm_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String type, String userName, String email, String message) {
		ModelAndView mv = new JModelAndView("admin/blue/crm_list.html", configService.getSysConfig(), 0,
				request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		String params = "";
//		CustomerRelManaQueryObject qo = new CustomerRelManaQueryObject(
//				currentPage, mv, "addTime", "desc");
//		qo.addQuery("obj.whether_self", new SysMap("whether_self", 1), "=");
//		if (email != null) {
//			if (email.equals("yes")) {
//				qo.addQuery("obj.whether_send_email", new SysMap(
//						"whether_send_email", 1), "=");
//			}
//			if (email.equals("no")) {
//				qo.addQuery("obj.whether_send_email", new SysMap(
//						"whether_send_email", 0), "=");
//			}
//			mv.addObject("email", email);
//		}
//		if (message != null) {
//			if (message.equals("yes")) {
//				qo.addQuery("obj.whether_send_message", new SysMap(
//						"whether_send_message", 1), "=");
//			}
//			if (message.equals("no")) {
//				qo.addQuery("obj.whether_send_message", new SysMap(
//						"whether_send_message", 0), "=");
//			}
//			mv.addObject("message", message);
//		}
//		if (type != null && type.equals("order")) {
//			qo.addQuery("obj.cus_type", new SysMap("cus_type", 0), "=");
//		}
//		if (type != null && type.equals("consult")) {
//			qo.addQuery("obj.cus_type", new SysMap("cus_type", 1), "=");
//		}
//		if (type != null && type.equals("fav")) {
//			qo.addQuery("obj.cus_type", new SysMap("cus_type", 2), "=");
//		}
//		if (userName != null && !userName.equals("")) {
//			qo.addQuery("obj.userName", new SysMap("userName", userName), "=");
//		}
//		WebForm wf = new WebForm();
//		wf.toQueryPo(request, qo, CustomerRelMana.class, mv);
//		IPageList pList = this.customerRelManaService.list(qo);
//		CommUtil.saveIPageList2ModelAndView(url + "/admin/crm_list.htm", "",
//				params, pList, mv);
//		mv.addObject("type", type);
//		mv.addObject("userName", userName);
		return mv;
	}

	@SecurityMapping(title = "自营crm管理", value = "/admin/send_crm_info.htm*", rtype = "admin", rname = "客户管理", rcode = "crm_admin", rgroup = "商城管理")
	@RequestMapping("/admin/send_crm_info.htm")
	public ModelAndView send_crm_info(HttpServletRequest request, HttpServletResponse response,
			String mulitId, String type) {
		ModelAndView mv = new JModelAndView("admin/blue/send_crm_email.html", configService.getSysConfig(),
				0, request, response);
		if (type != null && type.equals("message")) {
			mv = new JModelAndView("admin/blue/send_crm_message.html", configService.getSysConfig(), 0,
					request, response);
		}
		mv.addObject("ids", mulitId);
		return mv;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "自营crm管理", value = "/admin/send_email_save.htm*", rtype = "admin", rname = "客户管理", rcode = "crm_admin", rgroup = "商城管理")
	@RequestMapping("/admin/send_email_save.htm")
	public void send_email_save(HttpServletRequest request, HttpServletResponse response, String ids,
			String message) {
		String subject = this.configService.getSysConfig().getTitle() + "邮件";
		String status = "success";
		if (message != null && !message.equals("")) {
			String[] cids = ids.split(",");
//			for (String id : cids) {
//				CustomerRelMana crm = this.customerRelManaService
//						.getObjById(CommUtil.null2Long(id));
//				if (crm != null && crm.getWhether_self() == 1) {
//					User buyer = this.userService.getObjById(CommUtil
//							.null2Long(crm.getUser_id()));
//					if (buyer != null && buyer.getEmail() != null
//							&& !buyer.getEmail().equals("")) {
//						boolean ret = this.msgTools.sendEmail(buyer.getEmail(),
//								subject, message);
//						if (ret) {
//							crm.setWhether_send_email(1);
//							this.customerRelManaService.update(crm);
//						}
//					}
//				}
//			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(status);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "自营crm管理", value = "/admin/send_message_save.htm*", rtype = "admin", rname = "客户管理", rcode = "crm_admin", rgroup = "商城管理")
	@RequestMapping("/admin/send_message_save.htm")
	public void send_message_save(HttpServletRequest request, HttpServletResponse response, String ids,
			String message) throws UnsupportedEncodingException {
		String subject = this.configService.getSysConfig().getTitle();
		String status = "success";
		if (message != null && !message.equals("")) {
			String[] cids = ids.split(",");
//			for (String id : cids) {
//				CustomerRelMana crm = this.customerRelManaService
//						.getObjById(CommUtil.null2Long(id));
//				if (crm != null && crm.getWhether_self() == 1) {
//					User buyer = this.userService.getObjById(CommUtil
//							.null2Long(crm.getUser_id()));
//					if (buyer != null && buyer.getMobile() != null
//							&& !buyer.getMobile().equals("")) {
//							boolean ret = this.msgTools.sendSMS(
//									buyer.getMobile(), subject + ":" + message);
//							if (ret) {
//								crm.setWhether_send_message(1);
//								this.customerRelManaService.update(crm);
//							}
//						}
//					}
//				}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(status);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "自营crm管理", value = "/admin/crm_del.htm*", rtype = "admin", rname = "客户管理", rcode = "crm_admin", rgroup = "商城管理")
	@RequestMapping("/admin/crm_del.htm")
	public String crm_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		String[] ids = mulitId.split(",");
		User user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		for (String id : ids) {
//			if (!id.equals("")) {
//				CustomerRelMana customerrelmana = this.customerRelManaService
//						.getObjById(Long.parseLong(id));
//				if (customerrelmana != null
//						&& customerrelmana.getWhether_self() == 1) {
//					this.customerRelManaService.delete(Long.parseLong(id));
//				}
//			}
//		}
		return "redirect:crm_list.htm?currentPage=" + currentPage;
	}
}
