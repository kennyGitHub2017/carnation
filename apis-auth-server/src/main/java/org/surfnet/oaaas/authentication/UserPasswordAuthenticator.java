package org.surfnet.oaaas.authentication;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.surfnet.oaaas.auth.AuthResponse;
import org.surfnet.oaaas.auth.ResourceOwnerAuthenticator;
import org.surfnet.oaaas.auth.ValidationResponseException;
import org.surfnet.oaaas.auth.principal.AuthenticatedPrincipal;
import org.surfnet.oaaas.contants.ScopeContant;
import org.surfnet.oaaas.model.Client;

import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.user.dao.OperatorDao;
import com.sinco.carnation.user.dao.SellerDao;
import com.sinco.carnation.user.model.Seller;

public class UserPasswordAuthenticator implements ResourceOwnerAuthenticator {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Inject
	private UserAccountDao userAccountDao;

	@Inject
	private UserDao userDao;

	@SuppressWarnings("unused")
	@Inject
	private OperatorDao operatorDao;

	@Inject
	private OrclUserAppBaseService orclUserAppBaseService;

	@Autowired
	private SellerDao sellerDao;

	@Resource(name = "storeDao")
	private StoreDao storeDao;

	private static AuthResponse loginNameError;
	private static AuthResponse userPassowrdError;
	private static AuthResponse userDisableError;
	private static AuthResponse operatorDisableError;
	private static AuthResponse operatorUserPassowrdError;
	private static AuthResponse isCnUserMobile;// 改手机是已绑定CN账号
	private static AuthResponse isShopError; // 供应商用户是否登录商户APP
	private static AuthResponse isMerchantError; // 是否为商户用户
	private static AuthResponse useMobileLoginMerchantApp;// 提示CN老用户且是商户的使用绑定的手机号进行登录
	private static AuthResponse notUseCNAccountLoginMerchantApp; // 提示非CN老用户不能使用CN账号登录商户APP

	private static final String PASSWORD_CRYPT_KEY_JG = "JgYeScOM_abc_12345678_kEHrDooxWHCWtfeSxvDvgqZq";

	static {
		loginNameError = new AuthResponse();
		loginNameError.setErrorCode("2");
		loginNameError.setMsg("Error authorize");
		loginNameError.setSubCode("loginNameOrPasswordError");
		loginNameError.setSubMsg("请检查您的手机号码是否输入正确");

		userPassowrdError = new AuthResponse();
		userPassowrdError.setErrorCode("2");
		userPassowrdError.setMsg("Error authorize");
		userPassowrdError.setSubCode("loginNameOrPasswordError");
		userPassowrdError.setSubMsg("您的手机号 或 密码有误，请重新输入！");

		userDisableError = new AuthResponse();
		userDisableError.setErrorCode("2");
		userDisableError.setMsg("Error authorize");
		userDisableError.setSubCode("userDisable");
		userDisableError.setSubMsg("用户已被禁用");

		operatorDisableError = new AuthResponse();
		operatorDisableError.setErrorCode("2");
		operatorDisableError.setMsg("Error authorize");
		operatorDisableError.setSubCode("operatorDisable");
		operatorDisableError.setSubMsg("帐号还未通过审核");

		operatorUserPassowrdError = new AuthResponse();
		operatorUserPassowrdError.setErrorCode("2");
		operatorUserPassowrdError.setMsg("Error authorize");
		operatorUserPassowrdError.setSubCode("operatorUserPassowrd");
		operatorUserPassowrdError.setSubMsg("您的帐号或密码错误，请重新输入");

		isCnUserMobile = new AuthResponse();
		isCnUserMobile.setErrorCode("2");
		isCnUserMobile.setMsg("Error authorize");
		isCnUserMobile.setSubCode("isCnUserMobile");
		isCnUserMobile.setSubMsg("手机已绑定CN账号，请从CN入口登录");

		isShopError = new AuthResponse();
		isShopError.setErrorCode("2");
		isShopError.setMsg("Error authorize");
		isShopError.setSubCode("isShopError");
		isShopError.setSubMsg("供应商用户不能登录商户APP");

		isMerchantError = new AuthResponse();
		isMerchantError.setErrorCode("2");
		isMerchantError.setMsg("Error authorize");
		isMerchantError.setSubCode("isMerchantError");
		isMerchantError.setSubMsg("老板等不及了吧，可惜只差一步，请先入驻！");

		useMobileLoginMerchantApp = new AuthResponse();
		useMobileLoginMerchantApp.setErrorCode("2");
		useMobileLoginMerchantApp.setMsg("Error authorize");
		useMobileLoginMerchantApp.setSubCode("useMobileLoginMerchantApp");
		useMobileLoginMerchantApp.setSubMsg("系统更新，请用CN账号绑定的手机号码登录，密码不变！");

		notUseCNAccountLoginMerchantApp = new AuthResponse();
		notUseCNAccountLoginMerchantApp.setErrorCode("2");
		notUseCNAccountLoginMerchantApp.setMsg("Error authorize");
		notUseCNAccountLoginMerchantApp.setSubCode("notUseCNAccountLoginMerchantApp");
		notUseCNAccountLoginMerchantApp.setSubMsg("系统更新，不支持使用CN账号或已绑定手机号码的非商户CN账号登录商户APP！");
	}

