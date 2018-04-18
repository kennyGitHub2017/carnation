package com.sinco.carnation.user.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.o2o.dao.GroupOrderDao;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.orcl.CnMoneyBO;
import com.sinco.carnation.sys.bo.orcl.CnUserMoneyBO;
import com.sinco.carnation.sys.bo.orcl.IntegralSwapBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.UserMoneyBO;
import com.sinco.carnation.user.dao.OperatorDao;
import com.sinco.carnation.user.dao.RebateRecordDao;
import com.sinco.carnation.user.dao.SellerDao;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.dao.UserRebateStatisDao;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.carnation.user.vo.RebateRecordVO;
import com.sinco.carnation.user.vo.SellerVO;
import com.sinco.carnation.user.vo.UserCustomerVO;
import com.sinco.dal.utils.DateCalendar;
import com.sinco.dal.utils.DateUtils;

@Service
public class StatisticsService {

	private static final Logger logger = LoggerFactory.getLogger(StatisticsService.class);

	@Autowired
	private SellerDao sellerDao;
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private UserCustomerDao customerDao;
	@Autowired
	private OperatorDao operatorDao;
	@Autowired
	private RebateRecordDao rebateRecordDao;
	@Autowired
	private GroupOrderDao groupOrderDao;
	@Autowired
	private UserRebateStatisDao userRebateStatisDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRelationService userRelationService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private RedisCacheService redisCacheService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private UserMoneyService moneyService;
	@Autowired
	private CnPayBaseService cnPayBaseService;
	@Autowired
	private OrclUserBaseService orclUserBaseService;

	public Map<String, Object> getAdminStatistics(String areaId) {
		Map<String, Object> resultMap = new HashMap<>();
		BigDecimal resumeSum = rebateRecordDao.selectRebateSumByArea(areaId, "1");
		BigDecimal rechangeSum = rebateRecordDao.selectRebateSumByArea(areaId, "2");
		int operatorCount = operatorDao.selectOperatorCountByArea(areaId);
		int storeCount = storeDao.selectStoreByArea(areaId);
		int customerCount = customerDao.selectCustomerCountByArea(areaId);
		int orderCount = groupOrderDao.selectGroupOrderCountByArea(areaId);
		resultMap.put("resumeSum", resumeSum != null ? resumeSum : 0);
		resultMap.put("rechangeSum", rechangeSum != null ? rechangeSum : 0);
		resultMap.put("operatorCount", operatorCount);
		resultMap.put("storeCount", storeCount);
		resultMap.put("customerCount", customerCount);
		resultMap.put("orderCount", orderCount);
		return resultMap;
	}

