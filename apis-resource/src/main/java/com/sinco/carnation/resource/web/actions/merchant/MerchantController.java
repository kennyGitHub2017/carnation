package com.sinco.carnation.resource.web.actions.merchant;

import java.util.HashMap;
import java.util.Map;

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

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.carnation.resource.constant.MerchantConstant;
import com.sinco.carnation.resource.vo.merchant.MerchantBinding;
import com.sinco.carnation.resource.vo.merchant.MerchantRegisterVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.merchant.MerchantWeChatAutoCheckResponse;
import com.sinco.carnation.resource.web.response.merchant.MerchatResponse;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.WeChatService;
import com.sinco.common.utils.IPUtil;
/**
 * 商户APP接口
 * @author yuleijia
 * 2017.4.13
 */
@Controller
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "商户", namespace = "merchant")
public class MerchantController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserAccountService accountService;
	@Autowired
	private RedisCacheService redisCacheService;
	@Autowired
	private WeChatService weChatService;
	@Autowired
	private StoreService storeService;
	
	
	/**
	 * 商户入驻申请-微信授权后数据校验
	 * @param unionID  微信unionID
	 * @return
	 */
	@RequestMapping(value = "/merchant/weChatAutoAfter", method = RequestMethod.POST)
	@MethodMapping(desc = "商户入驻申请-微信授权后数据校验")
	public @ResponseBody
	MerchantWeChatAutoCheckResponse mercharWeChatAuthCheck(
			@RequestParam(value = "unionID") @Param(desc = "微信unionID") String unionID) {

		log.debug("================ Merchant App weChat Auth Check");
		log.debug(">>>>>>>>>> unionID->" + unionID);
		MerchantWeChatAutoCheckResponse response = new MerchantWeChatAutoCheckResponse();
		Integer state = MerchantConstant.DEFAULT_STATE;
		String content = "无数据";
		if (unionID != null && unionID.trim().length() > 0) {
			int result = this.accountService.queryUserAccountByUnionID(unionID);
			state = result;
			switch (result) {
				case MerchantConstant.NEW_ACCOUNT_STATE:
					content = "新会员"; // 新会员->会员注册->填写入驻信息
					break;
				case MerchantConstant.ACCOUNT_NOT_BOUND_MOBILE_STATE:
					content = "该会员未绑定手机号码"; // 该会员未绑定手机号码->绑定手机号->填写入驻信息
					break;
				case MerchantConstant.ACCOUNT_BOUND_MOBILE_MERCHANT:
					content = "该会员已绑定手机号码且是商户"; // 该会员已绑定手机号码且是商户->商户首页
					break;
				case MerchantConstant.ACCOUNT_BOUND_MOBILE_NOT_MERCHANT:
					content = "该会员已绑定手机号码非商户"; // 该该会员已绑定手机号码非商户->填写入驻信息
					break;
				case MerchantConstant.AUDIT_STATUS_WAITFOR:
					state = 320; // 待审核
					content = "入驻申请还在待审核中";
					break;
				case MerchantConstant.AUDIT_STATUS_FAILE:
					state = 330; // 审核失败
					String temp = this.getAuditContent(unionID);
					if (temp !=null && temp.trim().length() > 0) {
						content = temp;
					} else {
						content = "入驻申请审核失败或已被关闭";
					}
					break;
				case MerchantConstant.ACCOUNT_IS_CN:
					state = 340;
					content = "CN会员不能成为商户！"; // CN会员不能申请成为商户和供应商
					break;
			}
		}
		log.debug("<<<<<<<<<<<<<<< " + content);
		response.setState(state);
		response.setContent(content);
		return response;
	}
	/**
	 * 微信用户为新用户-会员注册
	 * @param vo
	 * @param bindingResult
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/merchant/registerUserAccount", method = RequestMethod.POST)
	@MethodMapping(desc = "微信用户为新用户-会员注册")
	public @ResponseBody
	MerchatResponse registerUserAccount(@Valid @ModelAttribute @Param MerchantRegisterVO vo,
			BindingResult bindingResult, HttpServletRequest request) {
		
		
		log.debug("========================= Merchant RegisterUserAccount =======================");
		
		MerchatResponse response = new MerchatResponse();
		if (bindingResult.hasErrors()) {
			ActionsUtil.handleParamError(bindingResult.getAllErrors(), response);
			return response;
		}
		int result = MerchantConstant.ERROR;
		String content = "error";

		String snsCode = redisCacheService.getSmsCode(0L, vo.getMobile());
		log.debug(">>>>>>> snsCode->" + snsCode);
		if (StringUtils.isBlank(snsCode)) { // 未发送验证码或者验证码已过期
			response.putErrorMessage("4.user.bindingMobile.exist_code_not");
			return response;
		}
		if (!snsCode.equals(vo.getVerCode())) { // 验证码不对
			response.putErrorMessage("4.user.bindingMobile.code_wrong");
			return response;
		}
		//校验手机号码是否已存在
		UserAccountBO phoneUserAccount = new UserAccountBO();
		phoneUserAccount.setAccountType(UserContant.ACCOUNT_TYPE_2);
		phoneUserAccount.setLoginName(vo.getMobile());
		UserAccountBO phoneUserAccountBO = this.accountService.findAccountByVo(phoneUserAccount);
		if(phoneUserAccountBO != null)
		{
			result = 500;
			content = "error";
			response.putErrorMessage("4.user.userAccount.register.mobile.existence");// 手机号已存在，请重新输入手机号
			return response;
		}
		// 校验微信是否已存在
		String unionID = vo.getUnionid();
		UserAccountBO weChatUserAccount = this.accountService.fetchByLoginName(unionID);
		if (weChatUserAccount == null) {
			String ipAddr = IPUtil.getIpAddr(request);
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("openid", vo.getOpenID());
			paramMap.put("nickName", vo.getNickName());
			paramMap.put("sex", null);
			paramMap.put("headimgurl", vo.getHeadImgUrl());
			paramMap.put("unionid_", vo.getUnionid());
			paramMap.put("invitationCode", vo.getInvitationCode());
			paramMap.put("requestIp", ipAddr);
			int resultSate = this.weChatService.saveMerchantRegisterAccount(paramMap, vo.getPassWord(), vo.getMobile());
			if(resultSate==200)
			{
				result = 200;
				content = "注册会员成功";
			}
			else
			{
				result = 500;
				content = "注册会员失败";
			}
			

		} else {
			result = 500;
			content = "error";
			response.putErrorMessage("4.user.weChatUserAccount.existence");// 当前微信用户已存在
		}
		response.setResult(result);
		response.setContent(content);
		return response;
	}
	
	/**
	 * 微信是会员没绑定手机号码
	 * @param vo
	 * @param bindingResult
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/merchant/bindingUserAccount", method = RequestMethod.POST)
	@MethodMapping(desc = "微信是会员没绑定手机号码")
	public @ResponseBody
	MerchatResponse bindingUserAccount(@Valid @ModelAttribute @Param MerchantBinding vo,
			BindingResult bindingResult, HttpServletRequest request) 
	{
		
		log.debug("========================= Merchant BindingUserAccount =======================");
		
		MerchatResponse response = new MerchatResponse();
		if (bindingResult.hasErrors()) {
			ActionsUtil.handleParamError(bindingResult.getAllErrors(), response);
			return response;
		}
		int result = MerchantConstant.ERROR;
		String content = "error";
		String snsCode = redisCacheService.getSmsCode(0L, vo.getMobile());
		log.debug(">>>>>>> snsCode->" + snsCode);
		if (StringUtils.isBlank(snsCode)) { // 未发送验证码或者验证码已过期
			response.putErrorMessage("4.user.bindingMobile.exist_code_not");
			return response;
		}
		if (!snsCode.equals(vo.getVerCode())) { // 验证码不对
			response.putErrorMessage("4.user.bindingMobile.code_wrong");
			return response;
		}/**/
		// 校验手机号码是否已存在
		UserAccountBO phoneUserAccount = new UserAccountBO();
		phoneUserAccount.setAccountType(UserContant.ACCOUNT_TYPE_2);
		phoneUserAccount.setLoginName(vo.getMobile());
		UserAccountBO phoneUserAccountBO = this.accountService.findAccountByVo(phoneUserAccount);
		if(phoneUserAccountBO != null)
		{
			result = 500;
			content = "error";
			response.putErrorMessage("4.user.userAccount.register.mobile.existence");// 手机号已存在，请重新输入手机号
			return response;
		}
		else
		{
			// 校验微信用户是否已存在
			String unionID = vo.getUnionid();
			UserAccountBO weChatUserAccount = this.accountService.fetchByLoginName(unionID);
			if(weChatUserAccount!=null)
			{
				//校验改微信用户是否绑定过手机号码
				long uid = weChatUserAccount.getUid();
				phoneUserAccount = new UserAccountBO();
				phoneUserAccount.setAccountType(UserContant.ACCOUNT_TYPE_2);
				phoneUserAccount.setUid(uid);
				phoneUserAccountBO = this.accountService.findAccountByVo(phoneUserAccount);
				if(phoneUserAccountBO != null)
				{
					result = 500;
					content = "error";
					response.putErrorMessage("4.user.userAccount.register.weChat.mobile.existence");// 手机号已存在，请重新输入手机号
				}
				else
				{
					// 绑定手机号码
					String pwd = PasswordUtils.entryptPassword(vo.getPassWord());
					UserAccount account_ = new UserAccount();
					account_.setLoginName(vo.getMobile());
					account_.setAccountType(UserContant.ACCOUNT_TYPE_2);
					account_.setIsDeleted(false);
					account_.setUid(uid);
					account_.setPassword(pwd);
					account_.setSellerPassword(pwd);
					this.accountService.save(account_);
					result = 200;
					content = "绑定会员成功";
				}
			}
			else
			{
				result = 500;
				content = "error";
				response.putErrorMessage("4.user.weChatUserAccount.not_existence");// 微信用户不已存在
			}
		}
		response.setResult(result);
		response.setContent(content);
		return response;
	}
	/**
	 * 获取商户审核状态内容
	 * @param unionID
	 * @return
	 */
	private String getAuditContent(String unionID)
	{
		String content = "";
		UserAccountBO userAccount = new UserAccountBO();
		userAccount.setAccountType(UserContant.ACCOUNT_TYPE_4);
		userAccount.setLoginName(unionID);
		UserAccountBO wxUserAccount = this.accountService.findAccountByVo(userAccount);
		Long uid = wxUserAccount.getUid();
		StoreBO store = storeService.queryStoreStatus(uid,true,false);
		if(store!=null)
		{
			content = store.getFailReseaon();
		}
		return content;
	}
}
