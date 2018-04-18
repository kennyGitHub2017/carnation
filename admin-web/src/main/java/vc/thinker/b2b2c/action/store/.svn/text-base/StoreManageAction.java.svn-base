package vc.thinker.b2b2c.action.store;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.database.DatabaseTools;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.GoodsSpecPropertyService;
import com.sinco.carnation.goods.service.GoodsSpecificationService;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.operation.service.CouponInfoService;
import com.sinco.carnation.operation.service.CouponService;
import com.sinco.carnation.operation.service.ZTCGoldLogService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.shop.service.ComplaintGoodsService;
import com.sinco.carnation.shop.service.ConsultService;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.bo.StoreGradeBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.model.StoreGrade;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.store.service.StorePointService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreApplyInfoVO;
import com.sinco.carnation.store.vo.StoreApplyVO;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.bo.orcl.CnUserLevelBO;
import com.sinco.carnation.sys.contants.OrclUserContants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.RoleService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.TemplateService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.GoldLogService;
import com.sinco.carnation.user.service.GoldRecordService;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.OrclUserBaseService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.carnation.watermark.service.WaterMarkService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: StoreManageAction.java
 * </p>
 * 
 * <p>
 * Description: 运营商店铺管理控制器，用来管理店铺，可以添加、修改、删除店铺，运营商所有对店铺的操作均通过该管理控制器完成
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
 * @date 2014-5-12
 * 
 * @version 1.0.1
 */
