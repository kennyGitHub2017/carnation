package vc.thinker.b2b2c.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
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
import vc.thinker.b2b2c.tools.GoodsFloorTools;

import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsFloorBO;
import com.sinco.carnation.goods.dao.BrandFindVO;
import com.sinco.carnation.goods.model.GoodsFloor;
import com.sinco.carnation.goods.service.GoodsBrandService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsFloorService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.recommend.service.AdvertPositionService;
import com.sinco.carnation.recommend.service.AdvertService;
import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GoodsFloorManageAction.java
 * </p>
 * 
 * <p>
 * Description: 商品楼层管理控制器，通过拖拽式管理完成首页楼层管理，平台管理员可以任意管理控制商城首页楼层信息
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
public class GoodsFloorManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsFloorService goodsfloorService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsBrandService goodsBrandService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private AdvertPositionService advertPositionService;
	@Autowired
	private AdvertService advertService;
	@Autowired
	private GoodsFloorTools gf_tools;

	/**
	 * GoodsFloor列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "楼层分类列表", value = "/admin/goods_floor_list.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_list.htm")
	public ModelAndView goods_floor_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<GoodsFloorBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_list.html", configService.getSysConfig(),
				0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		String params = "";

		this.goodsfloorService.findByPage(0, page);

		CommUtil.saveIPageList2ModelAndView(url + "/admin/goods_floor_list.htm", "", params, page, mv);
		return mv;
	}

	/**
	 * goodsfloor添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "楼层分类添加", value = "/admin/goods_floor_add.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_add.htm")
	public ModelAndView goods_floor_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String pid) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_add.html", configService.getSysConfig(),
				0, request, response);
		mv.addObject("currentPage", currentPage);
		List<GoodsFloorBO> gfs = this.goodsfloorService.findByLevel(0);

		mv.addObject("gfs", gfs);

		GoodsFloor obj = new GoodsFloor();
		GoodsFloor parent = this.goodsfloorService.getObjById(CommUtil.null2Long(pid));
		if (parent != null) {
			obj.setParentId(Long.parseLong(pid));
			obj.setGfLevel(parent.getGfLevel() + 1);
		} else {
			obj.setGfLevel(0);
		}

		obj.setGfDisplay(true);

		mv.addObject("obj", obj);
		return mv;
	}

	/**
	 * goodsfloor编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "楼层分类编辑", value = "/admin/goods_floor_edit.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_edit.htm")
	public ModelAndView goods_floor_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_add.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && !id.equals("")) {
			GoodsFloor goodsfloor = this.goodsfloorService.getObjById(Long.parseLong(id));

			List<GoodsFloorBO> gfs = this.goodsfloorService.findByLevel(0);

			mv.addObject("gfs", gfs);
			mv.addObject("obj", goodsfloor);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * goodsfloor保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "楼层分类保存", value = "/admin/goods_floor_save.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_save.htm")
	public ModelAndView goods_floor_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String pid, String list_url, String add_url) {
		WebForm wf = new WebForm();
		GoodsFloor goodsfloor = wf.toPo(request, GoodsFloor.class);

		if (StringUtils.isNotBlank(id)) {
			goodsfloor.setId(Long.parseLong(id));
			GoodsFloor oldObj = this.goodsfloorService.getObjById(Long.parseLong(id));
			if (oldObj != null) {
				goodsfloor.setIconId(oldObj.getIconId());
			}
		}

		GoodsFloor parent = this.goodsfloorService.getObjById(CommUtil.null2Long(pid));
		if (parent != null) {
			goodsfloor.setParentId(parent.getId());
			goodsfloor.setGfLevel(parent.getGfLevel() + 1);
		}

		// 上传图片
		String iconId = accessoryService.upload(request, "icon_logo", goodsfloor.getIconId());
		goodsfloor.setIconId(iconId);

		this.goodsfloorService.save(goodsfloor);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存首页楼层成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?currentPage=" + currentPage);
		}
		return mv;
	}

	@SecurityMapping(title = "楼层分类删除", value = "/admin/goods_floor_del.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_del.htm")
	public String goods_floor_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		String[] ids = mulitId.split(",");
		List<Long> idList = new ArrayList<Long>();

		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}
		this.goodsfloorService.batchDelete(idList);

		return "redirect:goods_floor_list.htm?currentPage=" + currentPage;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "楼层分类Ajax更新", value = "/admin/goods_floor_ajax.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_ajax.htm")
	public void goods_floor_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
		GoodsFloor obj = new GoodsFloor();
		obj.setId(Long.parseLong(id));

		GoodsFloor oldObj = this.goodsfloorService.getObjById(Long.parseLong(id));

		Field[] fields = GoodsFloor.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(obj);
		BeanWrapper oldWrapper = new BeanWrapper(oldObj);

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
					val = !CommUtil.null2Boolean(oldWrapper.getPropertyValue(fieldName));
				}
				wrapper.setPropertyValue(fieldName, val);
			}
		}
		this.goodsfloorService.update(obj);
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
	@SecurityMapping(title = "楼层分类下级加载", value = "/admin/goods_floor_data.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_data.htm")
	public ModelAndView goods_floor_data(HttpServletRequest request, HttpServletResponse response,
			String pid, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_data.html", configService.getSysConfig(),
				0, request, response);
		Map map = new HashMap();
		map.put("pid", CommUtil.null2Long(pid));
		List<GoodsFloorBO> gfs = this.goodsfloorService.findByParent(Long.parseLong(pid));
		mv.addObject("gfs", gfs);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "楼层模板编辑", value = "/admin/goods_floor_template.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_template.htm")
	public ModelAndView goods_floor_template(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id, String tab) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_template.html",
				configService.getSysConfig(), 0, request, response);
		GoodsFloorBO obj = this.goodsfloorService.findBOById(CommUtil.null2Long(id), true);

		mv.addObject("obj", obj);
		mv.addObject("gf_tools", this.gf_tools);
		mv.addObject("currentPage", currentPage);
		mv.addObject("tab", tab);
		mv.addObject("url", CommUtil.getURL(request));
		return mv;
	}

	@SecurityMapping(title = "楼层模板商品分类编辑", value = "/admin/goods_floor_class.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_class.htm")
	public ModelAndView goods_floor_class(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_class.html",
				configService.getSysConfig(), 0, request, response);
		GoodsFloor obj = this.goodsfloorService.getObjById(CommUtil.null2Long(id));

		List<GoodsClassBO> gcs = this.goodsClassService.findLevelAll();

		mv.addObject("gcs", gcs);
		mv.addObject("obj", obj);
		mv.addObject("gf_tools", this.gf_tools);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "楼层模板商品分类加载", value = "/admin/goods_floor_class_load.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_class_load.htm")
	public ModelAndView goods_floor_class_load(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String gc_id) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_class_load.html",
				configService.getSysConfig(), 0, request, response);
		GoodsClassBO gc = this.goodsClassService.getBOById(CommUtil.null2Long(gc_id));
		gc.setChilds(this.goodsClassService.findByParent(gc.getId()));

		mv.addObject("gc", gc);
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "楼层模板商品分类保存", value = "/admin/goods_floor_class_save.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_class_save.htm")
	public String goods_floor_class_save(HttpServletRequest request, HttpServletResponse response, String id,
			String ids, String gf_name) {
		GoodsFloor obj = new GoodsFloor();
		obj.setId(Long.parseLong(id));
		obj.setGfName(gf_name);
		List gf_gc_list = new ArrayList();
		String[] id_list = ids.split(",pid:");
		for (String t_id : id_list) {
			String[] c_id_list = t_id.split(",");
			Map map = new HashMap();
			for (int i = 0; i < c_id_list.length; i++) {
				String c_id = c_id_list[i];
				if (c_id.indexOf("cid") < 0) {
					map.put("pid", c_id);
				} else {
					map.put("gc_id" + i, c_id.substring(4));
				}
			}
			map.put("gc_count", c_id_list.length - 1);
			if (!map.get("pid").toString().equals(""))
				gf_gc_list.add(map);
		}
		// System.out.println(Json.toJson(gf_gc_list, JsonFormat.compact()));
		obj.setGfGcList(Json.toJson(gf_gc_list, JsonFormat.compact()));
		this.goodsfloorService.update(obj);
		return "redirect:goods_floor_template.htm?id=" + id;
	}

	@SecurityMapping(title = "楼层模板分类商品编辑", value = "/admin/goods_floor_gc_goods.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_gc_goods.htm")
	public ModelAndView goods_floor_gc_goods(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_gc_goods.html",
				configService.getSysConfig(), 0, request, response);
		GoodsFloor obj = this.goodsfloorService.getObjById(CommUtil.null2Long(id));

		List<GoodsClassBO> gcs = this.goodsClassService.findLevelAll();

		mv.addObject("gcs", gcs);
		mv.addObject("obj", obj);
		mv.addObject("gf_tools", this.gf_tools);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "楼层模板分类商品保存", value = "/admin/goods_floor_gc_goods_save.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_gc_goods_save.htm")
	public String goods_floor_gc_goods_save(HttpServletRequest request, HttpServletResponse response,
			String gf_name, String id, String ids) {

		GoodsFloor oldObj = this.goodsfloorService.getObjById(CommUtil.null2Long(id));

		GoodsFloor obj = new GoodsFloor();
		obj.setId(Long.parseLong(id));
		String[] id_list = ids.split(",");
		Map map = new HashMap();
		for (int i = 0; i < id_list.length; i++) {
			if (!id_list[i].equals("")) {
				map.put("goods_id" + i, id_list[i]);
			}
		}
		// System.out.println(Json.toJson(map, JsonFormat.compact()));
		obj.setGfGcGoods(Json.toJson(map, JsonFormat.compact()));
		this.goodsfloorService.update(obj);
		return "redirect:goods_floor_template.htm?id=" + oldObj.getParentId() + "&tab=" + id;
	}

	@SecurityMapping(title = "楼层模板右侧商品列表编辑", value = "/admin/goods_floor_list_goods.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_list_goods.htm")
	public ModelAndView goods_floor_list_goods(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_list_goods.html",
				configService.getSysConfig(), 0, request, response);
		GoodsFloor obj = this.goodsfloorService.getObjById(CommUtil.null2Long(id));
		List<GoodsClassBO> gcs = this.goodsClassService.findLevelAll();

		mv.addObject("gcs", gcs);
		mv.addObject("obj", obj);
		mv.addObject("gf_tools", this.gf_tools);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@SecurityMapping(title = "楼层模板右侧商品列表保存", value = "/admin/goods_floor_list_goods_save.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_list_goods_save.htm")
	public String goods_floor_list_goods_save(HttpServletRequest request, HttpServletResponse response,
			String list_title, String id, String ids) {
		GoodsFloor obj = new GoodsFloor();
		obj.setId(Long.parseLong(id));

		String[] id_list = ids.split(",");
		Map map = new HashMap();
		map.put("list_title", list_title);
		for (int i = 0; i < id_list.length; i++) {
			if (!id_list[i].equals("")) {
				map.put("goods_id" + i, id_list[i]);
			}
		}
		// System.out.println(Json.toJson(map, JsonFormat.compact()));
		obj.setGfListGoods(Json.toJson(map, JsonFormat.compact()));
		this.goodsfloorService.update(obj);
		return "redirect:goods_floor_template.htm?id=" + obj.getId();
	}

	@SecurityMapping(title = "楼层模板左下方广告编辑", value = "/admin/goods_floor_left_adv.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_left_adv.htm")
	public ModelAndView goods_floor_left_adv(HttpServletRequest request, HttpServletResponse response,
			String id) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_left_adv.html",
				configService.getSysConfig(), 0, request, response);
		GoodsFloor obj = this.goodsfloorService.getObjById(CommUtil.null2Long(id));
		List<AdvertPosition> aps = this.advertPositionService
				.findByTypeAndlLocation(AdvertContant.AP_TYPE_IMG, AdvertContant.AP_LOCATION_PC, 156, null,
						AdvertContant.AP_STATUS_1);
		mv.addObject("aps", aps);
		mv.addObject("obj", obj);
		mv.addObject("gf_tools", this.gf_tools);
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "楼层模板左下方广告保存", value = "/admin/goods_floor_left_adv_save.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_left_adv_save.htm")
	public String goods_floor_left_adv_save(HttpServletRequest request, HttpServletResponse response,
			String type, String id, String adv_url, String adv_id) {
		GoodsFloor obj = new GoodsFloor();
		obj.setId(Long.parseLong(id));
		if (type.equals("user")) {
			// 模板广告图片
			Map json_map = new HashMap();
			String accId = this.accessoryService.upload(request, "img", null);

			json_map.put("acc_id", accId);

			json_map.put("acc_url", adv_url);
			json_map.put("adv_id", "");
			System.out.println(Json.toJson(json_map, JsonFormat.compact()));
			obj.setGfLeftAdv(Json.toJson(json_map, JsonFormat.compact()));
		}
		if (type.equals("adv")) {
			Map json_map = new HashMap();
			json_map.put("acc_id", "");
			json_map.put("acc_url", "");
			json_map.put("adv_id", adv_id);
			System.out.println(Json.toJson(json_map, JsonFormat.compact()));
			obj.setGfLeftAdv(Json.toJson(json_map, JsonFormat.compact()));
		}
		this.goodsfloorService.update(obj);
		return "redirect:goods_floor_template.htm?id=" + obj.getId();
	}

	@SecurityMapping(title = "楼层模板右下方广告编辑", value = "/admin/goods_floor_right_adv.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_right_adv.htm")
	public ModelAndView goods_floor_right_adv(HttpServletRequest request, HttpServletResponse response,
			String id) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_right_adv.html",
				configService.getSysConfig(), 0, request, response);
		GoodsFloor obj = this.goodsfloorService.getObjById(CommUtil.null2Long(id));
		List<AdvertPosition> aps = this.advertPositionService
				.findByTypeAndlLocation(AdvertContant.AP_TYPE_IMG, AdvertContant.AP_LOCATION_PC, 205, null,
						AdvertContant.AP_STATUS_1);
		mv.addObject("aps", aps);
		mv.addObject("obj", obj);
		mv.addObject("gf_tools", this.gf_tools);
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unused", "unchecked"})
	@SecurityMapping(title = "楼层模板右下方广告保存", value = "/admin/goods_floor_right_adv_save.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_right_adv_save.htm")
	public String goods_floor_right_adv_save(HttpServletRequest request, HttpServletResponse response,
			String type, String id, String adv_url, String adv_id) {
		GoodsFloor obj = new GoodsFloor();
		obj.setId(Long.parseLong(id));

		Map map = new HashMap();
		if (type.equals("user")) {
			// 模板广告图片
			String uploadFilePath = this.configService.getSysConfig().getUploadFilePath();
			String saveFilePathName = request.getSession().getServletContext().getRealPath("/")
					+ uploadFilePath + File.separator + "advert";
			Map json_map = new HashMap();
			String accId = this.accessoryService.upload(request, "img", null);

			json_map.put("acc_id", accId);

			json_map.put("acc_url", adv_url);
			json_map.put("adv_id", "");
			System.out.println(Json.toJson(json_map, JsonFormat.compact()));
			obj.setGfRightAdv(Json.toJson(json_map, JsonFormat.compact()));
		}
		if (type.equals("adv")) {
			Map json_map = new HashMap();
			json_map.put("acc_id", "");
			json_map.put("acc_url", "");
			json_map.put("adv_id", adv_id);
			System.out.println(Json.toJson(json_map, JsonFormat.compact()));
			obj.setGfRightAdv(Json.toJson(json_map, JsonFormat.compact()));
		}
		this.goodsfloorService.update(obj);
		return "redirect:goods_floor_template.htm?id=" + obj.getId();
	}

	@SecurityMapping(title = "楼层模板品牌编辑", value = "/admin/goods_floor_brand.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_brand.htm")
	public ModelAndView goods_floor_brand(HttpServletRequest request, HttpServletResponse response,
			String id, MyPage<GoodsBrandBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_brand.html",
				configService.getSysConfig(), 0, request, response);
		GoodsFloor obj = this.goodsfloorService.getObjById(CommUtil.null2Long(id));

		BrandFindVO vo = new BrandFindVO();
		vo.setAudit(GoodsConstants.GB_AUDIT_1);
		this.goodsBrandService.findByPage(vo, page);

		CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request) + "/admin/goods_floor_brand_load.htm",
				"", "", page, mv);
		mv.addObject("obj", obj);
		mv.addObject("gf_tools", this.gf_tools);
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "楼层模板品牌保存", value = "/admin/goods_floor_brand_save.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_brand_save.htm")
	public String goods_floor_brand_save(HttpServletRequest request, HttpServletResponse response, String id,
			String ids) {
		GoodsFloor obj = new GoodsFloor();
		obj.setId(Long.parseLong(id));
		String[] id_list = ids.split(",");
		Map map = new HashMap();
		for (int i = 0; i < id_list.length; i++) {
			if (!id_list[i].equals("")) {
				map.put("brand_id" + i, id_list[i]);
			}
		}
		System.out.println(Json.toJson(map, JsonFormat.compact()));
		obj.setGfBrandList(Json.toJson(map, JsonFormat.compact()));
		this.goodsfloorService.update(obj);
		return "redirect:goods_floor_template.htm?id=" + obj.getId();
	}

	@SecurityMapping(title = "楼层模板品牌加载", value = "/admin/goods_floor_brand_load.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_brand_load.htm")
	public ModelAndView goods_floor_brand_load(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String name, MyPage<GoodsBrandBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_brand_load.html",
				configService.getSysConfig(), 0, request, response);

		BrandFindVO vo = new BrandFindVO();
		vo.setAudit(GoodsConstants.GB_AUDIT_1);
		vo.setBrandName(name);
		this.goodsBrandService.findByPage(vo, page);

		CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request) + "/admin/goods_floor_brand_load.htm",
				"", "&name=" + CommUtil.null2String(name), page, mv);
		return mv;
	}

	@SecurityMapping(title = "楼层模板分类商品编辑", value = "/admin/goods_floor_list_goods_load.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_list_goods_load.htm")
	public ModelAndView goods_floor_list_goods_load(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String gc_id, String goods_name, String page, String module_id,
			MyPage<GoodsBO> myPage) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_list_goods_load.html",
				configService.getSysConfig(), 0, request, response);
		if (!CommUtil.null2String(page).equals("")) {
			mv = new JModelAndView("admin/blue/" + page + ".html", configService.getSysConfig(), 0, request,
					response);
		}
		myPage.setPageSize(14);

		GoodsVO goods = new GoodsVO();
		goods.setGoodsName(goods_name);
		goods.setGoodsStatus(GoodsConstants.GOODS_STATUS_SELLING);

		if (!CommUtil.null2String(gc_id).equals("")) {
			Set<Long> ids = this.goodsClassService.genericIds(Long.parseLong(gc_id));
			ids.add(Long.parseLong(gc_id));
			goods.setGoodsClassIds(ids);
		}

		goods.setIsYgb(0);// 非云购币产品
		this.goodsService.list(myPage, goods);

		CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request)
				+ "/admin/goods_floor_list_goods_load.htm", "", "&gc_id=" + gc_id + "&goods_name="
				+ goods_name, myPage, mv);
		mv.addObject("module_id", module_id);
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked", "unused"})
	@SecurityMapping(title = "楼层ICON恢复初始", value = "/admin/goods_floor_icon_restore.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_icon_restore.htm")
	public void restore_img(HttpServletRequest request, HttpServletResponse response, Long id)
			throws IOException {
		Map map = new HashMap();
		GoodsFloor gf = new GoodsFloorBO();
		gf.setId(id);
		gf.setIconId(null);
		this.goodsfloorService.update(gf);

		map.put("path", CommUtil.getURL(request)
				+ "/resources/style/system/front/default/images/left_nav.png");
		HttpSession session = request.getSession(false);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = response.getWriter();
		writer.print(Json.toJson(map, JsonFormat.compact()));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "楼层模板2右侧数据管理", value = "/admin/goods_floor_style2.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_style2.htm")
	public ModelAndView goods_floor_style2(HttpServletRequest request, HttpServletResponse response,
			String id, String index, String width, String height, String module_id) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_style2.html",
				configService.getSysConfig(), 0, request, response);
		GoodsFloor obj = this.goodsfloorService.getObjById(CommUtil.null2Long(id));
		List<Map> maps = new ArrayList<Map>();
		if (obj.getGfStyle2Goods() != null) {
			maps = Json.fromJson(List.class, obj.getGfStyle2Goods());
		}
		Map obj_map = null;
		for (Map map : maps) {
			if (CommUtil.null2String(map.get("module_id")).equals(module_id)) {
				obj_map = map;
				break;
			}
		}
		List<AdvertPosition> aps = new ArrayList<AdvertPosition>();
		if (CommUtil.null2Int(width) > 0 && CommUtil.null2Int(height) > 0) {

			aps = this.advertPositionService.findByTypeAndlLocation(AdvertContant.AP_TYPE_IMG,
					AdvertContant.AP_LOCATION_PC, CommUtil.null2Int(width), CommUtil.null2Int(height),
					AdvertContant.AP_STATUS_1);
		} else {
			aps = this.advertPositionService.findByTypeAndlLocation(AdvertContant.AP_TYPE_IMG,
					AdvertContant.AP_LOCATION_PC, null, null, AdvertContant.AP_STATUS_1);

		}
		List<GoodsClassBO> gcs = this.goodsClassService.findLevelAll();
		mv.addObject("obj_map", obj_map);
		mv.addObject("gcs", gcs);
		mv.addObject("width", width);
		mv.addObject("height", height);
		mv.addObject("aps", aps);
		mv.addObject("obj", obj);
		mv.addObject("module_id", module_id);
		mv.addObject("gf_tools", this.gf_tools);
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "楼层style2模板保存", value = "/admin/goods_floor_style2_save.htm*", rtype = "admin", rname = "首页楼层", rcode = "goods_floor", rgroup = "商城管理")
	@RequestMapping("/admin/goods_floor_style2_save.htm")
	public String goods_floor_style2_save(HttpServletRequest request, HttpServletResponse response,
			String id, String type, String goods_id, String adv_id, String module_id) {
		GoodsFloor obj = this.goodsfloorService.getObjById(CommUtil.null2Long(id));
		List<Map> maps = new ArrayList<Map>();
		if (!CommUtil.null2String(obj.getGfStyle2Goods()).equals("")) {
			maps = Json.fromJson(List.class, obj.getGfStyle2Goods());
			boolean update = false;
			for (Map map : maps) {
				if (map.get("module_id").equals(module_id)) {
					if (type.equals("goods") && StringUtils.isNotBlank(goods_id)) {
						map.put("type", type);
						map.put("module_id", module_id);
						setGoods(Long.parseLong(goods_id), map);
					}
					if (type.equals("img")) {
						map.put("type", type);
						map.put("module_id", module_id);
						setImg(request, map);
					}
					if (type.equals("adv")) {
						if (StringUtils.isNotBlank(adv_id))
							setAdv(request, Long.parseLong(adv_id), map);

					}
					update = true;
				}
			}
			if (!update) {
				if (type.equals("goods") && StringUtils.isNotBlank(goods_id)) {
					Map map = new HashMap();
					map.put("type", type);
					map.put("module_id", module_id);
					setGoods(Long.parseLong(goods_id), map);
					maps.add(map);
				}
				if (type.equals("img")) {
					Map map = new HashMap();
					map.put("type", type);
					map.put("module_id", module_id);
					setImg(request, map);
					maps.add(map);
				}
				if (type.equals("adv")) {
					Map map = new HashMap();

					if (StringUtils.isNotBlank(adv_id)) {
						setAdv(request, Long.parseLong(adv_id), map);
					}
					maps.add(map);
				}
			}
			obj.setGfStyle2Goods(Json.toJson(maps, JsonFormat.compact()));
		} else {
			Map map = new HashMap();
			map.put("type", type);
			map.put("module_id", module_id);

			if (type.equals("goods") && StringUtils.isNotBlank(goods_id)) {
				setGoods(Long.parseLong(goods_id), map);
				maps.add(map);
			}
			if (type.equals("img")) {
				setImg(request, map);
				maps.add(map);
			}
			if (type.equals("adv")) {
				if (StringUtils.isNotBlank(adv_id)) {
					setAdv(request, Long.parseLong(adv_id), map);
				}
				maps.add(map);
			}
		}
//		 System.out.println(Json.toJson(maps, JsonFormat.compact()));
		obj.setGfStyle2Goods(Json.toJson(maps, JsonFormat.compact()));
		this.goodsfloorService.update(obj);
		return "redirect:goods_floor_template.htm?id=" + obj.getParentId();
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private Map setGoods(Long goodsId, Map map) {

		GoodsBO goods = this.goodsService.findBOByid(goodsId);
		if (goods != null) {
			map.put("goods_id", goodsId);
			map.put("img_url", goods.getGoodsMainPhotoPath());
			map.put("goods_price", goods.getGoodsPrice());
			map.put("store_price", goods.getGoodsCurrentPrice());
			map.put("goods_name", goods.getGoodsName());
			map.put("href_url", "/goods_" + goodsId + ".htm");
		}
		return map;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private Map setImg(HttpServletRequest request, Map map) {
		String imgUrl = this.accessoryService.upload(request, "img", null);
		if (StringUtils.isNotBlank(imgUrl)) {
			map.put("goods_id", "");
			map.put("goods_price", "");
			map.put("store_price", "");
			map.put("goods_name", "");
			map.put("img_url", imgUrl);
			map.put("href_url", request.getParameter("adv_url"));
		}
		return map;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private Map setAdv(HttpServletRequest request, Long adv_id, Map map) {
		AdvertPosition ap = this.advertPositionService.getObjById(adv_id);
		List<Advert> advs = this.advertService.findListByAdApId(ap.getId());

		String img_url = ap.getApImgPath();
		String adv_url = CommUtil.getURL(request) + "/advert_redirect.htm?url=" + ap.getApAccUrl() + "&id=";// +
																											// ap.getAdv_id();

		if (ap.getApShowType() == AdvertContant.AP_SHOW_TYPE_0) {// 固定广告
			if (advs.size() > 0) {
				img_url = advs.get(0).getAdImgPath();

				adv_url = CommUtil.getURL(request) + "/advert_redirect.htm?url=" + advs.get(0).getAdUrl()
						+ "&id=" + advs.get(0).getId();
			}
		} else if (ap.getApShowType() == AdvertContant.AP_SHOW_TYPE_1) {// 随机广告
			if (advs.size() > 0) {
				Random random = new Random();
				int i = random.nextInt(advs.size());
				img_url = advs.get(i).getAdImgPath();

				adv_url = CommUtil.getURL(request) + "/advert_redirect.htm?url=" + advs.get(i).getAdUrl()
						+ "&id=" + advs.get(i).getId();
			}
		}
		map.put("goods_id", "");
		map.put("goods_price", "");
		map.put("store_price", "");
		map.put("goods_name", "");
		map.put("img_url", img_url);
		map.put("href_url", adv_url);
		return map;
	}
}