package vc.thinker.b2b2c.action;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elasticsearch.common.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dic.client.util.WebUtils;

/**
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("wx_act")
public class WxShareAction {

	@Autowired
	private SysConfigService configService;

	Logger logger = Logger.getLogger("WxShare");

	String _appId = "wx9d38abce10c26432";
	String _appSecret = "ff29a5f99cc707ae720c0d210ab666f6";
	String _wxCode = "wxappcode";// "test5";

	@RequestMapping(value = "/index", method = {RequestMethod.GET})
	public ModelAndView indexView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("wx_red_package/wx_red_package_index.html",
				configService.getSysConfig(), 1, request, response);
		return this.wxShareMv(mv, request);
	}

	@RequestMapping(value = "/talk_m", method = {RequestMethod.GET})
	public ModelAndView indexTalkmView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("wx_red_package/talk_m.html", configService.getSysConfig(), 1,
				request, response);
		wxShareMv(mv, request);
		return mv;
	}

	@RequestMapping(value = "/talk_g", method = {RequestMethod.GET})
	public ModelAndView indexTalkgView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("wx_red_package/talk_g.html", configService.getSysConfig(), 1,
				request, response);
		wxShareMv(mv, request);
		return mv;
	}

	@RequestMapping(value = "/talk_ds", method = {RequestMethod.GET})
	public ModelAndView indexTalkdsView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("wx_red_package/talk_ds.html", configService.getSysConfig(), 1,
				request, response);
		wxShareMv(mv, request);
		return mv;
	}

	@RequestMapping(value = "/talk_hb", method = {RequestMethod.GET})
	public ModelAndView indexTalkhbView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("wx_red_package/talk_hb.html", configService.getSysConfig(), 1,
				request, response);
		wxShareMv(mv, request);
		return mv;
	}

	@RequestMapping(value = "/talk_lxlt", method = {RequestMethod.GET})
	public ModelAndView indexTalklxltView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("wx_red_package/talk_lxlt.html", configService.getSysConfig(), 1,
				request, response);
		wxShareMv(mv, request);
		return mv;
	}

	@RequestMapping(value = "/talk_zwj", method = {RequestMethod.GET})
	public ModelAndView indexTalkzwjView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("wx_red_package/talk_zwj.html", configService.getSysConfig(), 1,
				request, response);
		wxShareMv(mv, request);
		return mv;
	}

	@RequestMapping(value = "/talk_zxc", method = {RequestMethod.GET})
	public ModelAndView indexTalkzxcView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("wx_red_package/talk_zxc.html", configService.getSysConfig(), 1,
				request, response);
		wxShareMv(mv, request);
		return mv;
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
		mv.addObject("vcode", _wxCode);
		mv.addObject("nonceStr", signatureMap.get("nonceStr"));
		mv.addObject("timestamp", signatureMap.get("timestamp"));
		mv.addObject("signature", signatureMap.get("signature"));
		mv.addObject("url", "/wx_act/index.htm?invitationCode=" + getInvitationCode(request));// url
		// 邀请码
		mv.addObject("invitationCode", getInvitationCode(request));

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