@Controller
public class StoreManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreGradeService storeGradeService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ConsultService consultService;
	@Autowired
	private StoreTools storeTools;
	@Autowired
	private DatabaseTools databaseTools;
	@Autowired
	private TemplateService templateService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private GoodsCartService goodsCartService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private OrderFormLogService orderFormLogService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	// @Autowired
	// private AlbumService albumService;
	@Autowired
	private GoodsClassService goodsclassService;
	@Autowired
	private StorePointService storePointService;
	// @Autowired
	// private Favorite favoriteService;
	@Autowired
	private ComplaintGoodsService complaintGoodsService;
	@Autowired
	private PredepositService predepositService;
	@Autowired
	private CouponInfoService couponInfoService;
	@Autowired
	private PayoffLogService paylogService;
	@Autowired
	private GoodsSpecPropertyService specpropertyService;
	@Autowired
	private GoodsSpecificationService specService;
	@Autowired
	private GoldRecordService grService;
	@Autowired
	private ZTCGoldLogService ztcglService;
	@Autowired
	private GoldLogService glService;
	@Autowired
	private CouponService couponService;
	@Autowired
	private WaterMarkService waterMarkService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private UserRelationService userRelationService;
	@Autowired
	private UserService userService;

	@Autowired
	private UserCustomerService userCustomerService;

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private OrclUserBaseService orclUserBaseService;

	/**
	 * Store列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "店铺列表", value = "/admin/store_list.htm*", rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup = "商户管理")
	@RequestMapping("/admin/store_list.htm")
	public ModelAndView store_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<StoreBO> page, StoreVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/store_list.html", configService.getSysConfig(), 0,
				request, response);
		vo.setIsShop(true);
		this.storeService.findPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		List<StoreGradeBO> grades = this.storeGradeService.findList();
		List<GoodsClassBO> gcs = this.goodsclassService.findLevelAll();

		mv.addObject("grades", grades);
		mv.addObject("gcs", gcs);
		mv.addObject("vo", vo);

		return mv;
	}

	/**
	 * 店铺添加(进入到检查用户名页面)
	 * 
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "店铺添加(进入到检查用户名页面)", value = "/admin/store_add.htm*", rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup = "商户管理")
	@RequestMapping("/admin/store_add.htm")
	public ModelAndView store_add(HttpServletRequest request, HttpServletResponse response, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/store_add.html", configService.getSysConfig(),
		/* this.userConfigService.getUserConfig(), */0, request, response);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * 店铺添加
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "店铺添加", value = "/admin/store_new.htm*", rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup = "商户管理")
	@RequestMapping("/admin/store_new.htm")
	public ModelAndView store_new(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String userName, String list_url, String add_url) {
		ModelAndView mv = new JModelAndView("admin/blue/store_new.html", configService.getSysConfig(),
		/* this.userConfigService.getUserConfig(), */0, request, response);
		SellerBO user = null;
		if (StringUtils.isNotBlank(userName)) {
			user = sellerService.getByUsername(userName.trim());
		}
		if (user == null) {
			mv = new JModelAndView("admin/blue/tip.html", configService.getSysConfig(), 0, request, response);
			mv.addObject("op_tip", "不存在该用户");
			mv.addObject("list_url", list_url);
		} else {
			if (user.getStoreId() == null || !(user.getStoreId() > 0)) {
				List<Area> areas = this.areaService.queryParentArea();
				List<StoreGradeBO> grades = this.storeGradeService.findList();
				mv.addObject("grades", grades);
				mv.addObject("areas", areas);
				mv.addObject("currentPage", currentPage);
				mv.addObject("user", user);

				List<GoodsClassBO> gcs = this.goodsclassService.findLevelAll();
				mv.addObject("goodsClass", gcs);

				// 新增店铺都必填运营商推荐人。2016-9-19:需求修改
				/*String refereeUserName = null;
				if (user.getUid() != null && user.getUid() > 0) { // 这里没做判空导致空指针异常 bug 1636
					refereeUserName = this.GetRefereeUserName(user.getUid());
				}
				mv.addObject("refereeUserName", refereeUserName);*/

			} else {
				mv = new JModelAndView("admin/blue/tip.html", configService.getSysConfig(), 0, request,
						response);
				mv.addObject("op_tip", "该用户已经开通店铺");
				mv.addObject("list_url", add_url);
			}
		}
		return mv;
	}

	/**
	 * 获取推荐人名称 ---推荐人 如果会员存在推荐人，则显示推荐人；如果推荐人不存在，则需要用户填写，只能填写运营商编码； <br>
	 * <br>
	 * <br>
	 * <b>方法名首字母请小写，然后方法注释请用文档注释！！！！！！！还有记得判空</b> <br>
	 * <br>
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unused")
	private String GetRefereeUserName(Long userId) {
		String refereeUserName = "";
		if (userId != null && userId > 0) {
			UserRelationBO userRelationBO = this.userRelationService.getUserRelation(userId);
			if (userRelationBO != null
					&& (userRelationBO.getRefereeUserId() != null && userRelationBO.getRefereeUserId() > 0)) {
				UserBO userBo = this.userService.findById(userRelationBO.getRefereeUserId());
				int userType = userBo.getUserType();

				if (userType == UserContant.USER_TYPE_1) { // 个人或商户
					UserCustomer userCustomer = this.userCustomerService.findById(userBo.getId());
					refereeUserName = userCustomer == null ? "" : userCustomer.getNickname();
				} else if (userType == UserContant.USER_TYPE_4) { // 运营商
					OperatorBO operatorBO = this.operatorService.getOperatorBOByUserId(userBo.getId());
					refereeUserName = operatorBO == null ? "" : String.format("%s[%s]",
							operatorBO.getOperatorName(), operatorBO.getOperatorCode());
				}
			}
		}
		return refereeUserName;
	}

	// /**
	// * 店铺经营类目Ajax加载
	// *
	// * @param request
	// * @param response
	// * @param cid
	// * @return
	// */
	// @SecurityMapping(title = "店铺添加2", value = "/admin/store_gc_ajax.htm*",
	// rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup =
	// "店铺")
	// @RequestMapping("/admin/store_gc_ajax.htm")
	// public ModelAndView store_goodsclass_dialog(HttpServletRequest request,
	// HttpServletResponse response, String cid) {
	// ModelAndView mv = new JModelAndView("admin/blue/store_gc_ajax.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 0, request, response);
	// if (cid != null && !cid.equals("")) {
	// GoodsClass goodsClass = this.goodsclassService.getObjById(CommUtil
	// .null2Long(cid));
	// Set<GoodsClass> gcs = goodsClass.getChilds();
	// mv.addObject("gcs", gcs);
	// }
	// return mv;
	// }

	/**
	 * store公司信息查看
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "店铺公司信息查看", value = "/admin/store_company.htm*", rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup = "商户管理")
	@RequestMapping("/admin/store_company.htm")
	public ModelAndView store_company(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/store_company.html", configService.getSysConfig(),
		/* this.userConfigService.getUserConfig(), */0, request, response);
		StoreBO store = this.storeService.getObjById(CommUtil.null2Long(id));
		mv.addObject("store", store);

		return mv;
	}

	/**
	 * store编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "店铺编辑", value = "/admin/store_edit.htm*", rtype = "admin", rname = "店铺管理（编辑）", rcode = "admin_store_edit_permiter", rgroup = "商户管理")
	@RequestMapping("/admin/store_edit.htm")
	public ModelAndView store_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/store_edit.html", configService.getSysConfig(),
		/* this.userConfigService.getUserConfig(), */0, request, response);
		if (id != null && !id.equals("")) {
			StoreBO store = this.storeService.getObjById(Long.parseLong(id));
			List<Area> areas = this.areaService.queryParentArea();
			mv.addObject("areas", areas);
			mv.addObject("obj", store);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
			mv.addObject("goodsClass_main", this.goodsclassService.getObjById(store.getGcMainId()));
			Set<GoodsClass> goodsClassDetailSet = this.storeTools.query_store_DetailGc(store
					.getGcDetailInfo());
			mv.addObject("goodsClass_detail", goodsClassDetailSet);
			mv.addObject("area_info", store.getAreaInfo());
		}
		return mv;
	}

	/**
	 * store保存管理
	 * 
	 * @param id
	 * @param gc_main_id
	 *            :主营类目id
	 * @param gc_detail_ids
	 *            ：详细类目id
	 * @param id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@SecurityMapping(title = "店铺保存", value = "/admin/store_save.htm*", rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup = "商户管理")
	@RequestMapping("/admin/store_save.htm")
	public ModelAndView store_save(HttpServletRequest request, HttpServletResponse response, String list_url,
			String add_url, StoreVO store, String refereeOperatorCode) throws Exception {

		SysConfigBO config = configService.getSysConfig();
		if (store != null) {
			if (StringUtils.isNotBlank(store.getValidityStr())) {
				store.setValidity(CommUtil.formatDate(store.getValidityStr()));
			}
			if (store.getId() != null && store.getId() > 0) {// 更新
				this.storeService.update(store);
			} else { // 新增
				store.setAddTime(new Date());
				// 设置默认logo
				if (config.getStoreImage() != null) {
					store.setStoreLogoPath(config.getStoreImage().getPath());
				}
				if (store.getGcMainIdClone() != null && store.getGcMainIdClone() > 0) {
					store.setGcMainId(store.getGcMainIdClone());
				}
				store.setIsShop(true);
				store.setIsO2o(false);

				// 保存推荐关系
				if (StringUtils.isNotEmpty(refereeOperatorCode)) {
					OperatorBO operatorBO = this.operatorService
							.getOperatorBOByOperatorCode(refereeOperatorCode);
					if (operatorBO != null) {
						// 运营商为金卡，银卡级别的运营商不能推荐供应商
						if (UserContants.OPERATOR_LEVEL_GOLD.equals(operatorBO.getLevel())
								|| UserContants.OPERATOR_LEVEL_SILVER.equals(operatorBO.getLevel())) {
							JModelAndView mv = new JModelAndView("admin/blue/error.html",
									configService.getSysConfig(), 0, request, response);
							mv.addObject("op_title", "金卡，银卡级别不能推荐供应商!");
							mv.addObject("list_url", list_url);
							return mv;
						}
						if (operatorBO.getCn_username() != null
								&& operatorBO.getCn_username().startsWith(UserContant.ACCOUNT_TYPE_CN)) {
							CnUserLevelBO cn = orclUserBaseService.getOrclUserLevel(operatorBO
									.getCn_username());
							if (null == cn || null == cn.getUserType() || "" == cn.getUserType()) {
								JModelAndView mv = new JModelAndView("admin/blue/error.html",
										configService.getSysConfig(), 0, request, response);
								mv.addObject("op_title", "结算平台未查询到该运营商，请稍后再试!");
								mv.addObject("list_url", list_url);
								return mv;
							}
							if (cn != null && OrclUserContants.OPERATOR_LEVEL_GOLD.equals(cn.getUserType())
									|| OrclUserContants.OPERATOR_LEVEL_SILVER.equals(cn.getUserType())) {
								JModelAndView mv = new JModelAndView("admin/blue/error.html",
										configService.getSysConfig(), 0, request, response);
								mv.addObject("op_title", "金卡，银卡级别不能推荐供应商!");
								mv.addObject("list_url", list_url);
								return mv;
							}
						}
						// 保存推荐关系
						this.userRelationService.createUserRelation(store.getUid(), operatorBO.getUserId(),
								0L);
					} else {
						JModelAndView mv = new JModelAndView("admin/blue/error.html",
								configService.getSysConfig(), 0, request, response);
						mv.addObject("op_title", "运营商编码不存在");
						mv.addObject("list_url", list_url);
						return mv;
					}
				}/*else{
					JModelAndView mv = new JModelAndView("admin/blue/error.html",
							configService.getSysConfig(),
							0, request,
							response);
					mv.addObject("op_title", "运营商编码不能为空");
					mv.addObject("list_url", list_url);
					return mv;
					}*/

				this.storeService.create(store);
			}
		}
		// if (store_status != null && !store_status.equals("")) {
		// if (store_status.equals("5") || store_status.equals("10")) {// 入驻审核中
		// store.setStore_status(CommUtil.null2Int(store_status));
		// } else if (store_status.equals("6") || store_status.equals("11")) {//
		// 入驻审核失败
		// store.setStore_status(CommUtil.null2Int(store_status));
		// this.send_site_msg(request,
		// "msg_toseller_store_update_refuse_notify", store);
		// } else if (store_status.equals("15")) {// 入驻成功，给用户赋予卖家权限
		// if (user_id != null && !user_id.equals("")) {// 平台为用户新增店铺
		// User user = this.userService.getObjById(CommUtil
		// .null2Long(user_id));
		// store.setUser(user);
		// Area area = this.areaService.getObjById(CommUtil
		// .null2Long(area_id));
		// store.setArea(area);
		// StoreGrade grade = this.storeGradeService
		// .getObjById(CommUtil.null2Long(grade_id));
		// store.setGrade(grade);
		// store.setGc_main_id(CommUtil.null2Long(gc_main_id_clone));
		// store.setValidity(CommUtil.formatDate(validity));
		// // if (gc_detail_ids != null && !gc_detail_ids.equals("")) {
		// // String[] gc_detail = gc_detail_ids.split(",");
		// // Map map = new HashMap();
		// // for (int i = 0; i < gc_detail.length; i++) {
		// // map.put("id" + i, gc_detail[i]);
		// // }
		// // System.out.println(Json.toJson(map,
		// // JsonFormat.compact()));
		// // store.setGc_detail_info(Json.toJson(map,
		// // JsonFormat.compact()));
		// // }
		// store.setGc_detail_info(gc_detail_info);
		// this.storeService.save(store);
		// if (store.getPoint() == null) {
		// StorePoint sp = new StorePoint();
		// sp.setAddTime(new Date());
		// sp.setStore(store);
		// sp.setStore_evaluate(BigDecimal.valueOf(0));
		// sp.setDescription_evaluate(BigDecimal.valueOf(0));
		// sp.setService_evaluate(BigDecimal.valueOf(0));
		// sp.setShip_evaluate(BigDecimal.valueOf(0));
		// this.storePointService.save(sp);
		// }
		// }
		// String store_user_id = CommUtil.null2String(store.getUser()
		// .getId());
		// if (store_user_id != null && !store_user_id.equals("")) {
		// User store_user = this.userService.getObjById(Long
		// .parseLong(store_user_id));
		// store_user.setStore(store);
		// if (!store_user.getUserRole().equalsIgnoreCase("admin")) {//
		// 非admin该表用户为seller角色
		// store_user.setUserRole("SELLER");
		// } else {
		// store_user.setUserRole("ADMIN_SELLER");
		// }
		// // 给用户赋予卖家权限
		// Map params = new HashMap();
		// params.put("type", "SELLER");
		// List<Role> roles = this.roleService.query(
		// "select obj from Role obj where obj.type=:type",
		// params, -1, -1);
		// for (Role role : roles) {
		// store_user.getRoles().add(role);
		// }
		// store_user.getRoles().addAll(roles);
		// this.userService.update(store_user);
		// if (store.getStore_start_time() == null) {// 开店时间为空，意味着入驻审核通过，成功开店
		// store.setStore_start_time(new Date());
		// this.send_site_msg(request,
		// "msg_toseller_store_update_allow_notify", store);
		// }
		// }
		// store.setStore_status(CommUtil.null2Int(store_status));
		// } else if (store_status.equals("20")) {// 关闭违规店铺发送站内信提醒
		// store.setStore_status(CommUtil.null2Int(store_status));
		// if (!id.equals("") && store.getStore_status() == 20) {
		// this.send_site_msg(request,
		// "msg_toseller_store_closed_notify", store);
		// }
		// }
		// }
		// if (store.isStore_recommend()) {
		// store.setStore_recommend_time(new Date());
		// } else
		// store.setStore_recommend_time(null);
		// this.storeService.update(store);
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存店铺成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url);
		}
		return mv;
	}

	// private void send_site_msg(HttpServletRequest request, String mark,
	// Store store) throws Exception {
	// Template template = this.templateService.getObjByProperty(null, "mark",
	// mark);
	// if (template != null && template.isOpen()) {
	// if (store.getUser() != null) {
	// ExpressionParser exp = new SpelExpressionParser();
	// EvaluationContext context = new StandardEvaluationContext();
	// context.setVariable("reason", store.getViolation_reseaon());
	// context.setVariable("user", store.getUser());
	// context.setVariable("store", store);
	// context.setVariable("config", this.configService.getSysConfig());
	// context.setVariable("send_time",
	// CommUtil.formatLongDate(new Date()));
	// Expression ex = exp.parseExpression(template.getContent(),
	// new SpelTemplate());
	// String content = ex.getValue(context, String.class);
	// Map params = new HashMap();
	// params.put("userName", "admin");
	// params.put("userRole", "ADMIN");
	// List<User> fromUsers = this.userService
	// .query("select obj from User obj where obj.userName=:userName and obj.userRole=:userRole",
	// params, -0, 1);
	// if (fromUsers.size() > 0) {
	// Message msg = new Message();
	// msg.setAddTime(new Date());
	// msg.setContent(content);
	// msg.setFromUser(fromUsers.get(0));
	// msg.setTitle(template.getTitle());
	// msg.setToUser(store.getUser());
	// msg.setType(0);
	// this.messageService.save(msg);
	// }
	// }
	// }
	// }
	//
	// @SecurityMapping(title = "店铺删除", value = "/admin/store_del.htm*", rtype =
	// "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup = "店铺")
	// @RequestMapping("/admin/store_del.htm")
	// public String store_del(HttpServletRequest request, String mulitId)
	// throws Exception {
	// String[] ids = mulitId.split(",");
	// for (String id : ids) {
	// if (!id.equals("")) {
	// Store store = this.storeService.getObjById(CommUtil
	// .null2Long(id));
	// Map params = new HashMap();
	// if (store.getUser() != null) {
	// store.getUser().setStore(null);
	// User user = store.getUser();
	// if (user != null) {
	// Set<Role> roles = user.getRoles();
	// Set<Role> new_roles = new HashSet<Role>();
	// for (Role role : roles) {
	// if (!role.getType().equals("SELLER")) {
	// new_roles.add(role);
	// }
	// }
	// user.getRoles().clear();// 清除所有权限，重新添加不含商家的权限信息
	// user.getRoles().addAll(new_roles);//
	// user.setStore_apply_step(0);
	// this.userService.update(user);
	// for (User u : user.getChilds()) {// 清除子账户所有权限信息
	// roles = u.getRoles();
	// Set<Role> new_roles2 = new HashSet<Role>();
	// for (Role role : roles) {
	// if (!role.getType().equals("SELLER")) {
	// new_roles2.add(role);
	// }
	// }
	// u.getRoles().clear();// 清除所有权限，重新添加不含商家的权限信息
	// u.getRoles().addAll(new_roles2);//
	// u.setStore_apply_step(0);
	// this.userService.update(u);
	// }
	// }
	// params.clear();// 删除商家优惠券
	// params.put("store_id", store.getId());
	// List<Coupon> coupons = this.couponService
	// .query("select obj from Coupon obj where obj.store.id=:store_id",
	// params, -1, -1);
	// for (Coupon coupon : coupons) {
	// for (CouponInfo couponInfo : coupon.getCouponinfos()) {
	// this.couponInfoService.delete(couponInfo.getId());
	// }
	// this.couponService.delete(coupon.getId());
	// }
	//
	// for (GoldRecord gr : user.getGold_record()) {// 商家充值记录
	// this.grService.delete(gr.getId());
	// }
	// params.clear();
	// params.put("uid", user.getId());
	// List<GoldLog> gls = this.glService
	// .query("select obj from GoldLog obj where obj.gl_user.id=:uid",
	// params, -1, -1);
	// for (GoldLog gl : gls) {
	// this.glService.delete(gl.getId());
	// }
	// for (GoldRecord gr : user.getGold_record()) {
	// this.grService.delete(gr.getId());
	// }
	// for (GroupLifeGoods glg : user.getGrouplifegoods()) {// 商家发布的生活购
	// for (GroupInfo gi : glg.getGroupInfos()) {
	// this.groupinfoService.delete(gi.getId());
	// }
	// glg.getGroupInfos().removeAll(glg.getGroupInfos());
	// this.grouplifegoodsService.delete(CommUtil
	// .null2Long(glg.getId()));
	// }
	// for (PayoffLog log : user.getPaylogs()) {// 商家结算日志
	// this.paylogService.delete(log.getId());
	// }
	// for (Album album : user.getAlbums()) {// 商家相册删除
	// album.setAlbum_cover(null);
	// this.albumService.update(album);
	// params.clear();
	// params.put("album_id", album.getId());
	// List<Accessory> accs = this.accessoryService
	// .query("select obj from Accessory obj where obj.album_id=:album_id",
	// params, -1, -1);
	// for (Accessory acc : accs) {
	// CommUtil.del_acc(request, acc);
	// this.accessoryService.delete(acc.getId());
	// }
	// this.albumService.delete(album.getId());
	// }
	// }
	// for (Goods goods : store.getGoods_list()) {// 店铺内的商品
	// goods.setGoods_main_photo(null);
	// goods.setGoods_brand(null);
	// this.goodsService.update(goods);
	// goods.getGoods_photos().clear();
	// goods.getGoods_specs().clear();
	// goods.getGoods_ugcs().clear();
	// }
	// for (Goods goods : store.getGoods_list()) {// 删除店铺内的商品
	// for (GoodsCart gc : goods.getCarts()) {
	// this.goodsCartService.delete(gc.getId());
	// }
	// List<Evaluate> evaluates = goods.getEvaluates();
	// for (Evaluate e : evaluates) {
	// this.evaluateService.delete(e.getId());
	// }
	// for (ComplaintGoods cg : goods.getCgs()) {
	// this.complaintGoodsService.delete(cg.getId());
	// }
	// goods.getCarts().removeAll(goods.getCarts());// 移除对象中的购物车
	// goods.getEvaluates().removeAll(goods.getEvaluates());
	// goods.getCgs().removeAll(goods.getCgs());
	// params.clear();// 直通车商品记录
	// params.put("gid", goods.getId());
	// List<ZTCGoldLog> ztcgls = this.ztcglService
	// .query("select obj from ZTCGoldLog obj where obj.zgl_goods_id=:gid",
	// params, -1, -1);
	// for (ZTCGoldLog ztc : ztcgls) {
	// this.ztcglService.delete(ztc.getId());
	// }
	// this.goodsService.delete(goods.getId());
	// }
	// store.getGoods_list().removeAll(store.getGoods_list());
	//
	// for (GoodsSpecification spec : store.getSpecs()) {// 店铺规格
	// for (GoodsSpecProperty pro : spec.getProperties()) {
	// this.specpropertyService.delete(pro.getId());
	// }
	// spec.getProperties().removeAll(spec.getProperties());
	// }
	// String path = request.getSession().getServletContext()
	// .getRealPath("/")
	// + this.configService.getSysConfig().getUploadFilePath()
	// + File.separator
	// + "store"
	// + File.separator
	// + store.getId();
	// CommUtil.deleteFolder(path);
	// //删除店铺之前删除店铺的水印
	// params.clear();
	// params.put("sid", CommUtil.null2Long(id));
	// List<WaterMark> wm = this.waterMarkService
	// .query("select obj from WaterMark obj where obj.store.id=:sid",
	// params, 0, 1);
	// if(wm.size()>0){
	// this.waterMarkService.delete(wm.get(0).getId());
	// }
	// this.storeService.delete(CommUtil.null2Long(id));
	// this.send_site_msg(request, "msg_toseller_store_delete_notify",
	// store);
	// }
	// }
	// return "redirect:store_list.htm";
	// }
	//
	// @SecurityMapping(title = "店铺AJAX更新", value = "/admin/store_ajax.htm*",
	// rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup =
	// "店铺")
	// @RequestMapping("/admin/store_ajax.htm")
	// public void store_ajax(HttpServletRequest request,
	// HttpServletResponse response, String id, String fieldName,
	// String value) throws ClassNotFoundException {
	// Store obj = this.storeService.getObjById(Long.parseLong(id));
	// Field[] fields = Store.class.getDeclaredFields();
	// BeanWrapper wrapper = new BeanWrapper(obj);
	// Object val = null;
	// for (Field field : fields) {
	// // System.out.println(field.getName());
	// if (field.getName().equals(fieldName)) {
	// Class clz = Class.forName("java.lang.String");
	// if (field.getType().getName().equals("int")) {
	// clz = Class.forName("java.lang.Integer");
	// }
	// if (field.getType().getName().equals("boolean")) {
	// clz = Class.forName("java.lang.Boolean");
	// }
	// if (!value.equals("")) {
	// val = BeanUtils.convertType(value, clz);
	// } else {
	// val = !CommUtil.null2Boolean(wrapper
	// .getPropertyValue(fieldName));
	// }
	// wrapper.setPropertyValue(fieldName, val);
	// }
	// }
	// if (fieldName.equals("store_recommend")) {
	// if (obj.isStore_recommend()) {
	// obj.setStore_recommend_time(new Date());
	// } else {
	// obj.setStore_recommend_time(null);
	// }
	// }
	// this.storeService.update(obj);
	// response.setContentType("text/plain");
	// response.setHeader("Cache-Control", "no-cache");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter writer;
	// try {
	// writer = response.getWriter();
	// writer.print(val.toString());
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	//
	@SecurityMapping(title = "入驻管理", value = "/admin/store_base.htm*", rtype = "admin", rname = "入驻管理", rcode = "admin_store_base", rgroup = "商户管理")
	@RequestMapping("/admin/store_base.htm")
	public ModelAndView store_base(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/store_base_set.html", configService.getSysConfig(),
		/* this.userConfigService.getUserConfig(), */0, request, response);
		return mv;
	}

	@SecurityMapping(title = "店铺设置保存", value = "/admin/store_set_save.htm*", rtype = "admin", rname = "入驻管理", rcode = "admin_store_base", rgroup = "商户管理")
	@RequestMapping("/admin/store_set_save.htm")
	public ModelAndView store_set_save(HttpServletRequest request, HttpServletResponse response, String id,
			String list_url, String store_allow) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(),
		/* this.userConfigService.getUserConfig(), */0, request, response);
		SysConfig sc = this.configService.getSysConfig();
		sc.setStoreAllow(CommUtil.null2Boolean(store_allow));
		if (id.equals("")) {
			this.configService.save(sc);
		} else
			this.configService.update(sc);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存店铺设置成功");
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unused"})
	@SecurityMapping(title = "开店申请Ajax更新", value = "/admin/store_base_ajax.htm*", rtype = "admin", rname = "入驻管理", rcode = "admin_store_base", rgroup = "商户管理")
	@RequestMapping("/admin/store_base_ajax.htm")
	public void integral_goods_ajax(HttpServletRequest request, HttpServletResponse response, String fieldName)
			throws ClassNotFoundException {
		SysConfig sc = this.configService.getSysConfig();
		Field[] fields = SysConfig.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(sc);
		Object val = null;
		for (Field field : fields) {
			if (field.getName().equals(fieldName)) {
				Class clz = Class.forName("java.lang.Boolean");
				val = !CommUtil.null2Boolean(wrapper.getPropertyValue(fieldName));
				wrapper.setPropertyValue(fieldName, val);
				break;
			}
		}
		this.configService.update(sc);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(val.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// // 店铺模板管理
	// // @SecurityMapping(title = "店铺模板", value = "/admin/store_template.htm*",
	// // rtype = "admin", rname = "店铺模板", rcode = "admin_store_template",
	// rgroup =
	// // "店铺")
	// // @RequestMapping("/admin/store_template.htm")
	// public ModelAndView store_template(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView mv = new JModelAndView("admin/blue/store_template.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 0, request, response);
	// mv.addObject("path", request.getSession().getServletContext()
	// .getRealPath("/"));
	// mv.addObject("separator", File.separator);
	// return mv;
	// }

	@SecurityMapping(title = "等级限制时可选的类目", value = "/admin/sg_limit_gc.htm*", rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup = "商户管理")
	@RequestMapping("/admin/sg_limit_gc.htm")
	public void storeGrade_limit_goodsClass(HttpServletRequest request, HttpServletResponse response,
			String storeGrade_id, String goodsClass_id) {
		String jsonList = "";
		StoreGrade storeGrade = this.storeGradeService.getObjById(CommUtil.null2Long(storeGrade_id));
		if (storeGrade != null && !storeGrade.getMainLimit().equals(StoreConstants.STORE_MAIN_CLASS_NO_LIMIT)) { // 非旗舰店的情况，有限制主营类目
			GoodsClass goodsClass = this.goodsclassService.getObjById(CommUtil.null2Long(goodsClass_id));
			if (goodsClass != null) {
				List<Map<String, String>> gcList = new ArrayList<Map<String, String>>();
				List<GoodsClassBO> childsList = new ArrayList<GoodsClassBO>();
				childsList = this.goodsclassService.findByParent(goodsClass.getId());
				for (GoodsClassBO gc : childsList) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("gc_id", gc.getId().toString());
					map.put("gc_name", gc.getClassName());
					gcList.add(map);
				}
				jsonList = Json.toJson(gcList, JsonFormat.compact());
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(jsonList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@SecurityMapping(title = "新增详细经营类目", value = "/admin/add_gc_detail.htm*", rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup = "商户管理")
	@RequestMapping("/admin/add_gc_detail.htm")
	public ModelAndView addStore_GoodsClass_detail(HttpServletRequest request, HttpServletResponse response,
			String did, String gc_detail_info) {
		ModelAndView mv = new JModelAndView("admin/blue/store_detailgc_ajax.html",
				configService.getSysConfig(), 0, request, response);
		GoodsClassBO gc = this.goodsclassService.getBOWithParentById(CommUtil.null2Long(did));
		List<Map> list = null;// 用于转换成店铺中的详细经营类目json
		if (gc != null && gc.getParentId() != null && gc.getParentId() > 0) {
			if (gc_detail_info != null && !gc_detail_info.equals("")) {
				if (storeTools.query_MainGc_Map(gc.getParentId().toString(), gc_detail_info) == null) {// 不在一个大分类下
					list = Json.fromJson(ArrayList.class, gc_detail_info);
					List<Integer> gc_list = new ArrayList();
					Map map = new HashMap();
					gc_list.add(CommUtil.null2Int(did));
					map.put("gc_list", gc_list);
					map.put("m_id", gc.getParentId());
					list.add(map);
					String listJson = Json.toJson(list, JsonFormat.compact());
					mv.addObject("gc_detail_info", listJson);
					mv.addObject("gcs", storeTools.query_store_DetailGc(listJson));
				} else {// 在一个大分类下
					List<Map> oldList = Json.fromJson(ArrayList.class, gc_detail_info);
					list = new ArrayList<Map>();
					for (Map map : oldList) {
						if (CommUtil.null2Long(map.get("m_id")).equals(gc.getParentId())) {
							List<Integer> gc_list = (List<Integer>) map.get("gc_list");
							gc_list.add(CommUtil.null2Int(did));
							Map map2 = new HashMap();
							HashSet set = new HashSet(gc_list);
							gc_list = new ArrayList<Integer>(set);
							map2.put("gc_list", gc_list);
							map2.put("m_id", gc.getParentId());	
							list.add(map2);
						} else {
							list.add(map);
						}
					}
					String listJson = Json.toJson(list, JsonFormat.compact());
					mv.addObject("gc_detail_info", listJson);
					mv.addObject("gcs", storeTools.query_store_DetailGc(listJson));
				}
			} else {
				list = new ArrayList<Map>();
				Map map = new HashMap();
				List<Integer> gc_list = new ArrayList();
				gc_list.add(CommUtil.null2Int(did));
				map.put("gc_list", gc_list);
				map.put("m_id", gc.getParentId());
				list.add(map);
				String listJson = Json.toJson(list, JsonFormat.compact());
				mv.addObject("gc_detail_info", listJson);
				Set<GoodsClass> gcSet = storeTools.query_store_DetailGc(listJson);
				mv.addObject("gcs", gcSet);
			}
		}
		return mv;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@SecurityMapping(title = "删除详细经营类目", value = "/admin/del_gc_detail.htm*", rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup = "商户管理")
	@RequestMapping("/admin/del_gc_detail.htm")
	public ModelAndView delStore_GoodsClass_detail(HttpServletRequest request, HttpServletResponse response,
			String did, String gc_detail_info) {
		ModelAndView mv = new JModelAndView("admin/blue/store_detailgc_ajax.html",
				configService.getSysConfig(), 0, request, response);
		GoodsClass gc = this.goodsclassService.getObjById(CommUtil.null2Long(did));
		if (gc_detail_info != null && !gc_detail_info.equals("") && gc != null) {
			Long parentId = gc.getParentId();
			GoodsClass parentGc = this.goodsclassService.getObjById(parentId);
			String parentName = parentGc.getClassName();
			mv.addObject("parentName", parentName);
			List<Map> oldList = Json.fromJson(ArrayList.class, gc_detail_info);
			List<Map> list = new ArrayList<Map>();
			for (Map oldMap : oldList) {
				if (!CommUtil.null2Long(oldMap.get("m_id")).equals(parentId)) {
					list.add(oldMap);
				} else {
					List<Integer> gc_list = (List<Integer>) oldMap.get("gc_list");
					for (Integer integer : gc_list) {
						if (integer.equals(CommUtil.null2Int(did))) {
							gc_list.remove(integer);
							break;
						}
					}
					if (gc_list.size() > 0) {
						Map map = new HashMap();
						map.put("gc_list", gc_list);
						map.put("m_id", parentId);
						list.add(oldMap);
					}
				}
			}
			if (list.size() > 0) {
				String listJson = Json.toJson(list, JsonFormat.compact());
				mv.addObject("gc_detail_info", listJson);
				Set<GoodsClass> gcSet = storeTools.query_store_DetailGc(listJson);
				mv.addObject("gcs", gcSet);
			}
		}

		return mv;
	}

	@SecurityMapping(title = "店铺申请列表", value = "/admin/store_listCheck.htm*", rtype = "admin", rname = "店铺审核", rcode = "admin_store_set", rgroup = "商户管理")
	@RequestMapping("/admin/store_listCheck.htm")
	public ModelAndView store_list_check(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<StoreBO> page, StoreVO vo) {

		ModelAndView mv = new JModelAndView("admin/blue/store_list_check.html", configService.getSysConfig(),
				0, request, response);
		vo.setIsShop(true);

		this.storeService.findPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		List<StoreGradeBO> grades = this.storeGradeService.findList();
		List<GoodsClassBO> gcs = this.goodsclassService.findLevelAll();

		mv.addObject("grades", grades);
		mv.addObject("gcs", gcs);
		mv.addObject("vo", vo);

		return mv;
	}

	@SecurityMapping(title = "审核店铺公司信息查看", value = "/admin/store_companyCheck.htm*", rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup = "商户管理")
	@RequestMapping("/admin/store_companyCheck.htm")
	public ModelAndView store_companyCheck(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/store_company_check.html",
				configService.getSysConfig(),
				/* this.userConfigService.getUserConfig(), */0, request, response);
		List<StoreGradeBO> grades = this.storeGradeService.findList();
		
		StoreBO store = this.storeService.getObjById(CommUtil.null2Long(id));
		Set<GroupClass> groupClassDetailSet = this.storeTools.queryStoreDetailInfo(store.getGroupDetailInfo());
		GoodsClass gc = this.goodsclassService.getObjById(CommUtil.null2Long(store.getGcMainId()));
		List<GoodsClassBO> gcs = this.goodsclassService.findLevelAll();
		mv.addObject("groupClass_main", gc);
		mv.addObject("groupClassDetail", groupClassDetailSet);
		mv.addObject("gcs", gcs);
		mv.addObject("grades", grades);
		mv.addObject("store", store);

		
		return mv;
	}
	/***
	 * 总后台供应商资料需可以编辑修改
	 * 
	 * @return
	 */
	@SecurityMapping(title = "供应商信息填写", value = "/admin/supplier_save.htm*", rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup = "商户管理")
	@RequestMapping(value = "/admin/supplier_save.htm", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView supplier_save(HttpServletRequest request, HttpServletResponse response,
			StoreApplyVO applyVO, Long storeId) {
		ModelAndView mv = new JModelAndView("admin/blue/store_list_check.html", configService.getSysConfig(),
				0, request, response);
		if (storeId != null) {
			try {
				Seller seller = sellerService.findByStore(storeId);
				Long uid = seller.getUid();
				this.storeService.supplierUpdate(applyVO, storeId, uid);
			} catch (ServiceException e) {
				e.printStackTrace();
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", e.getErrorCode());
				return mv;
			}
		}
		StoreVO vo = new StoreVO();
		MyPage<StoreBO> page = new MyPage<>();
		return store_list_check(request, response, null, page, vo);
	}

	/***
	 * 
	 * 供应商审核
	 * 
	 * @param request
	 * @param response
	 * @param StoreId
	 * @param failReseaon
	 * @param storeStauts
	 * @return
	 */

	@RequestMapping("/admin/store_approve.htm")
	public String store_approve_return(HttpServletRequest request, HttpServletResponse response,
			Long storeId, String failReseaon, Integer storeStauts, Long gradeId, StoreApplyVO applyVO) {
		StoreVO storeVo = new StoreVO();
		StoreApplyInfoVO applyInfoVO = new StoreApplyInfoVO();

		// 保存信息
//		StoreApplyInfo res = storeService.supplierSaveService(user.getName(), applyVO, 0L, storeId);
		// 审核流程
		if (StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS == storeStauts) {
			storeVo.setStoreStatus(StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS);
			this.storeService.checkStoreSaveUserOwns(storeId);
			System.out.println("111111111111111");
		}
		if (StoreConstants.STORE_STATUS_SYS_AUDIT_FAIL == storeStauts) {
			storeVo.setStoreStatus(StoreConstants.STORE_STATUS_SYS_AUDIT_FAIL);
		}
		storeVo.setGradeId(gradeId);
		storeVo.setId(storeId);
		System.out.println("22222222222222222222");
		this.storeService.update(storeVo);
		System.out.println("33333333333333333333333333");
		applyInfoVO.setFailReseaon(failReseaon);
		applyInfoVO.setStoreId(storeId);
		System.out.println("444444444444444444444444444444");
		this.storeService.update(applyInfoVO);
		System.out.println("555555555555555555555555555555");

		return "redirect:store_listCheck.htm";
	}

}
