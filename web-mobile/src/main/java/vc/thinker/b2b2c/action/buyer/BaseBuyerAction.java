package vc.thinker.b2b2c.action.buyer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.bo.FootPointView;
import com.sinco.carnation.goods.bo.IntegralGoodsOrderView;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.tools.FootPointTools;
import com.sinco.carnation.goods.vo.GoodsShowListVO;
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.integral.tools.IntegralViewTools;
import com.sinco.carnation.operation.OperationConstants;
import com.sinco.carnation.operation.service.CouponInfoService;
import com.sinco.carnation.operation.vo.CouponInfoMyVO;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.order.tools.OrderViewTools;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.shop.bo.IntegralGoodsOrderBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.shop.vo.IntegralGoodsOrderVO;
import com.sinco.carnation.shop.vo.OrderFormVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StorePointService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.tools.StoreViewTools;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.orcl.CnUserMoneyBO;
import com.sinco.carnation.sys.contants.SysContants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.bo.UserCustomerFavoritesBO;
import com.sinco.carnation.user.model.UserFootPoint;
import com.sinco.carnation.user.service.FootPointService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.vo.UserCustomerFavoritesVO;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: BaseBuyerAction.java
 * </p>
 * 
 * <p>
 * Description: 买家中心基础管理控制器
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
 * @date 2014-5-19
 * 
 * @version 1.0.1
 */
@Controller
public class BaseBuyerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private StoreViewTools storeViewTools;
	@Autowired
	private OrderViewTools orderViewTools;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CouponInfoService couponInfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private IntegralGoodsOrderService integralGoodsOrderService;
	@Autowired
	private FootPointService footPointService;
	@Autowired
	private FootPointTools footPointTools;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private IntegralViewTools integralViewTools;
	@Autowired
	private UserAccountService accountService;
	@Autowired
	private StorePointService storePointService;
	@Autowired
	private CnPayBaseService cnPayBaseService;

	/**
	 * * 买家首页并分页查询所有动态,可以根据type参数不同进行不同的条件查询，
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param type
	 *            ：条件查询参数，type=1为查询自己，type=2为查询好友，type=3为查询相互关注
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unused"})
	@SecurityMapping(title = "买家中心", value = "/buyer/index.htm*", rtype = "buyer", rname = "买家中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/index.htm")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response, String type,
			MyPage<OrderFormBO> page) {
		/*		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_index.html", configService.getSysConfig(), 0, request, response);
		*/ModelAndView mv = new JModelAndView("web_mobile/buyer_index.html", configService.getSysConfig(), 1,
				request, response);
		UserCustomerBO user = this.customerService.findSessionUser(SecurityUserHolder.getCurrentUser()
				.getId());
		mv.addObject("storeViewTools", storeViewTools);
		mv.addObject("orderViewTools", orderViewTools);
		if (user != null) {
			CouponInfoMyVO vo = new CouponInfoMyVO();
			vo.setStatus(OperationConstants.COUPON_INFO_STATUS_0);
			vo.setUid(user.getUid());
			mv.addObject("couponInfoCount", this.couponInfoService.countMyCoupon(vo));
			/*
			CnUserMoneyBO cnUserMoneyBO1 =cnPayBaseService.getCnUserRepeatMoney(resAccount.getLoginName());//重消
			*/// 查询CN账号
			List<UserAccountBO> userAccount = accountService.findUserAccountByUid(user.getUid());
			boolean bl = false;
			double cnBonus = 0;
			double cnRepeat = 0;

			for (UserAccountBO account : userAccount) {
				if ("8".equals(account.getAccountType())) {
					bl = true;
					mv.addObject("cnbl", bl);
					break;
				}
			}
			if (bl) {
				UserAccount resAccount = this.accountService.findByUid(user.getUid(),
						UserContant.ACCOUNT_TYPE_8);
				CnUserMoneyBO cnUserMoneyBO = this.cnPayBaseService.getCnUserBounsMoney(resAccount
						.getLoginName());// 奖金
				if (cnUserMoneyBO != null) {
					if (null != cnUserMoneyBO.getISPAY() && 1 == cnUserMoneyBO.getISPAY().intValue()) {
						if (null != cnUserMoneyBO.getBONUS()) {
							cnBonus = cnUserMoneyBO.getBONUS();
							mv.addObject("cnBonus", cnBonus);
						}
					}
				}
				CnUserMoneyBO cnUserMoneyBO1 = this.cnPayBaseService.getCnUserRepeatMoney(resAccount
						.getLoginName());// 重消
				if (cnUserMoneyBO1 != null) {

					if (null != cnUserMoneyBO1.getISPAY() && 1 == cnUserMoneyBO1.getISPAY().intValue()
							&& null != cnUserMoneyBO1.getBONUS_REPEAT()) {
						// response.setcNRepeat(cnUserMoneyBO1.getBONUS_REPEAT());
						cnRepeat = cnUserMoneyBO1.getBONUS_REPEAT();
						mv.addObject("cnRepeat", cnRepeat);
					}
				}
			}
			/*			UserAccount account = accountService.findByUid(user.getUid(), UserContant.ACCOUNT_TYPE_8);
						mv.addObject("account",account);*/
		}

		// 查询订单信息
		/*		List<OrderFormBO> statusCountList = orderFormService.statusCount(SecurityUserHolder.getCurrentUserId());
				mv.addObject("sta tusCountList", statusCountList);*/

		// // 查询待付款的9个订单
		// List<OrderForm> orderForms = this.orderFormService.query("select obj
		// from OrderForm obj where obj.order_status=10 and obj.order_cat!=2 and
		// obj.user_id=" + user.getId().toString() + " order by obj.addTime
		// desc", null, 0, 9);
		OrderFormVO vo = new OrderFormVO();
		vo.setOrderStatusNum(10);;
		vo.setUserId(SecurityUserHolder.getCurrentUserId());
