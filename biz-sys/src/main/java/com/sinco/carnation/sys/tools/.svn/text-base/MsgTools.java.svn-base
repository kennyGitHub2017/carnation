package com.sinco.carnation.sys.tools;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.PopupAuthenticator;

import com.sinco.biz.utils.RedisCacheUtils;
import com.sinco.carnation.sys.dao.TemplateDao;
import com.sinco.carnation.sys.model.Template;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.messager.MessageHandler;
import com.sinco.messager.mobile.MobileMessageHandler;

/**
 * 
 * <p>
 * Title: MsgTools.java<／p>
 * 
 * <p>
 * Description: 系统手机短信、邮件发送工具类，手机短信发送需要运营商购买短信平台提供的相关接口信息，邮件发送需要正确配置邮件服务器， 运营商管理后台均有相关配置及发送测试（erikzhang） <／p>
 * <p>
 * 发送短信邮件工具类 参数json数据 buyer_id:如果有买家，则买家user.id seller_id:如果有卖家,卖家的user.id sender_id:发送者的user.id
 * receiver_id:接收者的user.id order_id:如果有订单 订单order.id childorder_id：如果有子订单id goods_id:商品的id self_goods: 如果是自营商品
 * 则在邮件或者短信显示 平台名称 SysConfig.title,（jinxinzhe）
 * 
 * 其中收费工具类只作为商家和用户在交易中的发送工具类，发送的短信邮件均收费，需要商家在商家中心购买相应数量的短信和邮件， 在短信和邮件数量允许的情况下才能发送（hezeng）
 * </p>
 * 
 * 
 * <p>
 * Copyright: Copyright (c) 2015<／p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc<／p>
 * 
 * @author thinker，jinxinzhe，hezeng
 * 
 * @date 2015-5-20
 * 
 * @version 1.0.1
 */
@Component
public class MsgTools {
	private static final Logger logger = LoggerFactory.getLogger(MsgTools.class);
	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserService userService;
	@Autowired
	private TemplateDao templateDao;

	@Autowired
	private RedisCacheUtils bizCacheUtils;

	@Resource(name = "jpushMobileMessageHandler")
	private MobileMessageHandler mobileMessageHandler;
	@Resource(name = "smsMessageHandler")
	private MessageHandler smsHandler;

	@Autowired
	private static final String MSG_CACHE_KEY = "sms:";

