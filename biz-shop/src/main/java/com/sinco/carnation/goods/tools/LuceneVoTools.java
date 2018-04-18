package com.sinco.carnation.goods.tools;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.LuceneVo;

import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.service.GoodsBrandService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;

/**
 * 
 * <p>
 * Title: LuceneUpdateTools.java
 * </p>
 * 
 * <p>
 * Description: lucene更新时的调用方法
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
 * @date 2014-6-5
 * 
 * 
 * @version 1.0.1
 */
@Component
public class LuceneVoTools {
//	@Autowired
//	private GroupViewTools groupViewTools;
//	@Autowired
//	private IActivityService activityService;
//	@Autowired
//	private IEnoughReduceService enoughReduceService;
//	@Autowired
//	private IBuyGiftService buyGiftService;
	@Autowired
	private GoodsBrandService goodsBrandService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private GoodsClassService goodsClassService;

	/**
	 * 封装商品信息到lucene索引
	 * 
	 * @param goods
	 * @return lucene索引
	 */
	@SuppressWarnings("unused")
	public LuceneVo updateGoodsIndex(Goods goods) {

		GoodsBO goodsBO = new GoodsBO();
		BeanUtils.copyProperties(goods, goodsBO);

		LuceneVo vo = new LuceneVo();
		// vo.setGoods_target(goods.getGoodsTarget());
		vo.setVo_id(goods.getId());
		vo.setVo_title(goods.getGoodsName());
		vo.setVo_content(goods.getGoodsDetails());
		vo.setVo_type("goods");
		vo.setVo_store_price(CommUtil.null2Double(goodsBO.getGoodsShowPrice()));
		vo.setVo_mobile_price(CommUtil.null2Double(goodsBO.getMobilePrice()));
		if (StringUtils.isNotBlank(goods.getGoodsTarget())) {
			vo.setTarget(goods.getGoodsTarget().split(",|，"));
		}
		if (goods.getAddTime() != null) {
			vo.setVo_add_time(goods.getAddTime().getTime());
		}
		if (goods.getGoodsSalenum() != null) {
			vo.setVo_goods_salenum(goods.getGoodsSalenum());
		}
		if (goods.getGoodsCollect() != null) {
			vo.setVo_goods_collect(goods.getGoodsCollect());
		}
		vo.setVo_well_evaluate(CommUtil.null2Double(goods.getWellEvaluate()));
		if (goods.getGoodsInventory() != null) {
			vo.setVo_goods_inventory(goods.getGoodsInventory());
		}
		if (goods.getGoodsType() != null) {
			vo.setVo_goods_type(goods.getGoodsType());
		}
		if (goods.getGoodsBrandId() != null) {
			vo.setVo_goods_brandname(goodsBrandService.getObjById(goods.getGoodsBrandId()).getName());
		}
		if (goods.getGoodsMainPhotoPath() != null) {
			vo.setVo_main_photo_url(goods.getGoodsMainPhotoPath());
		}
		if (goods.getExPriceFlag() != null && goods.getCnSelfAddPrice() != null) {
			if (goods.getExPriceFlag() == 1 && goods.getCnSelfAddPrice().compareTo(BigDecimal.ZERO) == 1) {
				vo.setBv(goods.getCnSelfAddPrice().doubleValue());
			} else {
				vo.setBv(BigDecimal.ZERO.doubleValue());
			}
		}
//		if (goods.getGoodsStoreId() != null
//				&& goods.getGoods_store().getUser() != null) {
//			vo.setVo_store_username(goods.getGoods_store().getUser()
//					.getUserName());
//		}
		List<String> list = new ArrayList<String>();
		for (Accessory obj : accessoryService.selectGoodsPhotos(goods.getId())) {
			list.add(obj.getPath());
		}
		String str = Json.toJson(list, JsonFormat.compact());
		vo.setVo_photos_url(str);
		vo.setVo_goods_evas(evaluateService.selectEvaluateByGoodsId(goods.getId()).size());
		GoodsClassBO gcBo = goodsClassService.getBOById(goods.getGcId());
		if (gcBo != null && gcBo.getLevel() == 2) {
			vo.setVo_goods_class(CommUtil.null2String(gcBo.getParentId()) + "_"
					+ CommUtil.null2String(goods.getGcId()));
		} else {
			vo.setVo_goods_class(CommUtil.null2String(goods.getGcId()) + "_");
		}
		vo.setVo_goods_transfee(String.valueOf(goods.getGoodsTransfee()));
		vo.setVo_goods_cod(goods.getGoodsCod());
		if (goods.getOrderEnoughGiveStatus() != null && 1 == goods.getOrderEnoughGiveStatus()) {
			vo.setVo_whether_active(1);
		}
		if (goods.getOrderEnoughGiveStatus() != null && 0 == goods.getOrderEnoughGiveStatus()) {
			vo.setVo_whether_active(0);
		}
		// 查询商品正在进行的优惠活动
		// 0为无活动 1为团购,2为活动，3为满送，4为满减，5为组合，6为F码，7为预售。
		int active = 0;
		Date nowDate = new Date();
//		if (goods.getGroupBuy() == 2) {
//			if (goods.getGroup().getBeginTime().before(nowDate)) {
//				active = 1;
//			}
//		}
//		if (goods.getActivityStatus() == 2) {
//			Activity ac = this.activityService.getObjById(CommUtil
//					.null2Long(goods.getActivityGoodsId()));
//			if (ac != null && ac.getAc_begin_time().before(nowDate)) {
//				active = 2;
//			}
//		}
//		if (goods.getOrderEnoughGiveStatus() == 1) {
//			BuyGift bg = this.buyGiftService.getObjById(goods.getBuyGift_id());
//			if (bg != null && bg.getBeginTime().before(nowDate)) {
//				active = 3;
//			}
//		}
//		if (goods.getEnoughReduce() == 1) {
//			EnoughReduce er = this.enoughReduceService.getObjById(CommUtil
//					.null2Long(goods.getOrderEnoughReduceId()));
//			if (er.getErbegin_time().before(nowDate)) {
//				active = 4;
//			}
//		}
		if (goods.getCombinStatus() != null && goods.getCombinStatus() == 1) {
			active = 5;
		}
		if (goods.getfSaleType() != null && goods.getfSaleType() == 1) {
			active = 6;
		}
		if (goods.getAdvanceSaleType() != null && goods.getAdvanceSaleType() == 1) {
			active = 7;
		}
		vo.setVo_whether_active(active);
		if (goods.getfSaleType() != null) {
			vo.setVo_f_sale_type(goods.getfSaleType());
		}
		if (goods.getHasExchangeIntegral() != null) {
			vo.setVo_has_exchange_integral(goods.getHasExchangeIntegral());
		} else {
			vo.setVo_has_exchange_integral(false);
		}
		if (goods.getHasMobilePrice() != null) {
			vo.setVo_has_mobile_price(goods.getHasMobilePrice());
		} else {
			vo.setVo_has_mobile_price(false);
		}
		// 非CN会员登陆需要过滤精品专区商品，添加 2017-07-11 tw
		vo.setVo_is_ygb(goods.getIsYgb() == null ? 0 : goods.getIsYgb());
		// CN会员登陆商城页面需要展示BV值，添加 2017-02-27 tw
		vo.setVo_goods_price(goods.getGoodsPrice() == null ? 0 : goods.getGoodsPrice().doubleValue());
		vo.setVo_self_add_price(goods.getSelfAddPrice() == null ? 0 : goods.getSelfAddPrice().doubleValue());
		vo.setVo_cn_self_add_price(goods.getCnSelfAddPrice() == null ? 0 : goods.getCnSelfAddPrice()
				.doubleValue());
		vo.setVo_ex_price_flag(goods.getExPriceFlag() == null ? 0 : goods.getExPriceFlag());
		if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(goods.getInventoryType())) {
			// 如果为多规格商品，列表页面默认显示最小价格
			vo.setVo_inventory_type(GoodsConstants.GOODS_INVENTORY_TYPE_SPEC);
			if (StringUtils.isNotBlank(goods.getGoodsInventoryDetail())) {
				JSONArray jsonArr = JSONArray.fromObject(goods.getGoodsInventoryDetail());
				double defaultSelfAddPrice = 0;
				double defaultCnSelfAddPrice = 0;
				double defaultStorePrice = 0;
				Double defaultPrice = null;
				int minIndex = -1;
				if (jsonArr != null && jsonArr.size() > 0) {
					for (int i = 0; i < jsonArr.size(); i++) {
						JSONObject jsonObj = jsonArr.getJSONObject(i);
						double price = jsonObj.optDouble("price", 0);
						if (defaultPrice == null) {
							defaultPrice = price;
							minIndex = i;
						} else {
							if (defaultPrice > price) {
								defaultPrice = price;
								minIndex = i;
							}
						}
					}
				}
				if (minIndex > -1) {
					JSONObject jsonObj = jsonArr.getJSONObject(minIndex);
					defaultSelfAddPrice = jsonObj.optDouble("selfAddPrice", 0);
					defaultCnSelfAddPrice = jsonObj.optDouble("cnSelfAddPrice", 0);
					// 只有商户商品才会有加价
					if (goods.getGoodsType() != null && goods.getGoodsType() == 1) {
						defaultStorePrice = jsonObj.optDouble("price", 0) - defaultSelfAddPrice;
					} else {
						defaultStorePrice = jsonObj.optDouble("price", 0);
					}
				}
				vo.setVo_self_add_price(defaultSelfAddPrice);
				vo.setVo_cn_self_add_price(defaultCnSelfAddPrice);
				vo.setVo_store_price(defaultStorePrice);
			}
		}
		return vo;
	}

