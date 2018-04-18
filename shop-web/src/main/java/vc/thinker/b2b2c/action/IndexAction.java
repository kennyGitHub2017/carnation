package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsFloorBO;
import com.sinco.carnation.goods.model.GoodsCase;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsCaseService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsFloorService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.tools.GoodsCaseViewTools;
import com.sinco.carnation.goods.tools.GoodsClassViewTools;
import com.sinco.carnation.goods.tools.GoodsFloorViewTools;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.vo.GoodsShowListVO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.tools.StoreViewTools;
import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.bo.ArticleClassBO;
import com.sinco.carnation.sys.bo.PartnerBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.SysContants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.ArticleClassService;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.PartnerService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.tools.NavViewTools;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.UserCustomerService;

import net.weedfs.client.WeedFSClient;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

/**
 * 
 * <p>
 * Title: BaseManageAction.java
 * </p>
 * 
 * <p>
 * Description: 平台管理基础控制，这里包含平台管理的基础方法、系统全局配置信息的保存、修改及一些系统常用请求
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
 * @date 2014-5-9
 * 
 * @version 1.0.1
 */
@Controller
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class IndexAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private WeedFSClient fsClient;

	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private PartnerService partnerService;
	@Autowired
	private ArticleClassService articleClassService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private GoodsService goodsService;
