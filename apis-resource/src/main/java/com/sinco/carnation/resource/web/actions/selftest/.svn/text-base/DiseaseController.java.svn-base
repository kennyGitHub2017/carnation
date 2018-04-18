package com.sinco.carnation.resource.web.actions.selftest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.sns.bo.WenJuanGroupBO;
import com.sinco.carnation.sns.bo.WenJuanProposalBO;
import com.sinco.carnation.sns.bo.WenJuanProposalDetailedBO;
import com.sinco.carnation.sns.bo.WenJuanQuestionBO;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.wenjuan.service.DiseaseService;

/**
 * 疾病自测
 * 
 * @author yuleijia
 */
@Controller
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "疾病自测", namespace = "disease")
public class DiseaseController extends BasicApiController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DiseaseService diseaseService;

	@Autowired
	private IntegralService integralService;

	/**
	 * 疾病自测
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/jibing/indexList", method = RequestMethod.GET)
	public ModelAndView query_group_List(HttpServletRequest request,
			@Valid @RequestParam(value = "userID") @Param(desc = "用户ID") String userID) {
		logger.info("============== 疾病自测 ==============");
		ModelAndView mv = new ModelAndView("wenjuan/jiBing_index.html");

		Long uid = Long.parseLong(userID);
		if (uid == null) {
			uid = 0L;
		}
		long themeID = 5L;
		List<WenJuanGroupBO> list = this.diseaseService.query_Disease_list(themeID);
		logger.info("...... result list size:" + list.size());
		/*String webPath = CommUtil.getURL(request);
		mv.addObject("apiPath", webPath);*/
		mv.addObject("uid", uid);
		mv.addObject("list", list);
		return mv;
	}

	/**
	 * 获取疾病自测_自测题目
	 * 
	 * @param request
	 * @param userID
	 * @param groupID
	 * @return
	 */
	@RequestMapping(value = "/jibing/questionList", method = RequestMethod.POST)
	public ModelAndView query_question_List(HttpServletRequest request,
			@Valid @RequestParam(value = "userID") @Param(desc = "用户ID") String userID,
			@Valid @RequestParam(value = "groupID") @Param(desc = "题组ID") String groupID) {
		ModelAndView mv = new ModelAndView("wenjuan/jiBingZiCe_List.html");
		Long uid = null;
		if (userID != null && userID.trim().length() > 0) {
			uid = Long.parseLong(userID);
			List<Long> group_ID_List = new ArrayList<Long>();
			boolean isBoo = groupID.contains(",");
			if (isBoo) {
				String[] strArr = groupID.split(",");
				for (String str : strArr) {
					group_ID_List.add(Long.parseLong(str));
				}
			}
			if (!isBoo) {
				group_ID_List.add(Long.parseLong(groupID));
			}
			logger.info(".....group_ID_List:" + group_ID_List.toString());
			List<WenJuanQuestionBO> list = this.diseaseService.queryQuestionListByGroupID(group_ID_List);
			mv.addObject("list", list);
			mv.addObject("groupID", groupID);
		}
		/*String webPath = CommUtil.getURL(request);
		mv.addObject("apiPath", webPath);*/
		mv.addObject("uid", uid);
		return mv;
	}

	/**
	 * 疾病自测结果
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/jibing/result", method = RequestMethod.POST)
	public ModelAndView query_Question_Result(HttpServletRequest request,
			@Valid @RequestParam(value = "userID") @Param(desc = "用户ID") String userID,
			@Valid @RequestParam(value = "jsonStr") @Param(desc = "JSON格式字符串") String jsonStr,
			@Valid @RequestParam(value = "groupID") @Param(desc = "题ID") String groupID) {
		logger.info("============== 疾病自测结果 ==============");
		logger.info("<<<<<<< userID:" + userID + "  jsonStr:" + jsonStr + " groupID:" + groupID);
		JSONObject json = JSONObject.fromObject(jsonStr);
		boolean isBoo = groupID.contains(",");
		List<Long> group_ID_List = new ArrayList<Long>();
		if (isBoo) {
			String[] strArr = groupID.split(",");
			for (String str : strArr) {
				group_ID_List.add(Long.parseLong(str));
			}
		}
		if (!isBoo) {
			group_ID_List.add(Long.parseLong(groupID));
		}
		Map<Long, Integer> map = new HashMap<Long, Integer>();

		for (int i = 0; i < group_ID_List.size(); i++) {
			long id = group_ID_List.get(i);
			int score = (int) json.get(String.valueOf(id));
			map.put(id, score);
		}
		List<WenJuanProposalBO> list = this.diseaseService.questionWenJuanProposal(group_ID_List, map,
				Long.parseLong(userID));
		if (list == null) {
			logger.info("********** 当前分数无对应做题结果 ******** ");
		}
		ModelAndView mv = new ModelAndView("wenjuan/jiBingZiCe_result.html");
		mv.addObject("list", list);
		return mv;
	}
	
	/**
	 * 疾病自测后_膳食建议/养生建议
	 * 
	 * @param request
	 * @param userID
	 * @param types
	 * @return
	 */
	@RequestMapping(value = "/jibing/proposal", method = RequestMethod.GET)
	public ModelAndView query_proposalList(HttpServletRequest request,
			@Valid @RequestParam(value = "userID") @Param(desc = "用户ID") String userID,
			@Valid @RequestParam(value = "types") @Param(desc = "建议类型  10:膳食  20：养生") String types) {
		logger.info("<<<<<<<<<<<<< userID:" + userID + " types:" + types);

		List<WenJuanProposalDetailedBO> result_list = this.diseaseService.query_ProposalDetailed(
				Long.parseLong(userID), Long.parseLong(types));
		String pageName = "";
		if (types.equals("10")) // 饮食
		{
			pageName = "wenjuan/shanShi.html";
		}
		if (types.equals("20")) // 方法
		{
			pageName = "wenjuan/yangSheng.html";
		}
		ModelAndView mv = new ModelAndView(pageName);
		/*String webPath = CommUtil.getURL(request);
		mv.addObject("apiPath", webPath);*/
		mv.addObject("list", result_list);
		return mv;
	}
}
