package com.sinco.carnation.resource.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.sns.bo.WenJuanGroupBO;
import com.sinco.carnation.sns.bo.WenJuanresultHistoryBO;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.wenjuan.service.WenJuanGropService;

/**
 * 问卷调查Controller
 */
@Controller
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "问卷调查", namespace = "wenjuan")
public class WenJuanController extends BasicApiController {

	@Autowired
	private WenJuanGropService wenJuanGropService;

	@Autowired
	private IntegralService integralService;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 获取问卷题目
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/wenjuan/questionnaire", method = RequestMethod.GET)
	@MethodMapping(desc = "问卷调查题目")
	public String select_wenJuan_question_List(HttpServletRequest request, Model model,
			@Valid @RequestParam(value = "userID") String userID) {
		logger.info("======= 获取问卷题目 =========");
		long themeID = 4L;
		// WenJuanGroupBO wenJuan = this.wenJuanGropService.getWenJuan(themeID);

		List<WenJuanGroupBO> list = this.wenJuanGropService.getWenJuanList(themeID);

		Long uid = Long.parseLong(userID);
		logger.info(".....uid:" + uid);
		if (uid != null) {
			String result = ApiConstants.FAIL;
			if (list != null && list.size() > 0) {
				result = ApiConstants.SUCC;
				// wenJuan.setWjThemeID(themeID);
				model.addAttribute("list", list);
				model.addAttribute("themeID", themeID);
				// integralService.addIntegral(IntegralConstants.INTEGRAL_HEALTH_CESHI, uid, null);
			}
			model.addAttribute("result", result);
			model.addAttribute("uid", uid);

		}
		/*String webPath = CommUtil.getURL(request);
		model.addAttribute("apiPath", webPath);*/
		return "wenjuan/questionnaire.html";
	}

	/**
	 * 问卷调查结果分析
	 * 
	 * @param request
	 * @param reqResult
	 *            JSON格式(eg:{wjThemeID:id,totalScore:score})
	 * @return
	 */
	@RequestMapping(value = "/wenjuan/wjResult", method = RequestMethod.GET)
	@MethodMapping(desc = "问卷调查结果分析")
	public String wenJuanResult(HttpServletRequest request, String reqResult, Model model) {
		logger.info(" ============ 问卷调查结果分析 ============== ");
		logger.info("<<<<<<<<<< reqResult:" + reqResult);
		String result = ApiConstants.SUCC;
		if (reqResult != null && reqResult.trim().length() > 0) {
			JSONObject jsonObject = JSONObject.parseObject(reqResult);
			long wjThemeID = jsonObject.getLongValue("wjThemeID");
			int totalScore = jsonObject.getIntValue("totalScore");
			logger.info("..... 题ID:" + wjThemeID + " 总分数:" + totalScore);
			Long uid = Long.parseLong(request.getParameter("uid"));
			// uid = new Long("1151");
			WenJuanresultHistoryBO bo = this.wenJuanGropService.saveWenJuanResult(wjThemeID, totalScore, uid);
			if (bo != null) {
				model.addAttribute("bo", bo);
				model.addAttribute("uid", uid);
//				integralService.addIntegral(IntegralConstants.INTEGRAL_HEALTH_CESHI, uid, null);
			} else {
				result = ApiConstants.FAIL;
			}
		}
		model.addAttribute("result", result);
		/*String webPath = CommUtil.getURL(request);
		model.addAttribute("apiPath", webPath);*/
		return "wenjuan/questionnaire_assess.html";
	}

	/**
	 * 用户健康评估
	 * 
	 * @param request
	 * @param model
	 * @param userID
	 * @return
	 */
	@RequestMapping(value = "/wenjuan/proposal", method = RequestMethod.GET)
	@MethodMapping(desc = "用户健康评估")
	public String healthProposal(HttpServletRequest request, Model model,
			@RequestParam(value = "userID") @Param String userID) {
		String result = ApiConstants.SUCC;
		if (userID != null && userID.trim().length() > 0) {
			Long uid = ActionsUtil.getOwnerUid();
			WenJuanresultHistoryBO bo = this.wenJuanGropService.getHealthProposal(uid);
			if (bo != null) {
				model.addAttribute("bo", bo);
			} else {
				result = ApiConstants.FAIL;
			}
		}
		/*String webPath = CommUtil.getURL(request);
		model.addAttribute("apiPath", webPath);*/
		model.addAttribute("result", result);
		return "wenjuan/questionnaire_proposal.html";
	}

	/**
	 * 用户健康调查建议
	 * 
	 * @param request
	 * @param model
	 * @param userID
	 * @param proposalID
	 * @return
	 */
	@RequestMapping(value = "/wenjuan/proposalDetai", method = RequestMethod.GET)
	@MethodMapping(desc = "用户健康调查建议")
	public ModelAndView healthProposalDetai(HttpServletRequest request, Model model,
			@RequestParam(value = "proposalID") @Param String proposalID,
			@RequestParam(value = "userID") @Param String userID) {
		logger.info("===========  用户健康调查建议  ============= ");
		ModelAndView mv = new ModelAndView("wenjuan/questionnaire_proposal.html");
		if (userID != null) {
			Long uid = new Long(userID);
			WenJuanresultHistoryBO bo = this.wenJuanGropService.getHealthAssesDetailed(uid, proposalID);
			if (bo != null) {
				model.addAttribute("bo", bo);
			}
			model.addAttribute("uid", uid);
		}
		/*String webPath = CommUtil.getURL(request);
		model.addAttribute("apiPath", webPath);*/
		return mv;
	}

	public static void main(String[] args) {

	}

}
