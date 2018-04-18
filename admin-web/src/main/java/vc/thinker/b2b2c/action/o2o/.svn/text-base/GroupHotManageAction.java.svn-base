package vc.thinker.b2b2c.action.o2o;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
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

import com.sinco.carnation.sys.bo.AreaBO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GroupHotManageAction.java
 * </p>
 * 
 * <p>
 * Description: 服务热门城市管理
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
 * @date 2015年9月11日
 * 
 * @version 1.0.1
 */
@Controller
public class GroupHotManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private AreaServiceImpl areaServiceImpl;

	/**
	 * GroupHot列表页
	 * 
	 * @param currentPage
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "热门城市列表", value = "/admin/group_hot_list.htm*", rtype = "admin", rname = "热门城市管理", rcode = "group_hot_admin", rgroup = "商户管理")
	@RequestMapping("/admin/group_hot_list.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, MyPage<AreaBO> page,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/group_hot_list.html", configService.getSysConfig(),
				0, request, response);
		if (!StringUtils.isNotEmpty(currentPage)) {
			page.setCurrentPage(1);
		}
		page.setPageSize(10);
		this.areaServiceImpl.findGroupHotCityByPage(page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	/**
	 * grouphot添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "热门城市增加", value = "/admin/group_hot_add.htm*", rtype = "admin", rname = "热门城市管理", rcode = "group_hot_admin", rgroup = "商户管理")
	@RequestMapping("/admin/group_hot_add.htm")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/group_hot_add.html", configService.getSysConfig(), 0,
				request, response);
		// 省份列表
		List<Area> provinces = this.areaServiceImpl.getAllParentIsNull();
		mv.addObject("provinces", provinces);
		return mv;
	}

	/**
	 * grouphot保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "热门城市保存", value = "/admin/group_hot_save.htm*", rtype = "admin", rname = "热门城市管理", rcode = "group_hot_admin", rgroup = "商户管理")
	@RequestMapping("/admin/group_hot_save.htm")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response, String city,
			String currentPage, Area area) {
		area.setId(CommUtil.null2Long(city));
		area.setIsGroupHot(true);
		if (area.getSequence() == null) {
			area.setSequence(0);
		}
		this.areaServiceImpl.update(area);
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/group_hot_list.htm?currentPage="
				+ currentPage);
		mv.addObject("op_title", "保存热门城市成功");
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/group_hot_add.htm?currentPage="
				+ currentPage);
		return mv;
	}

	@SecurityMapping(title = "热门城市删除", value = "/admin/group_hot_del.htm*", rtype = "admin", rname = "热门城市管理", rcode = "group_hot_admin", rgroup = "商户管理")
	@RequestMapping("/admin/group_hot_del.htm")
	public String delete(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		if (!"".equals(id)) {
			Area area = this.areaServiceImpl.getObjById(Long.parseLong(id));
			area.setSequence(0);
			area.setIsGroupHot(false);
			this.areaServiceImpl.update(area);
		}
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		return "redirect:group_hot_list.htm?&currentPage=" + currentPage;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "热门城市Ajax更新", value = "/admin/group_hot_ajax.htm*", rtype = "admin", rname = "热门城市管理", rcode = "group_hot_admin", rgroup = "商户管理")
	@RequestMapping("/admin/group_hot_ajax.htm")
	public void ajax(HttpServletRequest request, HttpServletResponse response, String id, String fieldName,
			String value) throws ClassNotFoundException {
		Area obj = this.areaServiceImpl.getObjById(Long.parseLong(id));
		Field[] fields = Area.class.getDeclaredFields();
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
		this.areaServiceImpl.update(obj);
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

	@RequestMapping("/admin/group_hot_verify.htm")
	public void group_class_verify(HttpServletRequest request, HttpServletResponse response, String city) {
		boolean ret = true;
		Area area = areaServiceImpl.getObjById(CommUtil.null2Long(city));
		if (null != area && area.getIsGroupHot()) {
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