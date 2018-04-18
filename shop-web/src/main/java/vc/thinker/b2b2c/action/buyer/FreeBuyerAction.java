package vc.thinker.b2b2c.action.buyer;

import org.springframework.stereotype.Controller;

/**
 * 
 * <p>
 * Title: FreeBuyerAction.java
 * </p>
 * 
 * <p>
 * Description: 用户中心0元试用中心
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
 * @date 2014-11-18
 * 
 * @version 1.0.1
 */
@Controller
public class FreeBuyerAction {
//	@Autowired
//	private ISysConfigService configService;
//	@Autowired
//	private IUserConfigService userConfigService;
//	@Autowired
//	private IFreeGoodsService freegoodsService;
//	@Autowired
//	private IFreeClassService freeClassService;
//	@Autowired
//	private IGoodsService goodsService;
//	@Autowired
//	private IGoodsClassService goodsClassService;
//	@Autowired
//	private IAccessoryService accessoryService;
//	@Autowired
//	private FreeTools freeTools;
//	@Autowired
//	private IFreeApplyLogService freeapplylogService;
//	@Autowired
//	private IExpressCompanyService expressCompayService;
//	@Autowired
//	private IShipAddressService shipAddressService;
//	@Autowired
//	private IAreaService areaService;
//	@Autowired
//	private ShipTools shipTools;
//
//	@SecurityMapping(title = "买家中心", value = "/buyer/freeapply_logs.htm*", rtype = "buyer", rname = "买家中心", rcode = "user_center", rgroup = "用户中心")
//	@RequestMapping("/buyer/freeapply_logs.htm")
//	public ModelAndView freeapply_logs(HttpServletRequest request,
//			HttpServletResponse response, String currentPage, String orderBy,
//			String orderType, String status) {
//		ModelAndView mv = new JModelAndView(
//				"user/default/usercenter/freeapplylog_list.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		FreeApplyLogQueryObject qo = new FreeApplyLogQueryObject(currentPage,
//				mv, orderBy, orderType);
//		qo.addQuery(
//				"obj.user_id",
//				new SysMap("user_id", CommUtil.null2Long(SecurityUserHolder
//						.getCurrentUser().getId())), "=");
//		if (status != null && status.equals("yes")) {
//			qo.addQuery("obj.apply_status", new SysMap("apply_status", 5), "=");
//			mv.addObject("status", status);
//		}
//		if (status != null && status.equals("waiting")) {
//			qo.addQuery("obj.apply_status", new SysMap("apply_status", 0), "=");
//			mv.addObject("status", status);
//		}
//		if (status != null && status.equals("no")) {
//			qo.addQuery("obj.apply_status", new SysMap("apply_status", -5), "=");
//			mv.addObject("status", status);
//		}
//		WebForm wf = new WebForm();
//		wf.toQueryPo(request, qo, FreeApplyLog.class, mv);
//		IPageList pList = this.freeapplylogService.list(qo);
//		CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
//		return mv;
//	}
//
//	@SecurityMapping(title = "买家中心", value = "/buyer/freeapply_log_info.htm*", rtype = "buyer", rname = "买家中心", rcode = "user_center", rgroup = "用户中心")
//	@RequestMapping("/buyer/freeapply_log_info.htm")
//	public ModelAndView freeapply_log_info(HttpServletRequest request,
//			HttpServletResponse response, String id) {
//		ModelAndView mv = new JModelAndView(
//				"user/default/usercenter/freeapplylog_info.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		User user = SecurityUserHolder.getCurrentUser();
//		FreeApplyLog fal = this.freeapplylogService.getObjById(CommUtil
//				.null2Long(id));
//		if (fal != null && fal.getUser_id().equals(user.getId())) {
//			mv.addObject("obj", fal);
//			mv.addObject("shipTools", shipTools);
//		} else {
//			mv = new JModelAndView("error.html", configService.getSysConfig(),
//					this.userConfigService.getUserConfig(), 1, request,
//					response);
//			mv.addObject("op_title", "此0元试用申请无效");
//			mv.addObject("url", CommUtil.getURL(request)
//					+ "/buyer/freeapply_logs.htm");
//		}
//		return mv;
//	}
//
//	@SecurityMapping(title = "买家中心", value = "/buyer/freeapply_log_info.htm*", rtype = "buyer", rname = "买家中心", rcode = "user_center", rgroup = "用户中心")
//	@RequestMapping("/buyer/freeapplylog_save.htm")
//	public void freeapplylog_save(HttpServletRequest request,
//			HttpServletResponse response, String id, String use_experience) {
//		User user = SecurityUserHolder.getCurrentUser();
//		FreeApplyLog fal = this.freeapplylogService.getObjById(CommUtil
//				.null2Long(id));
//		if (fal.getUser_id().equals(user.getId())) {
//			fal.setUse_experience(use_experience);
//			fal.setEvaluate_time(new Date());
//			fal.setEvaluate_status(1);
//			this.freeapplylogService.save(fal);
//		}
//	}
}