	/**
	 * 运营商关系统计
	 * 
	 * @param operator
	 * @param type
	 *            0 /NULL 所有 , 1本日
	 * @return
	 */
	public Map<String, Object> getOperatorRelationStatistics(OperatorBO operator, String type) {
		Map<String, Object> resultMap = new HashMap<>();
		Date time = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startTime = null;
		Date endTime = null;
		String start = null;
		String end = null;
		OperatorVO operatorVO = new OperatorVO();
		operatorVO.setUserId(operator.getUserId());
		operatorVO.setUserLevel(operator.getLevel());
		operatorVO.setOperatorAreaId(operator.getOperatorAreaId());
		operatorVO.setId(operator.getId());

		SellerVO sellerVO = new SellerVO();
		sellerVO.setOperatorUserId(operator.getUserId());
		sellerVO.setOperatorId(operator.getId());
		sellerVO.setUserLevel(operator.getLevel());
		sellerVO.setOperatorAreaId(operator.getOperatorAreaId());

		UserCustomerVO customerVO = new UserCustomerVO();
		customerVO.setOperatorUserId(operator.getUserId());
		customerVO.setOperatorId(operator.getId());
		customerVO.setUserLevel(operator.getLevel());
		customerVO.setOperatorAreaId(operator.getOperatorAreaId());
		if (type != null && type.equals("1")) {// 查询当日时设置查询时间段
			startTime = DateCalendar.getStartTimeByThisTime(time);
			endTime = DateCalendar.getEndTimeByThisTime(time);

			start = sdf.format(startTime);
			end = sdf.format(endTime);
			operatorVO.setStartDate(start);
			operatorVO.setEndDate(end);
			sellerVO.setStartTime(start);
			sellerVO.setEndTime(end);
			customerVO.setBeginTime(start);
			customerVO.setEndTime(end);
		}
		int roCount = 0;// 注册运营商
		int ownOperatorCount = 0;// 辖区运营商
		int rsCount = 0;// 运营商注册商户 数量
		int rgsCount = 0;// 运营商注册商家(供应商)数量
		int sruCount = 0;// 运营商隶属商户注册会员数
		int cnRegistCount = 0;// 团队注册会员
		int cnRegistShopRegistCount = 0;// 团队签约商户注册会员
		int ownSellerCount = 0;// 隶属商户
		int areaSellerCount = 0;// 辖区商户
		int registerCustomerCount = 0;// 小伙伴数量
		int ownCustomerCount = 0;// 隶属商户的会员
		int areaCustomerCount = 0;
		// 获取注册和辖区运营商数量

		roCount = operatorDao.selectRegisterOperatorCount(operatorVO);
		resultMap.put("roCount", roCount);
		ownOperatorCount = operatorDao.selectOwnOperatorCount(operatorVO);
		resultMap.put("ooCount", ownOperatorCount);
		// 获取 运营商注册商户 数量、运营商注册商家(供应商)数量、运营商隶属商户注册会员数
		sellerVO.setIsOwn("1");// 隶属
		rsCount = sellerDao.selectOperatorRegisterSellerCount(sellerVO);
		rgsCount = sellerDao.selectOperatorRegisterGoodsSellerCount(sellerVO);
		sruCount = sellerDao.selectSellerRegisterUserCount(operator.getUserId(), start, end);
		// 获取隶属商户 辖区商户数量
		ownSellerCount = sellerDao.selectOperatorSellerCount(sellerVO);
		sellerVO.setIsOwn("0");// 辖区
		areaSellerCount = sellerDao.selectOperatorSellerCount(sellerVO);
		
		// 获取小伙伴、隶属商户的会员、?的数量 所有/本日
		if(StringUtils.isBlank(type) || type.equals("0")){
			registerCustomerCount = userRelationService.getAllCountByUid(operator.getUserId());//小伙伴
		}else{
			registerCustomerCount = this.getAbcPartnerCount(operator.getUserId(), start, end);
		}

		// 获取 团队注册会员 团队签约商户注册会员
		if (operator.getCn_username() != null) {
			cnRegistCount = userRelationService.getCnRegistUserCount(operator.getCn_username(), start, end);
			cnRegistShopRegistCount = userRelationService.getCnRegistShopRegistUserCount(
					operator.getCn_username(), start, end);
			cnRegistCount = cnRegistCount + registerCustomerCount;
//			cnRegistCount=10;
//			cnRegistShopRegistCount=10;
		}
		customerVO.setIsOwn("1");// 隶属
		ownCustomerCount = customerDao.selectOwnCustomerCount(customerVO);
		customerVO.setIsOwn("0");// 辖区
		areaCustomerCount = customerDao.selectOwnCustomerCount(customerVO);
		resultMap.put("rsCount", rsCount);
		resultMap.put("rgsCount", rgsCount);
		resultMap.put("sruCount", sruCount);
		resultMap.put("cnRegistCount", cnRegistCount);
		resultMap.put("cnRegistShopRegistCount", cnRegistShopRegistCount);
		resultMap.put("osCount", ownSellerCount);
		resultMap.put("asCount", areaSellerCount);
		resultMap.put("rcCount", registerCustomerCount);
		resultMap.put("ocCount", ownCustomerCount);
		resultMap.put("acCount", areaCustomerCount);
		return resultMap;
	}

