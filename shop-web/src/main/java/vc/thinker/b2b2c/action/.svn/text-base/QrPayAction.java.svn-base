package vc.thinker.b2b2c.action;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.ActionResult;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.biz.utils.ThinkerQRCodeUtil;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.ShopQrPayOrderService;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.pay.tools.WxMpTools;
import com.sinco.carnation.pay.tools.WxPayTools;
import com.sinco.carnation.pay.tools.WxShareTools;
import com.sinco.carnation.shop.bo.ShopQrPayOrderBO;
import com.sinco.carnation.shop.model.ShopQrServerInfo;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.carnation.user.service.WeChatService;
import com.sinco.common.utils.StringUtils;

@Controller
public class QrPayAction {

	@Autowired
	private SysConfigService configService;

	@Autowired
	private WxShareTools wxShareTools;
	@Autowired
	private WxPayTools wxPayTools;
	@Autowired
	private PayTools payTools;

	@Autowired
	private SellerService sellerService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private UserCustomerService userCustomerService;

	@Autowired
	private UserMoneyService userMoneyService;
	@Autowired
	private UserRelationService userRelationService;

	private static final Logger log = LoggerFactory.getLogger(QrPayAction.class);
	@Autowired
	private WxMpTools wxMpTools;
	@Autowired
	private WeChatService weChatService;
	@Autowired
	private GroupOrderService groupOrderService;

	/**
	 * 
	 * @param response
	 * @param json
	 */
	public void returnBody(HttpServletResponse response, String json) {
		CommUtil.returnBody(response, json);
	}

	@Autowired
	private ShopQrPayOrderService shopQrPayOrderService;

	@Autowired
	private UserAccountService accountService;

