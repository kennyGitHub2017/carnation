package com.sinco.carnation.job;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.biz.utils.httpclient.HttpRequestClient;
import com.sinco.biz.utils.httpclient.Httpclient;
import com.sinco.carnation.jiuye.config.JiuyeConfig;
import com.sinco.carnation.jiuye.constant.JiuyeContants;
import com.sinco.carnation.jiuye.model.JiuyeOrder;
import com.sinco.carnation.jiuye.service.JiuyeOrderFormService;
import com.sinco.carnation.jiuye.vo.JiuyeOrderPojectVO;
import com.sinco.carnation.jiuye.vo.JiuyeOrderVO;
import com.sinco.carnation.user.model.UserMoney;
import com.sinco.carnation.user.service.UserMoneyService;

public class JiuyeOrderSynJob {
	private static final Logger LOG = LoggerFactory.getLogger(JiuyeOrderSynJob.class);
	private JiuyeOrderFormService jiuyeOrderFormService;
	private UserMoneyService userMoneyService;
	
	public void setJiuyeOrderFormService(JiuyeOrderFormService jiuyeOrderFormService){
		this.jiuyeOrderFormService = jiuyeOrderFormService;
	}
	
	public void setUserMoneyService(UserMoneyService userMoneyService){
		this.userMoneyService = userMoneyService;
	}
	
	public void syn(){
		int page = 1;
		List<String> orders = jiuyeOrderFormService.querySynOrderId(page++, 1000);
		while(orders != null && orders.size() > 0){
			orderSyn(orders);
			orders = jiuyeOrderFormService.querySynOrderId(page++, 1000);
		}
	}
	
	public void orderSyn(List<String> orderIds){
		String url = JiuyeConfig.getRemoteServiceDomain() + JiuyeContants.TEST_GET_ORDER_LIST;
		Httpclient<JiuyeOrderPojectVO> httpClient = new HttpRequestClient<JiuyeOrderPojectVO>();
		Map<String, String> argumentsMap = new HashMap<String, String>();
		for(String orderId : orderIds){
			argumentsMap.put("orderId", orderId);
			try{
				JiuyeOrderPojectVO orderVO = httpClient.get(url ,argumentsMap, JiuyeOrderPojectVO.class);
				if (orderVO !=  null) {
					JiuyeOrderVO order = orderVO.getOrder();
					if(order != null){
						int effect = jiuyeOrderFormService.updateOrderStatusByOrderId(orderId, order.getOrderStatus());
						if(effect > 0 && order.getOrderStatus() == 9){
							//用户退款，至云豆账户
							Map<String, Object> oo = jiuyeOrderFormService.getRefundOrderByOrderId(orderId);
							if(oo != null && oo.get("user_id") != null && oo.get("pay_money") != null){
								Long uid = (Long)oo.get("user_id");
								double amount = ((BigDecimal)oo.get("pay_money")).doubleValue();
								userMoneyService.addMoney(uid, amount, null, "退款", "酒业订单退款至用户云豆");
							}
						}
					}else{
						jiuyeOrderFormService.updateOrderStatusByOrderId(orderId, 10);
					}
				}else{
					LOG.info("订单不存在>>>id: " + orderId);
				}
			}catch(Exception e){
				LOG.error("同步订单状态失败", e);
			}
		}
	}
	
}
