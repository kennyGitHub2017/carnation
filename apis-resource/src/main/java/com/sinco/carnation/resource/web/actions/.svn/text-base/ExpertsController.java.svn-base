package com.sinco.carnation.resource.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;
import org.jsoup.Jsoup;
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
import com.sinco.api.util.JsoupUtils;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.bo.ExpertsBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.favorites.ExpertsDetailVO;
import com.sinco.carnation.resource.vo.favorites.ExpertsVO;
import com.sinco.carnation.resource.web.response.favorites.ExpertsResponse;
import com.sinco.carnation.resource.web.response.favorites.PraiseResponse;
import com.sinco.carnation.user.bo.UserExpertsBO;
import com.sinco.carnation.user.service.ExpertsService;
import com.sinco.carnation.user.vo.UserExpertsVO;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "专家咨询", namespace = "experts")
public class ExpertsController extends BasicApiController {

	@Autowired
	private ExpertsService expertsService;

	@Autowired
	private Mapper mapper;

	/**
	 * 专家列表
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/users/experts/list", method = RequestMethod.POST)
	@MethodMapping(desc = "专家列表")
	public @ResponseBody
	ExpertsResponse expertsList(@Valid @ModelAttribute @Param ExpertsVO vo, BindingResult result,
			HttpServletRequest request) {

		ExpertsResponse response = new ExpertsResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		UserExpertsVO userVO = mapper.map(vo, UserExpertsVO.class);
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<UserExpertsBO> page = new MyPage<UserExpertsBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		expertsService.selectExpertsListByVO(userVO, page);

		List<ExpertsBO> expertsBOs = MapperUtils.map(mapper, page.getContent(), ExpertsBO.class);

		for (int i = 0; i < expertsBOs.size(); i++) {
			if (StringUtils.isNotBlank(expertsBOs.get(i).getDescription())) {
				expertsBOs.get(i).setDesc(Jsoup.parse(expertsBOs.get(i).getDescription()).text());
			}
		}
		response.setExperts(expertsBOs);
		response.setTotalCount(page.getTotalElements());
		return response;
	}

	/**
	 * 专家详情
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/users/experts/detail", method = RequestMethod.POST)
	@MethodMapping(desc = "专家详情")
	public @ResponseBody
	ExpertsResponse expertsDetail(@Valid @ModelAttribute @Param ExpertsDetailVO vo, BindingResult result,
			HttpServletRequest request) {

		ExpertsResponse response = new ExpertsResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();
		UserExpertsBO experts = expertsService.selectExpertsDetail(vo.getUid(), userId);
		ExpertsBO bo = mapper.map(experts, ExpertsBO.class);
		if (StringUtils.isNotBlank(bo.getDescription())) {
			bo.setDescription(JsoupUtils.queryHtml(bo.getDescription()));
		}
		response.setExpertsDetail(bo);
		return response;
	}

	/**
	 * 点赞
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/users/experts/praise", method = RequestMethod.POST)
	@MethodMapping(desc = "专家点赞")
	public @ResponseBody
	PraiseResponse usersExpertsPraise(
			@Valid @RequestParam(value = "expertsId") @Param(desc = "专家用户userid") Long expertsId,
			HttpServletRequest request) {

		PraiseResponse response = new PraiseResponse();
		if (expertsId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();

		int result = expertsService.usersPraise(String.valueOf(userId), expertsId);

		if (result < 0) {
			response.putErrorMessage("4.user.usersExpertsPraise.has_praised");
			return response;
		} else if (result < 1) {
			response.putErrorMessage("5.invitation.usersPraise.praise_fail");
			return response;
		}

		return response;
	}

	/**
	 * 取消点赞
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/users/experts/unpraise", method = RequestMethod.POST)
	@MethodMapping(desc = "取消专家点赞")
	public @ResponseBody
	PraiseResponse usersExpertsUnpraise(
			@Valid @RequestParam(value = "expertsId") @Param(desc = "专家用户userid") Long expertsId,
			HttpServletRequest request) {

		PraiseResponse response = new PraiseResponse();
		if (expertsId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();

		int result = expertsService.usersUnPraise(String.valueOf(userId), expertsId);

		if (result < 0) {
			response.putErrorMessage("4.user.usersExpertsPraise.has_not_praised");
			return response;
		} else if (result < 1) {
			response.putErrorMessage("5.invitation.usersPraise.praise_fail");
			return response;
		}

		return response;
	}
}
