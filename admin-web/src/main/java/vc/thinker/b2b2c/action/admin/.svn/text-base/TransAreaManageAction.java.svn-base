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
import com.sinco.carnation.shop.bo.TransAreaBO;
import com.sinco.carnation.shop.model.TransArea;
import com.sinco.carnation.shop.service.TransAreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: TransAreaManageAction.java
 * </p>
 * 
 * <p>
 * Description:运费区域管理控制器，用来管理控制系统配送区域信息，和系统常用区域不同
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
public class TransAreaManageAction {

	@Autowired
	private SysConfigService configService;

	@Autowired
	private TransAreaServiceImpl transareaService;

	@Autowired
	private DicContent dicContent;

	// @Autowired
	// private IUserConfigService userConfigService;

	/**
	 * TransArea列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "运费地区列表", value = "/admin/trans_area_list.htm*", rtype = "admin", rname = "运费区域", rcode = "admin_trans_area", rgroup = "商城管理")
	@RequestMapping("/admin/trans_area_list.htm")
	public ModelAndView trans_area_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String pid, MyPage<TransArea> page) {
		ModelAndView mv = new JModelAndView("admin/blue/trans_area_list.html", configService.getSysConfig(),
				0, request, response);
		String url = CommUtil.getURL(request);

		if (StringUtils.isNotBlank(pid)) {
			TransArea parent = transareaService.queryTransAreaById(CommUtil.null2Long(pid));
			mv.addObject("parent", parent);
			// 区域选择进入
			if (parent.getLevel() == 0) {
				List<TransAreaBO> secondsBases = transareaService.findByParentId(CommUtil.null2Long(pid));// 取得省份下面的城市
				mv.addObject("seconds", secondsBases);
				mv.addObject("first", parent);
			}
			// 城市选择进入
			if (parent.getLevel() == 1) {
				List<TransAreaBO> thirdsBases = transareaService.findByParentId(parent.getId());
				List<TransAreaBO> secondsBases = transareaService.findByParentId(parent.getParentId());
				TransArea first = transareaService.queryTransAreaById(parent.getParentId());
				mv.addObject("thirds", thirdsBases);
				mv.addObject("seconds", secondsBases);
				mv.addObject("second", parent);
				mv.addObject("first", first);
			}
			// 州县进入
			if (parent.getLevel() == 2) {
				TransArea sends = transareaService.queryTransAreaById(parent.getParentId());
				TransArea firsArea = transareaService.queryTransAreaById(sends.getId());
				TransArea firs = transareaService.queryTransAreaById(firsArea.getParentId());
				List<TransAreaBO> thirds = transareaService.findByParentId(sends.getId());
				List<TransAreaBO> rootBases = transareaService.findByParentId(firs.getId());
				mv.addObject("thirds", thirds);
				mv.addObject("seconds", rootBases);
				mv.addObject("third", parent);
				mv.addObject("second", sends);
				mv.addObject("first", firs);

			}
		}
		List<TransAreaBO> rootBases = transareaService.findParentArea();
		mv.addObject("areas", rootBases);

		page.setPageSize(20);
		transareaService.queryTransAreaList(CommUtil.null2Long(pid), page);
		if (StringUtils.isNotBlank(pid)) {
			CommUtil.saveIPageList2ModelAndView(url + "/admin/trans_area_list.htm", "", "&parent_id=" + pid,
					page, mv);
		} else {
			CommUtil.saveIPageList2ModelAndView(url + "/admin/trans_area_list.htm", "", "&parent_id=-1",
					page, mv);
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
	@SecurityMapping(title = "运费地区保存", value = "/admin/trans_area_save.htm*", rtype = "admin", rname = "运费区域", rcode = "admin_trans_area", rgroup = "商城管理")
	@RequestMapping("/admin/trans_area_save.htm")
	public ModelAndView trans_area_save(HttpServletRequest request, HttpServletResponse response,
			String areaId, String pid, String count, String list_url, String currentPage) {
		transareaService.batchSave(areaId, pid, count, request);
		// 批量保存完毕
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("op_title", "更新配送区域成功");
		mv.addObject("list_url", list_url + "?currentPage=" + currentPage + "&pid=" + pid);
		return mv;

	}

	@SecurityMapping(title = "运费地区删除", value = "/admin/trans_area_del.htm*", rtype = "admin", rname = "运费区域", rcode = "admin_trans_area", rgroup = "商城管理")
	@RequestMapping("/admin/trans_area_del.htm")
	public String trans_area_del(HttpServletRequest request, String mulitId, String currentPage, String pid) {
		transareaService.batchDel(mulitId);
		return "redirect:trans_area_list.htm?pid=" + pid + "&currentPage=" + currentPage;
	}

	@SecurityMapping(title = "运费地区Ajax更新", value = "/admin/trans_area_ajax.htm*", rtype = "admin", rname = "运费区域", rcode = "admin_trans_area", rgroup = "商城管理")
	@RequestMapping("/admin/trans_area_ajax.htm")
	public void trans_area_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
		TransArea obj = transareaService.queryTransAreaById(CommUtil.null2Long(id));
		Field[] fields = TransArea.class.getDeclaredFields();
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
		transareaService.update(obj);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(val.toString());
		} catch (IOException e) {
		}

	}
}