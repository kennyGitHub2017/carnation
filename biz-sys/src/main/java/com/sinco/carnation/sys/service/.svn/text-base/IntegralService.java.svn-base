package com.sinco.carnation.sys.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.config.constant.DictionKey;
import com.sinco.carnation.config.dao.ConfigSetDao;
import com.sinco.carnation.notice.dao.NoticeMessageDao;
import com.sinco.carnation.sns.dao.WenJuanresultHistoryDao;
import com.sinco.carnation.sys.bo.IntegralRegBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.IntegralRegDao;
import com.sinco.carnation.sys.model.IntegralReg;
import com.sinco.carnation.sys.vo.IntegralRegVO;
import com.sinco.carnation.user.bo.IntegralLogBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.dao.IntegralLogDao;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.model.IntegralLog;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Service
@Transactional
public class IntegralService {
	private static final Logger logger = LoggerFactory.getLogger(IntegralService.class);
	@Autowired
	private IntegralLogDao integralLogDao;
	@Autowired
	private IntegralRegDao integralRegDao;
	@Autowired
	private UserCustomerDao userCustomerDao;

	@Autowired
	private NoticeMessageDao noticeMessageDao;

	@Autowired
	private ConfigSetDao cfDao;

	@Autowired
	private NoticeMessageService noticeMessageService;

	@Autowired
	private UserAccountService accountService;

	@Autowired
	private IntegralRegService integralRegService;
	@Autowired
	private WenJuanresultHistoryDao wenJuanresultHistoryDao;

	public void save(IntegralLog integralLog) {
		integralLogDao.save(integralLog);
	}