	/**
	 * 收费短信发送方法，商家购买短信或者邮件后，当商家有交易订单需要发送短信提醒商家或者订单用户时使用该收费工具
	 * 
	 * @param request
	 * @param mark
	 * @param mobile
	 * @param json
	 *            :参数json，发送非订单信息的参数
	 * @param order_id
	 *            ：订单id，
	 * @throws Exception
	 */
	@Async
	public void sendSmsCharge(String web, String mark, String mobile, String json, String order_id,
			String store_id) throws Exception {
		if (this.configService.getSysConfig().getSmsEnbale()) {
			// Template template = this.templateDao.findByMark(mark);
			// Store store = null;
			// boolean flag = false;
			// Map function_map = new HashMap();
			// List<Map> function_maps = new ArrayList<Map>();
			// if (store_id != null && !store_id.equals("")) {
			// // store = this.storeService.getObjById(CommUtil
			// // .null2Long(store_id));
			// if (store.getStoreSmsCount() > 0) {
			// function_maps = (List<Map>) Json.fromJson(store
			// .getSmsEmailInfo());
			// for (Map temp_map2 : function_maps) {
			//
			// if (template != null
			// && CommUtil.null2String(temp_map2.get("type"))
			// .equals(CommUtil.null2String(template
			// .getType()))
			// && CommUtil.null2String(temp_map2.get("mark"))
			// .equals(template.getMark())) {
			// function_map = temp_map2;
			// if (CommUtil.null2Int(function_map.get("sms_open")) == 1) {//
			// 验证功能是否开启
			// flag = true;
			// break;
			// } else {
			// System.out.println("商家已关闭该短信发送功能");
			// }
			// }
			// }
			// }
			// }
			// if (flag && template != null && template.getOpen()) {
			// ExpressionParser exp = new SpelExpressionParser();
			// EvaluationContext context = new StandardEvaluationContext();
			// Map map = this.queryJson(json);
			// if (mobile != null && !mobile.equals("")) {
			// if (order_id != null) {
			// // OrderForm order = this.orderFormService
			// // .getObjById(CommUtil.null2Long(order_id));
			// // User buyer = this.userService.getObjById(CommUtil
			// // .null2Long(order.getUserId()));
			// // context.setVariable("buyer", buyer);
			// if (store != null) {
			// //context.setVariable("seller", store.getUser());
			// }
			// context.setVariable("config",
			// this.configService.getSysConfig());
			// context.setVariable("send_time",
			// CommUtil.formatLongDate(new Date()));
			// context.setVariable("webPath", web);
			// // context.setVariable("order", order);
			// }
			// if (map.get("receiver_id") != null) {
			// Long receiver_id = CommUtil.null2Long(map
			// .get("receiver_id"));
			// User receiver = this.userService
			// .getObjById(receiver_id);
			// context.setVariable("receiver", receiver);
			// }
			// if (map.get("sender_id") != null) {
			// Long sender_id = CommUtil.null2Long(map
			// .get("sender_id"));
			// User sender = this.userService.getObjById(sender_id);
			// context.setVariable("sender", sender);
			// }
			// if (map.get("buyer_id") != null) {
			// Long buyer_id = CommUtil.null2Long(map.get("buyer_id"));
			// User buyer = this.userService.getObjById(buyer_id);
			// context.setVariable("buyer", buyer);
			// }
			// if (map.get("seller_id") != null) {
			// Long seller_id = CommUtil.null2Long(map
			// .get("seller_id"));
			// User seller = this.userService.getObjById(seller_id);
			// context.setVariable("seller", seller);
			// }
			// if (map.get("order_id") != null) {
			// Long temp_order_id = CommUtil.null2Long(map
			// .get("order_id"));
			// OrderForm orderForm = this.orderFormService
			// .getObjById(temp_order_id);
			// context.setVariable("orderForm", orderForm);
			// }
			// if (map.get("childorder_id") != null) {
			// Long childorder_id = CommUtil.null2Long(map
			// .get("childorder_id"));
			// OrderForm orderForm = this.orderFormService
			// .getObjById(childorder_id);
			// context.setVariable("child_orderForm", orderForm);
			// }
			// if (map.get("goods_id") != null) {
			// Long goods_id = CommUtil.null2Long(map.get("goods_id"));
			// Goods goods = this.goodsService.getObjById(goods_id);
			// context.setVariable("goods", goods);
			// }
			// if (map.get("self_goods") != null) {
			// context.setVariable("seller", map.get("self_goods")
			// .toString());
			// }
			// context.setVariable("config",
			// this.configService.getSysConfig());
			// context.setVariable("send_time",
			// CommUtil.formatLongDate(new Date()));
			// context.setVariable("webPath", web);
			// Expression ex = exp.parseExpression(template.getContent(),
			// new SpelTemplate());
			// String content = ex.getValue(context, String.class);
			// boolean result = this.sendSMS(mobile, content);
			// if (result) {// 更新商家店铺发送短信邮件信息
			// System.out.println("发送短信成功");
			// if (store != null) {
			// store.setStoreSmsCount(store.getStoreSmsCount() - 1);// 商家短信数量减1
			// function_map.put("sms_count",
			// CommUtil.null2Int(function_map
			// .get("sms_count")) + 1);// 商家功能发送短信数量加1
			// String sms_email_json = Json.toJson(function_maps,
			// JsonFormat.compact());
			// store.setSendSmsCount(store.getSendSmsCount() + 1);
			// store.setSmsEmailInfo(sms_email_json);
			// this.storeService.update(store);
			// }
			// }
			// }
			// }
		} else {
			System.out.println("系统关闭了短信发送功能！");
		}
	}

