package vc.thinker.b2b2c.action.seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.RequestResult;
import net.weedfs.client.WeedFSClient;

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
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

import com.sinco.carnation.express.service.ExpressCompanyCommonService;
import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.shop.bo.EcCommonBO;
import com.sinco.carnation.shop.bo.ExpressCompanyBO;
import com.sinco.carnation.shop.constants.EcCommonConstants;
import com.sinco.carnation.shop.constants.ExpressCompanyConstants;
import com.sinco.carnation.shop.model.EcCommon;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.shop.vo.EcCommonVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.transport.tools.TransportTools;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: ExpressCompanyManageAction.java
 * </p>
 * 
 * <p>
 * Description: 商家快递公司相关管理
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
 * @date 2014-10-29
 * 
 * @version 1.0.1
 */
@Controller
@SuppressWarnings({"unchecked", "unused", "rawtypes"})
public class ExpressCompanyCommonSellerAction {
	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private IUserConfigService userConfigService;
	@Autowired
	private ExpressCompanyService expressCompanyService;
//	@Autowired
//	private IOrderFormService orderFormService;
//	@Autowired
//	private IUserService userService;
	@Autowired
	private ExpressCompanyCommonService expressCompanyCommonService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private TransportTools transportTools;
	@Autowired
	private WeedFSClient fsClient;

	/**
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @return
	 */
	@SecurityMapping(title = "常用快递公司配置", value = "/seller/ecc_set.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_set.htm")
	public ModelAndView ecc_set(HttpServletRequest request, HttpServletResponse response, String currentPage,
			String orderBy, String orderType) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/ecc_set.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		List<ExpressCompanyBO> ecs = this.expressCompanyService
				.findListByStatus(ExpressCompanyConstants.COMPANY_STATUS_ENABLE);
		mv.addObject("ecs", ecs);
		mv.addObject("transportTools", transportTools);
		mv.addObject("storeId", store.getId());
		return mv;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param mulitId
	 */
	@SecurityMapping(title = "常用快递保存", value = "/seller/ecc_save.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_save.htm")
	public void ecc_save(HttpServletRequest request, HttpServletResponse response, String ids) {
		boolean ret = true;
		String[] ec_ids = ids.split(",");

		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}

		List<EcCommonBO> eccs = this.expressCompanyCommonService.selectAllByCondition(
				EcCommonConstants.ECC_TYPE_COMMON, store.getId());

//		Map params = new HashMap();
//		User user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		Store store = user.getStore();
//		params.put("ecc_type", 0);
//		params.put("ecc_store_id", store.getId());
//		List<ExpressCompanyCommon> eccs = this.expressCompanyCommonService.query(
//				"select obj from ExpressCompanyCommon obj where obj.ecc_type=:ecc_type and obj.ecc_store_id=:ecc_store_id",
//				params, -1, -1);