	public IntegralLog getObjById(Long id) {
		IntegralLog integralLog = this.integralLogDao.get(id);
		if (integralLog != null) {
			return integralLog;
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Long id) {
		integralLogDao.remove(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void batchDelete(List<Serializable> integralLogIds) {
		for (Serializable id : integralLogIds) {
			delete((Long) id);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(IntegralLog integralLog) {
		integralLogDao.update(integralLog);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveIntegrall(String userName, String operateType, String content, String integral,
			Long operateUserId) {
		UserCustomer customer = userCustomerDao.queryUserCuxtomerByLoginName(userName);
		if (operateType.equals("add")) {
			if (customer.getIntegral() == null) {
				customer.setIntegral(0);
			}
			customer.setIntegral(customer.getIntegral() + CommUtil.null2Int(integral));
		} else {
			if (customer.getIntegral() > CommUtil.null2Int(integral))
				customer.setIntegral(customer.getIntegral() - CommUtil.null2Int(integral));
			else
				customer.setIntegral(0);
		}
		customer.setUpdateTime(new Date());
		// 更新用户积分
		userCustomerDao.updateByPrimaryKeySelective(customer);
		// 增加积分日志
		addIntegralLog(operateType, content, integral, customer.getUid(), operateUserId);
	}

	/**
	 * 保存积分
	 * 
	 * @param type
	 *            积分规则标识 （IntegralConstants.java 积分规则标识常量类）
	 * @param uid
	 *            用户UID
	 * @param operateUserId
	 *            操作用户ID（针对后台手动为用户增加积分，否则传空）
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int addIntegral(String type, Long uid, Long operateUserId) {
		try {
			return addIntegral(type, uid, null, operateUserId, null, null);
		} catch (Exception e) {
			logger.error("[addIntegral] is unsuccess ,type="+type+" ,uid="+uid+" ,operateUserId="+operateUserId);
		}
		return 0;
	}

	/**
	 * regType=integral_sign_day 查询连续签到天数 regType=integral_flip_cards 拼手气
	 * 
	 * @param uid
	 *            用户UID
	 */
	public int getSignDay(Long uid, String regType) {
		int day = 0;
		IntegralLogBO todayBO = this.integralLogDao.querySignIntegralLogYestoday(uid, "2", regType);
		if (todayBO != null) {
			day = todayBO.getSignDay();
		} else {
			IntegralLogBO yestodayBO = this.integralLogDao.querySignIntegralLogYestoday(uid, "1", regType);
			if (yestodayBO != null) {
				day = yestodayBO.getSignDay();
			}
		}

		return day;
	}

	/**
	 * regType=integral_sign_day 查询昨天连续签到天数 regType=integral_flip_cards 拼手气
	 * 
	 * @param uid
	 *            用户UID
	 */
	public int getSignYesterday(Long uid, String regType) {
		int day = 0;
		IntegralLogBO todayBO = this.integralLogDao.querySignIntegralLogYestoday(uid, "3", regType);
		if (todayBO != null) {
			day = todayBO.getSignDay();
		}
		return day;
	}

	/**
	 * type=integral_sign_day今天是否已签到 type=integral_flip_cards 今天是否已翻牌
	 * 
	 * @param uid
	 *            用户UID
	 * 
	 * @return boolean true:已签到 false:未签到
	 */
	public boolean isSignToday(Long uid, String type) {
		boolean isSign = false;
		IntegralRegVO vo = new IntegralRegVO();
		vo.setType(type);
		vo.setIntegralUserId(uid);
		vo.setTimesLimitType(3);
		int count = this.integralLogDao.checkIntegralLog(vo);
		if (count > 0) {// 已签到
			isSign = true;
		}

		return isSign;
	}

	/**
	 * type=integral_sign_day昨天是否已签到 type=integral_flip_cards 昨天是否已翻牌
	 * 
	 * @param uid
	 *            用户UID
	 * 
	 * @return boolean true:已签到 false:未签到
	 */
	public boolean isSignYesterday(Long uid, String type) {
		boolean isSign = false;
		IntegralRegVO vo = new IntegralRegVO();
		vo.setType(type);
		vo.setIntegralUserId(uid);
		vo.setTimesLimitType(2);
		int count = this.integralLogDao.checkIntegralLog(vo);
		if (count > 0) {// 已签到
			isSign = true;
		}

		return isSign;
	}

	/**
	 * 保存积分
	 * 
	 * @param type
	 *            积分规则标识 （IntegralConstants.java 积分规则标识常量类）
	 * @param uid
	 *            用户UID
	 * @param amount
	 *            消费金额（针对消费、积分兑换、积分购物等积分不确定的情况，否则传空）
	 * @param operateUserId
	 *            操作用户ID（针对后台手动为用户增加积分，否则传空）
	 * @param consumerType
	 *            消费类型（goods:商品；group:服务；offlineOrder:线下订单）
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public synchronized int addIntegral(String type, Long uid, String amount, Long operateUserId,
			String consumerType, Date payTime) throws Exception {
//		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//		logger.info("添加积分日期：" + date + ",type：" + type + ",uid：" + uid + ",amount:" + amount
//				+ ",operateUserId：" + operateUserId);
			IntegralReg integralReg = this.integralRegDao.findByType(type);
			int returnIntegral = 0;
			// 积分规则不为空
			if (null != integralReg) {
				// 积分规则在使用
				if (integralReg.getDisplay()) {
					try {
						returnIntegral = this.saveIntegral(uid, integralReg, amount, operateUserId, consumerType,
								payTime);
					} catch (Exception e) {
						logger.error("add integral is unsuccess", e);
						throw e;
					}
				}
			}
			return returnIntegral;
	}

	/**
	 * 保存积分
	 * 
	 * @param uid
	 *            用户UID
	 * @param integralReg
	 *            积分规则
	 * @param amount
	 *            积分（针对消费、积分兑换、积分购物等积分不确定的情况，否则传空）
	 * @param operateUserId
	 *            操作用户ID（针对后台手动为用户增加积分，否则传空）
	 * @param consumerType
	 *            消费类型（goods:商品；group:服务；offlineOrder:线下订单）
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	private int saveIntegral(Long uid, IntegralReg integralReg, String amount, Long operateUserId,
			String consumerType, Date payTime) throws Exception {
		UserCustomer customer = userCustomerDao.findById(uid);
		if(null == customer){
			logger.error("[saveIntegral] can't find customer ,uid ="+uid);
		}
		Map<String, Object> map = null;
		int returnIntegral = 0;
		if (null != customer) {
			Date now = new Date();
			boolean flag = true;
			String date = CommUtil.formatLongDate(now);
			// String content = "用户" + customer.getNickname() + "于" + date +
			// integralReg.getName() + "获得积分$2";
			String content = "您于" + date + integralReg.getName() + "获得积分$2";
			if (customer.getIntegral() == null) {
				customer.setIntegral(returnIntegral);
			}
			int timesLimitType = integralReg.getTimesLimitType() == null ? 1 : integralReg
					.getTimesLimitType();
			if (timesLimitType > 1) {// 有次数限制
				int times = integralReg.getTimes() == null ? 0 : integralReg.getTimes();
				if (times > 0) {

					IntegralRegVO vo = new IntegralRegVO();
					vo.setType(integralReg.getType());
					vo.setIntegralUserId(customer.getUid());
					vo.setTimesLimitType(timesLimitType);
					int count = this.integralLogDao.checkIntegralLog(vo);
					if (times <= count) {// 赠送大于等于次数限制了就不能赠送了
						flag = false;
					}
				}
			}
			if (flag) {
				map = this.handleIntegralRegType(integralReg, consumerType, content, customer, date,
						operateUserId, amount, returnIntegral, payTime,now);
				if ((boolean) map.get("flag")) {
					customer.setUpdateTime(now);
					// 增加积分日志
					if(String.valueOf((int)map.get("returnIntegral")).equals("0")){
						addIntegralLog(String.valueOf(map.get("content"))+",本日积分已满",String.valueOf((int)map.get("returnIntegral")), integralReg,
								customer.getUid(), operateUserId, (int) map.get("signDay"));
					}else{
						addIntegralLog(String.valueOf(map.get("content")),String.valueOf((int)map.get("returnIntegral")), integralReg,
								customer.getUid(), operateUserId, (int) map.get("signDay"));
					}
					// 更新用户积分
					userCustomerDao.updateByPrimaryKeySelective(customer);
					/*
					 * try { //更新消息推送日志 NoticeMessage noticeMesg = new
					 * NoticeMessage(); noticeMesg.setUid(uid);
					 * noticeMesg.setCreateTime(new Date()); int i = (int)
					 * map.get("returnIntegral"); BigDecimal getIntegral = new
					 * BigDecimal(i);
					 * noticeMesg.setNotcieLogAmount(getIntegral); String
					 * message = "您于" + date + "获得" + getIntegral + "积分";
					 * noticeMesg.setNoticeMessage(message);
					 * noticeMesg.setPushType("integral");
					 * //noticeMessageDao.save(noticeMesg);
					 * noticeMessageService.save(noticeMesg);
					 * 
					 * noticeMessageService.pushMessage(noticeMesg);
					 * logger.info("=======积分消息推送========="); } catch (Exception
					 * e) { logger.error("消息日志推送失败" + e.getStackTrace()); }
					 */
				}
			}
		}
		if (null == map) {
			return 0;
		}
		if (map.containsKey("returnIntegral")) {
			return (int) map.get("returnIntegral");
		} else {
			return 0;
		}
	}
	

	/**
	 * 保存积分
	 * 
	 * @param type
	 *            积分规则标识 （IntegralConstants.java 积分规则标识常量类）
	 * @param uid
	 *            用户UID
	 * @param amount
	 *            消费金额（针对消费、积分兑换、积分购物等积分不确定的情况，否则传空）
	 * @param operateUserId
	 *            操作用户ID（针对后台手动为用户增加积分，否则传空）
	 * @param consumerType
	 *            消费类型（goods:商品；group:服务；offlineOrder:线下订单）
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public synchronized int addIntegral(String type, Long uid, String amount, Long operateUserId,
			String consumerType, Date payTime , Date addTime) throws Exception {
//		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//		logger.info("添加积分日期：" + date + ",type：" + type + ",uid：" + uid + ",amount:" + amount
//				+ ",operateUserId：" + operateUserId);
		IntegralReg integralReg = this.integralRegDao.findByType(type);
		int returnIntegral = 0;
		// 积分规则不为空
		if (null != integralReg) {
			// 积分规则在使用
			if (integralReg.getDisplay()) {
				try {
					returnIntegral = this.saveIntegral(uid, integralReg, amount, operateUserId, consumerType,
							payTime , addTime);
				} catch (Exception e) {
					logger.error("add integral is unsuccess", e);
					throw e;
				}
			}
		}
		return returnIntegral;
	}
	
	/**
	 * 保存积分
	 * 
	 * @param uid
	 *            用户UID
	 * @param integralReg
	 *            积分规则
	 * @param amount
	 *            积分（针对消费、积分兑换、积分购物等积分不确定的情况，否则传空）
	 * @param operateUserId
	 *            操作用户ID（针对后台手动为用户增加积分，否则传空）
	 * @param consumerType
	 *            消费类型（goods:商品；group:服务；offlineOrder:线下订单）
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	private int saveIntegral(Long uid, IntegralReg integralReg, String amount, Long operateUserId,
			String consumerType, Date payTime , Date addTime) throws Exception {
		UserCustomer customer = userCustomerDao.findById(uid);
		if(null == customer){
			logger.error("[saveIntegral] can't find customer ,uid ="+uid);
		}
		Map<String, Object> map = null;
		int returnIntegral = 0;
		if (null != customer) {
			Date now = new Date();
			if(null != addTime){
				now = addTime;
			}
			boolean flag = true;
			String date = CommUtil.formatLongDate(now);
			String content = "您于" + date + integralReg.getName() + "获得积分$2";
			if (customer.getIntegral() == null) {
				customer.setIntegral(returnIntegral);
			}
			int timesLimitType = integralReg.getTimesLimitType() == null ? 1 : integralReg
					.getTimesLimitType();
			if (timesLimitType > 1) {// 有次数限制
				int times = integralReg.getTimes() == null ? 0 : integralReg.getTimes();
				if (times > 0) {

					IntegralRegVO vo = new IntegralRegVO();
					vo.setType(integralReg.getType());
					vo.setIntegralUserId(customer.getUid());
					vo.setTimesLimitType(timesLimitType);
					vo.setAddTime(now);
					int count = this.integralLogDao.checkIntegralLogByTime(vo);
					if (times <= count) {// 赠送大于等于次数限制了就不能赠送了
						flag = false;
					}
				}
			}
			if (flag) {
				map = this.handleIntegralRegType(integralReg, consumerType, content, customer, date,
						operateUserId, amount, returnIntegral, payTime,now);
				if ((boolean) map.get("flag")) {
					customer.setUpdateTime(now);
					// 增加积分日志
					if(String.valueOf((int)map.get("returnIntegral")).equals("0")){
						addIntegralLog(String.valueOf(map.get("content"))+",本日积分已满",String.valueOf((int)map.get("returnIntegral")), integralReg,
								customer.getUid(), operateUserId, (int) map.get("signDay"));
					}else{
						addIntegralLog(String.valueOf(map.get("content")),String.valueOf((int)map.get("returnIntegral")), integralReg,
								customer.getUid(), operateUserId, (int) map.get("signDay") ,addTime);
					}
					// 更新用户积分
					userCustomerDao.updateByPrimaryKeySelective(customer);
				}
			}
		}
		if (null == map) {
			return 0;
		}
		if (map.containsKey("returnIntegral")) {
			return (int) map.get("returnIntegral");
		} else {
			return 0;
		}
	}

	@SuppressWarnings("unused")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	private Map<String, Object> handleIntegralRegType(IntegralReg integralReg, String consumerType,
			String content, UserCustomer customer, String date, Long operateUserId, String amount,
			int returnIntegral, Date payTime ,Date addTime) throws Exception {
		if(null == addTime){
			addTime = new Date();
		}
		Map<String, Object> map = new HashMap<>();
		int cosumerIntegral = 0;// 消费者积分
		int signDay = 0;
		int remedialSignDay = 0;
		boolean flag = false;
		if (integralReg.getType().equals(IntegralConstants.INTEGRAL_CONSUMER)) {// 消费赠送积分（获得等额积分）
			flag = true;
			// 处理首次消费
			int integral = this.handleFirstConsumer(consumerType, content, customer, date, operateUserId);
			content = content.replace("$2", String.valueOf(amount));
			cosumerIntegral = CommUtil.null2Int(new BigDecimal(amount).setScale(0, BigDecimal.ROUND_HALF_UP));
			returnIntegral = integral + cosumerIntegral;
			// 是否开启双倍积分
			Map<String, String> dss = cfDao.getMapFindAll();
			if (dss != null && cfDao.doubleScoreIsUnlock(dss, payTime)) {
				int number = Integer.parseInt(dss.get(DictionKey.SCORE_NUMBER));// 双倍积分数
				cosumerIntegral = number * cosumerIntegral;
			}
			customer.setIntegral(customer.getIntegral() + integral + cosumerIntegral);
		}else if(integralReg.getType().equals(IntegralConstants.INTEGRAL_JUANPI_ORDER)){ // 卷皮订单加积分
			flag = true;
			cosumerIntegral = CommUtil.null2Int(new BigDecimal(amount).setScale(0, BigDecimal.ROUND_HALF_UP));
			returnIntegral = cosumerIntegral;
			content = content.replace("$2", String.valueOf(cosumerIntegral));
			customer.setIntegral(customer.getIntegral() + cosumerIntegral);
		}else if (integralReg.getType().equals(IntegralConstants.INTEGRAL_SIGN_DAY)) {// 连续签到送积分
			// 校验今天是否已签到
			IntegralRegVO vo = new IntegralRegVO();
			vo.setType(integralReg.getType());
			vo.setIntegralUserId(customer.getUid());
			vo.setTimesLimitType(3);
			int count = this.integralLogDao.checkIntegralLog(vo);
			if (count == 0) {// 未签到
				flag = true;
				String signIntegral = integralReg.getSignIntegral();
				String[] signIntegrals = signIntegral.split(",");
				IntegralLogBO bo = this.integralLogDao.querySignIntegralLogYestoday(customer.getUid(), "1",
						integralReg.getType());
				if (bo != null) {// 连续签到
					signDay = bo.getSignDay();
					if (signDay >= 7) {
						int mod = signDay % 7;
						returnIntegral = Integer.valueOf(signIntegrals[mod]);
					} else {
						returnIntegral = Integer.valueOf(signIntegrals[signDay]);
					}
					++signDay;
				} else {// 断开
					returnIntegral = Integer.valueOf(signIntegrals[0]);
					signDay = 1;
				}
				integralReg.setIntegral(returnIntegral);
				// 积分上限/积分每日获取上限/本日剩余积分
				returnIntegral = IntegralEverydayRemaining(returnIntegral, customer.getUid(),addTime);
				// 积分信息放入对象
				customer.setIntegral(customer.getIntegral() + returnIntegral);
				// 积分信息放入积分日志字符串
				content = content.replace("$2", String.valueOf(returnIntegral));
			}
		} else if (integralReg.getType().equals(IntegralConstants.INTEGRAL_FLIP_CARDS)) {// 翻牌送积分
			// 校验今天是否已翻牌
			IntegralRegVO vo = new IntegralRegVO();
			vo.setType(integralReg.getType());
			vo.setIntegralUserId(customer.getUid());
			vo.setTimesLimitType(3);
			int count = this.integralLogDao.checkIntegralLog(vo);

			content = content.replace("$2", String.valueOf(amount));
			cosumerIntegral = CommUtil.null2Int(new BigDecimal(amount).setScale(0, BigDecimal.ROUND_HALF_UP));
			if (count == 0) {// 未翻牌
				flag = true;
				String signIntegral = integralReg.getSignIntegral();
				String[] signIntegrals = signIntegral.split(",");
				IntegralLogBO bo = this.integralLogDao.querySignIntegralLogYestoday(customer.getUid(), "1",
						integralReg.getType());
				if (bo == null) {
					bo = this.integralLogDao.querySignIntegralLogYestoday(customer.getUid(), "2",
							IntegralConstants.INTEGRAL_FLIP_CARDS_REMEDIAL_MARK);
				}
				if (bo != null) {// 连续翻牌
					signDay = bo.getSignDay() + remedialSignDay;
					returnIntegral = cosumerIntegral;
					++signDay;
				} else {// 断开
					returnIntegral = cosumerIntegral;
					signDay = 1;
				}
				// 积分上限/积分每日获取上限/本日剩余积分
				returnIntegral = IntegralEverydayRemaining(returnIntegral, customer.getUid(),addTime);
				// 积分信息放入对象
				customer.setIntegral(customer.getIntegral() + returnIntegral);
				// 积分信息放入积分日志字符串
				content = content.replace("$2", String.valueOf(returnIntegral));
			}
		}else if(integralReg.getTimesLimitType()<3){
			flag = true;
			returnIntegral = CommUtil.null2Int(integralReg.getIntegral());
			// 积分信息存入对象
			customer.setIntegral(customer.getIntegral() + returnIntegral);
			// 积分信息放入积分日志字符串
			content = content.replace("$2", String.valueOf(returnIntegral));
		}else{
			// 登录赠送积分,注册赠送积分,推荐注册赠送积分,评论赠送积分,健康任务赠送积分,评价赠送积分,发帖赠送积分,自测赠送积分,分享赠送积分
			flag = true;
			returnIntegral = CommUtil.null2Int(integralReg.getIntegral());
			// 积分上限/积分每日获取上限/本日剩余积分
			returnIntegral = IntegralEverydayRemaining(returnIntegral, customer.getUid(),addTime);
			// 积分信息存入对象
			customer.setIntegral(customer.getIntegral() + returnIntegral);
			// 积分信息放入积分日志字符串
			content = content.replace("$2", String.valueOf(returnIntegral));
		}
		map.put("content", content);
		map.put("returnIntegral", returnIntegral);
		map.put("cosumerIntegral", cosumerIntegral);
		map.put("signDay", signDay);
		map.put("flag", flag);
		return map;
	}

	/**
	 * 限制积分获取不能超过当日上限
	 * 
	 * @param Integral
	 *            积分值
	 * @param uid
	 *            用户ID
	 */
	public int IntegralTodayRemaining(Integer Integral, long uid) {
		int todayGetIntegral = this.IntegralTodayGet(uid);
		// 当日积分未上限
		if (IntegralConstants.INTEGRAL_CEILING_DAILY - todayGetIntegral - Integral > 0) {
			return Integral;
		} else {
			// 当日积分已上限
			if (IntegralConstants.INTEGRAL_CEILING_DAILY - todayGetIntegral > 0) {
				return IntegralConstants.INTEGRAL_CEILING_DAILY - todayGetIntegral;
			} else {
				return 0;
			}
		}
	}
	/**
	 * 通过uid获取当日已获取(所有类型的)积分值
	 * 
	 * @param uid
	 */
	public int IntegralTodayAllGet(long uid) {
		List<IntegralLogBO> logs = integralLogDao.findListByUid(uid);
		int todayGetIntegral = 0;
		try {
			if (logs != null) {
				for (IntegralLogBO log : logs) {
					/*
					 * String logStr=log.getContent();
					 * if(logStr.contains("消费获得积分")){//消费积分不算在内 }else{ String
					 * todayGetIntegralNo=logStr.substring(logStr.lastIndexOf(
					 * "获得积分")+4,logStr.length()); todayGetIntegral=
					 * Integer.valueOf(todayGetIntegralNo)+todayGetIntegral; }
					 */
					if (/*
						 * log.getType().equals(IntegralConstants.
						 * INTEGRAL_CONSUMER)||
						 */log.getType().equals("integral_order") || log.getType().equals("system")) {// 消费积分算在内
					} else {
						if(log.getIntegral()>0){
							todayGetIntegral += log.getIntegral();
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("积分获取失败" + e.getStackTrace());
			return 0;
		}
		return todayGetIntegral;
	}

	/**
	 * 通过uid获取当日已获取(每日类型的)积分值
	 * 
	 * @param uid
	 */
	public int IntegralTodayGet(long uid) {
		List<IntegralLogBO> logs = integralLogDao.findListByUid(uid);
		List<IntegralRegBO> regList = integralRegService.findAll();
		int todayGetIntegral = 0;
		try {
			if (logs != null) {
				for (IntegralLogBO log : logs) {
					/*
					 * String logStr=log.getContent();
					 * if(logStr.contains("消费获得积分")){//消费积分不算在内 }else{ String
					 * todayGetIntegralNo=logStr.substring(logStr.lastIndexOf(
					 * "获得积分")+4,logStr.length()); todayGetIntegral=
					 * Integer.valueOf(todayGetIntegralNo)+todayGetIntegral; }
					 */
					if(hasIntegralTypeDaily(log.getType() , regList)){//积分类型为每日类型的积分才会加积分
						todayGetIntegral += log.getIntegral();
					}
				}
			}
		} catch (Exception e) {
			logger.error("积分获取失败" + e.getStackTrace());
			return 0;
		}
		return todayGetIntegral;
	}

	
	/**
	 * 限制积分获取不能超过当日上限
	 * 
	 * @param Integral
	 *            积分值
	 * @param uid
	 *            用户ID
	 */
	public int IntegralEverydayRemaining(Integer Integral, long uid, Date addTime) {
		int todayGetIntegral = this.IntegralEverydayGet(uid ,addTime);
		// 当日积分未上限
		if (IntegralConstants.INTEGRAL_CEILING_DAILY - todayGetIntegral - Integral > 0) {
			return Integral;
		} else {
			// 当日积分已上限
			if (IntegralConstants.INTEGRAL_CEILING_DAILY - todayGetIntegral > 0) {
				return IntegralConstants.INTEGRAL_CEILING_DAILY - todayGetIntegral;
			} else {
				return 0;
			}
		}
	}

	/**
	 * 通过uid获取当日已获取(每日类型的)积分值
	 * 
	 * @param uid
	 */
	public int IntegralEverydayGet(long uid, Date addTime) {
		List<IntegralLogBO> logs = integralLogDao.findListByUidTime(uid , addTime);
		List<IntegralRegBO> regList = integralRegService.findAll();
		int todayGetIntegral = 0;
		try {
			if (logs != null) {
				for (IntegralLogBO log : logs) {
					if(hasIntegralTypeDaily(log.getType() , regList)){//积分类型为每日类型的积分才会加积分
						todayGetIntegral += log.getIntegral();
					}
				}
			}
		} catch (Exception e) {
			logger.error("积分获取失败" + e.getStackTrace());
			return 0;
		}
		return todayGetIntegral;
	}
	/** 根据type判断该积分是否是每日类型的积分 **/
	public boolean hasIntegralTypeDaily(String type , List<IntegralRegBO> regList){
		boolean result = false;
		if(StringUtils.isBlank(type)){
			return result;
		}
/*		if(type.equals(IntegralConstants.INTEGRAL_CONSUMER)
				|| type.equals("integral_order") || type.equals("system")
				|| type.equals("integral_register_invitation")
				|| type.equals(IntegralConstants.INTEGRAL_INVITE_FRIENDS)){
			result = false;
		}*/
		for(IntegralRegBO bo : regList){
			if(null == bo.getType()){
				return result;
			}
			if(bo.getType().equals(type)){
				if(bo.getTimesLimitType()>2){//1：无次数限制 2：总次数限制 3：日次数限制 4:连续签到
					result = true;
					return result;
				}
			}
		}
		return result;
	}

	/**
	 * 处理首次消费
	 * 
	 * @param consumerType
	 * @param content
	 * @param customer
	 * @param date
	 * @param operateUserId
	 * @throws Exception
	 */
	public int handleFirstConsumer(String consumerType, String content, UserCustomer customer, String date,
			Long operateUserId) throws Exception {
		int integral = 0;
		if (StringUtils.isNotEmpty(consumerType)) {
			List<IntegralLogBO> bos = null;
			String type = null;
			IntegralReg integralReg2 = null;
			if ("goods".equals(consumerType)) {
				type = IntegralConstants.INTEGRAL_GOODS_FIRST_CONSUMER;
			} else if ("group".equals(consumerType)) {
				type = IntegralConstants.INTEGRAL_GROUP_FIRST_CONSUMER;
			} else if ("offlineOrder".equals(consumerType)) {
				type = IntegralConstants.INTEGRAL_OFFLINE_ORDER_FIRST_CONSUMER;
			}
			bos = this.integralLogDao.findByType(type, customer.getUid());
			if (bos == null || bos.size() == 0) {// 首次消费
				integralReg2 = this.integralRegDao.findByType(type);
				if (integralReg2 != null && integralReg2.getDisplay()) {
					integral = integralReg2.getIntegral();
					content = content.replace("$1", integralReg2.getName()).replace("$2",
							String.valueOf(integral));
					// 增加积分日志
					addIntegralLog(content, integral + "", integralReg2, customer.getUid(), operateUserId, 0);
					content = "用户" + customer.getNickname() + "于" + date + "$1获得积分$2";
				}
			}
		}

		return integral;
	}

	/**
	 * 增加积分日志
	 * 
	 * @param content
	 *            积分日志内容
	 * @param integralReg
	 *            积分规则
	 * @param amount
	 *            消费金额（针对消费、积分兑换、积分购物等积分不确定的情况，否则传空）
	 * @param userId
	 *            用户ID
	 * @param operateUserId
	 *            操作用户ID（针对后台手动为用户增加积分，否则传空）
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addIntegralLog(String content, String amount, IntegralReg integralReg, Long userId,
			Long operateUserId, int signDay) throws Exception {
		IntegralLog log = new IntegralLog();
		log.setAddtime(new Date());
		log.setContent(content);
		if (StringUtils.isNotEmpty(amount)) {
			// log.setIntegral(CommUtil.null2Int(amount));
			log.setIntegral(CommUtil.null2Int(new BigDecimal(amount).setScale(0, BigDecimal.ROUND_HALF_UP)));
		} else {
			log.setIntegral(CommUtil.null2Int(integralReg.getIntegral()));
		}
		log.setSignDay(signDay);
		log.setIntegralUserId(userId);
		// log.setOperateUserId(operateUserId);
		log.setType(integralReg.getType());

		UserCustomerBO balance = userCustomerDao.findBOByUserId(userId);// 用户信息
		log.setBalance(balance.getIntegral());// 积分余额

		integralLogDao.save(log);
	}
	

	/**
	 * 增加积分日志
	 * 
	 * @param content
	 *            积分日志内容
	 * @param integralReg
	 *            积分规则
	 * @param amount
	 *            消费金额（针对消费、积分兑换、积分购物等积分不确定的情况，否则传空）
	 * @param userId
	 *            用户ID
	 * @param operateUserId
	 *            操作用户ID（针对后台手动为用户增加积分，否则传空）
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addIntegralLog(String content, String amount, IntegralReg integralReg, Long userId,
			Long operateUserId, int signDay ,Date addTime) throws Exception {
		IntegralLog log = new IntegralLog();
		if(null != addTime){
			log.setAddtime(addTime);
		}else{
			log.setAddtime(new Date());
		}
		log.setContent(content);
		if (StringUtils.isNotEmpty(amount)) {
			// log.setIntegral(CommUtil.null2Int(amount));
			log.setIntegral(CommUtil.null2Int(new BigDecimal(amount).setScale(0, BigDecimal.ROUND_HALF_UP)));
		} else {
			log.setIntegral(CommUtil.null2Int(integralReg.getIntegral()));
		}
		log.setSignDay(signDay);
		log.setIntegralUserId(userId);
		// log.setOperateUserId(operateUserId);
		log.setType(integralReg.getType());

		UserCustomerBO balance = userCustomerDao.findBOByUserId(userId);// 用户信息
		log.setBalance(balance.getIntegral());// 积分余额

		integralLogDao.save(log);
	}

	/**
	 * 增加积分日志
	 * 
	 * @param operateType
	 * @param content
	 * @param integral
	 * @param userId
	 * @param operateUserId
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addIntegralLog(String operateType, String content, String integral, Long userId,
			Long operateUserId) {
		IntegralLog log = new IntegralLog();
		log.setAddtime(new Date());
		log.setContent(content);
		if (operateType.equals("add")) {
			log.setIntegral(CommUtil.null2Int(integral));
		} else {
			log.setIntegral(-CommUtil.null2Int(integral));
		}
		log.setIntegralUserId(userId);
		log.setOperateUserId(operateUserId);
		log.setType("system");

		UserCustomerBO balance = userCustomerDao.findBOByUserId(userId);// 用户信息
		log.setBalance(balance.getIntegral());// 积分余额

		integralLogDao.save(log);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addIntegralSwapLog(Long userId, Integer integral) {
		IntegralLog log = new IntegralLog();
		log.setAddtime(new Date());
		log.setContent("积分转换成购物积分实际转出" + Math.abs(integral));
		log.setIntegral(integral);
		log.setIntegralUserId(userId);
		log.setType(IntegralConstants.INTEGERAL_SWAP_MARK);
		UserCustomerBO balance = userCustomerDao.findBOByUserId(userId);// 用户信息
		log.setBalance(balance.getIntegral());// 积分余额
		integralLogDao.save(log);
	}

	/**
	 * 标识补签
	 * 
	 * @param content
	 *            积分日志内容
	 * @param type
	 *            积分类型
	 * @param userId
	 *            用户ID
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addIntegralLogFlipCards(String content, String type, Long userId, int signDay)
			throws Exception {
		IntegralLog log = new IntegralLog();
		log.setAddtime(new Date());
		log.setContent(content);
		log.setIntegral(0);
		log.setSignDay(signDay);
		log.setIntegralUserId(userId);
		log.setType(type);
		UserCustomerBO balance = userCustomerDao.findBOByUserId(userId);// 用户信息
		log.setBalance(balance.getIntegral());// 积分余额
		integralLogDao.save(log);
	}

	public void queryIntegralPageList(String loginName, MyPage<IntegralLogBO> page) {
		page.setContent(integralLogDao.queryIntegralPageList(loginName, page));
	}

	/**
	 * 根据用户ID查询今日积分获取情况
	 * 
	 * @param userid
	 * @return IntegralRegBO
	 */
	public List<IntegralRegBO> selectRegByUserid(Long userid) {
		return integralRegDao.selectRegByUserid(userid);
	}

	/**
	 * 根据用户ID查询今日积分获取情况
	 * 
	 * @param userid
	 * @return IntegralRegBO
	 */
	public List<IntegralRegBO> selectOtherRegByUserid(Long userid) {
		return integralRegDao.selectOtherRegByUserid(userid);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void bindingGetIntegral(Long uid, String type) throws Exception {
		List<UserAccountBO> accounts = accountService.findUserAccountByUid(uid);
		for (UserAccountBO account : accounts) {
			if (account.getAccountType().equals(UserContant.ACCOUNT_TYPE_2)) {
				this.addIntegral(IntegralConstants.INTEGRAL_BANGDING_MOBILE, uid, null);
			}
			if (account.getAccountType().equals(UserContant.ACCOUNT_TYPE_3)) {
				this.addIntegral(IntegralConstants.INTEGRAL_BANGDING_XIELUNYAN, uid, null);
			}
			if (account.getAccountType().equals(UserContant.ACCOUNT_TYPE_4)) {
				this.addIntegral(IntegralConstants.INTEGRAL_BANGDING_WECHAT, uid, null);
			}
			if (account.getAccountType().equals(UserContant.ACCOUNT_TYPE_5)) {
				this.addIntegral(IntegralConstants.INTEGRAL_BANGDING_WEIBO, uid, null);
			}
		}
//		this.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_DIANZAN, uid, null);
	}

	/**
	 * 补签 消耗积分，记录日志
	 * 
	 * @param uid
	 * @param content
	 * @param signDay
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int FlipCardsLost(Long uid, String content, int signDay) {
		int num = 0;
		try {
			num = this.addIntegral(IntegralConstants.INTEGRAL_FLIP_CARDS_REMEDIAL, uid, null);// 减少积分
			this.addIntegralLogFlipCards(content, IntegralConstants.INTEGRAL_FLIP_CARDS_REMEDIAL_MARK, uid,
					signDay);
		} catch (Exception e) {
			logger.error("FLIP_CARDS_REMEDIAL is unsuccess uid =" + uid);
		}// 添加日志
		return num;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int flipCardsGetIntegral(Long uid, boolean flag) {
		String amount = "10";
		int num = 0;
		// 随机3取1
		Random rd = new Random();
		int x = rd.nextInt(3) + 1;
		if (uid != null && !flag) {
			int signDay = this.getSignDay(uid, IntegralConstants.INTEGRAL_FLIP_CARDS);
			boolean remedyflag = this.isSignToday(uid, IntegralConstants.INTEGRAL_FLIP_CARDS_REMEDIAL_MARK);
			if (remedyflag) {// 已补救不需再次补救
				signDay = this.getSignDay(uid, IntegralConstants.INTEGRAL_FLIP_CARDS_REMEDIAL_MARK);
			}
			if (signDay <= 6) {
				if (x == 1) {
					amount = "5";
				} else if (x == 2) {
					amount = "8";
				} else {
					amount = "10";
				}
			} else {
				if (x == 1) {
					amount = "10";
				} else if (x == 2) {
					amount = "15";
				} else {
					amount = "20";
				}
			}
			try {
				// 增加积分，添加日志
				num = this.addIntegral(IntegralConstants.INTEGRAL_FLIP_CARDS, uid, amount, null, null, null);
			} catch (Exception e) {
				logger.error("add integral is unsuccess userid" + uid);
			}
		}
		return num;
	}

	/**
	 * 积分商城 过期商品下架
	 */
	public void changeShow() {
		integralRegDao.changeShow();
	}
	
	/** 根据uid time type 获取积分日志**/
	public IntegralLogBO getByUidTimeType(Long uid ,Date time ,String type){
		return integralLogDao.getByUidTimeType(uid, time, type);
	}
	
	
	/** 根据uid time type 获取积分日志**/
	public IntegralLogBO getLastByUidType(Long uid ,String type){
		if(null == uid || null == type){
			return null;
		}
		return integralLogDao.getLastByUidType(uid, type);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addWenJuanHistoryIntegralByid(Long id ,Long uid , String type ,Date time){
		try {
			if(wenJuanresultHistoryDao.updateIsAddIntegralByid(id)>0){
				//加积分
				this.addIntegral(type, uid, null, null, null, null);
			}
		} catch (Exception e) {
			logger.error("[wjResultHistoryAddIntegral] error , uid = "+ uid);
			logger.error("[wjResultHistoryAddIntegral] error , e="+e);
		}
	}
	
	public void changeErrorLog(){
//		List<IntegralLogBO> users = integralLogDao.listErrorUidByType();//查询数据异常的用户
////		System.out.println(users.size());
//		for(IntegralLogBO userBO : users){
//			Long uid = userBO.getIntegralUserId();
////			Long uid = 214829L;
//			int subIntegral = 0;
//			int bBlance = 0;
//			int dBlance = 0;
//			Long bFirstId = 0L;
//			Long dFirstId = 0L;
//			//查询异常积分总值
//			UserCustomer customer = userCustomerDao.findById(uid);
//			if(null == customer){
//				continue;
//			}
//			int userIntegral = customer.getIntegral().intValue();
//			Integer bdz = integralLogDao.sumErrorByUidType(uid,IntegralConstants.INTEGRAL_JIANKANGQUAN_BEIDIANZAN);
//			Integer dz = integralLogDao.sumErrorByUidType(uid,IntegralConstants.INTEGRAL_JIANKANGQUAN_DIANZAN);
//			//用户现有积分-异常积分是否负数
//			if(userIntegral<(bdz+dz)){
//				logger.info("user integral less than errorIntegral ,uid="+uid);
//				continue;
//			}
//			int bline = 0;
//			List<IntegralLogBO> bday = integralLogDao.listErrorByUidType(uid,IntegralConstants.INTEGRAL_JIANKANGQUAN_BEIDIANZAN);//查询该用户这段时间的异常日志
//			for(IntegralLogBO dayBO : bday){
//				bline=bline+1;
//				if(bline<141){//正常数据以内 不做处理
//					if(bline == 1){
//						bFirstId = dayBO.getId();
//						bBlance = dayBO.getBalance();
//					}
//				}else{
//					if(bline>140){
//						integralLogDao.delete(dayBO.getId());
//					}
//				}
//			}
//			int dline = 0;
//			List<IntegralLogBO> dday = integralLogDao.listErrorByUidType(uid,IntegralConstants.INTEGRAL_JIANKANGQUAN_DIANZAN);//查询该用户这段时间的异常日志
//			for(IntegralLogBO dayBO : dday){
//				dline=dline+1;
//				if(dline<141){//正常数据以内 不做处理
//					if(dline == 1){
//						dFirstId = dayBO.getId();
//						dBlance = dayBO.getBalance();
//					}
//				}else{
//					if(dline>140){
//						integralLogDao.delete(dayBO.getId());
//					}
//				}
//			}
//			int blance = bBlance;
//			Long queryId = bFirstId;
//			if(bFirstId > dFirstId && dFirstId > 0){
//				queryId = dFirstId;
//				blance = dBlance;
//			}
//			if(queryId==0){
//				continue;
//			}
//			List<IntegralLogBO> allLogByUidAndId = integralLogDao.listErrorByUidId(uid,queryId);//根据uid和最开始正常的记录查询异常日志并恢复
//			for(IntegralLogBO allLogBO : allLogByUidAndId){
//				allLogBO.setBalance(blance);
//				blance = blance+allLogBO.getIntegral();
//				integralLogDao.updateBlanceByPrimaryKeySelective(allLogBO);//保存
//			}
//			subIntegral=userIntegral-blance;
//			userCustomerDao.subtractIntegral(uid, subIntegral);
//		}
	}
}
