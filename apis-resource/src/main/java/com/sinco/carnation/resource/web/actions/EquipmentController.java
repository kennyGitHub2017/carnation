package com.sinco.carnation.resource.web.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.util.WearingUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.bo.SleepRecordBO;
import com.sinco.carnation.resource.bo.StepRecordBO;
import com.sinco.carnation.resource.bo.WeekOfMonthRecordBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.equipment.EquipMentQueryVO;
import com.sinco.carnation.resource.vo.equipment.EquipMentVO;
import com.sinco.carnation.resource.vo.favorites.SleepRecoredVO;
import com.sinco.carnation.resource.web.response.equipment.DayEquipMentResponse;
import com.sinco.carnation.resource.web.response.equipment.EquipMentRangeResponse;
import com.sinco.carnation.resource.web.response.equipment.EquipMentResponse;
import com.sinco.carnation.resource.web.response.favorites.SleepRecordResponse;
import com.sinco.carnation.user.bo.UserSleepRecordBO;
import com.sinco.carnation.user.bo.UserStepRecordBO;
import com.sinco.carnation.user.model.UserSleepRecord;
import com.sinco.carnation.user.model.UserStepRecord;
import com.sinco.carnation.user.service.EquipMentService;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "我的设备", namespace = "equipment")
public class EquipmentController extends BasicApiController {

	@Autowired
	private EquipMentService equipService;

	@Autowired
	private Mapper mapper;

	@RequestMapping(value = "/equip/add", method = RequestMethod.POST)
	@MethodMapping(desc = "保存跑步数据")
	public @ResponseBody
	EquipMentResponse equipmentAdd(@Valid @ModelAttribute @Param EquipMentVO vo, BindingResult result,
			HttpServletRequest request) {

		EquipMentResponse response = new EquipMentResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		// 总里程
		double dist = WearingUtils.stepLength(vo.getHeigth()) * vo.getStepNumber() / 100000d;
		Long calories = (long) (0.6 * vo.getWeight() * dist);
		if (equipService.equipMentAdd(uid, vo.getStepNumber(), calories, dist) < 0) {
			return response;
		}
		return response;
	}

	/**
	 * 保存多條跑步数据记录
	 * 
	 * @param stepJsonList
	 *            :step跑步记录的json对象的字符串
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/equip/addStepsList", method = RequestMethod.POST)
	@MethodMapping(desc = "保存跑步数据")
	public @ResponseBody
	EquipMentResponse equipStepAddList(
			@Valid @RequestParam(value = "jsonStr") @Param(desc = "json格式字符串：手环记录数据") String jsonStr) {

		EquipMentResponse response = new EquipMentResponse();
		if (jsonStr == null || jsonStr.isEmpty()) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		// 总里程
		List<EquipMentVO> recordList = JSON.parseArray(jsonStr, EquipMentVO.class);
		// 计算卡路里和里程
		List<UserStepRecord> stepRecordList = new ArrayList<UserStepRecord>();
		for (EquipMentVO vo : recordList) {
			double dist = WearingUtils.stepLength(vo.getHeigth()) * vo.getStepNumber() / 100000d;
			Long calories = (long) (0.6 * vo.getWeight() * dist);

			UserStepRecord record = new UserStepRecord();
			record.setCalories(calories);
			record.setRecordDate(new Date());
			record.setUid(uid);
			record.setTotalKm(dist);
			record.setStepNumber(vo.getStepNumber());

			stepRecordList.add(record);

		}

		try {
			equipService.equipMentAddStepsList(uid, stepRecordList);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSubMsg("保存数据出现异常");
		}

		return response;
	}

	@RequestMapping(value = "/equip/day/query", method = RequestMethod.POST)
	@MethodMapping(desc = "当天数据")
	public @ResponseBody
	DayEquipMentResponse equipDayQuery() {
		DayEquipMentResponse response = new DayEquipMentResponse();
		Long uid = ActionsUtil.getOwnerUid();
		UserStepRecord record = equipService.equipDayQuery(uid);
		if (null != record) {
			response.setCalories(record.getCalories());
			response.setDistance(record.getTotalKm());
			response.setStepNumber(record.getStepNumber());
		}
		return response;
	}

	@RequestMapping(value = "/equip/day/queryByDate", method = RequestMethod.POST)
	@MethodMapping(desc = "跑步|根据日期查询")
	public @ResponseBody
	DayEquipMentResponse equipDayQueryByDate(
			@Valid @RequestParam(value = "dayDateStr") @Param(desc = "日期|如：2016-01-08字符串格式年月日") String dayDateStr,
			BindingResult result) {
		DayEquipMentResponse response = new DayEquipMentResponse();

		if (dayDateStr == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();

		/*	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String formatedDate = format.format(vo.getDate());*/

		UserStepRecord record = equipService.equipDayQueryByDate(uid, dayDateStr);

