package com.sinco.carnation.store.tools;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinco.carnation.free.service.FreeGoodsService;
import com.sinco.carnation.goods.dao.GoodsDao;
import com.sinco.carnation.goods.dao.ReturnGoodsLogDao;
import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.shop.dao.ComplaintDao;
import com.sinco.carnation.shop.dao.ConsultDao;
import com.sinco.carnation.shop.dao.OrderFormDao;
import com.sinco.carnation.store.dao.PayoffLogDao;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.dao.UserMoneyDao;

/**
 * 
 * <p>
 * Title: StatTools.java
 * </p>
 * 
 * <p>
 * Description:统计工具类，用来在超级后台的首页显示统计信息，统计不是及时的，为了节约系统开支，系统定时进行数据统计并保存到数据库中
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
 * @date 2015-3-16
 * 
 * @version 1.0.1
 */
@Component
public class StatTools {
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private GoodsDao goodsDao;
//	@Autowired
//	private DeliveryAddressService deliveryService;
//	@Autowired
//	private CircleService circleService;
//	@Autowired
//	private InvitationService invitationService;
//	@Autowired
//	private InformationService informationService;
	@Autowired
	private ConsultDao consultDao;
	@Autowired
	private OrderFormDao orderFormDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PayoffLogDao plDao;
	@Autowired
	private ReturnGoodsLogDao returnGoodsLogDao;
	@Autowired
	private FreeGoodsService freegoodsService;
//	@Autowired
//	private GroupInfoService groupinfoService;
	@Autowired
	private ComplaintDao complaintDao;
	@Autowired
	private UserMoneyDao userMoneyDao;
	@Autowired
	private ReturnGoodsLogService returngoodslogService;
	@Autowired
	private UserCustomerDao customerDao;

	public int query_store(int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, count);
		return this.storeDao.selectStoreCountByTime(cal.getTime());
	}

	public int query_user(int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, count);
		return this.userDao.selectUserCountByTime(cal.getTime());
	}

//	public int query_live_user(int count) {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_YEAR, count);
//		params.put("lastLoginDate", cal.getTime());
//		params.put("userRole", "ADMIN");
//		list = this.userService
//				.query("select obj.id from User obj where obj.lastLoginDate>=:lastLoginDate and obj.userRole!=:userRole",
//						params, -1, -1);
//		return list.size();
//	}
	public int query_goods(int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, count);
		return this.goodsDao.selectGoodsCountByTime(cal.getTime());
	}

	public int query_order(int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, count);
		return this.orderFormDao.selectCountByTime(cal.getTime());
	}

//	public int query_ztc(int count) {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_YEAR, count);
//		params.put("time", cal.getTime());
//		params.put("ztc_status", 2);
//		list = this.goodsService
//				.query("select obj.id from Goods obj where obj.addTime>=:time and obj.ztc_status=:ztc_status",
//						params, -1, -1);
//		return list.size();
//	}
//
//	public int query_delivery(int count) {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_YEAR, count);
//		params.put("time", cal.getTime());
//		params.put("da_status", 10);
//		list = this.deliveryService
//				.query("select obj.id from DeliveryAddress obj where obj.addTime>=:time and obj.da_status=:da_status",
//						params, -1, -1);
//		return list.size();
//	}
//
//	public int query_circle(int count) {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_YEAR, count);
//		params.put("time", cal.getTime());
//		params.put("status", 5);
//		list = this.circleService
//				.query("select obj.id from Circle obj where obj.addTime>=:time and obj.status=:status",
//						params, -1, -1);
//		return list.size();
//	}
//
//	public int query_information(int count) {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_YEAR, count);
//		params.put("time", cal.getTime());
//		params.put("status", 20);
//		list = this.informationService
//				.query("select obj.id from Information obj where obj.addTime>=:time and obj.status=:status",
//						params, -1, -1);
//		return list.size();
//	}
//
//	public int query_invitation(int count) {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_YEAR, count);
//		params.put("time", cal.getTime());
//		list = this.invitationService
//				.query("select obj.id from CircleInvitation obj where obj.addTime>=:time",
//						params, -1, -1);
//		return list.size();
//	}
//
	public int query_all_user() {
		return this.customerDao.count();
	}

	public int query_all_goods() {
		return this.goodsDao.count();
	}

	public int query_all_store() {
		return this.storeDao.count();
	}

	public int query_audit_store() {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(10);
		return this.storeDao.selectAuditStoreCount(list);
	}

	public BigDecimal query_all_amount() {
		return this.orderFormDao.selectSumTotlePriceByStatus(60);
	}

	public int query_complaint(int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, count);
		return this.complaintDao.findCountByStatusAndTime(0, cal.getTime());
	}

	public int query_payoff() {
		return this.plDao.selectCountByStatus(1);
	}

	public BigDecimal query_all_user_balance() {
		return this.userMoneyDao.selectSumBalance();
	}

	public int query_refund() {
		return this.returnGoodsLogDao.selectCountByStatus(0, "10");
	}

