package vc.thinker.b2b2c.action.check;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.check.service.CheckClassService;
import com.sinco.carnation.check.service.CheckGroupService;
import com.sinco.carnation.check.service.CheckResultService;
import com.sinco.carnation.sns.bo.CheckResultGroupBO;
import com.sinco.carnation.sns.bo.CheckResultItemBO;
import com.sinco.carnation.sns.bo.CheckResultReplyBO;
import com.sinco.carnation.sns.model.CheckResultGroup;
import com.sinco.carnation.sns.model.CheckResultItem;
import com.sinco.carnation.sns.model.CheckResultReply;
import com.sinco.carnation.sns.vo.CheckResultGroupVO;
import com.sinco.carnation.sns.vo.CheckResultItemVO;
import com.sinco.carnation.sns.vo.CheckResultReplyVO;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: CircleManageAction.java
 * </p>
 * 
 * <p>
 * Description: 自测题管理，
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
 * @date 2014-11-20
 * 
 * @version 1.0.1
 */
@Controller
public class CheckResultAction {
	@Autowired
	CheckResultService checkResultService;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserService userService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private CheckClassService checkClassService;
	@Autowired
	private CheckGroupService checkGroupService;
	@Autowired
	private WeedFSClient fsClient;

	/**
	 * 体检报告列表
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequestMapping("/admin/reportList.htm")
	@SecurityMapping(title = "体检报告列表", value = "/admin/reportList.htm*", rtype = "admin", rname = "体检报告", rcode = "check_report_admin", rgroup = "内容管理")
	public ModelAndView reportList(HttpServletRequest request, HttpServletResponse response,
			CheckResultReplyVO vo, MyPage<CheckResultReplyBO> page) {
		ModelAndView mv = null;
		if (vo.getUserId() != null && vo.getUserId() != 0)
			mv = new JModelAndView("admin/blue/reportList_self.html", configService.getSysConfig(), 0,
					request, response);
		else if (vo.getStatus() != null && vo.getStatus() == 2)
			mv = new JModelAndView("admin/blue/reportList.html", configService.getSysConfig(), 0, request,
					response);
		else
			mv = new JModelAndView("admin/blue/repor_processed_List.html", configService.getSysConfig(), 0,
					request, response);
		checkResultService.search(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("pages", page.getContent());
		mv.addObject("vo", vo);

		return mv;
	}

	/**
	 * 体检报告详情
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/reportDetailed.htm")
	@SecurityMapping(title = "体检报告详情", value = "/admin/reportDetailed.htm*", rtype = "admin", rname = "体检报告", rcode = "check_report_admin", rgroup = "内容管理")
	public ModelAndView reportDetailed(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/reportDetailed.html", configService.getSysConfig(),
				0, request, response);
		mv.addObject("obj", checkResultService.detailed(id));

		return mv;
	}

	/**
	 * 处理报告结果
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/saveReportResultView.htm")
	@SecurityMapping(title = "处理报告结果", value = "/admin/saveReportResultView.htm*", rtype = "admin", rname = "体检报告", rcode = "check_report_admin", rgroup = "内容管理")
	public ModelAndView saveReportResultView(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/saveReportResultView.html",
				configService.getSysConfig(), 0, request, response);
		CheckResultReplyBO obj = checkResultService.get(id);
		mv.addObject("obj", obj);

		return mv;
	}

	/**
	 * 处理体检报告
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param result
	 * @param page
	 * @return
	 */
	@RequestMapping("/admin/saveCheckResult.htm")
	@SecurityMapping(title = "处理体检报告", value = "/admin/saveCheckResult.htm*", rtype = "admin", rname = "体检报告", rcode = "check_report_admin", rgroup = "内容管理")
	public String saveCheckResult(HttpServletRequest request, HttpServletResponse response,
			CheckResultReplyVO vo, CheckResultReply result, MyPage<CheckResultReplyBO> page) {
		checkResultService.update(result);

		return "redirect:/admin/reportList.htm?status=2";
	}

