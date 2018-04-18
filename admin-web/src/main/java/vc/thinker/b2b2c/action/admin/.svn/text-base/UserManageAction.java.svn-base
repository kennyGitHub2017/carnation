package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.carnation.aio.model.AioBinding;
import com.sinco.carnation.aio.service.AioBindingService;
import com.sinco.carnation.check.service.CheckResultHistoryService;
import com.sinco.carnation.consulting.service.ConsultingService;
import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.o2o.bo.GroupEvaluationBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.service.GroupEvaluationService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupEvaluationVO;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.rebate.service.RebateRecordService;
import com.sinco.carnation.shop.bo.EvaluateBO;
import com.sinco.carnation.shop.vo.EvaluateVO;
import com.sinco.carnation.sns.bo.CircleInvitationBO;
import com.sinco.carnation.sns.bo.ConsultingBO;
import com.sinco.carnation.sns.bo.ConsultingRepayBO;
import com.sinco.carnation.sns.vo.ConsultingVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.RoleService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.SysLogServiceImpl;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.CheckResultHistoryBO;
import com.sinco.carnation.user.bo.RebateRecordBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.bo.UserExpertsBO;
import com.sinco.carnation.user.service.ExpertsService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.vo.CheckResultHistoryVO;
import com.sinco.carnation.user.vo.RebateRecordVO;
import com.sinco.carnation.user.vo.UserCustomerVO;
import com.sinco.common.utils.IPUtil;
import com.sinco.dal.common.MyPage;

