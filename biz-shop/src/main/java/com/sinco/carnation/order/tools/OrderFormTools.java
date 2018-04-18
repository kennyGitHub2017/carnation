package com.sinco.carnation.order.tools;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.common.collect.Lists;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.express.service.ExpressInfoService;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.GoodsSpecPropertyService;
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.integral.service.IntegralGoodsService;
import com.sinco.carnation.juanpi.bo.JuanpiOrderGoodsBO;
import com.sinco.carnation.juanpi.dao.JuanpiOrderGoodsDao;
import com.sinco.carnation.kuaidi100.service.TransInfoService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.dao.OrderFormDao;
import com.sinco.carnation.shop.model.IntegralGoods;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.TransInfo;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.SysConfigService;

//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.nutz.json.Json;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import vc.thinker.b2b2c.core.tools.CommUtil;
//import vc.thinker.b2b2c.foundation.domain.Evaluate;
//import vc.thinker.b2b2c.foundation.domain.ExpressCompany;
//import vc.thinker.b2b2c.foundation.domain.Goods;
//import vc.thinker.b2b2c.foundation.domain.GoodsSpecProperty;
//import vc.thinker.b2b2c.foundation.domain.IntegralGoods;
//import vc.thinker.b2b2c.foundation.domain.IntegralGoodsOrder;
//import vc.thinker.b2b2c.foundation.domain.OrderForm;
//import vc.thinker.b2b2c.foundation.domain.Store;
//import vc.thinker.b2b2c.foundation.domain.SysConfig;
//import vc.thinker.b2b2c.foundation.domain.virtual.TransContent;
//import vc.thinker.b2b2c.foundation.domain.virtual.TransInfo;
//import vc.thinker.b2b2c.foundation.service.IEvaluateService;
//import vc.thinker.b2b2c.foundation.service.IExpressCompanyService;
//import vc.thinker.b2b2c.foundation.service.IGoodsService;
//import vc.thinker.b2b2c.foundation.service.IGoodsSpecPropertyService;
//import vc.thinker.b2b2c.foundation.service.IIntegralGoodsOrderService;
//import vc.thinker.b2b2c.foundation.service.IIntegralGoodsService;
//import vc.thinker.b2b2c.foundation.service.IOrderFormService;
//import vc.thinker.b2b2c.foundation.service.IStoreService;
//import vc.thinker.b2b2c.foundation.service.ISysConfigService;
//import vc.thinker.b2b2c.foundation.service.IUserService;
//import vc.thinker.b2b2c.kuaidi100.domain.ExpressInfo;
//import vc.thinker.b2b2c.kuaidi100.service.IExpressInfoService;
//
/**
 * 
 * <p>
 * Title: MsgTools.java
 * </p>
 * 
 * <p>
 * Description: 订单解析工具，解析订单中json数据
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-5-4
 * 
 * @version 1.0.1
 */
