package com.sinco.carnation.resource.web.actions.healthTask;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.bo.healthTask.HealthTaskBO;
import com.sinco.carnation.resource.bo.healthTask.UserHealthTaskInfoBO;
import com.sinco.carnation.resource.vo.healthTask.HealthTaskVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.healthTask.HealthTaskResponse;
import com.sinco.carnation.resource.web.response.healthTask.ResultResponse;
import com.sinco.carnation.resource.web.response.healthTask.UserHealthTaskInfoResponse;
import com.sinco.carnation.resource.web.response.healthTask.UserHealthTaskRelationResponse;
import com.sinco.carnation.sns.bo.UserHealthtaskBO;
import com.sinco.carnation.sns.bo.UserHealthtaskRelationBO;
import com.sinco.carnation.sns.bo.UserHealthtaskSetBO;
import com.sinco.carnation.sns.bo.UserHealthtaskSignlogBO;
import com.sinco.carnation.sns.vo.UserHealthtaskVO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.user.service.UserHealthTaskService;
import com.sinco.carnation.user.service.UserHealthtaskRelationService;
import com.sinco.dal.common.MyPage;

/**
 * 个人中心/健康任务
 * 
 * @author yuleijia
 */
@Controller
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "用户健康任务", namespace = "ht")
public class UserHealthTaskController extends BasicApiController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Mapper mapper;

	@Autowired
	private UserHealthtaskRelationService userHealthtaskRelationService;

	@Autowired
	private UserHealthTaskService userHealthTaskService;

	@Autowired
	private IntegralService integralService;

	/*@Value(value = "${api.path}")
	private String apiPath;
	
	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}*/

	/**
	 * 用户健康任务
	 * 
	 * @param request
	 *            * @return
	 */
	@RequestMapping(value = "/ht/userHTList", method = RequestMethod.GET)
	@MethodMapping(desc = "用户健康任务接口")
	public @ResponseBody
	UserHealthTaskInfoResponse ht_User_List(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			BindingResult result, HttpServletRequest request) {
		log.info("============= 用户健康任务接口 =================");

		UserHealthTaskInfoResponse response = new UserHealthTaskInfoResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();

		MyPage<UserHealthtaskRelationBO> page = new MyPage<UserHealthtaskRelationBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		this.userHealthtaskRelationService.selectPageByUserID(page, uid);

		List<UserHealthtaskRelationBO> source_List = page.getContent();

		List<UserHealthTaskInfoBO> healthTaskInfo_res_bo_list = MapperUtils.map(mapper, source_List,
				UserHealthTaskInfoBO.class);

		response.setUserHealthTaskInfoList(healthTaskInfo_res_bo_list);

		return response;
	}

	/**
	 * 健康任务 注：用户已参与的活动不在获取健康任务
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ht/htList", method = RequestMethod.GET)
	@MethodMapping(desc = "健康任务接口")
	public @ResponseBody
	HealthTaskResponse ht_List(@Valid @ModelAttribute @Param BasicPageParamVo vo, BindingResult result,
			HttpServletRequest request) {
		log.info("=============== 健康任务列表接口 =================");

		HealthTaskResponse res = new HealthTaskResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), res);
			return res;
		}

		Long userId = ActionsUtil.getOwnerUid();

		MyPage<UserHealthtaskBO> page = new MyPage<UserHealthtaskBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		this.userHealthTaskService.getHealthTaskListSer(page, userId);

		List<UserHealthtaskBO> source_list = page.getContent();

		List<HealthTaskBO> res_list = MapperUtils.map(mapper, source_list, HealthTaskBO.class);
		res.setHealthTaskBOList(res_list);

		return res;
	}

	/**
	 * 健康任务搜索 注：用户已参与的活动不在搜索范围内
	 * 
	 * @param request
	 * @param taskName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ht/search", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@MethodMapping(desc = "健康任务搜索")
	public @ResponseBody
	HealthTaskResponse search_healthTask(HttpServletRequest request,
			@RequestParam(value = "taskName") @Param(desc = "任务名") String taskName) throws Exception {
		log.info(" ================ 健康任务搜索  ============= ");
		HealthTaskResponse response = new HealthTaskResponse();
		Long userId = ActionsUtil.getOwnerUid();
		userId = new Long("15138");
		if (taskName != null && taskName.trim().length() > 0) {
			taskName = java.net.URLDecoder.decode(taskName, "UTF-8");
			List<UserHealthtaskBO> source_list = this.userHealthTaskService.getHealthTaskByLike(taskName,
					userId);
			List<HealthTaskBO> res_list = MapperUtils.map(mapper, source_list, HealthTaskBO.class);
			response.setHealthTaskBOList(res_list);
		} else {
			response.setHealthTaskBOList(new ArrayList<HealthTaskBO>());
		}
		return response;
	}

	/**
	 * 健康任务/参与/创建
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ht/setUpHT", method = RequestMethod.GET)
	@MethodMapping(desc = "健康任务/参与/创建")
	public @ResponseBody
	ResultResponse setUp_HealthTask(@Valid @ModelAttribute @Param HealthTaskVO vo, BindingResult result,
			HttpServletRequest request) {
		ResultResponse response = new ResultResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();
		if (userId == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}

		UserHealthtaskVO vo_ = mapper.map(vo, UserHealthtaskVO.class);

		int result_ = this.userHealthTaskService.save_userHealthTaskSer(userId, vo_);
		String res_result = String.valueOf(result_);
		String res_content = null;
		switch (result_) {
			case UserHealthTaskService.oper_Succ:
				res_content = "success";
				break;
			case UserHealthTaskService.oper_Failed:
				res_content = "操作失败";
				break;
			case UserHealthTaskService.task_is_no:
				res_content = "参与任务不存在";
				break;
		}
		response.setResult(res_result);
		response.setContent(res_content);
		return response;
	}

	/**
	 * 今日任务
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ht/todayTask", method = RequestMethod.GET)
	public @ResponseBody
	HealthTaskResponse get_today_task(HttpServletRequest request) {
		log.info(" ================ 今日任务  ============= ");
		HealthTaskResponse response = new HealthTaskResponse();
		Date date = new Date();
		Long uid = ActionsUtil.getOwnerUid();
		List<UserHealthtaskBO> resultList = this.userHealthTaskService.getTodayHealthTaskSer(date, uid);
		if (resultList != null) {
			List<HealthTaskBO> res_list = MapperUtils.map(mapper, resultList, HealthTaskBO.class);
			response.setHealthTaskBOList(res_list);
		} else {
			response.setHealthTaskBOList(new ArrayList<HealthTaskBO>());
		}
		return response;
	}

	/**
	 * 健康任务签到——任务信息
	 * 
	 * @param request
	 * @param taskID
	 * @return
	 */
	@RequestMapping(value = "/ht/userTaskInfo", method = RequestMethod.GET)
	public @ResponseBody
	UserHealthTaskRelationResponse get_Task_Sign(HttpServletRequest request,
			@RequestParam(value = "taskID") @Param(desc = "任务ID") String taskID) {
		UserHealthTaskRelationResponse response = new UserHealthTaskRelationResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (taskID != null) {
			UserHealthtaskRelationBO result = this.userHealthtaskRelationService.getTaskSingInfo(uid,
					Long.parseLong(taskID));
			if (result != null) {
				response = mapper.map(result, UserHealthTaskRelationResponse.class);
			}
		}
		return response;
	}

	/**
	 * 删除健康任务
	 * 
	 * @param request
	 * @param id
	 *            健康任务
	 * @return
	 */
	/*@RequestMapping(value="/ht/delete",method = RequestMethod.POST)
	public ModelAndView deleteTask(HttpServletRequest request,
			@RequestParam(value = "taskID") @Param(desc = "任务ID") String id)
	{
		ModelAndView mv = new ModelAndView("");
		String webPath = CommUtil.getURL(request);
		this.userHealthTaskService.deleteByIDService(Long.parseLong(id));
		mv.addObject("apiPath", webPath);
		return mv;
	}*/
	/**
	 * 任务设置界面/H5
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ht/taskSet", method = RequestMethod.GET)
	public ModelAndView taskSetting(HttpServletRequest request,
			@Valid @RequestParam(value = "id") @Param(desc = "任务ID") String id,
			@Valid @RequestParam(value = "userID") @Param(desc = "用户ID") String userID) {
		log.info("=============== 健康任务设置 ===============");
		ModelAndView mv = new ModelAndView("healthTask/taskSetting.html");
		Long uid = null;

		String jumpType = request.getParameter("jumpType");
		if (jumpType == null || jumpType.length() == 0) {
			jumpType = "";
		}
		if (userID != null && userID.trim().length() > 0) {
			uid = new Long(userID);
		}
		// String webPath = CommUtil.getURL(request);
		UserHealthtaskBO bo = this.userHealthTaskService.findOne(Long.parseLong(id));

		Long taskID = Long.parseLong(id);

		UserHealthtaskSetBO healthTask = this.userHealthTaskService.query_HealthTaskSetByUIdAndTaskID(uid,
				taskID);

		boolean is_open = this.userHealthTaskService.query_HealthTaskRelation_isOpen(uid, taskID);

		mv.addObject("obj", bo);
		mv.addObject("healthTask", healthTask);
		mv.addObject("is_open", is_open);
		// mv.addObject("apiPath", webPath);
		mv.addObject("uid", uid);
		mv.addObject("jumpType", jumpType);
		return mv;
	}

	/**
	 * 健康任务 注：获取用户参加健康任务_列表/H5
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ht/index", method = RequestMethod.GET)
	public ModelAndView healthTaskIndex(HttpServletRequest request, @Param String pageNumber,
			@Param String pageSize, @Valid @RequestParam(value = "userID") @Param(desc = "用户ID") String userID) {

		log.info(" ================== 获取用户参加健康任务 ======================");
		ModelAndView mv = new ModelAndView("healthTask/task-index.html");
		long uid = 0;
		if (userID != null && userID.trim().length() > 0) {
			uid = new Long(userID);// ActionsUtil.getOwnerUid();
			MyPage<UserHealthtaskRelationBO> page = new MyPage<UserHealthtaskRelationBO>();
			page.setPageNumber(0);
			page.setPageSize(40);

			this.userHealthtaskRelationService.selectPageByUserID(page, uid);
			List<UserHealthtaskRelationBO> list = page.getContent();

			mv.addObject("list", list);
			mv.addObject("uid", uid);
		} else {
			mv.addObject("list", null);
		}
		/*String webPath = CommUtil.getURL(request);
		mv.addObject("apiPath", webPath);*/
		return mv;
	}

	/**
	 * 健康任务设置/H5
	 * 
	 * @param request
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/ht/doSet", method = RequestMethod.GET)
	public ModelAndView saveHealthTaskSet(HttpServletRequest request, @Param HealthTaskVO vo,
			@Valid @RequestParam(value = "userID") @Param(desc = "用户ID") String userID) {

		log.info("============== 健康任务设置/H5 ==============");

		ModelAndView mv = null;
		UserHealthtaskVO vo_ = mapper.map(vo, UserHealthtaskVO.class);

		long uid = 0;
		if (userID != null && userID.trim().length() > 0) {
			uid = Long.parseLong(userID);
		}
		int result_ = this.userHealthTaskService.save_userHealthTaskSer(uid, vo_);
		String jumpType = request.getParameter("jumpType");
		String redirectURL = "redirect:index?userID=" + uid; // 首页
		if (jumpType != null && jumpType.trim().equals("sys")) {
			redirectURL = "redirect:sysTaskList?userID=" + uid + "&pageSize=10&pageNumber=0";
		}
		if (jumpType != null && jumpType.trim().equals("task-index")) {
			redirectURL = "redirect:index?userID=" + uid; // 个人中心-健康任务
		}
		switch (result_) {
			case UserHealthTaskService.oper_Succ:
				log.info("......... succ");
				break;
			case UserHealthTaskService.oper_Failed:
				log.info("......... fail");
				break;
			case UserHealthTaskService.task_is_no:
				log.info("......... 当前任务不存在");
				break;
		}
		mv = new ModelAndView(redirectURL);

		return mv;
	}

	/**
	 * 新任务/H5 获取系统健康任务(用户未参加的任务)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ht/sysTaskList", method = RequestMethod.GET)
	public ModelAndView query_Sys_task(HttpServletRequest request, @Param String pageNumber,
			@Param String pageSize, @Valid @RequestParam(value = "userID") String userID) {
		log.info("================== 获取系统健康任务(用户未参加的任务) ==============");

		ModelAndView mv = new ModelAndView("healthTask/add.html");
		// sys:客户端健康管理-新任务按钮进入
		// task-index:用户健康任务列表+号进入
		String jumpType = request.getParameter("jumpType");
		if (jumpType == null || jumpType.trim().length() == 0) {
			jumpType = "sys"; // 默认
		}
		MyPage<UserHealthtaskBO> page = new MyPage<UserHealthtaskBO>();
		page.setPageNumber(0);
		page.setPageSize(40);
		if (userID != null && userID.trim().length() > 0) {
			long uid = Long.parseLong(userID);// ActionsUtil.getOwnerUid();
			this.userHealthTaskService.getSysHealthTaskList(page, uid);
			List<UserHealthtaskBO> list = page.getContent();
			mv.addObject("list", list);
			mv.addObject("uid", uid);
		}
		/*String webPath = CommUtil.getURL(request);
		mv.addObject("apiPath", webPath);*/
		mv.addObject("jumpType", jumpType);
		return mv;
	}

	/**
	 * 去完成功能 注：用户健康任务签到
	 * 
	 * @param request
	 * @param taskID
	 * @return
	 */
	@RequestMapping(value = "/ht/sign", method = RequestMethod.GET)
	public ModelAndView get_HealthTask_Sign(HttpServletRequest request,
			@RequestParam(value = "taskID") @Param(desc = "任务ID") String taskID,
			@RequestParam(value = "userID") @Param(desc = "会员ID") String userID)

	{
		log.info("================== 用户健康任务签到  ==============");

		ModelAndView mv = new ModelAndView("healthTask/sign.html");
		long uid = 0;
		if (userID != null && userID.trim().length() > 0) {
			uid = new Long(userID); // ActionsUtil.getOwnerUid();

		}

		UserHealthtaskRelationBO obj = this.userHealthtaskRelationService.getTaskSingInfo(uid,
				Long.parseLong(taskID));

		Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);

		String currDate = MessageFormat.format("{0}月{1}日", month, date);
		mv.addObject("currDate", currDate);
		mv.addObject("obj", obj);
		mv.addObject("uid", uid);
		return mv;
	}

	/**
	 * 用户健康任务签到
	 * 
	 * @param request
	 * @param taskID
	 * @param id
	 * @param uid
	 * @return
	 */
	@RequestMapping(value = "/ht/doSign", method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse do_HealthTask_Sign(HttpServletRequest request,
			@RequestParam(value = "taskID") @Param(desc = "任务ID") String taskID,
			@RequestParam(value = "id") @Param(desc = "id") String id,
			@RequestParam(value = "uid") @Param(desc = "用户ID") String uid) {
		log.info("================== 用户健康任务签到  ==============");

		ResultResponse response = new ResultResponse();
		String finishTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		this.userHealthtaskRelationService.updateUserHealthTaskSign(new Long(id), new Long(uid), new Long(
				taskID), finishTime);
		response.setResult("200");
		response.setContent("success");
		// 增加积分
		integralService.addIntegral(IntegralConstants.INTEGRAL_HEALTH_RENWU, new Long(uid), null);
		return response;
	}

	/**
	 * 删除任务
	 * 
	 * @param request
	 * @param taskID
	 * @return
	 */
	@RequestMapping(value = "/ht/delete", method = RequestMethod.POST)
	public @ResponseBody
	ResultResponse do_delete_task(HttpServletRequest request,
			@RequestParam(value = "taskID") @Param(desc = "任务ID") String taskID,
			@RequestParam(value = "userID") @Param(desc = "任务ID") String userID) {
		log.info("====================== 删除健康任务 =================");
		ResultResponse response = new ResultResponse();
		int resultRow = userHealthtaskRelationService.delete_HealthTask(Long.parseLong(userID),
				Long.parseLong(taskID));
		String result = "";
		if (resultRow > 0) {
			result = "succ";
		} else {
			result = "fail";
		}
		response.setResult(result);
		return response;
	}

	/**
	 * 已完成-查看结果
	 * 
	 * @param request
	 * @param taskID
	 * @param userID
	 * @return
	 */
	@RequestMapping(value = "/ht/signLog")
	public ModelAndView query_One_SignLog(HttpServletRequest request,
			@RequestParam(value = "signLogID") @Param(desc = "日志ID") String signLogID,
			@RequestParam(value = "uid") @Param(desc = "用户ID") String uid) {
		ModelAndView mv = new ModelAndView("healthTask/signLog.html");

		long id = Long.parseLong(signLogID);
		UserHealthtaskSignlogBO resultObj = this.userHealthTaskService.query_OneSignLog_By_ID(id);
		Calendar c = Calendar.getInstance();// 可以对每个时间域单独修改
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		String currDate = MessageFormat.format("{0}月{1}日", month, date);
		mv.addObject("currDate", currDate);
		mv.addObject("obj", resultObj);
		mv.addObject("uid", uid);
		mv.addObject("jumpType", request.getParameter("jumpType"));
		return mv;
	}

	/**
	 * 健康任务-点击任务 如果点击任务未签到或未到提醒时间 则跳转到当前任务设置界面 如果已签到 则跳转到签到结果界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ht/taskFinishSignLog")
	public ModelAndView query_task_finish_SignLog(HttpServletRequest request,
			@RequestParam(value = "taskID") @Param(desc = "任务ID") String taskID,
			@RequestParam(value = "userID") @Param(desc = "用户ID") String userID,
			@RequestParam(value = "jumpType") String jumpType) {
		ModelAndView mv = new ModelAndView("healthTask/signLog.html");

		String currentDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		currentDate = sdf.format(new Date());

		UserHealthtaskSignlogBO signLog = this.userHealthTaskService.query_OneSignLog_By_UIDAndTaskID(
				Long.parseLong(userID), Long.parseLong(taskID), currentDate);
		if (signLog == null) // 当前任务未签到或未到提醒条件
		{
			mv = new ModelAndView("redirect:taskSet");
			mv.addObject("id", taskID);
			mv.addObject("userID", userID);
			mv.addObject("jumpType", jumpType);
		} else {
			mv = new ModelAndView("redirect:signLog");
			mv.addObject("signLogID", signLog.getId());
			mv.addObject("uid", userID);
			mv.addObject("jumpType", jumpType);
		}
		return mv;
	}

	public static void main(String[] args) throws Exception {
		/*Date date=new Date();

		SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");

		System.out.println(dateFm.format(date));*/

		/*Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		System.out.println(year + "/" + month + "/" + date + " " +hour + ":" +minute + ":" + second); */

		String t = "%E5%90%83";
		String taskName = new String(t.getBytes("ISO-8859-1"), "utf-8");

		System.out.println(taskName);

	}

}
