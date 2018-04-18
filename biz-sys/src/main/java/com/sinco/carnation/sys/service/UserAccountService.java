package com.sinco.carnation.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.model.BindingHistory;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.dao.OperatorDao;
import com.sinco.carnation.user.dao.SellerDao;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.dao.UserRelationDao;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.vo.UpdateWxVO;

@Service
@Transactional(readOnly = true)
public class UserAccountService {

	private Logger logger = LoggerFactory.getLogger(UserAccountService.class);

	@Autowired
	private UserAccountDao userAccountDao;

	@Autowired
	private UserService userService;

	@Autowired
	private UserCustomerDao userCustomerDao;

	@Autowired
	private BindingHistoryService bindingHistoryService;

	@Autowired
	private OperatorDao operatorDao;

	@Autowired
	private UserRelationDao userRelationdao;

	@Autowired
	private StoreDao storeDao;

	@Autowired
	private SellerDao selleDaor;

	public UserAccount findUserAccount(Long uid, String acountType) {
		return userAccountDao.findUserAccount(uid, acountType);
	}

	public UserAccount findUserAccount(String mobile, String acountType) {
		return userAccountDao.findUserAccount(mobile, acountType);
	}

	public UserAccountBO findLastLogin(Long uid) {
		return userAccountDao.findLastLogin(uid);
	}

	public UserAccountBO findByLoginName(String loginName) {
		return userAccountDao.findByLoginName(loginName);
	}

	/**
	 * 当loginName为CN账户开头的做相应的逻辑处理 by young
	 */
	public UserAccountBO fetchByLoginName(String loginName) {
		return userAccountDao.fetchByLoginName(loginName);
	}

