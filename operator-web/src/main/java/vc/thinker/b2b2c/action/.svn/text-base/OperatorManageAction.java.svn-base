package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.security.support.OperatorUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.IpAddressByDetails;
import vc.thinker.b2b2c.exportvo.AreaOperatorVO;
import vc.thinker.b2b2c.exportvo.AreaSellerVO;
import vc.thinker.b2b2c.exportvo.RegisterOperatorVO;
import vc.thinker.b2b2c.exportvo.RegisterSellerVO;
import vc.thinker.b2b2c.utils.MapperUtils;

import com.alibaba.fastjson.JSONObject;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupGoodsVO;
import com.sinco.carnation.o2o.vo.GroupOrderVO;
import com.sinco.carnation.rebate.service.RebateStatisService;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.bo.orcl.CnUserLevelBO;
import com.sinco.carnation.sys.contants.OperatorContants;
import com.sinco.carnation.sys.contants.OrclUserContants;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SnsActivityService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.model.Operator;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.OrclUserBaseService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.StatisticsService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.carnation.user.vo.SellerVO;
import com.sinco.carnation.user.vo.UserCustomerVO;
import com.sinco.common.utils.IPUtil;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicBase;
import com.sinco.office.excel.ExportExcel;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * 
 * @ClassName: OperatorManageAction
 * @Description: TODO(运营商管理控制器)
 * @author Tang
 * @date 2015年9月6日 下午3:06:17
 * 
 */
@Controller
public class OperatorManageAction {
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private GroupClassService groupClassService;
	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private Mapper mapper;
	@Autowired
	private GroupGoodsService groupGoodsService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StatisticsService statisticsService;
	@Autowired
	private RebateStatisService rebateStatisService;
	@Autowired
	private SnsActivityService snsActivityService;
	@Autowired
	private DicContent dicContant;

	@Autowired
	private OrclUserBaseService orclUserBaseService;

	@Autowired
	private AreaServiceImpl areaService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@SecurityMapping(title = "注册运营商列表", value = "/operator/register_operator_list.htm*", rtype = "operator", rname = "注册运营商列表", rcode = "register_operator_list", rgroup = "运营商管理")
	@RequestMapping("/operator/register_operator_list.htm")
	public String operatorRegisterOpertor(Model model, MyPage<OperatorBO> page, OperatorVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setUserId(user.getOperatorBO().getUserId());
		vo.setUserLevel(user.getOperatorBO().getLevel());
		vo.setId(user.getOperatorBO().getId());
		page.setPageSize(20);
		operatorService.selectRegisterOperatorPageList(page, vo);
		List<OperatorBO> operatorList = page.getContent();
		for (OperatorBO oper : operatorList) {
			long uid = oper.getUserId();
			Map<String, Object> resultMap = this.rebateStatisService.getUserRebateStatis(uid, null, null,
					"0", "1");
			double b2cRebateAmount = CommUtil.null2Double(resultMap.get("sum"));
			oper.setB2cRebateAmount(new BigDecimal(b2cRebateAmount));
			resultMap = new HashMap<>();
			resultMap = this.rebateStatisService.getUserRebateStatis(uid, null, null, "0", "0");
			double o2oRebateAmount = CommUtil.null2Double(resultMap.get("sum"));
			oper.setO2oRebateAmount(new BigDecimal(o2oRebateAmount));
			oper.setRebateAmount(new BigDecimal(o2oRebateAmount).add(new BigDecimal(b2cRebateAmount)));
		}
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		return "register_operator_list.html";
	}