	/**
	 * 分类列表
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequestMapping("/admin/reportGroupList.htm")
	@SecurityMapping(title = "分类列表", value = "/admin/reportGroupList.htm*", rtype = "admin", rname = "体检报告", rcode = "check_report_admin", rgroup = "内容管理")
	public ModelAndView reportGroupList(HttpServletRequest request, HttpServletResponse response,
			CheckResultGroupVO vo, MyPage<CheckResultGroupBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/reportGroupList.html", configService.getSysConfig(),
				0, request, response);
		checkResultService.searchCheckResultGroupBO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("pages", page.getContent());
		mv.addObject("vo", vo);

		return mv;
	}

	/**
	 * 添加或修改分类界面
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/reportGroupAddView.htm")
	@SecurityMapping(title = "添加或修改分类界面", value = "/admin/reportGroupAddView.htm*", rtype = "admin", rname = "体检报告", rcode = "check_report_admin", rgroup = "内容管理")
	public ModelAndView reportGroupAddView(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/reportGroupAddView.html",
				configService.getSysConfig(), 0, request, response);
		CheckResultGroupBO obj = checkResultService.findCheckResultGroupBO(id);
		mv.addObject("obj", obj);

		return mv;
	}

	/**
	 * 添加或修改分类
	 * 
	 * @param request
	 * @param response
	 * @param crg
	 * @return
	 */
	@RequestMapping("/admin/saveReportGroup.htm")
	@SecurityMapping(title = "添加或修改分类", value = "/admin/saveReportGroup.htm*", rtype = "admin", rname = "体检报告", rcode = "check_report_admin", rgroup = "内容管理")
	public String saveReportGroup(HttpServletRequest request, HttpServletResponse response,
			CheckResultGroup crg) {
		if (crg != null && crg.getId() != null)
			checkResultService.updateCheckResultGroup(crg);
		else
			checkResultService.saveCheckResultGroup(crg);

		return "redirect:/admin/reportGroupList.htm";
	}

	/**
	 * 删除分类
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/deleteReportGroup.htm")
	@SecurityMapping(title = "删除分类", value = "/admin/deleteReportGroup.htm*", rtype = "admin", rname = "体检报告", rcode = "check_report_admin", rgroup = "内容管理")
	public String deleteReportGroup(HttpServletRequest request, HttpServletResponse response, Long id) {
		checkResultService.deleteCheckResultGroup(id);

		return "redirect:/admin/reportGroupList.htm";
	}

	/**
	 * 体检项列表
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequestMapping("/admin/checkResultItemList.htm")
	@SecurityMapping(title = "体检项列表", value = "/admin/checkResultItemList.htm*", rtype = "admin", rname = "体检报告", rcode = "check_report_admin", rgroup = "内容管理")
	public ModelAndView checkResultItemList(HttpServletRequest request, HttpServletResponse response,
			CheckResultItemVO vo, MyPage<CheckResultItemBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/checkResultItemList.html",
				configService.getSysConfig(), 0, request, response);
		checkResultService.searchCheckResultItemBO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("pages", page.getContent());
		mv.addObject("vo", vo);

		CheckResultGroupVO crgvo = new CheckResultGroupVO();
		MyPage<CheckResultGroupBO> pageCrgvo = new MyPage<CheckResultGroupBO>();
		pageCrgvo.setPageSize(100);
		checkResultService.searchCheckResultGroupBO(crgvo, pageCrgvo);
		mv.addObject("groupList", pageCrgvo.getContent());

		return mv;
	}

	/**
	 * 添加或修改体检项界面
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/reportGroupItemAddView.htm")
	@SecurityMapping(title = "添加或修改体检项界面", value = "/admin/reportGroupItemAddView.htm*", rtype = "admin", rname = "体检报告", rcode = "check_report_admin", rgroup = "内容管理")
	public ModelAndView reportGroupItemAddView(HttpServletRequest request, HttpServletResponse response,
			Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/reportGroupItemAddView.html",
				configService.getSysConfig(), 0, request, response);
		CheckResultItemBO obj = checkResultService.loadCheckResultItemBO(id);
		mv.addObject("obj", obj);

		CheckResultGroupVO crgvo = new CheckResultGroupVO();
		MyPage<CheckResultGroupBO> pageCrgvo = new MyPage<CheckResultGroupBO>();
		pageCrgvo.setPageSize(100);
		checkResultService.searchCheckResultGroupBO(crgvo, pageCrgvo);
		mv.addObject("groupList", pageCrgvo.getContent());

		return mv;
	}

	/**
	 * 添加或修改体检项
	 * 
	 * @param request
	 * @param response
	 * @param crg
	 * @return
	 */
	@RequestMapping("/admin/saveReportItem.htm")
	@SecurityMapping(title = "添加或修改体检项", value = "/admin/saveReportItem.htm*", rtype = "admin", rname = "体检报告", rcode = "check_report_admin", rgroup = "内容管理")
	public String saveReportItem(HttpServletRequest request, HttpServletResponse response, CheckResultItem cri) {
		if (cri != null && cri.getId() != null)
			checkResultService.updateCheckResultItem(cri);
		else
			checkResultService.saveCheckResultItem(cri);

		return "redirect:/admin/checkResultItemList.htm";
	}

	/**
	 * 删除体检项
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/deleteReportItem.htm")
	@SecurityMapping(title = "删除体检项", value = "/admin/deleteReportItem.htm*", rtype = "admin", rname = "体检报告", rcode = "check_report_admin", rgroup = "内容管理")
	public String deleteReportItem(HttpServletRequest request, HttpServletResponse response, Long id) {
		checkResultService.deleteCheckResultItem(id);

		return "redirect:/admin/checkResultItemList.htm";
	}
}
