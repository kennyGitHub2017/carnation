package com.sinco.carnation.redpackage.tools;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.market.bo.ActRedPackageBO;
import com.sinco.carnation.market.bo.RedPackageGetRecordBO;
import com.sinco.carnation.market.dao.ActRedPackageDao;
import com.sinco.carnation.market.dao.RedPackageGetRecordDao;
import com.sinco.carnation.market.model.RedPackageGetRecordExample;
import com.sinco.carnation.market.service.ActRedPackageService;
import com.sinco.carnation.pay.service.PredepositLogService;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.dao.UserMoneyDao;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.common.utils.IPUtil;

@Service
@Transactional
public class RedPackageTools {

	@Autowired
	private ActRedPackageDao actRedPackageDao;

	@Autowired
	private RedPackageGetRecordDao redPackageGetRecordDao;

	@Autowired
	private UserAccountDao dao;

	@Autowired
	private UserMoneyDao userMoneyDao;

	@Autowired
	private RedisCacheService redisCacheService;

	@Autowired
	private UserRelationService relationService;

	@Autowired
	private UserService userService;

	@Autowired
	private ActRedPackageService actRedPackageService;

	@Autowired
	private PredepositLogService predepositLogService;

	@Autowired
	private UserMoneyService userMoneyService;

	private static final String RED_COOKIE_UUID = "RED_COOKIE_UUID";// 红包cookie名称

	/**
	 * 红包状态
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public String findRedStatus(HttpServletRequest request, Long id) {
		String str = "";
		String redcookvalue = getCurrentRedCookies(request, id);
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		example.createCriteria().andCookIdEqualTo(redcookvalue).andPhoneIsNotNull().andGetTimeIsNotNull();
		List<RedPackageGetRecordBO> reds = redPackageGetRecordDao.selectByExample(example);
		if (reds != null && reds.size() > 0) {
			str = "5";// 红包已经领取
			return str;
		}
		ActRedPackageBO red = actRedPackageDao.findOne(id);
		if (red != null) {
			if (red.getIsEnabled() == 1 && red.getTotalMoney().compareTo(BigDecimal.valueOf(0.0)) == 1
					&& red.getStartTime().before(new Date()) && red.getEndTime().after(new Date())) {
				str = "0";
				return str;
			} else if (red.getIsEnabled() == 0) {
				str = "1";
				return str;
			} else if (red.getTotalMoney().compareTo(BigDecimal.valueOf(0.0)) == 0) {
				str = "2";
				return str;
			} else if (red.getTotalCount() == red.getCurrentOpenCount()) {
				str = "3";
				return str;
			} else if (red.getEndTime().before(new Date())) {
				str = "4";
				return str;
			}

		} else {
			str = "-1";
		}
		return str;
	}

	/**
	 * 红包设置cookie状态
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@Transactional
	public Map<String, String> getRedCookieStatus(HttpServletRequest request, HttpServletResponse response,
			Long id) {

		Map<String, String> map = new HashMap<String, String>();
		String money = "", redcookvalue = "";
		try {
			map.put("code", "200");
			String uuid = UUID.randomUUID().toString();
			redcookvalue = getCurrentRedCookies(request, id);
			if (!redcookvalue.trim().equals("")) {
				RedPackageGetRecordExample example = new RedPackageGetRecordExample();
				example.createCriteria().andCookIdEqualTo(redcookvalue);
				List<RedPackageGetRecordBO> reds = redPackageGetRecordDao.selectByExample(example);
				if (reds != null && reds.size() > 0) {
					RedPackageGetRecordBO red = reds.get(0);
					money = red.getMoney() + "";
				}

			} else {
				money = this.getRedActivate(request, id, uuid);
				if (!money.equals("")) {// 有抢到红包加入cookie
					Cookie cookie = new Cookie(RED_COOKIE_UUID + id, uuid);
					cookie.setMaxAge(60 * 60 * 24 * 7 * 48);// cookie1年过期(7天*4周*12月)
					cookie.setDomain(CommUtil.generic_domain(request));
					// 设置路径，这个路径即该工程下都可以访问该cookie
					// 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
					// cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
			if (money.equals("")) {
				map.put("code", "600"); // 红包抢空，cookie已经占用
			}
			map.put("money", money);
		} catch (Exception e) {
			map.put("code", "500");
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 抢红包
	 * 
	 * @return
	 */
	@Transactional
	public synchronized String getRedActivate(HttpServletRequest request, Long id, String uuid) {
		String money = "";
		boolean f = false;
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		example.createCriteria().andPackageIdEqualTo(id).andPhoneIsNull().andCookIdIsNull()
				.andUserIdEqualTo(0L);
		List<RedPackageGetRecordBO> reds = redPackageGetRecordDao.selectByExample(example);
		if (reds != null && reds.size() > 0) {
			RedPackageGetRecordBO red = reds.get(0);
			red.setCookId(uuid);
			red.setStatus((byte) 1);
			red.setOpenTime(new Date());
			red.setIp(IPUtil.getIpAddr(request));
			redPackageGetRecordDao.update(red);
			money = red.getMoney() + "";
			f = true;
		}

		ActRedPackageBO redbo = actRedPackageDao.findOne(id);
		if (redbo != null && f) {
			redbo.setCurrentOpenCount((redbo.getCurrentOpenCount() != null ? redbo.getCurrentOpenCount() + 1
					: 1));
			actRedPackageDao.update(redbo);
		}
		return money;

	}