//	public int query_grouplife_refund() {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		params.put("status", 5);
//		list = this.groupinfoService.query(
//				"select obj.id from GroupInfo obj where obj.status=:status",
//				params, -1, -1);
//		return list.size();
//	}
//
//	public int query_ztc_audit() {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		params.put("ztc_status", 1);
//		list = this.goodsService
//				.query("select obj.id from Goods obj where obj.ztc_status=:ztc_status",
//						params, -1, -1);
//		return list.size();
//	}
//
//	public int query_delivery_audit() {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		params.put("da_status", 0);
//		list = this.deliveryService
//				.query("select obj.id from DeliveryAddress obj where obj.da_status=:da_status",
//						params, -1, -1);
//		return list.size();
//	}
//
//	public int query_information_audit() {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		params.put("status", 10);
//		list = this.informationService.query(
//				"select obj.id from Information obj where obj.status=:status",
//				params, -1, -1);
//		return list.size();
//	}

	public int query_self_goods() {
		return this.goodsDao.selectGoodsCountByStatusAndType(0, 0);
	}

	public int query_self_storage_goods() {
		return this.goodsDao.selectGoodsCountByStatusAndType(0, 1);
	}

	public int query_self_consult() {
		return this.consultDao.selectCountByRepayAndSelf(false, 1);
	}

	public int query_self_order_shipping() {
		List<Integer> list = new ArrayList<>();
		list.add(20);
		list.add(16);
		return this.orderFormDao.selectSelfOrderShipping(1, 2, list);
	}

	public int query_self_order_pay() {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(16);
		return this.orderFormDao.selectSelfOrderShipping(1, 2, list);
	}

	public int query_self_order_evaluate() {
		List<Integer> list = new ArrayList<>();
		list.add(40);
		return this.orderFormDao.selectSelfOrderShipping(1, 2, list);
	}

	public int query_self_all_order() {
		return this.orderFormDao.selectSelfOrderShipping(1, 2, null);
	}

	public int query_self_return_apply() {
		return this.returnGoodsLogDao.selectCountByGoodsTypeAndStatus(0, "5");
	}

//	public int query_self_groupinfo_return_apply() {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		params.put("status", 3);
//		params.put("goods_type", 1);
//		list = this.groupinfoService
//				.query("select obj.id from GroupInfo obj where obj.status=:status and obj.lifeGoods.goods_type=:goods_type",
//						params, -1, -1);
//		return list.size();
//	}
////
	// 2015版新增统计信息
	// 未审核商品数
	public int query_goods_audit() {
		return this.goodsDao.selectGoodsCountByStatusAndType(null, -5);
	}
//
//	// 自营促销商品
//	public int query_self_activity_goods() {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		params.put("goods_type", 0);
//		params.put("activity_status", 2);
//		list = this.goodsService
//				.query("select obj.id from Goods obj where obj.activity_status=:activity_status and obj.goods_type=:goods_type",
//						params, -1, -1);
//		return list.size();
//	}
//
//	public int query_self_group_goods() {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		params.put("goods_type", 0);
//		params.put("group_buy", 2);
//		list = this.goodsService
//				.query("select obj.id from Goods obj where obj.group_buy=:group_buy and obj.goods_type=:goods_type",
//						params, -1, -1);
//		return list.size();
//	}
//
//	public int query_self_group_life() {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		params.put("goods_type", 0);
//		params.put("group_type", 1);
//		params.put("group_buy", 2);
//		list = this.goodsService
//				.query("select obj.id from Goods obj where obj.group_buy=:group_buy and obj.goods_type=:goods_type and obj.group.group_type=:group_type",
//						params, -1, -1);
//		return list.size();
//	}
//
//	public int query_self_free_goods() {
//		List list = new ArrayList();
//		Map params = new HashMap();
//		params.put("freeStatus", 5);
//		params.put("freeType", 1);
//		list = this.freegoodsService
//				.query("select obj.id from FreeGoods obj where obj.freeStatus=:freeStatus and obj.freeType=:freeType",
//						params, -1, -1);
//		return list.size();
//	}

}
