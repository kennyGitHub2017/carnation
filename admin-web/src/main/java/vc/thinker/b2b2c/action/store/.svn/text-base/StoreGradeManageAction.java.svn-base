package vc.thinker.b2b2c.action.store;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

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

import com.google.common.collect.Lists;
import com.sinco.carnation.store.bo.StoreGradeBO;
import com.sinco.carnation.store.model.StoreGrade;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreGradeVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: StoreGradeManageAction.java
 * </p>
 * 
 * <p>
 * Description:店铺类型管理控制器，用来管理商城店铺类型信息
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
 * @date 2014-10-16
 * 
 * @version 1.0.1
 */
@Controller
public class StoreGradeManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private StoreGradeService storegradeService;
	@Autowired
	private StoreService storeService;

	/**
	 * StoreGrade列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "店铺类型列表", value = "/admin/storegrade_list.htm*", rtype = "admin", rname = "店铺类型", rcode = "store_grade", rgroup = "商户管理")
	@RequestMapping("/admin/storegrade_list.htm")
	public ModelAndView storegrade_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<StoreGradeBO> page, StoreGradeVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/storegrade_list.html", configService.getSysConfig(),
				0, request, response);

		this.storegradeService.findPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		mv.addObject("vo", vo);

		return mv;
	}

	/**
	 * storegrade添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "店铺类型添加", value = "/admin/storegrade_add.htm*", rtype = "admin", rname = "店铺类型", rcode = "store_grade", rgroup = "商户管理")
	@RequestMapping("/admin/storegrade_add.htm")
	public ModelAndView storegrade_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/store_grade_add.html", configService.getSysConfig(),
		/* this.userConfigService.getUserConfig(), */0, request, response);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * storegrade编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "店铺类型编辑", value = "/admin/storegrade_edit.htm*", rtype = "admin", rname = "店铺类型", rcode = "store_grade", rgroup = "商户管理")
	@RequestMapping("/admin/storegrade_edit.htm")
	public ModelAndView storegrade_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/store_grade_add.html", configService.getSysConfig(),
		/* this.userConfigService.getUserConfig(), */0, request, response);
		if (id != null && !id.equals("")) {
			StoreGrade storegrade = this.storegradeService.getObjById(CommUtil.null2Long(id));
			mv.addObject("obj", storegrade);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * storegrade保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "店铺类型保存", value = "/admin/storegrade_save.htm*", rtype = "admin", rname = "店铺类型", rcode = "store_grade", rgroup = "商户管理")
	@RequestMapping("/admin/storegrade_save.htm")
	public ModelAndView storegrade_save(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String list_url, String add_url, StoreGrade storeGrade) {
		if (storeGrade != null) {

			if (storeGrade.getGoodsAudit() == null)
				storeGrade.setGoodsAudit(0);

			if (storeGrade.getId() != null && storeGrade.getId() > 0) {
				// 更新
				this.storegradeService.update(storeGrade);
			} else {
				// 新增
				storeGrade.setAddTime(new Date());
				storeGrade.setSysGrade(Boolean.FALSE);
				this.storegradeService.save(storeGrade);
			}
		}

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存店铺类型成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?currentPage=" + currentPage);
		}
		return mv;
	}

	@SecurityMapping(title = "店铺类型删除", value = "/admin/storegrade_del.htm*", rtype = "admin", rname = "店铺类型", rcode = "store_grade", rgroup = "商户管理")
	@RequestMapping("/admin/storegrade_del.htm")
	public String storegrade_del(HttpServletRequest request, String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");
		List<Long> idsList = Lists.newArrayList();
		for (String id : ids) {
			if (StringUtils.isNotBlank(id)) {
				idsList.add(CommUtil.null2Long(id));
			}
		}
		this.storegradeService.batchDelete(idsList);
		return "redirect:storegrade_list.htm?currentPage=" + currentPage;
	}

//	@SecurityMapping(title = "店铺类型AJAX更新", value = "/admin/storegrade_ajax.htm*", rtype = "admin", rname = "店铺类型", rcode = "store_grade", rgroup = "店铺")
//	@RequestMapping("/admin/storegrade_ajax.htm")
//	public void storegrade_ajax(HttpServletRequest request,
//			HttpServletResponse response, String id, String fieldName,
//			String value) throws ClassNotFoundException {
//		StoreGrade obj = this.storegradeService.getObjById(Long.parseLong(id));
//		Field[] fields = StoreGrade.class.getDeclaredFields();
//		BeanWrapper wrapper = new BeanWrapper(obj);
//		Object val = null;
//		for (Field field : fields) {
//			if (field.getName().equals(fieldName)) {
//				Class clz = Class.forName("java.lang.String");
//				if (field.getType().getName().equals("int")) {
//					clz = Class.forName("java.lang.Integer");
//				}
//				if (field.getType().getName().equals("boolean")) {
//					clz = Class.forName("java.lang.Boolean");
//				}
//				if (!value.equals("")) {
//					val = BeanUtils.convertType(value, clz);
//				} else {
//					val = !CommUtil.null2Boolean(wrapper
//							.getPropertyValue(fieldName));
//				}
//				wrapper.setPropertyValue(fieldName, val);
//			}
//		}
//		this.storegradeService.update(obj);
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(val.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	@SecurityMapping(title = "店铺类型模板设置", value = "/admin/storegrade_template.htm*", rtype = "admin", rname = "店铺类型", rcode = "store_grade", rgroup = "店铺")
//	@RequestMapping("/admin/storegrade_template.htm")
//	public ModelAndView storegrade_template(HttpServletRequest request,
//			HttpServletResponse response, String id) {
//		ModelAndView mv = new JModelAndView(
//				"admin/blue/store_grade_template.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		mv.addObject("path", request.getSession().getServletContext().getRealPath("/"));
//		mv.addObject("obj",
//				this.storegradeService.getObjById(Long.parseLong(id)));
//		mv.addObject("separator", File.separator);
//		return mv;
//	}
//
//	@SecurityMapping(title = "店铺类型模板保存", value = "/admin/storegrade_template_save.htm*", rtype = "admin", rname = "店铺类型", rcode = "store_grade", rgroup = "店铺")
//	@RequestMapping("/admin/storegrade_template_save.htm")
//	public ModelAndView storegrade_template_save(HttpServletRequest request,
//			HttpServletResponse response, String list_url, String id,
//			String templates) {
//		ModelAndView mv = new JModelAndView("admin/blue/success.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		StoreGrade grade = this.storegradeService
//				.getObjById(Long.parseLong(id));
//		grade.setTemplates(templates);
//		this.storegradeService.update(grade);
//		mv.addObject("list_url", list_url);
//		mv.addObject("op_title", "保存店铺类型模板成功");
//		return mv;
//	}
}