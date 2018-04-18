package com.sinco.carnation.resource.web.actions.count;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.count.CountResponse;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.service.RedisCacheService;

/**
 * 统计接口
 * 
 * @author yuleijia
 */
@Controller
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "统计", namespace = "count")
public class CountController extends BasicApiController {

	@Autowired
	private UserService userService;
	@Autowired
	private RedisCacheService redisCacheService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 系统已注册且未被删除的用户
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/count/userRegisterCount", method = RequestMethod.GET)
	@MethodMapping(desc = "系统已注册且未被删除的用户")
	public @ResponseBody
	CountResponse user_Register_Count(HttpServletRequest request, HttpServletResponse response) {
		logger.info("============== 统计注册会员总数 =============");
		String cacheUserRegisterCount = this.redisCacheService.getUserRegisterCount();
		Long countResult = 0l;
		if (cacheUserRegisterCount != null && cacheUserRegisterCount.trim().length() > 0) {
			logger.info("********cacheUserRegisterCount -> " + cacheUserRegisterCount);
			countResult = Long.parseLong(cacheUserRegisterCount);
		} else {
			int second = 300; // 数据缓存2小时
			Boolean isDeleted = false; // 未删除
			countResult = this.userService.countUserRegister(isDeleted);
			this.redisCacheService.setUserRegisterCount(String.valueOf(countResult), second);
		}
		logger.info("<<<<<<<<<<<<<< result1 -> " + countResult);
		CountResponse resp = new CountResponse();
		String result = "succ";
		if (countResult == null) {
			result = "fail";
			countResult = 0l;
		}
		countResult = countResult + 30000; // 原有的数据上加3W
		logger.info("<<<<<<<<<<<<<< result2 -> " + countResult);
		resp.setUserRegisterCount(countResult);
		resp.setResult(result);
		return resp;
	}

}