//	@Autowired
//	private GroupGoodsService groupGoodsService;
//	@Autowired
//	private GroupService groupService;
	@Autowired
	private GoodsFloorService goodsFloorService;
	@Autowired
	private GoodsCartService goodsCartService;
	@Autowired
	private NavViewTools navTools;
	@Autowired
	private GoodsViewTools goodsViewTools;
	@Autowired
	private StoreViewTools storeViewTools;

	@Autowired
	private GoodsFloorViewTools gf_tools;

	@Autowired
	private GoodsClassViewTools gcViewTools;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private GoodsCaseService goodsCaseService;
	@Autowired
	private GoodsCaseViewTools goodsCaseViewTools;
	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private UserAccountService userAccountService;

	private int index_recommend_count = 5;// 首页推荐商品及推荐用户喜欢的商品个数，所有在这个页面位置的商品都以该数量作为查询基准，定义为一个参数，便于修改

	/**
	 * 前台公用顶部页面，使用自定义标签httpInclude.include("/top.htm")完成页面读取
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/top.htm")
	public ModelAndView top(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("top.html", configService.getSysConfig(), 1, request, response);
		UserCustomer customer = customerService.findById(SecurityUserHolder.getCurrentUserId());

		/*StoreBO store = storeService.queryStoreStatus(SecurityUserHolder.getCurrentUserId());//修改,屏蔽查询
		mv.addObject("store", store);*/

		if (null != customer) {
			if (null != customer.getNickname()) {
				mv.addObject("top_nickName", customer.getNickname());
			} else {
				mv.addObject("top_nickName", "现在还没有设置昵称");
			}
		}
		mv.addObject("navTools", navTools);
		return mv;
	}

	/**
	 * 前台公用导航主菜单页面，使用自定义标签httpInclude.include("/nav.htm")完成页面读取
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/nav.htm")
	public ModelAndView nav(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("nav.html", configService.getSysConfig(), 1, request, response);
		UserBO userBo = SecurityUserHolder.getCurrentUser();
		if (null != userBo) {
			UserAccount userAccount = this.userAccountService.findUserAccount(userBo.getId(),
					UserContant.ACCOUNT_TYPE_8);
			if (null == userAccount) {
				mv.addObject("cnFlagFalse", 1);
			}
		} else {
			mv.addObject("cnFlagFalse", 1);
		}

		mv.addObject("navTools", navTools);
		mv.addObject("gcViewTools", gcViewTools);
		mv.addObject("isLogin", SecurityUserHolder.getCurrentUser() != null);
		return mv;
	}

	/**
	 * app下载页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/downnav.htm")
	public ModelAndView downnav(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("downnav.html", configService.getSysConfig(), 1, request,
				response);
		UserBO userBo = SecurityUserHolder.getCurrentUser();
		if (null != userBo) {
			UserAccount userAccount = this.userAccountService.findUserAccount(userBo.getId(),
					UserContant.ACCOUNT_TYPE_8);
			if (null == userAccount) {
				mv.addObject("cnFlagFalse", 1);
			}
		} else {
			mv.addObject("cnFlagFalse", 1);
		}

		mv.addObject("navTools", navTools);
		mv.addObject("gcViewTools", gcViewTools);
		return mv;
	}

	/**
	 * 带有全部商品分类的导航菜单，使用自定义标签httpInclude.include("/nav1.htm")完成页面读取
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/nav1.htm")
	public ModelAndView nav1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("nav1.html", configService.getSysConfig(), 1, request, response);
		UserBO userBo = SecurityUserHolder.getCurrentUser();
		if (null != userBo) {
			UserAccount userAccount = this.userAccountService.findUserAccount(userBo.getId(),
					UserContant.ACCOUNT_TYPE_8);
			if (null == userAccount) {
				mv.addObject("cnFlagFalse", 1);
			}
		} else {
			mv.addObject("cnFlagFalse", 1);
		}
		mv.addObject("navTools", navTools);
		mv.addObject("gcViewTools", gcViewTools);
		String op = CommUtil.null2String(request.getAttribute("op"));
		String id = CommUtil.null2String(request.getAttribute("id"));
		mv.addObject("op", "/" + op + "/index.htm");
		if ("activity".equals(op) && id != null && !id.equals("")) {
			mv.addObject("op", "activity/index_" + id + ".htm");
		}
		if ("subject".equals(op) && id != null && !id.equals("")) {
			mv.addObject("op", "subject/view_" + id + ".htm");
		}
		mv.addObject("isLogin", SecurityUserHolder.getCurrentUser() != null);
		return mv;
	}

	/**
	 * 前台公用head页面，包含系统logo及全文搜索，使用自定义标签httpInclude.include("/head.htm")完成页面读取
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/head.htm")
	public ModelAndView head(HttpServletRequest request, HttpServletResponse response, String keyword) {
		ModelAndView mv = new JModelAndView("head.html", configService.getSysConfig(), 1, request, response);
		String type = CommUtil.null2String(request.getAttribute("type"));

		String cart_session_id = this.goodsCaseViewTools.getCartSessionId(request, response);

		// 这里应该改造成数量
		int cartCount = goodsCartService
				.countCartCalc(SecurityUserHolder.getCurrentUserId(), cart_session_id);

		mv.addObject("cartCount", cartCount);
		mv.addObject("type", type.equals("") ? "goods" : type);
		return mv;
	}

	/**
	 * 用户登录页顶部，使用include加载
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login_head.htm")
	public ModelAndView login_head(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("login_head.html", configService.getSysConfig(), 1, request,
				response);
		return mv;
	}

	/**
	 * 首页商品楼层数据，该数据纳入系统缓存页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping("/floor.htm")
	public ModelAndView floor(HttpServletRequest request, HttpServletResponse response)
			throws InterruptedException {
		ModelAndView mv = new JModelAndView("floor.html", configService.getSysConfig(), 1, request, response);
		List<GoodsFloorBO> floors = this.goodsFloorService.findLevelByDisplay(true);
		mv.addObject("floors", floors);
		mv.addObject("gf_tools", this.gf_tools);
		mv.addObject("url", CommUtil.getURL(request));
		return mv;
	}

	/**
	 * 首页商品楼层数据，该数据纳入系统缓存页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws InterruptedException
	 */
	@RequestMapping("/getFloor.htm")
	public ModelAndView floorView(HttpServletRequest request, HttpServletResponse response, Long id,
			Integer floorCount) throws InterruptedException {
		ModelAndView mv = new JModelAndView("floor_view.html", configService.getSysConfig(), 1, request,
				response);
		GoodsFloorBO floor = this.goodsFloorService.findLevelById(id);
		mv.addObject("floor", floor);
		mv.addObject("floorCount", floorCount);
		mv.addObject("gf_tools", this.gf_tools);
		mv.addObject("url", CommUtil.getURL(request));
		return mv;
	}

	/**
	 * 前台公用顶部导航页面，使用自定义标签httpInclude.include("/footer.htm")完成页面读取
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/footer.htm")
	public ModelAndView footer(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("footer.html", configService.getSysConfig(), 1, request, response);
		mv.addObject("navTools", navTools);

		List<ArticleClassBO> acs = this.articleClassService.findShopHome();
		mv.addObject("acs", acs);
		return mv;
	}

	/**
	 * 商城首页
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/index.htm")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("index.html", configService.getSysConfig(), 1, request, response);
		List<PartnerBO> img_partners = this.partnerService.findImg(false);
		mv.addObject("img_partners", img_partners);

		List<PartnerBO> text_partners = this.partnerService.findImg(true);
		mv.addObject("text_partners", text_partners);

		String[] class_marks = {"gonggao"}; // 首页右上角公告区分类的标识，通过后台添加
		Map<String, List<ArticleBO>> articles = Maps.newLinkedHashMap();
		for (String m : class_marks) {
			List<ArticleBO> article = this.articleService.findByParentClassMark(
					SysContants.ARTICLE_TYPE_USER, Lists.newArrayList(m), true, 6);
			articles.put(m, article);
		}
		mv.addObject("articles", articles);
		// 视图工具
		mv.addObject("goodsCaseViewTools", goodsCaseViewTools);
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("storeViewTools", storeViewTools);

		if (SecurityUserHolder.getCurrentUser() != null) {
			Long uid = SecurityUserHolder.getCurrentUserId();
			/*mv.addObject("user", this.customerService.findSessionUser(uid));*/ //修改，屏蔽词查询
			/**
			 * 会员登陆后 检查是否为CN用户 普通会员 不显示BV值 CN用户 显示新增BV值 add by yuleijia 2017.2.17
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
//		GoodsBrandShowIndexVO goodsbrandVO=new GoodsBrandShowIndexVO();
//		goodsbrandVO.setShowIndex(true);
//		goodsbrandVO.setAudit(GoodsConstants.GB_AUDIT_1);
//		goodsbrandVO.setCount(4);
//		List<GoodsBrandBO> goodsBrands = this.goodsBrandService.findByShowIndex(goodsbrandVO);
//			
//		mv.addObject("goodsBrands", goodsBrands);
		mv.addObject("navTools", navTools);

		// 楼层改造
		List<GoodsFloorBO> floors = this.goodsFloorService.findLevelByDisplay(true);
		mv.addObject("floors", floors);
		mv.addObject("gf_tools", this.gf_tools);
		mv.addObject("url", CommUtil.getURL(request));
		// 查询团购6件商品在首页显示,更加团购成功数量倒叙，团购成功数量越多的越靠前
//		params.clear();
//		params.put("beginTime", new Date());
//		params.put("endTime", new Date());
//		params.put("group_type", 0);
//		List<Group> groups = this.groupService
//				.query("select obj.id from Group obj where obj.beginTime<=:beginTime and obj.endTime>=:endTime and obj.group_type=:group_type",
//						params, -1, -1);
//		List<GroupGoods> group_goods_list = new ArrayList<GroupGoods>();
//		if (groups.size() > 0) {
//			params.clear();
//			params.put("group_id", CommUtil.null2Long(groups.get(0)));
//			params.put("gg_status", 1);
//			group_goods_list = this.groupGoodsService
//					.query("select new GroupGoods(id,gg_price,gg_img) from GroupGoods obj where obj.group.id=:group_id and obj.gg_status=:gg_status order by obj.gg_selled_count desc",
//							params, 0, 6);
//		}
//		mv.addObject("group_goods_list", group_goods_list);
		return mv;
	}

	/**
	 * 商城关闭时候导向的请求
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/close.htm")
	public ModelAndView close(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("close.html", configService.getSysConfig(), 1, request, response);
		return mv;
	}

	@RequestMapping("/404.htm")
	public ModelAndView error404(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("wap/404.html", configService.getSysConfig(), 1, request,
				response);
		String userAgent = request.getHeader("user-agent");
		mv.addObject("url", CommUtil.getURL(request) + "/wap/index.htm");
		if (userAgent == null || userAgent.indexOf("Mobile") == -1) {
			mv = new JModelAndView("404.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}
		mv.addObject("navTools", navTools);
		UserBO userBo = SecurityUserHolder.getCurrentUser();
		if (null != userBo) {
			UserAccount userAccount = this.userAccountService.findUserAccount(userBo.getId(),
					UserContant.ACCOUNT_TYPE_8);
			if (null == userAccount) {
				mv.addObject("cnFlagFalse", 1);
			}
		} else {
			mv.addObject("cnFlagFalse", 1);
		}
		return mv;
	}

	@RequestMapping("/500.htm")
	public ModelAndView error500(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("wap/500.html", configService.getSysConfig(), 1, request,
				response);
		String userAgent = request.getHeader("user-agent");
		mv.addObject("url", CommUtil.getURL(request) + "/wap/index.htm");
		if (userAgent == null || userAgent.indexOf("Mobile") == -1) {
			mv = new JModelAndView("500.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}

		UserBO userBo = SecurityUserHolder.getCurrentUser();
		if (null != userBo) {
			UserAccount userAccount = this.userAccountService.findUserAccount(userBo.getId(),
					UserContant.ACCOUNT_TYPE_8);
			if (null == userAccount) {
				mv.addObject("cnFlagFalse", 1);
			}
		} else {
			mv.addObject("cnFlagFalse", 1);
		}

		mv.addObject("navTools", navTools);
		return mv;
	}

	/**
	 * 商城商品分类导航页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/goods_class.htm")
	public ModelAndView goods_class(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("goods_class.html", configService.getSysConfig(), 1, request,
				response);
		List<GoodsClassBO> gcs = this.goodsClassService.findLevelAll(true);
		mv.addObject("gcs", gcs);
		// 这里要注意改掉，直接循环判断是否为推荐就行
//		mv.addObject("recommend_gcs", recommend_gcs);
		return mv;
	}

	@RequestMapping("/switch_case_goods.htm")
	public ModelAndView switch_case_goods(HttpServletRequest request, HttpServletResponse response,
			String goods_random, String caseid) {
		ModelAndView mv = new JModelAndView("switch_case_goods.html", configService.getSysConfig(), 1,
				request, response);
		GoodsCase goodscase = this.goodsCaseService.getObjById(CommUtil.null2Long(caseid));

		List list = (List) Json.fromJson(goodscase.getCaseContent());
		int length = list.size();

		List<Long> goodsIds = Lists.newArrayList();
		if (length > 6) {
			int begin = CommUtil.null2Int(goods_random) * 6;
			int i = 0;
			while (i < 6) {
				long id = CommUtil.null2Long(list.get((begin + i) % length));
				goodsIds.add(id);
				i++;
			}
		} else {
			for (Object id : list) {
				goodsIds.add(CommUtil.null2Long(id));
			}
		}
		GoodsShowListVO vo = new GoodsShowListVO();
		vo.setIds(goodsIds);
		List<GoodsBO> goods_list = this.goodsService.findShopListBO(vo);
		mv.addObject("goods", goods_list);
		return mv;
	}

	/**
	 * 系统只允许单用户登录，第二次登陆后提出先前用户的请求
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/outline.htm")
	public ModelAndView outline(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
		mv.addObject("op_title", "该用户在其他地点登录，您被迫下线！");
		mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		return mv;
	}

	/**
	 * ajax加载head部分用户中心 并从cookie中查询浏览记录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/head_ajax_usercenter.htm")
	public ModelAndView head_ajax_usercenter(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("head_ajax_usercenter.html", configService.getSysConfig(), 1,
				request, response);
		UserCustomerBO user = null;
		if (SecurityUserHolder.getCurrentUser() != null) {
			user = this.customerService.findSessionUser(SecurityUserHolder.getCurrentUserId());
			mv.addObject("user", user);
			mv.addObject("order_size_10", 0);
			mv.addObject("order_size_30", 0);
			List<OrderFormBO> statusCountList = orderFormService.statusCount(SecurityUserHolder
					.getCurrentUserId());
			for (OrderFormBO of : statusCountList) {
				if (of.getOrderStatus() == 10)
					mv.addObject("order_size_10", of.getStatusCount());
				else if (of.getOrderStatus() == 30)
					mv.addObject("order_size_30", of.getStatusCount());
			}
			int messageCount = messageService.countByToUser(user.getUid(), SysContants.MESSAGE_STATUS_0);
			mv.addObject("msg_size", messageCount);
		}
		List<GoodsBO> objs = new ArrayList<GoodsBO>();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("goodscookie")) {
					String[] goods_id = cookie.getValue().split(",");
					int j = 5;
					if (j > goods_id.length) {
						j = goods_id.length;
					}
					List<Long> goodsIds = new ArrayList<Long>();

					for (int i = 0; i < j; i++) {
						goodsIds.add(CommUtil.null2Long(goods_id[i]));
					}
					GoodsShowListVO vo = new GoodsShowListVO();
					vo.setIds(goodsIds);
					objs = this.goodsService.findShopListBO(vo);
				}
			}
		}
		mv.addObject("objs", objs);
		return mv;
	}

	/**
	 * ajax加载head部分用户中心 并从cookie中查询浏览记录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/head_ajax_user_group.htm")
	public ModelAndView head_ajax_userGroup(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("head_ajax_user_group.html", configService.getSysConfig(), 1,
				request, response);
		UserCustomerBO user = null;
		if (SecurityUserHolder.getCurrentUser() != null) {
			user = this.customerService.findSessionUser(SecurityUserHolder.getCurrentUserId());
			mv.addObject("user", user);
			mv.addObject("order_size_10", 0);
			mv.addObject("order_size_20", 0);
			List<GroupOrderBO> statusCountList = groupOrderService.statusCount(user.getUid(),
					Lists.newArrayList(10, 20));
			for (GroupOrderBO of : statusCountList) {
				if (of.getOrderStatus() == 10)
					mv.addObject("order_size_10", of.getStatusCount());
				else if (of.getOrderStatus() == 20)
					mv.addObject("order_size_20", of.getStatusCount());
			}
			int messageCount = messageService.countByToUser(user.getUid(), SysContants.MESSAGE_STATUS_0);
			mv.addObject("msg_size", messageCount);
		}
		return mv;
	}

	@RequestMapping("/success.htm")
	public ModelAndView success(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		mv.addObject("op_title", request.getSession(false).getAttribute("op_title"));
		mv.addObject("url", request.getSession(false).getAttribute("url"));
		request.getSession(false).removeAttribute("op_title");
		request.getSession(false).removeAttribute("url");
		return mv;
	}

	/**
	 * 默认错误页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/error.htm")
	public ModelAndView error(HttpServletRequest request, HttpServletResponse response) {
		User user = SecurityUserHolder.getCurrentUser();
		ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
		mv.addObject("op_title", request.getSession(false).getAttribute("op_title"));
		mv.addObject("list_url", request.getSession(false).getAttribute("url"));
		mv.addObject("url", request.getSession(false).getAttribute("url"));
		request.getSession(false).removeAttribute("op_title");
		request.getSession(false).removeAttribute("url");
		return mv;
	}

	/**
	 * 默认异常出现
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/exception.htm")
	public ModelAndView exception(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
		mv.addObject("op_title", "系统出现异常");
		mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		return mv;
	}

	/**
	 * 语言验证码处理
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/voice.htm")
	public ModelAndView voice(HttpServletRequest request, HttpServletResponse response) {
		return new JModelAndView("include/flash/soundPlayer.swf", this.configService.getSysConfig(), request,
				response);
	}

	/**
	 * flash获取验证码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getCode.htm")
	public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = response.getWriter();
		writer.print("result=true&code=" + (String) session.getAttribute("verify_code"));
	}

	/**
	 * 系统编辑器图片上传
	 * 
	 * @param request
	 * @param response
	 * @throws ClassNotFoundException
	 */
	public static final int maxSize = 8 * 1024 * 1024;

	@RequestMapping("/upload.htm")
	public void upload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("imgFile") MultipartFile file)
	// throws ClassNotFoundException {
			throws Exception {
		// 限制图片体积

		JSONObject obj = new JSONObject();
		if (file.getSize() > maxSize) {
			obj.put("error", 2); // 图片超出限制
		} else {
			try {
				if (file != null) {
					String fileUrl=FileUploadTools.fileUpload(file, UploadConstants.EDITOR);

					obj.put("error", 0);
					obj.put("url", fileUrl);
				} else {
					obj.put("error", "file is null");
				}
			} catch (IOException e) {
				obj.put("error", 1);
				obj.put("message", e.getMessage());
				e.printStackTrace();
			}
		}

		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(obj.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@RequestMapping("/file/upload.htm")
	public void fileUpload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("imgFile") MultipartFile file,@RequestParam("module") String module)
	// throws ClassNotFoundException {
			throws Exception {
		// 限制图片体积

		JSONObject obj = new JSONObject();
		if (file.getSize() > maxSize) {
			obj.put("error", 2); // 图片超出限制
		} else {
			try {
				if (file != null) {
					String fileUrl=FileUploadTools.fileUpload(file, module);

					obj.put("error", 0);
					obj.put("url", fileUrl);
				} else {
					obj.put("error", "file is null");
				}
			} catch (IOException e) {
				obj.put("error", 1);
				obj.put("message", e.getMessage());
				e.printStackTrace();
			}
		}

		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(obj.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("/js.htm")
	public ModelAndView js(HttpServletRequest request, HttpServletResponse response, String js) {
		ModelAndView mv = new JModelAndView("resources/js/" + js + ".js", configService.getSysConfig(), 2,
				request, response);
		return mv;
	}

	/**
	 * 右侧浮动窗口
	 */
	@RequestMapping("/goTop.htm")
	public ModelAndView goTop(HttpServletRequest request, HttpServletResponse response, String js) {
		ModelAndView mv = new JModelAndView("app/goTop.html", configService.getSysConfig(), 1, request,
				response);
		return mv;
	}

	@RequestMapping("/appDown.htm")
	public ModelAndView appDown(HttpServletRequest request, HttpServletResponse response, String js) {
		ModelAndView mv = new JModelAndView("app/downloadAppRedirect.html", configService.getSysConfig(), 1,
				request, response);
		return mv;
	}

	/**
	 * 首页导航栏
	 * 
	 * @param request
	 * @param response
	 * @param js
	 * @return
	 */
	@RequestMapping("/appDownLoad.htm")
	public ModelAndView appDownLoad(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("app/appDownLoad.html", configService.getSysConfig(), 1, request,
				response);
		return mv;
	}

	/**
	 * 商户端下载页面
	 */
	@RequestMapping("/shdappDownLoad.htm")
	public ModelAndView appDownLoad1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("app/shdappDownLoad.html", configService.getSysConfig(), 1,
				request, response);
		return mv;
	}

	/**
	 * 运营商下载页面
	 */
	@RequestMapping("/yysappDownLoad.htm")
	public ModelAndView appDownLoad2(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("app/yysappDownLoad.html", configService.getSysConfig(), 1,
				request, response);
		return mv;
	}

	/**
	 * 带有全部商品分类的导航菜单，使用自定义标签httpInclude.include("/nav1.htm")完成页面读取
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/navJFShop.htm")
	public ModelAndView navJFShop(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("navJFShop.html", configService.getSysConfig(), 1, request,
				response);
		UserBO userBo = SecurityUserHolder.getCurrentUser();
		if (null != userBo) {
			UserAccount userAccount = this.userAccountService.findUserAccount(userBo.getId(),
					UserContant.ACCOUNT_TYPE_8);
			if (null == userAccount) {
				mv.addObject("cnFlagFalse", 1);
			}
		} else {
			mv.addObject("cnFlagFalse", 1);
		}

		mv.addObject("navTools", navTools);
		mv.addObject("gcViewTools", gcViewTools);
		String op = CommUtil.null2String(request.getAttribute("op"));
		String id = CommUtil.null2String(request.getAttribute("id"));
		mv.addObject("op", "/" + op + "/index.htm");
		if ("activity".equals(op) && id != null && !id.equals("")) {
			mv.addObject("op", "activity/index_" + id + ".htm");
		}
		if ("subject".equals(op) && id != null && !id.equals("")) {
			mv.addObject("op", "subject/view_" + id + ".htm");
		}
		mv.addObject("isLogin", SecurityUserHolder.getCurrentUser() != null);
		return mv;
	}

	/**
	 * 绑定手机号
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/bandphone.htm")
	public ModelAndView bandphone(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("bandphone.html", configService.getSysConfig(), 1, request,
				response);
		return mv;
	}

	/**
	 * 前台品牌馆页面，使用自定义标签httpInclude.include("/nav_brand.htm")完成页面读取
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/navBrand.htm")
	public ModelAndView nav_brand(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("nav_brand.html", configService.getSysConfig(), 1, request,
				response);
		UserBO userBo = SecurityUserHolder.getCurrentUser();
		if (null != userBo) {
			UserAccount userAccount = this.userAccountService.findUserAccount(userBo.getId(),
					UserContant.ACCOUNT_TYPE_8);
			if (null == userAccount) {
				mv.addObject("cnFlagFalse", 1);
			}
		} else {
			mv.addObject("cnFlagFalse", 1);
		}
		mv.addObject("navTools", navTools);
		mv.addObject("gcViewTools", gcViewTools);
		mv.addObject("isLogin", SecurityUserHolder.getCurrentUser() != null);
		return mv;
	}

	/**
	 * 云购币专区nav
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/navYunGo.htm")
	public ModelAndView nav_yunGo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("nav_yunGo.html", configService.getSysConfig(), 1, request,
				response);
		UserBO userBo = SecurityUserHolder.getCurrentUser();
		if (null != userBo) {
			UserAccount userAccount = this.userAccountService.findUserAccount(userBo.getId(),
					UserContant.ACCOUNT_TYPE_8);
			if (null == userAccount) {
				mv.addObject("cnFlagFalse", 1);
			}
		} else {
			mv.addObject("cnFlagFalse", 1);
		}
		mv.addObject("navTools", navTools);
		mv.addObject("gcViewTools", gcViewTools);
		mv.addObject("isLogin", SecurityUserHolder.getCurrentUser() != null);
		return mv;
	}
	
	/**
	 * 电信增值业务许可证
	 */
	@RequestMapping("/license_dxzz.htm")
	public ModelAndView licenseDxzz(HttpServletRequest request, HttpServletResponse response, String js) {
		ModelAndView mv = new JModelAndView("license_dxzz.html", configService.getSysConfig(), 1, request,
				response);
		return mv;
	}
}
