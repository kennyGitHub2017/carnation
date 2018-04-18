package vc.thinker.b2b2c.action.seller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jfree.util.Log;
import org.jsoup.helper.StringUtil;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.qrcode.QRCodeUtil;
import vc.thinker.b2b2c.core.security.SecurityManager;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.goods.vo.GoodsShowListVO;
import com.sinco.carnation.notice.service.OperatorNoticesService;
import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupInfoVO;
import com.sinco.carnation.o2o.vo.GroupOrderVO;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderViewTools;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.pay.service.PredepositCashService;
import com.sinco.carnation.pay.service.PredepositLogService;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.bo.PredepositLogBO;
import com.sinco.carnation.shop.service.ComplaintService;
import com.sinco.carnation.shop.service.ConsultService;
import com.sinco.carnation.sns.bo.OperatorNoticesBO;
import com.sinco.carnation.sns.vo.OperatorNoticesVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.tools.StoreViewTools;
import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.bo.orcl.CnUserMoneyBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.ImageViewTools;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.StatisticsService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.tools.MenuTools;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: BaseSellerAction.java
 * </p>
 * 
 * <p>
 * Description: 商家后台基础管理器 主要功能包括商家后台的基础管理、快捷菜单设置等
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
 * @date 2014-6-10
 * 
 * 
 * @version 1.0.1
 */
@Controller
public class BaseSellerAction implements ServletContextAware {

	@SuppressWarnings("unused")
	private ServletContext servletContext;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserService userService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private SecurityManager securityManager;
	@Autowired
	private MessageService messageService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private StoreViewTools storeViewTools;
	@Autowired
	private OrderViewTools orderViewTools;
//	@Autowired
//	private AreaViewTools areaViewTools;
	@Autowired
	private PayoffLogService payofflogService;
	@Autowired
	private ReturnGoodsLogService returngoodslogService;
	@Autowired
	private OrderFormService orderformService;
	@Autowired
	private ComplaintService complaintService;
	@Autowired
	private MenuTools menuTools;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private ConsultService consultService;
	@Autowired
	private ImageViewTools imageViewTools;
	@Autowired
	private GroupGoodsService groupGoodsService;
	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private GroupInfoService groupInfoService;
	@Autowired
	private OperatorNoticesService operatorNoticesService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private OperatorService operatorService;

	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private GroupClassService groupClassService;
	@Autowired
	private GoodsClassService goodsclassService;
	@Autowired
	private UserMoneyService userMoneyService;
	@Autowired
	private UserAccountService accountService;

	@Autowired
	private RedisCacheService redisCacheService;
	@Autowired
	private PredepositCashService predepositCashService;
	@Autowired
	private StatisticsService statisticsService;
	@Autowired
	private PredepositLogService predepositLogService;
	@Autowired
	private CnPayBaseService cnPayBaseService;