	@SecurityMapping(title = "辖区运营商列表", value = "/operator/area_operator_list.htm*", rtype = "operator", rname = "辖区运营商列表", rcode = "area_operator_list", rgroup = "运营商管理")
	@RequestMapping("/operator/area_operator_list.htm")
	public String areaOperatorList(Model model, MyPage<OperatorBO> page, OperatorVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setUserId(user.getOperatorBO().getUserId());
		vo.setUserLevel(user.getOperatorBO().getLevel());
		vo.setId(user.getOperatorBO().getId());
		vo.setOperatorAreaId(user.getOperatorBO().getOperatorAreaId());
		page.setPageSize(20);
		operatorService.selectOwnOperatorPageList(page, vo);
		List<OperatorBO> operatorList = page.getContent();
		for (OperatorBO oper : operatorList) {
			long uid = oper.getUserId();
			Map<String, Object> resultMap = this.rebateStatisService.getUserRebateStatis(uid, null, null,
					"0", "1");
			double b2cRebateAmount = CommUtil.null2Double(resultMap.get("sum"));
			oper.setB2cRebateAmount(new BigDecimal(b2cRebateAmount));
			resultMap = new HashMap<>();
			resultMap = this.rebateStatisService.getUserRebateStatis(uid, null, null, "0", "0");
			double o2oRebateAmount = CommUtil.null2Double(resultMap.get("sum"));
			oper.setO2oRebateAmount(new BigDecimal(o2oRebateAmount));
			oper.setRebateAmount(new BigDecimal(o2oRebateAmount).add(new BigDecimal(b2cRebateAmount)));
		}
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		return "area_operator_list.html";
	}

	@SecurityMapping(title = "注册运营商导出", value = "/operator/register_operator_export.htm*", rtype = "operator", rname = "注册运营商导出", rcode = "register_operator_export", rgroup = "运营商管理")
	@RequestMapping("/operator/register_operator_export.htm")
	public String registerOperatorExport(HttpServletResponse response, OperatorVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setUserId(user.getOperatorBO().getUserId());
		vo.setUserLevel(user.getOperatorBO().getLevel());
		vo.setId(user.getOperatorBO().getId());
		List<OperatorBO> listResult = operatorService.selectRegisterOperatorPageList(null, vo);
		exportResult(response, RegisterOperatorVO.class, listResult, "注册运营商");
		return null;
	}

	@SecurityMapping(title = "辖区运营商导出", value = "/operator/area_operator_export.htm*", rtype = "operator", rname = "辖区运营商导出", rcode = "area_operator_export", rgroup = "运营商管理")
	@RequestMapping("/operator/area_operator_export.htm")
	public String areaOperatorExport(HttpServletResponse response, OperatorVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setUserId(user.getOperatorBO().getUserId());
		vo.setUserLevel(user.getOperatorBO().getLevel());
		vo.setId(user.getOperatorBO().getId());
		vo.setOperatorAreaId(user.getOperatorBO().getOperatorAreaId());
		List<OperatorBO> listResult = operatorService.selectOwnOperatorPageList(null, vo);
		exportResult(response, AreaOperatorVO.class, listResult, "辖区运营商");
		return null;
	}

	@SecurityMapping(title = "注册商户列表", value = "/operator/register_shop_list.htm*", rtype = "operator", rname = "注册商户列表", rcode = "register_shop_list", rgroup = "运营商管理")
	@RequestMapping("/operator/register_shop_list.htm")
	public String registerShopList(Model model, MyPage<SellerBO> page, SellerVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setUserLevel(user.getOperatorBO().getLevel());
		vo.setOperatorId(user.getOperatorBO().getId());
		vo.setOperatorUserId(user.getOperatorBO().getUserId());
		vo.setOperatorAreaId(user.getOperatorBO().getOperatorAreaId());
		page.setPageSize(20);
		sellerService.selectOperatorRegisterSellerPageList(page, vo);
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		model.addAttribute("shopPath", configService.getSysConfig().getAddress());
		return "register_shop_list.html";
	}

	@SecurityMapping(title = "所属商户列表", value = "/operator/area_shop_list.htm*", rtype = "operator", rname = "所属商户列表", rcode = "area_shop_list", rgroup = "运营商管理")
	@RequestMapping("/operator/area_shop_list.htm")
	public String areaShopList(Model model, MyPage<SellerBO> page, SellerVO vo) {
		List<GroupClassBO> gcList = groupClassService.findAllParents();
		model.addAttribute("gcList", gcList);
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setUserLevel(user.getOperatorBO().getLevel());
		vo.setOperatorId(user.getOperatorBO().getId());
		vo.setOperatorUserId(user.getOperatorBO().getUserId());
		vo.setOperatorAreaId(user.getOperatorBO().getOperatorAreaId());
		page.setPageSize(20);
		sellerService.selectOperatorSellerPageList(page, vo);
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		model.addAttribute("op", userDetails.getOperatorBO());
		model.addAttribute("shopPath", configService.getSysConfig().getAddress());
		return "area_shop_list.html";
	}

