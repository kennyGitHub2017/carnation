package com.sinco.carnation.user.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.sns.bo.UserHealthtaskBO;
import com.sinco.carnation.sns.bo.UserHealthtaskRelationBO;
import com.sinco.carnation.sns.bo.UserHealthtaskSetBO;
import com.sinco.carnation.sns.bo.UserHealthtaskSignlogBO;
import com.sinco.carnation.sns.dao.UserHealthtaskDao;
import com.sinco.carnation.sns.dao.UserHealthtaskRelationDao;
import com.sinco.carnation.sns.dao.UserHealthtaskSetDao;
import com.sinco.carnation.sns.dao.UserHealthtaskSignlogDao;
import com.sinco.carnation.sns.model.UserHealthtask;
import com.sinco.carnation.sns.model.UserHealthtaskRelation;
import com.sinco.carnation.sns.model.UserHealthtaskSet;
import com.sinco.carnation.sns.model.UserHealthtaskSignlog;
import com.sinco.carnation.sns.vo.UserHealthtaskVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class UserHealthTaskService {

	@Autowired
	private UserHealthtaskDao userHealthTaskDao;
	@Autowired
	private UserHealthtaskRelationDao userHealthtaskRelationDao;
	@Autowired
	private UserHealthtaskSetDao userHealthtaskSetDao;
	@Autowired
	private UserHealthtaskSignlogDao userHealthtaskSignlogDao;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 健康任务
	 * 
	 * @return
	 */
	public void getHealthTaskListSer(MyPage<UserHealthtaskBO> page, Long uid) {
		// 获取用户已参与的活动ID
		List<Long> userthID_List = this.userHealthtaskRelationDao.get_userJoinTaskID_ByUserID(uid);

		List<UserHealthtaskBO> list = userHealthTaskDao.get_HealthTaskList_Dao(page, userthID_List);
		if (list != null && list.size() > 0) {
			page.setContent(list);
		} else {
			page.setContent(new ArrayList<UserHealthtaskBO>());
		}
	}

	public List<UserHealthtaskBO> getHealthTaskByLike(String taskName, Long userID) {
		// 获取用户已参与的活动ID
		List<Long> userHealthTask_List = this.userHealthtaskRelationDao.get_userJoinTaskID_ByUserID(userID);

		if (userHealthTask_List == null || userHealthTask_List.size() == 0) {
			userHealthTask_List = null;
		}
		// 搜索活动
		List<UserHealthtaskBO> list = this.userHealthTaskDao.get_HealthTaskList_Dao(taskName,
				userHealthTask_List);
		if (list != null && list.size() > 0) {
			return list;
		}
		return new ArrayList<UserHealthtaskBO>();
	}

	public int save_userHealthTaskSer(Long uid, UserHealthtaskVO vo) {
		int operType = vo.getOperType();
		int result = oper_Succ;
		switch (operType) {
			case operType_SetUp: // 创建任务
				/*创建健康任务*/
				UserHealthtask userht = new UserHealthtask();
				userht.setTaskName(vo.getTaskName());
				userht.setJoinNum(new Long(0));
				userht.setCreateBy(uid);
				if (vo.getIsOpen() == 1) // 任务开启
				{
					int row0 = this.userHealthTaskDao.insert_userHealthTaskDao(userht);
					long userht_ID = userht.getId();
					logger.info("...... insert result ID:" + userht_ID);
					/*创建健康任务设置*/
					UserHealthtaskSet ht_set = new UserHealthtaskSet();
					ht_set.setUserHealthtaskId(userht_ID);
					ht_set.setUserId(uid);
					ht_set.setRemindTime(vo.getRemindTime());

					String week = vo.getRemindWeek();
					boolean isConains = week.contains(",");
					if (isConains) {
						String[] weekArr = week.split(",");
						for (int i = 0; i < weekArr.length; i++) {
							this.setWeek(ht_set, weekArr[i]);
						}
					} else {
						this.setWeek(ht_set, week);
					}
					int row1 = this.userHealthtaskSetDao.insert_UserHealthtaskSetDao(ht_set);
					/*用户与健康任务关系表*/
					UserHealthtaskRelation relation = new UserHealthtaskRelation();
					relation.setUserId(uid);
					relation.setUserHealthtaskId(userht_ID);
					relation.setDoDays(new Long("0"));
					int row2 = this.userHealthtaskRelationDao.insert_UserHealthtaskRelationDao(relation);
					if (row0 < 0 || row1 < 0 || row2 < 0) {
						result = oper_Failed; // 操作失败
					}
				}
				break;
			case operType_Join: // 参与任务
				UserHealthtaskBO userHealthtaskBO = this.userHealthTaskDao.findOne(vo.getId());
				if (userHealthtaskBO != null && vo.getIsOpen() == 1) {
					long userHealtTask_ID = userHealthtaskBO.getId();

					UserHealthtaskSetBO taskSet = this.userHealthtaskSetDao.findOne_By_UID_TaskIDDao(uid,
							userHealtTask_ID);

					/*健康任务设置*/
					UserHealthtaskSet set = new UserHealthtaskSet();
					set.setRemindTime(vo.getRemindTime());
					String week00 = vo.getRemindWeek();
					boolean isConains00 = week00.contains(",");
					if (isConains00) {
						String[] weekArr = week00.split(",");
						for (int i = 0; i < weekArr.length; i++) {
							this.setWeek(set, weekArr[i]);
						}
					} else {
						this.setWeek(set, week00);
					}
					int inRow01 = 0;
					int updateRow03 = 0;
					if (taskSet != null) // 更新
					{
						long id = taskSet.getId();
						set.setId(id);
						this.userHealthtaskSetDao.updateUserHealthTaskSetDao(set);

						UserHealthtaskRelationBO relation = userHealthtaskRelationDao
								.getUserHealthtaskRelationOne(uid, userHealtTask_ID);
						if (relation.getIsDeleted() == 1) // 如果任务被关闭则开启
						{
							Long relationID = relation.getId();
							UserHealthtaskRelation updateRelation = new UserHealthtaskRelation();
							updateRelation.setId(relationID);
							updateRelation.setIsDeleted(0L); // 开启
							this.userHealthtaskRelationDao.update(updateRelation);
						}
					}
					if (taskSet == null) // 添加
					{
						set.setUserHealthtaskId(userHealtTask_ID);
						set.setUserId(uid);

						inRow01 = this.userHealthtaskSetDao.insert_UserHealthtaskSetDao(set);
						/*用户与健康任务关系表*/
						UserHealthtaskRelation relation0 = new UserHealthtaskRelation();
						relation0.setUserId(uid);
						relation0.setUserHealthtaskId(userHealtTask_ID);
						relation0.setDoDays(new Long("0"));
						int inRow02 = this.userHealthtaskRelationDao
								.insert_UserHealthtaskRelationDao(relation0);
						/*更新健康任务参与人数*/
						updateRow03 = this.userHealthTaskDao.update_JoinNum_ByPrimaryKeyDao(userHealtTask_ID);
						if (inRow01 < 0 || inRow02 < 0 || updateRow03 < 0) {
							result = oper_Failed;
						}
					}

				} else if (vo.getIsOpen() == 0) // 健康任务不开启 执行添加存在 不执行更新操作
				{
					long userHealtTask_ID = userHealthtaskBO.getId();
					UserHealthtaskSetBO taskSet = this.userHealthtaskSetDao.findOne_By_UID_TaskIDDao(uid,
							userHealtTask_ID);
					if (taskSet == null) {
						/*健康任务设置*/
						UserHealthtaskSet set = new UserHealthtaskSet();
						set.setUserHealthtaskId(userHealtTask_ID);
						set.setUserId(uid);
						/*this.userHealthtaskSetDao.insert_UserHealthtaskSetDao(set);
						result = oper_Succ;*/
						int row1 = this.userHealthtaskSetDao.insert_UserHealthtaskSetDao(set);
						/*用户与健康任务关系表*/
						UserHealthtaskRelation relation0 = new UserHealthtaskRelation();
						relation0.setUserId(uid);
						relation0.setUserHealthtaskId(userHealtTask_ID);
						relation0.setDoDays(new Long("0"));
						relation0.setIsDeleted(1L);
						int row2 = this.userHealthtaskRelationDao.insert_UserHealthtaskRelationDao(relation0);
						/*更新健康任务参与人数*/
						int row3 = this.userHealthTaskDao.update_JoinNum_ByPrimaryKeyDao(userHealtTask_ID);
						if (row1 < 0 || row2 < 0 || row3 < 0) {
							result = oper_Failed;
						}
					}
					if (taskSet != null) {
						UserHealthtaskRelationBO relation = userHealthtaskRelationDao
								.getUserHealthtaskRelationOne(uid, userHealtTask_ID);
						Long relationID = relation.getId();
						UserHealthtaskRelation updateRelation = new UserHealthtaskRelation();
						updateRelation.setId(relationID);
						updateRelation.setIsDeleted(1L); // 关闭
						this.userHealthtaskRelationDao.update(updateRelation);
					}
				} else {
					result = task_is_no;
				}
				break;
		}
		return result;
	}

	public List<UserHealthtaskBO> getTodayHealthTaskSer(Date date, Long uid) {
		String week = UserHealthTaskService.getWeekOfDate(date);
		if (week.equals("0")) {
			week = "7";
		}
		UserHealthtaskSet taskSet = new UserHealthtaskSet();
		this.setWeek(taskSet, week);
		taskSet.setUserId(uid);
		List<UserHealthtaskSetBO> setList = this.userHealthtaskSetDao.select_Today_HealthTaskDao(taskSet);

		logger.info("=====" + setList.toString());

		if (setList == null || setList.size() <= 0) {
			return null;
		}

		List<Long> taskID_list = new ArrayList<Long>();
		for (UserHealthtaskSetBO obj : setList) {
			taskID_list.add(obj.getUserHealthtaskId());
		}
		String nowDate = UserHealthTaskService.getNowDate();
		logger.info(".... nowDate:" + nowDate);
		List<UserHealthtaskRelationBO> relationList = this.userHealthtaskRelationDao
				.get_Today_HealthTaskRelationDao(uid, taskID_list);

		Map<Long, Integer> finishMap = new HashMap<Long, Integer>();
		Map<Long, Long> taskID_SignLogID_Map = new HashMap<Long, Long>();

		List<Long> taskIDList = new ArrayList<Long>();

		for (UserHealthtaskRelationBO obj : relationList) {
			String finish = obj.getFinishTime();
			long userHealthtaskId = obj.getUserHealthtaskId();
			if (finish != null && finish.equals(nowDate)) {
				finishMap.put(userHealthtaskId, healthTask_State_finish);
				UserHealthtaskSignlog signLog = new UserHealthtaskSignlog();
				signLog.setUserHealthtaskId(obj.getUserHealthtaskId());
				signLog.setUserId(uid);

				UserHealthtaskSignlogBO signLog_result = this.userHealthtaskSignlogDao.selectByCondition(
						signLog).get(0);
				if (signLog_result != null && signLog_result.getId() != null) {
					Long signLogID = signLog_result.getId();
					taskID_SignLogID_Map.put(obj.getUserHealthtaskId(), signLogID);
				}
			} else {
				finishMap.put(userHealthtaskId, healthTask_State_unfinished);
			}
			taskIDList.add(userHealthtaskId);
		}
		List<UserHealthtaskBO> list = new ArrayList<UserHealthtaskBO>();
		if (taskIDList.size() != 0) {
			list = this.userHealthTaskDao.get_List_In_ID(taskIDList);
		}
		List<UserHealthtaskBO> unFinishedList = new ArrayList<UserHealthtaskBO>();

		List<UserHealthtaskBO> finishedList = new ArrayList<UserHealthtaskBO>();

		logger.info("=========" + finishMap.toString());

		for (UserHealthtaskBO obj : list) {
			obj.setFinishState(finishMap.get(obj.getId()));
			obj.setFinishTaskURL("");
			if (taskID_SignLogID_Map.containsKey(obj.getId())) {
				obj.setFinishTaskURL("v1/ht/signLog?signLogID=" + taskID_SignLogID_Map.get(obj.getId())
						+ "&uid=" + uid);
			}
			if (obj.getDescribes() == null || obj.getDescribes().trim().length() == 0) {
				obj.setDescribes("当前任务无描述");
			}
			if (obj.getSignType() == 1) {
				obj.setYinDaoURL("");
			}
			if (obj.getSignType() == 2) {
				obj.setYinDaoURL(obj.getTaskURL());
			}
			if (obj.getFinishState() == healthTask_State_unfinished) {
				unFinishedList.add(obj);
			}
			if (obj.getFinishState() == healthTask_State_finish) {
				finishedList.add(obj);
			}
		}
		// 排序
		List<UserHealthtaskBO> resultList = new ArrayList<UserHealthtaskBO>();
		for (UserHealthtaskBO obj1 : unFinishedList) {
			resultList.add(obj1);
		}
		for (UserHealthtaskBO obj2 : finishedList) {
			resultList.add(obj2);
		}
		return resultList;
	}

	public UserHealthtaskBO findOne(Long id) {
		return this.userHealthTaskDao.findOne(id);
	}

	private static String getNowDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		return df.format(new Date());
	}

	private static String getWeekOfDate(Date dt) {
		/* String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};*/
		String[] weekDay = {"0", "1", "2", "3", "4", "5", "6"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return weekDay[w];
	}

	private void setWeek(UserHealthtaskSet obj, String weekStr) {
		Integer week = Integer.valueOf(weekStr);
		Long trueL = new Long("1");
		switch (week) {
			case Every:
				obj.setRemindWeek("1");
				break;
			case Mon: // 周一
				obj.setMon(trueL);
				break;
			case Tue: // 周二
				obj.setTue(trueL);
				break;
			case Wed: // 周三
				obj.setWed(trueL);
				break;
			case Thu: // 周四
				obj.setThu(trueL);
				break;
			case Fri: // 周五
				obj.setFri(trueL);
				break;
			case Sat: // 周六
				obj.setSat(trueL);
				break;
			case Sun: // 周日
				obj.setSun(trueL);
				break;
		}
	}

	public int deleteByIDService(long id) {
		return this.userHealthTaskDao.deleteByID(id);
	}

	/**
	 * 获取系统类型健康任务(用户未参加的)
	 * 
	 * @return
	 */
	public void getSysHealthTaskList(MyPage<UserHealthtaskBO> page, long uid) {
		// 获取用户参加的健康任务
		List<Long> taskIDList = this.userHealthtaskRelationDao.get_userJoinTaskID_ByUserID(uid);
		if (taskIDList.size() == 0) {
			taskIDList = null;
		}
		List<UserHealthtaskBO> list = this.userHealthTaskDao.getSysHealthTask(page, taskIDList);
		page.setContent(list);
	}

	public UserHealthtaskSignlogBO query_OneSignLog_By_ID(Long id) {
		return this.userHealthtaskSignlogDao.findOne(id);
	}

	public UserHealthtaskSignlogBO query_OneSignLog_By_UIDAndTaskID(Long uid, Long taskID, String currentDate) {
		UserHealthtaskSignlogBO result = null;

		UserHealthtaskSignlog signLog = new UserHealthtaskSignlog();
		signLog.setUserId(uid);
		signLog.setUserHealthtaskId(taskID);
		List<UserHealthtaskSignlogBO> list = this.userHealthtaskSignlogDao.selectByCondition(signLog);
		if (list == null || list.size() == 0) {
			return null;
		}
		result = list.get(0);
		Date signTime = result.getSignTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String signTimeStr = sdf.format(signTime);
		if (!(signTimeStr.equals(currentDate))) {
			return null;
		}
		return result;
	}

	public UserHealthtaskSetBO query_HealthTaskSetByUIdAndTaskID(Long uid, Long taskID) {
		UserHealthtaskSetBO set = this.userHealthtaskSetDao.findOne_By_UID_TaskIDDao(uid, taskID);
		if (set != null && set.getId() != null) {
			return set;
		}
		return null;
	}

	/**
	 * 判断健康任务是否开启
	 * 
	 * @param uid
	 * @param taskID
	 * @return true:开启 false:关闭
	 */
	public boolean query_HealthTaskRelation_isOpen(Long uid, Long taskID) {
		UserHealthtaskRelationBO relation = this.userHealthtaskRelationDao.getUserHealthtaskRelationOne(uid,
				taskID);
		if (relation != null && relation.getId() != 0l) {
			long is_open = relation.getIsDeleted();
			if (is_open == 1l) {
				return false; // close
			} else if (is_open == 0l) {
				return true; // open
			}
		}
		return true;
	}

	// ///////////////////// 业务逻辑常量 author:yuleijia/////////////////////////
	/**
	 * 20:创建任务
	 */
	public final static int operType_SetUp = 20;
	/**
	 * 10:参与任务
	 */
	public final static int operType_Join = 10;
	/**
	 * 200:操作失败
	 */
	public final static int oper_Failed = 200;
	/**
	 * 100：操作成功
	 */
	public final static int oper_Succ = 100;
	/**
	 * 300:任务不存在
	 */
	public final static int task_is_no = 300;

	public final static int Every = 0;

	public final static int Mon = 1;

	public final static int Tue = 2;

	public final static int Wed = 3;

	public final static int Thu = 4;

	public final static int Fri = 5;

	public final static int Sat = 6;

	public final static int Sun = 7;
	/**
	 * 健康任务完成状态：0：未完成
	 */
	public final static int healthTask_State_unfinished = 0;
	/**
	 * 健康任务完成状态：1：已完成
	 */
	public final static int healthTask_State_finish = 1;

	public static void main(String[] args) {
		String t = "1,2,3";
		boolean boo = t.contains(",");
		System.out.println(boo);
		String[] strArr = t.split(",");
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
	}

}
