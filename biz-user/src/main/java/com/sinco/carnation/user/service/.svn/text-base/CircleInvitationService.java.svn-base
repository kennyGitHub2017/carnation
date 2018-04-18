package com.sinco.carnation.user.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.sinco.carnation.sns.bo.CircleInvitationBO;
import com.sinco.carnation.sns.bo.CircleInvitationReplyBO;
import com.sinco.carnation.sns.dao.CircleDao;
import com.sinco.carnation.sns.dao.CircleInvitationDao;
import com.sinco.carnation.sns.dao.CircleInvitationReplyDao;
import com.sinco.carnation.sns.model.Circle;
import com.sinco.carnation.sns.model.CircleInvitation;
import com.sinco.carnation.sns.model.CircleInvitationReply;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.dao.UserCustomerFavoritesDao;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = false)
public class CircleInvitationService {

	private Logger logger = LoggerFactory.getLogger(CircleInvitationService.class);

	@Autowired
	private CircleInvitationDao cInvitationDao;

	@Autowired
	private UserCustomerDao userCustomerDao;

	@Autowired
	private CircleDao circleDao;

	@Autowired
	private UserCustomerFavoritesDao favoritesDao;

	@Autowired
	private CircleInvitationReplyDao replyDao;

	@Autowired
	private IntegralService integralService;

	public List<CircleInvitation> selectInvitationByClassId(Long classId) {
		return cInvitationDao.selectInvitationByClassId(classId);
	}