	private static final Logger log = LoggerFactory.getLogger(BaseSellerAction.class);

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	/**
	 * 商家后台顶部
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "商家中心", value = "/seller/top.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/top.htm")
	public ModelAndView top(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_top.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		mv.addObject("userName", userDetails.getUsername());

		StoreBO store = storeService.getObjById(userDetails.getStoreId());
		if (store != null) {
			mv.addObject("isO2o", store.getIsO2o());
			mv.addObject("isShop", store.getIsShop());
		}

		return mv;
	}

	/**
	 * 商家中心首页，该请求受系统ss权限管理，对应角色名为"商家中心",商家中心添加子账户时默认添加“商家中心”权限，“ user_center_seller”不可更改
	 * 
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商家中心", value = "/seller/index.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/index.htm")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = null; 
		mv = new JModelAndView("user/default/sellercenter/seller_index.html",
				configService.getSysConfig(), 0, request, response);
		
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (userDetails.getStoreId() != null) {
			store = storeService.getObjById(userDetails.getStoreId());
		}

		if (store.getIsShop()) {

			if (UserContant.USER_TYPE_10.equals(userDetails.getUser().getUserType())) { // 是云购币专用会员
				// mv = new JModelAndView("user/default/sellercenter/seller_yungou_index.html",
				// configService.getSysConfig(), 0, request, response);
			}

			GoodsShowListVO vo = new GoodsShowListVO();
			vo.setGoodsStoreId(userDetails.getSeller().getStoreId());
			vo.setGoodsStatus(0);
			vo.setOrderBy("goods_salenum");
			vo.setOrderType("desc");
			vo.setCount(10);
			List<GoodsBO> goods_sale_list = this.goodsService.findShopListBO(vo);

			// 商品退货
			int returnGoodsCount = this.returngoodslogService.selectCountByStatus(userDetails.getSeller()
					.getStoreId(), "5");
			// 出售中的商品 仓库中的商品 违规下架的商品数量
			Map<Integer, Integer> goodsCountMap = goodsService.findCountByStoreId(userDetails.getSeller()
					.getStoreId());
			mv.addObject("goodsCountMap", goodsCountMap);
			mv.addObject("returnGoodsCount", returnGoodsCount);
			mv.addObject("goods_sale_list", goods_sale_list);

			// 库存不足的商品
			int warnGoodsCount = goodsService.findCountWarnGoods(userDetails.getSeller().getStoreId());
			mv.addObject("warnGoodsCount", warnGoodsCount);
			// 商品投诉
			Map<Integer, Integer> complaintCountMap = complaintService.findCountByToUserId(userDetails
					.getId());
			mv.addObject("complaintCountMap", complaintCountMap);
		}

		if (store.getIsO2o()) {
			
			if (StringUtil.isBlank(store.getStoreName())
					|| StringUtil.isBlank(store.getStoreLogoPath())
					|| StringUtil.isBlank(store.getStoreCoverPath())
					|| StringUtil.isBlank(store.getMobile())) {
				try {
					response.sendRedirect(CommUtil.getURL(request) + "/seller/store_set.htm");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			List<GroupGoods> group_list = groupGoodsService.findTopByStoreId(store.getId());
			// 服务退款
			MyPage<GroupInfoBO> page1 = new MyPage<GroupInfoBO>();
			GroupInfoVO gv = new GroupInfoVO();
			gv.setStoreId(userDetails.getSeller().getStoreId());
			List<GroupInfoBO> returnGroups = groupInfoService.findPageByStoreId(page1, gv);

			// 服务订单
			MyPage<GroupOrderBO> page = new MyPage<GroupOrderBO>();
			GroupOrderVO ov = new GroupOrderVO();
			ov.setStoreId(userDetails.getSeller().getStoreId());
			ov.setOrderType(1);
			List<GroupOrderBO> groupOrders = this.groupOrderService.findPageByVo(page, ov);
			Map<Integer, Integer> groupCountMap = groupGoodsService.findCountByStoreId(userDetails
					.getSeller().getStoreId());
			mv.addObject("groupOrders", groupOrders);
			mv.addObject("groupCountMap", groupCountMap);
			mv.addObject("returnGroupCount", returnGroups.size());
			mv.addObject("group_list", group_list);

			// 库存不足的服务
			int warnGroupCount = groupGoodsService.findCountWarnGoods(userDetails.getSeller().getStoreId());
			mv.addObject("warnGroupCount", warnGroupCount);
			// 运营商公告列表
			OperatorNoticesVO noticeVo = new OperatorNoticesVO();
			// noticeVo.setOperatorId();
			MyPage<OperatorNoticesBO> noticePage = new MyPage<OperatorNoticesBO>();
			noticePage.setPageSize(5);
			if (store.getAreaId() != null) {
				Area area = areaService.fetchAndAllParent(store.getAreaId());
				if (area != null) {
					Area parent = area.getParent();
					if (parent != null) {
						List<OperatorBO> operators = operatorService.getOperatorBOByOperatorAreaId(parent
								.getId() + "");
						if (operators != null && operators.size() > 0) {
							OperatorBO operator = operators.get(0);
							noticeVo.setOperatorId(operator.getId());
							noticeVo.setNtStatus(1);
							List<OperatorNoticesBO> operatorNotices = operatorNoticesService.findPageByVO(
									noticeVo, noticePage).getContent();
							mv.addObject("operatorNotices", operatorNotices);
						}
					}
				}
			}

			// 服务商平台公告
			MyPage<ArticleBO> articlePage = new MyPage<ArticleBO>();
			articlePage.setPageSize(5);
			articleService.findByParentMark("o2osellernotice", articlePage);
			mv.addObject("listArticles", articlePage.getContent());
		} else {
			// 店铺平台公告
			MyPage<ArticleBO> articlePage = new MyPage<ArticleBO>();
			articlePage.setPageSize(5);
			articleService.findByParentMark("sellernotice", articlePage);
			mv.addObject("listArticles", articlePage.getContent());
		}

//		int msgsCount = this.consultService.selectCountByRepayAndStoreId(false, userDetails.getSeller().getStoreId());
//		int complaintsCount = this.complaintService.findCountByStatusAndToUserId(0, userDetails.getUser().getId());
//		mv.addObject("complaintsCount", complaintsCount);
//		mv.addObject("msgs", msgsCount);

		List<OrderFormBO> orders = this.orderformService.selectOrderFormByStoreId(CommUtil
				.null2String(userDetails.getSeller().getStoreId()));
		UserAccountBO userAccount = userAccountService.findLastLogin(userDetails.getSeller().getUid());

		mv.addObject("userAccount", userAccount);
		mv.addObject("orders", orders);
//		mv.addObject("articles", articles);
		mv.addObject("user", userDetails.getSeller());
		mv.addObject("store", store);
//		mv.addObject("func_articles", func_articles);
		mv.addObject("storeViewTools", storeViewTools);
		mv.addObject("orderViewTools", orderViewTools);
		mv.addObject("menuTools", menuTools);
		return mv;
	}

	@SecurityMapping(title = "商家中心导航", value = "/seller/nav.htm*", rtype = "seller", rname = "商家中心导航", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/nav.htm")
	public ModelAndView nav(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_nav.html",
				configService.getSysConfig(), 0, request, response);
		String op = CommUtil.null2String(request.getAttribute("op"));

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		SellerBO seller = userDetails.getSeller();
		//StoreBO store = storeService.getObjById(userDetails.getStoreId());
		StoreBO store = this.storeService.getStoreStatus(userDetails.getStoreId());
		boolean isCN = false;
		if (userAccountService.findByUid(seller.getUid(), UserContant.ACCOUNT_TYPE_8) != null) {
			isCN = true;
		}
		mv.addObject("isCN", isCN);
		mv.addObject("op", op);
		mv.addObject("user", seller);
		mv.addObject("store", store);
		if (store != null) {
			int store_status = store.getStoreStatus();
			if (store_status != StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS) {
				mv.addObject("limit", true);
			}
			mv.addObject("isO2o", store.getIsO2o());
			mv.addObject("isShop", store.getIsShop());
		}
		if (UserContant.USER_TYPE_10.equals(userDetails.getUser().getUserType())) { // 增加usertype=10标识
			mv.addObject("userType", 10);
		}
		return mv;
	}

	/**
	 * 查看云尚平台公告
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "云尚平台公告详情", value = "/seller/articles_view.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/articles_view.htm")
	public ModelAndView articlesView(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/articles_view.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotEmpty(id)) {
			Article bo = this.articleService.getObjById(CommUtil.null2Long(id));
			mv.addObject("obj", bo);
		}
		return mv;
	}

	/**
	 * 查看云尚平台公告列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "云尚公告列表", value = "/seller/articles_list.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/articles_list.htm")
	public ModelAndView articlesList(HttpServletRequest request, HttpServletResponse response,
			MyPage<ArticleBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/articles_list.html",
				configService.getSysConfig(), 0, request, response);

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (userDetails.getStoreId() != null) {
			store = storeService.getObjById(userDetails.getStoreId());
		}
		if (store != null) {
			if (store.getIsO2o()) {
				this.articleService.findByParentMark("o2osellernotice", page);
			} else {
				this.articleService.findByParentMark("sellernotice", page);
			}
			CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		}
		return mv;
	}

	/**
	 * 查看运营商公告
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "运营商公告详情", value = "/seller/notice_view.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/notice_view.htm")
	public ModelAndView notice_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/operator_notice.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotEmpty(id)) {
			OperatorNoticesBO bo = operatorNoticesService.getBoById(CommUtil.null2Long(id));
			mv.addObject("obj", bo);
		}
		return mv;
	}

	/**
	 * 查看运营商公告
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "运营商公告列表", value = "/seller/notice_list.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/notice_list.htm")
	public ModelAndView notice_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<OperatorNoticesBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/operator_notice_list.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (userDetails.getStoreId() != null) {
			store = storeService.getObjById(userDetails.getStoreId());
		}
		if (store != null) {
			// 运营商公告列表
			OperatorNoticesVO noticeVo = new OperatorNoticesVO();
			// noticeVo.setOperatorId();
			if (store.getAreaId() != null) {
				Area area = areaService.fetchAndAllParent(store.getAreaId());
				if (area != null) {
					Area parent = area.getParent();
					if (parent != null) {
						List<OperatorBO> operators = operatorService.getOperatorBOByOperatorAreaId(parent
								.getId() + "");
						if (operators != null && operators.size() > 0) {
							OperatorBO operator = operators.get(0);
							noticeVo.setOperatorId(operator.getId());
							noticeVo.setNtStatus(1);
							operatorNoticesService.findPageByVO(noticeVo, page);
						}
					}
				}
			}
		}
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "商家中心快捷功能设置保存", value = "/seller/store_quick_menu_save.htm*", rtype = "seller", rname = "商家中心快捷功能设置保存", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/store_quick_menu_save.htm")
	public void store_quick_menu_save(HttpServletRequest request, HttpServletResponse response, String menus) {
		String[] menu_navs = menus.split(";");
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		Store store = new Store();
		store.setId(userDetails.getStoreId());

		List<Map> list = new ArrayList<Map>();
		for (String menu_nav : menu_navs) {
			if (!menu_nav.equals("")) {
				String[] infos = menu_nav.split(",");
				Map map = new HashMap();
				map.put("menu_name", infos[0]);
				map.put("menu_url", infos[1]);
				list.add(map);
			}
		}
		store.setStoreQuickMenu(Json.toJson(list, JsonFormat.compact()));
		this.storeService.update(store);
		String ret = Json.toJson(list, JsonFormat.compact());
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 商家后台操作成功提示页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/seller/success.htm")
	public ModelAndView success(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_success.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("op_title", request.getSession(false).getAttribute("op_title"));
		mv.addObject("url", request.getSession(false).getAttribute("url"));
		request.getSession(false).removeAttribute("op_title");
		request.getSession(false).removeAttribute("url");
		return mv;
	}

	/**
	 * 商家后台操作错误提示页
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/seller/error.htm")
	public ModelAndView error(HttpServletRequest request, HttpServletResponse response) {
		User user = SecurityUserHolder.getCurrentUser();
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_error.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("op_title", request.getSession(false).getAttribute("op_title"));
		mv.addObject("url", request.getSession(false).getAttribute("url"));
		request.getSession(false).removeAttribute("op_title");
		request.getSession(false).removeAttribute("url");
		return mv;
	}

	/**
	 * 店铺到期关闭后，商家申请续费重新开店
	 * 
	 * @param request
	 * @param response
	 */
	@SecurityMapping(title = "商家中心申请重新开店", value = "/seller/store_renew.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/store_renew.htm")
	public void store_renew(HttpServletRequest request, HttpServletResponse response) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		boolean ret = false;

