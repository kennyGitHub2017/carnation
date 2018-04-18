package com.sinco.carnation.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.constant.Globals;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sinco.carnation.sys.bo.RelationBO;
import com.sinco.carnation.sys.bo.ResBO;
import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.RoleGroupBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.ResDao;
import com.sinco.carnation.sys.dao.RoleDao;
import com.sinco.carnation.sys.dao.RoleGroupDao;
import com.sinco.carnation.sys.dao.RoleResDao;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.dao.UserRoleDao;
import com.sinco.carnation.sys.model.Res;
import com.sinco.carnation.sys.model.RoleGroup;
import com.sinco.carnation.sys.model.RoleRes;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.model.UserRole;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.tools.CodeTools;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.bo.WxInvitationRelationBO;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.dao.UserRelationDao;
import com.sinco.carnation.user.dao.WxInvitationRelationDao;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.model.UserRelation;
import com.sinco.dal.common.MyPage;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserAccountDao accountDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserRoleDao urDao;

	@Autowired
	private RoleResDao rrDao;

	@Autowired
	private RoleService roleService;

	@Autowired
	private RoleGroupDao roleGroupDao;

	@Autowired
	private RoleResDao roleResDao;

	@Autowired
	private ResDao resDao;

	@Autowired
	private CodeTools codeTools;

	@Autowired
	private WxInvitationRelationDao weixinRelationDao;

	@Autowired
	private UserRelationDao userRelationDao;

	@Autowired
	private UserCustomerDao userCustomerDao;

	@Autowired
	private IntegralService integralService;

	/*
	 * @Autowired private UserRelationService userRelationService;
	 */

	/**
	 * 根据role code 查找
	 * 
	 * @param roleCode
	 * @return
	 */
	public List<RoleBO> findRoleByRoleCode(String roleCode) {
		return this.roleDao.findByRoleCode(roleCode);
	}

	/**
	 * 根据role type 查找
	 * 
	 * @param roleCode
	 * @return
	 */
	public List<RoleBO> findRoleByType(String... types) {
		return this.roleDao.findByType(types);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long createUser(Integer userType, String accountType, String loginName, String password,
			String requestIp) {

		User user = new User();
		user.setIsDeleted(false);
		user.setRegistIp(requestIp);
		user.setStatus(UserContant.USER_STATUS_1);
		user.setUserType(userType);
		user.setInvitationCode(codeTools.getInvitationCode());
		userDao.insert(user);

		UserAccount account = new UserAccount();
		account.setLoginName(loginName);
		account.setPassword(PasswordUtils.entryptPassword(password));
		// 添加供应商密码和商户密码（前期和会员密码一致）
		account.setSellerPassword(PasswordUtils.entryptPassword(password));
		account.setSupplierPassword(PasswordUtils.entryptPassword(password));
		account.setOperatorPassword(PasswordUtils.entryptPassword(password));
		account.setAccountType(accountType);
		account.setIsDeleted(false);
		account.setUid(user.getId());
		// 获取第三方账号nickname
		/*		if(accountType.equals("3")||accountType.equals("4")||accountType.equals("5")){
					account.setThirdNickName(this.bindingGetThirdNickName(accountType, token, loginName));
				}*/
		accountDao.insert(account);
		return user.getId();
	}

	/**
	 * 创建用户信息 用于微商城微信授权登陆 add by yuleijia
	 * 
	 * @param userType
	 * @param accountType
	 * @param loginName
	 * @param password
	 * @param requestIp
	 * @param openId
	 * @return
	 */
	// @Transactional(readOnly = false)
	public UserAccount createUser(Integer userType, String accountType, String unionid, String password,
			String requestIp, String openId) {

		User user = new User();
		user.setIsDeleted(false);
		user.setRegistIp(requestIp);
		user.setStatus(UserContant.USER_STATUS_1);
		user.setUserType(userType);
		user.setInvitationCode(codeTools.getInvitationCode());
		userDao.insert(user);

		UserAccount account = new UserAccount();
		account.setLoginName(unionid);
		account.setPassword(PasswordUtils.entryptPassword(password)); // 密码用unionid
		// 添加供应商密码和商户密码（前期和会员密码一致）
		account.setSellerPassword(PasswordUtils.entryptPassword(password));
		account.setSupplierPassword(PasswordUtils.entryptPassword(password));
		account.setOperatorPassword(PasswordUtils.entryptPassword(password));
		account.setAccountType(accountType);
		account.setIsDeleted(false);
		account.setUid(user.getId());
		account.setOpenId(openId);
		// 获取第三方账号nickname
		/*		if(accountType.equals("3")||accountType.equals("4")||accountType.equals("5")){
					account.setThirdNickName(this.bindingGetThirdNickName(accountType, token, unionid));
				}*/
		this.accountDao.insert(account);

		return account;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long createRelationUser(Integer userType, String accountType, String loginName, String password,
			String requestIp, Integer relationType) {

		User user = new User();
		user.setIsDeleted(false);
		user.setRegistIp(requestIp);
		user.setStatus(UserContant.USER_STATUS_1);
		user.setUserType(userType);
		user.setInvitationCode(codeTools.getInvitationCode());
		user.setRelationType(relationType);
		userDao.insert(user);

		UserAccount account = new UserAccount();
		account.setLoginName(loginName);
		account.setPassword(PasswordUtils.entryptPassword(password));
		// 添加供应商密码和商户密码（前期和会员密码一致）
		account.setSellerPassword(PasswordUtils.entryptPassword(password));
		account.setSupplierPassword(PasswordUtils.entryptPassword(password));
		account.setOperatorPassword(PasswordUtils.entryptPassword(password));
		account.setAccountType(accountType);
		account.setIsDeleted(false);
		account.setUid(user.getId());
		// 获取第三方账号nickname
		/*		if(accountType.equals("3")||accountType.equals("4")||accountType.equals("5")){
					account.setThirdNickName(this.bindingGetThirdNickName(accountType, token, loginName));
				}*/
		accountDao.insert(account);

		return user.getId();
	}

	/**
	 * 修改用户密码
	 * 
	 * @param uid
	 * @param password
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updatePassword(Long uid, String password) {
		UserAccount account = new UserAccount();
		account.setUid(uid);
		account.setPassword(PasswordUtils.entryptPassword(password));
		account.setUpdateTime(new Date());
		accountDao.updateChangePassword(account);
	}

	/**
	 * 根据不同的角色标识修改密码
	 * 
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updatePassword(Long userId, String password, String source) {
		UserAccount account = new UserAccount();
		setUserAccountPassword(password, source, account);
		account.setUpdateTime(new Date());
		account.setUid(userId);
		accountDao.passwordUpdate(account);
	}

	private void setUserAccountPassword(String password, String source, UserAccount account) {
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
		}
	}

	/**
	 * 保存用户的权限
	 * 
	 * @param uid
	 * @param rids
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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

	public UserBO getObjById(Long id) {
		return userDao.findById(id);
	}

	public UserBO findByLoginName(String loginName) {
		return userDao.findByLoginName(loginName);
	}

	public UserBO findByInvitationCode(String invitationCode) {
		return userDao.findByInvitationCode(invitationCode);
	}

	public RelationBO findRelationSidByInvitationCode(String invitationCode) {
		return userDao.findRelationSidByInvitationCode(invitationCode);
	}

	public List<RoleBO> findRoleByUid(Long uid) {
		return roleDao.findByUid(uid);
	}

	public List<RoleBO> findRoleByResId(Long resId) {
		return roleDao.findByResId(resId);
	}

	/**
	 * 根据类型查找 res
	 * 
	 * @param type
	 * @return
	 */
	public List<ResBO> findResByType(String type) {
		List<ResBO> ress = resDao.findByType(type);

		List<RoleBO> roleAll = roleDao.findByResType(type);
		Map<Long, RoleBO> roleMap = Maps.newHashMap();
		for (RoleBO roleBO : roleAll) {
			roleMap.put(roleBO.getId(), roleBO);
		}

		List<RoleRes> roleResAll = roleResDao.findByResType(type);

		for (ResBO res : ress) {
			List<RoleBO> roles = Lists.newArrayList();
			for (RoleRes roleRes : roleResAll) {
				if (res.getId().equals(roleRes.getResId())) {
					if (roleMap.containsKey(roleRes.getRoleId())) {
						roles.add(roleMap.get(roleRes.getRoleId()));
					}
				}
			}
			res.setRoles(roles);
		}

		return ress;
	}

	/**
	 * 初始化权限
	 * 
	 * @param mappings
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void initRole(List<SecurityMapping> mappings) {
		int sequence = 0;

		for (SecurityMapping mappin : mappings) {
			if (mappin.rcode().equals("admin_lucene")) {
				System.err.println("");
			}

			String value = mappin.value();
			List<ResBO> ress = this.resDao.findResByRoleType(mappin.rtype().toUpperCase(), value);
			if (ress.size() == 0) {
				Res res = new Res();
				res.setResName(mappin.title());
				res.setValue(value);
				res.setType("URL");
				res.setSequence(0);
				res.setAddTime(new Date());
				this.resDao.save(res);

				String roleCode = mappin.rcode();
				if (roleCode.indexOf("ROLE_") != 0) {
					roleCode = ("ROLE_" + roleCode).toUpperCase();
				}
				// 获取权限分组
				String groupName = mappin.rgroup();
				String type = mappin.rtype().toUpperCase();
				List<RoleGroupBO> rgs = this.roleGroupDao.findByTypeAndName(type, groupName);
				RoleGroup rg = null;
				if (rgs.size() > 0) {
					rg = rgs.get(0);
				}
				if (rg == null) {
					rg = new RoleGroup();
					rg.setAddTime(new Date());
					rg.setName(groupName);
					rg.setSequence(sequence);
					rg.setType(type);
					this.roleGroupDao.save(rg);
				}

				List<RoleBO> roles = this.roleDao.findByRoleCodeAndType(mappin.rtype().toUpperCase(),
						roleCode);

				RoleBO role = null;
				if (roles.size() > 0) {
					role = roles.get(0);

				} else {
					role = new RoleBO();
					role.setRoleName(mappin.rname());
					role.setRgId(rg.getId());
					role.setRoleCode(roleCode.toUpperCase());
					role.setSequence(sequence);
					role.setAddTime(new Date());
					role.setSequence(0);
					role.setDisplay(mappin.display());
					role.setType(mappin.rtype().toUpperCase());
					this.roleService.save(role);
				}

				try {
					RoleRes rr = new RoleRes();
					rr.setResId(res.getId());
					rr.setRoleId(role.getId());
					this.rrDao.save(rr);
				} catch (DataAccessException e) {
				}

				sequence++;
			}
		}
	}

	public List<User> findAll() {
		return userDao.findByVO(null);
	}

	public UserBO findById(Long userId) {
		return userDao.findById(userId);
	}

	public UserAccountBO findByLoginName(String loginName, String accountType) {
		return accountDao.findByMobile(loginName, accountType);
	}

	public UserBO fetchRefereeUser(Long userId) {
		return userDao.fetchRefereeUser(userId);
	}

	/**
	 * 用户绑定第三方id--所有创建第三方account表记录都会经过这里
	 * 
	 * @param loginName
	 * @param password
	 * @param accountType
	 * @param uid
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int bindingUser(String loginName, String password, String accountType, Long uid) {
		// 微信注册，需要查找推荐关系
		if (UserContant.ACCOUNT_TYPE_4.equals(accountType)) {
			// 通过 openid 查找微信的荐关系
			WxInvitationRelationBO wxRelation = weixinRelationDao.findByUnionId(loginName);// unionId
			if (wxRelation != null) {
				// 绑定真实的推荐关系（需要判断）
				UserRelationBO userRelationBO = userRelationDao.findOne(uid);

				if (userRelationBO == null || userRelationBO.getRefereeUserId() == null
						|| userRelationBO.getRefereeUserId() <= 0L) {
					// 创建user_relation关系
					this.createUserRelation(uid, wxRelation.getOwnerId(), null);

				}
			}
		}
		UserAccount account = new UserAccount();
		account.setLoginName(loginName);
		String psd = null;
		if (CommUtil.isNotNull(password)) {
			psd = PasswordUtils.entryptPassword(password);

		} else {
			psd = PasswordUtils.entryptPassword(loginName);
		}
		// 保存密码
		account.setPassword(psd);
		account.setOperatorPassword(psd);
		account.setSellerPassword(psd);
		account.setSupplierPassword(psd);

		account.setAccountType(accountType);
		account.setIsDeleted(false);
		account.setUid(uid);
		/*account.set;*/
		// 获取第三方账号nickname
		/*		if(accountType.equals("3")||accountType.equals("4")||accountType.equals("5")){
					account.setThirdNickName(this.bindingGetThirdNickName(accountType, token, loginName));
				}*/
		int returnint = accountDao.insert(account);
		return returnint;
	}

	/**
	 * 更新用户手机号
	 * 
	 * @param loginName
	 * @param password
	 * @param accountType
	 * @param uid
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateMobile(Long uid, String Mobile) {
		UserCustomer customer = new UserCustomer();
		customer.setUid(uid);
		customer.setMobile(Mobile);
		userCustomerDao.updateById(customer);
	}

	public void findRefereeUserList(Long userId, MyPage<UserBO> page) {
		userDao.findRefereeUserList(userId, page);
	}

	public User queryUserById(Long userId) {
		return userDao.queryUserById(userId);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createUserRelation(Long userId, Long refereeUserId, Long sellerUserId) {
		if (accountDao.findByUid(userId, UserContant.ACCOUNT_TYPE_8) != null) {// CN账号无法被邀请
			refereeUserId = null;
		}
		UserRelation relation = new UserRelation();

		relation.setUserId(userId);
		relation.setRefereeUserId(refereeUserId);
		if (sellerUserId != null) {
			relation.setSellerUserId(sellerUserId);
		}
		relation.setUpdateTime(new Date());
		relation.setCreateTime(new Date());

		UserRelationBO r = userRelationDao.queryUserRation(userId);
		if (r == null) {
			userRelationDao.insertSelective(relation);
		} else {
			userRelationDao.update(relation);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long createOrclUser(Integer userType, String accountType, String loginName) {
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
		// 获取第三方账号nickname
		/*		if(accountType.equals("3")||accountType.equals("4")||accountType.equals("5")){
					account.setThirdNickName(this.bindingGetThirdNickName(accountType, token, loginName));
				}*/
		accountDao.insert(account);

		return user.getId();
	}

	/**
	 * 第三方登录创建用户 sys_user
	 * 
	 * @param userType
	 *            用户类型 1 个人、商户 3专家 4运营商 9 后台管理员
	 * @param accountType
	 *            账户类型 1:邮箱 2:手机3:QQ4:微信5:微博 9:用户名 8:CN账户
	 * @param openid
	 *            微信是UnionId 其他是OpenId
	 * @param requestIp
	 *            注册id
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long createUser3(Integer userType, String accountType, String openid, String requestIp) {
		User user = new User();
		user.setIsDeleted(false);
		user.setRegistIp(requestIp);
		user.setStatus(UserContant.USER_STATUS_1);
		user.setUserType(userType);
		user.setInvitationCode(codeTools.getInvitationCode());
		userDao.insert(user);

		return user.getId();
	}

	public static void main(String[] args) {
		System.out.println(PasswordUtils.entryptPassword("123456"));
	}

	/**
	 * 第三方绑定增加操作 1.加积分 2.获取第三方ThirdNickName
	 * 
	 * @param accountType
	 *            绑定第三方账户类型
	 * @param uid
	 *            用户ID
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void bindingThirdDo(String accountType, Long uid, String loginName) {
		// 1.加积分
		this.bindingAddIntegeal(accountType, uid);
		// 2.获取第三方ThirdNickName
	}

	/**
	 * 第三方绑定加积分
	 * 
	 * @param accountType
	 * @param uid
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void bindingAddIntegeal(String accountType, Long uid) {
		switch (accountType) {
			case "2":
				integralService.addIntegral(IntegralConstants.INTEGRAL_BANGDING_MOBILE, uid, null);
				break;
			case "3":
				integralService.addIntegral(IntegralConstants.INTEGRAL_BANGDING_WEIBO, uid, null);
				break;
			case "4":
				integralService.addIntegral(IntegralConstants.INTEGRAL_BANGDING_WECHAT, uid, null);
				break;
			case "5":
				integralService.addIntegral(IntegralConstants.INTEGRAL_BANGDING_XIELUNYAN, uid, null);
				break;
			default:
		}
	}

	/**
	 * 获取第三方ThirdNickName
	 * 
	 * @param accountType
	 * @param loginName
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String bindingGetThirdNickName(String accountType, String token, String openid) {
		String nickName = null;
		/*if(StringUtils.isNotBlank(token)||StringUtils.isNotBlank(openid)){
			switch (accountType) {
			case "3"://QQ
				return TokenAuthUtils.getWeixin_UserNickName(token, openid);
			case "4"://WX
				return tokenAuthUtils.getQQ_UserNickName(token, openid);
			case "5"://WB
				return TokenAuthUtils.getWeibo_UserNickName(token, openid);
			default:
			}
		}*/
		return nickName;
	}

	public Long countUserRegister(Boolean isDeleted) {
		if (isDeleted != null) {
			return this.userDao.countUserRegister(isDeleted);
		}
		return null;
	}

	/**
	 * 账号清除（假删除）
	 * 
	 * @param uid
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updateUserIsDeleted(String uid, Long currentUserID, boolean isDeleted) {
		long uidL = Long.valueOf(uid);
		UserBO userBo = this.userDao.findById(uidL);
		if (userBo != null && userBo.getId() != 0l) {
			this.userDao.updateUserForIsDeleted(uidL, currentUserID, isDeleted);
			this.accountDao.updateUserAccountForIsDeleted(uidL, currentUserID, isDeleted);
			this.userCustomerDao.updateUserCustomerForIsDelete(uidL, currentUserID, isDeleted);
		} else {
			return 1; // 当前用户不存在
		}
		return 0;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteUserByUID(String uid) {
		long uidL = Long.valueOf(uid);
		this.userDao.deleteById(uidL);
		this.accountDao.deleteByUID(uidL);
		this.userCustomerDao.deleteById(uidL);
		return 0;
	}

	public void update(User user) {
		userDao.updateById(user);
	}

	public List<User> getByTimeAndCoupon(Integer couponId, String startTime, String endTime) {
		return this.userDao.getByTimeAndCoupon(couponId, startTime, endTime);
	}

	/**
	 * 是否包含CN账号
	 * 
	 * @return false:否 true:是
	 */
	public boolean queryIncludeCNUserAccount(Long uid) {
		boolean result = Boolean.FALSE;
		List<UserAccountBO> list = this.accountDao.findUserAccountByUid(uid);
		for (UserAccountBO userAccount : list) {
			boolean userCN = userAccount.getAccountType().equals(UserContant.ACCOUNT_TYPE_8);
			if (userCN) {
				String loginName = userAccount.getLoginName();
				boolean cnName = loginName.startsWith(Globals.ACCOUNT_TYPE_CN);
				if (cnName) {
					return Boolean.TRUE;
				} else {
					return Boolean.FALSE;
				}
			}
		}
		return result;
	}
}
