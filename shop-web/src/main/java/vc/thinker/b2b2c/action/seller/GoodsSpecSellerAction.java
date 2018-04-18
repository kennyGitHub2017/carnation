package vc.thinker.b2b2c.action.seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;
import vc.thinker.b2b2c.core.tools.database.DatabaseTools;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsSpecPropertyBO;
import com.sinco.carnation.goods.bo.GoodsSpecificationBO;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.model.GoodsSpecProperty;
import com.sinco.carnation.goods.model.GoodsSpecification;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsSpecPropertyService;
import com.sinco.carnation.goods.service.GoodsSpecificationService;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.goods.vo.GoodsSpecificationVO;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;

import freemarker.core.ParseException;

/**
 * 
 * <p>
 * Title: GoodsSpecSellerAction.java
 * </p>
 * 
 * <p>
 * Description: 商家商品规格管理控制器，商家可以自行管理规格属性，发不商品时商家选择自己添加的规格属性，规格属性只在商品详细页显示并可以选择，
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
 * @date 2014-5-7
 * 
 * @version 1.0.1
 */
@Controller
public class GoodsSpecSellerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private GoodsSpecificationService goodsSpecService;
	@Autowired
	private GoodsSpecPropertyService goodsSpecPropertyService;
	@Autowired
	private DatabaseTools databaseTools;
	@Autowired
	private StoreTools shopTools;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private DicContent dicContent;

	/**
	 * GoodsSpecification列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商品规格列表", value = "/seller/goods_spec_list.htm*", rtype = "seller", rname = "规格管理", rcode = "spec_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_spec_list.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,
			MyPage<GoodsSpecificationBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_spec_list.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		this.goodsSpecService.listByStoreyId(page, userDetails.getStoreId());;
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
	@SecurityMapping(title = "商品规格添加", value = "/seller/goods_spec_add.htm*", rtype = "seller", rname = "规格管理", rcode = "spec_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_spec_add.htm")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_spec_add.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		mv.addObject("store_id", userDetails.getStoreId());
		Store store = storeService.getObjById(userDetails.getStoreId());
		Set<GoodsClass> gcs = this.shopTools.query_store_DetailGc(store.getGcDetailInfo());// 解析所有详细类目
		GoodsClassBO main_gc = this.dicContent.getTreeDic(GoodsClassBO.class,
				CommUtil.null2String(store.getGcMainId()));
		if (gcs.size() > 0) {// 如果商家注册时选择了详细类目
			mv.addObject("gcs", gcs);
		} else {// 如果商家注册时没有选择详细类目，将查询主营类目的所有下级类目
			mv.addObject("gcs", main_gc.getChilds());
		}
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
	@SecurityMapping(title = "商品规格编辑", value = "/seller/goods_spec_edit.htm*", rtype = "seller", rname = "规格管理", rcode = "spec_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_spec_edit.htm")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_spec_add.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Store store = storeService.getObjById(userDetails.getStoreId());
		if (id != null && !id.equals("")) {
			GoodsSpecificationBO goodsSpecification = this.goodsSpecService.findBOById(Long.parseLong(id));
			if (goodsSpecification != null) {
				if (goodsSpecification.getStoreId().equals(store.getId())) {
					mv.addObject("obj", goodsSpecification);
					mv.addObject("currentPage", currentPage);
					mv.addObject("store_id", store.getId());
					mv.addObject("edit", true);
					Set<GoodsClass> gcs = this.shopTools.query_store_DetailGc(store.getGcDetailInfo());// 解析所有详细类目
					GoodsClassBO main_gc = this.dicContent.getTreeDic(GoodsClassBO.class,
							CommUtil.null2String(store.getGcMainId()));
					if (gcs.size() > 0) {// 如果商家注册时选择了详细类目
						mv.addObject("gcs", gcs);
					} else {// 如果商家注册时没有选择详细类目，将查询主营类目的所有下级类目
						mv.addObject("gcs", main_gc.getChilds());
					}
					GoodsClassBO gc_details = this.dicContent.getTreeDic(GoodsClassBO.class,
							CommUtil.null2String(goodsSpecification.getGoodsClassId()));
					mv.addObject("gc_details", gc_details.getChilds());
				} else {
					mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("url", CommUtil.getURL(request) + "/seller/goods_spec_list.htm?currentPage="
							+ currentPage);
					mv.addObject("op_title", "您所访问的地址不存在");
				}
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("url", CommUtil.getURL(request) + "/seller/goods_spec_list.htm?currentPage="
						+ currentPage);
				mv.addObject("op_title", "您所访问的地址不存在");
			}
		}
		return mv;
	}

	/**
	 * goodsSpecification保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "商品规保存", value = "/seller/goods_spec_save.htm*", rtype = "seller", rname = "规格管理", rcode = "spec_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_spec_save.htm")
	public String save(HttpServletRequest request, HttpServletResponse response, String id, String count,
			String currentPage, String gc_id, String goodsClassDetailIds) {
//		WebForm wf = new WebForm();
//		GoodsSpecificationBO goodsSpecification = null;
//		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
//		if (id.equals("")) {
//			goodsSpecification = wf.toPo(request, GoodsSpecificationBO.class);
//			goodsSpecification.setAddTime(new Date());
//		} else {
//			GoodsSpecification obj = this.goodsSpecService.getObjById(Long.parseLong(id));
//			goodsSpecification = (GoodsSpecificationBO) wf.toPo(request, obj);
//		}
//		goodsSpecification.setSpecType(1);
//		goodsSpecification.setStoreId(userDetails.getStoreId());
//		if (gc_id != null && !gc_id.equals("")) {
//			goodsSpecification.setGoodsClassId(CommUtil.null2Long(gc_id));;
//		}
////		if (goodsClass_detail_ids != null && !goodsClass_detail_ids.equals("")) {
////			String ids[] = goodsClass_detail_ids.split(",");
////			List<GoodsClass> gc_list = new ArrayList<GoodsClass>();
////			for (String c_id : ids) {
////				GoodsClass gc_detail = this.goodsClassService.getObjById(CommUtil.null2Long(c_id));
////				if (gc_detail != null) {
////					gc_list.add(gc_detail);
////				}
////			}
////			if (gc_list.size() > 0) {
////				goodsSpecification.setSpecGoodsClassDetail(gc_list);
////			}
////		} else {
////			goodsSpecification.getSpecGoodsClassDetail().removeAll(goodsSpecification.getSpecGoodsClassDetail());
////		}
////		if (id.equals("")) {
////			this.goodsSpecService.save(goodsSpecification);
////		} else
////			this.goodsSpecService.update(goodsSpecification);
//		this.genericProperty(request, goodsSpecification, count);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		WebForm wf = new WebForm();
		GoodsSpecification goodsSpecification = wf.toPo(request, GoodsSpecification.class);
		goodsSpecification.setSpecType(1);
		goodsSpecification.setStoreId(userDetails.getStoreId());
		if (StringUtils.isNotBlank(id)) {
			goodsSpecification.setId(Long.parseLong(id));
		}

		List<Long> gcIdList = new ArrayList<Long>();

		if (goodsClassDetailIds != null && !goodsClassDetailIds.equals("")) {
			String ids[] = goodsClassDetailIds.split(",");
			for (String c_id : ids) {
				gcIdList.add(Long.parseLong(c_id));
			}
		}

		if (StringUtils.isNotBlank(gc_id)) {
			goodsSpecification.setGoodsClassId(Long.parseLong(gc_id));
		}

		List<GoodsSpecProperty> properties = this.genericProperty(request, goodsSpecification, count);

		this.goodsSpecService.save(goodsSpecification, gcIdList, properties);

		request.getSession(false).setAttribute("url",
				CommUtil.getURL(request) + "/seller/goods_spec_list.htm");
		request.getSession(false).setAttribute("op_title", "规格添加成功");
		return "redirect:/seller/success.htm";
	}

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

	@SecurityMapping(title = "商品规格删除", value = "/seller/goods_spec_del.htm*", rtype = "seller", rname = "规格管理", rcode = "spec_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_spec_del.htm")
	public String delete(HttpServletRequest request, String mulitId, String currentPage) {
		if (StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		String[] ids = mulitId.split(",");
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		userDetails.getStoreId();
		List<Long> idList = Lists.newArrayList();
		for (String id : ids) {
			if (!id.equals("")) {
				GoodsSpecification obj = this.goodsSpecService.getObjById(Long.parseLong(id));
				if (obj.getStoreId().equals(userDetails.getStoreId())) {
					idList.add(Long.parseLong(id));
				}
			}
		}
		if (idList.size() > 0) {
			try {
				this.goodsSpecService.batchDelete(idList);
			} catch (ServiceException e) {
				return "redirect:goods_spec_list.htm?currentPage=" + currentPage;
			}
		}
		return "redirect:goods_spec_list.htm?currentPage=" + currentPage;
	}
	
	/***
	 * 删除属性_new
	 * @param request
	 * @param response
	 * @param id
	 */
	@SecurityMapping(title = "商品规格Ajax删除", value = "/seller/goods_property_delete.htm*", rtype = "seller", rname = "规格管理", rcode = "spec_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_property_delete.htm")
	public void goods_property_delete(HttpServletRequest request, HttpServletResponse response, String id) {
		boolean ret = true;
		String errorMsg = null;
		if (!id.equals("")) {
			try {
				//ret = this.goodsSpecPropertyService.delete(Long.parseLong(id));
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

	@SecurityMapping(title = "规格名称验证", value = "/seller/goods_spec_verify.htm*", rtype = "seller", rname = "规格管理", rcode = "spec_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_spec_verify.htm")
	public void goods_spec_verify(HttpServletRequest request, HttpServletResponse response, String name,
			String id, Long store_id) {
		boolean ret = true;
		int count = this.goodsSpecService.countByNameAndStoreId(name, store_id,
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
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "规格新增分类加载", value = "/seller/spec_gc_load.htm*", rtype = "seller", rname = "规格管理", rcode = "spec_seller", rgroup = "商品管理")
	@RequestMapping("/seller/spec_gc_load.htm")
	public ModelAndView spec_gc_load(HttpServletRequest request, HttpServletResponse response, String gc_id,
			String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/spec_gc_load.html",
				configService.getSysConfig(), 0, request, response);
		if (gc_id != null && !gc_id.equals("")) {
			mv.addObject("gcs", dicContent.getTreeDic(GoodsClassBO.class, gc_id).getChilds());
		}
		if (id != null && !id.equals("")) {
			GoodsSpecification obj = this.goodsSpecService.getObjById(CommUtil.null2Long(id));
			mv.addObject("obj", obj);
		}
		return mv;
	}
	
	/***
	 * 异步的保存属性_new
	 * @param request
	 * @param response
	 * @param goodsSpecProperty 属性
	 */
	@RequestMapping("/seller/goods_property_save.htm")
	public void goods_property_save(HttpServletRequest request,
			HttpServletResponse response, GoodsSpecProperty goodsSpecProperty) {

		//boolean bl = this.goodsSpecPropertyService.save(goodsSpecProperty);
		this.goodsSpecPropertyService.addProperty(goodsSpecProperty);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter write;
		try {
			write = response.getWriter();
			write.print(goodsSpecProperty.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/***
	 * 属性上传图片_new
	 * @param request
	 * @param response
	 * @param fileName
	 * 
	 */
	@RequestMapping("/seller/goods_property_img_upload.htm")
	@ResponseBody
	public String goods_property_img_upload(HttpServletRequest request,HttpServletResponse response,String fileName, Long propertyId,String mark){
		String  filePath = this.accessoryService.upload(request, mark+"_file", null);
		return filePath;
	}
	/***
	 * 
	 * 根据规格ID和店铺ID 查询属性列表_new
	 * @return
	 */
	@RequestMapping("/seller/load_property.htm")
	public String loadGoodsPropertyByStoreId(Long specId, Long storeId) {
		List<GoodsSpecPropertyBO> list = this.goodsSpecPropertyService.getGoodsPropertyByStoreId(specId, storeId);
		String listStr = JSON.toJSONString(list);
		return listStr;
	}
	
	/***
	 * 模糊查询规格列表_NEW
	 * @return
	 */
	@RequestMapping("/seller/get_spec_list.htm")
	@ResponseBody
	public String getSpecList(HttpServletRequest request,HttpServletResponse response,String keyWords) {
		GoodsSpecificationVO vo = new GoodsSpecificationVO();
		vo.setDisplay(0);
		vo.setName(keyWords);
		vo.setSpecType(0);
		List<GoodsSpecificationBO> list = this.goodsSpecService.findByVO(null, vo);
		String str = Json.toJson(list);
		JSONArray a = JSONArray.fromObject(str);
		return a.toString();
	}
	
	/***
	 * 批量插入属性并返回插入对象
	 * @param request
	 * @param response
	 * @param specId
	 * @param propertyName
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/seller/goods_property_save_batch.htm")
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