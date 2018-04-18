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
import com.sinco.carnation.massage.service.MassageService;
import com.sinco.carnation.resource.bo.massage.MassageMO;
import com.sinco.carnation.resource.constant.ResultCodeConstant;
import com.sinco.carnation.resource.constant.ResultMsgConstant;
import com.sinco.carnation.resource.vo.massage.MassageVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.massage.MassageResponse;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "按摩", namespace = "massage")
public class MassageAction extends BasicApiController {

	@Autowired
	private MassageService massageService;

	@Autowired
	private Mapper mapper;

	@RequestMapping(value = "/massage/data/upload", method = RequestMethod.POST)
	@MethodMapping(desc = "上传按摩数据")
	@ResponseBody
	public MassageResponse uploadMassageData(MassageVO massageVO, HttpServletRequest request) {
		MassageResponse response = new MassageResponse();
		Long userId = ActionsUtil.getOwnerUid();
//		Long userId = (long) 15869;
		// 校验用户ID不为空
		if (!CommUtil.isNotNull(userId)) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.USER_ID_NOT_NULL);
			response.setM_errorMsg(ResultMsgConstant.USER_ID_NOT_NULL);
			return response;
		}
		if (null == massageVO.getAdviceTime() && null == massageVO.getAllTime()) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.PARAMETER_ERROR);
			response.setM_errorMsg(ResultMsgConstant.PARAMETER_ERROR);
			return response;
		}
		Massage massage = new Massage();
		massage.setAdviceTime(massageVO.getAdviceTime());
		massage.setAllTime(massageVO.getAllTime());
		// 上传按摩数据
		Massage result = massageService.uploadMassage(massage, userId);

		// 返回保存数据
		MassageMO messageMO = mapper.map(result, MassageMO.class);
		response.setMassage(messageMO);
		return response;
	}

	@RequestMapping(value = "/get/massage/data", method = RequestMethod.POST)
	@MethodMapping(desc = "获取按摩数据")
	@ResponseBody
	public MassageResponse getMassageData(HttpServletRequest request) {
		MassageResponse response = new MassageResponse();
		Long userId = ActionsUtil.getOwnerUid();
//		Long userId = (long) 15869;
		// 校验用户ID不为空
		if (!CommUtil.isNotNull(userId)) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.USER_ID_NOT_NULL);
			response.setM_errorMsg(ResultMsgConstant.USER_ID_NOT_NULL);
			return response;
		}
		// 根据用户ID获取按摩数据
		Massage massage = massageService.getByUserId(userId);

		// 返回保存数据
		MassageMO messageMO = new MassageMO();
		if (null != massage) {
			messageMO = mapper.map(massage, MassageMO.class);
		}
		response.setMassage(messageMO);
		return response;
	}

}
