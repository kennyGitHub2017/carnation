package vc.thinker.b2b2c.action.self;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;
import vc.thinker.b2b2c.core.tools.database.DatabaseTools;

import com.google.common.collect.Lists;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsSpecificationBO;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.model.GoodsSpecProperty;
import com.sinco.carnation.goods.model.GoodsSpecification;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsSpecPropertyService;
import com.sinco.carnation.goods.service.GoodsSpecificationService;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.goods.vo.GoodsSpecificationVO;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GoodsSpecificationSelfManageAction.java
 * </p>
 * 
 * <p>
 * Description: 自营商品规格管理控制器，平台自营及商家可以自行管理规格属性，规格属性只在商品详细页显示并可以选择， 平台搜索列表显示的规格属性为平台商品类型中的新增属性
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
 * @date 2014年4月25日
 * 
 * @version 1.0.1
 */
@Controller
public class SelfGoodsSpecManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private GoodsSpecificationService goodsSpecService;
	@Autowired
	private GoodsSpecPropertyService goodsSpecPropertyService;
	@Autowired
	private GoodsClassService goodsclassService;
	@Autowired
	private DatabaseTools databaseTools;

	@Autowired
	private StoreTools shopTools;

	/**
	 * GoodsSpecification列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商品规格列表", value = "/admin/goods_spec_list.htm*", rtype = "admin", rname = "规格管理", rcode = "goods_spec", rgroup = "商城管理")
	@RequestMapping("/admin/goods_spec_list.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, String errorMsg,
			GoodsSpecificationVO vo, MyPage<GoodsSpecificationBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_spec_list.html", configService.getSysConfig(),
				0, request, response);
		// 需要在list页提示的错误消息
		mv.addObject("errorMsg", errorMsg);
		mv.addObject("vo", vo);
//		this.goodsSpecService.list(page, GoodsConstants.GOODS_SPECI_SELF);
		vo.setSpecType(GoodsConstants.GOODS_SPECI_SELF);
		goodsSpecService.findByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("shopTools", shopTools);
		return mv;
	}

	/**
	 * goodsSpecification添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "商品规格添加", value = "/admin/goods_spec_add.htm*", rtype = "admin", rname = "规格管理", rcode = "goods_spec", rgroup = "商城管理")
	@RequestMapping("/admin/goods_spec_add.htm")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_spec_add.html", configService.getSysConfig(),
				0, request, response);
		List<GoodsClassBO> pgcs = this.goodsclassService.findParnetIsNull();
		mv.addObject("pgcs", pgcs);
		return mv;
	}

	/**
	 * goodsSpecification编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "商品规格编辑", value = "/admin/goods_spec_edit.htm*", rtype = "admin", rname = "规格管理", rcode = "goods_spec", rgroup = "商城管理")
	@RequestMapping("/admin/goods_spec_edit.htm")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_spec_add.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && !id.equals("")) {
			GoodsSpecificationBO goodsSpecification = this.goodsSpecService.findBOById(Long.parseLong(id));
			mv.addObject("obj", goodsSpecification);
			mv.addObject("currentPage", currentPage);
			List<GoodsClassBO> pgcs = this.goodsclassService.findParnetIsNull();

			if (goodsSpecification.getGoodsClassId() != null) {

				GoodsClass gc = this.goodsclassService.getObjById(goodsSpecification.getGoodsClassId());
				if (goodsSpecification.getSpecGoodsClassDetail() != null
						&& goodsSpecification.getSpecGoodsClassDetail().size() > 0) {

					mv.addObject("gc_childs",
							this.goodsclassService.findByParent(goodsSpecification.getGoodsClassId()));
				}
				mv.addObject("gcs", this.goodsclassService.findByParent(gc.getParentId()));
			}
			mv.addObject("pgcs", pgcs);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * goodsSpecification保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "商品规格保存", value = "/admin/goods_spec_save.htm*", rtype = "admin", rname = "规格管理", rcode = "goods_spec", rgroup = "商城管理")
	@RequestMapping("/admin/goods_spec_save.htm")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response, String id, String cmd,
			String count, String add_url, String list_url, String currentPage, String gc_ids, String gc_id) {
		WebForm wf = new WebForm();
		GoodsSpecification goodsSpecification = wf.toPo(request, GoodsSpecification.class);

		if (StringUtils.isNotBlank(id)) {
			goodsSpecification.setId(Long.parseLong(id));
		}

		List<Long> gcIdList = new ArrayList<Long>();

		if (gc_ids != null && !gc_ids.equals("")) {
			String ids[] = gc_ids.split(",");
			for (String c_id : ids) {
				gcIdList.add(Long.parseLong(c_id));
			}
		}

		if (StringUtils.isNotBlank(gc_id)) {
			goodsSpecification.setGoodsClassId(Long.parseLong(gc_id));
		}

		List<GoodsSpecProperty> properties = this.genericProperty(request, goodsSpecification, count);

		this.goodsSpecService.save(goodsSpecification, gcIdList, properties);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url + "?currentPage="
				+ (StringUtils.isNotEmpty(currentPage) ? currentPage : 0));
		mv.addObject("op_title", "保存商品规格成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url);
		}
		return mv;
	}

//	private void clearProperty(HttpServletRequest request,
//			GoodsSpecification spec) {
//		for (GoodsSpecProperty property : spec.getProperties()) {
//			this.databaseTools.execute("delete from "
//					+ Globals.DEFAULT_TABLE_SUFFIX
//					+ "goods_spec where spec_id=" + property.getId());
//			this.databaseTools.execute("delete from "
//					+ Globals.DEFAULT_TABLE_SUFFIX + "cart_gsp where gsp_id="
//					+ property.getId());
//			property.setSpec(null);
//			Accessory img = property.getSpecImage();
//			CommUtil.del_acc(request, img);
//			property.setSpecImage(null);
//			this.goodsSpecPropertyService.delete(property.getId());
//		}
//	}

	/**
	 * 得到属性
	 * 
	 * @param request
	 * @param spec
	 * @param count
	 * @return
	 */
	private List<GoodsSpecProperty> genericProperty(HttpServletRequest request, GoodsSpecification spec,
			String count) {
		List<GoodsSpecProperty> properties = new ArrayList<GoodsSpecProperty>();
		for (int i = 1; i <= CommUtil.null2Int(count); i++) {
			Integer sequence = CommUtil.null2Int(request.getParameter("sequence_" + i));
			String value = CommUtil.null2String(request.getParameter("value_" + i));
			if (sequence != null && !sequence.equals("") && value != null && !value.equals("")) {
				String id = CommUtil.null2String(request.getParameter("id_" + i));
				GoodsSpecProperty property = null;
				if (id != null && !id.equals("")) {
					property = this.goodsSpecPropertyService.getObjById(Long.parseLong(id));
				}
				if (property == null) {
					property = new GoodsSpecProperty();
				}
				property.setAddTime(new Date());
				property.setSequence(sequence);
				property.setValue(value);
				property.setSpecImageId(accessoryService.upload(request, "specImage_" + i,
						property.getSpecImageId()));
				properties.add(property);
			}
		}
		return properties;
	}

	@SecurityMapping(title = "商品规格删除", value = "/admin/goods_spec_del.htm*", rtype = "admin", rname = "规格管理", rcode = "goods_spec", rgroup = "商城管理")
	@RequestMapping("/admin/goods_spec_del.htm")
	public String delete(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) throws UnsupportedEncodingException {
		String[] ids = mulitId.split(",");
		List<Long> idList = Lists.newArrayList();
		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}
		if (idList.size() > 0) {
			try {
				//this.goodsSpecService.batchDelete(idList);
				this.goodsSpecService.updateDeleteStatus(idList);//删除改成逻辑删除
			} catch (ServiceException e) {
				return "redirect:goods_spec_list.htm?currentPage=" + currentPage + "&errorMsg="
						+ URLEncoder.encode(e.getErrorCode(), "utf-8");
			}
		}
		return "redirect:goods_spec_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "商品规格属性AJAX删除", value = "/admin/goods_property_delete.htm*", rtype = "admin", rname = "规格管理", rcode = "goods_spec", rgroup = "商城管理")
	@RequestMapping("/admin/goods_property_delete.htm")
	public void goods_property_delete(HttpServletRequest request, HttpServletResponse response, String id) {
		boolean ret = true;
		String errorMsg = null;
		if (!id.equals("")) {
			try {
				/*ret = this.goodsSpecPropertyService.delete(Long.parseLong(id));*/
				this.goodsSpecPropertyService.removeProperty(CommUtil.null2Long(id)); //删除属性
			} catch (ServiceException e) {
				ret = false;
				errorMsg = e.getErrorCode();
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			if (errorMsg != null) {
				writer.print(errorMsg);
			} else {
				writer.print(ret);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "商品规格AJAX更新", value = "/admin/goods_spec_ajax.htm*", rtype = "admin", rname = "规格管理", rcode = "goods_spec", rgroup = "商城管理")
	@RequestMapping("/admin/goods_spec_ajax.htm")
	public void ajax(HttpServletRequest request, HttpServletResponse response, String id, String fieldName,
			String value) throws ClassNotFoundException {
		GoodsSpecification obj = new GoodsSpecification();
		obj.setId(Long.parseLong(id));
		Field[] fields = GoodsSpecification.class.getDeclaredFields();
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
		this.goodsSpecService.update(obj);
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

	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping("/admin/goods_spec_verify.htm")
	public void goods_spec_verify(HttpServletRequest request, HttpServletResponse response, String name,
			String id) {
		boolean ret = true;
		Map params = new HashMap();
		params.put("name", name);
		params.put("id", CommUtil.null2Long(id));
		int count = this.goodsSpecService.countByNameAndSpecType(name, GoodsConstants.SPEC_TYPE_0,
				StringUtils.isNotBlank(id) ? Long.parseLong(id) : null);
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

	/**
	 * GoodsSpecification列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@RequestMapping("/admin/goods_spec_gc_load.htm")
	public ModelAndView spec_goodsclass_load(HttpServletRequest request, HttpServletResponse response,
			String gc_id, String mark, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_spec_gc_load.html",
				configService.getSysConfig(), 0, request, response);
		if (mark != null && !mark.equals("")) {
			if (mark.equals("pgc")) {
				mv = new JModelAndView("admin/blue/goods_spec_pgc_load.html", configService.getSysConfig(),
						0, request, response);
			}
		}
		GoodsClass gc = this.goodsclassService.getObjById(CommUtil.null2Long(gc_id));
		if (id != null && !id.equals("")) {
			GoodsSpecification gspec = this.goodsSpecService.getObjById(CommUtil.null2Long(id));
			mv.addObject("obj", gspec);
		}
		if (gc != null) {
			mv.addObject("gcs", this.goodsclassService.findByParent(gc.getId()));
		}
		return mv;
	}
	
	/***
	 * 添加产品属性页面_new
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/admin/goods_add_spec_dialog.htm")
	public ModelAndView  add_spec_dialog(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_spec_add_dialog.html",
				configService.getSysConfig(),0,request,response);
		return mv;
	}
	
	/***
	 * 保存规格值_new
	 * @param record
	 * @return
	 */
	@RequestMapping("/admin/add_spec_save.htm")
	public String add_spec_save(GoodsSpecification record) {
		try {
			record.setAddTime(new Date());
			this.goodsSpecService.saveGoodsSpecification(record);
		} catch (Exception e) {
		}
		return "redirect:goods_spec_list.htm?currentPage=" + "1";
	}
	
	/***
	 * 修改规格显示问题_new
	 * @param id
	 * @param value
	 * @return
	 */
	@RequestMapping("/admin/update_display.htm")
	public String updateDisPlay (Long id, Integer value) {
		try {
			GoodsSpecification specification = new GoodsSpecification();
			specification.setId(id);
			specification.setDisplay(value);
			this.goodsSpecService.update(specification);
		} catch (Exception e) {
		}
		return "redirect:goods_spec_list.htm?currentPage=" + "1";
	}
	
	/***
	 * 查询规格_NEW
	 * @param keyWord
	 * @return
	 */
	@RequestMapping("/admin/get_spec_list.htm")
	@ResponseBody
	public String getSpecList(String keyWord) {
		GoodsSpecificationVO vo = new GoodsSpecificationVO();
		vo.setName(keyWord);
		vo.setDisplay(0);
		vo.setSpecType(0);
		List<GoodsSpecificationBO> list = this.goodsSpecService.findByVO(null, vo);
		String str = Json.toJson(list);
		JSONArray a = JSONArray.fromObject(str);
		return a.toString();
	}
	
	/***
	 * 添加属性_NEW
	 * @param request
	 * @param response
	 * @param goodsSpecProperty
	 */
	@RequestMapping("/admin/goods_property_save.htm")
	public void goods_property_save(HttpServletRequest request, HttpServletResponse response,
			GoodsSpecProperty goodsSpecProperty){
		boolean bl = this.goodsSpecPropertyService.save(goodsSpecProperty);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter write;
		try {
			write = response.getWriter();
			write.print(bl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 上传产品属性图片_NEW
	 * @param request
	 * @param response
	 * @param fileName
	 * @param propertyId
	 */
	@RequestMapping("/admin/goods_property_img_upload.htm")
	@ResponseBody
	public String goods_property_img_upload(HttpServletRequest request,HttpServletResponse response,String fileName, Long propertyId,String mark){
		String  filePath = this.accessoryService.upload(request, mark+"_file", null);
		return filePath;
	}
	
	/***
	 * 批量插入属性并返回插入对象_new1
	 * @param request
	 * @param response
	 * @param specId
	 * @param propertyName
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/admin/goods_property_save_batch.htm")
	@ResponseBody
	public String goods_property_save_batch(HttpServletRequest request,
			HttpServletResponse response, Integer specId, String propertyName) {
		String[] pName = propertyName.split(",");
		List<GoodsSpecProperty> list = new ArrayList<GoodsSpecProperty>();
		for (int i = 0; i < pName.length; i++) {
			GoodsSpecProperty vo = new GoodsSpecProperty();
			vo.setSpecId(CommUtil.null2Long(specId));
			vo.setValue(pName[i]);
			vo.setStoreId(1);
			vo.setSequence(0);
			vo.setAddTime(new Date());
			int id = this.goodsSpecPropertyService.addProperty(vo);
			GoodsSpecProperty res = this.goodsSpecPropertyService.getObjById(CommUtil.null2Long(vo.getId()));
			list.add(res);
		}
		JSONArray json = JSONArray.fromObject(list);
		return json.toString();
		
	}
	
}