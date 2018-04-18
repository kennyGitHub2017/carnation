package com.sinco.carnation.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.elong.model.ElongOrder;
import com.sinco.carnation.elong.service.ElongOrderService;

/**
 * 艺农酒店订单数据同步
 * @author Tivan
 *
 */
public class ElongOrderSynJob {
	protected static final Logger LOGGER = LoggerFactory.getLogger(ElongOrderSynJob.class);
	private ElongOrderService elongOrderService;
	
	public void setElongOrderService(ElongOrderService elongOrderService) { 
		this.elongOrderService = elongOrderService;
	}
	
	/**
	 * 同步艺农酒店订单状态
	 */
	public void orderSyn(){
		//获取需要的同步订单
		List<ElongOrder> orders = elongOrderService.querySynOrderList();
		if(orders != null && orders.size() > 0){
			for(ElongOrder order : orders){
				/*if(order.getPaymentDeadlineTime() != null && order.getPaymentDeadlineTime().before(new Date())){
					order.setStatus("E");
					order.setShowStatus("256");
					order.setLastUpdateTime(new Date());
					elongOrderService.updateById(order);
				}*/
				elongOrderService.synOrder(order.getId());
			}
		}
	}
	
}
