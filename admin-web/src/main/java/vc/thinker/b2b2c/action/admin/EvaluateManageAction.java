package vc.thinker.b2b2c.action.admin;

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
import com.sinco.carnation.evaluate.tools.EvaluateViewTools;
import com.sinco.carnation.shop.bo.EvaluateBO;
import com.sinco.carnation.shop.model.Evaluate;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: EvaluateManageAction.java
 * </p>
 * 
 * <p>
 * Description: 系统商品评价管理类
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
 * @date 2014年5月27日
 * 
 * @version 1.0
 */
@Controller
public class EvaluateManageAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private UserService userService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private EvaluateViewTools evaluateViewTools;

	@SecurityMapping(title = "商品评价列表", value = "/admin/evaluate_list.htm*", rtype = "admin", rname = "商品评价", rcode = "evaluate_admin", rgroup = "商城管理")
	@RequestMapping("/admin/evaluate_list.htm")
	public ModelAndView evaluate_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String nickName, String goodsName, MyPage<EvaluateBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/evaluate_list.html", configService.getSysConfig(), 0,
				request, response);
		page.setPageSize(20);
		evaluateService.queryEvaluateList(nickName, goodsName, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("objs", page.getContent());
		mv.addObject("nickName", nickName);
		mv.addObject("goodsName", goodsName);
		return mv;
	}

	@SecurityMapping(title = "商品评价编辑", value = "/admin/evaluate_edit.htm*", rtype = "admin", rname = "商品评价", rcode = "evaluate_admin", rgroup = "商城管理")
	@RequestMapping("/admin/evaluate_edit.htm")
	public ModelAndView evaluate_edit(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/evaluate_edit.html", configService.getSysConfig(), 0,
				request, response);

		if (StringUtils.isNotBlank(id)) {
			EvaluateBO evaluate = evaluateService.queryEvaluateById(CommUtil.null2Long(id));
			mv.addObject("obj", evaluate);
			mv.addObject("evaluateViewTools", evaluateViewTools);
		}
		return mv;
	}

	@SecurityMapping(title = "商品评价编辑", value = "/admin/evaluate_save.htm*", rtype = "admin", rname = "商品评价", rcode = "evaluate_admin", rgroup = "商城管理")
	@RequestMapping("/admin/evaluate_save.htm")
	public ModelAndView evaluate_save(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id, String evaluateStatus, String evaluateAdminInfo, String list_url,
			String edit) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		Evaluate obj = evaluateService.findOne(CommUtil.null2Long(id));
		obj.setEvaluateAdminInfo(evaluateAdminInfo);
		obj.setEvaluateStatus(CommUtil.null2Int(evaluateStatus));
		evaluateService.update(obj);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "商品评价编辑成功");
		return mv;
	}

	@SecurityMapping(title = "商品评价删除", value = "/admin/evaluate_del.htm*", rtype = "admin", rname = "商品评价", rcode = "evaluate_admin", rgroup = "商城管理")
	@RequestMapping("/admin/evaluate_del.htm")
	public String evaluate_del(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String[] ids = mulitId.split(",");
		if (ids != null && ids.length > 0) {
			if (ids.length == 1) {
				evaluateService.changDelStatus(CommUtil.null2Long(ids[0]));
			} else {
				// 暂不支持批量删除
			}
		}
		return "redirect:evaluate_list.htm";
	}
}
