package vc.thinker.b2b2c.action.self;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

import com.sinco.carnation.express.service.ExpressCompanyCommonService;
import com.sinco.carnation.express.service.ExpressCompanyService;
//import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.bo.EcCommonBO;
import com.sinco.carnation.shop.bo.ExpressCompanyBO;
import com.sinco.carnation.shop.constants.EcCommonConstants;
import com.sinco.carnation.shop.constants.ExpressCompanyConstants;
import com.sinco.carnation.shop.model.EcCommon;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.shop.vo.EcCommonVO;
import com.sinco.carnation.sys.service.SysConfigService;
//import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.transport.tools.TransportTools;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: ExpressCompanyCommonManageAction.java
 * </p>
 * 
 * <p>
 * Description: 平台自营中的常用物流管理，用来处理自营中的常用信息，包括常用物流配置，常用物流模板设置，默认物流设置，常用物流模板打印偏移量配置等等内容
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
 * @date 2014-11-19
 * 
 * @version 1.0.1
 */
@Controller
public class SelfExpressCommonManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ExpressCompanyService expressCompanyService;
//	@Autowired
//	private OrderFormService orderFormService;
//	@Autowired
//	private UserService userService;
	@Autowired
	private ExpressCompanyCommonService expressCompanyCommonService;
	@Autowired
	private TransportTools transportTools;
	@Autowired
	private WeedFSClient fsClient;

	@SecurityMapping(title = "常用物流配置", value = "/admin/ecc_set.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_set.htm")
	public ModelAndView ecc_set(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/ecc_set.html", configService.getSysConfig(), 0,
				request, response);
		List<ExpressCompanyBO> ecs = this.expressCompanyService
				.findListByStatus(ExpressCompanyConstants.COMPANY_STATUS_ENABLE);
		mv.addObject("ecs", ecs);
		mv.addObject("transportTools", transportTools);
		return mv;
	}

	@SecurityMapping(title = "常用物流配置", value = "/admin/ecc_save.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_save.htm")
	public void ecc_save(HttpServletRequest request, HttpServletResponse response, String ids) {
		boolean ret = false;
		String[] ecIds = ids.split(",");
		if (ecIds != null && ecIds.length > 0) {
			ret = this.expressCompanyCommonService.ecCommonSave(ecIds);
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

	@SecurityMapping(title = "常用物流列表", value = "/admin/ecc_list.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_list.htm")
	public ModelAndView ecc_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, EcCommonVO vo, MyPage<EcCommonBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/ecc_list.html", configService.getSysConfig(), 0,
				request, response);
		page.setPageSize(25);
		this.expressCompanyCommonService.findListByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("transportTools", transportTools);
		mv.addObject("vo", vo);
		return mv;
	}

	@SecurityMapping(title = "设置为默认物流", value = "/admin/ecc_default.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_default.htm")
	public void ecc_default(HttpServletRequest request, HttpServletResponse response, Long id) {
		boolean ret = true;
		if (id != null) {
			List<EcCommonBO> eccs = null;
			EcCommon obj = this.expressCompanyCommonService.getObjById(id);
			if (obj != null && obj.getEccType() == EcCommonConstants.ECC_TYPE_SELF) {
				eccs = this.expressCompanyCommonService.selectAllByCondition(EcCommonConstants.ECC_TYPE_SELF,
						EcCommonConstants.ECC_IS_DEFAULT);
			}
			for (EcCommonBO ecc : eccs) {
				ecc.setEccDefault(EcCommonConstants.ECC_IS_NOT_DEFAULT);
				this.expressCompanyCommonService.update(ecc);
			}
			obj.setEccDefault(EcCommonConstants.ECC_IS_DEFAULT);
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
			writer.print(ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "取消默认物流", value = "/admin/ecc_default_cancle.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_default_cancle.htm")
	public void ecc_default_cancle(HttpServletRequest request, HttpServletResponse response, Long id) {
		boolean ret = true;
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		if (id != null && id > 0 && obj.getEccType() == EcCommonConstants.ECC_TYPE_SELF) {
			obj.setEccDefault(EcCommonConstants.ECC_IS_NOT_DEFAULT);
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
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "常用物流打印测试", value = "/admin/ecc_print_view.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_print_view.htm")
	public ModelAndView ecc_print_view(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/ecc_print_view.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && id > 0) {
			EcCommon obj = this.expressCompanyCommonService.getObjById(id);
			if (obj.getEccType() == EcCommonConstants.ECC_TYPE_SELF) {
				Map offsetMap = Json.fromJson(Map.class, CommUtil.null2String(obj.getEccTemplateOffset()));
				if (CommUtil.null2String(obj.getEccTemplate()).equals("")) {
					mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
							response);
					mv.addObject("op_title", "该快递暂无模板，无法打印");
				} else {
					mv.addObject("offset_map", offsetMap);
					mv.addObject("obj", obj);
				}
			}
		}
		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "常用物流打印偏移量设置", value = "/admin/ecc_print_set.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_print_set.htm")
	public ModelAndView ecc_print_set(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/ecc_print_set.html", configService.getSysConfig(), 0,
				request, response);
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		if (obj.getEccType() == EcCommonConstants.ECC_TYPE_SELF
				&& !CommUtil.null2String(obj.getEccTemplateOffset()).equals("")) {
			Map offset_map = Json.fromJson(Map.class, obj.getEccTemplateOffset());
			if (CommUtil.null2String(obj.getEccTemplate()).equals("")) {
				mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
						response);
				mv.addObject("op_title", "该快递暂无模板，无法设置");
			} else {
				mv.addObject("obj", obj);
				mv.addObject("offset_map", offset_map);
			}
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "物流参数错误，无法设置");
			mv.addObject("url", CommUtil.getURL(request) + "/admin/ecc_list.htm");
		}
		return mv;
	}

	@SuppressWarnings({"unused", "rawtypes", "unchecked"})
	@SecurityMapping(title = "常用物流打印偏移量配置保存", value = "/admin/ecc_print_set_save.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_print_set_save.htm")
	public ModelAndView ecc_print_set_save(HttpServletRequest request, HttpServletResponse response,
			String id, String left_offset, String top_offset) {
		boolean ret = true;
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		if (obj.getEccType() == EcCommonConstants.ECC_TYPE_SELF
				&& !CommUtil.null2String(obj.getEccTemplateOffset()).equals("")) {
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
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/ecc_list.htm");
		mv.addObject("op_title", "运费打印模板偏移量保存成功");
		return mv;
	}

	@SecurityMapping(title = "自建物流模板", value = "/admin/ecc_create.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_create.htm")
	public ModelAndView ecc_create(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/ecc_create.html", configService.getSysConfig(), 0,
				request, response);
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		if (obj != null && obj.getEccType() == EcCommonConstants.ECC_TYPE_SELF) {
			mv.addObject("obj", obj);
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "物流参数错误，无法设置");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/ecc_list.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "自建物流模板保存", value = "/admin/ecc_template_save.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_template_save.htm")
	public ModelAndView ecc_template_save(HttpServletRequest request, HttpServletResponse response,
			String currentPage, EcCommon obj, @RequestParam("eccTemplateAcc") MultipartFile file) {
		if (obj != null && obj.getEccType() == EcCommonConstants.ECC_TYPE_SELF) {
			if (file != null && file.getSize() != 0) {
				try {
					String fileUrl=FileUploadTools.fileUpload(file, UploadConstants.EDITOR);
					
					obj.setEccTemplate(fileUrl);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			obj.setEccFromType(EcCommonConstants.ECC_FROM_IS_SELF);// 设置为自建模板
			obj.setEccTemplateOffset(null);
			obj.setEccTemplateHeigh(CommUtil.null2Int(obj.getEccTemplateHeigh()));
			obj.setEccTemplateWidth(CommUtil.null2Int(obj.getEccTemplateWidth()));
			this.expressCompanyCommonService.update(obj);
			ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
					request, response);
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/ecc_list.htm");
			mv.addObject("op_title", "自建物流模板保存成功");
			return mv;
		} else {
			ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
					request, response);
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/ecc_list.htm");
			mv.addObject("op_title", "物流参数错误，无法设置");
			return mv;
		}
	}

	@SecurityMapping(title = "绑定系统默认物流", value = "/admin/ecc_bind_defalut_template.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_bind_defalut_template.htm")
	public ModelAndView ecc_bind_defalut_template(HttpServletRequest request, HttpServletResponse response,
			String id) {
		EcCommon obj = this.expressCompanyCommonService.getObjById(Long.parseLong(id));
		if (obj != null && obj.getEccType() == EcCommonConstants.ECC_TYPE_SELF) {
			ExpressCompany ec = this.expressCompanyService.getObjById(obj.getEccEcId());
			obj.setEccType(EcCommonConstants.ECC_TYPE_SELF);
			obj.setEccCode(ec.getCompanyMark());
			obj.setEccName(ec.getCompanyName());
			obj.setEccTemplate(ec.getCompanyTemplate());
			obj.setEccTemplateHeigh(ec.getCompanyTemplateHeigh());
			obj.setEccTemplateWidth(ec.getCompanyTemplateWidth());
			obj.setEccTemplateOffset(ec.getCompanyTemplateOffset());
			obj.setEccFromType(EcCommonConstants.ECC_FROM_IS_SYSTEM);// 恢复为系统默认模板
			obj.setEccEcType(ec.getCompanyType());
			this.expressCompanyCommonService.update(obj);
			ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
					request, response);
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/ecc_list.htm");
			mv.addObject("op_title", "恢复系统默认模板成功");
			return mv;
		} else {
			ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
					request, response);
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/ecc_list.htm");
			mv.addObject("op_title", "物流参数错误，无法设置");
			return mv;
		}
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "自建物流模板保存", value = "/admin/ecc_design.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_design.htm")
	public ModelAndView ecc_design(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/ecc_design.html", configService.getSysConfig(), 0,
				request, response);
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		if (obj != null && obj.getEccType() == EcCommonConstants.ECC_TYPE_SELF) {
			Map offsetMap = Json.fromJson(Map.class, CommUtil.null2String(obj.getEccTemplateOffset()));
			mv.addObject("offset_map", offsetMap);
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "物流参数错误，无法设置");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/ecc_list.htm?currentPage="
					+ currentPage);
		}
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "自建物流模板保存", value = "/admin/ecc_design_save.htm*", rtype = "admin", rname = "常用物流", rcode = "ecc_self", rgroup = "商城管理")
	@RequestMapping("/admin/ecc_design_save.htm")
	public void ecc_design_save(HttpServletRequest request, HttpServletResponse response, String id) {
		EcCommon obj = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(id));
		boolean ret = true;
		if (obj != null && obj.getEccType() == EcCommonConstants.ECC_TYPE_SELF) {
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
			e.printStackTrace();
		}
	}
}
