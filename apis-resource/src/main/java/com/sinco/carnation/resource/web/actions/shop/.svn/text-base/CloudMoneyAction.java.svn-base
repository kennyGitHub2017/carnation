package com.sinco.carnation.resource.web.actions.shop;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositCashService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.resource.bo.paymet.WeiXinPaymetBO;
import com.sinco.carnation.resource.bo.shop.CloudPredepositCashBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.shop.CloudPredepositCashVO;
import com.sinco.carnation.resource.vo.shop.PredepositVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.shop.CloudMoneyResponse;
import com.sinco.carnation.resource.web.response.shop.ShopTradePaymetResponse;
import com.sinco.carnation.resource.web.response.user.MoneyFreePoundageResponse;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.shop.vo.PredepositCashVO;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.UserMoneyBO;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.common.utils.IPUtil;
import com.weixin.utils.Signature;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "云豆交易API", namespace = "cloud_buyer")
public class CloudMoneyAction extends BasicApiController {
	
	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(CloudMoneyAction.class);
	
	@Autowired
	private OrderFormTools ofTools;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PredepositService predepositService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private PayTools payTools;

	@Autowired
	private UserMoneyService userMoneyService;

	@Autowired
	private UserAccountService accountService;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private RedisCacheService redisCacheService;

	@Autowired
	private PredepositCashService predepositCashService;

	@Autowired
	private Mapper mapper;