	/**
	 * 获得红包金额
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public synchronized String getMoeny(HttpServletRequest request, Long id) {
		String money = "";
		String redcookuuid = getCurrentRedCookies(request, id);
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		example.createCriteria().andPackageIdEqualTo(id).andCookIdEqualTo(redcookuuid);
		List<RedPackageGetRecordBO> reds = redPackageGetRecordDao.selectByExample(example);
		if (reds != null && reds.size() > 0) {
			RedPackageGetRecordBO red = reds.get(0);
			money = red.getMoney() + "";
		}

		return money;

	}

	/**
	 * 红包充值给会员
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param phone
	 * @return
	 */
	@Transactional
	public synchronized String grabRedRecharge(HttpServletRequest request, HttpServletResponse response,
			Long id, String phone) {

		String redcookuuid = getCurrentRedCookies(request, id), result = "-1";// result
																				// -1，用户不存在
																				// 0，成功
																				// 1,红包不存在
																				// 2,该活动用户手机号已经抢过红包
																				// 3,该红包已经充值
		// 验证用户是否抢过红包
		RedPackageGetRecordExample example2 = new RedPackageGetRecordExample();
		example2.createCriteria().andPackageIdEqualTo(id).andPhoneEqualTo(phone);
		List<RedPackageGetRecordBO> ckecks = redPackageGetRecordDao.selectByExample(example2);
		if (ckecks != null && ckecks.size() > 0) {
			result = "2";
			return result;
		}

		// 验证红包是否过期
		RedPackageGetRecordBO vo = null;
		RedPackageGetRecordExample example = new RedPackageGetRecordExample();
		example.createCriteria().andCookIdEqualTo(redcookuuid);
		List<RedPackageGetRecordBO> reds = redPackageGetRecordDao.selectByExample(example);
		if (reds != null && reds.size() > 0) {
			vo = reds.get(0);
			if (vo.getPhone() != null) {
				result = "3";
				return result;
			}
		} else {
			result = "1";
			return result;
		}

		UserAccountBO userAccountBO = dao.queryByLoginName(phone);
		if (userAccountBO != null) {// 用户是否存在
			// 指定该红包手机号
			if (vo != null) {
				vo.setPhone(phone);
				redPackageGetRecordDao.update(vo);
			}
			vo.setGetTime(new Date());
			byte status = 2;// 已领取
			vo.setStatus(status);
			vo.setUserId(userAccountBO.getUid());
			vo.setPhone(phone);
			// 更新红包记录表(phone,status)
			int effectedNum = actRedPackageService.updateByCookieIdandPacketId(vo);
			if (effectedNum > 0) {
				// 根据红包id和用户id查询红包钱数
				RedPackageGetRecordBO redPackageGetRecordBO = actRedPackageService.findRedPackageByPhone(
						vo.getPhone(), id);

				userMoneyService.isExistAndCreate(userAccountBO.getUid());

				userMoneyDao.addMoney(userAccountBO.getUid(),
						CommUtil.null2Double(redPackageGetRecordBO.getMoney()));// 更新用户云豆信息

				double balance = userMoneyService.getAvailableBalance(userAccountBO.getUid());// 余额
				// 红包日志
				userMoneyService.addRedPredepositLog(redPackageGetRecordBO.getMoney(),
						userAccountBO.getUid(), balance);

				// 更新红包表（已领取数）
				actRedPackageService.updateActRedPackageRecordById(vo.getPackageId());

				result = "0";
			}
		}

		return result;
	}

	/**
	 * 获得当前红包Cookie值
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@Transactional
	public String getCurrentRedCookies(HttpServletRequest request, Long id) {
		String cookievalue = "";
		Cookie[] cookies = request.getCookies();// 这样便可以获取一个cookie数组
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(RED_COOKIE_UUID + id)) {
					cookievalue = c.getValue();
				}
			}
		}

		return cookievalue;

	}

}
