package com.sinco.carnation.resource.web.actions;

import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.exception.ApiException;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.IPUtil;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.vo.register.PasswordForgetUpdateVO;
import com.sinco.carnation.resource.vo.register.RegisterAccountExistsVO;
import com.sinco.carnation.resource.vo.register.RegisterNicknameExistsVO;
import com.sinco.carnation.resource.vo.register.RegisterThirdAccountVO;
import com.sinco.carnation.resource.vo.register.RegisterUsersCreateVO;
import com.sinco.carnation.resource.vo.register.VerifyMobileSendVO;
import com.sinco.carnation.resource.web.response.register.CodeSendIfMobileResponse;
import com.sinco.carnation.resource.web.response.register.PasswordForgetUpdateResponse;
import com.sinco.carnation.resource.web.response.register.RegisterAccountExistsResponse;
import com.sinco.carnation.resource.web.response.register.RegisterUsersCreateResponse;
import com.sinco.carnation.resource.web.response.register.VerifyCodeSendResponse;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.enums.EmRegisterFromType;
import com.sinco.carnation.sys.service.RegisterLogService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.messager.MessageHandler;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "注册", namespace = "register")
public class RegisterController extends BasicApiController {

	private final Logger log = LoggerFactory.getLogger(RegisterController.class);

	@Resource(name = "smsMessageHandler")
	private MessageHandler smsHandler;

	@Autowired
	private UserCustomerService userCustomerService;

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private RedisCacheService redisCacheService;

	@Autowired
	private UserRelationService relationService;

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private UserService userService;

	@Autowired
	private RegisterLogService registerLogService;

	@RequestMapping(value = "/verify_code/send", method = RequestMethod.POST)
	@MethodMapping(desc = "注册发送验证码")
	public @ResponseBody
	VerifyCodeSendResponse registerVerifyCodeSend(@Valid @ModelAttribute @Param VerifyMobileSendVO vo,
			BindingResult result, HttpServletRequest request) {

		VerifyCodeSendResponse response = new VerifyCodeSendResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		boolean isfal = Pattern.compile("^((13[0-9])|(14[0-9])|(15([0-9]))|(17([0-9]))|(18[0-9]))\\d{8}$")
				.matcher(vo.getMobile()).matches();
		if (!isfal) {
			response.putErrorMessage("4.register.registerVerifyCodeSend.Format_is_wrong");
			return response;
		}
		UserAccountBO account = userAccountService.findByMobile(vo.getMobile(), UserContant.ACCOUNT_TYPE_2);
		if (null != account) {
			response.putErrorMessage("4.register.registerUsersCreate.login_name_not_unique");
			return response;
		}
		// String code = SmsUtils.createRandom(true, 6);
		// String msg = "您的验证码是：" + code + "。请不要把验证码泄露给其他人。";
		// try {
		// boolean bo = smsHandler.sendMessage(vo.getMobile(), msg);
		// } catch (Exception e) {
		// log.error("短信发送超时" + e.getMessage(), e);
		// }
		// if (bo) {
		// UserCustomer customer =
		// userCustomerService.findByMobile(vo.getMobile());
		UserAccountBO userAccount = userAccountService.findByMobile(vo.getMobile(),
				UserContant.ACCOUNT_TYPE_2);
		if (null != userAccount)
			userCustomerService.sendValidateCode(userAccount.getUid(), vo.getMobile(),
					IPUtil.getIpAddr(request));
		// redisCacheService.setSmsCode(userAccount.getUid(), code,
		// vo.getMobile());
		else
			userCustomerService.sendRegisterValidateCode(vo.getMobile(), IPUtil.getIpAddr(request));
		// redisCacheService.setSmsCode(0L, code, vo.getMobile());
		// }

		return response;
	}

