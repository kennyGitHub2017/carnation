package vc.thinker.b2b2c.action;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.qrcode.QRCodeUtil;
import vc.thinker.b2b2c.core.security.support.BasicUserDetails;
import vc.thinker.b2b2c.core.security.support.OperatorUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.rebate.service.RebateStatisService;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.StatisticsService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.dal.common.MyPage;

@Controller
public class IndexAction {
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private UserAccountService accountService;
	@Autowired
	private RedisCacheService redisCacheService;
	@Autowired
	private UserMoneyService moneyService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private UserRelationService relationService;
	@Autowired
	private StatisticsService statisticsService;

	@Autowired
	private RebateStatisService rebateStatisService;

	private static final Logger log = LoggerFactory.getLogger(IndexAction.class);

	@SecurityMapping(title = "运营商首页", value = "/operator/index.htm*", rtype = "operator", rname = "运营商首页", rcode = "operator_index", rgroup = "运营商管理")
	@RequestMapping("/operator/index.htm")
	public String index(Model model) {
		return "index.html";
	}

	@SecurityMapping(title = "运营商头部", value = "/operator/header.htm*", rtype = "operator", rname = "运营商头部", rcode = "operator_header", rgroup = "运营商管理")
	@RequestMapping("/operator/header.htm")
	public String header(Model model) {
		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		model.addAttribute("operatorBO", userDetails.getOperatorBO());
		return "header.html";
	}

	@SecurityMapping(title = "运营商导航", value = "/operator/nav.htm*", rtype = "operator", rname = "运营商导航", rcode = "operator_nav", rgroup = "运营商管理")
	@RequestMapping("/operator/nav.htm")
	public String nav(Model model) {
		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		model.addAttribute("op", userDetails.getOperatorBO());
		return "nav.html";
	}

	@SecurityMapping(title = "运营商基本信息", value = "/operator/main.htm*", rtype = "operator", rname = "运营商基本信息", rcode = "operator_main", rgroup = "运营商管理")
	@RequestMapping("/operator/main.htm")
	public String main(Model model) {
		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		OperatorBO operatorBO = operatorService.getOperatorBOByUserId(userDetails.getUser().getId());
		model.addAttribute("op", operatorBO);
		UserBO operatorUser = userService.getObjById(operatorBO.getUserId());
		model.addAttribute("operatorUserInvitationCode", operatorUser.getInvitationCode());
		UserRelationBO relation = relationService.getUserRelation(operatorBO.getUserId());
		if (relation != null && null != relation.getRefereeUserId()) {
			Long refereeUserId = relation.getRefereeUserId();
			UserCustomer userCustomer = customerService.findById(refereeUserId);
			String refereeName = "";
			if (userCustomer == null) {
				OperatorBO refereeOper = operatorService.getOperatorBOByUserId(refereeUserId);
				if (refereeOper != null) {
					refereeName = refereeOper.getOperatorName();
				}
			} else {
				refereeName = userCustomer.getNickname();
			}
			model.addAttribute("refereeName", refereeName);
		}
		return "main.html";
	}

	@SecurityMapping(title = "运营商关系统计信息", value = "/operator/statistics_relation.htm*", rtype = "operator", rname = "运营商关系统计信息", rcode = "operator_main", rgroup = "运营商管理")
	@RequestMapping("/operator/statistics_relation.htm")
	public String statisticsRelation(Model model) {
		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();

		Map<String, Object> mapResult = statisticsService.getOperatorRelationStatistics(
				userDetails.getOperatorBO(), null);
		model.addAttribute("resultMap", mapResult);
		return "statistics_relation.html";
	}

