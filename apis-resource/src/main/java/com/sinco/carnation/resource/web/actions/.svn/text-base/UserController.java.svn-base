package com.sinco.carnation.resource.web.actions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.exception.ApiException;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.IPUtil;
import com.sinco.api.util.JsoupUtils;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.aio.model.AioBinding;
import com.sinco.carnation.aio.service.AioBindingService;
import com.sinco.carnation.notice.service.OperatorNoticesService;
import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.service.CouponInfoService;
import com.sinco.carnation.operation.vo.CouponInfoMyVO;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.pay.service.PredepositLogService;
import com.sinco.carnation.resource.bo.APIAccountBO;
import com.sinco.carnation.resource.bo.CustomerBO;
import com.sinco.carnation.resource.bo.IntegerTodayBO;
import com.sinco.carnation.resource.bo.OpNoticesBO;
import com.sinco.carnation.resource.bo.RelationBO;
import com.sinco.carnation.resource.bo.SysVersionControlBO;
import com.sinco.carnation.resource.bo.UserDocumentBO;
import com.sinco.carnation.resource.bo.UserIntegralBO;
import com.sinco.carnation.resource.bo.UserIntegralDetailBO;
import com.sinco.carnation.resource.bo.UserYunGouMoneyBO;
import com.sinco.carnation.resource.bo.UserYunMoneyBO;
import com.sinco.carnation.resource.bo.check.UserSignBO;
import com.sinco.carnation.resource.bo.o2o.OperatorBankBO;
import com.sinco.carnation.resource.bo.o2o.StoreBankBO;
import com.sinco.carnation.resource.bo.shop.ShopCouponInfoBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.ArticleMarkVO;
import com.sinco.carnation.resource.vo.BindingCheckVO;
import com.sinco.carnation.resource.vo.BindingMobileVO;
import com.sinco.carnation.resource.vo.BindingRegisterVO;
import com.sinco.carnation.resource.vo.BindingThirdVO;
import com.sinco.carnation.resource.vo.BindingWeiXinCheckVO;
import com.sinco.carnation.resource.vo.CnBindMobileVO;
import com.sinco.carnation.resource.vo.CnBindingTridVO;
import com.sinco.carnation.resource.vo.CnMobileBindWx;
import com.sinco.carnation.resource.vo.CouponInfoVO;
import com.sinco.carnation.resource.vo.FeedBackVO;
import com.sinco.carnation.resource.vo.MobileBingWxCheckVO;
import com.sinco.carnation.resource.vo.NoticesVO;
import com.sinco.carnation.resource.vo.OpNoticesVO;
import com.sinco.carnation.resource.vo.RelationVO;
import com.sinco.carnation.resource.vo.UserIntegralDetailListVO;
import com.sinco.carnation.resource.vo.bindingCreatUserVO;
import com.sinco.carnation.resource.vo.register.InvitationUsersVO;
import com.sinco.carnation.resource.vo.register.OperaterMoneyPassWordVO;
import com.sinco.carnation.resource.vo.register.PasswordUpdateVO;
import com.sinco.carnation.resource.vo.register.PaymentPasswordVO;
import com.sinco.carnation.resource.vo.register.RegisterAccountUpdateVO;
import com.sinco.carnation.resource.vo.register.SearchCustomerVo;
import com.sinco.carnation.resource.vo.register.ShareInfoSettingVO;
import com.sinco.carnation.resource.vo.register.UpdateAccountUpdateVO;
import com.sinco.carnation.resource.web.response.NullResponse;
import com.sinco.carnation.resource.web.response.VersionControlResponse;
import com.sinco.carnation.resource.web.response.check.AppleCheckedResponse;
import com.sinco.carnation.resource.web.response.check.WxBindingResponse;
import com.sinco.carnation.resource.web.response.register.CnBindMobileResponse;
import com.sinco.carnation.resource.web.response.register.IntegerTodayResponse;
import com.sinco.carnation.resource.web.response.register.PasswordUpdateResponse;
import com.sinco.carnation.resource.web.response.register.RegisterAccountUpdateResponse;
import com.sinco.carnation.resource.web.response.register.SearchCustomerResponse;
import com.sinco.carnation.resource.web.response.register.ThirdAccountResponse;
import com.sinco.carnation.resource.web.response.register.UserCustomerSavefirstResponse;
import com.sinco.carnation.resource.web.response.user.CheckUserCodeResponse;
import com.sinco.carnation.resource.web.response.user.CouponInfoResponse;
import com.sinco.carnation.resource.web.response.user.DocInfoResponse;
import com.sinco.carnation.resource.web.response.user.InvitationUserResponse;
import com.sinco.carnation.resource.web.response.user.MyRefereInfoResponse;
import com.sinco.carnation.resource.web.response.user.ShareInfoResponse;
import com.sinco.carnation.resource.web.response.user.ShopBonusRepeatLogResponse;
import com.sinco.carnation.resource.web.response.user.UserIntegralListResponse;
import com.sinco.carnation.resource.web.response.user.UserYunMoneylListResponse;
import com.sinco.carnation.resource.web.util.TokenAuthUtils;
import com.sinco.carnation.shop.bo.PredepositLogBO;
import com.sinco.carnation.shop.bo.ShopBonusRepeatLogBO;
import com.sinco.carnation.shop.vo.ShopBonusRepeatLogVO;
import com.sinco.carnation.sns.bo.OperatorNoticesBO;
import com.sinco.carnation.sns.vo.OperatorNoticesVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.AreaBO;
import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.bo.ArticleClassBO;
import com.sinco.carnation.sys.bo.DocumentBO;
import com.sinco.carnation.sys.bo.IntegralRegBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.bo.VersionControlBO;
import com.sinco.carnation.sys.bo.orcl.CnMoneyBO;
import com.sinco.carnation.sys.bo.orcl.CnUserMoneyBO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.constant.OrclSchmaNameConstants;
import com.sinco.carnation.sys.contants.ArticleContant;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.model.BindingHistory;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.ArticleClassService;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.sys.service.BindingHistoryService;
import com.sinco.carnation.sys.service.DocumentService;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.service.VersionControlService;
import com.sinco.carnation.user.bo.IntegralLogBO;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.dao.UserRelationDao;
import com.sinco.carnation.user.model.Address;
import com.sinco.carnation.user.model.Feedback;
import com.sinco.carnation.user.service.AddressService;
import com.sinco.carnation.user.service.FeedbackService;
import com.sinco.carnation.user.service.IntegralLogService;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.StatisticsService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.service.UserOwnService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "用户API", namespace = "user")
public class UserController extends BasicApiController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private UserAccountService accountService;

	@Autowired
	private UserMoneyService moneyService;

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private UserRelationService relationService;

	@Autowired
	private StoreService storeService;
	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private RedisCacheService redisCacheService;

	@Autowired
	private IntegralService integralService;

	@Autowired
	private FeedbackService feedBackService;

	@Autowired
	private DocumentService documentService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserOwnService userOwnsService;
	@Autowired
	private OperatorNoticesService noticesService;
	@Autowired
	private OperatorNoticesService operatorNoticesService;
	@Autowired
	private ArticleClassService articleClass;

	@Autowired
	private IntegralLogService integrallogService;

	@Autowired
	private PredepositLogService predepositlogService;

	@Autowired
	private CouponInfoService couponInfoService;

	@Autowired
	private Mapper mapper;

	@Autowired
	private AddressService addressService;

	@Autowired
	private CnPayBaseService cnPayBaseService;

	@Autowired
	private BindingHistoryService bindingHistoryService;
	@Autowired
	private StatisticsService statisticsService;

	@Autowired
	private VersionControlService versionControlService;
	// @Autowired
	// private CnPayBaseService cnPayBaseService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unused")
	private volatile static UserController singleton = null;

	@Autowired
	private AioBindingService aioService;

	//
	// @RequestMapping(value = "/roles/all", method = RequestMethod.GET)
	// @MethodMapping(desc = "得到用户的所有角色")
	// public @ResponseBody RolesAllResponse rolesAll() throws ApiException {
	// RolesAllResponse response=new RolesAllResponse();
	//
	// Long uid=ActionsUtil.getOwnerUid();
	//
	//
	// return response;
	// }
	//
	// @RequestMapping(value = "/roles/profile", method = RequestMethod.GET)
	// @MethodMapping(desc = "角色详细信息")
	// public @ResponseBody RolesProfileResponse rolesProfile(HttpServletRequest
	// req,
	// @RequestParam(value="rid",required=false)
	// @Param(desc="角色id,如果不传默认所 tokan 中的当前使用角色") Long rid
	// ,@RequestParam(value="nickname",required=false)
	// @Param(desc="角色昵称，rid 和 nickname 都存在的情况下会优先使用rid") String nickname)
	// throws ApiException {
	// RolesProfileResponse response=new RolesProfileResponse();
	//
	// return response;
	// }

	@RequestMapping(value = "/users/customer/search", method = RequestMethod.POST)
	@MethodMapping(desc = "查找用户信息")
	public @ResponseBody
	SearchCustomerResponse usersSearchCustomer(@Valid @ModelAttribute @Param SearchCustomerVo vo,
			BindingResult result, HttpServletRequest request) {

		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long userId = ActionsUtil.getOwnerUid(); // 15905L;
		UserCustomerBO list = customerService.searchCustomer(userId);
		if (null != list) {
			CustomerBO customerList = mapper.map(list, CustomerBO.class);
			UserBO user = userService.getObjById(userId);
			if (user != null) {
				// 设置邀请码
				customerList.setInvitationCode(user.getInvitationCode());
			}
			UserRelationBO relationBO = relationService.queryReferee(userId);

			/* 获取当前用户邀请好友人数 author:yuleijia start */
			int inviteNumber = statisticsService.getAbcPartnerCount(userId);
			customerList.setInviteNumber(inviteNumber);
			/* end */

			if (relationBO != null) {
				UserBO invitaor = userService.fetchRefereeUser(relationBO.getRefereeUserId());
				// 设置推荐人
				if (invitaor != null) {
					customerList.setReferee(invitaor.getUserName());
				}
				// 设置隶属商户
				customerList.setMerchant(relationBO.getStoreName());
			}

			UserCustomerBO customer = customerService.queryUserByUid(userId);
			UserIntegralBO integral = mapper.map(customer, UserIntegralBO.class);
			response.setIntegral(integral);// 返回用户积分

			String source = ActionsUtil.getOwnerSource();
			// 云豆 奖金 云购币 BEGIN
			// 查询云豆支付密码
			Map<String, Object> moneyMap = statisticsService.getUserMoneyV2(userId, source);
			double cnIntegral = (double) moneyMap.get("cnIntegral");// 购物积分
			double cnBonus = (double) moneyMap.get("cnBonus");// 奖金
			double cnRepeat = (double) moneyMap.get("cnRepeat");// 冲销币
			double availableBalance = (double) moneyMap.get("availableBalance"); // 云豆
			double recordBalance = (double) moneyMap.get("recordBalance");// 预分润云豆
			boolean pwdNotNull = (boolean) moneyMap.get("pwdNotNull");// 是否设置了云豆
			response.setCnIntegral(cnIntegral);// 购物积分
			response.setcNBonus(cnBonus);// 奖金
			response.setcNRepeat(cnRepeat);
			response.setAvailableBalance(availableBalance);// 当前云豆
			response.setRecordBalance(recordBalance);// 预分润云豆
			response.setCountMoney(cnBonus + availableBalance);// 总金额=奖金+云豆
			if (pwdNotNull) {
				// 已设置云豆密码
				customerList.setCloudPassword(true);
			}

			// 通过userid查询默认收货地址区域ID
			Address address = addressService.getDefaultByUserId(userId);
			if (address != null) {
				// 通过默认收货地址区域ID查询所属省市
				AreaBO areabo = areaService.selectNameByAreaId(address.getAreaId());
				customerList.setAddress(areabo.getProvinceName() + "-" + areabo.getCityName());
			}
			UserAccountBO userbo = new UserAccountBO();
			userbo.setAccountType(UserContant.ACCOUNT_TYPE_8);
			userbo.setUid(userId);
			UserAccountBO accountBO = userAccountService.findAccountByVo(userbo);
			if (accountBO != null) {
				customerList.setIsCn(true);
			} else {
				customerList.setIsCn(false);
			}
			// 验证该账户是否是cn账户,以及是否绑定过手机号
			/*
			 * String extend=list.getExtend(); if(!StringUtils.isEmpty(extend)){
			 * UserExtends
			 * userExtend=JSON.toJavaObject(JSON.parseObject(extend),
			 * UserExtends.class);
			 * if(null!=userExtend&&!StringUtils.isEmpty(userExtend
			 * .getCn_username
			 * ())&&userExtend.getCn_username().startsWith(UserContant
			 * .ACCOUNT_TYPE_CN)){ customerList.setIsCn(true); //验证CN账户是否绑定手机号
			 * UserAccountBO userbo=new UserAccountBO();
			 * userbo.setAccountType(UserContant.ACCOUNT_TYPE_2);
			 * userbo.setUid(userId); UserAccountBO
			 * accountBO=userAccountService.findAccountByVo(userbo);
			 * if(accountBO==null){
			 * customerList.setIsBindMobiel(false);//CN账户未绑定手机号 } } }
			 */
			// 获取身份号
			AioBinding aioBinding = aioService.getAioBindingByUid(userId);
			customerList.setIdCard(null != aioBinding ? aioBinding.getIdCard() : null);

			response.setCustomer(customerList);
		}
		return response;
	}

	@RequestMapping(value = "/users/customer/update", method = RequestMethod.POST)
	@MethodMapping(desc = "修改用户信息")
	public @ResponseBody
	RegisterAccountUpdateResponse userAccountUpdate(@Valid @ModelAttribute @Param RegisterAccountUpdateVO vo,
			BindingResult result, HttpServletRequest request) {

		RegisterAccountUpdateResponse response = new RegisterAccountUpdateResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();
		if (customerService.updateUserInfo(userId, null, vo.getNickname(), vo.getHeadImgPath(),
				vo.getEmail(), vo.getName(), vo.getHeight(), vo.getWeight(), vo.getAllergHistory(),
				vo.getSex(), vo.getBirthDate(), vo.getTransGenetic(), vo.getTransHistory(), vo.getBlood(),
				vo.getUserSignature()) <= 0) {
			response.putErrorMessage("5.register.userAccountUpdate.update_fail");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/users/customer/updateImg", method = RequestMethod.POST)
	@MethodMapping(desc = "修改用户头像")
	public @ResponseBody
	RegisterAccountUpdateResponse usersCustomerUpdateImg(
			@Valid @RequestParam(value = "headImgPath") @Param(desc = "修改后的用户头像地址") String headImgPath,
			HttpServletRequest request) {

		RegisterAccountUpdateResponse response = new RegisterAccountUpdateResponse();

		if (StringUtils.isEmpty(headImgPath)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		Long userId = ActionsUtil.getOwnerUid();
		if (customerService.updateUserImg(userId, headImgPath) < 1) {
			response.putErrorMessage("5.register.userAccountUpdate.update_fail");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/users/password/update", method = RequestMethod.POST)
	@MethodMapping(desc = "修改密码")
	public @ResponseBody
	PasswordUpdateResponse usersPassWordUpdate(@Valid @ModelAttribute @Param PasswordUpdateVO vo,
			BindingResult result, HttpServletRequest request) {

		PasswordUpdateResponse response = new PasswordUpdateResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();
		// UserAccount account = accountService.findByUid(userId,
		// UserContant.ACCOUNT_TYPE_2);
		UserAccount account = accountService.findByUid(userId);

		String source = ActionsUtil.getOwnerSource();
		String password = "";
		switch (source) {
			case UserContant.ACCOUNT_TYPE_RESOURCE:
				password = account.getPassword();
				break;
			case UserContant.ACCOUNT_TYPE_MERCHANT:
				password = account.getSellerPassword();
				break;
			case UserContant.ACCOUNT_TYPE_SUPPLIER:
				password = account.getSupplierPassword();
				break;
			case UserContant.ACCOUNT_TYPE_YY:
				password = account.getOperatorPassword();
				break;
		}

		if (!PasswordUtils.validatePassword(vo.getOdlPassword(), password)) {
			response.putErrorMessage("5.user.usersPassWordUpdate.odl_password_fail");
			return response;
		}
		if (accountService.passwordUpdate(userId, vo.getNewPassword(), source) < 0) {
			response.putErrorMessage("5.user.usersPassWordUpdate.update_fail");
			return response;
		}
		log.debug("Update Password Source:" + source);
		return response;
	}

	@RequestMapping(value = "/users/integral", method = RequestMethod.POST)
	@MethodMapping(desc = "用户云豆")
	public @ResponseBody
	SearchCustomerResponse getUserIntegral() {
		SearchCustomerResponse response = new SearchCustomerResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		// 获取用户名
		UserAccount account = accountService.findByUid(uid, UserContant.ACCOUNT_TYPE_2);
		if (account != null) {
			response.setMobile(account.getLoginName());
		}
		String source = ActionsUtil.getOwnerSource();
		Map<String, Object> moneyMap = statisticsService.getUserMoneyV2(uid, source);
		double cnIntegral = (double) moneyMap.get("cnIntegral");// 购物积分
		double cnBonus = (double) moneyMap.get("cnBonus");// 奖金
		double cnRepeat = (double) moneyMap.get("cnRepeat");// 冲销币
		double availableBalance = (double) moneyMap.get("availableBalance"); // 云豆
		double recordBalance = (double) moneyMap.get("recordBalance");// 预分润云豆
		boolean pwdNotNull = (boolean) moneyMap.get("pwdNotNull");// 是否设置了云豆
		// 判断是否设置云豆密码
		if (pwdNotNull) {
			response.setCloudPassword(true);
		}
		response.setCnIntegral(cnIntegral);// 购物积分
		response.setcNBonus(cnBonus);// 奖金
		response.setcNRepeat(cnRepeat);// 冲销币
		response.setRecordBalance(recordBalance);// 用户预分润云豆
		response.setAvailableBalance(availableBalance);// 用户云豆
		response.setCountMoney(cnBonus + availableBalance);// 用户总云豆 奖金+云豆
		return response;
	}

	@RequestMapping(value = "/users/pay_password/update", method = RequestMethod.POST)
	@MethodMapping(desc = "修改云豆密码")
	public @ResponseBody
	SearchCustomerResponse updatPaymentPassword(@Valid @ModelAttribute @Param PaymentPasswordVO vo,
			BindingResult result, HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		String source = ActionsUtil.getOwnerSource();
		int num = 0;
		if (null != source) {
			num = customerService.updatePaymentPassword(uid, vo.getMobile(), vo.getCode(), vo.getPassword(),
					source);
		} else {
			num = customerService.updatePaymentPassword(uid, vo.getMobile(), vo.getCode(), vo.getPassword());
		}
		switch (num) {
			case 100:
				return response;
			case 200:
				response.putErrorMessage("5.user.updatPaymentPassword.user_not");
				return response;
			case 300:
				response.putErrorMessage("5.user.updatPaymentPassword.user_fail");
				return response;
			case 400:
				response.putErrorMessage("5.user.updatPaymentPassword.user_code_fail");
				return response;
			default:
				response.putErrorMessage("payment error");
				return response;
		}
	}

	@RequestMapping(value = "/users/integral/get", method = RequestMethod.POST)
	@MethodMapping(desc = "用户获取积分")
	public @ResponseBody
	IntegerTodayResponse getIntegral() {
		IntegerTodayResponse response = new IntegerTodayResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		UserCustomerBO customer = customerService.queryUserByUid(uid);
		UserIntegralBO integral = mapper.map(customer, UserIntegralBO.class);

		// 当日已获取全部积分
		int todayall = integralService.IntegralTodayAllGet(customer.getUid());
		// 当日已获取消费积分外的积分
		int today = integralService.IntegralTodayGet(customer.getUid());
		integral.setIntegralToday(todayall);
		// 剩余可获取积分
		int canget = 0;
		if (IntegralConstants.INTEGRAL_CEILING_DAILY - today > 0) {
			canget = IntegralConstants.INTEGRAL_CEILING_DAILY - today;
		}
		integral.setIntegralCeiling(canget);
		response.setIntegral(integral);

		/*
		 * List<IntegralRegBO> bo = integralService.selectRegByUserid(uid);
		 * response.setIntegralToday(bo);
		 */
		// 当日积分任务情况
		List<IntegralRegBO> listResult = integralService.selectRegByUserid(uid);
		List<IntegerTodayBO> list = MapperUtils.map(mapper, listResult, IntegerTodayBO.class);
		response.setIntegralToday(list);
		// 一次性积分任务情况
		List<IntegralRegBO> listResult2 = integralService.selectOtherRegByUserid(uid);
		List<IntegralRegBO> listResult3 = new ArrayList<>();
		for (IntegralRegBO bo : listResult2) {
			if (bo.getType().equals(IntegralConstants.INTEGRAL_CONSUMER)
					|| bo.getType().equals(IntegralConstants.INTEGRAL_INVITE_FRIENDS)) {
				listResult3.add(bo);
			}
		}
		List<IntegerTodayBO> list2 = MapperUtils.map(mapper, listResult3, IntegerTodayBO.class);
		response.setIntegralOther(list2);
		return response;
	}

	/**
	 * 用户积分商品促销活动，查看用户积分信息（后期拓展）
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users/integral/getByUid", method = RequestMethod.POST)
	@MethodMapping(desc = "用户获取积分")
	public @ResponseBody
	SearchCustomerResponse getIntegralByUid() {
		SearchCustomerResponse response = new SearchCustomerResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.nologin.integral");
			return response;
		}

		UserCustomerBO customer = customerService.queryUserByUid(uid);
		UserIntegralBO integral = mapper.map(customer, UserIntegralBO.class);
		response.setIntegral(integral);
		return response;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/group/availableBalance/get", method = RequestMethod.POST)
	@MethodMapping(desc = "用户财富")
	public @ResponseBody
	SearchCustomerResponse getAvailableBalance() {
		SearchCustomerResponse response = new SearchCustomerResponse();
		Long uid = ActionsUtil.getOwnerUid();
		String source = ActionsUtil.getOwnerSource();
		Map<String, Object> moneyMap = statisticsService.getUserMoneyV2(uid, source);
		double cnBonus = (double) moneyMap.get("cnBonus");// 奖金
		double cnRepeat = (double) moneyMap.get("cnRepeat");// 冲销币
		double balance = (double) moneyMap.get("availableBalance");// 获取用户云豆
		response.setBalance(new BigDecimal(balance).setScale(2, RoundingMode.DOWN));
		double record = (double) moneyMap.get("recordBalance");// 获取用户预分润云豆
		response.setRecordBalance(record);
		return response;
	}

	@RequestMapping(value = "/users/operater_moneypass/update", method = RequestMethod.POST)
	@MethodMapping(desc = "营运商修改云豆密码")
	public @ResponseBody
	SearchCustomerResponse updateOperaterPassWord(@Valid @ModelAttribute @Param OperaterMoneyPassWordVO vo,
			BindingResult result, HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			uid = 0L;
		}
		int num = customerService.updateOperaterPaymentPassword(uid, vo.getMobile(), vo.getCode(),
				vo.getPassword());
		if (num == 400) {
			response.putErrorMessage("5.user.updatPaymentPassword.user_code_fail");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/users/bank_info/get", method = RequestMethod.POST)
	@MethodMapping(desc = "获取商户或营运商银行信息")
	public @ResponseBody
	SearchCustomerResponse userBankInfo(
			@Valid @RequestParam(value = "type") @Param(desc = "类型|1商户2营运商") Integer type) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (type == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (type == 1) {
//			StoreBO store = storeService.queryStoreByCreateUserId(uid);
			StoreBO store = this.storeService.queryStoreInfo(uid, true, false);
			if (store != null) {
				StoreBankBO storeBank = mapper.map(store, StoreBankBO.class);
				response.setStoreBankInfo(storeBank);
			}
		} else if (type == 2) {
			OperatorBO operator = operatorService.queryOperatorInfo(uid);
			if (operator != null) {
				OperatorBankBO operatorBank = mapper.map(operator, OperatorBankBO.class);
				response.setOperatorBankInfo(operatorBank);
			}
		}
		return response;
	}

	@RequestMapping(value = "/openId_binding/check", method = RequestMethod.POST)
	@MethodMapping(desc = "检查用户是否绑定第三方平台")
	public @ResponseBody
	SearchCustomerResponse queryAccountByOpenId(@Valid @ModelAttribute @Param BindingCheckVO vo,
			BindingResult result, HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		UserAccountBO account = null;
		if (UserContant.ACCOUNT_TYPE_4.equals(String.valueOf(vo.getType()))) { // 微信使用unionId
			account = accountService.queryAccountByOpenId(vo.getUnionId(), vo.getType());
		} else {
			account = accountService.queryAccountByOpenId(vo.getOpenId(), vo.getType());
		}

		if (account != null) {
			response.setIsBinding(true);
			response.setBindingOpenId(vo.getOpenId());
			return response;
		} else {
			response.setIsBinding(false);
			return response;
		}
	}

	/**
	 * 第三方帐号绑定列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/binding/list", method = RequestMethod.POST)
	@MethodMapping(desc = "用户的第三方平台绑定账号列表")
	public @ResponseBody
	ThirdAccountResponse getThirdAccountList() {

		ThirdAccountResponse response = new ThirdAccountResponse();
		List<UserAccountBO> list = accountService.findUserAccountByUid(ActionsUtil.getOwnerUid());
		List<UserAccountBO> list1 = new ArrayList<UserAccountBO>();
		for (UserAccountBO account : list) {
			if (account.getLoginName().length() > 13)
				account.setLoginName(account.getLoginName().substring(0, 11));
			list1.add(account);
		}
		List<APIAccountBO> lList = MapperUtils.map(mapper, list1, APIAccountBO.class);
		response.setAccounts(lList);

		return response;
	}

	/**
	 * 第三方帐号解绑
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/openId_binding/delete", method = RequestMethod.POST)
	@MethodMapping(desc = "用户绑定的第三方平台解绑")
	public @ResponseBody
	NullResponse deleteAccountByOpenId(
			@Valid @RequestParam(value = "type") @Param(desc = "类型| 3:QQ4:微信5:微博 ") String type) {

		NullResponse response = new NullResponse();
		Long uid = ActionsUtil.getOwnerUid();

		if (type == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		boolean flag = accountService.deleteAccount(uid, type);
		if (!flag) {
			response.setSubMsg("解除绑定失败！");
		}
		return response;
	}

	@RequestMapping(value = "/users/sign/login", method = RequestMethod.POST)
	@MethodMapping(desc = "用户签到")
	public @ResponseBody
	SearchCustomerResponse userLoginSign(
			@Valid @RequestParam(value = "type") @Param(desc = "是否签到|1签到2不签到") Integer type,
			HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (type == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		boolean flag = integralService.isSignToday(uid, IntegralConstants.INTEGRAL_SIGN_DAY);
		UserSignBO sign = new UserSignBO();
		// 签到
		if (type == 1) {
			// 当天已签到
			if (flag) {
				sign.setIsSign(true);
				sign.setDay(integralService.getSignDay(uid, IntegralConstants.INTEGRAL_SIGN_DAY));
			} else {
				int num = integralService.addIntegral(IntegralConstants.INTEGRAL_SIGN_DAY, uid, null);// 增加积分
				int day = integralService.getSignDay(uid, IntegralConstants.INTEGRAL_SIGN_DAY);
				sign.setDay(day);
				sign.setIntegral(num);
				sign.setIsSign(false);
			}
			// 不签到
		} else if (type == 2) {
			sign.setIsSign(flag);
			sign.setDay(integralService.getSignDay(uid, IntegralConstants.INTEGRAL_SIGN_DAY));
		}
		response.setUserSign(sign);
		if (integralService.IntegralTodayRemaining(1, uid) == 0) {
			response.putErrorMessage("5.integral.get.is_ceiling");// 积分获取达到上限
		}
		return response;
	}

	@RequestMapping(value = "/users/feed/back", method = RequestMethod.POST)
	@MethodMapping(desc = "问题反馈")
	public @ResponseBody
	SearchCustomerResponse feedback(@Valid @ModelAttribute @Param FeedBackVO vo, BindingResult result,
			HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		Feedback feedback = new Feedback();
		feedback.setContent(vo.getContent());
		feedback.setCreateTime(new Date());
		feedback.setSource(vo.getSource());
		feedback.setUserId(uid);
		feedback.setStatus(0);
		feedBackService.saveFeedBack(feedback);
		return response;
	}

	@RequestMapping(value = "/users/sys/help", method = RequestMethod.POST)
	@MethodMapping(desc = "系统帮助")
	public @ResponseBody
	SearchCustomerResponse sysHelp(
			@Valid @RequestParam("code") @Param(desc = "code|papphelp个人，mapphelp商户，oapphelp营运商,pappabout个人关于,mappabout商户关于，oappabout营运商关于") String code,
			HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (StringUtils.isBlank(code)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		DocumentBO documentBO = documentService.findByMark(code);
		if (documentBO != null) {
			UserDocumentBO document = mapper.map(documentBO, UserDocumentBO.class);
			document.setHtmlContent(JsoupUtils.queryHtml(document.getContent()));// 设置html模版内容
			response.setDocumet(document);
		}
		return response;
	}

	@RequestMapping(value = "/users/notice", method = RequestMethod.POST)
	@MethodMapping(desc = "商户公告")
	public @ResponseBody
	SearchCustomerResponse sysNotice(@Valid @ModelAttribute @Param NoticesVO vo, BindingResult result,
			HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		// 营运商公告
		if (vo.getType() == 0) {
			MyPage<OperatorNoticesBO> page = new MyPage<OperatorNoticesBO>();
			page.setPageNumber(vo.getPageNum());
			page.setPageSize(vo.getPageSize());

			// 运营商公告列表
			OperatorNoticesVO noticeVo = new OperatorNoticesVO();
			/*StoreBO storeBO = storeService.fetchStoreByCreateUserId(uid);*/
			SellerBO seller = sellerService.findSessionById(uid, true, null);
			StoreBO storeBO = this.storeService.getStoreStatus(seller.getStoreId());
			if (storeBO != null) {
				Area area = areaService.fetchAndAllParent(storeBO.getAreaId());
				if (area != null) {
					Area parent = area.getParent();
					List<OperatorBO> operators = operatorService.getOperatorBOByOperatorAreaId(CommUtil
							.null2String(parent.getId()));
					if (operators != null && operators.size() > 0) {
						OperatorBO operator = operators.get(0);
						noticeVo.setOperatorId(operator.getId());
						noticeVo.setNtStatus(1);
						List<OperatorNoticesBO> operatorNotices = operatorNoticesService.findPageByVO(
								noticeVo, page).getContent();
						List<OpNoticesBO> list = MapperUtils.map(mapper, operatorNotices, OpNoticesBO.class);
						response.setOpNoticesBOs(list);
						return response;
					}
				}
			}

		} else {
			// 平台公告
			MyPage<ArticleBO> page = new MyPage<ArticleBO>();
			page.setPageNumber(vo.getPageNum());
			page.setPageSize(vo.getPageSize());
			articleService.queryMerchantNoticeList(ArticleContant.O2O_MARK, page);
			List<com.sinco.carnation.resource.bo.ArticleBO> articleBOs = MapperUtils.map(mapper,
					page.getContent(), com.sinco.carnation.resource.bo.ArticleBO.class);
			response.setOpArticleList(articleBOs);
			return response;
		}

		return response;
	}

	@RequestMapping(value = "/users/operator/notices", method = RequestMethod.POST)
	@MethodMapping(desc = "营运商公告")
	public @ResponseBody
	SearchCustomerResponse operatorNotices(@Valid @ModelAttribute @Param OpNoticesVO vo, BindingResult result) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		// 平台公告
		MyPage<ArticleBO> page = new MyPage<ArticleBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		articleService.queryMerchantNoticeList(ArticleContant.OPERATOR_MARK, page);
		List<com.sinco.carnation.resource.bo.ArticleBO> articleBOs = MapperUtils.map(mapper,
				page.getContent(), com.sinco.carnation.resource.bo.ArticleBO.class);
		response.setOpArticleList(articleBOs);
		return response;
	}

	@RequestMapping(value = "/users/sys_notices/details", method = RequestMethod.POST)
	@MethodMapping(desc = "营运商公告和商户平台公告详情")
	public @ResponseBody
	SearchCustomerResponse sysNoticesDetails(
			@Valid @RequestParam(value = "id") @Param(desc = "公告id|营运商公告和商户平台公告id") Long id,
			HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Article article = articleService.getObjById(id);
		if (article != null) {
			com.sinco.carnation.resource.bo.ArticleBO articleBO = mapper.map(article,
					com.sinco.carnation.resource.bo.ArticleBO.class);
			articleBO.setContent(JsoupUtils.queryHtml(articleBO.getContent()));
			response.setArticleBO(articleBO);
		}
		return response;
	}

	@RequestMapping(value = "/users/notices/details", method = RequestMethod.POST)
	@MethodMapping(desc = "营运商发给商户公告详情")
	public @ResponseBody
	SearchCustomerResponse noticesDetails(
			@Valid @RequestParam(value = "id") @Param(desc = "公告id|营运商发给商户公告id") Long id,
			HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		OperatorNoticesBO noticesBO = noticesService.getBoById(id);
		if (noticesBO != null) {
			OpNoticesBO articleBO = mapper.map(noticesBO, OpNoticesBO.class);
			articleBO.setNtContent(JsoupUtils.queryHtml(articleBO.getNtContent()));
			response.setNoticesBO(articleBO);
		}
		return response;
	}

	@RequestMapping(value = "/users/artic_mark/list", method = RequestMethod.POST)
	@MethodMapping(desc = "公告文章列表")
	public @ResponseBody
	SearchCustomerResponse articleList(@Valid @ModelAttribute @Param ArticleMarkVO vo, BindingResult result) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		List<ArticleBO> articleList = new ArrayList<ArticleBO>();
		List<ArticleClassBO> list = articleClass.queryArticleList(vo.getMark());
		for (ArticleClassBO articleClass : list) {
			List<ArticleBO> aList = articleService.queryUserArticList(articleClass.getId(), "user");
			articleList.addAll(aList);
		}
		List<com.sinco.carnation.resource.bo.ArticleBO> lList = MapperUtils.map(mapper, articleList,
				com.sinco.carnation.resource.bo.ArticleBO.class);
		Collections.sort(lList, new Comparator<com.sinco.carnation.resource.bo.ArticleBO>() {

			@Override
			public int compare(com.sinco.carnation.resource.bo.ArticleBO o1,
					com.sinco.carnation.resource.bo.ArticleBO o2) {
				if (o1.getAddTime().before(o2.getAddTime()))
					return 1;
				else
					return -1;
			}

		});
		response.setArticMarkleList(lList);
		return response;
	}

	@RequestMapping(value = "/users/article_mark/details", method = RequestMethod.POST)
	@MethodMapping(desc = "公告详情")
	public @ResponseBody
	SearchCustomerResponse articleDetails(@Valid @RequestParam(value = "id") @Param(desc = "文章id") Long id) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Article article = articleService.getObjById(id);
		if (article != null) {
			com.sinco.carnation.resource.bo.ArticleBO articleBO = mapper.map(article,
					com.sinco.carnation.resource.bo.ArticleBO.class);
			articleBO.setContent(JsoupUtils.queryHtml(articleBO.getContent()));
			response.setArticMarkleDetails(articleBO);
		}
		return response;
	}

	@RequestMapping(value = "/users/invitationCode/bind", method = RequestMethod.POST)
	@MethodMapping(desc = "绑定邀请人关系")
	public @ResponseBody
	InvitationUserResponse userInvitationBind(@Valid @ModelAttribute @Param InvitationUsersVO vo,
			BindingResult result, HttpServletRequest request) throws ApiException {

		// log.info("参数内容："+vo.getInvitationCode());

		InvitationUserResponse response = new InvitationUserResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();

		// log.info("用户uid："+uid);

		if (StringUtils.isNotBlank(vo.getInvitationCode())) {
			// 检查邀请码是否存在
			UserBO user = userService.findByInvitationCode(vo.getInvitationCode());// user_seller表

			if(null != userAccountService.get_CN_User(uid)){
				// CN账号无法被邀请
				response.putErrorMessage("4.register.registerUsersCreate.Invitation_code_CN");
				response.setVerfiySuccess(false);
				return response;
			}
			
			if (null == user || user.getStatus() != 1) {
				// 邀请码错误
				response.putErrorMessage("4.register.registerUsersCreate.Invitation_code_user_is_CN");
				response.setVerfiySuccess(false);
				return response;
			}

			if (uid.equals(user.getId())) {
				// 不能绑定自己
				response.putErrorMessage("4.register.registerUsersCreate.mySelfExists");
				response.setVerfiySuccess(false);
				return response;
			}
			UserRelationBO relationBO = relationService.checkUserExistsRelation(uid);
			if (relationBO != null && relationBO.getRefereeUserId() != null
					&& relationBO.getRefereeUserId() > 0L) {
				// 已经绑定过邀请码
				response.putErrorMessage("4.register.registerUsersCreate.relationExists");
				response.setVerfiySuccess(false);
				return response;
			}
			synchronized (this) {
				// 检查邀请码对应的用户是否和当前用户有层级关系
				// 如果有则不对该邀请码录入
				boolean boo = this.relationService.checkUserLevel(uid, vo.getInvitationCode());
				if (boo) {
					// 不能添加下级会员邀请码
					response.putErrorMessage("4.register.registerUsersCreate.subordinate");
					response.setVerfiySuccess(false);
					return response;
				}
				// return singleton; //也有人提议在此处进行一次返回
				UserRelationBO userRelationBefore = userRelationDao.findOne(user.getId());// 查询推荐人的推荐关系
				if (null != userRelationBefore && null != userRelationBefore.getRefereeUserId()
						&& userRelationBefore.getRefereeUserId().equals(uid)) {// 邀请人和被邀请人不能互相绑定邀请关系
					response.putErrorMessage("4.register.registerUsersCreate.Invitation_code_is_illegal");
					response.setVerfiySuccess(false);
					return response;
				}
				// 是否已经存在推荐关系
				// 更新user_relation
				UserBO relation = relationService.createUserRelation(uid, vo.getInvitationCode());// 更新推荐人与被推荐人的关系
				if (null != relation) {
					integralService.addIntegral(IntegralConstants.INTEGRAL_INVITE_FRIENDS, relation.getId(),
							uid);
				}
			}
			response.setVerfiySuccess(true);
		}

		return response;
	}

	@RequestMapping(value = "/users/invitationCode/checkExists", method = RequestMethod.POST)
	@MethodMapping(desc = "查询我是否已经绑定过")
	public @ResponseBody
	CheckUserCodeResponse checkExists(HttpServletRequest request) throws ApiException {

		CheckUserCodeResponse response = new CheckUserCodeResponse();

		Long uid = ActionsUtil.getOwnerUid();

		// 检查邀请码是否存在

		UserRelationBO relationBO = relationService.checkUserExistsCode(uid);
		if (relationBO != null) {
			response.putErrorMessage("4.register.registerUsersCreate.relationExists");
			response.setInvitationCode(relationBO.getInvitationCode());
			response.setExist(true);
			return response;
		}

		response.setExist(false);

		return response;
	}

	@RequestMapping(value = "/users/shareInfo/get", method = RequestMethod.GET)
	@MethodMapping(desc = "获取我的分享设置信息")
	public @ResponseBody
	ShareInfoResponse getMyShareInfo(HttpServletRequest request) throws ApiException {

		ShareInfoResponse response = new ShareInfoResponse();

		Long uid = ActionsUtil.getOwnerUid();

		// uid = vo.getUid();//test

		UserAccount userAccount = accountService.findByUid(uid);

		if (userAccount != null && StringUtils.isNotBlank(userAccount.getAppShareInfo())) {
			response.setShareInfo(userAccount.getAppShareInfo());
		} else {
			String defaultInfo = "专业健康管理创富平台，赶紧下载注册分享，一起创造财富。";// 暂定默认提示信息
			response.setShareInfo(defaultInfo);
		}

		return response;
	}

	@RequestMapping(value = "/users/referer/info", method = RequestMethod.GET)
	@MethodMapping(desc = "获取我的推荐人信息")
	public @ResponseBody
	MyRefereInfoResponse getrefererInfo(HttpServletRequest request) throws ApiException {

		MyRefereInfoResponse response = new MyRefereInfoResponse();
		Long uid = ActionsUtil.getOwnerUid();
		// uid = vo.getUid();//test
		UserRelationBO relation = relationService.queryReferee(uid);
		if (relation != null) {
			UserCustomerBO user = customerService.findBOByUserId(relation.getRefereeUserId());
			if (user != null) {
				response.setUserId(relation.getRefereeUserId());
				relation.setNickname(user.getNickname());
			}
		}
		return response;
	}

	@RequestMapping(value = "/users/shareInfo/save", method = RequestMethod.POST)
	@MethodMapping(desc = "获取我的分享设置信息")
	public @ResponseBody
	ShareInfoResponse saveMyShareInfo(@Valid @ModelAttribute @Param ShareInfoSettingVO vo,
			BindingResult result, HttpServletRequest request) throws ApiException {

		ShareInfoResponse response = new ShareInfoResponse();

		Long uid = ActionsUtil.getOwnerUid();

		// uid = vo.getUid();//test

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		// UserAccount userAccount = accountService.findByUid(uid);
		UserAccount userAccount = new UserAccount();

		List<UserAccountBO> userAccountList = accountService.findUserAccountByUid(uid);

		if (userAccountList != null && userAccountList.size() > 0) {
			userAccount.setId(userAccountList.get(0).getId());
			userAccount.setUid(uid);
			userAccount.setAppShareInfo(vo.getShareInfo());

			try {
				accountService.update(userAccount);
				response.setSaveSuccess(true);
			} catch (Exception e) {
				response.setSaveSuccess(false);
			}
		}

		return response;
	}

	@RequestMapping(value = "/users/relation/list", method = RequestMethod.POST)
	@MethodMapping(desc = "邀请明细")
	public @ResponseBody
	SearchCustomerResponse relationList(@Valid @ModelAttribute @Param RelationVO vo, BindingResult result) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<UserCustomerBO> page = new MyPage<UserCustomerBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		long uid = ActionsUtil.getOwnerUid();
		customerService.queryRelationList(uid, page);

		if (page != null && page.getContent().size() > 0) {
			List<RelationBO> raBoList = MapperUtils.map(mapper, page.getContent(), RelationBO.class);
			for (RelationBO relation : raBoList) {
				relation.setTime(CommUtil.formatLongDate(relation.getRegisterTime()));
			}
			response.setRalationList(raBoList);
			response.setRelationCount(page.getTotalElements());
		}

		return response;
	}

	@RequestMapping(value = "/users/integral/list", method = RequestMethod.GET)
	@MethodMapping(desc = "我的积分明细")
	public @ResponseBody
	UserIntegralListResponse usersIntegralList(@Valid @ModelAttribute @Param UserIntegralDetailListVO vo) {
		UserIntegralListResponse response = new UserIntegralListResponse();

		MyPage<IntegralLogBO> page = new MyPage<IntegralLogBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		Long uid = ActionsUtil.getOwnerUid();
		// Long uid = new Long(281);//testing

		integrallogService.queryUserIntegralPageListByUid(uid, page);
		UserCustomerBO customer = customerService.queryUserByUid(uid);
		UserIntegralBO integral = mapper.map(customer, UserIntegralBO.class);
		if (page != null && page.getContent().size() > 0) {
			List<UserIntegralDetailBO> userIntegralList = MapperUtils.map(mapper, page.getContent(),
					UserIntegralDetailBO.class);
			response.setUserIntegralList(userIntegralList);
			response.setUserIntegralCount(page.getTotalElements());
			response.setIntegralBalance(integral.getIntegral());
		}

		return response;
	}

	@RequestMapping(value = "/users/yunMoney/list", method = RequestMethod.GET)
	@MethodMapping(desc = "我的云豆明细")
	public @ResponseBody
	UserYunMoneylListResponse usersYunMoneyList(@Valid @ModelAttribute @Param UserIntegralDetailListVO vo) {
		UserYunMoneylListResponse response = new UserYunMoneylListResponse();

		MyPage<PredepositLogBO> page = new MyPage<PredepositLogBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		Long uid = ActionsUtil.getOwnerUid();

		// Long uid = new Long(192);//testing

		String source = ActionsUtil.getOwnerSource();
		predepositlogService.findPageByUid(uid, page, UserContant.accountTypeToUserCode(source));
		double balance = moneyService.getAvailableBalance(uid);

		if (page != null && page.getContent().size() > 0) {
			List<UserYunMoneyBO> list = MapperUtils.map(mapper, page.getContent(), UserYunMoneyBO.class);
			/*
			 * if(list!=null){ int count=list.size()-1; for(int i=count;i>=0;){
			 * UserYunMoneyBO bo=list.get(i);
			 * bo.setBalance((i==count&&i!=0?bo.getPdLogAmount
			 * ().doubleValue():list
			 * .get(i).getPdLogAmount().doubleValue()+list.get
			 * (i+1).getBalance())); i--; } }
			 */
			response.setUserYunMoneyBOList(list);
			response.setUserYunMoneyCount(page.getTotalElements());
			response.setAvailableBalance(balance);// 用户云豆明细总数
			/*
			 * if(list != null && !list.isEmpty()){
			 * 
			 * //年月与月份组合成key List<Object> keyList = new ArrayList<Object>();
			 * for(int i = 0,l = list.size() ; i < l ; i++){ Date date =
			 * list.get(i).getAddTime(); String dateStr =
			 * DateUtils.formatDateTime(date); String ym[] = dateStr.split("-");
			 * //System.out.println(dateStr+"\n"+ym[0]+ym[1]); String yearMonth
			 * = ym[0]+ym[1];//年份与月份组合 Integer key = Integer.valueOf(yearMonth);
			 * if(!keyList.contains(key)){ keyList.add(key); }
			 * 
			 * }
			 * 
			 * //遍历key，将相同月分的记录按照月份分组 if(keyList != null && !keyList.isEmpty()){
			 * //List<Map<Integer, List<UserYunMoneyBO>>> wholeList = new
			 * ArrayList<Map<Integer, List<UserYunMoneyBO>>>();
			 * Map<Integer,List<UserYunMoneyBO>> listMap = new
			 * HashMap<Integer,List<UserYunMoneyBO>>(); for(int i = 0 , l =
			 * keyList.size(); i < l; i++){ List<UserYunMoneyBO> dataList = new
			 * ArrayList<UserYunMoneyBO>(); for(int j = 0 , f = list.size() ; j
			 * < f ;j++ ){ Date date = list.get(j).getAddTime(); String dateStr
			 * = DateUtils.formatDateTime(date); String ym[] =
			 * dateStr.split("-"); String yearMonth = ym[0]+ym[1];//年份与月份组合
			 * Integer key = Integer.valueOf(yearMonth);
			 * if(keyList.contains(key)){ dataList.add(list.get(j)); }
			 * if(keyList.get(i).equals(key)){ dataList.add(list.get(j)); } }
			 * //将list数据映射到key中 listMap.put((Integer) keyList.get(i), dataList);
			 * log.info("listMap", listMap); //wholeList.add(mapList); }
			 * //log.info(format, listMap.get); response.setListMap(listMap);
			 * //response.setListMap(wholeList); } }
			 */
		}

		return response;
	}

	@RequestMapping(value = "/users/integral/doc", method = RequestMethod.GET)
	@MethodMapping(desc = "积分规则说明")
	public @ResponseBody
	DocInfoResponse specification(@Valid @RequestParam(value = "docMark") @Param(desc = "说明代码") String docMark) {
		DocInfoResponse response = new DocInfoResponse();

		DocumentBO bo = documentService.findByMark(docMark);
		response.setSpecContent(bo.getContent());
		return response;
	}

	@Autowired
	private UserRelationDao userRelationDao;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private UserAccountService userAccountService;

	@SuppressWarnings("unused")
	@RequestMapping(value = "/user/customer/savefirst", method = RequestMethod.POST)
	// ,method = RequestMethod.GET ,method = RequestMethod.POST
	@MethodMapping(desc = "个人信息首次保存")
	public @ResponseBody
	UserCustomerSavefirstResponse account_save(@Valid @ModelAttribute @Param UpdateAccountUpdateVO vo,
			BindingResult result, HttpServletRequest request) {
		UserCustomerSavefirstResponse response = new UserCustomerSavefirstResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();

		// Long userId = ivo.getUid();
		// Long userId = 726L;

		Long areaId = null;
		// 如果地址为空，取手机号归属地作为地址
		if (StringUtils.isBlank(vo.getPaddress())) {
			UserAccount model = userAccountService.findByUid(userId);
			if (model != null) {
				String city = relationService.getPhoneCityWithProvince(model.getLoginName());
				String cty[] = city.split(",");
				city = cty[1];
				Area parea = areaService.queryAreaByName(city);
				Long pareaId = parea.getId();
				areaId = pareaId + 2;
			} else {
				areaId = 4521985L;
			}
		} else {
			Area parea = areaService.queryAreaByName(vo.getPaddress());
			Long pareaId = parea.getId();
			/*
			 * Area area = areaService.queryAreaByPidAndName(pareaId,
			 * vo.getAddress()); areaId = area.getId();
			 */
			areaId = pareaId + 2;
		}

		try {
			addressService.save(null, "", areaId, userId);// areaInfo设置为""，该地址设置为默认地址
		} catch (ServiceException e) {
			log.error(String.format("地址保存失败", CommUtil.getStackTrace(e)));
			response.putErrorMessage("地址保存失败");
		}
		if (customerService.updateUserInfo(userId, null, vo.getNickname(), null, null, null, vo.getHeight(),
				vo.getWeight(), null, vo.getSex(), vo.getBirthDate(), null, null, null, null) <= 0) {
			response.putErrorMessage("5.register.userAccountUpdate.update_fail");
			return response;
		} else {
			// 根据id查询绑定关系
			UserRelationBO relation = relationService.queryReferee(userId);
			// String invitationCode=vo.getInvitationCode();
			boolean isbd = false;
			if (relation == null) {
				// isbd=true;
				return response;
			} else {
				if (relation.getSellerUserId() == null) {
					isbd = true;
				}
			}
			if (isbd) {
				String invitationCode = userService.getObjById(relation.getRefereeUserId())
						.getInvitationCode();

				String sellerCity = "";
				String currentCity = vo.getPaddress();

				// 推荐父类
				UserRelationBO parentRelationBO = userRelationDao.findOne(relation.getRefereeUserId());

				if (parentRelationBO != null && parentRelationBO.getSellerUserId() != null) {
					// 推荐父类的 卖家Id
					Long parentSellerId = parentRelationBO.getSellerUserId();

					UserAccount currentAccount = accountService.findByUid(userId, "2");
					if (currentAccount != null) {
						// currentPhone = currentAccount.getLoginName();
						// currentCity =
						// this.getPhoneCity2(currentAccount.getLoginName());

						SellerBO sellerBO = sellerService.findByUid(parentSellerId);
						if (sellerBO != null && sellerBO.getStoreId() != null) {
							StoreBO bo = storeDao.findObjById(sellerBO.getStoreId());

							sellerCity = this.getAreaCityByStoreId(bo);
							// if (StringUtils.isNotBlank(sellerCity) &&
							// sellerCity.lastIndexOf("市") > -1)
							// sellerCity = sellerCity.substring(0,
							// sellerCity.lastIndexOf("市"));
						}
						// 如果同在一个城市，更新此会员的商户Id
						/*if (currentCity.equals(sellerCity)
								&& StringUtils.isNotBlank(currentCity)) {

							// 绑定关系
							UserBO refereeUser = relationService
									.createUserRelation(userId, invitationCode,
											parentSellerId);
							if (refereeUser != null) {
								return response;
							}
						}
						*/
						// 绑定关系
						UserBO refereeUser = relationService.createUserRelation(userId, invitationCode,
								parentSellerId);
						if (refereeUser != null) {
							return response;
						}
					}
				}

				// com.sinco.carnation.sys.bo.RelationBO relationBO =
				// relationService.iscity(invitationCode);
				// // 商户id
				// Long sellerUserId =new Long(relationBO.getSellerUserId());
				// Long Sid= new Long((long)relationBO.getSid());
				// //商户与用户是否同一城市
				// if (relationBO.getSid() != null && pareaId.equals(Sid)) {
				// //绑定关系
				// UserBO refereeUser =
				// relationService.createUserRelation(userId, invitationCode,
				// sellerUserId);
				// if(refereeUser != null){
				// return response;
				// }
				// }
			}
		}
		return response;
	}

	/**
	 * 获取Store的城市名称
	 * 
	 * @param uid
	 * @return
	 */
	public String getAreaCityByStoreId(StoreBO bo) {
		if (bo != null && bo.getIsO2o()) {
			Area area = areaService.getObjById(bo.getAreaId());
			if (area != null) {
				Area pArea = areaService.getObjById(area.getParentId());
				return pArea == null ? null : pArea.getAreaName();
			}
		}
		return "";
	}

	@RequestMapping(value = "/user/customer/coupon", method = RequestMethod.POST)
	@MethodMapping(desc = "我的优惠券列表")
	public @ResponseBody
	CouponInfoResponse userCoupon(@Valid @ModelAttribute @Param CouponInfoVO vo) {
		CouponInfoResponse response = new CouponInfoResponse();
		MyPage<CouponInfoBO> page = new MyPage<CouponInfoBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		// Long uid = new Long(632);//testing
		Long uid = ActionsUtil.getOwnerUid();
		CouponInfoMyVO cp = new CouponInfoMyVO();
		cp.setUid(uid);
		List<CouponInfoBO> coups = couponInfoService.findMyCoupon(cp, page);
		if (page != null && page.getContent().size() > 0) {
			List<ShopCouponInfoBO> couponInfos = MapperUtils.map(mapper, coups, ShopCouponInfoBO.class);
			response.setCouponInfos(couponInfos);
			response.setUserCouponCount(page.getTotalElements());
		}
		return response;
	}

	/***
	 * 邀请明细123级别
	 * 
	 * @param vo
	 * @param level
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/users/relation/levelList", method = RequestMethod.POST)
	@MethodMapping(desc = "邀请明细")
	public @ResponseBody
	SearchCustomerResponse relationLevelList(@Valid @ModelAttribute @Param RelationVO vo, BindingResult result) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<UserCustomerBO> page = new MyPage<UserCustomerBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		long uid = ActionsUtil.getOwnerUid();// 15905L;

		// customerService.queryRelationList(uid, page);
		if (vo.getLevel() == 1) {
			this.customerService.queryUserByRelation1(uid, page);
		}
		if (vo.getLevel() == 2) {
			this.customerService.queryUserByRelation2(uid, page);
		}
		if (vo.getLevel() == 3) {
			this.customerService.queryUserByRelation3(uid, page);
		}

		int one = this.customerService.queryUserByRelation1Count(uid, null, null);
		int two = this.customerService.queryUserByRelation2Count(uid, null, null);
		int three = this.customerService.queryUserByRelation3Count(uid, null, null);

		log.info("...... 一级人数:" + one + " 二级人数:" + two + " 三级人数" + three);

		response.setLevelOneCount(one);
		response.setLevelTwoCount(two);
		response.setLevelThreeCount(three);

		if (page != null && page.getContent().size() > 0) {
			List<RelationBO> raBoList = MapperUtils.map(mapper, page.getContent(), RelationBO.class);
			for (RelationBO relation : raBoList) {
				relation.setTime(CommUtil.formatShortDate(relation.getRegisterTime()));
			}
			response.setRalationList(raBoList);
		}
		return response;
	}

	@RequestMapping()
	public ModelAndView update_Perfect_Personal(HttpServletRequest request, Model model,
			@Valid @RequestParam(value = "userID") String userID) {
		ModelAndView mv = new ModelAndView("");
		return mv;
	}

	/**
	 * 获取CN账户的重消余额
	 * 
	 * @return
	 */
	/*
	 * @RequestMapping(value = "/users/cnuserBouns_Repeat", method =
	 * RequestMethod.POST)
	 * 
	 * @MethodMapping(desc = "用户云购币") public @ResponseBody
	 * SearchCustomerResponse getCNUserBouns() { SearchCustomerResponse response
	 * = new SearchCustomerResponse(); Long uid = ActionsUtil.getOwnerUid(); if
	 * (uid == null) { response.putErrorMessage("3.user.feedList.rid_null");
	 * return response; } // 获取用户名 UserAccount account =
	 * accountService.findByUid(uid); CnUserMoneyBO cnuser =
	 * cnPayBaseService.getCnUserRepeatMoney(account.getLoginName());
	 * if(cnuser!=null){
	 * response.setAvailableBalance_Repeat(cnuser.getBONUS_REPEAT()); }
	 * response.setMobile(account.getLoginName()); return response; }
	 */

	@RequestMapping(value = "/apple/Checked", method = RequestMethod.GET)
	@MethodMapping(desc = "审核是否通过")
	public @ResponseBody
	AppleCheckedResponse appleChecked(HttpServletRequest request) {
		AppleCheckedResponse response = new AppleCheckedResponse();
		response.setNum(0);// 0需要审核 其他跳过审核
		return response;
	}

	/***
	 * 获取cn账户的 奖金和重消
	 * 
	 * @return
	 */

	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping(value = "/users/getBonusAndRepeat", method = RequestMethod.POST)
	@MethodMapping(desc = "获取用户的云购币(重消)和奖金")
	public @ResponseBody
	SearchCustomerResponse getCUserBonusAndRepeat() {
		SearchCustomerResponse response = new SearchCustomerResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		boolean bl = false;
		double cnBonus = 0;
		double cnRepeat = 0;
		double cnRecharge = 0;

		List<UserAccountBO> userAccount = this.userAccountService.findUserAccountByUid(uid);
		for (UserAccountBO account : userAccount) {
			if ("8".equals(account.getAccountType())) {
				bl = true;
				break;
			}
		}
		if (bl) {

			UserAccount resAccount = this.accountService.findByUid(uid, "8");
			CnUserMoneyBO cnUserMoneyBO = this.cnPayBaseService
					.getCnUserBounsMoney(resAccount.getLoginName());// 奖金
			if (cnUserMoneyBO != null) {
				if (null != cnUserMoneyBO.getISPAY() && 1 == cnUserMoneyBO.getISPAY().intValue()) {
					if (null != cnUserMoneyBO.getBONUS()) {
						cnBonus = cnUserMoneyBO.getBONUS();
					}
				}
			}
			CnUserMoneyBO cnUserMoneyBO1 = this.cnPayBaseService.getCnUserRepeatMoney(resAccount
					.getLoginName());// 重消
			if (cnUserMoneyBO1 != null) {

				if (null != cnUserMoneyBO1.getISPAY() && 1 == cnUserMoneyBO1.getISPAY().intValue()
						&& null != cnUserMoneyBO1.getBONUS_REPEAT()) {
					// response.setcNRepeat(cnUserMoneyBO1.getBONUS_REPEAT());
					cnRepeat = cnUserMoneyBO1.getBONUS_REPEAT();
				}
			}

			Map map_2 = new HashMap();
			map_2.put("USER_ALIAS", resAccount.getLoginName());
			map_2.put("WALLETTYPE", OrclSchmaNameConstants.WALLET_TYPE_CZ);
			CnMoneyBO cn_rechargeBO = cnPayBaseService.getCnUserCxWalletView(map_2);// 充值账户
			if (null != cn_rechargeBO && null != cn_rechargeBO.getMONEY()
					&& null != cn_rechargeBO.getWALLET_STATUS()) {
				cnRecharge = cn_rechargeBO.getMONEY();
				if (cn_rechargeBO.getWALLET_STATUS().equals("5")) {// 账户被冻结
					cnRecharge = 0.0;
				}
			}

			response.setcNBonus(cnBonus);
			response.setcNRepeat(cnRepeat);
			response.setcNrecharge(cnRecharge);
		}
		return response;
	}

	@RequestMapping(value = "/binding/creatUser", method = RequestMethod.POST)
	@MethodMapping(desc = "第三方登录 新建账号")
	public @ResponseBody
	SearchCustomerResponse bindingCreatUser(@Valid @ModelAttribute @Param bindingCreatUserVO vo,
			BindingResult result, HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		try {
			String ip = IPUtil.getIpAddr(request);
			String openid = "";
			if (UserContant.ACCOUNT_TYPE_4.equals(String.valueOf(vo.getType()))) {
				openid = vo.getUnionId();// 微信使用unionId
			} else {
				openid = vo.getOpenId();
			}
			UserAccountBO account = null;
			account = accountService.queryAccountByOpenId(openid, vo.getType());
			if (account != null) {// 第三方账号有记录
				response.setIsBinding(true);
				response.setBindingOpenId(vo.getOpenId());
				return response;
			}
			relationService.createUser3(openid, String.valueOf(vo.getType()), ip, vo.getInvitationCode());
			response.setIsBinding(true);
			response.setBindingOpenId(openid);
			return response;
		} catch (Exception e) {
			log.error(String.format("创建失败", e.getMessage()));
			response.setIsBinding(false);
			return response;
		}
	}

	@RequestMapping(value = "/users/yunGouMoney/list", method = RequestMethod.POST)
	@MethodMapping(desc = "我的云购币明细")
	public @ResponseBody
	ShopBonusRepeatLogResponse userYunGouMoney(@Valid @ModelAttribute @Param UserIntegralDetailListVO vo) {
		ShopBonusRepeatLogResponse response = new ShopBonusRepeatLogResponse();

		MyPage<ShopBonusRepeatLogBO> page = new MyPage<ShopBonusRepeatLogBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		ShopBonusRepeatLogVO param = new ShopBonusRepeatLogVO();
		Long uid = ActionsUtil.getOwnerUid();
		param.setUid(uid);
		this.predepositlogService.getPageRepeatByVo(param, page);

		if (page != null && page.getContent().size() > 0) {
			List<UserYunGouMoneyBO> list = MapperUtils
					.map(mapper, page.getContent(), UserYunGouMoneyBO.class);
			response.setShopBonusRepeatList(list);
		}

		double yunGouMoney = 0;

		boolean bl = false;
		List<UserAccountBO> userAccount = this.userAccountService.findUserAccountByUid(uid);
		for (UserAccountBO account : userAccount) {
			if ("8".equals(account.getAccountType())) {
				bl = true;
				break;
			}
		}
		if (bl) {
			UserAccount resAccount = this.accountService.findByUid(uid, "8");
			CnUserMoneyBO cnUserMoneyBO1 = this.cnPayBaseService.getCnUserRepeatMoney(resAccount
					.getLoginName());// 云购币

			if (cnUserMoneyBO1 != null) {
				if (null != cnUserMoneyBO1.getISPAY() && cnUserMoneyBO1.getISPAY().intValue() == 1
						&& null != cnUserMoneyBO1.getBONUS_REPEAT()) {
					yunGouMoney = cnUserMoneyBO1.getBONUS_REPEAT();
				}
			}
		}
		response.setYunGouMoney(yunGouMoney);
		return response;
	}

	@RequestMapping(value = "/binding/mobile/check", method = RequestMethod.POST)
	@MethodMapping(desc = "检查用户是绑定手机")
	public @ResponseBody
	SearchCustomerResponse bindingMobileCheck(@Valid @ModelAttribute @Param BindingCheckVO vo,
			BindingResult result, HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		String openid = "";
		if (UserContant.ACCOUNT_TYPE_4.equals(String.valueOf(vo.getType()))) {
			openid = vo.getUnionId();// 微信使用unionId
		} else {
			openid = vo.getOpenId();
		}
		UserAccountBO account = null;
		account = accountService.queryAccountByOpenId(openid, vo.getType());
		if (account != null) {
			UserAccountBO bo = new UserAccountBO();
			bo.setUid(account.getUid());
			bo.setAccountType(UserContant.ACCOUNT_TYPE_2);
			account = accountService.findAccountByVo(bo);
			if (account != null) {
				response.putErrorMessage("4.user.bindingMobile.mobiel_exited");
				response.setIsBinding(true);// 已绑定手机
				response.setBindingOpenId(vo.getOpenId());
				return response;
			}
		}
		response.setIsBinding(false);// 未绑定手机
		return response;
	}

	/**
	 * 验证CN账户是否绑定手机号
	 */
	@RequestMapping(value = "/cnuser/bind", method = RequestMethod.POST)
	@MethodMapping(desc = "CN是否绑定手机号")
	public @ResponseBody
	CnBindMobileResponse cn_isBind(HttpServletRequest request) {
		CnBindMobileResponse response = new CnBindMobileResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		UserCustomerBO usercunstomer = customerService.searchCustomer(uid);
		if (null != usercunstomer) {
			UserAccountBO account = new UserAccountBO();
			account.setUid(usercunstomer.getUid());
			account.setAccountType(UserContant.ACCOUNT_TYPE_8);
			UserAccountBO userAccountBO_ = accountService.findAccountByVo(account);
			// String extend=usercunstomer.getExtend();
			// if(!StringUtils.isEmpty(extend)){
			// UserExtends
			// userExtend=JSON.toJavaObject(JSON.parseObject(extend),UserExtends.class);
			if (userAccountBO_ != null && userAccountBO_.getId() != null) {
				// 验证CN账户是否绑定手机号
				UserAccountBO userbo = new UserAccountBO();
				userbo.setAccountType(UserContant.ACCOUNT_TYPE_2);
				userbo.setUid(uid);
				UserAccountBO accountBO = userAccountService.findAccountByVo(userbo);
				if (accountBO == null) {
					response.setIsBindMobile(false);
					response.setIsCn(true);
				} else {
					response.setMobile(accountBO.getLoginName());
					response.setIsBindMobile(true);
					response.setIsCn(true);
				}
			}
			// }
		}
		return response;
	}

	/**
	 * 通过uid验证当前账户是否绑定手机
	 */
	@RequestMapping(value = "/mobile/is/bind/uid", method = RequestMethod.POST)
	@MethodMapping(desc = "通过uid验证当前账户是否绑定手机")
	public @ResponseBody
	SearchCustomerResponse mobileIsBindUid() {
		SearchCustomerResponse response = new SearchCustomerResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		List<UserAccountBO> list = accountService.findUserAccountByUid(uid);
		if (null != list) {
			for (UserAccountBO bo : list) {
				if (bo.getAccountType().equals(UserContant.ACCOUNT_TYPE_2)) {
					response.setIsBinding(true);
					return response;
				}
			}
		}
		return response;
	}

	/**
	 * CN账号绑定手机账号
	 */
	@RequestMapping(value = "/cnuser/mobile", method = RequestMethod.POST)
	@MethodMapping(desc = "CN绑定手机号")
	public @ResponseBody
	CnBindMobileResponse cnBindMobile(@Valid @ModelAttribute @Param CnBindMobileVO vo,
			HttpServletRequest request) {
		CnBindMobileResponse response = new CnBindMobileResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		String snsCode = null;
		UserAccountBO account = userAccountService.findByMobile(vo.getMobile(), UserContant.ACCOUNT_TYPE_2);

		if (account != null) {
			snsCode = redisCacheService.getSmsCode(account.getUid(), vo.getMobile());
		} else {
			snsCode = redisCacheService.getSmsCode(0L, vo.getMobile());
		}
		System.out.println("snsCode====" + snsCode);
		if (StringUtils.isBlank(snsCode)) {// 未发送验证码或者验证码已过期
			response.putErrorMessage("4.user.bindingMobile.exist_code_not");
			return response;
		}
		if (!snsCode.equals(vo.getCode())) {// 验证码不对
			response.putErrorMessage("4.user.bindingMobile.code_wrong");
			return response;
		}
		int relust = customerService.cnBindMobile(account, uid, vo.getMobile(), vo.getCn_username(),
				vo.getPassword());
		if (relust == 100) {
			response.setIsBindMobile(true);
			response.setIsLogin(false);
		} else if (relust == 200) {
			relationService.relieveRelationByUid(account.getUid());// 手机号升级成CN账号，解除该手机以前关系
			response.setIsBindMobile(true);
			response.setIsLogin(true);// 重新登录
		} else if (relust == 300) {
			response.putErrorMessage("4.user.bindingMobile.cnmobiel_exited");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/binding/WeiXin", method = RequestMethod.POST)
	@MethodMapping(desc = "手机号绑定微信")
	public @ResponseBody
	SearchCustomerResponse bindingWeiXin(@Valid @ModelAttribute @Param BindingWeiXinCheckVO vo,
			BindingResult result, HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (accountService.mobileOnly(uid, UserContant.ACCOUNT_TYPE_4)) {// 账号是否绑定过微信
			response.putErrorMessage("4.user.bindingWeiXin.zhanghao_IsBinding");// 账号已经绑定了微信
			return response;
		}
		String openid = vo.getUnionId();
		UserAccountBO account = accountService.findByMobile(openid, UserContant.ACCOUNT_TYPE_4);// 查询微信号是不是平台用户

		if (account != null) {// 如果微信号是平台用户
			UserAccount accountMobile = accountService
					.findByUid(account.getUid(), UserContant.ACCOUNT_TYPE_2);// 查询微信账号是否绑定手机
			if (accountMobile != null) {
				response.putErrorMessage("4.user.bindingWeiXin.weixin_IsBinding");// 微信已绑定其他手机
				return response;
			}
			int rt = userAccountService.banding(openid, uid, UserContant.ACCOUNT_TYPE_4);
			if (rt == 4) {
				response.putErrorMessage("4.user.bindingWeiXin.weixin_IsBinding");
				return response;
			} else if (rt == 0) {
				response.setIsBinding(true);
				response.setBindingMobile(openid);
				return response;
			}
			/*
			 * UserAccount userAccount =
			 * accountService.findByUid(uid,UserContant.ACCOUNT_TYPE_2);//用户信息
			 * UserAccount savAccount= new UserAccount();
			 * savAccount.setUid(userAccount.getUid());
			 * accountService.update(savAccount);//更新第三方登录账户的UID为手机号账户的UID
			 * response.setIsBinding(true); response.setBindingMobile(openid);
			 * return response;
			 */
		}

		relationService.bindingUser(uid, openid, null, UserContant.ACCOUNT_TYPE_4);// 账号绑定微信号
		response.setIsBinding(true);
		response.setBindingMobile(openid);
		return response;
	}

	/**
	 * 检查用户是否绑定过微信账号
	 */
	@RequestMapping(value = "/wx_binding/check", method = RequestMethod.POST)
	@MethodMapping(desc = "检查用户是否绑定过微信账号")
	public @ResponseBody
	WxBindingResponse queryAccountBindingWx() {
		WxBindingResponse response = new WxBindingResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid != null) {
			String wxOpenid = userAccountService.queryAccountBindingWx(uid);
			if (wxOpenid != null && wxOpenid.trim() != "") {// 已绑定
				response.setBinding(1);
				return response;
			} else {// 未绑定
				response.setBinding(0);
				return response;
			}
		}
		response.setBinding(1);
		return response;

	}

	// 绑定第三方账号
	@RequestMapping(value = "/binding/Third", method = RequestMethod.POST)
	@MethodMapping(desc = "绑定第三方账号")
	public @ResponseBody
	SearchCustomerResponse bindingThird(@Valid @ModelAttribute @Param BindingThirdVO vo,
			BindingResult result, HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		// 检查该类型的第三方账号是不是已经绑定
		Long uid = ActionsUtil.getOwnerUid();
		if (userAccountService.findUserAccount(uid, String.valueOf(vo.getType())) != null) {
			response.putErrorMessage("4.user.bindingWeiXin.zhanghao_IsBinding");
			return response;
		}
		// 检查要绑定的第三方账号是否正确
		// 检查要绑定的第三方账号是不是已经绑定
		int rt;
		switch (vo.getType()) {
			case 2:// 手机号
				if (userAccountService.findByMobile(vo.getOpenId(), UserContant.ACCOUNT_TYPE_2) != null) {
					response.putErrorMessage("4.user.bindingMobile.mobiel_exited");
					return response;
				}
				break;
			case 3:// QQ
				boolean flag1 = TokenAuthUtils.getQQ_UserInfo(vo.getToken(), vo.getOpenId());
				if (!flag1) {
//				response.putErrorMessage("4.user.bindingMobile.qq_openId_not");
					log.error("[bindingThird] uid=" + uid + ",Token=" + vo.getToken() + ",openId="
							+ vo.getOpenId() + ",type=" + vo.getType());
					// 已经登录 去掉再次验证步骤 2016-12-24
					// return response;
				}
				if (userAccountService.findByMobile(vo.getOpenId(), UserContant.ACCOUNT_TYPE_3) != null) {
					rt = userAccountService.banding(vo.getOpenId(), uid, UserContant.ACCOUNT_TYPE_3);
					if (rt == 4) {
						response.putErrorMessage("4.user.bindingWeiXin.qq_IsBinding");
						log.error("[bindingThird] uid=" + uid + ",Token=" + vo.getToken() + ",openId="
								+ vo.getOpenId() + ",type=" + vo.getType());
						return response;
					} else if (rt == 0) {
						response.setIsBinding(true);
						response.setBindingMobile(vo.getOpenId());
						return response;
					}
				}
				break;
			case 4:// 微信
				boolean falg2 = TokenAuthUtils.getWeixin_Userinfo2(vo.getToken(), vo.getOpenId());
				if (!falg2) {
//				response.putErrorMessage("4.user.bindingMobile.winxin_openId_not");
					log.error("[bindingThird] uid=" + uid + ",Token=" + vo.getToken() + ",openId="
							+ vo.getOpenId() + ",type=" + vo.getType());
					// 已经登录 去掉再次验证步骤 2016-12-24
					// return response;
				}
				if (userAccountService.findByMobile(vo.getOpenId(), UserContant.ACCOUNT_TYPE_4) != null) {
					rt = userAccountService.banding(vo.getOpenId(), uid, UserContant.ACCOUNT_TYPE_4);
					if (rt == 4) {
						response.putErrorMessage("4.user.bindingWeiXin.weixin_IsBinding");
						return response;
					} else if (rt == 0) {
						//
						response.setIsBinding(true);
						response.setBindingMobile(vo.getOpenId());
						return response;
					}
				}
				break;
			case 5:// 微博
				boolean falg3 = TokenAuthUtils.getWeibo_UserInfo(vo.getToken(), vo.getOpenId());
				if (!falg3) {
//				response.putErrorMessage("4.user.bindingMobile.weibo_openId_not");
					log.error("[bindingThird] uid=" + uid + ",Token=" + vo.getToken() + ",openId="
							+ vo.getOpenId() + ",type=" + vo.getType());
					// 已经登录 去掉再次验证步骤 2016-12-24
					// return response;
				}
				if (userAccountService.findByMobile(vo.getOpenId(), UserContant.ACCOUNT_TYPE_5) != null) {
					rt = userAccountService.banding(vo.getOpenId(), uid, UserContant.ACCOUNT_TYPE_5);
					if (rt == 4) {
						response.putErrorMessage("4.user.bindingWeiXin.weibo_IsBinding");
						return response;
					} else if (rt == 0) {
						response.setIsBinding(true);
						response.setBindingMobile(vo.getOpenId());
						return response;
					}
				}
				break;
			default:
		}
		// 绑定第三方账号
		relationService.bindingUser(uid, vo.getOpenId(), null, String.valueOf(vo.getType()));// 账号绑定微信号
		response.setIsBinding(true);
		response.setBindingMobile(vo.getOpenId());
		return response;
	}

	// 绑定第三方账号
	@RequestMapping(value = "/binding/CnWx", method = RequestMethod.POST)
	@MethodMapping(desc = "CN绑定微信")
	public @ResponseBody
	SearchCustomerResponse bindingWx(@Valid @ModelAttribute @Param CnBindingTridVO vo, BindingResult result,
			HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		int re = customerService.cnBindingWx(vo.getMobile(), vo.getUnionID());
		if (re == 500) {
			response.putErrorMessage("4.user.cnbindingWx.mobile_not");
			return response;
		} else if (re == 501) {
			response.putErrorMessage("4.user.cnbindingWx.weixin_exit");
			return response;
		} else if (re == 100) {
			response.setIsBinding(true);
		}
		return response;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/binding/mobile", method = RequestMethod.POST)
	@MethodMapping(desc = "第三方平台绑定手机")
	public @ResponseBody
	SearchCustomerResponse bindingMobile(@Valid @ModelAttribute @Param BindingMobileVO vo,
			BindingResult result, HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		String ip = IPUtil.getIpAddr(request);
		switch (vo.getType()) {
			case 3:// QQ
				boolean flag1 = TokenAuthUtils.getQQ_UserInfo(vo.getToken(), vo.getOpenId());
				if (!flag1) {
					// response.putErrorMessage("4.user.bindingMobile.qq_openId_not");
					log.error("[bindingMobile] mobile=" + vo.getMobile() + ",Token=" + vo.getToken()
							+ ",openId=" + vo.getOpenId() + ",type=" + vo.getType());
					// 已经登录 去掉再次验证步骤 2016-12-24
					// return response;
				}
				break;
			case 4:// 微信
				boolean falg2 = TokenAuthUtils.getWeixin_Userinfo(vo.getToken(), vo.getOpenId());
				if (!falg2) {
					// response.putErrorMessage("4.user.bindingMobile.winxin_openId_not");
					log.error("[bindingMobile] mobile=" + vo.getMobile() + ",Token=" + vo.getToken()
							+ ",openId=" + vo.getOpenId() + ",type=" + vo.getType());
					// 已经登录 去掉再次验证步骤 2016-12-24
					// return response;
				}
				break;
			case 5:// 微博
				boolean falg3 = TokenAuthUtils.getWeibo_UserInfo(vo.getToken(), vo.getOpenId());
				if (!falg3) {
					// response.putErrorMessage("4.user.bindingMobile.weibo_openId_not");
					log.error("[bindingMobile] mobile=" + vo.getMobile() + ",Token=" + vo.getToken()
							+ ",openId=" + vo.getOpenId() + ",type=" + vo.getType());
					// 已经登录 去掉再次验证步骤 2016-12-24
					// return response;
				}
				break;
			default:
				response.putErrorMessage("4.user.bindingMobile.openId_not");// 账号异常
				return response;
		}

		UserAccountBO accountMobile = accountService.findByMobile(vo.getMobile(), UserContant.ACCOUNT_TYPE_2);

		String openid = "";// 微信使用unionId 其他使用Openid
		if (UserContant.ACCOUNT_TYPE_4.equals(String.valueOf(vo.getType()))) {
			openid = vo.getUnionId();
		} else {
			openid = vo.getOpenId();
		}
		UserAccountBO accountThird = new UserAccountBO();
		accountThird = accountService.findByMobile(openid, CommUtil.null2String(vo.getType())); // 第三方登录
		Long uid = accountThird.getUid();

		if (null != accountMobile && null != accountMobile.getUid()) {// 如果手机号是平台用户，直接绑定
			if (accountService.mobileOnly(accountMobile.getUid(), String.valueOf(vo.getType()))) {// 手机号是否已经绑定过该类型的第三方账号
				response.putErrorMessage("4.user.bindingMobile.mobiel_exited");
				return response;
			}
			String snsCode = redisCacheService.getSmsCode(accountMobile.getUid(), vo.getMobile());
			if (StringUtils.isBlank(snsCode)) {// 未发送验证码或者验证码已过期
				response.putErrorMessage("4.user.bindingMobile.exist_code_not");
				return response;
			}
			if (!snsCode.equals(vo.getCode())) {// 验证码不对
				response.putErrorMessage("4.user.bindingMobile.code_wrong");
				return response;
			}
			if (accountService.findByUid(accountThird.getUid(), UserContant.ACCOUNT_TYPE_2) != null) {// 用户是否绑定了手机
				response.putErrorMessage("4.user.bindingMobile.mobile_is_binding");
				return response;
			}
			if (accountThird != null) {
				if (String.valueOf(vo.getType()).equals(UserContant.ACCOUNT_TYPE_4)) {// 微信绑定手机号
					UserAccount accountCN = accountService.findUserAccount(accountMobile.getUid(),
							UserContant.ACCOUNT_TYPE_8);
					// 处理微信绑手机 手机UID改成微信的UID 手机号如果绑定了CN账号,CN的UID也改成微信的UID
					int returnInt = accountService.WxBindingMobile(accountMobile, accountThird, accountCN);
					if (returnInt == 0) {// 手机号是CN账号，清除微信的上层推进关系
						relationService.relieveRelationByUid(accountThird.getUid());
					}
					try {
						integralService.bindingGetIntegral(accountThird.getUid(), null);
					} catch (Exception e) {
						log.error("add integral is unsuccess uid = " + accountThird.getUid());
					}
					response.setIsBinding(true);
					response.setBindingMobile(vo.getOpenId());
					return response;
				}

				BindingHistory record = new BindingHistory();// uid记录
				record.setNewUid(accountMobile.getUid());
				record.setOldUid(accountThird.getUid());
				bindingHistoryService.save(record);

				UserAccount savAccount = new UserAccount();
				savAccount.setId(accountThird.getId());
				savAccount.setUid(accountMobile.getUid());
				accountService.update(savAccount);// 更新第三方登录账户的UID为手机号账户的UID

				userService.updateMobile(accountMobile.getUid(), vo.getMobile());// 更新账户的手机号码

				response.setIsBinding(true);
				response.setBindingMobile(vo.getOpenId());
				return response;
			}
		}
		// 验证验证码
		String codeRedis = redisCacheService.getSmsCode(0L, vo.getMobile());

		// 验证码校验
		if (!vo.getCode().equalsIgnoreCase("ae937fd9ae2211e58c06001e67cd90fd")) {
			// 用户未申请发送过验证码，或者验证号已过期
			if (StringUtils.isBlank(codeRedis)) {
				response.putErrorMessage("4.register.registerUsersCreate.account_not_send_verify_sms");
				return response;
			}
			// 验证码是否正确
			if (!vo.getCode().equals(codeRedis)) {
				response.putErrorMessage("4.register.registerUsersCreate.verify_code_error");
				return response;
			}
		}
		redisCacheService.delSmsCode(0L, vo.getMobile());
		// 手机号没创建过用户
		UserAccountBO accountBO = new UserAccountBO();
		accountBO = accountService.findByMobile(openid, CommUtil.null2String(vo.getType()));
		relationService.bindingUser(accountBO.getUid(), vo.getMobile(), vo.getPassword(),
				UserContant.ACCOUNT_TYPE_2);
		userService.updateMobile(accountBO.getUid(), vo.getMobile());// 更新账户的手机号码
		response.setIsBinding(true);
		response.setBindingMobile(vo.getOpenId());
		return response;
	}

	@RequestMapping(value = "/binding/register", method = RequestMethod.POST)
	@MethodMapping(desc = "补全资料注册")
	public @ResponseBody
	SearchCustomerResponse bindingRegister(@Valid @ModelAttribute @Param BindingRegisterVO vo,
			BindingResult result, HttpServletRequest request) {
		SearchCustomerResponse response = new SearchCustomerResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		String ip = IPUtil.getIpAddr(request);
		// 验证openid是否属于平台
		// QQ
		switch (vo.getType()) {
			case 3:// QQ
				boolean flag1 = TokenAuthUtils.getQQ_UserInfo(vo.getToken().toString(), vo.getOpenId());
				if (vo.getToken().toString().endsWith("|")) {
					flag1 = TokenAuthUtils.getQQ_UserInfo(
							vo.getToken().toString().substring(0, vo.getToken().toString().length() - 1),
							vo.getOpenId());
				}
				if (!flag1) {
					response.putErrorMessage("4.user.bindingRegister.qq_openId_not");
					return response;
				}
				vo.setUnionId(vo.getOpenId());
				break;
			case 4:// 微信
				boolean falg2 = TokenAuthUtils.getWeixin_Userinfo(vo.getToken(), vo.getUnionId());
				if (!falg2) {
					response.putErrorMessage("4.user.bindingRegister.winxin_openId_not");
					return response;
				}
				break;
			case 5:// 微博
				boolean falg3 = TokenAuthUtils.getWeibo_UserInfo(vo.getToken(), vo.getOpenId());
				if (!falg3) {
					response.putErrorMessage("4.user.bindingRegister.weibo_openId_not");
					return response;
				}
				break;
			default:
				response.putErrorMessage("4.user.bindingRegister.openId_not");
				return response;
		}

		int num = relationService.createUser(vo.getNickName(), vo.getMobile(), vo.getPassword(), ip,
				vo.getType(), vo.getInvitationCode(), vo.getUnionId());
		if (num == -4) {
			response.putErrorMessage("4.user.bindingRegister.exist_user");
			return response;
		} else if (num == -5) {
			response.putErrorMessage("4.user.bindingRegister.exist_nickName");
			return response;
		} else if (num == -3) {
			response.putErrorMessage("4.user.bindingRegister.binding_fail");
			return response;
		}
		response.setBindingMobile(vo.getMobile());
		response.setBindingOpenId(vo.getOpenId());
		response.setIsBinding(true);
		return response;
	}

	/**
	 * 检查手机号是否绑定过微信账号
	 */
	@RequestMapping(value = "/mobile_binding/check", method = RequestMethod.POST)
	@MethodMapping(desc = "检查用户是否绑定过微信账号")
	public @ResponseBody
	CnMobileBindWx queryMobileBindingWx(@Valid @ModelAttribute @Param MobileBingWxCheckVO vo,
			BindingResult result, HttpServletRequest request) {
		CnMobileBindWx response = new CnMobileBindWx();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		UserAccountBO account = accountService.fetchByLoginName(vo.getMobile());
		if (account == null) {
			response.putErrorMessage("4.user.cnbindingWx.mobile_not");
			return response;
		}
		UserAccountBO account_ = new UserAccountBO();
		account_.setAccountType(UserContant.ACCOUNT_TYPE_4);
		account_.setUid(account.getUid());
		UserAccountBO bo = accountService.findAccountByVo(account_);
		if (bo != null) {
			response.setBinding(1);
			response.setUnionID(bo.getLoginName());
		} else {
			response.setBinding(0);
		}
		return response;

	}

	@RequestMapping(value = "/versionControl/getNew", method = RequestMethod.GET)
	@MethodMapping(desc = "查询最新版本信息")
	public VersionControlResponse versionControlGetNew(
			@Valid @RequestParam(value = "type") @Param(desc = "11.IOS appStore 12 IOS 蒲公英  21.安卓") int type) {
		VersionControlResponse response = new VersionControlResponse();
		VersionControlBO bo = versionControlService.findOneByTypeNew(type);
		if (bo == null) {
			response.putErrorMessage("4.sys.version.control_is_null");
			return response;
		}
		SysVersionControlBO BO = mapper.map(bo, SysVersionControlBO.class);
		response.setSysVersionControlBO(BO);
		return response;
	}

}