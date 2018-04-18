package com.sinco.carnation.resource.web.actions.aio;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
import com.sinco.carnation.aio.model.AioBinding;
import com.sinco.carnation.aio.service.AioBindingService;
import com.sinco.carnation.resource.bo.aio.AioBindingMO;
import com.sinco.carnation.resource.constant.ResultCodeConstant;
import com.sinco.carnation.resource.constant.ResultMsgConstant;
import com.sinco.carnation.resource.vo.aio.AioBindingVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.aio.AioBindingInfoResponse;
import com.sinco.carnation.resource.web.response.aio.AioBindingResponse;
import com.sinco.carnation.resource.web.util.IdcardValidator;
import com.sinco.carnation.user.service.RedisCacheService;

/**
 * 健康一体机绑定
 * 
 * @author yuanmin.feng
 */
@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "健康一体机绑定", namespace = "aioBinding")
public class AioBindingAction extends BasicApiController {

	@Autowired
	private AioBindingService aioService;

	@Autowired
	private Mapper mapper;

	@Autowired
	private RedisCacheService redisCacheService;

	/**
	 * 判断一体机是否绑定
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/aio/is/binding", method = RequestMethod.POST)
	@MethodMapping(desc = "判断一体机是否绑定")
	@ResponseBody
	public AioBindingResponse isBinding(HttpServletRequest request) {

		AioBindingResponse response = new AioBindingResponse();
		// 获取当前用户ID
		Long uid = ActionsUtil.getOwnerUid();
//		Long uid = (long) 16337;
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioService.getAioBindingByUid(uid);
		response.setResult(null != aioBinding ? true : false);
		response.setUpdateNum(null != aioBinding ? aioBinding.getUpdateNum() : 0);
		return response;
	}

	/**
	 * 获取绑定信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/aio/get/binding/info", method = RequestMethod.POST)
	@MethodMapping(desc = "获取绑定信息")
	@ResponseBody
	public AioBindingInfoResponse getBindingInfo(HttpServletRequest request) {

		AioBindingInfoResponse response = new AioBindingInfoResponse();
		// 获取当前用户ID
		Long uid = ActionsUtil.getOwnerUid();
//		Long uid = (long) 16337;
		// 根据用户ID查询一体机绑定信息
		AioBinding aioBinding = aioService.getAioBindingByUid(uid);
		if (null == aioBinding) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.NOT_BINDING_DATA);
			response.setM_errorMsg(ResultMsgConstant.NOT_BINDING_DATA);
			return response;
		}
		AioBindingMO aioBindingInfo = mapper.map(aioBinding, AioBindingMO.class);
		response.setAioBindingInfo(aioBindingInfo);
		return response;
	}

	/**
	 * 添加或修改一体机绑定信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/aio/save/binding", method = RequestMethod.POST)
	@MethodMapping(desc = "添加或修改一体机绑定信息")
	@ResponseBody
	public AioBindingResponse saveBinding(HttpServletRequest request, AioBindingVO aioBindingVO) {

		AioBindingResponse response = new AioBindingResponse();
		// 获取当前用户ID
		Long uid = ActionsUtil.getOwnerUid();
//		Long uid = (long) 16342;

		String snsCode = redisCacheService.getSmsCode(uid, aioBindingVO.getMobile());
		if (StringUtils.isBlank(snsCode)) {// 未发送验证码或者验证码已过期
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.VERIFICATION_CODE_ERROR);
			response.setM_errorMsg(ResultMsgConstant.VERIFICATION_CODE_ERROR);
			return response;
		}
		if (!snsCode.equals(aioBindingVO.getCode())) {// 验证码不对
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.VERIFICATION_CODE_ERROR);
			response.setM_errorMsg(ResultMsgConstant.VERIFICATION_CODE_ERROR);
			return response;
		}
		// 校验身份证
		if (!IdcardValidator.isValidatedAllIdcard(aioBindingVO.getIdCard())) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.ID_CARD_ERROR);
			response.setM_errorMsg(ResultMsgConstant.ID_CARD_ERROR);
			return response;
		}

		// 封装绑定信息数据
		AioBinding aioBinding = new AioBinding();
		aioBinding.setUid(uid);
		aioBinding.setIdCard(aioBindingVO.getIdCard());
		aioBinding.setDeleteStatus(0);
		aioBinding.setCreateTime(CommUtil.formatLongDate(new Date()));
		aioBinding.setLastUpdateTime(CommUtil.formatLongDate(new Date()));

		// 保存或修改绑定信息
		int result = aioService.saveAioBinding(aioBinding);
		// 参数异常
		if (result == 101) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.PARAMETER_ERROR);
			response.setM_errorMsg(ResultMsgConstant.PARAMETER_ERROR);
			return response;
		}
		if (result == 102) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.EXCESS_UPDATE_NUM);
			response.setM_errorMsg(ResultMsgConstant.EXCESS_UPDATE_NUM);
			return response;
		}
		response.setUpdateNum(result);
		response.setResult(true);
		return response;
	}
}
