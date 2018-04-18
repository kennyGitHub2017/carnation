package vc.thinker.b2b2c.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.sys.service.SysConfigService;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;

/**
 * 
 * 
 * <p>
 * Title: AdminEvaManageAction.java
 * </p>
 * 
 * <p>
 * Description: 买家对自营商品管理员的评价
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc<／p>
 * 
 * @author thinker
 * 
 * @date 2014年5月6日
 * 
 * @version 1.0.1
 */

@Controller
public class AdminEvaManageAction {
	@Autowired
	private SysConfigService configService;

	@SecurityMapping(title = "管理员服务评价", value = "/admin/admin_eva.htm*", rtype = "admin", rname = "服务评价", rcode = "admin_evas", rgroup = "商户管理")
	@RequestMapping("/admin/admin_eva.htm")
	public ModelAndView admin_eva(String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_eva.html", configService.getSysConfig(), 0,
				request, response);
//		UserQueryObject uqo = new UserQueryObject(currentPage, mv, orderBy, orderType);
//		WebForm wf = new WebForm();
//		wf.toQueryPo(request, uqo, User.class, mv);
//		uqo.addQuery("obj.userRole", new SysMap("userRole", "ADMIN"), "=");
//		uqo.addQuery("obj.userRole", new SysMap("userRole1", "ADMIN_BUYER_SELLER"), "=", "or");
//		uqo.addQuery("obj.admin_sp.id is not null", null);
//		IPageList pList = this.userService.list(uqo);
//		String url = this.configService.getSysConfig().getAddress();
//		if (url == null || url.equals("")) {
//			url = CommUtil.getURL(request);
//		}
//		CommUtil.saveIPageList2ModelAndView(url + "/admin/admin_eva.htm", "", "", pList, mv);
		mv.addObject("userRole", "ADMIN");
		return mv;
	}
}
