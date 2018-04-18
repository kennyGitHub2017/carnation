package vc.thinker.b2b2c.action.admin;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.weedfs.client.WeedFSClient;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.shop.bo.ExpressCompanyBO;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;
import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

/**
 * 商城平台快递公司管理，通过快递公司代码查询对应的订单信息数据
 * 
 * @since V1.3
 * 
 */
@Controller
public class ExpressCompanyManageAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private ExpressCompanyService expressCompanyService;
	@Autowired
	private WeedFSClient fsClient;

	@Autowired
	private UserCustomerService server;

	/**
	 * 系统集成“快递100”数据接口，支持多种快递在线查询显示，需要向“快递100”申请id后才可以使用
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "快递设置", value = "/admin/set_kuaidi.htm*", rtype = "admin", rname = "快递设置", rcode = "admin_set_kuaidi", rgroup = "商城管理")
	@RequestMapping("/admin/set_kuaidi.htm")
	public ModelAndView set_kuaidi(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/set_kuaidi.html", configService.getSysConfig(), 0,
				request, response);
		SysConfig config = configService.querySysConfig();
		mv.addObject("config", config);
		return mv;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param kuaidi_id
	 * @return
	 */
	@SecurityMapping(title = "保存快递设置", value = "/admin/set_kuaidi_save.htm*", rtype = "admin", rname = "快递设置", rcode = "admin_set_kuaidi", rgroup = "商城管理")
	@RequestMapping("/admin/set_kuaidi_save.htm")
	public ModelAndView set_kuaidi_save(HttpServletRequest request, HttpServletResponse response, String id) {
		SysConfig obj = this.configService.getSysConfig();
		WebForm wf = new WebForm();
		SysConfig config = null;
		if (StringUtils.isNotBlank(id))
			config = (SysConfig) wf.toPo(request, obj);
		else
			config = wf.toPo(request, SysConfig.class);
		configService.saveSysConfig(config);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("op_title", "快递设置成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/set_kuaidi.htm");
		return mv;
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
	@SecurityMapping(title = "快递公司列表", value = "/admin/express_company_list.htm*", rtype = "admin", rname = "快递公司", rcode = "admin_express_company", rgroup = "商城管理")
	@RequestMapping("/admin/express_company_list.htm")
	public ModelAndView express_company_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<ExpressCompanyBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/express_company_list.html",
				configService.getSysConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(20);
		expressCompanyService.queryExpressCompany(page);
		CommUtil.saveIPageList2ModelAndView(url + "/admin/expresscompany_list.htm", "", "", page, mv);
		return mv;
	}

	/**
	 * 新增快递公司
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "快递公司添加", value = "/admin/express_company_add.htm*", rtype = "admin", rname = "快递公司", rcode = "admin_express_company", rgroup = "商城管理")
	@RequestMapping("/admin/express_company_add.htm")
	public ModelAndView express_company_add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/express_company_add.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	/**
	 * expresscompany编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "快递公司编辑", value = "/admin/express_company_edit.htm*", rtype = "admin", rname = "快递公司", rcode = "admin_express_company", rgroup = "商城管理")
	@RequestMapping("/admin/express_company_edit.htm")
	public ModelAndView express_company_edit(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/express_company_add.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotBlank(id)) {
			ExpressCompanyBO expresscompany = expressCompanyService.queryExpressCompanyById(CommUtil
					.null2Long(id));
			mv.addObject("obj", expresscompany);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * expresscompany保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "快递公司保存", value = "/admin/express_company_save.htm*", rtype = "admin", rname = "快递公司", rcode = "admin_express_company", rgroup = "商城管理")
	@RequestMapping("/admin/express_company_save.htm")
	public ModelAndView express_company_save(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		WebForm wf = new WebForm();
		ExpressCompany expresscompany = wf.toPo(request, ExpressCompany.class);

//		if (file != null && file.getSize() != 0) {
//			RequestResult result;
//			try {
//				result = fsClient.upload(file.getInputStream(), file.getName(),
//						URLConnection.guessContentTypeFromName((file.getOriginalFilename())));
//				if (result.isSuccess())
//					expresscompany.setCompanyTemplate(result.getUrl());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		expressCompanyService.saveExpressCompany(expresscompany);
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/express_company_list.htm");
		mv.addObject("op_title", "保存快递公司成功");
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/express_company_add.htm?currentPage="
				+ currentPage);
		return mv;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param mulitId
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "快递公司删除", value = "/admin/express_company_del.htm*", rtype = "admin", rname = "快递公司", rcode = "admin_express_company", rgroup = "商城管理")
	@RequestMapping("/admin/express_company_del.htm")
	public String express_company_del(HttpServletRequest request, HttpServletResponse response,
			String mulitId, String currentPage) {
		expressCompanyService.deleteExpressCompanyById(mulitId);
		return "redirect:express_company_list.htm?currentPage=" + currentPage;
	}

	// @SecurityMapping(title = "快递公司Ajax更新数据", value =
	// "/admin/express_company_ajax.htm*", rtype = "admin", rname = "快递公司",
	// rcode = "admin_express_company", rgroup = "设置")
	// @RequestMapping("/admin/express_company_ajax.htm")
	// public void express_company_ajax(HttpServletRequest request,
	// HttpServletResponse response, String id, String fieldName,
	// String value) throws ClassNotFoundException {
	// ExpressCompany obj = this.expressCompanyService.getObjById(Long
	// .parseLong(id));
	// Field[] fields = ExpressCompany.class.getDeclaredFields();
	// BeanWrapper wrapper = new BeanWrapper(obj);
	// Object val = null;
	// for (Field field : fields) {
	// // System.out.println(field.getName());
	// if (field.getName().equals(fieldName)) {
	// Class clz = Class.forName("java.lang.String");
	// if (field.getType().getName().equals("int")) {
	// clz = Class.forName("java.lang.Integer");
	// }
	// if (field.getType().getName().equals("boolean")) {
	// clz = Class.forName("java.lang.Boolean");
	// }
	// if (!value.equals("")) {
	// val = BeanUtils.convertType(value, clz);
	// } else {
	// val = !CommUtil.null2Boolean(wrapper
	// .getPropertyValue(fieldName));
	// }
	// wrapper.setPropertyValue(fieldName, val);
	// }
	// }
	// this.expressCompanyService.update(obj);
	// response.setContentType("text/plain");
	// response.setHeader("Cache-Control", "no-cache");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter writer;
	// try {
	// writer = response.getWriter();
	// writer.print(val.toString());
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	//
	// @RequestMapping("/admin/express_company_mark.htm")
	// public void express_company_mark(HttpServletRequest request,
	// HttpServletResponse response, String company_mark, String id) {
	// Map params = new HashMap();
	// params.put("company_mark", company_mark.trim());
	// params.put("id", CommUtil.null2Long(id));
	// List<ExpressCompany> ecs = this.expressCompanyService
	// .query("select obj from ExpressCompany obj where obj.company_mark=:company_mark and obj.id!=:id",
	// params, -1, -1);
	// boolean ret = true;
	// if (ecs.size() > 0) {
	// ret = false;
	// }
	// response.setContentType("text/plain");
	// response.setHeader("Cache-Control", "no-cache");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter writer;
	// try {
	// writer = response.getWriter();
	// writer.print(ret);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "运单模板编辑", value = "/admin/express_company_template_edit.htm*", rtype = "admin", rname = "快递公司", rcode = "admin_express_company", rgroup = "商城管理")
	@RequestMapping("/admin/express_company_template_edit.htm")
	public ModelAndView express_company_template_edit(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage) throws Exception {
		ModelAndView mv = new JModelAndView("admin/blue/express_company_template_edit.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotBlank(id)) {
			ExpressCompany expressCompany = expressCompanyService.queryExpressCompanyById(CommUtil
					.null2Long(id));
			ObjectMapper mapper = new ObjectMapper();
			if (StringUtils.isNotBlank(expressCompany.getCompanyTemplateOffset())) {
				Map offset_map = mapper.readValue(expressCompany.getCompanyTemplateOffset(), Map.class);
				mv.addObject("offset_map", offset_map);
			}
			mv.addObject("obj", expressCompany);
			mv.addObject("currentPage", currentPage);
		}
		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "运单模板打印测试", value = "/admin/express_company_template_print.htm*", rtype = "admin", rname = "快递公司", rcode = "admin_express_company", rgroup = "商城管理")
	@RequestMapping("/admin/express_company_template_print.htm")
	public ModelAndView express_company_template_print(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage) throws Exception {
		ModelAndView mv = new JModelAndView("admin/blue/express_company_template_print.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotBlank(id)) {
			ExpressCompany expresscompany = expressCompanyService.queryExpressCompanyById(CommUtil
					.null2Long(id));
			ObjectMapper mapper = new ObjectMapper();
			Map offset_map = mapper.readValue(expresscompany.getCompanyTemplateOffset(), Map.class);
			mv.addObject("offset_map", offset_map);
			mv.addObject("obj", expresscompany);
		}
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "运单模板保存", value = "/admin/express_company_template_print.htm*", rtype = "admin", rname = "快递公司", rcode = "admin_express_company", rgroup = "商城管理")
	@RequestMapping("/admin/express_company_template_save.htm")
	public void express_company_template_save(HttpServletRequest request, HttpServletResponse response,
			String id) throws Exception {
		ExpressCompany obj = expressCompanyService.queryExpressCompanyById(CommUtil.null2Long(id));
		boolean ret = true;
		if (obj != null) {
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
			// System.out.println(Json.toJson(map, JsonFormat.compact()));
			ObjectMapper mapper = new ObjectMapper();
			obj.setCompanyTemplateOffset(mapper.writeValueAsString(map));
			System.out.println("map:" + mapper.writeValueAsString(map));
			expressCompanyService.update(obj);
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		writer = response.getWriter();
		writer.print(ret);

	}

	@SecurityMapping(title = "运单模板保存成功", value = "/admin/express_company_template_success.htm*", rtype = "admin", rname = "快递公司", rcode = "admin_express_company", rgroup = "商城管理")
	@RequestMapping("/admin/express_company_template_success.htm")
	public ModelAndView express_company_template_success(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/express_company_list.htm");
		mv.addObject("op_title", "快递运单模板保存成功");
		return mv;
	}

	// @SecurityMapping(title = "运单模板加载", value =
	// "/admin/express_company_template_load.htm*", rtype = "admin", rname =
	// "快递公司", rcode = "admin_express_company", rgroup = "设置")
	// @RequestMapping("/admin/express_company_template_load.htm")
	// public ModelAndView express_company_template_load(
	// HttpServletRequest request, HttpServletResponse response,
	// String id, String currentPage) {
	// ModelAndView mv = new JModelAndView(
	// "admin/blue/express_company_template_load.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 0, request, response);
	// if (id != null && !id.equals("")) {
	// ExpressCompany expresscompany = this.expressCompanyService
	// .getObjById(Long.parseLong(id));
	// mv.addObject("obj", expresscompany);
	// }
	// return mv;
	// }
	//
	// @SecurityMapping(title = "快递推送列表", value =
	// "/admin/express_info_list.htm*", rtype = "admin", rname = "快递公司", rcode =
	// "admin_express_company", rgroup = "设置")
	// @RequestMapping("/admin/express_info_list.htm")
	// public ModelAndView express_info_list(HttpServletRequest request,
	// HttpServletResponse response, String currentPage,
	// String order_express_id, String order_status) {
	// ModelAndView mv = new JModelAndView(
	// "admin/blue/express_info_list.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 0, request, response);
	// ExpressInfoQueryObject qo = new ExpressInfoQueryObject(currentPage, mv,
	// "addTime", "desc");
	// if (!CommUtil.null2String(order_express_id).equals("")) {
	// qo.addQuery("obj.order_express_id", new SysMap("order_express_id",
	// CommUtil.null2String(order_express_id)), "=");
	// }
	// if (!CommUtil.null2String(order_status).equals("")) {
	// qo.addQuery(
	// "obj.order_status",
	// new SysMap("order_status", CommUtil.null2Int(order_status)),
	// "=");
	// }
	// IPageList pList = this.expressInfoService.list(qo);
	// CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
	// mv.addObject("order_express_id", order_express_id);
	// mv.addObject("order_status", order_status);
	// return mv;
	// }
	//
	// @SecurityMapping(title = "快递推送详情", value =
	// "/admin/express_info_view.htm*", rtype = "admin", rname = "快递公司", rcode =
	// "admin_express_company", rgroup = "设置")
	// @RequestMapping("/admin/express_info_view.htm")
	// public ModelAndView express_info_view(HttpServletRequest request,
	// HttpServletResponse response, String id) {
	// ModelAndView mv = new JModelAndView(
	// "admin/blue/express_info_view.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 0, request, response);
	// mv.addObject("obj",
	// this.expressInfoService.getObjById(CommUtil.null2Long(id)));
	// mv.addObject("orderFormTools", orderFormTools);
	// return mv;
	// }
}