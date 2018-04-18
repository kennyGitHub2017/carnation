package vc.thinker.b2b2c.action.operator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.util.MapperUtils;
import vc.thinker.b2b2c.vo.OperatorExportVO;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.rebate.service.RebateStatisService;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.bo.UserOwnsBO;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.StatisticsService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserOwnService;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.carnation.user.vo.SellerVO;
import com.sinco.carnation.user.vo.UserCustomerVO;
import com.sinco.common.utils.IPUtil;
import com.sinco.dal.common.MyPage;
import com.sinco.office.excel.ExportExcel;

/**
 * 
 * @ClassName: OperatorManageAction
 * @Description: TODO(运营商控制器)
 * @author Tang
 * @date 2015年9月6日 下午5:28:02
 * 
 */
@Controller
public class OperatorManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private Mapper mapper;
	@Autowired
	private UserOwnService userOwnService;
	@Autowired
	private GroupClassService groupClassService;

	@Autowired
	private SellerService sellerService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private StatisticsService statisticsService;

	@Autowired
	private RebateStatisService rebateStatisService;

	/**
	 * 验证码ajax验证方法
	 * 
	 * @param response
	 */
	@RequestMapping("/admin/is_exists_operator_code.htm")
	public void isExistsOperatorCode(HttpServletRequest request, HttpServletResponse response, String code) {
		boolean isExists = false;
		if (StringUtils.isNotBlank(code)) {
			isExists = operatorService.getOperatorBOByOperatorCode(code) == null ? false : true;
		}

		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(isExists);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "运营商冻结", value = "/admin/operator_freeze.htm*", rtype = "admin", rname = "运营商冻结账号", rcode = "operator_freeze", rgroup = "运营商")
	@RequestMapping("/admin/operator_freeze.htm")
	public String user_del(HttpServletRequest request, boolean freezed, String mulitId, String currentPage)
			throws Exception {
		customerService.freezeUsers(mulitId, freezed);
		return "redirect:/admin/operator_list.htm?currentPage=" + currentPage;
	}

	/**
	 * 
	 * @Title: operatorList
	 * @Description: TODO(运营商列表)
	 * @param @param request
	 * @param @param response
	 * @param @param currentPage
	 * @param @param page
	 * @param @param vo
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @author Tang
	 * @throws
	 */
	@SecurityMapping(title = "运营商未审核商户列表", value = "/admin/operator_check_store_list.htm*", rtype = "admin", rname = "运营商未审核商户", rcode = "operator_check_store_list", rgroup = "运营商")
	@RequestMapping("/admin/operator_check_store_list.htm")
	public ModelAndView operatorCheckStoreList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<StoreBO> page, String operatorCode, String operatorName,
			String storeName, String operatorUserName) {
		ModelAndView mv = new JModelAndView("admin/blue/operator_check_store_list.html",
				configService.getSysConfig(), 0, request, response);

		storeService.selectOperatorCheckList(page, operatorCode, operatorName, storeName, operatorUserName);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("operatorCode", operatorCode);
		mv.addObject("operatorName", operatorName);
		mv.addObject("storeName", storeName);
		mv.addObject("operatorUserName", operatorUserName);
		return mv;
	}

	/**
	 * 
	 * @Title: operatorList
	 * @Description: TODO(运营商列表)
	 * @param @param request
	 * @param @param response
	 * @param @param currentPage
	 * @param @param page
	 * @param @param vo
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @author Tang
	 * @throws
	 */
	@SecurityMapping(title = "运营商列表", value = "/admin/operator_list.htm*", rtype = "admin", rname = "运营商管理", rcode = "operator_manage", rgroup = "运营商")
	@RequestMapping("/admin/operator_list.htm")
	public ModelAndView operatorList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<OperatorBO> page, OperatorVO vo, String condition, String value,
			String condition2, String value2) {
		ModelAndView mv = new JModelAndView("admin/blue/operator_list.html", configService.getSysConfig(), 0,
				request, response);
		if (StringUtils.isNotBlank(condition) && StringUtils.isNotBlank(value)) {
			if (condition.equals("1")) {
				vo.setUserName(value);
			}
			if (condition.equals("2")) {
				vo.setOperatorCode(value);
			}
			if (condition.equals("3")) {
				vo.setPhone(value);
			}
		}
		if (StringUtils.isNotBlank(condition2) && StringUtils.isNotBlank(value2)) {
			if (condition2.equals("1")) {
				vo.setRefereeUserName(value2);
			}
			if (condition2.equals("2")) {
				vo.setRefereeOperatorCode(value2);
			}
		}
		operatorService.selectOperatorPageList(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		List<Area> areas = this.areaService.getAllParentIsNull();
		mv.addObject("areas", areas);
		mv.addObject("condition", condition);
		mv.addObject("value", value);
		mv.addObject("condition2", condition2);
		mv.addObject("value2", value2);
		mv.addObject("vo", vo);
		operatorId = null;
		return mv;
	}

	@SecurityMapping(title = "运营商导出", value = "/admin/operator_list_export.htm*", rtype = "admin", rname = "运营商管理", rcode = "operator_export", rgroup = "运营商")
	@RequestMapping("/admin/operator_list_export.htm")
	public String operatorListExport(HttpServletRequest request, HttpServletResponse response, OperatorVO vo) {
		List<OperatorBO> listResult = operatorService.selectOperatorPageList(null, vo);
		// 把返回的list做成导出list
		List<OperatorExportVO> excelList = MapperUtils.map(mapper, listResult, OperatorExportVO.class);
		if (null != listResult) {
			try {
				String title = "运营商列表";
				new ExportExcel(title, OperatorExportVO.class).setDataList(excelList)
						.write(response, title.toString() + ".xlsx").dispose();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return null;
	}

	@SecurityMapping(title = "运营商分配商户列表", value = "/admin/operator_assigned_list.htm*", rtype = "admin", rname = "运营商分配商户管理", rcode = "operator_assigned_list", rgroup = "运营商")
	@RequestMapping("/admin/operator_assigned_list.htm")
	public ModelAndView operatorAssignedList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<StoreBO> page, StoreVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/operator_assigned_list.html",
				configService.getSysConfig(), 0, request, response);
		storeService.selectAllotStoreList(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		List<Area> areas = this.areaService.getAllParentIsNull();
		mv.addObject("areas", areas);
		mv.addObject("vo", vo);

		return mv;
	}

	@SecurityMapping(title = "运营商分配商户", value = "/admin/operator_assigned.htm*", rtype = "admin", rname = "运营商分配商户", rcode = "operator_assigned", rgroup = "运营商")
	@RequestMapping("/admin/operator_assigned.htm")
	public ModelAndView operatorAssigned(HttpServletRequest request, HttpServletResponse response,
			Long sellerId, Long storeId) {
		ModelAndView mv = new JModelAndView("admin/blue/operator_assigned.html",
				configService.getSysConfig(), 0, request, response);
		Integer ownType = 1;
		UserOwnsBO userOwn = userOwnService.findOne(sellerId,ownType);
		StoreBO storeBO = storeService.getObjById(storeId);
		if (userOwn == null || userOwn.getOwnOperatorId() != null || storeBO == null
				|| !storeBO.getCreateUserId().equals(sellerId)) {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("message", "对不起，该商户不允许更改！");
			return mv;
		}
		if (storeBO.getAreaId() != null) {
			List<OperatorBO> list = operatorService.getCheckOkOperatorByOperatorAreaId(String.valueOf(storeBO
					.getAreaId()));
			mv.addObject("operatorList", list);
		}
		mv.addObject("sellerId", sellerId);
		mv.addObject("storeId", storeId);
		return mv;
	}

	@SecurityMapping(title = "运营商分配商户", value = "/admin/operator_assigned_save.htm*", rtype = "admin", rname = "运营商分配商户", rcode = "operator_assigned_save", rgroup = "运营商")
	@RequestMapping("/admin/operator_assigned_save.htm")
	public String operatorAssignedSave(HttpServletRequest request, HttpServletResponse response,
			Long sellerId, String operatorCode) {
		if (sellerId != null && StringUtils.isNotEmpty(operatorCode)) {
			Integer ownType = 1;
			UserOwnsBO userOwn = userOwnService.findOne(sellerId,ownType);
			if (userOwn != null && userOwn.getOwnOperatorId() == null) {
				try {
					StoreBO store = storeService.queryStoreInfo(sellerId,true,null);
					userOwnService.updateUserOwns(sellerId, operatorCode, store.getAreaId(),ownType);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
		}

		return "redirect:/admin/operator_assigned_list.htm";
	}

	/**
	 * 
	 * @Title: operatorAdd
	 * @Description: TODO(运营商添加)
	 * @param @param request
	 * @param @param response
	 * @param @param currentPage
	 * @param @return 设定文件
	 * @return ModelAndView 返回类型
	 * @author Tang
	 * @throws
	 */
	@SecurityMapping(title = "运营商添加", value = "/admin/operator_add.htm*", rtype = "admin", rname = "运营商添加", rcode = "operator_add", rgroup = "运营商")
	@RequestMapping("/admin/operator_add.htm")
	public ModelAndView operatorAdd(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/operator_add.html", configService.getSysConfig(), 0,
				request, response);
		// 查询地址信息，前端需要商家选择发货地址
		List<Area> areas = this.areaService.getAllParentIsNull();
		mv.addObject("areas", areas);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "运营商编辑", value = "/admin/operator_edit.htm*", rtype = "admin", rname = "运营商编辑", rcode = "operator_check_form", rgroup = "运营商")
	@RequestMapping("/admin/operator_edit.htm")
	public ModelAndView operatorCheckForm(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/operator_add.html", configService.getSysConfig(), 0,
				request, response);
		OperatorBO operatorBO = operatorService.get(id);
		if (operatorBO == null) {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("message", "对不起，无法找到审核中的运营商！");
			return mv;
		}
		mv.addObject("obj", operatorBO);
		mv.addObject("edit", true);
		List<Area> areas = this.areaService.getAllParentIsNull();
		mv.addObject("areas", areas);
		return mv;
	}

	@SecurityMapping(title = "运营商查看", value = "/admin/operator_view.htm*", rtype = "admin", rname = "运营商查看", rcode = "operator_check_form", rgroup = "运营商")
	@RequestMapping("/admin/operator_view.htm")
	public ModelAndView operatorView(HttpServletRequest request, HttpServletResponse response, Long id,
			Boolean isForMerchant) {
		ModelAndView mv = null;
		List<UserOwnsBO> userOwnslist = null;
		OperatorBO operatorBO = operatorService.get(id);
		if (operatorBO == null) {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("message", "对不起，无法找到运营商！");
			return mv;
		} else {
			if (isForMerchant != null && isForMerchant == true) {
				mv = new JModelAndView("admin/blue/operator_view_for_merchant.html",
						configService.getSysConfig(), 0, request, response);
				userOwnslist = this.userOwnService.findAllSellerByOperId(id);
			} else {
				mv = new JModelAndView("admin/blue/operator_view.html", configService.getSysConfig(), 0,
						request, response);
			}
		}
		mv.addObject("obj", operatorBO);
		mv.addObject("userOwnslist", userOwnslist);
		List<Area> areas = this.areaService.getAllParentIsNull();
		mv.addObject("areas", areas);
		return mv;
	}

	@SecurityMapping(title = "运营商审核", value = "/admin/operator_check.htm*", rtype = "admin", rname = "运营商审核（审核）", rcode = "operator_check_permiter", rgroup = "运营商")
	@RequestMapping("/admin/operator_check.htm")
	public String operatorCheck(HttpServletRequest request, HttpServletResponse response, Long id) {
		if (id != null) {
			OperatorBO operatorBO = operatorService.getOperatorBOByIdAndStatus(id,
					UserContants.OPERATOR_CHECK_STATUS_CHECKING);
			operatorService.checkOperator(operatorBO,
					CommUtil.null2String(SecurityUserHolder.getCurrentUserId()));
		}
		return "redirect:/admin/operator_list.htm";
	}

	/*
	 * 所属商户
	 */
	@SecurityMapping(title = "所属商户", value = "/admin/operator_own_shop.htm*", rtype = "admin", rname = "所属商户", rcode = "operator_own_shop", rgroup = "运营商")
	@RequestMapping("/admin/operator_own_shop.htm")
	public ModelAndView operatorOwnShop(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<SellerBO> page, SellerVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/operator_own_shop.html",
				configService.getSysConfig(), 0, request, response);

		OperatorBO operatorBO = operatorService.get(vo.getOperatorId());
		if (operatorBO == null) {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("message", "对不起，无法找到所属商户的运营商！");
			return mv;
		}
		vo.setUserLevel(operatorBO.getLevel());
		vo.setOperatorId(operatorBO.getId());
		vo.setOperatorUserId(operatorBO.getUserId());
		vo.setOperatorAreaId(operatorBO.getOperatorAreaId());

		sellerService.selectOperatorSellerSimplePageList(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		List<GroupClassBO> gcList = groupClassService.findAllParents();
		mv.addObject("gcList", gcList);
		mv.addObject("vo", vo);
		return mv;
	}

	/*
	 * 所属会员
	 */
	@SecurityMapping(title = "所属会员", value = "/admin/operator_own_shopMember.htm*", rtype = "admin", rname = "所属会员", rcode = "operator_own_shopMember", rgroup = "运营商")
	@RequestMapping("/admin/operator_own_shopMember.htm")
	public ModelAndView operator_own_shopMember(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<UserCustomerBO> page, UserCustomerVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/operator_own_shopMember.html",
				configService.getSysConfig(), 0, request, response);
		OperatorBO operatorBO = operatorService.get(vo.getOperatorId());
		if (operatorBO == null) {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("message", "对不起，无法找到所属会员的运营商！");
			return mv;
		}
		vo.setUserLevel(operatorBO.getLevel());
		vo.setOperatorId(operatorBO.getId());
		vo.setOperatorUserId(operatorBO.getUserId());
		vo.setOperatorAreaId(operatorBO.getOperatorAreaId());

		customerService.selectOwnCustomerByOperatorUserId(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		mv.addObject("vo", vo);
		return mv;
	}

	@RequestMapping("/admin/verify_operator_area.htm")
	public void verifyOperatorArea(HttpServletRequest request, HttpServletResponse response,
			String operatorAreaId, Integer level) {
		boolean ret = true;
		if (StringUtils.isNotEmpty(operatorAreaId)) {
			// List<OperatorBO> list = operatorService.getOperatorBOByOperatorAreaId(operatorAreaId);
			List<OperatorBO> list = this.operatorService.getLevelAndArea(operatorAreaId, level);
			if (CollectionUtils.isNotEmpty(list)) {
				ret = false;
				/*	for (OperatorBO operatorBO : list) 
					{
						if (level.equals(operatorBO.getLevel()))
						{
							ret = false;//存在 不等于3,的会进来
							break;
						}
					}*/
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

	@SecurityMapping(title = "运营商保存", value = "/admin/operator_save.htm*", rtype = "admin", rname = "运营商信息保存", rcode = "operator_save", rgroup = "运营商")
	@RequestMapping("/admin/operator_save.htm")
	public ModelAndView operatorSave(HttpServletRequest request, HttpServletResponse response,
			String list_url, String add_url, OperatorBO operatorBO) {
		String requestIp = IPUtil.getIpAddr(request);
		String url = "admin/blue/success.html";
		String opTitle = "保存运营商成功！";
		Long userId = SecurityUserHolder.getCurrentUserId();
		String result = operatorService.saveOperator(request, requestIp, CommUtil.null2String(userId),
				operatorBO);
		if (result.equals("1")) {
			url = "admin/blue/error.html";
			opTitle = "保存运营商失败; 邀请码不存在！";
		} else if (result.equals("2")) {
			url = "admin/blue/error.html";
			opTitle = "保存运营商失败; 该地区，该级别运营商已经存在！";
		}
		ModelAndView mv = new JModelAndView(url, configService.getSysConfig(), 0, request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", opTitle);
		if (add_url != null) {
			mv.addObject("add_url", add_url);
		}
		return mv;
	}

	@SecurityMapping(title = "运营商关系统计", value = "/admin/operator_state_relation.htm*", rtype = "admin", rname = "运营商关系统计", rcode = "operator_state_relation", rgroup = "运营商")
	@RequestMapping("/admin/operator_state_relation.htm")
	public ModelAndView operatorStateRelation(HttpServletRequest request, HttpServletResponse response,
			Long id) {
		OperatorBO operator = operatorService.get(id);
		String url = "admin/blue/operator_state_relation.html";
		String opTitle = "";
		if (operator == null) {
			url = "admin/blue/error.html";
			opTitle = "运营商不存在！";
		}
		ModelAndView mv = new JModelAndView(url, configService.getSysConfig(), 0, request, response);
		Map<String, Object> mapResult = statisticsService.getOperatorRelationStatistics(operator, null);
		mv.addObject("op_title", opTitle);
		mv.addObject("resultMap", mapResult);
		return mv;
	}

	@SecurityMapping(title = "运营商收益统计", value = "/admin/operator_state_rebate.htm*", rtype = "admin", rname = "运营商收益统计", rcode = "operator_state_rebate", rgroup = "运营商")
	@RequestMapping("/admin/operator_state_rebate.htm")
	public ModelAndView operatorStateRebate(HttpServletRequest request, HttpServletResponse response,
			Long id, String queryType, String startTime, String endTime) {
		OperatorBO operator = operatorService.get(id);
		String url = "admin/blue/operator_state_rebate.html";
		ModelAndView mv = new JModelAndView(url, configService.getSysConfig(), 0, request, response);
		String opTitle = "";
		if (operator == null) {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			opTitle = "运营商不存在！";
			mv.addObject("op_title", opTitle);
			return mv;
		}
		if (StringUtils.isEmpty(queryType)) {
			queryType = "0";
		}
		Map<String, Object> mapResult = statisticsService.getOperatorRebateStatistics(operator, startTime,
				endTime, queryType);
		mv.addObject("op_title", opTitle);
		mv.addObject("resultMap", mapResult);
		mv.addObject("queryType", queryType);
		mv.addObject("startTime", startTime);
		mv.addObject("endTime", endTime);
		mv.addObject("id", id);
		return mv;
	}

	/*
	 * 注册会员
	 */
	@SecurityMapping(title = "注册会员", value = "/admin/register_user_list.htm*", rtype = "admin", rname = "注册会员", rcode = "register_user_list", rgroup = "运营商")
	@RequestMapping("/admin/register_user_list.htm")
	public ModelAndView registerUserList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<UserCustomerBO> page, UserCustomerVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/register_user_list.html",
				configService.getSysConfig(), 0, request, response);
		OperatorBO operatorBO = operatorService.get(vo.getOperatorId());
		if (operatorBO == null) {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("message", "对不起，无法找到注册会员的运营商！");
			return mv;
		}
		vo.setOperatorUserId(operatorBO.getUserId());
		vo.setOperatorAreaId(operatorBO.getOperatorAreaId());
		customerService.selectUserCustomerByOperatorUserId(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		List<GroupClassBO> gcList = groupClassService.findAllParents();
		mv.addObject("gcList", gcList);
		mv.addObject("vo", vo);
		return mv;
	}

	/*
	 * 注册商户
	 */
	@SecurityMapping(title = "注册商户", value = "/admin/register_shop_list.htm*", rtype = "admin", rname = "注册商户", rcode = "register_shop_list", rgroup = "运营商")
	@RequestMapping("/admin/register_shop_list.htm")
	public ModelAndView registerShopList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<SellerBO> page, SellerVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/register_shop_list.html",
				configService.getSysConfig(), 0, request, response);
		OperatorBO operatorBO = operatorService.get(vo.getOperatorId());
		if (operatorBO == null) {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("message", "对不起，无法找到所属商户的运营商！");
			return mv;
		}
		vo.setUserLevel(operatorBO.getLevel());
		vo.setOperatorId(operatorBO.getId());
		vo.setOperatorUserId(operatorBO.getUserId());
		vo.setOperatorAreaId(operatorBO.getOperatorAreaId());

		sellerService.selectOperatorRegisterSellerPageList(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		List<GroupClassBO> gcList = groupClassService.findAllParents();
		mv.addObject("gcList", gcList);
		mv.addObject("vo", vo);
		return mv;
	}

	Long operatorId = null;

	@SecurityMapping(title = "辖区运营商", value = "/admin/area_operator_list.htm*", rtype = "admin", rname = "辖区运营商", rcode = "area_operator_list", rgroup = "运营商")
	@RequestMapping("/admin/area_operator_list.htm")
	public ModelAndView areaOperatorList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<OperatorBO> page, OperatorVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/area_operator_list.html",
				configService.getSysConfig(), 0, request, response);
		if (operatorId == null) {
			operatorId = vo.getId();
		}
		OperatorBO operatorBO = operatorService.get(operatorId);
		if (operatorBO == null) {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("message", "对不起，无法找到辖区运营商的运营商！");
			return mv;
		}
		vo.setUserId(operatorBO.getUserId());
		vo.setUserLevel(operatorBO.getLevel());
		vo.setId(operatorBO.getId());
		vo.setOperatorAreaId(operatorBO.getOperatorAreaId());
		operatorService.selectOwnOperatorPageList(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		List<GroupClassBO> gcList = groupClassService.findAllParents();
		mv.addObject("gcList", gcList);
		mv.addObject("vo", vo);
		return mv;
	}

	@SecurityMapping(title = "注册运营商", value = "/admin/register_operator_list.htm*", rtype = "admin", rname = "注册运营商", rcode = "register_operator_list", rgroup = "运营商")
	@RequestMapping("/admin/register_operator_list.htm")
	public ModelAndView operatorRegisterOpertor(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<OperatorBO> page, OperatorVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/register_operator_list.html",
				configService.getSysConfig(), 0, request, response);
		if (operatorId == null) {
			operatorId = vo.getId();
		}
		OperatorBO operatorBO = operatorService.get(operatorId);
		if (operatorBO == null) {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("message", "对不起，无法找到注册运营商的运营商！");
			return mv;
		}
		vo.setUserId(operatorBO.getUserId());
		vo.setUserLevel(operatorBO.getLevel());
		vo.setId(operatorBO.getId());
		page.setPageSize(20);
		operatorService.selectRegisterOperatorPageList(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		List<GroupClassBO> gcList = groupClassService.findAllParents();
		mv.addObject("gcList", gcList);
		mv.addObject("vo", vo);
		return mv;
	}

	@SecurityMapping(title = "注册运营商", value = "/admin/rebateStatisService.htm*", rtype = "admin", rname = "运营商分润统计", rcode = "register_operator_list", rgroup = "运营商")
	@RequestMapping("/admin/rebateStatisService.htm")
	public ModelAndView statiservice(HttpServletRequest request, HttpServletResponse response, String bg,
			String ed) {

		ModelAndView mv = new JModelAndView("500.html", configService.getSysConfig(), 1, request, response);
//		bg 2010-01-01  ed 2010-01-01
		rebateStatisService.sratisticRebateByStartAndEndTime(bg, ed);

		return mv;
	}
}