	/**
	 * 收费邮件发送方法，商家购买短信或者邮件后，当商家有交易订单需要发送短信提醒商家或者订单用户时使用该收费工具
	 * 
	 * @param request
	 * @param mark
	 * @param mobile
	 * @param json
	 * @param order_id
	 *            :订单操作时发送邮件
	 * @param store_id
	 *            :发送邮件的店铺id
	 * @throws Exception
	 */
	@Async
	public void sendEmailCharge(String weburl, String mark, String email, String json, String order_id,
			String store_id) throws Exception {
		// if (this.configService.getSysConfig().getEmailEnable()) {
		// Template template = this.templateDao.findByMark(mark);
		// Store store = null;
		// boolean flag = false;
		// Map function_map = new HashMap();
		// List<Map> function_maps = new ArrayList<Map>();
		// if (store_id != null && !store_id.equals("")) {
		// // store = this.storeService.getObjById(CommUtil
		// // .null2Long(store_id));
		// if (store != null && store.getStoreEmailCount() > 0) {
		// function_maps = (List<Map>) Json.fromJson(store
		// .getSmsEmailInfo());
		// for (Map temp_map2 : function_maps) {
		// if (template != null
		// && CommUtil.null2String(temp_map2.get("type"))
		// .equals(CommUtil.null2String(template
		// .getType()))
		// && CommUtil.null2String(temp_map2.get("mark"))
		// .equals(template.getMark())) {
		// function_map = temp_map2;
		// if (CommUtil.null2Int(function_map
		// .get("email_open")) == 1) {// 验证功能是否开启
		// flag = true;
		// break;
		// } else {
		// flag = false;
		// System.out.println("商家已关闭该邮件发送功能");
		// }
		// }
		// }
		// } else {
		// System.out.println("商家没有购买邮件流量");
		// }
		// }
		// if (flag && template != null && template.getOpen()) {
		// ExpressionParser exp = new SpelExpressionParser();
		// EvaluationContext context = new StandardEvaluationContext();
		// Map map = this.queryJson(json);
		// String subject = template.getTitle();
		// if (order_id != null) {
		// OrderForm order = this.orderFormService.getObjById(CommUtil
		// .null2Long(order_id));
		// User buyer = this.userService.getObjById(CommUtil
		// .null2Long(order.getUserId()));
		// context.setVariable("buyer", buyer);
		// if (store != null) {
		// //context.setVariable("seller", store.getUser());
		// }
		// context.setVariable("config",
		// this.configService.getSysConfig());
		// context.setVariable("send_time",
		// CommUtil.formatLongDate(new Date()));
		// context.setVariable("webPath", weburl);
		// context.setVariable("order", order);
		// }
		// if (map.get("receiver_id") != null) {
		// Long receiver_id = CommUtil.null2Long(map
		// .get("receiver_id"));
		// User receiver = this.userService.getObjById(receiver_id);
		// context.setVariable("receiver", receiver);
		// }
		// if (map.get("sender_id") != null) {
		// Long sender_id = CommUtil.null2Long(map.get("sender_id"));
		// User sender = this.userService.getObjById(sender_id);
		// context.setVariable("sender", sender);
		// }
		// if (map.get("buyer_id") != null) {
		// Long buyer_id = CommUtil.null2Long(map.get("buyer_id"));
		// User buyer = this.userService.getObjById(buyer_id);
		// context.setVariable("buyer", buyer);
		// }
		// if (map.get("seller_id") != null) {
		// Long seller_id = CommUtil.null2Long(map.get("seller_id"));
		// User seller = this.userService.getObjById(seller_id);
		// context.setVariable("seller", seller);
		// }
		// if (map.get("order_id") != null) {
		// Long temp_order_id = CommUtil
		// .null2Long(map.get("order_id"));
		// OrderForm orderForm = this.orderFormService
		// .getObjById(temp_order_id);
		// context.setVariable("orderForm", orderForm);
		// }
		// if (map.get("childorder_id") != null) {
		// Long childorder_id = CommUtil.null2Long(map
		// .get("childorder_id"));
		// OrderForm orderForm = this.orderFormService
		// .getObjById(childorder_id);
		// context.setVariable("child_orderForm", orderForm);
		// }
		// if (map.get("goods_id") != null) {
		// Long goods_id = CommUtil.null2Long(map.get("goods_id"));
		// Goods goods = this.goodsService.getObjById(goods_id);
		// context.setVariable("goods", goods);
		// }
		// if (map.get("self_goods") != null) {
		// context.setVariable("seller", map.get("self_goods")
		// .toString());
		// }
		// context.setVariable("config", this.configService.getSysConfig());
		// context.setVariable("send_time",
		// CommUtil.formatLongDate(new Date()));
		// context.setVariable("webPath", weburl);
		// Expression ex = exp.parseExpression(template.getContent(),
		// new SpelTemplate());
		// String content = ex.getValue(context, String.class);
		// boolean result = this.sendEmail(email, subject, content);
		// if (result) {// 更新商家店铺发送短信邮件信息
		// System.out.println("发送邮件成功");
		// if (store != null) {
		// store.setStoreEmailCount(store.getStoreEmailCount() - 1);// 商家邮件数量减1
		// function_map.put("email_count", CommUtil
		// .null2Int(function_map.get("email_count")) + 1);// 商家功能发送邮件数量加1
		// String sms_email_json = Json.toJson(function_maps,
		// JsonFormat.compact());
		// store.setSmsEmailInfo(sms_email_json);
		// store.setSendEmailCount(store.getSendEmailCount() + 1);
		// this.storeService.update(store);
		// }
		// }
		// }
		// } else {
		// System.out.println("系统关闭了邮件发送功能！");
		// }
	}

