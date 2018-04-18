package vc.thinker.b2b2c.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.LuceneUtil;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.bo.GoodsBrandCategoryBO;
import com.sinco.carnation.goods.model.GoodsBrand;
import com.sinco.carnation.goods.service.GoodsBrandCategoryService;
import com.sinco.carnation.goods.service.GoodsBrandService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.tools.NavViewTools;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: BrandViewAction.java
 * </p>
 * 
 * <p>
 * Description: 品牌相关控制器
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2012-2014
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author KENNY
 * 
 * @date 2014-4-28
 * 
 */

@Controller
public class BrandViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsBrandService goodsBrandService;
	@Autowired
	private GoodsBrandCategoryService goodsBrandCategorySerivce;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GoodsViewTools goodsViewTools;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private GoodsBrandCategoryService goodsBrandCategoryService;
	@Autowired
	private NavViewTools navTools;
	@Autowired
	private GoodsClassService goodsClassService;

	/***
	 * 品牌馆首页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("brandStore/index")
	public ModelAndView brandStoreIndex(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("brand_store/brand_store_index.html",
				configService.getSysConfig(), 1, request, response);
		List<GoodsBrandCategoryBO> category = this.goodsBrandCategoryService.findAll();
		GoodsBrand gb = new GoodsBrand();
		gb.setDeleteStatus(false);
		List<GoodsBrandBO> brandList = this.goodsBrandService.findByVo(gb);
		mv.addObject("categoryList", category);// 品牌类型
		mv.addObject("brandList", brandList);// 品牌列表
		mv.addObject("navTools", navTools);
		return mv;
	}

	/***
	 * 点击品牌图片，出现产品列表
	 * 
	 * @param request
	 * @param response
	 * @param goodsBrandId
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequestMapping("search-goodsBy-Brand")
	public ModelAndView searchGoodsBrand(HttpServletRequest request, HttpServletResponse response,
			String goodsBrandId, GoodsVO vo, MyPage<GoodsBO> page) {
		ModelAndView mv = new JModelAndView("brand_store/brand_goods_list.html",
				configService.getSysConfig(), 1, request, response);

		vo.setBrandIds(goodsBrandId);
		if ("".equals(vo.getOrderBy())) {
			vo.setOrderBy(null);
		}
		if ("".equals(vo.getOrderType())) {
			vo.setOrderType(null);
		}
		int allCount = 0;
		this.goodsService.getPageByVo(page, vo);
		List<GoodsBO> goodsList = page.getContent();
		if(goodsList!=null && goodsList.size() > 0){
			allCount = goodsList.size();
		}
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("vo", vo);
		mv.addObject("currentPage", page.getCurrentPage());
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("goodsBrandId", goodsBrandId);
		mv.addObject("allCount", allCount);
		/*		List<GoodsClassBO> gcs = this.goodsClassService.findLevelAll(true);
				mv.addObject("gcs", gcs);*/
		/*		List<GoodsBrandCategoryBO> brandCategory = this.goodsBrandCategorySerivce.findAll();
				mv.addObject("brandCategory", brandCategory);
				List<GoodsBrand> goodsBrand = this.goodsBrandService.findAll();
				mv.addObject("goodsBrand", goodsBrand);*/
		return mv;
	}

	/***
	 * 
	 * @param request
	 * @param response
	 * @param goodsBrandId
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequestMapping("search-goodsBy-Brand1")
	public ModelAndView searchGoodsBrand1(HttpServletRequest request, HttpServletResponse response,
			String goodsBrandId, GoodsVO vo, MyPage<GoodsBO> page) {
		ModelAndView mv = new JModelAndView("brand_store/brand_goods_list.html",
				configService.getSysConfig(), 1, request, response);

		vo.setBrandIds(goodsBrandId);
		this.goodsService.getPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("vo", vo);
		mv.addObject("currentPage", page.getCurrentPage());
		mv.addObject("goodsViewTools", goodsViewTools);
		return mv;
	}

//	/**
//	 * 品牌首页
//	 *
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping("/brand/index.htm")
//	public ModelAndView brand(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView("brand.html",
//				configService.getSysConfig(),
//				 1, request, response);
//		Map params = new HashMap();
//		params.put("recommend", true);
//		params.put("audit", 1);
//		List<GoodsBrand> gbs1 = this.goodsBrandService
//				.query("select obj from GoodsBrand obj where obj.recommend=:recommend and obj.audit=:audit order by obj.sequence asc",
//						params, 0, 21);
//		mv.addObject("gbs1", gbs1);
//		List<GoodsBrand> gbs2 = this.goodsBrandService
//				.query("select obj from GoodsBrand obj where obj.recommend=:recommend and obj.audit=:audit order by obj.sequence asc",
//						params, 21, 21);
//		if (gbs2.size() >= 21) {
//			mv.addObject("gbs2", gbs2);
//		}
//		List<GoodsBrand> gbs3 = this.goodsBrandService
//				.query("select obj from GoodsBrand obj where obj.recommend=:recommend and obj.audit=:audit order by obj.sequence asc",
//						params, 42, 21);
//		if (gbs3.size() >= 21) {
//			mv.addObject("gbs3", gbs3);
//		}
//		List<GoodsBrand> brands = new ArrayList<GoodsBrand>();
//		params.clear();
//		params.put("audit", 1);
//		brands = this.goodsBrandService
//				.query("select obj from GoodsBrand obj where obj.audit=:audit order by obj.sequence asc",
//						params, -1, -1);
//		List all_list = new ArrayList();
//		String list_word = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
//		String words[] = list_word.split(",");
//		for (String word : words) {
//			Map brand_map = new HashMap();
//			List brand_list = new ArrayList();
//			for (GoodsBrand gb : brands) {
//				if (!CommUtil.null2String(gb.getFirstWord()).equals("")
//						&& word.equals(gb.getFirstWord().toUpperCase())) {
//					brand_list.add(gb);
//				}
//			}
//			brand_map.put("brand_list", brand_list);
//			brand_map.put("word", word);
//			all_list.add(brand_map);
//		}
//		mv.addObject("all_list", all_list);
//		// 品牌街下方品牌标签
//		List<Map> list = new ArrayList<Map>();
//		List<GoodsBrandCategory> gbcs = this.goodsBrandCategorySerivce
//				.query("select obj from GoodsBrandCategory obj  order by obj.addTime desc",
//						null, 0, 8);
//		if (gbcs.size() < 7) {
//			return mv;
//		}
//		for (GoodsBrandCategory gbc : gbcs) {
//			if (gbc.getName() != null && !gbc.getName().equals("")
//					&& list.size() < 7) {
//				Map<String, Object> gbc_map = new HashMap<String, Object>();
//				List gbc_list = new ArrayList();
//
//				params.clear();
//				params.put("audit", 1);
//				params.put("gbc_id", gbc.getId());
//				List<GoodsBrand> gbs = this.goodsBrandService
//						.query("select obj from GoodsBrand obj where obj.audit=:audit and obj.category.id=:gbc_id order by obj.sequence asc",
//								params, 0, 9);
//				for (GoodsBrand goodsBrand : gbs) {
//					Map map = new HashMap();
//					map.put("id", goodsBrand.getId());
//					if (goodsBrand.getBrandLogo() != null) {
//						map.put("logo", goodsBrand.getBrandLogo().getPath()
//								+ "/" + goodsBrand.getBrandLogo().getName());
//					}
//					gbc_list.add(map);
//				}
//
//				gbc_map.put("name", gbc.getName());
//				gbc_map.put("brands", gbc_list);
//				list.add(gbc_map);
//			}
//		}
//		mv.addObject("list", list);
//		return mv;
//	}
//
//	/**
//	 * 根据品牌列表商品
//	 *
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping("/brand_goods.htm")
//	public ModelAndView brand_goods(HttpServletRequest request,
//			HttpServletResponse response, String id, String currentPage,
//			String orderBy, String orderType, String goods_inventory,
//			String goods_type, String goods_transfee, String goods_cod) {
//		ModelAndView mv = new JModelAndView("brand_goods.html",
//				configService.getSysConfig(),
//				 1, request, response);
//		GoodsBrand gb = this.goodsBrandService.getObjById(CommUtil
//				.null2Long(id));
//		if (gb != null) {
//			mv.addObject("gb", gb);
//			String path = System.getProperty("thinkervcb2b2c.root")
//					+ File.separator + "luence" + File.separator + "goods";
//			//LuceneUtil lucene = LuceneUtil.instance();
//			//lucene.setIndex_path(path);
//			Sort sort = null;
//			boolean order_type = true;
//			String order_by = "";
//			// 处理排序方式
//			if (CommUtil.null2String(orderBy).equals("goods_salenum")) {
//				order_by = "goods_salenum";
//				sort = new Sort(new SortField(order_by, SortField.Type.INT,
//						order_type));
//			}
//			if (CommUtil.null2String(orderBy).equals("goods_collect")) {
//				order_by = "goods_collect";
//				sort = new Sort(new SortField(order_by, SortField.Type.INT,
//						order_type));
//			}
//			if (CommUtil.null2String(orderBy).equals("well_evaluate")) {
//				order_by = "well_evaluate";
//				sort = new Sort(new SortField(order_by, SortField.Type.DOUBLE,
//						order_type));
//			}
//			if (CommUtil.null2String(orderType).equals("asc")) {
//				order_type = false;
//			}
//			if (CommUtil.null2String(orderType).equals("")) {
//				orderType = "desc";
//			}
//			if (CommUtil.null2String(orderBy).equals("goods_current_price")) {
//				order_by = "store_price";
//				sort = new Sort(new SortField(order_by, SortField.Type.DOUBLE,
//						order_type));
//			}
//			LuceneResult pList = null;
//			if (sort != null) {
//				pList = luceneUtil.search(null, CommUtil.null2Int(currentPage),
//						goods_inventory, goods_type, null, goods_transfee,
//						goods_cod, sort, null, null, gb.getName());
//			} else {
//				pList = luceneUtil.search(GoodsDocument.class,null, CommUtil.null2Int(currentPage),
//						goods_inventory, goods_type, null, goods_transfee,
//						goods_cod, null, null, gb.getName());
//			}
//			LuceneCommonUtil.saveLucene2ModelAndView(pList, mv);
//			mv.addObject("allCount", pList.getRows());
//			mv.addObject("stores", this.search_stores_seo(gb.getName()));
//			mv.addObject("more_gbs", this.more_gb(gb.getCategory()));
//		}
//		this.more_goods(mv);
//		mv.addObject("orderBy", orderBy);
//		mv.addObject("orderType", orderType);
//		mv.addObject("goods_type", goods_type);
//		mv.addObject("goods_inventory", goods_inventory);
//		mv.addObject("goods_transfee", goods_transfee);
//		mv.addObject("goods_cod", goods_cod);
//		// 处理系统商品对比信息
//		List<Goods> goods_compare_list = (List<Goods>) request
//				.getSession(false).getAttribute("goods_compare_cart");
//		// 计算商品对比中第一间商品的分类，只允许对比同一个分类的商品
//		if (goods_compare_list == null) {
//			goods_compare_list = new ArrayList<Goods>();
//		}
//		int compare_goods_flag = 0;// 默认允许对比商品，如果商品分类不一致曾不允许对比
//		for (Goods compare_goods : goods_compare_list) {
//			if (compare_goods != null) {
//				compare_goods = this.goodsService.getObjById(compare_goods
//						.getId());
//				if (!compare_goods.getGc().getParent().getParent().getId()
//						.equals(gb.getGc().getId())) {
//					compare_goods_flag = 1;
//				}
//			}
//		}
//		mv.addObject("compare_goods_flag", compare_goods_flag);
//		mv.addObject("goods_compare_list", goods_compare_list);
//		mv.addObject("goodsViewTools", goodsViewTools);
//		return mv;
//	}
//
//	/**
//	 * 根据店铺SEO关键字，查出经营该品牌的店铺
//	 *
//	 * @param keyword
//	 * @return
//	 */
//	public List<Store> search_stores_seo(String gb_name) {
//		Map params = new HashMap();
//		params.put("keyword1", gb_name);
//		params.put("keyword2", gb_name + ",%");
//		params.put("keyword3", "%," + gb_name + ",%");
//		params.put("keyword4", "%," + gb_name);
//		List<Store> stores = this.storeService
//				.query("select obj from Store obj where obj.store_seo_keywords =:keyword1 or obj.store_seo_keywords like:keyword2 or obj.store_seo_keywords like:keyword3 or obj.store_seo_keywords like:keyword4",
//						params, 0, 3);
//		Collections.sort(stores, new Comparator() {
//			public int compare(Object o1, Object o2) {
//				Store store1 = (Store) o1;
//				Store store2 = (Store) o2;
//				int l1 = store1.getStore_seo_keywords().split(",").length;
//				int l2 = store2.getStore_seo_keywords().split(",").length;
//				if (l1 > l2) {
//					return 1;
//				}
//				;
//				if (l1 == l2) {
//					if (store1.getPoint().getStore_evaluate()
//							.compareTo(store2.getPoint().getStore_evaluate()) == 1) {
//						return -1;
//					}
//					;
//					if (store1.getPoint().getStore_evaluate()
//							.compareTo(store2.getPoint().getStore_evaluate()) == -1) {
//						return 1;
//					}
//					;
//					return 0;
//				}
//				return -1;
//			}
//		});
//		return stores;
//	}
//
//	/**
//	 * 品牌主页上方“发现更多品牌”
//	 *
//	 * @param keyword
//	 * @return
//	 */
//	public List<GoodsBrand> more_gb(GoodsBrandCategory gbc) {
//		if (gbc != null && gbc.getBrands().size() > 5) {
//			return gbc.getBrands();
//		}
//		Map params = new HashMap();
//		params.put("recommend", true);
//		params.put("audit", 1);
//		List<GoodsBrand> gbs = this.goodsBrandService
//				.query("select obj from GoodsBrand obj where obj.recommend=:recommend and obj.audit=:audit order by obj.sequence asc",
//						params, 0, 6);
//		return gbs;
//	}
//
//	/**
//	 * 品牌主页左侧推广商品
//	 *
//	 * @param keyword
//	 * @return
//	 */
//	public void more_goods(ModelAndView mv) {
//		if (this.configService.getSysConfig().isZtc_status()) {
//			List<Goods> left_ztc_goods = null;
//			Map ztc_map = new HashMap();
//			ztc_map.put("ztc_status", 3);
//			ztc_map.put("now_date", new Date());
//			ztc_map.put("ztc_gold", 0);
//			// 获取所有商品数量，查询出的对象为只有id的对象，减少查询压力,查询所有直通车商品，随机显示出指定数量
//			List all_left_ztc_goods = this.goodsService
//					.query("select obj.id from Goods obj where obj.ztc_status =:ztc_status "
//							+ "and obj.ztc_begin_time <=:now_date and obj.ztc_gold>:ztc_gold "
//							+ "order by obj.ztc_dredge_price desc", ztc_map,
//							-1, -1);
//			left_ztc_goods = this.goodsService
//					.query("select new Goods(id, goods_name, goods_current_price,goods_price, goods_main_photo) from Goods obj where obj.ztc_status =:ztc_status "
//							+ "and obj.ztc_begin_time <=:now_date and obj.ztc_gold>:ztc_gold "
//							+ "order by obj.ztc_dredge_price desc", ztc_map, 0,
//							all_left_ztc_goods.size());
//			left_ztc_goods = this.goodsViewTools.randomZtcGoods2(
//					left_ztc_goods, 4);
//			mv.addObject("left_ztc_goods", left_ztc_goods);
//		} else {
//			Map params2 = new HashMap();
//			params2.clear();
//			params2.put("store_recommend", true);
//			params2.put("goods_status", 0);
//			// 获取所有商品数量，查询出的对象为只有id的对象，减少查询压力,查询所有直通车商品，随机显示出指定数量
//			List all_goods = this.goodsService
//					.query("select obj.id from Goods obj where obj.store_recommend=:store_recommend and obj.goods_status=:goods_status order by obj.goods_salenum desc",
//							params2, -1, -1);
//			List<Goods> left_ztc_goods = this.goodsService
//					.query("select new Goods(id, goods_name, goods_current_price,goods_price, goods_main_photo) from Goods obj where obj.store_recommend=:store_recommend and obj.goods_status=:goods_status order by obj.goods_salenum desc",
//							params2, 0, all_goods.size());
//			left_ztc_goods = this.goodsViewTools.randomZtcGoods2(
//					left_ztc_goods, 4);
//			mv.addObject("left_ztc_goods", left_ztc_goods);
//		}
//	}

}
