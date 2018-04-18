package com.sinco.carnation.sys.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.MessageBO;
import com.sinco.carnation.sys.bo.RelationMessageBO;
import com.sinco.carnation.sys.dao.MessageDao;
import com.sinco.carnation.sys.dao.RelationMessageDao;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.model.RelationMessage;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.dal.common.MyPage;
import com.sinco.messager.mobile.MobileMessageHandler;

@Service
@Transactional
public class MessageService {
	@Autowired
	private UserCustomerDao userCustomerDao;
	@Autowired
	private MessageDao messageDao;

	@Autowired
	private RelationMessageDao relationMessageDao;

	@Resource(name = "jpushMobileMessageHandler")
	private MobileMessageHandler mobileMessageHandler;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 根据接收方 count
	 * 
	 * @param toUid
	 * @param status
	 * @return
	 */
	public int countByToUser(Long toUid, Integer status) {
		return messageDao.countByToUser(toUid, status);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean save(Message message) {
		/**
		 * init other field here
		 */
		return this.messageDao.save(message);
	}

	public List<MessageBO> selectByUser(Long userId, String type, MyPage<MessageBO> page) {
		return messageDao.selectByUser(userId, type, page);
	}

	public int markRead(long messageId, long toUserId) {
		return messageDao.markRead(messageId, toUserId);
	}

	public MessageBO getObjById(Long id) {
		MessageBO message = messageDao.get(id);
		if (message != null) {
			UserCustomer uc = userCustomerDao.findById(message.getFromUserId());
			if (uc != null) {
				message.setHeadImgPath(uc.getHeadImgPath());
				message.setNickname(uc.getNickname());
			}

			return message;
		}

		return null;
	}

	public List<MessageBO> selectByParent(Long parentId, MyPage<MessageBO> page) {
		return messageDao.selectByParent(parentId, page);
	}

	public List<MessageBO> forCountAll(Long userId) {
		return messageDao.forCountAll(userId);
	}

	public List<MessageBO> forCountA(Long userId) {
		return messageDao.forCountA(userId);
	}

	public List<MessageBO> forCountB(Long userId) {
		return messageDao.forCountB(userId);
	}

	public List<MessageBO> forCountC(Long userId) {
		return messageDao.forCountC(userId);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) {
		try {
			this.messageDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean batchDelete(List<Serializable> messageIds) {
		// TODO Auto-generated method stub
		for (Serializable id : messageIds) {
			delete((Long) id);
		}
		return true;
	}

	// public IPageList list(IQueryObject properties) {
	// if (properties == null) {
	// return null;
	// }
	// String query = properties.getQuery();
	// String construct = properties.getConstruct();
	// Map params = properties.getParameters();
	// GenericPageList pList = new GenericPageList(Message.class,construct,
	// query,
	// params, this.messageDao);
	// if (properties != null) {
	// PageObject pageObj = properties.getPageObj();
	// if (pageObj != null)
	// pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
	// .getCurrentPage(), pageObj.getPageSize() == null ? 0
	// : pageObj.getPageSize());
	// } else
	// pList.doList(0, -1);
	// return pList;
	// }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(Message message) {
		try {
			this.messageDao.update(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// public List<Message> query(String query, Map params, int begin, int max){
	// return this.messageDao.query(query, params, begin, max);
	//
	// }

	public MyPage<MessageBO> findPageByVO(Long userId, String type, MyPage<MessageBO> page) {
		messageDao.selectByUser(userId, type, page);
		return page;
	}

	/**
	 * 发送站内短信
	 * 
	 * @param message
	 * @param fromUserId
	 *            发送人的uid
	 * @param toUserId
	 *            接受人的uid
	 * @param type
	 *            短信类型 0为系统短信，1是邀请注册，2是用户之间的短信
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean saveMessage(Message message, Long fromUserId, Long toUserId, int type) {
		if (message == null) {
			message = new Message();
		}
		if (null == message.getAddTime()) {
			message.setAddTime(new Date());// 时间现在
		}
		message.setStatus(0);// 状态未读
		if (null == message.getTitle()) {
			message.setTitle("标题被吃了");
		}
		if (null == message.getContent()) {
			message.setContent("内容被吃了");
		}
		message.setFromUserId(fromUserId);
		message.setToUserId(toUserId);
		message.setType(type);
		return this.save(message);
	}

	/**
	 * 根据ID查询消息详情
	 * 
	 * @param id
	 * @return
	 */
	public Message findOneByMesId(Long id) {
		return messageDao.findOne(id);
	}

	/**
	 * 查询消息任务列表所有未发送记录
	 * 
	 * @return
	 */
	public List<RelationMessageBO> findAllDelStatusFalse() {
		return relationMessageDao.findAllDelStatusFalse();
	}

	/**
	 * 物理删除
	 * 
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteRelationMessage(Long id) {
		relationMessageDao.delete(id);
	}

	/**
	 * 逻辑删除
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean changeRelationMessageDelStatus(Long id) {
		RelationMessage record = relationMessageDao.findById(id);
		if (record != null) {
			record.setDeleteStatus(true);
			relationMessageDao.save(record);
			return true;
		}
		return false;
	}

	/**
	 * 保存
	 * 
	 * @param record
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean saveRelationMessage(RelationMessage record) {
		if (relationMessageDao.save(record) != null) {
			return true;
		}
		return false;
	}

	/**
	 * 随机排序
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void randomSequence() {
		int count = 0;
		count = messageDao.updateInvitationRand();// 文章帖子排序
		if (count > 1) {
			logger.info("update InvitationRand is success count=" + count);
		} else {
			logger.error("update InvitationRand is unsuccess ");
		}
		count = 0;
		count = messageDao.updateShopGoodsRand();// 猜你喜欢商品排序
		if (count > 1) {
			logger.info("update ShopGoodsRand is success count=" + count);
		} else {
			logger.error("update ShopGoodsRand is unsuccess ");
		}
		count = 0;
		count = messageDao.updateCheckGroupRand();// 自测题排序
		if (count > 1) {
			logger.info("update CheckGroupRand is success count=" + count);
		} else {
			logger.error("update CheckGroupRand is unsuccess ");
		}
		count = 0;
	}

	/**
	 * 文章帖子排序更新
	 */
	public void updateInvitationRand() {
		messageDao.updateInvitationRand();// 文章帖子排序
	}

}
