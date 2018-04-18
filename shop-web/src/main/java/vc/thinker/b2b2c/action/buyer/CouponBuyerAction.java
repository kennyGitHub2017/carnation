package vc.thinker.b2b2c.action.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.service.CouponInfoService;
import com.sinco.carnation.operation.vo.CouponInfoMyVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: CouponBuyerAction.java
 * </p>
 * 
 * <p>
 * Description:买家优惠券管理控制器，商场管理员赠送给买家优惠券后，买家可以在这里查看优惠券信息
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
 * @date 2015-3-16
 * 
 * @version 1.0.1
 */
@Controller
public class CouponBuyerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private CouponInfoService couponInfoService;

	@SecurityMapping(title = "买家优惠券列表", value = "/buyer/coupon.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/coupon.htm")
	public ModelAndView coupon(HttpServletRequest request, HttpServletResponse response, String reply,
			MyPage<CouponInfoBO> page) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_coupon.html",
				configService.getSysConfig(), 0, request, response);
//		CouponInfoQueryObject qo = new CouponInfoQueryObject(currentPage, mv, "addTime", "desc");
//		qo.addQuery("obj.user.id", new SysMap("user_id", SecurityUserHolder.getCurrentUser().getId()), "=");
//		IPageList pList = this.couponInfoService.list(qo);
		CouponInfoMyVO vo = new CouponInfoMyVO();
//		vo.setStatus(OperationConstants.COUPON_INFO_STATUS_0);
		vo.setUid(SecurityUserHolder.getCurrentUserId());
		couponInfoService.findMyCoupon(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}
}
