package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.pay.tools.WxAccountConfig;
import com.sinco.carnation.pay.tools.WxMpMenueToops;
import com.sinco.carnation.pay.tools.WxMpTools;
import com.sinco.carnation.pay.tools.WxPayTools;
import com.sinco.carnation.pay.tools.WxShareTools;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.model.WxMsgLog;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.WxMsgLogService;
import com.sinco.carnation.user.service.UserWeiXinRelationService;
import com.thoughtworks.xstream.XStream;
import com.weixin.mp.util.InputMessage;
import com.weixin.mp.util.OutputMessage;
import com.weixin.mp.util.SerializeXmlUtil;
import com.weixin.mp.util.WxMsgType;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.pay.tenpay.util.Sha1Util;

/**
 * 微信公众号开发
 * 
 * @author 陈舟
 * 
 */
@Controller
@RequestMapping("/wxmp")
public class WxMpAction {

	@Autowired
	private WxShareTools wxShareTools;
	@Autowired
	private WxMpTools wxMpTools;
	@Autowired
	private WxPayTools wxPayTools;
	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private UserWeiXinRelationService userWeiXinRelationService;

	private static final Logger log = LoggerFactory.getLogger(WxMpAction.class);
	@Autowired
	private WxMsgLogService wxMsgLogService;

