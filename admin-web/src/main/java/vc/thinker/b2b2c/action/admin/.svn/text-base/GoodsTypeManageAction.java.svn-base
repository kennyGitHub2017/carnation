package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
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
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsBrandCategoryBO;
import com.sinco.carnation.goods.bo.GoodsTypeBO;
import com.sinco.carnation.goods.model.GoodsType;
import com.sinco.carnation.goods.model.GoodsTypeProperty;
import com.sinco.carnation.goods.service.GoodsBrandCategoryService;
import com.sinco.carnation.goods.service.GoodsBrandService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsSpecificationService;
import com.sinco.carnation.goods.service.GoodsTypePropertyService;
import com.sinco.carnation.goods.service.GoodsTypeService;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GoodsTypeManageAction.java
 * </p>
 * 
 * <p>
 * Description: 商品类型管理类
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
public class GoodsTypeManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsTypeService goodsTypeService;
	@Autowired
	private GoodsBrandService goodsBrandService;
	
	@Autowired
	private GoodsBrandCategoryService goodsBrandCategoryService;
	@Autowired
	private GoodsSpecificationService goodsSpecificationService;
	@Autowired
	private GoodsTypePropertyService goodsTypePropertyService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private StoreTools shopTools;
	
	/**
	 * GoodsType列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商品类型列表", value = "/admin/goods_type_list.htm*", rtype = "admin", rname = "类型管理", rcode = "goods_type", rgroup = "商城管理")
	@RequestMapping("/admin/goods_type_list.htm")
	public ModelAndView goods_type_list(HttpServletRequest request,
			HttpServletResponse response,MyPage<GoodsTypeBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_type_list.html",
				configService.getSysConfig(),
				 0, request, response);
		
		this.goodsTypeService.findByPage(page);
		
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	/**
	 * goodsType添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "商品类型添加", value = "/admin/goods_type_add.htm*", rtype = "admin", rname = "类型管理", rcode = "goods_type", rgroup = "商城管理")
	@RequestMapping("/admin/goods_type_add.htm")
	public ModelAndView goods_type_add(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_type_add.html",
				configService.getSysConfig(),
				 0, request, response);
		List<GoodsBrandCategoryBO> gbcs = this.goodsBrandCategoryService.findBrandAll();
		mv.addObject("gbcs", gbcs);
		mv.addObject("shopTools", shopTools);
		return mv;
	}

	/**
	 * goodsType编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "商品类型编辑", value = "/admin/goods_type_edit.htm*", rtype = "admin", rname = "类型管理", rcode = "goods_type", rgroup = "商城管理")
	@RequestMapping("/admin/goods_type_edit.htm")
	public ModelAndView goods_type_edit(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_type_add.html",
				configService.getSysConfig(),
				 0, request, response);
		if (id != null && !id.equals("")) {
			GoodsTypeBO goodsType = this.goodsTypeService.getBOById(Long
					.parseLong(id));
			
			List<GoodsBrandCategoryBO> gbcs = this.goodsBrandCategoryService.findBrandAll();
			mv.addObject("gbcs", gbcs);
			mv.addObject("shopTools", shopTools);
			mv.addObject("obj", goodsType);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * goodsType保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "商品类型保存", value = "/admin/goods_type_save.htm*", rtype = "admin", rname = "类型管理", rcode = "goods_type", rgroup = "商城管理")
	@RequestMapping("/admin/goods_type_save.htm")
	public ModelAndView goods_type_save(HttpServletRequest request,
			HttpServletResponse response, String id, String cmd,
			String currentPage, String list_url, String add_url,
			String brand_ids, String count) {
		WebForm wf = new WebForm();
		GoodsType goodsType =wf.toPo(request, GoodsType.class);
		if (StringUtils.isNotBlank(id)) {
			goodsType.setId(Long.parseLong(id));
		}
		
		List<Long> gbIdList=Lists.newArrayList();
		String[] gb_ids = brand_ids.split(",");
		for (String gb_id : gb_ids) {
			if (!gb_id.equals("")) {
				gbIdList.add(Long.parseLong(gb_id));
			}
		}
		List<GoodsTypeProperty> gtps=this.genericProperty(request, count);
		
		this.goodsTypeService.save(goodsType,gbIdList,gtps);
	
		
		ModelAndView mv = new JModelAndView("admin/blue/success.html",
				configService.getSysConfig(),
				 0, request, response);
		mv.addObject("list_url", list_url + "?currentPage=" + (StringUtils.isNotBlank(currentPage) ? currentPage :"1"));
		mv.addObject("op_title", "保存商品类型成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url);
		}
		return mv;
	}

	public List<GoodsTypeProperty> genericProperty(HttpServletRequest request,
			String count) {
		List<GoodsTypeProperty> result=Lists.newArrayList();
		for (int i = 1; i <= CommUtil.null2Int(count); i++) {
			int sequence = CommUtil.null2Int(request
					.getParameter("gtp_sequence_" + i));
			String name = CommUtil.null2String(request.getParameter("gtp_name_"
					+ i));
			String value = CommUtil.null2String(request
					.getParameter("gtp_value_" + i));
			boolean display = CommUtil.null2Boolean(request
					.getParameter("gtp_display_" + i));
			String hc_value = CommUtil.null2String(request
					.getParameter("gtp_value_hc_" + i));
			if (!name.equals("") && !value.equals("")) {
				GoodsTypeProperty gtp = null;
				String id = CommUtil.null2String(request.getParameter("gtp_id_"
						+ i));
				if (id.equals("")) {
					gtp = new GoodsTypeProperty();
				} else {
					gtp = this.goodsTypePropertyService.getObjById(Long
							.parseLong(id));
				}
				gtp.setAddTime(new Date());
				gtp.setDisplay(display);
				gtp.setName(name);
				gtp.setSequence(sequence);
				gtp.setValue(value);
				gtp.setHcValue(hc_value);
				result.add(gtp);
			}
		}
		return result;
	}

	@SecurityMapping(title = "商品类型删除", value = "/admin/goods_type_del.htm*", rtype = "admin", rname = "类型管理", rcode = "goods_type", rgroup = "商城管理")
	@RequestMapping("/admin/goods_type_del.htm")
	public String goods_type_del(HttpServletRequest request, String mulitId,
			String currentPage) {
		String[] ids = mulitId.split(",");
		List<Long> idList=Lists.newArrayList();
		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}
		this.goodsTypeService.batchDelete(idList);
		
		return "redirect:goods_type_list.htm?currentPage=" + (StringUtils.isNotBlank(currentPage) ? currentPage :"1");
	}

	@SecurityMapping(title = "商品类型属性AJAX删除", value = "/admin/goods_type_property_delete.htm*", rtype = "admin", rname = "类型管理", rcode = "goods_type", rgroup = "商城管理")
	@RequestMapping("/admin/goods_type_property_delete.htm")
	public void goods_type_property_delete(HttpServletRequest request,
			HttpServletResponse response, String id) {
		boolean ret = false;
		if (!id.equals("")) {
			GoodsTypeProperty property = this.goodsTypePropertyService
					.getObjById(Long.parseLong(id));
			if(property != null){
				ret = this.goodsTypePropertyService.delete(property.getId());
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "商品类型AJAX更新", value = "/admin/goods_type_ajax.htm*", rtype = "admin", rname = "类型管理", rcode = "goods_type", rgroup = "商城管理")
	@RequestMapping("/admin/goods_type_ajax.htm")
	public void ajax(HttpServletRequest request, HttpServletResponse response,
			String id, String fieldName, String value)
			throws ClassNotFoundException {
		GoodsType obj = this.goodsTypeService.getObjById(Long.parseLong(id));
		Field[] fields = GoodsType.class.getDeclaredFields();
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
					val = !CommUtil.null2Boolean(wrapper
							.getPropertyValue(fieldName));
				}
				wrapper.setPropertyValue(fieldName, val);
			}
		}
		this.goodsTypeService.update(obj);
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

	@RequestMapping("/admin/goods_type_verify.htm")
	public void goods_type_verify(HttpServletRequest request,
			HttpServletResponse response, String name, String id) {
		boolean ret = true;
		
		int count=this.goodsTypeService.countByName(name, StringUtils.isNotBlank(id) ? Long.parseLong(id):null);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}