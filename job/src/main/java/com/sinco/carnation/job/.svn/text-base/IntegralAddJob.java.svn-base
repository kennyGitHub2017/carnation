package com.sinco.carnation.job;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinco.carnation.healthcircle.model.Post;
import com.sinco.carnation.healthcircle.model.PostEvaluate;
import com.sinco.carnation.healthcircle.model.PostPraise;
import com.sinco.carnation.healthcircle.service.PostEvaluateService;
import com.sinco.carnation.healthcircle.service.PostService;
import com.sinco.carnation.juanpi.service.JuanpiOrderService;
import com.sinco.carnation.sns.bo.WenJuanresultHistoryBO;
import com.sinco.carnation.sns.dao.WenJuanresultHistoryDao;
import com.sinco.carnation.sns.model.CircleInvitationReply;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.user.bo.PhysicalResultBO;
import com.sinco.carnation.user.service.CircleInvitationService;
import com.sinco.carnation.user.service.PhysicalService;

public class IntegralAddJob {
	@Autowired
	private WenJuanresultHistoryDao wenJuanresultHistoryDao;
	@Autowired
	private IntegralService integralService;
	@Autowired
	private PostService postService;
	@Autowired
	private	PostEvaluateService postEvaluateService;
	@Autowired
	private CircleInvitationService circleInvitationService;
	@Autowired
	private PhysicalService physicalService;
	@Autowired
	private JuanpiOrderService juanpiOrderService;
	
	private static final Logger logger = LoggerFactory.getLogger(IntegralAddJob.class);
	
	public synchronized void executeJob(){
		synchronized(logger){
			
			this.circlePostAddIntegral();
			this.wjResultHistoryAddIntegral();
			this.healthCircleEvaluateAddIntegral();
			this.circleInvitationAddIntegral();
			this.PostPraiseAddIntegral();
			this.physicalAddIntegral();
			
			//卷皮商品加积分
			this.juanpiOrderAddIntegral();
			logger.info("[IntegralAddJob] is success");
		}
	}
	
	/** 问卷记录加积分 **/
	public void wjResultHistoryAddIntegral(){
		String type = IntegralConstants.INTEGRAL_HEALTH_FENGXIANPINGGU;
		List<WenJuanresultHistoryBO> list = wenJuanresultHistoryDao.listByisAddIntegral();
		if(null == list || list.size() <= 0){
			return;
		}
		for(WenJuanresultHistoryBO BO : list){
			Long uid = BO.getUserId();
			Long id = BO.getId();
			Date time = BO.getCreateTime();
			if(time == null){
				time = new Date();
			}
			//10：问卷，20：疾病
			if(null != BO.getTypes() && BO.getTypes() == 10L){
				type = IntegralConstants.INTEGRAL_HEALTH_CESHI;
			}
			integralService.addWenJuanHistoryIntegralByid(id, uid, type, time);
		}
		logger.info("[wjResultHistoryAddIntegral] is success");
	}
	
	/** 发帖加积分 **/
	public void circlePostAddIntegral(){
		String type = IntegralConstants.INTEGRAL_JIANKANGQUAN_FATIE;
		List<Post> list = postService.listByisAddIntegral();
		if(null == list || list.size() <= 0){
			return;
		}
		for(Post BO : list){
			Long uid = BO.getUserId();
			Long id = BO.getId();
			Date time = BO.getAddTime();
			if(time == null){
				time = new Date();
			}
			postService.addIntegralByid(id, uid, type, time);
			
		}
		logger.info("[circlePostAddIntegral] is success");
	}
	
	/** 健康圈评论加积分  **/
	public void healthCircleEvaluateAddIntegral(){
		String type = IntegralConstants.INTEGRAL_JIANKANGQUAN_PINGLUN;
		String typeB = IntegralConstants.INTEGRAL_JIANKANGQUAN_BEIPINGLUN;
		List<PostEvaluate> list = postEvaluateService.listByisAddIntegral();
		if(null == list || list.size() <= 0){
			return;
		}
		for(PostEvaluate BO : list){
			Long uid = BO.getFromUserid();
			Long id = BO.getId();
			Date time = BO.getAddTime();
			if(time == null){
				time = new Date();
			}
			postEvaluateService.addIntegralByid(id, uid, type, time, BO.getPostId(), typeB);
		}
		logger.info("[healthCircleEvaluateAddIntegral] is success");
	}
	
