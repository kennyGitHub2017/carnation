package com.sinco.carnation.user.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.notice.model.NoticeMessage;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.pay.service.PredepositCashService;
import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.dao.PredepositCashDao;
import com.sinco.carnation.shop.dao.PredepositDao;
import com.sinco.carnation.shop.dao.PredepositLogDao;
import com.sinco.carnation.shop.dao.ShopBonusRepeatLogDao;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.shop.model.PredepositCash;
import com.sinco.carnation.shop.model.PredepositLog;
import com.sinco.carnation.shop.model.ShopBonusRepeatLog;
import com.sinco.carnation.shop.vo.PredepositCashVO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.orcl.CnUserMoneyBO;
import com.sinco.carnation.sys.bo.orcl.CnUserPayBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.NoticeMessageService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.UserMoneyBO;
import com.sinco.carnation.user.constant.MoneyUserTypeEnum;
import com.sinco.carnation.user.dao.PrepareMoneyLogDao;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.dao.UserMoneyDao;
import com.sinco.carnation.user.dao.UserMoneyLogDao;
import com.sinco.carnation.user.exception.MoneyPasswordNullConsumption;
import com.sinco.carnation.user.model.PrepareMoneyLog;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.model.UserMoney;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class UserMoneyService {

	private static final Logger logger = LoggerFactory.getLogger(UserMoneyService.class);

	@Autowired
	private PredepositDao predepositDao;

	@Autowired
	private PredepositLogDao predepositLogDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserMoneyDao moneyDao;

	@Autowired
	private PredepositCashDao predepositCashDao;

	@Autowired
	private UserCustomerDao customerDao;

	@Autowired
	private MsgTools msgTools;

	@Autowired
	private NoticeMessageService noticeMessageService;

	@Autowired
	private CnPayBaseService cnPayBaseService;
	@Autowired
	private UserAccountDao userAccountDao;
	@Autowired
	private ShopBonusRepeatLogDao shopBonusRepeatLogDao;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private UserMoneyLogDao userMoneyLogDao;

	@Autowired
	private PrepareMoneyLogDao prepareMoneyLogDao;

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private UserCustomerService userCustomerService;

	@Autowired
	private PredepositCashService predepositCashService;

	@Autowired
	private SellerService sellerService;

	/**
	 * 
	 * @Title: userCashApply @Description: TODO(提现申请) @param @param userId @param @param vo @param @return @param @throws
	 *         ServiceException 设定文件 @return String 返回类型 @author Tang @throws
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String userCashApply(Long userId, PredepositCashVO vo) throws ServiceException {
		// 验证余额
		double money = this.getAvailableBalance(userId);
		if (money < vo.getCashAmount()) {
			throw new ServiceException("对不起，余额不足!");
		}
		// 是否CN账号
		UserAccount account = userAccountService.findByUid(userId, UserContant.ACCOUNT_TYPE_8);
		// 验证密码
		boolean falg = false;
		/*if(operatorBO != null){
			UserAccount account = userAccountService.findByUid(userId, UserContant.ACCOUNT_TYPE_8);
			int isPay = cnPayBaseService.validatPassword2(operatorBO.getCn_username(), vo.getCashPassword()).getISPAY();
			falg =isPay==1?true:false;*/
		if (account != null) {
			OperatorBO operatorBO = operatorService.getOperatorBOByUserId(userId);// 是否运营商
			String loginName = account.getLoginName();
			if (operatorBO != null) {
				loginName = operatorBO.getCn_username();
			}
			int isPay = cnPayBaseService.validatPassword2(loginName, vo.getCashPassword()).getISPAY();
			falg = isPay == 1 ? true : false;
		} else {
			falg = this.validatePassword(userId, vo.getCashPassword());
		}
		if (!falg) {
			throw new ServiceException("对不起，提现密码不正确!");
		}

		PredepositCash obj = new PredepositCash();
		obj.setCashPayment(vo.getCashPayment());
		obj.setCashAccount(vo.getCashAccount());
		obj.setCashUserName(vo.getCashUserName());
		obj.setCashBank(vo.getCashBank());
		obj.setCashAmount(BigDecimal.valueOf(CommUtil.null2Double(vo.getCashAmount())));
		obj.setCashInfo(vo.getCashInfo());
		obj.setCashSn("cash" + CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + userId);
		obj.setAddTime(new Date());
		obj.setCashUserId(userId);
		obj.setCashStatus(0);
		obj.setCashPayStatus(0);
		obj.setCashRelation(vo.getCashRelation());
		obj.setCashSubbranch(vo.getCashSubbranch());
		PredepositCash result = this.predepositCashDao.save(obj);
		if (result.getId() != null) {

			// 保存提现日志
			PredepositLog log = new PredepositLog();
			log.setAddTime(new Date());
			log.setPdLogAmount(BigDecimal.ZERO.subtract(new BigDecimal(String.valueOf(vo.getCashAmount()))));
			log.setPdLogInfo("申请提现");
			log.setPdLogUserId(userId);
			log.setPdOpType(UserContants.PD_OP_TYPE_WITHDRAW);
			log.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
			log.setPredepositId(result.getId());
			predepositLogDao.save(log);
			// 减去金额
			this.subtractMoney(userId, new BigDecimal(String.valueOf(vo.getCashAmount())), null, log,null,0.00);

		}
		return "提现申请成功!";
	}

	/**
	 * 
	 * @Title: resource 会员端、 merchant 商户端、supplier 供应商端 、YY 运营商
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String userCashApplyV2(Long userId, PredepositCashVO vo, String source) throws ServiceException {
		if (userId == null || source == null || vo == null) {
			return "提现申请失败!";
		}
		String userCode = UserContant.accountTypeToUserCode(source);
		double poundage = 0;// 手续费
		double money = 0;// 余额
		double cashAmount = 0;
		String logInfo = "申请提现";// 提现log info信息
		// 是否CN账号
		UserAccount account = userAccountService.findByUid(userId, UserContant.ACCOUNT_TYPE_8);
		// 验证密码
		boolean falg = false;
		if (source.equals(UserContant.USER_CODE_CN) && account != null) {// CN运营商登录 取CN账号密码
			OperatorBO operatorBO = operatorService.getOperatorBOByUserId(userId);// 是否运营商
			String loginName = account.getLoginName();
			if (operatorBO != null) {
				source = UserContant.ACCOUNT_TYPE_CN;// 申请提现的用户是CN运营商
				loginName = operatorBO.getCn_username();
			}
			int isPay = cnPayBaseService.validatPassword2(loginName, vo.getCashPassword()).getISPAY();
			falg = isPay == 1 ? true : false;
		} else {// 其他方式登录 取其他密码
			falg = this.validatePasswordV2(userId, vo.getCashPassword(), source);
		}
		if (!falg) {
			throw new ServiceException("对不起，提现密码不正确!");
		}

		// 验证余额
//		this.verifyBalance(userId, source , vo.getCashAmount());
		money = this.getMoneyByUidAndSource(userId, source);
		if (money < vo.getCashAmount()) {
			throw new ServiceException("对不起，余额不足!");
		}
		cashAmount = vo.getCashAmount();
		double FreePoundage = predepositCashService.getFreePoundage(userId, source);
		if (vo.getCashAmount() > FreePoundage && FreePoundage != 0
				&& userCode.equals(UserContant.USER_CODE_USER)) {// 提现金额超过免费额度 免费提现部分和收费提现部分区分开
			PredepositCash obj = new PredepositCash();
			obj.setCashPayment(vo.getCashPayment());
			obj.setCashAccount(vo.getCashAccount());
			obj.setCashUserName(vo.getCashUserName());
			obj.setCashBank(vo.getCashBank());
			obj.setCashAmount(BigDecimal.valueOf(FreePoundage));
			obj.setCashInfo("免手续费部分提现");
			obj.setCashSn("cash" + CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + userId);
			obj.setAddTime(new Date());
			obj.setCashUserId(userId);
			obj.setCashStatus(0);
			obj.setCashPayStatus(0);
			obj.setCashRelation(vo.getCashRelation());
			obj.setCashSubbranch(vo.getCashSubbranch());
			obj.setUserCode(Integer.valueOf(userCode));
			obj.setCashPoundage(BigDecimal.valueOf(poundage));
			this.predepositCashDao.save(obj);
			vo.setCashAmount(vo.getCashAmount() - FreePoundage);// 免费提现和收费提现区分开
		}
		// 获取手续费
		if (userCode.equals(UserContant.USER_CODE_USER)) {
			poundage = predepositCashService.getPoundage(userId, source,
					BigDecimal.valueOf(CommUtil.null2Double(vo.getCashAmount())));
			logInfo = "申请提现,手续费" + poundage + "元";
		}
		PredepositCash obj = new PredepositCash();
		obj.setCashPayment(vo.getCashPayment());
		obj.setCashAccount(vo.getCashAccount());
		obj.setCashUserName(vo.getCashUserName());
		obj.setCashBank(vo.getCashBank());
		obj.setCashAmount(BigDecimal.valueOf(CommUtil.null2Double(vo.getCashAmount())));
		obj.setCashInfo(vo.getCashInfo());
		obj.setCashSn("cash" + CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + userId);
		obj.setAddTime(new Date());
		obj.setCashUserId(userId);
		obj.setCashStatus(0);
		obj.setCashPayStatus(0);
		obj.setCashRelation(vo.getCashRelation());
		obj.setCashSubbranch(vo.getCashSubbranch());
		obj.setUserCode(Integer.valueOf(userCode));
		obj.setCashPoundage(BigDecimal.valueOf(poundage));
		PredepositCash result = this.predepositCashDao.save(obj);
		if (result.getId() != null) {
			// 保存提现日志
			PredepositLog log = new PredepositLog();
			log.setAddTime(new Date());
			log.setPdLogAmount(BigDecimal.ZERO.subtract(new BigDecimal(String.valueOf(cashAmount - poundage))));
			log.setPdLogInfo(logInfo);
			log.setPdLogUserId(userId);
			log.setPdOpType(UserContants.PD_OP_TYPE_WITHDRAW);
			log.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
			log.setPredepositId(result.getId());
			log.setUserCode(Long.valueOf(userCode));

			if (poundage > 0) {
				PredepositLog poundageLog = new PredepositLog();
				poundageLog.setAddTime(new Date());
				poundageLog
						.setPdLogAmount(BigDecimal.ZERO.subtract(new BigDecimal(String.valueOf(poundage))));
				poundageLog.setPdLogInfo(logInfo);
				poundageLog.setPdLogUserId(userId);
				poundageLog.setPdOpType(UserContants.PD_OP_TYPE_WITHDRAW_POUNDAGE);
				poundageLog.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
				poundageLog.setPredepositId(result.getId());
				poundageLog.setUserCode(Long.valueOf(userCode));
				// 减去金额
				this.subtractMoney(userId, new BigDecimal(String.valueOf(cashAmount)), source, log,
						poundageLog, poundage);
			} else {
				this.subtractMoney(userId, new BigDecimal(String.valueOf(cashAmount)), source, log, null,
						poundage);
			}
		}
		return "提现申请成功!";
	}

	/**
	 * 验证余额
	 * 
	 * @param uid
	 *            用户uid @param source 用户登录source @param cashAmount 变动金额
	 **/
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void verifyBalance(Long uid, String source, double cashAmount) throws ServiceException {
		if (StringUtils.isBlank(source)) {
			source = UserContant.ACCOUNT_TYPE_RESOURCE;
		}
		if (cashAmount < 0) {
			cashAmount = -cashAmount;
		}
		UserMoneyBO bo = this.findUserMoneyByUid(uid);
		if (bo != null) {
			switch (source) {
				case UserContant.ACCOUNT_TYPE_RESOURCE:// 个人
					if (bo.getAvailableBalance().doubleValue() < cashAmount) {
						throw new ServiceException("对不起，余额不足!");
					}
					break;
				case UserContant.ACCOUNT_TYPE_SUPPLIER:// 供应商
					if (bo.getB2cBalance().doubleValue() < cashAmount) {
						throw new ServiceException("对不起，余额不足!");
					}
					break;
				case UserContant.ACCOUNT_TYPE_MERCHANT:// 商户
					if (bo.getO2oBalance().doubleValue() < cashAmount) {
						throw new ServiceException("对不起，余额不足!");
					}
					break;
				case UserContant.ACCOUNT_TYPE_YY:// YY运营商
					if (bo.getAvailableBalance().doubleValue() < cashAmount) {
						throw new ServiceException("对不起，余额不足!");
					}
					break;
				default:// CN运营商
					if (bo.getYysBalance().doubleValue() < cashAmount) {
						throw new ServiceException("对不起，余额不足!");
					}
					break;
			}
		} else {
			throw new ServiceException("无法查询用户信息,请稍候再试");
		}
	}

	/**
	 * 获取余额
	 * 
	 * @param uid
	 *            用户uid @param source 用户登录source
	 **/
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public double getMoneyByUidAndSource(Long uid, String source) {
		double result = 0.00;
		if (StringUtils.isBlank(source)) {
			source = UserContant.ACCOUNT_TYPE_RESOURCE;
		}
		UserMoneyBO bo = this.findUserMoneyByUid(uid);
		if (bo != null) {
			switch (source) {
				case UserContant.ACCOUNT_TYPE_RESOURCE:// 个人
					result = bo.getAvailableBalance().doubleValue();
					break;
				case UserContant.ACCOUNT_TYPE_SUPPLIER:// 供应商
					result = bo.getB2cBalance().doubleValue();
					break;
				case UserContant.ACCOUNT_TYPE_MERCHANT:// 商户
					result = bo.getO2oBalance().doubleValue();
					break;
				case UserContant.ACCOUNT_TYPE_YY:// YY运营商
					result = bo.getAvailableBalance().doubleValue();
					break;
				default:// CN运营商
					result = bo.getYysBalance().doubleValue();
					break;
			}
		}
		return result;
	}

	// /**
	// * app提现
	// *
	// * @param uid
	// * @param vo
	// */
	// @Transactional(readOnly = false)
	// public int predepositCashApp(Long uid, PredepositCashVO vo)throws
	// ServiceException {
	// int ret = 100;
	// // 验证余额
	// double money = this.getAvailableBalance(uid);
	// if (money < vo.getCashAmount()) {
	// return 200;
	// }
	// // 验证密码
	// boolean falg = this.validatePassword(uid, vo.getCashPassword());
	// if (!falg) {
	// return 300;
	// }
	//
	// PredepositCash obj = new PredepositCash();
	// obj.setCashPayment(vo.getCashPayment());
	// obj.setCashAccount(vo.getCashAccount());
	// obj.setCashUserName(vo.getCashUserName());
	// obj.setCashBank(vo.getCashBank());
	// obj.setCashAmount(BigDecimal.valueOf(CommUtil.null2Double(vo.getCashAmount())));
	// obj.setCashInfo(vo.getCashInfo());
	// obj.setCashSn("cash" + CommUtil.formatTime("yyyyMMddHHmmss", new Date())
	// + uid);
	// obj.setAddTime(new Date());
	// obj.setCashUserId(uid);
	// obj.setCashStatus(0);
	// obj.setCashPayStatus(0);
	// this.predepositCashDao.save(obj);
	//
	// return ret;
	// }

	/**
	 * 验证密码
	 * 
	 * @param uid
	 * @param password
	 * @return
	 */
	public boolean validatePassword(Long uid, String password) {
		UserMoney money = this.isExistAndCreate(uid);
		// 是否CN账号
		UserAccount account = userAccountService.findByUid(uid, UserContant.ACCOUNT_TYPE_8);
		// 验证密码
		boolean falg = false;
		/*if(operatorBO != null){
			UserAccount account = userAccountService.findByUid(userId, UserContant.ACCOUNT_TYPE_8);
			int isPay = cnPayBaseService.validatPassword2(operatorBO.getCn_username(), vo.getCashPassword()).getISPAY();
			falg =isPay==1?true:false;*/
		if (account != null) {
			OperatorBO operatorBO = operatorService.getOperatorBOByUserId(uid);// 是否运营商
			String loginName = account.getLoginName();
			if (operatorBO != null) {
				loginName = operatorBO.getCn_username();
			}
			int isPay = cnPayBaseService.validatPassword2(loginName, password).getISPAY();
			falg = isPay == 1 ? true : false;
		} else {
			if (StringUtils.isBlank(money.getPassword())) {
				return false;
			}
			falg = PasswordUtils.validatePassword(password, money.getPassword());
		}

		return falg;
	}

	/**
	 * 验证密码
	 * 
	 * @param uid
	 * @param password
	 * @return
	 */
	public boolean validatePasswordV2(Long uid, String password, String source) {
		if (StringUtils.isBlank(source)) {
			source = UserContant.ACCOUNT_TYPE_RESOURCE;
		}
		UserMoney money = this.isExistAndCreate(uid);
		// 是否CN账号
		UserAccount account = userAccountService.findByUid(uid, UserContant.ACCOUNT_TYPE_8);
		// 验证密码
		boolean falg = false;
		if (account != null) {
			OperatorBO operatorBO = operatorService.getOperatorBOByUserId(uid);// 是否运营商
			String loginName = account.getLoginName();
			if (operatorBO != null) {
				loginName = operatorBO.getCn_username();
			}
			int isPay = cnPayBaseService.validatPassword2(loginName, password).getISPAY();
			falg = isPay == 1 ? true : false;
		} else {
			switch (source) {
				case UserContant.ACCOUNT_TYPE_RESOURCE:// 个人
					if (StringUtils.isBlank(money.getPassword())) {
						return false;
					}
					falg = PasswordUtils.validatePassword(password, money.getPassword());
					break;
				case UserContant.ACCOUNT_TYPE_MERCHANT:// 商户
					if (StringUtils.isBlank(money.getO2oPassword())) {
						return false;
					}
					falg = PasswordUtils.validatePassword(password, money.getO2oPassword());
					break;
				case UserContant.ACCOUNT_TYPE_SUPPLIER:// 供应商
					if (StringUtils.isBlank(money.getB2cPassword())) {
						return false;
					}
					falg = PasswordUtils.validatePassword(password, money.getB2cPassword());
					break;
				case UserContant.ACCOUNT_TYPE_YY:// YY运营商--YY运营商账号是独立的 使用和个人的一样的字段可以减少运营商逻辑修改
					if (StringUtils.isBlank(money.getPassword())) {
						return false;
					}
					falg = PasswordUtils.validatePassword(password, money.getPassword());
					break;

				default:// CN运营商
					if (StringUtils.isBlank(money.getYysPassword())) {
						return false;
					}
					falg = PasswordUtils.validatePassword(password, money.getYysPassword());
					break;
			}

		}

		return falg;
	}

	/**
	 * 是否设置过密码
	 * 
	 * @param uid
	 * @return
	 */
	public boolean isPasswordNull(Long uid) {
		UserMoney userMoney = moneyDao.get(uid);
		if (userMoney == null) {
			return true;
		}
		return StringUtils.isBlank(userMoney.getPassword());
	}

	/**
	 * 是否设置过密码
	 * 
	 * @param uid
	 * @param source
	 * @return
	 */
	public boolean isPasswordNull(Long uid, String source) {
		if (StringUtils.isBlank(source)) {
			source = UserContant.ACCOUNT_TYPE_RESOURCE;
		}
		UserMoney userMoney = moneyDao.get(uid);
		if (userMoney == null) {
			return true;
		}
		boolean result = true;
		switch (source) {
			case UserContant.ACCOUNT_TYPE_RESOURCE:// 个人
				result = StringUtils.isBlank(userMoney.getPassword());
				break;
			case UserContant.ACCOUNT_TYPE_SUPPLIER:// 供应商
				result = StringUtils.isBlank(userMoney.getB2cPassword());
				break;
			case UserContant.ACCOUNT_TYPE_MERCHANT:// 商户
				result = StringUtils.isBlank(userMoney.getO2oPassword());
				break;
			case UserContant.ACCOUNT_TYPE_YY:// YY账号
				result = StringUtils.isBlank(userMoney.getPassword());
				break;
			default:// 运营商
				result = StringUtils.isBlank(userMoney.getYysPassword());
				break;
		}
		return result;
	}

	/**
	 * 得到用户云豆
	 * 
	 * @param uid
	 * @return
	 */
	public double getAvailableBalance(Long uid) {
		UserMoney userMoney = moneyDao.get(uid);
		if (userMoney == null) {
			return 0;
		}
		return userMoney.getAvailableBalance().doubleValue();
	}

	/**
	 * 消费云豆,检查密码
	 * 
	 * @param amount
	 * @param pdLogInfo
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean consumptionMoney(Long uid, double amount, String password, String pdLogInfo)
			throws ServiceException {

		User user = this.userDao.findById(uid);
		if (null == user) {
			return false;
		}

		UserMoney money = this.isExistAndCreate(uid);

		// 用户支付密码是否为空
		if (StringUtils.isBlank(money.getPassword())) {
			throw new MoneyPasswordNullConsumption();
		}

		if (!PasswordUtils.validatePassword(password, money.getPassword())) {
			throw new ServiceException("支付密码错误!");
		}

		return consumptionMoney(uid, amount, pdLogInfo);
	}

	/**
	 * 消费云豆
	 * 
	 * @param amount
	 * @param pdLogInfo
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean consumptionMoney(Long uid, double amount, String pdLogInfo) throws ServiceException {
		BigDecimal amountDecimal = BigDecimal.valueOf(amount);

		if (this.moneyDao.countByUid(uid, amountDecimal) <= 0) {
			return false;
			// throw new ServiceException("用户云豆不足，无法完成支付!");
		}

		PredepositLog log = new PredepositLog();
		log.setAddTime(new Date());
		log.setPdLogAmount(amountDecimal.multiply(BigDecimal.valueOf(-1L)));
		log.setPdLogUserId(uid);
		log.setPdOpType(UserContants.PD_OP_TYPE_CONSUMPTION);
		log.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
		log.setPdLogInfo(pdLogInfo);
		this.predepositLogDao.save(log);

		this.subtractMoney(uid, amountDecimal, null, log,null,0.00);

		// 消费云豆进行消息通知推送
		try {
			// 更新消息推送日志
			NoticeMessage noticeMesg = new NoticeMessage();
			noticeMesg.setUid(uid);
			noticeMesg.setCreateTime(new Date());
			noticeMesg.setNotcieLogAmount(new BigDecimal(-amount));
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			String message = "您于" + date + "消费" + amount + "云豆";
			noticeMesg.setNoticeMessage(message);
			noticeMesg.setPushType("cloudMoney");

			/*noticeMessageService.save(noticeMesg);
			noticeMessageService.pushMessage(noticeMesg);*/
			logger.info("用户" + uid + ":云豆消费通知推送成功");
		} catch (Exception e) {
			logger.error("云豆消费日志推送失败" + e.getStackTrace());
		}

		return true;
	}

	/**
	 * 提现扣钱----没使用的方法
	 * 
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void cashMoney(String cash_admin_info, int cash_status, int cash_pay_status, Long cashId,
			Long adminId) throws ServiceException {
		PredepositCashBO cashBO = predepositCashDao.get(cashId);
		if (cashBO.getCashPayStatus() == 1)// 已经提现
			return;
		// 更改提现申请状态
		if (cash_pay_status == 1) {// 扣钱
			cash_status = 1;
			if (this.moneyDao.countByUid(cashBO.getCashUserId(), cashBO.getCashAmount()) <= 0) {
				throw new ServiceException("用户云豆不足，无法完成提现!");
			}
			// 日志记录
			PredepositLog log = new PredepositLog();
			log.setAddTime(new Date());
			log.setPdLogAmount(cashBO.getCashAmount().multiply(new BigDecimal(-1)));
			log.setPdLogInfo("申请提现审核通过");
			log.setPdLogAdminId(adminId);
			log.setPdOpType(UserContants.PD_OP_TYPE_WITHDRAW);
			log.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
			log.setPredepositId(cashId);
			log.setPdLogUserId(cashBO.getCashUserId());
			// 减去金额
			this.subtractMoney(cashBO.getCashUserId(), cashBO.getCashAmount(), null, log,null,0.00);

			UserCustomer customer = customerDao.findById(cashBO.getCashUserId());
			logger.info("[cashMoney] mobile=" + customer.getMobile() + " , Amount="
					+ cashBO.getCashAmount().toString() + "??"
					+ cashBO.getCashAccount().substring(cashBO.getCashAccount().length() - 2));
			msgTools.sendSms("sms_toseller_deposit_audit_success_notify", customer.getMobile(), cashBO
					.getCashAmount().toString(),
					cashBO.getCashAccount().substring(cashBO.getCashAccount().length() - 2));

		}
		cashBO.setCashAdminId(adminId);
		cashBO.setCashPayStatus(cash_pay_status);
		cashBO.setCashStatus(cash_status);
		cashBO.setCashAdminInfo(cash_admin_info);
		predepositCashDao.update(cashBO);

		/*
		 * //消费云豆进行消息通知推送 try { //更新消息推送日志 NoticeMessage noticeMesg = new
		 * NoticeMessage(); noticeMesg.setUid(uid); noticeMesg.setCreateTime(new
		 * Date()); noticeMesg.setNotcieLogAmount(new BigDecimal(-amount));
		 * String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new
		 * Date()); String message = "您于" + date + "消费"+amount+"云豆";
		 * noticeMesg.setNoticeMessage(message);
		 * noticeMesg.setPushType("cloudMoney");
		 * 
		 * noticeMessageService.save(noticeMesg);
		 * noticeMessageService.pushMessage(noticeMesg);
		 * logger.info("用户"+uid+":云豆消费通知推送成功"); } catch (Exception e) {
		 * logger.error("云豆消费日志推送失败"+e.getStackTrace()); }
		 */

	}

	/**
	 * 增加用户云豆
	 * 
	 * @param uid
	 *            用户ID
	 * @param amount
	 *            云豆数量
	 * @param adminId
	 *            操作者
	 * @param pdOpType
	 *            类型
	 * @param info
	 *            信息
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean addMoney(Long uid, double amount, Long adminId, String pdOpType, String info) {
		User user = this.userDao.findById(uid);
		if (user == null) {
			return false;
		}
		isExistAndCreate(uid);
		if (moneyDao.addMoney(uid, amount) < 1) {
			logger.error("add money error, uid =" + uid);
			return false;
		}
		double balance = moneyDao.get(uid).getAvailableBalance().doubleValue();// 余额
		PredepositLog log = new PredepositLog();
		log.setPdLogAdminId(adminId);
		log.setAddTime(new Date());
		log.setPdLogAmount(new BigDecimal(amount));
		log.setBalance(BigDecimal.valueOf(balance));
		log.setPdLogInfo(info);
		log.setPdLogUserId(uid);
		log.setPdOpType(pdOpType);
		log.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
		predepositLogDao.save(log);
		return true;
	}

	/**
	 * 创建云豆充值
	 * 
	 * @param predeposit
	 * @param uid
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long rechargeMoneySave(Predeposit predeposit, Long uid) throws ServiceException {

		if (predeposit.getId() == null) {
			predeposit.setPdSn("pd" + CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + uid);
			predeposit.setAddTime(new Date());
			predeposit.setPdStatus(UserContants.PD_STATUS_0);
		}

		this.predepositDao.save(predeposit);

		// 产生支付id
		String tradeNo = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
		predeposit.setPdNo("pd-" + tradeNo + "-" + predeposit.getId().toString());

		this.predepositDao.save(predeposit);
		Long id = predeposit.getId();

		this.rechargeMoney(id, "后台调整");

		return id;
	}

	/**
	 * 充值
	 * 
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Predeposit rechargeMoney(Long pid, String pdLogInfo) throws ServiceException {

		Predeposit predeposit = this.predepositDao.get(pid);

		if (predeposit == null) {
			throw new ServiceException("未找到充值记录！");
		}

		if (predeposit.getPdPayStatus() == UserContants.PD_PAY_STATUS_2) {
			return predeposit;
		}

		predeposit.setPdStatus(UserContants.PD_STATUS_1);
		predeposit.setPdPayStatus(UserContants.PD_PAY_STATUS_2);
		this.predepositDao.update(predeposit);

		User user = this.userDao.findById(predeposit.getPdUserId());
		if (user != null) {

			isExistAndCreate(user.getId());

			moneyDao.addMoney(user.getId(), predeposit.getPdAmount().doubleValue());

			double balance = moneyDao.get(user.getId()).getAvailableBalance().doubleValue();// 余额

			PredepositLog log = new PredepositLog();
			log.setAddTime(new Date());
			log.setPdLogAmount(predeposit.getPdAmount());
			log.setBalance(BigDecimal.valueOf(balance));
			log.setPdLogUserId(user.getId());
			log.setPdOpType(UserContants.PD_OP_TYPE_RECHARGE);
			log.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
			log.setPdLogInfo(pdLogInfo);
			this.predepositLogDao.save(log);
			// 个人端除春雨医生推送消息，其它都关闭2017-05-26 tw
			/*
			try {
				// 更新消息推送日志
				NoticeMessage noticeMesg = new NoticeMessage();
				noticeMesg.setUid(user.getId());
				noticeMesg.setCreateTime(new Date());
				noticeMesg.setNotcieLogAmount(new BigDecimal(predeposit.getPdAmount().doubleValue()));
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				String message = "您于" + date + "充值" + predeposit.getPdAmount().doubleValue() + "云豆";
				noticeMesg.setNoticeMessage(message);
				noticeMesg.setPushType("cloudMoney");

				noticeMessageService.save(noticeMesg);
				noticeMessageService.pushMessage(noticeMesg);
				logger.info("用户" + user.getId() + ":云豆消费通知推送成功");
			} catch (Exception e) {
				logger.error("云豆消费日志推送失败" + e.getStackTrace());
			}
			 */
		}

		return predeposit;
	}

	/**
	 * 修改密码
	 * 
	 * @param uid
	 * @param password
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updatePassword(Long uid, String password) {
		isExistAndCreate(uid);

		UserMoney um = new UserMoney();
		um.setUid(uid);
		um.setPassword(PasswordUtils.entryptPassword(password));
		moneyDao.update(um);
		return true;
	}

	/**
	 * 根据角色标识修改密码
	 * 
	 * @param uid
	 * @param password
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updatePassword(Long uid, String password, String source) {
		isExistAndCreate(uid);
		UserMoney um = new UserMoney();
		um.setUid(uid);
		setPasswordToSource(password, source, um);
		moneyDao.update(um);
		return true;
	}

	private void setPasswordToSource(String password, String source, UserMoney um) {
		// 不同角色修改对应的密码
		switch (source) {
			case UserContant.ACCOUNT_TYPE_RESOURCE:
				um.setPassword(PasswordUtils.entryptPassword(password));
				break;
			case UserContant.ACCOUNT_TYPE_MERCHANT:
				um.setO2oPassword(PasswordUtils.entryptPassword(password));
				break;
			case UserContant.ACCOUNT_TYPE_SUPPLIER:
				um.setB2cPassword(PasswordUtils.entryptPassword(password));
				break;
			case UserContant.ACCOUNT_TYPE_YY:
				um.setYysPassword(PasswordUtils.entryptPassword(password));
				break;
			default:
				um.setPassword(PasswordUtils.entryptPassword(password));
				break;
		}
	}

	/**
	 * 判断是否存在，不存在创建
	 * 
	 * @param uid
	 */
	public UserMoney isExistAndCreate(Long uid) {

		UserMoney userMoney = moneyDao.get(uid);

		if (userMoney == null) {
			userMoney = new UserMoney();
			userMoney.setUid(uid);
			userMoney.setAvailableBalance(new BigDecimal(0));
			// 空密码
			moneyDao.create(userMoney);
		}
		return userMoney;
	}

	public UserMoneyBO findUserMoneyByUid(Long uid) {
		return moneyDao.findOne(uid);
	}

	/**
	 * 管理员审核体现申请
	 * 
	 * @param userId
	 *            当前登录用户（管理员）
	 * @param cashId
	 *            体现记录ID
	 * @param memo
	 *            管理员备注
	 * @param cashStatus
	 *            操作体现状态
	 * @param cashPayStatus
	 *            操作支付状态
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public synchronized void audit(Long userId, Long cashId, String memo, int cashStatus) throws ServiceException {
			PredepositCashBO cashBO = predepositCashDao.get(cashId);
			/** 用户角色标识 0.个人 1.供应商 2.商户 3.CN运营商 4.YY运营商 **/
			String source = UserContant.accountUserCodeToType(String.valueOf(cashBO.getUserCode()));
			if (null == cashBO || cashBO.getCashStatus() == -1)// 已经提现
				throw new ServiceException("参数有误");
			if (cashStatus == -1) {// 审核拒绝
				if (StringUtils.isEmpty(memo)) {
					throw new ServiceException("审核拒绝时，备注必填");
				}
				if (/*!addMoney(cashBO.getCashUserId(), cashBO.getCashAmount().doubleValue(), userId,
						UserContants.PD_OP_TYPE_WITHDRAW, "提现申请被拒绝")*/
				!addMoneyV2(cashBO.getCashUserId(), cashBO.getCashAmount().doubleValue(), userId,
						UserContants.PD_OP_TYPE_WITHDRAW, "提现申请被拒绝", source)) {
					throw new ServiceException("审核失败");
				}
			}

			cashBO.setCashAdminId(userId);
			// cashBO.setCashPayStatus(cashPayStatus);
			cashBO.setCashStatus(cashStatus);
			cashBO.setCashAdminInfo(memo);

			predepositCashDao.update(cashBO);
			// 消费提现成功进行消息通知推送
			/*try {
				// 更新消息推送日志
				NoticeMessage noticeMesg = new NoticeMessage();
				noticeMesg.setUid(cashBO.getCashUserId());
				noticeMesg.setCreateTime(new Date());
				noticeMesg.setNotcieLogAmount(new BigDecimal(cashBO.getCashAmount().doubleValue()));
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				String message = "您于" + date + "提现" + cashBO.getCashAmount().doubleValue() + "云豆";
				noticeMesg.setNoticeMessage(message);
				noticeMesg.setPushType("cloudMoney");
			
				noticeMessageService.save(noticeMesg);
				noticeMessageService.pushMessage(noticeMesg);
				logger.info("[audit] user:" + cashBO.getCashUserId() + ":云豆提现通知推送成功");
				
				
			} catch (Exception e) {
				logger.error("[audit] sendMessage error uid = " + cashBO.getCashUserId() );
				logger.error("[audit] sendMessage error" + e.getStackTrace());
			}*/

			Long uid = cashBO.getCashUserId();
			try {
				// 发送提现短信
				if (cashStatus != -1) {
					UserAccount userAccount = userAccountService.findByUid(uid, UserContant.ACCOUNT_TYPE_2);
					logger.info("[cashMoney] mobile=" + userAccount.getLoginName() + " , Amount="
							+ cashBO.getCashAmount().toString() + "??"
							+ cashBO.getCashAccount().substring(cashBO.getCashAccount().length() - 2));
					msgTools.sendSms("sms_toseller_deposit_audit_success_notify", userAccount.getLoginName(),
							cashBO.getCashAmount().toString(),
							cashBO.getCashAccount().substring(cashBO.getCashAccount().length() - 2));
				}
			} catch (Exception e) {
				logger.error("[audit] sendSms error uid = " + uid);
				logger.error("[audit] sendSms error" + e.getStackTrace());
			}
	}

	/**
	 * 红包日志
	 * 
	 * @param amount
	 * @param uid
	 * @param balance
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addRedPredepositLog(BigDecimal amount, Long uid, double balance) {
		PredepositLog log = new PredepositLog();
		log.setAddTime(new Date());
		log.setPdLogAmount(amount);
		log.setPdLogInfo("红包收入");
		log.setPdLogUserId(uid);
		log.setPdOpType("抢红包");
		log.setPdType("可用云豆");
		log.setBalance(BigDecimal.valueOf(balance));
		predepositLogDao.save(log);
	}

	/**
	 * 消费云豆,检查密码 云豆不足，奖金调用
	 * 
	 * @param amount
	 *            总金额
	 * @param pdLogInfo
	 * @throws ServiceException
	 * @param availableBalance
	 *            云豆账户余额
	 * @param pdAmount
	 *            还需要支付的费用
	 */
	@SuppressWarnings("unused")
	public boolean consumptionMoney2(Long uid, double amount, String password, String pdLogInfo,
			String bonusPassword, BigDecimal availableBalance, BigDecimal pdAmount, String orderId)
			throws ServiceException {

		User user = this.userDao.findById(uid);
		if (null == user) {
			return false;
		}

		UserMoney money = this.isExistAndCreate(uid);// 查询个人账户

		return consumptionMoney2(uid, amount, pdLogInfo, availableBalance, pdAmount, orderId, bonusPassword);
	}

	/**
	 * 消费云豆 和 奖金
	 * 
	 * @param amount
	 * @param pdLogInfo
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean consumptionMoney2(Long uid, double amount, String pdLogInfo, BigDecimal availableBalance,
			BigDecimal pdAmount, String orderId, String bonusPassword) throws ServiceException {
		// BigDecimal amountDecimal = BigDecimal.valueOf(amount);
		if (availableBalance.compareTo(new BigDecimal(0)) > 0) {
			PredepositLog log = new PredepositLog();
			log.setAddTime(new Date());
			log.setPdLogAmount(availableBalance.multiply(BigDecimal.valueOf(-1L)));
			log.setPdLogUserId(uid);
			log.setPdOpType(UserContants.PD_OP_TYPE_CONSUMPTION);
			log.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
			log.setPdLogInfo(pdLogInfo);
			this.subtractMoney(uid, availableBalance, null, log,null,0.00); // 扣除云豆
		}
		UserAccountBO vo = new UserAccountBO();// 奖金支付
		vo.setUid(uid);
		vo.setAccountType("8");
		UserAccountBO account = this.userAccountDao.findAccountByVo(vo);
		CnUserPayBO cnUserPayBO = this.cnPayBaseService.OrderPay(1, account.getLoginName(), orderId,
				pdAmount, bonusPassword, "");
		if (cnUserPayBO.getISPAY().equals("0")) {
			throw new ServiceException("支付失败");
		}

		// 添加云购币/奖金 日志 信息[shop_bonus_log]
		ShopBonusRepeatLog record = new ShopBonusRepeatLog();
		record.setDateTime(new Date());
		record.setOrderId(orderId);
		record.setPayType(1);
		record.setReturnTracNo(cnUserPayBO.getDEAL_NUMBER());
		record.setTotalPrice(CommUtil.null2BigDecimal(amount));
		record.setType(0);
		record.setUid(uid);
		record.setUsedBonusPrice(pdAmount);
		record.setUserAlias(account.getLoginName());
		this.shopBonusRepeatLogDao.save(record);

		// shop_predeposit_log/shop_predeposit_log

		// 消费云豆进行消息通知推送
		try {
			// 更新消息推送日志
			NoticeMessage noticeMesg = new NoticeMessage();
			noticeMesg.setUid(uid);
			noticeMesg.setCreateTime(new Date());
			noticeMesg.setNotcieLogAmount(new BigDecimal(-amount));
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			String message = "您于" + date + "消费" + amount + "云豆";
			noticeMesg.setNoticeMessage(message);
			noticeMesg.setPushType("cloudMoney");

			/*		noticeMessageService.save(noticeMesg);
					noticeMessageService.pushMessage(noticeMesg);*/
			logger.info("用户" + uid + ":云豆消费通知推送成功");
		} catch (Exception e) {
			logger.error("云豆消费日志推送失败" + e.getStackTrace());
		}

		return true;
	}

	/**
	 * 得到用户预分润云豆
	 * 
	 * @param uid
	 * @return
	 */
	public double getRecordBalance(Long uid) {
		UserMoney userMoney = moneyDao.get(uid);
		if (userMoney == null) {
			return 0;
		}
		return userMoney.getRecordBalance().doubleValue();
	}

	/**
	 * 添加预分润云豆
	 * 
	 * @param uid
	 *            变更的用户id
	 * @param amount
	 *            更改的金额
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	private int addRecordBalance(Long uid, BigDecimal amount) {
		UserMoney userMoney = moneyDao.get(uid);
		if (null == userMoney) {
			return 0;
		}
		try {
			return moneyDao.addRecordMoney(uid, amount.doubleValue());
		} catch (Exception e) {
			logger.error("更新用户预分润云豆失败 uid = " + uid);
			logger.error("erro:" + e.getStackTrace());
			return 0;
		}
	}

	/**
	 * 减少预分润云豆
	 * 
	 * @param uid
	 *            变更的用户id
	 * @param amount
	 *            更改的金额
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	private int subtractRecordMoney(Long uid, BigDecimal amount) {
		UserMoney userMoney = moneyDao.get(uid);
		if (null == userMoney) {
			return 0;
		}
		try {
			return moneyDao.subtractRecordMoney(uid, amount.abs());// amount可能传入负数 进入sql语句一律为正数
		} catch (Exception e) {
			logger.error("更新用户预分润云豆失败 uid = " + uid);
			logger.error("erro:" + e.getStackTrace());
			return 0;
		}
	}

	/**
	 * 根据CN登录名获取CN账户的奖金
	 */
	public double getCNBonus(String loginName) {
		double cnBonus = 0;
		if (CommUtil.isNotNull(loginName)) {
			CnUserMoneyBO cnUserMoneyBO = this.cnPayBaseService.getCnUserBounsMoney(loginName);// 奖金
			if (cnUserMoneyBO != null) {
				if (null != cnUserMoneyBO.getISPAY() && 1 == cnUserMoneyBO.getISPAY().intValue()) {
					if (null != cnUserMoneyBO.getBONUS()) {
						cnBonus = cnUserMoneyBO.getBONUS();
					}
				}
			}
		}
		return cnBonus;
	}

	/**
	 * 根据CN登录名CN账户的云购币(冲销币)
	 */
	public double getCNRepeat(String loginName) {
		double cnRepeat = 0;
		if (CommUtil.isNotNull(loginName)) {
			CnUserMoneyBO cnUserMoneyBO1 = this.cnPayBaseService.getCnUserRepeatMoney(loginName);// 重消
			if (cnUserMoneyBO1 != null) {
				if (null != cnUserMoneyBO1.getISPAY() && 1 == cnUserMoneyBO1.getISPAY().intValue()
						&& null != cnUserMoneyBO1.getBONUS_REPEAT()) {
					cnRepeat = cnUserMoneyBO1.getBONUS_REPEAT();
				}
			}
		}
		return cnRepeat;
	}

	/**
	 * 添加预分润日志
	 * 
	 * @param uid
	 *            用户id
	 * @param amount
	 *            分润金额
	 * @param info
	 *            日志信息
	 * @param type
	 *            分润类型 1.分润 2.分润到账
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	private boolean addPrepareMoneyLog(Long uid, BigDecimal amount, String info, String type, Long adminId) {
		BigDecimal recordBalance = new BigDecimal(this.getRecordBalance(uid));
		PrepareMoneyLog prepareMoneyLog = new PrepareMoneyLog();
		prepareMoneyLog.setPdLogAdminId(adminId);
		prepareMoneyLog.setAddTime(new Date());
		prepareMoneyLog.setPdLogAmount(amount);
		prepareMoneyLog.setPdLogUserId(uid);
		prepareMoneyLog.setPdLogInfo(info);
		prepareMoneyLog.setBalance(recordBalance);
		prepareMoneyLog.setPdOpType(type);
		prepareMoneyLog.setPdType("预分润");
		prepareMoneyLogDao.save(prepareMoneyLog);
		return true;
	}

	/**
	 * 添加预分润
	 * 
	 * @param uid
	 * @param amount
	 * @param adminId
	 * @param pdOpType
	 * @param info
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean addRecordBalanceAndLog(Long uid, double amount, Long adminId, String pdOpType, String info) {
		/*User user = new User();
		user = this.userDao.findById(uid);
		if (user == null) {
			return false;
		}*/
		// 加日志
		this.addPrepareMoneyLog(uid, new BigDecimal(amount), info, pdOpType, adminId);
		// 更新预分润
		this.addRecordBalance(uid, new BigDecimal(amount));

		return true;
	}

	/**
	 * 预分润到账
	 * 
	 * @param uid
	 * @param amount
	 * @param adminId
	 * @param pdOpType
	 * @param info
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean subtractRecordBalanceAndLog(Long uid, double amount, Long adminId, String pdOpType,
			String info) {
		User user = this.userDao.findById(uid);
		if (user == null) {
			return false;
		}
		// 加日志
		this.addPrepareMoneyLog(uid, new BigDecimal(amount), info, pdOpType, adminId);
		// 更新预分润
		this.subtractRecordMoney(uid, new BigDecimal(amount));

		return true;
	}

	/**
	 * 根据分润表更新预分润
	 * 
	 * @return boolean
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updateRecordBalance() {
		try {
			this.userAccountDao.updateRecordBalance();
			return true;
		} catch (Exception e) {
			logger.error("[updateRecordBalance] is error" + e);
		}
		return false;
	}

	/**
	 * 发送短信 尊敬的云尚商家您好！您的提现已受理，请注意您的收款帐号信息，实际到帐时间请以银行信息为准，感谢您的支持！
	 * 
	 * @param mark
	 *            模板标识
	 * @param mobile
	 *            接受短信的手机
	 * @param ip
	 *            ""
	 * @param str
	 *            $1 $2 ...
	 * @return
	 */
