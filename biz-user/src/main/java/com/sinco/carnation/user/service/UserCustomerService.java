package com.sinco.carnation.user.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Maps;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.dao.GoodsDao;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.dao.GroupGoodsDao;
import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.dao.CouponInfoDao;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.dao.OrderFormDao;
import com.sinco.carnation.shop.dao.PredepositCashDao;
import com.sinco.carnation.sns.SNSConstants;
import com.sinco.carnation.sns.bo.CircleInvitationBO;
import com.sinco.carnation.sns.dao.CircleInvitationDao;
import com.sinco.carnation.sns.model.CircleInvitation;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.bo.orcl.IntegralSwapBO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.BindingHistoryDao;
import com.sinco.carnation.sys.dao.RoleDao;
import com.sinco.carnation.sys.dao.SysLogDao;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.model.BindingHistory;
import com.sinco.carnation.sys.model.SysLog;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.bo.UserCustomerFavoritesBO;
import com.sinco.carnation.user.bo.UserExpertsBO;
import com.sinco.carnation.user.bo.UserMoneyBO;
import com.sinco.carnation.user.dao.AlbumDao;
import com.sinco.carnation.user.dao.IntegralLogDao;
import com.sinco.carnation.user.dao.OperatorDao;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.dao.UserCustomerFavoritesDao;
import com.sinco.carnation.user.dao.UserExpertsDao;
import com.sinco.carnation.user.dao.UserMoneyDao;
import com.sinco.carnation.user.dao.UserRelationDao;
import com.sinco.carnation.user.model.Album;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.model.UserCustomerFavorites;
import com.sinco.carnation.user.model.UserExperts;
import com.sinco.carnation.user.model.UserMoney;
import com.sinco.carnation.user.vo.UpdateWxVO;
import com.sinco.carnation.user.vo.UserCustomerFavoritesVO;
import com.sinco.carnation.user.vo.UserCustomerVO;
import com.sinco.common.utils.Base64;
import com.sinco.dal.common.MyPage;
import com.sinco.messager.MessageHandler;
import com.sinco.messager.mobile.MobileMessageHandler;
import com.sinco.messager.mobile.jpush.AliasMobileChannel;
import com.sinco.messager.mobile.jpush.MessageMobileMessage;
import com.sinco.messager.util.SmsUtils;