		if (userDetails.getStoreId() != null) {
			Store store = new Store();
			store.setId(userDetails.getStoreId());
			store.setStoreStatus(StoreConstants.STORE_STATUS_SHOP_EXPIRE_RENEWAL);
			this.storeService.update(store);
			ret = true;
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 查看商家的邀请管理
	 * 
	 * @param request
	 * @param response
	 */
	@SecurityMapping(title = "商家邀请管理", value = "/seller/my_invitation.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/my_invitationInfo.htm")
	public ModelAndView my_invitationInfo(HttpServletRequest request, HttpServletResponse response) {
		// 查询头像图片，我的昵称，邀请码，邀请设置，二维码

		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_my_invitation.html",
				configService.getSysConfig(), 0, request, response);

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		UserBO user = userService.getObjById(userDetails.getSeller().getUid());// 邀请码

		UserAccount userAccount = userAccountService.findByUid(userDetails.getSeller().getUid());// 邀请设置信息

		UserCustomerBO userCustomer = customerService.searchCustomer(userDetails.getSeller().getUid());// 头像图片，昵称

		mv.addObject("user", user);
		mv.addObject("userAccount", userAccount);
		mv.addObject("userCustomer", userCustomer);

		return mv;
	}

	/**
	 * pc-保存我的邀请信息
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("unused")
	@SecurityMapping(title = "商家邀请管理-我的邀请信息", value = "/seller/my_invitationInfo_save.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/my_invitationInfo_save.htm")
	public ModelAndView my_invitationInfo_save(HttpServletRequest request, HttpServletResponse response,
			UserAccount userAccount) {
		// 查询头像图片，我的昵称，邀请码，邀请设置，二维码

		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_my_invitation.html",
				configService.getSysConfig(), 0, request, response);

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		// userAccount.setUid(userDetails.getSeller().getUid());

		try {
			userAccountService.update(userAccount);// 根据id更新
			mv.addObject("saveSuccessMsg", "保存成功");
		} catch (Exception e) {
			mv.addObject("saveFailMsg", "保存失败");
		}

		return mv;
	}

	/**
	 * 查看商家的邀请管理
	 * 
	 * @param request
	 * @param response
	 */
	@SecurityMapping(title = "商家邀请管理-邀请明细", value = "/seller/my_invitation_list.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/my_invitation_list.htm")
	public ModelAndView my_invitation_list(HttpServletRequest request, MyPage<UserCustomerBO> page,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_my_invitation_list.html",
				configService.getSysConfig(), 0, request, response);

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		page.setPageSize(4);