	/**
	 * 扫描店铺二维码后，提交支付
	 * 
	 * @param request
	 * @param response
	 * @param money
	 * @param sellerId
	 * @param code
	 * @param payType
	 * @param phone
	 * @param serverName
	 * @param userId
	 * @param payPwd
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/q/wx_qr_pay_self_order.htm")
	public void wx_qr_pay_order(HttpServletRequest request, HttpServletResponse response, BigDecimal money,
			Long sellerId, String code, String payType, String phone, String serverName, Long userId,
			String payPwd) {

		try {
			// 信息验证
			//SellerBO sellerbo = sellerService.findByUid(sellerId);
			SellerBO sellerbo = this.sellerService.findSessionById(sellerId, true, false);
			if (sellerbo == null) {
				returnBody(response, Json.toJson(ActionResult.NewFail("卖家信息不存在")));
				return;
			}
			if (money.compareTo(BigDecimal.ZERO) < 1) {
				returnBody(response, Json.toJson(ActionResult.NewFail("支付金额必须大于0")));
				return;
			}
			//StoreBO storeBo = storeService.getStoreBOById(sellerbo.getStoreId());
			StoreBO storeBo =	this.storeService.getStoreStatus(sellerbo.getStoreId());
			log.info("STOREID{}",storeBo.getStoreId());
			if (storeBo == null) {
				returnBody(response, Json.toJson(ActionResult.NewFail("店铺信息不存在")));
				return;
			}

			// 扫码支付新增折扣价
			BigDecimal originalPrice = new BigDecimal(money.doubleValue());
			if (storeBo.getIsO2o() && storeBo.getGroupDiscount() != null
					&& storeBo.getGroupDiscount().compareTo(BigDecimal.ZERO) == 1) {
				money = originalPrice.multiply(storeBo.getGroupDiscount()).setScale(2, RoundingMode.HALF_UP);
			}

			if (userId != null && userId > 0L) {
				UserCustomerBO customer = userCustomerService.findByMobile(phone);
				if (customer == null || !customer.getUid().equals(userId)) {
					returnBody(response, Json.toJson(ActionResult.NewFail("该用户手机号码错误")));
					return;
				}
			}
			String webPath = configService.getSysConfig().getAddress();
			
			
			System.out.println("====================================================================================================");
			System.out.println("========================================================="+payType);
			if (payType.equals("wxpay")) // 微信支付
			{
				// 微信支付移植web-mobile中
			} else if (payType.equals("alipay")) // 支付宝支付
			{

				log.info("======================= Do Alipay Start ======================== ");
				String reUrl = payTools.mchAliQrPay(sellerbo, money, originalPrice, webPath, phone,
						serverName);
				if (StringUtils.isBlank(reUrl)) {
					returnBody(response, Json.toJson(ActionResult.NewFail("支付请求失败")));
				} else {
					returnBody(response, Json.toJson(ActionResult.NewSuccess(reUrl)));
				}
			} else if (payType.equals("jgpay")) // 云豆支付
			{
				// 创建支付订单
				ShopQrPayOrderBO bo = payTools.mchJgQrPay(userId, sellerbo, money, originalPrice, webPath,
						phone, serverName, payPwd);
				if (bo == null) {
					returnBody(response, Json.toJson(ActionResult.NewFail("支付失败")));
				} else {
					String info = String.format("云尚订单支付成功，订单号：%s", bo.getPayOrderNo());
					returnBody(response, Json.toJson(ActionResult.NewSuccess(info)));
				}
			}
		} catch (ServiceException e) {
			returnBody(response, Json.toJson(ActionResult.NewFail(e.getErrorCode())));
		} catch (Exception e) {
			log.error(String.format("商家店内扫描出现错误:%s", CommUtil.getStackTrace(e)));
			returnBody(response, Json.toJson(ActionResult.NewFail(e.getMessage())));
		}

	}

	/**
	 * 扫描店铺二维码，转到支付页面
	 * 
	 * @param request
	 * @param response
	 * @param s
	 *            sellerId 卖家Id
	 * @param m
	 *            money 金额
	 * @param ser
	 *            server 服务名称
	 * @param p
	 *            phone 手机号
	 * @param wxCode
	 *            微信code
	 * @param t
	 *            payType 支付类型
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("q/pay.htm")
	public ModelAndView mch_qr_pay(HttpServletRequest request, HttpServletResponse response, Long s,
			String t, Long id) throws Exception {

		log.info("====================== Alipay Start ================= ");

		ModelAndView mv = new JModelAndView("qr_pay/mch_wx_qr_pay.html", configService.getSysConfig(), 1,
				request, response);

		// 信息验证
		SellerBO sellerbo = sellerService.findByUid(s);
		if (sellerbo == null) {
			mv.addObject("errMsg", "卖家信息不存在");
			return mv;
		}
		StoreBO storeBo = storeService.getStoreBOById(sellerbo.getStoreId());
		if (storeBo == null) {
			mv.addObject("errMsg", "店铺信息不存在");
			return mv;
		}
		if (!StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS.equals(storeBo.getStoreStatus())) {
			mv.addObject("errMsg", "非正常营业店铺不支持收款");
			return mv;
		}
		if (!storeBo.getIsO2o()) {
			mv.addObject("errMsg", "只有商户账号才能收款");
			return mv;
		}
		mv.addObject("sellerBo", sellerbo);
		mv.addObject("storeBo", storeBo);

		if (id != null) {
			ShopQrServerInfo info = shopQrPayOrderService.getServerInfo(id);
			if (info == null) {
				mv.addObject("errMsg", "服务信息未找到");
				return mv;
			}

			mv.addObject("code", info.getCode());
			if (info.getMoney() != null && info.getMoney().compareTo(BigDecimal.ZERO) == 1) {
				mv.addObject("money", info.getMoney());
			}
			mv.addObject("serverName", info.getServer());
			mv.addObject("phone", info.getPhone());
		}

		mv.addObject("payType", t);

		mv.addObject("version", UUID.randomUUID());

		wxShareTools.wxShareMv(mv, request);

		return mv;

	}

	@RequestMapping("/qr_server_info_save.htm")
	public void qr_server_info_save(HttpServletRequest request, HttpServletResponse response,
			BigDecimal money, String server, String phone, String code) {

		ShopQrServerInfo info;

		try {
			info = saveServerInfo(money, server, phone, code);
			returnBody(response, Json.toJson(ActionResult.NewSuccess(info.getId())));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("信息保存失败{}", CommUtil.getStackTrace(e));
			returnBody(response, Json.toJson(ActionResult.NewFail("保存失败")));
		}
	}

	private ShopQrServerInfo saveServerInfo(BigDecimal money, String server, String phone, String code) {
		ShopQrServerInfo info;
		info = new ShopQrServerInfo();
		info.setMoney(money);
		info.setServer(server);
		info.setPhone(phone);
		info.setCode(code);
		info.setCreateTime(new Date());
		shopQrPayOrderService.saveServerInfo(info);
		return info;
	}

	/**
	 * 商家扫码 二维码展示入口
	 * 
	 * @param request
	 * @param response
	 * @param s
	 * @return
	 */
	@RequestMapping("/qr_main.htm")
	public ModelAndView qr_main(HttpServletRequest request, HttpServletResponse response, Long s)
			throws Exception {

		SellerBO sellerbo = sellerService.findByUid(s);
		if (sellerbo == null) {
			throw new Exception("参数错误,商家账号不存在");
		}

		ModelAndView mv = new JModelAndView("qr_pay/qr_main.html", configService.getSysConfig(), 1, request,
				response);
		mv.addObject("sellerId", s);
		String url = configService.getSysConfig().getAddress();

		Map<String, String> map = payTools.GetQrPath(url, s, true);

		for (Map.Entry<String, String> entry : map.entrySet()) {
			mv.addObject(entry.getKey(), entry.getValue());
		}
		mv.addObject("path", url + "/qr_server_info_save.htm");
		return mv;
	}

