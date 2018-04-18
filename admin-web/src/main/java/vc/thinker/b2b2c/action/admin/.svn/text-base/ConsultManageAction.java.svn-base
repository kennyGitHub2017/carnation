package vc.thinker.b2b2c.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.shop.bo.ConsultBO;
import com.sinco.carnation.shop.service.ConsultService;
import com.sinco.carnation.shop.vo.ConsultVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: ConsultManageAction.java
 * </p>
 * 
 * <p>
 * Description: 系统咨询管理类，
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
 * @date 2014年4月24日
 * 
 * @version 1.0.1
 */
@Controller
public class ConsultManageAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private ConsultService consultService;

	/**
	 * Consult列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "咨询列表", value = "/admin/consult_list.htm*", rtype = "admin", rname = "咨询管理", rcode = "consult_admin", rgroup = "内容管理")
	@RequestMapping("/admin/consult_list.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, ConsultVO vo,
			String currentPage, MyPage<ConsultBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/consult_list.html", configService.getSysConfig(), 0,
				request, response);
		page.setPageSize(20);
//		consultService.queryConsultList(consultUserName,page);
		consultService.findListByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
//		mv.addObject("objs", page.getContent());
//		mv.addObject("consultUserName", consultUserName);
		mv.addObject("vo", vo);
		return mv;
	}

	@SecurityMapping(title = "咨询删除", value = "/admin/consult_del.htm*", rtype = "admin", rname = "咨询管理", rcode = "consult_admin", rgroup = "内容管理")
	@RequestMapping("/admin/consult_del.htm")
	public String delete(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		consultService.deleteConsultByIds(mulitId);
		return "redirect:consult_list.htm?currentPage=" + currentPage;
	}
}