	@SecurityMapping(title = "运营商返润统计信息", value = "/operator/statistics_rebate.htm*", rtype = "operator", rname = "运营商收益统计信息", rcode = "operator_main", rgroup = "运营商管理")
	@RequestMapping("/operator/statistics_rebate.htm")
	public String statisticsRebate(Model model, String startTime, String endTime, String queryType) {
		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (StringUtils.isEmpty(queryType)) {
			queryType = "0";
		}
		Map<String, Object> o2oMapResult = rebateStatisService.getUserRebateStatis(userDetails.getId(),
				startTime, endTime, queryType, "0");
		Map<String, Object> b2cMapResult = rebateStatisService.getUserRebateStatis(userDetails.getId(),
				startTime, endTime, queryType, "1");
		double b2CAmountSum = 0; // 辖区内会员商城购物分润
		double b2CupAmount = 0; // 上传产品分润
		double b2CrupAmount = 0;// 推荐上传分润
		double b2CrjAmount = 0;// 推荐辖区分润
		double b2CgrAmount = 0;// 商户注册分润
		double b2CsgAmount = 0;// 签约商户分润
		double b2crsCAmount = 0;// 推荐签约分润
		double b2CrmAmount = 0;// B2C注册会员分润
		double b2CrsAmount = 0;// B2C分享注册分润
		double b2CormAmount = 0;// 运营注册会员分润
		double b2CrormAmount = 0;// 推荐运营注册分润

		double o2OjmAmount = 0;// 市/区级辖区管理分润
		double o2OjgAmount = 0; // 市/区级辖区服务分润
		double o2OjrmAmount = 0;// 推荐辖区管理分润
		double o2OjrgAmount = 0;// 推荐辖区服务分润
		double o2OsgmAmount = 0;// 签约商户管理分润
		double o2OsggAmount = 0;// 签约商户服务分润
		double o2OrsmAmount = 0;// 推荐签约管理分润
		double o2OrsgAmount = 0;// 推荐签约服务分润
		double o2OrmAmount = 0;// 注册会员分润
		double o2OrsAmount = 0;// 分享注册分润
		double o2OormAmount = 0;// 运营注册会员分润
		double o2OrormAmount = 0;// 推荐运营注册分润
		if (o2oMapResult != null && b2cMapResult != null) {
			b2CAmountSum = CommUtil.null2Double(b2cMapResult.get("b2CAmountSum")); // 辖区内会员商城购物分润
			b2CupAmount = CommUtil.null2Double(b2cMapResult.get("b2CupAmount")); // 上传产品分润
			b2CrupAmount = CommUtil.null2Double(b2cMapResult.get("b2CrupAmount"));// 推荐上传分润
			b2CrjAmount = CommUtil.null2Double(b2cMapResult.get("b2CrjAmount"));// 推荐辖区分润
			b2CgrAmount = CommUtil.null2Double(b2cMapResult.get("b2CgrAmount"));// 商户注册分润
			b2CsgAmount = CommUtil.null2Double(b2cMapResult.get("b2CsgAmount"));// 签约商户分润
			b2crsCAmount = CommUtil.null2Double(b2cMapResult.get("b2crsCAmount"));// 推荐签约分润
			b2CrmAmount = CommUtil.null2Double(b2cMapResult.get("b2CrmAmount"));// B2C注册会员分润
			b2CrsAmount = CommUtil.null2Double(b2cMapResult.get("b2CrsAmount"));// B2C分享注册分润
			b2CormAmount = CommUtil.null2Double(b2cMapResult.get("b2CormAmount"));// 运营注册会员分润
			b2CrormAmount = CommUtil.null2Double(b2cMapResult.get("b2CrormAmount"));// 推荐运营注册分润

			o2OjmAmount = CommUtil.null2Double(o2oMapResult.get("o2OjmAmount"));// 市/区级辖区管理分润
			o2OjgAmount = CommUtil.null2Double(o2oMapResult.get("o2OjgAmount")); // 市/区级辖区服务分润
			o2OjrmAmount = CommUtil.null2Double(o2oMapResult.get("o2OjrmAmount"));// 推荐辖区管理分润
			o2OjrgAmount = CommUtil.null2Double(o2oMapResult.get("o2OjrgAmount"));// 推荐辖区服务分润
			o2OsgmAmount = CommUtil.null2Double(o2oMapResult.get("o2OsgmAmount"));// 签约商户管理分润
			o2OsggAmount = CommUtil.null2Double(o2oMapResult.get("o2OsggAmount"));// 签约商户服务分润
			o2OrsmAmount = CommUtil.null2Double(o2oMapResult.get("o2OrsmAmount"));// 推荐签约管理分润
			o2OrsgAmount = CommUtil.null2Double(o2oMapResult.get("o2OrsgAmount"));// 推荐签约服务分润
			o2OrmAmount = CommUtil.null2Double(o2oMapResult.get("o2OrmAmount"));// 注册会员分润
			o2OrsAmount = CommUtil.null2Double(o2oMapResult.get("o2OrsAmount"));// 分享注册分润
			o2OormAmount = CommUtil.null2Double(o2oMapResult.get("o2OormAmount"));// 运营注册会员分润
			o2OrormAmount = CommUtil.null2Double(o2oMapResult.get("o2OrormAmount"));// 推荐运营注册分润
		}
		DecimalFormat df  = new DecimalFormat("######0.00");
		double b2csum = b2CAmountSum + b2CupAmount + b2CrupAmount + b2CrjAmount + b2CgrAmount + b2CsgAmount
				+ b2crsCAmount + b2CrmAmount + b2CrsAmount + b2CormAmount + b2CrormAmount;
		model.addAttribute("b2csum", df.format(b2csum));
		double o2osum = o2OjmAmount + o2OjgAmount + o2OjrmAmount + o2OjrgAmount + o2OsgmAmount + o2OsggAmount
				+ o2OrsmAmount + o2OrsgAmount + o2OrmAmount + o2OrsAmount + o2OormAmount + o2OrormAmount;
		model.addAttribute("o2osum", df.format(o2osum));
		double sum = b2csum + o2osum;
		model.addAttribute("sum", df.format(sum));
		// 市/区级辖区管理分润 o2OjmAmount
		model.addAttribute("o2OjmAmount", df.format(o2OjmAmount));
		// 市/区级辖区服务分润 o2OjgAmount
		model.addAttribute("o2OjgAmount", df.format(o2OjgAmount));
//		推荐辖区管理分润 o2OjrmAmount
		model.addAttribute("o2OjrmAmount", df.format(o2OjrmAmount));
//		推荐辖区服务分润  o2OjrgAmount
		model.addAttribute("o2OjrgAmount", df.format(o2OjrgAmount));
//		签约商户管理分润 o2OsgmAmount
		model.addAttribute("o2OsgmAmount", df.format(o2OsgmAmount));
//		签约商户服务分润	 o2OsggAmount
		model.addAttribute("o2OsggAmount", df.format(o2OsggAmount));
//		推荐签约管理分润 o2OrsmAmount
		model.addAttribute("o2OrsmAmount", df.format(o2OrsmAmount));
//		推荐签约服务分润 o2OrsgAmount
		model.addAttribute("o2OrsgAmount", df.format(o2OrsgAmount));
//		注册会员分润 o2OrmAmount
		model.addAttribute("o2OrmAmount", df.format(o2OrmAmount));
//		分享注册分润 o2OrsAmount
		model.addAttribute("o2OrsAmount", df.format(o2OrsAmount));
//		运营注册会员分润 o2OormAmount
		model.addAttribute("o2OormAmount", df.format(o2OormAmount));
//		推荐运营注册分润 o2OrormAmount
		model.addAttribute("o2OrormAmount", df.format(o2OrormAmount));
//		辖区内会员商城购物分润 b2CAmountSum
		model.addAttribute("b2CAmountSum", df.format(b2CAmountSum));
//		上传产品分润 b2CupAmount
		model.addAttribute("b2CupAmount", df.format(b2CupAmount));
//		推荐上传分润 b2CrupAmount
		model.addAttribute("b2CrupAmount", df.format(b2CrupAmount));
//		推荐辖区分润 b2CrjAmount
		model.addAttribute("b2CrjAmount", df.format(b2CrjAmount));
//		商户注册分润 b2CgrAmount
		model.addAttribute("b2CgrAmount", df.format(b2CgrAmount));
//		签约商户分润 b2CsgAmount
		model.addAttribute("b2CsgAmount", df.format(b2CsgAmount));
//		推荐签约分润 b2crsCAmount
		model.addAttribute("b2crsCAmount", df.format(b2crsCAmount));
//		B2C注册会员分润 b2CrmAmount
		model.addAttribute("b2CrmAmount", df.format(b2CrmAmount));
//		B2C分享注册分润 b2CrsAmount
		model.addAttribute("b2CrsAmount", df.format(b2CrsAmount));
//		运营注册会员分润 b2CormAmount
		model.addAttribute("b2CormAmount", df.format(b2CormAmount));
//		推荐运营注册分润 b2CrormAmount
		model.addAttribute("b2CrormAmount", df.format(b2CrormAmount));

		model.addAttribute("queryType", queryType);
		model.addAttribute("level", userDetails.getOperatorBO().getLevel());

		return "statistics_rebate.html";
	}

