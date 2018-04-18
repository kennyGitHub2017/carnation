package com.sinco.carnation.rebate.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.order.service.ShopQrPayOrderService;
import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.RebateRecordBO;
import com.sinco.carnation.user.bo.UserRebateStatisBO;
import com.sinco.carnation.user.dao.UserRebateStatisDao;
import com.sinco.carnation.user.model.UserRebateStatis;
import com.sinco.carnation.user.service.StatisticsService;
import com.sinco.carnation.user.vo.UserRebateStatisVO;
import com.sinco.dal.utils.DateCalendar;
import com.sinco.dal.utils.DateUtils;
import com.sinco.biz.common.service.ServiceException;

@Service
@Transactional(readOnly = false, rollbackFor = ServiceException.class)
public class RebateStatisService {

	private static final Logger logger = LoggerFactory.getLogger(RebateStatisService.class);
	@Autowired
	private ShopQrPayOrderService shopQrPayOrderService;
	@Autowired
	private UserService userService;
	@Autowired
	private StatisticsService statisticsService;
	@Autowired
	private RebateRecordService rebateRecordService;
	@Autowired
	private UserRebateStatisDao userRebateStatisDao;
	@Autowired
	private UserDao userDao;

	/**
	 * 用户收益统计保存
	 * 
	 * @param uid
	 * @param UserRebateStatis
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean saveUserRebateStatis(Long uid, UserRebateStatis userRebateStatis) {
		User user = userDao.findById(uid);
		if (user == null) {
			logger.error("cant find this operator where uid = " + uid);
			return false;
		}
		userRebateStatis.setUid(uid);
		userRebateStatisDao.save(userRebateStatis);
		return true;
	}

	/**
	 * 用户收益统计列表
	 * 
	 * @return
	 */
	public List<UserRebateStatisBO> getUserRebateStatisList() {
		List<UserRebateStatisBO> list = userRebateStatisDao.findAll();
		if(list == null){
			return new ArrayList<UserRebateStatisBO>();
		}
		return list;
	}

	/**
	 * 用户收益统计
	 * 
	 * @return UserRebateStatisBO
	 */
	public List<UserRebateStatisBO> findUserRebateStatisByUidOrTime(Long uid, Date bgTime, Date edTime) {
		List<UserRebateStatisBO> list = userRebateStatisDao.findByUidAndTime(uid, bgTime, edTime);
		if (list == null) {
			return new ArrayList<UserRebateStatisBO>();
		}
		return list;
	}

	/**
	 * 条件查询
	 * 
	 * @param vo
	 * @return
	 */
	public UserRebateStatisBO getUserRebateStatisByTimeAndUid(UserRebateStatisVO vo) {
		if (vo == null) {
			return null;
		}
		return userRebateStatisDao.getUserRebateStatisByTimeAndUid(vo);
	}

	/**
	 * 根据id精确查询
	 * 
	 * @param vo
	 * @return
	 */
	public UserRebateStatisBO getUserRebateStatisById(Long id) {
		if (id == null) {
			return null;
		}
		return userRebateStatisDao.findOne(id);
	}

	/**
	 * 根据开始时间和结束时间统计数据
	 * 
	 * @param startTime
	 *            2010-01-01
	 * @param endTime
	 *            2010-01-01
	 */
	@SuppressWarnings("static-access")
	public void sratisticRebateByStartAndEndTime(String bg, String ed) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startTime = null;
		Date endTime = null;
		try {
			startTime = format.parse(bg);
			endTime = format.parse(ed);
		} catch (ParseException e) {
			logger.error("[sratisticRebateByStartAndEndTime] time wrong");
			e.printStackTrace();
		}
		startTime = DateCalendar.getStartTimeByThisTime(startTime);
		endTime = DateCalendar.getStartTimeByThisTime(endTime);
		// 结束时间不能大于开始时间
		if (startTime.compareTo(endTime) > 0) {
			logger.error("Start time is not greater than end time");
			return;
		}
		Date thisTime = new Date();
		thisTime = DateCalendar.getStartTimeByThisTime(thisTime);
		// 结束时间不能大于今天
		if (thisTime.compareTo(endTime) < 0) {
			logger.error("Can't statistical data in the future");
			return;
		}
		// 今天的数据只能明天统计
		String str1 = thisTime.toString();
		String str2 = endTime.toString();
		if (str1.equals(str2)) {
			logger.error("Today's data collection, please tomorrow statistics");
			return;
		}