//	public boolean sendMsg(String mark,String mobile, String ip, String[] str) {
//		msgTools.sendSms("sms_toshop_pay_complate", mobile, ip, str);
//		return true;
//	}

	/***
	 * 
	 * @param uid
	 * @param pdLogInfo
	 *            备注
	 * @param subtractMoney
	 *            扣除的本地云豆
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean consumptionMoney3(Long uid, String pdLogInfo, BigDecimal subtractMoney)
			throws ServiceException {

		PredepositLog log = new PredepositLog();
		log.setAddTime(new Date());
		log.setPdLogAmount(subtractMoney.multiply(BigDecimal.valueOf(-1L)));
		log.setPdLogUserId(uid);
		log.setPdOpType(UserContants.PD_OP_TYPE_CONSUMPTION);
		log.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
		log.setPdLogInfo(pdLogInfo);
		this.subtractMoney(uid, subtractMoney, null, log,null,0.00); // 扣除云豆

		return true;
	}

	/**
	 * 增加用户云豆
	 * 
	 * @param uid
	 *            用户ID
	 * @param amount
	 *            云豆数量
	 * @param adminId
	 *            操作者
	 * @param pdOpType
	 *            类型
	 * @param info
	 *            信息
	 * @param source
	 *            角色 resource 会员端、 merchant 商户端、supplier 供应商端 、CN CN账户、YY YY账户
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean addMoneyV2(Long uid, double amount, Long adminId, String pdOpType, String info,
			String source) {
		User user = this.userDao.findById(uid);
		if (user == null) {
			return false;
		}
		isExistAndCreate(uid);
		if (moneyDao.addMoneyV2(uid, amount, source) < 1) {
			logger.error("add money error, uid =" + uid);
			return false;
		}
		/** 用户角色标识 0.个人 1.供应商 2.商户 3.CN运营商 4.YY运营商 **/
		Long userCode = Long.valueOf(UserContant.accountTypeToUserCode(source));
		double balance = 0.00;
		if (userCode == 0 || userCode == 4) {
			balance = moneyDao.get(uid).getAvailableBalance().doubleValue();// 余额
		} else if (userCode == 1) {
			balance = moneyDao.get(uid).getB2cBalance().doubleValue();// 供应商余额
		} else if (userCode == 2) {
			balance = moneyDao.get(uid).getO2oBalance().doubleValue();// 商户余额
		} else if (userCode == 3) {
			balance = moneyDao.get(uid).getYysBalance().doubleValue();// 商户余额
		}
		PredepositLog log = new PredepositLog();
		log.setPdLogAdminId(adminId);
		log.setAddTime(new Date());
		log.setPdLogAmount(new BigDecimal(amount));
		log.setBalance(BigDecimal.valueOf(balance));
		log.setPdLogInfo(info);
		log.setPdLogUserId(uid);
		log.setPdOpType(pdOpType);
		log.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
		log.setUserCode(userCode);
		predepositLogDao.save(log);
		return true;
	}

	/**
	 * 根据用户类型(会员卖家运营商)细分角色(会员.供应商.商户.YY.CN)添加云豆
	 * 
	 * @param uid
	 *            用户ID
	 * @param amount
	 *            云豆数量
	 * @param adminId
	 *            操作者
	 * @param pdOpType
	 *            类型
	 * @param info
	 *            信息
	 * @param userType
	 *            用户角色 buyer会员 seller卖家 operator供应商
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean addMoneyV2ByUserType(Long uid, double amount, Long adminId, String pdOpType, String info,
			MoneyUserTypeEnum userType) {
		if (null == uid || 0 == amount || null == userType) {
			return false;
		}
		String source = UserContant.ACCOUNT_TYPE_RESOURCE;
		switch (userType.toString()) {
			case "buyer":
				return this.addMoneyV2(uid, amount, adminId, pdOpType, info, source);
			case "b2c":
				return this.addMoneyV2(uid, amount, adminId, pdOpType, info,
						UserContant.ACCOUNT_TYPE_SUPPLIER);
			case "o2o":
				return this.addMoneyV2(uid, amount, adminId, pdOpType, info,
						UserContant.ACCOUNT_TYPE_MERCHANT);
				/*case "seller":
					if (sellerService.sellerIsB2CByUid(uid)) {
						source = UserContant.ACCOUNT_TYPE_SUPPLIER;
					} else {
						source = UserContant.ACCOUNT_TYPE_MERCHANT;
					}
					if(sellerService.sellerIsO2oByUid(uid)){
						source = UserContant.ACCOUNT_TYPE_MERCHANT;
					}
					return this.addMoneyV2(uid, amount, adminId, pdOpType, info, source);*/
			case "operator":
				if (userAccountService.findByUid(uid, UserContant.ACCOUNT_TYPE_8) != null) {
					source = UserContant.ACCOUNT_TYPE_CN;
				} else {
					source = UserContant.ACCOUNT_TYPE_YY;
				}
				return this.addMoneyV2(uid, amount, adminId, pdOpType, info, source);
			default:
				return false;
		}
	}

	/**
	 * 扣除云豆
	 * @param uid
	 * @param cashAmount
	 * @param source
	 * @param log 日志
	 * @param poundageLog 手续费日志
	 * @param poundage 手续费
	 * @throws ServiceException
	 */
	public void subtractMoney(Long uid, BigDecimal cashAmount, String source, PredepositLog log,
			PredepositLog poundageLog, Double poundage) throws ServiceException {
		if(cashAmount.signum()==-1){
			throw new ServiceException("云豆值不能为负数");
		}
		if (source == null) {
			if (moneyDao.subtractMoney(uid, cashAmount) == 0) {
				logger.error("[subtractMoney] error uid:"+uid+" ,cashAmount"+cashAmount+" ,poundage"+poundage);
				throw new ServiceException("云豆扣除异常");
			}
			double balance = moneyDao.get(uid).getAvailableBalance().doubleValue();// 云豆剩下余额
			log.setBalance(BigDecimal.valueOf(balance));
			this.predepositLogDao.save(log);
		} else {
			if (moneyDao.subtractMoneyV2(uid, new BigDecimal(String.valueOf(cashAmount)), source) == 0) {
				logger.error("[subtractMoney] error uid:"+uid+" ,cashAmount"+cashAmount+" ,poundage"+poundage);
				throw new ServiceException("云豆扣除异常");
			}
			double balance = this.getMoneyByUidAndSource(uid, source);// 余额
			if(null != poundageLog){
				log.setBalance(BigDecimal.valueOf(balance + poundage));// 变动后余额
			}else{
				log.setBalance(BigDecimal.valueOf(balance));// 变动后余额
			}
			this.predepositLogDao.save(log);
			if(null != poundageLog){//手续费
				poundageLog.setBalance(BigDecimal.valueOf(balance));// 变动后余额
				this.predepositLogDao.save(poundageLog);
			}
		}
	}
}
