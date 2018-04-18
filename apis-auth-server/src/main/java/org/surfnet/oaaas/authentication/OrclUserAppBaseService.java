package org.surfnet.oaaas.authentication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.surfnet.oaaas.contants.ScopeContant;

import vc.thinker.b2b2c.core.tools.Md5Encrypt;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinco.biz.common.orcl.OrclService;
import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.orcl.OrclUserBO;
import com.sinco.carnation.sys.constant.OrclSchmaNameConstants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.AccessoryDao;
import com.sinco.carnation.sys.dao.RoleDao;
import com.sinco.carnation.sys.dao.SysConfigDao;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.dao.UserRoleDao;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.model.UserRole;
import com.sinco.carnation.sys.tools.CodeTools;
import com.sinco.carnation.sys.tools.JsonUtil;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.dao.AlbumDao;
import com.sinco.carnation.user.dao.OperatorDao;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.dao.UserMoneyDao;
import com.sinco.carnation.user.model.Album;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.model.UserMoney;
import com.sinco.common.utils.StringUtils;

/**
 * CN账户基础服务
 * 
 * @author Administrator
 * 
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OrclUserAppBaseService {
	@Autowired
	private UserAccountDao userAccountDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private OperatorDao operatorDao;

	@Autowired
	private UserCustomerDao userCustomerDao;

	@Autowired
	private AlbumDao albumDao;

	@Autowired
	private OrclService orclService;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserRoleDao urDao;

	@Autowired
	private UserMoneyDao moneyDao;

	@Autowired
	private SysConfigDao sysConfigDAO;

	@Autowired
	private AccessoryDao accessoryDao;

	@Autowired
	private CodeTools codeTools;

//	@Autowired
//	private OperatorService operatorService;

	/**
	 * 获取CN会员信息
	 * 
	 * @param loginName
	 * @return
	 */

	@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
	public UserAccountBO getOrclUser(String loginName, String password, List<String> scopes) {
		UserAccountBO user = new UserAccountBO();
		Map map = new HashMap();
		map.put("USER_ALIAS", loginName);
		if (password == null || password == "") {
			return null;
		}
		password = Md5Encrypt.md5(password).toLowerCase();
		map.put("PASSWORD1", password);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_LOGIN, map);
		JSONObject json1 = (JSONObject) JSONObject.parse(result);
		String issucces = json1.getString("result");
		JSONObject json00 = null;
		OrclUserBO userBo = null;
		if ("success".equals(issucces)) {
			JSONArray jsonArr = json1.getJSONArray("data");
			if (!jsonArr.isEmpty()) {
				json00 = jsonArr.getJSONObject(0);
				userBo = (OrclUserBO) JsonUtil.getObject4JsonString(json00.toString(), OrclUserBO.class);
			}
			if (userBo != null && userBo.getISLOGIN() == 1) {
				user.setLoginName(userBo.getUSER_ALIAS());
				user.setPassword(userBo.getPASSWORD());
				user.setIsDeleted(false);
				user.setAccountType(UserContant.ACCOUNT_TYPE_8);
				if (scopes.contains(ScopeContant.SCOPE_BUYER)) {
					user = this.insertOrclUser(user);
				} else if (scopes.contains(ScopeContant.SCOPE_OPERATOR)) {
					user = this.insertOrclOperator(user);
				}
//		        operatorService.updateCnLevel(userBo.getUSER_ALIAS());//每次登陆更新CN运营商等级信息
			} else {
				user = null;
			}
			return user;
		} else {
			System.out.println("oracle登录接口异常======");
			return null;
		}
	}

	/**
	 * 用户首次登录-初始化CN账户信息，生成相应的映射信息
	 * 
	 * @param user
	 */

	public UserAccountBO insertOrclUser(UserAccountBO user) {
		// UserAccountBO userbo=userAccountDao.fetchByLoginName(user.getLoginName());
		UserAccountBO userbo = userAccountDao.selectAcocountByCnUserAlias(user.getLoginName());
		if (!StringUtils.isEmpty(user.getLoginName())
				&& user.getLoginName().startsWith(UserContant.ACCOUNT_TYPE_CN) && userbo == null) {// 需要生成相应信息
			Long uid = this.createOrclUser(UserContant.USER_TYPE_4, UserContant.ACCOUNT_TYPE_8,
					user.getLoginName());
			user.setUid(uid);
			// 创建用户信息
			this.createCNCustomer(uid, null, user.getLoginName(), user.getLoginName(), null, null, null);
			return user;
		} else if (null != userbo && StringUtils.isEmpty(userbo.getUserID())) {
			this.createCNCustomer(userbo.getUid(), null, user.getLoginName(), user.getLoginName(), null,
					null, null);
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

	public Long createOrclUser(Integer userType, String accountType, String loginName) {
		try {
			User user = new User();
			user.setIsDeleted(false);
			user.setRegistIp("10000");
			user.setStatus(UserContant.USER_STATUS_1);
			user.setUserType(userType);// orcl用户
			user.setInvitationCode(codeTools.getInvitationCode());
			userDao.insert(user);

			UserAccount account = new UserAccount();
			account.setLoginName(loginName);
			account.setAccountType(accountType);
			account.setIsDeleted(false);
			account.setUid(user.getId());
			userAccountDao.insert(account);
			return user.getId();
		} catch (Exception e) {
			// 如果注释掉throw new RuntimeException，那么事务将不能回滚，因为spring捕捉不到Exception
			// 解决办法，去掉try catch，或者在cache中抛出异常以便spring捕获
			throw new RuntimeException("运行时出错！");
		}

	}

	public int createCNCustomer(Long uid, String mobile, String nicName, String name, String email,
			Integer sex, Long refereeUserId) {
		// 创建用户默认相册
		Album album = new Album();
		album.setAlbumDefault(true);
		album.setAlbumName("默认相册");
		album.setAlbumSequence(-10000);
		album.setAddTime(new Date());
		album.setUserId(uid);
		album.setAlbumDefault(false);
		albumDao.save(album);

		// 添加买家权限
		List<RoleBO> roles = this.roleDao.findByType(UserContant.ROLE_TYPE_BUYER);
		List<Long> rids = new ArrayList<Long>();
		for (RoleBO roleBO : roles) {
			rids.add(roleBO.getId());
		}
		this.saveUserRole(uid, UserContant.ROLE_TYPE_BUYER, rids.toArray(new Long[rids.size()]));

		/*UserMoney money = new UserMoney();
		money.setAvailableBalance(new BigDecimal(0));
		money.setUid(uid);
		this.moneyDao.create(money);*/
		// 创建用户钱包
		isExistAndCreate(uid);
		Map<String, String> map = new HashMap<String, String>();
		map.put("cn_username", nicName);
		String extend = Json.toJson(map, JsonFormat.compact());
		// 创建用户信息
		UserCustomer customer = new UserCustomer();
		customer.setFreezeBlance(BigDecimal.valueOf(0));
		customer.setUid(uid);
		customer.setMobile(mobile);
		customer.setNickname(nicName);
		customer.setName(name);
		customer.setEmail(email);
		customer.setSex(sex);
		customer.setCreateTime(new Date());
		customer.setIsDeleted(false);
		customer.setStatus("1");
		customer.setExtend(extend);
		// 设置用户默认头像
		Accessory as = accessoryDao.findOne(sysConfigDAO.findAll().get(0).getMemberIconId());
		if (as != null) {
			customer.setHeadImgPath(as.getPath());
		}
		int result = userCustomerDao.insert(customer);
		// 添加积分
		// integralService.addIntegral(IntegralConstants.INTEGRAL_REGISTER, uid, uid);
		// 推荐人也赠送积分
		// if (refereeUserId != null && refereeUserId>0)
		// integralService.addIntegral(IntegralConstants.INTEGRAL_REGISTER_INVITATION, refereeUserId, uid);

		return result;
	}

	public void saveUserRole(Long uid, String roleType, Long[] rids) {
		User user = userDao.findById(uid);
		if (user != null) {
			urDao.deleteByRoleTypeAndUid(uid, roleType);

			List<UserRole> urs = new ArrayList<UserRole>();
			for (Long rid : rids) {
				UserRole ur = new UserRole();
				ur.setRoleId(rid);
				ur.setUserId(uid);
				urs.add(ur);
			}
			urDao.save(urs);
		}
	}

	/**
	 * 用户首次登录运营商app-初始化CN账户信息，生成相应的映射信息
	 * 
	 * @param user
	 */

	public UserAccountBO insertOrclOperator(UserAccountBO user) {
		// OperatorBO operatorBO=operatorDao.selectOperatorByCnUserName(user.getLoginName());
		UserAccountBO userbo = userAccountDao.selectAcocountOperatorByCnUserAlias(user.getLoginName());
		if (!StringUtils.isEmpty(user.getLoginName()) && userbo == null) {
			Long uid = this.saveCnOperator(user.getLoginName());
			user.setUid(uid);
			return user;
		} else if (null != userbo && StringUtils.isEmpty(userbo.getUserID())) {
			this.saveOperatorBase(user.getLoginName(), userbo.getUid());
			user.setUid(userbo.getUid());
			return user;
		} else {
			if (null == userbo || null == userbo.getUserID()) {
				return null;
			}
			user.setUid(userbo.getUid());
			return user;
		}
	}

	/**
	 * 添加运营商信息
	 * 
	 * @param username
	 * @return
	 */
	public Long saveCnOperator(String username) {
		OperatorBO operatorBO = new OperatorBO();
		// account为空，先添加account,再添加运营商
		operatorBO.setOperatorCode(username);
		Long userId = this.createOrclUser(UserContant.USER_TYPE_4, UserContant.ACCOUNT_TYPE_8,
				operatorBO.getOperatorCode());
		if (userId > 0) {
			return this.saveOperatorBase(username, userId);
		} else {
			return null;
		}
	}

	/**
	 * 保存运营商主表
	 * 
	 * @param username
	 * @param userId
	 * @return
	 */
	public Long saveOperatorBase(String username, Long userId) {
		OperatorBO operatorBO = new OperatorBO();
		operatorBO.setOperatorCode(username);
		operatorBO.setCn_username(username);
		operatorBO.setUserName(username);
		operatorBO.setOperatorName(username);
		operatorBO.setUserId(userId);
		operatorBO.setAssignedTime(new Date());
		// operatorBO.setUpdateBy(null);
		operatorBO.setUpdateTime(new Date());
		operatorBO.setCreateBy("system_login");
		operatorBO.setCreateTime(new Date());
		// operatorBO.setStatus(UserContants.OPERATOR_CHECK_STATUS_PASS);
		operatorBO.setStatus(UserContants.OPERATOR_CHECK_STATUS_CHECKING); // 审核中状态
		operatorDao.save(operatorBO);
		this.isExistAndCreate(userId);
		return userId;
	}

	/**
	 * 初始化钱包
	 * 
	 * @param uid
	 * @return
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
}
