package vc.thinker.b2b2c.action.self;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.shop.bo.TransportBO;
import com.sinco.carnation.shop.model.TransArea;
import com.sinco.carnation.shop.model.Transport;
import com.sinco.carnation.shop.service.TransAreaServiceImpl;
import com.sinco.carnation.shop.vo.TransportVO;
import com.sinco.carnation.sys.service.SysConfigService;
//import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.transport.service.TransportService;
import com.sinco.carnation.transport.tools.TransportTools;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: TransportSelfManageAction.java
 * </p>
 * 
 * <p>
 * Description: 商城自营商品运费模板管理控制器，用来添加、复制、编辑管理运费模板信息
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
 * @author jingxinzhe
 * 
 * @date 2014-5-9
 * 
 * @version 1.0.1
 */
@Controller
public class SelfTransportManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private TransportService transportService;
	@Autowired
	private TransAreaServiceImpl transAreaService;
//	@Autowired
//	private UserService userService;
	@Autowired
	private TransportTools transportTools;

	/**
	 * Transport列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "运费模板列表", value = "/admin/transport_list.htm*", rtype = "admin", rname = "运费模板", rcode = "transport_self", rgroup = "商城管理")
	@RequestMapping("/admin/transport_list.htm")
	public ModelAndView transport_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<TransportBO> page, TransportVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/transport_list.html", configService.getSysConfig(),
				0, request, response);
		page.setPageSize(3);
		vo.setTransUser(0);
		this.transportService.findPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("transportTools", transportTools);

		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		mv.addObject("url", url);

//		String params = "";
//		TransportQueryObject qo = new TransportQueryObject(currentPage, mv,
//				orderBy, orderType);
//		qo.addQuery("obj.trans_user", new SysMap("obj_trans_user", 0), "=");
//		qo.setPageSize(3);
//		IPageList pList = this.transportService.list(qo);
//		CommUtil.saveIPageList2ModelAndView("", "", params, pList, mv);
//		mv.addObject("transportTools", transportTools);
		return mv;
	}

	/**
	 * transport添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "运费模板添加", value = "/admin/transport_add.htm*", rtype = "admin", rname = "运费模板", rcode = "transport_self", rgroup = "商城管理")
	@RequestMapping("/admin/transport_add.htm")
	public ModelAndView transport_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/transport_add.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * transport编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "运费模板编辑", value = "/admin/transport_edit.htm*", rtype = "admin", rname = "运费模板", rcode = "transport_self", rgroup = "商城管理")
	@RequestMapping("/admin/transport_edit.htm")
	public ModelAndView transport_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/transport_add.html", configService.getSysConfig(), 0,
				request, response);
		if (id != null && !id.equals("")) {
			Transport transport = this.transportService.getObjById(Long.parseLong(id));
			mv.addObject("obj", transport);
			mv.addObject("currentPage", currentPage);
		}
		mv.addObject("transportTools", transportTools);
		return mv;
	}

	@SecurityMapping(title = "运费模板复制", value = "/admin/transport_copy.htm*", rtype = "admin", rname = "运费模板", rcode = "transport_self", rgroup = "商城管理")
	@RequestMapping("/admin/transport_copy.htm")
	public ModelAndView transport_copy(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/transport_add.html", configService.getSysConfig(), 0,
				request, response);
		if (id != null && !id.equals("")) {
			Transport transport = this.transportService.getObjById(Long.parseLong(id));
			Transport obj = new Transport();
			BeanUtils.copyProperties(transport, obj);

//			obj.setStore(transport.getStore());
//			obj.setTrans_ems(transport.isTrans_ems());
//			obj.setTrans_ems_info(transport.getTrans_ems_info());
//			obj.setTrans_express(transport.isTrans_express());
//			obj.setTrans_express_info(transport.getTrans_express_info());
//			obj.setTrans_mail(transport.isTrans_mail());
//			obj.setTrans_mail_info(transport.getTrans_mail_info());
//			obj.setTrans_name(transport.getTrans_name());

			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		}
		mv.addObject("transportTools", transportTools);
		return mv;
	}

	/**
	 * transport保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "运费模板保存", value = "/admin/transport_save.htm*", rtype = "admin", rname = "运费模板", rcode = "transport_self", rgroup = "商城管理")
	@RequestMapping("/admin/transport_save.htm")
	public String transport_save(HttpServletRequest request, HttpServletResponse response, String list_url,
			String add_url, TransportVO vo) {

		if (vo != null) {
			List<Map<String, Object>> transInfo = null;
			if (vo.getTransMail() == null)
				vo.setTransMail(Boolean.FALSE);
			if (vo.getTransExpress() == null)
				vo.setTransExpress(Boolean.FALSE);
			if (vo.getTransEms() == null)
				vo.setTransEms(Boolean.FALSE);
			if (vo.getTransMail()) {
				transInfo = new ArrayList<Map<String, Object>>();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("city_id", "-1");
				map.put("city_name", "全国");
				map.put("trans_weight", vo.getMailTransWeight());
				map.put("trans_fee", vo.getMailTransFee());
				map.put("trans_add_weight", vo.getMailTransAddWeight());
				map.put("trans_add_fee", vo.getMailTransAddFee());
				transInfo.add(map);
				for (int i = 1; i <= vo.getMailCityCount(); i++) {
					int transWeight = vo.getMailTransWeight();
					String cityIds = CommUtil.null2String(request.getParameter("mailCityIds" + i));
					if (!cityIds.equals("") && transWeight > 0) {
						float transFee = CommUtil.null2Float(request.getParameter("mailTransFee" + i));
						int transAddWeight = CommUtil
								.null2Int(request.getParameter("mailTransAddWeight" + i));
						float transAddFee = CommUtil.null2Float(request.getParameter("mailTransAddFee" + i));
						String cityName = CommUtil.null2String(request.getParameter("mailCityNames" + i));
						Map<String, Object> transMailInfoMap = new HashMap<String, Object>();
						transMailInfoMap.put("city_id", cityIds);
						transMailInfoMap.put("city_name", cityName);
						transMailInfoMap.put("trans_weight", transWeight);
						transMailInfoMap.put("trans_fee", transFee);
						transMailInfoMap.put("trans_add_weight", transAddWeight);
						transMailInfoMap.put("trans_add_fee", transAddFee);
						transInfo.add(transMailInfoMap);
					}
				}
				vo.setTransMailInfo(Json.toJson(transInfo, JsonFormat.compact()));
			} else {
				vo.setTransMailInfo("");
			}
			if (vo.getTransExpress()) {
				transInfo = new ArrayList<Map<String, Object>>();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("city_id", "-1");
				map.put("city_name", "全国");
				map.put("trans_weight", vo.getExpressTransWeight());
				map.put("trans_fee", vo.getExpressTransFee());
				map.put("trans_add_weight", vo.getExpressTransAddWeight());
				map.put("trans_add_fee", vo.getExpressTransAddFee());
				transInfo.add(map);
				for (int i = 1; i <= vo.getExpressCityCount(); i++) {
					int transWeight = CommUtil.null2Int(request.getParameter("expressTransWeight" + i));
					String cityIds = CommUtil.null2String(request.getParameter("expressCityIds" + i));
					if (!cityIds.equals("") && transWeight > 0) {
						float transFee = CommUtil.null2Float(request.getParameter("expressTransFee" + i));
						int transAddWeight = CommUtil.null2Int(request.getParameter("expressTransAddWeight"
								+ i));
						float transAddFee = CommUtil.null2Float(request
								.getParameter("expressTransAddFee" + i));
						String cityName = CommUtil.null2String(request.getParameter("expressCityNames" + i));
						Map<String, Object> transExpressInfoMap = new HashMap<String, Object>();
						transExpressInfoMap.put("city_id", cityIds);
						transExpressInfoMap.put("city_name", cityName);
						transExpressInfoMap.put("trans_weight", transWeight);
						transExpressInfoMap.put("trans_fee", transFee);
						transExpressInfoMap.put("trans_add_weight", transAddWeight);
						transExpressInfoMap.put("trans_add_fee", transAddFee);
						transInfo.add(transExpressInfoMap);
					}
				}
				vo.setTransExpressInfo(Json.toJson(transInfo, JsonFormat.compact()));
			} else {
				vo.setTransExpressInfo("");
			}
			if (vo.getTransEms()) {
				transInfo = new ArrayList<Map<String, Object>>();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("city_id", "-1");
				map.put("city_name", "全国");
				map.put("trans_weight", vo.getEmsTransWeight());
				map.put("trans_fee", vo.getEmsTransFee());
				map.put("trans_add_weight", vo.getEmsTransAddWeight());
				map.put("trans_add_fee", vo.getEmsTransAddFee());
				transInfo.add(map);
				for (int i = 1; i <= vo.getEmsCityCount(); i++) {
					int transWeight = CommUtil.null2Int(request.getParameter("emsTransWeight" + i));
					String city_ids = CommUtil.null2String(request.getParameter("emsCityIds" + i));
					if (!city_ids.equals("") && transWeight > 0) {
						float transFee = CommUtil.null2Float(request.getParameter("emsTransFee" + i));
						int transAddWeight = CommUtil.null2Int(request.getParameter("emsTransAddWeight" + i));
						float transAddFee = CommUtil.null2Float(request.getParameter("emsTransAddFee" + i));
						String cityName = CommUtil.null2String(request.getParameter("emsCityNames" + i));
						Map<String, Object> transEmsInfoMap = new HashMap<String, Object>();
						transEmsInfoMap.put("city_id", city_ids);
						transEmsInfoMap.put("city_name", cityName);
						transEmsInfoMap.put("trans_weight", transWeight);
						transEmsInfoMap.put("trans_fee", transFee);
						transEmsInfoMap.put("trans_add_weight", transAddWeight);
						transEmsInfoMap.put("trans_add_fee", transAddFee);
						transInfo.add(transEmsInfoMap);
					}
				}
				vo.setTransEmsInfo(Json.toJson(transInfo, JsonFormat.compact()));
			} else {
				vo.setTransEmsInfo("");
			}

			if (vo.getId() != null && vo.getId() > 0) {
				this.transportService.update(vo);
			} else {
				vo.setAddTime(new Date());
				this.transportService.save(vo);
			}
		}
		return "redirect:transport_success.htm";// ?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "运费模板保存成功", value = "/admin/transport_success.htm*", rtype = "admin", rname = "运费模板", rcode = "transport_self", rgroup = "商城管理")
	@RequestMapping("/admin/transport_success.htm")
	public ModelAndView transport_success(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("op_title", "运费模板保存成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/transport_list.htm");
		// ?currentPage=" + currentPage
		return mv;
	}

	@SecurityMapping(title = "运费模板删除", value = "/admin/transport_del.htm*", rtype = "admin", rname = "运费模板", rcode = "transport_self", rgroup = "商城管理")
	@RequestMapping("/admin/transport_del.htm")
	public String transport_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
//				Transport transport = this.transportService.getObjById(Long
//						.parseLong(id));
				this.transportService.delete(CommUtil.null2Long(id));
			}
		}
		return "redirect:transport_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "运费模板详细信息", value = "/admin/transport_info.htm*", rtype = "admin", rname = "运费模板", rcode = "transport_self", rgroup = "商城管理")
	@RequestMapping("/admin/transport_info.htm")
	public ModelAndView transport_info(HttpServletRequest request, HttpServletResponse response, String type,
			String id) {
		if (type == null || type.equals("")) {
			type = CommUtil.null2String(request.getAttribute("type"));
		}
		if (id == null || id.equals("")) {
			id = CommUtil.null2String(request.getAttribute("id"));
		}
		if (CommUtil.null2String(type).equals("")) {
			type = "mail";
		}
		ModelAndView mv = new JModelAndView("admin/blue/transport_" + type + ".html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && !id.equals("")) {
			Transport transport = this.transportService.getObjById(Long.parseLong(id));
			mv.addObject("obj", transport);
			mv.addObject("transportTools", transportTools);
		}
		return mv;
	}

	@SecurityMapping(title = "运费模板区域编辑", value = "/admin/transport_area.htm*", rtype = "admin", rname = "运费模板", rcode = "transport_self", rgroup = "商城管理")
	@RequestMapping("/admin/transport_area.htm")
	public ModelAndView transport_area(HttpServletRequest request, HttpServletResponse response, String id,
			String trans_city_type, String trans_index) {
		ModelAndView mv = new JModelAndView("admin/blue/transport_area.html", configService.getSysConfig(),
				0, request, response);
		List<TransArea> objs = this.transAreaService.getAllTransAreas();

		mv.addObject("objs", objs);
		mv.addObject("trans_city_type", trans_city_type);
		mv.addObject("trans_index", trans_index);
		return mv;
	}

}