import net.weedfs.client.WeedFSClient;
import vc.thinker.b2b2c.core.constant.Globals;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class UserCustomerService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserAccountDao userAccountDao;

	@Autowired
	private UserCustomerDao userCustomerDao;
	@Autowired
	private UserRelationDao userRelationdao;

	@Autowired
	private UserCustomerFavoritesDao favoritesDao;

	@Autowired
	private UserExpertsDao expertsDao;

	@Autowired
	private CircleInvitationDao invitationDao;

	@Autowired
	private RedisCacheService redisCacheService;

	@Autowired
	private UserAccountService accountService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserAccountDao accountDao;

	@Autowired
	private OperatorDao operatorDao;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private IntegralLogDao integralLogDao;

	@Autowired
	private OrderFormDao orderFormDao;

	@Autowired
	private CouponInfoDao couponInfoDao;

	@Autowired
	private IntegralLogService integralLogService;

	@Resource(name = "smsMessageHandler")
	private MessageHandler smsHandler;

	@Autowired
	private MsgTools msgTools;

	@Autowired
	private AlbumDao albumDao;

	@Autowired
	private AlbumService albumService;

	@Autowired
	private PredepositCashDao predepositCashDao;

	@Autowired
	private SysLogDao sysLogDao;

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private StoreDao storeDao;

	@Autowired
	private UserMoneyDao moneyDao;
	@Autowired
	private AddressService addressService;

	@Autowired
	private UserMoneyService moneyServer;

	@Autowired
	private WeedFSClient fsClient;
	@Autowired
	private GroupGoodsDao groupGoodsDao;

	@Autowired
	private IntegralService integralService;

	@Autowired
	private UserRelationService userRelationService;

	@Autowired
	private BindingHistoryDao bindingHistoryDao;

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private OrclUserBaseService orclUserBaseService;

	/** 默认的头像文件扩展名 */
	private static final String DEFAULT_AVATAR_FILE_EXT = ".jpg";

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "jpushMobileMessageHandler")
	private MobileMessageHandler mobileMessageHandler;

	public List<UserCustomerBO> selectUserCustomerByOperatorUserId(UserCustomerVO vo,
			MyPage<UserCustomerBO> page) {
		List<UserCustomerBO> list = userCustomerDao.selectUserCustomerByOperatorUserId(vo, page);
		if (!CollectionUtils.isEmpty(list)) {
			for (int i = 0; i < list.size(); i++) {
				UserCustomerBO userCustomerBO = list.get(i);
				OperatorBO opbo = null;
				if (userCustomerBO.getOwnOperatorId() != null) {
					opbo = operatorDao.get(userCustomerBO.getOwnOperatorId());
					list.get(i).setOperator(opbo);
				}
				/*				if(userCustomerBO != null && userCustomerBO.getSellerUid() != null){
									StoreBO store = storeDao.getStoreByUserId(userCustomerBO.getSellerUid());
									if (store != null) {
										userCustomerBO.setStoreName(store.getStoreName());// 设置店铺名称
									}
								}*/
			}
			page.setContent(list);
		}

		return list;
	}

	public List<UserCustomerBO> selectOwnCustomerByOperatorUserId(UserCustomerVO vo,
			MyPage<UserCustomerBO> page) {
		List<UserCustomerBO> list = userCustomerDao.selectOwnCustomerByOperatorUserId(vo, page);
		if (!CollectionUtils.isEmpty(list)) {
			for (int i = 0; i < list.size(); i++) {
				UserCustomerBO userCustomerBO = list.get(i);
				OperatorBO opbo = null;
				if (userCustomerBO.getOwnOperatorId() != null) {
					opbo = operatorDao.get(userCustomerBO.getOwnOperatorId());
					list.get(i).setOperator(opbo);
				}
			}
			page.setContent(list);
		}

		return list;
	}

	public List<Long> findAllCustomer() {
		List<UserCustomerBO> customerList = userCustomerDao.findAll(false);
		if (!CollectionUtils.isEmpty(customerList)) {
			List<Long> userIds = new ArrayList<>();
			for (UserCustomerBO userCustomerBO : customerList) {
				userIds.add(userCustomerBO.getUid());
			}
			return userIds;
		}
		return null;
	}

	public void sendMessage(List<Long> userIds, String content) {
		MessageMobileMessage message = new MessageMobileMessage(content);
		// 附加参数，需要什么自己加
		Map<String, String> exts = Maps.newHashMap();
		exts.put("messageType", "2");
		message.setExts(exts);
		// message.setMessage("您咨询的问题"+consulting.getTitle()+"有了新的回复，请去查看！");

		// 消息的渠道分为 Alias 和 tag ,消息内容分为 alert 和 message
		if (!CollectionUtils.isEmpty(userIds)) {
			for (Object userId : userIds) {
				mobileMessageHandler.sendMessage(new AliasMobileChannel(String.valueOf(userId)), message);
			}
		}
	}

	/**
	 * 根据昵称 count
	 * 
	 * @param nickname
	 * @return
	 */
	public int countByNickname(String nickname, Long notUid) {
		return this.userCustomerDao.countByNickname(nickname, notUid);
	}

	/**
	 * 初始化个人用户商城权限,非事务进行
	 * 
	 * @param mappings
	 */
	@Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
	public void initCustomerRole() {
		List<Long> rids = new ArrayList<Long>();

		// 商城权限
		List<RoleBO> buyerRoles = roleDao.findByType(UserContant.ROLE_TYPE_BUYER);
		for (RoleBO roleBO : buyerRoles) {
			rids.add(roleBO.getId());
		}

		// 给个人用户设置权限
		List<UserCustomerBO> customerAll = this.userCustomerDao.findAll(false);
		for (UserCustomerBO customer : customerAll) {
			userService.saveUserRole(customer.getUid(), UserContant.ROLE_TYPE_BUYER,
					rids.toArray(new Long[rids.size()]));
		}
	}

	/**
	 * 修改用户积分
	 * 
	 * @param uid
	 * @param integral
	 * @return
	 */
	public boolean addIntegral(Long uid, int integral) {
		return userCustomerDao.addIntegral(uid, integral) == 1;
	}

	/**
	 * 减少用户积分
	 * 
	 * @param uid
	 * @param integral
	 * @return
	 */
	public boolean subtractIntegral(Long uid, int integral) {
		return userCustomerDao.subtractIntegral(uid, integral) == 1;
	}

	/**
	 * 编辑会员信息
	 * 
	 * @param uid
	 * @return
	 */
	public UserCustomerBO queryUserByUid(Long uid) {
		return userCustomerDao.queryUserByUid(uid);
	}

	/**
	 * 发送注册的验证码
	 * 
	 * @param mobile
	 * @return
	 */
	public boolean sendRegisterValidateCode(String mobile, String ip) {
		String code = SmsUtils.createRandom(true, 6);
		log.info("this mobile Send verification code to used register and the mobile:" + mobile + ", code :"
				+ code);
		msgTools.sendSms("sms_tobuyer_validate_code", mobile, ip, new String[] {code});
		redisCacheService.setSmsCode(0L, code, mobile);
		return true;
	}

	/**
	 * 发送其它验证码
	 * 
	 * @param mobile
	 * @return
	 */
	public boolean sendValidateCode(Long uid, String mobile, String ip) {
		String code = SmsUtils.createRandom(true, 6);
		log.info("this mobile Send verification code to used other and the mobile:" + mobile + ", code :"
				+ code);
		msgTools.sendSms("sms_tobuyer_validate_code", mobile, ip, new String[] {code});
		redisCacheService.setSmsCode(uid, code, mobile);
		return true;
	}

	/**
	 * 发送更换手机的验证码
	 * 
	 * @param mobile
	 * @return
	 */
	public boolean sendChangeMobielValidateCode(Long uid, String mobile) {
		UserCustomer customer = findByMobile(mobile);
		if (customer != null)
			return false;
		String code = SmsUtils.createRandom(true, 6);
		// String content = "尊敬的"
		// + customer.getName()
		// + "您好，您在试图修改"
		// + configService.getSysConfig().getWebsiteName()
		// + "用户绑定手机，手机验证码为：" + code + "。["
		// + configService.getSysConfig().getTitle() + "]";
		log.info("this mobile Send verification code to used change mobile and the mobile:" + mobile
				+ ", code :" + code);
		msgTools.sendSms("sms_tobuyer_validate_code", mobile, code);

		redisCacheService.setSmsCode(uid, code, mobile);

		return true;
	}

	public UserCustomerBO selectByNickname(String nickname) {
		return userCustomerDao.selectByNickname(nickname);
	}

	// public boolean updateBalance(String balance, String userId) {
	// return userCustomerDao.updateBalance(balance, userId) == 1;
	// }

	/**
	 * 更换手机
	 * 
	 * @param mobile
	 * @return
	 */
	@SuppressWarnings("null")
	@Transactional(readOnly = false)
	public boolean changeMobile(Long userId, String mobile, String code) {
		UserCustomer customer = findByMobile(mobile);
		if (null != customer)
			return false;

		String codeRedis = redisCacheService.getSmsCode(userId, mobile);
		// 用户未申请发送过验证码，或者验证号已过期
		if (StringUtils.isBlank(codeRedis))
			return false;
		// 验证码是否正确
		if (!code.equalsIgnoreCase(codeRedis))
			return false;

		// 绑定成功后发送手机短信提醒
		String content = "尊敬的" + customer.getName() + "您好，您于" + CommUtil.formatLongDate(new Date())
				+ "绑定手机号成功。[" + configService.getSysConfig().getTitle() + "]";
		smsHandler.sendMessage(mobile, content);

		customer.setMobile(mobile);
		if (userCustomerDao.updateByPrimaryKeySelective(customer) > 0)
			return true;

		return false;
	}

	/**
	 * 用户登入方法
	 */
	@Transactional(readOnly = false)
	public void login(Long uid, String loginName, String ip) {
		// SysConfigBO sysConfig = configService.getSysConfig();

		// if (sysConfig.getIntegral()) {
		// UserAccountBO account = accountDao.findLastLogin(uid);
		// // 如果是当天第一次登录
		// if (account == null ||
		// account.getLastLoginTime().before(CommUtil.formatDate(CommUtil.formatShortDate(new
		// Date())))) {
		// // 添加积分
		// if (userCustomerDao.addIntegral(uid, sysConfig.getMemberDayLogin()) >
		// 0) {
		// IntegralLog log = new IntegralLog();
		// log.setAddtime(new Date());
		// log.setContent("用户" + CommUtil.formatLongDate(new Date()) + "登录增加" +
		// sysConfig.getMemberDayLogin() + "分");
		// log.setIntegral(sysConfig.getMemberDayLogin());
		// log.setIntegralUserId(uid);
		// log.setType(UserContants.INTEGRAL_LOG_TYPE_LOGIN);
		// log.setOperateUserId(uid);
		// this.integralLogDao.save(log);
		// }
		// }
		// }

		// 添加积分
		this.integralService.addIntegral(IntegralConstants.INTEGRAL_LOGIN, uid, null);
		System.out.println("555555555555555555555555555555555555555555555555555555");
		// 修改最后登录时间
		UserAccount updateAccount = new UserAccount();
		updateAccount.setLastLoginIp(ip);
		updateAccount.setLastLoginTime(new Date());
		accountDao.updateByLoginName(loginName, updateAccount);
		System.out.println("99999999999999999999999999999999999999999999999999999");
	}

	/**
	 * 商品竞购减积分
	 * 
	 * @param uid
	 * @param integral
	 */
	public void useOrderIntegral(Long uid, int integral) {
		if (integral > 0) {
			UserCustomerBO userBO = userCustomerDao.findSessionUser(uid);
			if (userCustomerDao.subtractIntegral(uid, integral) > 0) {
				// 记录日志
				integralLogService.saveLog("用户" + CommUtil.formatLongDate(new Date()) + "使用" + integral
						+ "分兑购商品", uid, uid, Integer.parseInt("-" + integral), userBO.getIntegral(),
						UserContants.INTEGRAL_LOG_TYPE_INTEGRAL_ORDER);
			}
		}
	}

	/**
	 * 订单取消 返还积分
	 * 
	 * @param uid
	 * @param integral
	 * @param orderId
	 */
	public void useOrderIntegralReturn(Long uid, int integral, String orderId) {
		if (integral > 0) {
			UserCustomerBO userBO = userCustomerDao.findSessionUser(uid);
			if (userCustomerDao.subtractIntegral(uid, -integral) > 0) {
				// 记录日志
				integralLogService.saveLog("用户" + CommUtil.formatLongDate(new Date()) + "取消" + orderId
						+ "积分兑购，返还积分", uid, uid, integral, userBO.getIntegral(),
						UserContants.INTEGRAL_LOG_TYPE_INTEGRAL_ORDER);
			}
		}
	}

	public void freezeUsers(String mulitId, boolean freezed) {
		if (StringUtils.isNotBlank(mulitId)) {
			String[] ids = mulitId.split(",");
			for (String id : ids) {
				User user = userDao.findById(CommUtil.null2Long(id));
				if (null != user) {
					User userUpdate = new User();
					userUpdate.setId(CommUtil.null2Long(id));
					userUpdate.setStatus(freezed ? 2 : 1);
					userDao.updateById(userUpdate);
				}
			}
		}
	}

	/**
	 * 删除会员
	 */
	@Transactional(readOnly = false)
	public void delMember(String mulitId) {
		if (StringUtils.isNotBlank(mulitId)) {
			String[] ids = mulitId.split(",");
			for (String uid : ids) {
				// 会员订单
				List<OrderFormBO> orderForm = orderFormDao.queryOrderFromByUid(uid);
				for (OrderFormBO order : orderForm) {
					// 删除订单
					orderFormDao.delete(order.getId());
				}
				// 会员优惠券
				List<CouponInfoBO> couponBO = couponInfoDao.queryCouponByUid(CommUtil.null2Long(uid));
				for (CouponInfoBO coupon : couponBO) {
					// 删除优惠券
					couponInfoDao.delete(coupon.getId());
				}
				// 会员相册
				List<AlbumBO> albums = albumDao.queryAlbumListByUid(CommUtil.null2Long(uid));
				for (Album album : albums) {
					// 删除相册
					albumService.albumDelete(String.valueOf(album.getId()));
				}
				// 会员充值记录
				List<PredepositCashBO> predepositBOs = predepositCashDao.queryPredepositCashByUid(CommUtil
						.null2Long(uid));
				for (PredepositCashBO pred : predepositBOs) {
					// 删除会员充值记录
					predepositCashDao.delete(pred.getId());
				}
				// 会员日志
				List<SysLog> sysLogs = sysLogDao.querySysLogByUid(CommUtil.null2Long(uid));
				for (SysLog sysLog : sysLogs) {
					// 删除会员操作日志
					sysLogDao.delete(sysLog.getId());
				}
				// 还有删除购物车记录和积分记录 待完成。。。。。。。。。。。。。

				// 删除会员帐号
				// 删除customer
				userCustomerDao.deleteById(CommUtil.null2Long(uid));
				// 删除account
				userAccountDao.delExpert(CommUtil.null2Long(uid));
				// 删除user
				userDao.deleteById(CommUtil.null2Long(uid));
			}
		}
	}

	/**
	 * 后台添加会员
	 */
	@Transactional(readOnly = false)
	public void addUser(UserCustomerVO user, String ip) {
		// 先添加account
		Long uid = userService.createUser(UserContant.USER_TYPE_1, UserContant.ACCOUNT_TYPE_2,
				user.getLoginName(), user.getPassword(), ip);
		// 添加customer
		createCustomer(uid, user.getMobile(), user.getNickname(), user.getName(), user.getEmail(),
				user.getSex());
	}

	/**
	 * 修改会员信息
	 */
	@Transactional(readOnly = false)
	public void updateUser(UserCustomerVO user) {
		if (user.getUid() != null && StringUtils.isNotBlank(user.getPassword())) {
			// 修改会员密码
			userService.updatePassword(user.getUid(), user.getPassword());
		}
		// 修改会员基本信息
		updateUserInfo(user.getUid(), user.getMobile(), user.getNickname(), null, user.getEmail(),
				user.getName(), null, null, null, user.getSex(), user.getBirthdate(), null, null, null,
				user.getUserSignature());

	}

	/**
	 * 修改会员发票信息
	 */
	@Transactional(readOnly = false)
	public boolean updateUserInvoice(UserCustomer customer) {
		return userCustomerDao.updateById(customer) > 0;
	}

	/**
	 * 根据电话号码查询用户
	 * 
	 * @param mobile
	 * @return
	 */
	public UserCustomerBO findByMobile(String mobile) {
		return userCustomerDao.findByMobile(mobile);
	}

	/**
	 * 得到放session里的个人数据
	 * 
	 * @param id
	 * @return
	 */
	public UserCustomerBO findSessionUser(Long id) {
		return userCustomerDao.findSessionUser(id);
	}

	public int createCustomer(Long uid, String mobile, String nicName, String name, String email, Integer sex) {
		return createCustomer(uid, mobile, nicName, name, email, sex, 0L);
	}

	/**
	 * 创建个人用户方法
	 * 
	 * @param uid
	 * @param mobile
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int createCustomer(Long uid, String mobile, String nicName, String name, String email,
			Integer sex, Long refereeUserId) {
		SysConfigBO config = this.configService.getSysConfig();
		// 创建用户默认相册
		Album album = new Album();
		album.setAlbumDefault(true);
		album.setAlbumName("默认相册");
		album.setAlbumSequence(-10000);
		this.albumService.albumSave(uid, album);

		// 添加买家权限
		List<RoleBO> roles = this.userService.findRoleByType(UserContant.ROLE_TYPE_BUYER);
		List<Long> rids = new ArrayList<Long>();
		for (RoleBO roleBO : roles) {
			rids.add(roleBO.getId());
		}
		this.userService.saveUserRole(uid, UserContant.ROLE_TYPE_BUYER, rids.toArray(new Long[rids.size()]));

		UserMoney money = new UserMoney();
		money.setAvailableBalance(new BigDecimal(0));
		money.setUid(uid);
		this.moneyDao.create(money);

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
		// 设置用户默认头像
		if (config.getMemberIcon() != null) {
			customer.setHeadImgPath(config.getMemberIcon().getPath());
		}

		int result = userCustomerDao.insert(customer);
		if (result == 0) {
			return 0;
		}
		// 添加积分
		integralService.addIntegral(IntegralConstants.INTEGRAL_REGISTER, uid, uid);
		// 推荐人也赠送积分
		if (refereeUserId != null && refereeUserId > 0)
			integralService.addIntegral(IntegralConstants.INTEGRAL_INVITE_FRIENDS, refereeUserId, uid);
		//
		// 绑定第三方用户加分 第三方绑定增加操作 一.加积分 2:手机3:QQ4:微信5:微博
		/*integralService.bindingThirdDo(accountType,uid,loginName);*/
		return result;
	}

	/**
	 * 用户注册
	 * 
	 * @param mobile
	 * @param registImei
	 * @param password
	 * @param requestIp
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = false)
	public int createUser(String nickname, String mobile, String password, String requestIp, String code) {

		UserAccountBO userAccount = accountService.findByMobile(mobile, UserContant.ACCOUNT_TYPE_2);
		if (null != userAccount) {
			// 用户已存在
			return -4;
		}
		if (userCustomerDao.countByNickname(nickname, null) > 0) {
			// 用户昵称已存在
			return -5;
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
		return createCustomer(uid, mobile, nickname, null, null, null);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param mobile
	 * @param nicName
	 * @param birthDate
	 * @param headImgPath
	 * @param email
	 * @return
	 */
	@Transactional(readOnly = false)
	public int updateUserInfo(Long uid, String mobile, String nicName, String headImgPath, String email,
			String name, Integer hegiht, Integer weight, String allergHistory, Integer sex, String birthDate,
			String transGenetic, String transHistory, String blood, String userSignature) {
		UserCustomer customer = new UserCustomer();
		customer.setUid(uid);
		customer.setMobile(mobile);
		customer.setNickname(nicName);
		customer.setHeadImgPath(headImgPath);
		customer.setEmail(email);
		customer.setStatus("1");
		customer.setUpdateTime(new Date());
		customer.setName(name);
		customer.setHeight(hegiht);
		customer.setWeight(weight);
		customer.setAllergicHistory(allergHistory);
		customer.setSex(sex);
		customer.setUserSignature(userSignature);
		if (StringUtils.isNotBlank(birthDate)) {
			try {
				customer.setBirthdate(DateUtils.parseDate(birthDate, "yyyyy-MM-dd"));
			} catch (ParseException e) {
				log.error("生日格式转换出错", e);
			}
		}
		customer.setTransGenetic(transGenetic);
		customer.setTransHistory(transHistory);
		if (uid != null) {
			customer.setUpdateBy(uid.toString());
		}
		customer.setIsDeleted(false);
		customer.setBlood(blood);
		return userCustomerDao.updateByPrimaryKeySelective(customer);

	}

	@Transactional(readOnly = false)
	public int updateUserImg(Long uid, String headImgPath) {
		try {
			UserCustomer customer = new UserCustomer();
			customer.setUid(uid);
			customer.setHeadImgPath(headImgPath);
			customer.setUpdateBy(String.valueOf(uid));
			customer.setUpdateTime(new Date());
			return userCustomerDao.updateByPrimaryKeySelective(customer);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return -1;
	}

	public UserCustomerBO searchCustomer(Long userId) {
		UserCustomerBO bo = userCustomerDao.searchCustomerBO(userId);
		// customer mobile 字段没保存成功 取account表loginName登录手机号
		if (bo != null) {
			if (bo.getMobile() == null) {
				UserAccount account = userAccountService.findByUid(userId, UserContant.ACCOUNT_TYPE_2);
				if (account != null) {
					bo.setMobile(account.getLoginName());
				}
			}
		}
		return bo;
	}

	/**
	 * 查找用户收藏
	 * 
	 * @param uid
	 * @param fid
	 * @return
	 */
	public UserCustomerFavorites findFavoritesByFid(Long uid, String fid, String type) {
		return favoritesDao.findFavoritesByFid(uid, fid, type);
	}

	/**
	 * 查询用户收藏列表
	 * 
	 * @param uid
	 * @param fid
	 * @param type
	 * @return
	 */
	public void queryFavorites(UserCustomerFavoritesVO vo, MyPage<UserCustomerFavoritesBO> page) {
		favoritesDao.queryFavorites(vo, page);
	}

	/**
	 * 查询服务商家收藏列表 此处包装了收藏人气
	 * 
	 * @param vo
	 * @param page
	 */
	public void queryGroupStores(UserCustomerFavoritesVO vo, MyPage<UserCustomerFavoritesBO> page) {
		favoritesDao.queryFavorites(vo, page);
		List<UserCustomerFavoritesBO> list = page.getContent();
		for (UserCustomerFavoritesBO bo : list) {
			if (null != bo.getFid()) {
				StoreBO store = storeDao.findOne(Long.parseLong(bo.getFid()));
				bo.setFavoriteCount(store.getFavoriteCount());
			}
		}

	}

	/**
	 * 查询收藏的团购券
	 * 
	 * @param vo
	 * @param page
	 */
	public void queryGroupServiceFavorites(Long userId, MyPage<GroupGoodsBO> page) {

		favoritesDao.queryGroupServiceFavorites(userId, page);
	}

	public boolean queryIsFavorites(Long uid, String fid, String type) {
		UserCustomerFavorites favorites2 = favoritesDao.findFavoritesByFid(uid, fid, type);
		return favorites2 != null;
	}

	/**
	 * 搜索用户收藏的团购券
	 * 
	 * @param userId
	 *            已知的用户id
	 * @param type
	 *            现金券或者套餐券
	 * @param page
	 */
	public void searchFavoriteGroupServices(Long uid, String nickName, String type, MyPage<GroupGoodsBO> page) {
		favoritesDao.searchFavoriteGroupGoods(uid, nickName, type, page);
	}

	/**
	 * 搜索用户收藏的商品
	 * 
	 * @param userId
	 *            已知的用户ID
	 * @param page
	 */
	public void searchFavoriteGoods(Long uid, String nickName, MyPage<GoodsBO> page) {
		favoritesDao.searchFavoriteGoods(uid, nickName, page);
	}

	/**
	 * 搜索用户收藏的商户
	 * 
	 * @param userId
	 *            已知的用户ID
	 * @param page
	 */
	public void searchFavoriteStores(Long uid, String nickName, String type, MyPage<StoreBO> page) {
		favoritesDao.searchFavoriteStores(uid, nickName, type, page);
	}

	/**
	 * 搜索用户收藏的专家
	 * 
	 * @param nickName
	 *            收藏用户昵称
	 * @param page
	 */
	public void searchFavoriteExperts(Long uid, String nickName, MyPage<UserExpertsBO> page) {
		favoritesDao.searchFavoriteExperts(uid, nickName, page);
	}

	/**
	 * 搜索用户收藏的帖子
	 * 
	 * @param nickName
	 *            收藏用户昵称
	 * @param page
	 */
	public void searchFavoriteCircleInvitations(Long uid, String nickName, MyPage<CircleInvitationBO> page) {
		favoritesDao.searchFavoriteCircleInvitations(uid, nickName, page);
	}

	/**
	 * 添加收藏
	 * 
	 * @param uid
	 * @param fid
	 * @param type
	 * @return
	 */
	@Transactional(readOnly = false)
	public int addFavorites(Long uid, String fid, String type) throws ServiceException {

		UserCustomerFavorites favorites2 = favoritesDao.findFavoritesByFid(uid, fid, type);
		if (null != favorites2) {
			// 如果用户已经收藏
			return 1;
		} else {
			// 如果没收藏
			UserCustomerFavorites favorites = new UserCustomerFavorites();
			favorites.setUid(uid);
			favorites.setFid(fid);
			favorites.setType(type);
			favorites.setCreateTime(new Date());
			if (favoritesDao.addFavorites(favorites) > 0) {
				if (type.equals(UserContants.FAVORITES_TYPE_1)) {
					// 更新帖子收藏用户id
					CircleInvitation invitation = invitationDao.findOne(Long.parseLong(fid));
					if (null != invitation) {
						invitationDao.updateFavo(invitation.getId(), String.valueOf(uid));
					}
				} else if (type.equals(UserContants.FAVORITES_TYPE_2)) {
					// 更新专家收藏用户id
					UserExperts experts = expertsDao.queryExpertById(Long.parseLong(fid));
					if (null != experts) {
						expertsDao.updateExpertsFavo(experts.getUid(), String.valueOf(uid));
					}
				} else if (type.equals(UserContants.FAVORITES_TYPE_3)) {
					// 商品收藏
					goodsDao.increaseGoodsCollect(Long.parseLong(fid));
				} else if (type.equals(UserContants.FAVORITES_TYPE_4)) {
					// 店铺收藏
					storeDao.increaseFavoriteCount(Long.parseLong(fid));
				} else if (type.equals(UserContants.FAVORITES_TYPE_5)) {
					// 服务收藏
					groupGoodsDao.increaseGoodsCollect(Long.parseLong(fid));
				} else if (type.equals(UserContants.FAVORITES_TYPE_6)) {
					// 收藏商户
					storeDao.increaseFavoriteCount(CommUtil.null2Long(fid));
				}

				return 0;
			}
			return 2;
		}
	}

	public int updateFavorites(Long uid, String fid, String type) {
		UserCustomerFavorites favorites = new UserCustomerFavorites();
		favorites.setUid(uid);
		favorites.setFid(fid);
		favorites.setType(type);
		favorites.setCreateTime(new Date());
		return favoritesDao.updateFavorites(favorites);
	}

	/**
	 * 取消收藏
	 * 
	 * @param uid
	 * @param fid
	 * @return
	 */
	@Transactional(readOnly = false)
	public int cancleGoodsOrStoreFavoritesById(Long id) throws ServiceException {
		UserCustomerFavorites fava = favoritesDao.findById(id);
		if (CommUtil.null2Int(fava.getType()) == 4 || CommUtil.null2Int(fava.getType()) == 6) {
			storeDao.subductionFavoriteCount(CommUtil.null2Long(fava.getFid()));
			favoritesDao.cancleFavorites(id);
			return 0;

		} else if (CommUtil.null2Int(fava.getType()) == 5) {
			groupGoodsDao.subductionGoodsCollect(CommUtil.null2Long(fava.getFid()));
			favoritesDao.cancleFavorites(id);
			return 0;
		} else if (CommUtil.null2Int(fava.getType()) == 3) {
			goodsDao.reduceGoodsCollect(CommUtil.null2Long(fava.getFid()));
			favoritesDao.cancleFavorites(id);
			return 0;
		}
		return 1;
	}

	/**
	 * 取消收藏
	 * 
	 * @param uid
	 * @param fid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public int cancleFavorites(Long uid, String fid, String type) {
		UserCustomerFavorites favorites = favoritesDao.findFavorites(uid, fid, type);
		if (null != favorites) {
			// 删除收藏的帖子id
			if (favoritesDao.cancleFavorites(favorites.getId()) > 0) {
				// 更新帖子收藏用户id
				CircleInvitation invitation = invitationDao.findOne(Long.parseLong(fid));
				if (null != invitation && StringUtils.isNotBlank(invitation.getFavoritesInfo())) {
					String[] idsArr = invitation.getFavoritesInfo().split(",");
					List<String> idsList = new ArrayList<String>();
					idsList.addAll(CollectionUtils.arrayToList(idsArr));
					idsList.remove(String.valueOf(uid));
					String favor = "";
					if (idsList.size() > 0) {
						favor = StringUtils.join(idsList, ",") + ",";
					}
					invitationDao.updateInvitationUnFavo(invitation.getId(), favor);
				}

				// expertsDao.updateExpertsUnFavo(Long.parseLong(fid), favor);

			}
		}
		return 0;
	}

	/**
	 * 取消收藏专家
	 * 
	 * @param uid
	 * @param fid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public int cancleFavoritesExperts(Long uid, String expertsId) {
		UserCustomerFavorites favorites = favoritesDao.findFavorites(uid, expertsId,
				SNSConstants.FAVORITES_TYPE_EXPERTS);
		if (null != favorites) {
			// 删除收藏的帖子id
			if (favoritesDao.cancleFavorites(favorites.getId()) > 0) {
				// 更新专家
				UserExperts experts = expertsDao.queryExpertById(Long.parseLong(expertsId));
				if (null != experts && StringUtils.isNotBlank(experts.getFavorInfo())) {
					String[] idsArr = experts.getFavorInfo().split(",");
					List<String> idsList = new ArrayList<String>();
					idsList.addAll(CollectionUtils.arrayToList(idsArr));
					idsList.remove(String.valueOf(uid));
					String favor = "";
					if (idsList.size() > 0) {
						favor = StringUtils.join(idsList, ",") + ",";
					}
					return expertsDao.updateExpertsUnFavo(Long.parseLong(expertsId), favor);
				}
			}
			return 0;
		}
		return 0;
	}

	public void queryExperts(Long uid, Integer expertType, String type, MyPage<UserExpertsBO> page) {
		List<UserExpertsBO> list = expertsDao.queryUserExperts(uid, expertType, type, page);
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (StringUtils.isNotBlank(list.get(i).getFavorInfo())
						&& list.get(i).getFavorInfo().indexOf(uid.toString()) != -1) {
					list.get(i).setIsFavor(true);
				} else {
					list.get(i).setIsFavor(false);
				}
				if (StringUtils.isNotBlank(list.get(i).getPraiseInfo())
						&& list.get(i).getPraiseInfo().indexOf(uid.toString()) != -1) {
					list.get(i).setIsPraise(true);
				} else {
					list.get(i).setIsPraise(false);
				}
			}
		}
		page.setContent(list);
	}

	/**
	 * 查找会员列表
	 */
	public void queryCustomerPageList(UserCustomerVO vo, String condition, String value,
			MyPage<UserCustomerBO> page) {
		if (StringUtils.isNotBlank(condition) && StringUtils.isNotBlank(value)) {
			if (condition.equals("1")) {
				vo.setLoginName(value);
			}
			if (condition.equals("2")) {
				vo.setEmail(value);
			}
			if (condition.equals("3")) {
				vo.setName(value);
			}
			if (condition.equals("4")) {
				vo.setMyInvitationCode(value);
			}
		}
		List<UserCustomerBO> list = userCustomerDao.queryCustomerPageList(vo, page);
		// 给昵称加邀请码
		for (UserCustomerBO bo : list) {
			if (StringUtils.isNotBlank(bo.getReUserName())
					&& StringUtils.isNotBlank(bo.getReInvitationCode())) {
				if (!bo.getReUserName().contains(bo.getReInvitationCode())) {
					bo.setReUserName(bo.getReUserName() + "(" + bo.getReInvitationCode() + ")");
				}
			}
			if (StringUtils.isNotBlank(bo.getOperatorName())
					&& StringUtils.isNotBlank(bo.getReInvitationCode())) {
				if (!bo.getOperatorName().contains(bo.getReInvitationCode())) {
					bo.setOperatorName(bo.getOperatorName() + "(" + bo.getReInvitationCode() + ")");
				}
			}
		}
		page.setContent(list);
	}

	/**
	 * 查找会员列表
	 */
	public void queryCustomerPageList2(UserCustomerVO vo, String condition, String value,
			MyPage<UserCustomerBO> page) {
		if (StringUtils.isNotBlank(condition) && StringUtils.isNotBlank(value)) {
			if (condition.equals("1")) {
				vo.setLoginName(value);
			}
			if (condition.equals("2")) {
				vo.setEmail(value);
			}
			if (condition.equals("3")) {
				vo.setName(value);
			}
			if (condition.equals("4")) {
				vo.setMyInvitationCode(value);
			}
		}
		List<UserCustomerBO> list = userCustomerDao.queryCustomerPageList2(vo, page);
		// 给昵称加邀请码
		for (UserCustomerBO bo : list) {
			if (StringUtils.isNotBlank(bo.getReUserName())
					&& StringUtils.isNotBlank(bo.getReInvitationCode())) {
				if (!bo.getReUserName().contains(bo.getReInvitationCode())) {
					bo.setReUserName(bo.getReUserName() + "(" + bo.getReInvitationCode() + ")");
				}
			}
			if (StringUtils.isNotBlank(bo.getOperatorName())
					&& StringUtils.isNotBlank(bo.getReInvitationCode())) {
				if (!bo.getOperatorName().contains(bo.getReInvitationCode())) {
					bo.setOperatorName(bo.getOperatorName() + "(" + bo.getReInvitationCode() + ")");
				}
			}
		}
		page.setContent(list);
	}

	/**
	 * 第三方注册
	 * 
	 * @param loginName
	 * @param accountType
	 * @param requestIp
	 * @return
	 */
	public int createThirdUser(String loginName, String accountType, String requestIp) {
		UserAccountBO userAccount = accountService.findByMobile(loginName, accountType);
		if (null != userAccount) {
			UserCustomer customer = userCustomerDao.findById(userAccount.getUid());
			// 用户已存在
			if (null != customer) {
				return -4;
			}
			return createCustomer(userAccount.getUid(), null, null, null, null, null);
		}
		Long uid = userService.createUser(UserContant.USER_TYPE_1, accountType, loginName, "123456",
				requestIp);
		return createCustomer(uid, null, null, null, null, null);
	}

	@Transactional(readOnly = false)
	public void upload(HttpServletRequest request, Long userId) throws IOException {
		// 文件类型
		String imageType = CommUtil.null2String(request.getParameter("image_type"));
		imageType = imageType.equals("") ? DEFAULT_AVATAR_FILE_EXT : imageType;

		// 大头像内容
		String bigAvatarContent = CommUtil.null2String(request.getParameter("big_avatar"));
		String bigAvatarName = userId + "_big";

		// ###中头像内容
		String middleAvatarContent = CommUtil.null2String(request.getParameter("middle_avatar"));
		// ###中头像名称
		String middleAvatarName = CommUtil.null2String(request.getParameter("middle_avatar_name"));

		// $$$小头像内容
		String littleAvatarContent = CommUtil.null2String(request.getParameter("little_avatar"));
		// $$$小头像名称
		String littleAvatarName = CommUtil.null2String(request.getParameter("little_avatar_name"));

		// Accessory photo = accessoryService.;
		// photo.setAddTime(new Date());
		// photo.setWidth(132);
		// photo.setHeight(132);
		// photo.setName(bigAvatarName + imageType);
		// photo.setExt(imageType);
		// photo.setPath(uploadFilePath + "/account");
		// accessoryService.save(photo);

		// @@@保存大头像
		String headImgPath = saveImage(imageType, bigAvatarContent, bigAvatarName);
		updateUserImg(userId, headImgPath);

		// ###保存中头像
		saveImage(imageType, middleAvatarContent, middleAvatarName);
		// $$$保存小头像
		saveImage(imageType, littleAvatarContent, littleAvatarName);

	}

	/**
	 * 保存图片
	 * 
	 * @param filePath
	 *            保存路径
	 * @param imageType
	 *            文件类型(.jpg、.png、.gif)
	 * @param avatarContent
	 *            文件内容
	 * @param avatarName
	 *            文件名称(不包括扩展名)
	 * @throws IOException
	 */
	private String saveImage(String imageType, String avatarContent, String avatarName) throws IOException {
		if (!"".equals(avatarContent)) {
			if ("".equals(avatarName))
				avatarName = UUID.randomUUID().toString() + DEFAULT_AVATAR_FILE_EXT;
			else
				avatarName = avatarName + imageType;
			Base64 _decoder = new Base64();
			byte[] data = _decoder.decode(avatarContent);

			String fileUrl = null;
			try {
				fileUrl = FileUploadTools.fileUpload(data, UploadConstants.EDITOR);
			} catch (Exception e) {
				e.printStackTrace();
			}

//			RequestResult res = fsClient.upload(data, avatarName,
//					"image/" + FilenameUtils.getExtension(avatarName));
//			System.out.println(res.getFid());
			// File f = new File(res.getFileName());
			// DataOutputStream dos = new DataOutputStream(new
			// FileOutputStream(f));
			// dos.write(data);
			// dos.flush();
			// dos.close();

			return fileUrl;
		}
		return "";
	}

	/**
	 * 根据uid来查询用户信息
	 * 
	 * @param uid
	 * @return
	 */
	public UserCustomer findById(Long uid) {
		UserCustomer userCustomer = this.userCustomerDao.findById(uid);
		if (userCustomer != null) {
			if (StringUtils.isBlank(userCustomer.getMobile())) {
				UserAccount userAccount = userAccountService.findUserAccount(uid, UserContant.ACCOUNT_TYPE_2);
				if (userAccount != null) {
					userCustomer.setMobile(userAccount.getLoginName());
				}
			}
		}
		return userCustomer;
	}

	/**
	 * 更新用户信息及地址
	 * 
	 * @param vo
	 * @param id
	 *            user_address.id
	 * @param areaInfo
	 *            收货人详细地址
	 * @param areaId
	 *            地区id
	 * @param userId
	 *            用户id
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false)
	public void updateUserCustomerAndAddress(UserCustomerVO vo, Long id, String areaInfo, Long areaId,
			Long userId) throws ServiceException {
		updateUser(vo);
		addressService.save(id, areaInfo, areaId, userId);
	}

	/**
	 * 修改支付密码
	 * 
	 * @param mobile
	 * @param code
	 * @param password
	 */
	@Transactional(readOnly = false)
	public int updatePaymentPassword(Long uid, String mobile, String code, String password) {
		// UserAccount account = accountService.findByMobile(mobile,
		// UserContant.ACCOUNT_TYPE_2);
		UserAccountBO account = accountService.findByLoginName(mobile);
		// 用户不存在
		if (account == null) {
			return 200;
		}
		// 用户异常
		if (!uid.equals(account.getUid())) {
			return 300;
		}
		// 验证码错误
		String verify = redisCacheService.getSmsCode(account.getUid(), mobile);
		if (!verify.equals(code)) {
			return 400;
		}
		moneyServer.updatePassword(account.getUid(), password);
		return 100;
	}

	/**
	 * 根据角色标识修改支付密码
	 * 
	 * @param mobile
	 * @param code
	 * @param password
	 */
	@Transactional(readOnly = false)
	public int updatePaymentPassword(Long uid, String mobile, String code, String password, String source) {
		// UserAccount account = accountService.findByMobile(mobile,
		// UserContant.ACCOUNT_TYPE_2);
		UserAccountBO account = accountService.findByLoginName(mobile);
		// 用户不存在
		if (account == null) {
			return 200;
		}
		// 用户异常
		if (!uid.equals(account.getUid())) {
			return 300;
		}
		// 验证码错误
		String verify = redisCacheService.getSmsCode(account.getUid(), mobile);
		if (!verify.equals(code)) {
			return 400;
		}
		moneyServer.updatePassword(account.getUid(), password, source);
		return 100;
	}

	public UserCustomerFavorites queryCustomerFavorites(Long uid, String fid, String type) {
		return favoritesDao.findFavoritesByFid(uid, fid, type);
	}

	public void queryStoreCustomer(Long sellerUid, String mobile, MyPage<UserCustomerBO> page) {
		userCustomerDao.queryStoreCustomer(sellerUid, mobile, page);
	}

	/**
	 * 查询店铺收藏数量 by young
	 * 
	 * @param storeId
	 * @param favoriteType
	 *            收藏类型
	 * @return
	 */
	public int countStoreFavorite(Long storeId, int favoriteType) {
		return favoritesDao.countStoreFavorite(storeId, favoriteType);
	}

	public void queryUserCustomerByOperatorUserId(UserCustomerVO vo, MyPage<UserCustomerBO> page) {
		page.setContent(userCustomerDao.queryUserCustomerByOperatorUserId(vo, page));
	}

	/**
	 * 营运商修改云豆密码
	 * 
	 * @param mobile
	 * @param code
	 * @param password
	 */
	@Transactional(readOnly = false)
	public int updateOperaterPaymentPassword(Long uid, String mobile, String code, String password) {
		// 验证码错误
		String verify = redisCacheService.getSmsCode(uid, mobile);
		if (StringUtils.isBlank(verify) || !verify.equals(code)) {
			return 400;
		}
		moneyServer.updatePassword(uid, password);
		return 100;
	}

	public Map<String, Integer> queryUserStatistics() {
		Map<String, Integer> map = new HashMap<>();
		map.put("unknown", 0);
		map.put("male", 0);
		map.put("female", 0);
		map.put("secret", 0);
		List<UserCustomerBO> users = userCustomerDao.queryUserStatistics();
		for (UserCustomerBO bo : users) {
			if (bo.getSex() == null)
				map.put("unknown", bo.getNum());
			else if (bo.getSex() == 1)
				map.put("male", bo.getNum());
			else if (bo.getSex() == 2)
				map.put("female", bo.getNum());
			else if (bo.getSex() == -1)
				map.put("secret", bo.getNum());
		}
		return map;
	}

	public UserCustomerBO findBOByUserId(Long id) {
		UserCustomerBO bo = userCustomerDao.findBOByUserId(id);
		if (bo != null && null != bo.getRefreeUserId()) {
			UserBO userBo = userService.findById(bo.getRefreeUserId());
			if (userBo != null) {
				if (UserContant.USER_TYPE_1.equals(userBo.getUserType())) {
					// UserCustomer reBo = userCustomerDao.findSessionUser(id);
					UserCustomer reBo = this.userCustomerDao.findOneByUserId(id);
					if (reBo != null) {
						bo.setReUserName(reBo.getNickname());
						bo.setReMobile(reBo.getMobile());
					}
				}
				if (UserContant.USER_TYPE_4.equals(userBo.getUserType())) {
					OperatorBO reBo = operatorDao.getOperatorBOByUserId(id);
					if (reBo != null) {
						bo.setReUserName(reBo.getOperatorName());
						bo.setReMobile(reBo.getPhone());
					}
				}
			}
		}
		return bo;
	}

	public void queryRelationList(Long uid, MyPage<UserCustomerBO> page) {
		List<UserCustomerBO> list = userCustomerDao.queryRelationList(uid, page);
		page.setContent(list);
	}

	public void queryUserByRelation1(Long relationId, MyPage<UserCustomerBO> page) {
		List<UserCustomerBO> list = userCustomerDao.queryUserByRelation1(relationId, page);
		for (UserCustomerBO obj : list) {
			if (obj.getHeadImgPath() == null || obj.getHeadImgPath().trim().length() == 0) {
				obj.setHeadImgPath("-");
			}
			obj.setRegisterTime(obj.getCreateTime());
		}
		page.setContent(list);
	}

	public void queryUserByRelation2(Long relationId, MyPage<UserCustomerBO> page) {
		List<UserCustomerBO> list = userCustomerDao.queryUserByRelation2(relationId, page);
		for (UserCustomerBO obj : list) {
			if (obj.getHeadImgPath() == null || obj.getHeadImgPath().trim().length() == 0) {
				obj.setHeadImgPath("-");
			}
			obj.setRegisterTime(obj.getCreateTime());
		}
		page.setContent(list);
	}

	public void queryUserByRelation3(Long relationId, MyPage<UserCustomerBO> page) {
		List<UserCustomerBO> list = userCustomerDao.queryUserByRelation3(relationId, page);
		for (UserCustomerBO obj : list) {
			if (obj.getHeadImgPath() == null || obj.getHeadImgPath().trim().length() == 0) {
				obj.setHeadImgPath("-");
			}
			obj.setRegisterTime(obj.getCreateTime());
		}
		page.setContent(list);
	}

	public int queryUserByRelation1Count(Long relationId, String startTime, String endTime) {
		int result = userCustomerDao.queryUserByRelation1Count(relationId, startTime, endTime);
		return result;
	}

	public int queryUserByRelation2Count(Long relationId, String startTime, String endTime) {
		int result = userCustomerDao.queryUserByRelation2Count(relationId, startTime, endTime);
		return result;
	}

	public int queryUserByRelation3Count(Long relationId, String startTime, String endTime) {
		int result = userCustomerDao.queryUserByRelation3Count(relationId, startTime, endTime);
		return result;
	}

	/**
	 * 创建CN个人用户方法
	 * 
	 * @param uid
	 * @param mobile
	 * @return
	 */
	public int createCNCustomer(Long uid, String mobile, String nicName, String name, String email,
			Integer sex, Long refereeUserId) {
		SysConfigBO config = this.configService.getSysConfig();
		// 创建用户默认相册
		Album album = new Album();
		album.setAlbumDefault(true);
		album.setAlbumName("默认相册");
		album.setAlbumSequence(-10000);
		this.albumService.albumSave(uid, album);

		// 添加买家权限
		List<RoleBO> roles = this.userService.findRoleByType(UserContant.ROLE_TYPE_BUYER);
		List<Long> rids = new ArrayList<Long>();
		for (RoleBO roleBO : roles) {
			rids.add(roleBO.getId());
		}
		this.userService.saveUserRole(uid, UserContant.ROLE_TYPE_BUYER, rids.toArray(new Long[rids.size()]));
		moneyServer.isExistAndCreate(uid);
		/*UserMoney money = new UserMoney();
		money.setAvailableBalance(new BigDecimal(0));
		money.setUid(uid);
		this.moneyDao.create(money);*/

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
		if (config.getMemberIcon() != null) {
			customer.setHeadImgPath(config.getMemberIcon().getPath());
		}

		int result = userCustomerDao.insert(customer);
		// 添加积分
		// integralService.addIntegral(IntegralConstants.INTEGRAL_REGISTER, uid, uid);
		// 推荐人也赠送积分
		// if (refereeUserId != null && refereeUserId>0)
		// integralService.addIntegral(IntegralConstants.INTEGRAL_REGISTER_INVITATION, refereeUserId, uid);

		return result;
	}

	public int updateByPrimaryKeySelective(UserCustomer record) {
		return this.userCustomerDao.updateByPrimaryKeySelective(record);
	}

	/**
	 * 绑定手机号码
	 * 
	 * @param uid
	 * @param mobile
	 * @param password
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public UserAccount updateMobileByUIDAndPassWord(Long uid, String mobile, String password) {
		UserAccount wxUserAccount = this.userAccountDao.findByUid(uid, UserContant.ACCOUNT_TYPE_4);
		UserAccountBO phoneUserAccountBO = accountService.findByMobile(mobile, UserContant.ACCOUNT_TYPE_2);
		String entryptPassword = PasswordUtils.entryptPassword(password);

		UserAccount resultAccount = null;
		// 如果当前手机号存在，合并帐号时，
		// 把当前手机在系统里对应的uid修改成微信帐号对应的uid，其它数据不管
		if (phoneUserAccountBO != null && phoneUserAccountBO.getId() != 0L) {
			/*UserAccount update_WXUserAccount = new UserAccount();
			update_WXUserAccount.setId(wxUserAccountID);
			update_WXUserAccount.setPassword(entryptPassword);
			this.userAccountDao.updatePwdByID(update_WXUserAccount);*/
			/*
			 * 把当前手机在系统里对应的uid修改成微信帐号对应的uid
			 */
			Long ouid = phoneUserAccountBO.getUid();
			UserAccountBO update_Phone_UserAccountBo = new UserAccountBO();
			update_Phone_UserAccountBo.setUid(wxUserAccount.getUid()); // 微信用户uid
			update_Phone_UserAccountBo.setPassword(entryptPassword);
			update_Phone_UserAccountBo.setSellerPassword(entryptPassword);
			update_Phone_UserAccountBo.setSupplierPassword(entryptPassword);
			update_Phone_UserAccountBo.setOperatorPassword(entryptPassword);
			this.userAccountDao.updatePassWordAndUIDByOuid(update_Phone_UserAccountBo, ouid);
			/**
			 * 绑定记录
			 */
			BindingHistory record = new BindingHistory();
			record.setNewUid(wxUserAccount.getUid());
			record.setOldUid(ouid);
			userRelationService.historyBoundRelation(record);
			/*
			 * 同时如果当前手机存在并且手机对应的帐号是cn帐号，清除微信的上层推进关系
			 */
			UserAccountBO cnUserAccount = new UserAccountBO();
			cnUserAccount.setAccountType(UserContant.ACCOUNT_TYPE_8);
			cnUserAccount.setUid(phoneUserAccountBO.getUid());
			UserAccountBO cnUserAccountResult = userAccountDao.findAccountByVo(cnUserAccount);
			if (cnUserAccountResult != null && cnUserAccountResult.getId() != 0l) {
				userRelationService.relieveRelationByUid(wxUserAccount.getUid());
			}
			resultAccount = new UserAccount();
			resultAccount.setLoginName(wxUserAccount.getLoginName());
			resultAccount.setPassword(wxUserAccount.getPassword());
		} else // 如果手机号不是平台用户
		{
			// 创建以绑定手机号为登陆名的用户且对应的UID为微信授权登录账户的UID
			UserAccount phoneUserAccount = new UserAccount();
			phoneUserAccount.setUid(wxUserAccount.getUid());
			phoneUserAccount.setLoginName(mobile);
			phoneUserAccount.setPassword(entryptPassword);
			phoneUserAccount.setSellerPassword(entryptPassword);
			phoneUserAccount.setSupplierPassword(entryptPassword);
			phoneUserAccount.setOperatorPassword(entryptPassword);
			phoneUserAccount.setAccountType(UserContant.ACCOUNT_TYPE_2);
			phoneUserAccount.setIsDeleted(false);
			this.userAccountDao.save(phoneUserAccount);

			// 更新微信授权登录账户登陆密码为绑定手机号时输入的密码
			/*UserAccount update_WXUserAccount = new UserAccount();
			update_WXUserAccount.setId(wxUserAccountID);
			update_WXUserAccount.setUid(wxUserAccount.getUid());
			update_WXUserAccount.setPassword(entryptPassword);
			this.userAccountDao.updateByUid(update_WXUserAccount);*/
			//
			this.userCustomerDao.updateMobileByUID(wxUserAccount.getUid(), mobile);

			resultAccount = new UserAccount();
			resultAccount.setLoginName(wxUserAccount.getLoginName());
			resultAccount.setPassword(wxUserAccount.getPassword());
		}
		return resultAccount;
	}

	/**
	 * 创建个人用户方法(用于微信网页授权)
	 * 
	 * @param uid
	 *            用户ID
	 * @param mobile
	 *            手机号码
	 * @param nicName
	 *            昵称
	 * @param name
	 *            名称
	 * @param email
	 *            电子邮件
	 * @param sex
	 *            性别
	 * @param refereeUserId
	 *            推荐用户ID
	 * @param headImgPath
	 *            头像
	 * @return
	 */
	public int createCustomer(Long uid, String mobile, String nicName, String name, String email,
			Integer sex, Long refereeUserId, String headImgPath) {
		// 创建用户默认相册
		Album album = new Album();
		album.setAlbumDefault(true);
		album.setAlbumName("默认相册");
		album.setAlbumSequence(-10000);
		this.albumService.albumSave(uid, album);
		// 添加买家权限
		List<RoleBO> roles = this.userService.findRoleByType(UserContant.ROLE_TYPE_BUYER);
		List<Long> rids = new ArrayList<Long>();
		for (RoleBO roleBO : roles) {
			rids.add(roleBO.getId());
		}
		this.userService.saveUserRole(uid, UserContant.ROLE_TYPE_BUYER, rids.toArray(new Long[rids.size()]));

		UserMoney money = new UserMoney();
		money.setAvailableBalance(new BigDecimal(0));
		money.setUid(uid);
		this.moneyDao.create(money);

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
		customer.setHeadImgPath(headImgPath);

		int result = userCustomerDao.insert(customer);
		// 添加积分
		integralService.addIntegral(IntegralConstants.INTEGRAL_REGISTER, uid, uid);
		// 推荐人也赠送积分
		if (refereeUserId != null && refereeUserId > 0) {
			integralService.addIntegral(IntegralConstants.INTEGRAL_INVITE_FRIENDS, refereeUserId, uid);
		}
		return result;
	}

	/**
	 * 微信网页授权登陆后，绑定手机号判断
	 * 
	 * @param unionId
	 *            微信unionid
	 * @return true:已绑定 false:未绑定
	 */
	public boolean query_CheckWeChatBoundPhone(String unionId) {
		boolean isBinding = false; // true:已绑定 false:未绑定
		int accountType = Integer.valueOf(UserContant.ACCOUNT_TYPE_4);
		String openid = unionId; // 微信使用unionId
		UserAccountBO account = null;
		// 根据当前微信的unionid获取用户信息
		account = this.userAccountDao.queryAccountByOpenId(openid, accountType);
		if (account != null) {
			// 获取用户ID
			long uid = account.getUid();
			UserAccountBO bo = new UserAccountBO();
			bo.setUid(uid);
			bo.setAccountType(UserContant.ACCOUNT_TYPE_2);
			account = accountService.findAccountByVo(bo);
			if (account != null) {
				isBinding = true; // 已绑定手机
			}
		}
		return isBinding;
	}

	/**
	 * Cn账号绑定微信
	 * 
	 * @param mobile
	 * @param unionID
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int cnBindingWx(String mobile, String unionID) {
		UserAccountBO userAccountBO = accountService.findByLoginName(unionID);// 微信
		UserAccountBO userAccountMobile = accountService.findByLoginName(mobile);// 手机号
		if (userAccountMobile == null) {
			return 500;// 该手机号未注册过
		}

		UserAccountBO account1 = new UserAccountBO();
		account1.setUid(userAccountMobile.getUid());
		account1.setAccountType(UserContant.ACCOUNT_TYPE_4);
		UserAccountBO userAccountBO1 = accountService.findAccountByVo(account1);
		if (userAccountBO1 != null && userAccountBO1.getId() != null) {
			log.info(mobile + "该手机号已绑定过微信号");
			return 600;// 该手机号已绑定过微信
		}

		if (userAccountBO == null) {// 该微信未注册
			UserAccount account = new UserAccount();
			account.setPassword(PasswordUtils.entryptPassword(unionID));
			account.setLoginName(unionID);
			account.setAccountType(UserContant.ACCOUNT_TYPE_4);
			account.setIsDeleted(false);
			account.setUid(userAccountMobile.getUid());
			accountDao.insert(account);
		} else {// 该微信已注册过，且未绑定手机号
			UserAccountBO account = new UserAccountBO();
			account.setUid(userAccountBO.getUid());
			account.setAccountType(UserContant.ACCOUNT_TYPE_2);
			UserAccountBO userAccountBO_ = accountService.findAccountByVo(account);
			if (userAccountBO_ != null && userAccountBO_.getId() != null) {// 该微信已绑定过手机号
				return 501;
			} else {
				// 查询CN账户的运营商
				UserAccountBO cnaccount = new UserAccountBO();
				cnaccount.setUid(userAccountMobile.getUid());
				Long newUid = userAccountBO.getUid();// 微信uid为主
				Long oldUid = userAccountMobile.getUid();// cn账号uid

//				cnaccount.setAccountType(UserContant.ACCOUNT_TYPE_8);
//				UserAccountBO cnuserAccountBO = accountService.findAccountByVo(cnaccount);
//				UserAccountBO bo = userAccountDao.selectAcocountOperatorByCnUserAlias(cnuserAccountBO
//						.getLoginName());
				this.changeUidRelated(oldUid, newUid, mobile);
			}
		}
		return 100;
	}

	/**
	 * 手机绑定微信号
	 * 
	 * @param mobile
	 *            :手机号码
	 * @param unionid
	 *            :微信unionid
	 * @return 404：当前手机用户不存在平台系统中 406：当前手机用户已绑定过微信号 409：当前微信已绑定过手机号 200：绑定成功
	 */
	public int mobileBindingWeChat(String mobile, String unionid) {
		log.info("============ mobile binding WeChat ============== ");
		log.info("<<<<<<<< params mobile->" + mobile + " unionid->" + unionid);
		UserAccountBO mobile_UserAccount = this.userAccountDao.fetchByLoginName(mobile); // 手机用户
		UserAccountBO weChat_UserAccount = accountService.findByLoginName(unionid); // 微信用户
		// 1.当前手机用户是否存在于系统中
		if (mobile_UserAccount != null && mobile_UserAccount.getId() != 0l) {
			// 2.当前手机用户是否已经绑定过微信号
			long mobileUID = mobile_UserAccount.getUid();
			UserAccountBO account1 = new UserAccountBO();
			account1.setUid(mobileUID);
			account1.setAccountType(UserContant.ACCOUNT_TYPE_4);
			UserAccountBO weChatUA = accountService.findAccountByVo(account1);
			if (weChatUA == null) // 当前手机号未绑定过微信
			{
				// 3.当前微信号是否存在于系统平台中
				if (weChat_UserAccount != null && weChat_UserAccount.getId() != null) // 当前微信号已存在平台中
				{
					// 4.当前微信号是否已绑定过手机号
					long weChatUID = weChat_UserAccount.getUid();
					UserAccountBO account2 = new UserAccountBO();
					account2.setUid(weChatUID);
					account2.setAccountType(UserContant.ACCOUNT_TYPE_2);
					UserAccountBO mobileUA = accountService.findAccountByVo(account2);
					if (mobileUA == null) // 微信未绑定手机号
					{
						UserCustomerBO mobileUA00 = userCustomerDao.findBOByUserId(mobileUID);
						UserCustomerBO weChatUA00 = userCustomerDao.findBOByUserId(weChatUID);
						weChatUA00.setMobile(mobileUA00.getMobile());
						mobileUA00.setMobile(null);
						this.userCustomerDao.updateById(mobileUA00);
						this.userCustomerDao.updateById(weChatUA00);
						// 账号绑定历史记录
						BindingHistory history = new BindingHistory();// uid记录
						history.setNewUid(weChatUID);
						history.setOldUid(mobileUID);
						this.bindingHistoryDao.save(history);
						// 更改当前登录账号的UID修改为微信登录账户的UID
						UserAccount savAccount = new UserAccount();
						savAccount = mobile_UserAccount;
						savAccount.setUid(weChatUID);
						this.userAccountDao.update(savAccount);

					} else // 微信已绑定手机号
					{
						log.info("=============== weChatUser Bound mobile ===============");
						return 409;
					}
				} else // 当前微信号非平台用户
				{
					// 为当前手机用户创建微信账号，手机账号和微信账号的UID为同一个
					UserAccount account = new UserAccount();
					account.setPassword(PasswordUtils.entryptPassword(unionid));
					account.setLoginName(unionid);
					account.setAccountType(UserContant.ACCOUNT_TYPE_4);
					account.setIsDeleted(false);
					account.setUid(mobileUID);
					accountDao.insert(account);
				}
			} else // 当前手机号已绑定过微信
			{
				log.info("=============== mobileUser Bound WeChat ===============");
				return 406;
			}
		} else {
			log.info("=============== mobileUser Non-existent ===============");
			return 404; // 当前手机用户不存在平台系统中
		}
		log.info("============ binding  succ ============= ");
		return 200;
	}

	/**
	 * 获取一级用户信息UID
	 * 
	 * @param relationId
	 * @return
	 */
	/*public List<Long> queryUserByRelation1(Long relationId)
	{
		List<UserCustomerBO> list = userCustomerDao.queryUserByRelation1(relationId, null);
		List<Long> resultList = new ArrayList<Long>();
		for(UserCustomerBO userCustomer:list)
		{
			long uid = userCustomer.getUid();
			resultList.add(uid);
		}
		return resultList;
	}*/
	/**
	 * 获取二级用户信息UID
	 * 
	 * @param relationId
	 * @return
	 */
	/*public List<Long> queryUserByRelation2(Long relationId)
	{
		List<UserCustomerBO> list = userCustomerDao.queryUserByRelation2(relationId, null);
		List<Long> resultList = new ArrayList<Long>();
		for(UserCustomerBO userCustomer:list)
		{
			long uid = userCustomer.getUid();
			resultList.add(uid);
		}
		return resultList;
	}*/
	/**
	 * 获取二级用户信息UID
	 * 
	 * @param relationId
	 * @return
	 */
	/*public List<Long> queryUserByRelation3(Long relationId)
	{
		List<UserCustomerBO> list = userCustomerDao.queryUserByRelation3(relationId, null);
		List<Long> resultList = new ArrayList<Long>();
		for(UserCustomerBO userCustomer:list)
		{
			long uid = userCustomer.getUid();
			resultList.add(uid);
		}
		return resultList;
	}*/

	public List<Long> queryUserByRelation(List<Long> relationIDList) {
		List<UserCustomerBO> list = userCustomerDao.queryUserByRelationByIn_RefereeUserId(relationIDList);
		List<Long> resultList = new ArrayList<Long>();
		for (UserCustomerBO userCustomer : list) {
			long uid = userCustomer.getUid();
			resultList.add(uid);
		}
		return resultList;
	}

	/**
	 * 判断用户是否为供应商
	 * 
	 * @param storeId
	 * @return
	 */
	public boolean checkUserAccoutIsShop(Long storeId) {
		storeId = storeId != null ? storeId : 0L;
		StoreBO store = this.storeDao.getStoreStatus(storeId);
		if (store != null) {
			Boolean boo_UserShop = store.getIsShop();
			if (boo_UserShop) {
				logger.debug("=====UserAccount is Supplier");
				return Boolean.TRUE;
			} else {
				logger.debug("=====UserAccount is not Supplier");
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
	public boolean checkUserAccoutIsO2O(Long storeId) {
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

	public List<UserAccount> queryUserAccountByUID(Long uid) {
		uid = uid != null ? uid : 0L;
		List<UserAccount> list = this.userAccountDao.findByUid(uid);
		logger.debug("User Account Size = " + (list != null ? list.size() : 0));
		return list;
	}

	public UserAccount queryUserAccountByUidAndUserType(Long uid, String userAccountType) {
		return this.userAccountDao.findByUid(uid, userAccountType);
	}

	/**
	 * 获取用户信息（登录名+uid）
	 * 
	 * @param loginName
	 * @param uid
	 * @return
	 */
	public UserAccount queryUserAccountByLoginNameAndUid(String loginName, Long uid) {
		return this.userAccountDao.findByLoginNameAndUid(loginName, uid);
	}

	/**
	 * 登陆后用户类型判断
	 * 
	 * @param loginName
	 *            登录名
	 * @param uid
	 *            UID
	 * @param storeId
	 *            店铺ID
	 * @return
	 */
	public UserAccoutStateEnum queryLoggerinCheck(String loginName, Long uid, Long storeId) {
		// 1.是否使用CN账号登陆供应商(商户)
		// CN老用户已成为运营商和商户的不能使用CN账号登陆
		boolean boo_CN_User = loginName.toUpperCase().trim().startsWith(Globals.ACCOUNT_TYPE_CN);
		if (boo_CN_User) {
			return UserAccoutStateEnum.CNACCOUT;
		}

		// 是否为供应商
		boolean supplierBoo = this.checkUserAccoutIsShop(storeId);
		// 是否为商户
		boolean merchantBoo = this.checkUserAccoutIsO2O(storeId);

		// 2.使用手机号或第三方登陆
		// 检查当前用户是否为CN用户,CN用户不能登录供应商和商户
		// 新版本后CN用户不能申请入驻供应商和商户
		// 老版本中CN用户已成为供应商或商户的不能使用CN账号登陆进行登陆操作
		UserAccount userAccount = this.queryUserAccountByLoginNameAndUid(loginName, uid);
		String accountType = userAccount.getAccountType().trim();
		boolean hasCN = accountType.equals(UserContant.ACCOUNT_TYPE_8);
		boolean hasPhone = accountType.equals(UserContant.ACCOUNT_TYPE_2);
		boolean hasWeChat = accountType.equals(UserContant.ACCOUNT_TYPE_4);
		logger.debug("======= isCN = " + hasCN + "-> isPhone = " + hasPhone + "-> isWeChat = " + hasWeChat);
		if (hasCN) // 用户以CN角色登录
		{
			logger.debug(">>>>>>>>> CN UserAccount Login Start");
			/* 处理老数据：已成为供应商或商户的老CN用户*/
			// String loginNameTemp = userAccount.getLoginName().trim().toUpperCase();
			// boolean cnLoginName = (loginNameTemp.startsWith(Globals.ACCOUNT_TYPE_CN));
			if (supplierBoo) // 已是供应商 +使用非CN账号登录
			{
				return UserAccoutStateEnum.ISSUPPLIER;
			} else if (merchantBoo) // 已是商户+使用非CN账号登录
			{
				return UserAccoutStateEnum.ISMERCHANT;
			}
			return UserAccoutStateEnum.CNACCOUT;
		} else if (hasPhone) // 手机号登录
		{
			logger.debug(">>>>>>>>> Phone UserAccount Login Start");
			/* 手机号登录（非CN绑定），是供应商和商户则进入供应商后台 */
			// 已成为商户或供应商的CN老用户可以使用手机号进行登录操作
			// 如果老用户的CN账号已被后台手动修改成绑定手机的号码，则可以进行登陆
			// 如果没被修改成手机号，则不能进行登录
			UserAccount cnUserAccount = this
					.queryUserAccountByUidAndUserType(uid, UserContant.ACCOUNT_TYPE_8);
			boolean isCNTemp = (cnUserAccount != null ? true : false);
			String loginNameTemp = (isCNTemp ? cnUserAccount.getLoginName() : "");
			boolean cnLoginName = (loginNameTemp.trim().toUpperCase().startsWith(Globals.ACCOUNT_TYPE_CN));
			return this.checkUserAccountState(isCNTemp, cnLoginName, supplierBoo, merchantBoo);
		} else if (hasWeChat) // 第三方登陆：微信
		{
			logger.debug(">>>>>>>>> WeChat UserAccount Login Start");
			UserAccount cnUserAccount = this
					.queryUserAccountByUidAndUserType(uid, UserContant.ACCOUNT_TYPE_8);
			boolean isCNTemp = (cnUserAccount != null ? true : false);
			String loginNameTemp = (cnUserAccount.getLoginName() != null ? cnUserAccount.getLoginName() : "");
			boolean cnLoginName = (loginNameTemp.trim().toUpperCase().startsWith(Globals.ACCOUNT_TYPE_CN));
			// 微信登录（已CN绑定的老数据）
			if (isCNTemp) {
				return this.checkUserAccountState(isCNTemp, cnLoginName, supplierBoo, merchantBoo);
			}
			// 微信登录（非CN绑定）
			else {
				/**
				 * 绑定了手机，是供应商则进入后台 1.绑定了手机，是供应商和商户则进入后台 2.绑定了手机，不是供应商和商户则填写入驻信息 3.没有绑手机，绑定手机，重复1和2步骤
				 */
				UserAccount phoneUserAccount = this.queryUserAccountByUidAndUserType(uid,
						UserContant.ACCOUNT_TYPE_2);
				boolean isPhoneTemp = (phoneUserAccount != null);
				if (isPhoneTemp) // 绑定
				{
					if (supplierBoo) {
						return UserAccoutStateEnum.ISSUPPLIER;
					} else if (merchantBoo) {
						return UserAccoutStateEnum.ISMERCHANT;
					} else {
						return UserAccoutStateEnum.NOT_SUPPLIER_OR_MERCHANT;
					}
				} else {
					return UserAccoutStateEnum.NOTBINGPHONE;
				}
			}
		}
		return UserAccoutStateEnum.NOT_SUPPLIER_OR_MERCHANT; // 不是供应商（商户）
	}

	/**
	 * 用户类型枚举类
	 */
	public enum UserAccoutStateEnum {
		/**
		 * CN账号
		 */
		CNACCOUT(),
		/**
		 * 手机账号(未绑定CN)
		 */
		MOBILE(),
		/**
		 * 非供应商(商户)
		 */
		NOT_SUPPLIER_OR_MERCHANT(),
		/**
		 * 供应商
		 */
		ISSUPPLIER(),
		/**
		 * 商户
		 */
		ISMERCHANT(),
		/**
		 * 未绑定手机
		 */
		NOTBINGPHONE();
		UserAccoutStateEnum() {
		}
	}

	private UserAccoutStateEnum checkUserAccountState(boolean isCNTemp, boolean cnLoginName,
			boolean supplierBoo, boolean merchantBoo) {
		if (isCNTemp && cnLoginName) {
			return UserAccoutStateEnum.CNACCOUT;
		} else if (isCNTemp && !cnLoginName && supplierBoo) // 老数据：是CN用户 && CN账号已被修改成手机号码 && 是供应商
		{
			return UserAccoutStateEnum.ISSUPPLIER;
		} else if (isCNTemp && !cnLoginName && merchantBoo) // 老数据：是CN用户 && CN账号已被修改成手机号码 && 是商户
		{
			return UserAccoutStateEnum.ISMERCHANT;
		} else if (!isCNTemp && supplierBoo) // 新数据：非绑定CN 且 是供应商
		{
			return UserAccoutStateEnum.ISSUPPLIER;
		} else if (!isCNTemp && merchantBoo) // 新数据：非绑定CN 且 是商户
		{
			return UserAccoutStateEnum.ISMERCHANT;
		} else // 不是供应商和商户
		{
			return UserAccoutStateEnum.NOT_SUPPLIER_OR_MERCHANT;
		}
	}

	/**
	 * cn账户绑定手机号,判断该手机号是否是平台用户，为平台用户时，合并cn账户与手机号账户，以手机号账户为准
	 * 
	 * @param account
	 * @param cnUid
	 * @param mobile
	 * @return
	 */
	@Transactional(readOnly = false)
	public int cnBindMobile(UserAccountBO account, Long cnUid, String mobile, String cn_username,
			String password) {
		if (cnUid == null) {
			return 400;
		}
		password = "yunshang123456";// CN账户绑定手机号，默认手机号密码
		if (account == null) {// 手机号账户为空
			UserCustomerBO usercunstomer = userCustomerDao.searchCustomerBO(cnUid);// 更新CN账户的手机号
			if (usercunstomer == null) {
				return 400;
			}
			UserAccount account_ = new UserAccount();
			account_.setLoginName(mobile);
			account_.setAccountType(UserContant.ACCOUNT_TYPE_2);
			account_.setIsDeleted(false);
			account_.setUid(cnUid);
			account_.setPassword(PasswordUtils.entryptPassword(password));
			this.userAccountDao.save(account_);
			usercunstomer.setMobile(mobile);
			userCustomerDao.updateByPrimaryKeySelective(usercunstomer);
			return 100;
		} else {// 当该手机号已经为平台用户:将手机账号与cn账户合并，以手机账号为主
			UserAccountBO userbo = new UserAccountBO();
			userbo.setAccountType(UserContant.ACCOUNT_TYPE_8);
			userbo.setUid(cnUid);
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
			// OperatorBO
			// operatorBO=operatorDao.getOperatorBOByOperatorCode(cn_username);
			UserAccountBO bo = userAccountDao.selectAcocountOperatorByCnUserAlias(cn_username);
			if (cnaccountBO != null && account.getUid().longValue() != cnUid.longValue() && f) {
				if (StringUtils.isEmpty(bo.getUserID())) {// CN号为新账户
					cnaccountBO.setUid(account.getUid());
					Map<String, String> map = new HashMap<String, String>();
					map.put("combine", "YES");// CN标识合并
					map.put("cn_username", cn_username);
					String extend = Json.toJson(map, JsonFormat.compact());
					usercunstomer.setExtend(extend);
					userAccountDao.update(cnaccountBO);// 将cn账户uid替换成手机账户uid
					userCustomerDao.updateByPrimaryKeySelective(usercunstomer);
					userCustomerDao.deleteById(cnUid);// 删除刚初始化的CN账户
					User user = userService.getObjById(account.getUid());
					user.setUserType(UserContant.USER_TYPE_4);
					userService.update(user);
					return 200;
				} else {
					Long newUid = account.getUid();
					UserAccount wxAccount = userAccountService.findByUid(newUid, UserContant.ACCOUNT_TYPE_4);
					if (null != wxAccount) {// 手机号已经绑定了微信号
						this.changeUidRelated(cnUid, newUid, mobile);
						return 200;
					}
					// 手机号没绑微信号
					// 该cn账号存在运营商，以运营商uid为主,将手机号uid变为运营商uid
					Long muid = account.getUid();
					// account.setUid(uid);
					// userAccountDao.update(account);
					UpdateWxVO accountup = new UpdateWxVO();
					// accountup.setId(userAccountMobile.getId());
					accountup.setNewUid(cnUid);
					accountup.setOldUid(muid);
					userAccountDao.updateWx(accountup);
					// 保存记录
					BindingHistory record = new BindingHistory();
					record.setOldUid(muid);
					record.setNewUid(cnUid);
					bindingHistoryDao.save(record);
					return 200;
				}
			}
			return 300;
		}
	}

	/**
	 * 账号uid变更相关功能 1.uid变更相关 2.手机号变更 3.云豆合并 4.关系合并 5.保存日志 如果是CN账号 另外执行 1.解除上级关系 2.账户类型修改为运营商 3.运营商表uid表更为新uid
	 * 2017/3/14 手机号绑微信,微信绑已完善资料的CN账号 以前以CN uid为主,现在以微信uid为主
	 * 
	 * @param oldUid
	 * @param newUid
	 * @param mobile
	 *            不为空,则变更mobile
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void changeUidRelated(Long oldUid, Long newUid, String mobile) {
		UserAccount cn = userAccountService.findByUid(oldUid, UserContant.ACCOUNT_TYPE_8);// 查询该账号是否CN账号
		boolean hasCN = false;
		if (cn != null) { // CN账号升级账号类型为运营商,更新运营商uid
			// 解除新uid上级关系
			hasCN = true;
			userRelationService.relieveRelationByUid(newUid);
		}
		// uid表更相关(account operator sys_user uid seller store 变更日志)
		userAccountService.changeUid(oldUid, newUid, hasCN);

		// 手机号变更
		if (mobile != null) {
			// 旧uid,将手机号对应的主表手机号致空
			userCustomerDao.updateMobileByUID(oldUid, null);
			// 新uid,将微信uid所对应的主表的手机号更新。
			userCustomerDao.updateMobileByUID(newUid, mobile);
		}
		// 关系
		if (userRelationdao.countRelationByRefereeUid(oldUid) > 0) {
			userRelationdao.updateRefereeUidByOldRefereeUid(oldUid, newUid);
		}
		// 云豆
		UserMoneyBO oldMoney = moneyServer.findUserMoneyByUid(oldUid);
		if (null != oldMoney && oldMoney.getAvailableBalance().doubleValue() > 0) {
			UserMoneyBO userMoney = moneyServer.findUserMoneyByUid(newUid);
			try {
				userMoney.setAvailableBalance(userMoney.getAvailableBalance().add(
						oldMoney.getAvailableBalance()));
				// 云豆合并到新账号上
				moneyServer.addMoney(newUid, oldMoney.getAvailableBalance().doubleValue(), 0L, "合并",
						"账号合并,云豆增加");
				// 旧账号上云豆清空
				moneyServer.consumptionMoney3(oldUid, "账号合并,云豆减少", oldMoney.getAvailableBalance());
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public UserCustomerBO findOneByUserId(Long id) {
		return this.userCustomerDao.findOneByUserId(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public IntegralSwapBO integralSwap(Long uid, String pwd, Integer exchangeIntegral) {
		IntegralSwapBO integralBO = new IntegralSwapBO();
		UserAccount userAccount = userAccountService.findByUid(uid, UserContant.ACCOUNT_TYPE_8);
		if (userAccount != null) {
			// CN用户才可以转换
			UserCustomer userCustomer = this.findOneByUserId(uid);
			if (userCustomer != null) {
				// 判断兑换积分是否足够
				if (userCustomer.getIntegral() != null && userCustomer.getIntegral() >= exchangeIntegral) {
					String orderNo = CommUtil.formatTime("yyyyMMddHHmmssSSS", new Date()) + uid;
					integralBO = orclUserBaseService.integralSwap(userAccount.getLoginName(), pwd,
							exchangeIntegral, orderNo);
					if (integralBO.getRETURN_STATUS() == 100) {
						// 添加转换日志
						integralService.addIntegralSwapLog(uid, -exchangeIntegral);
						this.addIntegral(uid, -exchangeIntegral);
					}
				} else {
					integralBO.setRETURN_STATUS(21);
				}
			} else {
				integralBO.setRETURN_STATUS(23);
			}
		} else {
			integralBO.setRETURN_STATUS(22);
		}
		return integralBO;
	}
}