@Controller
public class UserManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	RebateRecordService rebateRecordService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	CheckResultHistoryService checkResultHistoryService;
	@Autowired
	private SysLogServiceImpl syslogService;
	@Autowired
	private ConsultingService consulService;
	@Autowired
	private EvaluateService evaluateService;
	// @Autowired
	// private IOrderFormService orderFormService;
	// @Autowired
	// private IOrderFormLogService orderFormLogService;
	// @Autowired
	// private IGroupLifeGoodsService grouplifegoodsService;
	// @Autowired
	// private IGoodsService goodsService;
	// @Autowired
	// private IGroupInfoService groupinfoService;
	// @Autowired
	// private ICouponInfoService couponInfoService;
	// @Autowired
	// private IPayoffLogService paylogService;
	// @Autowired
	// private IGoodsSpecPropertyService specpropertyService;
	// @Autowired
	// private IGoodsSpecificationService specService;
	// @Autowired
	// private IGoldLogService goldlogService;
	// @Autowired
	// private IFavoriteService favoriteService;
	// @Autowired
	// private IComplaintGoodsService complaintGoodsService;
	// @Autowired
	// private IStoreService storeService;
	// @Autowired
	// private IGoldRecordService grService;
	// @Autowired
	// private IStorePointService storepointService;
	// @Autowired
	// private IGoldLogService glService;
	// @Autowired
	// private IPredepositCashService redepositcashService;
	// @Autowired
	// private StoreTools storeTools;
	// @Autowired
	// private IIntegralGoodsOrderService integralGoodsOrderService;
	// @Autowired
	// private IIntegralLogService integralLogService;
	// @Autowired
	// private ISnsAttentionService snsAttentionService;
	// @Autowired
	// private IDeliveryAddressService deliveryAddressService;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private ExpertsService expertService;

	@Autowired
	private WeedFSClient fsClient;

	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private GroupEvaluationService groupEvaluationService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private GroupOrderService orderService;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private AioBindingService aioService;

	@SecurityMapping(title = "会员详情", value = "/admin/user_detail.htm*", rtype = "admin", rname = "会员详情", rcode = "user_detail", rgroup = "用户管理")
	@RequestMapping("/admin/user_detail.htm")
	public ModelAndView userDetail(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/user_detail.html", configService.getSysConfig(), 0,
				request, response);
		UserCustomerBO customer = userCustomerService.findBOByUserId(id);
		UserCustomerBO refreeUser = null;
		if (customer.getRefreeUserId() != null) {
			refreeUser = userCustomerService.findBOByUserId(customer.getRefreeUserId());
		}
		// 获取身份号
		AioBinding aioBinding = aioService.getAioBindingByUid(id);
		customer.setIdCard(null != aioBinding ? aioBinding.getIdCard() : "");
		
		mv.addObject("customer", customer);
		mv.addObject("refreeUser", refreeUser);
		return mv;
	}

	@SecurityMapping(title = "会员统计", value = "/admin/user_statistic.htm*", rtype = "admin", rname = "会员统计", rcode = "user_manage", rgroup = "用户管理")
	@RequestMapping("/admin/user_statistic.htm")
	public ModelAndView user_statistic(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/user_statistic.html", configService.getSysConfig(),
				0, request, response);
		Map<String, Integer> map = customerService.queryUserStatistics();
		mv.addObject("map", map);
		return mv;
	}

	@SecurityMapping(title = "会员添加", value = "/admin/user_add.htm*", rtype = "admin", rname = "会员管理", rcode = "user_manage", rgroup = "用户管理")
	@RequestMapping("/admin/user_add.htm")
	public ModelAndView user_add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/user_add.html", configService.getSysConfig(), 0,
				request, response);
		return mv;
	}

	@SecurityMapping(title = "会员编辑", value = "/admin/user_edit.htm*", rtype = "admin", rname = "会员管理", rcode = "user_manage", rgroup = "用户管理")
	@RequestMapping("/admin/user_edit.htm")
	public ModelAndView user_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String op) {
		ModelAndView mv = new JModelAndView("admin/blue/user_add.html", configService.getSysConfig(), 0,
				request, response);
		if (StringUtils.isNotBlank(id)) {
			UserCustomerBO user = customerService.queryUserByUid(CommUtil.null2Long(id));
			mv.addObject("obj", user);
			mv.addObject("edit", true);
		}
		return mv;
	}

	@SecurityMapping(title = "企业用户", value = "/admin/company_user.htm*", rtype = "admin", rname = "会员管理", rcode = "user_manage", rgroup = "用户管理")
	@RequestMapping("/admin/company_user.htm")
	public ModelAndView company_user(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/company_user.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("obj", this.userService.findById(Long.parseLong(id)));
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "会员列表", value = "/admin/user_list.htm*", rtype = "admin", rname = "会员管理", rcode = "user_manage", rgroup = "用户管理")
	@RequestMapping("/admin/user_list.htm")
	public ModelAndView user_list(HttpServletRequest request, HttpServletResponse response,
			UserCustomerVO vo, String condition, String value, MyPage<UserCustomerBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/user_list.html", configService.getSysConfig(), 0,
				request, response);
		customerService.queryCustomerPageList(vo, condition, value, page);
		List<UserCustomerBO> lists = page.getContent();
		if(lists != null && lists.size() > 0){
			List<Long> ids =  new ArrayList<>();
			for(UserCustomerBO bo : lists){
				ids.add(bo.getUid());
			}
			if(ids.size() > 0){
				List<UserAccount> users = userAccountService.findUserAccountByUids(ids, null);
				if(users != null && users.size() > 0){
					for(UserCustomerBO bo : lists){
						for(UserAccount user : users){
							if(bo.getUid().longValue() == user.getUid().longValue()){
								if(bo.getLoginName() == null || bo.getLoginName().length() > 12){
									bo.setId(user.getId());
									bo.setLoginName(user.getLoginName());
									bo.setLastLoginTime(user.getLastLoginTime());
								}
							}
						}
					}
				}
			}
		}
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("pages", page.getContent());
		mv.addObject("vo", vo);
		mv.addObject("condition", condition);
		mv.addObject("value", value);
		return mv;
	}

	@SecurityMapping(title = "会员保存", value = "/admin/user_save.htm*", rtype = "admin", rname = "会员管理", rcode = "user_manage", rgroup = "用户管理")
	@RequestMapping("/admin/user_save.htm")
	public ModelAndView user_save(HttpServletRequest request, HttpServletResponse response, String id,
			String list_url, String add_url) {
		String ip = IPUtil.getIpAddr(request);
		WebForm wf = new WebForm();
		UserCustomerVO user = null;
		if (StringUtils.isBlank(id)) {
			user = wf.toPo(request, UserCustomerVO.class);
			// 添加会员
			customerService.addUser(user, ip);
		} else {
			user = (UserCustomerVO) wf.toPo(request, UserCustomerVO.class);
			// 修改会员
			customerService.updateUser(user);
		}

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存会员成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url);
		}
		return mv;
	}

