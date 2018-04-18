package vc.thinker.b2b2c.action.weChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.ActionResult;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.service.ShopQrPayOrderService;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.pay.tools.WxMpTools;
import com.sinco.carnation.pay.tools.WxPayTools;
import com.sinco.carnation.pay.tools.WxShareTools;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.bo.ShopQrPayOrderBO;
import com.sinco.carnation.shop.model.ShopQrServerInfo;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.WeChatService;
import com.sinco.common.utils.IPUtil;
import com.sinco.common.utils.StringUtils;
import com.weixin.bean.PayH5QrCode;

/**
 * 四码和一(微信支付)
 */
@Controller
public class WCQrPayAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private ShopQrPayOrderService shopQrPayOrderService;
	@Autowired
	private WxMpTools wxMpTools;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private WxShareTools wxShareTools;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private WxPayTools wxPayTools;
	@Autowired
	private WeChatService weChatService;
	@Autowired
	private UserService userService;
	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private PayTools payTools;
	@Autowired
	private WeChatTool weChatTool;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private OrderFormService orderFormService;

	private static final Logger log = LoggerFactory.getLogger(WCQrPayAction.class);

	@RequestMapping("q/wcQrPay/wx_s.htm")
	public String mch_wx_qr_pay_start(HttpServletRequest request, HttpServletResponse response, Long s,
			Long id) {
		log.debug("[wx_s.htm] arguments, seller id =" + s + ",id =" + id);
		String jumpToUrl = configService.getSysConfig().getMobileAddress() + "/mp/wcQrPay/mch_wx_qr_pay.htm";
		// jumpToUrl +="/mp/wcQrPay/mch_wx_qr_pay.htm";
		log.debug("[wx_s.htm] arguments, jumpToUrl =" + jumpToUrl);
		String state = String.format("%s-%s-%s-%s", s.toString(), "", "", "");
		log.debug("[wx_s.htm] arguments, state =" + state);
		// 获取微信回调url
		StringBuilder redirectUrl = wxMpTools.getMpRedirectUrl(jumpToUrl, state);
		log.debug("[wx_s.htm] callBack=" + redirectUrl);
		return "redirect:" + redirectUrl;
	}

	/**
	 * 四码合一(微信支付-授权回调入口)
	 * 
	 * @param request
	 * @param response
	 * @param code
	 * @param state
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/mp/wcQrPay/mch_wx_qr_pay.htm")
	public ModelAndView mch_wx_qr_pay(HttpServletRequest request, HttpServletResponse response, String code,
			String state) throws Exception {

		log.debug("====================== WeChat Pay Auth Callback ====================== ");

		String[] strArray = state.split("-");

		Long sellerId = CommUtil.null2Long(strArray[0]);
		BigDecimal money = null;
		String server = "";
		String phone = "";

		if (strArray.length > 1 && StringUtils.isNotEmpty(strArray[1])) {
			money = new BigDecimal(strArray[1]);
		}
		if (strArray.length > 2) {
			server = strArray[2];
		}
		if (strArray.length > 3) {
			phone = strArray[3];
		}

		ShopQrServerInfo info = this.saveServerInfo(money, server, phone, code);
		/*String address = configService.getSysConfig().getAddress();
		if(address==null)
		{
			configService.refreshSysConfig();
			address = configService.getSysConfig().getAddress();
		}
		String shopAddress = address+"/q/pay.htm";
		
		log.debug("============== go to ->"+shopAddress);*/

		log.debug("<<<<<<<<<<<<<<<< ShopQrServerInfo ID ->" + info.getId() + " Code->" + info.getCode());
		ModelAndView mv = new ModelAndView("redirect:/q/pay.htm");
		mv.addObject("s", sellerId);
		mv.addObject("id", info.getId());
		mv.addObject("t", "wxpay");
		// mch_qr_pay(request, response, sellerId, "wxpay", info.getId());

