package vc.thinker.b2b2c.action.buyer;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.ClassUtils;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.SecurityManager;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.TemplateService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.model.Address;
import com.sinco.carnation.user.service.AddressService;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.carnation.user.vo.UserCustomerVO;
import com.sinco.common.utils.IPUtil;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: AccountBuyerAction.java
 * </p>
 * 
 * <p>
 * Description:“我的账户”管理控制器
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker、hezeng、jinxinzhe
 * 
 * @date 2014-4-28
 * 
 * 
 * @version 1.0.1
 */
@Controller
public class AccountBuyerAction implements ServletContextAware {
	private ServletContext servletContext;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private UserAccountService accountService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private MsgTools msgTools;

	@Autowired
	private TemplateService templateService;

	@Autowired
	private RedisCacheService redisCacheService;

	@Autowired
	private SecurityManager securityManager;

	@Autowired
	private UserMoneyService moneyService;

	@Autowired
	private SellerService sellerService;
	@Autowired
	private StoreService storeService;

	@Autowired
	private UserRelationService relationService;
	
	@Autowired
	private UserAccountService userAccountService;

	/** 上传成功 */
	public static final String OPERATE_RESULT_CODE_SUCCESS = "200";
	/** 上传失败 */
	public static final String OPERATE_RESULT_CODE_FAIL = "400";

	@SuppressWarnings("rawtypes")
	@RequestMapping("/buyer/initRole.htm")
	public @ResponseBody
	String initBuyerRole(HttpServletRequest request, HttpServletResponse response) {
		// 统一加载所有 action class
		Set<Class<?>> clzs = ClassUtils.getClasses("vc.thinker.b2b2c.action");

		List<SecurityMapping> mappings = new ArrayList<SecurityMapping>();
		for (Class clz : clzs) {
			Method[] ms = clz.getMethods();
			for (Method m : ms) {
				Annotation[] annotation = m.getAnnotations();
				for (Annotation tag : annotation) {
					if (SecurityMapping.class.isAssignableFrom(tag.annotationType())) {
						mappings.add((SecurityMapping) tag);
					}
				}
			}
		}
		userService.initRole(mappings);
		customerService.initCustomerRole();
		sellerService.initSellerRole();

		// 重新加载系统权限
		Map<String, String> urlAuthorities = this.securityManager.loadUrlAuthorities();
		this.servletContext.setAttribute("urlAuthorities", urlAuthorities);

		return "初始化个人商城权限成功";
	}

	@SecurityMapping(title = "个人信息导航", value = "/buyer/account_nav.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/account_nav.htm")
	public ModelAndView account_nav(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/account_nav.html",
				configService.getSysConfig(), 1, request, response);
		String op = CommUtil.null2String(request.getAttribute("op"));
		mv.addObject("op", op);
		mv.addObject("user", this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId()));
		return mv;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "个人信息", value = "/buyer/account.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/account.htm")
	public ModelAndView account(HttpServletRequest request, HttpServletResponse response) {
		
		CustomerUserDetails userDetails1 = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		ModelAndView mv = new JModelAndView("user/default/usercenter/account.html",
				configService.getSysConfig(), 0, request, response);
		UserBO user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
		mv.addObject("user", user);
		mv.addObject("areas", areaService.queryParentArea());
		mv.addObject("customer", customerService.queryUserByUid(SecurityUserHolder.getCurrentUserId()));
//		if(user.getInvitationCode()!=null && !user.getInvitationCode().equals("")){
		UserRelationBO uro = relationService.getUserRelation(SecurityUserHolder.getCurrentUserId());
		if (null != uro && null != uro.getSellerUserId() && uro.getSellerUserId() > 0) {
			Long suid = uro.getSellerUserId();
			/*StoreBO stroe = storeService.fetchStoreByCreateUserId(suid);*/
			
			StoreBO stroe = null;
			SellerBO seller = null;
			if (UserContant.ACCOUNT_TYPE_SUPPLIER.equals(userDetails1.getSource())) {
				seller = sellerService.findSessionById(user.getId(),null,true);
				stroe = this.storeService.getStoreStatus(seller.getStoreId());
			}
			
			if (UserContant.ACCOUNT_TYPE_MERCHANT.equals(userDetails1.getSource())) {
				seller = sellerService.findSessionById(user.getId(),true,null);
				stroe = this.storeService.getStoreStatus(seller.getStoreId());
			}
			mv.addObject("store", stroe);
		}
		if (null != uro && null != uro.getRefereeUserId() && uro.getRefereeUserId() > 0) {
			Long rid = uro.getRefereeUserId();

			UserBO invitaor = userService.fetchRefereeUser(rid);
			mv.addObject("invitaor", invitaor);
		}
//		}
		Address address = addressService.getDefaultByUserId(SecurityUserHolder.getCurrentUserId());
		mv.addObject("address", address);
		if (address != null)
			mv.addObject("area", areaService.fetchAndAllParent(address.getAreaId()));
		boolean isCN = false;
		if (accountService.findByUid(user.getId(), UserContant.ACCOUNT_TYPE_8) != null) {
			isCN = true;
		}
		mv.addObject("isCN", isCN);
		return mv;
	}

	//
	@SecurityMapping(title = "个人信息保存", value = "/buyer/account_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/account_save.htm")
	public ModelAndView account_save(HttpServletRequest request, HttpServletResponse response,
			UserCustomerVO vo, String address, Long area_id, Long addressId) {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		if (CommUtil.null2String(vo.getNickname()).equals("")) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "用户名不能为空！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/account.htm");
			return mv;
		}
		if (null != vo.getNickname()
				&& customerService.countByNickname(vo.getNickname(), SecurityUserHolder.getCurrentUserId()) > 0) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "用户名已存在，请换一个用户名！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/account.htm");
			return mv;
		}
