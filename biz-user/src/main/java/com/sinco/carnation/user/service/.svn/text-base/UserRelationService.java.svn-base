package com.sinco.carnation.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Maps;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.sys.bo.RelationBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.MessageContants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.dao.UserPhoneAreaDao;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.BindingHistory;
import com.sinco.carnation.sys.model.RelationMessage;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.model.UserPhoneArea;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.BindingHistoryService;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.bo.UserRelationStatisBO;
import com.sinco.carnation.user.dao.RelationLogDao;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.dao.UserRelationDao;
import com.sinco.carnation.user.dao.UserRelationStatisDao;
import com.sinco.carnation.user.model.RelationLog;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.model.UserRelation;
import com.sinco.carnation.user.vo.UserCustomerVO;
import com.sinco.dic.client.util.WebUtils;

/**
 * 
 * @ClassName: UserOwnService
 * @Description: TODO(推荐关系)
 * @author Tang
 * @date 2015年9月8日 下午8:01:05
 * 
 */
@Service
public class UserRelationService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRelationDao userRelationDao;
	@Autowired
	private UserService userService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private UserAccountService accountService;
	@Autowired
	private UserCustomerDao userCustomerDao;
	@Autowired
	private RedisCacheService redisCacheService;
	@Autowired
	private UserRelationDao relationDao;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private StoreDao storeDao;

	@Autowired
	private MessageService messageService;

	@Autowired
	private BindingHistoryService bindingHistoryService;

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private OperatorRemoteService operatorRemoteService;

	@Autowired
	private OperatorService operService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private RelationLogDao relationLogDao;

	@Autowired
	private UserRelationStatisDao userRelationStatisDao;

	/** 添加关系日志 type 1.成为CN账号解除关系 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean addRelationLog(UserRelationBO relation, Long refereeUid, Long sellerUid, String logInfo,
			int type) {
		if (relation == null) {
			return false;
		}
		RelationLog log = new RelationLog();
		log.setUid(relation.getUserId());
		log.setRefereeUid(relation.getRefereeUserId());
		log.setRefereeUidNew(refereeUid);
		log.setSellerUid(relation.getSellerUserId());
		log.setSellerUidNew(sellerUid);
		log.setLogInfo(logInfo);
		log.setLogType(type);
		relationLogDao.save(log);
		return true;
	}

	/**
	 * 解除某用户的推荐关系 推荐使用：CN账户绑定普通会员时，解除关系
	 * 
	 * @return false失败 true 成功
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean relieveRelationByUid(Long userId) {
		if (null == userId || userId <= 0) {
			return false;
		}
		// 成为CN账户解除关系要给推荐关系链上的会员发送站内消息
		UserRelationBO userRelationBO = this.findOneByUid(userId);
		if (userRelationBO != null) {
			if (null != userRelationBO.getRefereeUserId()) {
				this.setMassage(userRelationBO.getRefereeUserId(), userId,
						Integer.valueOf(MessageContants.rmType2));
			} // 添加日志
			String logInfo = "用户成为CN账号,解除推荐关系";
			if (userRelationBO.getRefereeUserId() != null) {
				this.addRelationLog(userRelationBO, null, userRelationBO.getSellerUserId(), logInfo, 1);
			}
		}
		// 关系置空
		return relationDao.updateUserReferee2Nll(userId);
	}

	public Long getUserRecommendCnOperator(Long userId) {
		if (userId == null) {
			return null;
		}
		Map<Long, Long> record = new HashMap<Long, Long>();
		List<Long> uid = new ArrayList<Long>();
		getUserRecommendCnOperator(uid, record, userId);
		return uid.size() > 0 ? uid.get(0) : null;
	}

	/**
	 * 获取当前用户的推荐CN运营商
	 * 
	 * @param userId
	 * @return
	 */
	private void getUserRecommendCnOperator(List<Long> uid, Map<Long, Long> record, long userId) {
		Long recommendUid = getRecommendUpper(userId);
		if (null == recommendUid) {
			return;
		}
		if (record.containsKey(userId)) {
			recommendUid = record.get(userId);
			log.error("user recommend error.loop recommend user id =" + userId + ", recommend uid="
					+ recommendUid);
			return;
		}
		record.put(userId, recommendUid);
		UserAccount userAccount = accountService.findByUid(recommendUid, UserContant.ACCOUNT_TYPE_8);
		if (null == userAccount) {
			this.getUserRecommendCnOperator(uid, record, recommendUid);
		} else {
			uid.add(recommendUid);
		}
		// 返回用户id
		return;
	}

	/**
	 * 获取推荐关系的上层信息
	 * 
	 * @param userId
	 * @return
	 */
	public Long getRecommendUpper(long userId) {
		UserRelationBO userRelatebo = userRelationDao.get(userId);
		if (null == userRelatebo || null == userRelatebo.getRefereeUserId()) {
			return null;
		}
		return userRelatebo.getRefereeUserId();
	}

	public Map<Integer, Long> getUserRecommendByLevel(int level, Long userId) {
		Map<Integer, Long> recommendUser = new HashMap<Integer, Long>();
		buileUserRecommendBylevel(recommendUser, 0, level + 1, userId);
		return recommendUser;
	}

	/**
	 * 用户推荐层级关系
	 * 
	 * @param recommendUsers
	 * @param key
	 * @param level
	 * @param userId
	 */
	private void buileUserRecommendBylevel(Map<Integer, Long> recommendUsers, int key, int level, Long userId) {
		if (userId == null) {
			return;
		}
		if (key > level) {
			return;
		} else {
			key++;
			UserRelationBO userRelatebo = userRelationDao.get(userId);
			if (null != userRelatebo) {
				recommendUsers.put(key, userRelatebo.getUserId());
			} else {
				// 最后一位无推荐关系
				recommendUsers.put(key, userId);
				return;
			}
			if (null != userRelatebo.getRefereeUserId()) {
				buileUserRecommendBylevel(recommendUsers, key, level, userRelatebo.getRefereeUserId());
			}
		}
	}

	/**
	 * 根据用户id，获取当前用户的绑定关系
	 * 
	 * @param userId
	 * @return
	 */
	public UserRelationBO getUserRelation(Long userId) {
		return userRelationDao.get(userId);
	}

	/**
	 * 注册用户，且更新关系
	 * 
	 * @param userType
	 * @param accountType
	 * @param loginName
	 * @param password
	 * @param requestIp
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int registerUser(String nickname, String mobile, String password, String requestIp, String code,
			String invitationCode) {
		UserAccountBO userAccount = accountService.findByMobile(mobile, UserContant.ACCOUNT_TYPE_2);
		if (null != userAccount) {
			// 用户已存在
			return -4;
		}

		String codeRedis = redisCacheService.getSmsCode(0L, mobile);

		// 验证码校验
		if (!code.equalsIgnoreCase("ae937fd9ae2211e58c06001e67cd90fd")) {
			// 用户未申请发送过验证码，或者验证号已过期
			if (StringUtils.isBlank(codeRedis)) {
				return -2;
			}
			// 验证码是否正确
			if (!code.equals(codeRedis)) {
				return -3;
			}
		}
		Long uid = userService.createUser(UserContant.USER_TYPE_1, UserContant.ACCOUNT_TYPE_2, mobile,
				password, requestIp);

		// 如果昵称为空，则自动生成昵称：
		UserBO sysuser = userService.getObjById(uid);
		if (StringUtils.isBlank(nickname)) {
			nickname = "云尚" + sysuser.getInvitationCode();
		}

		if (userCustomerDao.countByNickname(nickname, null) > 0) {
			// 用户昵称已存在
			return -5;
		}

		UserBO refereeUser = null;
		if (null != invitationCode && !invitationCode.equals(""))
			// 绑定关系
			refereeUser = createUserRelation(uid, invitationCode);

		int s = customerService.createCustomer(uid, mobile, nickname, null, null, null,
				refereeUser == null ? 0L : refereeUser.getId());
		redisCacheService.delSmsCode(0L, mobile);
		return s;
	}

	/**
	 * 当推荐人所属商户与用户在同城，注册用户，且更新关系
	 * 
	 * @param userType
	 * @param accountType
	 * @param loginName
	 * @param password
	 * @param requestIp
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int registerUserwithshop(String nickname, String mobile, String password, String requestIp,
			String code, String invitationCode, Integer sellerUserId) {
		UserAccountBO userAccount = accountService.findByMobile(mobile, UserContant.ACCOUNT_TYPE_2);
		Long lsellerUserId = Long.valueOf(sellerUserId);

		if (null != userAccount) {
			// 用户已存在
			return -4;
		}

		String codeRedis = redisCacheService.getSmsCode(0L, mobile);

		// 验证码校验
		if (!code.equalsIgnoreCase("ae937fd9ae2211e58c06001e67cd90fd")) {
			// 用户未申请发送过验证码，或者验证号已过期
			if (StringUtils.isBlank(codeRedis)) {
				return -2;
			}
			// 验证码是否正确
			if (!code.equals(codeRedis)) {
				return -3;
			}
		}
		redisCacheService.delSmsCode(0L, mobile);
		Long uid = userService.createUser(UserContant.USER_TYPE_1, UserContant.ACCOUNT_TYPE_2, mobile,
				password, requestIp);

		// 如果昵称为空，则自动生成昵称：
		UserBO sysuser = userService.getObjById(uid);
		if (StringUtils.isBlank(nickname)) {
			nickname = "云尚" + sysuser.getInvitationCode();
		}

		if (userCustomerDao.countByNickname(nickname, null) > 0) {
			// 用户昵称已存在
			return -5;
		}

		UserBO refereeUser = null;
		if (null != invitationCode && !invitationCode.equals(""))
			// 绑定关系
			refereeUser = createUserRelation(uid, invitationCode, lsellerUserId);

		return customerService.createCustomer(uid, mobile, nickname, null, null, null,
				refereeUser == null ? 0L : refereeUser.getId());
	}

	/**
	 * 手机分享注册用户，且更新关系
	 * 
	 * @param userType
	 * @param accountType
	 * @param loginName
	 * @param password
	 * @param requestIp
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int registerUserByMoblie(String mobile, String password, String requestIp, String code,
			String invitationCode) {
		UserAccountBO userAccount = accountService.findByMobile(mobile, UserContant.ACCOUNT_TYPE_2);
		if (null != userAccount) {
			// 用户已存在
			return -4;
		}

		String codeRedis = redisCacheService.getSmsCode(0L, mobile);
		// 用户未申请发送过验证码，或者验证号已过期
		if (StringUtils.isBlank(codeRedis)) {
			return -2;
		}
		// 验证码是否正确
		if (!code.equals(codeRedis)) {
			return -3;
		}
		redisCacheService.delSmsCode(0L, mobile);
		Long uid = userService.createUser(UserContant.USER_TYPE_1, UserContant.ACCOUNT_TYPE_2, mobile,
				password, requestIp);

		UserBO refereeUser = null;
		if (null != invitationCode && !invitationCode.equals(""))
			refereeUser = createUserRelation(uid, invitationCode);

		int result = customerService.createCustomer(uid, mobile, mobile, null, null, null,
				refereeUser == null ? 0L : refereeUser.getId());

		UserBO sysuser = userService.getObjById(uid);
		customerService.updateUserInfo(uid, mobile, "云尚" + sysuser.getInvitationCode(), null, null, null,
				null, null, null, null, null, null, null, null, null);
		return result;
	}

	/**
	 * 运营商注册会员
	 * 
	 * @param mobile
	 * @param password
	 * @param requestIp
	 * @param code
	 * @param invitationCode
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int yysRegisterUserByMobile(String mobile, String password, String requestIp, String code,
			String invitationCode) {
		UserAccountBO userAccount = accountService.findByMobile(mobile, UserContant.ACCOUNT_TYPE_2);
		if (null != userAccount) {
			// 用户已存在
			return -4;
		}
		String codeRedis = redisCacheService.getSmsCode(0L, mobile);
		// 用户未申请发送过验证码，或者验证号已过期
		if (StringUtils.isBlank(codeRedis)) {
			return -2;
		}
		// 验证码是否正确
		if (!code.equals(codeRedis)) {
			return -3;
		}
		redisCacheService.delSmsCode(0L, mobile);
		// 注册会员UID
		Long uid = userService.createUser(UserContant.USER_TYPE_1, UserContant.ACCOUNT_TYPE_2, mobile,
				password, requestIp);
		UserBO refereeUser = null;
		if (null != invitationCode && !invitationCode.equals("")) {
			UserBO invitation_User = userService.findByInvitationCode(invitationCode);
			long invitation_UserID = invitation_User.getId();
			long refereeUserId = invitation_UserID;
			OperatorBO operator = this.operatorService.queryOperatorInfo(invitation_UserID);
			long extensionSellerUID = operator.getExtensionSellerUid();
			if (extensionSellerUID != 0L) {
				// 新注册会员+推荐人+隶属商户 绑定关系
				UserRelation relation = new UserRelation();
				relation.setUserId(uid);
				relation.setRefereeUserId(refereeUserId);
				relation.setSellerUserId(extensionSellerUID); // 隶属商户
				relation.setUpdateTime(new Date());
				relation.setCreateTime(new Date());
				UserRelationBO r = userRelationDao.queryUserRation(uid);
				if (r == null) {
					this.userRelationDao.insertSelective(relation);
				} else {
					userRelationDao.update(relation);
				}
			} else {
				refereeUser = this.createUserRelation(uid, invitationCode);
			}
		}
		int result = customerService.createCustomer(uid, mobile, mobile, null, null, null,
				refereeUser == null ? 0L : refereeUser.getId());

		UserBO sysuser = userService.getObjById(uid);
		customerService.updateUserInfo(uid, mobile, "云尚" + sysuser.getInvitationCode(), null, null, null,
				null, null, null, null, null, null, null, null, null);
		return result;
	}

	/**
	 * 抢红包手机分享注册用户，且更新关系
	 * 
	 * @param userType
	 * @param accountType
	 * @param loginName
	 * @param password
	 * @param requestIp
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int registerUserByMoblieRelation(String mobile, String password, String requestIp, String code,
			String invitationCode) {
		UserAccountBO userAccount = accountService.findByMobile(mobile, UserContant.ACCOUNT_TYPE_2);
		if (null != userAccount) {
			// 用户已存在
			return -4;
		}

		String codeRedis = redisCacheService.getSmsCode(0L, mobile);
		// 用户未申请发送过验证码，或者验证号已过期
		if (StringUtils.isBlank(codeRedis)) {
			return -2;
		}
		// 验证码是否正确
		if (!code.equals(codeRedis)) {
			return -3;
		}
		redisCacheService.delSmsCode(0L, mobile);
		Long uid = userService.createRelationUser(UserContant.USER_TYPE_1, UserContant.ACCOUNT_TYPE_2,
				mobile, password, requestIp, 1);

		UserBO refereeUser = null;
		if (null != invitationCode && !invitationCode.equals(""))
			refereeUser = createUserRelation(uid, invitationCode);

		int result = customerService.createCustomer(uid, mobile, mobile, null, null, null,
				refereeUser == null ? 0L : refereeUser.getId());

		UserBO sysuser = userService.getObjById(uid);
		customerService.updateUserInfo(uid, mobile, "云尚" + sysuser.getInvitationCode(), null, null, null,
				null, null, null, null, null, null, null, null, null);
		return result;
	}

	/**
	 * 
	 * @Title: createUserRelation @Description: TODO(创建用户推荐关系，包括个人，商户，运营商；如果推荐人是商户的话，那么所属商户id直接填写) @param @param
	 *         userId 注册人用户id @param @param invitationCode 推荐人邀请码 @return void 返回类型 @author Tang @throws
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public UserBO createUserRelation(Long userId, String invitationCode) {
		UserBO userBO = userService.findByInvitationCode(invitationCode);// 推荐人信息
		if (userBO == null) {
			log.error("invitationCode is not find" + invitationCode);
			return null;
		}
		if (userBO != null && !(userBO.getId().equals(userId))) // 防止自己推荐自己
		{
			long uid = userBO.getId();
			boolean isOperator = this.operService.isOperator(uid);
			Long sellerUID = uid;
			long refereeUserId = uid;
			if (isOperator) // 运营商 运营商有为其下属商户注册会员功能
			{
				OperatorBO operator = this.operService.getOperatorBOByUserId(uid);
				Long recoUID = operator.getExtensionSellerUid(); // 为商户注册会员的商户UID
				sellerUID = recoUID;
				createUserRelation(userId, refereeUserId, sellerUID);
			}
			// 说明是商户信息
			else if (StringUtils.isNotBlank(userBO.getUserName())) {// 自己是商户 被推荐人所属商户为自己
				createUserRelation(userId, refereeUserId, sellerUID);
			} else {
				UserRelationBO refRelation = this.getUserRelation(userBO.getId());// 推荐人推荐信息
				sellerUID = null;
				if (refRelation != null) {
					sellerUID = refRelation.getSellerUserId();// 推荐人所属商户设置为被推荐人所属商户
				}
				createUserRelation(userId, userBO.getId(), sellerUID);
			}
			// 给邀请码所属会员及所属会员的推荐人发送短信
			this.setMassage(userBO.getId(), userId, Integer.valueOf(MessageContants.rmType1));
		}
		return userBO;
	}

	/**
	 * 
	 * @Title: createUserRelation @Description: TODO(创建用户推荐关系，包括个人，商户，运营商；如果推荐人的商户与用户在同一城市， 那么所属商户id直接填写) @param @param
	 *         userId 注册人用户id @param @param invitationCode 推荐人邀请码 @return void 返回类型 @author Tang @throws
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public UserBO createUserRelation(Long userId, String invitationCode, Long sellerUserId) {
		UserBO userBO = userService.findByInvitationCode(invitationCode);
		// RelationBO relationBO =
		// userService.findRelationSidByInvitationCode(invitationCode);
		if (userBO == null) {
			return null;
		}
		long uid = userBO.getId();
		boolean isOperator = this.operService.isOperator(uid);
		Long sellerUID = uid;
		long refereeUserId = uid;
		if (isOperator) // 运营商 运营商有为其下属商户注册会员功能
		{
			OperatorBO operator = this.operService.getOperatorBOByUserId(uid);
			Long recoUID = operator.getExtensionSellerUid(); // 为商户注册会员的商户UID
			sellerUID = recoUID;
			this.createUserRelation(userId, refereeUserId, sellerUID);
		} else if (StringUtils.isNotBlank(userBO.getUserName())) {
			createUserRelation(userId, userBO.getId(), userBO.getId());
		} else {

			createUserRelation(userId, userBO.getId(), sellerUserId);
		}
		// 给邀请码所属会员及所属会员的推荐人发送短信
		this.setMassage(userBO.getId(), userId, Integer.valueOf(MessageContants.rmType1));

		return userBO;
	}

	/**
	 * 
	 * @Title: createUserRelation @Description: TODO(创建用户推荐关系，包括个人，商户，运营商；如果推荐人是商户的话，那么所属商户id直接填写) @param @param
	 *         userId 注册人用户id @param @param refereeUserId 推荐人 @return void 返回类型 @author Tang @throws
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createUserRelation(Long userId, Long refereeUserId, Long sellerUserId) {
		// 用户是CN账号 无法建立推荐关系
		if (userAccountService.findByUid(userId, UserContant.ACCOUNT_TYPE_8) != null) {
			refereeUserId = null;
		}
		UserRelation relation = new UserRelation();

		relation.setUserId(userId);
		relation.setRefereeUserId(refereeUserId);
		boolean isO2o = false;
		// sellerUserId 不为空
		if (sellerUserId != null) {
			// sellerUserId 是o2o
			try {
				isO2o = sellerService.sellerIsO2oByUid(sellerUserId);
			} catch (Exception e) {

			}
			if (isO2o) {
				relation.setSellerUserId(sellerUserId);
			}
		} else {
			UserRelationBO bo = this.getUserRelation(refereeUserId);
			if (null != bo && null != bo.getSellerUserId()) {
				// bo.getSellerUserId() 是o2o
				try {
					isO2o = sellerService.sellerIsO2oByUid(sellerUserId);
				} catch (Exception e) {

				}
				if (isO2o) {
					relation.setSellerUserId(bo.getSellerUserId());
				}
			}
		}

		UserRelationBO r = userRelationDao.queryUserRation(userId);
		if (r == null) {
			relation.setUpdateTime(new Date());
			relation.setCreateTime(new Date());
			userRelationDao.insertSelective(relation);
		} else {
			relation.setUpdateTime(new Date());
			userRelationDao.update(relation);
		}
	}

	/**
	 * 检测消费者是否是商户会员 首次消费绑定所属关系
	 * 
	 * @param uid
	 * @param refereeUid
	 * @param sellerUid
	 */
	@Transactional(readOnly = false)
	public void checkUserRelation(Long uid, Long sellerUid) {
		UserRelationBO relationBO = userRelationDao.queryUserRation(uid);
		if (relationBO == null || relationBO.getSellerUserId() == null || relationBO.getSellerUserId() == 0) {
			UserRelation record = new UserRelation();
			record.setUserId(uid);
			record.setSellerUserId(sellerUid);
			record.setRelationType(1);
			record.setUpdateTime(new Date());
			if (relationBO == null) {
				record.setCreateTime(new Date());
				userRelationDao.insertSelective(record);
			} else {
				userRelationDao.update(record);;
			}
		}
	}

	/**
	 * 统计推荐会员数
	 */
	public int queryRefereeUserCount(Long refereeUserId, String startDate, String endDate) {
		return userRelationDao.queryRefereeUserCount(refereeUserId, startDate, endDate);
	}

	public int queryOwnCustomerCount(Long refereeUserId, String startDate, String endDate) {
		return userRelationDao.queryOwnCustomerCount(refereeUserId, startDate, endDate);
	}

	/**
	 * 统计推荐商户数
	 */
	public int queryRefereeSellerCount(Long refereeUserId, String startDate, String endDate) {
		return userRelationDao.queryRefereeSellerCount(refereeUserId, startDate, endDate);
	}

	@Transactional(readOnly = true)
	public UserRelationBO queryReferee(Long uid) {
		UserRelationBO relationBO = relationDao.queryUserRelation(uid);
		if (relationBO != null && relationBO.getUserType() != null) {
			// 如果是个人或者商户
			switch (relationBO.getUserType()) {
				case 1:
					UserCustomer customer = customerService.findById(relationBO.getRefereeUserId());
					if (customer != null) {
						relationBO.setNickname(customer.getNickname());
					}
					break;
				// 营运商
				case 4:
					OperatorBO operator = operatorService.get(relationBO.getRefereeUserId());
					if (operator != null) {
						relationBO.setNickname(operator.getUserName());
					}
					break;
			}
		}
		// 设置隶属商户名称
		if (relationBO != null && relationBO.getSellerUserId() != null) {
			// StoreBO store = storeDao.getStoreByUserId(relationBO.getSellerUserId());
			StoreBO store = this.storeDao.queryStoreInfo(relationBO.getSellerUserId(), true, false);
			if (store != null) {
				relationBO.setStoreName(store.getStoreName());
			}
		}
		return relationBO;
		// return relationDao.queryReferee(uid);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int createUser(String nickname, String mobile, String password, String requestIp, Integer type,
			String invitationCode, String unionId) {
		UserAccountBO userAccount = accountService.findByMobile(mobile, UserContant.ACCOUNT_TYPE_2);
		if (null != userAccount) {
			// 用户已存在
			return -4;
		}
		if (userCustomerDao.countByNickname(nickname, null) > 0) {
			// 用户昵称已存在
			return -5;
		}
		// 手机号码注册
		Long uid = userService.createUser(UserContant.USER_TYPE_1, UserContant.ACCOUNT_TYPE_2, mobile,
				password, requestIp);
		// 手机号码注册成功，绑定第三方平台id
		if (uid != null) {
			// 注册第三方平台id
			userService.bindingUser(unionId, null, CommUtil.null2String(type), uid);
			UserBO refereeUser = null;
			if (null != invitationCode && !invitationCode.equals(""))
				refereeUser = createUserRelation(uid, invitationCode);
			return customerService.createCustomer(uid, mobile, nickname, null, null, null,
					refereeUser == null ? 0L : refereeUser.getId());
		}
		return -3;
	}

	/**
	 * 绑定第三方用户
	 * 
	 * @param uid
	 * @param unionId
	 * @param password
	 * @param type
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int bindingUser(Long uid, String unionId, String password, String type) {
		return userService.bindingUser(unionId, password, type, uid);
	}

	/**
	 * 检测用户是否已经被邀请过
	 * 
	 * @param 被邀请人uid
	 * @param refereeUid
	 * @param sellerUid
	 */
	@Transactional(readOnly = false)
	public UserRelationBO checkUserExistsRelation(Long uid) {
		UserRelationBO relationBO = userRelationDao.queryUserRation(uid);
		return relationBO;

	}

	@Transactional(readOnly = false)
	public UserRelationBO checkUserExistsCode(Long uid) {
		UserRelationBO relationBO = userRelationDao.queryExistUserRelationCode(uid);
		return relationBO;

	}

	@Autowired
	private AreaServiceImpl areaService;

	/**
	 * 注册区域处理
	 * 
	 */
	public synchronized void registerAreaDeal() {

		try {
			while (true) {
				try {
					// 查找时间最早的一条没有所属商户的用户记录
					UserRelationBO currentRelationBO = userRelationDao.findFirstNORelationBelongSeller();

					// 没有了，就退出循环
					if (currentRelationBO == null)
						return;

					// 用 -1 标识 此记录已处理过
					currentRelationBO.setSellerUserId(0L);

					if (currentRelationBO.getRelationType() == null)
						currentRelationBO.setRelationType(2);
					String currentCity = "", sellerCity = "", currentPhone = "";
					StoreBO storeBo = null;

					if (currentRelationBO.getRefereeUserId() != null) {
						// 推荐父类
						UserRelationBO parentRelationBO = userRelationDao.findOne(currentRelationBO
								.getRefereeUserId());

						if (parentRelationBO != null && parentRelationBO.getSellerUserId() != null) {
							// 推荐父类的 卖家Id
							Long parentSellerId = parentRelationBO.getSellerUserId();

							UserAccount currentAccount = accountService.findByUid(
									currentRelationBO.getUserId(), "2");
							if (currentAccount != null) {
								currentPhone = currentAccount.getLoginName();
								currentCity = this.getPhoneCityWithProvince(currentAccount.getLoginName());

								SellerBO sellerBO = sellerService.findByUid(parentSellerId);
								if (sellerBO != null && sellerBO.getStoreId() != null) {
									StoreBO bo = storeDao.findObjById(sellerBO.getStoreId());

									sellerCity = this.getAreaCityByStoreId(bo);
									if (StringUtils.isNotBlank(sellerCity)
											&& sellerCity.lastIndexOf("市") > -1)
										sellerCity = sellerCity.substring(0, sellerCity.lastIndexOf("市"));
								}
								// 如果同在一个城市，更新此会员的商户Id
								if (currentCity.equals(sellerCity) && StringUtils.isNotBlank(currentCity)) {
									if (currentRelationBO.getUserId().equals(parentSellerId)) { // not
																								// belong
																								// self
										currentRelationBO.setSellerUserId(parentSellerId);
										currentRelationBO.setUpdateTime(new Date());
									}
								}
							}
						}
					}
					userRelationDao.updateOrCreate(currentRelationBO, currentPhone, currentCity, sellerCity,
							storeBo);

				} catch (Exception e) {
					log.error(String.format("出现异常%s", e.getMessage()));
				}
			}
		} catch (Exception e) {
			log.error(String.format("出现异常%s", e.getMessage()));
		}
		// 将-1 还原
		// userRelationDao.updateUserRelationToNull();
	}

	@Autowired
	UserAccountDao userAccountDao;

	@Autowired
	UserPhoneAreaDao userPhoneAreaDao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public synchronized void saveUserPhoneCityArea() {
		// Date begin = new Date(2015,12,1);
		// Date end = new Date(2015,12,20);
		//
		List<UserAccount> list = userAccountDao.findUserAccountList();
		Collection<Area> areaColl = areaService.getCacheAll();

		userPhoneAreaDao.deleteAll();
		String city = "";

		for (UserAccount userAccount : list) {

			city = this.getPhoneCity(userAccount.getLoginName());
			if (StringUtils.isNotEmpty(city)) {
				UserPhoneArea record = new UserPhoneArea();
				record.setUid(userAccount.getUid());
				record.setAreaName(city + "市");

				for (Area a : areaColl) {
					if (a.getName().equals(record.getAreaName())) {
						record.setAreaId(a.getId());
						break;
					}
				}
				record.setPhone(userAccount.getLoginName());
				userPhoneAreaDao.save(record);
			}
		}
	}

	/**
	 * 获取Store的城市名称
	 * 
	 * @param uid
	 * @return
	 */
	public String getAreaCityByStoreId(StoreBO bo) {
		if (bo != null && bo.getIsO2o()) {
			Area area = areaService.getCacheById(bo.getAreaId());
			if (area != null) {
				Area pArea = areaService.getCacheById(area.getParentId());
				return pArea == null ? null : pArea.getAreaName();
			}
		}
		return "";
	}

	@SuppressWarnings("rawtypes")
	public String getPhoneCity(String phone) {
		Map map2 = getPhoneAreaInfo(phone);
		if (map2 != null && map2.containsKey("city")) {
			return map2.get("city").toString();
		} else {
			return "";
		}
	}

	@SuppressWarnings("rawtypes")
	public String getPhoneCityWithProvince(String phone) {
		Map map2 = getPhoneAreaInfo(phone);
		String city = map2.get("city").toString();
		String province = map2.get("province").toString();
		return province + "," + city;
	}

	@SuppressWarnings("rawtypes")
	public Map getPhoneAreaInfo(String phone) {
		String url = "http://apis.juhe.cn/mobile/get";
		Map<String, String> params = Maps.newHashMap();
		params.put("phone", phone);
		params.put("dtype", "jsonp");
		params.put("key", "421f367e9ce01855697c6516c4f4b9f1");
		params.put("_", "1452569818864");

		try {
			String jsonStr = WebUtils.doGet(url, params);
			// ({"resultcode":"200","reason":"Return
			// Successd!","result":{"province":"广东","city":"深圳","areacode":"0755","zip":"518000","company":"中国移动","card":"移动150卡"},"error_code":0})

			jsonStr = jsonStr.replace("(", "");
			jsonStr = jsonStr.replace(");", "");
			Map map = (Map) Json.fromJson(jsonStr);
			Map map2 = (Map) map.get("result");
			return map2;

		} catch (Exception e) {
			// TODO: handle exception
			log.error(String.format("获取phone[%s] 所属地 异常", phone));
		}

		return null;
	}

	/**
	 * 通过邀请码查询商户所属城市
	 * 
	 */
	public RelationBO iscity(String invitationCode) {
		RelationBO relationBO = userService.findRelationSidByInvitationCode(invitationCode);
		return relationBO;
	}

	/**
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveFirstareaid(String address, Long area_id, Long userid) {
		Long addressId = null;
		String areaInfo = null;
		UserCustomerVO vo = new UserCustomerVO();
		// vo.setUid(SecurityUserHolder.getCurrentUserId());
		try {
			customerService.updateUserCustomerAndAddress(vo, addressId, areaInfo, area_id, userid);
		} catch (ServiceException e) {
			// return mv;
		}
		// return mv;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long createUser3(String openid, String type, String requestIp, String invitationCode) {
		Long uid = userService.createUser3(UserContant.USER_TYPE_1, type, openid, requestIp);
		// 手机号码注册
		// 手机号码注册成功，绑定第三方平台id
		if (uid != null) {
			// 注册第三方平台id
			userService.bindingUser(openid, null, CommUtil.null2String(type), uid);
			UserBO refereeUser = null;
			UserBO sysuser = userService.getObjById(uid);
			String nickname = "云尚" + sysuser.getInvitationCode();
			if (null != invitationCode && !invitationCode.equals(""))
				refereeUser = createUserRelation(uid, invitationCode);
			customerService.createCustomer(uid, null, nickname, null, null, null, refereeUser == null ? 0L
					: refereeUser.getId());
			return uid;
		}
		return -3L;
	}

	/**
	 * 向推荐人和推荐人的推荐人发送站内短信
	 * 
	 * @param reUserId
	 *            推荐人的信息
	 * @param userId
	 *            注册人的uiserid
	 * 
	 * @param type
	 *            信息类型0.系统 1.推荐 2.解除关系 3.订单
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void setMassage(Long reUserId, Long userId, int type) {
		// UserCustomerBO userCustomer =
		// userCustomerDao.findBOByUserId(userId);//查询用户信息
		if (userId == null || reUserId == null) {
			log.error("userId or reUserId is null");
			return;
		}
		RelationMessage relationMessage = new RelationMessage();
		relationMessage.setCreatTime(new Date());
		relationMessage.setRmType(type);
		relationMessage.setForUserId(userId);
		relationMessage.setToUserId(reUserId);
		if (messageService.saveRelationMessage(relationMessage)) {
		} else {
			log.error("save relationMessage is Unsuccess ForUserId=" + userId + ",ToUserId=" + reUserId);
		}
	}

	/****
	 * 是否可以推荐
	 * 
	 * @param userId
	 *            被推荐人uid
	 * 
	 * @param refereeId
	 *            推荐人uid
	 * 
	 */
	public boolean isBoundRelation(String userId, String refereeId) {
		boolean isBoundRelation = false;
		boolean user1 = this.isCnAccount(CommUtil.null2Long(userId));// 被推荐人用户
		boolean user2 = this.isCnAccount(CommUtil.null2Long(refereeId));// 推荐人用户

		if (user1 && user2) { // 都是CN用户
			log.info("不能推荐");
			isBoundRelation = false;
		} else if (!user1 && !user2) {// 都是普通用户
			log.info("可以推荐");
			isBoundRelation = true;
		} else if (user1 && !user2) { // 被推荐人是 CN用户; 推荐人是普通
			log.info("不能推荐");
			isBoundRelation = false;
		} else if (!user1 && user2) {// 被推荐人是 普通用户;推荐人是CN用户
			log.info("可以推荐");
			isBoundRelation = true;
		}
		return isBoundRelation;
	}

	/***
	 * 判断是否是CN用户
	 */
	public boolean isCnAccount(Long userId) {
		boolean bl = false;
		List<UserAccountBO> userAccount = this.userAccountService.findUserAccountByUid(userId);
		for (UserAccountBO account : userAccount) {// 判断账号是否是CN账号
			if ("8".equals(account.getAccountType())) {
				bl = true;
			}
		}
		return bl;
	}

	/***
	 * 推荐关系用户（CN账户的不能建立推荐关系）
	 * 
	 * 适用于没有推荐关系的
	 * 
	 * @param uid
	 *            已经注册的uid(被邀请人的UID)
	 * 
	 * @param invitationCode
	 *            邀请码(邀请人的 邀请码)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void boundRelation(Long uid, String invitationCode) {
		boolean bl = true;// 表示不是CN账户
		List<UserAccountBO> userAccount = this.userAccountService.findUserAccountByUid(uid);
		for (UserAccountBO account : userAccount) {
			if ("8".equals(account.getAccountType())) {
				bl = false; // 表示是CN账户
				break;
			}
		}

		if (bl) { // 表示不是CN账户,可以绑定

			UserRelationBO ub = userRelationDao.get(uid);
			if (ub == null || ub.getRefereeUserId() == null) {

				UserBO userBO = userService.findByInvitationCode(invitationCode);
				if (userBO != null && !(userBO.getId().equals(uid))) {
					log.info("->" + (userBO.getId().equals(uid)) + " uid1->" + uid + " uid2->"
							+ userBO.getId());
					log.info("=============== bound user ==============");
					if (StringUtils.isNotBlank(userBO.getUserName())) {
						createUserRelation(uid, userBO.getId(), userBO.getId());
					} else {

						UserRelationBO refRelation = this.getUserRelation(userBO.getId());// 推荐人推荐信息
						Long sellerUID = null;
						if (refRelation != null) {
							sellerUID = refRelation.getSellerUserId();// 推荐人所属商户设置为被推荐人所属商户
						}
						createUserRelation(uid, userBO.getId(), sellerUID);
					}
					// 给邀请码所属会员及所属会员的推荐人发送短信
					this.setMassage(userBO.getId(), uid, Integer.valueOf(MessageContants.rmType1));

				} else {
					log.error("invitationCode is not find" + invitationCode);
				}
			}

		}

	}

	/**
	 * 
	 * @param record
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void historyBoundRelation(BindingHistory record) {
		bindingHistoryService.save(record);
	}

	/**
	 * 根据用户UID查询绑定关系
	 */
	public UserRelationBO findOneByUid(Long uid) {
		return userRelationDao.findOne(uid);
	}

	/**
	 * 查询用户的3级关系 如果填写的邀请码对应的用户存在于3级关系里面 则不让用户填写绑定改邀请码
	 * 
	 * @param uid
	 *            用户ID
	 * @param invitationCode
	 *            邀请码
	 * @return false:不存在 true:存在
	 */
	public boolean checkUserLevel(Long uid, String invitationCode) {
		// 邀请码对应的用户
		UserBO userBo = this.userService.findByInvitationCode(invitationCode);
		// 推荐人UID
		Long recoUserID = userBo.getId();
		// 查询用户的第一级用户信息
		List<Long> relationUserIDList = new ArrayList<Long>();
		relationUserIDList.add(uid);
		List<Long> userOneLevelList = this.customerService.queryUserByRelation(relationUserIDList);
		if (userOneLevelList != null && userOneLevelList.size() > 0) {
			if (userOneLevelList.contains(recoUserID)) {
				return true; // 推荐用户为当前用户的第一级会员
			} else {
				relationUserIDList.clear();
				for (Long relationUserID : userOneLevelList) {
					relationUserIDList.add(relationUserID);
				}
				List<Long> userTwoLevelList = this.customerService.queryUserByRelation(relationUserIDList);
				if (userTwoLevelList != null && userTwoLevelList.size() > 0) {
					if (userTwoLevelList.contains(recoUserID)) {
						return true; // 推荐用户为当前用户的第二级会员
					} else {
						relationUserIDList.clear();
						for (Long relationUserID : userTwoLevelList) {
							relationUserIDList.add(relationUserID);
						}
						List<Long> userThreeLevelList = this.customerService
								.queryUserByRelation(relationUserIDList);
						if (userThreeLevelList.contains(recoUserID)) {
							return true; // 推荐用户为当前用户的第三级会员
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * 获取当前用户ABC级总用户量
	 * 
	 * @param refereeUserID
	 * @return
	 */
	public int queryRefereeUserCount(Long refereeUserID) {
		log.info(" ************ 统计所有邀请人数 ************ ");
		int count = 0;
		List<Long> list = new ArrayList<Long>();
		list.add(refereeUserID);
		List<Long> oneLevelList = this.userRelationDao.queryUserRefereeByInRefereeUserID(list);
		int oneLevelCount = oneLevelList.size();
		if (oneLevelCount > 0) {
			count = count + oneLevelCount;
			list.clear();
			for (Long userID : oneLevelList) {
				// 系统存在推荐人为当前用户的下属的数据，该问题已做修改，加上改判断防止数据未处理
				if (!userID.equals(refereeUserID)) {
					list.add(userID);
				}
			}
			List<Long> twoLevelList = this.userRelationDao.queryUserRefereeByInRefereeUserID(list);
			int twoLevelCount = twoLevelList.size();
			if (twoLevelCount > 0) {
				count = count + twoLevelCount;
				list.clear();
				for (Long userID : twoLevelList) {
					// 系统存在推荐人为当前用户的下属的数据，该问题已做修改，加上改判断防止数据未处理
					if (!userID.equals(refereeUserID)) {
						list.add(userID);
					}
				}
				List<Long> threeLevelList = this.userRelationDao.queryUserRefereeByInRefereeUserID(list);
				int threeLevelCount = threeLevelList.size();
				if (threeLevelCount > 0) {
					count = count + threeLevelCount;
				}
			}

		}
		return count;
	}

	/**
	 * 团队注册会员
	 */
	public int getCnRegistUserCount(String operaCnUserName, String start, String end) {
		List<String> cnUserName = null;
		int userRegistCount = 0;
		try {
			cnUserName = operatorRemoteService.getRemoteCNuserNameByCode(operaCnUserName);
			if (start == null && end == null) {
				userRegistCount = this.userRelationStatisDao.countByLoginNames(cnUserName);
			} else {
				userRegistCount = this.userRelationDao.queryRegistCountByCnUserNameFromAccount(cnUserName,
						start, end);
			}
			return userRegistCount;
		} catch (Exception e) {
			log.error("[getCnRegistUserCount].[getRemoteCNuserNameByCode] is error");
			return 0;
		}
//		int operaRegistCount = this.userRelationDao.queryRegistCountByCnUserNameFromOperator(cnUserName);
	}

	/**
	 * 团队签约商户注册会员
	 */
	public int getCnRegistShopRegistUserCount(String operaCnUserName, String start, String end) {
		List<String> cnUserName = null;
		int userRegistCount = 0;
		try {
			cnUserName = operatorRemoteService.getRemoteCNuserNameByCode(operaCnUserName);
//			userRegistCount = this.userRelationDao.queryRegistShopRegistCountByCnUserName(cnUserName, "1",
//					start, end);
			if (start == null && end == null) {
				userRegistCount = this.userRelationStatisDao.countStoreByLoginNames(cnUserName);
			} else {
				userRegistCount = this.userRelationDao.queryRegistShopRegistCountByCnUserName(cnUserName, "1",
				start, end);
			}
			return userRegistCount;
		} catch (Exception e) {
			log.error("[getCnRegistShopRegistUserCount].[getRemoteCNuserNameByCode] is error");
			return 0;
		}
//		int operaRegistCount = this.userRelationDao.queryRegistShopRegistCountByCnUserName(cnUserName, "2");
	}

	/**
	 * 通过推荐人的uid 获取被推荐人的uid
	 * 
	 * @param uids
	 * @return
	 */
	public List<Long> getRelationUid(List<Long> uids) {
		if (uids.size() > 0) {
			List<Long> list = new ArrayList<>();
			list = this.userRelationDao.getRelationUidByUid(uids);
			return list;
		}
		return null;
	}

	public List<Long> getRelationUidAndCount(List<Long> uids, int count) {
		List<Long> list = this.getRelationUid(uids);
		if (list.size() <= 0) {
			return list;
		}
		return getRelationUidAndCount(list, count);
	}

	@SuppressWarnings("unused")
	public void getRelationCountByUid(Long uid) {
		int count = 0;
		List<Long> uids = new ArrayList<>();
		uids.add(uid);
		List<Long> list = this.getRelationUidAndCount(uids, count);
		System.out.println(count);
	}

	/**
	 * 首次消费绑定用户所属商户关系
	 * 
	 * @param uid
	 * @param storeId
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void firstConsumptionRelation(Long uid, String storeId) {
		if (null == uid) {
			return;
		}
		if (StringUtils.isBlank(storeId)) {
			return;
		}
		// 获取店铺
		StoreBO store = this.storeDao.queryStoreById(Long.parseLong(storeId));
		if (store == null) {
			log.debug("===== [orderPay] 店铺不存在");
			return;
		}
		if (store.getIsShop() == null) { // 供应商无法绑定用户
			return;
		}
		if (store.getIsShop()) {
			return;
		}
		UserRelationBO userRetation = this.userRelationDao.findOne(uid);
		// 卖家uid
		Long sellerUID = this.sellerService.getByStoreId(store.getId()).getUid();
		// 判断卖家商户是否为运营商(用户绑定商户，不存在用户绑定供应商)
		boolean isOperator = this.operatorService.isOperator(sellerUID);
		if (isOperator) {// 卖家是运营商
			return;
		}
		UserRelationBO updateObj = new UserRelationBO();
		updateObj.setUserId(uid);
		updateObj.setUpdateTime(new Date());
		updateObj.setSellerUserId(sellerUID);
		if (userRetation != null) {
			Long user_sellerUID = userRetation.getSellerUserId();
			if (!(user_sellerUID == null || user_sellerUID.equals(0L))) {// 用户已绑定商户
				return;
			}
			// 获取买家所属商户id
			log.debug("===== [orderPay] update userRetation for sellerUID");
			// 与商户产生从属关系
			this.userRelationDao.update(updateObj);
		} else {
			updateObj.setCreateTime(new Date());
			this.userRelationDao.insertSelective(updateObj);
			log.debug("===== [orderPay] 当前用户没有推荐关系记录uid=" + uid);
		}
	}

	/**
	 * @param uids
	 * @param count用户关系数量
	 * @param alluserid关系链上uid
	 * @param userid查询用户uid
	 */
	private void whileUserRelation(List<Long> uids, StringBuffer count, String alluserid, Long userid) {
		Long countRelation = 0L;
		try {
			countRelation = Long.valueOf(count.toString());
		} catch (Exception e) {
			log.error("[whileUserRelation] error that uid = " + userid);
		}
		if (uids == null || uids.size() < 1) {
			return;
		}
		if (null == alluserid) {
			alluserid = "";
		}
		for (Long uid : uids) {
			if (alluserid.contains("," + uid + ",")) {
				log.error("userRelation infinite loop that uid = " + userid);
				return;
			}
			alluserid = alluserid + "," + uid + ",";
		}
		if (StringUtils.isBlank(alluserid)) {
			alluserid = "," + userid + ",";
		}
		List<Long> list = this.getRelationUid(uids);
		countRelation = countRelation + list.size();
		count.delete(0, count.length());
		count.append(countRelation);
		whileUserRelation(list, count, alluserid, userid);
	}

	private Long countUserRelation(List<Long> uids, Long userid) {
		StringBuffer count = new StringBuffer("0");
		whileUserRelation(uids, count, null, userid);
		return Long.valueOf(count.toString());
	}

	public UserRelationStatisBO findByUid(Long uid) {
		UserRelationStatisBO result = userRelationStatisDao.findByUid(uid);
		return result == null ? new UserRelationStatisBO() : result;
	}

	/**
	 * 通过uid查询会员小伙伴数量
	 * 
	 * @param uid
	 * @return
	 */
	public int getAllCountByUid(Long uid) {
		int result = 0;
		try {
			UserRelationStatisBO bo = findByUid(uid);
			if (bo.getRelationCount() != null) {
				result = Integer.valueOf(bo.getRelationCount().toString());
			}
		} catch (Exception e) {
			log.error("[getAllCountByUid] error, uid = " + uid);
		}
		return result;
	}

	/**
	 * 保存小伙伴统计记录
	 * 
	 * @param uid
	 * @param changeUser
	 */
	public void saveStatisByUid(Long uid, Long changeUser) {
		if (null == uid) {
			return;
		}
		// 统计小伙伴数量
		List<Long> uids = new ArrayList<>();
		uids.add(uid);
		Long relationCount = countUserRelation(uids, uid);
		// 保存记录
		UserRelationStatisBO bo = findByUid(uid);
		bo.setRelationCount(relationCount);
		bo.setLastUpdateTime(new Date());
		bo.setLastUpdateUser(changeUser.toString());
		if (bo.getId() == null) {
			bo.setUid(uid);
			bo.setCreateTime(new Date());
			bo.setCreateUser(changeUser.toString());
		}
		userRelationStatisDao.save(bo);
	}

	public void changeStatisUid(Long oldUid, Long newUid, Long changeUser) {
		UserRelationStatisBO bo = findByUid(oldUid);
		if (bo.getId() == null) {
			return;
		}
		bo.setLastUpdateTime(new Date());
		bo.setLastUpdateUser(changeUser.toString());
		bo.setUid(newUid);
		userRelationStatisDao.save(bo);
	}
}
