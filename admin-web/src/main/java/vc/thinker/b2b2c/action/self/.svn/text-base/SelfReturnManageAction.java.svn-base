package vc.thinker.b2b2c.action.self;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.goods.model.ReturnGoodsLog;
import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.shop.model.TransInfo;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * 
 * <p>
 * Title: SelfReturnManageAction.java
 * </p>
 * 
 * <p>
 * Description: 自营商品退货管理，查看自营商品的退货申请。以及对退货的一些操作。
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
 * @date 2014年5月12日
 * 
 * @version 1.0.1
 */
@Controller
public class SelfReturnManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ReturnGoodsLogService returngoodslogService;
	@Autowired
	private ExpressCompanyService expressCompayService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private OrderFormService orderformService;

	@Autowired
	private OrderFormTools orderFormTools;

	/**
	 * self_return列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "自营退货列表", value = "/admin/self_return.htm*", rtype = "admin", rname = "自营退货", rcode = "self_return", rgroup = "商城管理")
	@RequestMapping("/admin/self_return.htm")
	public ModelAndView self_return(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String name, String userName, String returnServiceId, String status,
			MyPage<ReturnGoodsLog> page) {
		ModelAndView mv = new JModelAndView("admin/blue/self_return.html", configService.getSysConfig(), 0,
				request, response);
		String url = configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(20);
		returngoodslogService.queryReturnGoodsLogPageList(userName, name, returnServiceId, status, page);
		CommUtil.saveIPageList2ModelAndView(url + "/admin/self_return.htm", "", "", page, mv);
		mv.addObject("name", name);
		mv.addObject("userName", userName);
		mv.addObject("returnServiceId", returnServiceId);
		mv.addObject("status", status);
		return mv;
	}

	/**
	 * 自营退货审核查看界面
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "自营退货列表查看", value = "/admin/self_return_check.htm*", rtype = "admin", rname = "自营退货", rcode = "self_return", rgroup = "商城管理")
	@RequestMapping("/admin/self_return_check.htm")
	public ModelAndView self_return_check(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/self_return_check.html",
				configService.getSysConfig(), 0, request, response);
		ReturnGoodsLog obj = this.returngoodslogService.getObjById(CommUtil.null2Long(id));
		if (obj.getGoodsReturnStatus().equals("7")) {
			TransInfo transInfo = this.query_ship_getData(CommUtil.null2String(obj.getId()));
			mv.addObject("transInfo", transInfo);
			Map map = Json.fromJson(HashMap.class, obj.getReturnExpressInfo());
			mv.addObject("express_company_name", map.get("express_company_name"));
		}
		mv.addObject("obj", obj);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * 保存自营退货操作
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "自营退货列表查看保存", value = "/admin/self_return_check_save.htm*", rtype = "admin", rname = "自营退货", rcode = "self_return", rgroup = "商城管理")
	@RequestMapping("/admin/self_return_check_save.htm")
	public ModelAndView self_return_check_save(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage, String cmd, String list_url, String goodsReturnStatus,
			String selfAddress, String goodsGspIds) {

		Long uid = SecurityUserHolder.getCurrentUserId();
		returngoodslogService.selfReturnCheckSave(id, goodsReturnStatus, selfAddress, uid, goodsGspIds);
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("currentPage", currentPage);
		mv.addObject("op_title", "审核通过");
		return mv;
	}

	/**
	 * self_return_confirm保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "确认退货收货", value = "/admin/self_return_confirm.htm*", rtype = "admin", rname = "自营退货", rcode = "self_return", rgroup = "商城管理")
	@RequestMapping("/admin/self_return_confirm.htm")
	public ModelAndView self_return_confirm(HttpServletRequest request, HttpServletResponse response,
			String id) {
		returngoodslogService.selfReturnConfirm(id);
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("op_title", "确认退货成功!");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_return.htm");
		return mv;
	}

	@SuppressWarnings("static-access")
	private TransInfo query_ship_getData(String id) {
		TransInfo info = new TransInfo();
		ReturnGoodsLog obj = this.returngoodslogService.getObjById(CommUtil.null2Long(id));
		try {
			ExpressCompany ec = this.queryExpressCompany(obj.getReturnExpressInfo());
			String query_url = "http://api.kuaidi100.com/api?id="
					+ this.configService.getSysConfig().getKuaidiId() + "&com="
					+ (ec != null ? ec.getCompanyMark() : "") + "&nu=" + obj.getExpressCode()
					+ "&show=0&muti=1&order=asc";
			URL url = new URL(query_url);
			URLConnection con = url.openConnection();
			con.setAllowUserInteraction(false);
			InputStream urlStream = url.openStream();
			String type = con.guessContentTypeFromStream(urlStream);
			String charSet = null;
			if (type == null)
				type = con.getContentType();
			if (type == null || type.trim().length() == 0 || type.trim().indexOf("text/html") < 0)
				return info;
			if (type.indexOf("charset=") > 0)
				charSet = type.substring(type.indexOf("charset=") + 8);
			byte b[] = new byte[10000];
			int numRead = urlStream.read(b);
			String content = new String(b, 0, numRead, charSet);
			while (numRead != -1) {
				numRead = urlStream.read(b);
				if (numRead != -1) {
					// String newContent = new String(b, 0, numRead);
					String newContent = new String(b, 0, numRead, charSet);
					content += newContent;
				}
			}
			info = Json.fromJson(TransInfo.class, content);
			urlStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return info;
	}

	@SuppressWarnings("rawtypes")
	private ExpressCompany queryExpressCompany(String json) {
		ExpressCompany ec = null;
		if (json != null && !json.equals("")) {
			HashMap map = Json.fromJson(HashMap.class, json);
			ec = this.expressCompayService.getObjById(CommUtil.null2Long(map.get("express_company_id")));
		}
		return ec;
	}
}
