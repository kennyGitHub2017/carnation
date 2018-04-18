package vc.thinker.b2b2c.action.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.bo.ConsultBO;
import com.sinco.carnation.shop.service.ConsultService;
import com.sinco.carnation.shop.vo.ConsultVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: ConsultBuyerAction.java
 * </p>
 * 
 * <p>
 * Description: 买家咨询管理器,显示所有买家发布的商品咨询信息及回复信息
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
 * @date 2014-9-29
 * 
 * @version 1.0.1
 */
@Controller
public class ConsultBuyerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ConsultService consultService;
	@Autowired
	private OrderFormTools orderFormTools;

	@SecurityMapping(title = "买家咨询列表", value = "/buyer/consult.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/consult.htm")
	public ModelAndView consult(HttpServletRequest request, HttpServletResponse response, String reply,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_consult.html",
				configService.getSysConfig(), 0, request, response);
		MyPage<ConsultBO> page = new MyPage<>();
		ConsultVO vo = new ConsultVO();
		if (StringUtils.isNotEmpty(reply))
			vo.setReply(CommUtil.null2Boolean(reply));
		vo.setConsultUserId(SecurityUserHolder.getCurrentUserId());
		consultService.selectConsultListByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("reply", CommUtil.null2String(reply));
		mv.addObject("orderFormTools", orderFormTools);
		return mv;
	}
}
