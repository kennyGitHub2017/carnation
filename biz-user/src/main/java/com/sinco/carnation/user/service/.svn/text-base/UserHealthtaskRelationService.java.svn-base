package com.sinco.carnation.user.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.sns.bo.UserHealthtaskBO;
import com.sinco.carnation.sns.bo.UserHealthtaskRelationBO;
import com.sinco.carnation.sns.bo.UserHealthtaskSetBO;
import com.sinco.carnation.sns.dao.UserHealthtaskDao;
import com.sinco.carnation.sns.dao.UserHealthtaskRelationDao;
import com.sinco.carnation.sns.dao.UserHealthtaskSetDao;
import com.sinco.carnation.sns.dao.UserHealthtaskSignlogDao;
import com.sinco.carnation.sns.model.UserHealthtaskSignlog;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class UserHealthtaskRelationService {

	private Logger logger = LoggerFactory.getLogger(UserHealthtaskRelationService.class);

	@Autowired
	private UserHealthtaskRelationDao userHealthtaskRelationDao;

	@Autowired
	private UserHealthtaskDao userHealthTaskDao;

	@Autowired
	private UserHealthtaskSetDao userHealthtaskSetDao;

	@Autowired
	private UserHealthtaskSignlogDao userHealthtaskSignlogDao;

	public MyPage<UserHealthtaskRelationBO> selectPageByUserID(MyPage<UserHealthtaskRelationBO> page,
			Long userID) {
		List<UserHealthtaskRelationBO> list = this.userHealthtaskRelationDao
				.select_UserHealthtaskRelation_By_UserId(userID, page);
		page.setContent(list);
		return page;
	}

	@SuppressWarnings("unused")
	public UserHealthtaskRelationBO getTaskSingInfo(Long uid, Long taskID) {
		logger.info("<<<<< uid:" + uid + " taskID:" + taskID);
		UserHealthtaskRelationBO resultObj = null;
		UserHealthtaskRelationBO uhrbo = this.userHealthtaskRelationDao.getUserHealthtaskRelationOne(uid,
				taskID);
		if (uhrbo != null) {
			UserHealthtaskBO userHealthTaskObj = this.userHealthTaskDao.findOne(taskID);
			UserHealthtaskSetBO setBo = this.userHealthtaskSetDao.findOne_By_UID_TaskIDDao(uid, taskID);
			resultObj = new UserHealthtaskRelationBO();
			resultObj.setTaskID(userHealthTaskObj.getId());
			resultObj.setTaskName(userHealthTaskObj.getTaskName());
			resultObj.setDoDays(uhrbo.getDoDays());
			/*resultObj.setWeeks(this.handleWeeks(setBo));*/
			resultObj.setId(uhrbo.getId());
			resultObj.setUserId(uhrbo.getUserId());
		}
		return resultObj;
	}

	@SuppressWarnings("unused")
	private String handleWeeks(UserHealthtaskSetBO obj) {
		String result = "";
		String remindWeek = obj.getRemindWeek();
		if (remindWeek != null && remindWeek.equals("1")) {
			result = "0"; // 每天
		} else {
			Long mon = (long) (obj.getMon() == 1 ? 1 : 0);
			Long tue = (long) (obj.getTue() == 1 ? 2 : 0);
			Long wed = (long) (obj.getWed() == 1 ? 3 : 0);
			Long thu = (long) (obj.getThu() == 1 ? 4 : 0);
			Long fri = (long) (obj.getFri() == 1 ? 5 : 0);
			Long sat = (long) (obj.getSat() == 1 ? 6 : 0);
			Long sun = (long) (obj.getSun() == 1 ? 7 : 0);
			Long[] longArr = {mon, tue, wed, thu, fri, sat, sun};
			for (int i = 0; i < longArr.length; i++) {
				long temp_week = longArr[i];
				if (temp_week != 0) {
					String temp = String.valueOf(temp_week);
					int temp_length = result.trim().length();
					if (temp_length == 0) {
						result = temp;
					} else if (temp_length > 0) {
						result += "," + temp;
					}
				}
			}
		}
		logger.info("<<<<<<< result:" + result);
		return result;
	}

	/**
	 * 用户健康任务签到
	 * 
	 * @param id
	 * @param uid
	 * @param taskID
	 * @param finishTime
	 * @return
	 */
	public int updateUserHealthTaskSign(long id, long uid, long taskID, String finishTime) {
		int result = this.userHealthtaskRelationDao.updateUserHealthTaskSign(id, uid, taskID, finishTime);
		if (result > 0) {
			long doDays = this.userHealthtaskRelationDao.findOne(id).getDoDays();

			UserHealthtaskSignlog log = new UserHealthtaskSignlog();
			log.setUserId(uid);
			log.setIsDeleted(new Long("0"));
			log.setUserHealthtaskId(taskID);
			Long signWeek = Long.parseLong(this.getWeekOfDate(new Date()));
			log.setSignWeek(signWeek);
			log.setDays(String.valueOf(doDays));
			userHealthtaskSignlogDao.save(log);
		}
		return 0;
	}

	public int delete_HealthTask(Long userID, Long taskID) {
		int row1 = this.userHealthtaskSetDao.deleteHealthtaskSet(userID, taskID);
		int row2 = this.userHealthtaskRelationDao.deleteHealthtaskRelation(userID, taskID);
		if (row1 > 0 && row2 > 0) {
			return 1;
		}
		return 0;
	}

	public String getWeekOfDate(Date date) {
		String[] weekDays = {"7", "1", "2", "3", "4", "5", "6"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return weekDays[w];
	}

	public static void main(String[] args) {
		long l = 1;
		if (l == 1) {
			System.out.println("=");
		}
	}
}