	@RequestMapping(value = "/cloud/buyer/paymet", method = RequestMethod.POST)
	@MethodMapping(desc = "云豆订单支付")
	public @ResponseBody
	ShopTradePaymetResponse cloudBuyerPaymet(HttpServletRequest request,
			@Valid @ModelAttribute @Param PredepositVO vo) {

		ShopTradePaymetResponse responses = new ShopTradePaymetResponse();

		// 错误信息
		Map<String, String> errorParam = new HashMap<>();

		try {
			Long uid = ActionsUtil.getOwnerUid();
			// WebForm wf = new WebForm();
			Predeposit obj = new Predeposit(); // wf.toPo(request, Predeposit.class);
			obj.setId(vo.getId());
			obj.setPdAmount(vo.getPdAmount());
			obj.setPdPayment(vo.getPdPayment());
			if (vo.getId() == null) {
				if (PaymentConstants.PAYMENT_MARK_OUTLINE.equals(vo.getPdPayment())) {
					obj.setPdPayStatus(UserContants.PD_PAY_STATUS_1);
				} else {
					obj.setPdPayStatus(UserContants.PD_PAY_STATUS_0);
				}
				obj.setPdPayment(vo.getPdPayment());
				obj.setPdUserId(uid);
			} else {
				obj.setId(CommUtil.null2Long(vo.getId()));
			}

			Long predepositId = this.predepositService.save(obj, uid);
			responses.setPredepositId(predepositId);

			SysConfigBO config = configService.getSysConfig();
			// 支付类型是否为空
			if (vo.getPdPayment() == null || "".equals(vo.getPdPayment())) {
				errorParam.put("param", "支付类型不能为空");
				responses.putErrorMessage(MsgCodeConstant.ERROR_PARAM, errorParam);
				return responses;
			} else {

				Predeposit pr = predepositService.getObjById(obj.getId());

				// 找云豆充值记录上的支付方式
				PaymentBO payment = this.paymentService.findByMark(pr.getPdPayment());
				String type = PaymentConstants.ORDER_TYPE_CASH;

				String paySignature = payTools.appPay(config.getAddress(), payment.getId().toString(), type,
						obj.getId().toString());

				if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(payment.getMark())) {
					responses.setWeiXinPaymet(makeWeixinPaymet(payment, paySignature));
				} else if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(payment.getMark())) {
					responses.setPaySignature(paySignature);
				}
				responses.setPaymetType(payment.getMark());

				return responses;
			}
		} catch (Exception e) {
			errorParam.put("msg", "云豆充值异常");
			responses.putErrorMessage("4.cloud_trade.tradePaymet.failure", errorParam);
		}

		return responses;
	}

	@RequestMapping(value = "/cloud/buyer/status", method = RequestMethod.POST)
	@MethodMapping(desc = "云豆充值状态")
	public @ResponseBody
	ShopTradePaymetResponse cloudBuyerStatus(HttpServletRequest request,
			@Valid @RequestParam(value = "id") @Param(desc = "云豆充值id") Long id) {
		ShopTradePaymetResponse responses = new ShopTradePaymetResponse();
		responses.setIsCompletePay(false);
		// 错误信息
		Map<String, String> errorParam = new HashMap<>();
		Predeposit pr = predepositService.getObjById(id);
		Integer status = (pr != null ? pr.getPdPayStatus() : null);
		if (pr == null) {
			errorParam.put("param", "云豆订单不存在!");
			responses.putErrorMessage(MsgCodeConstant.ERROR_PARAM, errorParam);
		}
		if (status == null) {
			errorParam.put("param", "云豆充值状态异常!");
			responses.putErrorMessage(MsgCodeConstant.ERROR_PARAM, errorParam);
		} else if (status == 0 || status == 1) {
			errorParam.put("param", "云豆充值待支付!");
			responses.putErrorMessage(MsgCodeConstant.ERROR_PARAM, errorParam);
		} else if (status == 2) {
			responses.setIsCompletePay(true);
			responses.setPaymetType(pr.getPdPayment());
			responses.setPdAmount(pr.getPdAmount());
			responses.setAddTime(new Date());
			responses.setSubMsg("云豆充值成功。");
		}

		return responses;

	}

	@RequestMapping(value = "/cloud/buyer/cash/save", method = RequestMethod.POST)
	@MethodMapping(desc = "云豆提现保存")
	@ResponseBody
	public ShopTradePaymetResponse cloudCashSave(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute @Param CloudPredepositCashVO vo) {
		ShopTradePaymetResponse responses = new ShopTradePaymetResponse();
		boolean b = true;
		responses.setSubCode("200");
		String result = "提现申请成功！";
		if (vo.getCashId() != null && vo.getCashId() > 0) {// 第一提现时cashId为空,cashId为空时用户手动填银行信息
			try {
				PredepositCashBO bo = predepositCashService.fetch(vo.getCashId());
				if (bo != null) {
					vo.setCashUserName(bo.getCashUserName());
					vo.setCashAccount(bo.getCashAccount());
					vo.setCashBank(bo.getCashBank());
					vo.setCashInfo(bo.getCashInfo());
					vo.setCashPayment(bo.getCashPayment());
					vo.setCashRelation(1);
					vo.setCashSubbranch(bo.getCashSubbranch());
				} else {
					result = "提现失败！获取最近提现记录异常.";
					b = false;
					responses.setSubCode("400");
					responses.setSubMsg(result);
					responses.setIsCompletePay(b);
					return responses;
				}
				// PropertyUtils.copyProperties(vo, bo);
			} catch (Exception e) {
				// e.printStackTrace();
				result = "提现失败！对象复制异常.";
				b = false;
				responses.setSubCode("400");
				responses.setSubMsg(result);
				responses.setIsCompletePay(b);
				return responses;
			}
		}
		if (vo.getCashAmount().doubleValue() % 100 > 0) {
			result = "提现金额只能是100的整数倍";
			b = false;
			responses.setSubCode("400");
		} else {
			try {
				Long uid = ActionsUtil.getOwnerUid();// test Long.parseLong("212");
				String source = ActionsUtil.getOwnerSource();
				PredepositCashVO pvo = new PredepositCashVO();
				BeanUtils.copyProperties(pvo, vo);
				result = userMoneyService.userCashApplyV2(uid, pvo, source);
			} catch (ServiceException e) {
				result = e.getErrorCode();
				b = false;
			} catch (Exception e) {
				result = "提现失败！请联系客服！";
				b = false;
				responses.setSubCode("400");
			}

		}
		responses.setIsCompletePay(b);
		responses.setPaymetType(vo.getCashPayment());
		responses.setCashBank(vo.getCashBank());
		responses.setCashAccount(vo.getCashAccount());
		responses.setCashSubbranch(vo.getCashSubbranch());
		responses.setPdAmount(vo.getCashAmount());
		responses.setAddTime(new Date());
		responses.setSubMsg(result);

		return responses;
	}

	@RequestMapping(value = "/cloud/buyer/query/only/one", method = RequestMethod.POST)
	@MethodMapping(desc = "云豆提现最近一条记录")
	@ResponseBody
	public CloudMoneyResponse cloudQueryOnlyOne(HttpServletRequest request, HttpServletResponse response) {

		CloudMoneyResponse cm = new CloudMoneyResponse();
		Long uid = ActionsUtil.getOwnerUid();
		PredepositCashBO bo = predepositCashService.queryOnlyOneByUid(uid);
		if (bo != null) {
			cm.setCloudPredepositCash(mapper.map(bo, CloudPredepositCashBO.class));
			cm.setRet(true);
		} else {
			cm.setCloudPredepositCash(null);
			cm.setRet(false);
		}

		return cm;
	}

	@RequestMapping(value = "/cloud/buyer/passwordIsNull", method = RequestMethod.POST)
	@MethodMapping(desc = "当前用户是否设置云豆密码")
	@ResponseBody
	public CloudMoneyResponse cloudPasswordIsNull(HttpServletRequest request) {
		CloudMoneyResponse cm = new CloudMoneyResponse();
		Long uid = ActionsUtil.getOwnerUid();
		boolean ret = true;
		UserMoneyBO bo = userMoneyService.findUserMoneyByUid(uid);
		if (bo == null) {
			ret = false;
		} else {
			if (bo.getPassword() == null || "".equals(bo.getPassword())) {
				ret = false;
			}
		}
		cm.setRet(ret);
		cm.setSubMsg((ret ? "已设置云豆密码！" : "未设置云豆密码验！"));
		return cm;
	}

	@RequestMapping(value = "/cloud/buyer/money/password", method = RequestMethod.POST)
	@MethodMapping(desc = "设置云豆密码")
	@ResponseBody
	public CloudMoneyResponse moneyPassword(HttpServletRequest request, HttpServletResponse response) {

		CloudMoneyResponse cm = new CloudMoneyResponse();
		Long uid = ActionsUtil.getOwnerUid();
		UserAccount account = accountService.findByUid(uid, UserContant.ACCOUNT_TYPE_2); // 用户的手机账号
		cm.setLoginName(account.getLoginName());
		cm.setRet(account.getLoginName() != null);
		return cm;

	}

	@RequestMapping(value = "/cloud/buyer/money/password/save", method = RequestMethod.POST)
	@MethodMapping(desc = "云豆密码修改保存")
	@ResponseBody
	public CloudMoneyResponse moneypPsswordSave(HttpServletRequest request, HttpServletResponse response,
			@Valid @RequestParam(value = "new_password") @Param(desc = "新密码") String new_password,
			@Valid @RequestParam(value = "mobile_verify_code") @Param(desc = "验证码") String mobile_verify_code)
			throws Exception {
		CloudMoneyResponse res = new CloudMoneyResponse();
		String result = "";
		Long uid = ActionsUtil.getOwnerUid();
		UserAccount account = accountService.findByUid(uid, UserContant.ACCOUNT_TYPE_2); // 用户的手机账号
		String codeRedis = redisCacheService.getSmsCode(uid, account.getLoginName());
		if(StringUtils.isBlank(new_password)){
			res.setSubCode("400");
			res.putErrorMessage("5.register.passwordOperatorForgetUpdate.update_user_fail");
			return res;
		}
		// 验证码是否正确
		if (StringUtils.isNotBlank(codeRedis) && codeRedis.equals(mobile_verify_code)) {
			userMoneyService.updatePassword(uid, new_password);
			res.setRet(true);
			result = "云豆密码修改成功";
		} else {
			res.setSubCode("400");
			result = "验证不正确";
		}
		res.setSubMsg(result);

		return res;
	}

	@RequestMapping(value = "/cloud/buyer/money/password/validate", method = RequestMethod.POST)
	@MethodMapping(desc = "云豆密码验证")
	@ResponseBody
	public CloudMoneyResponse moneypPsswordValidate(HttpServletRequest request, HttpServletResponse response,
			@Valid @RequestParam(value = "paymentPassword") @Param(desc = "支付密码") String paymentPassword)
			throws Exception {

		CloudMoneyResponse cm = new CloudMoneyResponse();
		Long uid = ActionsUtil.getOwnerUid();
		boolean b = userMoneyService.validatePassword(uid, paymentPassword);
		cm.setRet(b);
		cm.setSubMsg((b ? "云豆密码验证成功！" : "云豆密码验证失败！"));
		return cm;
	}

	/**
	 * 
	 * @param request
	 * @param type
	 *            mobile_vetify_code 发送更换手机的验证码 ,password_vetify_code 发送其它验证码
	 * @param mobile
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/cloud/buyer/mobile/sms", method = RequestMethod.POST)
	@MethodMapping(desc = "手机短信发送")
	public CloudMoneyResponse cloud_mobile_sms(HttpServletRequest request,
			@Valid @RequestParam(value = "type") @Param(desc = "验证类型") String type,
			@Valid @RequestParam(value = "mobile") @Param(desc = "手机号") String mobile)
			throws UnsupportedEncodingException {
		CloudMoneyResponse cm = new CloudMoneyResponse();
		Long uid = ActionsUtil.getOwnerUid();
		String msg_info = "短信发送成功.";
		boolean ret = true;
		if (type.equals("mobile_vetify_code")) {
			if (null != customerService.findByMobile(mobile)) {
				ret = false;
				msg_info = "该手机号码异常!";
			} else if (!customerService.sendChangeMobielValidateCode(uid, mobile)) {
				ret = false;
				msg_info = "短信发送失败!";
			}

		} else if (type.equals("password_vetify_code")) {
			UserAccount account = accountService.findByUid(uid, UserContant.ACCOUNT_TYPE_2); // 用户的手机账号
			if (!customerService.sendValidateCode(uid, account.getLoginName(), IPUtil.getIpAddr(request))) {
				ret = false;
				msg_info = "短信发送失败!";
			}
		}
		cm.setSubMsg(msg_info);
		cm.setRet(ret);
		return cm;
	}

	@SuppressWarnings("unchecked")
	private WeiXinPaymetBO makeWeixinPaymet(Payment payment, String content) {
		Document doc = Jsoup.parse(content, "", Parser.xmlParser());

		WeiXinPaymetBO weiXinPaymet = new WeiXinPaymetBO();
		weiXinPaymet.setAppid(payment.getWxAppid());
		weiXinPaymet.setPrepayid(doc.select("prepay_id").text());
		weiXinPaymet.setNoncestr(UUID.randomUUID().toString().replace("-", ""));
		weiXinPaymet.setPartnerid(payment.getTenpayPartner());
		weiXinPaymet.setTimestamp(String.valueOf(new Date().getTime() / 1000));

		Map<String, String> map = null;
		try {
			map = BeanUtils.describe(weiXinPaymet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("package", map.get("package1"));
		map.remove("class");
		map.remove("package1");

		String sign = Signature.generateSign(map, payment.getWxPaysignkey());
		weiXinPaymet.setSign(sign);
		return weiXinPaymet;
	}

	@RequestMapping(value = "money/free/poundage", method = RequestMethod.POST)
	@MethodMapping(desc = "获取剩余免费额度")
	@ResponseBody
	public MoneyFreePoundageResponse moneyFreePoundage(HttpServletRequest request, HttpServletResponse response) {
		MoneyFreePoundageResponse result = new MoneyFreePoundageResponse();
		Long uid = ActionsUtil.getOwnerUid();
		String source = ActionsUtil.getOwnerSource();
		double  freePoundage = predepositCashService.getFreePoundage(uid, source);
		int lint = predepositCashService.getLineByUid(uid, source);
		// 获取用户当月已提现次数
		result.setFreePoundage(freePoundage);
		result.setLine(lint);
		return result;
	}

}