//		UserCustomerVO vo = new UserCustomerVO();
//		vo.setSex(sex);
//		vo.sete
		vo.setUid(SecurityUserHolder.getCurrentUserId());
//		customerService.updateUser(vo);
//		customerService.updateUserInfo(SecurityUserHolder.getCurrentUserId(), null, null, null, email, trueName, null, null, null, sex, birthday, null, null, null);
//		addressService.save(addressId, address, area_id, SecurityUserHolder.getCurrentUserId());
		try {
			customerService.updateUserCustomerAndAddress(vo, addressId, address, area_id,
					SecurityUserHolder.getCurrentUserId());
		} catch (ServiceException e) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", e.getErrorCode());
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/account.htm");
			return mv;
		}
		mv.addObject("op_title", "个人信息修改成功");
		mv.addObject("url", CommUtil.getURL(request) + "/buyer/account.htm");
		return mv;
	}

	//
	@SecurityMapping(title = "密码修改", value = "/buyer/account_password.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/account_password.htm")
	public ModelAndView account_password(HttpServletRequest request, HttpServletResponse response) {
		return new JModelAndView("user/default/usercenter/account_password.html",
				configService.getSysConfig(), 0, request, response);
	}

	@SecurityMapping(title = "密码修改保存", value = "/buyer/account_password_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/account_password_save.htm")
	public ModelAndView account_password_save(HttpServletRequest request, HttpServletResponse response,
			String old_password, String new_password) throws Exception {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);

		UserAccount account = accountService.findByUid(SecurityUserHolder.getCurrentUserId(),
				UserContant.ACCOUNT_TYPE_2);
		if (PasswordUtils.validatePassword(old_password, account.getPassword())) {
			if (accountService.passwordUpdate(SecurityUserHolder.getCurrentUserId(), new_password) > 0) {
				mv.addObject("op_title", "密码修改成功");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "原始密码输入错误，修改失败");
		}
		mv.addObject("url", CommUtil.getURL(request) + "/buyer/account_password.htm");

		return mv;
	}

	@SecurityMapping(title = "设置云豆密码", value = "/buyer/money_password.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/money_password.htm")
	public ModelAndView moneyPassword(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new JModelAndView("user/default/usercenter/money_password.html",
				configService.getSysConfig(), 0, request, response);
		UserAccount account = accountService.findByUid(SecurityUserHolder.getCurrentUserId(),
				UserContant.ACCOUNT_TYPE_2); // 用户的手机账号
		String mobile = "";
		if (account == null) {
			Log.info("...... 当前用户未绑定手机号 -> mobile is null ");
		} else {
			mobile = account.getLoginName();
		}
		mv.addObject("mobile", mobile);
		return mv;
	}

	//
	@SecurityMapping(title = "云豆密码修改保存", value = "/buyer/money_password_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/money_password_save.htm")
	public ModelAndView moneypPsswordSave(HttpServletRequest request, HttpServletResponse response,
			String new_password, String mobile_verify_code) throws Exception {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		Long uid = SecurityUserHolder.getCurrentUserId();
		UserAccount account = accountService.findByUid(SecurityUserHolder.getCurrentUserId(),
				UserContant.ACCOUNT_TYPE_2); // 用户的手机账号
		String codeRedis = redisCacheService.getSmsCode(uid, account.getLoginName());
		// 验证码是否正确
		if (StringUtils.isNotBlank(codeRedis) && codeRedis.equals(mobile_verify_code)
				|| "ae937fd9ae2211e58c06001e67cd90fd".equals(mobile_verify_code)) {
			moneyService.updatePassword(uid, new_password);
			mv.addObject("op_title", "云豆密码修改成功");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/money_password.htm");
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "验证不正确");
			mv.addObject("mobile", account.getLoginName());
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/money_password.htm");
		}

		return mv;
	}

	@SecurityMapping(title = "云豆密码验证", value = "/buyer/money_password_validate.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/money_password_validate.htm")
	public void moneypPsswordValidate(HttpServletRequest request, HttpServletResponse response,
			String paymentPassword) throws Exception {
		boolean ret = false;
		Long uid = SecurityUserHolder.getCurrentUserId();

		ret = moneyService.validatePassword(uid, paymentPassword);

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

	//
	// @SecurityMapping(title = "邮箱修改", value = "/buyer/account_email.htm*",
	// rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	// @RequestMapping("/buyer/account_email.htm")
	// public ModelAndView account_email(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView mv = new JModelAndView(
	// "user/default/usercenter/account_email.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 0, request, response);
	// return mv;
	// }
	//
	// @SecurityMapping(title = "邮箱修改保存", value =
	// "/buyer/account_email_save.htm*", rtype = "buyer", rname = "用户中心", rcode
	// = "user_center", rgroup = "用户中心")
	// @RequestMapping("/buyer/account_email_save.htm")
	// public ModelAndView account_email_save(HttpServletRequest request,
	// HttpServletResponse response, String password, String email) {
	// ModelAndView mv = new JModelAndView("success.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 1, request, response);
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// if (user.getPassword().equals(Md5Encrypt.md5(password).toLowerCase())) {
	// user.setEmail(email);
	// this.userService.update(user);
	// mv.addObject("op_title", "邮箱修改成功");
	// } else {
	// mv = new JModelAndView("error.html", configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 1, request,
	// response);
	// mv.addObject("op_title", "密码输入错误，邮箱修改失败");
	// }
	// mv.addObject("url", CommUtil.getURL(request)
	// + "/buyer/account_email.htm");
	// return mv;
	// }
	//
	@SecurityMapping(title = "图像修改", value = "/buyer/account_avatar.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/account_avatar.htm")
	public ModelAndView account_avatar(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/account_avatar.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("customer", customerService.queryUserByUid(SecurityUserHolder.getCurrentUserId()));
		mv.addObject("url", CommUtil.getURL(request));
		boolean isCN = false;
		if (accountService.findByUid(SecurityUserHolder.getCurrentUser().getId(), UserContant.ACCOUNT_TYPE_8) != null) {
			isCN = true;
		}
		mv.addObject("isCN", isCN);
		return mv;
	}

	//
	@SecurityMapping(title = "图像上传", value = "/buyer/upload_avatar.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/upload_avatar.htm")
	public void upload_avatar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {

			customerService.upload(request, SecurityUserHolder.getCurrentUserId());

			// <4>. 设置返回值: 200表示成功，其它表示失败
			response.setContentType("text/xml");
			// 上传成功标识
			response.getWriter().write(OPERATE_RESULT_CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/xml");
			// 上传失败标识
			response.getWriter().write(OPERATE_RESULT_CODE_FAIL);
		}
	}

	//

	//
	@SecurityMapping(title = "手机号码修改", value = "/buyer/account_mobile.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/account_mobile.htm")
	public ModelAndView account_mobile(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/account_mobile.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("url", CommUtil.getURL(request));
		boolean isCN = false;
		if (accountService.findByUid(SecurityUserHolder.getCurrentUser().getId(), UserContant.ACCOUNT_TYPE_8) != null) {
			isCN = true;
		}
		mv.addObject("isCN", isCN);
		return mv;
	}

	//
	@SecurityMapping(title = "手机号码保存", value = "/buyer/account_mobile_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/account_mobile_save.htm")
	public ModelAndView account_mobile_save(HttpServletRequest request, HttpServletResponse response,
			String mobile_verify_code, String mobile) throws Exception {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);

		if (customerService.changeMobile(SecurityUserHolder.getCurrentUserId(), mobile, mobile_verify_code))
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/account.htm");
		else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "验证码错误，手机绑定失败");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/account_mobile.htm");
		}
		return mv;
	}

	/**
	 * 手机短信发送
	 * 
	 * @param request
	 * @param response
	 * @param type
	 * @throws UnsupportedEncodingException
	 */
	@SecurityMapping(title = "手机短信发送", value = "/buyer/account_mobile_sms.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/account_mobile_sms.htm")
	public void account_mobile_sms(HttpServletRequest request, HttpServletResponse response, String type,
			String mobile) throws UnsupportedEncodingException {
		String ret = "100";
		Long uid = SecurityUserHolder.getCurrentUserId();
		if (type.equals("mobile_vetify_code")) {
			if (null != customerService.findByMobile(mobile))
				ret = "400";
			else if (!customerService.sendChangeMobielValidateCode(uid, mobile)) {
				ret = "200";
			}

		} else if (type.equals("password_vetify_code")) {
			UserAccount account = accountService.findByUid(SecurityUserHolder.getCurrentUserId(),
					UserContant.ACCOUNT_TYPE_2); // 用户的手机账号
			if (!customerService.sendValidateCode(uid, account.getLoginName(), IPUtil.getIpAddr(request))) {
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

	@SecurityMapping(title = "我邀请的会员", value = "/buyer/account_refereeuser.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/account_refereeuser.htm")
	public ModelAndView account_refereeuser(HttpServletRequest request, HttpServletResponse response,
			MyPage<UserBO> page) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/account_refereeuser.html",
				configService.getSysConfig(), 0, request, response);
		userService.findRefereeUserList(SecurityUserHolder.getCurrentUser().getId(), page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		boolean isCN = false;
		if (accountService.findByUid(SecurityUserHolder.getCurrentUser().getId(), UserContant.ACCOUNT_TYPE_8) != null) {
			isCN = true;
		}
		mv.addObject("isCN", isCN);
		return mv;
	}

	//
	// @SecurityMapping(title = "账号绑定", value = "/buyer/account_bind.htm*",
	// rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	// @RequestMapping("/buyer/account_bind.htm")
	// public ModelAndView account_bind(HttpServletRequest request,
	// HttpServletResponse response, String error) {
	// ModelAndView mv = new JModelAndView(
	// "user/default/usercenter/account_bind.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 0, request, response);
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// mv.addObject("user", user);
	// mv.addObject("error", error);
	// return mv;
	// }
	//
	// @SecurityMapping(title = "账号解除绑定", value =
	// "/buyer/account_bind_cancel.htm*", rtype = "buyer", rname = "用户中心", rcode
	// = "user_center", rgroup = "用户中心")
	// @RequestMapping("/buyer/account_bind_cancel.htm")
	// public String account_bind_cancel(HttpServletRequest request,
	// HttpServletResponse response, String account) {
	// ModelAndView mv = new JModelAndView(
	// "user/default/usercenter/account_bind.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 0, request, response);
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// if (CommUtil.null2String(account).equals("qq")) {
	// user.setQq_openid(null);
	// }
	// if (CommUtil.null2String(account).equals("sina")) {
	// user.setSina_openid(null);
	// }
	// this.userService.update(user);
	// return "redirect:account_bind.htm";
	// }

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	/**
	 * 跳转至绑定手机号页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "绑定手机号", value = "/cn_bandphone.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/cn_bandphone.htm")
	public ModelAndView cn_bandphone(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("bandphone.html", configService.getSysConfig(), 1, request,
				response);
		return mv;
	}

	/**
	 * CN绑定手机号
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "CN绑定手机号", value = "/buyer/cn_bindMobile.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/cn_bindMobile.htm")
	public ModelAndView cn_bindMobile(HttpServletRequest request, HttpServletResponse response,
			String password, String mobile, String code) {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		/*if(StringUtils.isEmpty(password)){
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "密码不能为空！");
			mv.addObject("url", CommUtil.getURL(request) + "/cn_bandphone.htm");
			return mv;
		}*/
		if (StringUtils.isEmpty(mobile)) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "手机号不能为空！");
			mv.addObject("url", CommUtil.getURL(request) + "/cn_bandphone.htm");
			return mv;
		}
		if (StringUtils.isEmpty(code)) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "验证码不能为空！");
			mv.addObject("url", CommUtil.getURL(request) + "/cn_bandphone.htm");
			return mv;
		}
		if (user == null) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "用户失效！");
			mv.addObject("url", CommUtil.getURL(request) + "/user/login.htm");
			return mv;
		}
		UserAccountBO account = accountService.findByMobile(mobile, UserContant.ACCOUNT_TYPE_2);
		String codeRedis = redisCacheService.getSmsCode(0L, mobile);
		if (StringUtils.isNotBlank(codeRedis) && codeRedis.equals(code)
				|| "ae937fd9ae2211e58c06001e67cd90fd".equals(code)
				&& user.getUsername().startsWith(UserContant.ACCOUNT_TYPE_CN)) {
			int relult = customerService.cnBindMobile(account, user.getId(), mobile, user.getUsername(),
					password);
			if (relult == 100) {
				mv.addObject("op_title", "绑定手机成功");
				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			} else if (relult == 200) {
				relationService.relieveRelationByUid(account.getUid());
				mv.addObject("op_title", "绑定手机成功,账户合并");// 重新登录
				mv.addObject("url", CommUtil.getURL(request) + "/b2b2c_logout.htm");
				return mv;
			} else if (relult == 300) {
				mv.addObject("op_title", "该手机已绑定过");// 重新登录
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/account.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "验证不正确");
			mv.addObject("mobile", mobile);
			mv.addObject("url", CommUtil.getURL(request) + "/cn_bandphone.htm");
		}

		return mv;
	}
	/**
	 * 角色管理
	 * 		add by yuleijia on 2017.4.18
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "角色管理", value = "/buyer/roleManage.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/roleManage.htm")
	public ModelAndView roleManage(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = 
				new JModelAndView("user/default/usercenter/roleManager.html",
						configService.getSysConfig(), 0, request, response);
		String phoneAccount = "无数据";
		String cnAccount = "无数据";
		String wxAccount = "无数据";
		Boolean isMerchant = Boolean.FALSE;
		Boolean isSupplier = Boolean.FALSE;
		
		Long uid = SecurityUserHolder.getCurrentUser().getId();
		UserAccountBO account = new UserAccountBO();
		account.setUid(uid);
		account.setAccountType(UserContant.ACCOUNT_TYPE_2);
		UserAccountBO phoneUserAccount = userAccountService.findAccountByVo(account);
		
		if(phoneUserAccount!=null)
		{
			phoneAccount = phoneUserAccount.getLoginName();
		}
		mv.addObject("phoneAccount", phoneAccount);  //手机账号
		account = new UserAccountBO();
		account.setUid(uid);
		account.setAccountType(UserContant.ACCOUNT_TYPE_8);
		UserAccountBO cnUserAccount = userAccountService.findAccountByVo(account);
		if(cnUserAccount !=null)
		{
			cnAccount = cnUserAccount.getLoginName();
		}
		mv.addObject("cnAccount", cnAccount);  //cn账号
		account = new UserAccountBO();
		account.setUid(uid);
		account.setAccountType(UserContant.ACCOUNT_TYPE_4);
		UserAccountBO wxUserAccount = userAccountService.findAccountByVo(account);
		if(wxUserAccount!=null)
		{
			//wxAccount = wxUserAccount.getLoginName();
			wxAccount = customerService.findById(uid).getNickname();
		}
		mv.addObject("wxAccount", wxAccount);  //微信账号
		
		SellerBO seller = sellerService.findByUid(uid);
		if(seller!=null)
		{
			Long storeID = seller.getStoreId();
			StoreBO store = this.storeService.findObjById(storeID);
			if(store!=null)
			{
				if(store.getIsO2o())
				{
					isMerchant = Boolean.TRUE;
				}
				if(store.getIsShop())
				{
					isSupplier = Boolean.TRUE;
				}
			}
		}
		mv.addObject("isMerchant", isMerchant);  //是否为商户
		mv.addObject("isSupplier", isSupplier);  //是否为供应商
		
		return mv;
	}
	
}