@Component
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class OrderFormTools {
	// @Autowired
	// private ISysConfigService configService;
	// @Autowired
	// private IUserService userService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsSpecPropertyService gspService;
	@Autowired
	private StoreService storeService;
	// @Autowired
	// private IExpressCompanyService expressCompanyService;
	// @Autowired
	// private IExpressInfoService expressInfoService;
	@Autowired
	private IntegralGoodsOrderService integralGoodsOrderService;
	// @Autowired
	// private IEvaluateService evaluateService;
	@Autowired
	private IntegralGoodsService integralGoodsService;

	@Autowired
	private OrderFormDao orderFormDao;

	@Autowired
	private SysConfigService configService;
	@Autowired
	private ExpressInfoService expressInfoService;
	@Autowired
	private ExpressCompanyService expressCompayService;
	@Autowired
	private TransInfoService transInfoService;
	@Autowired
	private JuanpiOrderGoodsDao JuanpiOrderGoodsDao;

	/**
	 * 解析订单商品信息json数据
	 * 
	 * @param order_id
	 * @return
	 */
	public List<Map> queryGoodsInfo(String json) {
		List<Map> map_list = new ArrayList<Map>();
		if (json != null && !json.equals("")) {
			map_list = Json.fromJson(ArrayList.class, json);
		}
		return map_list;
	}

	public List<Map<String, Object>> queryNewGoodsInfo(String json) {
		List<Map<String, Object>> map_list = new ArrayList<Map<String, Object>>();
		if (json != null && !json.equals("")) {
			map_list = Json.fromJson(ArrayList.class, json);
		}
		return map_list;
	}

	/**
	 * 解析订单商品信息json数据 这个主要是去重 比如商品一样数量不一样
	 * 
	 * @param order_id
	 * @return
	 */
	public List<Map> queryGoodsInfo2(String json) {
		List<Map> map_list = new ArrayList<Map>();
		if (json != null && !json.equals("")) {
			map_list = Json.fromJson(ArrayList.class, json);
		}
		List<String> goodsIds = new ArrayList<>();
		List<Map> list = new ArrayList<>();
		for (Map map : map_list) {
			String goodsId = String.valueOf(map.get("goods_id"));
			if (!goodsIds.contains(goodsId)) {
				goodsIds.add(goodsId);
				list.add(map);
			}
		}
		return list;
	}

	/**
	 * 解析子订单商品信息json数据
	 * 
	 * @param order_id
	 * @return
	 */
	public List<Map> queryChildGoodsInfo(String json) {
		List<Map> map_list = queryGoodsInfo(json);
		List<Map> goodsList = Lists.newArrayList();

		List<Long> ids = Lists.newArrayList();

		for (Map map : map_list) {
			ids.add(CommUtil.null2Long(map.get("order_id")));
		}
		List<OrderFormBO> orders = orderFormDao.findAll(ids);
		for (OrderFormBO bo : orders) {
			List<Map> childGoodsList = queryGoodsInfo(bo.getGoodsInfo());
			for (Map map : childGoodsList) {
				map.put("order_id", bo.getId());
			}
			goodsList.addAll(childGoodsList);
		}
		return goodsList;
	}

	/**
	 * 根据订单id查询该订单中所有商品,包括子订单中的商品
	 * 
	 * @param order_id
	 * @return
	 */
	public List<GoodsBO> queryOfGoods(String of_id) {
		return queryOfGoods(CommUtil.null2Long(of_id));
	}

	public BigDecimal getReturnGoodsCommisionAmount(String returnGoodsJson) {
		BigDecimal sumReuturnAmount = BigDecimal.ZERO;
		List<Map> map_list = new ArrayList<Map>();
		if (returnGoodsJson != null && !returnGoodsJson.equals("")) {
			map_list = Json.fromJson(ArrayList.class, returnGoodsJson);
			for (Map map : map_list) {
				sumReuturnAmount = sumReuturnAmount.add(CommUtil.null2BigDecimal(map
						.get("return_commission_amount")));
			}
		}
		return sumReuturnAmount;

	}

	/**
	 * 根据订单id查询该订单中所有商品,包括子订单中的商品
	 * 
	 * @param order_id
	 * @return
	 */
	public List<GoodsBO> queryOfGoods(Long of_id) {
		OrderForm of = this.orderFormService.getObjById(CommUtil.null2Long(of_id));
		List<Map> map_list = this.queryGoodsInfo(of.getGoodsInfo());
		List<GoodsBO> goods_list = new ArrayList<GoodsBO>();
		for (Map map : map_list) {
			GoodsBO goods = this.goodsService.getObjById(CommUtil.null2Long(map.get("goods_id")));
			goods.setGoodsSpecIds(CommUtil.null2String(map.get("goods_gsp_ids")));
			goods.setGoodsCommissionAmount(CommUtil.null2BigDecimal(map.get("goods_commission_price")));
			goods_list.add(goods);
		}
		if (!CommUtil.null2String(of.getChildOrderDetail()).equals("")) {// 查询子订单中的商品信息
			List<Map> maps = this.queryGoodsInfo(of.getChildOrderDetail());
			for (Map map : maps) {
				OrderForm child_order = this.orderFormService.getObjById(CommUtil.null2Long(map
						.get("order_id")));
				map_list.clear();
				map_list = this.queryGoodsInfo(child_order.getGoodsInfo());
				for (Map map1 : map_list) {
					GoodsBO goods = this.goodsService.getObjById(CommUtil.null2Long(map1.get("goods_id")));
					goods.setGoodsSpecIds(CommUtil.null2String(map.get("goods_gsp_ids")));
					goods.setGoodsCommissionAmount(CommUtil.null2BigDecimal(map1
							.get("goods_commission_price")));
					goods_list.add(goods);
				}
			}
		}
		return goods_list;
	}

	/**
	 * 根据订单id查询该订单中所有商品的价格总和
	 * 
	 * @param order_id
	 * @return
	 */
	public double queryOfGoodsPrice(String order_id) {
		double price = 0;
		OrderForm of = this.orderFormService.getObjById(CommUtil.null2Long(order_id));
		List<Map> map_list = this.queryGoodsInfo(of.getGoodsInfo());
		for (Map map : map_list) {
			price = price + CommUtil.null2Double(map.get("goods_all_price"));
		}
		return price;
	}

	/**
	 * 根据订单id和商品id查询该商品在该订单中的数量
	 * 
	 * @param order_id
	 * @return
	 */
	public int queryOfGoodsCount(String order_id, String goods_id, String gspId) {
		OrderForm of = this.orderFormService.getObjById(CommUtil.null2Long(order_id));
		return queryOfGoodsCount(of, goods_id, gspId);
	}

	/**
	 * 根据订单id和商品id查询该商品在该订单中的数量
	 * 
	 * @param order_id
	 * @return
	 */
	public int queryOfGoodsCount(OrderForm of, String goods_id, String gspId) {
		Integer count = null;
		List<Map> map_list = this.queryGoodsInfo(of.getGoodsInfo());
		for (Map map : map_list) {
			count = getOfOrderCount(map, goods_id, gspId);
			if (count != null) {
				break;
			}
		}
		if (count == null) {// 主订单无数量信息，继续从子订单中查询
			if (!CommUtil.null2String(of.getChildOrderDetail()).equals("")) {
				List<Map> maps = this.queryGoodsInfo(of.getChildOrderDetail());
				for (Map map : maps) {
					OrderForm child_order = this.orderFormService.getObjById(CommUtil.null2Long(map
							.get("order_id")));
					map_list.clear();
					map_list = this.queryGoodsInfo(child_order.getGoodsInfo());
					for (Map map1 : map_list) {
						if (CommUtil.null2String(map1.get("goods_id")).equals(goods_id)) {
							count = getOfOrderCount(map1, goods_id, gspId);
							if (count != null) {
								break;
							}
						}
					}
				}
			}
		}
		return count == null ? 0 : count;
	}

	private Integer getOfOrderCount(Map map, String goods_id, String gspId) {
		if (StringUtils.isNotBlank(gspId)) {
			if (CommUtil.null2String(map.get("goods_id")).equals(goods_id)
					&& CommUtil.null2String(map.get("goods_gsp_ids")).equals(gspId)) {
				return CommUtil.null2Int(map.get("goods_count"));
			}
		} else {
			if (CommUtil.null2String(map.get("goods_id")).equals(goods_id)) {
				return CommUtil.null2Int(map.get("goods_count"));
			}
		}
		return null;
	}

	/**
	 * 解析订单物流信息json数据
	 * 
	 * @param json
	 * @return
	 */
	public String queryExInfo(String json, String key) {
		Map map = new HashMap();
		if (json != null && !json.equals("")) {
			map = Json.fromJson(HashMap.class, json);
		}
		return CommUtil.null2String(map.get(key));
	}

	/**
	 * 解析订单优惠券信息json数据
	 * 
	 * @param json
	 * @return
	 */
	public Map queryCouponInfo(String json) {
		Map map = new HashMap();
		if (json != null && !json.equals("")) {
			map = Json.fromJson(HashMap.class, json);
		}
		return map;
	}

	/**
	 * 解析生活类团购订单json数据
	 * 
	 * @param json
	 * @return
	 */
	public Map queryGroupInfo(String json) {
		Map map = new HashMap();
		if (json != null && !json.equals("")) {
			map = Json.fromJson(HashMap.class, json);
		}
		return map;
	}

	/**
	 * 根据订单id查询订单信息
	 * 
	 * @param id
	 * @return
	 */
	public OrderForm query_order(String id) {
		return this.orderFormService.getObjById(CommUtil.null2Long(id));
	}

	/**
	 * 查询订单的状态，用在买家中心的订单列表中，多商家复合订单中只有全部商家都已经发货，卖家中心才会出现确认收货按钮
	 * 
	 * @param order_id
	 * @return
	 */
	public int query_order_status(String order_id) {
		int order_status = 0;
		OrderForm order = this.orderFormService.getObjById(CommUtil.null2Long(order_id));
		if (order != null) {
			order_status = order.getOrderStatus();
			if (order.getOrderMain() == 1 && !CommUtil.null2String(order.getChildOrderDetail()).equals("")) {
				List<Map> maps = this.queryGoodsInfo(order.getChildOrderDetail());
				for (Map child_map : maps) {
					OrderForm child_order = this.orderFormService.getObjById(CommUtil.null2Long(child_map
							.get("order_id")));
					if (child_order.getOrderStatus() < 30) {
						order_status = child_order.getOrderStatus();
					}
				}
			}
		}
		return order_status;
	}

	/**
	 * 查询订单总价格（如果包含子订单，将子订单价格与主订单价格相加）
	 * 
	 * @param order_id
	 * @return
	 */
	public double query_order_price(String order_id) {
		double all_price = 0;
		OrderForm order = this.orderFormService.getObjById(CommUtil.null2Long(order_id));
		if (order != null) {
			return query_order_price(order);
		}
		return all_price;
	}

	/**
	 * 查询订单总价格（如果包含子订单，将子订单价格与主订单价格相加）
	 * 
	 * @param order
	 * @return
	 */
	public double query_order_price(OrderForm order) {
		if (order == null) {
			return 0;
		}
		if (StringUtils.isBlank(order.getChildOrderDetail())) {
			return order.getTotalPrice().doubleValue();
		}

		List<Map> maps = this.queryGoodsInfo(order.getChildOrderDetail());
		List<Long> ids = Lists.newArrayList(order.getId());
		for (Map map : maps) {
			ids.add(CommUtil.null2Long(map.get("order_id")));
		}
		return orderFormDao.sumOrderPrice(ids);
	}
	
	/**
	 * 查询订单现金部分总和 （如果包含子订单，将子订单价格与主订单价格相加）
	 * 
	 * @param order
	 * @return
	 */
	public double query_order_cash_price(OrderForm order) {
		if (order == null) {
			return 0;
		}
		if (StringUtils.isBlank(order.getChildOrderDetail())) {
			return order.getAllCashPrice().doubleValue();
		}
		List<Map> maps = this.queryGoodsInfo(order.getChildOrderDetail());
		List<Long> ids = Lists.newArrayList(order.getId());
		for (Map map : maps) {
			ids.add(CommUtil.null2Long(map.get("order_id")));
		}
		return orderFormDao.sumOrderCashPrice(ids);
	}	
	
	/**
	 * 查询订单积分部分总和 （如果包含子订单，将子订单价格与主订单积分相加）
	 * 
	 * @param order
	 * @return
	 */
	public double query_order_integral(OrderForm order) {
		if (order == null) {
			return 0;
		}
		if (StringUtils.isBlank(order.getChildOrderDetail())) {
			return order.getAllIntegral().doubleValue();
		}
		List<Map> maps = this.queryGoodsInfo(order.getChildOrderDetail());
		List<Long> ids = Lists.newArrayList(order.getId());
		for (Map map : maps) {
			ids.add(CommUtil.null2Long(map.get("order_id")));
		}
		return orderFormDao.sumOrderIntegral(ids);
	}	
	
	/**
	 * 查询订单运费部分总和 （如果包含子订单，将子订单价格与主订单积分相加）
	 * 
	 * @param order
	 * @return
	 */
	public double query_order_ship(OrderForm order) {
		if (order == null) {
			return 0;
		}
		if (StringUtils.isBlank(order.getChildOrderDetail())) {
			return order.getShipPrice().doubleValue();
		}
		List<Map> maps = this.queryGoodsInfo(order.getChildOrderDetail());
		List<Long> ids = Lists.newArrayList(order.getId());
		for (Map map : maps) {
			ids.add(CommUtil.null2Long(map.get("order_id")));
		}
		return orderFormDao.sumOrderShip(ids);
	}
	
	
	
	
	/**
	 * 查询云购币订单总价格
	 * 
	 * @param order
	 * @return
	 */
	public double query_yg_order_price(OrderForm order) {
		if (order == null) {
			return 0;
		}

		double ygPrice = CommUtil.null2Double(order.getAllygPrice());// 云购币
		double CashPrice = CommUtil.null2Double(order.getAllCashPrice());// 需要现金
		double countAmount = CommUtil.add(ygPrice, CashPrice);
		return countAmount;
	}

	// public double query_order_goods(String order_id) {
	// double all_goods = 0;
	// OrderForm order = this.orderFormService.getObjById(CommUtil
	// .null2Long(order_id));
	// if (order != null) {
	// all_goods = CommUtil.null2Double(order.getGoods_amount());
	// if (order.getChild_order_detail() != null
	// && !order.getChild_order_detail().equals("")) {
	// List<Map> maps = this.queryGoodsInfo(order
	// .getChild_order_detail());
	// for (Map map : maps) {
	// OrderForm child_order = this.orderFormService
	// .getObjById(CommUtil.null2Long(map.get("order_id")));
	// all_goods = all_goods
	// + CommUtil.null2Double(child_order
	// .getGoods_amount());
	// }
	// }
	// }
	// return all_goods;
	// }
	//
	/**
	 * 解析订单中组合套装详情
	 * 
	 * @param order_id
	 * @return
	 */
	public Map query_order_suitinfo(String goods_info) {
		Map map = (Map) Json.fromJson(goods_info);
		return map;
	}

	//
	/**
	 * 解析订单中组合套装详情
	 * 
	 * @param order_id
	 * @return
	 */
	public List<Map> query_order_suitgoods(Map suit_map) {
		List<Map> map_list = new ArrayList();
		if (suit_map != null && !suit_map.equals("")) {
			map_list = (List<Map>) suit_map.get("goods_list");
		}
		return map_list;
	}

	//
	/**
	 * 根据店铺id查询是否开启了二级域名。
	 * 
	 * @param id为参数
	 *            type为store时查询store type为goods时查询商品
	 * @return
	 */
	public Store goods_second_domain(String id, String type) {
		Store store = null;
		if (type.equals("store")) {
			store = this.storeService.getObjById(CommUtil.null2Long(id));
		}
		if (type.equals("goods")) {
			Goods goods = this.goodsService.getObjById(CommUtil.null2Long(id));
			if (goods != null && goods.getGoodsType() == 1) {
				// store = goods.getGoods_store();
				store = this.storeService.getObjById(goods.getGoodsStoreId());
				// storeService.
			}
		}
		return store;
	}

	//
	// public TransInfo query_ship_getData(String id) {
	// TransInfo info = new TransInfo();
	// OrderForm obj = this.orderFormService
	// .getObjById(CommUtil.null2Long(id));
	// if (obj != null && !CommUtil.null2String(obj.getShipCode()).equals("")) {
	// if (this.configService.getSysConfig().getKuaidi_type() == 0) {// 免费物流接口
	// try {
	// ExpressCompany ec = this.queryExpressCompany(obj
	// .getExpress_info());
	// String query_url = "http://api.kuaidi100.com/api?id="
	// + this.configService.getSysConfig().getKuaidi_id()
	// + "&com="
	// + (ec != null ? ec.getCompany_mark() : "") + "&nu="
	// + obj.getShipCode() + "&show=0&muti=1&order=asc";
	// URL url = new URL(query_url);
	// URLConnection con = url.openConnection();
	// con.setAllowUserInteraction(false);
	// InputStream urlStream = url.openStream();
	// String type = con.guessContentTypeFromStream(urlStream);
	// String charSet = null;
	// if (type == null)
	// type = con.getContentType();
	// if (type == null || type.trim().length() == 0
	// || type.trim().indexOf("text/html") < 0)
	// return info;
	// if (type.indexOf("charset=") > 0)
	// charSet = type.substring(type.indexOf("charset=") + 8);
	// byte b[] = new byte[10000];
	// int numRead = urlStream.read(b);
	// String content = new String(b, 0, numRead, charSet);
	// while (numRead != -1) {
	// numRead = urlStream.read(b);
	// if (numRead != -1) {
	// // String newContent = new String(b, 0, numRead);
	// String newContent = new String(b, 0, numRead,
	// charSet);
	// content += newContent;
	// }
	// }
	// info = Json.fromJson(TransInfo.class, content);
	// urlStream.close();
	// } catch (MalformedURLException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// if (this.configService.getSysConfig().getKuaidi_type() == 1) {// 收费物流接口
	// ExpressInfo ei = this.expressInfoService
	// .getObjByPropertyWithType("order_id", obj.getId(), 0);
	// if (ei != null) {
	// List<TransContent> data = (List<TransContent>) Json
	// .fromJson(CommUtil.null2String(ei
	// .getOrder_express_info()));
	// info.setData(data);
	// info.setStatus("1");
	// }
	// }
	// }
	// return info;
	// }
	//
	/**
	 * 解析订单中自提点信息
	 * 
	 * @param order_id
	 * @return
	 */
	public Map query_order_delivery(String delivery_info) {
		Map map = (Map) Json.fromJson(delivery_info);
		return map;
	}

	//
	// private ExpressCompany queryExpressCompany(String json) {
	// ExpressCompany ec = null;
	// if (json != null && !json.equals("")) {
	// HashMap map = Json.fromJson(HashMap.class, json);
	// ec = this.expressCompanyService.getObjById(CommUtil.null2Long(map
	// .get("express_company_id")));
	// }
	// return ec;
	// }
	//
	// /**
	// * 查询订单中所以商品数量
	// *
	// * @param order_id
	// * @return
	// */
	// public int query_goods_count(String order_id) {
	// OrderForm orderForm = this.query_order(order_id);
	// List<Map> list_map = new ArrayList<Map>();
	// int count = 0;
	// if (orderForm != null) {
	// list_map = this.queryGoodsInfo(orderForm.getGoods_info());
	// for (Map map : list_map) {
	// count = count + CommUtil.null2Int(map.get("goods_count"));
	// }
	// if (orderForm.getOrder_main() == 1
	// && !CommUtil.null2String(orderForm.getChild_order_detail())
	// .equals("")) {
	// list_map = this.queryGoodsInfo(orderForm
	// .getChild_order_detail());
	// for (Map map : list_map) {
	// List<Map> list_map1 = new ArrayList<Map>();
	// list_map1 = this.queryGoodsInfo(map.get("order_goods_info")
	// .toString());
	// for (Map map2 : list_map1) {
	// count = count
	// + CommUtil.null2Int(map2.get("goods_count"));
	// }
	// }
	// }
	// }
	// return count;
	// }
	//
	// /**
	// * 查询订单中所有团购数量
	// *
	// * @param order_id
	// * @return
	// */
	// public int query_group_count(String order_id) {
	// OrderForm orderForm = this.query_order(order_id);
	// Map map = new HashMap();
	// int count = 0;
	// if (orderForm != null) {
	// map = this.queryGroupInfo(orderForm.getGroup_info());
	// count = CommUtil.null2Int(map.get("goods_count"));
	// }
	// return count;
	// }

	/**
	 * 查询订单中所有积分商品数量
	 * 
	 * @param order_id
	 * @return
	 */
	public List<Map> query_integral_goodsinfo(String json) {
		List<Map> maps = new ArrayList<Map>();
		if (json != null && !json.equals("")) {
			maps = Json.fromJson(List.class, json);
		}
		return maps;
	}

	/**
	 * 查询订单中所有积分商品数量
	 * 
	 * @param order_id
	 * @return
	 */
	public int query_integral_count(String order_id) {
		IntegralGoodsOrder igo = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(order_id));
		if (igo != null) {
			List<Map> objs = Json.fromJson(List.class, igo.getGoodsInfo());
			int count = objs.size();
			return count;
		} else {
			return 0;
		}
	}

	/**
	 * 查询积分订单中所有商品，返回IntegralGoods集合
	 * 
	 * @param order_id
	 * @return
	 */
	public List<IntegralGoods> query_integral_all_goods(String order_id) {
		IntegralGoodsOrder igo = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(order_id));
		List<IntegralGoods> objs = new ArrayList<IntegralGoods>();
		List<Map> maps = Json.fromJson(List.class, igo.getGoodsInfo());
		for (Map obj : maps) {
			IntegralGoods ig = this.integralGoodsService.getObjById(CommUtil.null2Long(obj.get("id")));
			if (ig != null) {
				objs.add(ig);
			}
		}
		return objs;
	}

	/**
	 * 查询积分订单中某商品的下单数量
	 * 
	 * @param order_id
	 * @return
	 */
	public int query_integral_one_goods_count(IntegralGoodsOrder igo, String ig_id) {
		int count = 0;
		List<IntegralGoods> objs = new ArrayList<IntegralGoods>();
		List<Map> maps = Json.fromJson(List.class, igo.getGoodsInfo());
		for (Map obj : maps) {
			if (obj.get("id").equals(ig_id)) {
				count = CommUtil.null2Int(obj.get("ig_goods_count"));
				break;
			}
		}
		return count;
	}

	// /**
	// * 查询订单中某件是否评价
	// *
	// * @param order_id
	// * @param goods_id
	// * @return
	// */
	// public Evaluate query_order_evaluate(Object order_id, Object goods_id) {
	// Map para = new HashMap();
	// para.put("order_id", CommUtil.null2Long(order_id));
	// para.put("goods_id", CommUtil.null2Long(goods_id));
	// List<Evaluate> list = this.evaluateService
	// .query("select obj from Evaluate obj where
	// obj.evaluate_goods.id=:goods_id and obj.of.id=:order_id",
	// para, -1, -1);
	// if (list.size() > 0) {
	// return list.get(0);
	// }
	// return null;
	// }
	//
	/**
	 * 判断是否可修改评价
	 * 
	 * @param date
	 * @return
	 */
	public int evaluate_able(Date date) {
		if (date != null) {
			long begin = date.getTime();
			long end = new Date().getTime();
			SysConfig config = this.configService.getSysConfig();
			long day = (end - begin) / 86400000;
			if (day <= config.getEvaluateEditDeadline()) {
				return 1;
			}
		}
		return 0;
	}

	//
	/**
	 * 判断是否可追加评价
	 * 
	 * @param date
	 * @return
	 */
	public int evaluate_add_able(Date date) {
		if (date != null) {
			long begin = date.getTime();
			long end = new Date().getTime();
			SysConfig config = this.configService.getSysConfig();
			long day = (end - begin) / 86400000;
			if (day <= config.getEvaluateAddDeadline()) {
				return 1;
			}
		}
		return 0;
	}

	//
	/**
	 * 计算今天到指定时间天数
	 * 
	 * @param date
	 * @return
	 */
	public int how_soon(Date date) {
		if (date != null) {
			long begin = date.getTime();
			long end = new Date().getTime();
			long day = (end - begin) / 86400000;
			return CommUtil.null2Int(day);
		}
		return 999;
	}

	public TransInfo query_ship_getData(String id) {
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		return query_ship_getData(obj);
	}

	public TransInfo query_ship_getData(OrderForm obj) {
		if (obj != null && !CommUtil.null2String(obj.getShipCode()).equals("")) {
			return transInfoService.queryShipInfo(obj.getExpressInfo(), obj.getShipCode());
		}
		return new TransInfo();
	}

	public int eva_rate(String rate) {
		int score = 0;
		if (rate.equals("a")) {
			score = 1;
		} else if (rate.equals("b")) {
			score = 2;
		} else if (rate.equals("c")) {
			score = 3;
		} else if (rate.equals("d")) {
			score = 4;
		} else if (rate.equals("e")) {
			score = 5;
		}
		return score;
	}

	public int eva_total_rate(String rate) {
		int score = -5;
		if (rate.equals("a")) {
			score = 1;
		} else if (rate.equals("b")) {
			score = 0;
		} else if (rate.equals("c")) {
			score = -1;
		}
		return score;
	}

	/**
	 * 昵称显示处理 [云尚****** 昵称自动生成的 为匿名用户]
	 * 
	 * @param nickName
	 * @return
	 */
	public String dealNickNameDisplay(String nickName) {
		if (StringUtils.isEmpty(nickName)) {
			return "";
		}
		if (nickName.equals("云尚")) {
			return "云尚";
		}
		if (nickName.startsWith("云尚") || nickName.startsWith("云尚")) {
			String subfix = nickName.substring(3);
			if (subfix.length() == 6) {

				
			}
		} else {
			if (nickName.length() > 1) {
				return StringUtils.rightPad(nickName.substring(0, 1), nickName.length(), "*");
			} else {
				return nickName;
			}
		}
		return nickName;
	}
	
	public List<Map> queryJquanpiGoodsInfo (String orderId) {
		List<Map> map_list = new ArrayList<Map>();
		List<JuanpiOrderGoodsBO> goodsInfo = this.JuanpiOrderGoodsDao.findGoodsByOrder(CommUtil.null2Long(orderId));
		String json = Json.toJson(goodsInfo);
		map_list = Json.fromJson(List.class, Json.toJson(goodsInfo));
		return map_list;
	}

}
