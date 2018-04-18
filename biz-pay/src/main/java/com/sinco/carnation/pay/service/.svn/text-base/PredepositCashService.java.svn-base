package com.sinco.carnation.pay.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.dao.PredepositCashDao;
import com.sinco.carnation.shop.model.PredepositCash;
import com.sinco.carnation.shop.vo.PredepositCashVO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.user.dao.UserMoneyDao;
import com.sinco.carnation.user.model.UserMoney;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dal.utils.DateCalendar;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class PredepositCashService {
	@Autowired
	private PredepositCashDao predepositCashDao;
	@Autowired
	private UserMoneyDao moneyDao;
	@Autowired
	private PredepositLogService predepositLogService;

	/** 提现规则开始实行时间 **/
//	private final String beginTime = "2017-03-01 00:00:00";//测试
	private final String beginTime = "2017-05-01 00:00:00";
	/** 免费提现额度 **/
	private final double allowances = 1000;
	/** 免费提现次数 **/
	private final int line = 2;

	public List<PredepositCashBO> queryPredepositCashPageList(String pdPayment, String pdPayStatus,
			String pdStatus, String pdRemittanceUser, String pdRemittanceBank, String pdUserName,
			String beginTime, String endTime, String userType, MyPage<PredepositCashBO> page) {
		return predepositCashDao.queryPredepositCashPageList(pdPayment, pdPayStatus, pdStatus,
				pdRemittanceUser, pdRemittanceBank, pdUserName, beginTime, endTime, userType, page);
	}
	
//	public List<PredepositCashBO> ListPredepositCashPageByUserCode(String userCode,String pdPayment, String pdPayStatus,
//			String pdStatus, String pdRemittanceUser, String pdRemittanceBank, String pdUserName,
//			String beginTime, String endTime, String userType, MyPage<PredepositCashBO> page) {
//		return predepositCashDao.queryPredepositCashPageList(pdPayment, pdPayStatus, pdStatus,
//				pdRemittanceUser, pdRemittanceBank, pdUserName, beginTime, endTime, userType, page);
//	}
	
	public BigDecimal sumPredepositCashPageList(String pdPayment, String pdPayStatus,
			String pdStatus, String pdRemittanceUser, String pdRemittanceBank, String pdUserName,
			String beginTime, String endTime, String userType) {
		return predepositCashDao.sumPredepositCashPageList(pdPayment, pdPayStatus, pdStatus, pdRemittanceUser,
				pdRemittanceBank, pdUserName, beginTime, endTime, userType);
	}
//	@Transactional(readOnly = false)
//	public void add(Long uid, Double amount, PredepositCash predepositCash) throws ServiceException {
//
//		if (this.moneyDao.countByUid(uid, new BigDecimal(amount)) <= 0) {
//			throw new ServiceException("用户金额不足，无法申请提现!");
//		}
//
//		this.predepositCashDao.save(predepositCash);
//		// 保存提现日志
//		// PredepositLog log = new PredepositLog();
//		// log.setAddTime(new Date());
//		// log.setPdLogAmount(predepositCash.getCashAmount());
//		// log.setPdLogInfo("申请提现");
//		// log.setPdLogUserId(predepositCash.getCashUserId());
//		// log.setPdOpType(PaymentConstants.ORDER_TYPE_CASH);
//		// // log.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
//		// log.setPredepositId(predepositCash.getId());
//		// predepositLogService.save(log);
//	}

	// @Transactional(readOnly = false)
	// public boolean save(PredepositCash predepositCash) {
	// /**
	// * init other field here
	// */
	// try {
	//
	// return true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// return false;
	// }
	// }

	/**
	 * 获得最近一次提现
	 * 
	 * @param userId
	 * @return
	 */
	public PredepositCashBO queryOnlyOneByUid(Long userId) {
		return predepositCashDao.queryOnlyOneByUid(userId);
	}

	public PredepositCashBO fetch(Long id) {
		return predepositCashDao.get(id);
	}

	public PredepositCash getObjById(Long id) {
		PredepositCash predepositCash = this.predepositCashDao.get(id);
		if (predepositCash != null) {
			return predepositCash;
		}
		return null;
	}

	public void queryByUserId(Long userId, OperatorVO vo, MyPage<PredepositCashBO> page) {
		predepositCashDao.queryByUserId(userId, vo, page);
	}

	public boolean delete(Long id) {
		try {
			this.predepositCashDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> predepositCashIds) {
		// TODO Auto-generated method stub
		for (Serializable id : predepositCashIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(PredepositCash predepositCash) {
		try {
			this.predepositCashDao.update(predepositCash);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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

	public void findPredepositPageList(Long uid, MyPage<PredepositCashBO> page) {
		page.setContent(predepositCashDao.findPredepositPageList(uid, page));
	}

	/**
	 * 获取剩余免费额度 
	 * @return 保留两位小数
	 */
	public double getFreePoundage(Long uid, String source) {
		if (null == uid) {
			return 0.00;
		}
		int code = 0;
		double allowances = 0;
		if (source != null) {
			code = Integer.valueOf(UserContant.accountTypeToUserCode(source));
		}
		// 用户角色标识 0.个人 1.供应商 2.商户 3.运营商
		PredepositCashVO vo = new PredepositCashVO();
		vo.setCashUserId(uid);
		vo.setUserCode(code);
		vo.setBeginTime(this.beginTime);
		vo.setCashType(0);
		BigDecimal cashAmount = this.predepositCashDao.countCashAmountByVO(vo);
		allowances = this.allowances - cashAmount.doubleValue();
		if (allowances < 0) {
			allowances = 0;
		}
		DecimalFormat df = new DecimalFormat("######0.00");
		return Double.valueOf(df.format(allowances));
	}
	
	/**
	 * 获取提现手续费 
	 */
	public double getPoundage(Long uid, String source, BigDecimal amount) {
		if (null == uid) {
			return 0.00;
		}
		if (amount.compareTo(BigDecimal.ZERO) == -1) {
			return 0.00;
		}
		int code = 0;
		if (source != null) {
			code = Integer.valueOf(UserContant.accountTypeToUserCode(source));
		}
		// 手续费
		double poundage = 0;
		// 要计算手续费的金额
		double poundageAmount = 0;
		// 用户角色标识 0.个人 1.供应商 2.商户 3.运营商
		PredepositCashVO vo = new PredepositCashVO();
		vo.setCashUserId(uid);
		vo.setUserCode(code);
		vo.setBeginTime(this.beginTime);
		vo.setCashType(0);
		// 获取用户已提现金额(从设定时间开始)
		BigDecimal cashAmount = this.predepositCashDao.countCashAmountByVO(vo);
		// 免费额度
		BigDecimal allowances = new BigDecimal(this.allowances);

		if (cashAmount.compareTo(allowances) == -1) {// 已提现金额在免费范围内
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
			// 获取用户当月已提现次数
			vo.setBeginTime(sdf.format(DateCalendar.getCurrentMonthStartTime()));
			vo.setEndTime(sdf.format(DateCalendar.getCurrentMonthEndTime()));
			int line = this.predepositCashDao.listPredepositCashByVO(vo).size();
			if (line < this.line) {// 提现次数少于两次
				if (allowances.compareTo(cashAmount.add(amount)) == -1) {// 已提现金额与当前提现金额超出免费范围
					poundageAmount = -(allowances.subtract(cashAmount).subtract(amount)).doubleValue();
				} else { // 在免费额度范围内
					return 0.00;
				}
			} else { // 提现次数超过 每月免费次数
				poundageAmount = amount.doubleValue();
			}
		} else {
			poundageAmount = amount.doubleValue();
		}
		poundage = poundageAmount * (0.01);// 手续费=提现金额0.01
		if (poundage < 2) {
			poundage = 2;
		}
		DecimalFormat df = new DecimalFormat("######0.00");
		return Double.valueOf(df.format(poundage));
	}

	/**
	 * 获取当月提现次数
	 */
	public int getLineByUid(Long uid, String source) {
		if (null == uid) {
			return 0;
		}
		int code = 0;
		int line = 0;
		if (source != null) {
			code = Integer.valueOf(UserContant.accountTypeToUserCode(source));
		}
		PredepositCashVO vo = new PredepositCashVO();
		vo.setCashUserId(uid);
		vo.setUserCode(code);
		// 获取用户当月已提现次数
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		vo.setBeginTime(sdf.format(DateCalendar.getCurrentMonthStartTime()));
		vo.setEndTime(sdf.format(DateCalendar.getCurrentMonthEndTime()));

		List<PredepositCashBO> list = this.predepositCashDao.listPredepositCashByVO(vo);
		if (list != null) {
			line = list.size();
		}
		return line;
	}
	public String cashStatus(int cashStatus)
	{
		String result = "";
		if(cashStatus==0)
		{
			result = "等待审核";
		}
		else if(cashStatus==1)
		{
			result = "审核完成";
		}
		else if(cashStatus==-1)
		{
			result = "审核拒绝";
		}
		return result;
	}
	
	public String userType(String userType,String sellerId)
	{
		String result = "";
		if(StringUtils.isBlank(userType)){
			return result;
		}
		if(userType.equals("1"))
		{
			if(sellerId!=null)
			{
				result = "商户";
			}
			else
			{
				result = "普通会员";
			}
		}
		else if(userType.equals("4"))
		{
			result = "运营商";
		}
		else
		{
			result = "——";
		}
		return result;
	}
	
	public String cashPayment(String cashPayment)
	{
		String result = "";
		if(StringUtils.isBlank(cashPayment)){
			return "无";
		}
		if(cashPayment.equals("alipay"))
		{
			result = "支付宝";
		}
		else if(cashPayment.equals("alipay_app"))
		{
			result = "支付宝";
		}
		else if(cashPayment.equals("tenpay"))
		{
			result = "财付通";
		}
		else if(cashPayment.equals("bill"))
		{
			result = "快钱";
		}
		else if(cashPayment.equals("chinabank"))
		{
			result = "网银在线";
		}
		else
		{
			result = "无";
		}
		return result;
	}
	
	public String cashPayStatus(int cashPayStatus)
	{
		String result = "";
		if(cashPayStatus==0)
		{
			result = "等待支付";
		}
		else if(cashPayStatus==1)
		{
			result = "支付完成";
		}
		return result;
	}
}