	@SecurityMapping(title = "注册商户导出", value = "/operator/register_shop_export.htm*", rtype = "operator", rname = "注册商户导出", rcode = "register_shop_export", rgroup = "运营商管理")
	@RequestMapping("/operator/register_shop_export.htm")
	public String registerShopExport(HttpServletResponse response, SellerVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setUserLevel(user.getOperatorBO().getLevel());
		vo.setOperatorId(user.getOperatorBO().getId());
		vo.setOperatorUserId(user.getOperatorBO().getUserId());
		vo.setOperatorAreaId(user.getOperatorBO().getOperatorAreaId());
		List<SellerBO> listResult = sellerService.selectOperatorRegisterSellerPageList(null, vo);
		exportResult(response, RegisterSellerVO.class, listResult, "注册商户");
		return null;
	}

	@SecurityMapping(title = "所属商户导出", value = "/operator/area_shop_export.htm*", rtype = "operator", rname = "所属商户导出", rcode = "area_shop_export", rgroup = "运营商管理")
	@RequestMapping("/operator/area_shop_export.htm")
	public String areaShopExport(HttpServletResponse response, SellerVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setUserLevel(user.getOperatorBO().getLevel());
		vo.setOperatorId(user.getOperatorBO().getId());
		vo.setOperatorUserId(user.getOperatorBO().getUserId());
		vo.setOperatorAreaId(user.getOperatorBO().getOperatorAreaId());
		List<SellerBO> listResult = sellerService.selectOperatorSellerPageList(null, vo);
		exportResult(response, AreaSellerVO.class, listResult, "所属商户");
		return null;
	}

	@SecurityMapping(title = "商户订单列表", value = "/operator/shop_order_list.htm*", rtype = "operator", rname = "商户订单列表", rcode = "shop_order_list", rgroup = "运营商管理")
	@RequestMapping("/operator/shop_order_list.htm")
	public String shopOrderList(Model model, MyPage<GroupOrderBO> page, GroupOrderVO vo) {
		if (vo.getSellerId() == null) {
			model.addAttribute("op_title", "参数错误！");
			return "tips.html";
		}
		page.setPageSize(20);
		groupOrderService.selectOrderBySellerId(vo, page);
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		model.addAttribute("PaymentConstants", new PaymentConstants());
		return "shop_order_list.html";
	}

	@SecurityMapping(title = "商户服务列表", value = "/operator/shop_group_list.htm*", rtype = "operator", rname = "商户服务列表", rcode = "shop_group_list", rgroup = "运营商管理")
	@RequestMapping("/operator/shop_group_list.htm")
	public String shopGroupList(Model model, MyPage<GroupGoodsBO> page, GroupGoodsVO vo) {
		if (vo.getStoreId() == null) {
			model.addAttribute("op_title", "参数错误！");
			return "tips.html";
		}
		page.setPageSize(20);
		this.groupGoodsService.findListByVO(page, vo);
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		model.addAttribute("shopPath", configService.getSysConfig().getAddress());
		return "shop_group_list.html";
	}