//		vo.setOrderForm(OrderFormConstants.ORDER_FORM_SELF);
		page.setPageSize(9);
		orderFormService.findPageByVo(page, vo);
		mv.addObject("orderForms", page.getContent());
		// 查询9个用户关注收藏的商品
		// Map params = new HashMap();
		// params.put("goods_type", 0);
		// params.put("user_id", user.getId());
		// List<Favorite> favorite_goods = this.favService.query("select obj
		// from Favorite obj where obj.user_id=:user_id and obj.type=:goods_type
		// order by obj.addTime desc", params, 0, 9);
		MyPage<UserCustomerFavoritesBO> favoritePage = new MyPage<>();
		UserCustomerFavoritesVO fvo = new UserCustomerFavoritesVO();
		fvo.setUid(user.getUid());
		fvo.setGoodsType(0);
		fvo.setType("3");
		favoritePage.setPageSize(9);

		customerService.queryFavorites(fvo, favoritePage);

		List<Long> ids = new ArrayList<>();
		ids.add(-1L);
		for (UserCustomerFavoritesBO bo : favoritePage.getContent()) {
			ids.add(Long.parseLong(bo.getFid()));
		}
		GoodsShowListVO gslv = new GoodsShowListVO();
		gslv.setIds(ids);

		mv.addObject("favorite_goods", goodsService.findShopListBO(gslv));
		// 查询9个用户关注收藏的店铺
		// params.clear();
		// params.put("store_type", 1);
		// params.put("user_id", user.getId());
		// List<Favorite> favorite_stores = this.favService.query("select obj
		// from Favorite obj where obj.user_id=:user_id and obj.type=:store_type
		// order by obj.addTime desc",params, 0, 9);
		favoritePage = new MyPage<>();
		fvo = new UserCustomerFavoritesVO();
		fvo.setType("4");
		fvo.setUid(user.getUid());
		favoritePage.setPageSize(9);
		customerService.queryFavorites(fvo, favoritePage);

		List<StoreBO> stores = new ArrayList<>();
		for (UserCustomerFavoritesBO bo : favoritePage.getContent()) {
			long id = Long.parseLong(bo.getFid());
			StoreBO sb = storeService.getObjById(id);
//			StorePointBO spbo = storePointService.fetchByStoreId(sb.getId());
//			sb.setStoreEvaluate(spbo.getStoreEvaluate());

			Map<Integer, Integer> map = goodsService.findCountByStoreId(sb.getId());
			if (map != null)
				sb.setNum(map.get(0));
			stores.add(sb);
		}

		mv.addObject("favorite_stores", stores);
		mv.addObject("user", user);
		mv.addObject("type", type);
		// 查询未读站内信数量
		// List<Message> msgs = new ArrayList<Message>();
		// params.clear();
		// params.put("status", 0);
		// params.put("user_id", user.getId());
		// msgs = this.messageService
		// .query("select count(obj.id) from Message obj where
		// obj.status=:status and obj.toUser.id=:user_id and obj.parent.id is
		// null order by obj.addTime desc",
		// params, -1, -1);
		int num = messageService.countByToUser(user.getUid(), 0);
		mv.addObject("msg_size", num);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("integralViewTools", integralViewTools);
		// 查询9个已经付款完成的积分兑换信息,
		// params.clear();
		// params.put("igo_user", user.getId());
		// // params.put("igo_status", 20);
		// List<IntegralGoodsOrder> igos = this.integralGoodsOrderService
		// .query("select obj from IntegralGoodsOrder obj where
		// obj.igo_user.id=:igo_user order by obj.addTime desc",
		// params, 0, 9);
		MyPage<IntegralGoodsOrderBO> igoPage = new MyPage<>();
		igoPage.setPageSize(9);
		IntegralGoodsOrderVO igoVO = new IntegralGoodsOrderVO();
		igoVO.setUid(user.getUid());
		igoVO.setIgoStatus(20);
		integralGoodsOrderService.findPageByVo(igoPage, igoVO);
		List<IntegralGoodsOrderView> igois = new ArrayList<IntegralGoodsOrderView>();
		for (IntegralGoodsOrder igo : igoPage.getContent()) {
			IntegralGoodsOrderView igoi = new IntegralGoodsOrderView();
			igoi.setIgo_order_id(igo.getId());
			igoi.setIgo_total_integral(igo.getIgoTotalIntegral());
			List<Map> maps = this.orderFormTools.query_integral_goodsinfo(igo.getGoodsInfo());
			for (Map map : maps) {
				igoi.setIgo_goods_name(CommUtil.null2String(map.get("ig_goods_name")));
				igoi.setIgo_goods_id(CommUtil.null2Long(map.get("id")));
				igoi.setIgo_goods_img(CommUtil.null2String(map.get("ig_goods_img")));
				break;
			}
			igois.add(igoi);
		}
		mv.addObject("igois", igois);
		// // 查询9条浏览足迹信息
		// params.clear();
		// params.put("fp_user_id", user.getId());
		// List<FootPoint> fps = this.footPointService
		// .query("select obj from FootPoint obj where
		// obj.fp_user_id=:fp_user_id order by obj.addTime desc",
		// params, 0, 6);
		List<FootPointView> fpvs = new ArrayList<FootPointView>();
		List<UserFootPoint> fps = footPointService.findListByUserId(user.getUid(), null);
		for (UserFootPoint fp : fps) {
			List<FootPointView> list = this.footPointTools.generic_fpv(fp.getFpGoodsContent());
			fpvs.addAll(list);
		}
		mv.addObject("fpvs", fpvs);

		UserAccount account = accountService.findByUid(user.getUid(), UserContant.ACCOUNT_TYPE_4);
		// 计算密码安全度
		/*int pws_safe = 20;
		int nums = CommUtil.checkInput(account.getPassword());
		if (nums > 1) {
			pws_safe = pws_safe + 10;
		}
		if (num > 2) {
			pws_safe = pws_safe + 10;
		}
		if (!CommUtil.null2String(user.getEmail()).equals("")) {
			pws_safe = pws_safe + 30;
		}
		if (!CommUtil.null2String(user.getMobile()).equals("")) {
			pws_safe = pws_safe + 30;
		}
		mv.addObject("pws_safe", pws_safe);*/
		return mv;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "买家中心导航", value = "/buyer/nav.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/nav.htm")
	public ModelAndView nav(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_nav.html",
				configService.getSysConfig(), 0, request, response);
		String op = CommUtil.null2String(request.getAttribute("op"));
		mv.addObject("op", op);
		List<Message> msgs = new ArrayList<Message>();
		if (SecurityUserHolder.getCurrentUser() != null) {
			mv.addObject("msg_size", this.messageService.countByToUser(SecurityUserHolder.getCurrentUserId(),
					SysContants.MESSAGE_STATUS_0));
		}
		return mv;
	}

	@SecurityMapping(title = "买家中心导航", value = "/buyer/head.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/head.htm")
	public ModelAndView head(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_head.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	@RequestMapping("/buyer/authority.htm")
	public ModelAndView authority(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
		mv.addObject("op_title", "您登录的用户角色不正确");
		mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		return mv;
	}

}