		Calendar ca = Calendar.getInstance();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(endTime);
		calendar.add(calendar.DATE, 1);
		endTime = calendar.getTime();

		while (startTime.compareTo(endTime) < 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String str = sdf.format(startTime);
			System.out.println(str);
			logger.info(str + "[sratisticRebateByStartAndEndTime] begin");
			// 开始统计
			this.statisticRebateByTime(startTime);
			ca.setTime(startTime);
			ca.add(ca.DATE, 1);
			startTime = ca.getTime();
		}
	}

	/**
	 * @throws ServiceException
	 *             收益统计
	 * @param time
	 *            统计日期
	 * @param isToday
	 *            = true 统计昨天的数据
	 */
	@Transactional(readOnly = false)
	public void statisticRebateByTime(Date time) {
		Date todayStartTime = DateCalendar.getCurrentDayStartTime();
		Date startTime = todayStartTime;
		Date endTime = DateCalendar.getCurrentDayEndTime();
		if (time == null) {
			// 统计时间默认为昨日
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(startTime);
			gc.add(5, -1);
			startTime = gc.getTime();
			gc.setTime(endTime);
			gc.add(5, -1);
			endTime = gc.getTime();
		} else {
			startTime = DateCalendar.getStartTimeByThisTime(time);
			endTime = DateCalendar.getEndTimeByThisTime(time);
		}
		List<User> list = userService.findAll();
		for (User bo : list) {
			Long uid = bo.getId();
			List<UserRebateStatisBO> UserRebateStatisBOs = this.findUserRebateStatisByUidOrTime(uid,
					startTime, endTime);// 用户当日有统记过，不会再次统计
			List<RebateRecordBO> RebateRecordBOs = rebateRecordService.findAllByUidAndTime(uid, startTime,
					endTime);// 获取用户当日日收益
			if (UserRebateStatisBOs.size() > 0) {// 已统计
			} else if (RebateRecordBOs.size() < 1) {// 无收益记录，不统计
//				UserRebateStatis o2oUserRebateStatis = new UserRebateStatis();
//				UserRebateStatis b2cUserRebateStatis = new UserRebateStatis();
//				o2oUserRebateStatis.setStatisType("1");
//				b2cUserRebateStatis.setStatisType("2");
//				o2oUserRebateStatis.setCreateTime(endTime);
//				b2cUserRebateStatis.setCreateTime(endTime);
//				BigDecimal sellerQrPay = shopQrPayOrderService.findAllPaySuccessMoneyBySellerId(uid,
//						startTime, endTime);// 获取商户扫码金额
//				if (sellerQrPay == null) {
//					sellerQrPay = new BigDecimal(0);
//				}
//				o2oUserRebateStatis.setSellerQrPay(sellerQrPay);
//				this.saveUserRebateStatis(uid, o2oUserRebateStatis);
//				this.saveUserRebateStatis(uid, b2cUserRebateStatis);
			} else {// 有收益记录统计
				UserRebateStatis o2oUserRebateStatis = new UserRebateStatis();
				o2oUserRebateStatis.setStatisType("1");
				UserRebateStatis b2cUserRebateStatis = new UserRebateStatis();
				b2cUserRebateStatis.setStatisType("2");
				
				BigDecimal amount = BigDecimal.ZERO;
				for (RebateRecordBO rebateRecordBO : RebateRecordBOs) {
					
					if(rebateRecordBO.getRebateAmount().equals(0)){//不统计分润金额为0的记录
						break;
					}
					if (rebateRecordBO.getRebateType().equals(RebateConstants.REBATE_MEMBER)) {
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateMember(killNull(
									o2oUserRebateStatis.getRebateMember()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateMember(killNull(
									b2cUserRebateStatis.getRebateMember()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(RebateConstants.REBATE_MEMBER_FIRST)) {// 注册会员分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateMemberFirst(killNull(
									o2oUserRebateStatis.getRebateMemberFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateMemberFirst(killNull(
									b2cUserRebateStatis.getRebateMemberFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(RebateConstants.REBATE_MEMBER_SECOND)) {// 分享注册分润1
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateMemberSecond(killNull(
									o2oUserRebateStatis.getRebateMemberSecond()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateMemberSecond(killNull(
									b2cUserRebateStatis.getRebateMemberSecond()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(RebateConstants.REBATE_MEMBER_THIRD)) {// 分享注册分润2
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateMemberThird(killNull(
									o2oUserRebateStatis.getRebateMemberThird()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateMemberThird(killNull(
									b2cUserRebateStatis.getRebateMemberThird()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(RebateConstants.REBATE_BINDING_SELLER)) {// 商户注册分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateBindingSeller(killNull(
									o2oUserRebateStatis.getRebateBindingSeller()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateBindingSeller(killNull(
									b2cUserRebateStatis.getRebateBindingSeller()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_BINDING_SELLER_FIRST)) {// 签约商户管理分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateBindingSellerFirst(killNull(
									o2oUserRebateStatis.getRebateBindingSellerFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateBindingSellerFirst(killNull(
									b2cUserRebateStatis.getRebateBindingSellerFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_BINDING_SELLER_SECOND)) {// 推荐签约管理分润1
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateBindingSellerSecond(killNull(
									o2oUserRebateStatis.getRebateBindingSellerSecond()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateBindingSellerSecond(killNull(
									b2cUserRebateStatis.getRebateBindingSellerSecond()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_BINDING_SELLER_THIRD)) {// 推荐签约管理分润2
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateBindingSellerThird(killNull(
									o2oUserRebateStatis.getRebateBindingSellerThird()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateBindingSellerThird(killNull(
									b2cUserRebateStatis.getRebateBindingSellerThird()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(RebateConstants.REBATE_SPENDING_SELLER)) {
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateSpendingSeller(killNull(
									o2oUserRebateStatis.getRebateSpendingSeller()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateSpendingSeller(killNull(
									b2cUserRebateStatis.getRebateSpendingSeller()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_SPENDING_SELLER_SECOND)) {// 推荐签约管理分润1
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateSpendingSellerSecond(killNull(
									o2oUserRebateStatis.getRebateSpendingSellerSecond()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateSpendingSellerSecond(killNull(
									b2cUserRebateStatis.getRebateSpendingSellerSecond()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_SPENDING_SELLER_FIRST)) {// 签约商户服务分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateSpendingSellerFirst(killNull(
									o2oUserRebateStatis.getRebateSpendingSellerFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateSpendingSellerFirst(killNull(
									b2cUserRebateStatis.getRebateSpendingSellerFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_SPENDING_SELLER_THIRD)) {// // 推荐签约服务分润2
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateSpendingSellerThird(killNull(
									o2oUserRebateStatis.getRebateSpendingSellerThird()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateSpendingSellerThird(killNull(
									b2cUserRebateStatis.getRebateSpendingSellerThird()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_SPENDING_DISTRICT_OPERATOR)) {// 区级服务分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateSpendingDistrictOperator(killNull(
									o2oUserRebateStatis.getRebateSpendingDistrictOperator()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateSpendingDistrictOperator(killNull(
									b2cUserRebateStatis.getRebateSpendingDistrictOperator()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_SPENDING_DISTRICT_OPERATOR_FIRST)) {// 推荐辖区服务分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateSpendingDistrictOperatorFirst(killNull(
									o2oUserRebateStatis.getRebateSpendingDistrictOperatorFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateSpendingDistrictOperatorFirst(killNull(
									b2cUserRebateStatis.getRebateSpendingDistrictOperatorFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_SPENDING_CITY_OPERATOR)) {// 市级服务分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateSpendingCityOperator(killNull(
									o2oUserRebateStatis.getRebateSpendingCityOperator()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateSpendingCityOperator(killNull(
									b2cUserRebateStatis.getRebateSpendingCityOperator()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_SPENDING_CITY_OPERATOR_FIRST)) {// 推荐辖区服务分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateSpendingCityOperatorFirst(killNull(
									o2oUserRebateStatis.getRebateSpendingCityOperatorFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateSpendingCityOperatorFirst(killNull(
									b2cUserRebateStatis.getRebateSpendingCityOperatorFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_BINDING_DISTRICT_OPERATOR)) {// 区级管理分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateBindingDistrictOperator(killNull(
									o2oUserRebateStatis.getRebateBindingDistrictOperator()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateBindingDistrictOperator(killNull(
									b2cUserRebateStatis.getRebateBindingDistrictOperator()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_BINDING_DISTRICT_OPERATOR_FIRST)) {// 推荐辖区管理分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateBindingDistrictOperatorFirst(killNull(
									o2oUserRebateStatis.getRebateBindingDistrictOperatorFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateBindingDistrictOperatorFirst(killNull(
									b2cUserRebateStatis.getRebateBindingDistrictOperatorFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_BINDING_CITY_OPERATOR)) {// 市级管理分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateBindingCityOperator(killNull(
									o2oUserRebateStatis.getRebateBindingCityOperator()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateBindingCityOperator(killNull(
									b2cUserRebateStatis.getRebateBindingCityOperator()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_BINDING_CITY_OPERATOR_FIRST)) {// 推荐辖区管理分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateBindingCityOperatorFirst(killNull(
									o2oUserRebateStatis.getRebateBindingCityOperatorFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateBindingCityOperatorFirst(killNull(
									b2cUserRebateStatis.getRebateBindingCityOperatorFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(RebateConstants.REPEAT_REBATE)) {
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRepeatRebate(killNull(
									o2oUserRebateStatis.getRepeatRebate()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRepeatRebate(killNull(
									b2cUserRebateStatis.getRepeatRebate()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(RebateConstants.REBATE_SUPPLIER)) {
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateSupplier(killNull(
									o2oUserRebateStatis.getRebateSupplier()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateSupplier(killNull(
									b2cUserRebateStatis.getRebateSupplier()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(RebateConstants.REBATE_SUPPLIER_FIRST)) {// 上传产品分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateSupplierFirst(killNull(
									o2oUserRebateStatis.getRebateSupplierFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateSupplierFirst(killNull(
									b2cUserRebateStatis.getRebateSupplierFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(RebateConstants.REBATE_SUPPLIER_SECOND)) {// 推荐上传分润1
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateSupplierSecond(killNull(
									o2oUserRebateStatis.getRebateSupplierSecond()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateSupplierSecond(killNull(
									b2cUserRebateStatis.getRebateSupplierSecond()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(RebateConstants.REBATE_SUPPLIER_THIRD)) {// 推荐上传分润2
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateSupplierThird(killNull(
									o2oUserRebateStatis.getRebateSupplierThird()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateSupplierThird(killNull(
									b2cUserRebateStatis.getRebateSupplierThird()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_MEMBER_RECOMMEND_CNOPERATOR_FIRST)) {// 运营注册会员分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateMemberRecommendCnoperatorFirst(killNull(
									o2oUserRebateStatis.getRebateMemberRecommendCnoperatorFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateMemberRecommendCnoperatorFirst(killNull(
									b2cUserRebateStatis.getRebateMemberRecommendCnoperatorFirst()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_MEMBER_RECOMMEND_CNOPERATOR_SECOND)) {// // 推荐运营注册分润1
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateMemberRecommendCnoperatorSecond(killNull(
									o2oUserRebateStatis.getRebateMemberRecommendCnoperatorSecond()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateMemberRecommendCnoperatorSecond(killNull(
									b2cUserRebateStatis.getRebateMemberRecommendCnoperatorSecond()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(
							RebateConstants.REBATE_MEMBER_RECOMMEND_CNOPERATOR_THIRD)) {// 推荐运营注册分润2
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateMemberRecommendCnoperatorThird(killNull(
									o2oUserRebateStatis.getRebateMemberRecommendCnoperatorThird()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateMemberRecommendCnoperatorThird(killNull(
									b2cUserRebateStatis.getRebateMemberRecommendCnoperatorThird()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					} else if (rebateRecordBO.getRebateType().equals(RebateConstants.REBATE_YUN_GOU_BI)) {// 云购币专区订单分润
						if (rebateRecordBO.getRebateCode().substring(0, 4).equalsIgnoreCase("life")) {// code前4位是life,该分润是O2O线下分润
							o2oUserRebateStatis.setRebateYunGouBi(killNull(
									o2oUserRebateStatis.getRebateYunGouBi()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						} else {
							b2cUserRebateStatis.setRebateYunGouBi(killNull(
									b2cUserRebateStatis.getRebateYunGouBi()).add(
									killNull(rebateRecordBO.getRebateAmount())));
						}
						amount = amount.add(rebateRecordBO.getRebateAmount());
					}
				}
				BigDecimal sellerQrPay = shopQrPayOrderService.findAllPaySuccessMoneyBySellerId(uid,
						startTime, endTime);// 获取商户扫码金额
				if (sellerQrPay == null) {
					sellerQrPay = new BigDecimal(0);
				}
				o2oUserRebateStatis.setSellerQrPay(sellerQrPay); // 商户扫码金额
				o2oUserRebateStatis.setCreateTime(endTime);
				b2cUserRebateStatis.setCreateTime(endTime);
				if (UserRebateStatisBOs.size() > 0) {
					/*UserRebateStatisVO vo = new UserRebateStatisVO();
					vo.setUid(uid);
					vo.setStartTime(startTime);
					this.getUserRebateStatisByTimeAndUid(vo);
					//					o2oUserRebateStatis.setId(id);
					this.saveUserRebateStatis(uid, o2oUserRebateStatis);
					this.saveUserRebateStatis(uid, b2cUserRebateStatis);*/
				} else {
					this.saveUserRebateStatis(uid, o2oUserRebateStatis);
					this.saveUserRebateStatis(uid, b2cUserRebateStatis);
				}
			}
		}
	}

	/**
	 * 根据用户id 统计时间和类型获取统计数据
	 * 
	 * @param uid
	 * @param startTimeStr
	 *            开始时间
	 * @param endTimeStr
	 *            结束时间
	 * @param queryType
	 *            查询类型 0 根据传的时间查询 w.本周 m.本月 q.本季度 h.半年 y.今年 a.全部
	 * @param statisType
	 *            查询类型 0 o2o , 1 b2c
	 * @return
	 */
	public Map<String, Object> getUserRebateStatis(Long uid, String startTimeStr, String endTimeStr,
			String queryType, String statisType) {
		if (uid == null || queryType == null) {
			return null;
		}
		Date startTime = null;
		Date endTime = null;
		switch (queryType) {
			case "0":// 时间段
				if (StringUtils.isNotEmpty(startTimeStr)) {
					startTime = DateUtils.parseDate(startTimeStr);
				}
				if (StringUtils.isNotEmpty(endTimeStr)) {
					endTime = DateUtils.parseDate(endTimeStr);
				}
				break;
			case "w":// 周
				startTime = DateCalendar.getCurrentWeekDayStartTime();
				endTime = DateCalendar.getCurrentWeekDayEndTime();
				break;
			case "m":// 月
				startTime = DateCalendar.getCurrentMonthStartTime();
				endTime = DateCalendar.getCurrentMonthEndTime();
				break;
			case "q":// 本季度
				startTime = DateCalendar.getCurrentQuarterStartTime();
				endTime = DateCalendar.getCurrentQuarterEndTime();
				break;
			case "h":// 半年
				startTime = DateCalendar.getHalfYearStartTime();
				endTime = DateCalendar.getHalfYearEndTime();
				break;
			case "y":// 年
				startTime = DateCalendar.getCurrentYearStartTime();
				endTime = DateCalendar.getCurrentYearEndTime();
				break;
			case "a":// 查询全部
				startTime = null;
				endTime = null;
				break;
		}
		String type = "1";
		if (statisType.equals("1")) {// 参数传入类型 0.o2o 1.b2c 返润统计类型 1.o2o,2.b2c
			type = "2";
		}
		Map<String, Object> resultMap = new HashMap<>();
		UserRebateStatisVO vo = new UserRebateStatisVO();
		vo.setUid(uid);
		vo.setStartTime(startTime);
		vo.setEndTime(endTime);
		vo.setStatisType(type);
		UserRebateStatisBO resultBO = this.getUserRebateStatisByTimeAndUid(vo);
		// 市/区级辖区管理分润
		BigDecimal o2OjmAmount = null;
		// 市/区级辖区服务分润
		BigDecimal o2OjgAmount = null;
		// 推荐辖区管理分润
		BigDecimal o2OjrmAmount = null;
		// 推荐辖区服务分润
		BigDecimal o2OjrgAmount = null;
		// 签约商户管理分润
		BigDecimal o2OsgmAmount = null;
		// 签约商户服务分润
		BigDecimal o2OsggAmount = null;
		// 推荐签约管理分润
		BigDecimal o2OrsmAmount = null;
		// 推荐签约服务分润
		BigDecimal o2OrsgAmount = null;
		// 注册会员分润
		BigDecimal o2OrmAmount = null;
		// 分享注册分润
		BigDecimal o2OrsAmount = null;
		// 运营注册会员分润
		BigDecimal o2OormAmount = null;
		// 推荐运营注册分润
		BigDecimal o2OrormAmount = null;
		// 辖区内会员商城购物分润
		BigDecimal b2CAmountSum = null;
		// 上传产品分润
		BigDecimal b2CupAmount = null;
		// 推荐上传分润
		BigDecimal b2CrupAmount = null;
		// 推荐辖区分润
		BigDecimal b2CrjAmount = null;
		// 商户注册分润
		BigDecimal b2CgrAmount = null;
		// 签约商户分润
		BigDecimal b2CsgAmount = null;
		// 推荐签约分润
		BigDecimal b2crsCAmount = null;
		// B2C注册会员分润
		BigDecimal b2CrmAmount = null;
		// B2C分享注册分润
		BigDecimal b2CrsAmount = null;
		// 运营注册会员分润
		BigDecimal b2CormAmount = null;
		// 推荐运营注册分润
		BigDecimal b2CrormAmount = null;

		BigDecimal sum = null;

		if (resultBO != null) {
			if (type.equals("1")) {
				// 市/区级辖区管理分润 会员绑定市/区运营商订单分润 ---管理：会员绑定商户隶属运营商 辖区：消费地运营商获益
				o2OjmAmount = resultBO.getRebateBindingDistrictOperator().add(
						resultBO.getRebateBindingCityOperator());
				// 市/区级辖区服务分润 会员消费市/区级运营商订单分润
				o2OjgAmount = resultBO.getRebateSpendingDistrictOperator().add(
						resultBO.getRebateSpendingCityOperator());
				// 推荐辖区管理分润 会员绑定市运营商1层关系订单分润+会员绑定区域运营商1层关系订单分润
				o2OjrmAmount = resultBO.getRebateBindingDistrictOperatorFirst().add(
						resultBO.getRebateBindingCityOperatorFirst());
				// 推荐辖区服务分润 会员消费市级运营商1层关系订单分润+会员消费区域运营商1层关系订单分润
				o2OjrgAmount = resultBO.getRebateSpendingDistrictOperatorFirst().add(
						resultBO.getRebateSpendingCityOperatorFirst());
				// 签约商户管理分润 签约商户管理分润
				o2OsgmAmount = resultBO.getRebateBindingSellerFirst();
				// 签约商户服务分润 签约商户服务分润
				o2OsggAmount = resultBO.getRebateSpendingSellerFirst();
				// 推荐签约管理分润 推荐签约管理分润1+推荐签约管理分润2
				o2OrsmAmount = resultBO.getRebateBindingSellerSecond().add(
						resultBO.getRebateBindingSellerThird());
				// 推荐签约服务分润 推荐签约服务分润1+推荐签约服务分润2
				o2OrsgAmount = resultBO.getRebateSpendingSellerSecond().add(
						resultBO.getRebateSpendingSellerThird());
				// 注册会员分润 注册会员分润
				o2OrmAmount = resultBO.getRebateMemberFirst();
				// 分享注册分润 分享注册分润1+分享注册分润2
				o2OrsAmount = resultBO.getRebateMemberSecond().add(resultBO.getRebateMemberThird());
				// 运营注册会员分润 运营注册会员分润
				o2OormAmount = resultBO.getRebateMemberRecommendCnoperatorFirst();
				// 推荐运营注册分润 推荐运营注册分润1+推荐运营注册分润2
				o2OrormAmount = resultBO.getRebateMemberRecommendCnoperatorSecond().add(
						resultBO.getRebateMemberRecommendCnoperatorThird());

				sum = o2OjmAmount.add(o2OjgAmount).add(o2OjrmAmount).add(o2OjrgAmount).add(o2OsgmAmount)
						.add(o2OsggAmount).add(o2OrsmAmount).add(o2OrsgAmount).add(o2OrmAmount)
						.add(o2OrsAmount).add(o2OormAmount).add(o2OrormAmount);
			} else {
				// 辖区内会员商城购物分润 会员绑定区域运营商订单分润
				b2CAmountSum = resultBO.getRebateBindingDistrictOperator();
				// 上传产品分润 上传产品分润
				b2CupAmount = resultBO.getRebateSupplierFirst();
				// 推荐上传分润 推荐上传分润1+推荐上传分润2
				b2CrupAmount = resultBO.getRebateSupplierSecond().add(resultBO.getRebateSupplierThird());
				// 推荐辖区分润 会员绑定市运营商1层关系订单分润+会员绑定区域运营商1层关系订单分润
				b2CrjAmount = resultBO.getRebateBindingDistrictOperatorFirst().add(
						resultBO.getRebateBindingCityOperatorFirst());
				// 商户注册分润 商户注册分润
				b2CgrAmount = resultBO.getRebateBindingSeller();
				// 签约商户分润 签约商户管理分润
				b2CsgAmount = resultBO.getRebateBindingSellerFirst();
				// 推荐签约分润 推荐签约管理分润1+推荐签约管理分润2
				b2crsCAmount = resultBO.getRebateBindingSellerSecond().add(
						resultBO.getRebateBindingSellerThird());
				// B2C注册会员分润 注册会员分润
				b2CrmAmount = resultBO.getRebateMemberFirst();
				// B2C分享注册分润 分享注册分润1+分享注册分润2
				b2CrsAmount = resultBO.getRebateMemberSecond().add(resultBO.getRebateMemberThird());
				// 运营注册会员分润 运营注册会员分润
				b2CormAmount = resultBO.getRebateMemberRecommendCnoperatorFirst();
				// 推荐运营注册分润 推荐运营注册分润1+推荐运营注册分润2
				b2CrormAmount = resultBO.getRebateMemberRecommendCnoperatorSecond().add(
						resultBO.getRebateMemberRecommendCnoperatorThird());

				sum = b2CAmountSum.add(b2CupAmount).add(b2CrupAmount).add(b2CrjAmount).add(b2CgrAmount)
						.add(b2CsgAmount).add(b2crsCAmount).add(b2CrmAmount).add(b2CrsAmount)
						.add(b2CormAmount).add(b2CrormAmount);
			}
		}
		// 市/区级辖区管理分润
		resultMap.put("o2OjmAmount", o2OjmAmount == null ? 0.00 : o2OjmAmount);
		// 市/区级辖区服务分润
		resultMap.put("o2OjgAmount", o2OjgAmount == null ? 0.00 : o2OjgAmount);
		// 推荐辖区管理分润
		resultMap.put("o2OjrmAmount", o2OjrmAmount == null ? 0.00 : o2OjrmAmount);
		// 推荐辖区服务分润
		resultMap.put("o2OjrgAmount", o2OjrgAmount == null ? 0.00 : o2OjrgAmount);
		// 签约商户管理分润
		resultMap.put("o2OsgmAmount", o2OsgmAmount == null ? 0.00 : o2OsgmAmount);
		// 签约商户服务分润
		resultMap.put("o2OsggAmount", o2OsggAmount == null ? 0.00 : o2OsggAmount);
		// 推荐签约管理分润
		resultMap.put("o2OrsmAmount", o2OrsmAmount == null ? 0.00 : o2OrsmAmount);
		// 推荐签约服务分润
		resultMap.put("o2OrsgAmount", o2OrsgAmount == null ? 0.00 : o2OrsgAmount);
		// 注册会员分润
		resultMap.put("o2OrmAmount", o2OrmAmount == null ? 0.00 : o2OrmAmount);
		// 分享注册分润
		resultMap.put("o2OrsAmount", o2OrsAmount == null ? 0.00 : o2OrsAmount);
		// 运营注册会员分润
		resultMap.put("o2OormAmount", o2OormAmount == null ? 0.00 : o2OormAmount);
		// 推荐运营注册分润
		resultMap.put("o2OrormAmount", o2OrormAmount == null ? 0.00 : o2OrormAmount);
		// 辖区内会员商城购物分润
		resultMap.put("b2CAmountSum", b2CAmountSum == null ? 0.00 : b2CAmountSum);
		// 上传产品分润
		resultMap.put("b2CupAmount", b2CupAmount == null ? 0.00 : b2CupAmount);
		// 推荐上传分润
		resultMap.put("b2CrupAmount", b2CrupAmount == null ? 0.00 : b2CrupAmount);
		// 推荐辖区分润
		resultMap.put("b2CrjAmount", b2CrjAmount == null ? 0.00 : b2CrjAmount);
		// 商户注册分润
		resultMap.put("b2CgrAmount", b2CgrAmount == null ? 0.00 : b2CgrAmount);
		// 签约商户分润
		resultMap.put("b2CsgAmount", b2CsgAmount == null ? 0.00 : b2CsgAmount);
		// 推荐签约分润
		resultMap.put("b2crsCAmount", b2crsCAmount == null ? 0.00 : b2crsCAmount);
		// B2C注册会员分润
		resultMap.put("b2CrmAmount", b2CrmAmount == null ? 0.00 : b2CrmAmount);
		// B2C分享注册分润
		resultMap.put("b2CrsAmount", b2CrsAmount == null ? 0.00 : b2CrsAmount);
		// 运营注册会员分润
		resultMap.put("b2CormAmount", b2CormAmount == null ? 0.00 : b2CormAmount);
		// 推荐运营注册分润
		resultMap.put("b2CrormAmount", b2CrormAmount == null ? 0.00 : b2CrormAmount);
		// sum
		resultMap.put("sum", sum == null ? 0.00 : sum);
		return resultMap;
	}

	private static BigDecimal killNull(BigDecimal value) {
		if (value == null) {
			value = new BigDecimal(0);
		}
		return value;
	}
}