	/**
	 * 免费短信发送方法，系统给用户发送的短信工具，
	 * 
	 * @param request
	 * @param mark
	 * @param mobile
	 * @param json
	 * @throws Exception
	 */
	@Async
	public void sendSmsFree(String web, String mark, String mobile, String json, String order_id)
			throws Exception {
		// if (this.configService.getSysConfig().getSmsEnbale()) {
		// Template template = this.templateDao.findByMark(mark);
		// if (template != null && template.getOpen()) {
		// Map map = this.queryJson(json);
		// if (mobile != null && !mobile.equals("")) {
		// ExpressionParser exp = new SpelExpressionParser();
		// EvaluationContext context = new StandardEvaluationContext();
		// if (order_id != null) {
		// OrderForm order = this.orderFormService
		// .getObjById(CommUtil.null2Long(order_id));
		// User buyer = this.userService.getObjById(CommUtil
		// .null2Long(order.getUserId()));
		// context.setVariable("buyer", buyer);
		// context.setVariable("config",
		// this.configService.getSysConfig());
		// context.setVariable("send_time",
		// CommUtil.formatLongDate(new Date()));
		// context.setVariable("webPath", web);
		// context.setVariable("order", order);
		// }
		// if (map.get("receiver_id") != null) {
		// Long receiver_id = CommUtil.null2Long(map
		// .get("receiver_id"));
		// User receiver = this.userService
		// .getObjById(receiver_id);
		// context.setVariable("receiver", receiver);
		// }
		// if (map.get("sender_id") != null) {
		// Long sender_id = CommUtil.null2Long(map
		// .get("sender_id"));
		// User sender = this.userService.getObjById(sender_id);
		// context.setVariable("sender", sender);
		// }
		// if (map.get("buyer_id") != null) {
		// Long buyer_id = CommUtil.null2Long(map.get("buyer_id"));
		// User buyer = this.userService.getObjById(buyer_id);
		// context.setVariable("buyer", buyer);
		// }
		// if (map.get("seller_id") != null) {
		// Long seller_id = CommUtil.null2Long(map
		// .get("seller_id"));
		// User seller = this.userService.getObjById(seller_id);
		// context.setVariable("seller", seller);
		// }
		// if (map.get("order_id") != null) {
		// Long order_id_temp = CommUtil.null2Long(map
		// .get("order_id"));
		// OrderForm orderForm = this.orderFormService
		// .getObjById(order_id_temp);
		// context.setVariable("orderForm", orderForm);
		// }
		// if (map.get("childorder_id") != null) {
		// Long childorder_id = CommUtil.null2Long(map
		// .get("childorder_id"));
		// OrderForm orderForm = this.orderFormService
		// .getObjById(childorder_id);
		// context.setVariable("child_orderForm", orderForm);
		// }
		// if (map.get("goods_id") != null) {
		// Long goods_id = CommUtil.null2Long(map.get("goods_id"));
		// Goods goods = this.goodsService.getObjById(goods_id);
		// context.setVariable("goods", goods);
		// }
		// if (map.get("self_goods") != null) {
		// context.setVariable("seller", map.get("self_goods")
		// .toString());
		// }
		// context.setVariable("config",
		// this.configService.getSysConfig());
		// context.setVariable("send_time",
		// CommUtil.formatLongDate(new Date()));
		// context.setVariable("webPath", web);
		// Expression ex = exp.parseExpression(template.getContent(),
		// new SpelTemplate());
		// String content = ex.getValue(context, String.class);
		// boolean ret = this.sendSMS(mobile, content);
		// if (ret) {
		// System.out.println("发送短信成功");
		// } else {
		// System.out.println("发送短信失败");
		// }
		// }
		// }
		// } else {
		// System.out.println("系统关闭了短信发送功能！");
		// }
	}