		customerService.queryRelationList(userDetails.getSeller().getUid(), page);

		// 处理对象的手机号码
		if (page != null && page.getContent().size() > 0) {
			// List<RelationBO> raBoList = MapperUtils.map(mapper, page.getContent(), RelationBO.class);
			List<UserCustomerBO> list = page.getContent();
			for (UserCustomerBO bo : list) {
				String mobile = bo.getMobile();
				if (StringUtils.isNotBlank(mobile)) {
					int between = mobile.length() / 2;
					// 拼接最终值
					String formatMobile = mobile.substring(0, between - 2) + "****"
							+ mobile.substring(between + 2, mobile.length());// 159****3287
					bo.setMobile(formatMobile);
				}
			}

		}

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		return mv;
	}

	/**
	 * 查看商家的邀请管理--下载二维码
	 * 
	 * @param request
	 * @param response
	 */
	@SecurityMapping(title = "商家邀请管理-下载二维码", value = "/seller/my_invitation_downloadQrcode.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/my_invitation_downloadQrcode.htm")
	public void my_invitation_downloadQrcode(HttpServletRequest request, MyPage<UserCustomerBO> page,
			HttpServletResponse response) {

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		String invitationCode = userDetails.getUser().getInvitationCode();

		try {
			String fileName = "我的邀请二维码", suffix = ".jpg", encodedFileName;
			encodedFileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// 避免中文乱码
			response.addHeader("Content-Disposition", "attachment;filename=" + encodedFileName + suffix);

			OutputStream ous = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream;charset=UTF-8");

			// String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName()
					+ request.getContextPath();
			// String content = "http://shop.ysysgo.com/mobile_register.htm?invitationCode="+invitationCode;
			String content = basePath + "/mobile_register.htm?invitationCode=" + invitationCode;

			QRCodeUtil.encode(content, ous);
			Log.info(content);
			// System.out.println(invitationCode+"\n"+content+"\n"+basePath);
			ous.flush();
			ous.close();
		} catch (IOException e) {
			log.info("下载二维码出现读写IO异常");
		} catch (Exception e) {
			log.info("下载二维码出现异常");
		}
	}

	/**
	 * 　入驻平台 判断
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/seller/ruzhu_pingtai.htm")
	public ModelAndView ruzhu_pingtai(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = null;
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		int noRole = 1;//是否有资格申请成为商户供应商 1有0没有
		if (userDetails == null) {
			System.out.println("没有登录！");
			mv = new JModelAndView("gongyingshang/ruzhupt.html", configService.getSysConfig(), 1, request,
					response);
		} else {
			UserCustomerBO user =this.customerService.findOneByUserId(userDetails.getId());
			Long uid = user.getUid();
			if(null != userAccountService.findUserAccount(uid, UserContant.ACCOUNT_TYPE_8)){//CN账号无法申请成为供应商商户
				noRole = 0;
			}
			mv = new JModelAndView("gongyingshang/ruzhupt.html", configService.getSysConfig(), 1,
					request, response);
			mv.addObject("user", user);
		}
		mv.addObject("noRole",noRole);
		return mv;
	}

	/**
	 * 　入驻须知
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/seller/ruzhu_xuzhi.htm")
	public ModelAndView ruzhu_xuzhi(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = null;
		mv = new JModelAndView("gongyingshang/gysruzhu.html", configService.getSysConfig(), 1,
				request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (userDetails != null) {
			long uid = userDetails.getId();
			SellerBO seller = sellerService.findSessionById(uid,null,true);
			StoreBO store = null;
			if (seller != null) {
				store = this.storeService.getStoreStatus(seller.getStoreId());
			}
			if (store != null && store.getIsShop()) {// 申请分为7步，走完第7步流程进入审核状态，就不允许继续修改资料了
				mv = new JModelAndView("gongyingshang/chakansehngpijindu.html", configService.getSysConfig(), 1,
						request, response);
			}
			if (store != null && store.getIsO2o()) {
				System.out.println("我是O2O");
			}
			UserCustomerBO user = this.customerService.findOneByUserId(uid);
			mv.addObject("user", user);
			mv.addObject("store", store);
		}
		return mv;
	}

	/**
	 * 提交入驻申请
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/seller/ruzhu_shenqing.htm")
	public ModelAndView ruzhu_shenqing(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("gongyingshang/tijiaoruzhushenqing.html",
				configService.getSysConfig(), 1, request, response);
		List<GoodsClassBO> gcs = this.goodsclassService.findLevelAll();
		List<GoodsClassBO> list = new ArrayList<>();
		for (GoodsClassBO bo : gcs) {
			if (bo.getClassName().equals("热门品牌") || bo.getClassName().equals("热门搜索")) {
			} else {
				list.add(bo);
			}
		}
		String ruzhu_session = CommUtil.randomString(32);
		mv.addObject("ruzhu_session", ruzhu_session);
		request.getSession(false).setAttribute("ruzhu_session", ruzhu_session);
		
		mv.addObject("groupClassList", list);
		return mv;
	}

	/**
	 * 查看审批进度
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/seller/ruzhu_shenpijindu.htm")
	public ModelAndView ruzhu_shenpijindu(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("gongyingshang/chakansehngpijindu.html",
				configService.getSysConfig(), 1, request, response);
		return mv;
	}

	/***
	 * 云购币专区专用菜单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "商家中心导航", value = "/seller/yungou_nav.htm*", rtype = "seller", rname = "商家中心导航", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/yungou_nav.htm")
	public ModelAndView yungou_nav(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_yungou_nav.html",
				configService.getSysConfig(), 0, request, response);
		String op = CommUtil.null2String(request.getAttribute("op"));

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		SellerBO seller = userDetails.getSeller();
		StoreBO store = storeService.getObjById(userDetails.getStoreId());
		mv.addObject("op", op);
		mv.addObject("user", seller);
		mv.addObject("store", store);
		if (store != null) {
			int store_status = store.getStoreStatus();
			if (store_status != StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS) {
				mv.addObject("limit", true);
			}
			mv.addObject("isO2o", store.getIsO2o());
			mv.addObject("isShop", store.getIsShop());
		}
		return mv;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "提现管理", value = "/seller/seller_cash.htm*", rtype = "seller", rname = "预存款管理", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/seller_cash.htm")
	public ModelAndView seller_cash(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_cash.html",
				configService.getSysConfig(), 0, request, response);
		Long uid = SecurityUserHolder.getCurrentUserId();
		String source = SecurityUserHolder.getCurrentUserDetails().getSource();
		UserAccount account = userAccountService.findByUid(uid, UserContant.ACCOUNT_TYPE_8);
		Map<String, Object> moneyMap = statisticsService.getUserMoneyV2(uid, source);
		boolean pwdNotNull = (boolean) moneyMap.get("pwdNotNull");// 是否设置了云豆
		if (account == null) {
			if (!pwdNotNull) {
				mv = new JModelAndView("error_seller_index.html", configService.getSysConfig(), 1, request,
						response);
				mv.addObject("op_title", "抱歉，您需要先设置取款密码 ！");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/money_password.htm");
				return mv;
			}
		}
		if (!this.configService.getSysConfig().getDeposit()) {
			mv = new JModelAndView("error_seller_index.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		} else {
			PredepositCashBO predepositCash = predepositCashService.queryOnlyOneByUid(uid);//提现记录
			mv.addObject("predepositCash", predepositCash);
			Double cnBonus = (Double) moneyMap.get("cnBonus");// 奖金
			Double cnRepeat = (Double) moneyMap.get("cnRepeat");// 冲销币
			Double availableBalance = (Double) moneyMap.get("availableBalance"); // 云豆
			Double recordBalance = (Double) moneyMap.get("recordBalance");// 预分润云豆
//			boolean pwdNotNull = (boolean) moneyMap.get("pwdNotNull");//是否设置了云豆 
			mv.addObject("cnBonus", new BigDecimal(cnBonus).setScale(2, RoundingMode.DOWN));
			mv.addObject("availableBalance", new BigDecimal(availableBalance).setScale(2, RoundingMode.DOWN));
			mv.addObject("recordBalance", new BigDecimal(recordBalance).setScale(2, RoundingMode.DOWN));
		}

		return mv;
	}

	@SecurityMapping(title = "提现列表", value = "/seller/seller_cash_list.htm*", rtype = "seller", rname = "预存款管理", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/seller_cash_list.htm")
	public ModelAndView seller_cash_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<PredepositCashBO> page, OperatorVO vo) {
		String source = SecurityUserHolder.getCurrentUserDetails().getSource();
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_cash_list.html",
				configService.getSysConfig(), 0, request, response);
		if (!this.configService.getSysConfig().getDeposit()) {
			mv = new JModelAndView("error_seller_index.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		} else {
			// PredepositCashQueryObject qo = new
			// PredepositCashQueryObject(currentPage, mv, "addTime", "desc");
			// qo.addQuery("obj.cash_user.id", new SysMap("user_id",
			// SecurityUserHolder.getCurrentUser().getId()), "=");
			// IPageList pList = this.predepositCashService.list(qo);
			// CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
		
				if (UserContant.ACCOUNT_TYPE_SUPPLIER.equals(source)) {
					vo.setUserCode(1);
				}
				
				if (UserContant.ACCOUNT_TYPE_MERCHANT.equals(source)) {
					vo.setUserCode(2);
				}
				if (UserContant.ACCOUNT_TYPE_RESOURCE.equals(source)) {
					vo.setUserCode(0);
				}
		
			predepositCashService.queryByUserId(SecurityUserHolder.getCurrentUserId(), vo, page);
			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		}
		return mv;
	}

	@SecurityMapping(title = "会员提现详情", value = "/seller/seller_cash_view.htm*", rtype = "seller", rname = "预存款管理", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/seller_cash_view.htm")
	public ModelAndView seller_cash_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_cash_view.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			PredepositCashBO obj = this.predepositCashService.fetch(CommUtil.null2Long(id));
			mv.addObject("obj", obj);
		} else {
			mv = new JModelAndView("error_seller_index.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "设置云豆密码", value = "/seller/money_password.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/money_password.htm")
	public ModelAndView moneyPassword(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/money_password.html",
				configService.getSysConfig(), 0, request, response);
		if (accountService.findByUid(SecurityUserHolder.getCurrentUserId(), UserContant.ACCOUNT_TYPE_8) != null) {
			mv = new JModelAndView("error_seller_index.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "CN账号不能修改云豆密码");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		}
		UserAccount account = accountService.findByUid(SecurityUserHolder.getCurrentUserId(),
				UserContant.ACCOUNT_TYPE_2); // 用户的手机账号
		String mobile = "";
		if (account == null) {
			Log.info("...... 当前用户未绑定手机号 -> mobile is null ");
		} else {
			mobile = account.getLoginName();
		}
		mv.addObject("mobile", mobile);
		return mv;
	}

	@SecurityMapping(title = "云豆密码修改保存", value = "/seller/money_password_save.htm*", rtype = "seller", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/money_password_save.htm")
	public ModelAndView moneypPsswordSave(HttpServletRequest request, HttpServletResponse response,
			String new_password, String mobile_verify_code) throws Exception {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		Long uid = SecurityUserHolder.getCurrentUserId();
		String source = SecurityUserHolder.getCurrentUserDetails().getSource();
		UserAccount account = accountService.findByUid(SecurityUserHolder.getCurrentUserId(),
				UserContant.ACCOUNT_TYPE_2); // 用户的手机账号
		if (accountService.findByUid(uid, UserContant.ACCOUNT_TYPE_8) != null) {
			mv = new JModelAndView("error_seller_index.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "CN账号不能修改云豆密码");
			mv.addObject("mobile", account.getLoginName());
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		}
		String codeRedis = redisCacheService.getSmsCode(uid, account.getLoginName());
		// 验证码是否正确
		if (StringUtils.isNotBlank(codeRedis) && codeRedis.equals(mobile_verify_code)) {
			userMoneyService.updatePassword(uid, new_password, source);
			mv.addObject("op_title", "云豆密码修改成功");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		} else {
			mv = new JModelAndView("error_seller_index.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "验证不正确");
			mv.addObject("mobile", account.getLoginName());
			mv.addObject("url", CommUtil.getURL(request) + "/seller/money_password.htm");
		}
		return mv;
	}
	

	@SuppressWarnings("unused")
	@SecurityMapping(title = "收入明细", value = "/seller/seller_yunbi_list.htm*", rtype = "buyer", rname = "商家中心", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/seller/seller_yunbi_list.htm")
	public ModelAndView predeposit_log(HttpServletRequest request, HttpServletResponse response,
			MyPage<PredepositLogBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_yunbi_list.html",
				configService.getSysConfig(), 0, request, response);

		Long uid = SecurityUserHolder.getCurrentUserId();
		String source = SecurityUserHolder.getCurrentUserDetails().getSource();
		if (this.configService.getSysConfig().getDeposit()) {
			this.predepositLogService.findPageByUid(uid, page,
					UserContant.accountTypeToUserCode(source));
			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		}
		UserCustomerBO userCustomerBO = this.customerService.findSessionUser(SecurityUserHolder
				.getCurrentUser().getId());
		double recordBalance = userMoneyService.getRecordBalance(SecurityUserHolder.getCurrentUserId());
		UserAccountBO user = new UserAccountBO();
		user.setUid(SecurityUserHolder.getCurrentUserId());
		user.setAccountType(UserContant.ACCOUNT_TYPE_8);
		UserAccount user_ = userAccountService.findAccountByVo(user);
		double cnBonus = 0.0;
		if (user_ != null) {
			CnUserMoneyBO cnUserMoneyBO = this.cnPayBaseService.getCnUserBounsMoney(user_.getLoginName());// 奖金
			if (cnUserMoneyBO != null) {
				if (null != cnUserMoneyBO.getISPAY() && 1 == cnUserMoneyBO.getISPAY().intValue()) {
					if (null != cnUserMoneyBO.getBONUS()) {
						cnBonus = cnUserMoneyBO.getBONUS();
					}
				}
			}
		}
		BigDecimal bous = new BigDecimal(cnBonus).add(new BigDecimal(recordBalance));
//		BigDecimal availableBalance = (null == userCustomerBO.getAvailableBalance()) ? new BigDecimal(0)
//				: userCustomerBO.getAvailableBalance();
//		double availableBalance_ = bous.add(availableBalance).doubleValue();
		
		Map<String, Object> moneyMap = statisticsService.getUserMoneyV2(uid, source);
		Double availableBalance = (Double) moneyMap.get("availableBalance"); // 云豆
		
		mv.addObject("availableBalance", availableBalance);
		return mv;
	}

}