	@RequestMapping(value = "/notify.htm", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public void notify(HttpServletRequest request, HttpServletResponse response) {
		log.info("进入wxmp --> notify");
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		if (isGet) {
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");

			log.info(signature);
			log.info(timestamp);
			log.info(nonce);
			log.info(echostr);

			access(request, response);
		} else {
			// 进入POST聊天处理
			log.info("enter post");
			try {
				// 接收消息并返回消息
				acceptMessage(request, response);
			} catch (IOException e) {
				log.error("微信接受消息错误：{}", CommUtil.getStackTrace(e));
			}
		}
	}

	/**
	 * 验证URL真实性
	 * 
	 * @author morning
	 * @date 2015年2月17日 上午10:53:07
	 * @param request
	 * @param response
	 * @return String
	 */
	private String access(HttpServletRequest request, HttpServletResponse response) {
		// 验证URL真实性
		log.info("进入验证access");
		String signature = request.getParameter("signature");// 微信加密签名
		String timestamp = request.getParameter("timestamp");// 时间戳
		String nonce = request.getParameter("nonce");// 随机数
		String echostr = request.getParameter("echostr");// 随机字符串
		List<String> params = new ArrayList<String>();
		params.add(WxAccountConfig.TOKEN);
		params.add(timestamp);
		params.add(nonce);
		// 1. 将token、timestamp、nonce三个参数进行字典序排序
		Collections.sort(params, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
		String temp = Sha1Util.getSha1(params.get(0) + params.get(1) + params.get(2));
		if (temp.equals(signature)) {
			try {
				response.getWriter().write(echostr);
				log.info("成功返回 echostr：" + echostr);
				return echostr;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.info("失败 认证");
		return null;
	}

	@SuppressWarnings("unused")
	private void acceptMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 处理接收消息
		ServletInputStream in = request.getInputStream();
		// 将POST流转换为XStream对象
		XStream xs = SerializeXmlUtil.createXstream();
		xs.processAnnotations(InputMessage.class);
		xs.processAnnotations(OutputMessage.class);
		// 将指定节点下的xml节点数据映射为对象
		xs.alias("xml", InputMessage.class);
		// 将流转换为字符串
		StringBuilder xmlMsg = new StringBuilder();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			xmlMsg.append(new String(b, 0, n, "UTF-8"));
		}
		// 将xml内容转换为InputMessage对象
		InputMessage inputMsg = (InputMessage) xs.fromXML(xmlMsg.toString());

		String servername = inputMsg.getToUserName();// 服务端
		String custermname = inputMsg.getFromUserName();// 客户端
		long createTime = inputMsg.getCreateTime();// 接收时间
		Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间

		// 取得消息类型
		String msgType = inputMsg.getMsgType();

		WxMsgLog msgLog = new WxMsgLog();
		msgLog.setType(msgType);
		msgLog.setContent(Json.toJson(inputMsg));
		wxMsgLogService.save(msgLog);

		// 根据消息类型获取对应的消息内容
		if (msgType.equalsIgnoreCase(WxMsgType.TEXT)) {
			String content = "云尚是云尚（中国）健康管理集团旗下的一款服务用户移动健康管理APP，云尚（中国）健康管理集团以领先于行业的健康管理理念，应用健康智能手环、APP手机客户端、大数据、云计算、云空间等现代科技手段，打造了一个集健康管理服务、同业联盟O2O、移动支付和积分通兑为一体的综合性健康管理与增值服务平台。服务热线：xxxxxxxx";

			replayWxMsg(response, servername, custermname, returnTime, msgType, content);
		}

		// 获取并返回多图片消息
		if (msgType.equalsIgnoreCase(WxMsgType.IMAGE)) {

			// OutputMessage outputMsg = new OutputMessage();
			// outputMsg.setFromUserName(servername);
			// outputMsg.setToUserName(custermname);
			// outputMsg.setCreateTime(returnTime);
			// outputMsg.setMsgType(msgType);
			// ImageMessage images = new ImageMessage();
			// images.setMediaId(inputMsg.getMediaId());
			// outputMsg.setImage(images);
			// log.info("xml转换：/n" + xs.toXML(outputMsg));
			// response.getWriter().write(xs.toXML(outputMsg));

		}

		// 事件消息
		if (msgType.equalsIgnoreCase(WxMsgType.EVENT)) {
			String event = inputMsg.getEvent();
			// 关注事件
			if (event.equalsIgnoreCase(WxMsgType.WxEventType.SUBSCRIBE)) {
				String eventKey = inputMsg.getEventKey();
				if (eventKey.startsWith("qrscene_")) {
					// String suffix = eventKey.substring(8, eventKey.length());
					// String[] strArray = suffix.split(",");
					// // 扫描二维码 后面带 scene_str，这里通过sceneid 来添加推荐关系
					// Long belongUserId = CommUtil.null2Long(strArray[1]);
					//
					// String unionid = strArray[0];
					//
					// // 创建关系
					// String replayStr =
					// userWeiXinRelationService.createAndBindRelateByWeixin(custermname,
					// belongUserId);
					//
					// if (StringUtils.isEmpty(replayStr)) {
					// // 回复
					// replayWxMsg(response, servername, custermname,
					// returnTime, WxMsgType.TEXT, "恭喜您加入云尚！");
					// } else {
					// replayWxMsg(response, servername, custermname,
					// returnTime, WxMsgType.TEXT, replayStr);
					// }
				}
			} else if (event.equalsIgnoreCase(WxMsgType.WxEventType.CLICK)) {
				String eventKey = inputMsg.getEventKey();
				String msg = wxMpMenueToops.getButtonClickMsg(eventKey);
				replayWxMsg(response, servername, custermname, returnTime, WxMsgType.TEXT, msg);
			}
		}
	}

	@Autowired
	private WxMpMenueToops wxMpMenueToops;

	private void replayWxMsg(HttpServletResponse response, String servername, String custermname,
			Long returnTime, String msgType, String content) throws IOException {
		// 文本消息
		StringBuffer str = new StringBuffer();
		str.append("<xml>");
		str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");
		str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");
		str.append("<CreateTime>" + returnTime + "</CreateTime>");
		str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
		str.append("<Content><![CDATA[").append(content).append("]]></Content>");
		str.append("</xml>");
		log.info(str.toString());
		response.getWriter().write(str.toString());
	}

	/**
	 * 初始化菜单
	 * 
	 * @param request
	 * @param response
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/init_menue.htm", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String init_menue(HttpServletRequest request, HttpServletResponse response, String key) {
		boolean flag = false;
		String token = "";
		if (key.equals("jg_yes_123")) {
			String url = configService.getSysConfig().getAddress() + "/wxmp/qr_invitation_show.htm";

			url = wxMpTools.getMpRedirectUrl(url, "").toString();
			token = wxShareTools.getToken();
			String menueData = Json.toJson(wxMpMenueToops.getInitMenueList(url));

			flag = wxMpTools.initMenue(token, menueData);
		}
		return "token " + token + " - " + CommUtil.null2String(flag);
	}

	/**
	 * 展示我的推广二维码
	 * 
	 * @param request
	 * @param response
	 * @param code
	 * @param state
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "null"})
	@RequestMapping(value = "/qr_invitation_show.htm", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView qr_invitation_show(HttpServletRequest request, HttpServletResponse response,
			String code) {
		SysConfigBO sysBo = configService.getSysConfig();

		ModelAndView mv = new JModelAndView("wxmp/qr_invitation_show.html", sysBo, 1, request, response);

		Map map = wxPayTools.getAccesssTokenMap(code);
		if (map == null && map.size() > 0) {
			mv.addObject("errMsg", "openid 获取失败");
			return mv;
		}

		Map mapWxUser = wxPayTools.getWxUserInfoMap(map.get("access_token").toString(), map.get("openid")
				.toString());
		if (mapWxUser == null && mapWxUser.size() > 0) {
			mv.addObject("errMsg", "微信用户信息 获取失败");
			return mv;
		}
		log.info("unionid" + Json.toJson(mapWxUser));

		UserAccountBO bo = userAccountService.queryAccountByOpenId(mapWxUser.get("unionid").toString(), 4);
		if (bo == null) {
			mv.addObject("errMsg", "您还未在云尚绑定手机号！");
			return mv;
		}
//		String token = wxShareTools.getToken();
//		Map mapwx = wxMpTools.getQrUrl(token, mapWxUser.get("unionid").toString() + "," + bo.getUid().toString());

		mv.addObject("wxNickName", mapWxUser.get("nickname"));
		mv.addObject("headImgUrl", mapWxUser.get("headimgurl"));

		String qrUrl = sysBo.getAddress() + "/wxmp/qr?u=" + bo.getUid();
		mv.addObject("qrUrl", qrUrl);

		wxShareTools.wxShareMv(mv, request);

		return mv;
	}

	/**
	 * 被推荐人，扫一扫入口
	 * 
	 * @param request
	 * @param response
	 * @param u
	 * @return
	 */
	@RequestMapping(value = "/qr", method = {RequestMethod.GET, RequestMethod.POST})
	public String qr(HttpServletRequest request, HttpServletResponse response, Long u) {

		SysConfigBO sysBo = configService.getSysConfig();
		String qrUrl = sysBo.getAddress() + "/wxmp/qr_deal.htm";
		String url = wxMpTools.getMpRedirectUrl(qrUrl, CommUtil.null2String(u)).toString();

		return "redirect:" + url;

	}

	/**
	 * 被推荐人，扫一扫详细处理， 绑定推荐关系
	 * 
	 * @param request
	 * @param response
	 * @param code
	 * @param state
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "null"})
	@RequestMapping(value = "/qr_deal.htm", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView qr_deal(HttpServletRequest request, HttpServletResponse response, String code,
			String state) {

		SysConfigBO sysBo = configService.getSysConfig();
		ModelAndView mv = new JModelAndView("wxmp/qr_deal.html", sysBo, 1, request, response);
		Map map = wxPayTools.getAccesssTokenMap(code);
		if (map == null && map.size() > 0) {
			mv.addObject("errMsg", "openid 获取失败");
			return mv;
		}
		String openId = map.get("openid").toString();

		Map<String, String> mapWxUser = wxPayTools.getWxUserInfoMap(map.get("access_token").toString(),
				openId);
		if (mapWxUser == null && mapWxUser.size() > 0) {
			mv.addObject("errMsg", "微信用户信息 获取失败");
			return mv;
		}
		log.info("unionid" + Json.toJson(mapWxUser));
		String unionId = mapWxUser.get("unionid").toString();
		String nickname = mapWxUser.get("nickname").toString();
		String headimgurl = mapWxUser.get("headimgurl").toString();

		// 创建关系
		String errMsg = userWeiXinRelationService.createAndBindRelateByWeixin(unionId, openId, nickname,
				headimgurl, CommUtil.null2Long(state));

		if (StringUtils.isEmpty(errMsg)) {
			errMsg = "恭喜您加入云尚！</br>请下载云尚使用微信授权登录，更多精彩等着您！";
		}
		mv.addObject("errMsg", errMsg);

		mv.addObject("wxNickName", nickname);
		mv.addObject("headImgUrl", mapWxUser.get("headimgurl"));
		wxShareTools.wxShareMv(mv, request);
		return mv;
	}

	/**
	 * 推广二维码分享
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @param n
	 * @param h
	 * @return
	 */
	@RequestMapping(value = "/qr_invitation_share.htm", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView qr_invitation_share(HttpServletRequest request, HttpServletResponse response,
			String qrUrl, String n, String h) {

		ModelAndView mv = new JModelAndView("wxmp/qr_invitation_share.html", configService.getSysConfig(), 1,
				request, response);
		mv.addObject("wxNickName", n);
		mv.addObject("headImgUrl", h);
		mv.addObject("qrUrl", qrUrl);
		wxShareTools.wxShareMv(mv, request);
		return mv;
	}
}
