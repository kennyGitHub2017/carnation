package vc.thinker.b2b2c.action.o2o;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;

import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.rebate.service.RebateService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.RebateRecordBO;
import com.sinco.carnation.user.service.UserRelationService;

/**
 * 
 * <p>
 * Title: GroupStatSellerAction.java
 * </p>
 * 
 * <p>
 * Description: 商家中心服务统计控制器
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
public class GroupStatSellerAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private GroupOrderService groupOrderService;

	@Autowired
	private RebateService rebateService;

	@Autowired
	private UserRelationService userRelationService;

	@SecurityMapping(title = "服务统计", value = "/seller/stat_group.htm*", rtype = "seller", rname = "服务统计", rcode = "seller_stat_group", rgroup = "商铺统计")
	@RequestMapping("/seller/stat_group.htm")
	public ModelAndView stat_group(HttpServletRequest request, HttpServletResponse response,
			String startDate, String endDate) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/stat_group.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		// 订单成交金额
		BigDecimal of_totalPrice = groupOrderService.queryOrderPriceByDate(userDetails.getStoreId(),
				startDate, endDate);
		mv.addObject("of_totalPrice", of_totalPrice == null ? 0 : of_totalPrice);
		// 订单成交总数
		int of_totalCount = groupOrderService.queryOrderCountByDate(userDetails.getStoreId(), startDate,
				endDate);
		mv.addObject("of_totalCount", of_totalCount);

		// 总的反润金额
		RebateRecordBO bo = rebateService.queryrebatesum(userDetails.getId(), startDate, endDate);
		mv.addObject("of_totalRebate", bo == null ? 0 : bo.getTotalRebateAmout());

		// 推荐会员数
		int reUser = userRelationService.queryRefereeUserCount(userDetails.getId(), startDate, endDate);
		mv.addObject("reUser", reUser);

		// 推荐商户数
		int reSeller = userRelationService.queryRefereeSellerCount(userDetails.getId(), startDate, endDate);
		mv.addObject("reSeller", reSeller);

		mv.addObject("startDate", startDate);
		mv.addObject("endDate", endDate);
		return mv;
	}

}
