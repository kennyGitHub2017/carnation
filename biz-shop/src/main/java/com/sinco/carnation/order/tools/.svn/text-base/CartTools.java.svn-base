package com.sinco.carnation.order.tools;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.operation.OperationConstants;
import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.dao.CouponInfoDao;
import com.sinco.carnation.operation.vo.CouponInfoMyVO;

/**
 * 
 * 
 * <p>
 * Title:CartTools.java
 * </p>
 * 
 * <p>
 * Description:订单工具类，用以处理各个店铺的优惠劵信息
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
 * @date 2014年5月12日
 * 
 * @version 1.0.1
 */
@Component
public class CartTools {
	@Autowired
	private CouponInfoDao couponInfoDao;

	/**
	 * 查出该用户在店铺（包括自营）所可以使用的优惠券
	 * 
	 * @param store_id
	 * @param total_price
	 * @return
	 */
	public List<CouponInfoBO> query_coupon(String store_id, String total_price, Long uid) {
		Date date = new Date();
		CouponInfoMyVO vo = new CouponInfoMyVO();
		vo.setCouponOrderAmount(BigDecimal.valueOf(CommUtil.null2Double(total_price)));
		vo.setUid(uid);
		vo.setCouponBeginTime(date);
		vo.setCouponEndTime(date);
		vo.setStatus(OperationConstants.COUPON_INFO_STATUS_0);

		if (store_id.equals("self")) {// 自营
			vo.setCouponType(OperationConstants.COUPON_TYPE_0);
		} else {// 第三方经营
			vo.setStoreId(CommUtil.null2Long(store_id));
		}
		List<CouponInfoBO> couponinfos = this.couponInfoDao.findMyCoupon(vo, null);
		return couponinfos;
	}

//	/**
//	 * 手机端优惠券查询
//	 * 
//	 * @param store_id
//	 * @param total_price
//	 * @return
//	 */
//	public List<CouponInfo> mobile_query_coupon(String store_id,
//			String total_price, String user_id) {
//		User user = this.userService.getObjById(CommUtil.null2Long(user_id));
//		Map params = new HashMap();
//		List<CouponInfo> couponinfos = new ArrayList<CouponInfo>();
//		params.put("coupon_order_amount",
//				BigDecimal.valueOf(CommUtil.null2Double(total_price)));
//		params.put("user_id", user.getId());
//		params.put("coupon_begin_time", new Date());
//		params.put("coupon_end_time", new Date());
//		params.put("status", 0);
//		if (store_id.equals("self")) {// 自营
//			params.put("coupon_type", 0);
//			couponinfos = this.couponInfoService
//					.query("select obj from CouponInfo obj where obj.coupon.coupon_order_amount<=:coupon_order_amount "
//							+ "and obj.status=:status and obj.user.id=:user_id and obj.coupon.coupon_type=:coupon_type "
//							+ "and obj.coupon.coupon_begin_time<=:coupon_begin_time and obj.coupon.coupon_end_time>=:coupon_end_time",
//							params, -1, -1);
//		} else {// 第三方经营
//			params.put("store_id", CommUtil.null2Long(store_id));
//			couponinfos = this.couponInfoService
//					.query("select obj from CouponInfo obj where obj.coupon.coupon_order_amount<=:coupon_order_amount "
//							+ "and obj.status=:status and obj.user.id=:user_id and obj.coupon.store.id=:store_id "
//							+ "and obj.coupon.coupon_begin_time<=:coupon_begin_time and obj.coupon.coupon_end_time>=:coupon_end_time",
//							params, -1, -1);
//		}
//		return couponinfos;
//	}
}