	/**
	 * 商家扫码主入口-返回一码扫的主入口
	 * 
	 * @param request
	 * @param response
	 * @param s
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/merchant_home.htm")
	public ModelAndView merchantHome(HttpServletRequest request, HttpServletResponse response, Long s)
			throws Exception {

		UserBO bo = userService.findById(s);
		if (bo == null) {
			throw new Exception("参数错误,商家用户不存在");
		}

		SellerBO sellerbo = sellerService.findByUid(s);
		if (sellerbo == null) {
			throw new Exception("参数错误,商家账号不存在");
		}

		ModelAndView mv = new JModelAndView("qr_pay/merchant_home.html", configService.getSysConfig(), 1,
				request, response);
		// mv.addObject("sellerId", s);
		mv.addObject("invitationCode", bo.getInvitationCode());

		Map<String, String> map = payTools.GetQrPath(configService.getSysConfig().getAddress(), s, false);

		for (Map.Entry<String, String> entry : map.entrySet()) {
			mv.addObject(entry.getKey(), entry.getValue());
		}
		return mv;
	}

	/**
	 * 登录检查，检查用户名和密码
	 * 
	 * @param request
	 * @param response
	 * @param phone
	 * @param pwd
	 * @throws Exception
	 */
	@RequestMapping("wap/login_check.htm")
	public void login_check(HttpServletRequest request, HttpServletResponse response, String phone, String pwd)
			throws Exception {
		if (StringUtils.isEmpty(phone)) {
			returnBody(response, Json.toJson(ActionResult.NewFail("手机号不能为空")));
			return;
		}
		if (StringUtils.isEmpty(pwd)) {
			returnBody(response, Json.toJson(ActionResult.NewFail("密码不能为空")));
			return;
		}

		UserCustomerBO customer = userCustomerService.findByMobile(phone);
		if (customer == null) {
			returnBody(response, Json.toJson(ActionResult.NewFail("该用户不存在")));
			return;
		}
		UserAccount account = userAccountService.findByUid(customer.getUid());
		if (account == null) {
			returnBody(response, Json.toJson(ActionResult.NewFail("该用户不存在")));
			return;
		}

		if (!PasswordUtils.validatePassword(pwd, account.getPassword())) {
			returnBody(response, Json.toJson(ActionResult.NewFail("密码错误！")));
			return;
		}

		returnBody(response, Json.toJson(ActionResult.NewSuccess(account.getUid())));
	}

	/**
	 * 支付密码检查
	 * 
	 * @param request
	 * @param response
	 * @param userId
	 * @param payPwd
	 * @throws Exception
	 */
	@RequestMapping("wap/pay_pwd_check.htm")
	public void pay_pwd_check(HttpServletRequest request, HttpServletResponse response, Long userId,
			String payPwd) throws Exception {

		boolean flag = userMoneyService.validatePassword(userId, payPwd);

		returnBody(response, Json.toJson(ActionResult.NewSuccess(flag)));
	}

	/**
	 * 调整注册用户的所属地
	 * 
	 * @param request
	 * @param response
	 * @param key
	 */
	@RequestMapping("/register_area.htm")
	public void registerAreaDeal(HttpServletRequest request, HttpServletResponse response, String key,
			String type) {

		// 检查key
		if (!"E004D539-B845-11E5-8C06-001E67CD90FD".equals(key)) {
			returnBody(response, Json.toJson(ActionResult.NewFail("key error")));
			return;
		}

		if (type.equals("add")) {
			userRelationService.saveUserPhoneCityArea();
		} else if (type.equals("register")) {
			// 处理注册用户所属地
			userRelationService.registerAreaDeal();
		}

		returnBody(response, Json.toJson(ActionResult.NewSuccess("Ok")));

	}

