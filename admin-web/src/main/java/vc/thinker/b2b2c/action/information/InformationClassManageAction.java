package vc.thinker.b2b2c.action.information;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.cms.service.InformationClassServiceImpl;
import com.sinco.carnation.cms.view.tools.CmsTools;
import com.sinco.carnation.sns.bo.InformationClassBO;
import com.sinco.carnation.sns.model.InformationClass;
import com.sinco.carnation.sns.vo.InformationClassVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: InformationClassManageAction.java
 * </p>
 * 
 * <p>
 * Description:资讯分类管理控制器，用来操作资讯分类信息，资讯分类使用两级管理
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
 * @date 2015-2-6
 * 
 * @version 1.0.1
 */
@Controller
public class InformationClassManageAction {
	@Autowired
	private SysConfigService configService;
	// @Autowired
	// private IUserConfigService userConfigService;
	@Autowired
	private InformationClassServiceImpl informationclassService;
//	@Autowired
//	private InformationServiceImpl informationService;
//	@Autowired
//	private InformationReplyServiceImpl informationReplyService;
	@Autowired
	private CmsTools cmsTools;

	/**
	 * InformationClass列表页
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "资讯分类列表", value = "/admin/information_class_list.htm*", rtype = "admin", rname = "资讯分类", rcode = "information_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/information_class_list.htm")
	public ModelAndView information_class_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, InformationClassVO vo, MyPage<InformationClassBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/information_class_list.html",
				configService.getSysConfig(), 0, request, response);
		vo.setIcPid(new Long(0));
		this.informationclassService.findPageByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		mv.addObject("cmsTools", cmsTools);
		return mv;
	}

	/**
	 * 取得资讯分类子级
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "取得资讯分类子级", value = "/admin/information_class_data.htm*", rtype = "admin", rname = "资讯分类", rcode = "information_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/information_class_data.htm")
	public ModelAndView information_class_data(HttpServletRequest request, HttpServletResponse response,
			Long pid) {
		ModelAndView mv = new JModelAndView("admin/blue/information_class_data.html",
				configService.getSysConfig(), 0, request, response);
		if (pid != null && pid > 0) {
			List<InformationClassBO> list = this.informationclassService.findInforClassByParentId(pid);
			mv.addObject("gcs", list);
		}
		return mv;
	}

	/**
	 * informationclass添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "资讯分类添加", value = "/admin/information_class_add.htm*", rtype = "admin", rname = "资讯分类", rcode = "information_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/information_class_add.htm")
	public ModelAndView information_class_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String pid) {
		ModelAndView mv = new JModelAndView("admin/blue/information_class_add.html",
				configService.getSysConfig(), 0, request, response);

		List<InformationClassBO> informationClasses = this.informationclassService.findAll();
		mv.addObject("informationClasses", informationClasses);
		mv.addObject("id", pid);
		mv.addObject("currentPage", currentPage);

		return mv;
	}

	/**
	 * informationclass编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "资讯分类编辑", value = "/admin/information_class_edit.htm*", rtype = "admin", rname = "资讯分类", rcode = "information_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/information_class_edit.htm")
	public ModelAndView information_class_edit(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/information_class_add.html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && !id.equals("")) {
			InformationClass informationclass = this.informationclassService.getObjById(Long.parseLong(id));
			mv.addObject("obj", informationclass);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
			List<InformationClassBO> informationClasses = this.informationclassService.findAll();
			mv.addObject("informationClasses", informationClasses);
		}
		return mv;
	}

	/**
	 * informationclass保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "资讯分类保存", value = "/admin/information_class_save.htm*", rtype = "admin", rname = "资讯分类", rcode = "information_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/information_class_save.htm")
	public ModelAndView information_class_save(HttpServletRequest request, HttpServletResponse response,
			String list_url, String add_url, InformationClass infoClass) {
		boolean flag = Boolean.FALSE;

		if (infoClass != null) {
			if (infoClass.getIcPid() == null) {
				infoClass.setIcPid(new Long(0));
				infoClass.setLevel(0);
				flag = Boolean.TRUE;
			} else {
				InformationClass ic = this.informationclassService.getObjById(infoClass.getIcPid());
				if (ic != null) {
					if (ic.getLevel() < 2) {
						infoClass.setLevel(ic.getLevel() + 1);
						flag = Boolean.TRUE;
					}
				}
			}

			if (infoClass.getId() == null) { // 新增
				infoClass.setAddTime(new Date());
				flag = flag && this.informationclassService.save(infoClass);
			} else {// 更新
				flag = flag && this.informationclassService.update(infoClass);
			}
		}

		ModelAndView mv = null;
		if (flag) {
			mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "保存资讯分类成功");
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "保存资讯分类失败");
		}
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/information_class_list.htm");
		if (add_url != null) {
			mv.addObject("add_url", CommUtil.getURL(request) + "/admin/information_class_add.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "资讯分类删除", value = "/admin/information_class_del.htm*", rtype = "admin", rname = "资讯分类", rcode = "information_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/information_class_del.htm")
	public String information_class_del(HttpServletRequest request, HttpServletResponse response,
			String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}

		this.informationclassService.delete(idList.toArray(new Long[idList.size()]));

		return "redirect:information_class_list.htm";
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "资讯分类ajax", value = "/admin/information_class_ajax.htm*", rtype = "admin", rname = "资讯分类", rcode = "information_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/information_class_ajax.htm")
	public void information_class_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
		InformationClass obj = this.informationclassService.getObjById(Long.parseLong(id));
		Field[] fields = InformationClass.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(obj);
		Object val = null;
		for (Field field : fields) {
			// System.out.println(field.getName());
			if (field.getName().equals(fieldName)) {
				Class clz = Class.forName("java.lang.String");
				if (field.getType().getName().equals("int")) {
					clz = Class.forName("java.lang.Integer");
				}
				if (field.getType().getName().equals("boolean")) {
					clz = Class.forName("java.lang.Boolean");
				}
				if (!value.equals("")) {
					val = BeanUtils.convertType(value, clz);
				} else {
					val = !CommUtil.null2Boolean(wrapper.getPropertyValue(fieldName));
				}
				wrapper.setPropertyValue(fieldName, val);
			}
		}
		this.informationclassService.update(obj);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(val.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}