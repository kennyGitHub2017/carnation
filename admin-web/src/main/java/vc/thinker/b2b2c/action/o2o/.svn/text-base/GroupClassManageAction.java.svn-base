package vc.thinker.b2b2c.action.o2o;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
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
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GroupClassManageAction.java
 * </p>
 * 
 * <p>
 * Description: 团购分类管理
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
 * @version 1.0.1
 */
@Controller
public class GroupClassManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GroupClassService groupclassService;
	@Autowired
	private GroupGoodsService groupgoodsService;

	/**
	 * GroupClass列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "服务分类列表", value = "/admin/group_class_list.htm*", rtype = "admin", rname = "服务分类", rcode = "admin_group_class", rgroup = "商户管理")
	@RequestMapping("/admin/group_class_list.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupClassBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/group_class_list.html", configService.getSysConfig(),
				0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(10);
		this.groupclassService.findParentIsNullPage(page);
		CommUtil.saveIPageList2ModelAndView(url + "/admin/blue/group_class_list.html", "", "", page, mv);
		mv.addObject("type", "life");
		return mv;
	}

	/**
	 * groupclass添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "服务分类增加", value = "/admin/group_class_add.htm*", rtype = "admin", rname = "服务分类", rcode = "admin_group_class", rgroup = "商户管理")
	@RequestMapping("/admin/group_class_add.htm")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response, String currentPage,
			String pid, String type) {
		ModelAndView mv = new JModelAndView("admin/blue/group_class_add.html", configService.getSysConfig(),
				0, request, response);
		List<GroupClassBO> gcs = this.groupclassService.findCacheLevelAll();
		GroupClass parent = this.groupclassService.getObjById(CommUtil.null2Long(pid));
		GroupClass obj = new GroupClass();
		obj.setDisplay(true);
		if (null != parent) {
			obj.setParentId(parent.getId());
		}
		mv.addObject("obj", obj);
		mv.addObject("gcs", gcs);
		mv.addObject("currentPage", currentPage);
		mv.addObject("type", type);
		return mv;
	}

	/**
	 * groupclass编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "服务分类编辑", value = "/admin/group_class_edit.htm*", rtype = "admin", rname = "服务分类", rcode = "admin_group_class", rgroup = "商户管理")
	@RequestMapping("/admin/group_class_edit.htm")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/group_class_add.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && !id.equals("")) {
			GroupClass groupclass = this.groupclassService.getObjById(Long.parseLong(id));
			List<GroupClassBO> gcs = this.groupclassService.findCacheLevelAll();
			mv.addObject("gcs", gcs);
			mv.addObject("obj", groupclass);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * groupclass保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "服务分类保存", value = "/admin/group_class_save.htm*", rtype = "admin", rname = "服务分类", rcode = "admin_group_class", rgroup = "商户管理")
	@RequestMapping("/admin/group_class_save.htm")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String cmd, String pid, String gc_type) {
		WebForm wf = new WebForm();
		GroupClass groupclass = null;
		if ("".equals(id)) {
			groupclass = wf.toPo(request, GroupClass.class);
			groupclass.setAddTime(new Date());
		} else {
			GroupClass obj = this.groupclassService.getObjById(Long.parseLong(id));
			groupclass = (GroupClass) wf.toPo(request, obj);
		}
		GroupClass parent = this.groupclassService.getObjById(CommUtil.null2Long(pid));
		if (parent != null) {
			groupclass.setParentId(parent.getId());
			groupclass.setGcLevel(parent.getGcLevel() + 1);
		}
		groupclass.setGcType(CommUtil.null2Int(gc_type));
		if ("".equals(id)) {
			this.groupclassService.save(groupclass, request);
		} else
			this.groupclassService.update(groupclass, request);
		String params = "goods";
		if (gc_type.equals("1")) {
			params = "life";
		}
		// 刷新缓存
		groupclassService.refreshDicCache();
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/group_class_list.htm?type=" + params);
		mv.addObject("op_title", "保存服务分类成功");
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/group_class_add.htm" + "?currentPage="
				+ currentPage + "&type=" + params);
		return mv;
	}

	@SecurityMapping(title = "服务分类删除", value = "/admin/group_class_del.htm*", rtype = "admin", rname = "服务分类", rcode = "admin_group_class", rgroup = "商户管理")
	@RequestMapping("/admin/group_class_del.htm")
	public String delete(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage, String type) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!"".equals(id)) {
				// 分类
				GroupClass groupclass = this.groupclassService.getObjById(Long.parseLong(id));
				// 子分类
				List<GroupClassBO> gcs = this.groupclassService.findByParent(Long.parseLong(id));
				// 逻辑删除分类
				groupclass.setDeleteStatus(true);
				this.groupclassService.update(groupclass);
				// 逻辑删除子分类
				if (null != gcs && gcs.size() > 0) {
					for (GroupClassBO bo : gcs) {
						bo.setDeleteStatus(true);
						this.groupclassService.update(bo);
					}
				}
			}
		}
		// 刷新缓存
		groupclassService.refreshDicCache();
		String params = "goods";
		if (type.equals("1")) {
			params = "life";
		}
		return "redirect:group_class_list.htm?type=" + params + "&currentPage=" + currentPage;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "服务分类Ajax更新", value = "/admin/group_class_ajax.htm*", rtype = "admin", rname = "服务分类", rcode = "admin_group_class", rgroup = "商户管理")
	@RequestMapping("/admin/group_class_ajax.htm")
	public void ajax(HttpServletRequest request, HttpServletResponse response, String id, String fieldName,
			String value) throws ClassNotFoundException {
		GroupClass obj = this.groupclassService.getObjById(Long.parseLong(id));
		Field[] fields = GroupClass.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(obj);
		Object val = null;
		for (Field field : fields) {
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
		this.groupclassService.update(obj);
		// 刷新缓存
		groupclassService.refreshDicCache();
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(val.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SecurityMapping(title = "服务分类下级加载", value = "/admin/group_class_data.htm*", rtype = "admin", rname = "服务分类", rcode = "admin_group_class", rgroup = "商户管理")
	@RequestMapping("/admin/group_class_data.htm")
	public ModelAndView group_class_data(HttpServletRequest request, HttpServletResponse response,
			String pid, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/group_class_data.html", configService.getSysConfig(),
				0, request, response);
		List<GroupClassBO> gcs = this.groupclassService.findByParent(Long.parseLong(pid));
		if (null != gcs && gcs.size() > 0) {
			for (GroupClassBO bo : gcs) {
				GroupClassBO parent = (GroupClassBO) this.groupclassService.getObjById(bo.getParentId());
				bo.setParent(parent);
			}
		}
		mv.addObject("gcs", gcs);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@RequestMapping("/admin/group_class_verify.htm")
	public void group_class_verify(HttpServletRequest request, HttpServletResponse response, String gcName,
			String id, String pid) {
		boolean ret = true;
		int count = groupclassService.countByName(gcName, StringUtils.isNotBlank(id) ? Long.parseLong(id)
				: null, StringUtils.isNotBlank(pid) ? Long.parseLong(pid) : null);
		if (count > 0) {
			ret = false;
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}