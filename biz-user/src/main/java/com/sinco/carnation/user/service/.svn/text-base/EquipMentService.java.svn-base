package com.sinco.carnation.user.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.user.bo.UserSleepRecordBO;
import com.sinco.carnation.user.bo.UserStepRecordBO;
import com.sinco.carnation.user.dao.UserSleepRecordDao;
import com.sinco.carnation.user.dao.UserStepRecordDao;
import com.sinco.carnation.user.model.UserSleepRecord;
import com.sinco.carnation.user.model.UserStepRecord;
import com.sinco.dal.utils.DateUtils;

@Service
@Transactional(readOnly = true)
public class EquipMentService {

	@Autowired
	private UserStepRecordDao stepDao;

	@Autowired
	private UserSleepRecordDao sleepDao;

	@Transactional(readOnly = false)
	public int equipMentAdd(Long uid, Integer stepNumber, Long calories, Double dist) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		UserStepRecord stepRecord = stepDao.findByUidAndTime(uid, format.format(new Date()));
		if (null != stepRecord) {
			stepRecord.setCalories(calories);
			stepRecord.setStepNumber(stepNumber);
			stepRecord.setTotalKm(dist);
			stepRecord.setRecordDate(new Date());
			stepDao.update(stepRecord);
			return 1;
		} else {
			UserStepRecord record = new UserStepRecord();
			record.setCalories(calories);
			record.setRecordDate(new Date());
			record.setUid(uid);
			record.setTotalKm(dist);
			record.setStepNumber(stepNumber);
			return stepDao.addUserStepRecord(record);
		}
	}

	public UserStepRecord equipDayQuery(Long uid) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return stepDao.findByUidAndTime(uid, format.format(new Date()));
	}

	public UserStepRecord equipDayQueryByDate(Long uid, String date) {

		return stepDao.findByUidAndTime(uid, date);
	}

	public List<UserStepRecordBO> weekStepRecord(Long uid) {
		return stepDao.weekStepRecord(uid);
	}

	@Transactional(readOnly = false)
	public int sleepRescordAdd(Long uid, Integer sleepSecond, Integer deepSleepSecond,
			Integer shallowSleepSecond) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		UserSleepRecord sleepRecord = sleepDao.findByUidAndTime(uid, format.format(new Date()));
		if (null != sleepRecord) {
			// 记录存在，更新时间
			sleepRecord.setRecordDate(new Date());
			sleepRecord.setDeepSleepSecond(deepSleepSecond);
			sleepRecord.setSleepSecond(sleepSecond);
			sleepRecord.setShallowSleepSecond(shallowSleepSecond);
			return sleepDao.sleepUpdate(sleepRecord);
		}
		// 记录步存在，插入新记录
		UserSleepRecord sleep = new UserSleepRecord();
		sleep.setUid(uid);
		sleep.setDeepSleepSecond(deepSleepSecond);
		sleep.setSleepSecond(sleepSecond);
		sleep.setShallowSleepSecond(shallowSleepSecond);
		sleep.setRecordDate(new Date());
		return sleepDao.sleepInsert(sleep);
	}

	public List<UserSleepRecord> sleepRecords(Long uid) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return sleepDao.sleepRecordQuery(uid, format.format(new Date()));
	}

	public List<UserSleepRecord> sleepRecordsByDate(Long uid, String date) {
		return sleepDao.sleepRecordQuery(uid, date);
	}

	public List<UserSleepRecordBO> weekSleepRecord(Long uid) {
		return sleepDao.weekSleepRecord(uid);
	}

	public List<UserStepRecord> equipStepQueryByRange(Long uid, String startDateStr, String endDateStr) {

		List<UserStepRecord> stepList = stepDao.queryStepByRange(uid, startDateStr, endDateStr);
		List<UserStepRecord> newList = new ArrayList<UserStepRecord>();
		// 没有记录的天数补充为0
		Date startDate = null, endDate = null;
		try {
			startDate = DateUtils.parseDateStrictly(startDateStr, "yyyy-MM-dd");
			endDate = DateUtils.parseDateStrictly(endDateStr, "yyyy-MM-dd");
			long days = DateUtils.getDateMargin(startDate, endDate);

			for (int i = 0; i <= days; i++) {// 找出空的日期
				UserStepRecord newStepRecord = new UserStepRecord();
				newStepRecord.setCalories(0L);
				newStepRecord.setStepNumber(0);
				newStepRecord.setTotalKm(0d);

				Date everyDate = DateUtils.getNextDay(i, startDate);
				newStepRecord.setRecordDate(everyDate);
				newList.add(newStepRecord);
			}

			for (UserStepRecord newRecordBO : newList) {
				String newRecordStr = DateUtils.formatDate(newRecordBO.getRecordDate(), "yyyy-MM-dd");
				for (UserStepRecord recordBO : stepList) {
					String recordDateStr = DateUtils.formatDate(recordBO.getRecordDate(), "yyyy-MM-dd");
					if (recordBO != null && recordDateStr != null && recordDateStr.equals(newRecordStr)) {
						newRecordBO.setCalories(recordBO.getCalories());
						newRecordBO.setStepNumber(recordBO.getStepNumber());
						newRecordBO.setTotalKm(recordBO.getTotalKm());
						newRecordBO.setRecordDate(recordBO.getRecordDate());

					}
				}
			}

			return newList;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newList;

	}

	public List<UserSleepRecordBO> equipSleepQueryByRange(Long uid, String startDateStr, String endDateStr) {
		// TODO Auto-generated method stub
		return sleepDao.equipSleepQueryByRange(uid, startDateStr, endDateStr);
	}

	/**
	 * 将月份记录查询出来根据周分组统计
	 * 
	 * @param uid
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<UserStepRecordBO> equipDayQueryWeekByMon(Long uid, String startDate, String endDate,
			Integer parmType) {
		List<UserStepRecord> recordList = stepDao.queryStepByRange(uid, startDate, endDate);
		// 对list进周分组统计

		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);// 星期一作为周的第一天
		Double firsKmtNum = 0d, secondKmtNum = 0d, thirthKmtNum = 0d, forthKmtNum = 0d, fifthKmtNum = 0d, sixthKmtNum = 0d;
		Integer firstStepNum = 0, secondStepNum = 0, thirthStepNum = 0, forthStepNum = 0, fifthStepNum = 0, sixthStepNum = 0;
		Double firstCalNum = 0D, secondCalNum = 0D, thirthCalNum = 0D, forthCalNum = 0D, fifthCalNum = 0D, sixthCalNum = 0D;
		for (UserStepRecord record : recordList) {

			calendar.setTime(record.getRecordDate());
			int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
			switch (parmType) {
			// 步数
				case 1:
					switch (weekOfMonth) {
						case 1:
							firstStepNum += record.getStepNumber();
							break;
						case 2:
							secondStepNum += record.getStepNumber();
							break;
						case 3:
							thirthStepNum += record.getStepNumber();
							break;
						case 4:
							forthStepNum += record.getStepNumber();
							break;
						case 5:
							fifthStepNum += record.getStepNumber();
							break;
						case 6:
							sixthStepNum += record.getStepNumber();
							break;
					}
					break;
				// 卡路里
				case 2:
					switch (weekOfMonth) {
						case 1:
							firstCalNum += record.getCalories();
							break;
						case 2:
							secondCalNum += record.getCalories();
							break;
						case 3:
							thirthCalNum += record.getCalories();
							break;
						case 4:
							forthCalNum += record.getCalories();
							break;
						case 5:
							fifthCalNum += record.getCalories();
							break;
						case 6:
							sixthCalNum += record.getCalories();
							break;
					}
					break;
				// 里程
				case 3:
					switch (weekOfMonth) {
						case 1:
							firsKmtNum += record.getTotalKm();
							break;
						case 2:
							secondKmtNum += record.getTotalKm();
							break;
						case 3:
							thirthKmtNum += record.getTotalKm();
							break;
						case 4:
							forthKmtNum += record.getTotalKm();
							break;
						case 5:
							fifthKmtNum += record.getTotalKm();
							break;
						case 6:
							sixthKmtNum += record.getTotalKm();
							break;
					}
			}
		}
		List<UserStepRecordBO> boList = new ArrayList<UserStepRecordBO>();

		for (int j = 1; j <= 6; j++) {
			UserStepRecordBO bo = new UserStepRecordBO();
			if (parmType != null && parmType == 1) {
				switch (j) {
					case 1:
						bo.setStepNumSumOfWeek(firstStepNum);
						break;
					case 2:
						bo.setStepNumSumOfWeek(secondStepNum);
						break;
					case 3:
						bo.setStepNumSumOfWeek(thirthStepNum);
						break;
					case 4:
						bo.setStepNumSumOfWeek(forthStepNum);
						break;
					case 5:
						bo.setStepNumSumOfWeek(fifthStepNum);
						break;
					case 6:
						bo.setStepNumSumOfWeek(sixthStepNum);
						break;
				}
			} else if (parmType != null && parmType == 2) {
				switch (j) {
					case 1:
						bo.setCaloriesSumOfWeek(firstCalNum);
						break;
					case 2:
						bo.setCaloriesSumOfWeek(secondCalNum);
						break;
					case 3:
						bo.setCaloriesSumOfWeek(thirthCalNum);
						break;
					case 4:
						bo.setCaloriesSumOfWeek(forthCalNum);
						break;
					case 5:
						bo.setCaloriesSumOfWeek(fifthCalNum);
						break;
					case 6:
						bo.setCaloriesSumOfWeek(sixthCalNum);
						break;
				}
			} else if (parmType != null && parmType == 3) {
				switch (j) {
					case 1:
						bo.setTotalKmSumOfWeek(firsKmtNum);
						break;
					case 2:
						bo.setTotalKmSumOfWeek(secondKmtNum);
						break;
					case 3:
						bo.setTotalKmSumOfWeek(thirthKmtNum);
						break;
					case 4:
						bo.setTotalKmSumOfWeek(forthKmtNum);
						break;
					case 5:
						bo.setTotalKmSumOfWeek(fifthKmtNum);
						break;
					case 6:
						bo.setTotalKmSumOfWeek(sixthKmtNum);
						break;
				}
			}
			boList.add(bo);
		}
		return boList;
	}

	/**
	 * 统计每月中的每周的睡眠统计记录数据
	 * 
	 * @param uid
	 * @param startDate
	 * @param endDate
	 * @param parmType
	 * @return
	 */
	public List<UserSleepRecordBO> equipSleepQueryWeekByMon(Long uid, String startDate, String endDate,
			Integer parmType) {
		List<UserSleepRecordBO> recordList = sleepDao.equipSleepQueryByRange(uid, startDate, endDate);
		// 对list进周分组统计

		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);// 星期一作为周的第一天
		Integer firstSleepSecNum = 0, secondSleepSecNum = 0, thirthSleepSecNum = 0, forthSleepSecNum = 0, fifthSleepSecNum = 0, sixthSleepSecNum = 0;
		Integer firstDeepSleepNum = 0, secondDeepSleepNum = 0, thirthDeepSleepNum = 0, forthDeepSleepNum = 0, fifthDeepSleepNum = 0, sixthDeepSleepNum = 0;
		Integer firstShallDeepNum = 0, secondShallDeepNum = 0, thirthShallDeepNum = 0, forthShallDeepNum = 0, fifthShallDeepNum = 0, sixthShallDeepNum = 0;
		for (UserSleepRecordBO record : recordList) {

			calendar.setTime(record.getRecordDate());
			int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
			// 4:睡眠时长,5:深睡时长,6:浅睡时长
			switch (parmType) {
			// 睡眠时长
				case 4:
					switch (weekOfMonth) {
						case 1:
							firstSleepSecNum += record.getSleepSecond();
							break;
						case 2:
							secondSleepSecNum += record.getSleepSecond();
							break;
						case 3:
							thirthSleepSecNum += record.getSleepSecond();
							break;
						case 4:
							forthSleepSecNum += record.getSleepSecond();
							break;
						case 5:
							fifthSleepSecNum += record.getSleepSecond();
							break;
						case 6:
							sixthSleepSecNum += record.getSleepSecond();
							break;
					}
					break;
				// 深睡时长
				case 5:
					switch (weekOfMonth) {
						case 1:
							firstDeepSleepNum += record.getDeepSleepSecond();
							break;
						case 2:
							secondDeepSleepNum += record.getDeepSleepSecond();
							break;
						case 3:
							thirthDeepSleepNum += record.getDeepSleepSecond();
							break;
						case 4:
							forthDeepSleepNum += record.getDeepSleepSecond();
							break;
						case 5:
							fifthDeepSleepNum += record.getDeepSleepSecond();
							break;
						case 6:
							sixthDeepSleepNum += record.getDeepSleepSecond();
							break;
					}
					break;
				// 里程
				case 6:
					switch (weekOfMonth) {
						case 1:
							firstShallDeepNum += record.getShallowSleepSecond();
							break;
						case 2:
							secondShallDeepNum += record.getShallowSleepSecond();
							break;
						case 3:
							thirthShallDeepNum += record.getShallowSleepSecond();
							break;
						case 4:
							forthShallDeepNum += record.getShallowSleepSecond();
							break;
						case 5:
							fifthShallDeepNum += record.getShallowSleepSecond();
							break;
						case 6:
							sixthShallDeepNum += record.getShallowSleepSecond();
							break;
					}
			}
		}
		List<UserSleepRecordBO> boList = new ArrayList<UserSleepRecordBO>();

		for (int j = 1; j <= 6; j++) {
			UserSleepRecordBO bo = new UserSleepRecordBO();
			if (parmType != null && parmType == 4) {// 参数值类型
				switch (j) {// 第几周
					case 1:
						bo.setSleepSecondSumOfWeek(firstSleepSecNum);
						break;
					case 2:
						bo.setSleepSecondSumOfWeek(secondSleepSecNum);
						break;
					case 3:
						bo.setSleepSecondSumOfWeek(thirthSleepSecNum);
						break;
					case 4:
						bo.setSleepSecondSumOfWeek(forthSleepSecNum);
						break;
					case 5:
						bo.setSleepSecondSumOfWeek(fifthSleepSecNum);
						break;
					case 6:
						bo.setSleepSecondSumOfWeek(sixthSleepSecNum);
						break;
				}
			} else if (parmType != null && parmType == 5) {
				switch (j) {
					case 1:
						bo.setDeepSleepSecondSumOfWeek(firstDeepSleepNum);
						break;
					case 2:
						bo.setDeepSleepSecondSumOfWeek(secondDeepSleepNum);
						break;
					case 3:
						bo.setDeepSleepSecondSumOfWeek(thirthDeepSleepNum);
						break;
					case 4:
						bo.setDeepSleepSecondSumOfWeek(forthDeepSleepNum);
						break;
					case 5:
						bo.setDeepSleepSecondSumOfWeek(fifthDeepSleepNum);
						break;
					case 6:
						bo.setDeepSleepSecondSumOfWeek(sixthDeepSleepNum);
						break;
				}
			} else if (parmType != null && parmType == 6) {
				switch (j) {
					case 1:
						bo.setShallowSleepSecondSumOfWeek(firstShallDeepNum);
						break;
					case 2:
						bo.setShallowSleepSecondSumOfWeek(secondShallDeepNum);
						break;
					case 3:
						bo.setShallowSleepSecondSumOfWeek(thirthShallDeepNum);
						break;
					case 4:
						bo.setShallowSleepSecondSumOfWeek(forthShallDeepNum);
						break;
					case 5:
						bo.setShallowSleepSecondSumOfWeek(fifthShallDeepNum);
						break;
					case 6:
						bo.setShallowSleepSecondSumOfWeek(sixthShallDeepNum);
						break;
				}
			}
			boList.add(bo);
		}
		return boList;
	}

	/**
	 * 查询一年中的个月的统计记录值
	 * 
	 * @param uid
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<UserStepRecordBO> equipStepQueryMonByYear(Long uid, String startDate, String endDate) {
		//

		List<UserStepRecordBO> monthList = stepDao.equipStepQueryMonByYear(uid, startDate, endDate);
		List<UserStepRecordBO> newList = new ArrayList<UserStepRecordBO>();
		for (int i = 1; i <= 12; i++) {// 创建十二个月的空记录
			UserStepRecordBO stepRecordBO = new UserStepRecordBO();
			stepRecordBO.setStepTotalMonth(0);
			stepRecordBO.setKmTotalMonth(0f);
			stepRecordBO.setCalTotalMonth(0d);
			stepRecordBO.setMonth(i);
			newList.add(stepRecordBO);
		}

		for (UserStepRecordBO newBO : newList) {// 将有统计的月记录替换到空的list
			int monthNum = newBO.getMonth();
			if (monthList != null && monthList.size() > 0) {
				for (UserStepRecordBO monBO : monthList) {
					if (monBO.getMonth() == monthNum) {
						newBO.setCalTotalMonth(monBO.getCalTotalMonth());
						newBO.setKmTotalMonth(monBO.getKmTotalMonth());
						newBO.setCalTotalMonth(monBO.getCalTotalMonth());
					}
				}
			}
		}

		return newList;
	}

	@Transactional(readOnly = false)
	public void equipMentAddStepsList(Long uid, List<UserStepRecord> stepRecordList) {
		if (stepRecordList != null && stepRecordList.size() > 0) {
			for (UserStepRecord record : stepRecordList) {
				stepDao.addUserStepRecord(record);
			}
		}

	}
}