		if (null != record) {
			response.setCalories(record.getCalories());
			response.setDistance(record.getTotalKm());
			response.setStepNumber(record.getStepNumber());
		}
		return response;
	}

	@RequestMapping(value = "/equip/queryByRange", method = RequestMethod.POST)
	@MethodMapping(desc = "跑步|根据日期范围查询")
	public @ResponseBody
	EquipMentRangeResponse equipQueryByRange(@Valid @ModelAttribute @Param EquipMentQueryVO vo,
			BindingResult result) {
		EquipMentRangeResponse response = new EquipMentRangeResponse();

		if (vo != null && !StringUtils.isNotBlank(vo.getStartDateStr())
				&& !StringUtils.isNotBlank(vo.getEndDateStr())) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		// uid = new Long(328);//test

		String startDate = vo.getStartDateStr(), endDate = vo.getEndDateStr();

		List<UserStepRecord> recordList = equipService.equipStepQueryByRange(uid, startDate, endDate);

		if (recordList != null && !recordList.isEmpty()) {
			List<StepRecordBO> list = MapperUtils.map(mapper, recordList, StepRecordBO.class);
			response.setRangeSteps(list);

			// 计算日期范围之内的总记录值
			Integer totalStepNumber = 0;
			Long totalCalories = 0L;
			Float totalDistance = 0f;
			for (StepRecordBO bo : list) {
				totalStepNumber += bo.getStepNumber();
				totalCalories += bo.getCalories();
				totalDistance += bo.getTotalKm();
			}
			response.setTotalStepNumber(totalStepNumber);
			response.setTotalCalories(totalCalories);
			response.setTotalDistance(totalDistance);
		}
		return response;
	}

	/**
	 * 查询当前月份的1-6周的跑步（步数，卡路里，里程统计信息）
	 * 
	 * @return
	 */
	@RequestMapping(value = "/equip/queryWeekByMon", method = RequestMethod.POST)
	@MethodMapping(desc = "查询当前月份的1-6周的跑步(步数，卡路里，里程统计信息)")
	public @ResponseBody
	DayEquipMentResponse equipDayQueryWeekByMon(@Valid @ModelAttribute @Param EquipMentQueryVO vo,
			BindingResult result) {
		DayEquipMentResponse response = new DayEquipMentResponse();

		if (vo != null && !StringUtils.isNotBlank(vo.getStartDateStr())
				&& !StringUtils.isNotBlank(vo.getEndDateStr())) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		// uid = new Long(328);//test

		String startDate = vo.getStartDateStr(), endDate = vo.getEndDateStr();

		List<UserStepRecordBO> recordList = equipService.equipDayQueryWeekByMon(uid, startDate, endDate,
				vo.getParmType());
		if (recordList != null && !recordList.isEmpty()) {
			List<WeekOfMonthRecordBO> list = MapperUtils.map(mapper, recordList, WeekOfMonthRecordBO.class);
			response.setWeekOfMonDataList(list);

		}
		return response;

	}

	/**
	 * 查询一年中个月月份的统计记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/equip/queryMonByYear", method = RequestMethod.POST)
	@MethodMapping(desc = " 查询一年中个月月份的统计记录")
	public @ResponseBody
	DayEquipMentResponse equipStepQueryMonByYear(@Valid @ModelAttribute @Param EquipMentQueryVO vo,
			BindingResult result) {
		DayEquipMentResponse response = new DayEquipMentResponse();

		if (vo != null && !StringUtils.isNotBlank(vo.getStartDateStr())
				&& !StringUtils.isNotBlank(vo.getEndDateStr())) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		// uid = new Long(328);//test

		String startDate = vo.getStartDateStr(), endDate = vo.getEndDateStr();

		List<UserStepRecordBO> recordList = equipService.equipStepQueryMonByYear(uid, startDate, endDate);
		if (recordList != null && !recordList.isEmpty()) {
			List<StepRecordBO> list = MapperUtils.map(mapper, recordList, StepRecordBO.class);
			response.setMonthRecordList(list);

		}
		return response;

	}

	@RequestMapping(value = "/equip/week/query", method = RequestMethod.POST)
	@MethodMapping(desc = "一周跑步数据")
	public @ResponseBody
	DayEquipMentResponse equipWeekQuery() {
		DayEquipMentResponse response = new DayEquipMentResponse();
		Long uid = ActionsUtil.getOwnerUid();
		List<UserStepRecordBO> record = equipService.weekStepRecord(uid);
		if (null != record && record.size() > 0) {
			List<StepRecordBO> list = MapperUtils.map(mapper, record, StepRecordBO.class);
			response.setWeekStep(list);
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/equip/sleep/add", method = RequestMethod.POST)
	@MethodMapping(desc = "保存睡眠数据")
	public @ResponseBody
	SleepRecordResponse sleepRecordAdd(@Valid @ModelAttribute @Param SleepRecoredVO vo, BindingResult result,
			HttpServletRequest request) {

		SleepRecordResponse response = new SleepRecordResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (equipService.sleepRescordAdd(uid, vo.getSleepSecond(), vo.getDeepSleepSecond(),
				vo.getShallowSleepSecond()) < 1) {
			return response;
		}
		return response;
	}

	@SuppressWarnings("null")
	@RequestMapping(value = "/equip/sleep/query", method = RequestMethod.POST)
	@MethodMapping(desc = "查询当天睡眠信息")
	public @ResponseBody
	SleepRecordResponse sleepRecordDayQuery() {

		SleepRecordResponse response = new SleepRecordResponse();
		Long uid = ActionsUtil.getOwnerUid();
		List<UserSleepRecord> list = equipService.sleepRecords(uid);
		if (null == list && list.size() <= 0) {
			return response;
		}
		List<SleepRecordBO> sleepRecordBOs = MapperUtils.map(mapper, list, SleepRecordBO.class);
		if (null != sleepRecordBOs && sleepRecordBOs.size() > 0) {
			response.setSleepRecordBO(sleepRecordBOs.get(0));
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/equip/sleep/queryByDate", method = RequestMethod.POST)
	@MethodMapping(desc = "查询某天睡眠信息")
	public @ResponseBody
	SleepRecordResponse sleepRecordDayQuery(
			@Valid @RequestParam(value = "dayDateStr") @Param(desc = "日期|如：2016-01-08字符串格式年月日") String dayDateStr,
			BindingResult result) {

		SleepRecordResponse response = new SleepRecordResponse();
		if (dayDateStr == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String formatedDate = format.format(vo.getDate());*/
		List<UserSleepRecord> list = equipService.sleepRecordsByDate(uid, dayDateStr);
		if (null != list && list.isEmpty()) {
			return response;
		}
		List<SleepRecordBO> sleepRecordBOs = MapperUtils.map(mapper, list, SleepRecordBO.class);
		if (null != sleepRecordBOs && sleepRecordBOs.size() > 0) {
			response.setSleepRecordBO(sleepRecordBOs.get(0));
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/equip/sleep/week", method = RequestMethod.POST)
	@MethodMapping(desc = "一周睡眠数据")
	public @ResponseBody
	SleepRecordResponse weekSleepRecord() {
		SleepRecordResponse response = new SleepRecordResponse();
		Long uid = ActionsUtil.getOwnerUid();
		List<UserSleepRecordBO> list = equipService.weekSleepRecord(uid);
		if (null != list && list.size() > 0) {
			List<SleepRecordBO> sleepRecordBOs = MapperUtils.map(mapper, list, SleepRecordBO.class);
			response.setSleeps(sleepRecordBOs);
			return response;
		}

		return response;
	}

	@RequestMapping(value = "/equip/sleep/queryByRange", method = RequestMethod.POST)
	@MethodMapping(desc = "睡眠|根据日期范围查询")
	public @ResponseBody
	SleepRecordResponse equipSleepQueryByRange(@Valid @ModelAttribute @Param EquipMentQueryVO vo,
			BindingResult result) {
		SleepRecordResponse response = new SleepRecordResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		// uid = new Long(308);//test

		List<UserSleepRecordBO> list = equipService.equipSleepQueryByRange(uid, vo.getStartDateStr(),
				vo.getEndDateStr());

		if (null != list && list.size() > 0) {
			List<SleepRecordBO> sleepRecordBOs = MapperUtils.map(mapper, list, SleepRecordBO.class);
			response.setSleeps(sleepRecordBOs);
			return response;
		}
		return response;
	}

	/**
	 * 查询当前月份的1-6周的睡眠里程统计信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/equip/sleep/queryWeekByMon", method = RequestMethod.POST)
	@MethodMapping(desc = "查询当前月份的1-6周的睡眠里程统计信息")
	public @ResponseBody
	DayEquipMentResponse equipSleepQueryWeekByMon(@Valid @ModelAttribute @Param EquipMentQueryVO vo,
			BindingResult result) {
		DayEquipMentResponse response = new DayEquipMentResponse();

		if (vo != null && !StringUtils.isNotBlank(vo.getStartDateStr())
				&& !StringUtils.isNotBlank(vo.getEndDateStr()) && vo.getParmType() != null) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		// uid = new Long(308);//test

		String startDate = vo.getStartDateStr(), endDate = vo.getEndDateStr();

		List<UserSleepRecordBO> recordList = equipService.equipSleepQueryWeekByMon(uid, startDate, endDate,
				vo.getParmType());
		if (recordList != null && !recordList.isEmpty()) {
			List<WeekOfMonthRecordBO> list = MapperUtils.map(mapper, recordList, WeekOfMonthRecordBO.class);
			response.setWeekOfMonDataList(list);

		}
		return response;

	}

	public static void main(String[] args) {
		System.out.println(5900 / 100000d);
	}
}
