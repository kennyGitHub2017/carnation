package com.sinco.carnation.operation.service;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.operation.bo.CouponBO;
import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.dao.CouponDao;
import com.sinco.carnation.operation.dao.CouponInfoDao;
import com.sinco.carnation.operation.model.Coupon;
import com.sinco.carnation.operation.model.CouponInfo;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.dao.OrderFormDao;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class CouponService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CouponDao couponDao;

	@Autowired
	private UserCustomerDao userCustomerDao;

	@Autowired
	private CouponInfoDao couponInfoDao;

	@Autowired
	private OrderFormDao orderFormDao;

	@Autowired
	private UserService userService;

	@Transactional(readOnly = false)
	public Coupon save(Coupon coupon) {
		return couponDao.save(coupon);
	}

	public Coupon getObjById(Long id) {
		Coupon coupon = couponDao.get(id);
		if (coupon != null) {
			return coupon;
		}
		return null;
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		couponDao.remove(id);
	}

	@Transactional(readOnly = false)
	public void batchDelete(List<Serializable> couponIds) {
		for (Serializable id : couponIds) {
			delete((Long) id);
		}
	}

	@Transactional(readOnly = false)
	public void update(Coupon coupon) {
		couponDao.update(coupon);
	}

	/**
	 * 优惠券列表
	 * 
	 * @param couponName
	 * @param beginTime
	 * @param endTime
	 * @param page
	 */
	public void queryCouponPageList(Long storeId, String couponName, String beginTime, String endTime,
			MyPage<CouponBO> page) {
		page.setContent(couponDao.queryCouponPageList(storeId, couponName, beginTime, endTime, page));
	}

	public void queryCouponPageList(String couponName, String beginTime, String endTime, MyPage<CouponBO> page) {
		page.setContent(couponDao.queryCouponPageList(null, couponName, beginTime, endTime, page));
	}

	@Transactional(readOnly = false)
	public void sendCoipon(String type, String id, String users) throws IOException {
		sendCoipon(type, id, users, null, null);
	}

	@Transactional(readOnly = false)
	public void sendCoipon(String type, String id, String users, Long storeId, BigDecimal orderAmount)
			throws IOException {
		List<UserCustomerBO> userList = new ArrayList<UserCustomerBO>();
		// 所有会员
		if (type.equals("all_user")) {
			userList = userCustomerDao.queryUserCuxtomerList();
		}
		// 指定会员
		if (type.equals("the_user")) {
			List<String> list = CommUtil.str2list(users);
			for (String userName : list) {
				UserCustomerBO customer = userCustomerDao.queryUserCuxtomerByLoginName(userName);
				if (customer != null) {
					userList.add(customer);
				}
			}
		}

		if (storeId != null && type.equals("the_order")) {
			List<OrderFormBO> list = this.orderFormDao.selectSumPriceByStoreId(50, storeId);
			if (CollectionUtils.isNotEmpty(list)) {
				for (OrderFormBO orderForm : list) {
					if (orderForm.getAllOfPrice() > CommUtil.null2Double(orderAmount)) {
						UserCustomerBO customer = (UserCustomerBO) this.userCustomerDao.findById(orderForm
								.getUserId());
						userList.add(customer);
					}
				}
			}
		}

		CouponBO coupon = couponDao.queryCouponById(CommUtil.null2Long(id));
		if(null != coupon){
			Integer couponCount = coupon.getCouponInfoCount();
			for (int i = 0; i < userList.size(); i++) {
				if (couponCount < coupon.getCouponCount() || coupon.getCouponCount() == 0) {
					CouponInfo info = new CouponInfo();
					info.setAddTime(new Date());
					info.setCouponId(coupon.getId());
					info.setCouponSn(UUID.randomUUID().toString());
					info.setUserId(userList.get(i).getUid());
					couponInfoDao.save(info);
					couponCount ++;
					// update(coupon);
				} else
					break;
			}
		}
	}

	public void queryCouponInfos(String id, MyPage<CouponInfoBO> page) {
		if (StringUtils.isNotBlank(id)) {
			page.setContent(couponInfoDao.queryCouponInfoPageList(CommUtil.null2Long(id), page));
		}
	}

	public CouponBO queryCouponByAddTime() {

		List<CouponBO> list = couponDao.queryCouponByAddTimeDesc();
		if (list != null && list.size() > 0) {
			CouponBO bo = list.get(0);
			return bo;
		}
		return null;
	}

	public CouponBO queryNewYearById(Long newYearId) {
		return couponDao.queryNewYearById(newYearId);
	}

	// //////////////////////////////////////////////////
	private static String registerStartTime;
	private static String registerEndTime;
	private static String sendCouponName;

	public static String getRegisterStartTime() {
		return registerStartTime;
	}

	public static void setRegisterStartTime(String registerStartTime) {
		CouponService.registerStartTime = registerStartTime;
	}

	public static String getRegisterEndTime() {
		return registerEndTime;
	}

	public static void setRegisterEndTime(String registerEndTime) {
		CouponService.registerEndTime = registerEndTime;
	}

	public static String getSendCouponName() {
		return sendCouponName;
	}

	public static void setSendCouponName(String sendCouponName) {
		CouponService.sendCouponName = sendCouponName;
	}

	/***
	 * 注册赠送优惠券 sendCouponName 优惠券名称 registerStartTime 用户注册时间 registerEndTime 用户注册时间结束
	 */

	public void registerSendCoupon() {
		try {
			CouponBO couponBo = this.couponDao.getByName(sendCouponName);
			if (null != couponBo) {
				List<User> userList = this.userService.getByTimeAndCoupon(couponBo.getId().intValue(),
						registerStartTime, registerEndTime);

				for (User user : userList) {
					CouponInfo info = new CouponInfo();
					info.setAddTime(new Date());
					info.setCouponId(couponBo.getId());
					info.setCouponSn(UUID.randomUUID().toString());
					info.setUserId(user.getId());
					couponInfoDao.save(info);
				}
			}

		} catch (Exception e) {
			logger.info("注册赠送优惠卷]查询优惠卷出错");
			e.printStackTrace();
		}

	}
	/////////////////////////////////////////////////////
	public CouponBO getByCouponInfoId(Long infoId){
		return this.couponDao.getByCouponInfoId(infoId);
	}

}