	@RequestMapping(value = "/password_forget/update", method = RequestMethod.POST)
	@MethodMapping(desc = "忘记密码的修改密码")
	public @ResponseBody
	PasswordForgetUpdateResponse passwordForgetUpdate(
			@Valid @ModelAttribute @Param PasswordForgetUpdateVO vo, BindingResult result,
			HttpServletRequest request) throws ApiException {

		PasswordForgetUpdateResponse response = new PasswordForgetUpdateResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		if (vo.getMobile().substring(0, 2).equalsIgnoreCase("CN")) {
			response.putErrorMessage("4.register.passwordOperatorForgetUpdate.account_is_cn");
			return response;
		}
		// UserCustomerBO customer =
		// userCustomerService.findByMobile(vo.getMobile());
		UserAccountBO userAccount = userAccountService.findByMobile(vo.getMobile(),
				UserContant.ACCOUNT_TYPE_2);
		if (null == userAccount) {
			response.putErrorMessage("4.register.passwordForgetUpdate.login_name_not");
			return response;
		} else if (null != userAccount) {
			String codeRedis = redisCacheService.getSmsCode(userAccount.getUid(), vo.getMobile());
			// 账号是CN账号
			if (userAccountService.findByUid(userAccount.getUid(), "8") != null) {
				response.putErrorMessage("4.register.passwordOperatorForgetUpdate.account_is_cn");
				return response;
			}
			// 用户未申请发送过验证码，或者验证号已过期
			if (StringUtils.isBlank(codeRedis)) {
				response.putErrorMessage("4.register.passwordForgetUpdate.account_not_send_verify_sms");
				return response;
			}
			// 验证失败
			if (!codeRedis.equals(vo.getVerifyCode())) {
				response.putErrorMessage("4.register.passwordForgetUpdate.verify_code_error");
				return response;
			}
			int resultInfo = userAccountService.passwordUpdate(userAccount.getUid(), vo.getPassword());
			if (resultInfo < 0) {
				response.putErrorMessage("5.register.passwordForgetUpdate.update_user_fail");
				return response;
			}
//			log.debug("Forget Password Source:" + source + ",resultInfo:" + resultInfo);
		}
		return response;
	}

	@RequestMapping(value = "/password_forget_to_source/update", method = RequestMethod.POST)
	@MethodMapping(desc = "忘记密码的修改密码(根据角色标识)")
	public @ResponseBody
	PasswordForgetUpdateResponse passwordForgetUpdateBySource(
			@Valid @ModelAttribute @Param PasswordForgetUpdateVO vo, BindingResult result,
			HttpServletRequest request) throws ApiException {

		PasswordForgetUpdateResponse response = new PasswordForgetUpdateResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		if (vo.getMobile().substring(0, 2).equalsIgnoreCase("CN")) {
			response.putErrorMessage("4.register.passwordOperatorForgetUpdate.account_is_cn");
			return response;
		}
		// UserCustomerBO customer =
		// userCustomerService.findByMobile(vo.getMobile());
		UserAccountBO userAccount = userAccountService.findByMobile(vo.getMobile(),
				UserContant.ACCOUNT_TYPE_2);
		if (null == userAccount) {
			response.putErrorMessage("4.register.passwordForgetUpdate.login_name_not");
			return response;
		} else if (null != userAccount) {
			String codeRedis = redisCacheService.getSmsCode(userAccount.getUid(), vo.getMobile());
			// 账号是CN账号
			if (userAccountService.findByUid(userAccount.getUid(), "8") != null) {
				response.putErrorMessage("4.register.passwordOperatorForgetUpdate.account_is_cn");
				return response;
			}
			// 用户未申请发送过验证码，或者验证号已过期
			if (StringUtils.isBlank(codeRedis)) {
				response.putErrorMessage("4.register.passwordForgetUpdate.account_not_send_verify_sms");
				return response;
			}
			// 验证失败
			if (!codeRedis.equals(vo.getVerifyCode())) {
				response.putErrorMessage("4.register.passwordForgetUpdate.verify_code_error");
				return response;
			}
			int resultInfo = userAccountService.passwordUpdate(userAccount.getUid(), vo.getPassword(),
					vo.getSource());
			if (resultInfo == -99) {
				response.putErrorMessage("6.register.passwordForgetUpdate.update_source_fail");
				return response;
			}
			if (resultInfo < 0) {
				response.putErrorMessage("5.register.passwordForgetUpdate.update_user_fail");
				return response;
			}
//			log.debug("Forget Password Source:" + source + ",resultInfo:" + resultInfo);
		}
		return response;
	}