	/**
	 * 免费邮件发送方法， 系统给用户发送的邮件工具，
	 * 
	 * @param request
	 * @param mark
	 * @param mobile
	 * @param json
	 * @throws Exception
	 */
	@Async
	public void sendEmailFree(String web, String mark, String email, String json, String order_id)
			throws Exception {
		// if (this.configService.getSysConfig().getEmailEnable()) {
		// Template template = this.templateDao.findByMark(mark);
		// if (template != null && template.getOpen()) {
		// Map map = this.queryJson(json);
		// String subject = template.getTitle();
		// ExpressionParser exp = new SpelExpressionParser();
		// EvaluationContext context = new StandardEvaluationContext();
		// if (order_id != null) {
		// OrderForm order = this.orderFormService.getObjById(CommUtil
		// .null2Long(order_id));
		// User buyer = this.userService.getObjById(CommUtil
		// .null2Long(order.getUserId()));
		// context.setVariable("buyer", buyer);
		// context.setVariable("config",
		// this.configService.getSysConfig());
		// context.setVariable("send_time",
		// CommUtil.formatLongDate(new Date()));
		// context.setVariable("webPath", web);
		// context.setVariable("order", order);
		// }
		// if (map.get("receiver_id") != null) {
		// Long receiver_id = CommUtil.null2Long(map
		// .get("receiver_id"));
		// User receiver = this.userService.getObjById(receiver_id);
		// context.setVariable("receiver", receiver);
		// }
		// if (map.get("sender_id") != null) {
		// Long sender_id = CommUtil.null2Long(map.get("sender_id"));
		// User sender = this.userService.getObjById(sender_id);
		// context.setVariable("sender", sender);
		// }
		// if (map.get("buyer_id") != null) {
		// Long buyer_id = CommUtil.null2Long(map.get("buyer_id"));
		// User buyer = this.userService.getObjById(buyer_id);
		// context.setVariable("buyer", buyer);
		// }
		// if (map.get("seller_id") != null) {
		// Long seller_id = CommUtil.null2Long(map.get("seller_id"));
		// User seller = this.userService.getObjById(seller_id);
		// context.setVariable("seller", seller);
		// }
		// if (map.get("order_id") != null) {
		// Long order_id_temp = CommUtil
		// .null2Long(map.get("order_id"));
		// OrderForm orderForm = this.orderFormService
		// .getObjById(order_id_temp);
		// context.setVariable("orderForm", orderForm);
		// }
		// if (map.get("childorder_id") != null) {
		// Long childorder_id = CommUtil.null2Long(map
		// .get("childorder_id"));
		// OrderForm orderForm = this.orderFormService
		// .getObjById(childorder_id);
		// context.setVariable("child_orderForm", orderForm);
		// }
		// if (map.get("goods_id") != null) {
		// Long goods_id = CommUtil.null2Long(map.get("goods_id"));
		// Goods goods = this.goodsService.getObjById(goods_id);
		// context.setVariable("goods", goods);
		// }
		// if (map.get("self_goods") != null) {
		// context.setVariable("seller", map.get("self_goods")
		// .toString());
		// }
		// context.setVariable("config", this.configService.getSysConfig());
		// context.setVariable("send_time",
		// CommUtil.formatLongDate(new Date()));
		// context.setVariable("webPath", web);
		// Expression ex = exp.parseExpression(template.getContent(),
		// new SpelTemplate());
		// String content = ex.getValue(context, String.class);
		// this.sendEmail(email, subject, content);
		// System.out.println("发送邮件成功");
		// } else {
		// System.out.println("系统关闭了邮件发送功能");
		// }
		// }
	}

