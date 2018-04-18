package vc.thinker.b2b2c.action.seller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsCart;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.UserGoodsClassService;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.bo.StoreNavigationBO;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StoreNavigation;
import com.sinco.carnation.store.model.StoreSlide;
import com.sinco.carnation.store.service.StoreNavigationService;
import com.sinco.carnation.store.service.StorePartnerService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.service.StoreSlideService;
import com.sinco.carnation.store.tools.StoreViewTools;
import com.sinco.carnation.store.vo.StoreSlideVO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.UserGoodsClassBO;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.model.UserGoodsClass;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * 
 * <p>
 * Title:StoreViewAction.java
 * </p>
 * 
 * <p>
 * Description: 前端店铺控制器
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
 * @author thinker、jy
 * 
 * @date 2014年4月24日
 * 
 * @version 1.0.1
 */
@Controller
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class StoreViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreSlideService storeSlideService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserGoodsClassService userGoodsClassService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private StoreNavigationService storenavigationService;
	@Autowired
	private StorePartnerService storepartnerService;
	@Autowired
	private EvaluateService evaluateService;
//	@Autowired
//	private AreaViewTools areaViewTools;
	@Autowired
	private GoodsViewTools goodsViewTools;
//	@Autowired
//	private UserTools userTools;
	@Autowired
	private StoreViewTools storeViewTools;
	@Autowired
	private UserService userService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private GoodsCartService goodsCartService;

	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private UserAccountService userAccountService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 店铺首页
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/store.htm")
	public ModelAndView store(HttpServletRequest request, HttpServletResponse response, Long ugcId,
			String id, String orderBy, String orderType, MyPage<GoodsBO> page, String ex_price_flag) {
		Integer exPriceFlag = null;
		if (ex_price_flag != null && ex_price_flag.trim().length() > 0 && "cn".equals(ex_price_flag.trim())) {
			exPriceFlag = GoodsVO.EXPRICEFLAG_CN_PRODUCT;
		}

		String serverName = request.getServerName().toLowerCase();
		String secondDomain = "";

		if (this.configService.getSysConfig().getSecondDomainOpen()) {
			secondDomain = serverName.substring(0, serverName.indexOf("."));
		}
		StoreBO store = null;
		if (this.configService.getSysConfig().getSecondDomainOpen()
				&& serverName.indexOf(".") != serverName.lastIndexOf(".") && !secondDomain.equals("www")) {
//			store = this.storeService.getObjByProperty(null, "store_second_domain", secondDomain);
		} else {
			store = this.storeService.getObjById(CommUtil.null2Long(id));
		}
		if (store == null) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "不存在该店铺信息");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		} else {
			ModelAndView mv = null;
			mv = new JModelAndView("default/store_default.html", configService.getSysConfig(), 1, request,
					response);
			if (store.getStoreStatus() == 15) {
				String fullName = "";
				if (store.getAreaId() != null) {
					fullName = areaService.fullName(store.getAreaId());
				}
				mv.addObject("fullName", fullName);
				this.add_store_common_info(mv, store);// 店铺商品信息
				this.generic_evaluate(store, mv);// 店铺信用信息
				if (StringUtils.isEmpty(orderType)) {
					orderType = "asc";
				}
				if (StringUtils.isEmpty(orderBy)) {
					orderBy = "add_time";
				}
				GoodsVO vo = new GoodsVO();
				vo.setOrderBy(orderBy);
				vo.setOrderType(orderType);
				vo.setStoreId(CommUtil.null2Long(id));

				if (ugcId != null) {
					Set<Long> userGoodsClassIds = new HashSet<>();
					UserGoodsClass currentUgc = userGoodsClassService.getObjById(ugcId);
					if (currentUgc != null) {
						userGoodsClassIds.add(ugcId);
						if (currentUgc.getParentId() == null) {
							List<UserGoodsClass> childs = userGoodsClassService.findByParentId(currentUgc
									.getId());
							if (CollectionUtils.isNotEmpty(childs)) {
								for (UserGoodsClass userGoodsClass : childs) {
									userGoodsClassIds.add(userGoodsClass.getId());
								}
							}

						}
					}
					vo.setUserGoodsClassIds(userGoodsClassIds);
				}
				vo.setExPriceFlag(exPriceFlag);
				page.setPageSize(9);
				this.goodsService.selectGoodsListByVO(page, vo);
				CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
//				List<GoodsBO> goodList = page.getResult();
//				for(GoodsBO good:goodList)
//				{
//					String goodsInventoryDetail = good.getGoodsInventoryDetail();
//					logger.debug("goodsInventoryDetail------->"+goodsInventoryDetail);
//					if(goodsInventoryDetail!=null && goodsInventoryDetail.trim().length()>0)
//					{
//						JSONArray jsonArr = JSONArray.fromObject(goodsInventoryDetail);
//						if(jsonArr.size()>0 )
//						{
//							
//						}
//					}
//				}

				if (exPriceFlag != null) {
					mv.addObject("exPriceFlag", exPriceFlag);
				}
				mv.addObject("orderBy", vo.getOrderBy());
				mv.addObject("orderType", vo.getOrderType());
				mv.addObject("currentPage", page.getCurrentPage());
				mv.addObject("ugcId", ugcId);

				String store_theme = "default";
				if (store.getStoreDecorateOldTheme() != null) {
					store_theme = store.getStoreDecorateOldTheme();
				}
				mv.addObject("store_theme", store_theme);
				if (store.getStoreDecorateBackgroundOldInfo() != null) {
					Map bg = Json.fromJson(Map.class, store.getStoreDecorateBackgroundOldInfo());
					mv.addObject("bg", bg);
				}
				if (SecurityUserHolder.getCurrentUser() != null) {
					Long uid = SecurityUserHolder.getCurrentUserId();
					/**
					 * 会员登陆后 检查是否为CN用户 CN用户 显示新增商品BV值 add by yuleijia 2017.2.20
					 */
					UserAccountBO account1 = new UserAccountBO();
					account1.setUid(uid);
					account1.setAccountType(UserContant.ACCOUNT_TYPE_8);
					UserAccountBO cnUserAccount = userAccountService.findAccountByVo(account1);
					boolean isCN = Boolean.FALSE;
					if (cnUserAccount != null) {
						isCN = Boolean.TRUE;
					}
					mv.addObject("isCN", isCN);
				}
			} else if (store.getStoreStatus() == 25 || store.getStoreStatus() == 26) {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "店铺因为合同到期现已关闭，如有疑问请联系商城客服");
				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			} else if (store.getStoreStatus() < 15) {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "店铺未正常营业");
				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			} else if (store.getStoreStatus() == 20) {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "店铺因为违反商城相关规定现已关闭，如有疑问请联系商城客服");
				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			}
			return mv;
		}
	}

	/**
	 * 店铺头部，在店铺内所有页面使用httpInclude.include("/store_head.htm")
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/store_head.htm")
	public ModelAndView store_head(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("default/store_head.html", configService.getSysConfig(), 1,
				request, response);
		String type = CommUtil.null2String(request.getAttribute("type"));
		String store_id = CommUtil.null2String(request.getAttribute("store_id"));
		String cart_session_id = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cart_session_id")) {
					cart_session_id = CommUtil.null2String(cookie.getValue());
				}
			}
		}
		if (cart_session_id.equals("")) {
			cart_session_id = UUID.randomUUID().toString();
			Cookie cookie = new Cookie("cart_session_id", cart_session_id);
			cookie.setDomain(CommUtil.generic_domain(request));
		}
		List<GoodsCart> carts_list = new ArrayList<GoodsCart>();// 用户整体购物车
		List<GoodsCart> carts_cookie = new ArrayList<GoodsCart>();// 未提交的用户cookie购物车
		List<GoodsCart> carts_user = new ArrayList<GoodsCart>();// 未提交的用户user购物车
		User user = SecurityUserHolder.getCurrentUser();
		Map cart_map = new HashMap();
		if (user != null) {
			user = userService.getObjById(user.getId());
			if (!cart_session_id.equals("")) {
				cart_map.clear();
				cart_map.put("cart_session_id", cart_session_id);
				cart_map.put("cart_status", 0);
//				carts_cookie = this.goodsCartService
//						.query("select obj from GoodsCart obj where obj.cart_session_id=:cart_session_id and obj.cart_status=:cart_status ",
//								cart_map, -1, -1);
				// 如果用户拥有自己的店铺，删除carts_cookie购物车中自己店铺中的商品信息
//				if (user.getStore() != null) {
//					for (GoodsCart gc : carts_cookie) {
//						if (gc.getGoods().getGoods_type() == 1) {// 该商品为商家商品
//							if (gc.getGoods().getGoods_store().getId()
//									.equals(user.getStore().getId())) {
//								this.goodsCartService.delete(gc.getId());
//							}
//						}
//					}
//				}
				cart_map.clear();
				cart_map.put("user_id", user.getId());
				cart_map.put("cart_status", 0);
//				carts_user = this.goodsCartService
//						.query("select obj from GoodsCart obj where obj.user.id=:user_id and obj.cart_status=:cart_status ",
//								cart_map, -1, -1);
			} else {
				cart_map.clear();
				cart_map.put("user_id", user.getId());
				cart_map.put("cart_status", 0);
//				carts_user = this.goodsCartService
//						.query("select obj from GoodsCart obj where obj.user.id=:user_id and obj.cart_status=:cart_status ",
//								cart_map, -1, -1);
			}
		} else {
			if (!cart_session_id.equals("")) {
				cart_map.clear();
				cart_map.put("cart_session_id", cart_session_id);
				cart_map.put("cart_status", 0);
//				carts_cookie = this.goodsCartService
//						.query("select obj from GoodsCart obj where obj.cart_session_id=:cart_session_id and obj.cart_status=:cart_status ",
//								cart_map, -1, -1);
			}
		}
		// 将cookie购物车与user购物车合并，并且去重
		if (user != null) {
			for (GoodsCart cookie : carts_cookie) {
				boolean add = true;
//				for (GoodsCart gc2 : carts_user) {
//					if (cookie.getGoods().getId()
//							.equals(gc2.getGoods().getId())) {
//						if (cookie.getSpec_info().equals(gc2.getSpec_info())) {
//							add = false;
//							this.goodsCartService.delete(cookie.getId());
//						}
//					}
//				}
//				if (add) {// 将cookie去重并添加到cart_list中
//					cookie.setCart_session_id(null);
//					cookie.setUser(user);
//					this.goodsCartService.update(cookie);
//					carts_list.add(cookie);
//				}
			}
		} else {
			for (GoodsCart gc : carts_cookie) {// 将carts_cookie添加到cart_list中
				carts_list.add(gc);
			}
		}
		for (GoodsCart gc : carts_user) {// 将carts_user添加到cart_list中
			carts_list.add(gc);
		}
		// 组合套装处理，只显示套装主购物车,套装内其他购物车不显示
		List<GoodsCart> combin_carts_list = new ArrayList<GoodsCart>();
		for (GoodsCart gc : carts_list) {
			if (gc.getCartType() != null && gc.getCartType().equals("combin")) {
				if (gc.getCombinMain() != 1) {
					combin_carts_list.add(gc);
				}
			}
		}
		if (combin_carts_list.size() > 0) {
			carts_list.removeAll(combin_carts_list);
		}
		mv.addObject("store_id", store_id);
		mv.addObject("carts", carts_list);
		mv.addObject("type", type.equals("") ? "goods" : type);
		return mv;
	}

	/**
	 * 除店铺首页外，在店铺其他页面依然使用httpInclude.include("/store_nav.htm")
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/store_nav.htm")
	public ModelAndView store_nav(HttpServletRequest request, HttpServletResponse response) {
		Long id = CommUtil.null2Long(request.getAttribute("id"));
		Store store = this.storeService.getObjById(id);
		ModelAndView mv = new JModelAndView("default/store_nav.html", configService.getSysConfig(), 1,
				request, response);
		if (store.getStoreStatus() == 15) {
			Map params = new HashMap();
			params.put("store_id", store.getId());
			params.put("display", true);
//			List<StoreNavigation> navs = this.storenavigationService
//					.query("select obj from StoreNavigation obj where obj.store.id=:store_id and obj.display=:display order by obj.sequence asc",
//							params, -1, -1);
//			mv.addObject("navs", navs);
			mv.addObject("store", store);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "店铺信息错误");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}
		return mv;
	}

	/**
	 * 店铺导航详情页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/store_url.htm")
	public ModelAndView store_url(HttpServletRequest request, HttpServletResponse response, String id) {
		StoreNavigation nav = this.storenavigationService.getObjById(CommUtil.null2Long(id));
		ModelAndView mv = new JModelAndView("default/store_url.html", configService.getSysConfig(), 1,
				request, response);
//		mv.addObject("store", nav.getStore());
		mv.addObject("nav", nav);
		mv.addObject("nav_id", nav.getId());
//		this.add_store_common_info(mv, nav.getStore());// 店铺商品信息
//		this.generic_evaluate(nav.getStore(), mv);// 店铺信用信息
//		mv.addObject("userTools", userTools);
		String store_theme = "default";
//		if (nav.getStore().getStore_decorate_old_theme() != null) {
//			store_theme = nav.getStore().getStore_decorate_old_theme();
//		}
		mv.addObject("store_theme", store_theme);
//		if (nav.getStore().getStore_decorate_background_old_info() != null) {
//			Map bg = Json.fromJson(Map.class, nav.getStore()
//					.getStore_decorate_background_old_info());
//			mv.addObject("bg", bg);
//		}
		return mv;
	}

	/**
	 * 根据单个店铺分类查看对应的商品
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/goods_list.htm")
	public ModelAndView goods_list(HttpServletRequest request, HttpServletResponse response, String ugc_id,
			String store_id, String keyword, String orderBy, String orderType, String currentPage,
			String submit_type) {
		ModelAndView mv = new JModelAndView("default/goods_list.html", configService.getSysConfig(), 1,
				request, response);
		StoreBO store = this.storeService.getObjById(CommUtil.null2Long(store_id));
		if (store != null) {
			if (submit_type != null && !submit_type.equals("")) {
				if (keyword != null && !keyword.equals("")) {// 关键字搜索商品
//					GoodsQueryObject gqo = new GoodsQueryObject(currentPage,
//							mv, "", "");
//					gqo.addQuery("obj.goods_store.id", new SysMap(
//							"goods_store_id", store.getId()), "=");
//					gqo.addQuery("obj.goods_status", new SysMap("goods_status",
//							0), "=");
//					gqo.addQuery("obj.goods_name", new SysMap("goods_name", "%"
//							+ keyword + "%"), "like");
//					gqo.setPageSize(18);
//					if (orderBy != null && !orderBy.equals("")) {
//						gqo.setOrderBy(orderBy);
//						mv.addObject("orderBy", orderBy);
//						gqo.setOrderType(orderType);
//						mv.addObject("orderType", orderType);
//					}
//					IPageList pList = this.goodsService.list(gqo);
//					String url = this.configService.getSysConfig().getAddress();
//					CommUtil.saveIPageList2ModelAndView(
//							url + "/goods_list.htm", "", "", pList, mv);
				}
				mv.addObject("submit_type", submit_type);
			} else {
				if (ugc_id != null && !ugc_id.equals("")) {// 店铺分类搜索商品
					UserGoodsClass ugc = this.userGoodsClassService.getObjById(CommUtil.null2Long(ugc_id));
//					GoodsQueryObject gqo = new GoodsQueryObject(currentPage, mv,
//							"", "");
//					gqo.addQuery("obj.goods_store.id", new SysMap("goods_store_id",
//							store.getId()), "=");
//					gqo.addQuery("obj.goods_status", new SysMap("goods_status", 0),
//							"=");
//					if (ugc != null) {
//						Set<Long> ids = this.genericUserGcIds(ugc);
//						List<UserGoodsClass> ugc_list = new ArrayList<UserGoodsClass>();
//						for (Long g_id : ids) {
//							UserGoodsClass temp_ugc = this.userGoodsClassService
//									.getObjById(g_id);
//							ugc_list.add(temp_ugc);
//						}
//						Map paras = new HashMap();
//						paras.put("ugc", ugc);
//						gqo.addQuery("(:ugc member of obj.goods_ugcs", paras);
//						// gqo.addQuery("ugc", ugc, "obj.goods_ugcs", "member of");
//						for (int i = 0; i < ugc_list.size(); i++) {
//							// gqo.addQuery("ugc" + i, ugc_list.get(i),
//							// "obj.goods_ugcs","member of", "or");
//							paras.clear();
//							if (i == ugc_list.size() - 1) {
//								paras.put("ugc" + i, ugc_list.get(i));
//								gqo.addQuery(" or :ugc" + i
//										+ " member of obj.goods_ugcs)", paras);
//							} else {
//								paras.put("ugc" + i, ugc_list.get(i));
//								gqo.addQuery(" or :ugc" + i
//										+ " member of obj.goods_ugcs", paras);
//							}
//						}
//					} else {
//						ugc = new UserGoodsClass();
//						ugc.setClassName("全部商品");
//						mv.addObject("ugc", ugc);
//					}
//					if (orderBy != null && !orderBy.equals("")) {
//						gqo.setOrderBy(orderBy);
//						mv.addObject("orderBy", orderBy);
//						gqo.setOrderType(orderType);
//						mv.addObject("orderType", orderType);
//					}
//					gqo.setPageSize(18);
//					IPageList pList = this.goodsService.list(gqo);
//					String url = this.configService.getSysConfig().getAddress();
//					CommUtil.saveIPageList2ModelAndView(url + "/goods_list.htm",
//							"", "", pList, mv);
//					mv.addObject("ugc", ugc);
				}
			}
			mv.addObject("ugc_id", ugc_id);
			mv.addObject("keyword", keyword);
			mv.addObject("store", store);
			mv.addObject("goodsViewTools", goodsViewTools);
			mv.addObject("storeViewTools", storeViewTools);
//			mv.addObject("areaViewTools", areaViewTools);
			Map params = new HashMap();
//			params.put("user_id", store.getUser().getId());
			params.put("display", true);
//			List<UserGoodsClass> ugcs = this.userGoodsClassService
//					.query("select obj from UserGoodsClass obj where obj.user_id=:user_id and obj.display=:display and obj.parent.id is null order by obj.sequence asc",
//							params, -1, -1);
//			mv.addObject("ugcs", ugcs);// 店内分类
			params.clear();
			params.put("store_id", store.getId());
//			List<Goods> hotgoods = this.goodsService
//					.query("select obj from Goods obj where obj.goods_store.id=:store_id order by obj.goods_salenum desc",
//							params, 0, 5);
//			mv.addObject("hotgoods", hotgoods);// 热销排行
			params.clear();
			params.put("store_id", store.getId());
			params.put("display", true);
//			List<StoreNavigation> navs = this.storenavigationService
//					.query("select obj from StoreNavigation obj where obj.store.id=:store_id and obj.display =:display order by obj.sequence asc ",
//							params, -1, -1);
//			mv.addObject("navs", navs);// 导航栏
			this.generic_evaluate(store, mv);// 店铺评分信息
//			mv.addObject("userTools", userTools);
			String store_theme = "default";
			if (store.getStoreDecorateOldTheme() != null) {
				store_theme = store.getStoreDecorateOldTheme();
			}
			mv.addObject("store_theme", store_theme);
			if (store.getStoreDecorateBackgroundOldInfo() != null) {
				Map bg = Json.fromJson(Map.class, store.getStoreDecorateBackgroundOldInfo());
				mv.addObject("bg", bg);
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "请求参数错误");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}
		return mv;
	}

	/**
	 * 店铺模块加载，通过url,加载不同的店铺模块
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @return
	 */
	@RequestMapping("/module_loading.htm")
	public String module_loading(HttpServletRequest request, HttpServletResponse response, String url,
			String id, String mark, String decorate_view, String div) {
		return "redirect:module_" + url + ".htm?id=" + id + "&mark=" + mark + "&decorate_view="
				+ decorate_view + "&div=" + div;
	}

	/**
	 * 店铺导航模块加载
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/module_nav.htm")
	public ModelAndView module_nav(HttpServletRequest request, HttpServletResponse response, String id,
			String mark) {
		Store store = this.storeService.getObjById(CommUtil.null2Long(id));
		ModelAndView mv = new JModelAndView("default/module_nav.html", configService.getSysConfig(), 1,
				request, response);
		// 模块设置信息
		Map obj = new HashMap();
		if (store.getStoreDecorateInfo() != null) {
			List<Map> maps = Json.fromJson(List.class, store.getStoreDecorateInfo());
			for (Map map : maps) {
				if (map.get("mark").equals(mark)) {
					obj = map;
					break;
				}
			}
		}
		mv.addObject("obj", obj);
		// 导航内容
		Map params = new HashMap();
		params.put("store_id", store.getId());
		params.put("display", true);
//		List<StoreNavigation> navs = this.storenavigationService
//				.query("select obj from StoreNavigation obj where obj.store.id=:store_id and obj.display=:display order by obj.sequence asc",
//						params, -1, -1);
//		mv.addObject("navs", navs);
		mv.addObject("store", store);
		return mv;
	}

	/**
	 * 店铺自定义幻灯模块加载
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/module_defined_slide.htm")
	public ModelAndView module_defined_slide(HttpServletRequest request, HttpServletResponse response,
			String id, String mark, String decorate_view) {
		ModelAndView mv = new JModelAndView("default/module_defined_slide.html",
				configService.getSysConfig(), 1, request, response);
		Store store = this.storeService.getObjById(CommUtil.null2Long(id));
		Map params = new HashMap();
		List<Map> objs = new ArrayList<Map>();
		Map obj_map = null;
		if (store.getStoreDecorateInfo() != null) {
			List<Map> maps = Json.fromJson(List.class, store.getStoreDecorateInfo());
			for (Map temp : maps) {
				if (temp.get("mark").equals(mark)) {
					obj_map = temp;
					break;
				}
			}
		}
		if (obj_map != null) {
			String temp_str[] = CommUtil.null2String(obj_map.get("slide_info")).split("\\|");
			for (String str : temp_str) {
				if (!str.equals("")) {
					String temp[] = str.split("_");
					Accessory img = this.accessoryService.getObjById(CommUtil.null2Long(temp[0]));
					Map obj = new HashMap();
					obj.put("src", img.getPath() + "/" + img.getName());
					if (temp.length > 1) {
						obj.put("url", temp[1]);
					}
					objs.add(obj);
				}
			}
			mv.addObject("obj", obj_map);
			mv.addObject("slides", objs);
		}
		mv.addObject("decorate_view", decorate_view);// 是否为店铺装修视图，
		return mv;
	}

	/**
	 * 店铺分类模块加载
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/module_class.htm")
	public ModelAndView module_class(HttpServletRequest request, HttpServletResponse response, String id,
			String mark, String decorate_view) {
		ModelAndView mv = new JModelAndView("default/module_class.html", configService.getSysConfig(), 1,
				request, response);
		Store store = this.storeService.getObjById(CommUtil.null2Long(id));
		Map params = new HashMap();
//		params.put("user_id", store.getUser().getId());
		params.put("display", true);
//		List<UserGoodsClass> ugcs = this.userGoodsClassService
//				.query("select obj from UserGoodsClass obj where obj.user_id=:user_id and obj.display=:display and obj.parent.id is null order by obj.sequence asc",
//						params, -1, -1);
//		mv.addObject("ugcs", ugcs);
		Map obj_map = null;
		if (store.getStoreDecorateInfo() != null) {
			List<Map> maps = Json.fromJson(List.class, store.getStoreDecorateInfo());
			for (Map temp : maps) {
				if (temp.get("mark").equals(mark)) {
					obj_map = temp;
					break;
				}
			}
		}
		mv.addObject("store", store);
		mv.addObject("decorate_view", decorate_view);
		mv.addObject("obj", obj_map);
		return mv;
	}

	/**
	 * 店铺热销商品列表模块加载
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/module_goods_sale.htm")
	public ModelAndView module_goods_sale(HttpServletRequest request, HttpServletResponse response,
			String id, String mark) {
		ModelAndView mv = new JModelAndView("default/module_goods_sale.html", configService.getSysConfig(),
				1, request, response);
		Store store = this.storeService.getObjById(CommUtil.null2Long(id));
		Map obj_map = null;
		if (store.getStoreDecorateInfo() != null) {
			List<Map> maps = Json.fromJson(List.class, store.getStoreDecorateInfo());
			for (Map temp : maps) {
				if (temp.get("mark").equals(mark)) {
					obj_map = temp;
					break;
				}
			}
		}
		int count = 5;
		if (obj_map != null && obj_map.get("goods_count") != null && !obj_map.get("goods_count").equals("")) {
			count = CommUtil.null2Int(obj_map.get("goods_count"));
		}
		Map params = new HashMap();
		params.put("store_id", store.getId());
		params.put("goods_status", 0);
//		List<Goods> hotgoods = this.goodsService
//				.query("select obj from Goods obj where obj.goods_store.id=:store_id and obj.goods_status=:goods_status order by obj.goods_salenum desc",
//						params, 0, count);
//		mv.addObject("hotgoods", hotgoods);// 加载热销商品
		mv.addObject("obj", obj_map);
		return mv;
	}

	/**
	 * 店铺信息模块加载
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/module_store_info.htm")
	public ModelAndView module_store_info(HttpServletRequest request, HttpServletResponse response,
			String id, String mark) {
		ModelAndView mv = new JModelAndView("default/module_store_info.html", configService.getSysConfig(),
				1, request, response);
		StoreBO store = this.storeService.getObjById(CommUtil.null2Long(id));
		this.generic_evaluate(store, mv);
		mv.addObject("store", store);
		Map obj_map = new HashMap();
		if (store.getStoreDecorateInfo() != null) {
			List<Map> maps = Json.fromJson(List.class, store.getStoreDecorateInfo());
			for (Map temp : maps) {
				if (temp.get("mark").equals(mark)) {
					obj_map = temp;
					break;
				}
			}
		}
		mv.addObject("obj", obj_map);
		return mv;
	}

	/**
	 * 店铺自定义商品列表块加载（2排3列）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/module_goods_top.htm")
	public ModelAndView module_goods_top(HttpServletRequest request, HttpServletResponse response, String id,
			String mark) {
		ModelAndView mv = new JModelAndView("default/module_goods_top.html", configService.getSysConfig(), 1,
				request, response);
		Store store = this.storeService.getObjById(CommUtil.null2Long(id));
		String goods_ids = null;
		List<Goods> objs = new ArrayList<Goods>();
		Map obj_map = new HashMap();
		if (store.getStoreDecorateInfo() != null) {
			List<Map> maps = Json.fromJson(List.class, store.getStoreDecorateInfo());
			for (Map temp : maps) {
				if (temp.get("mark").equals(mark)) {
					goods_ids = CommUtil.null2String(temp.get("goods_ids"));
					obj_map = temp;
					break;
				}
			}
		}
		if (goods_ids != null) {
			String ids[] = goods_ids.split(",");
			for (String gid : ids) {
				if (!gid.equals("")) {
					Goods obj = this.goodsService.getObjById(CommUtil.null2Long(gid));
					objs.add(obj);
				}
			}
			mv.addObject("obj", obj_map);
			mv.addObject("objs", objs);
		}
		return mv;
	}

	/**
	 * 店铺自定义商品列表块加载（4排3列）
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param mark
	 * @return
	 */
	@RequestMapping("/module_goods_right.htm")
	public ModelAndView module_goods_right(HttpServletRequest request, HttpServletResponse response,
			String id, String mark) {
		ModelAndView mv = new JModelAndView("default/module_goods_right.html", configService.getSysConfig(),
				1, request, response);
		Store store = this.storeService.getObjById(CommUtil.null2Long(id));
		String goods_ids = null;
		List<Goods> objs = new ArrayList<Goods>();
		Map obj = new HashMap();
		if (store.getStoreDecorateInfo() != null) {
			List<Map> maps = Json.fromJson(List.class, store.getStoreDecorateInfo());
			for (Map temp : maps) {
				if (temp.get("mark").equals(mark)) {
					goods_ids = CommUtil.null2String(temp.get("goods_ids"));
					obj = temp;
					break;
				}
			}
		}
		if (goods_ids != null) {
			String ids[] = goods_ids.split(",");
			for (String gid : ids) {
				if (!gid.equals("")) {
					Goods goods = this.goodsService.getObjById(CommUtil.null2Long(gid));
					objs.add(goods);
				}
			}
			mv.addObject("obj", obj);
			mv.addObject("objs", objs);
		}
		return mv;
	}

	/**
	 * 店铺热点模块加载
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/module_hotspot.htm")
	public ModelAndView module_hotspot(HttpServletRequest request, HttpServletResponse response, String id,
			String mark, String div) {
		ModelAndView mv = new JModelAndView("default/module_hotspot.html", configService.getSysConfig(), 1,
				request, response);
		Store store = this.storeService.getObjById(CommUtil.null2Long(id));
		Map temp_map = null;
		if (store.getStoreDecorateInfo() != null) {
			List<Map> maps = Json.fromJson(List.class, store.getStoreDecorateInfo());
			for (Map temp : maps) {
				if (temp.get("mark").equals(mark)) {
					temp_map = temp;
					break;
				}
			}
		}
		String coors_img_id_mark = "coors_img_id";
		String coors_list_mark = "coors_list";
		if (div != null && !div.equals("undefined") && !div.equals("") && !div.equals("null")) {
			coors_img_id_mark = "coors_img_id_" + div;
			coors_list_mark = "coors_list_" + div;
		}
		Accessory img = this.accessoryService.getObjById(CommUtil.null2Long(temp_map.get(coors_img_id_mark)));
		List<Map> temp_coors_list = (List<Map>) temp_map.get(coors_list_mark);
		List<Map> coors_list = new ArrayList<Map>();
		if (img != null && img.getWidth() > 680) {// 若图片宽度大于显示区域宽度，将所有热点区域按照比例放大显示
			double rate = CommUtil.div(img.getWidth(), 680);
			for (Map temp : temp_coors_list) {
				String temp_coor[] = CommUtil.null2String(temp.get("coor")).split(",");
				String coor = "";
				for (String str : temp_coor) {
					if (str != "") {
						if (coor == "") {
							coor = CommUtil.null2String(Math.round(CommUtil.mul(rate, str)));
						} else {
							coor = coor + "," + Math.round(CommUtil.mul(rate, str));
						}
					}
				}
				if (div != null && div.equals("div2")) {
					String new_coor = "";
					rate = CommUtil.div(790, 680);
					String div2_coor[] = CommUtil.null2String(temp.get("coor")).split(",");
					for (String str : div2_coor) {
						if (str != "") {
							if (new_coor == "") {
								new_coor = CommUtil.null2String(Math.round(CommUtil.mul(rate, str)));
							} else {
								new_coor = new_coor + "," + Math.round(CommUtil.mul(rate, str));
							}
						}
					}
					coor = new_coor;
				}
				Map temp2 = new HashMap();
				temp2.put("coor", coor);
				temp2.put("url", temp.get("url"));
				coors_list.add(temp2);
			}
			mv.addObject("coors_list", coors_list);
		} else {
			mv.addObject("coors_list", temp_coors_list);
		}
		if (img != null) {
			Map obj = new HashMap();
			obj.put("src", CommUtil.getURL(request) + "/" + img.getPath() + "/" + img.getName());
			mv.addObject("obj", obj);
		}
		return mv;
	}

	/**
	 * 店铺自定义内容模块加载
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/module_defined.htm")
	public ModelAndView module_defined(HttpServletRequest request, HttpServletResponse response, String id,
			String mark, String div) {
		ModelAndView mv = new JModelAndView("default/module_defined.html", configService.getSysConfig(), 1,
				request, response);
		Store store = this.storeService.getObjById(CommUtil.null2Long(id));
		String content = "";
		if (store.getStoreDecorateInfo() != null) {
			List<Map> maps = Json.fromJson(List.class, store.getStoreDecorateInfo());
			for (Map temp : maps) {
				if (temp.get("mark").equals(mark)) {
					if (div != null && !div.equals("undefined") && !div.equals("") && !div.equals("null")) {
						content = CommUtil.null2String(temp.get(div + "_content"));
					} else {
						content = CommUtil.null2String(temp.get("content"));
					}
					break;
				}
			}
		}
		mv.addObject("content", content);
		return mv;
	}

	/**
	 * 加载店铺相关信息
	 * 
	 * @param mv
	 * @param store
	 */
	private void add_store_common_info(ModelAndView mv, StoreBO store) {
		Map params = new HashMap();
		Seller seller = sellerService.getByStoreId(store.getId());
		List<UserGoodsClassBO> ugcs = this.userGoodsClassService.findParentByUserId(seller.getUid());
		mv.addObject("ugcs", ugcs);// 加载店内分类

//		params.clear();
//		params.put("store_id", store.getId());
//		params.put("goods_status", 0);
//		List<Goods> hotgoods = this.goodsService
//				.query("select obj from Goods obj where obj.goods_store.id=:store_id and obj.goods_status=:goods_status order by obj.goods_salenum desc",
//						params, 0, 5);
//		mv.addObject("hotgoods", hotgoods);// 加载热销商品

//		params.clear();
//		params.put("recommend", true);
//		params.put("goods_store_id", store.getId());
//		params.put("goods_status", 0);
//		List<Goods> goods_recommend = this.goodsService
//				.query("select obj from Goods obj where obj.goods_recommend=:recommend and obj.goods_store.id=:goods_store_id and obj.goods_status=:goods_status order by obj.addTime desc",
//						params, 0, 6);
//		mv.addObject("goods_recommend", goods_recommend);// 加载推荐商品

//		params.clear();
//		params.put("store_id", store.getId());
//		params.put("goods_status", 0);
//		List<Goods> goods_collect = this.goodsService
//				.query("select obj from Goods obj where obj.goods_store.id=:store_id and obj.goods_status=:goods_status order by obj.goods_collect desc",
//						params, 0, 6);
//		mv.addObject("goods_collect", goods_collect);// 加载人气商品

//		params.clear();
//		params.put("goods_store_id", store.getId());
//		params.put("goods_status", 0);
//		List<Goods> goods_new = this.goodsService
//				.query("select obj from Goods obj where obj.goods_store.id=:goods_store_id and obj.goods_status=:goods_status order by obj.addTime desc ",
//						params, 0, 12);
//		mv.addObject("goods", goods_new);// 加载最新商品

//		params.clear();
//		params.put("store_id", store.getId());
//		params.put("display", true);

		StoreSlideVO vo = new StoreSlideVO();
		vo.setStoreId(store.getId());
		vo.setSlideType("0");
		List<StoreSlide> slides = this.storeSlideService.findListByVo(vo);
		store.setSlides(slides);

		List<StoreNavigationBO> navs = this.storenavigationService.findAllByStoreId(store.getId());
		mv.addObject("navs", navs);// 导航栏

		mv.addObject("store", store);
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("storeViewTools", storeViewTools);
//		mv.addObject("areaViewTools", areaViewTools);
	}

	/**
	 * 加载店铺评分信息
	 * 
	 * @param store
	 * @param mv
	 */
	private void generic_evaluate(StoreBO store, ModelAndView mv) {
		double description_result = 0;
		double service_result = 0;
		double ship_result = 0;
		GoodsClass gc = this.goodsClassService.getObjById(store.getGcMainId());
		if (store != null && gc != null && store.getPoint() != null) {
			float description_evaluate = CommUtil.null2Float(gc.getDescriptionEvaluate());
			float service_evaluate = CommUtil.null2Float(gc.getServiceEvaluate());
			float ship_evaluate = CommUtil.null2Float(gc.getShipEvaluate());

			float store_description_evaluate = CommUtil.null2Float(store.getPoint().getDescriptionEvaluate());
			float store_service_evaluate = CommUtil.null2Float(store.getPoint().getServiceEvaluate());
			float store_ship_evaluate = CommUtil.null2Float(store.getPoint().getShipEvaluate());
			// 计算和同行比较结果
			description_result = CommUtil.div(store_description_evaluate - description_evaluate,
					description_evaluate);
			service_result = CommUtil.div(store_service_evaluate - service_evaluate, service_evaluate);
			ship_result = CommUtil.div(store_ship_evaluate - ship_evaluate, ship_evaluate);
		}
		if (description_result > 0) {
			mv.addObject("description_css", "value_strong");
			mv.addObject(
					"description_result",
					CommUtil.null2String(CommUtil.mul(description_result, 100) > 100 ? 100 : CommUtil.mul(
							description_result, 100)) + "%");
		}
		if (description_result == 0) {
			mv.addObject("description_css", "value_normal");
			mv.addObject("description_result", "-----");
		}
		if (description_result < 0) {
			mv.addObject("description_css", "value_light");
			mv.addObject("description_result", CommUtil.null2String(CommUtil.mul(-description_result, 100))
					+ "%");
		}
		if (service_result > 0) {
			mv.addObject("service_css", "value_strong");
			mv.addObject(
					"service_result",
					CommUtil.null2String(CommUtil.mul(service_result, 100) > 100 ? 100 : CommUtil.mul(
							service_result, 100)) + "%");
		}
		if (service_result == 0) {
			mv.addObject("service_css", "value_normal");
			mv.addObject("service_result", "-----");
		}
		if (service_result < 0) {
			mv.addObject("service_css", "value_light");
			mv.addObject("service_result", CommUtil.null2String(CommUtil.mul(-service_result, 100)) + "%");
		}
		if (ship_result > 0) {
			mv.addObject("ship_css", "value_strong");
			mv.addObject(
					"ship_result",
					CommUtil.null2String(CommUtil.mul(ship_result, 100) > 100 ? 100 : CommUtil.mul(
							ship_result, 100)) + "%");
		}
		if (ship_result == 0) {
			mv.addObject("ship_css", "value_normal");
			mv.addObject("ship_result", "-----");
		}
		if (ship_result < 0) {
			mv.addObject("ship_css", "value_light");
			mv.addObject("ship_result", CommUtil.null2String(CommUtil.mul(-ship_result, 100)) + "%");
		}
	}

	private Set<Long> genericUserGcIds(UserGoodsClass ugc) {
		Set<Long> ids = new HashSet<Long>();
		ids.add(ugc.getId());
//		for (UserGoodsClass child : ugc.getChilds()) {
//			Set<Long> cids = genericUserGcIds(child);
//			for (Long cid : cids) {
//				ids.add(cid);
//			}
//			ids.add(child.getId());
//		}
		return ids;
	}
}
