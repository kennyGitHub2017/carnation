package com.sinco.carnation.user.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.orcl.OrclService;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.pay.tools.OrclJsonTools;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.orcl.CnUserLevelBO;
import com.sinco.carnation.sys.bo.orcl.IntegralSwapBO;
import com.sinco.carnation.sys.bo.orcl.OrclUserBO;
import com.sinco.carnation.sys.constant.OrclSchmaNameConstants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.JsonUtil;
import com.sinco.common.utils.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vc.thinker.b2b2c.core.tools.Md5Encrypt;

/**
 * CN账户基础服务
 * 
 * @author Administrator
 * 
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class OrclUserBaseService {
	private static Logger logger = LoggerFactory.getLogger(OrclUserBaseService.class);
	@Autowired
	private UserService userService;

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private OrclService orclService;

	@Autowired
	private OperatorService operatorService;

	/**
	 * 获取CN会员信息
	 * 
	 * @param loginName
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked", "unused", "static-access"})
	public OrclUserBO getOrclUser(String loginName, String password) {
		UserAccountBO user = new UserAccountBO();
		Map map = new HashMap();
		map.put("USER_ALIAS", loginName);
		if (password == null || password == "") {
			return null;
		}
		password = Md5Encrypt.md5(password).toLowerCase();
		map.put("PASSWORD1", password);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_LOGIN, map);
		JSONObject json1 = JSONObject.fromObject(result);
		String issucces = json1.getString("result");
		JSONObject json00 = null;
		OrclUserBO userBo = null;
		if ("success".equals(issucces)) {
			JSONArray jsonArr = json1.getJSONArray("data");
			if (!jsonArr.isEmpty()) {
				json00 = jsonArr.getJSONObject(0);
				userBo = (OrclUserBO) JsonUtil.getObject4JsonString(json00.toString(), OrclUserBO.class);
			}
			return userBo;
		} else {
			System.out.println("oracle登录接口异常======" + json1);
			return null;
		}
	}

	/**
	 * 用户首次登录-初始化CN账户信息，生成相应的映射信息
	 * 
	 * @param user
	 */
	public UserAccountBO insertOrclUser(UserAccountBO user) {
		// UserAccountBO userbo=userAccountService.fetchByLoginName(user.getLoginName());
		UserAccountBO userbo = userAccountService.selectAcocountByCnUserAlias(user.getLoginName());
		if (!StringUtils.isEmpty(user.getLoginName())
				&& user.getLoginName().startsWith(UserContant.ACCOUNT_TYPE_CN) && userbo == null) {// 需要生成相应信息
			Long uid = userService.createOrclUser(UserContant.USER_TYPE_4, UserContant.ACCOUNT_TYPE_8,
					user.getLoginName());
			user.setUid(uid);
			// 创建用户信息
			customerService.createCNCustomer(uid, null, user.getLoginName(), user.getLoginName(), null, null,
					null);
			return user;
		} else if (null != userbo && StringUtils.isEmpty(userbo.getUserID())) {
			customerService.createCNCustomer(userbo.getUid(), null, user.getLoginName(), user.getLoginName(),
					null, null, null);
			user.setUid(userbo.getUid());
			return user;
		} else {
			if (null == userbo || null == userbo.getUid()) {
				return null;
			}
			user.setUid(userbo.getUid());
			return user;
		}
	}

	/**
	 * CN账号登录会员平台
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 */
	public UserAccountBO user_login(String loginName, String password) {
		UserAccountBO user = new UserAccountBO();
		OrclUserBO userBo = getOrclUser(loginName, password);
		if (userBo != null && userBo.getISLOGIN() == 1) {
			user.setLoginName(userBo.getUSER_ALIAS());
			user.setPassword(userBo.getPASSWORD());
			user.setIsDeleted(false);
			user = this.insertOrclUser(user);
		} else {
			user = null;
		}
		return user;
	}

	/**
	 * CN账户登录运营商系统
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public UserAccount operator_login(String userName, String password) {
		UserAccountBO user = new UserAccountBO();
		OrclUserBO userBo = getOrclUser(userName, password);
		if (userBo != null && userBo.getISLOGIN() == 1) {
			user.setLoginName(userBo.getUSER_ALIAS());
			user.setPassword(userBo.getPASSWORD());
			user.setIsDeleted(false);
			user = this.insertOrclOperator(user);// 首次登录初始化cn运营商信息
			operatorService.updateCnLevel(userName);// 每次登陆更新CN运营商等级信息
		} else {
			user = null;
		}
		return user;
	}

	/**
	 * CN用户首次登录运营商系统-初始化CN账户信息，生成相应的映射信息
	 * 
	 * @param user
	 */
	public UserAccountBO insertOrclOperator(UserAccountBO user) {
		// OperatorBO operatorBO=operatorService.selectOperatorByCnUserName(user.getLoginName());
		UserAccountBO userbo = userAccountService.selectAcocountOperatorByCnUserAlias(user.getLoginName());
		if (!StringUtils.isEmpty(user.getLoginName()) && userbo == null) {
			Long uid = operatorService.saveCnOperator(user.getLoginName());
			user.setUid(uid);
			return user;
		} else if (null != userbo && StringUtils.isEmpty(userbo.getUserID())) {
			// this.SaveOperatorBase(user.getLoginName(),userbo.getUid());
			operatorService.saveOperatorBase(user.getLoginName(), userbo.getUid());
			user.setUid(userbo.getUid());
			return user;
		} else {
			if (null == userbo || null == userbo.getUid()) {
				return null;
			}
			user.setUid(userbo.getUid());
			return user;
		}
	}

	/**
	 * 获取CN会员等级信息
	 * 
	 * @param loginName
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
	public CnUserLevelBO getOrclUserLevel(String user_alias) {
		Map map = new HashMap();
		map.put("USER_ALIAS", user_alias);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_TYPE, map);
		return (CnUserLevelBO) OrclJsonTools.handeljson(result, CnUserLevelBO.class);
	}

	/**
	 * 七步系统对接2
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 */
	public UserAccountBO user_seven_login(String loginName, String password) {
		UserAccountBO user = new UserAccountBO();
		OrclUserBO userBo = getSevenOrclUser(loginName, password);
		if (userBo != null && userBo.getISLOGIN() == 1) {
			logger.debug("userBo.getUSER_ID() {}", userBo.getISLOGIN());
			user.setLoginName(userBo.getUSER_ALIAS());
			user.setPassword(userBo.getPASSWORD());
			user.setIsDeleted(false);

		} else {
			user = null;
		}
		return user;
	}

	/***
	 * 七步系统对接1
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked", "unused", "static-access"})
	public OrclUserBO getSevenOrclUser(String loginName, String password) {
		UserAccountBO user = new UserAccountBO();
		Map map = new HashMap();
		map.put("USER_ALIAS", loginName);
		if (password == null || password == "") {
			return null;
		}
		password = Md5Encrypt.md5(password).toLowerCase();
		map.put("PASSWORD1", password);
		String result = orclService.getSevenOraclResult(OrclSchmaNameConstants.GET_USER_LOGIN, map);
		logger.debug("SEVEN SYSTEM LOGIN ACCOUNT{} RESULT {}",loginName, result);
		JSONObject json1 = JSONObject.fromObject(result);
		String issucces = json1.getString("result");
		JSONObject json00 = null;
		OrclUserBO userBo = null;
		if ("success".equals(issucces)) {
			JSONArray jsonArr = json1.getJSONArray("data");
			if (!jsonArr.isEmpty()) {
				json00 = jsonArr.getJSONObject(0);
				userBo = (OrclUserBO) JsonUtil.getObject4JsonString(json00.toString(), OrclUserBO.class);
			}
			return userBo;
		} else {
			logger.error("SEVEN SYSTEM LOGIN ERROR {}", json1);
			return null;
		}
	}
	
	/**
	 * 获取用户重消
	 * @param loginName 登陆用户
	 * @return
	 */
	public IntegralSwapBO getMyCXB(String loginName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("USER_ALIAS", loginName);
		String result = OrclService.getOrclResult(OrclSchmaNameConstants.GET_USER_ACCOUNT_3, map);
		logger.info("OrclUserBaseService->getMyCXB ACCOUNT{} RESULT {}", loginName, result);
		return (IntegralSwapBO) OrclJsonTools.handeljson(result, IntegralSwapBO.class);
	}
	
	/**
	 * 获取用户积分
	 * @param loginName 登陆用户
	 * @return
	 */
	public IntegralSwapBO getMyIntegral(String loginName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("USER_ALIAS", loginName);
		String result = OrclService.getOrclResult(OrclSchmaNameConstants.GET_USER_SHOP_PV_SUM, map);
		logger.info("OrclUserBaseService->getMyIntegral ACCOUNT{} RESULT {}", loginName, result);
		return (IntegralSwapBO) OrclJsonTools.handeljson(result, IntegralSwapBO.class);
	}
	
	/**
	 * 用户积分兑换
	 * @param loginName 登陆用户
	 * @param integral 需要兑换积分
	 * @param orderNo 订单流水号
	 * @return
	 */
	public IntegralSwapBO integralSwap(String loginName, String pwd, Integer integral, String orderNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("USER_ALIAS", loginName);
		map.put("SHOP_PV", integral);
		map.put("ORDERNO", orderNo);
		map.put("PASSWORD", pwd);
		String result = OrclService.getOrclResult(OrclSchmaNameConstants.GET_USER_RECHARGE_SHOP_PV, map);
		logger.info("OrclUserBaseService->integralSwap ACCOUNT{} RESULT {}", loginName, result);
		return (IntegralSwapBO) OrclJsonTools.handeljson(result, IntegralSwapBO.class);
	}
	
}