	@SecurityMapping(title = "所属商户统计信息", value = "/operator/shop_state_list.htm*", rtype = "operator", rname = "所属商户统计信息", rcode = "shop_state_list", rgroup = "运营商管理")
	@RequestMapping("/operator/shop_state_list.htm")
	@ResponseBody
	public String sellerState(Model model, Long sellerId) {
		JSONObject json = new JSONObject();
		int sellerMemberCount = sellerService.findSellerMemberById(sellerId);
		json.put("sellerMemberCount", sellerMemberCount);
		int sellerOwnMemberCount = sellerService.findSellerOwnMemberById(sellerId);
		json.put("sellerOwnMemberCount", sellerOwnMemberCount);
		int sellerOwnSellerCount = sellerService.findSellerOwnSellerById(sellerId);
		json.put("sellerOwnSellerCount", sellerOwnSellerCount);
		int sellerAllOrderCount = sellerService.findSellerAllOrderCount(sellerId);
		json.put("sellerAllOrderCount", sellerAllOrderCount);
		int sellerWeekOrderCount = sellerService.findSellerWeekOrderCount(sellerId);
		json.put("sellerWeekOrderCount", sellerWeekOrderCount);
		BigDecimal sellerRebateOrderAmount = sellerService.findSellerRebateOrderCount(sellerId);
		json.put("sellerRebateOrderAmount", sellerRebateOrderAmount == null ? 0 : sellerRebateOrderAmount);
		BigDecimal sellerWeekRebateOrderAmount = sellerService.findSellerWeekRebateOrderCount(sellerId);
		json.put("sellerWeekRebateOrderAmount", sellerWeekRebateOrderAmount == null ? 0
				: sellerWeekRebateOrderAmount);
		BigDecimal sellerMonthRebateOrderAmount = sellerService.findSellerMonthRebateOrderCount(sellerId);
		json.put("sellerMonthRebateOrderAmount", sellerMonthRebateOrderAmount == null ? 0
				: sellerMonthRebateOrderAmount);
		return json.toJSONString();
	}

	@SecurityMapping(title = "注册会员列表", value = "/operator/register_user_list.htm*", rtype = "operator", rname = "注册会员列表", rcode = "register_user_list", rgroup = "运营商管理")
	@RequestMapping("/operator/register_user_list.htm")
	public String registerUserList(Model model, MyPage<UserCustomerBO> page, UserCustomerVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setOperatorUserId(user.getOperatorBO().getUserId());
		vo.setOperatorAreaId(user.getOperatorBO().getOperatorAreaId());
		page.setPageSize(20);
		customerService.selectUserCustomerByOperatorUserId(vo, page);
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		return "register_user_list.html";
	}

	@SecurityMapping(title = "所属会员列表", value = "/operator/area_user_list.htm*", rtype = "operator", rname = "所属会员列表", rcode = "area_user_list", rgroup = "运营商管理")
	@RequestMapping("/operator/area_user_list.htm")
	public String areaUserList(Model model, MyPage<UserCustomerBO> page, UserCustomerVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setOperatorUserId(user.getOperatorBO().getUserId());
		vo.setOperatorId(user.getOperatorBO().getId());
		vo.setUserLevel(user.getOperatorBO().getLevel());
		vo.setOperatorAreaId(user.getOperatorBO().getOperatorAreaId());
		page.setPageSize(20);
		customerService.selectOwnCustomerByOperatorUserId(vo, page);
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		return "area_user_list.html";
	}

	@SecurityMapping(title = "CN账户完善个人信息", value = "/operator/cn_Improve_Info.htm*", rtype = "operator", rname = "CN账户完善个人信息", rcode = "cn_Improve_Info", rgroup = "运营商管理")
	@RequestMapping("/operator/cn_Improve_Info.htm")
	public ModelAndView cn_Improve_Info(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = null;
		return mv;
	}

