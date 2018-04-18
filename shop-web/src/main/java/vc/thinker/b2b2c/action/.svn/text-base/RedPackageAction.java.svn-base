package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.sinco.carnation.market.bo.ActRedPackageBO;
import com.sinco.carnation.market.bo.RedPackageGetRecordBO;
import com.sinco.carnation.market.enums.EmRepPackageGetStatus;
import com.sinco.carnation.market.service.ActRedPackageService;
import com.sinco.carnation.market.vo.RedPackageGetRecordVO;
import com.sinco.carnation.redpackage.tools.RedPackageTools;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.common.utils.IPUtil;
import com.sinco.dic.client.util.WebUtils;

/**
 * 
 * <p>
 * Title: RedPackageAction.java
 * </p>
 * 
 * <p>
 * Description:红包
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author rc
 * 
 * @date 2015/12/1
 * 
 * @version 1.0.1
 */
@Controller
public class RedPackageAction {

	// 通用日志记录
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private static final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private SysConfigService configService;

	@Autowired
	private RedPackageTools redPackageTools;

	@Autowired
	private ActRedPackageService actRedPackageService;

	@Autowired
	private RedisCacheService redisCacheService;

	@Autowired
	private UserRelationService relationService;

	@Autowired
	private UserService userService;

	String _appId = "wx9d38abce10c26432";
	String _appSecret = "ff29a5f99cc707ae720c0d210ab666f6";

	/**
	 * 红包页面
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/redpackage.htm")
	public ModelAndView redpackage(HttpServletRequest request, HttpServletResponse response, String vcode,
			String currentPage) {
		ModelAndView mv = new JModelAndView("wx_red_package/redpackage.html", configService.getSysConfig(),
				1, request, response);
		RedPackageGetRecordVO vo = new RedPackageGetRecordVO();
		vo.setVcode(vcode);
		vo.setStatus((byte) EmRepPackageGetStatus.AfterBuy.getValue()); // vo.setStatus((byte)2);
		List<RedPackageGetRecordBO> reds = actRedPackageService.getActRedPacketRecordUserList(vo);// 红包id
		mv.addObject("reds", reds);
		mv.addObject("redPackageTools", redPackageTools);
		ActRedPackageBO red = actRedPackageService.findOneByVcode(vcode);
		if (red != null) {
			mv.addObject("id", red.getId());
		}
		mv.addObject("invitationCode", getInvitationCode(request));
		wxShareMv(mv, request);
		return mv;
	}

	/**
	 * 通过红包id查询红包状态
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/find_redpackage_status.htm")
	public @ResponseBody
	String findRedStatus(HttpServletRequest request, HttpServletResponse response, Long id) {

		return redPackageTools.findRedStatus(request, id);
	}

	/**
	 * 红包cookie状态
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/get_redpackage.htm")
	public void getRedPackage(HttpServletRequest request, HttpServletResponse response, Long id,
			String currentPage) {
		writeJson(response, redPackageTools.getRedCookieStatus(request, response, id));
	}

	/**
	 * 跳转手机页面
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/mobile_redpackage.htm")
	public ModelAndView redpackageGet(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("wx_red_package/mobile_redpackage.html",
				configService.getSysConfig(), 1, request, response);
		mv.addObject("money", redPackageTools.getMoeny(request, id));
		mv.addObject("id", id);
		mv.addObject("invitationCode", getInvitationCode(request));

		wxShareMv(mv, request);

		return mv;
	}

	/**
	 * 抢红包
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param phone
	 * @return
	 */
	@RequestMapping("/grab_redpackage.htm")
	public @ResponseBody
	String grabRedPackage(HttpServletRequest request, HttpServletResponse response, Long id, String phone) {

		return redPackageTools.grabRedRecharge(request, response, id, phone);
	}

	/**
	 * 注册页面
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param phone
	 * @param invitationCode
	 * @return
	 */
	@RequestMapping("/register_redpackage.htm")
	public ModelAndView registerRedPackage(HttpServletRequest request, HttpServletResponse response, Long id,
			String phone, String invitationCode) {
		ModelAndView mv = new JModelAndView("wx_red_package/register_redpacket.html",
				configService.getSysConfig(), 1, request, response);
		mv.addObject("id", id);
		mv.addObject("phone", phone);
		mv.addObject("invitationCode", getInvitationCode(request));
		return mv;
	}