	@RequestMapping(value = "/register/users/create", method = RequestMethod.POST)
	@MethodMapping(desc = "用户创建")
	public @ResponseBody
	RegisterUsersCreateResponse registerUsersCreate(@Valid @ModelAttribute @Param RegisterUsersCreateVO vo,
			BindingResult result, HttpServletRequest request) throws ApiException {
		log.info("VARICOM create user old ," + vo.getMobile() + "," + vo.getPassword() + ","
				+ vo.getVerifyCode() + "," + request.getHeader("User-Agent"));
		String ip = IPUtil.getIpAddr(request);
		RegisterUsersCreateResponse response = new RegisterUsersCreateResponse();
		// 根据手机号查询归属地
		response.setAddressbyphone(relationService.getPhoneCityWithProvince(vo.getMobile()));
		response.setInvitationCode(vo.getInvitationCode());
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		if (StringUtils.isNotBlank(vo.getInvitationCode())) {
			UserBO user = userService.findByInvitationCode(vo.getInvitationCode());
			if (null == user || user.getStatus() != 1) {
				response.putErrorMessage("4.register.registerUsersCreate.Invitation_code_is_wrong");
				return response;
			}
		}
		int num = relationService.registerUser(vo.getNickname(), vo.getMobile(), vo.getPassword(), ip,
				vo.getVerifyCode(), vo.getInvitationCode());
		if (num == -5) {
			response.putErrorMessage("4.register.registerUsersCreate.nickname_not_unique");
			return response;
		} else if (num == -4) {
			response.putErrorMessage("4.register.registerUsersCreate.login_name_not_unique");
			return response;
		} else if (num == -3) {
			// 验证码错误
			response.putErrorMessage("4.register.registerUsersCreate.verify_code_error");
			return response;
		} else if (num == -2) {
			response.putErrorMessage("4.register.registerUsersCreate.account_not_send_verify_sms");
			return response;
		} else if (num == 0) {
			response.putErrorMessage("5.user.registerUsersCreate.create_user_fail");
			return response;
		} else {
			// 创建注册日志；
			registerLogService.createRegisterLog(request, vo.getMobile(), vo.getInvitationCode(),
					EmRegisterFromType.APP);
			// 创建用户成功，返回用户名和userid
			UserAccountBO accountBO = userAccountService.findByMobile(vo.getMobile(),
					UserContant.ACCOUNT_TYPE_2);
			response.setLoginName(accountBO.getLoginName());
			response.setUid(accountBO.getUid());
			// 更新缓存
			redisCacheService.setSmsCode(0L, vo.getVerifyCode(), vo.getMobile());
			log.info("register success. moblie=" + vo.getMobile());
			return response;
		}
	}

	@RequestMapping(value = "/register/account_exists", method = RequestMethod.POST)
	@MethodMapping(desc = "注册账号是否存在")
	public @ResponseBody
	RegisterAccountExistsResponse registerAccountExists(
			@Valid @ModelAttribute @Param RegisterAccountExistsVO vo, BindingResult result,
			HttpServletRequest request) throws ApiException {

		RegisterAccountExistsResponse response = new RegisterAccountExistsResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		// UserCustomer customer =
		// userCustomerService.findByMobile(vo.getLoginName());
		UserAccountBO userAccount = userAccountService.findByMobile(vo.getLoginName(),
				UserContant.ACCOUNT_TYPE_2);
		// 帐号存在
		if (null != userAccount)
			response.setIsExists(true);
		// 帐号不存在
		else
			response.setIsExists(false);

		return response;
	}

	@RequestMapping(value = "/register/nickname_exists", method = RequestMethod.POST)
	@MethodMapping(desc = "昵称是否存在")
	public @ResponseBody
	RegisterAccountExistsResponse registerNicknameExists(
			@Valid @ModelAttribute @Param RegisterNicknameExistsVO vo, BindingResult result,
			HttpServletRequest request) throws ApiException {

		RegisterAccountExistsResponse response = new RegisterAccountExistsResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		// UserCustomer customer =
		// userCustomerService.findByMobile(vo.getLoginName());
		int count = userCustomerService.countByNickname(vo.getNickname(), null);
		response.setIsExists(count > 0);

		return response;
	}