	@SuppressWarnings("null")
	@SecurityMapping(title = "保存CN账户完善个人信息", value = "/operator/save_CN_Improve_Info*", rtype = "operator", rname = "CN账户完善个人信息", rcode = "save_CN_Improve_Info", rgroup = "运营商管理")
	@RequestMapping("/operator/save_CN_Improve_Info.htm")
	public ModelAndView save_CN_Improve_Info(HttpServletRequest request, HttpServletResponse response,
			OperatorBO operatorBO, String area3) {
		ModelAndView mv = null;
		mv = new ModelAndView("forward:/operator/shenHe.htm");
		logger.info("================ save CN User Improve Info ================= ");
		UserBO currentUser = SecurityUserHolder.getCurrentUser();
		if (currentUser == null) {
			mv = new ModelAndView("forward:/login.htm");
			return mv;
		}
		long uid = currentUser.getId();
		boolean isCN = this.userAccountService.check_User_Is_CN(uid);
		boolean havaNull = true;
		String userName = operatorBO.getUserName();
		if (!StringUtils.isNotBlank(userName)) {
			havaNull = false;
		}
		String sex = operatorBO.getSex();
		if (!StringUtils.isNotBlank(sex)) {
			havaNull = false;
		}
		String phone = operatorBO.getPhone();
		if (!StringUtils.isNotBlank(phone)) {
			havaNull = false;
		}
		String idCard = operatorBO.getIdCard();
		if (!StringUtils.isNotBlank(idCard)) {
			havaNull = false;
		}
		String nation = operatorBO.getNation();
		if (!StringUtils.isNotBlank(nation)) {
			havaNull = false;
		}
		String operatorAreaId = area3;
		if (!StringUtils.isNotBlank(operatorAreaId)) {
			havaNull = false;
		}
		String bankName = operatorBO.getBankName();
		if (!StringUtils.isNotBlank(bankName)) {
			havaNull = false;
		}
		String subBankName = operatorBO.getSubBankName();
		if (!StringUtils.isNotBlank(subBankName)) {
			havaNull = false;
		}
		String bankNo = operatorBO.getBankNo();
		if (!StringUtils.isNotBlank(bankNo)) {
			havaNull = false;
		}
		if (!havaNull) {
			String url = CommUtil.getURL(request);
			mv.addObject("url", url);
			return mv;
		}
		if (isCN) {

			UserAccount cn_userAccount = this.userAccountService.get_CN_User(uid);
			String loginName = cn_userAccount.getLoginName();
			OperatorBO operator = this.operatorService.queryOperatorByLoginName(loginName);
			Operator updateOperator = new Operator();
			updateOperator.setStatus(UserContants.OPERATOR_CHECK_STATUS_CHECKING); // 未审核
			updateOperator.setUserName(userName);
			updateOperator.setSex(sex);
			updateOperator.setPhone(phone);
			updateOperator.setIdCard(idCard);
			updateOperator.setNation(nation);
			updateOperator.setOperatorAreaId(operatorAreaId);
			updateOperator.setBankName(bankName);
			updateOperator.setSubBankName(subBankName);
			updateOperator.setBankNo(bankNo);
			updateOperator.setId(operator.getId());
			updateOperator.setUpdateTime(new Date());
			updateOperator.setIsDeleted(false);

			CnUserLevelBO cn = orclUserBaseService.getOrclUserLevel(operator.getCn_username());
			String level = OperatorContants.OPERATOR_LEVEL_9;
			if (null != cn || null != cn.getUserType() || "" != cn.getUserType()) {
				String userType = cn.getUserType();
				if (OrclUserContants.OPERATOR_LEVEL_SILVER.equals(userType)) {
					level = OperatorContants.OPERATOR_LEVEL_9;
				} else if (OrclUserContants.OPERATOR_LEVEL_GOLD.equals(userType)) {
					level = OperatorContants.OPERATOR_LEVEL_7;
				} else if (OrclUserContants.OPERATOR_LEVEL_VIP.equals(userType)) {
					level = OperatorContants.OPERATOR_LEVEL_3;
				}
			}
			updateOperator.setLevel(level);
			this.operatorService.update(updateOperator);

			OperatorBO operatorBOt = operatorService.getOperatorBOByIdAndStatus(operator.getId(),
					UserContants.OPERATOR_CHECK_STATUS_CHECKING);
			operatorService.checkOperator(operatorBOt,
					CommUtil.null2String(SecurityUserHolder.getCurrentUserId()));
		}
		String url = CommUtil.getURL(request);
		mv.addObject("url", url);
		return mv;
	}

