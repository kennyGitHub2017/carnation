package vc.thinker.b2b2c.action;

import com.google.common.collect.Lists;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.biz.common.service.ServiceNORollbackException;
import com.sinco.carnation.activity.service.ActivityGoodsService;
import com.sinco.carnation.activity.tools.ActivityViewTools;
import com.sinco.carnation.buygift.service.BuyGiftService;
import com.sinco.carnation.combin.service.CombinPlanService;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsCartBO;
import com.sinco.carnation.goods.bo.GoodsSpecificationBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsCart;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsLogService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.tools.GoodsCaseViewTools;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.tools.LuceneVoTools;
import com.sinco.carnation.goods.vo.GoodsShowListVO;
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.integral.tools.IntegralViewTools;
import com.sinco.carnation.operation.service.CouponInfoService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.CartTools;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.pay.tools.PaymentTools;
import com.sinco.carnation.sales.service.EnoughReduceService;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.bo.PredepositBO;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.vo.GoodsCartMyVO;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.tools.StoreViewTools;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.transport.tools.TransportTools;
import com.sinco.carnation.user.bo.AddressBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.exception.MoneyPasswordNullConsumption;
import com.sinco.carnation.user.model.Address;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.AddressService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.DicNameMappingHandle;
import com.weixin.utils.QRCodeUtils;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.common.collect.Maps;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.domain.virtual.SysMap;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.Md5Encrypt;
import vc.thinker.b2b2c.core.tools.WebForm;
import vc.thinker.b2b2c.core.tools.XMLUtil;
import vc.thinker.b2b2c.lucene.LuceneUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * 
 * <p>
 * Title: CartViewAction.java
 * </p>
 * 
 * <p>
 * Description:购物控制器,包括购物车所有操作及订单相关操作。主要包含：购物三个主要流程、F码购物、添加商品到购物车、从购物车移除商品、 购物地址处理、各种付款方式付款等等
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
 * @author thinker、hezeng
 * 
 * @date 2014-5-14
 * 
 * @version 1.0.1
 */
@Controller
@SuppressWarnings({"rawtypes", "unused", "unchecked", "static-access"})
public class CartViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private GoodsCartService goodsCartService;
	@Autowired
	private StoreService storeService;
//	@Autowired
//	private GroupGoodsService groupGoodsService;
	@Autowired
	private CouponInfoService couponInfoService;
	@Autowired
	private MsgTools msgTools;
	@Autowired
	private PaymentTools paymentTools;
	@Autowired
	private PayTools payTools;
	@Autowired
	private TransportTools transportTools;
	@Autowired
	private GoodsViewTools goodsViewTools;
	@Autowired
	private StoreViewTools storeViewTools;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private CartTools cartTools;
	@Autowired
	private GoodsCaseViewTools goodsCaseViewTools;
//	@Autowired
//	private GroupLifeGoodsService groupLifeGoodsService;
//	@Autowired
//	private GroupInfoService groupInfoService;
	@Autowired
	private MessageService messageService;
//	@Autowired
//	private GroupViewTools groupViewTools;
	@Autowired
	private LuceneVoTools luceneVoTools;
//	@Autowired
//	private UserTools userTools;
	@Autowired
	private PayoffLogService payoffLogService;
	@Autowired
	private IntegralGoodsOrderService igorderService;
	@Autowired
	private EnoughReduceService enoughReduceService;
	@Autowired
	private BuyGiftService buyGiftService;
	@Autowired
	private CombinPlanService combinplanService;
//	@Autowired
//	private CombinTools combinTools;
//	@Autowired
//	private BuyGiftViewTools buyGiftViewTools;
	@Autowired
	private IntegralViewTools integralViewTools;
	@Autowired
	private ActivityGoodsService actgoodsService;
	@Autowired
	private ActivityViewTools activityTools;
//	@Autowired
//	private DeliveryAddressService deliveryaddrService;
	@Autowired
	private GoodsLogService goodsLogService;
