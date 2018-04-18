package com.sinco.carnation.pay.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.bo.PredepositLogBO;
import com.sinco.carnation.shop.bo.ShopBonusRepeatLogBO;
import com.sinco.carnation.shop.dao.PredepositLogDao;
import com.sinco.carnation.shop.dao.ShopBonusRepeatLogDao;
import com.sinco.carnation.shop.model.PredepositLog;
import com.sinco.carnation.shop.vo.PredepositLogVO;
import com.sinco.carnation.shop.vo.ShopBonusRepeatLogVO;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.user.bo.UserMoneyBO;
import com.sinco.carnation.user.dao.OperatorDao;
import com.sinco.carnation.user.dao.SellerDao;
import com.sinco.carnation.user.dao.UserMoneyDao;
import com.sinco.carnation.user.model.Seller;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class PredepositLogService {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(PredepositLogService.class);
	@Autowired
	private PredepositLogDao predepositLogDao;
	@Autowired
	private ShopBonusRepeatLogDao shopBonusRepeatLogDao;
	@Autowired
	private SellerDao sellerDao;
	@Autowired
	private OperatorDao operatorDao;
	@Autowired
	private UserMoneyDao userMoneyDao;
	@Autowired
	private UserAccountDao userAccountDao;

	/**
	 * 根据用户分页查询
	 * 
	 * @param uid
	 * @param page
	 * @param userCode
	 *            0.个人 1.供应商 2.商户 3.运营商
	 * @return
	 */
	public List<PredepositLogBO> findPageByUid(Long uid, MyPage<PredepositLogBO> page, String userCode) {
		return predepositLogDao.findPageByUid(uid, page, userCode);
	}

	/**
	 * 根据用户分页查询
	 * 
	 * @param uid
	 * @param page
	 * @return
	 */
	public List<PredepositLogBO> findPageByUid(Long uid, MyPage<PredepositLogBO> page) {
		return predepositLogDao.findPageByUid(uid, page, null);
	}

	public void queryByUserName(PredepositLogVO vo, MyPage<PredepositLogBO> page) {
		predepositLogDao.queryByUserName(vo, page);
	}

	public boolean save(PredepositLog predepositLog) {
		/**
		 * init other field here
		 */
		try {
			this.predepositLogDao.save(predepositLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public PredepositLog getObjById(Long id) {
		PredepositLog predepositLog = this.predepositLogDao.get(id);
		if (predepositLog != null) {
			return predepositLog;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.predepositLogDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> predepositLogIds) {
		// TODO Auto-generated method stub
		for (Serializable id : predepositLogIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(PredepositLog predepositLog) {
		try {
			this.predepositLogDao.update(predepositLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public BigDecimal queryGoodsProfitAmount(String pdType, Long sellerUid, Date startTime, Date endTime) {
		return predepositLogDao.queryGoodsProfitAmount(pdType, sellerUid, startTime, endTime);
	}

	/**
	 * @param userCode
	 *            角色标识 0.个人 1.供应商 2.商户 3.运营商 null不限
	 **/
	public List<PredepositLogBO> queryPredeMonth(Long sellerUid, String opType, String userCode) {
		return predepositLogDao.queryPredeMonth(sellerUid, opType, userCode);
	}

	public List<ShopBonusRepeatLogBO> getPageRepeatByVo(ShopBonusRepeatLogVO vo,
			MyPage<ShopBonusRepeatLogBO> page) {
		return this.shopBonusRepeatLogDao.getPageRepeatByVo(vo, page);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public synchronized void  changeErrorBlance() {
		// 查询用户
		List<Seller> sellers = sellerDao.listAllSeller();

		// 根据用户查询记录
		// 循环修改记录
		if (null != sellers && sellers.size() > 0) {
			Long uid = 0L;
			String userCode = "";
			BigDecimal balance = BigDecimal.ZERO;

			for (Seller seller : sellers) {
				if (null == seller.getUid()) {
					break;
				}
				uid = seller.getUid();
//				uid = 6241L;
				UserMoneyBO money = userMoneyDao.findOne(uid);
				if (null == money) {
					break;
				}
				// 供应商
				userCode = "1";
				balance = BigDecimal.ZERO;
				balance = balance.add(money.getB2cBalance());
				List<PredepositLogBO> logs = predepositLogDao.findPageByUid(uid, null, userCode);
				if (null != logs && logs.size() > 0) {
					for (PredepositLogBO log : logs) {
						log.setBalance(balance);
						predepositLogDao.update(log);
						balance = balance.subtract(log.getPdLogAmount());
					}
				}
				// 商户
				userCode = "2";
				balance = BigDecimal.ZERO;
				balance = balance.add(money.getO2oBalance());
				logs = null;
				logs = predepositLogDao.findPageByUid(uid, null, userCode);
				if (null != logs && logs.size() > 0) {
					for (PredepositLogBO log : logs) {
						log.setBalance(balance);
						predepositLogDao.update(log);
						balance = balance.subtract(log.getPdLogAmount());
					}
				}
			}
		}
		
		List<UserAccount> accounts = userAccountDao.listCNUser();
		if (null != accounts && accounts.size() > 0) {
			Long uid = 0L;
			String userCode = "";
			BigDecimal balance = BigDecimal.ZERO;
			//查询所有CN会员
			for(UserAccount account : accounts){
				if(null == account.getUid()){
					break;
				}
				uid = account.getUid();
				UserMoneyBO money = userMoneyDao.findOne(uid);
				if (null == money) {
					break;
				}
				userCode = "3";
				balance = BigDecimal.ZERO;
				balance = balance.add(money.getYysBalance());
				List<PredepositLogBO> logs = predepositLogDao.findPageByUid(uid, null, userCode);
				if (null != logs && logs.size() > 0) {
					for (PredepositLogBO log : logs) {
						log.setBalance(balance);
						predepositLogDao.update(log);
						balance = balance.subtract(log.getPdLogAmount());
					}
				}
			}
		}
	}
}
