package vc.thinker.b2b2c.action.seller;

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
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.bo.EvaluateBO;
import com.sinco.carnation.shop.model.Evaluate;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.vo.EvaluateVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.tools.ImageTools;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: EvaluateSellerAction.java
 * </p>
 * 
 * <p>
 * Description: 卖家评价管理控制器，
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
 * @date 2014-12-3
 * 
 * @version 1.0.1
 */
@Controller
public class EvaluateSellerAction {
	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private IUserConfigService userConfigService;
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private OrderFormService orderFormService;
//	@Autowired
//	private IUserService userService;
	@Autowired
	private ImageTools imageTools;

//	
	@SecurityMapping(title = "商品评价列表", value = "/seller/evaluate_list.htm*", rtype = "seller", rname = "评价管理", rcode = "evaluate_seller", rgroup = "客户服务")
	@RequestMapping("/seller/evaluate_list.htm")
	public ModelAndView evaluate_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<EvaluateBO> page, String status) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/evaluate_list.html",
				configService.getSysConfig(), 0, request, response);
		EvaluateVO vo = new EvaluateVO();
		// 获取商户的商铺
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		vo.setStoreId(userDetails.getStoreId());
		if ("yes".equals(status)) {
			vo.setReplyStatus(1);
		}
		if ("no".equals(status)) {
			vo.setReplyStatus(0);
		}
		evaluateService.findListByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("status", status);
		return mv;
	}

	@SecurityMapping(title = "商品评价内容", value = "/seller/evaluate_info.htm*", rtype = "seller", rname = "评价管理", rcode = "evaluate_seller", rgroup = "客户服务")
	@RequestMapping("/seller/evaluate_info.htm")
	public ModelAndView evaluate_info(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/evaluate_info.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		EvaluateBO evl = this.evaluateService.queryEvaluateById(CommUtil.null2Long(id));
		if (evl != null) {
			OrderForm of = orderFormService.getObjById(evl.getOfId());
			if (of != null && of.getStoreId() != null && userDetails.getStoreId() != null
					&& of.getStoreId().equals(userDetails.getStoreId().toString())) {
				mv.addObject("evl", evl);
				mv.addObject("imageTools", imageTools);
			} else {
				mv.addObject("ret", 0);
			}
		} else {
			mv.addObject("ret", 0);
		}
		return mv;
	}

	@SecurityMapping(title = "商品评价回复内容", value = "/seller/evaluate_reply.htm*", rtype = "seller", rname = "评价管理", rcode = "evaluate_seller", rgroup = "客户服务")
	@RequestMapping("/seller/evaluate_reply.htm")
	public ModelAndView evaluate_reply(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/evaluate_reply.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Evaluate evl = this.evaluateService.findOne(CommUtil.null2Long(id));
		if (evl != null) {
			OrderForm of = orderFormService.getObjById(evl.getOfId());
			if (of != null && of.getStoreId() != null && userDetails.getStoreId() != null
					&& of.getStoreId().equals(userDetails.getStoreId().toString())) {
				mv.addObject("evl", evl);
			} else {
				mv.addObject("ret", 0);
			}
		} else {
			mv.addObject("ret", 0);
		}
		mv.addObject("id", id);
		return mv;
	}

	@SecurityMapping(title = "商品评价回复保存", value = "/seller/evaluate_reply_save.htm*", rtype = "seller", rname = "评价管理", rcode = "evaluate_seller", rgroup = "客户服务")
	@RequestMapping("/seller/evaluate_reply_save.htm")
	public void evaluate_reply_save(HttpServletRequest request, HttpServletResponse response, String id,
			String reply) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Evaluate evl = this.evaluateService.findOne(CommUtil.null2Long(id));
		if (evl != null) {
			OrderForm of = orderFormService.getObjById(evl.getOfId());
			if (of != null && of.getStoreId() != null && userDetails.getStoreId() != null
					&& of.getStoreId().equals(userDetails.getStoreId().toString())) {
				evl.setReply(CommUtil.filterHTML(reply));
				evl.setReplyStatus(1);
				this.evaluateService.update(evl);
			}
		}
	}
}
