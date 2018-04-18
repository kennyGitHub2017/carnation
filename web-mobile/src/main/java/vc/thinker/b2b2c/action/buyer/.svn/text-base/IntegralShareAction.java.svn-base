package vc.thinker.b2b2c.action.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.service.IntegralService;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;

/**
 * 
 * <p>
 * Title: GroupStatSellerAction.java
 * </p>
 * 
 * <p>
 * Description: 用户分享赠送积分控制器
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-12-30
 */
@Controller
public class IntegralShareAction {
	@Autowired
	private IntegralService integralService;

	@SecurityMapping(title = "分享赠送积分", value = "/buyer/share_addIntegral.htm*", rtype = "buyer", rname = "分享积分", rcode = " integral_share", rgroup = "积分")
	@RequestMapping("/buyer/share_addIntegral.htm")
	public void share_addIntegral(HttpServletRequest request, HttpServletResponse response) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (userDetails != null) {
			// 赠送积分
			integralService.addIntegral(IntegralConstants.INTEGRAL_SHARE, userDetails.getId(), null);
		}
	}
}
