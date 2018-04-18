package com.sinco.carnation.resource.web.actions;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.bo.UserIntegralBO;
import com.sinco.carnation.resource.web.response.register.SearchCustomerResponse;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.UserCustomerService;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "用户支付API", namespace = "paymet")
public class PaymetController extends BasicApiController {

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private Mapper mapper;

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/paymet/password/validate", method = RequestMethod.POST)
	@MethodMapping(desc = "支付密码验证")
	public @ResponseBody
	SearchCustomerResponse paymetPasswordValidate() {
		SearchCustomerResponse response = new SearchCustomerResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		UserCustomerBO customerBO = customerService.searchCustomer(uid);
		if (customerBO != null) {
			UserIntegralBO integral = mapper.map(customerBO, UserIntegralBO.class);
			response.setIntegral(integral);
		}

		return response;
	}
}
