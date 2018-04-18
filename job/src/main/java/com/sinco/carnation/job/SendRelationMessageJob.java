package com.sinco.carnation.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.sys.bo.RelationMessageBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserRelationService;

public class SendRelationMessageJob {

	private MessageService messageService;

	private UserRelationService userRelationService;

	private UserCustomerService userCustomerService;

	private UserService userService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public synchronized void sentMessage() {
		Long uidLV1 = 0l;
		Long uidLV0 = 0l;
		Date time = null;
		try {
			List<RelationMessageBO> lists = messageService.findAllDelStatusFalse();
			List<RelationMessageBO> listSys = new ArrayList<>();// 系统
			List<RelationMessageBO> listRelation = new ArrayList<>();// 关系
			List<RelationMessageBO> listRemoveRelation = new ArrayList<>();// 关系
			List<RelationMessageBO> listOrder = new ArrayList<>();// 订单
			for (RelationMessageBO bo : lists) {
				if (bo.getRmType() == 0) {// 系统
					listSys.add(bo);
				}
				if (bo.getRmType() == 1) {// 关系
					listRelation.add(bo);
				}
				if (bo.getRmType() == 2) {// 成为CN解除关系
					listRemoveRelation.add(bo);
				}
				if (bo.getRmType() == 3) {// 订单
					listOrder.add(bo);
				}
			}

			for (RelationMessageBO bo : listRelation) {// 关系类型的消息任务执行
				UserBO sysuser = userService.getObjById(bo.getForUserId());// 用户信息
				if (null == sysuser) {
					logger.error("this user is empty in db. UID=" + bo.getForUserId());
					continue;
				}
				uidLV0 = sysuser.getId();
				uidLV1 = bo.getToUserId();// 推荐人的uid
				time = bo.getCreatTime();
				sendMessage(uidLV1, ",", sysuser.getInvitationCode(), time);
				logger.info("send message success uid = " + uidLV0 + "type = 1");
				messageService.changeRelationMessageDelStatus(bo.getId());
			}

			for (RelationMessageBO bo : listRemoveRelation) {// 成为CN解除关系发送短信
				uidLV0 = bo.getForUserId();
				uidLV1 = bo.getToUserId();
				time = bo.getCreatTime();
				UserCustomer customer = new UserCustomer();
				customer = userCustomerService.findById(uidLV0);
				if (customer != null) {
					String nickName = customer.getNickname()==null?"":customer.getNickname();
					if(nickName!=null){
						nickName = StringFilter(nickName);
					}
					// 给推荐关系链上的会员发送站内短信
					sendMessageForRemoveInvitation(uidLV1, ",", nickName, time);
					logger.info("send message success uid = " + uidLV0 + "type = 2");
				} else {
					logger.error("cant find this user.customer where uid = " + uidLV0);
				}
				messageService.changeRelationMessageDelStatus(bo.getId());
			}
		} catch (Exception e) {
			logger.error("send message error. UID=" + uidLV0 + ",REUID=" + uidLV1);
			logger.error("send message error.", e);
		}
	}

	private void sendMessage(Long refuid, String touserids, String invitationCode, Date time) {
		// 向上只发四层
		if (touserids.split(",").length > 5) {
			return;
		}
		// 存在已发过的人，就跳出
		if (touserids.contains("," + refuid + ",")) {
			return;
		}
		Message message2 = new Message();
		message2.setAddTime(time);
		message2.setTitle("系统消息");
		message2.setContent("恭喜你的小伙伴" + invitationCode + "已成功加入云尚大健康");
		boolean sendresult = messageService.saveMessage(message2, 1L, refuid, 1);
		if (sendresult) {
			logger.info("send message success! UID =" + refuid + ",CODE=" + invitationCode);
		}
		touserids = touserids + refuid + ",";
		UserRelationBO userRelationBefore = userRelationService.findOneByUid(refuid);// 查询推荐人的推荐关系
		if (userRelationBefore != null) {
			if (null == userRelationBefore.getRefereeUserId()) {
				logger.info("this user has relation , but no reference userId = " + refuid);
				return;
			}
			sendMessage(userRelationBefore.getRefereeUserId(), touserids, invitationCode, time);
		} else {
			return;
		}
	}

	/**
	 * 根据推荐关系向上发站内信息
	 * 
	 * @param refuid
	 *            推荐人的userId
	 * @param touserids
	 * @param nickName
	 */
	private void sendMessageForRemoveInvitation(Long refuid, String touserids, String nickName, Date time) {
		// 向上只发四层
		if (touserids.split(",").length > 5) {
			return;
		}
		// 存在已发过的人，就跳出
		if (touserids.contains("," + refuid + ",")) {
			return;
		}
		Message message2 = new Message();
		message2.setAddTime(time);
		message2.setTitle("系统消息");
		message2.setContent("恭喜您的小伙伴" + StringFilter(nickName) + "已成为CN会员");
		boolean sendresult = messageService.saveMessage(message2, 1L, refuid, 1);
		if (sendresult) {
			logger.info("send message success! UID =" + refuid + ",CODE=" + nickName);
		}
		touserids = touserids + refuid + ",";

		UserRelationBO userRelationBefore = userRelationService.findOneByUid(refuid);// 查询推荐人的推荐关系
		if (userRelationBefore != null) {
			if (null == userRelationBefore.getRefereeUserId()) {
				logger.info("this user has relation , but no reference userId = " + refuid);
				return;
			}
			sendMessageForRemoveInvitation(userRelationBefore.getRefereeUserId(), touserids, nickName, time);
		} else {
			return;
		}
	}

	public static String StringFilter(String str) throws PatternSyntaxException {
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public UserRelationService getUserRelationService() {
		return userRelationService;
	}

	public void setUserRelationService(UserRelationService userRelationService) {
		this.userRelationService = userRelationService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserCustomerService getUserCustomerService() {
		return userCustomerService;
	}

	public void setUserCustomerService(UserCustomerService userCustomerService) {
		this.userCustomerService = userCustomerService;
	}

}
