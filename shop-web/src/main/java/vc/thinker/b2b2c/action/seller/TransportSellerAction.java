package vc.thinker.b2b2c.action.seller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.sinco.carnation.shop.bo.TransportBO;
import com.sinco.carnation.shop.model.TransArea;
import com.sinco.carnation.shop.model.Transport;
import com.sinco.carnation.shop.service.TransAreaServiceImpl;
import com.sinco.carnation.shop.vo.TransportVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.transport.service.TransportService;
import com.sinco.carnation.transport.tools.TransportTools;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

/**
 * @info 卖家中心运费管理控制器，V1.3版本开始，废除以前的配送方式管理
 * @since V1.3
 * @author Grey
 * 
 */
@Controller
@SuppressWarnings({"rawtypes", "unchecked"})
public class TransportSellerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private TransportService transportService;
	@Autowired
	private TransAreaServiceImpl transAreaService;
	@Autowired
	private TransportTools transportTools;
	@Autowired
	private StoreService storeService;

	/**
	 * Transport列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "卖家运费模板列表", value = "/seller/transport_list.htm*", rtype = "seller", rname = "运费模板", rcode = "transport_seller", rgroup = "交易管理")
	@RequestMapping("/seller/transport_list.htm")
	public ModelAndView transport_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<TransportBO> page, TransportVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/transport_list.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		vo.setTransUser(1);
		vo.setStoreId(store.getId());
		this.transportService.findPageByVo(page, vo);

		mv.addObject("transportTools", transportTools);
		mv.addObject("vo", vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	/**
	 * transport添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "卖家运费模板添加", value = "/seller/transport_add.htm*", rtype = "seller", rname = "运费模板", rcode = "transport_seller", rgroup = "交易管理")
	@RequestMapping("/seller/transport_add.htm")
	public ModelAndView transport_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/transport_add.html",
				configService.getSysConfig(), 0, request, response);
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
	@SecurityMapping(title = "卖家运费模板编辑", value = "/seller/transport_edit.htm*", rtype = "seller", rname = "运费模板", rcode = "transport_seller", rgroup = "交易管理")
	@RequestMapping("/seller/transport_edit.htm")
	public ModelAndView transport_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/transport_add.html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && !id.equals("")) {
			Transport transport = this.transportService.getObjById(Long.parseLong(id));
			mv.addObject("obj", transport);
			mv.addObject("currentPage", currentPage);
		}
		mv.addObject("transportTools", transportTools);
		return mv;
	}

	@SecurityMapping(title = "卖家运费模板复制", value = "/seller/transport_copy.htm*", rtype = "seller", rname = "运费模板", rcode = "transport_seller", rgroup = "交易管理")
	@RequestMapping("/seller/transport_copy.htm")
	public ModelAndView transport_copy(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/transport_add.html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && !id.equals("")) {
			Transport transport = this.transportService.getObjById(Long.parseLong(id));
			Transport obj = new Transport();
			BeanUtils.copyProperties(transport, obj);
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
	@SecurityMapping(title = "卖家运费模板保存", value = "/seller/transport_save.htm*", rtype = "seller", rname = "运费模板", rcode = "transport_seller", rgroup = "交易管理")
	@RequestMapping("/seller/transport_save.htm")
	public void transport_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String trans_mail, String trans_express, String trans_ems,
			String mail_city_count, String express_city_count, String ems_city_count, String trans_name) {
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		WebForm wf = new WebForm();
		Transport transport = null;
		if (id.equals("")) {
			transport = wf.toPo(request, Transport.class);
			transport.setAddTime(new Date());
		} else {
			Transport obj = this.transportService.getObjById(Long.parseLong(id));
			transport = (Transport) wf.toPo(request, obj);
		}
		if (CommUtil.null2Boolean(trans_mail)) {
			List<Map> trans_mail_info = new ArrayList<Map>();
			Map map = new HashMap();
			map.put("city_id", "-1");
			map.put("city_name", "全国");
			map.put("trans_weight", CommUtil.null2Int(request.getParameter("mail_trans_weight")));
			map.put("trans_fee", CommUtil.null2Float(request.getParameter("mail_trans_fee")));
			map.put("trans_add_weight", CommUtil.null2Int(request.getParameter("mail_trans_add_weight")));
			map.put("trans_add_fee", CommUtil.null2Float(request.getParameter("mail_trans_add_fee")));
			trans_mail_info.add(map);
			for (int i = 1; i <= CommUtil.null2Int(mail_city_count); i++) {
				int trans_weight = CommUtil.null2Int(request.getParameter("mail_trans_weight" + i));
				String city_ids = CommUtil.null2String(request.getParameter("mail_city_ids" + i));
				if (!city_ids.equals("") && trans_weight > 0) {
					float trans_fee = CommUtil.null2Float(request.getParameter("mail_trans_fee" + i));
					int trans_add_weight = CommUtil.null2Int(request
							.getParameter("mail_trans_add_weight" + i));
					float trans_add_fee = CommUtil.null2Float(request.getParameter("mail_trans_add_fee" + i));
					String city_name = CommUtil.null2String(request.getParameter("mail_city_names" + i));
					Map map1 = new HashMap();
					map1.put("city_id", city_ids);
					map1.put("city_name", city_name);
					map1.put("trans_weight", trans_weight);
					map1.put("trans_fee", trans_fee);
					map1.put("trans_add_weight", trans_add_weight);
					map1.put("trans_add_fee", trans_add_fee);
					trans_mail_info.add(map1);
				}
			}
			transport.setTransMailInfo(Json.toJson(trans_mail_info, JsonFormat.compact()));
		} else {
			transport.setTransMailInfo("");
			transport.setTransMail(false);
		}
		if (CommUtil.null2Boolean(trans_express)) {
			List<Map> trans_express_info = new ArrayList<Map>();
			Map map = new HashMap();
			map.put("city_id", "-1");
			map.put("city_name", "全国");
			map.put("trans_weight", CommUtil.null2Int(request.getParameter("express_trans_weight")));
			map.put("trans_fee", CommUtil.null2Float(request.getParameter("express_trans_fee")));
			map.put("trans_add_weight", CommUtil.null2Int(request.getParameter("express_trans_add_weight")));
			map.put("trans_add_fee", CommUtil.null2Float(request.getParameter("express_trans_add_fee")));
			trans_express_info.add(map);
			for (int i = 1; i <= CommUtil.null2Int(express_city_count); i++) {
				int trans_weight = CommUtil.null2Int(request.getParameter("express_trans_weight" + i));
				String city_ids = CommUtil.null2String(request.getParameter("express_city_ids" + i));
				if (!city_ids.equals("") && trans_weight > 0) {
					float trans_fee = CommUtil.null2Float(request.getParameter("express_trans_fee" + i));
					int trans_add_weight = CommUtil.null2Int(request.getParameter("express_trans_add_weight"
							+ i));
					float trans_add_fee = CommUtil.null2Float(request.getParameter("express_trans_add_fee"
							+ i));
					String city_name = CommUtil.null2String(request.getParameter("express_city_names" + i));
					Map map1 = new HashMap();
					map1.put("city_id", city_ids);
					map1.put("city_name", city_name);
					map1.put("trans_weight", trans_weight);
					map1.put("trans_fee", trans_fee);
					map1.put("trans_add_weight", trans_add_weight);
					map1.put("trans_add_fee", trans_add_fee);
					trans_express_info.add(map1);
				}
			}
			transport.setTransExpress(true);
			transport.setTransExpressInfo(Json.toJson(trans_express_info, JsonFormat.compact()));
		} else {
			transport.setTransExpressInfo("");
			transport.setTransExpress(false);
		}
		if (CommUtil.null2Boolean(trans_ems)) {
			List<Map> trans_ems_info = new ArrayList<Map>();
			Map map = new HashMap();
			map.put("city_id", "-1");
			map.put("city_name", "全国");
			map.put("trans_weight", CommUtil.null2Int(request.getParameter("ems_trans_weight")));
			map.put("trans_fee", CommUtil.null2Float(request.getParameter("ems_trans_fee")));
			map.put("trans_add_weight", CommUtil.null2Int(request.getParameter("ems_trans_add_weight")));
			map.put("trans_add_fee", CommUtil.null2Float(request.getParameter("ems_trans_add_fee")));
			trans_ems_info.add(map);
			for (int i = 1; i <= CommUtil.null2Int(ems_city_count); i++) {
				int trans_weight = CommUtil.null2Int(request.getParameter("ems_trans_weight" + i));
				String city_ids = CommUtil.null2String(request.getParameter("ems_city_ids" + i));
				if (!city_ids.equals("") && trans_weight > 0) {
					float trans_fee = CommUtil.null2Float(request.getParameter("ems_trans_fee" + i));
					int trans_add_weight = CommUtil
							.null2Int(request.getParameter("ems_trans_add_weight" + i));
					float trans_add_fee = CommUtil.null2Float(request.getParameter("ems_trans_add_fee" + i));
					String city_name = CommUtil.null2String(request.getParameter("ems_city_names" + i));
					Map map1 = new HashMap();
					map1.put("city_id", city_ids);
					map1.put("city_name", city_name);
					map1.put("trans_weight", trans_weight);
					map1.put("trans_fee", trans_fee);
					map1.put("trans_add_weight", trans_add_weight);
					map1.put("trans_add_fee", trans_add_fee);
					trans_ems_info.add(map1);
				}
			}
			transport.setTransEms(true);
			transport.setTransEmsInfo(Json.toJson(trans_ems_info, JsonFormat.compact()));
		} else {
			transport.setTransEmsInfo("");
			transport.setTransEms(false);
		}
		transport.setAddTime(new Date());
		transport.setTransUser(1);// 设置为商家模板
		transport.setStoreId(store.getId());
		transport.setTransMail(CommUtil.null2Boolean(trans_mail));
		transport.setTransName(trans_name);
		if (id.equals("")) {
			this.transportService.save(transport);
		} else
			this.transportService.update(transport);
		Map json = new HashMap();
		json.put("ret", true);
		json.put("op_title", "运费模板保存成功");
		json.put("url", CommUtil.getURL(request) + "/seller/transport_list.htm");
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(json, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "卖家运费模板保存成功", value = "/seller/transport_success.htm*", rtype = "seller", rname = "运费模板", rcode = "transport_seller", rgroup = "交易管理")
	@RequestMapping("/seller/transport_success.htm")
	public ModelAndView transport_success(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_success.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("op_title", "运费模板保存成功");
		mv.addObject("url", CommUtil.getURL(request) + "/seller/transport_list.htm");
		return mv;
	}

	@SecurityMapping(title = "卖家运费模板删除", value = "/seller/transport_del.htm*", rtype = "seller", rname = "运费模板", rcode = "transport_seller", rgroup = "交易管理")
	@RequestMapping("/seller/transport_del.htm")
	public String transport_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				Transport transport = this.transportService.getObjById(Long.parseLong(id));

				if (transport != null && transport.getStoreId() != null
						&& transport.getStoreId().equals(store.getId())) {
					this.transportService.delete(Long.parseLong(id));
				}
			}
		}
		return "redirect:transport_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "卖家运费模板详细信息", value = "/seller/transport_info.htm*", rtype = "seller", rname = "运费模板", rcode = "transport_seller", rgroup = "交易管理")
	@RequestMapping("/seller/transport_info.htm")
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
		ModelAndView mv = new JModelAndView("user/default/sellercenter/transport_" + type + ".html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && !id.equals("")) {
			Transport transport = this.transportService.getObjById(Long.parseLong(id));
			mv.addObject("obj", transport);
			mv.addObject("transportTools", transportTools);
		}
		return mv;
	}

	@SecurityMapping(title = "卖家运费模板区域编辑", value = "/seller/transport_area.htm*", rtype = "seller", rname = "运费模板", rcode = "transport_seller", rgroup = "交易管理")
	@RequestMapping("/seller/transport_area.htm")
	public ModelAndView transport_area(HttpServletRequest request, HttpServletResponse response, String id,
			String trans_city_type, String trans_index) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/transport_area.html",
				configService.getSysConfig(), 0, request, response);
		List<TransArea> objs = this.transAreaService.getAllTransAreas();
		mv.addObject("objs", objs);
		mv.addObject("trans_city_type", trans_city_type);
		mv.addObject("trans_index", trans_index);
		return mv;
	}
}