	private void exportResult(HttpServletResponse response, Class<?> obj, List<?> listResult, String title) {
		// 把返回的list做成导出list
		List<?> excelList = MapperUtils.map(mapper, listResult, obj);;
		if (null != listResult) {
			try {
				new ExportExcel(title, obj).setDataList(excelList)
						.write(response, title.toString() + ".xlsx").dispose();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@SecurityMapping(title = "完善个人信息", value = "/operator/wanShan.htm*", rtype = "operator", rname = "完善个人信息", rcode = "operator_index", rgroup = "运营商管理")
	@RequestMapping("/operator/wanShan.htm")
	public ModelAndView wanShan_info(Model model, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("wanShan.html");
		// 获取ip
		mv.addObject("areas", areaService.queryParentArea());
		String ip = IPUtil.getIpAddr(request);
		// ip="121.34.128.240";
		String ipdetail = redIpFind(request, response, ip);
		if (ipdetail.equals("[未分配或者内网IP------]") || ipdetail.equals("[---IP地址不正确!----]")) {
			ip = "121.34.128.240";
			ipdetail = redIpFind(request, response, ip);
		}
		Area area = null;
		try {
			area = areaService.queryAreaByName(city);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int iscity = 0;
		if (area != null) {
			Long cid = area.getId();
			Long pid = area.getParentId();
			mv.addObject("cid", cid);
			mv.addObject("pid", pid);
			mv.addObject("iscity", iscity);
			iscity = 1;
			System.out.println("cid:" + cid);
		}
		return mv;
	}

	@SecurityMapping(title = "个人信息审核", value = "/operator/shenHe.htm*", rtype = "operator", rname = "个人信息审核", rcode = "operator_index", rgroup = "运营商管理")
	@RequestMapping("/operator/shenHe.htm")
	public String shenHe(Model model, HttpServletRequest request, HttpServletResponse response) {
		String url = CommUtil.getURL(request);
		request.setAttribute("url", url);
//		return "shenHe.html";
		return "index.html";
	}

	/**
	 * 为他注册会员
	 * 
	 * @param model
	 * @param page
	 * @param vo
	 * @return
	 */
	@SecurityMapping(title = "隶属商户", value = "/operator/merchant_bind.htm*", rtype = "operator", rname = "隶属商户", rcode = "operator_index", rgroup = "运营商管理")
	@RequestMapping("/operator/merchant_bind.htm")
	public ModelAndView merchant_bind(Model model, MyPage<SellerBO> page, SellerVO vo) {
		UserBO currentUser = SecurityUserHolder.getCurrentUser();
		long uid = currentUser.getId();
		ModelAndView mv = new ModelAndView("merchant_bind.html");
		OperatorBO operator = this.operatorService.queryOperatorInfo(uid);
		if (operator != null) {
			long extensionSellerUid = operator.getExtensionSellerUid();
			// 注册商户
			int sellerOwnMemberCount = sellerService.findSellerOwnMemberById(uid);
			// 情景一：该YY或CN账号没有签约商户，提示他去签约商户
			if (sellerOwnMemberCount == 0) {
				mv.addObject("sellerOwnMemberCount", "false");
			}
			// 情景二：该YY或CN账号签约了商户，但是没有绑定
			if (sellerOwnMemberCount > 0 && extensionSellerUid == 0L) {
				mv.addObject("sellerOwnMemberCount", "true");
			}
			// 情景三：有推荐卖家 该YY或CN账号已经绑定了在某个商户下
			if (extensionSellerUid != 0L) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
				SellerBO seller = this.sellerService.findByUid(extensionSellerUid);
				long storeID = seller.getStoreId();
				StoreBO store = this.storeService.findObjById(storeID);
				// 隶属会员人数
				int sellerMemberCount = sellerService.findSellerMemberById(extensionSellerUid);
				// 返润总额
				BigDecimal sellerRebateOrderAmount = sellerService
						.findSellerRebateOrderCount(extensionSellerUid);
				mv.addObject("store", store);
				mv.addObject("addTime", dateFormat.format(store.getAddTime()));
				mv.addObject("sellerUID", seller.getUid());
				mv.addObject("storeName", store.getStoreName());
				mv.addObject("sellerMemberCount", sellerMemberCount);
				mv.addObject("sellerRebateOrderAmount", sellerRebateOrderAmount == null ? BigDecimal.ZERO
						: sellerRebateOrderAmount);
			}
		}
		return mv;
	}

	@SecurityMapping(title = "选择绑定会员", value = "/operator/getOperatorRebateList.htm*", rtype = "operator", rname = "选择绑定会员", rcode = "getOperatorRebateList", rgroup = "运营商管理")
	@RequestMapping(value = "/operator/getOperatorRebateList.htm", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String get_OperatorRebateList() {
		net.sf.json.JSONObject json = new net.sf.json.JSONObject();
		MyPage<SellerBO> page = new MyPage<SellerBO>();
		SellerVO vo = new SellerVO();
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setUserLevel(user.getOperatorBO().getLevel());
		vo.setOperatorId(user.getOperatorBO().getId());
		vo.setOperatorUserId(user.getOperatorBO().getUserId());
		vo.setOperatorAreaId(user.getOperatorBO().getOperatorAreaId());
		page.setPageSize(20);
		List<SellerBO> list = sellerService.selectOperatorSellerPageList(page, vo);
		JSONArray jsonArray = new JSONArray();
		for (SellerBO seller : list) {
			long sellerUID = seller.getUid();
			int sellerMemberCount = sellerService.findSellerMemberById(sellerUID);
			net.sf.json.JSONObject jsonTemp = new net.sf.json.JSONObject();
			jsonTemp.element("shopName", seller.getShopName());
			jsonTemp.element("memCount", sellerMemberCount);
			jsonTemp.element("sellerUID", sellerUID);
			jsonArray.add(jsonTemp);
		}
		json.element("list", jsonArray);
		String result = json.toString();
		logger.info("<<<<<<<<<< " + result);
		return result;
	}

	@SecurityMapping(title = "绑定会员", value = "/operator/operatorRegMemberOther.htm*", rtype = "operator", rname = "选择绑定会员", rcode = "operatorRegMemberOther", rgroup = "运营商管理")
	@RequestMapping(value = "/operator/operatorRegMemberOther.htm", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String operatorRegMemberOther(HttpServletRequest request, HttpServletResponse response) {
		String result = "";
		String param = request.getParameter("sellerUID");
		long sellerUID = 0L;
		long currentUID = SecurityUserHolder.getCurrentUserId();
		net.sf.json.JSONObject json = new net.sf.json.JSONObject();
		if (param != null && param.trim().length() > 0) {
			sellerUID = Long.parseLong(param);
			OperatorBO operatorBO = operatorService.queryOperatorInfo(currentUID);
			long operatorID = operatorBO.getId();
			SellerBO sellerBO = this.sellerService.findByUid(sellerUID);
			long storeID = sellerBO.getStoreId();
			boolean isSub = this.operatorService.check_SubMerchant(operatorID, storeID);
			if (isSub) // 隶属关系
			{
				this.operatorService.reg_member_other_update(operatorID, storeID);
				json.element("result", "succ");
				json.element("content", "操作成功");
			} else {
				json.element("result", "fali");
				json.element("content", "操作失败");
			}
		}
		result = json.toString();
		logger.info("<<<<<<< " + result);
		return result;
	}

	/**
	 * 根据父id加载下级区域，返回json格式数据，这里只返回id和areaName，根据需要可以修改返回数据
	 * 
	 * @param request
	 * @param response
	 * @param pid
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping("/load_area.htm")
	public void load_area(HttpServletRequest request, HttpServletResponse response, String pid) {

		List<Area> areas = this.dicContant.getDicsConvertByParentCode(Area.class, pid);
		Collections.sort(areas);

		List<Map> list = new ArrayList<Map>();
		for (DicBase area : areas) {
			Map map = new HashMap();
			map.put("id", area.getCode());
			map.put("areaName", area.getName());
			list.add(map);
		}
		String temp = Json.toJson(list, JsonFormat.compact());
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(temp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	String city = "";

	public String redIpFind(HttpServletRequest request, HttpServletResponse response, String ip) {
		String ipdetail = "[---IP地址不正确!----]";
		if (ip != null && !ip.equals("") && ip.indexOf("0:0:0:0") < 0) {
			String[] split = ip.trim().split(",");
			ipdetail = IpAddressByDetails.GetAddressByIp(split[0].trim());
		}
		String ctys[] = ipdetail.split("--");
		city = ctys[2];
		return ipdetail;
	}
}
