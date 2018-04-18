package vc.thinker.b2b2c.action.o2o;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

import com.sinco.carnation.sys.bo.AdContentBO;
import com.sinco.carnation.sys.bo.AreaAdBO;
import com.sinco.carnation.sys.model.AdContent;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.DicArea;
import com.sinco.carnation.sys.service.AreaAdService;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.ContentService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.vo.AdContentVO;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GroupHotManageAction.java
 * </p>
 * 
 * <p>
 * Description: 专区内容管理
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
public class GroupContentManageAvtion {

	@Autowired
	private SysConfigService configService;

	@Autowired
	private ContentService contentService;

	@Autowired
	private AreaAdService areaAdService;

	@Autowired
	private AreaServiceImpl areaServiceImpl;
	
	

	/**
	 * content内容列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param vo
	 * @return
	 */
	@SecurityMapping(title = "专区内容管理列表", value = "/admin/advert/advert_content.htm*", rtype = "admin", rname = "内容管理", rcode = "group_content_admin", rgroup = "商户管理")
	@RequestMapping("/admin/advert/advert_content.htm")
	public ModelAndView findGroupContentByPage(HttpServletRequest request, HttpServletResponse response,
			MyPage<AdContentBO> page, AdContentVO vo, String currentPage) {
		ModelAndView mv = new JModelAndView("/admin/blue/advert/advert_content.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isBlank(currentPage)) {
			page.setCurrentPage(1);
		}
		page.setPageSize(10);
		contentService.findContentByPage(page, vo);
		List<AreaAdBO> areaads = areaAdService.findAllShow();
		System.out.println(vo.getAreaAdId());
		System.out.println(vo.getId());
		List<AdContentBO> areas = contentService.findAllName(vo);
		mv.addObject("vo", vo);
		mv.addObject("areaads", areaads);
		mv.addObject("areas", areas);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	@SecurityMapping(title = "条件联动", value = "/admin/advert/advert_select.htm*", rtype = "admin", rname = "内容管理", rcode = "group_content_admin", rgroup = "商户管理")
	@RequestMapping("/admin/advert/advert_select.htm")
	public void advert_select(HttpServletRequest request, HttpServletResponse response, AdContentVO vo)
			throws IOException {
		List<AdContentBO> areas = contentService.findAllName(vo);
		String temp = Json.toJson(areas, JsonFormat.compact());
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 跳转content添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "跳转内容增加", value = "/admin/advert/advert_content_add.htm*", rtype = "admin", rname = "跳转内容管理", rcode = "content_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert/advert_content_add.htm")
	public ModelAndView advert_add(HttpServletRequest request, HttpServletResponse response,
			MyPage<AdContentBO> page, AdContentVO vo,Long parentId,Long areaAdId) {
		
		ModelAndView mv = new JModelAndView("/admin/blue/advert/advert_content_add.html",
				configService.getSysConfig(), 0, request, response);
		List<AreaAdBO> areaads = areaAdService.findAllShow();
		vo = new AdContentVO();
		vo.setAreaAdId(areaAdId);
		List<AdContentBO> areas = contentService.findAllName(vo);
		mv.addObject("areaads", areaads);
		mv.addObject("areas", areas);
		mv.addObject("parentId", parentId);
		mv.addObject("areaAdId", areaAdId);
		List<Area> provinces = this.areaServiceImpl.getAllParentIsNull();
		mv.addObject("provinces", provinces);
		return mv;
	}

	
	
	/**
	 * content保存管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "内容保存", value = "/admin/advert/advert_content_save.htm*", rtype = "admin", rname = "内容保存", rcode = "content_admin", rgroup = "内容管理")
	@RequestMapping("/admin/advert/advert_content_save.htm")
	public ModelAndView adContentSave(HttpServletRequest request, HttpServletResponse response,
			AdContentBO adContenBO, String currentPage, @RequestParam("cover") MultipartFile file) {
		Long userId = SecurityUserHolder.getCurrentUserId();
		AdContent adConten = new AdContent();
		adConten = adContenBO;
		adConten.setModifyBy(userId);
		adConten.setModifyTime(new Date());
		int orders = this.contentService.findById(adContenBO.getParentId()).getOrders();
		adConten.setOrders(orders);
		if (null == adContenBO.getId()) {
			adConten.setCreateTime(new Date());
			adConten.setCreateBy(userId);
		}
		if (file != null && file.getSize() != 0) {
			try {
				String fileUrl=FileUploadTools.fileUpload(file, UploadConstants.EDITOR);
				adConten.setPic(fileUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			if(StringUtils.isBlank(adConten.getPic()))
			adConten.setPic("http://www.ysysgo.com/resources/style/system/front/default/images/logo.jpg");
		}
		this.contentService.save(adConten);
		if (StringUtils.isBlank(currentPage)) {
			currentPage = "1";
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/advert/advert_content.htm?currentPage="
				+ currentPage);
		mv.addObject("op_title", "内容保存成功");
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/advert_content_edit.htm?currentPage="
				+ currentPage);
		return mv;
	}

	
	
	@SecurityMapping(title = "内容管理删除", value = "/admin/content_delete.htm*", rtype = "admin", rname = "内容管理", rcode = "group_content_admin", rgroup = "商户管理")
	@RequestMapping("/admin/content_delete.htm*")
	public ModelAndView adContentDelete(HttpServletRequest request, HttpServletResponse response,
			AdContentBO adContenBO, String currentPage, String mulitId) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			contentService.deleteById(Long.valueOf(id));
		}
		return findGroupContentByPage(request, response, new MyPage<AdContentBO>(), new AdContentVO(),
				currentPage);
	}

	@SecurityMapping(title = "专区区域管理列表", value = "/admin/advert_area_list.htm*", rtype = "admin", rname = "内容管理", rcode = "group_content_admin", rgroup = "商户管理")
	@RequestMapping("/admin/advert_area_list.htm*")
	public ModelAndView adContentAreaList(HttpServletRequest request, HttpServletResponse response,
			MyPage<AdContentBO> page, AdContentVO vo, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/advert/advert_area.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isBlank(currentPage)) {
			currentPage = "1";
			page.setCurrentPage(1);
		}
		page.setPageSize(10);
		this.contentService.listByVO(vo, page, "parent");
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		List<AreaAdBO> areaads = areaAdService.findAllShow();
		mv.addObject("areaads", areaads);
		mv.addObject("vo", vo);
		mv.addObject("currentPage", currentPage);
		mv.addObject("pageNumber", Long.valueOf(currentPage) - 1);
		return mv;
	}

	
	

	@SecurityMapping(title = "专区内容管理编辑", value = "/admin/advert_content_edit.htm*", rtype = "admin", rname = "内容管理", rcode = "group_content_admin", rgroup = "商户管理")
	@RequestMapping("/admin/advert_content_edit.htm*")
	public ModelAndView adContentEdit(HttpServletRequest request, HttpServletResponse response, Long id,
			String currentPage, Long areaAdId,AdContentVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/advert/advert_content_add.html",
				configService.getSysConfig(), 0, request, response);
		AdContentBO bo = new AdContentBO();
	
		List<AreaAdBO> areaads = areaAdService.findAllShow();
		List<AdContentBO> areas = contentService.findAllName(vo);
		DicArea pobj = null;
		 List<DicArea> csList = null;
		if (null != id) {
			bo = this.contentService.findById(id);
			 pobj = contentService.findShen(bo.getAreaId());
			 vo.setParentId(pobj.getId());

			 csList = contentService.findAllChenShi(pobj.getId());
			mv.addObject("edit", true);
		}
		if (StringUtils.isBlank(currentPage)) {
			currentPage = "1";
		}
		List<Area> provinces = this.areaServiceImpl.getAllParentIsNull();
		mv.addObject("provinces", provinces);
		mv.addObject("obj", bo);
		mv.addObject("vo", vo);
		mv.addObject("csList", csList);
		mv.addObject("areas", areas);
		mv.addObject("areaAdId", areaAdId);
		mv.addObject("areaads", areaads);
		mv.addObject("currentPage", currentPage);
		return mv;
	}
	
//	AdContent
	
	
	@SecurityMapping(title = "专区区域管理编辑", value = "/admin/advert_area_edit.htm*", rtype = "admin", rname = "内容管理", rcode = "group_content_admin", rgroup = "商户管理")
	@RequestMapping("/admin/advert_area_edit.htm*")
	public ModelAndView adContentAreaEdit(HttpServletRequest request, HttpServletResponse response, Long id,
			String currentPage, Long areaAdId) {
		ModelAndView mv = new JModelAndView("admin/blue/advert/advert_area_add.html",
				configService.getSysConfig(), 0, request, response);
		AdContentBO bo = new AdContentBO();
		List<AreaAdBO> areaads = areaAdService.findAllShow();
		if (null != id) {
			bo = this.contentService.findById(id);
			mv.addObject("edit", true);
		}
		if (StringUtils.isBlank(currentPage)) {
			currentPage = "1";
		}
		mv.addObject("obj", bo);
		mv.addObject("areaAdId", areaAdId);
		mv.addObject("areaads", areaads);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "专区区域管理保存", value = "/admin/advert_area_save.htm*", rtype = "admin", rname = "内容管理", rcode = "group_content_admin", rgroup = "商户管理")
	@RequestMapping("/admin/advert_area_save.htm*")
	public ModelAndView adContentAreaSave(HttpServletRequest request, HttpServletResponse response,
			AdContentBO adContenBO, String currentPage, @RequestParam("advertImg") MultipartFile file) {
		Long userId = SecurityUserHolder.getCurrentUserId();
		AdContent adConten = new AdContent();
		adConten = adContenBO;
		adConten.setModifyBy(userId);
		adConten.setModifyTime(new Date());
		if (null == adContenBO.getId()) {
			adConten.setCreateTime(new Date());
			adConten.setCreateBy(userId);
		}
		if (file != null && file.getSize() != 0) {
			try {
				String fileUrl = FileUploadTools.fileUpload(file, UploadConstants.EDITOR);
				adConten.setPic(fileUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			if (StringUtils.isBlank(adConten.getPic()))
				adConten.setPic("http://www.ysysgo.com/resources/style/system/front/default/images/logo.jpg");
		}
		this.contentService.save(adConten);
		
		contentService.updateAllOrdersById(adContenBO);
		
		if (StringUtils.isBlank(currentPage)) {
			currentPage = "1";
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/advert_area_list.htm?currentPage="
				+ currentPage);
		mv.addObject("op_title", "区域保存成功");
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/advert_area_edit.htm?currentPage="
				+ currentPage);
		return mv;
	}

	@SecurityMapping(title = "专区区域管理删除", value = "/admin/advert_area_delete.htm*", rtype = "admin", rname = "内容管理", rcode = "group_content_admin", rgroup = "商户管理")
	@RequestMapping("/admin/advert_area_delete.htm*")
	public ModelAndView adContentAreaDelete(HttpServletRequest request, HttpServletResponse response,
			AdContentBO adContenBO, String currentPage, String mulitId) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			contentService.deleteById(Long.valueOf(id));
		}
		return adContentAreaList(request, response, new MyPage<AdContentBO>(), new AdContentVO(), currentPage);
	}
	@SecurityMapping(title = "专区区域管理状态改变", value = "/admin/advert_area_changeShow.htm*", rtype = "admin", rname = "内容管理", rcode = "group_content_admin", rgroup = "商户管理")
	@RequestMapping("/admin/advert_area_changeShow.htm*")
	public void adContentAreachangeShow(HttpServletRequest request, HttpServletResponse response,
			AdContentBO adContenBO, String currentPage, Long id, Integer disabled,Integer type ) {
		boolean flag = false;
		String data=null;
		AdContent ad = contentService.findById(id);
		if(id != null && disabled != null){
			AdContent adConten = new AdContent();
			adConten.setId(id);
			adConten.setDisabled(disabled);
			flag =  this.contentService.save(adConten);
		}
		if(ad!=null && flag){
			 data = Json.toJson(ad, JsonFormat.compact());
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(data);
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}
}