	@RequestMapping(value = "/verify_forgetcode/send", method = RequestMethod.POST)
	@MethodMapping(desc = "忘记密码发送验证码")
	public @ResponseBody
	VerifyCodeSendResponse forgetVerifyCodeSend(@Valid @ModelAttribute @Param VerifyMobileSendVO vo,
			BindingResult result, HttpServletRequest request) {

		VerifyCodeSendResponse response = new VerifyCodeSendResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		UserAccountBO userAccount = userAccountService.findByMobile(vo.getMobile(),
				UserContant.ACCOUNT_TYPE_2);
		if (null == userAccount) {
			response.putErrorMessage("4.register.passwordForgetUpdate.login_name_not");
			return response;
		}

		if (userAccountService.findByUid(userAccount.getUid(), UserContant.ACCOUNT_TYPE_8) != null) {
			response.putErrorMessage("4.register.passwordOperatorForgetUpdate.account_is_cn");
			return response;
		}
		boolean isfal = Pattern.compile("^((13[0-9])|(14[0-9])|(15([0-9]))|(17([0-9]))|(18[0-9]))\\d{8}$")
				.matcher(vo.getMobile()).matches();
		if (!isfal) {
			response.putErrorMessage("4.register.registerVerifyCodeSend.Format_is_wrong");
			return response;
		}

		// String code = SmsUtils.createRandom(true, 6);
		// String msg = "您的验证码是：" + code + "。请不要把验证码泄露给其他人。";
		// try {
		// boolean bo = smsHandler.sendMessage(vo.getMobile(), msg);
		// } catch (Exception e) {
		// log.error("短信发送超时" + e.getMessage(), e);
		// }

		userCustomerService.sendValidateCode(userAccount.getUid(), vo.getMobile(), IPUtil.getIpAddr(request));

		// if (bo) {
		// redisCacheService.setSmsCode(userAccount.getUid(), code,
		// vo.getMobile());
		// }
		return response;
	}

	@RequestMapping(value = "/register/third/create", method = RequestMethod.POST)
	@MethodMapping(desc = "创建第三方用户")
	public @ResponseBody
	RegisterUsersCreateResponse registerThirdUserCreate(
			@Valid @ModelAttribute @Param RegisterThirdAccountVO vo, BindingResult result,
			HttpServletRequest request) {

		RegisterUsersCreateResponse response = new RegisterUsersCreateResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		String requestIp = IPUtil.getIpAddr(request);
		int num = userCustomerService.createThirdUser(vo.getLongName(), vo.getLoginType(), requestIp);
		if (num == -4) {
			response.putErrorMessage("4.register.registerThirdUserCreate.login_name_not_unique");
			return response;
		}
		if (num == 0) {
			response.putErrorMessage("5.register.registerThirdUserCreate.third_create_fail ");
			return response;
		}
		return response;
	}

	@RequestMapping(value = ApiConstants.API + "/register/nvitationCode/exists", method = RequestMethod.POST)
	@MethodMapping(desc = "检查邀请码")
	public @ResponseBody
	RegisterAccountExistsResponse existsInvitationCode(
			@Valid @RequestParam(value = "code", required = false) @Param(desc = "邀请码") String code) {
		RegisterAccountExistsResponse response = new RegisterAccountExistsResponse();
		if (StringUtils.isBlank(code)) {
			response.setExistsCode(true);
			return response;
		}
		UserBO user = userService.findByInvitationCode(code);
		if (user == null || user.getStatus() != 1) {
			response.setExistsCode(false);
			return response;
		}
		response.setExistsCode(true);
		return response;
	}

	@RequestMapping(value = "/oper_code/send", method = RequestMethod.POST)
	@MethodMapping(desc = "营运商发送验证码|修改云豆密码和忘记密码")
	public @ResponseBody
	RegisterAccountExistsResponse operatorSendCode(@Valid @ModelAttribute @Param VerifyMobileSendVO vo,
			BindingResult result, HttpServletRequest request) {
		RegisterAccountExistsResponse response = new RegisterAccountExistsResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		OperatorBO opBo = operatorService.getOperatorByMobile(vo.getMobile());
		if (opBo == null) {
			response.putErrorMessage("4.register.operatorSendCode.mobile_user_fail");
			return response;
		}

		userCustomerService.sendValidateCode(opBo.getUserId(), vo.getMobile(), IPUtil.getIpAddr(request));
		return response;
	}

