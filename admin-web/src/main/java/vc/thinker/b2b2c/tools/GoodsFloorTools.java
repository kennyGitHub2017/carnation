package vc.thinker.b2b2c.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsBrand;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsBrandService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsFloorService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.recommend.service.AdvertPositionService;
import com.sinco.carnation.recommend.service.AdvertService;
import com.sinco.carnation.sns.bo.AdvertPositionBO;
import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;

/**
 * 
 * <p>
 * Title: GoodsFloorTools.java
 * </p>
 * 
 * <p>
 * Description:楼层管理json转换工具
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
 * @date 2014-6-24
 * 
 * @version 1.0.1
 */
@Component
public class GoodsFloorTools {

	private static final Logger log = LoggerFactory.getLogger(GoodsFloorTools.class);

	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsFloorService goodsFloorService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private GoodsBrandService goodsBrandService;
	@Autowired
	private AdvertPositionService advertPositionService;
	@Autowired
	private AdvertService advertService;

	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<GoodsClass> generic_gf_gc(String json) {
		List<GoodsClass> gcs = new ArrayList<GoodsClass>();
		if (json != null && !json.equals("")) {
			List<Map> list = Json.fromJson(List.class, json);
			for (Map map : list) {
				GoodsClass the_gc = this.goodsClassService.getObjById(CommUtil.null2Long(map.get("pid")));
				if (the_gc != null) {
					int count = CommUtil.null2Int(map.get("gc_count"));
					GoodsClassBO gc = new GoodsClassBO();
					gc.setId(the_gc.getId());
					gc.setClassName(the_gc.getClassName());
					for (int i = 1; i <= count; i++) {
						GoodsClassBO child = this.goodsClassService.getBOById(CommUtil.null2Long(map
								.get("gc_id" + i)));
						if (child != null) {
							if (gc.getChilds() == null) {
								gc.setChilds(new ArrayList<GoodsClassBO>());
							}
							gc.getChilds().add(child);
						}
					}
					gcs.add(gc);
				}
			}
		}
		return gcs;
	}

	@SuppressWarnings("rawtypes")
	public List<Goods> generic_goods(String json) {
		List<Goods> goods_list = new ArrayList<Goods>();
		if (json != null && !json.equals("")) {
			Map map = Json.fromJson(Map.class, json);
			for (int i = 1; i <= 10; i++) {
				String key = "goods_id" + i;
				// System.out.print(map.get(key));
				GoodsBO goods = this.goodsService.findBOByid(CommUtil.null2Long(map.get(key)));
				if (goods != null) {
					goods_list.add(goods);
				}

			}
		}
		return goods_list;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public Map generic_goods_list(String json) {
		Map map = new HashMap();
		map.put("list_title", "商品排行");
		if (json != null && !json.equals("")) {
			List<GoodsBO> goodsList = new ArrayList<GoodsBO>();
			Map list = Json.fromJson(Map.class, json);
			map.put("list_title", CommUtil.null2String(list.get("list_title")));
			for (int i = 0; i < 10; i++) {
				String name = new StringBuilder("goods_id").append(i + 1).toString();
				Object gid = list.get(name);
				if (gid != null) {
					GoodsBO goods = this.goodsService.findBOByid(CommUtil.null2Long(gid));
					if (goods != null) {
						goodsList.add(goods);
					}

				}
			}
			map.put("goodsList", goodsList);

		}
		return map;
	}

	@SuppressWarnings("rawtypes")
	public List<GoodsBrand> generic_brand(String json) {
		List<GoodsBrand> brands = new ArrayList<GoodsBrand>();
		if (json != null && !json.equals("")) {
			Map map = Json.fromJson(Map.class, json);
			for (int i = 1; i <= 12; i++) {
				String key = "brand_id" + i;
				GoodsBrand brand = this.goodsBrandService.getObjById(CommUtil.null2Long(map.get(key)));
				if (brand != null) {
					brands.add(brand);
				}
			}
		}
		return brands;
	}

	@SuppressWarnings({"unused", "rawtypes"})
	public String generic_adv(String web_url, String json) {
		String template = "<div style='float:left;overflow:hidden;'>";
		String imageServer = configService.getSysConfig().getImageWebServer();
		if (json != null && !json.equals("")) {
			Map map = Json.fromJson(Map.class, json);
			if (CommUtil.null2String(map.get("adv_id")).equals("")) {
				String img = CommUtil.null2String(map.get("acc_id"));

				if (StringUtils.isNotBlank(img)) {
					String url = CommUtil.null2String(map.get("acc_url"));

					template = template + "<a href='" + url + "' target='_blank'><img src='" + img
							+ "' /></a>";
				}
			} else {
				AdvertPosition ap = this.advertPositionService.getObjById(CommUtil.null2Long(map
						.get("adv_id")));
				AdvertPositionBO obj = new AdvertPositionBO();
				obj.setApType(ap.getApType());
				obj.setApStatus(ap.getApStatus());
				obj.setApShowType(ap.getApShowType());
				obj.setApWidth(ap.getApWidth());
				obj.setApHeight(ap.getApHeight());
				List<Advert> advs = this.advertService.findListByAdApId(ap.getId(),
						AdvertContant.AD_STATUS_PASS, new Date(), new Date());
				if (advs.size() > 0) {
					if (obj.getApType().equals("img")) {
						if (obj.getApShowType() == AdvertContant.AP_SHOW_TYPE_0) {// 固定广告
							obj.setApImgPath(advs.get(0).getAdImgPath());
							obj.setApAccUrl(advs.get(0).getAdUrl());
							obj.setAdvId(advs.get(0).getId());
						}
						if (obj.getApShowType() == AdvertContant.AP_SHOW_TYPE_1) {// 随机广告
							Random random = new Random();
							int i = random.nextInt(advs.size());
							obj.setApImgPath(advs.get(0).getAdImgPath());
							obj.setApAccUrl(advs.get(0).getAdUrl());
							obj.setAdvId(advs.get(0).getId());
						}
					}
				} else {
					obj.setApImgPath(ap.getApImgPath());
					obj.setApText(ap.getApText());
					obj.setApAccUrl(ap.getApAccUrl());
				}
				//
				template = template + "<a href='" + obj.getApAccUrl() + "' target='_blank'><img src='"
						+ obj.getApImgPath() + "' /></a>";
			}
		}
		template = template + "</div>";
		return template;
	}

	/**
	 * 生成配置首页style2样式单个模块信息
	 * 
	 * @param json
	 * @param module_id
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public Map generic_style2_goods(String json, String module_id) {
		try {
			List<Map> maps = Json.fromJson(List.class, json);
			if (maps == null) {
				return null;
			}
			for (Map map : maps) {
				if (map.get("module_id").equals(module_id)) {
					return map;
				}
			}
		} catch (Exception e) {
			log.error("", e);
			return null;
		}
		return null;
	}
}
