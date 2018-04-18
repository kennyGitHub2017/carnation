package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsTypeBO;
import com.sinco.carnation.goods.model.GoodsBrand;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.model.GoodsType;
import com.sinco.carnation.goods.service.GoodsBrandService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.GoodsTypeService;
import com.sinco.carnation.recommend.service.AdvertPositionService;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GoodsClassManageAction.java
 * </p>
 * 
 * <p>
 * Description: 商城商品分类管理控制器，用来管理商城商品分类信息，商城默认支持三级商品分类，遵循京东、一号店等B2B2C商城的商品分类模式
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
 * @date 2014-4-25
 * 
 * @version 1.0.1
 */
@Controller
public class GoodsClassManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private GoodsTypeService goodsTypeService;
	@Autowired
	private GoodsService goodsService;

	@Autowired
	private GoodsBrandService goodsbrandService;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@Autowired
	private AdvertPositionService advertPositionService;

	/**
	 * GoodsClass列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商品分类列表", value = "/admin/goods_class_list.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class", rgroup = "商城管理")
	@RequestMapping("/admin/goods_class_list.htm")
	public ModelAndView goods_class_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<GoodsClassBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_class_list.html", configService.getSysConfig(),
				0, request, response);

		page.setPageSize(10);

		this.goodsClassService.findParentIsNullPage(page);

		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		CommUtil.saveIPageList2ModelAndView(url + "/admin/goods_class_list.htm", "", "", page, mv);

		return mv;
	}

	/**
	 * goodsClass添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "商品分类添加", value = "/admin/goods_class_add.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class", rgroup = "商城管理")
	@RequestMapping("/admin/goods_class_add.htm")
	public ModelAndView goods_class_add(HttpServletRequest request, HttpServletResponse response, String pid) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_class_add.html", configService.getSysConfig(),
				0, request, response);
		List<GoodsClassBO> gcs = this.goodsClassService.findLevelAll();

		List<GoodsTypeBO> gts = this.goodsTypeService.findAll();

		if (StringUtils.isNotBlank(pid)) {
			GoodsClass obj = new GoodsClass();
			obj.setParentId(Long.parseLong(pid));
			obj.setDisplay(true);
			obj.setRecommend(true);
			mv.addObject("obj", obj);
		}
		List<AdvertPosition> aps = this.advertPositionService.findByType("img", 1);
		mv.addObject("aps", aps);
		mv.addObject("gcs", gcs);
		mv.addObject("gts", gts);
		return mv;
	}

	/**
	 * goodsClass编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "商品分类编辑", value = "/admin/goods_class_edit.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class", rgroup = "商城管理")
	@RequestMapping("/admin/goods_class_edit.htm")
	public ModelAndView goods_class_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_class_add.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && !id.equals("")) {
			GoodsClass goodsClass = this.goodsClassService.getObjById(Long.parseLong(id));
			mv.addObject("obj", goodsClass);

			List<GoodsClassBO> gcs = this.goodsClassService.findLevelAll();

			List<GoodsTypeBO> gts = this.goodsTypeService.findAll();

			List<AdvertPosition> aps = this.advertPositionService.findByType("img", 1);

			if (goodsClass.getGcAdvert() != null) {
				Map map = (Map) Json.fromJson(goodsClass.getGcAdvert());
				mv.addObject("adv_type", CommUtil.null2String(map.get("adv_type")));
				mv.addObject("adv_id", CommUtil.null2String(map.get("adv_id")));
				Accessory acc = this.accessoryService.getObjById(CommUtil.null2Long(map.get("acc_id")));
				if (acc != null) {
					mv.addObject("acc_img", acc.getPath());
				}
				if (map.get("acc_url") != null) {
					mv.addObject("acc_url", CommUtil.null2String(map.get("acc_url")));
				}
			}
			if (goodsClass.getGbInfo() != null && !goodsClass.getGbInfo().equals("")) {
				List<Map> map_list = (List<Map>) Json.fromJson(goodsClass.getGbInfo());
				List gbs = new ArrayList();
				for (Map map : map_list) {
					GoodsBrand gb = this.goodsbrandService.getObjById(CommUtil.null2Long(map.get("id")));
					if (gb != null) {
						gbs.add(gb);
					}
				}
				mv.addObject("gbs", gbs);
			}
			mv.addObject("aps", aps);
			mv.addObject("gcs", gcs);
			mv.addObject("gts", gts);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * goodsClass保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "商品分类保存", value = "/admin/goods_class_save.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class", rgroup = "商城管理")
	@RequestMapping("/admin/goods_class_save.htm")
	public ModelAndView goods_class_save(HttpServletRequest request, HttpServletResponse response, String id,
			String pid, String goodsTypeId, String currentPage, String list_url, String add_url,
			String child_link, String commission_link, String commission_rate, String guarantee,
			String guarantee_link, String adv_type, String ap_id, String gc_color, String gbs_ids,
			String gc_adv_url) {
		WebForm wf = new WebForm();
		GoodsClass goodsClass = wf.toPo(request, GoodsClass.class);

		if (StringUtils.isNotBlank(id)) {
			goodsClass.setId(Long.parseLong(id));
		}

		// 设置父级属性
		GoodsClass parent = this.goodsClassService.getObjById(CommUtil.null2Long(pid));
		if (parent != null) {
			goodsClass.setParentId(Long.parseLong(pid));
			goodsClass.setLevel(parent.getLevel() + 1);
		}
		GoodsType goodsType = this.goodsTypeService.getObjById(CommUtil.null2Long(goodsTypeId));
		if (goodsType != null) {
			goodsClass.setGoodsTypeId(Long.parseLong(goodsTypeId));
		}

		if (CommUtil.null2Int(adv_type) == 0) {// 设置系统广告
			AdvertPosition ap = this.advertPositionService.getObjById(CommUtil.null2Long(ap_id));
			Map map_temp = new HashMap();
			if (ap != null) {
				map_temp.put("adv_id", ap.getId());// 存入广告位id
			} else {
				map_temp.put("adv_id", "");
			}
			goodsClass.setGcAdvert(Json.toJson(map_temp, JsonFormat.compact()));
		}

		if (gc_color != null && !gc_color.equals("")) {
			goodsClass.setGcColor(gc_color);
		}

		if (gbs_ids != null && !gbs_ids.equals("")) {
			String[] gb_ids = gbs_ids.split(",");
			List list_temp = new ArrayList();
			for (String gb_id : gb_ids) {
				if (gb_id != null && !gb_id.equals("")) {
					GoodsBrand gb = this.goodsbrandService.getObjById(CommUtil.null2Long(gb_id));
					Map map_temp = new HashMap();
					map_temp.put("id", gb.getId());
					map_temp.put("name", gb.getName());
					list_temp.add(map_temp);
				}
			}
			goodsClass.setGbInfo(Json.toJson(list_temp, JsonFormat.compact()));
		} else {
			goodsClass.setGbInfo(null);
		}

		this.goodsClassService.save(goodsClass, request, CommUtil.null2Boolean(child_link),
				CommUtil.null2Boolean(commission_link), CommUtil.null2Boolean(guarantee_link), gc_adv_url,
				adv_type);
		goodsClassService.refreshDicCache();

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("op_title", "保存商品分类成功");
		mv.addObject("list_url", list_url);
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?pid=" + pid);
		}
		return mv;
	}

	@SecurityMapping(title = "商品分类下级加载", value = "/admin/goods_class_data.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class", rgroup = "商城管理")
	@RequestMapping("/admin/goods_class_data.htm")
	public ModelAndView goods_class_data(HttpServletRequest request, HttpServletResponse response,
			String pid, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_class_data.html", configService.getSysConfig(),
				0, request, response);
		List<GoodsClassBO> gcs = this.goodsClassService.findByParent(Long.parseLong(pid));
		mv.addObject("gcs", gcs);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "商品分类Ajax更新", value = "/admin/goods_class_ajax.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class", rgroup = "商城管理")
	@RequestMapping("/admin/goods_class_ajax.htm")
	public void goods_class_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
		GoodsClass gc = goodsClassService.getObjById(CommUtil.null2Long(id));
		gc.setId(Long.parseLong(id));
		Field[] fields = GoodsClass.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(gc);
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
		this.goodsClassService.update(gc);

		goodsClassService.refreshDicCache();

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

	@SecurityMapping(title = "商品分类批量推荐", value = "/admin/goods_class_recommend.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class", rgroup = "商城管理")
	@RequestMapping("/admin/goods_class_recommend.htm")
	public String goods_class_recommend(HttpServletRequest request, String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}
		goodsClassService.updateRecommend(true, idList);

		return "redirect:goods_class_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "商品分类批量删除", value = "/admin/goods_class_del.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class", rgroup = "商城管理")
	@RequestMapping("/admin/goods_class_del.htm")
	public String goods_class_del(HttpServletRequest request, String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}
		goodsClassService.delete(idList.toArray(new Long[idList.size()]));
		goodsClassService.refreshDicCache();

		return "redirect:goods_class_list.htm?currentPage=" + currentPage;

	}

	@RequestMapping("/admin/goods_class_verify.htm")
	public void goods_class_verify(HttpServletRequest request, HttpServletResponse response,
			String className, String id, String pid) {
		boolean ret = true;
		int count = goodsClassService.countByName(className, StringUtils.isNotBlank(id) ? Long.parseLong(id)
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "通过类型id查询相应品牌", value = "/admin/goods_goodsType_brand.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class", rgroup = "商城管理")
	@RequestMapping("/admin/goods_goodsType_brand.htm")
	public void goods_goodsType_brand(HttpServletRequest request, HttpServletResponse response, String type_id) {
		if (StringUtils.isBlank(type_id)) {
			return;
		}
		List<GoodsBrandBO> gbs = goodsbrandService.findByGoodsType(Long.parseLong(type_id));
		List<Map> list = new ArrayList<Map>();
		for (GoodsBrand gb : gbs) {
			Map map = new HashMap();
			map.put("id", gb.getId());
			map.put("name", gb.getName());
			list.add(map);
		}
		String temp = Json.toJson(list, JsonFormat.compact());
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(temp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}