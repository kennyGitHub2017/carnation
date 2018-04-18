package com.sinco.carnation.resource.web.actions.o2o;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Maps;
import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.ShopQrPayOrderService;
import com.sinco.carnation.pay.service.PredepositCashService;
import com.sinco.carnation.rebate.service.RebateRecordService;
import com.sinco.carnation.rebate.service.RebateStatisService;
import com.sinco.carnation.resource.bo.o2o.OperatorAmountBO;
import com.sinco.carnation.resource.bo.o2o.OperatorRegisterUserListBO;
import com.sinco.carnation.resource.bo.o2o.OperatorRelationBO;
import com.sinco.carnation.resource.bo.operator.CashMoneyDetailsBO;
import com.sinco.carnation.resource.bo.operator.OperatorInfoBO;
import com.sinco.carnation.resource.bo.operator.OperatorManagementBO;
import com.sinco.carnation.resource.bo.operator.OperatorMemberBO;
import com.sinco.carnation.resource.bo.operator.OperatorProfitListBO;
import com.sinco.carnation.resource.vo.check.CheckReportVO;
import com.sinco.carnation.resource.vo.o2o.CommonVO;
import com.sinco.carnation.resource.vo.o2o.OperatorProfitVO;
import com.sinco.carnation.resource.vo.o2o.OperatorVO;
import com.sinco.carnation.resource.vo.operator.CashMoneyVO;
import com.sinco.carnation.resource.vo.operator.OperatorCashMoneyVO;
import com.sinco.carnation.resource.vo.operator.OperatorManageMentVO;
import com.sinco.carnation.resource.vo.operator.OperatorMemberVO;
import com.sinco.carnation.resource.vo.operator.UserCloudVO;
import com.sinco.carnation.resource.vo.register.PasswordUpdateVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.base.BaseResponse;
import com.sinco.carnation.resource.web.response.operator.OperatorResponse;
import com.sinco.carnation.resource.web.response.register.PasswordUpdateResponse;
import com.sinco.carnation.resource.web.util.DateUtils;
import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.vo.PredepositCashVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.bo.orcl.CnUserLevelBO;
import com.sinco.carnation.sys.contants.OperatorContants;
import com.sinco.carnation.sys.contants.OrclUserContants;
import com.sinco.carnation.sys.contants.RebateStatisContant;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.RebateRecordBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.bo.UserMoneyBO;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.model.Operator;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.OrclUserBaseService;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.StatisticsService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.carnation.user.vo.RebateRecordVO;
import com.sinco.carnation.user.vo.UserCustomerVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dal.utils.DateCalendar;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "o2o运营商", namespace = "operator")
public class ApiOperatorAction extends BasicApiController {