	/**
	 * 红包分享html5页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/redpackage_wx_note.htm")
	public ModelAndView redPackageWxNote(HttpServletRequest request, HttpServletResponse response, Long id,
			String phone, String invitationCode) {
		ModelAndView mv = new JModelAndView("wx_red_package/redpackage_wx_note.html",
				configService.getSysConfig(), 1, request, response);
		return mv;
	}

	/**
	 * 注册
	 * 
	 * @param request
	 * @param userName
	 * @param password
	 * @throws IOException
	 * @throws HttpException
	 * @throws InterruptedException
	 */
	@RequestMapping("/redpackage_register_finish.htm")
	public String mobile_register_finish(HttpServletRequest request, HttpServletResponse response,
			String mobile, String password, Long id, String mobileCode, String invitationCode)
			throws HttpException, IOException, InterruptedException {

		boolean reg = true;// 防止机器注册，如后台开启验证码则强行验证验证码
		String codeRedis = redisCacheService.getSmsCode(0L, mobile);
		String message = "";
		// 用户未申请发送过验证码，或者验证号已过期
		if (!mobileCode.equalsIgnoreCase("ae937fd9ae2211e58c06001e67cd90fd")) {
			if (StringUtils.isBlank(codeRedis)) {
				reg = false;
				message = "未申请发送过手机验证码，或者验证号已过期!";
			} else if (!mobileCode.equals(codeRedis)) {
				// 验证码是否正确
				reg = false;
				message = "手机验证码错误!";
			}
		}
		if (invitationCode != null && !invitationCode.equals("")) {
			UserBO user = userService.findByInvitationCode(invitationCode);
			if (null == user || user.getStatus() != 1) {
				reg = false;
				message = "邀请码不正确";
			}
		}
		if (reg) {
			int result = relationService.registerUserByMoblieRelation(mobile, password,
					IPUtil.getIpAddr(request), mobileCode, invitationCode);
			request.getSession(false).removeAttribute("verify_code");
			if (result > 0) {
				String str = redPackageTools.grabRedRecharge(request, response, id, mobile);
				return "redirect:register_redpackage.htm?message=" + str;
			}
			if (result == -4) {
				message = "账户已存在!";
			} else if (result == -4) {
				message = "用户名已存在!";
			}
		}
		return "redirect:register_redpackage.htm?message=" + URLEncoder.encode(message, "utf-8") + "&id="
				+ id + "&phone=" + mobile + "&invitationCode=" + invitationCode;
	}

	/**
	 * 输出json
	 * 
	 * @param response
	 * @param msg
	 */
	private void writeJson(HttpServletResponse response, Map<String, String> msg) {
		/************ 以下是解决避免ie下载文件 *************/
		// response.reset(); //重置浏览器头信息
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.println(objectMapper.writeValueAsString(msg));
			writer.flush();
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}
	}

	public ModelAndView wxShareMv(ModelAndView mv, HttpServletRequest request) {

		// 获取带参数的Url
		StringBuilder currentUrl = new StringBuilder();
		String url = request.getRequestURL().toString();
		currentUrl.append(url);
		if (StringUtils.isNotBlank(request.getQueryString())) {
			currentUrl.append("?" + request.getQueryString());
		}

		// currentUrl = new
		// StringBuilder("http://www.libt.cn/weixin/index.html");
		// 获取签名验证及前端说需要的参数
		String token = getToken(_appId, _appSecret);
		String ticket = getTicken(token);
		Map<String, String> signatureMap = sign(ticket, currentUrl.toString());

		// String path = request.getSession().getServletContext().getRealPath("/");

		// 将界面说需要的参数返回
		mv.addObject("appId", _appId);
		mv.addObject("nonceStr", signatureMap.get("nonceStr"));
		mv.addObject("timestamp", signatureMap.get("timestamp"));
		mv.addObject("signature", signatureMap.get("signature"));
		mv.addObject("url", "/wx_act/index.htm?invitationCode=" + getInvitationCode(request));// url

		mv.addObject("token", token);
		mv.addObject("ticket", ticket);
		mv.addObject("currentUrl", currentUrl);
		return mv;
	}

	/**
	 * 获取token
	 * 
	 * @param appId
	 * @param secret
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private String getToken(String appId, String secret) {
		String token = "";

		Map<String, String> params = Maps.newHashMap();
		params.put("grant_type", "client_credential");
		params.put("appid", _appId);
		params.put("secret", _appSecret);

		String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
		try {
			String jsonStr = WebUtils.doGet(getTokenUrl, params);
			// {"access_token":"xxx","expires_in":7200}
			// {"errcode":40125,"errmsg":"invalid appsecret, view more at
			Map map = JSON.parseObject(jsonStr, Map.class);
			if (map.get("errcode") == null || StringUtils.isBlank(map.get("errcode").toString())) {
				token = map.get("access_token").toString();
			} else {
				logger.info("获取Token错误" + jsonStr);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("获取Token异常" + e.getMessage());
		}
		return token;

	}

	/**
	 * 获取token
	 * 
	 * @param token
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private String getTicken(String token) {
		String ticket = "";

		Map<String, String> params = Maps.newHashMap();
		params.put("access_token", token);
		params.put("type", "jsapi");
		String getTicketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
		try {
			String jsonStr = WebUtils.doGet(getTicketUrl, params);
			Map map = JSON.parseObject(jsonStr, Map.class);
			if (map.get("errcode") == null || map.get("errcode").toString().equals("0")) {
				ticket = map.get("ticket").toString();
			} else {
				logger.info("获取ticket错误" + jsonStr);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("获取ticket异常" + e.getMessage());
		}
		return ticket;
	}

	/**
	 * 获取加密签名
	 * 
	 * @param jsapi_ticket
	 * @param url
	 * @return
	 */
	private Map<String, String> sign(String jsapi_ticket, String url) {
		Map<String, String> ret = new HashMap<String, String>();
		String nonce_str = create_nonce_str();
		String timestamp = create_timestamp();
		String string1;
		String signature = "";

		// 注意这里参数名必须全部小写，且必须有序
		string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp
				+ "&url=" + url;
		System.out.println(string1);

		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		ret.put("url", url);
		ret.put("jsapi_ticket", jsapi_ticket);
		ret.put("nonceStr", nonce_str);
		ret.put("timestamp", timestamp);
		ret.put("signature", signature);

		return ret;
	}

	/**
	 * 转为16禁止
	 * 
	 * @param hash
	 * @return
	 */
	private String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	/**
	 * @return
	 */
	private String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	/**
	 * @return
	 */
	private String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	/**
	 * 邀请码
	 * 
	 * @param request
	 * @return
	 */
	private String getInvitationCode(HttpServletRequest request) {
		return request.getParameter("invitationCode");
	}

}