//		SysConfigBO sysBo = configService.getSysConfig();
		// 获取access_token参数Map
		Map<String, String> paramMap = new HashMap<String, String>();
		// 公众号的唯一标识
		paramMap.put("appid", this.weChatTool.getWeChatAppID());
		// 公众号的appsecret
		paramMap.put("secret", this.weChatTool.getWeChatAppSecret());
		// code参数
		paramMap.put("code", code);

		/* ***************** 获取access_token ******************  */
		// 请求地址
		String reqURL = this.get_Request_WXAccess_token(paramMap);
		log.debug("....." + reqURL);
		// 发送请求
		String res_Conent = getHttpContent(reqURL, "UTF-8", null);
		log.debug("============================== get weChat access_token result->" + res_Conent);
		// 解析返回参数 获取access_token值
		JSONObject json = JSONObject.fromObject(res_Conent);
		if (!json.containsKey("errcode")) {
			// 网页授权接口调用凭证
			String access_token = json.getString("access_token");
			// 接口调用凭证超时时间，单位（秒）
			int expires_in = json.getInt("expires_in");
			// 用户刷新access_token
			String refresh_token = json.getString("refresh_token");
			// 用户唯一标识
			String openid = json.getString("openid");
			// 用户授权的作用域
			String scope = json.getString("scope");
			// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
			String unionid = "";
			if (json.containsKey("unionid")) {
				unionid = json.getString("unionid");
			}

			long wcUID = 0l;

			/* ****************** 判断用户是否已注册过  ****************** */
			UserAccountBO userAccountBO = this.weChatService.find_WXUnionid_Is_Registered(unionid);
			if (userAccountBO != null) // 已注册过
			{
				wcUID = userAccountBO.getId();
				mv.addObject("openid", openid);
				mv.addObject("uid", wcUID);
				mv.addObject("userId", userAccountBO.getUid());

				// 授权后更新用户Openid,有遗留用户Openid为NULL
				UserAccount userAccount = new UserAccount();
				userAccount.setId(userAccountBO.getId());
				userAccount.setOpenId(openid);
				userAccountService.update(userAccount);
				return mv;
			}
			/* ****************** 未注册则拉取用户信息  注册用户 ****************** */
			paramMap.clear();
			paramMap.put("access_token", access_token);
			paramMap.put("openid", openid);
			// 请求地址 拉取用户信息
			String getUserInfoURL = this.get_Request_UserInfo(paramMap);
			// 获取返回数据
			String userInfoContent = getHttpContent(getUserInfoURL, "UTF-8", null);

			log.info("...." + userInfoContent);

			JSONObject userInfo_Json = JSONObject.fromObject(userInfoContent);
			if (!userInfo_Json.containsKey("errcode")) {
				// 用户的唯一标识
				String openid_ = userInfo_Json.getString("openid");
				// 用户昵称
				String nickName = userInfo_Json.getString("nickname");
				// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
				String sex = userInfo_Json.getString("sex");
				// 用户个人资料填写的省份
				String province = userInfo_Json.getString("province");
				// 普通用户个人资料填写的城市
				String city = userInfo_Json.getString("city");
				// 国家，如中国为CN
				String country = userInfo_Json.getString("country");
				// 用户头像
				String headimgurl = userInfo_Json.getString("headimgurl");
				// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
				String unionid_ = "";
				if (userInfo_Json.containsKey("unionid")) {
					unionid_ = json.getString("unionid");
				}

				long uid = sellerId;
				UserBO user = this.userService.getObjById(uid);
				String invitationCode = user.getInvitationCode();

				paramMap.clear();
				paramMap.put("openid", openid_);
				paramMap.put("nickName", nickName);
				paramMap.put("sex", sex);
				paramMap.put("province", province);
				paramMap.put("city", city);
				paramMap.put("country", country);
				paramMap.put("headimgurl", headimgurl);
				paramMap.put("unionid_", unionid_);
				paramMap.put("invitationCode", invitationCode);
				paramMap.put("requestIp", IPUtil.getIpAddr(request));

				log.debug("................ registerUser params:" + paramMap.toString());
				/**
				 * >>>>>>>>用户注册<<<<<<<
				 */
				UserAccount userAccount = this.weChatService.weChat_RegisterUser(paramMap);
				wcUID = userAccount.getId();
				mv.addObject("openid", openid);
				mv.addObject("uid", wcUID);
				mv.addObject("unionid", unionid_);
				mv.addObject("userId", userAccount.getUid());
				return mv;
			} else {
				log.error("......openid无效  " + json.getString("errmsg"));
			}
		} else {
			log.error(".........Code无效错误  " + json.getString("errmsg"));
		}

		return mv;
	}

	@RequestMapping("/q/pay.htm")
	public ModelAndView mch_qr_pay(HttpServletRequest request, HttpServletResponse response, Long s,
			String t, Long id) throws Exception {

		log.debug("====================== WeChatPay ================= ");

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
		String uid = request.getParameter("uid");
		String openId = request.getParameter("openid");
		String userId = request.getParameter("userId");
		mv.addObject("uid", uid);
		mv.addObject("openId", openId);
		mv.addObject("userId", userId);
		this.wxShareTools.wxShareMv(mv, request);
		return mv;
	}

	@RequestMapping("/q/wx_qr_pay_self_order.htm")
	public void wx_qr_pay_order(HttpServletRequest request, HttpServletResponse response, BigDecimal money,
			Long sellerId, String code, String payType, String phone, String serverName, Long userId,
			String payPwd) {

		try {
			// 信息验证
			SellerBO sellerbo = sellerService.findByUid(sellerId);
			if (sellerbo == null) {
				returnBody(response, Json.toJson(ActionResult.NewFail("卖家信息不存在")));
				return;
			}
			if (money.compareTo(BigDecimal.ZERO) < 1) {
				returnBody(response, Json.toJson(ActionResult.NewFail("支付金额必须大于0")));
				return;
			}
			StoreBO storeBo = storeService.getStoreBOById(sellerbo.getStoreId());
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
				if (phone != null && phone.trim().length() > 0) {
					UserCustomerBO customer = userCustomerService.findByMobile(phone);
					if (customer == null || !customer.getUid().equals(userId)) {
						returnBody(response, Json.toJson(ActionResult.NewFail("该用户手机号码错误")));
						return;
					}
				}
			}
			String webPath = configService.getSysConfig().getAddress();

			if (payType.equals("wxpay")) // 微信支付
			{
				log.debug("======================= do WeChat Start ======================== ");
				String uid = request.getParameter("uid");
				String openId = request.getParameter("openid");
				log.debug("<<<<<<<<<<<<< uid->" + uid + " openId->" + openId);
				// groupOrderService.createGroupOrder(Long.valueOf(uid), "微信扫描支付", money);
				PayH5QrCode order = payTools.mchWxQrPay(sellerbo, money, originalPrice, webPath, openId,
						phone, serverName, userId);
				returnBody(response, Json.toJson(ActionResult.NewSuccess(order)));

			} else if (payType.equals("alipay")) { // 支付宝支付
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

	@RequestMapping("/q/wx_qr_pay_goods_order.htm")
	public void wx_qr_pay_goods_order(HttpServletRequest request, HttpServletResponse response,
			BigDecimal money, String orderNo, String payType, String serverName, String userId, String openId) {

		try {
			if (money.compareTo(BigDecimal.ZERO) < 1) {
				returnBody(response, Json.toJson(ActionResult.NewFail("支付金额必须大于0")));
				return;
			}

			String webPath = configService.getSysConfig().getAddress();

			if (payType.equals("wxpay")) // 微信支付
			{
				OrderFormBO obj = this.orderFormService.findByOrderNo(orderNo);
				log.debug("======================= do WeChat Start ======================== ");
				PayH5QrCode order = payTools.mchWxQrPayOrder(webPath, money, obj.getOrderId(),
						obj.getTradeNo(), openId);
				returnBody(response, Json.toJson(ActionResult.NewSuccess(order)));

			}
		} catch (ServiceException e) {
			returnBody(response, Json.toJson(ActionResult.NewFail(e.getErrorCode())));
		} catch (Exception e) {
			log.error(String.format("商家店内扫描出现错误:%s", CommUtil.getStackTrace(e)));
			returnBody(response, Json.toJson(ActionResult.NewFail(e.getMessage())));
		}

	}

	/**
	 * 
	 * @param response
	 * @param json
	 */
	public void returnBody(HttpServletResponse response, String json) {
		CommUtil.returnBody(response, json);
	}

	@RequestMapping(value = "/mp/wcQrPay/test_test.htm")
	public ModelAndView test_test(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("index.html", configService.getSysConfig(), 1, request, response);
		return mv;
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

	// 通过code换取网页授权access_token URL
	// private static final String req_WX_Access_Token = "https://api.weixin.qq.com/sns/oauth2/access_token?";
	private static final String req_WX_Access_Token = "https://api.weixin.qq.com/sns/oauth2/access_token?"
			+ "appid={0}&secret={1}&code={2}&grant_type=authorization_code";

	/**
	 * 生成用于获取access_token的Code的Url
	 * 
	 * @param paramMap
	 * @return
	 */
	private String get_Request_WXAccess_token(Map<String, String> paramMap) {
		String result_URL = "";
		if (paramMap != null) {
			log.info("<<<<<<<< " + paramMap.toString());
			result_URL = MessageFormat.format(req_WX_Access_Token, paramMap.get("appid"),
					paramMap.get("secret"), paramMap.get("code"));
		}
		return result_URL;
	}

	/**
	 * 模拟http访问，返回相关数据
	 * 
	 * @param url
	 *            请求地址
	 * @param charSet
	 *            编码
	 * @param method
	 *            请求方法
	 * @return
	 */
	private static String getHttpContent(String url, String charSet, String method) {
		HttpURLConnection connection = null;
		String content = "";
		if (method == null || method.trim().length() == 0) {
			method = "GET";
		}
		try {
			URL address_url = new URL(url);
			connection = (HttpURLConnection) address_url.openConnection();
			connection.setRequestMethod(method);
			// 设置访问超时时间及读取网页流的超时时间,毫秒值
			connection.setConnectTimeout(1000000);
			connection.setReadTimeout(1000000);
			// 得到访问页面的返回值
			int response_code = connection.getResponseCode();
			if (response_code == HttpURLConnection.HTTP_OK) {
				InputStream in = connection.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in, charSet));
				String line = null;
				while ((line = reader.readLine()) != null) {
					content += line;
				}
				return content;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return "";
	}

	// 拉取用户信息URL
	private static final String req_WX_GetUserInfo_URL = "https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}&lang=zh_CN";

	/**
	 * 生成用于获取access_token的Code的Url
	 * 
	 * @param paramMap
	 * @return
	 */
	private String get_Request_UserInfo(Map<String, String> paramMap) {
		String result_URL = "";
		if (paramMap != null) {
			log.info("<<<<<<<< " + paramMap.toString());
			result_URL = MessageFormat.format(req_WX_GetUserInfo_URL, paramMap.get("access_token"),
					paramMap.get("openid"));
		}
		return result_URL;
	}
}