//	@Autowired
//	private DeliveryAddressTools DeliveryAddressTools;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private SellerService sellerService;

	@Autowired
	private GoodsClassService goodsClassService;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private DicContent dicContent;

	@Autowired
	private DicNameMappingHandle mappingHandle;
	
	@Autowired
	private PredepositService predepositService;
	
	@RequestMapping("/cart_menu_detail.htm")
	public ModelAndView cart_menu_detail(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("cart_menu_detail.html",
				configService.getSysConfig(),1, request, response);

		CustomerUserDetails userDetails=(CustomerUserDetails)SecurityUserHolder.getCurrentUserDetails();
		User user=userDetails!= null ?userDetails.getUser():null;
		Long storeId=userDetails != null?userDetails.getStoreId():null;

		String cart_session_id=this.goodsCaseViewTools.getCartSessionId(request, response);

		List<GoodsCartBO> carts=goodsCartService.findUserCart(user,storeId,cart_session_id,false);

		if (carts.size() > 0) {
			mv.addObject("total_price", goodsCartService.calCartPrice(carts, null));
			mv.addObject("carts", carts);
		}
		return mv;
	}

	/**
	 * 添加商品到购物车
	 *
	 * @param request
	 * @param response
	 * @param id
	 *            添加到购物车的商品id
	 * @param count
	 *            添加到购物车的商品数量
	 * @param price
	 *            添加到购物车的商品的价格,该逻辑会更加gsp再次计算实际价格，避免用户在前端篡改
	 * @param gsp
	 *            商品的属性值，这里传递id值，如12,1,21
	 * @param buy_type
	 *            购买的商品类型，组合销售时用于判断是套装购买还是配件购买,普通商品：不传值，配件组合:parts,组合套装：suit
	 * @param combin_ids
	 *            组合搭配中配件id
	 * @param combin_version
	 *            组合套装中套装版本
	 */
	@RequestMapping("/add_goods_cart.htm")
	public void add_goods_cart(HttpServletRequest request,
			HttpServletResponse response, String id, String count,
			String price, String gsp, String buy_type, String combin_ids,
			String combin_version) {
		int next = 0;// 0为添加成功，-3库存不足,
						// -1添加失败，-2商品下架，添加失败，-4不能购买自己的商品，0普通商品添加,1组合配件添加，2组合套装添加

		GoodsBO goods = this.goodsService.findBOByid(CommUtil.null2Long(id));

		CustomerUserDetails userDetails=(CustomerUserDetails)SecurityUserHolder.getCurrentUserDetails();
		User user=userDetails!= null ?userDetails.getUser():null;
		Long storeId=userDetails != null?userDetails.getStoreId():null;

		String cart_session_id=this.goodsCaseViewTools.getCartSessionId(request, response);

		List<GoodsCartBO> carts=goodsCartService.findUserCart(user,storeId,cart_session_id,false);

		next=this.goodsCartService.addGoods(CommUtil.null2Long(id),
				count, gsp, buy_type, combin_ids,
				combin_version, cart_session_id, user, carts,null);

		carts = this.goodsCartService.findUserCart(user,storeId,cart_session_id,false);

		Map json_map = new HashMap();
		json_map.put("count", carts.size());
		json_map.put("code", next);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(json_map, JsonFormat.compact()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 立即购买(网页立即购买，跳订单页面)
	 *
	 * @param request
	 * @param response
	 * @param id
	 *            添加到购物车的商品id
	 * @param count
	 *            添加到购物车的商品数量
	 * @param price
	 *            添加到购物车的商品的价格,该逻辑会更加gsp再次计算实际价格，避免用户在前端篡改
	 * @param gsp
	 *            商品的属性值，这里传递id值，如12,1,21
	 * @param buy_type
	 *            购买的商品类型，组合销售时用于判断是套装购买还是配件购买,普通商品：不传值，配件组合:parts,组合套装：suit
	 * @param combin_ids
	 *            组合搭配中配件id
	 * @param combin_version
	 *            组合套装中套装版本
	 */
	@RequestMapping("/buy_goods_cart.htm")
	public ModelAndView bug_goods_cart(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("id") String id, @RequestParam("count") String count,
			@RequestParam("price") String price, @RequestParam("gsp") String gsp) {
		
		//GoodsBO goods = this.goodsService.findBOByid(CommUtil.null2Long(id));
		
		CustomerUserDetails userDetails=(CustomerUserDetails)SecurityUserHolder.getCurrentUserDetails();
		User user=userDetails!= null ?userDetails.getUser():null;
		//Long storeId=userDetails != null?userDetails.getStoreId():null;
		
		String cart_session_id=this.goodsCaseViewTools.getCartSessionId(request, response);
		
		try {
			GoodsCart addCart=this.goodsCartService.buyGoods(CommUtil.null2Long(id),count, gsp,cart_session_id, user);
			//转到订单确认
			return new ModelAndView("redirect:/goods_cart2.htm?isBuyGoods=true&gcs="+addCart.getId());
		} catch (ServiceException e) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(),1, request,response);
			mv.addObject("op_title", e.getErrorCode());
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
	}
	
	/**
	 * 立即购买
	 *
	 * @param request
	 * @param response
	 * @param id
	 *            添加到购物车的商品id
	 * @param count
	 *            添加到购物车的商品数量
	 * @param price
	 *            添加到购物车的商品的价格,该逻辑会更加gsp再次计算实际价格，避免用户在前端篡改
	 * @param gsp
	 *            商品的属性值，这里传递id值，如12,1,21
	 * @param buy_type
	 *            购买的商品类型，组合销售时用于判断是套装购买还是配件购买,普通商品：不传值，配件组合:parts,组合套装：suit
	 * @param combin_ids
	 *            组合搭配中配件id
	 * @param combin_version
	 *            组合套装中套装版本
	 */
	@RequestMapping("/bug_goods_cart.htm")
	public ModelAndView buy_goods_cart(HttpServletRequest request,
			HttpServletResponse response, String id, String count,
			String price, String gsp) {
		
		GoodsBO goods = this.goodsService.findBOByid(CommUtil.null2Long(id));
		
		CustomerUserDetails userDetails=(CustomerUserDetails)SecurityUserHolder.getCurrentUserDetails();
		User user=userDetails!= null ?userDetails.getUser():null;
		Long storeId=userDetails != null?userDetails.getStoreId():null;
		
		String cart_session_id=this.goodsCaseViewTools.getCartSessionId(request, response);
		
		try {
			GoodsCart addCart=this.goodsCartService.buyGoods(CommUtil.null2Long(id),count, gsp,cart_session_id, user);
			//转到订单确认
			return new ModelAndView("redirect:/goods_cart2.htm?isBuyGoods=true&gcs="+addCart.getId());
		} catch (ServiceException e) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(),1, request,response);
			mv.addObject("op_title", e.getErrorCode());
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
	}

	/**
	 * 从购物车移除商品
	 *
	 * @param request
	 * @param response
	 * @param id
	 * @param count
	 * @param price
	 * @param spec_info
	 */
	@RequestMapping("/remove_goods_cart.htm")
	public void remove_goods_cart(HttpServletRequest request,
			HttpServletResponse response, String ids) {
		Double total_price = 0.00;
		String code = "100";// 100表示删除成功，200表示删除失败
		List<String> list_ids = new ArrayList<String>();
		String cart_session_id=this.goodsCaseViewTools.getCartSessionId(request, response);

		if (ids != null && !ids.equals("")) {
			String cart_ids[] = ids.split(",");
			for (String id : cart_ids) {
				if(StringUtils.isNotBlank(id)){
					list_ids.add(id);
				}
			}
			this.goodsCartService.removeGoods(cart_ids);
		} else {
			code = "200";
		}

		CustomerUserDetails userDetails=(CustomerUserDetails)SecurityUserHolder.getCurrentUserDetails();
		User user=userDetails!= null ?userDetails.getUser():null;
		Long storeId=userDetails != null?userDetails.getStoreId():null;

		List<GoodsCartBO> carts=goodsCartService.findUserCart(user,storeId,cart_session_id,false);

		total_price = this.goodsCartService.calCartPrice(carts, null);
		Map map = new HashMap();
		map.put("total_price", BigDecimal.valueOf(total_price));
		map.put("code", code);
		map.put("count", carts.size());
		map.put("ids", list_ids);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(map, JsonFormat.compact()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}




	/**
	 * 获得商品佣金
	 *
	 * @param request
	 * @param response
	 */
	private double getGoodscartCommission(GoodsCartBO gc) {
		GoodsClass goodsClass=this.goodsClassService.getObjById(gc.getGoods().getGcId());
		double commission_price = CommUtil.mul(goodsClass.getCommissionRate(),
				CommUtil.mul(gc.getPrice(), gc.getCount()));
		return commission_price;
	}

	/**
	 * 获得商品佣金
	 *
	 * @param request
	 * @param response
	 */
	private double getOrderCommission(List<GoodsCartBO> gcs) {
		double commission_price = 0.00;
		for (GoodsCartBO gc : gcs) {
			commission_price = commission_price
					+ this.getGoodscartCommission(gc);
		}
		return commission_price;
	}

	/**
	 * 商品数量调整
	 *
	 * @param request
	 * @param response
	 * @param id
	 * @param store_id
	 */
	@RequestMapping("/goods_count_adjust.htm")
	public void goods_count_adjust(HttpServletRequest request,
			HttpServletResponse response, String gc_id, String count,
			String gcs, String gift_id) {
		Map map = new HashMap();
		String code = "100";// 100表示修改成功，200表示库存不足,300表示团购库存不足
		double total_price = 0.00;// 购物车总价钱
		String cart_type = "";// 判断是否为组合销售
		String cart_session_id=this.goodsCaseViewTools.getCartSessionId(request, response);
		int temp_count = CommUtil.null2Int(count);

		String [] gcIds=null;
		if(StringUtils.isNotBlank(gcs)){
			gcIds=gcs.split(",");
		}
		try {
			GoodsCartBO gc = this.goodsCartService.adjustGoodsCount(gc_id, count, gcIds, gift_id);
			if(gc != null){
				map.put("gc_price", CommUtil.formatMoney(gc.getTotlePrice()));
				map.put("count", gc.getCount());
			}
		} catch (ServiceNORollbackException e) {
			code=e.getErrorCode();
		}

		CustomerUserDetails userDetails=(CustomerUserDetails)SecurityUserHolder.getCurrentUserDetails();
		User user=userDetails!= null ?userDetails.getUser():null;
		Long storeId=userDetails != null?userDetails.getStoreId():null;

		List<GoodsCartBO> carts=goodsCartService.findUserCart(user,storeId,cart_session_id,false);

		total_price = this.goodsCartService.calCartPrice(carts, gcIds);
		Map price_map =this.goodsCartService.calEnoughReducePrice(carts, gcIds);
		Map<Long, String> erMap = (Map<Long, String>) price_map.get("erString");
		map.put("total_price", CommUtil.formatMoney(total_price));
		map.put("code", code);
		map.put("enough_reduce_price",
				CommUtil.formatMoney(price_map.get("reduce")));
		map.put("before", CommUtil.formatMoney(price_map.get("all")));
		for (long k : erMap.keySet()) {
			map.put("erString" + k, erMap.get(k));
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(map, JsonFormat.compact()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@RequestMapping("/goods_cart0.htm")
	public ModelAndView goods_cart0(HttpServletRequest request,
			HttpServletResponse response, String gid) {
		ModelAndView mv = new JModelAndView("goods_cart0.html",
				configService.getSysConfig(),
				1, request, response);
		// 同类其他商品
		GoodsBO goods = this.goodsService.findBOByid(CommUtil.null2Long(gid));
		if (goods != null) {
			GoodsShowListVO vo=new GoodsShowListVO();
			vo.setGoodsStatus(GoodsConstants.GOODS_STATUS_SELLING);
			vo.setGcId(vo.getGcId());
			vo.setNotId(goods.getId());
			vo.setCount(9);
			List<GoodsBO> class_goods = this.goodsService.findShopListBO(vo);
			mv.addObject("class_goods", class_goods);
		}
//		// 当天直通车商品，并且随机显示6个,显示在goods_cart0.html您可能还需要以下商品中
//		List<Goods> ztc_goods = this.goodsViewTools.query_Ztc_Goods(6);
//		mv.addObject("ztc_goods", ztc_goods);
		String return_url = CommUtil.getURL(request) + "/goods_" + gid + ".htm";
		if (goods != null && goods.getGoodsType() == GoodsConstants.GOODS_TYPE_SHOP) {
			if (this.configService.getSysConfig().getSecondDomainOpen()
					&& StringUtils.isNotBlank(goods.getStoreSecondDomain() )) {
				String store_second_domain = "http://"
						+ goods.getStoreSecondDomain() + "."
						+ CommUtil.generic_domain(request);
				return_url = store_second_domain + "/goods_" + gid + ".htm";
			}
		}
		mv.addObject("return_url", return_url);
		return mv;
	}

	/**
	 * 确认购物车商品
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/goods_cart1.htm")
	public ModelAndView goods_cart1(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("goods_cart1.html",
				configService.getSysConfig(),
				1, request, response);
		// 当天直通车商品，
		mv.addObject("goodsViewTools", goodsViewTools);
		return mv;
	}

	/**
	 * 确认购物车商品
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/goods_cart1_load.htm")
	public ModelAndView goods_cart1_load(HttpServletRequest request,
			HttpServletResponse response, String load_class) {
		/*H5*/
/*		ModelAndView mv = new JModelAndView("goods_cart1_load.html",
				configService.getSysConfig(),1, request, response);*/
		ModelAndView mv = new JModelAndView("web_mobile/addCar.html",
				configService.getSysConfig(),1, request, response);

		CustomerUserDetails userDetails=(CustomerUserDetails)SecurityUserHolder.getCurrentUserDetails();
		User user=userDetails!= null ?userDetails.getUser():null;
		Long storeId=userDetails != null?userDetails.getStoreId():null;

		String cart_session_id=this.goodsCaseViewTools.getCartSessionId(request, response);

		List<GoodsCartBO> carts=goodsCartService.findUserCart(user,storeId,cart_session_id,false);

		if (carts.size() > 0) {
			List<GoodsCartBO> yungou_goods = new ArrayList<GoodsCartBO>();
			List<GoodsCartBO> native_goods = new ArrayList<GoodsCartBO>();
			List<GoodsCartBO> cn_goods = new ArrayList<GoodsCartBO>();
			Map<Long, String> erString = new HashMap<Long, String>();
			for (GoodsCartBO cart : carts) {
				if (cart.getGoods().getOrderEnoughGiveStatus() == 1 && cart.getGoods().getBuyGiftId() != null) {
//					BuyGift bg = this.buyGiftService.getObjById(cart.getGoods()
//							.getBuyGift_id());
//					if (bg.getBeginTime().before(date)) {
//						set.add(cart.getGoods().getBuyGift_id());
//					} else {
//						native_goods.add(cart);
//					}
				} else if (cart.getGoods().getEnoughReduce() == 1) {// 满就减
//					String er_id = cart.getGoods().getOrder_enough_reduce_id();
//					EnoughReduce er = this.enoughReduceService
//							.getObjById(CommUtil.null2Long(er_id));
//					if (er.getErbegin_time().before(date)) {
//						if (ermap.containsKey(er.getId())) {
//							ermap.get(er.getId()).add(cart);
//						} else {
//							List<GoodsCart> list = new ArrayList<GoodsCart>();
//							list.add(cart);
//							ermap.put(er.getId(), list);
//							Map map = (Map) Json.fromJson(er.getEr_json());
//							double k = 0;
//							String str = "";
//							for (Object key : map.keySet()) {
//								if (k == 0) {
//									k = Double.parseDouble(key.toString());
//									str = "活动商品购满" + k + "元，即可享受满减";
//								}
//								if (Double.parseDouble(key.toString()) < k) {
//									k = Double.parseDouble(key.toString());
//									str = "活动商品购满" + k + "元，即可享受满减";
//								}
//							}
//							erString.put(er.getId(), str);
//						}
//					} else {
//						native_goods.add(cart);
//					}
				} else if (cart.getExPriceFlag()==GoodsCart.EXPEICEFLAG_YES) {
					goodsService.cartGoodsMulSpecHandler(cart, cart.getGoods());
					cn_goods.add(cart);
				}else if( null != cart.getIsYgb() && cart.getIsYgb().intValue() == 1 )
				{
					yungou_goods.add(cart);
				} 
				else if (null != cart.getIsYgb() && cart.getIsYgb().intValue() == 0 ) 
				{
					native_goods.add(cart);
				}
			}
			mv.addObject("erString", erString);
			mv.addObject("yungouCart", yungou_goods);//云购币商品购物车
			mv.addObject("cnCart", cn_goods);//云购币商品购物车
//			mv.addObject("er_goods", ermap);// 满就减
//			Map<String, List<GoodsCart>> separate_carts = this
//					.separateCombin(native_goods);// 传入没有分离组合活动商品的购物车
//			mv.addObject("cart", (List<GoodsCart>) separate_carts.get("normal"));// 无活动的商品购物车
			mv.addObject("cart", native_goods);// 无活动的商品购物车
			mv.addObject("userId", user.getId());// 
			//购物车商品所属商家
			/*if(native_goods != null){
				List<GoodsCartBO> store_goods = new ArrayList<GoodsCartBO>();
				store_goods=native_goods;
				for (int i = 0; i < store_goods.size(); i++){
	                for (int j = store_goods.size() - 1 ; j > i; j--){
	                    if(store_goods.get(i).getGoods().getGoodsType()!=0 && store_goods.get(j).getGoods().getGoodsType()!=0){
	                    	if (store_goods.get(i).getStoreName() != null && store_goods.get(j).getStoreName() != null
	                    			&& store_goods.get(i).getStoreName().equals(store_goods.get(j).getStoreName()))
		                    {
		                    	store_goods.remove(j);
		                    }
	                    }
	                }
	            }
				mv.addObject("stgd",store_goods);
			}
			*/
//			mv.addObject("combin_carts",
//					(List<GoodsCart>) separate_carts.get("combin"));// 组合套装商品购物车
//			// 将有活动的商品分组(满就送)
//			if (set.size() > 0) {
//				Map<Long, List<GoodsCart>> map = new HashMap<Long, List<GoodsCart>>();
//				for (Long id : set) {
//					map.put(id, new ArrayList<GoodsCart>());
//				}
//				for (GoodsCart cart : carts) {
//					if (cart.getGoods().getOrder_enough_give_status() == 1
//							&& cart.getGoods().getBuyGift_id() != null) {
//						if (map.containsKey(cart.getGoods().getBuyGift_id())) {
//							map.get(cart.getGoods().getBuyGift_id()).add(cart);
//						}
//					}
//				}
//				mv.addObject("ac_goods", map);
//			}
		}
		// 当天直通车商品，
//		if (load_class != null) {
//			mv.addObject("load_class", load_class);
//		}
		
		//List<AddressBO> addrs = this.addressService.findShopByUid(user.getId());
		//mv.addObject("addrs", addrs);
		
		mv.addObject("goodsViewTools", goodsViewTools);
		//是否有默认地址
		Address defAddr = addressService.getDefaultByUserId(user.getId());
		if(defAddr == null || defAddr.getAreaId() == null || StringUtils.isBlank(defAddr.getAreaInfo()) 
				|| StringUtils.isBlank(defAddr.getMobile()) || StringUtils.isBlank(defAddr.getTrueName())){
			mv.addObject("hasDefaultAddress", false);
		}else{
			mv.addObject("hasDefaultAddress", true);
		}
		return mv;
	}

	/**
	 * 购物车修改商品规格
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/goods_cart1_spec.htm")
	public ModelAndView goods_cart1_spec(HttpServletRequest request,
			HttpServletResponse response, String cart_id) {
		ModelAndView mv = new JModelAndView("goods_cart1_spec.html",
				configService.getSysConfig(),
				1, request, response);
		GoodsCart cart = this.goodsCartService.getObjById(CommUtil
				.null2Long(cart_id));
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("cart", cart);
		return mv;
	}

	/**
	 * 购物确认,填写用户地址，配送方式，支付方式等
	 *
	 * @param request
	 * @param response
	 * @param gcs
	 * @param giftids
	 * @param isBuyGoods 是否立即购买
	 * @return
	 */
	@SecurityMapping(title = "确认购物车第二步", value = "/goods_cart2.htm*", rtype = "buyer", rname = "购物流程2", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/goods_cart2.htm")
	public ModelAndView goods_cart2(HttpServletRequest request,
			HttpServletResponse response, String gcs, String giftids,Boolean isBuyGoods) {
		ModelAndView mv = new JModelAndView("goods_cart2.html",
				configService.getSysConfig(),
				1, request, response);
		if (gcs == null || gcs.equals("")) {
			mv = new JModelAndView("error.html", configService.getSysConfig(),
					1, request,
					response);
			mv.addObject("op_title", "参数错误，请重新进入购物车");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}


		CustomerUserDetails userDetails=(CustomerUserDetails)SecurityUserHolder.getCurrentUserDetails();
		User user=userDetails!= null ?userDetails.getUser():null;
		Long storeId=userDetails != null?userDetails.getStoreId():null;

		String cart_session_id=this.goodsCaseViewTools.getCartSessionId(request, response);

		//立即购买处理
		List<GoodsCartBO> carts=null;
		if(isBuyGoods != null && isBuyGoods){
			carts=goodsCartService.findUserBuyCart(user.getId(),cart_session_id,false);
		}else{
			carts=goodsCartService.findUserCart(user,storeId,cart_session_id,false);
		}


		boolean goods_cod = true;// 默认支持货到付款，这样有一款产品不支持货到付款，这个订单就不支持货到付款
		int tax_invoice = 1;// 默认可以开具增值税发票，只要存在一款产品不支持增值税发票，整体订单不可以开具增值税发票

		String [] gcIds=null;
		if(StringUtils.isNotBlank(gcs)){
			gcIds=gcs.split(",");
		}
		if (carts.size() > 0) {
			List<AddressBO> addrs = this.addressService.findShopByUid(user.getId());

			mv.addObject("addrs", addrs);
			// cart_session 防止重复提交
			String cart_session = CommUtil.randomString(32);
			request.getSession(false).setAttribute("cart_session", cart_session);
			
			//计算价格
			Map erpMap = this.goodsCartService.calEnoughReducePrice(carts, gcIds);
			mv.addObject("cart_session", cart_session);
			mv.addObject("transportTools", transportTools);
			mv.addObject("goodsViewTools", goodsViewTools);
			mv.addObject("order_goods_price", erpMap.get("all"));
			mv.addObject("order_er_price", erpMap.get("reduce"));
			
			
			List map_list = new ArrayList();
			Set<Object> store_list = new HashSet<Object>();
			for (GoodsCartBO gc : carts) {
				if (gc.getGoods().getGoodsType() == GoodsConstants.GOODS_TYPE_SHOP) {
					store_list.add(gc.getGoods().getGoodsStoreId());
				} else {
					store_list.add("self");
				}
			}
			
			for (Object sl : store_list) {
				if (sl != "self" && !sl.equals("self")) {// 商家商品
					List<GoodsCartBO> gc_list = new ArrayList<GoodsCartBO>();
					List<GoodsCartBO> amount_gc_list = new ArrayList<GoodsCartBO>();
					Map<Long, List<GoodsCart>> ermap = new HashMap<Long, List<GoodsCart>>();
					Map<Long, String> erString = new HashMap<Long, String>();
					for (GoodsCartBO gc : carts) {
						for (String gc_id : gcIds) {
							if (StringUtils.isNotBlank(gc_id)
									&& CommUtil.null2Long(gc_id).equals(gc.getId())) {
								if (gc.getGoods().getGoodsStoreId() != null 
										&& gc.getGoods().getGoodsStoreId().equals(sl)) {
									
									if (gc.getCount() == 0) {
										mv = new JModelAndView("error.html",configService.getSysConfig(),1,request, response);
										mv.addObject("op_title", "订单中商品["+gc.getGoods().getGoodsName()+"]信息已变更，请删除后再提交订单");
										mv.addObject("url", CommUtil.getURL(request)
												+ "/goods_cart1.htm");
										return mv;
									}
									
									gc_list.add(gc);
									amount_gc_list.add(gc);
								}
							}
						}
					}
					if ((gc_list != null && gc_list.size() > 0)
							|| (ermap != null && ermap.size() > 0)) {
						Map map = new HashMap();
//						Map ergcMap = this.goodsCartService.calEnoughReducePrice(amount_gc_list,gcIds);// 满减相关信息
//						if (ermap.size() > 0) {
//							map.put("er_goods", ermap);
//							map.put("erString", ergcMap.get("erString"));
//						}
						map.put("store_id", sl);
						map.put("store", this.storeService.getObjById(CommUtil
								.null2Long(sl)));
						map.put("store_goods_price",this.goodsCartService.calCartPrice(amount_gc_list, gcIds));
//						map.put("store_enough_reduce", ergcMap.get("reduce"));
						map.put("gc_list", gc_list);
						map_list.add(map);
					}
					for (GoodsCartBO gc : gc_list) {
						if (gc.getGoods().getGoodsCod() == -1 || gc.getGoods().getGoodsChoiceType() == 1) {// 只要存在一件不允许使用货到付款购买的商品整个订单就不允许使用货到付款
							goods_cod = false;
						}
						if (gc.getGoods().getTaxInvoice() == 0) {// 只要存在一件不支持开具增值税发票的商品，整个订单就不允许开具增值税发票
							tax_invoice = 0;
						}
					}
				} else {// 自营商品
					List<GoodsCartBO> gc_list = new ArrayList<GoodsCartBO>();
					List<GoodsCartBO> amount_gc_list = new ArrayList<GoodsCartBO>();
					Map<Long, String> erString = new HashMap<Long, String>();
					
					for (GoodsCartBO gc : carts) {
						for (String gc_id : gcIds) {
							if (StringUtils.isNotBlank(gc_id)
									&& CommUtil.null2Long(gc_id).equals(gc.getId())) {
								if (gc.getGoods().getGoodsStoreId() == null) {
									gc_list.add(gc);
									amount_gc_list.add(gc);
								}
							}
						}
					}
					if ((gc_list != null && gc_list.size() > 0)) {
						Map map = new HashMap();
//						Map ergcMap = this.goodsCartService.calEnoughReducePrice(amount_gc_list,
//								gcIds);// 满减相关信息
//						if (gift_map.size() > 0) {
//							map.put("ac_goods", gift_map);
//						}
//						if (ermap.size() > 0) {
//							map.put("er_goods", ermap);
//							map.put("erString", ergcMap.get("erString"));
//						}
						map.put("store_id", sl);
						map.put("store_goods_price",this.goodsCartService.calCartPrice(amount_gc_list, gcIds));
//						map.put("store_enough_reduce", ergcMap.get("reduce"));
						map.put("gc_list", gc_list);
						map_list.add(map);
					}
					for (GoodsCartBO gc : gc_list) {
						if (gc.getGoods().getGoodsCod() == -1 || gc.getGoods().getGoodsChoiceType() == 1) {// 只要存在一件不允许使用货到付款购买的商品整个订单就不允许使用货到付款
							goods_cod = false;
						}
						if (gc.getGoods().getTaxInvoice() == 0) {// 只要存在一件不支持开具增值税发票的商品，整个订单就不允许开具增值税发票
							tax_invoice = 0;
						}
					}
				}
			}
			// 生成7天时间区间，目前不支持选择到货时间 
			List days = new ArrayList();
			List day_list = new ArrayList();
			for (int i = 0; i < 7; i++) {
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_YEAR, i);
				days.add(CommUtil.formatTime("MM-dd", cal.getTime()) + "<br />"+ this.genericDay(cal.get(Calendar.DAY_OF_WEEK)));
				day_list.add(CommUtil.formatTime("MM-dd", cal.getTime()) + this.genericDay(cal.get(Calendar.DAY_OF_WEEK)));
			}
			// 比较当日时间段
			Calendar cal = Calendar.getInstance();
			mv.addObject("before_time1", cal.getTime().before(CommUtil
					.formatDate(CommUtil.formatTime("yyyy-MM-dd 15:00:00", new Date()), "yyyy-MM-dd HH:mm:ss")));
			mv.addObject("before_time2", cal.getTime().before(CommUtil
					.formatDate(CommUtil.formatTime("yyyy-MM-dd 19:00:00", new Date()), "yyyy-MM-dd HH:mm:ss")));
			mv.addObject("before_time3", cal.getTime().before(CommUtil
					.formatDate(CommUtil.formatTime("yyyy-MM-dd 22:00:00", new Date()), "yyyy-MM-dd HH:mm:ss")));
			mv.addObject("user", customerService.findSessionUser(userDetails.getId()));
			mv.addObject("days", days);
			mv.addObject("day_list", day_list);
			mv.addObject("storeViewTools", storeViewTools);
			mv.addObject("cartTools", cartTools);
			mv.addObject("transportTools", transportTools);
//			mv.addObject("userTools", this.userTools);
			mv.addObject("map_list", map_list);
			mv.addObject("gcs", gcs);
			mv.addObject("goods_cod", goods_cod);
			mv.addObject("tax_invoice", tax_invoice);
			mv.addObject("giftids", giftids);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(),
					1, request,
					response);
			mv.addObject("op_title", "购物车信息为空");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}

		return mv;
	}

	private String genericDay(int day) {
		String[] list = new String[] { "星期日", "星期一", "星期二", "星期三", "星期四",
				"星期五", "星期六" };
		return list[day - 1];
	}

	@SecurityMapping(title = "完成订单提交进入支付", value = "/goods_cart3.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/goods_cart3.htm")
	public ModelAndView goods_cart3(HttpServletRequest request,
			HttpServletResponse response, String cart_session, String store_id,
			String addr_id, String gcs, String delivery_time,
			String delivery_type, String delivery_id, String payType,
			String gifts) throws Exception {
		ModelAndView mv = new JModelAndView("order_pay.html",
				configService.getSysConfig(),
				1, request, response);
		String cart_session1 = (String) request.getSession(false).getAttribute(
				"cart_session");

		if( cart_session1 == null || !cart_session1.equals(cart_session)
				|| StringUtils.isBlank(store_id)){
			mv = new JModelAndView("error.html", configService.getSysConfig(),
					1, request,
					response);
			mv.addObject("op_title", "订单已经失效");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}

		User user=SecurityUserHolder.getCurrentUser();
		Date date = new Date();
		String[] gc_ids = gcs.split(",");

		//满就送
//			String[] gift_ids = gifts.split(",");
//			List<Goods> gift_goods = new ArrayList<Goods>();
//
//			for (String gid : gift_ids) {
//				Goods goods = this.goodsService.getObjById(CommUtil
//						.null2Long(gid));
//				if (goods != null) {
//					BuyGift bg = this.buyGiftService.getObjById(CommUtil
//							.null2Long(goods.getBuyGift_id()));
//					if (bg != null && bg.getBeginTime().before(date)) {
//						gift_goods.add(goods);
//					}
//				}
//			}
		List<Long> ids=Lists.newArrayList();
//
		for (String gc_id : gc_ids) {
			if (StringUtils.isNotBlank(gc_id)) {
				ids.add(CommUtil.null2Long(gc_id));
			}
		}
		GoodsCartMyVO vo=new GoodsCartMyVO();
		vo.setIds(ids);
		//找到要结算的购物车商品
		List<GoodsCartBO> order_carts = goodsCartService.findMyCart(vo);

		for (GoodsCartBO gc : order_carts) {
			if (gc.getGoods().getGoodsCod() == GoodsConstants.GOODS_COD_NO_1) {// 只要存在一件不允许使用货到付款购买的商品整个订单就不允许使用货到付款
				if (!payType.equals("online")) {// 订单不支持货到付款，用户从页面前端恶意篡改支付方式为货到付款
					mv = new JModelAndView("error.html",configService.getSysConfig(),1,request, response);
					mv.addObject("op_title", "您恶意篡改支付方式，订单已经失效");
					mv.addObject("url", CommUtil.getURL(request)
							+ "/index.htm");
					return mv;
				}
			}
		}


		// 验证库存不成功，返回购物车，并给出提示！

		if(order_carts.size() <= 0 ){
			mv = new JModelAndView("error.html",
					configService.getSysConfig(),
					1, request,
					response);
			mv.addObject("op_title", "订单信息错误");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}

		if (payType.equals("payafter")) {// 使用货到付款
			mv = new JModelAndView("payafter_pay.html",
					configService.getSysConfig(),
					1,
					request, response);
			String pay_session = CommUtil.randomString(32);
			request.getSession(false).setAttribute("pay_session",
					pay_session);
			mv.addObject("paymentTools", this.paymentTools);
			mv.addObject("pay_session", pay_session);
		}
		request.getSession(false).removeAttribute("cart_session");// 删除订单提交唯一标示，用户不能进行第二次订单提交

		String store_ids[] = store_id.split(",");
		
		Map<String, String> transports=Maps.newHashMap();
		Map<String, String> msgs=Maps.newHashMap();
		Map<String, Long> couponIds=Maps.newHashMap();

		for (String sid : store_ids) {
			String transport=request.getParameter("transport_"+sid);
			String msg=request.getParameter("msg_"+sid);
			String couponId=request.getParameter("coupon_id_"+sid);
			
			if(StringUtils.isNotBlank(transport)){
				transports.put(sid, transport);
			}
			if(StringUtils.isNotBlank(msg)){
				msgs.put(sid, msg);
			}
			if(StringUtils.isNotBlank(couponId)){
				couponIds.put(sid, CommUtil.null2Long(couponId));
			}
		}
		
		Map<Long, String> integralIds=Maps.newHashMap();
		//设置积分兑购参数
		for (GoodsCartBO gc : order_carts) {
			String isIntegral=request.getParameter("integral_"+gc.getId());
			if(isIntegral != null){
				integralIds.put(gc.getId(), isIntegral);
			}
		}

		UserCustomerBO customer=customerService.findSessionUser(user.getId());

		String servicePath= CommUtil.getURL(request);
		String domain=CommUtil.generic_domain(request);

		//发票方式与抬头
		Integer invoiceType=CommUtil.null2Int(request.getParameter("invoiceType"));
		String invoice=request.getParameter("invoice");

		try {
			OrderFormBO mainOrder=this.goodsCartService.createOrderForm
					(order_carts, user.getId(), servicePath, CommUtil.null2Long(addr_id), 
							transports,msgs,couponIds,integralIds,
							store_ids, gc_ids, invoiceType, invoice, delivery_time,false,null,null);

			mv.addObject("order", mainOrder);// 将主订单信息封装到前台视图中
			mv.addObject("customer", customer);
			mv.addObject("all_of_price", this.orderFormTools.query_order_price(mainOrder)); // XXX 商品订单需付金额
			mv.addObject("paymentTools", paymentTools);
			mv.addObject("payTools", payTools);
			return mv;
		} catch (ServiceException e) {
			mv = new JModelAndView("error.html",
					configService.getSysConfig(),
					1, request,
					response);
			mv.addObject("op_title", e.getErrorCode());
			mv.addObject("url", CommUtil.getURL(request)
					+ "/goods_cart1.htm");
			return mv;
		}
	}

	@SecurityMapping(title = "订单支付详情", value = "/order_pay_view.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/order_pay_view.htm")
	public ModelAndView order_pay_view(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("order_pay.html",
				configService.getSysConfig(),
				1, request, response);
		OrderForm of = this.orderFormService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails userDetails= (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		if (of != null && of.getUserId().equals(userDetails.getUser().getId())) {
			if (of.getOrderStatus() == 10) {
				if (of.getOrderCat() == 1) {// 处理手机充值付款
					mv = new JModelAndView("recharge_order.html",
							configService.getSysConfig(),
							1, request,
							response);
					String ofcard_userid = this.configService.getSysConfig()
							.getOfcardUserid();
					String ofcard_userpws = Md5Encrypt.md5(this.configService
							.getSysConfig().getOfcardUserpws());
					String rc_amount = CommUtil.null2String(of.getRcAmount());
					String mobile = of.getRcMobile();
					String query_url = "http://api2.ofpay.com/telquery.do?userid="
							+ ofcard_userid
							+ "&userpws="
							+ ofcard_userpws
							+ "&phoneno="
							+ mobile
							+ "&pervalue="
							+ rc_amount
							+ "&version=6.0";
					String return_xml = this.getHttpContent(query_url,
							"gb2312", "POST");
					Map map = XMLUtil.parseXML(return_xml, true);
					double inprice = CommUtil.null2Double(map.get("inprice"));
					if (CommUtil.null2Double(map.get("inprice")) <= CommUtil
							.null2Double(rc_amount)) {
						inprice = CommUtil.add(map.get("inprice"),
								this.configService.getSysConfig()
										.getOfcardMobileProfit());
						if (inprice > CommUtil.null2Double(rc_amount)) {
							inprice = CommUtil.null2Double(rc_amount);
						}
					}
					map.put("inprice", inprice);
					String recharge_pay_session = CommUtil.randomString(64);
					request.getSession(false).setAttribute(
							"recharge_pay_session", recharge_pay_session);
					mv.addObject("recharge_pay_session", recharge_pay_session);
					mv.addObject("map", map);
					mv.addObject("rc_amount", rc_amount);
					mv.addObject("mobile", mobile);
					mv.addObject("order", of);
				} else {
					boolean inventory_very = true;
					List<GoodsBO> goods_list = this.orderFormTools.queryOfGoods(id);
					for (GoodsBO obj : goods_list) {
						int order_goods_count = this.orderFormTools
								.queryOfGoodsCount(id,CommUtil.null2String(obj.getId()),obj.getGoodsSpecIds());
						String order_goods_gsp_ids = "";
						List<Map> goods_maps = this.orderFormTools
								.queryGoodsInfo(of.getGoodsInfo());
						for (Map obj_map : goods_maps) {
							if (CommUtil.null2String(obj_map.get("goods_id"))
									.equals(obj.getId().toString())) {
								order_goods_gsp_ids = CommUtil
										.null2String(obj_map
												.get("goods_gsp_ids"));
								break;
							}
						}
						// 真实商品库存
						int real_goods_count = CommUtil.null2Int(this.goodsService
								.generic_default_info(obj, order_goods_gsp_ids,userDetails.getCustomer())
								.get("count"));// 计算商品库存信息
						if (order_goods_count > real_goods_count) {
							inventory_very = false;
							break;
						}
					}
					if (inventory_very) {// 订单中商品库存验证成功
						UserCustomerBO customer=customerService.findSessionUser(userDetails.getId());
						mv.addObject("order", of);// 将主订单信息封装到前台视图中
						mv.addObject("customer", customer);
						mv.addObject("all_of_price", this.orderFormTools.query_order_price(of));
						mv.addObject("paymentTools", paymentTools);
						mv.addObject("payTools", payTools);
					} else {
						mv = new JModelAndView("error.html",
								configService.getSysConfig(),
								1,
								request, response);
						mv.addObject("op_title", "订单中商品库存不足，请重新下单");
						mv.addObject("url", CommUtil.getURL(request)
								+ "/buyer/order.htm");
					}
				}
			} else if (of.getOrderStatus() < 10) {
				mv = new JModelAndView("error.html",
						configService.getSysConfig(),
						1, request,
						response);
				mv.addObject("op_title", "该订单已经取消");
				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			} else {
				mv = new JModelAndView("error.html",
						configService.getSysConfig(),
						1, request,
						response);
				mv.addObject("op_title", "该订单已付款");
				mv.addObject("url", CommUtil.getURL(request)
						+ "/buyer/order.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(),
					1, request,
					response);
			mv.addObject("op_title", "该订单已失效");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}
		return mv;
	}
	
	//生成扫码回调
	@SecurityMapping(title = "微信扫码支付", value = "/wx_qr_pay.htm*", rtype = "buyer", rname = "微信扫码支付", rcode = "goods_cart", rgroup = "微信扫码支付")
	@RequestMapping("/wx_qr_pay.htm*")
	public ModelAndView wx_qr_pay(HttpServletRequest request,
			HttpServletResponse response, String code,Double totalFee,String orderNo,String type) {
		ModelAndView mv = new JModelAndView("wx_web_pay.html",
				configService.getSysConfig(),
				1, request,
				response);
		String qrcode = QRCodeUtils.encodeQrcode(code);

		mv.addObject("qrcode", qrcode);
		mv.addObject("totalFee", totalFee);
		mv.addObject("orderNo", orderNo);
		mv.addObject("type", type);
		return mv;
	}
	
	
	//点击确认支付
	@SecurityMapping(title = "订单支付", value = "/order_pay.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/order_pay.htm")
	public ModelAndView order_pay(HttpServletRequest request,
			HttpServletResponse response,
			String payType, String order_id
			,boolean isAvailableBalance,String paymentPassword) {
		ModelAndView mv = null;
		SysConfigBO config=configService.getSysConfig();
		
		Long uid=SecurityUserHolder.getCurrentUserId();
		
		if(StringUtils.isBlank(order_id)){
			mv = new JModelAndView("error.html", configService.getSysConfig(),1, request,response);
			mv.addObject("op_title", "参数错误，付款失败");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
		
		try {//增加云购币，临时修改，需要扩展kenny
			OrderFormBO order=this.orderFormService.orderPay(payType, CommUtil.null2Long(order_id), uid, 
					isAvailableBalance, paymentPassword, false, "","",false);
			//如果完成支付
			if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
				mv = new JModelAndView("order_finish.html",configService.getSysConfig(),1, request, response);
				mv.addObject("all_price", this.orderFormTools.query_order_price(order));
				mv.addObject("obj", order);
				return mv;
			}else{
				String type = PaymentConstants.ORDER_TYPE_GOODS;
				mv = new JModelAndView("line_pay.html",configService.getSysConfig(),1,request, response);
				//如果云豆支付
				if(OrderFormConstants.ORDER_PAY_TYPE_BALANCE.equals(order.getPayType())){
					mv.addObject("cash_id", order.getCashId());
					type=PaymentConstants.ORDER_TYPE_CASH;
					
					//云豆支付的支付方式id,在云豆充值记录上
					PredepositBO predeposit=this.predepositService.findBOById(order.getCashId());
					mv.addObject("payment_id", predeposit.getPaymentId());
					
				}else if(OrderFormConstants.ORDER_PAY_TYPE_ONLINE.equals(order.getPayType())){
					mv.addObject("order", order);
					mv.addObject("order_id", order.getId());
					mv.addObject("payment_id", order.getPaymentId());
					type = PaymentConstants.ORDER_TYPE_GOODS;
					if (order.getOrderCat() == 2) {
						type = PaymentConstants.ORDER_TYPE_GROUP;// 订单属性为生活类团购
					}
				}
				
				String[] tPayType = payType.split("-");
				String realPayType = tPayType[0];
				mv.addObject("payType", realPayType);
				if(realPayType.equals("alipayB") || realPayType.equals("alipayC")){
					mv.addObject("bank", payType.replace("alipayB-", "").replace("alipayC-",""));
				}
				mv.addObject("url", config.getAddress()); //测试先修改为我自己ip
				mv.addObject("payTools", payTools);
				mv.addObject("type", type);
				return mv;
			}
		} catch (ServiceException e) {
			mv = new JModelAndView("error.html", configService.getSysConfig(),1, request,response);
			if(e instanceof MoneyPasswordNullConsumption){
				mv.addObject("op_title","用户支付密码为空，请进行设置！");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/money_password.htm");
			}else{
				mv.addObject("op_title",e.getErrorCode());
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			}
		}
		return mv;
	}

//	@SecurityMapping(title = "订单货到付款", value = "/order_pay_payafter.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
//	@RequestMapping("/order_pay_payafter.htm")
//	public ModelAndView order_pay_payafter(HttpServletRequest request,
//			HttpServletResponse response, String payType, String order_id,
//			String pay_msg, String pay_session) throws Exception {
//		ModelAndView mv = new JModelAndView("success.html",
//				configService.getSysConfig(),
//				1, request, response);
//		String pay_session1 = CommUtil.null2String(request.getSession(false)
//				.getAttribute("pay_session"));
//		if (pay_session1.equals(pay_session)) {
//			OrderForm order = this.orderFormService.getObjById(CommUtil
//					.null2Long(order_id));
//			order.setPay_msg(pay_msg);
//			order.setPayTime(new Date());
//			order.setPayType("payafter");
//			order.setOrder_status(16);
//			this.orderFormService.update(order);
//			if (order.getOrder_main() == 1
//					&& !CommUtil.null2String(order.getChild_order_detail())
//							.equals("")) {
//				List<Map> maps = this.orderFormTools.queryGoodsInfo(order
//						.getChild_order_detail());
//				for (Map child_map : maps) {
//					OrderForm child_order = this.orderFormService
//							.getObjById(CommUtil.null2Long(child_map
//									.get("order_id")));
//					child_order.setOrder_status(16);
//					child_order.setPayType("payafter");
//					child_order.setPayTime(new Date());
//					child_order.setPay_msg(pay_msg);
//					this.orderFormService.update(child_order);
//					// 向加盟商家发送付款成功短信提示，自营商品无需发送短信提示
//					Store store = this.storeService.getObjById(CommUtil
//							.null2Long(child_order.getStore_id()));
//					if (child_order.getOrder_form() == 0) {
//						this.msgTools.sendSmsCharge(CommUtil.getURL(request),
//								"sms_toseller_payafter_pay_ok_notify", store
//										.getUser().getMobile(), null, CommUtil
//										.null2String(child_order.getId()),
//								child_order.getStore_id());
//						this.msgTools.sendEmailCharge(CommUtil.getURL(request),
//								"email_toseller_payafter_pay_ok_notify", store
//										.getUser().getEmail(), null, CommUtil
//										.null2String(child_order.getId()),
//								child_order.getStore_id());
//					}
//				}
//			}
//			// 记录支付日志
//			OrderFormLog ofl = new OrderFormLog();
//			ofl.setAddTime(new Date());
//			ofl.setLog_info("提交货到付款申请");
//			ofl.setLog_user(SecurityUserHolder.getCurrentUser());
//			ofl.setOf(order);
//			this.orderFormLogService.save(ofl);
//			request.getSession(false).removeAttribute("pay_session");
//			mv.addObject("op_title", "货到付款提交成功，等待发货");
//			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
//		} else {
//			mv = new JModelAndView("error.html", configService.getSysConfig(),
//					1, request,
//					response);
//			mv.addObject("op_title", "订单已经支付，禁止重复支付");
//			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
//		}
//		return mv;
//	}
//
	@SecurityMapping(title = "订单预付款支付", value = "/order_pay_balance.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/order_pay_balance.htm")
	public ModelAndView order_pay_balance(HttpServletRequest request,
			HttpServletResponse response, String payType, String order_id,
			String pay_msg,String password) {
		ModelAndView mv = new JModelAndView("success.html",
				configService.getSysConfig(),
				1, request, response);
		OrderForm order = this.orderFormService.getObjById(CommUtil.null2Long(order_id));
		Long uid=SecurityUserHolder.getCurrentUserId();
		
		try {
			this.orderFormService.completeMoneyPay(CommUtil.null2Long(order_id),password, pay_msg);
			mv.addObject("op_title", "云豆支付成功");
			mv.addObject("url", CommUtil.getURL(request)
						+ "/buyer/order.htm");
			
		}catch (ServiceException e) {
			mv = new JModelAndView("error.html", configService.getSysConfig(),1, request,response);
			if(e instanceof MoneyPasswordNullConsumption){
				mv.addObject("op_title","用户支付密码为空，请进行设置！");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/money_password.htm");
			}else{
				mv.addObject("op_title",e.getErrorCode());
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			}
		}
		return mv;
	}

	@SecurityMapping(title = "订单支付结果", value = "/order_finish.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/order_finish.htm")
	public ModelAndView order_finish(HttpServletRequest request,
			HttpServletResponse response, String order_id,String orderNo) {
		ModelAndView mv = new JModelAndView("order_finish.html",
				configService.getSysConfig(),
				1, request, response);
		OrderForm obj = null;
		if(StringUtils.isNotBlank(order_id)){
			obj=this.orderFormService.getObjById(CommUtil.null2Long(order_id));
			
		}else if(StringUtils.isNotBlank(orderNo)){
			//根据订单编号 
			obj=this.orderFormService.findByOrderNo(orderNo);
		}
		mv.addObject("obj", obj);
		mv.addObject("all_price",
				this.orderFormTools.query_order_price(obj.getId().toString()));
		return mv;
	}

	@SecurityMapping(title = "地址修改", value = "/cart_address.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/cart_address.htm")
	public ModelAndView cart_address(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("cart_address.html",
				configService.getSysConfig(),
				1, request, response);
		List<Area> areas = dicContent.getRootDics(Area.class);
		Long uid=SecurityUserHolder.getCurrentUserId();

		if (id != null && !id.equals("")) {
			Address obj = this.addressService
					.getObjById(CommUtil.null2Long(id));
			if (obj != null) {
				if (uid.equals(obj.getUserId())) {
					setViewArea(mv, obj.getAreaId());
					mv.addObject("obj", obj);
				} else {
					mv.addObject("error", true);
				}
			} else {
				mv.addObject("error", true);
			}
		}
		mv.addObject("addrs_size", this.addressService.countByUid(uid));
		mv.addObject("areas", areas);
		return mv;
	}

	private void setViewArea(ModelAndView mv,Long areaCode){
		Area area=(Area) dicContent.getDic(Area.class, String.valueOf(areaCode));
		if(area != null){
			mv.addObject("areaTowId", area.getParentCode());
			mv.addObject("areas3", dicContent.getDicsByParentCode(Area.class, area.getParentCode()));

			Area parentArea=(Area) dicContent.getDic(Area.class, area.getParentCode());
			if(parentArea != null){
				mv.addObject("areaOneId", parentArea.getParentCode());
				mv.addObject("areas2", dicContent.getDicsByParentCode(Area.class, parentArea.getParentCode()));
			}

		}

	}

	@SecurityMapping(title = "地址保存", value = "/cart_address_save.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/cart_address_save.htm")
	public ModelAndView cart_address_save(HttpServletRequest request,
			HttpServletResponse response, String id, String area_id,
			String op_type, String gcs) throws ServiceException {
		WebForm wf = new WebForm();
		AddressBO address = (AddressBO) wf.toPo(request,  AddressBO.class);

		Long uid=SecurityUserHolder.getCurrentUserId();

		address.setId(id != null ? Long.parseLong(id):null);
		address.setUserId(uid);
		address.setAreaId(Long.parseLong(area_id));

		this.addressService.save(address);

		ModelAndView mv = null;
		if (CommUtil.null2String(op_type).equals("address_create")) {
			mv = new JModelAndView("cart_address_create_result.html",
					configService.getSysConfig(),
					1, request,
					response);
			Map params = new HashMap();
			params.put("user_id", uid);
			List<AddressBO> addrs = this.addressService.findShopByUid(uid);
			mv.addObject("addrs", addrs);
		} else {
			mv = new JModelAndView("cart_address_result.html",
					configService.getSysConfig(),
					1, request,
					response);
			mappingHandle.mappinHandle(address);
			mv.addObject("addr", address);
		}
		return mv;
	}

	@SecurityMapping(title = "地址新增", value = "/cart_address_create.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/cart_address_create.htm")
	public ModelAndView cart_address_create(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("cart_address_create.html",
				configService.getSysConfig(),
				1, request, response);
		List<Area> areas = dicContent.getRootDics(Area.class);
		Map params = new HashMap();
		params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
		List<AddressBO> addrs = this.addressService.findShopByUid(SecurityUserHolder.getCurrentUserId());
		mv.addObject("addrs", addrs);
		mv.addObject("areas", areas);
		return mv;
	}

	@SecurityMapping(title = "设置默认地址", value = "/cart_addr_default.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/cart_addr_default.htm")
	public void cart_addr_default(HttpServletRequest request,
			HttpServletResponse response, String id) {
		boolean ret = false;
		if (id != null && !id.equals("")) {
			ret=this.addressService.updateDefault(CommUtil.null2Long(id), SecurityUserHolder.getCurrentUserId());
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

//	@SecurityMapping(title = "订单加载自提点", value = "/cart_delivery.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
//	@RequestMapping("/cart_delivery.htm")
//	public ModelAndView cart_delivery(HttpServletRequest request,
//			HttpServletResponse response, String addr_id, String currentPage,
//			String deliver_area_id) {
//		ModelAndView mv = new JModelAndView("cart_delivery.html",
//				configService.getSysConfig(),
//				1, request, response);
//		DeliveryAddressQueryObject qo = new DeliveryAddressQueryObject(
//				currentPage, mv, "addTime", "desc");
//		if (deliver_area_id != null && !deliver_area_id.equals("")) {
//			Area deliver_area = this.areaService.getObjById(CommUtil
//					.null2Long(deliver_area_id));
//			Set<Long> ids = this.genericIds(deliver_area);
//			Map paras = new HashMap();
//			paras.put("ids", ids);
//			qo.addQuery("obj.da_area.id in(:ids)", paras);
//			mv.addObject("deliver_area_id", deliver_area_id);
//		} else {
//			if (addr_id != null && !addr_id.equals("")) {
//				Address addr = this.addressService.getObjById(CommUtil
//						.null2Long(addr_id));
//				qo.addQuery("obj.da_area.parent.id", new SysMap("da_area_id",
//						addr.getArea().getParent().getId()), "=");
//				mv.addObject("area", addr.getArea().getParent());
//			}
//		}
//		qo.addQuery("obj.da_status", new SysMap("da_status", 10), "=");
//		qo.setPageSize(5);
//		IPageList pList = this.deliveryaddrService.list(qo);
//		CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
//		String url = CommUtil.getURL(request) + "/cart_delivery.htm";
//		mv.addObject("objs", pList.getResult());
//		mv.addObject("gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(url, "",
//				pList.getCurrentPage(), pList.getPages()));
//		return mv;
//	}
//
	@SecurityMapping(title = "保存用户发票信息", value = "/invoice_save.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/invoice_save.htm")
	public void invoice_save(HttpServletRequest request,
			HttpServletResponse response, String invoice, String invoiceType) {
		boolean ret = false;
		User user = SecurityUserHolder.getCurrentUser();

		UserCustomer customer=new UserCustomer();
		customer.setUid(user.getId());
		customer.setInvoice(invoice);
		customer.setInvoiceType(CommUtil.null2Int(invoiceType));

		ret = this.customerService.updateUserInvoice(customer);

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

	@SecurityMapping(title = "地址切换", value = "/order_address.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/order_address.htm")
	public void order_address(HttpServletRequest request,
			HttpServletResponse response, String addr_id, String store_id) {

		CustomerUserDetails userDetails=(CustomerUserDetails)SecurityUserHolder.getCurrentUserDetails();
		User user=userDetails!= null ?userDetails.getUser():null;
		Long storeId=userDetails != null?userDetails.getStoreId():null;

		String cart_session_id=this.goodsCaseViewTools.getCartSessionId(request, response);

		List<GoodsCartBO> carts=goodsCartService.findUserCart(user,storeId,cart_session_id,false);

		List<GoodsCartBO> gc_list = new ArrayList<GoodsCartBO>();
		for (GoodsCartBO gc : carts) {
			if (store_id != "self" && !store_id.equals("self")) {
				if (gc.getGoods().getGoodsType() == GoodsConstants.GOODS_TYPE_SHOP
						&& gc.getGoods().getGoodsStoreId().equals(CommUtil.null2Long(store_id))) {
					gc_list.add(gc);
				}
			} else {
				if (gc.getGoods().getGoodsType() == GoodsConstants.GOODS_TYPE_SELF) {
					gc_list.add(gc);
				}
			}
		}
		Address addr = this.addressService.getObjById(CommUtil
				.null2Long(addr_id));
		List<SysMap> sms = this.transportTools.query_cart_trans(gc_list,
				CommUtil.null2String(addr.getArea().getId()));
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(sms, JsonFormat.compact()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String getHttpContent(String url, String charSet,
			String method) {
		HttpURLConnection connection = null;
		String content = "";
		try {
			URL address_url = new URL(url);
			connection = (HttpURLConnection) address_url.openConnection();
			connection.setRequestMethod("GET");
			// 设置访问超时时间及读取网页流的超时时间,毫秒值
			connection.setConnectTimeout(1000000);
			connection.setReadTimeout(1000000);
			// 得到访问页面的返回值
			int response_code = connection.getResponseCode();
			if (response_code == HttpURLConnection.HTTP_OK) {
				InputStream in = connection.getInputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in, charSet));
				String line = null;
				while ((line = reader.readLine()) != null) {
					content += line;
				}
				return content;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return "";
	}
//
//	@Async
//	private void send_groupInfo_sms(HttpServletRequest request,
//			OrderForm order, String mobile, String mark, List<String> codes,
//			String buyer_id, String seller_id) throws Exception {
//		Template template = this.templateService.getObjByProperty(null, "mark",
//				mark);
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < codes.size(); i++) {
//			sb.append(codes.get(i) + ",");
//		}
//		String code = sb.toString();
//		if (template != null && template.isOpen()) {
//			ExpressionParser exp = new SpelExpressionParser();
//			EvaluationContext context = new StandardEvaluationContext();
//			context.setVariable("buyer",
//					this.userService.getObjById(CommUtil.null2Long(buyer_id)));
//			context.setVariable("seller",
//					this.userService.getObjById(CommUtil.null2Long(seller_id)));
//			context.setVariable("config", this.configService.getSysConfig());
//			context.setVariable("send_time",
//					CommUtil.formatLongDate(new Date()));
//			context.setVariable("webPath", CommUtil.getURL(request));
//			context.setVariable("order", order);
//			Map map = Json.fromJson(Map.class, order.getGroup_info());
//			context.setVariable("group_info", map.get("goods_name"));
//			context.setVariable("code", code);
//			Expression ex = exp.parseExpression(template.getContent(),
//					new SpelTemplate());
//			String content = ex.getValue(context, String.class);
//			this.msgTools.sendSMS(mobile, content);
//		}
//	}
//
//	@SecurityMapping(title = "F码购物第一步", value = "/f_code_cart.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
//	@RequestMapping("/f_code_cart.htm")
//	public ModelAndView f_code_cart(HttpServletRequest request,
//			HttpServletResponse response, String goods_id, String gsp) {
//		ModelAndView mv = new JModelAndView("f_code_cart.html",
//				configService.getSysConfig(),
//				1, request, response);
//		Goods goods = this.goodsService
//				.getObjById(CommUtil.null2Long(goods_id));
//		if (goods != null) {
//			if (goods.getF_sale_type() == 0) {
//				mv = new JModelAndView("error.html",
//						configService.getSysConfig(),
//						1, request,
//						response);
//				mv.addObject("op_title", "该商品不需要F码购买");
//				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
//			} else {
//				if (CommUtil.null2String(gsp).equals("")) {
//					gsp = this.generic_default_gsp(goods);
//				}
//				int goods_inventory = goods_inventory = CommUtil.null2Int(this
//						.generic_default_info(goods, gsp).get("count"));// 计算该规格商品的库存量
//				if (goods_inventory > 0) {
//					String[] gsp_ids = CommUtil.null2String(gsp).split(",");
//					String spec_info = "";
//					List<GoodsSpecProperty> specs = new ArrayList<GoodsSpecProperty>();
//					for (String gsp_id : gsp_ids) {
//						GoodsSpecProperty spec_property = this.goodsSpecPropertyService
//								.getObjById(CommUtil.null2Long(gsp_id));
//						// System.out.println(spec_property.getSpec().getName());
//						boolean add = false;
//						for (GoodsSpecProperty temp_gsp : goods
//								.getGoods_specs()) {// 检查传入的规格信息是否是该商品对应的规格信息,杜绝用户私自修改传递参数
//							if (temp_gsp != null && spec_property != null) {
//								if (temp_gsp.getId().equals(
//										spec_property.getId())) {
//									add = true;
//								}
//							}
//						}
//						for (GoodsSpecProperty temp_gsp : specs) {
//							if (temp_gsp.getSpec().getId()
//									.equals(spec_property.getSpec().getId())) {
//								add = false;
//							}
//						}
//						if (add)
//							specs.add(spec_property);
//					}
//					// System.out.println(this.goodsViewTools.generic_spec(goods_id).size()
//					// + "   " + specs.size());
//					if (this.goodsViewTools.generic_spec(goods_id).size() == specs
//							.size()) {// 这里判断传入的规格数量和商品本身具有的是否一致,杜绝用户私自修改传递参数
//						for (GoodsSpecProperty spec : specs) {
//							spec_info = spec.getSpec().getName() + ":"
//									+ spec.getValue() + " " + spec_info;
//						}
//						String price = this.generGspgoodsPrice(gsp, goods_id);
//						mv.addObject("spec_info", spec_info);
//						mv.addObject("price", price);
//						mv.addObject("obj", goods);
//						mv.addObject("gsp", gsp);
//						mv.addObject("goodsViewTools", this.goodsViewTools);
//					} else {
//						mv = new JModelAndView("error.html",
//								configService.getSysConfig(),
//								1,
//								request, response);
//						mv.addObject("op_title", "规格参数错误");
//						mv.addObject("url", CommUtil.getURL(request)
//								+ "/index.htm");
//					}
//				} else {
//					mv = new JModelAndView("error.html",
//							configService.getSysConfig(),
//							1, request,
//							response);
//					mv.addObject("op_title", "商品默认规格无库存，请选择其他规格购买");
//					mv.addObject("url", CommUtil.getURL(request) + "/goods_"
//							+ goods.getId() + ".htm");
//				}
//
//			}
//		} else {
//			mv = new JModelAndView("error.html", configService.getSysConfig(),
//					1, request,
//					response);
//			mv.addObject("op_title", "商品参数错误");
//			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
//		}
//		return mv;
//	}
//
//	/**
//	 * 验证F码信息，并返回到页面中
//	 *
//	 * @param request
//	 * @param response
//	 * @param f_code
//	 * @param goods_id
//	 */
//	@SecurityMapping(title = "F码验证", value = "/f_code_validate.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
//	@RequestMapping("/f_code_validate.htm")
//	public void f_code_validate(HttpServletRequest request,
//			HttpServletResponse response, String f_code, String goods_id) {
//		int code = -100;// -100验证码错误，-200验证码已使用过，100验证成功，
//		Goods obj = this.goodsService.getObjById(CommUtil.null2Long(goods_id));
//		List<Map> list = Json.fromJson(List.class, obj.getGoods_f_code());
//		for (Map map : list) {
//			if (CommUtil.null2String(map.get("code")).equals(f_code)) {// 存在该F码且是未使用的则验证成功
//				if (CommUtil.null2Int(map.get("status")) == 0) {
//					code = 100;// 验证成功
//				} else {
//					code = -200;// 验证码已使用过
//				}
//				break;
//			}
//		}
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(code);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@SecurityMapping(title = "F码完成验证进入订单提交", value = "/f_code_validate.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
//	@RequestMapping("/add_f_code_goods_cart.htm")
//	public void add_f_code_goods_cart(HttpServletRequest request,
//			HttpServletResponse response, String goods_id, String f_code,
//			String gsp) {
//		boolean ret = false;
//		Goods goods = this.goodsService
//				.getObjById(CommUtil.null2Long(goods_id));
//		List<Map> f_code_list = Json.fromJson(List.class,
//				goods.getGoods_f_code());
//		for (Map map : f_code_list) {
//			if (CommUtil.null2String(map.get("code")).equals(f_code)
//					&& CommUtil.null2Int(map.get("status")) == 0) {// 存在该F码且是未使用的则验证成功
//				ret = true;
//			}
//		}
//		if (ret) {
//			List<GoodsCart> carts_list = new ArrayList<GoodsCart>();// 用户整体购物车
//			List<GoodsCart> carts_cookie = new ArrayList<GoodsCart>();// 未提交的用户cookie购物车
//			List<GoodsCart> carts_user = new ArrayList<GoodsCart>();// 未提交的用户user购物车
//			Map cart_map = new HashMap();
//			User user = userService.getObjById(SecurityUserHolder
//					.getCurrentUser().getId());
//			cart_map.clear();
//			cart_map.put("user_id", user.getId());
//			cart_map.put("cart_status", 0);
//			carts_user = this.goodsCartService
//					.query("select obj from GoodsCart obj where obj.user.id=:user_id and obj.cart_status=:cart_status ",
//							cart_map, -1, -1);
//			// 将cookie购物车与用户user购物车合并，去重
//			for (GoodsCart ugc : carts_user) {
//				carts_list.add(ugc);
//			}
//			for (GoodsCart cookie : carts_cookie) {
//				boolean add = true;
//				for (GoodsCart gc2 : carts_user) {
//					if (cookie.getGoods().getId()
//							.equals(gc2.getGoods().getId())) {
//						if (cookie.getSpec_info().equals(gc2.getSpec_info())) {
//							add = false;
//							this.goodsCartService.delete(cookie.getId());
//						}
//					}
//				}
//				if (add) {// 将cookie_cart转变为user_cart
//					cookie.setCart_session_id(null);
//					cookie.setUser(user);
//					this.goodsCartService.update(cookie);
//					carts_list.add(cookie);
//				}
//			}
//			GoodsCart obj = new GoodsCart();
//			boolean add = true;
//			String[] gsp_ids = CommUtil.null2String(gsp).split(",");
//			Arrays.sort(gsp_ids);
//			for (GoodsCart gc : carts_list) {
//				if (gsp_ids != null && gsp_ids.length > 0
//						&& gc.getGsps() != null) {
//					String[] gsp_ids1 = new String[gc.getGsps().size()];
//					for (int i = 0; i < gc.getGsps().size(); i++) {
//						gsp_ids1[i] = gc.getGsps().get(i) != null ? gc
//								.getGsps().get(i).getId().toString() : "";
//					}
//					Arrays.sort(gsp_ids1);
//					if (gc.getGoods().getId().toString().equals(goods_id)
//							&& Arrays.equals(gsp_ids, gsp_ids1)) {
//						add = false;
//					}
//				} else {
//					if (gc.getGoods().getId().toString().equals(goods_id)) {
//						add = false;
//					}
//				}
//			}
//			if (add) {// 排除购物车中没有重复商品后添加该商品到购物车
//				obj.setAddTime(new Date());
//				obj.setCount(1);
//				String price = this.generGspgoodsPrice(gsp, goods_id);
//				obj.setPrice(BigDecimal.valueOf(CommUtil.null2Double(price)));
//				obj.setGoods(goods);
//				String spec_info = "";
//				for (String gsp_id : gsp_ids) {
//					GoodsSpecProperty spec_property = this.goodsSpecPropertyService
//							.getObjById(CommUtil.null2Long(gsp_id));
//					obj.getGsps().add(spec_property);
//					if (spec_property != null) {
//						spec_info = spec_property.getSpec().getName() + ":"
//								+ spec_property.getValue() + " " + spec_info;
//					}
//				}
//				obj.setUser(user);
//				obj.setSpec_info(spec_info);
//				ret = this.goodsCartService.save(obj);
//				if (ret) {// 确定F码商品已经添加到购物车，作废F码
//					for (Map map : f_code_list) {
//						if (CommUtil.null2String(map.get("code"))
//								.equals(f_code)
//								&& CommUtil.null2Int(map.get("status")) == 0) {// 存在该F码且是未使用的则验证成功
//							map.put("status", 1);// 设置该F码已经被使用
//							break;
//						}
//					}
//					goods.setGoods_f_code(Json.toJson(f_code_list,
//							JsonFormat.compact()));
//					this.goodsService.update(goods);
//				}
//			}
//		}
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(ret);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
	/**
	 * 根据商品信息，计算该商品默认的规格信息，以各个规格值的第一个为默认值
	 *
	 * @param goods
	 *            商品
	 * @return 默认规格id组合，如1,2
	 */
	private String generic_default_gsp(Goods goods) {
		String gsp = "";
		if (goods != null) {
			List<GoodsSpecificationBO> specs = this.goodsService.selectGoodsSpecList(goods);
			for (GoodsSpecificationBO spec : specs) {
//				for (GoodsSpecProperty prop : goods.getGoods_specs()) {
//					if (prop.getSpec().getId().equals(spec.getId())) {
//						gsp = prop.getId() + "," + gsp;
//						break;
//					}
//				}
				if(spec.getProperties().size() > 0){
					gsp = spec.getProperties().get(0).getId() + "," + gsp;
				}
			}
		}
		return gsp;
	}

//	private Set<Long> genericIds(Area area) {
//		Set<Long> ids = new HashSet<Long>();
//		ids.add(area.getId());
//		for (Area child : area.getChilds()) {
//			Set<Long> cids = genericIds(child);
//			for (Long cid : cids) {
//				ids.add(cid);
//			}
//			ids.add(child.getId());
//		}
//		return ids;
//	}
	
	
	/***
	 * 支付完成跳转页面
	 * @param request
	 * @param response
	 * @param order_id
	 * @param orderNo
	 * @return
	 */
	@RequestMapping("/orderFinish.htm")
	public ModelAndView orderFinish(HttpServletRequest request,
			HttpServletResponse response, String order_id,String orderNo) {
		ModelAndView mv = new JModelAndView("order_finish.html",
				configService.getSysConfig(),
				1, request, response);
		OrderForm obj = null;
		if(StringUtils.isNotBlank(order_id)){
			obj=this.orderFormService.getObjById(CommUtil.null2Long(order_id));
			
		}else if(StringUtils.isNotBlank(orderNo)){
			//根据订单编号 
			obj=this.orderFormService.findByOrderNo(orderNo);
		}
		mv.addObject("obj", obj);
		mv.addObject("all_price",
				this.orderFormTools.query_order_price(obj.getId().toString()));
		return mv;
	}
}
