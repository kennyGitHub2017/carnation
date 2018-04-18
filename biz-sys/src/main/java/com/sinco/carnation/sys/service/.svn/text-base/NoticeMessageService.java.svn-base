package com.sinco.carnation.sys.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.sinco.carnation.notice.dao.NoticeMessageDao;
import com.sinco.carnation.notice.model.NoticeMessage;
import com.sinco.carnation.shop.constants.PushMessageConstants;
import com.sinco.carnation.sys.contants.MessageContants;
import com.sinco.carnation.sys.model.Message;
import com.sinco.messager.mobile.MobileMessageHandler;
import com.sinco.messager.mobile.MobileOSType;
import com.sinco.messager.mobile.jpush.AlertMobileMessage;
import com.sinco.messager.mobile.jpush.AliasMobileChannel;
import com.sinco.messager.mobile.jpush.MessageMobileMessage;

@Service
@Transactional
public class NoticeMessageService {
	private static final Logger logger = LoggerFactory.getLogger(NoticeMessageService.class);

	@Autowired
	private NoticeMessageDao noticeMessageDao;
	@Autowired
	private MessageService messageService;

	@Resource(name = "jpushMobileMessageHandler")
	private MobileMessageHandler mobileMessageHandler;
	
	@Resource(name = "sellerJpushMobileMessageHandler")
	private MobileMessageHandlerEx sellerJpushMobileMessageHandler;
	
	@Resource(name = "appJpushMobileMessageHandler")
	private MobileMessageHandlerEx appJpushMobileMessageHandler;

	@Transactional(readOnly = false)
	public void save(NoticeMessage noticeMessage) {
		noticeMessageDao.save(noticeMessage);
	}

	/**
	 * 推送消息
	 * 
	 * @param consulting
	 * @param cr
	 */
	@Async
	public void pushMessage(NoticeMessage noticeMsg) {
		// MessageMobileMessage message = new MessageMobileMessage(noticeMsg.getNoticeMessage());

		AlertMobileMessage message = new AlertMobileMessage(noticeMsg.getNoticeMessage());

		// 附加参数，需要什么自己加
		Map<String, String> exts = Maps.newHashMap();
		exts.put("id", String.valueOf(noticeMsg.getUid()));
		// exts.put("messageType",noticeMsg.getPushType());
		exts.put("messageType", noticeMsg.getPushType());
		noticeMsg.setCreateTime(new Date());
		exts.put("replyTime", noticeMsg.getCreateTime().toString());
		message.setExts(exts);
		// message.setMessage("您咨询的问题"+consulting.getTitle()+"有了新的回复，请去查看！");
		// 消息的渠道分为 Alias 和 tag ,消息内容分为 alert 和 message
		mobileMessageHandler.sendMessage(new AliasMobileChannel(String.valueOf(noticeMsg.getUid())), message);
	}

	/**
	 * 商户收款通知消息
	 * 
	 * @param uid
	 *            商户ID
	 * @param money
	 *            收款金额
	 */
	@Async
	public void pushReceiveMoneyMessage(Long uid, BigDecimal money, Long orderId) {
		if (uid == null || money == null) {
			return;
		}
		try {
			String m = money.setScale(2, RoundingMode.HALF_DOWN).toString();
			// 新增消息
			NoticeMessage message = new NoticeMessage();
			message.setCreateTime(new Date());
			message.setUid(uid);
			message.setNoticeMessage("您有一笔新的订单收入￥" + m + "，请查看！");
			message.setNoticeType(PushMessageConstants.RECEIVE_MONEY_TYPE);
			message.setPushStatus(1);
			message.setNotcieLogAmount(money);
			message.setRelateId(orderId);
			message.setMessageStatus(0);
			noticeMessageDao.save(message);
			// 获取未读消息数
			int total = getReceiveMoneyMessageCount(uid);
			// 消息推送
			AlertMobileMessage pushMmessage = new AlertMobileMessage(message.getNoticeMessage());
			Map<String, String> exts = Maps.newHashMap();
			exts.put("uid", String.valueOf(uid));
			exts.put("messageType", PushMessageConstants.RECEIVE_MONEY);
			exts.put("receiveMoney", m);
			exts.put("badge", String.valueOf(total));
			pushMmessage.setExts(exts);
			pushMmessage.setBadge(total);
			pushMmessage.setTitle("收款通知");
			pushMmessage.setSound("default");
			logger.info("push message==================" + Json.toJson(pushMmessage));
			sellerJpushMobileMessageHandler.sendMessage(uid, pushMmessage);
		} catch (Exception e) {
			logger.warn("商户收款消息推送失败", e);
		}
	}
	
