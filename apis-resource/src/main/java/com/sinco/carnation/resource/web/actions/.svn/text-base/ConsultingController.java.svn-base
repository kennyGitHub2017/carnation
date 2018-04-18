package com.sinco.carnation.resource.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.consulting.service.ConsultingService;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.favorites.ConsultingRepayVO;
import com.sinco.carnation.resource.vo.favorites.ConsultingVO;
import com.sinco.carnation.resource.web.response.favorites.ConsultingResponse;
import com.sinco.carnation.resource.web.response.favorites.UserConsultingListResponse;
import com.sinco.carnation.sns.bo.ConsultingBO;
import com.sinco.carnation.sns.model.Consulting;
import com.sinco.carnation.sns.model.ConsultingRepay;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "专家咨询", namespace = "experts")
public class ConsultingController extends BasicApiController {

	@Autowired
	private ConsultingService consultingService;

	@Autowired
	private Mapper mapper;

	/**
	 * 专家咨询，提问人个人中心我的提问
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/users/consulting/list", method = RequestMethod.POST)
	@MethodMapping(desc = "专家咨询，提问人个人中心我的提问列表")
	public @ResponseBody
	UserConsultingListResponse usersConsultingList(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			BindingResult result, HttpServletRequest request) {

		UserConsultingListResponse response = new UserConsultingListResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<ConsultingBO> page = new MyPage<ConsultingBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		consultingService.selectConsultingPageByUserId(ActionsUtil.getOwnerUid(), page);

		List<com.sinco.carnation.resource.bo.UserConsultingListBO> consultingList = MapperUtils.map(mapper,
				page.getContent(), com.sinco.carnation.resource.bo.UserConsultingListBO.class);
		response.setConsultingResult(consultingList);
		response.setTotalCount(page.getTotalElements());
		return response;
	}

	/**
	 * 根据id查询提问信息
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sns/consulting/detail", method = RequestMethod.POST)
	@MethodMapping(desc = "根据id查询提问信息")
	public @ResponseBody
	ConsultingResponse snsConsultingDetail(
			@Valid @RequestParam(value = "cid") @Param(desc = "咨询提问id") Long cid, HttpServletRequest request) {

		ConsultingResponse response = new ConsultingResponse();
		if (cid == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		Consulting consulting = consultingService.selectConsultingById(cid);

		com.sinco.carnation.resource.bo.ConsultingBO consultingBO = mapper.map(consulting,
				com.sinco.carnation.resource.bo.ConsultingBO.class);
		response.setConsultingBO(consultingBO);

		return response;
	}

	/**
	 * 咨询提问保存
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sns/consulting/add", method = RequestMethod.POST)
	@MethodMapping(desc = "咨询提问保存")
	public @ResponseBody
	ConsultingResponse consultingAdd(@Valid @ModelAttribute @Param ConsultingVO vo, BindingResult result,
			HttpServletRequest request) {

		ConsultingResponse response = new ConsultingResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Consulting consulting = mapper.map(vo, Consulting.class);
		consulting.setCurrentUserId(String.valueOf(ActionsUtil.getOwnerUid()));
		consulting.setUserId(ActionsUtil.getOwnerUid());
		consulting.setMark("1");
		consultingService.saveConsulting(consulting);

		com.sinco.carnation.resource.bo.ConsultingBO bo = mapper.map(consulting,
				com.sinco.carnation.resource.bo.ConsultingBO.class);

		response.setConsultingBO(bo);
		return response;
	}

	/**
	 * 咨询回复保存
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sns/consultingRepay/add", method = RequestMethod.POST)
	@MethodMapping(desc = "咨询提问保存")
	public @ResponseBody
	ConsultingResponse consultingRepayAdd(@Valid @ModelAttribute @Param ConsultingRepayVO vo,
			BindingResult result, HttpServletRequest request) {

		ConsultingResponse response = new ConsultingResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long userid = ActionsUtil.getOwnerUid();
		ConsultingRepay consultingRepay = mapper.map(vo, ConsultingRepay.class);
		consultingRepay.setCurrentUserId(String.valueOf(ActionsUtil.getOwnerUid()));
		consultingService.saveConsultingRepay(consultingRepay, userid);
		com.sinco.carnation.resource.bo.ConsultingBO consultingBO = new com.sinco.carnation.resource.bo.ConsultingBO();
		consultingBO.setId(vo.getConsultingId());
		response.setConsultingBO(consultingBO);
		return response;
	}
}
