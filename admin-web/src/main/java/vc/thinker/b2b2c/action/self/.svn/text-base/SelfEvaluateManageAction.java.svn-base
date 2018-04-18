package vc.thinker.b2b2c.action.self;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.shop.bo.EvaluateBO;
import com.sinco.carnation.shop.model.Evaluate;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.tools.ImageTools;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: SelfEvaluateManageAction.java
 * </p>
 * 
 * <p>
 * Description: 平台评价回复控制器。
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
public class SelfEvaluateManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private EvaluateService evaluateService;

	@Autowired
	private ImageTools imageTools;

	@SecurityMapping(title = "商品评价列表", value = "/admin/self_evaluate_list.htm*", rtype = "admin", rname = "评价管理", rcode = "self_evaluate_admin", rgroup = "商城管理")
	@RequestMapping("/admin/self_evaluate_list.htm")
	public ModelAndView self_evaluate_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String status, MyPage<EvaluateBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/self_evaluate_list.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(20);
		if (StringUtils.isNotBlank(status))
			evaluateService.queryEvaluateGoods(CommUtil.null2Int(status), GoodsConstants.GOODS_TYPE_SELF,
					page);
		else
			evaluateService.queryEvaluateGoods(null, GoodsConstants.GOODS_TYPE_SELF, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("objs", page.getContent());
		mv.addObject("status", status);
		return mv;
	}

	@SecurityMapping(title = "商品评价内容", value = "/admin/self_evaluate_info.htm*", rtype = "admin", rname = "评价管理", rcode = "self_evaluate_admin", rgroup = "商城管理")
	@RequestMapping("/admin/self_evaluate_info.htm")
	public ModelAndView self_evaluate_info(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/self_evaluate_info.html",
				configService.getSysConfig(), 0, request, response);
		EvaluateBO evl = evaluateService.queryEvaluateById(CommUtil.null2Long(id));
		mv.addObject("evl", evl);
		mv.addObject("imageTools", imageTools);
		return mv;
	}

	@SecurityMapping(title = "商品评价内容", value = "/admin/self_evaluate_reply.htm*", rtype = "admin", rname = "评价管理", rcode = "self_evaluate_admin", rgroup = "商城管理")
	@RequestMapping("/admin/self_evaluate_reply.htm")
	public ModelAndView evaluate_reply(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/self_evaluate_reply.html",
				configService.getSysConfig(), 0, request, response);
		EvaluateBO evl = evaluateService.queryEvaluateById(CommUtil.null2Long(id));
		mv.addObject("evl", evl);
		mv.addObject("id", id);
		return mv;
	}

	@SecurityMapping(title = "商品评价内容", value = "/admin/self_evaluate_reply_save.htm*", rtype = "admin", rname = "评价管理", rcode = "self_evaluate_admin", rgroup = "商城管理")
	@RequestMapping("/admin/self_evaluate_reply_save.htm")
	public void evaluate_reply_save(HttpServletRequest request, HttpServletResponse response, String id,
			String reply) {
		Evaluate evl = evaluateService.queryEvaluateId(CommUtil.null2Long(id));
		if (evl != null) {
			evl.setReply(CommUtil.filterHTML(reply));
			evl.setReplyStatus(1);
			evaluateService.update(evl);
		}
	}

	@SecurityMapping(title = "商品评价删除", value = "/admin/self_evaluate_del.htm*", rtype = "admin", rname = "评价管理", rcode = "self_evaluate_admin", rgroup = "商城管理")
	@RequestMapping("/admin/self_evaluate_del.htm")
	public ModelAndView self_evaluate_del(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		if (StringUtils.isNotBlank(id)) {
			evaluateService.changDelStatus(CommUtil.null2Long(id));
		}
		mv.addObject("op_title", "评论删除成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_evaluate_list.htm");
		return mv;
	}
}
