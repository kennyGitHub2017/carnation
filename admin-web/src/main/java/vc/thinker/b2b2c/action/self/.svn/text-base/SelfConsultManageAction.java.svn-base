package vc.thinker.b2b2c.action.self;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.shop.bo.ConsultBO;
import com.sinco.carnation.shop.model.Consult;
import com.sinco.carnation.shop.service.ConsultService;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: ConsultSelfManageAction.java
 * </p>
 * 
 * <p>
 * Description:自营咨询管理
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
 * @date 2014-10-29
 * 
 * @version 1.0.1
 */
@Controller
public class SelfConsultManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ConsultService consultService;
	@Autowired
	private UserService userService;

	@SecurityMapping(title = "自营商品咨询列表", value = "/admin/consult_self.htm*", rtype = "admin", rname = "商品咨询", rcode = "consult_self_manage", rgroup = "商城管理")
	@RequestMapping("/admin/consult_self.htm")
	public ModelAndView consult(HttpServletRequest request, HttpServletResponse response, String reply,
			String currentPage, String consultUserName, MyPage<ConsultBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/consult_self_list.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(20);
		if (StringUtils.isNotBlank(reply)) {
			consultService.queryConsultSelfList(consultUserName, Boolean.parseBoolean(reply), page);
		} else {
			consultService.queryConsultSelfList(consultUserName, null, page);
		}

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("objs", page.getContent());
		mv.addObject("consultUserName", consultUserName);
		mv.addObject("reply", CommUtil.null2String(reply));
		return mv;
	}

	@SecurityMapping(title = "自营商品咨询回复", value = "/admin/consult_self_reply.htm*", rtype = "admin", rname = "商品咨询", rcode = "consult_self_manage", rgroup = "商城管理")
	@RequestMapping("/admin/consult_self_reply.htm")
	public ModelAndView consult_reply(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/consult_self_reply.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotBlank(id)) {
			Consult obj = consultService.queryConsultById(CommUtil.null2Long(id));
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		}
		return mv;
	}

	@SecurityMapping(title = "自营商品咨询回复保存", value = "/admin/consult_reply_self_save.htm*", rtype = "admin", rname = "商品咨询", rcode = "consult_self_manage", rgroup = "商城管理")
	@RequestMapping("/admin/consult_reply_self_save.htm")
	public String consult_reply_save(HttpServletRequest request, HttpServletResponse response, String id,
			String consultReply, String currentPage) throws Exception {
		User user = SecurityUserHolder.getCurrentUser();
		consultService.updateConsult(user, consultReply, id);
		// if (this.configService.getSysConfig().isEmailEnable() &&
		// obj.getConsult_user_id() != null) {
		// Map map = new HashMap();
		// map.put("buyer_id", CommUtil.null2String(obj.getConsult_user_id()));
		// List<Map> maps = CommUtil.Json2List(obj.getGoods_info());
		// for (Map m : maps) {
		// map.put("goods_id", m.get("goods_id").toString());
		// }
		// String json = Json.toJson(map);
		// this.msgTools.sendEmailFree(CommUtil.getURL(request),
		// "email_tobuyer_cousult_reply_notify",
		// this.userService.getObjById(obj.getConsult_user_id()).getEmail(),
		// json,
		// null);
		// }
		return "redirect:consult_self.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "自营商品咨询删除", value = "/admin/consult_self_del.htm*", rtype = "admin", rname = "商品咨询", rcode = "consult_self_manage", rgroup = "商城管理")
	@RequestMapping("/admin/consult_self_del.htm")
	public String consult_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String consult_reply, String currentPage) {
		consultService.deleteConsultByIds(mulitId);
		return "redirect:consult_self.htm?currentPage=1";
	}
}