	@SecurityMapping(title = "运营商密码", value = "/operator/change_password.htm*", rtype = "operator", rname = "运营商密码", rcode = "change_password", rgroup = "运营商管理")
	@RequestMapping("/operator/change_password.htm")
	public String changePassword(Model model) {
		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		OperatorBO operatorBO = operatorService.getOperatorBOByUserId(userDetails.getUser().getId());
		model.addAttribute("op", operatorBO);
		return "change_password.html";
	}

	@SecurityMapping(title = "运营商密码保存", value = "/operator/password_save.htm*", rtype = "operator", rname = "运营商密码保存", rcode = "password_save.htm", rgroup = "运营商管理")
	@RequestMapping("/operator/password_save.htm")
	public String admin_pws_save(HttpServletRequest request, Model model, HttpServletResponse response,
			String oldPassword, String password) {
		BasicUserDetails user = SecurityUserHolder.getCurrentUserDetails();
		UserAccount account = accountService.findByLoginName(user.getUsername());
		if (PasswordUtils.validatePassword(oldPassword, account.getPassword())) {
			this.accountService.passwordUpdate(user.getUser().getId(), password);
			model.addAttribute("op_title", "修改密码成功");
		} else {
			model.addAttribute("op_title", "原密码错误");
		}
		return "tips.html";
	}

