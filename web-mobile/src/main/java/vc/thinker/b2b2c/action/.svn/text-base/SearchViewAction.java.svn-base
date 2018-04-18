package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.GoodsDocument;
import vc.thinker.b2b2c.lucene.LuceneCommonUtil;
import vc.thinker.b2b2c.lucene.LuceneResult;
import vc.thinker.b2b2c.lucene.LuceneUtil;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;

/**
 * 
 * <p>
 * Title: SearchViewAction.java
 * </p>
 * 
 * <p>
 * Description: 商品搜索控制器，商城搜索支持关键字全文搜索
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
 * @author thinker,jy
 * 
 * @date 2014-6-5
 * 
 * 
 * @version 1.0.1
 */
@Controller
public class SearchViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private StoreService storeService;
	// @Autowired
	// private GoodsService goodsService;
	// @Autowired
	// private StoreViewTools storeViewTools;
	// @Autowired
	// private StoreGradeService storeGradeService;
	// @Autowired
	// private AreaServiceImpl areaService;
	// @Autowired
	// private GroupPriceRangeService groupPriceRangeService;
	// @Autowired
	// private GroupLifeGoodsService groupLifeGoodsService;
	// @Autowired
	// private GroupClassService groupClassService;
	// @Autowired
	// private NavViewTools navTools;
	// @Autowired
	// private UserTools userTools;
	// @Autowired
	// private IGroupService groupService;
	@Autowired
	private GoodsViewTools goodsViewTools;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private DicContent dicContent;
	@Autowired
	private UserAccountService userAccountService;

	@RequestMapping("/search.htm")
	public ModelAndView search(HttpServletRequest request,
			HttpServletResponse response, String gc_id, String keyword,
			GoodsVO vo, MyPage<GoodsBO> page

	) throws UnsupportedEncodingException {
		/* H5 */
		/*
		 * ModelAndView mv = new JModelAndView("lucene/search_goods_list.html",
		 * configService.getSysConfig(), 1, request, response);
		 */
		/* H5 */
		ModelAndView mv = new JModelAndView(
				"web_mobile/search_goods_list.html",
				configService.getSysConfig(), 1, request, response);
		keyword = QueryParser.escape(keyword);
		// 将关键字加入用户的搜索历史中
		if (StringUtils.isNotEmpty(keyword)) {
			response.addCookie(search_history_cookie(request, keyword));

			// 根据店铺SEO关键字，查出关键字命中的店铺
			if (keyword != null && !keyword.equals("") && keyword.length() > 1) {
				mv.addObject("stores", search_stores_seo(keyword));
			}
			boolean order_type = true;
			if (CommUtil.null2String(vo.getOrderType()).equals("")) {
				vo.setOrderType("desc");
			}
			if (!vo.getOrderType().equals("desc")) {
				order_type = false;
			}
			if (StringUtils.isEmpty(vo.getOrderBy())) {
				vo.setOrderBy("add_time");
			}

			SortBuilder sort = null;
			String query_gc = "";
			String order_by = vo.getOrderBy();
			if (CommUtil.null2String(vo.getOrderBy()).equals(
					"goods_current_price")) {
				order_by = "store_price";
			}
			sort = new FieldSortBuilder(order_by)
					.order(order_type ? SortOrder.DESC : SortOrder.ASC);
			if (gc_id != null && !gc_id.equals("")) {
				GoodsClass gc = this.goodsClassService.getObjById(CommUtil
						.null2Long(gc_id));
				query_gc = gc.getLevel() == 1 ? gc_id + "_*" : CommUtil
						.null2String(gc.getParentId()) + "_" + gc_id;
				mv.addObject("gc_id", gc_id);
			}
			LuceneResult pList = null;
			boolean onlyCN = vo.getExPriceFlag() != null && vo.getExPriceFlag() == 1;
			if (sort != null) {
				/*
				 * pList = luceneUtil._search(keyword,
				 * CommUtil.null2Int(page.getCurrentPage()-1),
				 * CommUtil.null2String(vo.getGoodsInventory()),
				 * CommUtil.null2String(vo.getGoodsType()), query_gc,
				 * CommUtil.null2String(vo.getGoodsTransfee()),
				 * CommUtil.null2String(vo.getGoodsCod()), sort, null, null,
				 * null);
				 */
				pList = luceneUtil.search(GoodsDocument.class, keyword,
						CommUtil.null2Int(page.getCurrentPage() - 1),
						CommUtil.null2String(vo.getGoodsInventory()),
						CommUtil.null2String(vo.getGoodsType()), query_gc,
						CommUtil.null2String(vo.getGoodsTransfee()),
						CommUtil.null2String(vo.getGoodsCod()), null, null,
						null, sort,onlyCN, null, true, null, null);
			} else {
				pList = luceneUtil.search(GoodsDocument.class, keyword,
						CommUtil.null2Int(page.getCurrentPage() - 1),
						CommUtil.null2String(vo.getGoodsInventory()),
						CommUtil.null2String(vo.getGoodsType()), query_gc,
						CommUtil.null2String(vo.getGoodsTransfee()),
						CommUtil.null2String(vo.getGoodsCod()), null, null,
						null, null,onlyCN, null, true, null, null);
			}

			LuceneCommonUtil.saveLucene2ModelAndView(pList, mv);

			// 对关键字命中的商品进行分类提取
			Set<String> list_gcs = pList.getGoodsClassList();
			// luceneUtil.LoadData_goods_class(GoodsDocument.class,keyword);
			// 对商品分类数据进行分析加载,只查询id和className
			List<GoodsClassBO> gcs = this.query_GC_second(list_gcs);
			mv.addObject("gcs", gcs);
			mv.addObject("allCount", pList.getRows());
		}
		mv.addObject("keyword", keyword);
		mv.addObject("vo", vo);
		mv.addObject("currentPage", page.getCurrentPage());
		mv.addObject("gc_id", gc_id);
		mv.addObject("goodsViewTools", goodsViewTools);
		// 加载页面上其它的商品信息，最近浏览，猜你喜欢，推广热卖，直通车。
		this.search_other_goods(mv);
		// 处理系统商品对比信息
		// List<Goods> goods_compare_list = (List<Goods>) request
		// .getSession(false).getAttribute("goods_compare_cart");
		// // 计算商品对比中第一间商品的分类，只允许对比同一个分类的商品
		// if (goods_compare_list == null) {
		// goods_compare_list = new ArrayList<Goods>();
		// }
		// int compare_goods_flag = 0;// 默认允许对比商品，如果商品分类不一致曾不允许对比
		// for (Goods compare_goods : goods_compare_list) {
		// if (compare_goods != null) {
		// compare_goods = this.goodsService.getObjById(compare_goods
		// .getId());
		// if (!compare_goods.getGc().getParent().getParent().getId()
		// .equals(CommUtil.null2Long(gc_id))) {
		// compare_goods_flag = 1;
		// }
		// }
		// }
		// mv.addObject("compare_goods_flag", compare_goods_flag);
		// mv.addObject("goods_compare_list", goods_compare_list);
		//加入CN用户判断  2017-3-16 tw
		if (SecurityUserHolder.getCurrentUser() != null) {
			Long uid = SecurityUserHolder.getCurrentUserId();
			UserAccountBO account1 = new UserAccountBO();
			account1.setUid(uid);
			account1.setAccountType(UserContant.ACCOUNT_TYPE_8);
			UserAccountBO cnUserAccount = userAccountService.findAccountByVo(account1);
			boolean isCN = cnUserAccount != null;
			mv.addObject("isCN", isCN);
		}
		return mv;
	}

	/**
	 * 搜索框下拉提示相关分类
	 * 
	 * @param request
	 * @param response
	 * @param keyword
	 */
	@RequestMapping("/search_goodsclass.htm")
	public void search_goodsclass(HttpServletRequest request,
			HttpServletResponse response, String keyword) {
		if (keyword == null || keyword.equals("")) {
			return;
		}
		List<GoodsClassBO> objs = this.goodsClassService.findRelatedGoodsClass(
				2, keyword);
		Map<String, Object> map = null;
		if (objs.size() > 0) {
			map = new HashMap<>();
			List<Map<String, String>> list_parent = new ArrayList<>();
			List<List<Map<String, String>>> list_child = new ArrayList<>();
			for (GoodsClassBO obj : objs) {
				Map<String, String> parent_gc = new HashMap<String, String>();
				parent_gc.put("id", obj.getId().toString());
				parent_gc.put("name", obj.getClassName());
				list_parent.add(parent_gc);

				List<GoodsClassBO> childs = dicContent
						.getDicsConvertByParentCode(GoodsClassBO.class,
								CommUtil.null2String(obj.getId()));
				obj.setChilds(childs);

				List<Map<String, String>> list_temp = new ArrayList<Map<String, String>>();
				for (GoodsClass Child : obj.getChilds()) {
					Map<String, String> map_temp = new HashMap<String, String>();
					map_temp.put("id", Child.getId().toString());
					map_temp.put("name", Child.getClassName());
					list_temp.add(map_temp);
				}
				list_child.add(list_temp);
			}
			map.put("parent_gc", list_parent);
			map.put("list_child", list_child);
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(map, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载页面上其它的商品信息，最近浏览，猜你喜欢，推广热卖，直通车。
	 * 
	 * @param mv
	 */
	public void search_other_goods(ModelAndView mv) {
		// 如果系统开启直通车，商品列表页顶部推荐热卖商品及左侧推广商品均显示直通车商品
		// if (this.configService.getSysConfig().getZtcStatus()) {
		// // 页面左侧8条数据，从第3位开始查询
		// List<Goods> left_ztc_goods = null;
		// Map ztc_map = new HashMap();
		// ztc_map.put("ztc_status", 3);
		// ztc_map.put("now_date", new Date());
		// ztc_map.put("ztc_gold", 0);
		// // 获取所有商品数量，查询出的对象为只有id的对象，减少查询压力,查询所有直通车商品，随机显示出指定数量
		// List<Goods> all_left_ztc_goods = this.goodsService
		// .query("select obj.id from Goods obj where obj.ztc_status =:ztc_status "
		// + "and obj.ztc_begin_time <=:now_date and obj.ztc_gold>:ztc_gold "
		// + "order by obj.ztc_dredge_price desc", ztc_map,
		// -1, -1);
		// left_ztc_goods = this.goodsService
		// .query("select new Goods(id, goods_name, goods_current_price,goods_price, goods_main_photo) from Goods obj where obj.ztc_status =:ztc_status "
		// + "and obj.ztc_begin_time <=:now_date and obj.ztc_gold>:ztc_gold "
		// + "order by obj.ztc_dredge_price desc", ztc_map, 3,
		// all_left_ztc_goods.size());
		// left_ztc_goods = this.goodsViewTools.randomZtcGoods2(
		// left_ztc_goods, 8);
		// mv.addObject("left_ztc_goods", left_ztc_goods);
		// // 页面顶部,直通车前3个商品
		// List<Goods> top_ztc_goods = null;
		// Map ztc_map2 = new HashMap();
		// ztc_map2.put("ztc_status", 3);
		// ztc_map2.put("now_date", new Date());
		// ztc_map2.put("ztc_gold", 0);
		// top_ztc_goods = this.goodsService
		// .query("select new Goods(id, goods_name, goods_current_price,goods_price, goods_main_photo) from Goods obj where obj.ztc_status =:ztc_status "
		// + "and obj.ztc_begin_time <=:now_date and obj.ztc_gold>:ztc_gold "
		// + "order by obj.ztc_dredge_price desc", ztc_map2,
		// 0, 3);
		// mv.addObject("top_ztc_goods", top_ztc_goods);
		// } else {
		// Map params = new HashMap();
		// params.put("store_recommend", true);
		// params.put("goods_status", 0);
		// List<Goods> top_ztc_goods = this.goodsService
		// .query("select new Goods(id, goods_name, goods_current_price,goods_price, goods_main_photo) from Goods obj where obj.store_recommend=:store_recommend and obj.goods_status=:goods_status order by obj.goods_salenum desc",
		// params, 0, 3);
		// mv.addObject("top_ztc_goods", top_ztc_goods);
		// params.clear();
		// params.put("store_recommend", true);
		// params.put("goods_status", 0);
		// // 获取所有商品数量，查询出的对象为只有id的对象，减少查询压力,查询所有直通车商品，随机显示出指定数量
		// List<Goods> all_goods = this.goodsService
		// .query("select obj.id from Goods obj where obj.store_recommend=:store_recommend and obj.goods_status=:goods_status order by obj.goods_salenum desc",
		// params, -1, -1);
		// List<Goods> left_ztc_goods = this.goodsService
		// .query("select new Goods(id, goods_name, goods_current_price,goods_price, goods_main_photo) from Goods obj where obj.store_recommend=:store_recommend and obj.goods_status=:goods_status order by obj.goods_salenum desc",
		// params, 3, all_goods.size());
		// left_ztc_goods = this.goodsViewTools.randomZtcGoods2(
		// left_ztc_goods, 8);
		// mv.addObject("left_ztc_goods", left_ztc_goods);
		// }
	}

	/**
	 * 对商品分类数据进行处理去重，返回页面用以显示的二级分类
	 * 
	 * @param lucenc商品分类数据
	 * @return
	 */
	public List<GoodsClassBO> query_GC_second(Set<String> list_gcs) {
		String sid = new String();
		List<String> hasSelectList = new ArrayList<>();
		List<GoodsClassBO> gcs = new ArrayList<GoodsClassBO>();
		for (String str : list_gcs) {
			sid = str.split("_")[0];
			if (!hasSelectList.contains(sid)) {
				hasSelectList.add(sid);
				GoodsClassBO bo = (GoodsClassBO) dicContent.getTreeDic(
						GoodsClassBO.class, sid);
				gcs.add(bo);
			}
		}
		return gcs;
	}

	/**
	 * 根据店铺SEO关键字，查出关键字命中的店铺
	 * 
	 * @param keyword
	 * @return
	 */
	public List<StoreBO> search_stores_seo(String keyword) {
		List<StoreBO> stores = this.storeService.findStoreByKeywords(keyword);
		if (CollectionUtils.isNotEmpty(stores)) {
			Collections.sort(stores, new Comparator<StoreBO>() {
				public int compare(StoreBO o1, StoreBO o2) {
					StoreBO store1 = o1;
					StoreBO store2 = o2;
					int l1 = store1.getStoreSeoKeywords().split(",").length;
					int l2 = store2.getStoreSeoKeywords().split(",").length;
					if (l1 > l2) {
						return 1;
					}
					;
					if (l1 == l2) {
						if (store1
								.getPoint()
								.getStoreEvaluate()
								.compareTo(store2.getPoint().getStoreEvaluate()) == 1) {
							return -1;
						}
						;
						if (store1
								.getPoint()
								.getStoreEvaluate()
								.compareTo(store2.getPoint().getStoreEvaluate()) == -1) {
							return 1;
						}
						;
						return 0;
					}
					return -1;
				}
			});
		}
		return stores;
	}

	/**
	 * 得到一个存有搜索数据的Cookie
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public Cookie search_history_cookie(HttpServletRequest request,
			String keyword) throws UnsupportedEncodingException {
		String str = "";
		Cookie[] cookies = request.getCookies();
		Cookie search_cookie = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("search_history")) {
				String str_temp = URLDecoder.decode(cookie.getValue(), "UTF-8");
				for (String s : str_temp.split(",")) {
					if (!s.equals(keyword) && !str.equals("")) {
						str = str + "," + s;
					} else if (!s.equals(keyword)) {
						str = s;
					}
				}
				break;
			}
			;
		}
		if (str.equals("")) {
			str = keyword;
			str = URLEncoder.encode(str, "UTF-8");
			search_cookie = new Cookie("search_history", str);
		} else {
			str = keyword + "," + str;
			str = URLEncoder.encode(str, "UTF-8");
			search_cookie = new Cookie("search_history", str);
		}
		return search_cookie;
	}
}
