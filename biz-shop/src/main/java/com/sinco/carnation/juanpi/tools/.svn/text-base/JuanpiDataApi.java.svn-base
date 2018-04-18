package com.sinco.carnation.juanpi.tools;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.bo.JuanpiOrderBO;
import com.sinco.carnation.juanpi.bo.JuanpiOrderGoodsBO;
import com.weixin.utils.HttpsRequest;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.Md5Encrypt;

/**
 * 卷皮数据查询
 * 
 * @author Tivan
 *
 */
public class JuanpiDataApi {
	public static final Logger LOG = LoggerFactory.getLogger(JuanpiDataApi.class);
	public static final String PREFIX = "yunshang2017";
	public static final String FROM = "yunshang";
	public static final String PC_UTM_NO = "2366153";
	public static final String WAP_UTM_NO = "2666143";
	public static final String PC_UTM = "$2y$10$xEwnRo72.Y6RoVDcvPE5yep6ZZnvs2uKkSNgm3EnOd77ntoFG8Pfi";
	public static final String WAP_UTM = "$2y$10$r/5gCKPezjje1eBZq/zazuzDemqD5bAzYj9TNBLPMeP4H1rskvEm6";
	public static final String GOODS_LIST = "http://www.juanpi.com/openapi/goodslist?p=%d&from=%s&sign=%s";
	//public static final String ORDER_LIST = "http://union.juanpi.com/openapi/getorderlist?starttime=%s&endtime=%s&utm=%s&sign=%s";
	public static final String ORDER_LIST = "https://union.juanpi.com/openapi/getOrderListOfys?starttime=%s&endtime=%s&utm=%s&sign=%s";
	public static final DateFormat DF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static final DateFormat DF2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	protected static Date parseDate(String date) {
		if (date == null) {
			return null;
		}
		try {
			if(date.indexOf("-") != -1){
				return DF2.parse(date);
			}else{
				return DF.parse(date);
			}
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static List<JuanpiGoodsBO> getGoods(int page) {
		LOG.info("获取卷皮商品开始...");
		String sign = String.format("%s{\"p\":\"%d\",\"from\":\"%s\"}", PREFIX, page, FROM);
		String url = String.format(GOODS_LIST, page, FROM, Md5Encrypt.md5(sign));
		String result = HttpsRequest.get(url);
		if (StringUtils.hasText(result)) {
			JSONObject json = JSONObject.parseObject(result);
			if (json.containsKey("status") && json.getIntValue("status") == 1) {
				JSONArray arrs = json.getJSONArray("data");
				if (arrs != null && arrs.size() > 0) {
					LOG.info("发现" + arrs.size() + "个商品");
					StringBuilder sbd = new StringBuilder();
					List<JuanpiGoodsBO> goodss = new ArrayList<JuanpiGoodsBO>();
					for (int i = 0; i < arrs.size(); i++) {
						// 封装商品数据
						JSONObject obj = arrs.getJSONObject(i);
						JuanpiGoodsBO goods = new JuanpiGoodsBO();
						goods.setId(obj.getLong("goods_id"));
						goods.setGoodsTitle(obj.getString("goods_title"));
						goods.setImageUrl(obj.getString("image_url"));
						goods.setGoodsCprice(obj.getBigDecimal("goods_cprice"));
						goods.setTuanCprice(obj.getBigDecimal("tuan_cprice"));
						goods.setGoodsPrice(obj.getBigDecimal("goods_price"));
						goods.setTargetUrlPc(obj.getString("target_url_pc"));
						goods.setTargetUrlM(obj.getString("target_url_m"));
						goods.setGoodsOnShelf(parseDate(obj.getString("goods_on_shelf")));
						goods.setGoodsOffShelf(parseDate(obj.getString("goods_off_shelf")));
						goods.setFreeDelivery(obj.getInteger("free_delivery"));
						goods.setCateId(obj.getLong("cate_id"));
						goods.setCateName(obj.getString("cate_name"));
						goods.setCate2Id(obj.getLong("cate2_id"));
						goods.setCate2Name(obj.getString("cate2_name"));
						goods.setCate3Id(obj.getLong("cate3_id"));
						goods.setCate3Name(obj.getString("cate3_name"));
						if (goods.getTuanCprice() != null && goods.getTuanCprice().compareTo(BigDecimal.ZERO) > 0) {
							goods.setIsTuangou(1);
						} else {
							goods.setIsTuangou(0);
						}
						goodss.add(goods);
						sbd.append(goods.getId()).append(",");
					}
					LOG.info("商品ID: " + sbd.toString());
					return goodss;
				}
			} else {
				LOG.error("获取卷皮商品失败：" + json.get("msg"));
			}
		}
		return null;
	}

	public static List<JuanpiOrderBO> getOrders(long startTime, long endTime) {
		LOG.info("获取卷皮订单开始...");
		String url = String.format(ORDER_LIST, startTime, endTime, WAP_UTM_NO, WAP_UTM);
		LOG.info("Request URL: " + url);
		String result = HttpsRequest.get(url);
		if (StringUtils.hasText(result)) {
			JSONObject json = JSONObject.parseObject(result);
			if (json.containsKey("status") && json.getIntValue("status") == 1) {
				JSONArray arrs = json.getJSONArray("dataList");
				if (arrs != null && arrs.size() > 0) {
					LOG.info("发现" + arrs.size() + "个订单");
					List<JuanpiOrderBO> orders = new ArrayList<JuanpiOrderBO>();
					for (int i = 0; i < arrs.size(); i++) {
						// 封装订单数据
						JSONObject obj = arrs.getJSONObject(i);
						JuanpiOrderBO order = new JuanpiOrderBO();
						order.setOrderno(obj.getString("orderno"));
						order.setOrdertime(parseDate(obj.getString("ordertime")));
						order.setSubchannel(obj.getString("subchannel"));
						order.setPlatid(obj.getInteger("platid"));
						order.setGoodslist(obj.getString("goodslist"));
						order.setUserId(CommUtil.null2Long(order.getSubchannel()));
						// 订单下商品列表
						long goodsnumber = 0;
						BigDecimal goodsmoney = BigDecimal.ZERO;
						JSONArray arrs2 = obj.getJSONArray("goodslist");
						if (arrs2 != null && arrs2.size() > 0) {
							List<JuanpiOrderGoodsBO> goodss = new ArrayList<JuanpiOrderGoodsBO>();
							for (int j = 0; j < arrs2.size(); j++) {
								JSONObject obj2 = arrs2.getJSONObject(j);
								JuanpiOrderGoodsBO goods = new JuanpiOrderGoodsBO();
								goods.setGoodsid(obj2.getLong("goodsid"));
								goods.setGoodstitle(obj2.getString("goodstitle"));
								goods.setGoodsnumber(obj2.getLong("goodsnumber"));
								goods.setGoodsmoney(obj2.getBigDecimal("goodsmoney"));
								goods.setBrokerageratiocale(obj2.getBigDecimal("brokerageratiocale"));
								goods.setCommission(obj2.getBigDecimal("commission"));
								goods.setStatus(obj2.getInteger("status"));
								if (goods.getGoodsmoney() != null && goods.getBrokerageratiocale() != null) {
									goods.setYunCommission(
											goods.getGoodsmoney().multiply(goods.getBrokerageratiocale()));
								}
								if (goods.getGoodsnumber() != null) {
									goodsnumber = goodsnumber + goods.getGoodsnumber();
								}
								if (goods.getGoodsmoney() != null) {
									goodsmoney = goodsmoney.add(goods.getGoodsmoney());
								}
								goodss.add(goods);
							}
							order.setGoodss(goodss);
							order.setGoodsnumber(goodsnumber);
							order.setGoodsmoney(goodsmoney);
						}
						orders.add(order);
					}
					return orders;
				}
			} else {
				LOG.error("获取卷皮订单失败：" + json.get("msg"));
			}
		}
		return null;
	}
}
