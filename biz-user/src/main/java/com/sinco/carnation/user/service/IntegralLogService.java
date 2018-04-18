package com.sinco.carnation.user.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.service.NoticeMessageService;
import com.sinco.carnation.sys.vo.IntegralRegVO;
import com.sinco.carnation.user.bo.IntegralLogBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.dao.IntegralLogDao;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.model.IntegralLog;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.vo.IntegralLogVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class IntegralLogService {
	@Autowired
	private IntegralLogDao integralLogDao;

	@Autowired
	private UserCustomerDao userCustomerDao;

	@Autowired
	private NoticeMessageService noticeMessageService;

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(IntegralLogService.class);

	public void save(IntegralLog integralLog) {
		integralLogDao.save(integralLog);
	}

	public IntegralLog getObjById(Long id) {
		IntegralLog integralLog = this.integralLogDao.get(id);
		if (integralLog != null) {
			return integralLog;
		}
		return null;
	}

	@Transactional(readOnly = true)
	public void delete(Long id) {
		integralLogDao.remove(id);
	}

	@Transactional(readOnly = true)
	public void batchDelete(List<Serializable> integralLogIds) {
		for (Serializable id : integralLogIds) {
			delete((Long) id);
		}
	}

	@Transactional(readOnly = true)
	public void update(IntegralLog integralLog) {
		integralLogDao.update(integralLog);
	}

	@Transactional(readOnly = false)
	public void saveIntegrall(String userName, String operateType, String content, String integral,
			Long operateUserId) {
		UserCustomer customer = userCustomerDao.queryUserCuxtomerByLoginName(userName);
		if (operateType.equals("add")) {
			if (customer.getIntegral() == null) {
				customer.setIntegral(0);
			}
			customer.setIntegral(customer.getIntegral() + CommUtil.null2Int(integral));
		} else {
			if (customer.getIntegral() > CommUtil.null2Int(integral))
				customer.setIntegral(customer.getIntegral() - CommUtil.null2Int(integral));
			else
				customer.setIntegral(0);
		}
		customer.setUpdateTime(new Date());
		// 增加积分日志
		addIntegralLog(operateType, content, integral, customer.getUid(), operateUserId);
		// 更新用户积分
		userCustomerDao.updateByPrimaryKeySelective(customer);
	}

	/**
	 * 增加积分日志
	 * 
	 * @param operateType
	 * @param content
	 * @param integral
	 * @param userId
	 * @param operateUserId
	 */
	@SuppressWarnings("unused")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addIntegralLog(String operateType, String content, String integral, Long userId,
			Long operateUserId) {
		IntegralLog log = new IntegralLog();
		log.setAddtime(new Date());
		log.setContent(content);

		String pushDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String message;

		UserCustomerBO balance = userCustomerDao.findBOByUserId(userId);// 用户信息

		if (operateType.equals("add")) {
			log.setIntegral(CommUtil.null2Int(integral));
			message = "您增加" + integral + "积分";
		} else {
			log.setIntegral(-CommUtil.null2Int(integral));
			message = "您减少" + integral + "积分";
		}

		log.setBalance(balance.getIntegral());// 积分余额

		log.setIntegralUserId(userId);
		log.setOperateUserId(operateUserId);
		log.setType("system");
		integralLogDao.save(log);
		//个人端除春雨医生推送消息，其它都关闭2017-05-26 tw
		/*try {

			NoticeMessage noticeMesg = new NoticeMessage();
			noticeMesg.setUid(userId);
			noticeMesg.setPushType("integral");
			String addDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			String operateTypeName = "获得";
			if (operateType.equals("add")) {
				operateTypeName = "获得";
			} else {
				operateTypeName = "减少";
			}

			String pushMessage = "您于" + addDate + operateTypeName + integral + "积分";
			// 消息推送
			noticeMesg.setNoticeMessage(pushMessage);
			noticeMesg.setCreateTime(new Date());
			noticeMessageService.save(noticeMesg);
			noticeMessageService.pushMessage(noticeMesg);
			logger.info("=======积分消息推送=========");
		} catch (Exception e) {
			logger.info("=======积分消息推送出现异常=========");
		}*/
	}

	public void queryIntegralPageList(String loginName, MyPage<IntegralLogBO> page) {
		page.setContent(integralLogDao.queryIntegralPageList(loginName, page));
	}

	public void queryIntegralPageListByUid(Long uid, MyPage<IntegralLogBO> page) {
		page.setContent(integralLogDao.queryIntegralPageListByUid(uid, page));
	}

	public void queryUserIntegralPageListByUid(Long uid, MyPage<IntegralLogBO> page) {
		page.setContent(integralLogDao.queryUserIntegralPageListByUid(uid,
				IntegralConstants.INTEGRAL_FLIP_CARDS_REMEDIAL_MARK, page));
	}

	public int checkIntegralLog(IntegralRegVO vo) {
		return this.integralLogDao.checkIntegralLog(vo);
	}

	public void queryByVO(IntegralLogVO vo, MyPage<IntegralLogBO> page) {
		integralLogDao.queryByVO(vo, page);
	}

	public List<IntegralLogBO> selectIntegralPageList(String loginName, String type,String beginTime,String endTime,
			MyPage<IntegralLogBO> page) {
		return integralLogDao.selectIntegralPageList(loginName, type,beginTime,endTime,page);
	}
	
	public boolean saveLog(String content , Long uid ,Long operatorUid , Integer integral , Integer balance , String type){
		boolean result = false;
		// 记录日志
		IntegralLog log = new IntegralLog();
		log.setAddtime(new Date());
		log.setContent(content);
		log.setIntegral(integral);
		log.setBalance(balance);
		log.setIntegralUserId(uid);
		log.setOperateUserId(operatorUid);
		log.setType(type);
		if(this.integralLogDao.save(log)!=null){
			result = true;
		}
		return result;
	}
}