	/**
	 * 发送短信底层工具
	 * 
	 * @param mobile
	 * @param content
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("unused")
	public boolean sendSMS(String mobile, String content) throws UnsupportedEncodingException {
		boolean result = true;
		if (this.configService.getSysConfig().getSmsEnbale()) {
			String url = this.configService.getSysConfig().getSmsUrl();
			String userName = this.configService.getSysConfig().getSmsUserName();
			String password = this.configService.getSysConfig().getSmsPassword();
			String smsUrl = this.configService.getSysConfig().getSmsUrl();
			// SmsBase sb = new SmsBase(smsUrl, userName,password);
			// String ret = sb.SendSms(mobile, content);
			// if (!ret.substring(0, 3).equals("000")) {
			// result = false;
			// }
		} else {
			result = false;
			System.out.println("系统关闭了短信发送功能");
		}
		return result;
	}

	/**
	 * 发送邮件底层工具
	 * 
	 * @param mobile
	 * @param content
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public boolean sendEmail(String email, String subject, String content) {
		boolean ret = true;
		if (this.configService.getSysConfig().getEmailEnable()) {
			String username = "";
			String password = "";
			String smtp_server = "";
			String from_mail_address = "";
			username = this.configService.getSysConfig().getEmailUserName();
			password = this.configService.getSysConfig().getEmailPws();
			smtp_server = this.configService.getSysConfig().getEmailHost();
			from_mail_address = this.configService.getSysConfig().getEmailUser();
			String to_mail_address = email;
			if (username != null && password != null && !username.equals("") && !password.equals("")
					&& smtp_server != null && !smtp_server.equals("") && to_mail_address != null
					&& !to_mail_address.trim().equals("")) {
				Authenticator auth = new PopupAuthenticator(username, password);
				Properties mailProps = new Properties();
				mailProps.put("mail.smtp.auth", "true");
				mailProps.put("username", username);
				mailProps.put("password", password);
				mailProps.put("mail.smtp.host", smtp_server);
				Session mailSession = Session.getInstance(mailProps, auth);
				MimeMessage message = new MimeMessage(mailSession);
				try {
					message.setFrom(new InternetAddress(from_mail_address));
					message.setRecipient(Message.RecipientType.TO, new InternetAddress(to_mail_address));
					message.setSubject(subject);
					MimeMultipart multi = new MimeMultipart("related");
					BodyPart bodyPart = new MimeBodyPart();
					bodyPart.setDataHandler(new DataHandler(content, "text/html;charset=UTF-8"));// 网页格式
					// bodyPart.setText(content);
					multi.addBodyPart(bodyPart);
					message.setContent(multi);
					message.saveChanges();
					Transport.send(message);
					ret = true;
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					ret = false;
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					ret = false;
					e.printStackTrace();
				}
			} else {
				ret = false;
			}
		} else {
			ret = false;
			System.out.println("系统关闭了邮件发送功能");
		}
		System.out.println("ret:" + ret);
		return ret;
	}

	/**
	 * 解析json工具
	 * 
	 * @param json
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unused"})
	private Map queryJson(String json) {
		Map map = new HashMap();
		if (json != null && !json.equals("")) {
			map = Json.fromJson(HashMap.class, json);
		}
		return map;
	}

	/**
	 * 免费短信发送方法，系统给用户发送的短信工具，
	 * 
	 * @param request
	 * @param mark
	 *            短信模板代码
	 * @param mobile
	 *            手机号
	 * @param param
	 *            模板需要的参数
	 */
	@Async
	public void sendSms(String mark, String mobile, String... params) {
		sendSms(mark, mobile, null, params);
	}