	@SecurityMapping(title = "收款二维码", value = "/seller/receiving_info.htm*", rtype = "seller", rname = "收款二维码", rcode = "group_adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/receiving_info.htm")
	public ModelAndView receiving_info(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = null;
		mv = new JModelAndView("user/default/sellercenter/receiving_info.html", configService.getSysConfig(),
				0, request, response);

		// 获取商户的商铺
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (userDetails == null) {

		}

		Map<String, String> map = payTools.GetQrPath(configService.getSysConfig().getAddress(), userDetails
				.getUser().getId(), true);

		for (Map.Entry<String, String> entry : map.entrySet()) {
			mv.addObject(entry.getKey(), entry.getValue());
		}
		return mv;
	}

	@SuppressWarnings("deprecation")
	@RequestMapping("/qr_code.htm")
	public void qr_code(HttpServletRequest request, HttpServletResponse response, String qrUrl)
			throws Exception {
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		qrUrl = qrUrl.replace("-*-", "&");
		qrUrl = URLDecoder.decode(qrUrl); // 这里解码，能够把url长度变短
		BufferedImage image = ThinkerQRCodeUtil.createImage(qrUrl, null, true);

		ServletOutputStream rs = response.getOutputStream();
		// 输出图象到页面
		ImageIO.write(image, "JPEG", rs);

		// 以下关闭输入流！
		rs.flush();
		rs.close();
	}

	/**
	 * 请直接使用 qr_code.htm
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @throws Exception
	 */
	@Deprecated
	@RequestMapping("/seller/qr_code.htm")
	public void seller_qr_code(HttpServletRequest request, HttpServletResponse response, String url)
			throws Exception {
		qr_code(request, response, url);

	}