	@SecurityMapping(title = "运营商云豆密码", value = "/operator/currency_password.htm*", rtype = "operator", rname = "运营商云豆密码", rcode = "currency_password", rgroup = "运营商管理")
	@RequestMapping("/operator/currency_password.htm")
	public String currencyPassword(Model model) {
		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		OperatorBO operatorBO = operatorService.getOperatorBOByUserId(userDetails.getUser().getId());
		model.addAttribute("op", operatorBO);
		return "currency_password.html";
	}

	@SecurityMapping(title = "运营商云豆密码保存", value = "/operator/currency_password_save.htm*", rtype = "operator", rname = "运营商云豆密码保存", rcode = "currency_password_save", rgroup = "运营商管理")
	@RequestMapping("/operator/currency_password_save.htm")
	public String currencyPasswordSave(Model model, String password, String verifyCode) {
		Long uid = SecurityUserHolder.getCurrentUserId();
		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		String codeRedis = redisCacheService.getSmsCode(uid, userDetails.getOperatorBO().getPhone());
		// 验证码是否正确
		if (StringUtils.isNotBlank(codeRedis) && codeRedis.equals(verifyCode)) {
			moneyService.updatePassword(uid, password);
			model.addAttribute("op_title", "云豆密码修改成功");
			model.addAttribute("url", "/operator/main.htm");
		} else {
			model.addAttribute("op_title", "验证不正确");
			model.addAttribute("mobile", userDetails.getOperatorBO().getPhone());
			model.addAttribute("url", "/operator/currency_password.htm");
		}
		return "tips.html";
	}