	@RequestMapping(value = "/password_forget/operator/update", method = RequestMethod.POST)
	@MethodMapping(desc = "营运商忘记密码")
	public @ResponseBody
	PasswordForgetUpdateResponse passwordOperatorForgetUpdate(
			@Valid @ModelAttribute @Param PasswordForgetUpdateVO vo, BindingResult result,
			HttpServletRequest request) throws ApiException {

		PasswordForgetUpdateResponse response = new PasswordForgetUpdateResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		OperatorBO operatorBO = operatorService.getOperatorByMobile(vo.getMobile());
		if (null == operatorBO) {
			response.putErrorMessage("4.register.passwordForgetUpdate.login_name_not");
			return response;
		} else if (null != operatorBO) {
			if (userAccountService.findByUid(operatorBO.getUserId(), UserContant.ACCOUNT_TYPE_8) != null) {
				response.putErrorMessage("4.register.passwordOperatorForgetUpdate.account_is_cn");
				return response;
			}
			String codeRedis = redisCacheService.getSmsCode(operatorBO.getUserId(), vo.getMobile());
			// 用户未申请发送过验证码，或者验证号已过期
			if (StringUtils.isBlank(codeRedis)) {
				response.putErrorMessage("4.register.passwordForgetUpdate.account_not_send_verify_sms");
				return response;
			}
			// 验证失败
			if (!codeRedis.equals(vo.getVerifyCode())) {
				response.putErrorMessage("4.register.passwordForgetUpdate.verify_code_error");
				return response;
			}
			// 修改成功
			if (userAccountService.passwordUpdate(operatorBO.getUserId(), vo.getPassword()) < 0) {
				response.putErrorMessage("5.register.passwordForgetUpdate.update_user_fail");
				return response;
			}
		}

		return response;
	}

	@RequestMapping(value = "/code/send", method = RequestMethod.POST)
	@MethodMapping(desc = "发送验证码")
	public @ResponseBody
	VerifyCodeSendResponse CodeSend(@Valid @ModelAttribute @Param VerifyMobileSendVO vo,
			BindingResult result, HttpServletRequest request) {

		VerifyCodeSendResponse response = new VerifyCodeSendResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		UserAccountBO userAccount = userAccountService.findByMobile(vo.getMobile(),
				UserContant.ACCOUNT_TYPE_2);

		boolean isfal = Pattern.compile("^((13[0-9])|(14[0-9])|(15([0-9]))|(17([0-9]))|(18[0-9]))\\d{8}$")
				.matcher(vo.getMobile()).matches();
		if (!isfal) {
			response.putErrorMessage("4.register.registerVerifyCodeSend.Format_is_wrong");
			return response;
		}

		String ip = IPUtil.getIpAddr(request);

		if (userAccount != null) {
			userCustomerService.sendValidateCode(userAccount.getUid(), vo.getMobile(), ip);
		} else {
			userCustomerService.sendRegisterValidateCode(vo.getMobile(), ip);
		}
		return response;
	}

	@RequestMapping(value = "/code/sendIfMobile", method = RequestMethod.POST)
	@MethodMapping(desc = "发送验证码并判断手机号是否是平台账号")
	public @ResponseBody
	CodeSendIfMobileResponse CodeSendIfMobile(@Valid @ModelAttribute @Param VerifyMobileSendVO vo,
			BindingResult result, HttpServletRequest request) {

		CodeSendIfMobileResponse response = new CodeSendIfMobileResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		UserAccountBO userAccount = userAccountService.findByMobile(vo.getMobile(),
				UserContant.ACCOUNT_TYPE_2);

		boolean isfal = Pattern.compile("^((13[0-9])|(14[0-9])|(15([0-9]))|(17([0-9]))|(18[0-9]))\\d{8}$")
				.matcher(vo.getMobile()).matches();
		if (!isfal) {
			response.putErrorMessage("4.register.registerVerifyCodeSend.Format_is_wrong");
			return response;
		}
		String ip = IPUtil.getIpAddr(request);
		if (userAccount != null) {
			userCustomerService.sendValidateCode(userAccount.getUid(), vo.getMobile(), ip);
		} else {
			userCustomerService.sendRegisterValidateCode(vo.getMobile(), ip);
		}
		UserAccountBO account = userAccountService.findByMobile(vo.getMobile(), UserContant.ACCOUNT_TYPE_2);
		if (account != null) {
			response.setIsBinding(true);
			return response;
		}
		response.setIsBinding(false);
		return response;
	}

}