	/**
	 * 春雨医生问题回复通知
	 * @param uid 用户ID
	 * @param content 回复内容
	 * @param redirectUrl 点开消息通知跳转的链接
	 */
	@Async
	public void pushProblemReplyMessage(Long uid, String title, String content, String redirectUrl) {
		if (uid == null || content == null) {
			return;
		}
		// 新增消息
		/*推送消息记录
		NoticeMessage message = new NoticeMessage();
		message.setCreateTime(new Date());
		message.setUid(uid);
		message.setNoticeMessage(content);
		message.setNoticeType(PushMessageConstants.PROBLEM_REPLY_TYPE);
		message.setPushStatus(1);
		message.setMessageStatus(0);
		noticeMessageDao.save(message);
		*/
		//发送站内消息
		Message msg = new Message();
		msg.setAddTime(new Date());
		msg.setContent(content);
		msg.setTitle(redirectUrl);
		msg.setStatus(0);
		msg.setType(3);
		msg.setToUserId(uid);
		messageService.save(msg);
		//推送
		Map<String, String> exts = Maps.newHashMap();
		exts.put("uid", String.valueOf(uid));
		exts.put("messageId", String.valueOf(msg.getId()));
		exts.put("messageType", PushMessageConstants.PROBLEM_REPLY);
		exts.put("url", redirectUrl);
		try {
			MessageMobileMessage pushMmessage = new MessageMobileMessage(content);
			pushMmessage.setExts(exts);
			pushMmessage.setTitle(title);
			logger.debug("Android push message==================" + Json.toJson(pushMmessage));
			appJpushMobileMessageHandler.sendMessage(uid, pushMmessage, MobileOSType.ANDROID);
		} catch (Exception e) {
			logger.debug("Android『春雨医生』回复消息推送失败", e);
		}
		try{
			//IOS收不到自定义消息，SO...
			AlertMobileMessage pushMmessage = new AlertMobileMessage(content);
			pushMmessage.setExts(exts);
			pushMmessage.setTitle(title);
			pushMmessage.setBadge(0);
			pushMmessage.setSound("default");
			logger.debug("IOS push message==================" + Json.toJson(pushMmessage));
			appJpushMobileMessageHandler.sendMessage(uid, pushMmessage, MobileOSType.IOS);
		} catch (Exception e) {
			logger.debug("IOS『春雨医生』问题关闭消息推送失败", e);
		}
	}
	
	/**
	 * 春雨医生问题关闭通知
	 * @param uid 用户ID
	 * @param content 消息内容
	 * @param redirectUrl 点开消息通知跳转的链接
	 */
	@Async
	public void pushProblemCloseMessage(Long uid, String title, String content, String redirectUrl) {
		if (uid == null || content == null) {
			return;
		}
		// 新增消息
		/*推送消息记录
		NoticeMessage message = new NoticeMessage();
		message.setCreateTime(new Date());
		message.setUid(uid);
		message.setNoticeMessage(content);
		message.setNoticeType(PushMessageConstants.PROBLEM_CLOSE_TYPE);
		message.setPushStatus(1);
		message.setMessageStatus(0);
		noticeMessageDao.save(message);
		*/
		//发送站内消息
		Message msg = new Message();
		msg.setAddTime(new Date());
		msg.setContent(content);
		msg.setTitle(redirectUrl);
		msg.setStatus(0);
		msg.setType(3);
		msg.setToUserId(uid);
		messageService.save(msg);
		//推送
		Map<String, String> exts = Maps.newHashMap();
		exts.put("uid", String.valueOf(uid));
		exts.put("messageId", String.valueOf(msg.getId()));
		exts.put("messageType", PushMessageConstants.PROBLEM_CLOSE);
		exts.put("url", redirectUrl);
		try {
			MessageMobileMessage pushMmessage = new MessageMobileMessage(content);
			pushMmessage.setExts(exts);
			pushMmessage.setTitle(title);
			logger.debug("Android push message==================" + Json.toJson(pushMmessage));
			appJpushMobileMessageHandler.sendMessage(uid, pushMmessage, MobileOSType.ANDROID);
		} catch (Exception e) {
			logger.debug("Android『春雨医生』问题关闭消息推送失败", e);
		}
		try{
			//IOS收不到自定义消息，SO...
			AlertMobileMessage pushMmessage = new AlertMobileMessage(content);
			pushMmessage.setExts(exts);
			pushMmessage.setTitle(title);
			pushMmessage.setBadge(0);
			pushMmessage.setSound("default");
			logger.debug("IOS push message==================" + Json.toJson(pushMmessage));
			appJpushMobileMessageHandler.sendMessage(uid, pushMmessage, MobileOSType.IOS);
		} catch (Exception e) {
			logger.debug("IOS『春雨医生』问题关闭消息推送失败", e);
		}
	}
	

	/**
	 * 清空商户收款未读消息数量
	 * 
	 * @param uid
	 *            商户ID
	 */
	public void cleanReceiveMoneyMessage(Long uid) {
		cleanReceiveMessage(uid, PushMessageConstants.RECEIVE_MONEY_TYPE);
	}

