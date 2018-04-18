package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
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

import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.bo.GoodsBrandCategoryBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.dao.BrandFindVO;
import com.sinco.carnation.goods.model.GoodsBrand;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsBrandCategoryService;
import com.sinco.carnation.goods.service.GoodsBrandService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GoodsBrandManageAction.java
 * </p>
 * 
 * <p>
 * Description: 系统品牌管理控制器，用来添加系统品牌及审核商家提交的品牌信息
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
public class GoodsBrandManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsBrandService goodsBrandService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private GoodsBrandCategoryService goodsBrandCategoryService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsClassService goodsClassService;

	/**
	 * GoodsBrand列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商品品牌列表", value = "/admin/goods_brand_list.htm*", rtype = "admin", rname = "品牌管理", rcode = "goods_brand", rgroup = "商城管理")
	@RequestMapping("/admin/goods_brand_list.htm")
	public ModelAndView goods_brand_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<GoodsBrandBO> page, String name, String category) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_brand_list.html", configService.getSysConfig(),
				0, request, response);
		BrandFindVO vo = new BrandFindVO();
		vo.setAudit(1);
		vo.setBrandName(name);
		vo.setCategoryName(category);

		this.goodsBrandService.findByPage(vo, page);

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		mv.addObject("name", name);
		mv.addObject("category", category);
		return mv;
	}

	/**
	 * GoodsBrand审核页
	 * 
	 * @param request
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	@SecurityMapping(title = "商品品牌待审核列表", value = "/admin/goods_brand_audit.htm*", rtype = "admin", rname = "品牌管理", rcode = "goods_brand", rgroup = "商城管理")
	@RequestMapping("/admin/goods_brand_audit.htm")
	public ModelAndView goods_brand_audit(HttpServletRequest request, HttpServletResponse response,
			MyPage<GoodsBrandBO> page, String name, String category) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_brand_audit.html",
				configService.getSysConfig(), 0, request, response);
		BrandFindVO vo = new BrandFindVO();
		vo.setAudit(0);
		vo.setUserStatus(1);
		vo.setBrandName(name);
		vo.setCategoryName(category);

		this.goodsBrandService.findByPage(vo, page);

		CommUtil.saveIPageList2ModelAndView("/admin/goods_brand_audit.htm", "", "", page, mv);
		mv.addObject("name", name);
		mv.addObject("category", category);
		return mv;
	}

	@SecurityMapping(title = "商品品牌审核通过", value = "/admin/goods_brands_pass.htm*", rtype = "admin", rname = "品牌管理", rcode = "goods_brand", rgroup = "商城管理")
	@RequestMapping("/admin/goods_brands_pass.htm")
	public String goods_brands_pass(HttpServletRequest request, String id) {
		if (!id.equals("")) {
			GoodsBrand goodsBrand = new GoodsBrand();
			goodsBrand.setId(Long.parseLong(id));
			goodsBrand.setAudit(1);
			this.goodsBrandService.update(goodsBrand);
		}
		return "redirect:goods_brand_audit.htm";
	}

	@SecurityMapping(title = "商品品牌审核拒绝", value = "/admin/goods_brands_refuse.htm*", rtype = "admin", rname = "品牌管理", rcode = "goods_brand", rgroup = "商城管理")
	@RequestMapping("/admin/goods_brands_refuse.htm")
	public String goods_brands_refuse(HttpServletRequest request, String id) {
		if (!id.equals("")) {
			GoodsBrand goodsBrand = new GoodsBrand();
			goodsBrand.setId(Long.parseLong(id));
			goodsBrand.setAudit(-1);
			this.goodsBrandService.update(goodsBrand);
		}
		return "redirect:goods_brand_audit.htm";
	}

	/**
	 * goodsBrand添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "商品品牌添加", value = "/admin/goods_brand_add.htm*", rtype = "admin", rname = "品牌管理", rcode = "goods_brand", rgroup = "商城管理")
	@RequestMapping("/admin/goods_brand_add.htm")
	public ModelAndView goods_brand_add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_brand_add.html", configService.getSysConfig(),
				0, request, response);
		List<GoodsBrandCategoryBO> categorys = this.goodsBrandCategoryService.findAll();
		mv.addObject("categorys", categorys);
		List<GoodsClassBO> gcs = this.goodsClassService.findParnetIsNull();
		mv.addObject("gcs", gcs);
		return mv;
	}

	/**
	 * goodsBrand编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "商品品牌编辑", value = "/admin/goods_brand_edit.htm*", rtype = "admin", rname = "品牌管理", rcode = "goods_brand", rgroup = "商城管理")
	@RequestMapping("/admin/goods_brand_edit.htm")
	public ModelAndView goods_brand_edit(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_brand_add.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && !id.equals("")) {
			GoodsBrandBO goodsBrand = this.goodsBrandService.findBOById(Long.parseLong(id));
			mv.addObject("obj", goodsBrand);
		}

		List<GoodsBrandCategoryBO> categorys = this.goodsBrandCategoryService.findAll();
		mv.addObject("categorys", categorys);// 循环展示到页面上

		List<GoodsClassBO> gcs = this.goodsClassService.findParnetIsNull();
		mv.addObject("gcs", gcs);

		mv.addObject("edit", true);
		return mv;
	}

	/**
	 * goodsBrand保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "商品品牌保存", value = "/admin/goods_band_save.htm*", rtype = "admin", rname = "品牌管理", rcode = "goods_brand", rgroup = "商城管理")
	@RequestMapping("/admin/goods_band_save.htm")
	public ModelAndView goods_band_save(HttpServletRequest request, HttpServletResponse response, String id,
			String cmd, String cat_name, String list_url, String add_url, String gc_id, String categoryId) {
		WebForm wf = new WebForm();
		GoodsBrand goodsBrand = wf.toPo(request, GoodsBrand.class);
		if (StringUtils.isNotBlank(id)) {
			goodsBrand.setId(Long.parseLong(id));
		}

		GoodsClass gc = this.goodsClassService.getObjById(CommUtil.null2Long(gc_id));
		if (gc != null) {
			goodsBrand.setGcId(gc.getId());
		}
		this.goodsBrandService.save(request, goodsBrand, cat_name);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存品牌成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url);
		}
		return mv;
	}

	@SecurityMapping(title = "商品品牌删除", value = "/admin/goods_brand_del.htm*", rtype = "admin", rname = "品牌管理", rcode = "goods_brand", rgroup = "商城管理")
	@RequestMapping("/admin/goods_brand_del.htm")
	public String goods_brand_del(HttpServletRequest request, String mulitId, String audit, String currentPage) {
		String[] ids = mulitId.split(",");
		List<Long> idList = new ArrayList<Long>();

		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}

		this.goodsBrandService.batchDelete(idList);
		if (currentPage == null) {
			currentPage = "1";
		}
		String returnUrl = "redirect:goods_brand_list.htm?currentPage=" + currentPage;
		if (audit != null && !audit.equals("")) {
			returnUrl = "redirect:goods_brand_audit.htm?currentPage=" + currentPage;
		}
		return returnUrl;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "商品品牌AJAX更新", value = "/admin/goods_brand_ajax.htm*", rtype = "admin", rname = "品牌管理", rcode = "goods_brand", rgroup = "商城管理")
	@RequestMapping("/admin/goods_brand_ajax.htm")
	public void goods_brand_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
		GoodsBrand obj = new GoodsBrand();
		obj.setId(Long.parseLong(id));

		GoodsBrand oldObj = this.goodsBrandService.getObjById(Long.parseLong(id));

		Field[] fields = GoodsBrand.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(obj);
		BeanWrapper oldWrapper = new BeanWrapper(oldObj);

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
					val = !CommUtil.null2Boolean(oldWrapper.getPropertyValue(fieldName));
				}
				wrapper.setPropertyValue(fieldName, val);
			}
		}
		this.goodsBrandService.update(obj);
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

	@RequestMapping("/admin/goods_brand_verify.htm")
	public void goods_brand_verify(HttpServletRequest request, HttpServletResponse response, String name,
			String id) {
		boolean ret = true;
		int count = this.goodsBrandService.countByName(name, StringUtils.isNotBlank(id) ? Long.parseLong(id)
				: null);
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