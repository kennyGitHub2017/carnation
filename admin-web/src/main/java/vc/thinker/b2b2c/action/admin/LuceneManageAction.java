package vc.thinker.b2b2c.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.tools.LuceneVoTools;
import com.sinco.carnation.juanpi.service.JuanpiGoodsService;
import com.sinco.carnation.juanpi.service.SynJuanpiDataService;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.LuceneUtil;

/**
 * 
 * <p>
 * Title: GoodsManageAction.java
 * </p>
 * 
 * <p>
 * Description: 商品管理类
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
 * @date 2014年5月27日
 * 
 * @version 1.0.1
 */
@Controller
public class LuceneManageAction {
	private Logger logger = LoggerFactory.getLogger(LuceneManageAction.class);
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private LuceneVoTools luceneVoTools;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreSearchService storeSearchService;
	@Autowired
	private SynJuanpiDataService synJuanpiDataService;
	@Autowired
	private JuanpiGoodsService juanpiGoodsService;

	/**
	 * Goods 索引更新
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "搜索引擎设置", value = "/admin/set_lucene.htm*", rtype = "admin", rname = "搜索引擎设置", rcode = "admin_lucene", rgroup = "系统管理")
	@RequestMapping("/admin/set_lucene.htm")
	public ModelAndView luceneManage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/lucene.html", configService.getSysConfig(), 0,
				request, response);
		return mv;
	}

	/**
	 * Goods 索引更新
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "更新所有商品索引", value = "/admin/update_goods_lucene.htm*", rtype = "admin", rname = "搜索引擎管理", rcode = "admin_lucene", rgroup = "系统管理")
	@RequestMapping("/admin/update_goods_lucene.htm")
	@ResponseBody
	public String update_goods_lucene() {
		// 删除商品所有索引
		luceneUtil.deleteFileByIndex("goods");
		List<Long> allList = goodsService.findAllSellingGoods();
		if (CollectionUtils.isNotEmpty(allList)) {
			for (Long id : allList) {
				Goods goods = goodsService.getObjById(CommUtil.null2Long(id));
				if (goods != null) {
					logger.info("start modify good index in lucene, goods_name=" + goods.getGoodsName());
					// 更新lucene索引
					luceneUtil.update(CommUtil.null2String(id), luceneVoTools.updateGoodsIndex(goods));
				}
			}
		}
		allList = juanpiGoodsService.findAllSellingGoods();
		if (CollectionUtils.isNotEmpty(allList)) {
			for (Long id : allList) {
				synJuanpiDataService.updateLucene(id);
			}
		}
		logger.info("modify goods index in lucene,success!");
		return "＝＝＝＝更新商品索引成功！！！！";
	}
	
	@SecurityMapping(title = "更新卷皮商品&索引", value = "/admin/update_juanpi_goods_lucene.htm*", rtype = "admin", rname = "搜索引擎管理", rcode = "admin_lucene", rgroup = "系统管理")
	@RequestMapping("/admin/update_juanpi_goods.htm")
	@ResponseBody
	public String update_juanpi_goods() {
		synJuanpiDataService.synJuanpiGoods();
		return "＝＝＝＝更新卷皮商品&索引成功！！！！";
	}
	
	@SecurityMapping(title = "更新卷皮订单", value = "/admin/update_juanpi_order.htm*", rtype = "admin", rname = "搜索引擎管理", rcode = "admin_lucene", rgroup = "系统管理")
	@RequestMapping("/admin/update_juanpi_order.htm")
	@ResponseBody
	public String update_juanpi_order(Integer days) {
		if(days == null || days <= 0){
			days = 3;
		}
		synJuanpiDataService.synJuanpiOrder2(days);
		return "＝＝＝＝更新卷皮订单成功！！！！";
	}

	/**
	 * Goods 索引更新
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "更新所有店铺索引", value = "/admin/update_store_lucene.htm*", rtype = "admin", rname = "搜索引擎管理", rcode = "admin_lucene", rgroup = "系统管理")
	@RequestMapping("/admin/update_store_lucene.htm")
	@ResponseBody
	public String update_store_lucene() {
		// 删除索引
		luceneUtil.deleteFileByIndex("store");
		List<Long> allList = storeService.findInitLuceneList();
		logger.info("[update store index], store id array=" + allList.toArray(new Long[allList.size()]));
		storeSearchService.deleteIndex();
		logger.info("[update store index], delete store index success.");
		storeSearchService.updateIndex(allList.toArray(new Long[allList.size()]));
		return "＝＝＝＝更新店铺异步进行中索引成功！！！！";
	}
}