	/**
	 * 
	 * @Title: getOperatorRebateStatistics
	 * @Description: TODO(根据用户id查询该用户商城返润)
	 * @param @param userId
	 * @param @return 设定文件
	 * @return Map<String,Object> 返回类型
	 * @author Tang
	 * @throws
	 */
	public Map<String, Object> getShopRebateStatistics(Long userId, Date begin, Date end) {
		Map<String, Object> resultMap = new HashMap<>();
		// 推荐购买分润
		BigDecimal recommendCustomer = rebateRecordDao.selectSumByTypeAndUserId(userId,
				new String[] {RebateConstants.REBATE_TYPE_301}, begin, end);
		// 推荐产品分润
		BigDecimal recommendSeller = rebateRecordDao.selectSumByTypeAndUserId(userId,
				new String[] {RebateConstants.REBATE_TYPE_302}, begin, end);
		resultMap.put("rcRebate", recommendCustomer == null ? 0 : recommendCustomer);
		resultMap.put("rsRebate", recommendSeller == null ? 0 : recommendSeller);
		return resultMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getOperatorRebateStatistics(OperatorBO operator, String startTimeStr,
			String endTimeStr, String queryType) {
		Date startTime = null;
		Date endTime = null;
		switch (queryType) {
			case "0":
				if (StringUtils.isNotEmpty(startTimeStr)) {
					startTime = DateUtils.parseDate(startTimeStr);
				}
				if (StringUtils.isNotEmpty(endTimeStr)) {
					endTime = DateUtils.parseDate(endTimeStr);
				}
				break;
			case "w":
				startTime = DateCalendar.getCurrentWeekDayStartTime();
				endTime = DateCalendar.getCurrentWeekDayEndTime();
				break;
			case "m":
				startTime = DateCalendar.getCurrentMonthStartTime();
				endTime = DateCalendar.getCurrentMonthEndTime();
				break;
			case "q":
				startTime = DateCalendar.getCurrentQuarterStartTime();
				endTime = DateCalendar.getCurrentQuarterEndTime();
				break;
			case "h":
				startTime = DateCalendar.getHalfYearStartTime();
				endTime = DateCalendar.getHalfYearEndTime();
				break;
			case "y":
				startTime = DateCalendar.getCurrentYearStartTime();
				endTime = DateCalendar.getCurrentYearEndTime();
				break;
		}

		Map<String, Object> resultMap = new HashMap<>();
		/*
		 * 注册返润收益
		 */
		// 推荐运营商
		BigDecimal registerOperator = rebateRecordDao.selectSumByTypeAndUserId(operator.getUserId(),
				new String[] {RebateConstants.REBATE_TYPE_106}, startTime, endTime);
		// 推荐商户
		BigDecimal registerSeller = rebateRecordDao.selectSumByTypeAndUserId(operator.getUserId(),
				new String[] {RebateConstants.REBATE_TYPE_104, RebateConstants.REBATE_TYPE_109}, startTime,
				endTime);
		// 推荐会员
		BigDecimal registerCustomer = rebateRecordDao.selectSumByTypeAndUserId(operator.getUserId(),
				new String[] {RebateConstants.REBATE_TYPE_102}, startTime, endTime);
		resultMap.put("roAmount", registerOperator == null ? 0 : registerOperator);
		resultMap.put("rsAmount", registerSeller == null ? 0 : registerSeller);
		resultMap.put("rcAmount", registerCustomer == null ? 0 : registerCustomer);

		// 推荐购买分润
		BigDecimal recommendCustomer = rebateRecordDao.selectSumByTypeAndUserId(operator.getUserId(),
				new String[] {RebateConstants.REBATE_TYPE_301}, startTime, endTime);
		// 推荐产品分润
		BigDecimal recommendSeller = rebateRecordDao.selectSumByTypeAndUserId(operator.getUserId(),
				new String[] {RebateConstants.REBATE_TYPE_302}, startTime, endTime);
		resultMap.put("rcRebate", recommendCustomer == null ? 0 : recommendCustomer);
		resultMap.put("rsRebate", recommendSeller == null ? 0 : recommendSeller);
		/*
		 * 返润收益
		 */
		RebateRecordVO recordVO = new RebateRecordVO();
		recordVO.setOperatorId(operator.getId());
		recordVO.setUserId(operator.getUserId());
		recordVO.setOperatorAreaId(operator.getOperatorAreaId());
		recordVO.setUserLevel(operator.getLevel());
		recordVO.setStartTime(startTime);
		recordVO.setEndTime(endTime);
		String[] typeyArr = null;

		recordVO.setType("1");
		typeyArr = new String[] {RebateConstants.REBATE_TYPE_108, RebateConstants.REBATE_TYPE_107,
				RebateConstants.REBATE_TYPE_105};
		recordVO.setTypeList(CollectionUtils.arrayToList(typeyArr));
		BigDecimal areaSelfSelf = rebateRecordDao.selectSumAreaByVO(recordVO);
		BigDecimal ownSelfSelf = rebateRecordDao.selectSumOwnByVO(recordVO);

		recordVO.setType("2");
		BigDecimal areaSelfOut = rebateRecordDao.selectSumAreaByVO(recordVO);
		BigDecimal ownSelfOut = rebateRecordDao.selectSumOwnByVO(recordVO);

		recordVO.setType("3");
		typeyArr = new String[] {RebateConstants.REBATE_TYPE_110, RebateConstants.REBATE_TYPE_111,
				RebateConstants.REBATE_TYPE_112};
		recordVO.setTypeList(CollectionUtils.arrayToList(typeyArr));
		BigDecimal areaOutSelf = rebateRecordDao.selectSumAreaByVO(recordVO);
		BigDecimal ownOutSelf = rebateRecordDao.selectSumOwnByVO(recordVO);
		resultMap.put("assAmount", areaSelfSelf == null ? 0 : areaSelfSelf);
		resultMap.put("asoAmount", areaSelfOut == null ? 0 : areaSelfOut);
		resultMap.put("aosAmount", areaOutSelf == null ? 0 : areaOutSelf);
		resultMap.put("ossAmount", ownSelfSelf == null ? 0 : ownSelfSelf);
		resultMap.put("osoAmount", ownSelfOut == null ? 0 : ownSelfOut);
		resultMap.put("oosAmount", ownOutSelf == null ? 0 : ownOutSelf);

		recordVO = new RebateRecordVO();
		/*
		 * 支付手续收益
		 */
		BigDecimal ownPay = rebateRecordDao.selectSumRechargeByUserId(operator.getUserId(), operator.getId(),
				1, startTime, endTime);
		BigDecimal areaPay = rebateRecordDao.selectSumRechargeByUserId(operator.getUserId(),
				operator.getId(), 2, startTime, endTime);
		BigDecimal registerPay = rebateRecordDao.selectSumByTypeAndUserId(operator.getUserId(),
				new String[] {RebateConstants.REBATE_TYPE_204}, startTime, endTime);
		resultMap.put("opAmount", ownPay == null ? 0 : ownPay);
		resultMap.put("apAmount", areaPay == null ? 0 : areaPay);
		resultMap.put("rpAmount", registerPay == null ? 0 : registerPay);

		BigDecimal totleAmount = rebateRecordDao.selectSumByTypeAndUserId(operator.getUserId(), null,
				startTime, endTime);
		resultMap.put("totleAmount", totleAmount == null ? 0 : totleAmount);
		// O2O

		// B2C

		return resultMap;
	}

	/**
	 * 通过uid获取小伙伴数量(三级邀请关系)
	 * 
	 * @param uid
	 * @return
	 */
	public int getAbcPartnerCount(Long uid) {
		int abcPartnerCount = 0;
		// 实时查询写到缓存，1小时更新一次
		String levelCount = this.redisCacheService.getUserLevelCount(uid);
		if (levelCount == null) {
			int one = this.userCustomerService.queryUserByRelation1Count(uid, null, null);
			int two = this.userCustomerService.queryUserByRelation2Count(uid, null, null);
			int three = this.userCustomerService.queryUserByRelation3Count(uid, null, null);
			int resultUserLevelCount = one + two + three;
			if (resultUserLevelCount > 0) {
				// 缓存有效期
				int miao = 3600;// com.sinco.carnation.resource.web.util.DateUtils.getMiao(); //当前时间距离24时还有多少秒
				logger.info("......... cache seconds = " + miao + " hours:" + (miao / 60 / 60));
				// 缓存统计数据
				this.redisCacheService.setUserLevelCount(uid, String.valueOf(resultUserLevelCount), miao);
				abcPartnerCount = resultUserLevelCount;
			}
		} else {
			abcPartnerCount = Integer.valueOf(levelCount);
		}
		return abcPartnerCount;
	}

	/**
	 * 通过uid获取小伙伴数量(三级邀请关系) 时间段
	 * 
	 * @param uid
	 * @return
	 */
	public int getAbcPartnerCount(Long uid, String startTime, String endTime) {
		int one = this.userCustomerService.queryUserByRelation1Count(uid, startTime, endTime);
		int two = this.userCustomerService.queryUserByRelation2Count(uid, startTime, endTime);
		int three = this.userCustomerService.queryUserByRelation3Count(uid, startTime, endTime);
		int resultUserLevelCount = one + two + three;
		return resultUserLevelCount;
	}

	/**
	 * 通过uid获取用户钱包(云豆奖金云购币预分润云豆是否设置密码)
	 * 
	 * @param uid
	 * @return boolean pwdNotNull 是否设置云豆密码; double cnBonus;//奖金 double cnRepeat;//冲销币 double availableBalance;
	 *         //云豆 double recordBalance;//预分润云豆
	 */
	public Map<String, Object> getUserMoney(Long uid) {
		// 云豆 奖金 云购币 BEGIN
		// 查询云豆支付密码
		UserMoneyBO userMoney = moneyService.findUserMoneyByUid(uid);
		boolean bl = false;
		boolean pwdNotNull = false;
		double cnBonus = 0;// 奖金
		double cnRepeat = 0;// 重消
		double availableBalance = 0; // 云豆
		double recordBalance = 0;// 预分润云豆
//		double ShoppingPoints = 0 ;	//购物积分

		if (StringUtils.isNotBlank(userMoney.getPassword())) {
			pwdNotNull = true;
		}
		if (null != userMoney.getAvailableBalance()) {
			availableBalance = userMoney.getAvailableBalance().doubleValue();
		}

		if (null != userMoney.getRecordBalance()) {
			recordBalance = userMoney.getRecordBalance().doubleValue();
		}
		List<UserAccountBO> userAccount = this.userAccountService.findUserAccountByUid(uid);
		for (UserAccountBO account : userAccount) {// 判断账号是否是CN账号
			if (UserContant.ACCOUNT_TYPE_8.equals(account.getAccountType())) {
				pwdNotNull = true;
				bl = true;
				break;
			}
		}
		if (bl) {// CN账号查询奖金重消
			UserAccount resAccount = this.userAccountService.findByUid(uid, UserContant.ACCOUNT_TYPE_8);
			CnUserMoneyBO cnUserMoneyBO = this.cnPayBaseService
					.getCnUserBounsMoney(resAccount.getLoginName());// 奖金
			if (cnUserMoneyBO != null) {
				if (null != cnUserMoneyBO.getISPAY() && 1 == cnUserMoneyBO.getISPAY().intValue()) {
					if (null != cnUserMoneyBO.getBONUS()) {
						cnBonus = cnUserMoneyBO.getBONUS();
					}
				}
			}
			CnUserMoneyBO cnUserMoneyBO1 = this.cnPayBaseService.getCnUserRepeatMoney(resAccount
					.getLoginName());// 重消
			if (cnUserMoneyBO1 != null) {
				if (null != cnUserMoneyBO1.getISPAY() && 1 == cnUserMoneyBO1.getISPAY().intValue()
						&& null != cnUserMoneyBO1.getBONUS_REPEAT()) {
					// response.setcNRepeat(cnUserMoneyBO1.getBONUS_REPEAT());
					cnRepeat = cnUserMoneyBO1.getBONUS_REPEAT();
				}
			}
			// 购物积分
//			ShoppingPoints = ?
		}
		if (cnRepeat < 0)
			cnRepeat = 0;
		if (cnBonus < 0)
			cnBonus = 0;
		if (recordBalance < 0)
			recordBalance = 0;
		if (availableBalance < 0)
			availableBalance = 0;

		DecimalFormat df = new DecimalFormat("######0.00");

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("cnRepeat", Double.valueOf(df.format(cnRepeat)));
		resultMap.put("cnBonus", Double.valueOf(df.format(cnBonus)));
		resultMap.put("recordBalance", Double.valueOf(df.format(recordBalance)));
		resultMap.put("availableBalance", Double.valueOf(df.format(availableBalance)));
		resultMap.put("pwdNotNull", pwdNotNull);
		return resultMap;
	}

	/**
	 * 通过uid获取用户钱包(云豆奖金云购币预分润云豆是否设置密码)
	 * 
	 * @param uid
	 * @param uid
	 *            userCode resource 会员端、 merchant 商户端、supplier 供应商端 、CN CN账户、YY YY账户
	 * @return boolean pwdNotNull 是否设置云豆密码; double cnBonus;//奖金 double cnRepeat;//冲销币 double
	 *         availableBalance;//云豆 double recordBalance;//预分润云豆
	 */
	@SuppressWarnings("null")
	public Map<String, Object> getUserMoneyV2(Long uid, String source) {
		// 云豆 奖金 云购币 BEGIN
		// 查询云豆支付密码
		UserMoneyBO userMoney = moneyService.findUserMoneyByUid(uid);
		boolean bl = false;
		boolean pwdNotNull = false;
		double cnBonus = 0;// 奖金
		double cnRepeat = 0;// 冲销币
		double availableBalance = 0; // 云豆
		double recordBalance = 0;// 预分润云豆
		double cnIntegral = 0;//购物积分
		if (StringUtils.isBlank(source)) {
			source = UserContant.ACCOUNT_TYPE_RESOURCE;
		}
		if (userMoney != null) {
			switch (source) {// 不同角色返回的云豆和云豆密码不同
				case UserContant.ACCOUNT_TYPE_SUPPLIER:// 供应商
					if (StringUtils.isNotBlank(userMoney.getB2cPassword())) {
						pwdNotNull = true;
					}
					if (null != userMoney.getB2cBalance()) {
						availableBalance = userMoney.getB2cBalance().doubleValue();
					}
					break;
				case UserContant.ACCOUNT_TYPE_MERCHANT:// 商户
					if (StringUtils.isNotBlank(userMoney.getO2oPassword())) {
						pwdNotNull = true;
					}
					if (null != userMoney.getO2oBalance()) {
						availableBalance = userMoney.getO2oBalance().doubleValue();
					}
					break;
				case UserContant.ACCOUNT_TYPE_RESOURCE:// 个人
					if (StringUtils.isNotBlank(userMoney.getPassword())) {
						pwdNotNull = true;
					}
					if (null != userMoney.getAvailableBalance()) {
						availableBalance = userMoney.getAvailableBalance().doubleValue();
					}
					break;
				case UserContant.ACCOUNT_TYPE_YY:// YY运营商
					if (StringUtils.isNotBlank(userMoney.getPassword())) {
						pwdNotNull = true;
					}
					if (null != userMoney.getAvailableBalance()) {
						availableBalance = userMoney.getAvailableBalance().doubleValue();
					}
					break;

				default:// CN运营商
					if (StringUtils.isNotBlank(userMoney.getYysPassword())) {
						pwdNotNull = true;
					}
					if (null != userMoney.getYysBalance()) {
						availableBalance = userMoney.getYysBalance().doubleValue();
					}
					break;

			}

			if (null != userMoney.getRecordBalance()) {// 预分润
				recordBalance = userMoney.getRecordBalance().doubleValue();
			}
			List<UserAccountBO> userAccount = this.userAccountService.findUserAccountByUid(uid);
			for (UserAccountBO account : userAccount) {// 判断账号是否是CN账号
				if (UserContant.ACCOUNT_TYPE_8.equals(account.getAccountType())) {
					pwdNotNull = true;
					bl = true;
					break;
				}
			}
			if (bl) {// CN账号查询奖金重消
				try {
					UserAccount resAccount = this.userAccountService.findByUid(uid,
							UserContant.ACCOUNT_TYPE_8);

					CnUserMoneyBO cnUserMoneyBO = this.cnPayBaseService.getCnUserBounsMoney(resAccount
							.getLoginName());// 奖金
					if (cnUserMoneyBO != null) {
						if (null != cnUserMoneyBO.getISPAY() && 1 == cnUserMoneyBO.getISPAY().intValue()) {
							if (null != cnUserMoneyBO.getBONUS()) {
								cnBonus = cnUserMoneyBO.getBONUS();
							}
						}
					}
					CnUserMoneyBO cnUserMoneyBO1 = this.cnPayBaseService.getCnUserRepeatMoney(resAccount
							.getLoginName());// 重消
					if (cnUserMoneyBO1 != null) {
						if (null != cnUserMoneyBO1.getISPAY() && 1 == cnUserMoneyBO1.getISPAY().intValue()
								&& null != cnUserMoneyBO1.getBONUS_REPEAT()) {
							// response.setcNRepeat(cnUserMoneyBO1.getBONUS_REPEAT());
							cnRepeat = cnUserMoneyBO1.getBONUS_REPEAT();
						}
					}
					
					//购物积分
					IntegralSwapBO integralBO = orclUserBaseService.getMyIntegral(resAccount.getLoginName());
					cnIntegral = integralBO == null ? 0 : integralBO.getSHOP_PV();
				} catch (Exception e) {
					logger.error("[getUserMoneyV2]CN money is error" + e);
				}
			}
		} else {
			if (StringUtils.isNotBlank(userMoney.getPassword())) {
				pwdNotNull = true;
			}
			if (null != userMoney.getAvailableBalance()) {
				availableBalance = userMoney.getAvailableBalance().doubleValue();
			}
		}

		if (cnRepeat < 0)
			cnRepeat = 0;
		if (cnBonus < 0)
			cnBonus = 0;
		if (recordBalance < 0)
			recordBalance = 0;
		if (availableBalance < 0)
			availableBalance = 0;

		DecimalFormat df = new DecimalFormat("######0.00");

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("cnIntegral", Double.valueOf(df.format(cnIntegral)));
		resultMap.put("cnRepeat", Double.valueOf(df.format(cnRepeat)));
		resultMap.put("cnBonus", Double.valueOf(df.format(cnBonus)));
		resultMap.put("recordBalance", Double.valueOf(df.format(recordBalance)));
		resultMap.put("availableBalance", Double.valueOf(df.format(availableBalance)));
		resultMap.put("pwdNotNull", pwdNotNull);
		return resultMap;
	}

	/** 通过CN账号获取购物积分和重消 **/
	@SuppressWarnings({"unchecked", "rawtypes"})
	public Map<String, Object> getCNUserIntegralAndMoney(Long uid) {
		Map<String, Object> resultMap = new HashMap<>();
		UserAccount account = userAccountService.findUserAccount(uid, UserContant.ACCOUNT_TYPE_8);
		Double shopingIntegral = 0.00;
		Double cnRepeat = 0.00;
		
		if (account == null) {
			resultMap.put("cnRepeat", cnRepeat);
			resultMap.put("shopingIntegral", shopingIntegral);
			return resultMap;
		}
		Map map = new HashMap();
		map.put("USER_ALIAS", account.getLoginName());
		try {
			CnMoneyBO cn_pv = this.cnPayBaseService.getCnUserShopPv(map);// 积分账户
			CnUserMoneyBO cnUserMoneyBO1 = this.cnPayBaseService.getCnUserRepeatMoney(account.getLoginName());
			if (null != cn_pv && null != cn_pv.getSHOP_PV()) {
				shopingIntegral = cn_pv.getSHOP_PV();
			}
			if (null != cnUserMoneyBO1 && null != cnUserMoneyBO1.getBONUS_REPEAT()) {
				cnRepeat = cnUserMoneyBO1.getBONUS_REPEAT();
			}
		} catch (Exception e) {
			logger.error("[getCNUserIntegralAndMoney] error uid="+uid+" CN LoginName ="+account.getLoginName()+e);
			logger.error("[getCNUserIntegralAndMoney] error e:"+e);
		}
		DecimalFormat df = new DecimalFormat("######0.00");
		resultMap.put("cnRepeat", Double.valueOf(df.format(cnRepeat)));
		resultMap.put("shopingIntegral", Double.valueOf(df.format(shopingIntegral)));
		return resultMap;
	}

	/**
	 * 根据uid type 查询分润
	 * 
	 * @param userId
	 * @param typeList
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public BigDecimal selectSumByTypeAndUserId(Long userId, String[] typeList, Date startTime, Date endTime,
			String type) {
		if (CommUtil.isNotNull(type) && type.equals("0")) {// o2o
			return rebateRecordDao.selectSumByTypeUid(userId, typeList, startTime, endTime, 0);
		} else {// b2c
			return rebateRecordDao.selectSumByTypeUid(userId, typeList, startTime, endTime, 1);
		}
	}
}
