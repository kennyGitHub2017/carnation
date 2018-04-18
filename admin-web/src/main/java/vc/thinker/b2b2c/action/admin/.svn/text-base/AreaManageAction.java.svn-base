package vc.thinker.b2b2c.action.admin;

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

import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.database.DatabaseTools;

/**
 * 
 * <p>
 * Title: AreaManageAction.java
 * </p>
 * 
 * <p>
 * Description: 常用区域管理控制器，用来管理控制系统常用区域信息，常用区域主要用在买家添加配送地址、买家住址信息等，默认为中国大陆三级行政区域信息 ，平台管理员可以任意管理该信息
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
public class AreaManageAction {
	@Autowired
	private SysConfigService configService;
	// @Autowired
	// private IUserConfigService userConfigService;
	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private DatabaseTools databaseTools;

	@Autowired
	private DicContent dicContent;

	@SecurityMapping(title = "地区列表", value = "/admin/area_list.htm*", rtype = "admin", rname = "常用地区", rcode = "admin_area_set", rgroup = "商城管理")
	@RequestMapping("/admin/area_list.htm")
	public ModelAndView area_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String pid, String orderBy, String orderType, MyPage<Area> page) {
		ModelAndView mv = new JModelAndView("admin/blue/area_setting.html", configService.getSysConfig(), 0,
				request, response);
		String url = CommUtil.getURL(request);

		if (StringUtils.isNotBlank(pid)) {
			Area parent = areaService.queryAreaById(CommUtil.null2Long(pid));
			mv.addObject("parent", parent);
			// 省份选择进入
			if (parent.getLevel() == 0) {
				List<Area> secondsBases = areaService.findByParentId(CommUtil.null2Long(pid));
				// List<DicBase> secondsBases = dicContent.getDicsByParentCode(Area.class, pid);// 取得省份下面的城市
				mv.addObject("seconds", secondsBases);
				mv.addObject("first", parent);
			}
			// 城市选择进入
			if (parent.getLevel() == 1) {
				List<Area> thirdsBases = areaService.findByParentId(parent.getId());
				// List<DicBase> thirdsBases = dicContent.getDicsByParentCode(Area.class,
				// CommUtil.null2String(parent.getId()));// 州县
				List<Area> secondsBases = areaService.findByParentId(parent.getParentId());
				// List<DicBase> secondsBases = dicContent.getDicsByParentCode(Area.class,
				// parent.getParentCode());// 城市
				Area first = areaService.queryAreaById(parent.getParentId());
				// DicBase first = dicContent.getDic(Area.class, parent.getParentCode());
				mv.addObject("thirds", thirdsBases);
				mv.addObject("seconds", secondsBases);
				mv.addObject("second", parent);
				mv.addObject("first", first);
			}
			// 州县进入
			if (parent.getLevel() == 2) {
				Area sends = areaService.queryAreaById(parent.getParentId());// 城市
				// DicBase sends = dicContent.getDic(Area.class, parent.getParentCode());// 城市
				Area firsArea = areaService.queryAreaById(CommUtil.null2Long(sends.getCode()));
				Area firs = areaService.queryAreaById(firsArea.getParentId());// 州县
				// DicBase firs = dicContent.getDic(Area.class, firsArea.getParentCode());// 州县
				List<Area> thirds = areaService.findByParentId(sends.getId());
				// List<DicBase> thirds = dicContent.getDicsByParentCode(Area.class, sends.getCode());
				List<Area> rootBases = areaService.findByParentId(firs.getId());
				// List<DicBase> rootBases = dicContent.getDicsByParentCode(Area.class, firs.getCode());
				mv.addObject("thirds", thirds);
				mv.addObject("seconds", rootBases);
				mv.addObject("third", parent);
				mv.addObject("second", sends);
				mv.addObject("first", firs);

			}
		}
		List<Area> rootBases = areaService.findParentArea();
		mv.addObject("areas", rootBases);

		page.setPageSize(60);
		areaService.queryAreaList(CommUtil.null2Long(pid), page);
		if (StringUtils.isNotBlank(pid)) {
			CommUtil.saveIPageList2ModelAndView(url + "/admin/area_list.htm", "", "&parent_id=" + pid, page,
					mv);
		} else {
			CommUtil.saveIPageList2ModelAndView(url + "/admin/area_list.htm", "", "&parent_id=-1", page, mv);
		}

		mv.addObject("objs", page.getContent());
		return mv;
	}

	/**
	 * area保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "地区保存", value = "/admin/area_save.htm*", rtype = "admin", rname = "常用地区", rcode = "admin_area_set", rgroup = "商城管理")
	@RequestMapping("/admin/area_save.htm")
	public ModelAndView area_save(HttpServletRequest request, HttpServletResponse response, String areaId,
			String pid, String count, String list_url, String currentPage) {
		areaService.batchSave(areaId, pid, count, request);
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("op_title", "更新区域成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/area_list.htm" + "?currentPage="
				+ currentPage + "&pid=" + pid);
		return mv;

	}

	@SecurityMapping(title = "地区删除", value = "/admin/area_del.htm*", rtype = "admin", rname = "常用地区", rcode = "admin_area_set", rgroup = "商城管理")
	@RequestMapping("/admin/area_del.htm")
	public String area_del(HttpServletRequest request, String mulitId, String currentPage, String pid) {
		areaService.batchDel(mulitId);
		return "redirect:area_list.htm?pid=" + pid + "&currentPage=" + currentPage;
	}

	@SecurityMapping(title = "地区Ajax编辑", value = "/admin/area_ajax.htm*", rtype = "admin", rname = "常用地区", rcode = "admin_area_set", rgroup = "商城管理")
	@RequestMapping("/admin/area_ajax.htm")
	public void area_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
		Area obj = areaService.queryAreaById(CommUtil.null2Long(id));
		Field[] fields = Area.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(obj);
		Object val = null;
		for (Field field : fields) {
			if (field.getName().equals(fieldName)) {
				Class<?> clz = Class.forName("java.lang.String");
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
		areaService.update(obj);
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