	@SecurityMapping(title = "运营商联系电话", value = "/operator/change_mobile.htm*", rtype = "operator", rname = "运营商联系电话", rcode = "change_mobile", rgroup = "运营商管理")
	@RequestMapping("/operator/change_mobile.html")
	public String changeMobile(Model model) {
		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		OperatorBO operatorBO = operatorService.getOperatorBOByUserId(userDetails.getUser().getId());
		model.addAttribute("op", operatorBO);
		return "change_mobile.html";
	}

	@SecurityMapping(title = "运营商联系电话保存", value = "/operator/change_mobile_save.htm*", rtype = "operator", rname = "运营商联系电话保存", rcode = "change_mobile_save", rgroup = "运营商管理")
	@RequestMapping("/operator/change_mobile_save.html")
	public String changeMobileSave(Model model, String newMobile, String verifyCode) {
		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		String codeRedis = redisCacheService.getSmsCode(userDetails.getOperatorBO().getUserId(), userDetails
				.getOperatorBO().getPhone());
		// 验证码是否正确
		if (StringUtils.isNotBlank(codeRedis) && codeRedis.equals(verifyCode)) {
			operatorService.updatePhone(userDetails.getOperatorBO().getId(), newMobile);
			model.addAttribute("op_title", "联系电话修改成功");
			model.addAttribute("url", "/operator/main.htm");
		} else {
			model.addAttribute("op_title", "验证不正确");
			model.addAttribute("mobile", userDetails.getOperatorBO().getPhone());
			model.addAttribute("url", "/operator/change_mobile.htm");
		}

		return "tips.html";
	}