		for (EcCommonBO ecc : eccs) {// 首先删除邮件保存但是此次没有勾选的常用快递物流
			boolean delete = true;
			for (String ec_id : ec_ids) {
				if (!CommUtil.null2String(ec_id).equals("")) {
					if (ecc.getEccEcId().equals(CommUtil.null2Long(ec_id))) {
						delete = false;
					}
				}
			}
			if (delete) {
				this.expressCompanyCommonService.delete(ecc.getId());
			}
		}
		for (String ec_id : ec_ids) {
			if (!CommUtil.null2String(ec_id).equals("")) {
				eccs = this.expressCompanyCommonService.selectAllByCondition(0, store.getId(),
						CommUtil.null2Long(ec_id));

//				params.clear();
//				params.put("ecc_ec_id", CommUtil.null2Long(ec_id));
//				params.put("ecc_type", 0);
//				params.put("ecc_store_id", store.getId());
//				eccs = this.expressCompanyCommonService.query(
//						"select obj from ExpressCompanyCommon obj where obj.ecc_ec_id=:ecc_ec_id and  obj.ecc_type=:ecc_type and obj.ecc_store_id=:ecc_store_id",
//						params, -1, -1);

				if (eccs.size() == 0) {
					ExpressCompany ec = this.expressCompanyService.getObjById(CommUtil.null2Long(ec_id));
					EcCommon ecc = new EcCommon();
					ecc.setAddTime(new Date());
					ecc.setEccCode(ec.getCompanyMark());
					ecc.setEccEcId(ec.getId());
					ecc.setEccName(ec.getCompanyName());
					ecc.setEccStoreId(store.getId());
					ecc.setEccTemplate(ec.getCompanyTemplate());
					ecc.setEccTemplateHeigh(ec.getCompanyTemplateHeigh());
					ecc.setEccTemplateWidth(ec.getCompanyTemplateWidth());
					ecc.setEccTemplateOffset(ec.getCompanyTemplateOffset());
					ecc.setEccType(0);
					ecc.setEccEcType(ec.getCompanyType());
					this.expressCompanyCommonService.save(ecc);
				}

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

	/**
	 * ExpressCompany列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "常用快递公司列表", value = "/seller/ecc_list.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_list.htm")
	public ModelAndView ecc_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<EcCommonBO> page, EcCommonVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/ecc_list.html",
				configService.getSysConfig(), 0, request, response);

		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		page.setPageSize(25);
		vo.setEccType(0);
		vo.setStoreId(store.getId());
		this.expressCompanyCommonService.findListByVo(page, vo);
//		ExpressCompanyCommonQueryObject qo = new ExpressCompanyCommonQueryObject(currentPage, mv, "addTime", "desc");
//		qo.addQuery("obj.ecc_type", new SysMap("ecc_type", 0), "=");
//		qo.addQuery("obj.ecc_store_id", new SysMap("ecc_store_id", store.getId()), "=");
//		qo.setPageSize(25);
//		IPageList pList = this.expressCompanyCommonService.list(qo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("transportTools", transportTools);
		return mv;
	}

	/**
	 * ExpressCompany删除
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "常用快递公司删除", value = "/seller/ecc_delete.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_delete.htm")
	public String ecc_delete(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		EcCommon ecc = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (ecc.getEccStoreId().equals(store.getId())) {
			this.expressCompanyCommonService.delete(CommUtil.null2Long(id));
		}
		return "redirect:ecc_list.htm";
	}

	@SecurityMapping(title = "设置默认快递公司", value = "/seller/ecc_default.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_default.htm")
	public void ecc_default(HttpServletRequest request, HttpServletResponse response, String id) {
		boolean ret = true;
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		if (!CommUtil.null2String(id).equals("") && obj.getEccStoreId().equals(store.getId())) {
//			Map params = new HashMap();
//			params.put("ecc_default", 1);
//			params.put("ecc_type", 0);
//			params.put("ecc_store_id", store.getId());
//			List<ExpressCompanyCommon> eccs = this.expressCompanyCommonService.query(
//					"select obj from ExpressCompanyCommon obj where obj.ecc_default=:ecc_default and obj.ecc_type=:ecc_type and obj.ecc_store_id=:ecc_store_id",
//					params, -1, -1);
			List<EcCommonBO> eccs = this.expressCompanyCommonService
					.selectAllByCondition(0, 1, store.getId());
			for (EcCommonBO ecc : eccs) {
				ecc.setEccDefault(0);
				this.expressCompanyCommonService.update(ecc);
			}
			obj.setEccDefault(1);
			ret = this.expressCompanyCommonService.update(obj);
		} else {
			ret = false;
		}

		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "取消默认快递公司", value = "/seller/ecc_default_cancle.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_default_cancle.htm")
	public void ecc_default_cancle(HttpServletRequest request, HttpServletResponse response, String id) {
		boolean ret = true;
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		if (!CommUtil.null2String(id).equals("") && obj.getEccStoreId().equals(store.getId())) {
			obj.setEccDefault(0);
			ret = this.expressCompanyCommonService.update(obj);
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

	@SecurityMapping(title = "运费单打印测试", value = "/seller/ecc_print_view.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_print_view.htm")
	public ModelAndView ecc_print_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/ecc_print_view.html",
				configService.getSysConfig(), 0, request, response);
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (obj != null && obj.getEccStoreId().equals(store.getId()) && obj.getEccTemplateOffset() != null) {
			Map offset_map = Json.fromJson(Map.class, obj.getEccTemplateOffset());
			if (CommUtil.null2String(obj.getEccTemplate()).equals("")) {
				mv = new JModelAndView("user/default/sellercenter/seller_error.html",
						configService.getSysConfig(), 0, request, response);
				mv.addObject("op_title", "该快递暂无模板，无法打印");
			} else {
				mv.addObject("offset_map", offset_map);
				mv.addObject("obj", obj);
			}
		}
		return mv;
	}

	@SecurityMapping(title = "运费单打印设置", value = "/seller/ecc_print_set.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_print_set.htm")
	public ModelAndView ecc_print_set(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/ecc_print_set.html",
				configService.getSysConfig(), 0, request, response);
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (obj != null && obj.getEccStoreId().equals(store.getId()) && obj.getEccTemplateOffset() != null) {
			Map offset_map = Json.fromJson(Map.class, obj.getEccTemplateOffset());
			if (CommUtil.null2String(obj.getEccTemplate()).equals("")) {
				mv = new JModelAndView("user/default/sellercenter/seller_error.html",
						configService.getSysConfig(), 0, request, response);
				mv.addObject("op_title", "该快递暂无模板，无法设置");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/ecc_list.htm");
			} else {
				mv.addObject("obj", obj);
				mv.addObject("offset_map", offset_map);
			}
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "物流参数错误，无法设置");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/ecc_list.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "快递单偏移量保存", value = "/seller/ecc_print_set_save.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_print_set_save.htm")
	public void ecc_print_set_save(HttpServletRequest request, HttpServletResponse response, String id,
			String left_offset, String top_offset) {
		boolean ret = true;
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		if (obj != null && obj.getEccStoreId().equals(store.getId())) {
			Map offset_map = Json.fromJson(Map.class, obj.getEccTemplateOffset());
			if (offset_map.get("receipt_user_left") != null) {
				Iterator it = offset_map.keySet().iterator();
				while (it.hasNext()) {
					String key = CommUtil.null2String(it.next());
					if (key.indexOf("_left") > 0) {
						float value = CommUtil.null2Float(offset_map.get(key));
						System.out.println(key + "  " + value);
						value = value + CommUtil.null2Float(left_offset);
						offset_map.put(key, CommUtil.null2String(value));
					}
					if (key.indexOf("_top") > 0) {
						float value = CommUtil.null2Float(offset_map.get(key));
						System.out.println(key + "  " + value);
						value = value + CommUtil.null2Float(top_offset);
						offset_map.put(key, CommUtil.null2String(value));
					}
				}
				obj.setEccTemplateOffset(Json.toJson(offset_map, JsonFormat.compact()));
				ret = this.expressCompanyCommonService.update(obj);
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

	@SecurityMapping(title = "自建物流模板配置", value = "/seller/ecc_create.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_create.htm")
	public ModelAndView ecc_create(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/ecc_create.html",
				configService.getSysConfig(), 0, request, response);
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (obj != null && obj.getEccStoreId().equals(store.getId())) {
			mv.addObject("obj", obj);
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "物流参数错误，无法设置");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/ecc_list.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "自建物流模板保存", value = "/seller/ecc_template_save.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_template_save.htm")
	public ModelAndView ecc_template_save(HttpServletRequest request, HttpServletResponse response,
			String id, String ecc_template_width, String ecc_template_heigh,
			@RequestParam("ecc_template_acc") MultipartFile file) {
		EcCommon obj = this.expressCompanyCommonService.getObjById(Long.parseLong(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (obj != null && obj.getEccStoreId().equals(store.getId())) {
			if (file != null && file.getSize() != 0) {
				try {
					String fileUrl=FileUploadTools.fileUpload(file, UploadConstants.EDITOR);
					obj.setEccTemplate(fileUrl);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
//			String uploadFilePath = this.configService.getSysConfig().getUploadFilePath();
//			String saveFilePathName = request.getSession().getServletContext().getRealPath("/") + uploadFilePath
//					+ File.separator + "ecc_template";
//			Map map = new HashMap();
//			try {
//				map = CommUtil.saveFileToServer(request, "ecc_template_acc", saveFilePathName, "", null);
//				if (map.get("fileName") != "") {
//					String company_template = uploadFilePath + "/ecc_template/"
//							+ CommUtil.null2String(map.get("fileName"));
//					obj.setEccTemplate(company_template);
//				}
//
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			obj.setEccFromType(1);// 设置为自建模板
			obj.setEccTemplateOffset(null);
			obj.setDeleteStatus(false);
			obj.setEccTemplateHeigh(CommUtil.null2Int(ecc_template_heigh));
			obj.setEccTemplateWidth(CommUtil.null2Int(ecc_template_width));
			this.expressCompanyCommonService.update(obj);
			ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_success.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("url", CommUtil.getURL(request) + "/seller/ecc_list.htm");
			mv.addObject("op_title", "自建物流模板保存成功");
			return mv;
		} else {
			ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "物流参数错误，无法设置");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/ecc_list.htm");
			return mv;
		}
	}

	@SecurityMapping(title = "恢复系统默认物流", value = "/seller/ecc_bind_defalut_template.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_bind_defalut_template.htm")
	public ModelAndView ecc_bind_defalut_template(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		EcCommon obj = this.expressCompanyCommonService.getObjById(Long.parseLong(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (obj != null && obj.getEccStoreId().equals(store.getId())) {
			ExpressCompany ec = this.expressCompanyService.getObjById(obj.getEccEcId());
			obj.setEccCode(ec.getCompanyMark());
			obj.setEccName(ec.getCompanyName());
			obj.setEccStoreId(store.getId());
			obj.setEccTemplate(ec.getCompanyTemplate());
			obj.setEccTemplateHeigh(ec.getCompanyTemplateHeigh());
			obj.setEccTemplateWidth(ec.getCompanyTemplateWidth());
			obj.setEccTemplateOffset(ec.getCompanyTemplateOffset());
			obj.setEccFromType(0);// 恢复为系统默认模板
			obj.setEccEcType(ec.getCompanyType());
			this.expressCompanyCommonService.update(obj);
			ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_success.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("url", CommUtil.getURL(request) + "/seller/ecc_list.htm");
			mv.addObject("op_title", "恢复系统默认模板成功");
			return mv;
		} else {
			ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "物流参数错误，无法设置");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/ecc_list.htm");
			return mv;
		}

	}

	@SecurityMapping(title = "自建物流模板设计", value = "/seller/ecc_design.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_design.htm")
	public ModelAndView ecc_design(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/ecc_design.html",
				configService.getSysConfig(), 0, request, response);
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (obj != null && obj.getEccStoreId().equals(store.getId())) {
			Map offset_map = Json.fromJson(Map.class, CommUtil.null2String(obj.getEccTemplateOffset()));
			mv.addObject("offset_map", offset_map);
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "物流参数错误，无法设置");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/ecc_list.htm?currentPage=" + currentPage);
		}
		return mv;
	}

	@SecurityMapping(title = "自建物流模板设计", value = "/seller/ecc_design.htm*", rtype = "seller", rname = "常用物流", rcode = "seller_ecc", rgroup = "交易管理")
	@RequestMapping("/seller/ecc_design_save.htm")
	public void ecc_design_save(HttpServletRequest request, HttpServletResponse response, String id) {
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		boolean ret = true;
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (obj != null && obj.getEccStoreId().equals(store.getId())) {
			Map map = new HashMap();
			java.util.Enumeration enum1 = request.getParameterNames();
			while (enum1.hasMoreElements()) {
				String paramName = (String) enum1.nextElement();
				String value = request.getParameter(paramName);
				if (!paramName.equals("id") && !CommUtil.null2String(value).equals("")
						&& !CommUtil.null2String(value).equals("null")) {
					map.put(paramName, value);
				}
			}
			System.out.println(Json.toJson(map, JsonFormat.compact()));
			obj.setEccTemplateOffset(Json.toJson(map, JsonFormat.compact()));
			this.expressCompanyCommonService.update(obj);
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