package com.sinco.carnation.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.shop.SMSConstants;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.orcl.CnUserLevelBO;
import com.sinco.carnation.sys.contants.OperatorContants;
import com.sinco.carnation.sys.contants.OrclUserContants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.RoleDao;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.CodeTools;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserOwnsBO;
import com.sinco.carnation.user.dao.OperatorDao;
import com.sinco.carnation.user.dao.SellerDao;
import com.sinco.carnation.user.dao.UserOwnsDao;
import com.sinco.carnation.user.model.Operator;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.tools.RandomPassword;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.dal.common.MyPage;
import com.sinco.messager.MessageHandler;
import com.sinco.messager.util.SmsUtils;

/**
 * 
 * @ClassName: OperatorService
 * @Description: TODO(运营商业务逻辑)
 * @author Tang
 * @date 2015年9月5日 下午6:25:04
 * 
 */
@Service
@Transactional(readOnly = true)
public class OperatorService {
	@Autowired
	private OperatorDao operatorDao;
	@Autowired
	private UserService userService;
	@Autowired
	private CodeTools codeTools;
	@Autowired
	private UserRelationService userRelationService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserAccountDao accountDao;
	@Autowired
	private UserMoneyService moneyService;
	@Autowired
	private RedisCacheService redisCacheService;
	@Resource(name = "smsMessageHandler")
	private MessageHandler smsHandler;
	@Autowired
	private MsgTools msgTools;
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private SellerDao sellerDao;
	@Autowired
	private UserOwnsDao userOwnsDao;
	@Autowired
	private OrclUserBaseService orclUserBaseService;

	private static final Logger logger = LoggerFactory.getLogger(OperatorService.class);

	/**
	 * 
	 * @Title: selectOperatorByAreaAndCode @Description: TODO(根据地区市级，运营商编码，查询该市下是否有运营商) @param @param
	 *         operatorCode @param @param areaId @param @return 设定文件 @return int 返回类型 0为没有，大于0为有 @author Tang @throws
	 */
	public int selectOperatorByAreaAndCode(String operatorCode, String areaId) {
		List<OperatorBO> resultList = operatorDao.selectOperatorByAreaAndCode(operatorCode, areaId);
		return CollectionUtils.isNotEmpty(resultList) ? resultList.size() : 0;
	}