	/**
	 * 商户专属码
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "商户专属码", value = "/seller/sellerExclusiveCode.htm*", rtype = "seller", rname = "商户专属码", rcode = "sellerExclusiveCode", rgroup = "我的店铺")
	@RequestMapping("/seller/sellerExclusiveCode.htm")
	public ModelAndView sellerExclusiveCode(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/receiving_info.html",
				configService.getSysConfig(), 0, request, response);
		// 获取商户的商铺
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (userDetails == null) {
			log.error(" ========= 商户商铺为空 ========== ");
		} else {
			/*String address = configService.getSysConfig().getAddress();
			Map<String, String> map = payTools.exclusiveCode_GetQrPath(address,
					userDetails.getUser().getId());
			for (Map.Entry<String, String> entry : map.entrySet()) {
				mv.addObject(entry.getKey(), entry.getValue());
			}*/
			String address = configService.getSysConfig().getAddress();
			String qr_Address = address + "/q/exclusive.htm?s=" + userDetails.getUser().getId();
			mv.addObject("unified_QrPath", qr_Address);
		}
		return mv;
	}

	/**
	 * 专属码入口
	 * 
	 * @param request
	 * @param response
	 * @param sellerId
	 * @return
	 */
	@SecurityMapping(title = "专属码", value = "/q/exclusive.htm*", rtype = "seller", rname = "专属码", rcode = "exclusive", rgroup = "我的店铺")
	@RequestMapping("/q/exclusive.htm")
	public ModelAndView reqExclusiveCode(HttpServletRequest request, HttpServletResponse response, String s, String t) {
		ModelAndView mv = null;
		if (StringUtils.isBlank(s)) {
			log.error("[scan QR] argument error, selleruid is empty.");
			mv = new ModelAndView("redirect:/500.htm");
			return mv;
		}
		log.debug("[scan QR] arguments: selleruid=" + s);
		String scanArgument = request.getParameter("app");
		log.debug("[scan QR] scan argument app=" + scanArgument);
		// 云尚App扫描
		if (StringUtils.isNotBlank(scanArgument) && "ysysgo".equals(scanArgument)) {
			String uid = request.getParameter("uid");
			log.debug("[scan QR] YUN_SHANG scan: selleruid=" + s + ",uid=" + uid);
			// 验证商家是否合法
			String resultMsg = checkSeller(Long.valueOf(s));
			if (StringUtils.isNotBlank(resultMsg)) {
				log.error("[scan QR,YUN_SHANG scan] errorMsg=" + resultMsg + ",selleruid=" + s);
				mv = new ModelAndView("redirect:/500.htm");
				mv.addObject("errMsg", resultMsg);
			}
			mv = new JModelAndView("qr_pay/mch_wx_qr_pay.html", configService.getSysConfig(), 1, request,
					response);
			// 商家信息
			//SellerBO sellerbo = sellerService.findByUid(Long.valueOf(s));
			SellerBO sellerbo = this.sellerService.findSessionById(Long.valueOf(s), true, false);
			// 店铺信息
			StoreBO storeBo = storeService.getStoreBOById(sellerbo.getStoreId());
			mv.addObject("sellerBo", sellerbo);
			mv.addObject("storeBo", storeBo);
			mv.addObject("uid", uid);
			mv.addObject("orderType", t);
			mv.addObject("payType", "ysysgo");
			return mv;
		}
		String userAgent = request.getHeader("User-Agent").toLowerCase();
		boolean isWeChat = userAgent.toLowerCase().indexOf("micromessenger") > 0 ? true : false;
		boolean isAliPay = userAgent.toLowerCase().indexOf("alipayclient") > 0 ? true : false;
		log.info("======= isWeChat->" + isWeChat + " isAliPay->" + isAliPay);
		if (s != null && s.trim().length() > 0) {
			String payURL = "redirect:";
			if (isWeChat) // 微信支付
			{
				// 重定向到微商城中
				payURL += configService.getSysConfig().getMobileAddress() + "/q/wcQrPay/wx_s.htm?s=" + s;
				// payURL += "http://mobile.ysysgo.cn/q/wcQrPay/wx_s.htm?s=" + s;
			} else if (isAliPay) // 支付宝支付
			{
				payURL += String.format("/q/pay.htm?s=%s&t=alipay", s);
			} else // 浏览器扫码
			{
				payURL += "/q/qr_Prompt.htm";
			}
			log.info("======= payURL->" + payURL);
			mv = new ModelAndView(payURL);
		} else {
			mv = new ModelAndView("redirect:/500.htm");
		}
		return mv;
	}

	private String checkSeller(long selleruid) {
		// 信息验证
		SellerBO sellerbo = sellerService.findByUid(selleruid);
		if (sellerbo == null) {
			return "卖家信息不存在";
		}
		StoreBO storeBo = storeService.getStoreBOById(sellerbo.getStoreId());
		if (storeBo == null) {
			return "店铺信息不存在";
		}
		if (!StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS.equals(storeBo.getStoreStatus())) {
			return "非正常营业店铺不支持收款";
		}
		if (!storeBo.getIsO2o()) {
			return "只有商户账号才能收款";
		}
		return null;
	}

	/**
	 * 扫描提示界面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/q/qr_Prompt.htm")
	public ModelAndView qr_Prompt(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("qr_pay/qr_Prompt.html", configService.getSysConfig(), 1,
				request, response);
		return mv;
	}

	@RequestMapping("/q/refreshSysConfig.htm")
	public ModelAndView getTest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("qr_pay/exclusive_qr_pay.html", configService.getSysConfig(), 1,
				request, response);
		configService.refreshSysConfig();
		/*String jumpToUrl = configService.getSysConfig().getMobileAddress();
		if(jumpToUrl==null)
		{
			configService.refreshSysConfig();
			jumpToUrl = configService.getSysConfig().getMobileAddress();
		}
		String userAgent = request.getHeader("User-Agent").toLowerCase();
		
		System.out.println("============"+jumpToUrl);
		System.out.println(">>>>>>>>>>>>"+userAgent);*/
		return mv;
	}

	/**
	 * 专属码(H5)
	 * 
	 * @param request
	 * @param response
	 * @param s
	 *            sellerUID
	 * @return
	 */
	@RequestMapping(value = "/q/myself_code.htm")
	public ModelAndView myself_code(HttpServletRequest request, HttpServletResponse response, String s) {
		ModelAndView mv = new JModelAndView("qr_pay/myself_code.html", configService.getSysConfig(), 1,
				request, response);
		// 获取商户的商铺
		if (s == null || s.trim().length() <= 0) {
			log.error(" ========= 参数为空========== ");
		} else {
			String address = configService.getSysConfig().getAddress();
			String qr_Address = address + "/q/exclusive.htm?s=" + s;
			mv.addObject("unified_QrPath", qr_Address);
		}
		return mv;
	}
}