	/**
	 * 免费短信发送方法，系统给用户发送的短信工具，
	 * 
	 * @param request
	 * @param mark
	 *            短信模板代码
	 * @param mobile
	 *            手机号
	 * @param param
	 *            模板需要的参数
	 */
	public void sendSms(String mark, String mobile, String ip, String[] params) {
		try {
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			logger.info("短信发送日期：" + date + ",mark：" + mark + ",mobile：" + mobile + ",param:" + params);
			Template template = this.templateDao.findByMark(mark);
			if (template != null && template.getOpen()) {

				// 目前限制实现会出现超出的情况，具体超出多少要看第三方接口超时时间和超时后是否依然会发送
				if (template.getTimes() != null && template.getTimes() != 0) {
					if (!vaildateLimitCount(mark, mobile, template.getTimes())) {
						logger.error("号码{}发送{}模版超出次数限制", mobile, mark);
						return;
					}
					if (StringUtils.isNotBlank(ip) && !vaildateLimitCount(mark, ip, template.getTimes())) {
						logger.error("IP{}发送{}模版超出次数限制", mobile, ip);
						return;
					}
				}

				if (StringUtils.isNotEmpty(mobile)) {
					String content = template.getContent();
					if (StringUtils.isNotEmpty(content)) {
						//判断短信文本是否存在$占位符 add by yuleijia on 2017.4.17
						//旧短信文本：尊敬的用户：您申请的云豆提现$1元，云尚已成功受理，将返还至您账号尾号是$2的账户中，请注意查收。
						//新短信文本:尊敬的云尚商家您好！您的提现已受理，请注意您的收款帐号信息，实际到帐时间请以银行信息为准，感谢您的支持！ 
						int contentIndexOf = content.indexOf("$");
						if (params != null && contentIndexOf > -1) {
							for (int i = 0; i < params.length; i++) {
								content = content.replace("$" + (i + 1), params[i]);
							}
						}
						boolean ret = sendSmsExcute(mobile, date, content);
						// 添加手机限制次数
						addDaySendCount(mark, mobile);
						if (StringUtils.isNotBlank(ip)) {
							// 添加IP限制次数,先定6小时
							addSendCount(mark, ip, 60 * 60 * 6, false);
						}
						if (ret) {
//							logger.info("发送短信成功 "+mobile);
						} else {
							logger.info("发送短信失败" + mobile);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("短信发送失败：" + mobile + e);
		}
	}

	@Async
	private boolean sendSmsExcute(String mobile, String date, String content) {
		logger.info("短信发送日期：" + date + ",手机号码：" + mobile + ",短信内容：" + content);
		boolean ret = this.smsHandler.sendMessage(mobile, content);
		logger.info("短信发送日期：" + date + ",短信发送结果：" + ret);
		return ret;
	}

	/**
	 * 验证限制次数
	 * 
	 * @return true 正常， false 超出
	 */
	private boolean vaildateLimitCount(String mark, String mobile, Integer limitCount) {
		StringBuilder key = new StringBuilder(MSG_CACHE_KEY);
		key.append(":").append(mobile).append(":").append(mark);
		String sendCount = bizCacheUtils.get(key.toString());
		if (StringUtils.isNotBlank(sendCount)) {
			if (limitCount <= Integer.parseInt(sendCount)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 添加发送次数,设置每天过期
	 */
	private Long addDaySendCount(String mark, String mobile) {

		Calendar date = Calendar.getInstance();
		Long currentTime = date.getTime().getTime();
		date.set(Calendar.HOUR_OF_DAY, 23);
		date.set(Calendar.MINUTE, 59);
		date.set(Calendar.SECOND, 59);

		return addSendCount(mark, mobile,
				new Long((date.getTime().getTime() - currentTime) / 1000).intValue(), true);
	}

	/**
	 * 添加发送次数
	 * 
	 * @param mark
	 * @param mobile
	 * @param expire
	 *            过期时间，秒
	 * @param isAddFlush
	 *            添加是否刷新过期时间
	 * @return
	 */
	private Long addSendCount(String mark, String mobile, int expire, boolean isAddFlush) {
		StringBuilder key = new StringBuilder(MSG_CACHE_KEY);
		key.append(":").append(mobile).append(":").append(mark);
		Long sendCount = bizCacheUtils.incr(key.toString());

		if (isAddFlush) {
			// 设置过期
			bizCacheUtils.expire(key.toString(), expire);
		} else {
			// 只第一次设置过期
			if (sendCount == 1) {
				bizCacheUtils.expire(key.toString(), expire);
			}
		}
		return sendCount;
	}
	
}
