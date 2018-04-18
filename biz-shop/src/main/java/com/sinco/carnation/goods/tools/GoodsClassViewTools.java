package com.sinco.carnation.goods.tools;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsYgClassBO;
import com.sinco.carnation.goods.dao.GoodsBrandDao;
import com.sinco.carnation.goods.dao.GoodsClassDao;
import com.sinco.carnation.goods.model.GoodsBrand;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsBrandService;
import com.sinco.carnation.goods.service.GoodsYgClassService;
import com.sinco.carnation.goods.vo.GoodsClassCountVO;
import com.sinco.carnation.goods.vo.GoodsYgClassCountVO;
import com.sinco.carnation.recommend.service.AdvertPositionService;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;

/**
 * 
 * <p>
 * Title: GoodsClassViewTools.java
 * </p>
 * 
 * <p>
 * Description:
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
 */
@Component
public class GoodsClassViewTools {
	@Autowired
	private GoodsClassDao goodsClassDao;
	@Autowired
	private AdvertPositionService apService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private GoodsBrandDao goodsBrandDao;
	@Autowired
	private GoodsBrandService goodsBrandService;
	@Autowired
	private GoodsYgClassService goodsYgClassService;

	/**
	 * 查询指定数量的商品分类信息
	 * 
	 * @param pid
	 * @param count
	 * @return
	 */
	@SuppressWarnings("unused")
	public Collection<GoodsClassBO> query_gc(String pid, int count) {
		List<GoodsClassBO> gcs = null;
		GoodsClassCountVO vo = new GoodsClassCountVO();
		vo.setDisplay(true);
		vo.setCount(count);
		if (!CommUtil.null2String(pid).equals("")) {
			vo.setParentId(CommUtil.null2Long(pid));
			return goodsClassDao.findLevelByCount(vo);
		} else {
			return goodsClassDao.findLevelByCount(vo);
		}
	}

	/**
	 * 查询主分类中显示的品牌信息
	 * 
	 * @param count
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<Map> query_gc_brand(String gc_id) {
		List<Map> map_list = null;
			GoodsClass gc = this.goodsClassDao.findOne(CommUtil.null2Long(gc_id));
		if (gc != null && gc.getGbInfo() != null && !gc.getGbInfo().equals("")) {
			map_list = (List<Map>) Json.fromJson(gc.getGbInfo());
		}
		return map_list;
	}

	/**
	 * 查询主分类中显示的广告信息
	 * 
	 * @param count
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public Map query_gc_advert(String gc_id, String web_url) {
		Map adv_map = new HashMap();
		GoodsClass gc = this.goodsClassDao.findOne(CommUtil.null2Long(gc_id));
		if (gc != null && gc.getGcAdvert() != null && !gc.getGcAdvert().equals("")) {
			Map map_temp = (Map) Json.fromJson(gc.getGcAdvert());
			if (CommUtil.null2Int(map_temp.get("adv_type")) == 0) {// 系统广告
				AdvertPosition ap = this.apService.getObjById(CommUtil.null2Long(map_temp.get("adv_id")));
				if (ap != null) {
					if (ap.getApAccUrl() != null && !ap.getApAccUrl().equals("")) {
						adv_map.put("advert_url", web_url + "/advert_redirect.htm?url=" + ap.getApAccUrl()
								+ "&id=" + ap.getId());
					}
					if (StringUtils.isNotBlank(ap.getApImgPath())) {
						adv_map.put("advert_img", ap.getApImgPath());
					}
				}
			}
			if (CommUtil.null2Int(map_temp.get("adv_type")) == 1) {// 自定义广告
				Accessory acc = this.accessoryService.getObjById(CommUtil.null2Long(map_temp.get("acc_id")));
				if (acc != null) {
					adv_map.put("advert_url", CommUtil.null2String(map_temp.get("acc_url")));
					adv_map.put("advert_img", acc.getPath());
				}
			}
		}
		return adv_map;
	}

	/***
	 * 品牌馆 左侧菜单,
	 * 
	 * @return
	 */
	public List<GoodsBrandBO> query_gc_brand_new() {
		GoodsBrand goodsBrand = new GoodsBrand();
		goodsBrand.setDeleteStatus(false);
		return this.goodsBrandService.groupGoodsBrand(goodsBrand);
	}

	/**
	 * 查询指定数量的商品分类信息
	 * 
	 * @param pid
	 * @param count
	 * @return
	 */
	@SuppressWarnings("unused")
	public Collection<GoodsYgClassBO> query_yg_gc(String pid, int count) {
		List<GoodsYgClassBO> gcs = null;
		GoodsYgClassCountVO vo = new GoodsYgClassCountVO();
		vo.setDisplay(true);
		vo.setCount(count);
		if (!CommUtil.null2String(pid).equals("")) {
			vo.setParentId(CommUtil.null2Long(pid));
			return goodsYgClassService.findLevelByCount(vo);
		} else {
			return goodsYgClassService.findLevelByCount(vo);
		}
	}

}
