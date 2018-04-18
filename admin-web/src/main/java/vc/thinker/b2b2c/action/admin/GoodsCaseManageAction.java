package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import vc.thinker.b2b2c.lucene.GoodsDocument;
import vc.thinker.b2b2c.lucene.LuceneCommonUtil;
import vc.thinker.b2b2c.lucene.LuceneResult;
import vc.thinker.b2b2c.lucene.LuceneUtil;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsCaseBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsCase;
import com.sinco.carnation.goods.service.GoodsCaseService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.vo.GoodsCaseVO;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsClassBO;
import com.sinco.carnation.juanpi.service.JuanpiGoodsClassService;
import com.sinco.carnation.juanpi.service.JuanpiGoodsService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

import freemarker.core.ParseException;

/**
 * <p>
 * Title: GoodsCaseManageAction.java
 * </p>
 * 
 * <p>
 * Description: 平台橱窗管理控制器，用来管理首页等页面橱窗展示，首页橱窗展示位置在推荐商品通栏的tab页
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
 * @date 2014-9-16
 * @version 1.0.1
 */
@Controller
@SuppressWarnings({"rawtypes", "unused"})
public class GoodsCaseManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsCaseService goodscaseService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private JuanpiGoodsService juanpiGoodsService;
	@Autowired
	private JuanpiGoodsClassService juanpiGoodsClassService;
	/**
	 * GoodsCase列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "橱窗列表", value = "/admin/goods_case_list.htm*", rtype = "admin", rname = "橱窗管理", rcode = "goods_case", rgroup = "商城管理")
	@RequestMapping("/admin/goods_case_list.htm")
	public ModelAndView goods_case_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, GoodsCaseVO vo, MyPage<GoodsCaseBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_case_list.html", configService.getSysConfig(),
				0, request, response);

		this.goodscaseService.findPageByVO(vo, page);

		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}

	/**
	 * goodscase添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "橱窗添加", value = "/admin/goods_case_add.htm*", rtype = "admin", rname = "橱窗管理", rcode = "goods_case", rgroup = "商城管理")
	@RequestMapping("/admin/goods_case_add.htm")
	public ModelAndView goods_case_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_case_add.html", configService.getSysConfig(),
				0, request, response);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * goodscase编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "橱窗编辑", value = "/admin/goods_case_edit.htm*", rtype = "admin", rname = "橱窗管理", rcode = "goods_case", rgroup = "商城管理")
	@RequestMapping("/admin/goods_case_edit.htm")
	public ModelAndView goods_case_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_case_add.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && !id.equals("")) {
			GoodsCase goodscase = this.goodscaseService.getObjById(Long.parseLong(id));
			List list = (List) Json.fromJson(goodscase.getCaseContent());
			if (list != null && list.size() > 0)
				mv.addObject("count", list.size());
			mv.addObject("obj", goodscase);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * goodscase保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "橱窗保存", value = "/admin/goods_case_save.htm*", rtype = "admin", rname = "橱窗管理", rcode = "goods_case", rgroup = "商城管理")
	@RequestMapping("/admin/goods_case_save.htm")
	public ModelAndView goods_case_save(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String list_url, String add_url, GoodsCase goodsCase) {
		if (goodsCase != null) {
			if (goodsCase.getCaseContent() != null && !goodsCase.getCaseContent().equals("")) {
				List<Long> list = new ArrayList<Long>();
				for (String str : goodsCase.getCaseContent().split(",")) {
					if (str != null && !str.equals("")) {
						list.add(CommUtil.null2Long(str));
					}
				}
				Map<String, List<Long>> map = new HashMap<String, List<Long>>();
				map.put("ids", list);
				goodsCase.setCaseContent(Json.toJson(list, JsonFormat.compact()));
			}

			if (goodsCase.getId() != null && goodsCase.getId() > 0) {
				this.goodscaseService.update(goodsCase);
			} else {
				goodsCase.setAddTime(new Date());
				this.goodscaseService.save(goodsCase);
			}
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存橱窗成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?currentPage=" + currentPage);
		}
		return mv;
	}

	@SecurityMapping(title = "橱窗删除", value = "/admin/goods_case_del.htm*", rtype = "admin", rname = "橱窗管理", rcode = "goods_case", rgroup = "商城管理")
	@RequestMapping("/admin/goods_case_del.htm")
	public String goods_case_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				GoodsCase goodscase = this.goodscaseService.getObjById(Long.parseLong(id));
				this.goodscaseService.delete(Long.parseLong(id));
			}
		}
		return "redirect:goods_case_list.htm?currentPage=1";
	}

	@SecurityMapping(title = "橱窗Ajax更新", value = "/admin/goods_case_del.htm*", rtype = "admin", rname = "橱窗管理", rcode = "goods_case", rgroup = "商城管理")
	@RequestMapping("/admin/goods_case_ajax.htm")
	public void goods_case_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
		GoodsCase obj = this.goodscaseService.getObjById(Long.parseLong(id));
		Field[] fields = GoodsCase.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(obj);
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
					val = !CommUtil.null2Boolean(wrapper.getPropertyValue(fieldName));
				}
				if (field.getName().equals("display")) {
					if (obj.getDisplay() == 1) {
						obj.setDisplay(0);
						val = obj.getDisplay();
					} else {
						obj.setDisplay(1);
						val = obj.getDisplay();
					}
				}
				wrapper.setPropertyValue(fieldName, val);
			}
		}
		this.goodscaseService.update(obj);
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

	@SecurityMapping(title = "橱窗商品添加", value = "/admin/goods_case_goods.htm*", rtype = "admin", rname = "橱窗管理", rcode = "goods_case", rgroup = "商城管理")
	@RequestMapping("/admin/goods_case_goods.htm")
	public ModelAndView goods_case_goods(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id, String goods_ids) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_case_goods.html", configService.getSysConfig(),
				0, request, response);
		if (goods_ids != null && !goods_ids.equals("")) {
			List<Goods> goodsList = new ArrayList<Goods>();
			String ids[] = goods_ids.split(",");
			
			for (String gid : ids) {
				if (!gid.equals("")) {
				
					if (gid.contains("jp_")) {
						Goods obj = new Goods();
						String[] thisId = gid.split("_");
						JuanpiGoodsBO juanpiGoodsBO = this.juanpiGoodsService.findOne(CommUtil.null2Long(thisId[1]));
						if (juanpiGoodsBO != null) {
							obj.setGoodsName(juanpiGoodsBO.getGoodsTitle());
							obj.setGoodsMainPhotoPath(juanpiGoodsBO.getImageUrl());
							obj.setGoodsShowPrice(juanpiGoodsBO.getGoodsCprice());
							obj.setId(CommUtil.null2Long(thisId[1]));
							obj.setIsJuanpi(1);
							goodsList.add(obj);
						}
					} else {
						Goods obj = this.goodsService.getObjById(CommUtil.null2Long(gid));
						goodsList.add(obj);
					}
					
				}
			}
			mv.addObject("goods_list", goodsList);
		} else if (id != null && !id.equals("")) {
			List<Goods> goodsList = new ArrayList<Goods>();
			GoodsCase goodscase = this.goodscaseService.getObjById(CommUtil.null2Long(id));
			List list = (List) Json.fromJson(goodscase.getCaseContent());
			if (list != null && list.size() > 0) {
				for (Object obj : list) {
					Goods goods = this.goodsService.getObjById(CommUtil.null2Long(obj));
					goodsList.add(goods);
				}
			}
			// 已添加商品
			mv.addObject("goods_list", goodsList);
			// 年会活动商品不用加推荐图片
			mv.addObject("otherCase", goodscase.getOtherCase());
		}

		mv.addObject("goods_ids", goods_ids);
		mv.addObject("id", id);
		return mv;
	}

	@SecurityMapping(title = "商品分类异步加载", value = "/admin/goods_case_gc.htm*", rtype = "admin", rname = "橱窗管理", rcode = "goods_case", rgroup = "商城管理")
	@RequestMapping("/admin/goods_case_gc.htm")
	public ModelAndView goods_case_gc(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_case_gc.html", configService.getSysConfig(), 0,
				request, response);
		List<GoodsClassBO> gcs = this.goodsClassService.findLevelAll(true);
		mv.addObject("gcs", gcs);
		return mv;
	}

	@SecurityMapping(title = "商品加载", value = "/admin/goods_case_goods_load.htm*", rtype = "admin", rname = "橱窗管理", rcode = "goods_case", rgroup = "商城管理")
	@RequestMapping("/admin/goods_case_goods_load.htm")
	public ModelAndView goods_case_goods_load(HttpServletRequest request, HttpServletResponse response,
			String currentPage, GoodsVO vo, MyPage<GoodsBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_case_goods_load.html",
				configService.getSysConfig(), 0, request, response);
		if (vo != null) {
			if (vo.getGcId() != null) {
				Set<Long> ids = this.goodsClassService.genericIds(vo.getGcId());
				vo.setGcIds(ids);
			}
			page.setPageSize(7);
			vo.setIsYgb(0);// 展示非云购币产品
			goodsService.findPageByVo(page, vo);
			mv.addObject("vo", vo);
			CommUtil.saveIPageList2ModelAndView(
					CommUtil.getURL(request) + "/admin/goods_case_goods_load.htm",
					
					"",
					"&gcId=" + (vo.getGcId() == null ? "" : vo.getGcId()) + "&goodsName=" + vo.getGoodsName(),
					page, mv);
		}
		return mv;
	}
	
	
	/***
	 * 从缓存中加载产品
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "商品加载", value = "/admin/goods_case_goods_load_all.htm*", rtype = "admin", rname = "橱窗管理", rcode = "goods_case", rgroup = "商城管理")
	@RequestMapping("/admin/goods_case_goods_load_all.htm")
	public ModelAndView goods_case_goods_load_all(HttpServletRequest request, HttpServletResponse response,
			Integer currentPage, GoodsVO vo, MyPage<GoodsBO> page,LuceneResult luceneResult) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_case_goods_load_all.html",
				configService.getSysConfig(), 0, request, response);
		
			String goods_class = "";
			String juanpi_class = "";
			
			if(null != vo) {
				GoodsClassBO goodsClass = this.goodsClassService.getBOById(vo.getGcId());
				if (goodsClass != null && goodsClass.getParentId() != null) {
					goods_class = goodsClass.getParentId() + "_" + vo.getGcId();
				}
				
				List<JuanpiGoodsClassBO>  juanpiClass = this.juanpiGoodsClassService.findByClass3Id(CommUtil.null2Long(vo.getGcId()));
				if (juanpiClass != null && juanpiClass.size() > 0) {
					for (JuanpiGoodsClassBO jgc : juanpiClass) {
						juanpi_class += jgc.getCate3Id() + ",";
					}
				}
				if (juanpi_class.length() > 1) {
					juanpi_class = juanpi_class.substring(0, juanpi_class.length()-1);
				}
				
				if (luceneResult.getCurrentPage() == 0) {
					luceneResult.setCurrentPage(1);
				}
				
				LuceneResult pList = this.luceneUtil.search(GoodsDocument.class, vo.getGoodsName(), 
						luceneResult.getCurrentPage()-1, 7,null, null, goods_class, null,
						null, null, null, null, null, false, null,
						false, false, juanpi_class);
				LuceneCommonUtil.saveLucene2ModelAndView(pList, mv);
				
				mv.addObject("goodsName", vo.getGoodsName());
				mv.addObject("gcId", vo.getGcId());
			}
		return mv;
	}
}