//	/**
//	 * 设置生活类团购商品的索引
//	 *
//	 * @param goods
//	 * @return LuceneVo
//	 */
//	public LuceneVo updateLifeGoodsIndex(GroupLifeGoods goods) {
//		LuceneVo vo = new LuceneVo();
//		vo.setVo_id(goods.getId());
//		vo.setVo_title(goods.getGg_name());
//		vo.setVo_content(goods.getGroup_details());
//		vo.setVo_type("lifegoods");
//		vo.setVo_store_price(CommUtil.null2Double(goods.getGroup_price()));
//		vo.setVo_add_time(goods.getAddTime().getTime());
//		vo.setVo_goods_salenum(goods.getGroupInfos().size());
//		if (goods.getGroup_acc() != null) {
//			vo.setVo_main_photo_url(goods.getGroup_acc().getPath() + "/"
//					+ goods.getGroup_acc().getName());
//		}
//		vo.setVo_cost_price(CommUtil.null2Double(goods.getCost_price()));
//		vo.setVo_cat(goods.getGg_gc().getId().toString());
//		String rate = this.groupViewTools.getRate(
//				CommUtil.null2Double(goods.getGroup_price()),
//				CommUtil.null2Double(goods.getCost_price())).toString();
//		vo.setVo_rate(rate);
//		if (goods.getGg_ga() != null) {
//			vo.setVo_goods_area(goods.getGg_ga().getId().toString());
//		}
//
//		return vo;
//	}
//
//	/**
//	 * 设置团购商品的索引
//	 *
//	 * @param goods
//	 * @return LuceneVo
//	 */
//	public LuceneVo updateGroupGoodsIndex(GroupGoods goods) {
//		LuceneVo vo = new LuceneVo();
//		vo.setVo_id(goods.getId());
//		vo.setVo_title(goods.getGg_name());
//		vo.setVo_content(goods.getGg_content());
//		vo.setVo_type("groupgoods");
//		vo.setVo_store_price(CommUtil.null2Double(goods.getGg_price()));
//		vo.setVo_add_time(goods.getAddTime().getTime());
//		vo.setVo_goods_salenum(goods.getGg_selled_count());
//		vo.setVo_cost_price(CommUtil.null2Double(goods.getGg_goods()
//				.getGoods_price()));
//		if (goods.getGg_img() != null) {
//			vo.setVo_main_photo_url(goods.getGg_img().getPath() + "/"
//					+ goods.getGg_img().getName());
//		}
//		vo.setVo_cat(goods.getGg_gc().getId().toString());
//		vo.setVo_rate(CommUtil.null2String(goods.getGg_rebate()));
//		if (goods.getGg_ga() != null) {
//			vo.setVo_goods_area(goods.getGg_ga().getId().toString());
//		}
//		return vo;
//	}
}
