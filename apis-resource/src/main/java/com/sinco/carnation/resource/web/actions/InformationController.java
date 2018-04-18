package com.sinco.carnation.resource.web.actions;

import java.util.ArrayList;
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
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.check.service.CheckClassService;
import com.sinco.carnation.cms.service.InformationClassServiceImpl;
import com.sinco.carnation.cms.service.InformationServiceImpl;
import com.sinco.carnation.resource.bo.HumanBodyBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.HumanVO;
import com.sinco.carnation.resource.vo.favorites.InformationVO;
import com.sinco.carnation.resource.web.response.information.InformationClassResponse;
import com.sinco.carnation.resource.web.response.information.InformationResponse;
import com.sinco.carnation.sns.bo.CheckClassBO;
import com.sinco.carnation.sns.bo.InformationBO;
import com.sinco.carnation.sns.bo.InformationClassBO;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "资讯相关", namespace = "information")
public class InformationController extends BasicApiController {

	@Autowired
	private InformationServiceImpl informationServiceImpl;

	@Autowired
	private InformationClassServiceImpl informationClassServiceImpl;

	@Autowired
	private CheckClassService checkService;

	@Autowired
	private Mapper mapper;

	/**
	 * 资讯列表
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sns/information/page_list", method = RequestMethod.POST)
	@MethodMapping(desc = "资讯列表根据分类分页查询")
	public @ResponseBody
	InformationResponse snsInFormationPage(@Valid @ModelAttribute @Param InformationVO vo,
			BindingResult result, HttpServletRequest request) {
		InformationResponse response = new InformationResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<InformationBO> page = new MyPage<InformationBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		informationServiceImpl.selectPageByClassId(vo.getClassId(), page);
		List<com.sinco.carnation.resource.bo.InformationBO> informations = MapperUtils.map(mapper,
				page.getContent(), com.sinco.carnation.resource.bo.InformationBO.class);

		response.setInformations(informations);;
		// 设置总记录数
		response.setTotalCount(page.getTotalElements());

		return response;
	}

	@RequestMapping(value = "/sns/information/all_list", method = RequestMethod.POST)
	@MethodMapping(desc = "文章资讯根据分类查询全部")
	public @ResponseBody
	InformationResponse snsInfomationList(
			@Valid @RequestParam(value = "classId") @Param(desc = "资讯分类id，查询当前分类下的所有帖子") Long classId,
			HttpServletRequest request) {

		InformationResponse response = new InformationResponse();
		if (classId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		List<InformationBO> listResult = informationServiceImpl.selectByClassId(classId);
		List<com.sinco.carnation.resource.bo.InformationBO> informations = MapperUtils.map(mapper,
				listResult, com.sinco.carnation.resource.bo.InformationBO.class);
		response.setInformations(informations);
		return response;
	}

	@RequestMapping(value = "/sns/information/class", method = RequestMethod.POST)
	@MethodMapping(desc = "资讯分类")
	public @ResponseBody
	InformationClassResponse snsInfomationClass(
			@Valid @RequestParam(value = "parentClassId") @Param(desc = "传入资讯分类id，查询该分类下的一级子分类") Long parentClassId,
			HttpServletRequest request) {

		InformationClassResponse response = new InformationClassResponse();
		if (parentClassId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		List<InformationClassBO> listClass = informationClassServiceImpl
				.findInformationClassByParentId(parentClassId);

		List<com.sinco.carnation.resource.bo.InformationClassBO> informationClasses = MapperUtils.map(mapper,
				listClass, com.sinco.carnation.resource.bo.InformationClassBO.class);
		response.setInformationClasses(informationClasses);

		return response;
	}

	@RequestMapping(value = "/sns/body/list", method = RequestMethod.POST)
	@MethodMapping(desc = "人体部位列表")
	public @ResponseBody
	InformationClassResponse humanBody(@Valid @ModelAttribute @Param HumanVO vo, BindingResult result,
			HttpServletRequest request) {
		InformationClassResponse response = new InformationClassResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		// 形体
		if (vo.getType() == 0) {

			List<HumanBodyBO> list = new ArrayList<HumanBodyBO>();
			List<InformationClassBO> information = informationClassServiceImpl
					.selectInfomationClassList(5000l);
			// List<CheckClassBO> check1 =
			// checkService.selectCheckClaaaList(5000l);
			for (int i = 0; i < information.size(); i++) {
				HumanBodyBO bo = new HumanBodyBO();
				bo.setId(information.get(i).getId());
				bo.setName(information.get(i).getIcName());
				list.add(bo);
			}
			response.setBoyList(list);
			// 症状
		} else {
			List<HumanBodyBO> list = new ArrayList<HumanBodyBO>();
			List<CheckClassBO> check2 = checkService.selectCheckClaaaList(50l);
			for (int i = 0; i < check2.size(); i++) {
				HumanBodyBO bo = new HumanBodyBO();
				bo.setId(check2.get(i).getId());
				bo.setName(check2.get(i).getClassName());
				list.add(bo);
			}
			response.setBoyList(list);
		}
		return response;
	}
}