	@Autowired
	private OperatorService operatorService;
	@Autowired
	private UserMoneyService moneyService;
	@Autowired
	private PredepositCashService cashService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private UserMoneyService userMoneyService;
	@Autowired
	private RebateRecordService rebateService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRelationService relationService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private Mapper mapper;
	@Autowired
	private GroupOrderService groupOrderServer;
	@Autowired
	private StatisticsService statisticsService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private UserAccountService accountService;
	@Autowired
	private OrclUserBaseService orclUserBaseService;
	@Autowired
	private RedisCacheService redisCacheService;
	@Autowired
	private RebateStatisService rebateStatisService;
	@Autowired
	private ShopQrPayOrderService shopQrPayOrderService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/operator/invitation_code/get", method = RequestMethod.POST)
	@MethodMapping(desc = "获取运营商邀请码")
	public @ResponseBody
	OperatorResponse operatorInfoGet() {
		OperatorResponse response = new OperatorResponse();
		Long uid = ActionsUtil.getOwnerUid();

		UserBO user = userService.getObjById(uid);
		if (user != null) {
			response.setInvitationCode(user.getInvitationCode());
		}
		return response;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/operator/money/cash", method = RequestMethod.POST)
	@MethodMapping(desc = "营运商提现")
	public @ResponseBody
	OperatorResponse cashMoney(@Valid @ModelAttribute @Param OperatorCashMoneyVO vo, BindingResult result,
			HttpServletRequest request) {
		OperatorResponse response = new OperatorResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		if(vo == null || null == vo.getMoney() ||vo.getMoney()<=0){
			response.putErrorMessage("4.operator.cashMoney.money_error");
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		String source = ActionsUtil.getOwnerSource();
		OperatorBO op = operatorService.getOperatorBOByUserId(uid);
		if (op != null) {
			PredepositCashVO cashVo = new PredepositCashVO();
			cashVo.setCashAccount(op.getBankNo());
			cashVo.setCashAmount(vo.getMoney());
			cashVo.setCashBank(op.getBankName());
			cashVo.setCashPassword(vo.getPassword());
			cashVo.setCashPayment(op.getUserName());
			cashVo.setCashPayment("chinabank");// 网银在线

			try {
				String num = moneyService.userCashApplyV2(uid, cashVo, source);
			} catch (ServiceException e) {
				Map<String, String> param = Maps.newHashMap();
				param.put("msg", e.getErrorCode());
				response.putErrorMessage("");
				return response;
			}
		}
		return response;
	}

	@RequestMapping(value = "/operator/cash_money/details", method = RequestMethod.POST)
	@MethodMapping(desc = "营运商提现明细")
	public @ResponseBody
	OperatorResponse cashMoneyDetails(@Valid @ModelAttribute @Param CashMoneyVO vo, BindingResult result,
			HttpServletRequest request) {
		OperatorResponse response = new OperatorResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<PredepositCashBO> page = new MyPage<PredepositCashBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		com.sinco.carnation.user.vo.OperatorVO operatorVO = new com.sinco.carnation.user.vo.OperatorVO();
		Long uid = ActionsUtil.getOwnerUid();

		cashService.queryByUserId(uid, operatorVO, page);

		if (page != null) {
			List<CashMoneyDetailsBO> list = MapperUtils.map(mapper, page.getContent(),
					CashMoneyDetailsBO.class);
			response.setCashMoneyDetailsBOs(list);
		}

		return response;
	}

	@RequestMapping(value = "/operator/member/list", method = RequestMethod.POST)
	@MethodMapping(desc = "营运商隶属会员")
	public @ResponseBody
	OperatorResponse operatorMember(@Valid @ModelAttribute @Param OperatorMemberVO vo, BindingResult result,
			HttpServletRequest request) {
		OperatorResponse response = new OperatorResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<UserCustomerBO> page = new MyPage<UserCustomerBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		Long uid = ActionsUtil.getOwnerUid();
		OperatorBO op = operatorService.getOperatorBOByUserId(uid);
		if (op != null) {
			UserCustomerVO vo1 = new UserCustomerVO();
			vo1.setOperatorUserId(op.getUserId());
			vo1.setOperatorId(op.getId());
			vo1.setUserLevel(op.getLevel());
			vo1.setOperatorAreaId(op.getOperatorAreaId());

			customerService.queryUserCustomerByOperatorUserId(vo1, page);
			if (page != null) {
				List<OperatorMemberBO> memberList = MapperUtils.map(mapper, page.getContent(),
						OperatorMemberBO.class);
				for (OperatorMemberBO operator : memberList) {
					if (operator.getRelationType() == 0) {
						operator.setRelationName("邀请码");
					} else if (operator.getRelationType() == 1) {
						operator.setRelationName("首次消费");
					}
				}
				response.setMemberList(memberList);
			}

		}
		return response;
	}

	@RequestMapping(value = "/operator/info/get", method = RequestMethod.POST)
	@MethodMapping(desc = "营运商基本信息")
	public @ResponseBody
	OperatorResponse operatorInfo() {
		OperatorResponse response = new OperatorResponse();
		Long uid = ActionsUtil.getOwnerUid();
		boolean isCN = this.userAccountService.check_User_Is_CN(uid);
		// CN账户获取基本信息前的检验
		if (isCN) {
			response.setIsCN(isCN); // 是否为CN账户
			UserAccount cn_userAccount = this.userAccountService.get_CN_User(uid);
			String loginName = cn_userAccount.getLoginName();

			OperatorBO operator = this.operatorService.queryOperatorByLoginName(loginName);
			if (operator == null || operator.getId() == null) {
				response.putErrorMessage("4.operator.OperatorUser.no_exist");
				return response;
			}
			// 更新运营商等级
			try {
				operatorService.updateCnLevel(loginName);// 每次登陆更新CN运营商等级信息
				logger.info("[updateCnLevel] cnName=" + loginName);
			} catch (Exception e) {
				logger.error("can't [updateCnLevel] cnName=" + loginName + e);
			}

			CnUserLevelBO cn = orclUserBaseService.getOrclUserLevel(operator.getCn_username());
			OperatorInfoBO operatorInfo = new OperatorInfoBO();
			if (null == cn || null == cn.getUserType() || "" == cn.getUserType()) {
				operatorInfo.setLevelName("当前用户无对应级别");
			} else {
				String userType = cn.getUserType();
				String levelName = "";
				if (OrclUserContants.OPERATOR_LEVEL_SILVER.equals(userType)) {
					levelName = "银卡用户";
				} else if (OrclUserContants.OPERATOR_LEVEL_GOLD.equals(userType)) {
					levelName = "金卡用户";
				} else if (OrclUserContants.OPERATOR_LEVEL_VIP.equals(userType)) {
					levelName = "VIP用户";
				}
				operatorInfo.setLevelName(levelName);
			}
			response.setOperatorInfo(operatorInfo);
			// 身份证为必填项 CN账户在APP或PC首次登陆时系统会为CN账户初始化YY账户 初始化时 身份证号未空
			String idCard = operator.getIdCard();
			if (idCard == null || idCard.trim().length() == 0) // 首次登陆
			{
				response.setIsFirst(true);
				return response;
			} else {
				response.setIsFirst(false);
			}
		} else {
			response.setIsCN(isCN);
		}
		OperatorBO operatorBO = operatorService.getOperatorBOByUserId(uid);
		if (null == operatorBO.getAddress()) {
			operatorBO.setAddress("");
		}
		UserBO operatorUser = userService.getObjById(operatorBO.getUserId());
		UserRelationBO relation = relationService.getUserRelation(operatorBO.getUserId());
		if (operatorBO != null) {
			// 检查当前运营商是否已经审核
			// 0=审核中，1=审核通过，-1=审核不通过
			String auditStatus = operatorBO.getStatus();
			response.setSuditAtatus(auditStatus);
			/*if(!"1".equals(auditStatus))
			{
				return response;
			}*/
			OperatorInfoBO operator = mapper.map(operatorBO, OperatorInfoBO.class);
			String refereeName = "";
			if (relation != null && null != relation.getRefereeUserId()) {
				Long refereeUserId = relation.getRefereeUserId();
				UserCustomer userCustomer = customerService.findById(refereeUserId);
				if (userCustomer == null) {
					OperatorBO refereeOper = operatorService.getOperatorBOByUserId(refereeUserId);
					if (refereeOper != null) {
						refereeName = refereeOper.getOperatorName();
					}
				} else {
					refereeName = userCustomer.getNickname();
				}
			}
			operator.setLevelName(OperatorContants.OPERATOR_LEVEL_NAME_9);
			if (operatorBO.getLevel() != null) {
				// 设置营运商级别名称
				if (operatorBO.getLevel().equals(OperatorContants.OPERATOR_LEVEL_1)) {
					operator.setLevelName(OperatorContants.OPERATOR_LEVEL_NAME_1);
				} else if (operatorBO.getLevel().equals(OperatorContants.OPERATOR_LEVEL_2)) {
					operator.setLevelName(OperatorContants.OPERATOR_LEVEL_NAME_2);
				} else if (operatorBO.getLevel().equals(OperatorContants.OPERATOR_LEVEL_3)) {
					operator.setLevelName(OperatorContants.OPERATOR_LEVEL_NAME_3);
				} else if (operatorBO.getLevel().equals(OperatorContants.OPERATOR_LEVEL_7)) {
					operator.setLevelName(OperatorContants.OPERATOR_LEVEL_NAME_7);
				}
			}
			// 设置推荐人名字
			// operator.setRegistrationPath(refereeName);
			operator.setRefereeName(refereeName);
			String fullName = areaService.isFullName(CommUtil.null2Long(operator.getOperatorAreaId()));
			operator.setArea(fullName);
			// 设置邀请码
			if (operatorUser != null) {
				operator.setInvitationCode(operatorUser.getInvitationCode());
			}

			int inviteNumber = 0;
			/*relationService.queryRefereeUserCount(userId,
			null, null);*/

			// 实时查询写到缓存，1小时更新一次
			String levelCount = this.redisCacheService.getUserLevelCount(uid);
			if (levelCount == null) {
				int resultUserLevelCount = this.relationService.queryRefereeUserCount(uid);
				if (resultUserLevelCount > 0) {
					// 缓存有效期
					int miao = 3600;// com.sinco.carnation.resource.web.util.DateUtils.getMiao();
									// //当前时间距离24时还有多少秒
					logger.info("......... cache seconds = " + miao + " hours:" + (miao / 60 / 60));
					// 缓存统计数据
					this.redisCacheService.setUserLevelCount(uid, String.valueOf(resultUserLevelCount), miao);
					inviteNumber = resultUserLevelCount;
				}
			} else {
				inviteNumber = Integer.valueOf(levelCount);
			}
			// o2o收益
			Map<String, Object> o2oResultMap = rebateStatisService.getUserRebateStatis(uid, null, null, "a",
					"0");
			// b2c收益
			Map<String, Object> b2cResultMap = rebateStatisService.getUserRebateStatis(uid, null, null, "a",
					"1");
			// 收益金额
			DecimalFormat df = new DecimalFormat("0.00");
			double o2oTotalAmount = Double.valueOf(df.format(CommUtil.null2Double(o2oResultMap.get("sum"))));// 取值，非空，保留两位小数，转为double
			double b2cTotalAmount = Double.valueOf(df.format(CommUtil.null2Double(b2cResultMap.get("sum"))));
			double totalAmount = b2cTotalAmount + o2oTotalAmount;

			// 邀请人数
			operator.setInviteNumber(inviteNumber);
			// 收益金额
			operator.setO2oTotalAmount(o2oTotalAmount);
			operator.setB2cTotalAmount(b2cTotalAmount);
			operator.setTotalAmount(totalAmount);
			// 新增会员
			Map<String, Object> mapResult2 = statisticsService.getOperatorRelationStatistics(operatorBO, "1");
			operator.setTodayVipNumber(CommUtil.null2Int(mapResult2.get("rcCount")));
			response.setOperatorInfo(operator);
		}
		// response.setOperatorInfo(operator);
		return response;
	}

	@RequestMapping(value = "/operator/password/update", method = RequestMethod.POST)
	@MethodMapping(desc = "修改云豆密码")
	public @ResponseBody
	OperatorResponse updatePassword(@Valid @ModelAttribute @Param UserCloudVO vo, BindingResult result,
			HttpServletRequest request) {
		OperatorResponse response = new OperatorResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		// 检查用户是否为CN账户
		boolean isCN = this.userAccountService.check_User_Is_CN(uid);
		if (isCN) {
			// CN账户不能修改云豆密码
			response.putErrorMessage("4.operator.updatePassword.user_is_cn_on_updateYun");
			return response;
		}
		UserMoneyBO moneyBO = moneyService.findUserMoneyByUid(uid);
		if (moneyBO != null) {
			// 验证旧密码
			if (!moneyService.validatePassword(uid, vo.getOldPassword())) {
				response.putErrorMessage("4.operator.updatePassword.oldpassword_fail");
				return response;
			}
			if (!moneyService.updatePassword(uid, vo.getNewPassword())) {
				response.putErrorMessage("4.operator.updatePassword.password_update_fail");
				return response;
			}
		}
		return response;
	}

	@RequestMapping(value = "/operator/profit/list", method = RequestMethod.POST)
	@MethodMapping(desc = "收益流水")
	public @ResponseBody
	OperatorResponse profitOperator(@Valid @ModelAttribute @Param OperatorMemberVO vo, BindingResult result,
			HttpServletRequest request) {
		OperatorResponse response = new OperatorResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();

		MyPage<RebateRecordBO> page = new MyPage<RebateRecordBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		rebateService.queryOperatorProfitList(uid, null,null,page);

		if (page != null) {
			List<OperatorProfitListBO> list = MapperUtils.map(mapper, page.getContent(),
					OperatorProfitListBO.class);
			for (OperatorProfitListBO operator : list) {
				if (StringUtils.isNotBlank(operator.getRebateType())) {
					operator.setRebateTypeName(RebateConstants.getRebateNameByType(operator.getRebateType()));
				}
			}
			response.setOperatorList(list);
		}

		return response;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/operator/business_management/list", method = RequestMethod.POST)
	@MethodMapping(desc = "商户管理")
	public @ResponseBody
	OperatorResponse businessManagement(@Valid @ModelAttribute @Param OperatorManageMentVO vo,
			BindingResult result, HttpServletRequest request) {
		OperatorResponse response = new OperatorResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();

		MyPage<StoreBO> page = new MyPage<StoreBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		OperatorBO operatorBO = operatorService.queryOperatorInfo(uid);
		StoreVO vo1 = new StoreVO();
		vo1.setOperatorId(operatorBO.getId());
		vo1.setOperatorUserId(uid);
		int level = 3;
		if (CommUtil.null2Int(operatorBO.getLevel()) == 1 || CommUtil.null2Int(operatorBO.getLevel()) == 2) {
			level = CommUtil.null2Int(operatorBO.getLevel());
		}
		vo1.setLevel(level);
		vo1.setIsBeLong(vo.getIsBeLong());
		vo1.setOperatorAreaId(CommUtil.null2Long(operatorBO.getOperatorAreaId()));
		if (vo.getTimeType() != null) {
			setTime(vo1, vo.getTimeType());
		}

		storeService.queryBusinessPageList(vo1, page);

		if (page != null) {
			List<OperatorManagementBO> operatorList = MapperUtils.map(mapper, page.getContent(),
					OperatorManagementBO.class);
			for (OperatorManagementBO operator : operatorList) {
				if (operator.getRebateConsumeAmount() == null) {
					operator.setRebateConsumeAmount(BigDecimal.ZERO);
				}
				if (operator.getRebateFeeAmount() == null) {
					operator.setRebateFeeAmount(BigDecimal.ZERO);
				}
				// 设置分润总额 手续费返润 + 商户返润 2017-1-11 返润全部设置为商户总返润
//				operator.setRebateTotal(operator.getRebateConsumeAmount().add(operator.getRebateFeeAmount()));
//				//app现在用的字段是这个，为了不发版本，直接把值给这个字段
//				operator.setRebateConsumeAmount(operator.getRebateConsumeAmount().add(operator.getRebateFeeAmount()));
				// 设置分润总额 手续费返润 + 商户返润
				operator.setRebateTotal(operator.getRebateFeeAmount());
				// app现在用的字段是这个，为了不发版本，直接把值给这个字段
				operator.setRebateConsumeAmount(operator.getRebateFeeAmount());
				// 设置总交易额
				BigDecimal onLine = groupOrderServer.queryOnLineTotalPrice(operator.getStoreId(),
						vo1.getStartTime(), vo1.getEndTime());// 券销售总额 代金券+套餐券
				BigDecimal line = groupOrderServer.queryLineTotalPrice(operator.getStoreId(),
						vo1.getStartTime(), vo1.getEndTime());// 卡销售总额
				BigDecimal saoMa = new BigDecimal(0);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
				Date start = null;
				Date end = null;
				try {
					start = sdf.parse(vo1.getStartTime());
					end = sdf.parse(vo1.getEndTime());
				} catch (Exception e) {
					// TODO: handle exception
				}
//				saoMa = shopQrPayOrderService.findAllPaySuccessMoneyBySellerId(operator.getUid(), start,  end);//扫码总额
				if (onLine == null) {
					onLine = BigDecimal.ZERO;
				}
				if (line == null) {
					line = BigDecimal.ZERO;
				}
				if (saoMa == null) {
					saoMa = BigDecimal.ZERO;
				}
				operator.setTradingTotal(onLine.add(line).add(saoMa));
			}
			response.setOperatorRebateList(operatorList);
		}
		return response;
	}

	public void setTime(StoreVO vo, Integer type) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式

		if (type == 1) {// 一周
			// 当前日期的周日
			vo.setStartTime(sdf.format(DateUtils.getSundayOfWeek(new Date())));
			// 当前日期的周六
			vo.setEndTime(sdf.format(DateUtils.getMondayOfWeek(new Date())));
		} else if (type == 2) {// 一月
			// 当月的第一天
			vo.setStartTime(sdf.format(DateUtils.getFirstDateOfMonth(new Date())));
			// 当月的最后一天
			vo.setEndTime(sdf.format(DateUtils.getLastDateOfMonth(new Date())));
		} else if (type == 3) {// 一季
			// 当季度的第一天
			vo.setStartTime(sdf.format(DateUtils.getFirstDateOfSeason(new Date())));
			// 当季度的最后一天
			vo.setEndTime(sdf.format(DateUtils.getLastDateOfSeason(new Date())));
		} else if (type == 4) {// 一年
			// 当年度的第一天
			vo.setStartTime(sdf.format(DateUtils.getCurrYearFirst()));
			// 当年度的最后一天
			vo.setEndTime(sdf.format(DateUtils.getCurrYearLast()));
		}
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/operator/profit_statis/list", method = RequestMethod.POST)
	@MethodMapping(desc = "收益统计")
	public @ResponseBody
	OperatorResponse profitStatistics(@Valid @ModelAttribute @Param OperatorProfitVO vo,
			BindingResult result, HttpServletRequest request) {
		OperatorResponse response = new OperatorResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		String level = "9";// 默认为 银卡
		OperatorBO operator = operatorService.queryOperatorInfo(uid);
		if (operator == null) {
			response.putErrorMessage("4.user.usersSearchCustomer.no_data");
			return response;
		}
		if (null != operator.getLevel()) {
			level = operator.getLevel();
		}
		if (null == vo.getType()) {
			vo.setType("a");
		}
		OperatorAmountBO operatorAmountBO = new OperatorAmountBO();
		double b2cAmountSum = 0.00; // 辖区内会员商城购物分润
		double b2cUploadProductAmount = 0.00; // 上传产品分润
		double b2cRcdUploadProductAmount = 0.00;// 推荐上传分润
		double b2cRcdJdcAmount = 0.00;// 推荐辖区分润
		double b2cGroupRegistAmount = 0.00;// 商户注册分润
		double b2cSignGroupAmount = 0.00;// 签约商户分润
		double b2cRcdSignAmount = 0.00;// 推荐签约分润
		double b2cRegistMemberAmount = 0.00;// B2C注册会员分润
		double b2cRegistShareAmount = 0.00;// B2C分享注册分润
		double b2cOperateRegistMemberAmount = 0.00;// 运营注册会员分润
		double b2cRcdOperateRegistMemberAmount = 0.00;// 推荐运营注册分润

		double O2OJdcManageAmount = 0.00;// 市/区级辖区管理分润
		double O2OJdcGroupAmount = 0.00; // 市/区级辖区服务分润
		double O2OJdcRcdManageAmount = 0.00;// 推荐辖区管理分润
		double O2OJdcRcdGroupAmount = 0.00;// 推荐辖区服务分润
		double O2OSignGroupManageAmount = 0.00;// 签约商户管理分润
		double O2OSignGroupGroupAmount = 0.00;// 签约商户服务分润
		double O2ORcdSignManageAmount = 0.00;// 推荐签约管理分润
		double O2ORcdSignGroupAmount = 0.00;// 推荐签约服务分润
		double O2ORegistMemberAmount = 0.00;// 注册会员分润
		double O2ORegistShareAmount = 0.00;// 分享注册分润
		double O2OOperateRegistMemberAmount = 0.00;// 运营注册会员分润
		double O2ORcdOperateRegistMemberAmount = 0.00;// 推荐运营注册分润
		double sum = 0.00;

		// 数据查询
		if (vo.getQueryType().equals("t")) {// 今日即时统计
			Date date = new Date();
			Date startTime = DateCalendar.getStartTimeByThisTime(date);
			Date endTime = DateCalendar.getEndTimeByThisTime(date);
			String type = "0";
			if (vo.getType().equals("0")) {// o2o即时统计
//				RebateStatisContant
				O2OJdcManageAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.O2OJdcManageAmount, startTime, endTime, type));// 市/区级辖区管理分润
																							// 会员绑定市/区运营商订单分润
																							// ---管理：会员绑定商户隶属运营商
																							// 辖区：消费地运营商获益
				O2OJdcGroupAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.O2OJdcGroupAmount, startTime, endTime, type)); // 市/区级辖区服务分润
																							// 会员消费市/区级运营商订单分润
				O2OJdcRcdManageAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.O2OJdcRcdManageAmount, startTime, endTime, type));// 推荐辖区管理分润
																								// 会员绑定市运营商1层关系订单分润+会员绑定区域运营商1层关系订单分润
				O2OJdcRcdGroupAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.O2OJdcRcdGroupAmount, startTime, endTime, type));// 推荐辖区服务分润
																								// 会员消费市级运营商1层关系订单分润+会员消费区域运营商1层关系订单分润
				O2OSignGroupManageAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(
						uid, RebateStatisContant.O2OSignGroupManageAmount, startTime, endTime, type));// 签约商户管理分润
																										// 签约商户管理分润
				O2OSignGroupGroupAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(
						uid, RebateStatisContant.O2OSignGroupGroupAmount, startTime, endTime, type));// 签约商户服务分润
																										// 签约商户服务分润
				O2ORcdSignManageAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.O2ORcdSignManageAmount, startTime, endTime, type));// 推荐签约管理分润
																								// 推荐签约管理分润1+推荐签约管理分润2
				O2ORcdSignGroupAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.O2ORcdSignGroupAmount, startTime, endTime, type));// 推荐签约服务分润
																								// 推荐签约服务分润1+推荐签约服务分润2
				O2ORegistMemberAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.O2ORegistMemberAmount, startTime, endTime, type));// 注册会员分润 注册会员分润
				O2ORegistShareAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.O2ORegistShareAmount, startTime, endTime, type));// 分享注册分润
																								// 分享注册分润1+分享注册分润2
				O2OOperateRegistMemberAmount = CommUtil.null2Double(statisticsService
						.selectSumByTypeAndUserId(uid, RebateStatisContant.O2OOperateRegistMemberAmount,
								startTime, endTime, type));// 运营注册会员分润 运营注册会员分润
				O2ORcdOperateRegistMemberAmount = CommUtil.null2Double(statisticsService
						.selectSumByTypeAndUserId(uid, RebateStatisContant.O2ORcdOperateRegistMemberAmount,
								startTime, endTime, type));// 推荐运营注册分润 推荐运营注册分润1+推荐运营注册分润2
			} else {// b2c即时统计
				type = "1";
				b2cAmountSum = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.b2cAmountSum, startTime, endTime, type)); // 辖区内会员商城购物分润
																						// 会员绑定区域运营商订单分润
				b2cUploadProductAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.b2cUploadProductAmount, startTime, endTime, type)); // 上传产品分润
																								// 上传产品分润
				b2cRcdUploadProductAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(
						uid, RebateStatisContant.b2cRcdUploadProductAmount, startTime, endTime, type));// 推荐上传分润
																										// 推荐上传分润1+推荐上传分润2
				b2cRcdJdcAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.b2cRcdJdcAmount, startTime, endTime, type));// 推荐辖区分润
																						// 会员绑定市运营商1层关系订单分润+会员绑定区域运营商1层关系订单分润
				b2cGroupRegistAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.b2cGroupRegistAmount, startTime, endTime, type));// 商户注册分润 商户注册分润
				b2cSignGroupAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.b2cSignGroupAmount, startTime, endTime, type));// 签约商户分润 签约商户管理分润
				b2cRcdSignAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.b2cRcdSignAmount, startTime, endTime, type));// 推荐签约分润
																							// 推荐签约管理分润1+推荐签约管理分润2
				b2cRegistMemberAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.b2cRegistMemberAmount, startTime, endTime, type));// B2C注册会员分润
																								// 注册会员分润
				b2cRegistShareAmount = CommUtil.null2Double(statisticsService.selectSumByTypeAndUserId(uid,
						RebateStatisContant.b2cRegistShareAmount, startTime, endTime, type));// B2C分享注册分润
																								// 分享注册分润1+分享注册分润2
				b2cOperateRegistMemberAmount = CommUtil.null2Double(statisticsService
						.selectSumByTypeAndUserId(uid, RebateStatisContant.b2cOperateRegistMemberAmount,
								startTime, endTime, type));// 运营注册会员分润 运营注册会员分润
				b2cRcdOperateRegistMemberAmount = CommUtil.null2Double(statisticsService
						.selectSumByTypeAndUserId(uid, RebateStatisContant.b2cRcdOperateRegistMemberAmount,
								startTime, endTime, type));// 推荐运营注册分润 推荐运营注册分润1+推荐运营注册分润2
			}
		} else {// 其他时间段 收益统计表统计
			Map<String, Object> resultMap = rebateStatisService.getUserRebateStatis(uid, vo.getStartTime(),
					vo.getEndTime(), vo.getQueryType(), vo.getType());
			if (resultMap != null) {
				b2cAmountSum = CommUtil.null2Double(resultMap.get("b2CAmountSum")); // 辖区内会员商城购物分润
				b2cUploadProductAmount = CommUtil.null2Double(resultMap.get("b2CupAmount")); // 上传产品分润
				b2cRcdUploadProductAmount = CommUtil.null2Double(resultMap.get("b2CrupAmount"));// 推荐上传分润
				b2cRcdJdcAmount = CommUtil.null2Double(resultMap.get("b2CrjAmount"));// 推荐辖区分润
				b2cGroupRegistAmount = CommUtil.null2Double(resultMap.get("b2CgrAmount"));// 商户注册分润
				b2cSignGroupAmount = CommUtil.null2Double(resultMap.get("b2CsgAmount"));// 签约商户分润
				b2cRcdSignAmount = CommUtil.null2Double(resultMap.get("b2crsCAmount"));// 推荐签约分润
				b2cRegistMemberAmount = CommUtil.null2Double(resultMap.get("b2CrmAmount"));// B2C注册会员分润
				b2cRegistShareAmount = CommUtil.null2Double(resultMap.get("b2CrsAmount"));// B2C分享注册分润
				b2cOperateRegistMemberAmount = CommUtil.null2Double(resultMap.get("b2CormAmount"));// 运营注册会员分润
				b2cRcdOperateRegistMemberAmount = CommUtil.null2Double(resultMap.get("b2CrormAmount"));// 推荐运营注册分润

				O2OJdcManageAmount = CommUtil.null2Double(resultMap.get("o2OjmAmount"));// 市/区级辖区管理分润
				O2OJdcGroupAmount = CommUtil.null2Double(resultMap.get("o2OjgAmount")); // 市/区级辖区服务分润
				O2OJdcRcdManageAmount = CommUtil.null2Double(resultMap.get("o2OjrmAmount"));// 推荐辖区管理分润
				O2OJdcRcdGroupAmount = CommUtil.null2Double(resultMap.get("o2OjrgAmount"));// 推荐辖区服务分润
				O2OSignGroupManageAmount = CommUtil.null2Double(resultMap.get("o2OsgmAmount"));// 签约商户管理分润
				O2OSignGroupGroupAmount = CommUtil.null2Double(resultMap.get("o2OsggAmount"));// 签约商户服务分润
				O2ORcdSignManageAmount = CommUtil.null2Double(resultMap.get("o2OrsmAmount"));// 推荐签约管理分润
				O2ORcdSignGroupAmount = CommUtil.null2Double(resultMap.get("o2OrsgAmount"));// 推荐签约服务分润
				O2ORegistMemberAmount = CommUtil.null2Double(resultMap.get("o2OrmAmount"));// 注册会员分润
				O2ORegistShareAmount = CommUtil.null2Double(resultMap.get("o2OrsAmount"));// 分享注册分润
				O2OOperateRegistMemberAmount = CommUtil.null2Double(resultMap.get("o2OormAmount"));// 运营注册会员分润
				O2ORcdOperateRegistMemberAmount = CommUtil.null2Double(resultMap.get("o2OrormAmount"));// 推荐运营注册分润
			}
		}

		if (vo.getType().equals("0")) {// O2O
			sum = O2OJdcManageAmount + O2OJdcGroupAmount + O2OJdcRcdManageAmount + O2OJdcRcdGroupAmount
					+ O2OSignGroupManageAmount + O2OSignGroupGroupAmount + O2ORcdSignManageAmount
					+ O2ORcdSignGroupAmount + O2ORegistMemberAmount + O2ORegistShareAmount
					+ O2OOperateRegistMemberAmount + O2ORcdOperateRegistMemberAmount;
		} else {
			sum = b2cAmountSum + b2cUploadProductAmount + b2cRcdUploadProductAmount + b2cRcdJdcAmount
					+ b2cGroupRegistAmount + b2cSignGroupAmount + b2cRcdSignAmount + b2cRegistMemberAmount
					+ b2cRegistShareAmount + b2cOperateRegistMemberAmount + b2cRcdOperateRegistMemberAmount;
		}
		DecimalFormat df = new DecimalFormat("0.00");
		// 保留两位小数
		operatorAmountBO.setB2CUploadProductAmount(Double.valueOf(df.format(b2cUploadProductAmount)));// 上传产品分润
		operatorAmountBO.setB2CRcdUploadProductAmount(Double.valueOf(df.format(b2cRcdUploadProductAmount)));// 推荐上传分润
		operatorAmountBO.setB2CRcdJdcAmount(Double.valueOf(df.format(b2cRcdJdcAmount)));// 推荐辖区分润
		operatorAmountBO.setB2CGroupRegistAmount(Double.valueOf(df.format(b2cGroupRegistAmount)));// 商户注册分润
		operatorAmountBO.setB2CSignGroupAmount(Double.valueOf(df.format(b2cSignGroupAmount)));// 签约商户分润
		operatorAmountBO.setB2CRcdSignAmount(Double.valueOf(df.format(b2cRcdSignAmount)));// 推荐签约分润
		operatorAmountBO.setB2CRegistMemberAmount(Double.valueOf(df.format(b2cRegistMemberAmount)));// B2C注册会员分润
		operatorAmountBO.setB2CRegistShareAmount(Double.valueOf(df.format(b2cRegistShareAmount)));// B2C分享注册分润
		operatorAmountBO.setB2COperateRegistMemberAmount(Double.valueOf(df
				.format(b2cOperateRegistMemberAmount)));// 运营注册会员分润
		operatorAmountBO.setB2CRcdOperateRegistMemberAmount(Double.valueOf(df
				.format(b2cRcdOperateRegistMemberAmount)));// 推荐运营注册分润
		operatorAmountBO.setB2CAmountSum(Double.valueOf(df.format(b2cAmountSum)));// 市/区级分润

		operatorAmountBO.setO2OJdcManageAmount(Double.valueOf(df.format(O2OJdcManageAmount)));// 市/区级辖区管理分润
		operatorAmountBO.setO2OJdcGroupAmount(Double.valueOf(df.format(O2OJdcGroupAmount)));// 市/区级辖区服务分润
		operatorAmountBO.setO2OJdcRcdManageAmount(Double.valueOf(df.format(O2OJdcRcdManageAmount)));// 推荐辖区管理分润
		operatorAmountBO.setO2OJdcRcdGroupAmount(Double.valueOf(df.format(O2OJdcRcdGroupAmount)));// 推荐辖区服务分润
		operatorAmountBO.setO2OSignGroupManageAmount(Double.valueOf(df.format(O2OSignGroupManageAmount)));// 签约商户管理分润
		operatorAmountBO.setO2OSignGroupGroupAmount(Double.valueOf(df.format(O2OSignGroupGroupAmount)));// 签约商户服务分润
		operatorAmountBO.setO2ORcdSignManageAmount(Double.valueOf(df.format(O2ORcdSignManageAmount)));// 推荐签约管理分润
		operatorAmountBO.setO2ORcdSignGroupAmount(Double.valueOf(df.format(O2ORcdSignGroupAmount)));// 推荐签约服务分润
		operatorAmountBO.setO2ORegistMemberAmount(Double.valueOf(df.format(O2ORegistMemberAmount)));// 注册会员分润
		operatorAmountBO.setO2ORegistShareAmount(Double.valueOf(df.format(O2ORegistShareAmount)));// 分享注册分润
		operatorAmountBO.setO2OOperateRegistMemberAmount(Double.valueOf(df
				.format(O2OOperateRegistMemberAmount)));// 运营注册会员分润
		operatorAmountBO.setO2ORcdOperateRegistMemberAmount(Double.valueOf(df
				.format(O2ORcdOperateRegistMemberAmount)));// 推荐运营注册分润
		operatorAmountBO.setAmountMoney(Double.valueOf(df.format(sum)));// 总计

		response.setOperatorAmountBO(operatorAmountBO);
		return response;
	}

	@RequestMapping(value = "/operator/statis_relation/list", method = RequestMethod.POST)
	@MethodMapping(desc = "关系统计")
	public @ResponseBody
	OperatorResponse statisticsRelation() {
		OperatorResponse response = new OperatorResponse();
		Long uid = ActionsUtil.getOwnerUid();
		OperatorBO operator = operatorService.queryOperatorInfo(uid);
		if (operator == null) {
			return response;
		}
		Map<String, Object> mapResult = statisticsService.getOperatorRelationStatistics(operator, null);
		OperatorRelationBO relation = new OperatorRelationBO();
		if (mapResult != null) {
			// 注册运营商
			relation.setOperatorRegisterCount(CommUtil.null2Int(mapResult.get("roCount")));
			// 注册的商户
//			relation.setStoreRegisterCount(CommUtil.null2Int(mapResult.get("rsCount")));
			// 注册的商户
			relation.setStoreRegisterCount(CommUtil.null2Int(mapResult.get("osCount")));
			// 注册的供应商
			relation.setGoodsRegisterCount(CommUtil.null2Int(mapResult.get("rgsCount")));
			// 注册的会员
			relation.setUserRegisterCount(CommUtil.null2Int(mapResult.get("rcCount")));
			// 辖区运营商 ----不需要
			relation.setAreaOperatorCount(CommUtil.null2Int(mapResult.get("ooCount")));
			// 隶属的商户 ----不需要
			relation.setMembershipCount(CommUtil.null2Int(mapResult.get("osCount")));
			// 隶属商户的会员 ----不需要
			relation.setMembershipUserCount(CommUtil.null2Int(mapResult.get("ocCount")));
			// 商户注册会员
			relation.setStoreRegisterUserCount(CommUtil.null2Int(mapResult.get("sruCount")));
			// 团体注册会员
			relation.setCnRegisterUserCount(CommUtil.null2Int(mapResult.get("cnRegistCount")));
			// 团体商户注册会员
			relation.setCnStoreRegisterUserCount(CommUtil.null2Int(mapResult.get("cnRegistShopRegistCount")));
		}
		Map<String, Object> mapResult2 = statisticsService.getOperatorRelationStatistics(operator, "1");
		OperatorRelationBO todayOperatorRelation = new OperatorRelationBO();
		if (mapResult2 != null) {
			// 今日新增
			// 注册运营商
			todayOperatorRelation.setOperatorRegisterCount(CommUtil.null2Int(mapResult2.get("roCount")));
			// 注册的商户
//			todayOperatorRelation.setStoreRegisterCount(CommUtil.null2Int(mapResult2.get("rsCount")));
			todayOperatorRelation.setStoreRegisterCount(CommUtil.null2Int(mapResult2.get("osCount")));
			// 注册的商户
			todayOperatorRelation.setGoodsRegisterCount(CommUtil.null2Int(mapResult2.get("rgsCount")));
			// 注册的会员
			todayOperatorRelation.setUserRegisterCount(CommUtil.null2Int(mapResult2.get("rcCount")));
			// 辖区运营商 ----不需要
			todayOperatorRelation.setAreaOperatorCount(CommUtil.null2Int(mapResult2.get("ooCount")));
			// 隶属的商户 ----不需要
			todayOperatorRelation.setMembershipCount(CommUtil.null2Int(mapResult2.get("osCount")));
			// 隶属商户的会员 ----不需要
			todayOperatorRelation.setMembershipUserCount(CommUtil.null2Int(mapResult2.get("ocCount")));
			// 商户注册会员
			todayOperatorRelation.setStoreRegisterUserCount(CommUtil.null2Int(mapResult2.get("sruCount")));
			// 团体注册会员
			todayOperatorRelation.setCnRegisterUserCount(CommUtil.null2Int(mapResult2.get("cnRegistCount")));
			// 团体商户注册会员
			todayOperatorRelation.setCnStoreRegisterUserCount(CommUtil.null2Int(mapResult2
					.get("cnRegistShopRegistCount")));
		}
		response.setOperatorRelation(relation);
		response.setTodayOperatorRelation(todayOperatorRelation);
		return response;
	}

	@RequestMapping(value = "/operator/register/list", method = RequestMethod.POST)
	@MethodMapping(desc = "营运商注册会员")
	public @ResponseBody
	OperatorResponse registerUserList(@Valid @ModelAttribute @Param CheckReportVO vo, BindingResult result) {
		OperatorResponse response = new OperatorResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<UserCustomerBO> page = new MyPage<UserCustomerBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		Long uid = ActionsUtil.getOwnerUid();
		OperatorBO operator = operatorService.queryOperatorInfo(uid);
		if (operator != null) {
			UserCustomerVO vo1 = new UserCustomerVO();
			vo1.setOperatorUserId(operator.getUserId());
			vo1.setOperatorAreaId(operator.getOperatorAreaId());
			customerService.selectUserCustomerByOperatorUserId(vo1, page);
			// customerService.selectOwnCustomerByOperatorUserId(vo1, page);
			List<OperatorRegisterUserListBO> list = new ArrayList<OperatorRegisterUserListBO>();
			for (UserCustomerBO customer : page.getContent()) {
				OperatorRegisterUserListBO operatorRegister = new OperatorRegisterUserListBO();
				operatorRegister.setId(customer.getId());
				operatorRegister.setNickname(customer.getNickname());
				// operatorRegister.setStoreName(customer.getStoreName());
				if (customer.getOperator() != null) {
					operatorRegister.setAreaName(customer.getOperator().getAreaName());
					operatorRegister.setOperatorCode(customer.getOperator().getInvitationCode());
					operatorRegister.setOperatorName(customer.getOperator().getOperatorName());
				}
				operatorRegister.setSellerNickName(customer.getSellerNickName());
				operatorRegister.setCreateTime(customer.getCreateTime());
				list.add(operatorRegister);
			}
			response.setOperatorRegisterList(list);
		}
		return response;
	}

	@RequestMapping(value = "/operator/expect_profit/list", method = RequestMethod.POST)
	@MethodMapping(desc = "预期收益")
	public @ResponseBody
	OperatorResponse expectProfit(@Valid @ModelAttribute @Param CommonVO vo, BindingResult result) {
		OperatorResponse response = new OperatorResponse();
		long uid = ActionsUtil.getOwnerUid();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<RebateRecordBO> page = new MyPage<RebateRecordBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		RebateRecordVO rebateRecordVO = new RebateRecordVO();
		//rebateRecordVO.setGroup(true);
		//rebateRecordVO.setUserType("operator");
		rebateService.selectOperatorRebateRecordList(uid, RebateConstants.REBATE_STATUS_0, rebateRecordVO,
				page);
		List<OperatorProfitListBO> list = MapperUtils.map(mapper, page.getContent(),
				OperatorProfitListBO.class);
		BigDecimal totalExpectProfit = rebateService.selectOperatorRebateRecordTotal(uid,
				RebateConstants.REBATE_STATUS_0);
//		Calendar start = Calendar.getInstance();
//		start.setTime(new Date());
//		start.add(Calendar.MONTH, 1);
//		start.set(Calendar.DAY_OF_MONTH, 28);
		for (OperatorProfitListBO operator : list) {
			if (StringUtils.isNotBlank(operator.getRebateType())) {
				operator.setRebateTypeName(RebateConstants.getRebateNameByType(operator.getRebateType()));
				// 收益时间改成交易时间
//				operator.setCreateTime(start.getTime());
			}
		}
		response.setExpectProfitTotal(totalExpectProfit);// 预期收益总额
		response.setExpectProfit(list);
		return response;
	}

	@RequestMapping(value = "/operator/isCN", method = RequestMethod.POST)
	@MethodMapping(desc = "判断用是否为CN账户")
	public @ResponseBody
	OperatorResponse checkUserIsCN() {
		OperatorResponse response = new OperatorResponse();
		Long uid = ActionsUtil.getOwnerUid();
		boolean isCN = this.userAccountService.check_User_Is_CN(uid);
		logger.info("<<<<<<<<<< isCN->" + isCN);
		response.setIsCN(isCN);
		return response;
	}

	@SuppressWarnings("null")
	@RequestMapping(value = "/operator/saveCNOperatorUserInfo", method = RequestMethod.POST)
	@MethodMapping(desc = "CN账户完善个人信息")
	public @ResponseBody
	BaseResponse save_CN_OperatorUser_Info(@Valid @ModelAttribute @Param OperatorVO vo) {
		System.out.println("test========" + vo.getBankName() + "2222" + vo.getNation() + "333"
				+ vo.getSubBankName() + "444" + vo.getUserName());
		BaseResponse res = new BaseResponse();
		Long uid = ActionsUtil.getOwnerUid();
		UserAccount cn_userAccount = this.userAccountService.get_CN_User(uid);
		String result = "succ";
		String content = "操作成功";
		if (cn_userAccount != null) {
			String loginName = cn_userAccount.getLoginName();
			OperatorBO operator = this.operatorService.queryOperatorByLoginName(loginName);
			if (operator == null) {
				result = "fail";
				content = "无当前运营商数据";
			} else {
				Operator updateOperator = new Operator();
				updateOperator.setStatus(UserContants.OPERATOR_CHECK_STATUS_CHECKING); // 未审核
				/*String userName = "";
				String nation = "";
				String bankName = "";
				String subBankName = "";*/
				/*try 
				{
					resquest.getParameter("userName");
					userName = new String(vo.getUserName().getBytes("ISO-8859-1"),"UTF-8");
					nation = new String(vo.getNation().getBytes("ISO-8859-1"),"UTF-8");
					bankName = new String(vo.getBankName().getBytes("ISO-8859-1"),"UTF-8");
					subBankName = new String(vo.getSubBankName().getBytes("ISO-8859-1"),"UTF-8");
				} 
				catch (UnsupportedEncodingException e)
				{
					logger.error(e.getMessage());
				}*/
				updateOperator.setUserName(vo.getUserName());
				updateOperator.setSex(vo.getSex());
				updateOperator.setPhone(vo.getPhone());
				updateOperator.setIdCard(vo.getIdCard());
				updateOperator.setNation(vo.getNation());
				updateOperator.setOperatorAreaId(vo.getOperatorAreaId());
				updateOperator.setBankName(vo.getBankName());
				updateOperator.setSubBankName(vo.getSubBankName());
				updateOperator.setBankNo(vo.getBankNo());
				updateOperator.setIdCard(vo.getIdCard());
				updateOperator.setId(operator.getId());
				updateOperator.setUpdateTime(new Date());
				updateOperator.setIsDeleted(false);
				String level = OperatorContants.OPERATOR_LEVEL_9;
				CnUserLevelBO cn = orclUserBaseService.getOrclUserLevel(operator.getCn_username());
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
				updateOperator.setLevel(level);
				this.operatorService.update(updateOperator);

				OperatorBO operatorBO = operatorService.getOperatorBOByIdAndStatus(operator.getId(),
						UserContants.OPERATOR_CHECK_STATUS_CHECKING);
				operatorService.checkOperator(operatorBO, String.valueOf(operator.getUserId()));
			}
		} else {
			result = "fail";
			content = "当前用户不存在";
		}
		res.setResult(result);
		res.setContent(content);
		return res;
	}

	@RequestMapping(value = "/operator/updateLoginPwd", method = RequestMethod.POST)
	@MethodMapping(desc = "修改运营商登陆密码")
	public @ResponseBody
	PasswordUpdateResponse update_Operator_User_Pwd(@Valid @ModelAttribute @Param PasswordUpdateVO vo,
			BindingResult result, HttpServletRequest request) {

		PasswordUpdateResponse response = new PasswordUpdateResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();
		boolean isCN = this.userAccountService.check_User_Is_CN(userId);
		if (isCN) // 不支持CN用户修改运营商系统登陆密码
		{
			response.putErrorMessage("4.operator.updatePassword.user_is_cn");
			return response;
		}
		UserAccount account = this.accountService.findByUid(userId);
		if (!PasswordUtils.validatePassword(vo.getOdlPassword(), account.getPassword())) {
			response.putErrorMessage("5.user.usersPassWordUpdate.odl_password_fail");
			return response;
		}
		if (accountService.passwordUpdate(userId, vo.getNewPassword()) < 0) {
			response.putErrorMessage("5.user.usersPassWordUpdate.update_fail");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/operator/regMemberOther", method = RequestMethod.POST)
	@MethodMapping(desc = "为他注册会员")
	public @ResponseBody
	BaseResponse reg_member_other(HttpServletRequest request, HttpServletResponse response,
			@Param String storeID) {
		logger.info("===================== 为他注册会员 ================ ");
		// String storeID = request.getParameter("storeID");
		logger.info("<<<<<<<< storeID->" + storeID);
		BaseResponse response_ = new BaseResponse();
		String res = "succ";
		String content = "操作成功";
		if (storeID == null || storeID.trim().length() == 0) {
			response_.setResult("fail");
			response_.setContent("参数有误");
			return response_;
		}
		Long userId = ActionsUtil.getOwnerUid();// ActionsUtil.getOwnerUid();//ActionsUtil.getOwnerUid();16012L;

		OperatorBO operatorBO = operatorService.queryOperatorInfo(userId);
		long operatorID = operatorBO.getId();
		long storeID_ = Long.valueOf(storeID);
		boolean isSub = this.operatorService.check_SubMerchant(operatorID, storeID_);
		if (isSub) // 隶属关系
		{
			this.operatorService.reg_member_other_update(operatorID, storeID_);
		} else {
			res = "fali";
			content = "操作失败";
		}
		response_.setResult(res);
		response_.setContent(content);
		return response_;
	}
}
