package com.sinco.carnation.resource.web.actions.healthManage;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.healthcircle.model.Post;
import com.sinco.carnation.healthcircle.service.PostService;
import com.sinco.carnation.resource.bo.healthTask.HealthTaskBO;
import com.sinco.carnation.resource.bo.healthTask.TodayHealthTaskBO;
import com.sinco.carnation.resource.bo.healthcircle.HealthCircleBo;
import com.sinco.carnation.resource.bo.questionnaire.UserQuestionProposalBO;
import com.sinco.carnation.resource.bo.questionnaire.UserQuestionnaireBO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.healthManage.HMIndexResponse;
import com.sinco.carnation.sns.bo.UserHealthtaskBO;
import com.sinco.carnation.sns.bo.WenJuanGroupResultBO;
import com.sinco.carnation.sns.bo.WenJuanProposalBO;
import com.sinco.carnation.sns.bo.WenJuanresultHistoryBO;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserHealthTaskService;
import com.sinco.carnation.wenjuan.service.WenJuanGropService;
import com.sinco.common.utils.StringUtils;
import com.sinco.dal.common.MyPage;

/**
 * 健康管理首页
 * 
 * @author yuleijia
 */
@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "健康管理", namespace = "userHealthManage")
public class HealthManageController extends BasicApiController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private WenJuanGropService wenJuanGropService;
	@Autowired
	private UserHealthTaskService userHealthTaskService;
	@Autowired
	private Mapper mapper;
	@Autowired
	private PostService postService;

	/**
	 * 健康管理首页_已登陆
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/healthManage/index", method = RequestMethod.GET)
	@MethodMapping(desc = "健康管理首页")
	public @ResponseBody
	HMIndexResponse get_HealthManage_Index(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			BindingResult result, HttpServletRequest request,
			@RequestParam(value = "postType") @Param(desc = "类型0:全部,1:热门") Integer postType) {
		logger.debug(" ============= 健康管理首页_已登陆 ================== ");

		HMIndexResponse response = new HMIndexResponse();
		/*if (result.hasErrors())
		{
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}*/
		Long uid = ActionsUtil.getOwnerUid();
		// uid = new Long("15078"); //15078
		/** 获取用户信息 **/
		com.sinco.carnation.resource.bo.healthManage.UserCustomerBO user = this.query_User_By_Uid(uid);
		response.setUserCustomerBO(user);
		/** 获取问卷调查 **/
		response.setQuestionnaireBO(this.query_Questionnair_By_Uid(uid));
		/** 今日健康任务 **/
		response.setTodayHealthTask(this.query_todayTask_By_UID(uid));
		/** 健康圈 **/
		response.setHealthCircles(this.query_HealthCircle(vo, postType, uid));
		/** 疾病自测 **/
		this.query_JiBing(uid, request, response);

		return response;
	}

	/**
	 * 健康管理首页_未登陆
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/healthManage/index2", method = RequestMethod.GET)
	@MethodMapping(desc = "健康管理首页(未登陆状态)")
	public @ResponseBody
	HMIndexResponse get_HealthManage_Index2(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			BindingResult result, HttpServletRequest request,
			@RequestParam(value = "postType") @Param(desc = "类型0:全部,1:热门") Integer postType) {
		logger.debug(" ============= 健康管理首页_未登陆 ================== ");

		HMIndexResponse response = new HMIndexResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		/** 获取用户信息 **/
		response.setUserCustomerBO(null);
		/** 获取问卷调查 **/
		response.setQuestionnaireBO(null);
		/** 今日健康任务 **/
		response.setTodayHealthTask(null);
		/** 健康圈 **/
		response.setHealthCircles(this.query_HealthCircle(vo, postType, null));
		return response;
	}

	/**
	 * 用户信息
	 * 
	 * @param uid
	 *            用户ID
	 * @return
	 */
	private com.sinco.carnation.resource.bo.healthManage.UserCustomerBO query_User_By_Uid(Long uid) {
		logger.debug(" ============= 获取用户信息 ================== ");

		com.sinco.carnation.resource.bo.healthManage.UserCustomerBO res_bo = new com.sinco.carnation.resource.bo.healthManage.UserCustomerBO();
		UserCustomer userCustomer = customerService.findById(uid);
		if (userCustomer != null) {
			int currentRank = 1;
			int highestRank = 10;
			/*String rankJiFen = "{1:10,2:20,3:30,4:40,5:50,6:60,7:70,8:80,9:90,10:100}";*/
			/*Map<Integer,Integer> rankJiFenMap = new HashMap<Integer, Integer>();
			rankJiFenMap.put(1, 10);
			rankJiFenMap.put(2, 20);
			rankJiFenMap.put(3, 30);
			rankJiFenMap.put(4, 40);
			rankJiFenMap.put(5, 50);
			rankJiFenMap.put(6, 60);
			rankJiFenMap.put(7, 70);
			rankJiFenMap.put(8, 80);
			rankJiFenMap.put(9, 90);
			rankJiFenMap.put(10, 100);
			List<Map<Integer,Integer>> list = new ArrayList<Map<Integer,Integer>>();
			list.add(rankJiFenMap);*/
			String rankJiFen = "1:10|2:20|3:30|4:40|5:50|6:60|7:70|8:80|9:90|10:100";

			String userName = userCustomer.getName() == null ? "-" : userCustomer.getName();
			res_bo.setUid(userCustomer.getUid());
			res_bo.setName(userName);
			res_bo.setNickName(userCustomer.getNickname() == null ? "-" : userCustomer.getNickname());
			res_bo.setHeadImgPath(userCustomer.getHeadImgPath() == null ? "-" : userCustomer.getHeadImgPath());
			res_bo.setCurrentRank(currentRank); // 用户等级
			res_bo.setHighestRank(highestRank); // 最高等级
			res_bo.setRankJiFen(rankJiFen); // 等级积分
			res_bo.setSex(userCustomer.getSex() == null ? 0 : userCustomer.getSex());
			res_bo.setIntegral(userCustomer.getIntegral()); // 用户积分
		} else {
			logger.warn(".....当前用户不存在.....:" + uid);
		}
		return res_bo;
	}

	/**
	 * 问卷调查
	 * 
	 * @return
	 */
	private UserQuestionnaireBO query_Questionnair_By_Uid(Long uid) {
		logger.info(" ============= 问卷调查结果信息 ================== ");

		UserQuestionnaireBO res_BO = new UserQuestionnaireBO();
		WenJuanresultHistoryBO historyBO = this.wenJuanGropService.queryQuestionnairByUid(uid);
		Integer result = null;
		String content = "";
		if (historyBO != null) {
			Long historyID = historyBO.getId() == null ? 0L : historyBO.getId();
			int totalScore = historyBO.getTotalScore() == null ? 0 : historyBO.getTotalScore();
			WenJuanGroupResultBO groupResult = historyBO.getGroupResultBo() == null ? new WenJuanGroupResultBO()
					: historyBO.getGroupResultBo();
			int isChronic = groupResult.getIsChronic() ? 1 : 0;
			int isHealthy = groupResult.getIsHealthy() ? 1 : 0;
			int isHigh = groupResult.getIsHigh() ? 1 : 0;
			int isYjk = groupResult.getIsYjk() ? 1 : 0;

			logger.debug("...... isChronic:" + isChronic + " isHealthy:" + isHealthy + " isHigh:" + isHigh
					+ " isYjk:" + isYjk);

			// List<WenJuanProposalBO> jy_List = historyBO.getJianYi_List();
			List<WenJuanProposalBO> gj_List = historyBO.getProposalBO_List();
			// 建议题目集
			// List<UserQuestionProposalBO> proposalList = this.handleProposalList(jy_List);
			// 改进题目集
			List<UserQuestionProposalBO> improveList = this.handleProposalList(gj_List);

			res_BO.setId(historyID);
			res_BO.setTotalStore((long) totalScore);
			res_BO.setIsChronic(isChronic);
			res_BO.setIsHealthy(isHealthy);
			res_BO.setIsHigh(isHigh);
			res_BO.setIsYjk(isYjk);
			// res_BO.setProposalList(proposalList);
			res_BO.setImproveList(improveList);

			result = UserQuestionnaireBO.SUCC;
			content = UserQuestionnaireBO.SUCCTR;
		} else {
			result = UserQuestionnaireBO.ISNULL;
			content = UserQuestionnaireBO.ISNULLTR;
		}
		res_BO.setResult(result);
		res_BO.setContent(content);
		return res_BO;
	}

	private List<UserQuestionProposalBO> handleProposalList(List<WenJuanProposalBO> list) {
		List<UserQuestionProposalBO> resultList = new ArrayList<UserQuestionProposalBO>();
		UserQuestionProposalBO tempObj = null;
		for (WenJuanProposalBO obj : list) {
			tempObj = new UserQuestionProposalBO();
			tempObj.setId(obj.getId());
			tempObj.setProposalTitle(obj.getProposalTitle());
			resultList.add(tempObj);
		}
		return resultList;
	}

	/**
	 * 今日健康任务
	 * 
	 * @param uid
	 * @return
	 */
	private TodayHealthTaskBO query_todayTask_By_UID(Long uid) {

		logger.debug(" ================ 今日健康任务  ============= ");
		TodayHealthTaskBO resultBO = new TodayHealthTaskBO();
		Date date = new Date();
		List<UserHealthtaskBO> sourceList_ = this.userHealthTaskService.getTodayHealthTaskSer(date, uid);
		int result = UserHealthtaskBO.result_succ;
		String content = "succ";
		if (sourceList_ != null) {
			List<HealthTaskBO> resultList = MapperUtils.map(mapper, sourceList_, HealthTaskBO.class);
			resultBO.setHealthTaskList(resultList);
		} else {
			result = UserHealthtaskBO.result_succ_empty;
			content = UserHealthtaskBO.content_empty;
		}
		resultBO.setResult(result);
		resultBO.setContent(content);
		return resultBO;
	}

	/**
	 * 健康圈
	 * 
	 * @param vo
	 * @param postType
	 *            0:全部,1:热门
	 * @return
	 */
	private HealthCircleBo query_HealthCircle(BasicPageParamVo vo, Integer postType, Long uid) {
		// if(postType==null)
		// {
		postType = 0;
		// }
		logger.debug(" ================ 获取健康圈信息  ============= ");
		HealthCircleBo result_BO = new HealthCircleBo();
		MyPage<Post> page = new MyPage<Post>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		Integer ispush = 1;
		List<Post> list = postService.findPageByType(page, postType, uid, ispush);
		int result = HealthCircleBo.result_succ;
		String content = "succ";
		if (null != list && list.size() > 0) {
			list = getImages(list);
			List<com.sinco.carnation.resource.bo.healthcircle.PostBO> postList = MapperUtils.map(mapper,
					list, com.sinco.carnation.resource.bo.healthcircle.PostBO.class);
			result_BO.setPostList(postList);
		} else {
			result = HealthCircleBo.result_succ_empty;
			content = HealthCircleBo.content_empty;
		}
		result_BO.setContent(content);
		result_BO.setResult(result);
		return result_BO;
	}

	/**
	 * 对图片字符串进行相应的处理
	 */
	public List<Post> getImages(List<Post> list) {
		for (Post post : list) {
			String[] images = null;
			String thumbnail = post.getThumbnail();
			if (StringUtils.isNotEmpty(thumbnail)) {
				images = thumbnail.split("\\|");
				post.setImagesList(images);
			}
		}
		return list;
	}

	/**
	 * 疾病自测
	 * 
	 * @param userID
	 * @param request
	 * @param response
	 */
	private void query_JiBing(long userID, HttpServletRequest request, HMIndexResponse response) {
		logger.debug(" ================ 获取疾病自测信息  ============= ");
		// String webPath = CommUtil.getURL(request);
		boolean boo = this.wenJuanGropService.query_JiBing_History(userID);
		if (boo) // 做过疾病自测 给出 养生和膳食建议URL访问地址
		{
			logger.debug(" ////////////// 获取疾病建议 ////////////// ");
			// 10:膳食 20：养生
			response.setYangShengURL("/v1/jibing/proposal?userID=" + userID + "&types=" + 20);
			response.setShanShiURL("/v1/jibing/proposal?userID=" + userID + "&types=" + 10);
			response.setRetestURL("/v1/jibing/indexList?userID=" + userID);

		}
		if (!boo) // 未做过疾病自测 给出 疾病自测URL访问地址
		{
			logger.debug(" ////////////// 获取疾病自测题目 ////////////// ");
			response.setJiBingURL("/v1/jibing/indexList?userID=" + userID);
		}
	}
}