	public void queryCircleInvatation(Long uid, String type, Integer circleType, Long times,
			MyPage<CircleInvitationBO> page) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<CircleInvitationBO> list = null;
		if (null != times) {
			list = cInvitationDao.queryCircleInvatation(uid, type, circleType,
					format.format(new Date(times)), page);
		} else {
			list = cInvitationDao.queryCircleInvatation(uid, type, circleType, null, page);
		}
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (StringUtils.isNotBlank(list.get(i).getFavoritesInfo())
						&& list.get(i).getFavoritesInfo().indexOf(uid.toString()) != -1) {
					list.get(i).setIsFavo(true);
				} else {
					list.get(i).setIsFavo(false);
				}
				if (StringUtils.isNotBlank(list.get(i).getPraiseInfo())
						&& list.get(i).getPraiseInfo().indexOf(uid.toString()) != -1) {
					list.get(i).setIsPraise(true);
				} else {
					list.get(i).setIsPraise(false);
				}
				if (StringUtils.isNotBlank(list.get(i).getThumbnail())) {
					list.get(i).setHeadImgPath(list.get(i).getThumbnail());
				}
			}
		}
		page.setContent(list);
	}

	public CircleInvitation queryCircleInvitationById(Long fid) {
		return cInvitationDao.queryCircleInvitationById(fid);
	}

	@SuppressWarnings({"unused", "unchecked"})
	@Transactional(readOnly = false)
	public int usersPraise(String fid, Long uid) {
		// 查询帖子信息
		CircleInvitation invitation = cInvitationDao.queryCircleInvitationById(Long.parseLong(fid));
		if (null != invitation && StringUtils.isNotBlank(invitation.getPraiseInfo())) {
			String[] idsArr = invitation.getPraiseInfo().split(",");
			List<String> idsList = CollectionUtils.arrayToList(idsArr);
			if (CollectionUtils.arrayToList(idsArr).contains(String.valueOf(uid))) {
				// 说明已经赞过了
				return -1;
			}
		}
		return cInvitationDao.updateInvitationPraise(Long.parseLong(fid), String.valueOf(uid));
	}

	public List<CircleInvitation> lookInvitation(Long id) {
		return cInvitationDao.lookInvitation(id);
	}

	public CircleInvitationBO selectInvitationDetail(Long id) {
		return cInvitationDao.selectInvitationDetail(id);
	}

	public void circleByInvitationList(Long uid, Long circleId, Long circleType, Long times,
			MyPage<CircleInvitationBO> page) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<CircleInvitationBO> list = null;
		if (null != times) {
			list = cInvitationDao.circleByInvitationList(circleId, circleType,
					format.format(new Date(times)), page);
		} else {
			list = cInvitationDao.circleByInvitationList(circleId, circleType, null, page);
		}
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (uid != null && StringUtils.isNotBlank(list.get(i).getFavoritesInfo())
						&& list.get(i).getFavoritesInfo().indexOf(uid.toString()) != -1) {
					list.get(i).setIsFavo(true);
				} else {
					list.get(i).setIsFavo(false);
				}
				if (uid != null && StringUtils.isNotBlank(list.get(i).getPraiseInfo())
						&& list.get(i).getPraiseInfo().indexOf(uid.toString()) != -1) {
					list.get(i).setIsPraise(true);
				} else {
					list.get(i).setIsPraise(false);
				}
			}
		}
		page.setContent(list);
	}

	public void circleInvitationList(Long uid, MyPage<CircleInvitationBO> page) {
		List<CircleInvitationBO> list = cInvitationDao.circleInvitationList(uid, page);
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (StringUtils.isNotBlank(list.get(i).getFavoritesInfo())
						&& list.get(i).getFavoritesInfo().indexOf(uid.toString()) != -1) {
					list.get(i).setIsFavo(true);
				} else {
					list.get(i).setIsFavo(false);
				}
				if (StringUtils.isNotBlank(list.get(i).getPraiseInfo())
						&& list.get(i).getPraiseInfo().indexOf(uid.toString()) != -1) {
					list.get(i).setIsPraise(true);
				} else {
					list.get(i).setIsPraise(false);
				}
			}
		}
		page.setContent(list);
	}

	@Transactional(readOnly = false)
	public CircleInvitation addInvitation(Long uid, Long circleId, String title, String content, String pic) {
		Circle circle = circleDao.findById(circleId);
		if (null != circle) {
			CircleInvitation invitation = new CircleInvitation();
			invitation.setAddTime(new Date());
			invitation.setCircleId(circle.getId());
			invitation.setCircleName(circle.getClassName());
			invitation.setCircleType(1);
			invitation.setContent(content);
			invitation.setPic(pic);
			invitation.setUserId(uid);
			invitation.setTitle(title);
			invitation.setType("原创");
			invitation.setCircleName(circle.getTitle());
			invitation.setUpdateTime(new Date());
			invitation.setPraiseInfo("");
			invitation.setFavoritesInfo("");
			invitation.setPraiseCount(0);
			invitation.setFavoritesCount(0);
			List<UserCustomer> customer = userCustomerDao.searchCustomer(uid);
			// 设置用户昵称
			if (null != customer && customer.size() > 0) {
				invitation.setUserName(customer.get(0).getNickname());
			}
			// 更新圈子帖子数量
			if (cInvitationDao.addInvitation(invitation) > 0) {
				circle.setInvitationCount(circle.getInvitationCount() + 1);
				if (circleDao.updateById(circle) > 0) {
					// 赠送积分
//					integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_FATIE, uid, null);
					return invitation;
				}
			}
		}

		return null;
	}

	/**
	 * 帖子的回复列表
	 * 
	 * @param invitationId
	 * @param page
	 */
	public List<CircleInvitationReplyBO> queryInvitationReplyList(Long maxId, Long invitationId,
			Integer start, Integer pageSize) {
		return replyDao.replyList(maxId, invitationId, start, pageSize);
	}

	/**
	 * 圈子列表
	 * 
	 * @return
	 */
	public List<Circle> searchCircleList() {
		return circleDao.searchCircleList();
	}

	/**
	 * 帖子评论
	 * 
	 * @param uid
	 * @param invitationId
	 * @param content
	 * @return
	 */
	@Transactional(readOnly = false)
	public int addCommentInvitation(Long uid, Long invitationId, String content, String pic) {
		UserCustomer customer = userCustomerDao.findById(uid);
		if (null != customer) {
			CircleInvitationReply reply = new CircleInvitationReply();
			reply.setAddTime(new Date());
			reply.setContent(content);
			reply.setInvitationId(invitationId);
			reply.setUserId(uid);
			reply.setPic(pic);
			reply.setUserName(customer.getNickname());
			reply.setUserPhoto(customer.getHeadImgPath());
			int count = replyDao.intreplyInvitationCount(invitationId);
			reply.setLevelCount(count + 1);
			if (replyDao.addReplyInvitation(reply) > 0) {
				// 如果评论成功，更新帖子评论数和时间
				CircleInvitation circleInvitation = cInvitationDao.get(invitationId);
				circleInvitation.setReplyCount(circleInvitation.getReplyCount() + 1);
				circleInvitation.setUpdateTime(new Date());
				// circleInvitation.setReplyName(customer.getNickname());
				cInvitationDao.update(circleInvitation);
//				// 评论赠送积分
//				integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_PINGLUN, uid, null);
//				// 被评论送积分
//				integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_BEIPINGLUN,
//						circleInvitation.getUserId(), null);
				return 1;
			}
		}
		return 0;
	}

	/**
	 * 帖子回复
	 * 
	 * @param uid
	 * @param invitationId
	 * @param replyId
	 * @param content
	 * @return
	 */
	@Transactional(readOnly = false)
	public int replyInvitation(Long uid, Long invitationId, Long replyId, String content, String pic) {
		// 查询回复人信息
		UserCustomer customer = userCustomerDao.findById(uid);
		if (null != customer) {
			CircleInvitationReply reply = new CircleInvitationReply();
			reply.setAddTime(new Date());
			reply.setContent(content);
			reply.setPic(pic);
			reply.setInvitationId(invitationId);
			reply.setUserId(uid);
			reply.setUserName(customer.getNickname());
			reply.setUserPhoto(customer.getHeadImgPath());
			reply.setParentId(replyId);
			int count = replyDao.intreplyInvitationCount(invitationId);
			reply.setLevelCount(count + 1);
			if (replyDao.addReplyInvitation(reply) > 0) {

				// 更新回复数量
				CircleInvitationReply reply2 = replyDao.get(reply.getId());
				reply2.setReplyCount(reply2.getReplyCount() + 1);
				replyDao.update(reply2);

				// 回复成功后更新帖子评论数和时间
				CircleInvitation circleInvitation = cInvitationDao.get(invitationId);
				circleInvitation.setReplyCount(circleInvitation.getReplyCount() + 1);
				circleInvitation.setUpdateTime(new Date());
				// circleInvitation.setUserName(customer.getNickname());
				cInvitationDao.update(circleInvitation);
//				// 回复赠送积分
//				integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_PINGLUN, uid, null);
//
//				integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_BEIPINGLUN,
//						circleInvitation.getUserId(), null);
				return 1;
			}
		}
		return 0;
	}

	public void invitationAllListPage(Long uid, Long invitationType, Long timeStamp,
			MyPage<CircleInvitationBO> page) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<CircleInvitationBO> list = null;
		if (null != timeStamp) {
			list = cInvitationDao.invitationAllListPage(invitationType, format.format(new Date(timeStamp)),
					page);
		} else {
			list = cInvitationDao.invitationAllListPage(invitationType, null, page);
		}
		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				if (uid != null && StringUtils.isNotBlank(list.get(i).getFavoritesInfo())
						&& list.get(i).getFavoritesInfo().indexOf(uid.toString()) != -1) {
					list.get(i).setIsFavo(true);
				} else {
					list.get(i).setIsFavo(false);
				}
				if (uid != null && StringUtils.isNotBlank(list.get(i).getPraiseInfo())
						&& list.get(i).getPraiseInfo().indexOf(uid.toString()) != -1) {
					list.get(i).setIsPraise(true);
				} else {
					list.get(i).setIsPraise(false);
				}
			}
		}
		page.setContent(list);
	}

	public void searchInvitation(Long uid, String title, Long times, MyPage<CircleInvitationBO> page) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<CircleInvitationBO> list = null;
		if (null != times) {
			list = cInvitationDao.searchInvitation(title, format.format(new Date(times)), page);
		} else {
			list = cInvitationDao.searchInvitation(title, null, page);
		}
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (uid != null && StringUtils.isNotBlank(list.get(i).getFavoritesInfo())
						&& list.get(i).getFavoritesInfo().indexOf(uid.toString()) != -1) {
					list.get(i).setIsFavo(true);
				} else {
					list.get(i).setIsFavo(false);
				}
				if (uid != null && StringUtils.isNotBlank(list.get(i).getPraiseInfo())
						&& list.get(i).getPraiseInfo().indexOf(uid.toString()) != -1) {
					list.get(i).setIsPraise(true);
				} else {
					list.get(i).setIsPraise(false);
				}
			}
		}
		page.setContent(list);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public int cancleUsersPraise(Long uid, String fid) {
		// 查询帖子信息
		CircleInvitation circle = cInvitationDao.queryCircleInvitationById(Long.parseLong(fid));
		if (null != circle && StringUtils.isNotBlank(circle.getPraiseInfo())) {
			String[] idsArr = circle.getPraiseInfo().split(",");
			List<String> idsList = new ArrayList<String>();
			idsList.addAll(CollectionUtils.arrayToList(idsArr));
			if (!CollectionUtils.arrayToList(idsArr).contains(String.valueOf(uid))) {
				// 说明没赞过了
				return -1;
			}
			idsList.remove(String.valueOf(uid));
			String praise = "";
			if (idsList.size() > 0) {
				praise = StringUtils.join(idsList, ",") + ",";
			}
			return cInvitationDao.updateInvitationUnPraise(Long.parseLong(fid), praise);
		}
		return 0;
	}

	public Map<String, Boolean> userIsPraiseAndFavorite(Long uid, Long invitationId) {

		Map<String, Boolean> mapResult = new HashMap<String, Boolean>();
		mapResult.put("p", false);
		mapResult.put("f", false);
		// 查询帖子信息
		CircleInvitation circle = cInvitationDao.queryCircleInvitationById(invitationId);
		if (null != circle && StringUtils.isNotBlank(circle.getPraiseInfo())) {
			String[] idsArr = circle.getPraiseInfo().split(",");
			if (CollectionUtils.arrayToList(idsArr).contains(String.valueOf(uid))) {
				// 说明赞过了
				mapResult.put("p", true);
			}
		}

		if (null != circle && StringUtils.isNotBlank(circle.getFavoritesInfo())) {
			String[] idsArr = circle.getFavoritesInfo().split(",");
			if (CollectionUtils.arrayToList(idsArr).contains(String.valueOf(uid))) {
				// 说明收藏过了
				mapResult.put("f", true);
			}
		}

		return mapResult;
	}

	public List<Circle> queryCircle(Long circleId) {
		return circleDao.queryCircle(circleId);
	}
	
	/** 查询未加分记录 **/
	public List<CircleInvitationReply> listByisAddIntegral(){
		return replyDao.listByisAddIntegral();
	}
	/** 更新加分状态 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updateIsAddIntegralByid(Long id){
		return replyDao.updateIsAddIntegralByid(id);
	}
	

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addIntegralByid(Long id ,Long uid , String type ,Date time){
		try {
			//变状态
			if(this.updateIsAddIntegralByid(id)>0){
				//加积分
				integralService.addIntegral(type, uid, null, null, null, null,time);
			}
			
		} catch (Exception e) {
			logger.error("[AddIntegralByid] error , uid = "+ uid);
			logger.error("[AddIntegralByid] error"+e);
		}
	}
}
