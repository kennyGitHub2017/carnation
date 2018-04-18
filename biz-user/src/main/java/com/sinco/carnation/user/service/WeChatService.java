package com.sinco.carnation.user.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.IncrementDao;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.dao.UserMoneyDao;
import com.sinco.carnation.user.model.Album;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.model.UserMoney;
import com.sinco.carnation.weChat.dao.WeChatAuthInfoDao;
import com.sinco.carnation.weChat.dao.WeChatInvitationRelationDao;

@Service("weChatService")
@Transactional
public class WeChatService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WeChatAuthInfoDao weChatAuthInfoDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserAccountDao accountDao;

	@Autowired
	IncrementDao incrementDao;

	@Autowired
	private UserCustomerDao userCustomerDao;

	@Autowired
	private UserMoneyDao moneyDao;

	@Autowired
	private WeChatInvitationRelationDao weChatInvitationRelationDao;

	@Autowired
	private UserRelationService userRelationService;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private UserService userService;

	@Autowired
	private AlbumService albumService;

	@Autowired
	private IntegralService integralService;

	/**
	 * 判断用户OpenID是否已存在
	 * 
	 * @param openID
	 * @return true:存在 false:不存在
	 */
	public UserAccountBO find_OpenID_Is_Registered(String openID) {

		UserAccountBO bo = this.accountDao.queryAccountByOpenId2(openID,
				Integer.valueOf(UserContant.ACCOUNT_TYPE_4));
		// WeChatAuthInfoBO bo = this.weChatAuthInfoDao.findOneByOpenID(openID);
		if (bo != null && bo.getId() != null) {
			return bo;
		}
		return null;
	}

	/**
	 * 判断用户Unionid是否已存在
	 * 
	 * @param openID
	 * @return true:存在 false:不存在
	 */
	public UserAccountBO find_WXUnionid_Is_Registered(String openID) {
		UserAccountBO bo = this.accountDao.queryAccountByUnionid(openID,
				Integer.valueOf(UserContant.ACCOUNT_TYPE_4));
		if (bo != null && bo.getId() != null) {
			return bo;
		}
		return null;
	}

	/**
	 * 根据 unionid判断用户是否已经注册
	 * 
	 * @param unionid
	 * @return false:不存在 true:存在
	 */
	public boolean isRegisterByUnionid(String unionid) {
		boolean boo = false;
		UserAccountBO bo = this.accountDao.queryAccountByUnionid(unionid,
				Integer.valueOf(UserContant.ACCOUNT_TYPE_4));
		if (bo != null && bo.getId() != null) {
			boo = true;
		}
		return boo;
	}

	/**
	 * 注册用户
	 * 
	 * @return
	 */
	// @Transactional(readOnly = false)
	@SuppressWarnings("unused")
	public UserAccount registerUser(Map<String, String> paramMap) {
		logger.info("//////////////// 注册用户 /////////////// ");
		logger.info("<<<<<< " + paramMap.toString());

		String passWord = "123456"; // 默认密码
		String requestIp = paramMap.get("requestIp");
		String loginName = paramMap.get("nickName");
		String nickname = loginName;
		String invitationCode = paramMap.get("invitationCode");
		Integer sex = paramMap.get("sex") == null ? 1 : Integer.parseInt(paramMap.get("sex"));
		String headimgurl = paramMap.get("headimgurl");
		String openid = paramMap.get("openid");
		String unionid = paramMap.get("unionid_");
		if (unionid == null || unionid.trim().length() == 0) {
			unionid = nickname;
		}

		/*创建用户信息*/
		UserAccount userAccount = userService.createUser(UserContant.USER_TYPE_1, UserContant.ACCOUNT_TYPE_4,
				unionid, passWord, requestIp, openid);
		/*Long uid = userService.createUser(UserContant.USER_TYPE_1, UserContant.ACCOUNT_TYPE_4, unionid, passWord,
		requestIp);*/

		Long uid = userAccount.getUid();

		// 如果昵称为空，则自动生成昵称：
		UserBO sysuser = userService.getObjById(uid);
		if (StringUtils.isBlank(nickname)) {
			nickname = "云尚" + sysuser.getInvitationCode();
		}

//		if (userCustomerDao.countByNickname(nickname, null) > 0) 
//		{
//			// 用户昵称已存在
//			return -5;
//		}

		UserBO refereeUser = null;
		Long tiUserID = 0l;
		if (null != invitationCode && !invitationCode.equals("")) {
			// 绑定关系
			refereeUser = userRelationService.createUserRelation(uid, invitationCode);
			tiUserID = refereeUser.getId();
		}

		Long refereeUserId = refereeUser == null ? 0L : refereeUser.getId();
		/*
		 * 创建用户默认相册
		 */
		Album album = new Album();
		album.setAlbumDefault(true);
		album.setAlbumName("默认相册");
		album.setAlbumSequence(-10000);
		this.albumService.albumSave(uid, album);
		/**
		 * 添加买家权限
		 */
		List<RoleBO> roles = this.userService.findRoleByType(UserContant.ROLE_TYPE_BUYER);
		List<Long> rids = new ArrayList<Long>();
		for (RoleBO roleBO : roles) {
			rids.add(roleBO.getId());
		}
		this.userService.saveUserRole(uid, UserContant.ROLE_TYPE_BUYER, rids.toArray(new Long[rids.size()]));
		/**
		 * 初始用户金额
		 */
		UserMoney money = new UserMoney();
		money.setAvailableBalance(new BigDecimal(0));
		money.setUid(uid);
		this.moneyDao.create(money);
		/**
		 * 创建用户信息
		 */
		UserCustomer customer = new UserCustomer();
		customer.setFreezeBlance(BigDecimal.valueOf(0));
		customer.setUid(uid);
		customer.setMobile("-");
		customer.setNickname(nickname);
		customer.setName(nickname);
		customer.setEmail("-");
		customer.setSex(sex);
		customer.setCreateTime(new Date());
		customer.setIsDeleted(false);
		customer.setStatus("1");
		customer.setHeadImgPath(headimgurl);
		int result = userCustomerDao.insert(customer);
		if(result == 1){
			/**
			 * 添加积分
			 */
			integralService.addIntegral(IntegralConstants.INTEGRAL_REGISTER, uid, uid);
			/**
			 * 推荐人也赠送积分
			 */
			if (refereeUserId != null && refereeUserId > 0) {
				integralService.addIntegral(IntegralConstants.INTEGRAL_INVITE_FRIENDS, refereeUserId, uid);
			}
			// 绑定第三方用户加分 第三方绑定增加操作 一.加积分 2:手机3:QQ4:微信5:微博
			userService.bindingThirdDo(UserContant.ACCOUNT_TYPE_4, uid, loginName);
		}

		/*
		WeChatAuthInfo  authInfo = new WeChatAuthInfo();
		authInfo.setOpenid(openid);
		authInfo.setUserId(uid);
		weChatAuthInfoDao.save(authInfo);
		if(tiUserID!=0l)
		{
			WeChatInvitationRelation wxRelation = new WeChatInvitationRelation();
			wxRelation.setUnionId(paramMap.get("unionid_"));
			wxRelation.setOpenId(openid);
			wxRelation.setNickName(nickname);
			wxRelation.setHeadImgPath(headimgurl);
			wxRelation.setOwnerId(tiUserID);
			weChatInvitationRelationDao.save(wxRelation);
		}
		*/
		return userAccount;
	}

	/**
	 * 微信网页授权，授权用户非系统用户时，系统为用户进行注册操作
	 * 
	 * @param paramMap
	 * @return
	 */
	@Transactional(readOnly = false)
	public UserAccount weChat_RegisterUser(Map<String, String> paramMap) {
		UserAccount userAccount = null;
		logger.info("//////////////// 注册用户 /////////////// ");
		logger.info("<<<<<<< param->" + paramMap.toString());

		String nickName = paramMap.get("nickName");
		String requestIp = paramMap.get("requestIp");
		Integer sex = paramMap.get("sex") == null ? 1 : Integer.parseInt(paramMap.get("sex"));
		String headimgurl = paramMap.get("headimgurl") == null ? "" : paramMap.get("headimgurl");
		String openid = paramMap.get("openid");
		String unionid = paramMap.get("unionid_");
		String invitationCode = paramMap.get("invitationCode");
		String passWord = unionid; // 默认密码使用微信unionid
		/*创建用户信息*/
		userAccount = userService.createUser(UserContant.USER_TYPE_1, UserContant.ACCOUNT_TYPE_4, unionid,
				passWord, requestIp, openid);
		Long uid = userAccount.getUid();
		// 是否存在推荐关系 默认 false
		boolean hasRelation = Boolean.FALSE;
		Long refUserID = null;
		logger.debug("============> createUser uid->" + uid);
		if (invitationCode != null && invitationCode.trim().length() > 0 && uid != null) {

			logger.debug("========> [weChat_RegisterUser] invitationCode -> " + invitationCode);
			UserBO ref = userService.findByInvitationCode(invitationCode);// 获取推荐人的信息
			if (ref != null && ref.getId() != null) {
				refUserID = ref.getId();
				// customerService.createCustomer(uid, null, nickName, "", null, sex, ref.getId(),
				// headimgurl);
				// 添加推荐关系
				/*System.out.println(invitationCode + "" + uid);
				this.addUserRelation(uid, invitationCode);*/
				hasRelation = Boolean.TRUE;
			}
		}
		/*else {
			customerService.createCustomer(uid, null, nickName, "", null, sex, null, headimgurl);
		}*/
		customerService.createCustomer(uid, null, nickName, "", null, sex, refUserID, headimgurl);
		if (hasRelation) {
			// 添加推荐关系
			this.addUserRelation(uid, invitationCode);
		}
		return userAccount;
	}

	/***
	 * 建立绑定关系
	 * 
	 * @param uid
	 *            用户uid
	 * @param invitationCode
	 *            推荐人的邀请码
	 */
	public void addUserRelation(Long uid, String invitationCode) {
		if (uid == null || invitationCode == null) {
			return;
		}
		logger.debug("================== add User Relation =====================");
		logger.debug("<<<<<<<<<<< param-> uid：" + uid + " invitationCode:" + invitationCode);
		UserBO bo = userRelationService.createUserRelation(uid, invitationCode);
		System.out.println(bo);
	}
	/**
	 * 商户APP-微信授权后-注册会员
	 * 			add by yuleijia 2017.4.15
	 * @return
	 * 		200：succ
	 * 		500:fail
	 */
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int saveMerchantRegisterAccount(Map<String, String> paramMap,String password,String mobile)
	{
		logger.info("=================== Save Merchant Register Account ====================== ");
		int result = 200;
		if (paramMap != null && !paramMap.isEmpty()) {
			//注册微信会员
			UserAccount userAccount = this.weChat_RegisterUser(paramMap);
			Long uid = userAccount.getUid();
			// 绑定手机号码
			String pwd = PasswordUtils.entryptPassword(password);
			UserAccount account_ = new UserAccount();
			account_.setLoginName(mobile);
			account_.setAccountType(UserContant.ACCOUNT_TYPE_2);
			account_.setIsDeleted(false);
			account_.setUid(uid);
			account_.setPassword(pwd);
			account_.setSellerPassword(pwd);
			this.accountDao.save(account_);
		} else {
			result = 500;
		}
		logger.debug(">>>>>>>>>>>>> "+result);
		return result;
	}
}