	public List<Long> findCustomerByLoginNames(List<String> listLoginName) {
		List<UserAccount> list = userAccountDao.findCustomerByLoginNames(listLoginName);
		List<Long> ids = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(list)) {
			for (UserAccount userAccount : list) {
				ids.add(userAccount.getUid());
			}
		}
		return ids;
	}

	public UserAccountBO findByLoginName(String loginName, Long uid) {
		return userAccountDao.findByLoginName(loginName, uid);
	}

	public UserAccountBO findByMobile(String mobile, String accountType) {
		return userAccountDao.findByMobile(mobile, accountType);
	}

	public UserAccount findByUid(Long uid, String acountType) {
		return userAccountDao.findByUid(uid, acountType);
	}

	public UserAccount findByUid(Long uid) {
		return userAccountDao.queryAccountByUid(uid);
	}

	public UserAccountBO findByWeChatUnionid(String unionid) {
		return userAccountDao.findByMobile(unionid, UserContant.ACCOUNT_TYPE_4);
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	@Transactional(readOnly = false)
	public int passwordUpdate(Long userId, String password) {
		UserAccount account = new UserAccount();
		account.setPassword(PasswordUtils.entryptPassword(password));
//		account.setSellerPassword(PasswordUtils.entryptPassword(password));
//		account.setOperatorPassword(PasswordUtils.entryptPassword(password));
//		account.setSupplierPassword(PasswordUtils.entryptPassword(password));
		account.setUpdateTime(new Date());
		account.setUid(userId);
		return userAccountDao.passwordUpdate(account);
	}

	/**
	 * 根据不同的角色标识修改密码
	 * 
	 * @return
	 */
	@Transactional(readOnly = false)
	public int passwordUpdate(Long userId, String password, String source) {
		if (StringUtils.isBlank(source)) {
			return -99;
		}
		UserAccount account = new UserAccount();
		boolean isExist = setUserAccountPassword(password, source, account);
		if (!isExist) {
			return -99;
		}
		account.setUpdateTime(new Date());
		account.setUid(userId);
		return userAccountDao.passwordUpdate(account);
	}

	private boolean setUserAccountPassword(String password, String source, UserAccount account) {
		// 不同角色修改对应的密码
		switch (source) {
			case UserContant.ACCOUNT_TYPE_RESOURCE:
				account.setPassword(PasswordUtils.entryptPassword(password));
				break;
			case UserContant.ACCOUNT_TYPE_MERCHANT:
				account.setSellerPassword(PasswordUtils.entryptPassword(password));
				break;
			case UserContant.ACCOUNT_TYPE_SUPPLIER:
				account.setSupplierPassword(PasswordUtils.entryptPassword(password));
				break;
			case UserContant.ACCOUNT_TYPE_YY:
				account.setOperatorPassword(PasswordUtils.entryptPassword(password));
				break;
			default:
				return false;
		}
		return true;
	}

	public UserAccount setUserAccount(Long userId, String mobile, String password, String accountType,
			boolean sDeleted) {
		UserAccount account = new UserAccount();
		account.setUid(userId);
		account.setLoginName(mobile);
		account.setPassword(PasswordUtils.entryptPassword(password));
		// 添加供应商密码和商户密码（前期和会员密码一致）
		account.setSellerPassword(PasswordUtils.entryptPassword(password));
		account.setSupplierPassword(PasswordUtils.entryptPassword(password));
		account.setOperatorPassword(PasswordUtils.entryptPassword(password));
		account.setAccountType(accountType);
		account.setIsDeleted(sDeleted);
		account.setCreateTime(new Date());
		return account;
	}

	public List<UserAccountBO> findUserAccountByUid(Long uid) {
		return userAccountDao.findUserAccountByUid(uid);
	}

	public UserAccountBO queryAccountByOpenId(String openId, Integer type) {
		return userAccountDao.queryAccountByOpenId(openId, type);
	}

	@Transactional(readOnly = false)
	public boolean deleteAccount(Long uid, String type) {
		return userAccountDao.deleteAccount(uid, type);
	}

	@Transactional(readOnly = false)
	public void save(UserAccount account) {
		userAccountDao.save(account);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(UserAccount account) {
		userAccountDao.update(account);
	}

	@Transactional(readOnly = false)
	public UserAccountBO findAccountByVo(UserAccountBO account) {
		return userAccountDao.findAccountByVo(account);

	}

	/**
	 * cn账户绑定手机号,判断该手机号是否是平台用户，为平台用户时，合并cn账户与手机号账户，以手机号账户为准
	 * 
	 * @param account
	 * @param uid
	 * @param mobile
	 * @return
	 */
	@Transactional(readOnly = false)
	public int handelUserAccout(UserAccountBO account, Long uid, String mobile, String cn_username,
			String password) {
		password = "yunshang123456";// CN账户绑定手机号，默认手机号密码
		if (account == null) {
			UserCustomerBO usercunstomer = userCustomerDao.searchCustomerBO(uid);// 更新CN账户的手机号
			if (usercunstomer == null) {
				return 400;
			}
			UserAccount account_ = new UserAccount();
			account_.setLoginName(mobile);
			account_.setAccountType(UserContant.ACCOUNT_TYPE_2);
			account_.setIsDeleted(false);
			account_.setUid(uid);
			account_.setPassword(PasswordUtils.entryptPassword(password));
			this.userAccountDao.save(account_);
			usercunstomer.setMobile(mobile);
			userCustomerDao.updateByPrimaryKeySelective(usercunstomer);
			return 100;
		} else {// 当该手机号已经为平台用户:将手机账号与cn账户合并，以手机账号为主
			UserAccountBO userbo = new UserAccountBO();
			userbo.setAccountType(UserContant.ACCOUNT_TYPE_8);
			userbo.setUid(uid);
			// 查询CN账户：将CN账户的uid更新为手机账户的uid
			UserAccountBO cnaccountBO = userAccountDao.findAccountByVo(userbo);
			UserCustomerBO usercunstomer = userCustomerDao.searchCustomerBO(account.getUid());// 手机账户
			boolean f = true;
			// 判断该手机号是否有绑定过CN账户
			UserAccountBO userbo_ = new UserAccountBO();
			userbo_.setAccountType(UserContant.ACCOUNT_TYPE_8);
			userbo_.setUid(account.getUid());
			UserAccountBO cnaccountBO_ = userAccountDao.findAccountByVo(userbo_);
			if (cnaccountBO_ != null) {
				f = false;
			}

			// 查询CN账户的运营商
			// OperatorBO operatorBO=operatorDao.getOperatorBOByOperatorCode(cn_username);
			UserAccountBO bo = userAccountDao.selectAcocountOperatorByCnUserAlias(cn_username);
			if (cnaccountBO != null && account.getUid().longValue() != uid.longValue() && f) {
				if (StringUtils.isEmpty(bo.getUserID())) {
					cnaccountBO.setUid(account.getUid());
					Map<String, String> map = new HashMap<String, String>();
					map.put("combine", "YES");// CN标识合并
					map.put("cn_username", cn_username);
					String extend = Json.toJson(map, JsonFormat.compact());
					usercunstomer.setExtend(extend);
					userAccountDao.update(cnaccountBO);// 将cn账户uid替换成手机账户uid
					userCustomerDao.updateByPrimaryKeySelective(usercunstomer);
					userCustomerDao.deleteById(uid);// 删除刚初始化的CN账户
					User user = userService.getObjById(account.getUid());
					user.setUserType(UserContant.USER_TYPE_4);
					userService.update(user);
					return 200;
				} else {
					// 该cn账号存在运营商，以运营商uid为主,将手机号uid变为运营商uid
					Long muid = account.getUid();
					// account.setUid(uid);
					// userAccountDao.update(account);
					UpdateWxVO accountup = new UpdateWxVO();
					// accountup.setId(userAccountMobile.getId());
					accountup.setNewUid(uid);
					accountup.setOldUid(muid);
					userAccountDao.updateWx(accountup);
					// 保存记录
					BindingHistory record = new BindingHistory();
					record.setOldUid(muid);
					record.setNewUid(uid);
					bindingHistoryService.save(record);
					return 200;
				}
			}
			return 300;
		}
	}

	/**
	 * 验证是否已有第三方账号
	 * 
	 * @param uid
	 * @param accountType
	 * @return true 有 false 没有
	 */
	public boolean mobileOnly(long uid, String accountType) {
		UserAccountBO account = new UserAccountBO();
		account.setUid(uid);
		account.setAccountType(accountType);
		UserAccountBO bo = this.findAccountByVo(account);
		if (bo != null) {
			return true;
		}
		return false;
	}

	/**
	 * 验证是否存在绑定微信
	 * 
	 * @param uid
	 * @return 微信openid
	 */
	public String queryAccountBindingWx(Long uid) {
		return userAccountDao.queryAccountBindingWx(uid);
	}

	/**
	 * 微信绑手机，以微信UID为主
	 * 
	 * @param accountMobile
	 *            手机登录账号
	 * @param accountThird
	 *            第三方登录账号 3.QQ 4.微信 5.微博
	 * @param accountCN
	 *            CN登录账号
	 * @return 0 手机号是CN账号，微信绑定关系清理 1手机号不是CN账号
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int WxBindingMobile(UserAccount accountMobile, UserAccount accountThird, UserAccount accountCN) {
		int rt = 1;
		Long newUid = accountThird.getUid();
		Long oldUid = accountMobile.getUid();
		BindingHistory record = new BindingHistory();// uid记录
		record.setNewUid(newUid);
		record.setOldUid(oldUid);
		bindingHistoryService.save(record);

		if (accountMobile.getAccountType().equals(UserContant.ACCOUNT_TYPE_2)) {
			this.changeMobile(newUid, oldUid);
			/*userService.updateMobile(accountThird.getUid(),accountMobile.getLoginName());// 更新账户的手机号码*/
		}

		if (accountCN != null) {// 修改CN账号的UID为微信号的UID
			UserAccount savAccounCN = new UserAccount();
			savAccounCN = accountCN;
			savAccounCN.setUid(newUid);
			this.update(savAccounCN);// 更新CN账户的UID为微信登录账户的UID
			rt = 0;
		}
		UserAccount savAccount = new UserAccount();
		savAccount = accountMobile;// 指定要修改的是手机登录账号的记录
		savAccount.setUid(newUid);// 修改手机号账户的UID为微信登录账户的UID
		this.update(savAccount);// 更新手机号账户的UID为微信登录账户的UID
		// cn账号变更uid,账户类型修改为运营商,运营商表uid表更为新uid
		this.cnChangeUid(oldUid, newUid);
		return rt;
	}

	/**
	 * 绑定第三方账号
	 * 
	 * @param openid
	 *            要绑定的openid
	 * @param uid
	 *            用户当前登录uid
	 * @param type
	 *            要绑定的类型
	 * @return 0.成功 1.第三方账号不是平台用户 4.第三方账号已经绑定
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int banding(String openid, Long uid, String type) {
		UserAccountBO accountThird = this.findByMobile(openid, type);// 查询第三方账号是不是平台用户
		if (accountThird == null) {// 如果第三方账号不是是平台用户
			return 1;
		}
		Long newUid = 0L;// uid以微信为主
		Long oldUid = 0L;
		UserAccount accountWx = this.findByUid(accountThird.getUid(), UserContant.ACCOUNT_TYPE_2);// 查询第三方账号是否绑定了手机
		if (accountWx != null) {
			return 4;
		}
		UserAccount savAccount = new UserAccount();
		if (type.equals(UserContant.ACCOUNT_TYPE_4)) {// 要绑微信 以微信uid为主
			UserAccount userAccount = this.findByUid(uid, UserContant.ACCOUNT_TYPE_2);// 查询用户的手机登录账号信息
			if (userAccount != null) {
				// 修改用户手机号码
				if (!this.changeMobile(newUid, userAccount.getUid())) {
					logger.error("change mobile is unsuccess where mobile=" + userAccount.getLoginName());
				}
			} else {
				userAccount = this.findByUid(uid);
			}
			savAccount = userAccount;// 修改当前uid为微信uid
			newUid = accountThird.getUid();
			oldUid = uid;

		} else {// 第三方必须先绑定手机 所以这里只考虑微信号绑定第三方
			this.findByUid(uid, UserContant.ACCOUNT_TYPE_4);// 查询用户的微信登录账号信息
			savAccount = accountThird;// 修改第三方账号uid为当前uid
			newUid = uid;
			oldUid = accountThird.getUid();
		}
		oldUid = savAccount.getUid();
		BindingHistory record = new BindingHistory();// uid记录
		record.setNewUid(newUid);
		record.setOldUid(oldUid);
		bindingHistoryService.save(record);

		savAccount.setUid(newUid);
		this.update(savAccount);// 更新第三方登录账户的UID为微信账户的UID
		// cn账号变更uid,账户类型修改为运营商,运营商表uid表更为新uid
		cnChangeUid(oldUid, newUid);

		return 0;
	}

	/**
	 * cn账号变更uid,账户类型修改为运营商,运营商表uid表更为新uid
	 * 
	 * @param oldUid
	 * @param newUid
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void cnChangeUid(Long oldUid, Long newUid) {
		userCustomerDao.updateMobileByUID(oldUid, null);
		UserAccount cn = this.findByUid(oldUid, UserContant.ACCOUNT_TYPE_8);// 查询该账号是否CN账号
		if (cn != null) {
			// 账号升级为运营商
			User user = new User();
			user.setId(newUid);
			user.setUserType(UserContant.USER_TYPE_4);
			userService.update(user);

			OperatorBO operatorBO = operatorDao.queryOperatorInfo(oldUid);
			if (operatorBO != null) {
				// 更新运营商uid为微信账号uid
				operatorBO.setUserId(newUid);
				operatorDao.update(operatorBO);
			}
		}
	}

	public void updateWx(UpdateWxVO accountup) {
		userAccountDao.updateWx(accountup);
	}

	public UserAccountBO queryByUserAccount(UserAccount obj) {
		return this.userAccountDao.queryByUserAccount(obj);
	}

	/**
	 * 微信账户mobile字段设为手机号账户mobile，手机号账户Mobil字段设为空
	 * 
	 * @param newUid
	 *            第三方账号uid
	 * @param oldUid
	 *            手机号账号uid
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean changeMobile(Long newUid, Long oldUid) {
		try {
			UserCustomerBO oldUser = userCustomerDao.findBOByUserId(oldUid);
			UserCustomerBO newUser = userCustomerDao.findBOByUserId(newUid);

			newUser.setMobile(oldUser.getMobile());
			oldUser.setMobile(null);

			userCustomerDao.updateById(oldUser);
			userCustomerDao.updateById(newUser);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获取CN账户
	 * 
	 * @param uid
	 * @return
	 */
	public UserAccount get_CN_User(Long uid) {
		UserBO user = this.userService.findById(uid);
		UserAccount userAccount = null;
		if (user != null) {
			long userID = user.getId();
			userAccount = this.userAccountDao.findUserAccount(userID, UserContant.ACCOUNT_TYPE_8);
		}
		return userAccount;
	}

	/**
	 * 判断当前用户是否为CN账户
	 * 
	 * @param uid
	 * @return
	 */
	public boolean check_User_Is_CN(Long uid) {
		UserAccount userAccount = this.get_CN_User(uid);
		if (userAccount != null) {
			return true;
		}
		return false;
	}

	public UserAccountBO selectAcocountByCnUserAlias(String loginName) {
		// TODO Auto-generated method stub
		return this.userAccountDao.selectAcocountByCnUserAlias(loginName);
	}

	public UserAccountBO selectAcocountOperatorByCnUserAlias(String loginName) {
		// TODO Auto-generated method stub
		return this.userAccountDao.selectAcocountOperatorByCnUserAlias(loginName);
	}

	/**
	 * 账号uid变更 1.account表uid变更 2.关系表(1邀请关系 2绑定关系) 3.seller 4.store 5.保存日志 如果是CN账号 另外执行 1.账户类型修改为运营商
	 * 2.运营商表uid表更为新uid
	 * 
	 * @param oldUid
	 * @param newUid
	 * @param mobile
	 *            不为空,则变更mobile
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void changeUid(Long oldUid, Long newUid, boolean hasCN) {
		if (oldUid == null || newUid == null) {
			return;
		}
		// account表变更
		UpdateWxVO accountup = new UpdateWxVO();
		accountup.setNewUid(newUid);
		accountup.setOldUid(oldUid);
		this.updateWx(accountup);// 以微信号为准，将手机号和CN账号的uid改成微信uid
		// 关系表uid变更 1.邀请关系 2.商户绑定关系 3uid
		if (userRelationdao.countRelationByRefereeUid(oldUid) > 0) {// 该会员推荐的用户
			userRelationdao.updateRefereeUidByOldRefereeUid(oldUid, newUid);
		}
		if (userRelationdao.countSellerRelationByUid(oldUid) > 0) {// 该商户绑定的用户
			userRelationdao.updateSellerByOldRefereeUid(oldUid, newUid);
		}
		UserRelationBO relation = userRelationdao.queryUserRelation(oldUid);
		if (null != relation) {// 该会员自己的上级关系
			relation.setUserId(newUid);
			userRelationdao.update(relation);
		}
		// seller表uid变更
		Seller sellerBO = selleDaor.findByUid(oldUid);
		if (null != sellerBO) {
			sellerBO.setUid(newUid);
			sellerBO.setId(sellerBO.getId());/////修改关系
			selleDaor.update(sellerBO);
		}
		// sotre create_user_id字段变更
		StoreBO storeBO = storeDao.fetchStoreByCreateUserId(oldUid);
		if (null != storeBO) {
			storeBO.setCreateUserId(newUid);
			storeDao.update(storeBO);
		}

		// 保存记录
		BindingHistory record = new BindingHistory();
		record.setOldUid(oldUid);
		record.setNewUid(newUid);
		bindingHistoryService.save(record);

		if (hasCN) { // CN账号升级账号类型为运营商,更新运营商uid
			UserBO userBO = userService.findById(newUid);
			// 解除新uid上级关系
//			userRelationService.relieveRelationByUid(newUid);
			// 账号升级为运营商
			User user = userBO;
			user.setId(newUid);
			user.setUserType(UserContant.USER_TYPE_4);
			userService.update(user);
			// 更新运营商uid为微信账号uid
			OperatorBO operatorBO = operatorDao.queryOperatorInfo(oldUid);
			if (operatorBO != null) {
				operatorBO.setUserId(newUid);
				operatorDao.update(operatorBO);
			}
		}
	}

	/**
	 * 查询用户是否绑定手机号码且为商户
	 * 
	 * @param uid
	 *            用户ID
	 * @return false:否 true：是
	 */
	public Boolean queryUserAccountIsMobileAndMerchat(Long uid) {
		Boolean result = Boolean.FALSE;
		UserAccountBO bo = new UserAccountBO();
		bo.setUid(uid);
		bo.setAccountType(UserContant.ACCOUNT_TYPE_2);
		UserAccountBO account = userAccountDao.findAccountByVo(bo);
		if (account != null) {
			long userID = account.getUid();
			StoreBO store = this.storeDao.queryStoreInfo(userID,true,false);
			if (store == null) {
				 return Boolean.FALSE;
			}
			Long storeID = store.getStoreId();
			if (storeID != null) {
				result = this.queryUserAccoutIsO2O(storeID);
			}
		}
		return result;
	}

	/**
	 * 判断用户是否为商户
	 * 
	 * @param storeId
	 * @return
	 */
	public boolean queryUserAccoutIsO2O(Long storeId) {
		storeId = storeId != null ? storeId : 0L;
		StoreBO store = this.storeDao.getStoreStatus(storeId);
		if (store != null) {
			Boolean boo_O2O = store.getIsO2o();
			if (boo_O2O) {
				logger.debug("=====UserAccount is Merchant");
				return Boolean.TRUE;
			} else {
				logger.debug("=====UserAccount is not Merchant");
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * 判断用户是否为商户
	 * 
	 * @param storeId
	 * @return
	 */
	public boolean queryUserAccoutIsShop(Long storeId) {
		storeId = storeId != null ? storeId : 0L;
		StoreBO store = this.storeDao.getStoreStatus(storeId);
		if (store != null) {
			Boolean boo_Shop = store.getIsShop();
			if (boo_Shop) {
				logger.debug("=====UserAccount is Supplier");
				return Boolean.TRUE;
			} else {
				logger.debug("=====UserAccount is not Supplier");
			}
		}
		return Boolean.FALSE;
	}

	/**
	 * 根据微信的uniondID获取当前用户信息
	 * 
	 * @param unionID
	 * @return 10： 默认 100：新会员 200：是会员但没绑定手机号 300：是会员绑定手机号且是商户 310：是会员绑定手机号且未入驻 320：是会员绑定手机号且是供应商 330:
	 *         当前微信用户为CN账号 340: 待审核 350：审核失败 add by yuleijia on 2017.4.17
	 */
	@SuppressWarnings("unused")
	public Integer queryUserAccountByUnionID(String unionID) {
		Integer result = 10;
		if (unionID != null && unionID.trim().length() > 0) {
			UserAccountBO weChatUserAccountBo = this.userAccountDao.fetchByLoginName(unionID);
			if (weChatUserAccountBo != null) {
				Long uid = weChatUserAccountBo.getUid();
				// 校验当前微信用户是否为CN账户
				// 需求：CN会员不能申请成为商户和供应商
				UserAccountBO cn_UserAccount = new UserAccountBO();
				cn_UserAccount.setAccountType(UserContant.ACCOUNT_TYPE_8);
				cn_UserAccount.setUid(uid);
				UserAccountBO cnObj = this.findAccountByVo(cn_UserAccount);
				if (cnObj != null) {
					logger.debug("<<<<<<< 当前微信用户已绑定CN账号");
					result = 330;
				} else {
					// 是否绑定手机号码
					String accountType = UserContant.ACCOUNT_TYPE_2;
					UserAccountBO userAccountBO = new UserAccountBO();
					userAccountBO.setUid(uid);
					userAccountBO.setAccountType(accountType);
					UserAccountBO phoneUserAccountBO = this.findAccountByVo(userAccountBO);
					if (phoneUserAccountBO != null) {
						uid = phoneUserAccountBO.getUid();
						// 是否已入驻切是否为商户
						//Seller seller = this.selleDaor.findByUid(uid);// 修改
						Seller seller = this.selleDaor.findSessionById(uid, true, null);
						
						if (seller != null) {
							Long storeID = seller.getStoreId();
							boolean isO2O = this.queryUserAccoutIsO2O(storeID);//判断是否是商户
							boolean isShop = this.queryUserAccoutIsShop(storeID);//判断是否是供应商
							if (isO2O) {
								int stateResult = this.queryStoreAuditStatus(storeID);
								if (stateResult == 5) {
									result = 340; // 待审核中
									logger.debug("<<<<<<< 商户待审核中");
								} else if (stateResult == 15) {
									result = 300; // 已绑定手机号码且是商户
									logger.debug("<<<<<<< 已绑定手机号码且是商户");
								} else {
									result = 350; // 审核失败
									logger.debug("<<<<<<< 审核失败");
								}

							}
		/*					if (isShop) {
								result = 320; // 已绑定手机号码且是供应商
								logger.debug("<<<<<<< 已绑定手机号码且是供应商");
							}*/
						} else {
							result = 310; // 未入驻
							logger.debug("<<<<<<< 未入驻");
						}
					} else {
						result = 200; // 没绑定手机号码
						logger.debug("<<<<<<< 没绑定手机号码");
					}
				}
			} else {
				result = 100;// 新会员
				logger.debug("<<<<<<< 新会员");
			}
		}
		return result;
	}

	/**
	 * 获取当前店铺的审核状态
	 * 
	 * @param storeId
	 * @return 2, "运营商审批失败" 5, "平台待审" 6, "平台审核失败" 15, "正常营业" 20, "违规关闭"
	 */
	public int queryStoreAuditStatus(Long storeId) {
		storeId = storeId != null ? storeId : 0L;
		StoreBO store = this.storeDao.getStoreStatus(storeId);
		Integer storeStatus = 0;
		if (store != null) {
			storeStatus = store.getStoreStatus();
			String statesValue = StoreConstants.getMerchantStatusValue(storeStatus);
			logger.debug("<<<<<<< " + storeStatus + "->" + statesValue);
		}
		return storeStatus;
	}

	/**
	 * 判断用户类型 add by yuleijia on 2017.5.11
	 * 
	 * @return 0:普通用户 1：商户 2：供应商 3：运营商
	 */
	public Integer query_Customer_Type(Long uid) {
		logger.debug("<<<<<< uid->" + uid);
		Integer result = 0;
		StoreBO store = this.storeDao.getStoreByUserId(uid);
		if (store != null) {
			Boolean isShop = store.getIsShop();
			Boolean isO2o = store.getIsO2o();
			if (isShop) {
				logger.debug("[query_Customer_Type]-> is supplier");
				return UserContants.CUSTOMER_TYPE_SUPPLIER;
			}
			if (isO2o) {
				logger.debug("[query_Customer_Type]-> is merchant");
				return UserContants.CUSTOMER_TYPE_MERCHANT;
			}
		}
		OperatorBO operator = this.operatorDao.queryOperatorInfo(uid);
		if (operator != null) {
			logger.debug("[query_Customer_Type]-> is operator");
			return UserContants.CUSTOMER_TYPE_OPERATOR;
		}
		return result;
	}

	public List<UserAccount> findUserAccountByUids(List<Long> ids, String accountType) {
		return userAccountDao.findUserAccountByUids(ids, accountType);
	}
}
