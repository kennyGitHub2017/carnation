package com.sinco.carnation.goods.tools;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.bo.FootPointView;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.user.service.FootPointService;

/**
 * 
 * <p>
 * Title: FootPointTools.java
 * </p>
 * 
 * <p>
 * Description:足迹处理控制器，用来解析足迹数据
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
 * @date 2014-10-17
 * 
 * @version 1.0.1
 */
@Component
public class FootPointTools {
	@Autowired
	private FootPointService footPointService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private StoreService storeService;

	@SuppressWarnings({"unchecked", "rawtypes"})
	public List<FootPointView> generic_fpv(String json) {
		List<FootPointView> fpvs = new ArrayList<FootPointView>();
		if (!CommUtil.null2String(json).equals("")) {
			try {
				List<Map> list = Json.fromJson(List.class, json);
				for (Map map : list) {
					FootPointView fpv = new FootPointView();
					fpv.setFpv_goods_id(CommUtil.null2Long(map.get("goods_id")));
					fpv.setFpv_goods_img_path(CommUtil.null2String(map.get("goods_img_path")));
					fpv.setFpv_goods_name(CommUtil.null2String(map.get("goods_name")));
					fpv.setFpv_goods_sale(CommUtil.null2Int(map.get("goods_sale")));
					fpv.setFpv_goods_price(BigDecimal.valueOf(CommUtil.null2Double(map.get("goods_price"))));
					fpv.setFpv_goods_class_id(CommUtil.null2Long(map.get("goods_class_id")));
					fpv.setFpv_goods_class_name(CommUtil.null2String(map.get("goods_class_name")));
					fpvs.add(fpv);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fpvs;
	}

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
		return store;
	}

	public Store goodsSecondDomainByGoodsId(Long id) {
		GoodsBO goods = this.goodsService.findBOByid(CommUtil.null2Long(id));
		Store store = this.storeService.getObjById(goods.getGoodsStoreId());
		return store;
	}
}
