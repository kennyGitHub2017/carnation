package vc.thinker.b2b2c.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.notice.service.OperatorNoticesService;
import com.sinco.carnation.sns.bo.OperatorNoticesBO;
import com.sinco.carnation.sns.vo.OperatorNoticesVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

@Controller
public class NoticeManageAction {

	@Autowired
	private SysConfigService configService;

	@Autowired
	private OperatorNoticesService operatorNoticesService;

	/**
	 * 公告列表
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "公告列表", value = "/admin/operator_notice_list.htm*", rtype = "admin", rname = "广告管理", rcode = "operator_notice_admin", rgroup = "内容管理")
	@RequestMapping("/admin/operator_notice_list.htm")
	public ModelAndView operatorNoticeList(HttpServletRequest request, HttpServletResponse response,
			OperatorNoticesVO vo, MyPage<OperatorNoticesBO> page) {

		ModelAndView mv = new JModelAndView("admin/blue/operator_notice_list.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(10);
		operatorNoticesService.findPageByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("vo", vo);
		return mv;
	}

	/**
	 * 公告详情
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "公告详情", value = "/admin/operator_notice_detail.htm*", rtype = "admin", rname = "广告管理", rcode = "operator_notice_detail", rgroup = "内容管理")
	@RequestMapping("/admin/operator_notice_detail.htm")
	public ModelAndView operatorNoticeList(HttpServletRequest request, HttpServletResponse response, Long id) {

		ModelAndView mv = new JModelAndView("admin/blue/operator_notice_detail.html",
				configService.getSysConfig(), 0, request, response);

		OperatorNoticesBO bo = operatorNoticesService.getBoDataById(id);
		mv.addObject("obj", bo);
		return mv;
	}

	@SecurityMapping(title = "服务预审核", value = "/admin/operator_notice_pre_audit.htm*", rtype = "admin", rname = "公告审核", rcode = "admin_group_goods", rgroup = "内容管理")
	@RequestMapping("/admin/operator_notice_pre_audit.htm")
	public ModelAndView operatorNoticeAudit(HttpServletRequest request, HttpServletResponse response,
			String id, String dialogId) {
		ModelAndView mv = new JModelAndView("admin/blue/audit.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("id", id);
		mv.addObject("dialogId", dialogId);

		mv.addObject("sumbmitUrl", "admin/operator_notice_audit.htm");
		return mv;
	}

	/**
	 * 公告审核
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "公告审核", value = "/admin/operator_notice_audit.htm*", rtype = "admin", rname = "内容管理", rcode = "operator_notice_audit", rgroup = "内容管理")
	@RequestMapping("/admin/operator_notice_audit.htm")
	public ModelAndView operatorNoticeAuditDo(HttpServletRequest request, HttpServletResponse response,
			Long id, String status) {

		OperatorNoticesBO bo = operatorNoticesService.getBoById(id);
		ModelAndView mv = null;

		int statusInt = 0;
		if (!StringUtils.isNotEmpty(status) || bo == null) {

			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "参数错误");
		} else {
			statusInt = CommUtil.null2Int(status);
			operatorNoticesService.audit(bo, statusInt);

			mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "公告审核成功");
		}

		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operator_notice_list.htm");
		return mv;
	}
}