	@Override
	public AuthenticatedPrincipal authenticate(Client client, String username, String password)
			throws ValidationResponseException {

		logger.debug("=============== authenticate ============");
		boolean desFlag = false;
		if (username.endsWith("_")) {
			desFlag = true;
			username = username.substring(0, username.lastIndexOf("_"));
		}
		String accountPassword = null;
		String source = ""; // 账户登录来源（resource 会员端、 merchant 商户端、operator 供应商端、cn CN账户、yy YY账户）
		String cnpassword = "";
		UserAccountBO account = null;
		username = username.trim();
		String cn_username = username.toUpperCase();
		if (cn_username != null && cn_username.startsWith(UserContant.ACCOUNT_TYPE_CN)) {
			String password_ = password;
			try {
				password_ = Des.decrypt(password, PASSWORD_CRYPT_KEY_JG);
			} catch (Exception e) {
				throw new RuntimeException("解密错误！");
			}
			username = cn_username;
			account = orclUserAppBaseService.getOrclUser(cn_username, password_, client.getScopes());
			if (account != null) {
				cnpassword = account.getPassword();
			}
		} else {
			account = userAccountDao.queryByLoginName(username);
		}
		if (account == null) {
			// 是手机账户，个人或商户
			if (username.length() == 11)
				throw new ValidationResponseException(loginNameError);
			else
				// 营运商
				throw new ValidationResponseException(operatorUserPassowrdError);

		} else {

			// 获取请求APP类型
			String clientID = client.getClientId() != null ? client.getClientId() : "";
			// 是否为商户APP
			int hasMerchantState = clientID.indexOf(UserContant.ACCOUNT_TYPE_MERCHANT);

			// 判断该手机是否绑定CN账号，如绑定则提示到CN入口登录(非商户APP)
			if (username.length() == 11 && !username.startsWith(UserContant.ACCOUNT_TYPE_CN)
					&& hasMerchantState < 0) {
				UserAccountBO vo = new UserAccountBO();
				vo.setAccountType(UserContant.ACCOUNT_TYPE_8);
				vo.setUid(account.getUid());
				UserAccountBO account_ = userAccountDao.findAccountByVo(vo);
				if (account_ != null) {
					throw new ValidationResponseException(isCnUserMobile);
				}
			}
			// add by yuleijia on 2017.4.14
			// 商户APP -> 使用CN账号登录
			// 1.如果使用CN账号登录且已绑定手机号码+商户（老数据）则提示用户使用绑定的手机号码进行登录登录操作 密码不变
			// 2.如果使用CN账号登录已绑定手机号码（或没绑定）是商户（或非商户）则提示不能进行登录操作
			if (username.startsWith(UserContant.ACCOUNT_TYPE_CN) && hasMerchantState > 0) {
				logger.debug("=========== Merchant APP-> Use CN Account Login userName->" + username);
				long uid = account.getUid();
				Integer result = this.queryUserAccountIsMobileAndMerchat(uid);
				if (result == 0 || result == 2) {
					// 没绑定手机号码 || 绑定手机但非商户 -> 不能使用CN账号登录商户APP
					throw new ValidationResponseException(notUseCNAccountLoginMerchantApp);
				} else if (result == 1) {
					// 商户->提示用户使用绑定的手机号码登录
					throw new ValidationResponseException(useMobileLoginMerchantApp);
				}

			}

		}

		User user = userDao.findById(account.getUid());
		if (user == null) {
			throw new ValidationResponseException(loginNameError);
		}
		boolean phoneIsBingCN = Boolean.FALSE;
		if (!(account.getAccountType().equals("3") || account.getAccountType().equals("4") || account
				.getAccountType().equals("5"))) {
			// String origalPassword = null;
			// 将客户端加密的password进行对称解密为原密码
			if (desFlag) {
				try {
					password = Des.decrypt(password, PASSWORD_CRYPT_KEY_JG);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// clientID 验证来源（包含resource 会员端、 merchant 商户端、operator 供应商端）
			String clientID = "";
			String cn_accountPassword = "";
			if (null != client) {
				clientID = client.getClientId();
			}
			if (clientID.indexOf(UserContant.ACCOUNT_TYPE_RESOURCE) > 0) {// 普通会员端登录
				accountPassword = account.getPassword();
				source = UserContant.ACCOUNT_TYPE_RESOURCE;
			} else if (clientID.indexOf(UserContant.ACCOUNT_TYPE_MERCHANT) > 0) {// 商户端登录
				logger.debug("============ Merchant APP =============");
				// add by yuleijia on 2017.4.14
				// 处理老数据：老用户不能使用CN账号进行登录 使用手号码登录 密码为CN账号对应的密码
				UserAccountBO userAccountVo = new UserAccountBO();
				userAccountVo.setUid(account.getUid());
				userAccountVo.setAccountType(UserContant.ACCOUNT_TYPE_8);
				UserAccountBO cn_UserAccountBO = this.userAccountDao.findAccountByVo(userAccountVo);
				if (cn_UserAccountBO != null) {
					UserAccountBO CNObj = orclUserAppBaseService.getOrclUser(cn_UserAccountBO.getLoginName(),
							password, client.getScopes());
					if (null != CNObj && null != CNObj.getPassword()) {
						phoneIsBingCN = Boolean.TRUE;
						cn_accountPassword = CNObj.getPassword(); // 老数据：CN账号对应的密码
					} else {
						logger.error(">>>>>>>>>>>> 登录CN账号接口异常 <<<<<<<<<<<");
						throw new ValidationResponseException(userPassowrdError);
					}

				} else {
					accountPassword = account.getSellerPassword();
				}
				source = UserContant.ACCOUNT_TYPE_MERCHANT;
			}
			// 校验密码
			if (username != null && username.startsWith(UserContant.ACCOUNT_TYPE_CN)) {// CN账户
				if (!PasswordUtils.validateCNPassword(password, cnpassword)) {
					if (user.getUserType() == 3)
						throw new ValidationResponseException(operatorUserPassowrdError);
					else
						throw new ValidationResponseException(userPassowrdError);
				}
				source = UserContant.ACCOUNT_TYPE_CN;
			} else if (username != null
					&& (username.startsWith(UserContant.ACCOUNT_TYPE_YY) || username
							.startsWith(UserContant.ACCOUNT_TYPE_SN))) {// YY账户
				if (!PasswordUtils.validatePassword(password, account.getOperatorPassword())&&
						!PasswordUtils.validatePassword(password, account.getPassword())) {
					if (user.getUserType() == 3)
						throw new ValidationResponseException(operatorUserPassowrdError);
					else
						throw new ValidationResponseException(userPassowrdError);
				}
				source = UserContant.ACCOUNT_TYPE_YY;
			} else {
				Boolean validatePwd = Boolean.FALSE;
				if (phoneIsBingCN) {
					logger.debug("=========== phoneIsBingCN true");
					validatePwd = (!PasswordUtils.validateCNPassword(password, cn_accountPassword));
				} else {
					logger.debug("=========== phoneIsBingCN false");
					validatePwd = (!PasswordUtils.validatePassword(password, accountPassword));
				}
				if (validatePwd) {// 普通会员或商户
					if (user.getUserType() == 3)
						throw new ValidationResponseException(operatorUserPassowrdError);
					else
						throw new ValidationResponseException(userPassowrdError);
				}
				/*if (!PasswordUtils.validatePassword(password, accountPassword)) {// 普通会员或商户   //旧数据 2017.4.25
					if (user.getUserType() == 3)
						throw new ValidationResponseException(operatorUserPassowrdError);
					else
						throw new ValidationResponseException(userPassowrdError);
				}*/
			}

			/*
			 * if (!PasswordUtils.validatePassword(password,
			 * account.getPassword())) { if(user.getUserType() == 3) throw new
			 * ValidationResponseException(operatorUserPassowrdError); else
			 * throw new ValidationResponseException(userPassowrdError); }
			 */
		}

		// 用户被禁用
		if (user != null && user.getStatus() == 2) {
			throw new ValidationResponseException(userDisableError);
		}
		if (null != client) {
			// carnation-merchant-android/carnation-merchant-ios
			String clientID = client.getClientId();
			int be = clientID.indexOf("merchant");
			// 判断是否为商户APP登录请求 如果是则判断登录用户是否为供应商
			// add by yuleijia
			if (be > 0) {
				logger.debug("======== Req is Seller App ========");
				long uid = user.getId();
				Seller seller = this.sellerDao.findByUid(uid);
				//Seller seller = this.sellerDao.findSessionById(uid, true, false);//修改
				if (seller != null) {
					long storeID = seller.getStoreId();
					StoreBO store = this.storeDao.getStoreStatus(storeID);
					if (store != null) {
						Boolean isShop = store.getIsShop();
						if (isShop != null && isShop == true) {
							logger.debug("======== User is Supplier ========");
							// 供应商不能登录商户App
							throw new ValidationResponseException(isShopError);
						}
						Boolean isO2O = store.getIsO2o();
						if (isO2O) {
							/*
							 * 审核失败或审核中，商户登录时提示还不是入驻商户，提示申请入驻，按入驻流程走，然后进入审核页面
								1, "运营商待审"
								2, "运营商审批失败"
								5, "平台待审"
								6, "平台审核失败"
								15, "正常营业"
								20, "违规关闭"
							*/
							boolean isWeChat = this.queryWeChatAccountUser(username, account.getUid());
							if (!isWeChat) // 非微信登录商户APP时 做审核状态检查
							{
								int storeStatus = store.getStoreStatus();
								if (storeStatus == 5 || storeStatus == 6 || storeStatus == 20) {
									logger.debug("<<<<<<<<<<< "
											+ StoreConstants.getMerchantStatusValue(storeStatus));
									throw new ValidationResponseException(isMerchantError);
								}
							}
						}
					}
				} else {
					boolean isWeChat = this.queryWeChatAccountUser(username, account.getUid());
					// 如果不是使用微信号登陆 则进行校验
					// 如果使用微信号进行登陆时 则不进行校验
					// （商户入驻申请-微信授权-已会员+绑定手机-填写入驻申请-提交时需要用微信号进行登录以此获取token得到用户uid）
					if (!isWeChat) {
						// add by yuleijia on 2017.4.14
						// 当前用户不是商户未入驻
						// 非商户提示入驻
						// 是商户加入商户首页
						logger.debug("======== User is Not Merchant ========");
						throw new ValidationResponseException(isMerchantError);
					}
				}
			}
			List<String> scopes = client.getScopes();
			if (CollectionUtils.isNotEmpty(scopes)) {
				switch (user.getUserType()) {
					case 1: // 用户类型为个人用户
						if (scopes.contains(ScopeContant.SCOPE_BUYER)
								|| scopes.contains(ScopeContant.SCOPE_SELLER)) {
							break;
						}
						throw new ValidationResponseException(userPassowrdError);
					case 4:// 用户类型为运营商
						if (scopes.contains(ScopeContant.SCOPE_OPERATOR)
								|| scopes.contains(ScopeContant.SCOPE_BUYER)
								|| scopes.contains(ScopeContant.SCOPE_SELLER)) {
							break;
						}
						throw new ValidationResponseException(userPassowrdError);
					default:
						throw new ValidationResponseException(userPassowrdError);
				}
			}
		}
		AuthenticatedPrincipal principal = new AuthenticatedPrincipal(username);
		principal.addAttribute("uid", String.valueOf(account.getUid()));
		principal.addAttribute("source", source);
		return principal;
	}

	/**
	 * 针对商户APP 查询用户是否绑定手机号码且为商户
	 * 
	 * @param uid
	 *            用户ID
	 * @return 0：没绑定手机号码 1：商户且绑定手机号码 2：绑定手机号码但不是商户
	 */
	@SuppressWarnings("unused")
	private Integer queryUserAccountIsMobileAndMerchat(Long uid) {
		Integer result = 0;
		UserAccountBO bo = new UserAccountBO();
		bo.setUid(uid);
		bo.setAccountType(UserContant.ACCOUNT_TYPE_2);
		UserAccountBO account = userAccountDao.findAccountByVo(bo);
		if (account != null) {
			long userID = account.getUid();
			//StoreBO store = this.storeDao.queryStoreInfo(userID);//修改
			StoreBO store = this.storeDao.queryStoreInfo(uid, true, false);
			
			if (store == null) {
				result = 2; // 不是商户
				return result;
			}
			Long storeID = store.getId();
			if (storeID != null) {
				Boolean resultBoo = this.queryUserAccoutIsO2O(storeID);
				if (resultBoo) {
					result = 1;// 是商户
				} else {
					result = 2; // 不是商户
				}
			}
		}
		return result;
	}

	/**
	 * 针对商户APP 判断用户是否为商户
	 * 
	 * @param storeId
	 * @return
	 */
	private boolean queryUserAccoutIsO2O(Long storeId) {
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

	private Boolean queryWeChatAccountUser(String userName, Long uid) {
		Boolean hasWeChat = Boolean.FALSE;
		UserAccountBO wxUserAccountBO = new UserAccountBO();
		wxUserAccountBO.setUid(uid);
		wxUserAccountBO.setAccountType(UserContant.ACCOUNT_TYPE_4);
		wxUserAccountBO.setLoginName(userName);
		UserAccountBO cn_UserAccountBO = this.userAccountDao.findAccountByVo(wxUserAccountBO);
		if (cn_UserAccountBO != null) {
			hasWeChat = Boolean.TRUE;
		}
		return hasWeChat;
	}

	public static void main(String[] args) throws Exception {
		String t = "carnation-merchant-android";
		System.out.println(t.indexOf("ios"));

		String name = "13424263022";
		System.out.println(name.length() == 11);
		System.out.println(name.startsWith(UserContant.ACCOUNT_TYPE_CN));

		System.out.println(Des.encrypt("123456", PASSWORD_CRYPT_KEY_JG));

		System.out.println(Des.encrypt("659de35d596e9c367d196b0e50281ff7ad8666e827c1d1808761f6ae",
				PASSWORD_CRYPT_KEY_JG));
	}
}
