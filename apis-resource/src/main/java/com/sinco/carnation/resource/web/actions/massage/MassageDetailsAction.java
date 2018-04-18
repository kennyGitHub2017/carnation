package com.sinco.carnation.resource.web.actions.massage;

import javax.servlet.http.HttpServletRequest;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.massage.model.Massage;
import com.sinco.carnation.massage.model.MassageDetails;
import com.sinco.carnation.massage.service.MassageDetailsService;
import com.sinco.carnation.massage.service.MassageService;
import com.sinco.carnation.resource.bo.massage.MassageDetailsMO;
import com.sinco.carnation.resource.constant.ResultCodeConstant;
import com.sinco.carnation.resource.constant.ResultMsgConstant;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.massage.MassageDetailsResponse;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "按摩详细", namespace = "massageDetails")
public class MassageDetailsAction extends BasicApiController {

	@Autowired
	private MassageDetailsService massageDetailsService;

	@Autowired
	private MassageService massageService;

	@Autowired
	private Mapper mapper;

	@RequestMapping(value = "/massage/details/data/upload", method = RequestMethod.POST)
	@MethodMapping(desc = "上传按摩详细数据")
	@ResponseBody
	public MassageDetailsResponse uploadMassageData(Integer time, HttpServletRequest request) {
		MassageDetailsResponse response = new MassageDetailsResponse();
		Long userId = ActionsUtil.getOwnerUid();
//		Long userId = (long) 15869;
		// 校验用户ID不为空
		if (!CommUtil.isNotNull(userId)) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.USER_ID_NOT_NULL);
			response.setM_errorMsg(ResultMsgConstant.USER_ID_NOT_NULL);
			return response;
		}
		MassageDetails result = massageDetailsService.uploadMassageDetails(time, userId);

		// 返回保存数据
		MassageDetailsMO massageDetailsMO = mapper.map(result, MassageDetailsMO.class);
		response.setMassageDetails(massageDetailsMO);
		return response;
	}

	@RequestMapping(value = "/get/massage/details/data", method = RequestMethod.POST)
	@MethodMapping(desc = "获取按摩详细数据")
	@ResponseBody
	public MassageDetailsResponse getMassageDetailsData(HttpServletRequest request) {
		MassageDetailsResponse response = new MassageDetailsResponse();
		Long userId = ActionsUtil.getOwnerUid();
//		Long userId = (long) 16265;
		// 校验用户ID不为空
		if (!CommUtil.isNotNull(userId)) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.USER_ID_NOT_NULL);
			response.setM_errorMsg(ResultMsgConstant.USER_ID_NOT_NULL);
			return response;
		}
		// 根据用户ID获取当天按摩详细数据
		MassageDetails massageDetails = massageDetailsService.getByUserId(userId);

		// 返回保存数据
		MassageDetailsMO massageDetailsMO = new MassageDetailsMO();
		if (null != massageDetails) {
			massageDetailsMO = mapper.map(massageDetails, MassageDetailsMO.class);
			
		}
		Massage massage = massageService.getByUserId(userId);
		massageDetailsMO.setAllTime(null != massage ? massage.getAllTime() : 0);
		response.setMassageDetails(massageDetailsMO);
		return response;
	}

}