	@SecurityMapping(title = "手机短信发送", value = "/operator/account_mobile_sms.htm*", rtype = "operator", rname = "手机短信发送", rcode = "account_mobile_sms", rgroup = "运营商管理")
	@RequestMapping("/operator/account_mobile_sms.htm")
	public void account_mobile_sms(HttpServletRequest request, HttpServletResponse response, String type,
			String mobile) throws UnsupportedEncodingException {
		String ret = "100";
		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (type.equals("mobile_vetify_code")) {
			if (!operatorService.sendValidateCode(userDetails.getOperatorBO().getUserId(), mobile)) {
				ret = "200";
			}
		} else if (type.equals("password_vetify_code")) {
			if (!operatorService.sendValidateCode(userDetails.getOperatorBO().getUserId(), userDetails
					.getOperatorBO().getPhone())) {
				ret = "200";
			}
		}

		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/operator/operator_info_head.htm")
	public String operatorInfoHead(Model model, String active) {
		if (!StringUtils.isNotBlank(active)) {
			active = "main";
		}
		model.addAttribute("active", active);
		return "operator_info_head.html";
	}

	/**
	 * 查看运营商的邀请管理
	 * 
	 * @param request
	 * @param response
	 */
	@SecurityMapping(title = "运营商邀请管理", value = "/operator/my_invitation.htm*", rtype = "operator", rname = "运营商邀请管理信息", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/operator/my_invitationInfo.htm")
	public String my_invitationInfo(HttpServletRequest request, Model model, HttpServletResponse response) {
		// 查询头像图片，我的昵称，邀请码，邀请设置，二维码

		/*ModelAndView mv = new JModelAndView("user/default/sellercenter/my_invitation.html",
		configService.getSysConfig(), 0, request, response);*/

		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();

		UserBO user = userService.getObjById(userDetails.getOperatorBO().getUserId());// 邀请码

		UserAccount userAccount = accountService.findByUid(userDetails.getOperatorBO().getUserId());// 邀请设置信息

		UserCustomerBO userCustomer = customerService.searchCustomer(userDetails.getOperatorBO().getUserId());// 头像图片，昵称

		model.addAttribute("user", user);
		model.addAttribute("userAccount", userAccount);
		model.addAttribute("userCustomer", userCustomer);

		return "operator_invitation_info.html";
	}

	/**
	 * pc-保存我的邀请信息
	 * 
	 * @param request
	 * @param response
	 */
	@SecurityMapping(title = "运营商邀请管理-保存我的邀请信息", value = "/operator/my_invitationInfo_save.htm*", rtype = "operator", rname = "运营商邀请管理-保存我的邀请信息", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/operator/my_invitationInfo_save.htm")
	public String my_invitationInfo_save(HttpServletRequest request, Model model,
			HttpServletResponse response, UserAccount userAccount) {
		// 查询头像图片，我的昵称，邀请码，邀请设置，二维码

		// CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		// userAccount.setUid(userDetails.getSeller().getUid());

		try {
			accountService.update(userAccount);// 根据id更新
			model.addAttribute("saveSuccessMsg", "保存成功");
		} catch (Exception e) {
			model.addAttribute("saveFailMsg", "保存失败");
		}

		return "operator_invitation_info.html";
	}

	/**
	 * 查看运营商的邀请管理
	 * 
	 * @param request
	 * @param response
	 */
	@SecurityMapping(title = "运营商邀请管理-查看邀请明细", value = "/operator/my_invitation_list.htm*", rtype = "operator", rname = "运营商邀请管理-邀请明细", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/operator/my_invitation_list.htm")
	public String my_invitation_list(HttpServletRequest request, MyPage<UserCustomerBO> page, Model model,
			HttpServletResponse response) {

		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();

		page.setPageSize(4);

		customerService.queryRelationList(userDetails.getOperatorBO().getUserId(), page);

		CommUtil.saveIPageList2Model("", "", "", page, model);
		// CommUtil.saveIPageList2ModelAndView("", "", "", page, model);

		return "operator_invitation_list.html";
	}

	/**
	 * 查看运营商的邀请管理--下载二维码
	 * 
	 * @param request
	 * @param response
	 */
	@SecurityMapping(title = "运营商邀请管理-下载二维码", value = "/operator/my_invitation_downloadQrcode.htm*", rtype = "operator", rname = "运营商邀请管理-下载二维码", rcode = "user_center_seller", rgroup = "商家中心")
	@RequestMapping("/operator/my_invitation_downloadQrcode.htm")
	public void my_invitation_downloadQrcode(HttpServletRequest request, MyPage<UserCustomerBO> page,
			HttpServletResponse response) {

		OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		String invitationCode = userDetails.getUser().getInvitationCode();

		try {
			String fileName = "我的邀请二维码", suffix = ".jpg", encodedFileName;
			encodedFileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// 避免中文乱码
			response.addHeader("Content-Disposition", "attachment;filename=" + encodedFileName + suffix);

			OutputStream ous = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream;charset=UTF-8");

			// String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName()
					+ request.getContextPath();
			// String content = "http://shop.ysysgo.com/mobile_register.htm?invitationCode="+invitationCode;
			String targetDomain = "http://shop.ysysgo.com";
			if (basePath.contains("com")) {
				targetDomain = "http://shop.ysysgo.com";
			}/*else if(basePath.contains("cn")){
				   
				}*/

			String content = targetDomain + "/mobile_register.htm?invitationCode=" + invitationCode;

			QRCodeUtil.encode(content, ous);
			Log.info(content);
			// System.out.println(invitationCode+"\n"+content+"\n"+basePath);
			ous.flush();
			ous.close();
		} catch (IOException e) {
			log.info("下载二维码出现读写IO异常");
		} catch (Exception e) {
			log.info("下载二维码出现异常");
		}
	}

}
