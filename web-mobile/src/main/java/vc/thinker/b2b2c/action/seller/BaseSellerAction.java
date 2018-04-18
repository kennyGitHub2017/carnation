package vc.thinker.b2b2c.action.seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.SecurityManager;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.goods.vo.GoodsShowListVO;
import com.sinco.carnation.notice.service.OperatorNoticesService;
import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupInfoVO;
import com.sinco.carnation.o2o.vo.GroupOrderVO;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderViewTools;
import com.sinco.carnation.shop.bo.OrderFormBO;
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
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.ImageViewTools;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.tools.MenuTools;
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
@SuppressWarnings({"unchecked", "unused", "rawtypes"})
public class BaseSellerAction implements ServletContextAware {

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
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_index.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (userDetails.getStoreId() != null) {
			store = storeService.getObjById(userDetails.getStoreId());
		}
		if (store.getIsShop()) {
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
			Map<Integer, Integer> goodsCountMap = goodsService.findCountByStoreId(userDetails.getSeller()
					.getStoreId());
			mv.addObject("goodsCountMap", goodsCountMap);
			mv.addObject("returnGoodsCount", returnGoodsCount);
			mv.addObject("goods_sale_list", goods_sale_list);
			// 商品投诉
			Map<Integer, Integer> complaintCountMap = complaintService.findCountByToUserId(userDetails
					.getId());
			mv.addObject("complaintCountMap", complaintCountMap);
		}

		if (store.getIsO2o()) {

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
		StoreBO store = storeService.getObjById(userDetails.getStoreId());
		mv.addObject("op", op);
		mv.addObject("user", seller);
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
}
