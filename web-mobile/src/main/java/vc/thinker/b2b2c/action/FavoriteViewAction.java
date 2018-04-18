package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.LuceneUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.tools.LuceneVoTools;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.service.UserCustomerService;

/**
 * 
 * <p>
 * Title: FavoriteViewAction.java
 * </p>
 * 
 * <p>
 * Description: 商城前台收藏控制器，用来添加商品、店铺收藏
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
 * @date 2014-4-30
 * 
 * @version 1.0.1
 */
@Controller
public class FavoriteViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private LuceneVoTools luceneVoTools;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private GroupGoodsService groupGoodsService;

	@RequestMapping("/add_goods_favorite.htm")
	public void add_goods_favorite(HttpServletResponse response, String id) {
		int ret = 0;

		Goods goods = goodsService.getObjById(CommUtil.null2Long(id));

		if (goods != null) {
			try {
				ret = customerService.addFavorites(SecurityUserHolder.getCurrentUserId(), id,
						UserContants.FAVORITES_TYPE_3);
			} catch (ServiceException e) {
				ret = 1;
			}

			goods.setGoodsCollect(goods.getGoodsCollect() + 1);
			// 更新lucene索引
			luceneUtil.update(id, luceneVoTools.updateGoodsIndex(goods));
		} else {
			ret = 1;
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
	 * 添加服务收藏
	 * 
	 * @param response
	 * @param id
	 */
	@RequestMapping("/add_group_favorite.htm")
	public void add_group_favorite(HttpServletResponse response, String id) {
		int ret = 0;

		GroupGoods goods = groupGoodsService.getObjById(CommUtil.null2Long(id));

		if (goods != null) {
			try {
				ret = customerService.addFavorites(SecurityUserHolder.getCurrentUserId(), id,
						UserContants.FAVORITES_TYPE_5);
			} catch (ServiceException e) {
				ret = 1;
			}
		} else {
			ret = 1;
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

	@RequestMapping("/add_store_favorite.htm")
	public void add_store_favorite(HttpServletResponse response, String id) {

		int ret = 0;

		Store store = storeService.getObjById(CommUtil.null2Long(id));
		if (store != null) {
			try {
				customerService.addFavorites(SecurityUserHolder.getCurrentUserId(), id,
						UserContants.FAVORITES_TYPE_4);
			} catch (ServiceException e) {
				ret = 1;
			}

		} else {
			ret = 1;
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
