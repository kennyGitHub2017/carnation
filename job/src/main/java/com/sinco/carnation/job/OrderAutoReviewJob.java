package com.sinco.carnation.job;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.model.Evaluate;

/**
 * 订单收货7天默认好评，收货7天后不可评价
 * 
 * @author yuanming.feng
 * @date 2017年3月14日
 * 
 */
public class OrderAutoReviewJob {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private OrderFormService orderFormService;

	private OrderFormTools orderFormTools;

	private EvaluateService evaluateService;

	@Value(value = "${order.evaluate.content}")
	String content;

	@Value(value = "${order.auto.review.time}")
	int reviewTime;

	public synchronized void executeJob() {
		// 获取7天前的时间
		Date now = new Date();
		Calendar dateTime = Calendar.getInstance();
		dateTime.setTime(now);
		dateTime.set(Calendar.DATE, dateTime.get(Calendar.DATE) - reviewTime);
		Date daysAgo = dateTime.getTime();
		logger.info("=================订单收货" + reviewTime + "天默认好评，收货" + reviewTime + "天后不可评价。 开始时间：" + now
				+ "=================");
		// 获取超过7天已收货的订单列表
		List<OrderFormBO> orderForms = orderFormService.getOrdersByAutoReview(daysAgo,
				OrderFormConstants.ORDER_STATUS_TAKE_DELIVERY_OF_GOODS);
		logger.info("ClassName:" + this.getClass() + "====orderSize:" + orderForms.size());
		for (OrderFormBO item : orderForms) { // 遍历符合条件的订单信息
			logger.info("ClassName:" + this.getClass() + "====orderId:" + item.getId());
			// 解析订单的商品信息
			List<Map<String, Object>> goodsInfoMap = (List<Map<String, Object>>) orderFormTools
					.queryNewGoodsInfo(item.getGoodsInfo());
			List<Evaluate> evaluates = new ArrayList<Evaluate>();
			for (Map<String, Object> goodsInfo : goodsInfoMap) {
				// 商品ID
				String goodsId = goodsInfo.get("goods_id").toString();
				Evaluate exists = evaluateService.fetch(item.getUserId(), CommUtil.null2Long(goodsId),
						item.getId());
				// 跳过已评价的商品
				if (null != exists) {
					break;
				}
				// 商品数量
				String goodsCount = goodsInfo.get("goods_count").toString();
				// 商品价格
				String goodsPrice = goodsInfo.get("goods_price").toString();
				// 商品属性值
				String goodsGspVal = goodsInfo.get("goods_gsp_val").toString();
				// 封装评价Evaluate对象
				Evaluate evaluate = new Evaluate();
				evaluate.setDescriptionEvaluate(BigDecimal.valueOf(5)); // 描述相符评价 对卖家描述相符评价
				evaluate.setServiceEvaluate(BigDecimal.valueOf(5)); // 服务态度评价 对卖家服务态度评价
				evaluate.setShipEvaluate(BigDecimal.valueOf(5)); // 发货速度评价 对卖家发货速度评价
				evaluate.setEvaluateBuyerVal(1); // 买家评价 买家评价，评价类型，1为好评，0为中评，-1为差评
				evaluate.setEvaluateInfo(content); // 评价内容
				evaluate.setGoodsNum(CommUtil.null2Int(goodsCount));
				evaluate.setGoodsPrice(goodsPrice);
				evaluate.setGoodsSpec(goodsGspVal);
				evaluate.setEvaluateType("goods");
				evaluate.setAddTime(new Date());
				evaluate.setEvaluateUserId(item.getUserId());
				evaluate.setEvaluateGoodsId(CommUtil.null2Long(goodsId));
				evaluate.setOfId(item.getId());
				evaluate.setReplyStatus(0);
				evaluate.setEvaluateStatus(0);
				evaluates.add(evaluate);
				logger.info("ClassName:" + this.getClass() + "====goodsId:" + goodsId + "====goodsCount:"
						+ goodsCount + "====goodsPrice:" + goodsPrice + "====goodsGspVal:" + "goodsGspVal");
			}
			try {
				evaluateService.add(item, evaluates);
			} catch (Exception e) {
				logger.error("====orderId:" + item.getId() + ",===orderUid:" + item.getUserId()
						+ "===UserCustomer Object is null");
			}

		}
		logger.info("=================订单收货" + reviewTime + "天默认好评，收货" + reviewTime + "天后不可评价。 结束时间："
				+ new Date() + "=================");
	}

	public void setOrderFormService(OrderFormService orderFormService) {
		this.orderFormService = orderFormService;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setOrderFormTools(OrderFormTools orderFormTools) {
		this.orderFormTools = orderFormTools;
	}

	public void setEvaluateService(EvaluateService evaluateService) {
		this.evaluateService = evaluateService;
	}

}
