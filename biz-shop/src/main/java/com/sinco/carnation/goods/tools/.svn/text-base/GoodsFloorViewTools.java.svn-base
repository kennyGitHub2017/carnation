package com.sinco.carnation.goods.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.dao.GoodsBrandDao;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsFloorService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.vo.GoodsShowListVO;
import com.sinco.carnation.recommend.service.AdvertPositionService;
import com.sinco.carnation.recommend.service.AdvertService;
import com.sinco.carnation.sns.bo.AdvertPositionBO;
import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;

/**
 * 
 * <p>
 * Title: GoodsFloorViewTools.java
 * </p>
 * 
 * <p>
 * Description: 楼层管理json转换工具
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
 * @date 2014-8-25
 * 
 * @version 1.0.1
 */
@Component
public class GoodsFloorViewTools {
	@Autowired
	private GoodsFloorService goodsFloorService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private AdvertPositionService advertPositionService;
	@Autowired
	private AdvertService advertService;
	@Autowired
	private GoodsBrandDao goodsBrandDao;

	@SuppressWarnings({"unchecked", "rawtypes"})
	public List<GoodsClass> generic_gf_gc(String json) {
		List<GoodsClass> gcs = new ArrayList<GoodsClass>();
		if (json != null && !json.equals("")) {
			List<Map> list = Json.fromJson(List.class, json);
			for (Map map : list) {
				GoodsClassBO the_gc = this.goodsClassService.findByCache(CommUtil.null2Long(map.get("pid")));
				if (the_gc != null) {

					int count = CommUtil.null2Int(map.get("gc_count"));
					Set<Long> ids = new HashSet<Long>();
					for (int i = 1; i <= count; i++) {
						ids.add(CommUtil.null2Long(map.get("gc_id" + i)));
					}
					// 查询子类
					ids.add(CommUtil.null2Long(map.get("pid")));
					Collection<GoodsClassBO> childs = this.goodsClassService.findByCache(ids
							.toArray(new Long[ids.size()]));
					the_gc.setChilds(childs);
					gcs.add(the_gc);
				}
			}
		}
		return gcs;
	}

	@SuppressWarnings("rawtypes")
	public List<GoodsBO> generic_goods(String json) {
		List<Long> ids = new ArrayList<Long>();
		if (json != null && !json.equals("")) {
			Map map = Json.fromJson(Map.class, json);
			for (int i = 1; i <= 10; i++) {
				String key = "goods_id" + i;
				ids.add(CommUtil.null2Long(map.get(key)));
			}
			if (!ids.isEmpty()) {
				GoodsShowListVO vo = new GoodsShowListVO();
				vo.setIds(ids);
				return this.goodsService.findShopListBO(vo);
			}
		}
		return null;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public Map generic_goods_list(String json) {
		Map map = new HashMap();
		map.put("list_title", "商品排行");
		if (json != null && !json.equals("")) {
			Map list = Json.fromJson(Map.class, json);
			map.put("list_title", CommUtil.null2String(list.get("list_title")));
			List<Long> ids = Lists.newArrayList();
			for (int i = 0; i < 6; i++) {
				String name = new StringBuilder("goods_id").append(i + 1).toString();
				Object gid = list.get(name);
				if (gid != null) {
					ids.add(CommUtil.null2Long(gid));
				}
			}
			if (!ids.isEmpty()) {
				GoodsShowListVO vo = new GoodsShowListVO();
				vo.setIds(ids);
				map.put("goodsList", this.goodsService.findShopListBO(vo));
			}

		}
		return map;
	}

	@SuppressWarnings({"rawtypes", "unused"})
	public String generic_adv(String web_url, String json) {
		String template = "<div style='float:left;overflow:hidden;'>";
		if (json != null && !json.equals("")) {
			Map map = Json.fromJson(Map.class, json);
			if (CommUtil.null2String(map.get("adv_id")).equals("")) {
				String img = CommUtil.null2String(map.get("acc_id"));
				if (img != null) {
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

	@SuppressWarnings("rawtypes")
	public List<GoodsBrandBO> generic_brand(String json) {
		if (json != null && !json.equals("")) {
			Map map = Json.fromJson(Map.class, json);
			List<Long> ids = new ArrayList<Long>();
			for (int i = 1; i <= 12; i++) {
				String key = "brand_id" + i;
				ids.add(CommUtil.null2Long(map.get(key)));
			}
			return goodsBrandDao.findShopListByIds(ids);
		}
		return new ArrayList<GoodsBrandBO>();
	}

	/**
	 * 生成商城首页style2样式单个模块信息
	 * 
	 * @param json
	 * @param module_id
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public Map generic_style2_goods(String json, String module_id) {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		List<Map> maps = Json.fromJson(List.class, json);
		for (Map map : maps) {
			if (map.get("module_id").equals(module_id)) {
				return map;
			}
		}
		return null;
	}
}