	/**
	 * 发送更换手机的验证码
	 * 
	 * @param mobile
	 * @return
	 */
	@SuppressWarnings("unused")
	public boolean sendValidateCode(Long uid, String mobile) {
		if (StringUtils.isEmpty(mobile))
			return false;
		String code = SmsUtils.createRandom(true, 6);

		String msg = "您的验证码是：" + code + "。请不要把验证码泄露给其他人。";
		logger.info("uid = " + uid + ",mobile = " + mobile + ",mes" + msg);
		boolean bo = smsHandler.sendMessage(mobile, msg);
//		if (bo) {
		redisCacheService.setSmsCode(uid, code, mobile);
//		}
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updatePhone(Long id, String phone) {
		Operator operator = new Operator();
		operator.setId(id);
		operator.setPhone(phone);
		operator.setUpdateTime(new Date());
		operatorDao.update(operator);
	}

	public OperatorBO getOperatorBOByUserId(Long userId) {
		return operatorDao.getOperatorBOByUserId(userId);
	}

	public OperatorBO getOperatorBOByOperatorCode(String code) {
		return operatorDao.getOperatorBOByOperatorCode(code);
	}

	/**
	 * 根据运营商编码 count
	 * 
	 * @param operatorCode
	 * @return
	 */
	public int countByOperatorCode(String operatorCode) {
		return operatorDao.countByOperatorCode(operatorCode);
	}

	public boolean verifyInvitationCode(String code) {
		if (StringUtils.isNotEmpty(code)) {
			return operatorDao.selectByInvitationCode(code) != null ? true : false;
		}
		return false;
	}

	public List<OperatorBO> getOperatorBOByOperatorAreaId(String operatorAreaId) {
		return operatorDao.getOperatorBOByOperatorAreaId(operatorAreaId);
	}

	public List<OperatorBO> getCheckOkOperatorByOperatorAreaId(String operatorAreaId) {
		return operatorDao.getCheckOkOperatorByOperatorAreaId(operatorAreaId);
	}

	public OperatorBO getDistrictOperatorByCode(String operatorAreaId) {
		List<OperatorBO> operatorBos = operatorDao.getCheckOkOperatorByOperatorAreaId(operatorAreaId);
		if (null == operatorBos || operatorBos.size() <= 0) {
			return null;
		}
		for (OperatorBO operatorBO : operatorBos) {
			if ("2".equals(operatorBO.getLevel())) {
				return operatorBO;
			}
		}
		return null;
	}

	public OperatorBO getCityOperatorByCode(String operatorAreaId) {
		List<OperatorBO> operatorBos = operatorDao.getCheckOkOperatorByOperatorAreaId(operatorAreaId);
		if (null == operatorBos || operatorBos.size() <= 0) {
			return null;
		}
		for (OperatorBO operatorBO : operatorBos) {
			if ("1".equals(operatorBO.getLevel())) {
				return operatorBO;
			}
		}
		return null;
	}

	public OperatorBO getOperatorBOByIdAndStatus(Long id, String status) {
		return operatorDao.getOperatorBOByIdAndStatus(id, status);
	}

	public OperatorBO get(java.lang.Long id) {
		return operatorDao.get(id);
	}

	/**
	 * @Title: checkOperator @Description: TODO(审核运营商; 审核了之后需要对改运营商的隶属关系进行整理) @param @param id @param @param
	 *         userId 设定文件 @return void 返回类型 @author Tang @throws
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void checkOperator(OperatorBO operatorBO, String userId) {
		if (operatorBO != null) {
			Operator operator = new Operator();
			operator.setId(operatorBO.getId());
			operator.setStatus(UserContants.OPERATOR_CHECK_STATUS_PASS);
			operator.setUpdateBy(userId);
			operator.setUpdateTime(new Date());
			operatorDao.update(operator);

			String password = RandomPassword.genRandomNum(6);
			userService.updatePassword(operatorBO.getUserId(), password);
			// 审核成功之后发送短信
			msgTools.sendSms(SMSConstants.SMS_OPERATOR_AUDIT_SUCCESS, operatorBO.getPhone(), new String[] {
					operatorBO.getOperatorCode(), password});

			// 添加用户角色关系
			// 添运营商权限
			List<RoleBO> roles = this.userService.findRoleByType(UserContant.ROLE_TYPE_OPERATOR);
			List<Long> rids = new ArrayList<Long>();
			for (RoleBO roleBO : roles) {
				rids.add(roleBO.getId());
			}
			this.userService.saveUserRole(operatorBO.getUserId(), UserContant.ROLE_TYPE_OPERATOR,
					rids.toArray(new Long[rids.size()]));
		}
	}

	@Transactional(readOnly = false)
	public String saveOperator(HttpServletRequest request, String requestIp, String adminId,
			OperatorBO operatorBO) {
		if (StringUtils.isNotEmpty(operatorBO.getOperatorAreaId())
				&& !UserContants.OPERATOR_LEVEL_QUYU.equals(operatorBO.getLevel())) {
			List<OperatorBO> list = getOperatorBOByOperatorAreaId(operatorBO.getOperatorAreaId());
			if (CollectionUtils.isNotEmpty(list)) {
				for (OperatorBO temp : list) {
					if (operatorBO.getId() == null) {
						if (operatorBO.getLevel().equals(temp.getLevel())) {
							return "2";
						}
					} else {
						if (!operatorBO.getOperatorAreaId().equals(temp.getOperatorAreaId())
								&& operatorBO.getLevel().equals(temp.getLevel())) {
							return "2";
						}
					}
				}
			}
		}

		operatorBO.setOperatorCode(codeTools.getOperatorCode());
		if (null != operatorBO.getId()) {
			OperatorBO operatorOld = operatorDao.get(operatorBO.getId());
			// 如果他审核通过之后就不能修改级别
			if (UserContants.OPERATOR_CHECK_STATUS_PASS.equals(operatorOld.getStatus())) {
				operatorBO.setLevel(null);
				operatorBO.setOperatorAreaId(null);
			}
			operatorBO.setAssignedTime(null);
			operatorBO.setStatus(null);
			operatorBO.setInvitationCode(null);
			operatorBO.setOperatorCode(null);
			operatorBO.setUserId(null);
			// 如果密码传过来不为空，就要修改用户密码
			if (StringUtils.isNotEmpty(operatorBO.getPassword())) {
				userService.updatePassword(operatorOld.getUserId(), operatorBO.getPassword());
			}
			// 如果uid不为空，更新用户信息
			operatorBO.setUpdateBy(adminId);
			operatorBO.setUpdateTime(new Date());

			String registrationFile = accessoryService.upload(request, "registrationFile", null);
			if (StringUtils.isNotEmpty(registrationFile)) {
				operatorBO.setRegistrationPath(registrationFile);
			}
			String organizationFile = accessoryService.upload(request, "organizationFile", null);
			if (StringUtils.isNotEmpty(organizationFile)) {
				operatorBO.setOrganizationPath(organizationFile);
			}
			String taxFile = accessoryService.upload(request, "taxFile", null);
			if (StringUtils.isNotEmpty(taxFile)) {
				operatorBO.setTaxPath(taxFile);
			}

			operatorDao.save(operatorBO);
		} else {
			OperatorBO invitationBO = null;
			if (StringUtils.isNotEmpty(operatorBO.getInvitationCode())) {
				invitationBO = operatorDao.selectByInvitationCode(operatorBO.getInvitationCode());
				if (invitationBO == null) {
					return "1";
				}
			}

			// account为空，先添加account,再添加运营商

			Long userId = userService.createUser(UserContant.USER_TYPE_4, UserContant.ACCOUNT_TYPE_9,
					operatorBO.getOperatorCode(), RandomPassword.genRandomNum(6), requestIp);
			if (userId > 0) {
				// 如果邀请码不为空的话，那么需要插入邀请关系
				if (invitationBO != null) {
					userRelationService.createUserRelation(userId, invitationBO.getUserId(), null);
				}
				operatorBO.setUserId(userId);
				operatorBO.setAssignedTime(new Date());
				operatorBO.setUpdateBy(adminId);
				operatorBO.setUpdateTime(new Date());
				operatorBO.setCreateBy(adminId);
				operatorBO.setCreateTime(new Date());
				operatorDao.save(operatorBO);
				moneyService.isExistAndCreate(userId);
			}
		}

		return "0";
	}

	public List<OperatorBO> selectRegisterOperatorPageList(MyPage<OperatorBO> page, OperatorVO vo) {
		return operatorDao.selectRegisterOperatorPageList(page, vo);
	}

	public List<OperatorBO> selectOwnOperatorPageList(MyPage<OperatorBO> page, OperatorVO vo) {
		return operatorDao.selectOwnOperatorPageList(page, vo);
	}

	public List<OperatorBO> selectOperatorPageList(MyPage<OperatorBO> page, OperatorVO vo) {
		return operatorDao.selectOperatorPageList(page, vo);
	}

	/**
	 * 用户登入方法
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void login(Long uid, String loginName, String ip) {
		// 修改最后登录时间
		UserAccount updateAccount = new UserAccount();
		updateAccount.setLastLoginIp(ip);
		updateAccount.setLastLoginTime(new Date());
		accountDao.updateByLoginName(loginName, updateAccount);
	}

	/**
	 * 初始化权限
	 * 
	 * @param mappings
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void initOperatorRole(List<SecurityMapping> mappings) {
		userService.initRole(mappings);

		List<Long> rids = new ArrayList<Long>();

		List<RoleBO> buyerRoles = roleDao.findByType(UserContant.ROLE_TYPE_OPERATOR);
		for (RoleBO roleBO : buyerRoles) {
			rids.add(roleBO.getId());
		}

		// 给个人用户设置权限
		List<OperatorBO> all = this.operatorDao.findAll();
		for (OperatorBO operatorBO : all) {
			userService.saveUserRole(operatorBO.getUserId(), UserContant.ROLE_TYPE_OPERATOR,
					rids.toArray(new Long[rids.size()]));
		}
	}

	public OperatorBO queryOperatorInfo(Long uid) {
		return operatorDao.queryOperatorInfo(uid);
	}

	public OperatorBO getOperatorByMobile(String mobile) {
		return operatorDao.getOperatorByMobile(mobile);
	}

	/**
	 * CN账户登录运营商系统会员初始化
	 * 
	 * @param operatorBO
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long saveCnOperator(String username) {
		Long userId = userService.createUser(UserContant.USER_TYPE_4, UserContant.ACCOUNT_TYPE_8, username,
				RandomPassword.genRandomNum(6), "10000");
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
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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
		moneyService.isExistAndCreate(userId);
		return userId;
	}

	public OperatorBO selectOperatorByCnUserName(String cn_username) {

		return operatorDao.selectOperatorByCnUserName(cn_username);
	}

	public OperatorBO findOne(Long ownOperatorId) {
		// TODO Auto-generated method stub
		return operatorDao.findOne(ownOperatorId);
	}

	public OperatorBO queryOperatorByLoginName(String loginName) {
		// CN账户可以以CN账号登陆orYY开头的账号登陆
		// 所以需要进行判断区别
		boolean isYYStart = false;
		try {
			isYYStart = loginName.substring(0, 2).trim().equals("YY");
		} catch (Exception e) {

		}
		OperatorBO result = new OperatorBO();
		String cn_userName = "";
		if (isYYStart) {
			cn_userName = loginName.substring(2, loginName.length());
			result = this.selectOperatorByCnUserName(cn_userName);
		} else {
			result = this.selectOperatorByCnUserName(loginName);
		}
		return result;
	}

	@Transactional(readOnly = false)
	public void update(Operator record) {
		this.operatorDao.update(record);
	}

	/**
	 * 检查商户是否为隶属关系
	 * 
	 * @param operatorID
	 *            运营商ID
	 * @param storeID
	 *            店铺ID
	 * @return
	 */
	public boolean check_SubMerchant(Long operatorID, Long storeID) {

		StoreBO store = this.storeDao.findOne(storeID);
		if (store != null && store.getId() != 0l) {
			// 根据店铺ID获取对应卖家
			SellerBO seller = this.sellerDao.selectByStore(String.valueOf(store.getId()));
			if (seller != null) {
				Long sellerUID = seller.getUid();
				Integer ownType = 1;
				UserOwnsBO userOwn = this.userOwnsDao.selectBOBySellerId(sellerUID,ownType);
				if (userOwn != null) {
					Long ownOperatorId = userOwn.getOwnOperatorId();
					if (ownOperatorId.equals(operatorID)) {
						return true;
					}
				}

			}
		}
		return false;
	}

	/**
	 * 为隶属商户注册会员
	 * 
	 * @param operatorID
	 * @param storeID
	 * @return 200:succ 304:未修改
	 */
	@Transactional(readOnly = false)
	public int reg_member_other_update(Long operatorID, Long storeID) {
		// 根据店铺ID获取对应卖家
		StoreBO store = this.storeDao.findOne(storeID);
		if (store != null && store.getId() != 0l) {
			// 店铺ID
			long store_ID = store.getId();
			SellerBO seller = this.sellerDao.selectByStore(String.valueOf(store_ID));
			// 卖家UID
			long sellerUID = seller.getUid();
			// 为隶属商户注册会员
			Operator operator = new Operator();
			operator.setExtensionSellerUid(sellerUID);
			operator.setId(operatorID);
			this.operatorDao.update(operator);
			// 标示已被所属运营商推广
			Store upStore = new Store();
			upStore.setId(store_ID);
			upStore.setIsExtension(true);
			this.storeDao.update(upStore);
			// 运营商每次只能为隶属商户推广注册会员
			// 其他隶属商户标示为未推广注册会员
			List<UserOwnsBO> userOwnList = this.userOwnsDao
					.findAllSellerNotBySellerUID(operatorID, sellerUID);
			List<Long> seller_ID_List = new ArrayList<Long>();
			for (UserOwnsBO own : userOwnList) {
				seller_ID_List.add(own.getSellerUserId());
			}
			if (seller_ID_List.size() > 0) {
				List<Seller> sellerList = this.sellerDao.selectSellerinUIDList(seller_ID_List);
				List<Long> storeIDList = new ArrayList<Long>();
				for (Seller sellerTemp : sellerList) {
					storeIDList.add(sellerTemp.getStoreId());
				}
				if (storeIDList.size() > 0) {
					this.storeDao.update_Store_IsExtension_By_IDList(storeIDList, false);
				}
			}
			return 200;
		}
		return 304;
	}

	/**
	 * 是否为运营商
	 * 
	 * @param uid
	 * @return false 否 true: 是
	 */
	public boolean isOperator(long uid) {
		OperatorBO bo = this.operatorDao.getOperatorBOByUserId(uid);
		if (bo != null && bo.getId() > 0L) {
			return true;
		}
		return false;
	}

	public List<OperatorBO> getLevelAndArea(String areaId, Integer level) {
		return this.operatorDao.getLevelAndArea(areaId, level);
	}

	/**
	 * cn运营商每次登陆需要更新运营商级别
	 * 
	 * @param uid
	 */
	@SuppressWarnings("null")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateCnLevel(String userName) {
		// 查询运营商信息
		OperatorBO operatorBO = this.selectOperatorByCnUserName(userName);
		if (operatorBO != null) {
			String cnName = operatorBO.getCn_username();
			long id = operatorBO.getId();
			// 根据cn账号查询结算系统那边的等级
			CnUserLevelBO cn = orclUserBaseService.getOrclUserLevel(cnName);
			String level = OperatorContants.OPERATOR_LEVEL_9;
			if (null != cn || null != cn.getUserType() || "" != cn.getUserType()) {
				String userType = cn.getUserType();
				if (OrclUserContants.OPERATOR_LEVEL_SILVER.equals(userType)) {
					level = OperatorContants.OPERATOR_LEVEL_9;
				} else if (OrclUserContants.OPERATOR_LEVEL_GOLD.equals(userType)) {
					level = OperatorContants.OPERATOR_LEVEL_7;
				} else if (OrclUserContants.OPERATOR_LEVEL_VIP.equals(userType)) {
					level = OperatorContants.OPERATOR_LEVEL_3;
				}
			}
			boolean levelChange = true;
			if (CommUtil.isNotNull(operatorBO.getLevel())) {// 等级非空
				if (level.equals(operatorBO.getLevel())) {// 等级没变
					levelChange = false;
				}
			}
			if (levelChange) {
				Operator operator = new Operator();
				operator.setId(id);
				operator.setLevel(level);
				this.operatorDao.save(operator);
				logger.info("[updateCnLevel] operatorId = " + id);
			}
		}
	}
	public OperatorBO queryOperatorByOperatorCode(String operatorCode)
	{
		return this.operatorDao.queryOperatorByOperatorCode(operatorCode);
	}
	
	public List<OperatorBO> listAllOperator(){
		return this.operatorDao.listAllOperator();
	}
}