//	@SecurityMapping(title = "会员删除", value = "/admin/user_del.htm*", rtype = "admin", rname = "会员管理", rcode = "user_manage", rgroup = "会员")
//	@RequestMapping("/admin/user_del.htm")
//	public String user_del(HttpServletRequest request, String mulitId, String currentPage) throws Exception {
//        customerService.delMember(mulitId);
//		return "redirect:user_list.htm?currentPage=" + currentPage;
//	}

	@SecurityMapping(title = "会员冻结", value = "/admin/user_freeze.htm*", rtype = "admin", rname = "会员管理", rcode = "user_manage", rgroup = "用户管理")
	@RequestMapping("/admin/user_freeze.htm")
	public String user_del(HttpServletRequest request, boolean freezed, String mulitId, String currentPage)
			throws Exception {
		customerService.freezeUsers(mulitId, freezed);
		return "redirect:user_list.htm?currentPage=" + currentPage + "&isDeleted=" + !freezed;
	}

	@RequestMapping("/admin/userRebate.htm")
	public ModelAndView userRebate(HttpServletRequest request, HttpServletResponse response,
			RebateRecordVO vo, MyPage<RebateRecordBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/userRebate.html", configService.getSysConfig(), 0,
				request, response);
		rebateRecordService.queryByUser(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("pages", page.getContent());
		mv.addObject("vo", vo);

		return mv;
	}

	@RequestMapping("/admin/selfTest.htm")
	public ModelAndView selfTest(HttpServletRequest request, HttpServletResponse response,
			CheckResultHistoryVO vo, MyPage<CheckResultHistoryBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/selfTest.html", configService.getSysConfig(), 0,
				request, response);
		checkResultHistoryService.findPageByUserId(vo.getUserId(), page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("pages", page.getContent());
		mv.addObject("vo", vo);

		return mv;
	}

	@SecurityMapping(title = "会员通知", value = "/admin/user_msg.htm*", rtype = "admin", rname = "会员通知", rcode = "user_msg", rgroup = "用户管理")
	@RequestMapping("/admin/user_msg.htm")
	public ModelAndView user_msg(HttpServletRequest request, HttpServletResponse response, String userName,
			String list_url) {
		ModelAndView mv = new JModelAndView("admin/blue/user_msg.html", configService.getSysConfig(), 0,
				request, response);
		// List<StoreGrade> grades = this.storeGradeService.query(
		// "select obj from StoreGrade obj order by obj.sequence asc",
		// null, -1, -1);
		// mv.addObject("grades", grades);
		if (!"".equals(userName)) {
			mv.addObject("userName", userName);
		}
		if (!"".equals(list_url)) {
			mv.addObject("list_url", list_url);
		}
		return mv;
	}

	@SecurityMapping(title = "会员通知发送", value = "/admin/user_msg_send.htm*", rtype = "admin", rname = "会员通知", rcode = "user_msg", rgroup = "用户管理")
	@RequestMapping("/admin/user_msg_send.htm")
	public ModelAndView user_msg_send(HttpServletRequest request, HttpServletResponse response,
			String list_url, String type, String users, String content) throws IOException {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		List<Long> userIds = new ArrayList<>();
		if (type.equals("all_user"))
			userIds = customerService.findAllCustomer();
		else if (type.equals("the_user")) {
			List<String> user_names = CommUtil.str2list(users);
			if (CollectionUtils.isNotEmpty(user_names))
				userIds = userAccountService.findCustomerByLoginNames(user_names);
		}

		if (CollectionUtils.isNotEmpty(userIds))
			customerService.sendMessage(userIds, content);

		mv.addObject("op_title", "会员通知发送成功");
		mv.addObject("list_url", list_url);
		return mv;
	}

	@SecurityMapping(title = "会员等级", value = "/admin/user_level.htm*", rtype = "admin", rname = "会员等级", rcode = "user_level", rgroup = "用户管理")
	@RequestMapping("/admin/user_level.htm")
	public ModelAndView user_level(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/user_level.html", configService.getSysConfig(), 0,
				request, response);
		return mv;
	}

	@SecurityMapping(title = "会员等级保存", value = "/admin/user_level_save.htm*", rtype = "admin", rname = "会员等级", rcode = "user_level", rgroup = "用户管理")
	@RequestMapping("/admin/user_level_save.htm")
	public ModelAndView user_level_save(HttpServletRequest request, HttpServletResponse response, String id,
			String list_url) throws IOException {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		SysConfig sc = configService.getSysConfig();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i <= 6; i++) {
			map.put("creditrule" + i, CommUtil.null2Int(request.getParameter("creditrule" + i)));
		}
		ObjectMapper mapper = new ObjectMapper();
		String user_creditrule = mapper.writeValueAsString(map);
		sc.setUserLevel(user_creditrule);
		configService.saveSysGrade(id, sc);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存会员等级成功");
		return mv;
	}

	@SecurityMapping(title = "会员收藏专家列表", value = "/admin/user_collections_expert.htm*", rtype = "admin", rname = "会员收藏专家列表", rcode = "user_collections_expert", rgroup = "用户管理")
	@RequestMapping("/admin/user_collections_expert.htm")
	public ModelAndView user_collections_expert(Long userId, String nickName, MyPage<UserExpertsBO> page,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/user_collections_expert.html",
				configService.getSysConfig(), 0, request, response);
		customerService.searchFavoriteExperts(userId, null, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
//		mv.addObject("nickName", nickName);
		mv.addObject("userId", userId);
		return mv;
	}

	@SecurityMapping(title = "会员收藏帖子列表", value = "/admin/user_collections_post.htm*", rtype = "admin", rname = "会员收藏帖子列表", rcode = "user_collections_post", rgroup = "用户管理")
	@RequestMapping("/admin/user_collections_post.htm")
	public ModelAndView user_collections_post(Long userId, String nickName, MyPage<CircleInvitationBO> page,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/user_collections_post.html",
				configService.getSysConfig(), 0, request, response);
		customerService.searchFavoriteCircleInvitations(userId, null, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
//		mv.addObject("nickName", nickName);
		mv.addObject("userId", userId);
		return mv;
	}

	@SecurityMapping(title = "会员收藏服务商户列表", value = "/admin/user_collections_seller.htm*", rtype = "admin", rname = "会员收藏服务商户列表", rcode = "user_collections_seller", rgroup = "用户管理")
	@RequestMapping("/admin/user_collections_seller.htm")
	public ModelAndView user_collections_seller(Long userId, String nickName, String type,
			MyPage<StoreBO> page, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/user_collections_seller.html",
				configService.getSysConfig(), 0, request, response);
		customerService.searchFavoriteStores(userId, null, type, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
//		mv.addObject("nickName", nickName);
		mv.addObject("userId", userId);
		mv.addObject("type", type);
		return mv;
	}

	@SecurityMapping(title = "会员收藏商品列表", value = "/admin/user_collections_goods.htm*", rtype = "admin", rname = "会员收藏商品列表", rcode = "user_collections_goods", rgroup = "用户管理")
	@RequestMapping("/admin/user_collections_goods.htm")
	public ModelAndView user_collections_goods(Long userId, String nickName, MyPage<GoodsBO> page,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/user_collections_goods.html",
				configService.getSysConfig(), 0, request, response);
		customerService.searchFavoriteGoods(userId, null, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
//		mv.addObject("nickName", nickName);
		mv.addObject("userId", userId);
		return mv;
	}

	@SecurityMapping(title = "会员收藏服务列表", value = "/admin/user_collections_service.htm*", rtype = "admin", rname = "会员收藏服务列表", rcode = "user_collections_service", rgroup = "用户管理")
	@RequestMapping("/admin/user_collections_service.htm")
	public ModelAndView user_collections_service(Long userId, String nickName, String type,
			MyPage<GroupGoodsBO> page, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/user_collections_service.html",
				configService.getSysConfig(), 0, request, response);
		customerService.searchFavoriteGroupServices(userId, null, type, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
//		mv.addObject("nickName", nickName);
		mv.addObject("userId", userId);
		mv.addObject("type", type);
		return mv;
	}

	@SecurityMapping(title = "会员商品评论列表", value = "/admin/user_evaluations_goods.htm*", rtype = "admin", rname = "会员商品评论列表", rcode = "user_evaluation", rgroup = "用户管理")
	@RequestMapping("/admin/user_evaluations_goods.htm")
	public ModelAndView user_evaluations_goods(HttpServletRequest request, HttpServletResponse response,
			String currentPage, EvaluateVO vo, MyPage<EvaluateBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/user_evaluations_goods.html",
				configService.getSysConfig(), 0, request, response);
		evaluateService.queryByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("vo", vo);
		return mv;
	}

	@SecurityMapping(title = "会员商户服务评论列表", value = "/admin/user_evaluations_service.htm*", rtype = "admin", rname = "会员商户服务评论列表", rcode = "user_evaluation", rgroup = "用户管理")
	@RequestMapping("/admin/user_evaluations_service.htm")
	public ModelAndView user_evaluations_service(Long userId, HttpServletRequest request,
			HttpServletResponse response, String currentPage, GroupEvaluationVO vo,
			MyPage<GroupEvaluationBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/user_evaluations_service.html",
				configService.getSysConfig(), 0, request, response);
		groupEvaluationService.query(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("orderService", orderService);
		mv.addObject("userId", userId);
		return mv;
	}

	@SecurityMapping(title = "会员专家咨询列表", value = "/admin/user_consults.htm*", rtype = "admin", rname = "会员专家咨询列表", rcode = "user_consuling", rgroup = "用户管理")
	@RequestMapping("/admin/user_consultings.htm")
	public ModelAndView user_consultings(Long userId, HttpServletRequest request,
			HttpServletResponse response, String currentPage, ConsultingVO vo, MyPage<ConsultingBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/user_consultings.html", configService.getSysConfig(),
				0, request, response);
		vo.setUserId(userId);
		consulService.queryConsulList(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("userId", userId);
		return mv;
	}

	@SecurityMapping(title = "会员专家咨询详情", value = "/admin/user_consults.htm*", rtype = "admin", rname = "会员专家咨询详情", rcode = "user_consuling", rgroup = "用户管理")
	@RequestMapping("/admin/user_consulting_details.htm")
	public ModelAndView list(Long consId, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/user_consulting_details.html",
				configService.getSysConfig(), 0, request, response);
		ConsultingBO con = consulService.queryConsulDetails(consId);
		List<ConsultingRepayBO> list = consulService.consultReplyList(consId);
		if (StringUtils.isNotBlank(con.getImages())) {
			mv.addObject("imageList", con.getImages().split("\\|"));
		}
		mv.addObject("consId", consId);
		mv.addObject("obj", con);
		mv.addObject("pages", list);
		if (StringUtils.isNotBlank(con.getImages())) {
			String[] img = con.getImages().split("||");
			mv.addObject("imgs", img);
		}
		return mv;
	}

	/**
	 * 账号清除
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param condition
	 * @param value
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "帐号清除", value = "/admin/user_ClearAccount_Page.htm*", rtype = "admin", rname = "帐号清除", rcode = "user_consuling", rgroup = "用户管理")
	@RequestMapping("/admin/user_ClearAccount_Page.htm")
	public ModelAndView user_Clear_Account_Page(HttpServletRequest request, HttpServletResponse response,
			UserCustomerVO vo, String condition, String value, MyPage<UserCustomerBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/user_clear_list.html", configService.getSysConfig(),
				0, request, response);
		customerService.queryCustomerPageList2(vo, condition, value, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("pages", page.getContent());
		mv.addObject("vo", vo);
		mv.addObject("condition", condition);
		mv.addObject("value", value);
		return mv;
	}

	/**
	 * 帐号清除操作
	 * 
	 * @param request
	 * @param response
	 * @param uid
	 * @param types
	 *            0:清除账号(假删除) 1:彻底清除账号(真删除) 2:恢复账号
	 * @return
	 */
	@SecurityMapping(title = "帐号清除操作", value = "/admin/user_ClearAccount.htm*", rtype = "admin", rname = "帐号清除操作", rcode = "user_consuling", rgroup = "用户管理")
	@RequestMapping("/admin/user_ClearAccount.htm")
	public ModelAndView do_Clear_Account(HttpServletRequest request, HttpServletResponse response,
			String uid, String types) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		String op_title = "操作参数有误";
		long currentUserID = SecurityUserHolder.getCurrentUser().getId();
		if (types != null && types.trim().length() > 0) {
			if (types.equals("0")) // 清除账号
			{
				this.userService.updateUserIsDeleted(uid, currentUserID, true);
				op_title = "清除账号成功";
			} else if (types.equals("1")) // 彻底清除账号
			{
				this.userService.deleteUserByUID(uid);
				op_title = "彻底清除账号成功";
			} else if (types.equals("2")) // 恢复账号
			{
				this.userService.updateUserIsDeleted(uid, currentUserID, false);
				op_title = "恢复账号成功";
			}
		}
		String webPath = CommUtil.getURL(request);
		String list_url = webPath + "/admin/user_ClearAccount_Page.htm";
		mv.addObject("op_title", op_title);
		mv.addObject("list_url", list_url);
		return mv;
	}
}