	/**
	 * 获取商户收款未读消息数量
	 * 
	 * @param uid
	 *            用户ID
	 * @return
	 */
	public int getReceiveMoneyMessageCount(Long uid) {
		return getReceiveMessageCount(uid, PushMessageConstants.RECEIVE_MONEY_TYPE);
	}
	
	/**
	 * 清空未讲读消息
	 * @param uid 用户ID
	 * @param noticeType 通知类型
	 */
	protected void cleanReceiveMessage(Long uid, int noticeType){
		noticeMessageDao.cleanUnreadMessage(uid, noticeType);
	}
	
	/**
	 * 获取未读消息
	 * @param uid 用户ID
	 * @param noticeType 通知类型
	 * @return
	 */
	protected int getReceiveMessageCount(Long uid, int noticeType) {
		int count = noticeMessageDao.queryUnreadMessageCount(uid, noticeType);
		return count;
	}


	/**
	 * 服务退款审核被拒绝通知
	 * @param uid 用户ID
	 * @param content 回复内容
	 * @param redirectUrl 点开消息通知跳转的链接
	 * @param title "服务退款审核被拒绝通知";
	 */
	@Async
	public void pushGroupRefundRefusedMessage(Long uid, String title, String content, String redirectUrl , Long currUserId , Long orderId) {
		if (uid == null || content == null) {
			return;
		}		
		//推送消息记录
		NoticeMessage message = new NoticeMessage();
		message.setCreateTime(new Date());
		message.setUid(uid);
		message.setNoticeMessage(content);
		message.setNoticeType(PushMessageConstants.SERVER_ORDER_DETAILS_TYPE);
		message.setPushStatus(1);
		message.setMessageStatus(0);
		noticeMessageDao.save(message);
		
		Message msg = new Message();
		msg.setAddTime(new Date());
		msg.setContent(content);
		msg.setTitle(orderId.toString());
		msg.setStatus(0);
		msg.setType(Integer.valueOf(MessageContants.rmType20));
		msg.setToUserId(uid);
		msg.setFromUserId(currUserId);
		messageService.save(msg);
		//推送
		Map<String, String> exts = Maps.newHashMap();
		exts.put("uid", String.valueOf(uid));
		exts.put("orderId", String.valueOf(orderId));
		exts.put("messageId", String.valueOf(msg.getId()));
		exts.put("messageType", PushMessageConstants.SERVER_ORDER_DETAILS);
		exts.put("msgContext", content);
		exts.put("url", redirectUrl);
		try {
			AlertMobileMessage pushMmessage = new AlertMobileMessage(content);
			pushMmessage.setExts(exts);
			pushMmessage.setTitle(title);
			pushMmessage.setBadge(0);
			pushMmessage.setSound("default");
			logger.debug("all push message==================" + Json.toJson(pushMmessage));
			appJpushMobileMessageHandler.sendMessage(uid, pushMmessage, MobileOSType.ALL);
		} catch (Exception e) {
			logger.debug("[pushGroupRefundRefusedMessage] [Android] error", e);
		}
	}
	
	/**
	 * 服务退款审核通过通知
	 * @param uid 用户ID
	 * @param content 回复内容
	 * @param redirectUrl 点开消息通知跳转的链接
	 * @param title "服务退款审核被拒绝通知";
	 */
	@Async
	public void pushGroupRefundSuccessMessage(Long uid, String title, String content, String redirectUrl , Long currUserId) {
		if (uid == null || content == null) {
			return;
		}
		// 推送消息记录
		NoticeMessage message = new NoticeMessage();
		message.setCreateTime(new Date());
		message.setUid(uid);
		message.setNoticeMessage(content);
		message.setNoticeType(PushMessageConstants.CLOUDMONEY_TYPE);
		message.setPushStatus(1);
		message.setMessageStatus(0);
		noticeMessageDao.save(message);
		
		Message msg = new Message();
		msg.setAddTime(new Date());
		msg.setContent(content);
		msg.setTitle("您提交的退款订单金额已成功退回到您的云豆帐户，立即查看！");
		msg.setStatus(0);
		msg.setType(Integer.valueOf(MessageContants.rmType10));
		msg.setFromUserId(currUserId);
		msg.setToUserId(uid);
		messageService.save(msg);
		//推送
		Map<String, String> exts = Maps.newHashMap();
		exts.put("uid", String.valueOf(uid));
		exts.put("messageId", String.valueOf(msg.getId()));
		exts.put("messageType", PushMessageConstants.CLOUDMONEY);
		exts.put("url", redirectUrl);
		try {
			AlertMobileMessage pushMmessage = new AlertMobileMessage(content);
			pushMmessage.setExts(exts);
			pushMmessage.setTitle(title);
			pushMmessage.setBadge(0);
			pushMmessage.setSound("default");
			logger.debug("all push message==================" + Json.toJson(pushMmessage));
			appJpushMobileMessageHandler.sendMessage(uid, pushMmessage, MobileOSType.ALL);
		} catch (Exception e) {
			logger.debug("[pushGroupRefundRefusedMessage] [Android] error", e);
		}
	}
}
