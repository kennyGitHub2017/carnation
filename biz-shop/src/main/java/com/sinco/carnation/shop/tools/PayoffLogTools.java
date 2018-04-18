package com.sinco.carnation.shop.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;

/**
 * 
 * <p>
 * Title: MsgTools.java<／p>
 * 
 * <p>
 * Description: 结算账单工具类 <／p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015<／p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc<／p>
 * 
 * @author thinker
 * 
 * @date 2014-5-6
 * 
 * @version 1.0.1
 */
@Component
public class PayoffLogTools {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderFormService ofService;
	@Autowired
	private GoodsService goodsService;

	/**
	 * 解析json数据
	 * 
	 * @param
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<Map> queryGoodsInfo(String json) {
		List<Map> map_list = Json.fromJson(ArrayList.class, json);
		return map_list;
	}

	/**
	 * 查询账单中的对应的订单
	 * 
	 * @param order_id
	 * @return
	 */
	public OrderForm queryOrderInfo(String order_id) {
		OrderForm of = new OrderForm();
		if (order_id != null && !order_id.equals("")) {
			List<OrderFormBO> ofs = this.ofService.selectOrderFormByOrderId(order_id);
			if (ofs.size() > 0) {
				of = ofs.get(0);
			}
		}
		return of;
	}

	/**
	 * 查询账单中的对应的订单
	 * 
	 * @param order_id
	 * @return
	 */
	public OrderForm adminqueryOrderInfo(String order_id) {
		OrderForm of = new OrderForm();
		if (order_id != null && !order_id.equals("")) {
			List<OrderFormBO> ofs = this.ofService.selectOrderFormByOrderId(order_id);
			if (ofs.size() > 0) {
				of = ofs.get(0);
			}
		}
		return of;
	}

}