	/** 官方帖子评论加积分 **/
	public void circleInvitationAddIntegral(){
		String type = IntegralConstants.INTEGRAL_JIANKANGQUAN_PINGLUN;
		List<CircleInvitationReply> list = circleInvitationService.listByisAddIntegral();
		if(null == list || list.size() <= 0){
			return;
		}
		for(CircleInvitationReply BO : list){
			Long uid = BO.getUserId();
			Long id = BO.getId();
			Date time = BO.getAddTime();
			if(time == null){
				time = new Date();
			}
			circleInvitationService.addIntegralByid(id, uid, type, time);
		}
		logger.info("[circleInvitationAddIntegral] is success");
	}

	/** 点赞 **/
	public void PostPraiseAddIntegral(){
		String type = IntegralConstants.INTEGRAL_JIANKANGQUAN_DIANZAN;
		String typeB = IntegralConstants.INTEGRAL_JIANKANGQUAN_BEIDIANZAN;
		List<PostPraise> list = postService.listPraiseByisAddIntegral();
		if(null == list || list.size() <= 0){
			return;
		}
		for(PostPraise BO : list){
			Long uid = BO.getFromUserid();
			Long id = BO.getId();
			Date time = BO.getAddTime();
			if(time == null){
				time = new Date();
			}
			postService.addPraiseIntegralByid(id, uid, type, time, BO.getPostId(), typeB);
		}
		logger.info("[PostPraiseAddIntegral] is success");
	}
	/** 体检 **/
	public void physicalAddIntegral(){
		String type = IntegralConstants.INTEGRAL_HEALTH_TIJIAN;
		List<PhysicalResultBO> list = physicalService.listByisAddIntegral();
		if(null == list || list.size() <= 0){
			return;
		}
		for(PhysicalResultBO BO : list){
			if(StringUtils.isBlank(BO.getCreateBy())){
				break;
			}
			Long uid = Long.valueOf(BO.getCreateBy());
			Long id = BO.getId();
			Date time = new Date();//体检按日期保存没有精确到秒
			//加积分
			physicalService.addIntegralByid(id, uid, type, time);
		}
		logger.info("[physicalAddIntegral] is success");
	}
	/** 问卷调查 **/

	/** 卷皮商品 **/
	public void juanpiOrderAddIntegral(){
		 juanpiOrderService.juanpiOrderAddIntegral();
	}
	
	
	
	public WenJuanresultHistoryDao getWenJuanresultHistoryDao() {
		return wenJuanresultHistoryDao;
	}

	public void setWenJuanresultHistoryDao(WenJuanresultHistoryDao wenJuanresultHistoryDao) {
		this.wenJuanresultHistoryDao = wenJuanresultHistoryDao;
	}

	public IntegralService getIntegralService() {
		return integralService;
	}

	public void setIntegralService(IntegralService integralService) {
		this.integralService = integralService;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public PostEvaluateService getPostEvaluateService() {
		return postEvaluateService;
	}

	public void setPostEvaluateService(PostEvaluateService postEvaluateService) {
		this.postEvaluateService = postEvaluateService;
	}

	public CircleInvitationService getCircleInvitationService() {
		return circleInvitationService;
	}

	public void setCircleInvitationService(CircleInvitationService circleInvitationService) {
		this.circleInvitationService = circleInvitationService;
	}

	public PhysicalService getPhysicalService() {
		return physicalService;
	}

	public void setPhysicalService(PhysicalService physicalService) {
		this.physicalService = physicalService;
	}

	public JuanpiOrderService getJuanpiOrderService() {
		return juanpiOrderService;
	}

	public void setJuanpiOrderService(JuanpiOrderService juanpiOrderService) {
		this.juanpiOrderService = juanpiOrderService;
	}
}
