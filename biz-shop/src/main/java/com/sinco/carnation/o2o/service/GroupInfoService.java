package com.sinco.carnation.o2o.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.constants.GroupInfoConstants;
import com.sinco.carnation.o2o.dao.GroupInfoDao;
import com.sinco.carnation.o2o.dao.GroupOrderDao;
import com.sinco.carnation.o2o.model.GroupInfo;
import com.sinco.carnation.o2o.model.GroupOrder;
import com.sinco.carnation.o2o.vo.GroupInfoVO;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.rebate.service.RebateService;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.NoticeMessageService;
import com.sinco.carnation.user.dao.UserRelationDao;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class GroupInfoService {
	private static final Logger logger = LoggerFactory.getLogger(GroupInfoService.class);
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	UserMoneyService userMoneyService;
	@Autowired
	MessageService messageService;
	@Autowired
	private GroupInfoDao groupInfoDao;
	@Autowired
	private UserRelationDao userRelationDao;
	@Autowired
	private RebateService rebateService;
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private GroupOrderDao groupOrderDao;
	@Autowired
	private UserRelationService relationService;
	@Autowired
	private GroupGoodsService goodsService;
	@Autowired
	private IntegralService integralService;
	@Autowired
	private NoticeMessageService noticeMessageService;
	@Autowired
	private GroupOrderService groupOrderService;
	/**
	 * 根据消费码查询
	 * 
	 * @param groupSN
	 * @return
	 */
	public GroupInfoBO findByGroupSN(String groupSN) {
		return this.groupInfoDao.findByGroupSN(groupSN);
	}

	public boolean save(GroupInfo groupInfo) {
		/**
		 * init other field here
		 */
		this.groupInfoDao.save(groupInfo);
		return true;
	}

	public GroupInfo getObjById(Long id) {
		return this.groupInfoDao.get(id);
	}

	/**
	 * 消费码退款申请
	 * 
	 * @param infoId
	 *            消费码ID
	 * @param refundReasion
	 *            退款原因
	 * @param userId
	 *            申请者用户ID（当前用户ID）
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public GroupInfo refundInfo(String infoId, String refundReasion, Long userId) {
		GroupInfo gi = getObjById(CommUtil.null2Long(infoId));
		if ((gi.getStatus() == 0 || gi.getStatus() == 6) && gi.getUserId().equals(userId)) {
			gi.setStatus(GroupInfoConstants.STATUS_EXAMINE);
			GroupOrderBO order = groupOrderDao.get(gi.getOrderId());
			order.setOrderReturnCount(order.getOrderReturnCount() + 1);
			groupOrderDao.update(order);
			gi.setRefundCompleteTime(new Date());
			gi.setRefundReasion(refundReasion);
			update(gi);
		}

		return gi;
	}

	public boolean delete(Long id) {
		this.groupInfoDao.remove(id);
		return true;
	}

	public boolean batchDelete(List<Serializable> groupInfoIds) {
		for (Serializable id : groupInfoIds) {
			delete((Long) id);
		}
		return true;
	}

	public List<GroupInfoBO> selectByApply(GroupInfoVO vo, MyPage<GroupInfoBO> page) {
		return groupInfoDao.selectByApply(vo, page);
	}

	public List<GroupInfoBO> selectByRefund(GroupInfoVO vo, MyPage<GroupInfoBO> page) {
		return groupInfoDao.selectByRefund(vo, page);
	}

	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void refundIng(GroupInfoVO vo, Long currUserId) {
		GroupInfo gi = getObjById(vo.getId().longValue());
		if(null == gi || gi.getId() == null){
			logger.error("can't find this GroupInfo id="+vo.getId());
			return;
		}
		if(vo.getStatus().intValue()!=5){
			return;
		}
		gi.setStatus(7);
		gi.setRefundId(currUserId);
		gi.setRefundCompleteTime(new Date());
		update(gi);

		boolean isUpdate = true;
		List<GroupInfoBO> list = groupInfoDao.findByOrder(gi.getOrderId());
		for (GroupInfoBO bo : list)
			if (bo.getStatus() == 0)
				isUpdate = false;
		GroupOrderBO order = groupOrderDao.get(gi.getOrderId());
		if (isUpdate) {
			order.setLocalReturnStatus(2);
			order.setOrderStatus(30);
			groupOrderDao.update(order);
		}

		String content = gi.getGroupSn() + " 消费码退款成功";
		Map map = orderFormTools.queryGroupInfo(order.getGroupInfo());
		double price = Double.parseDouble(map.get("goods_price").toString());
		userMoneyService.addMoney(order.getUserId(), price, currUserId, "人工操作", content);

		Message msg = new Message();
		msg.setAddTime(new Date());
		msg.setStatus(0);
		msg.setType(0);
		msg.setContent(content);
		msg.setFromUserId(currUserId);
		msg.setToUserId(gi.getUserId());
		messageService.save(msg);
	}

	public boolean update(GroupInfo groupInfo) {
		this.groupInfoDao.update(groupInfo);
		return true;
	}

	public List<GroupInfoBO> queryGroupInfoList(Long orderId) {
		return groupInfoDao.queryGroupInfoList(orderId);
	}

	public List<GroupInfoBO> findPageByStoreId(MyPage<GroupInfoBO> page, GroupInfoVO vo) {
		return groupInfoDao.findPageByStoreId(page, vo);
	}

	/**
	 * 券消费确认
	 */
	@SuppressWarnings("rawtypes")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean consumerSure(GroupInfoBO infoBO) throws ServiceException {
		// 修改消费码状态
		if (infoBO.getStatus() != 1) {
			infoBO.setStatus(1);
			if (groupInfoDao.update(infoBO) == 1) {
				// 第四步 检查订单里面消费码是否用完，如果是 则修改订单状态
				List<GroupInfoBO> infoBOs = this.queryGroupInfoList(infoBO.getOrderId());
				// 标志订单里面券是否已使用完
				// List<String> list=new ArrayList<String>();
				boolean flag = true;
				for (GroupInfoBO groupInfoBO : infoBOs) {
					// 为使用
					if (groupInfoBO.getStatus() == 0) {
						flag = false;
						break;
					}
					if (groupInfoBO.getStatus() == 6) {//审核不通过
						flag = false;
						break;
					}
				}
				GroupOrderBO group = groupOrderDao.findOne(infoBO.getOrderId());
				// 券已使用完，修改订单状态
				if (flag) {
					GroupOrder order = new GroupOrder();
					order.setOrderStatus(30);
					order.setId(group.getId());
					groupOrderDao.save(order);
				}
				StoreBO storeBO = storeDao.queryStoreById(CommUtil.null2Long(group.getStoreId()));
				GroupGoodsBO goodsBO = goodsService.getObjById(infoBO.getGoodsId());

				// 服务的价格有可能会调整
				BigDecimal groupPrice = goodsBO.getGroupPrice();

				String groupInfo = group.getGroupInfo();
				if (StringUtils.isNotEmpty(groupInfo)) {
					Map map = (Map) Json.fromJson(groupInfo);
					if (map.containsKey("goods_price")
							&& StringUtils.isNotEmpty(String.valueOf(map.get("goods_price")))) {
						groupPrice = CommUtil.null2BigDecimal(map.get("goods_price"));
					}
				}

				// 第五步 返润
				if (group != null) {
					//
					rebateService.appRebate(infoBO.getId(), infoBO.getUserId(), storeBO.getCreateUserId(),
							infoBO.getOrderId(), groupPrice, infoBO.getGroupSn(),
							storeBO.getCommissionRebate());
				}
				// 服务消码赠送积分
				try {
					groupOrderService.o2oShopSendIntegral(infoBO.getUserId(), groupPrice.doubleValue());
//					integralService.addIntegral(IntegralConstants.INTEGRAL_CONSUMER, infoBO.getUserId(),
//							CommUtil.null2String(groupPrice), null, "group", null);
				} catch (Exception e) {
					logger.error("add integral unsuccess uid=" + infoBO.getUserId());
				}
			}
		}
		return true;
	}

	/**
	 * 过期服务分润结算
	 * 
	 * @throws ServiceException
	 */
	public boolean groupInfoExpiredBanlance() {
		// 过期团购服务    产品部/里程碑V1.3/已确定文件/平台优化/健康商城（供应商）及周边（商户）问题、后台优化（V1.3） 有效期过了，不可以申请退，钱沉淀到平台，如需退，人工处理。
//		List<GroupInfoBO> gis = this.groupInfoDao.findExpiredGroupInfo();
//		if (null != gis && gis.size() > 0) {
//			for (GroupInfoBO infoBO : gis) {
//				try {
//					this.groupInfoExpiredBanlanceRebate(infoBO);
//					this.rebateService.addRebateLog(infoBO.getOrderId(), infoBO.getGroupSn(), "消费返润", true,
//							null);
//				} catch (ServiceException e) {
//					this.rebateService.addRebateLog(infoBO.getOrderId(), infoBO.getGroupSn(), "消费返润", false,
//							e.getErrorCode());
//				}
//			}
//			return true;
//		}
		return false;
	}

	/**
	 * 过期服务分润结算
	 * 
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false, rollbackFor = ServiceException.class)
	public void groupInfoExpiredBanlanceRebate(GroupInfoBO infoBO) throws ServiceException {
		// 过期状态-1	产品部/里程碑V1.3/已确定文件/平台优化/健康商城（供应商）及周边（商户）问题、后台优化（V1.3） 有效期过了，不可以申请退，钱沉淀到平台，如需退，人工处理。
//		infoBO.setStatus(-1);
//		groupInfoDao.update(infoBO);
//		// 校验订单里所有服务的状态
//		List<GroupInfoBO> infoBOs = this.queryGroupInfoList(infoBO.getOrderId());
//		boolean flag = true;
//		for (GroupInfoBO groupInfoBO : infoBOs) {
//			// 未使用
//			if (groupInfoBO.getStatus() != 1 && groupInfoBO.getStatus() != 7 && groupInfoBO.getStatus() != -1) {
//				flag = false;
//			}
//		}
//		// 不存在未消费、未完成退款、未过期的服务，则修改订单状态为已消费
//		GroupOrderBO group = groupOrderDao.findOne(infoBO.getOrderId());
//		if (flag) {
//			GroupOrder order = new GroupOrder();
//			order.setOrderStatus(30);
//			order.setId(group.getId());
//			groupOrderDao.save(order);
//		}
//		// 返润
//		if (group != null) {
//			String groupInfo = group.getGroupInfo();
//			if (StringUtils.isNotEmpty(groupInfo)) {
//				Map map = Json.fromJson(HashMap.class, groupInfo);
//				StoreBO storeBO = storeDao.queryStoreById(CommUtil.null2Long(group.getStoreId()));
//				rebateService
//						.sendBuyRebate(infoBO.getUserId(), storeBO.getCreateUserId(), infoBO.getOrderId(),
//								BigDecimal.valueOf(CommUtil.null2Double(map.get("goods_price"))),
//								infoBO.getGroupSn());
//			}
//		}
	}

	public List<GroupInfoBO> selectGroupGoodsByOrderId(@Param("vo") GroupInfoVO vo) {
		return groupInfoDao.selectGroupGoodsByOrderId(vo);
	}

	public GroupInfo findByOrder(Long orderId) {
		List<GroupInfoBO> gis = groupInfoDao.findByOrder(orderId);
		GroupInfo gi = null;
		if (null != gis && gis.size() > 0) {
			gi = gis.get(0);
		}
		return gi;
	}
	
	public List<GroupInfoBO> ListByOrder(Long orderId) {
		List<GroupInfoBO> gis = groupInfoDao.findByOrder(orderId);
		return gis;
	}

	public List<GroupInfoBO> findExpiredGroupInfo() {
		return groupInfoDao.findExpiredGroupInfo();
	}

	public GroupInfoBO queryGroupInfoBySn(Long sellerUid, String groupSn) {
		return groupInfoDao.queryGroupInfoBySn(sellerUid, groupSn);
	}

	public List<GroupInfoBO> queryMultiGroupInfoBySn(Long sellerUid, List<String> groupSnList) {
		return groupInfoDao.queryMultiGroupInfoBySn(sellerUid, groupSnList);
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void groupRefundSucess(GroupInfoVO vo, Long currUserId){
		GroupInfo gi = getObjById(vo.getId().longValue());
		if(null == gi || gi.getId() == null){
			logger.error("can't find this GroupInfo id="+vo.getId());
			return;
		}
		if(vo.getStatus().intValue()!=5){
			return;
		}
		gi.setStatus(7);
		gi.setRefundId(currUserId);
		gi.setRefundCompleteTime(new Date());
		update(gi);
		Long uid = gi.getUserId();
		String title = "您提交的退款订单金额已成功退回到您的云豆帐户，立即查看！";
		String content = gi.getGroupSn() + " 消费码退款成功";
		String redirectUrl = "";
		boolean isUpdate = true;
		List<GroupInfoBO> list = groupInfoDao.findByOrder(gi.getOrderId());
		for (GroupInfoBO bo : list)
			if (bo.getStatus() == 0)
				isUpdate = false;
		GroupOrderBO order = groupOrderDao.get(gi.getOrderId());
		if (isUpdate) {
			order.setLocalReturnStatus(2);
			order.setOrderStatus(30);
			groupOrderDao.update(order);
		}
//		String content = gi.getGroupSn() + " 消费码退款失败";
		Map map = orderFormTools.queryGroupInfo(order.getGroupInfo());
		double price = Double.parseDouble(map.get("goods_price").toString());
		userMoneyService.addMoney(order.getUserId(), price, currUserId, "人工操作", content);
		//推送消息 站内消息
		noticeMessageService.pushGroupRefundSuccessMessage(uid, title, content, redirectUrl, currUserId);
	}	
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void groupRefundRefused(GroupInfoVO vo, Long currUserId){
		GroupInfo gi = getObjById(vo.getId().longValue());
		if(null == gi || gi.getId() == null){
			logger.error("can't find this GroupInfo id="+vo.getId());
			return;
		}
		if(vo.getStatus().intValue()!=6){
			return;
		}
		Long orderId = gi.getOrderId();
		Long uid = gi.getUserId();
		String title = "您申请的退款订单申请失败，立即查看！";
		String content = vo.getRefusedInfo() + " 退款消费码："+ gi.getGroupSn();
		String redirectUrl = "";
		
		//推送消息 站内消息
		noticeMessageService.pushGroupRefundRefusedMessage(uid, title, content, redirectUrl, currUserId , orderId);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updateGroupRefund(GroupInfoVO vo , String reason , Long currUserId ){
		boolean result = false;
		GroupInfo bo = this.getObjById(CommUtil.null2Long(vo.getId()));
		if (bo.getStatus() == 3) {
			bo.setStatus(vo.getStatus());
			bo.setCheckTime(new Date());// 审核时间
			if(vo.getStatus() == 6){//审核不通过 推送+站内短信提醒
				vo.setRefusedInfo(reason);
				this.groupRefundRefused(vo, currUserId);
			}
			if(vo.getStatus() == 5){//审核通过 同时进行退款操作
				vo.setCheckReasion(reason);
				this.groupRefundSucess(vo, currUserId);
			}
			bo.setRefusedInfo(vo.getRefusedInfo());
			bo.setCheckReasion(vo.getCheckReasion());
			this.update(bo);
			GroupInfo info = new GroupInfo();
			info.setReadStatus(0);
			info.setOrderId(bo.getOrderId());
			groupInfoDao.changeReadStatus(info);
			result = true;
		}
		return result;
	}
}
