package vc.thinker.b2b2c.action.buyer;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.integral.service.IntegralGoodsService;
import com.sinco.carnation.integral.tools.IntegralViewTools;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.bo.IntegralGoodsOrderBO;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.shop.model.IntegralGoods;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.shop.model.TransInfo;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.IntegralLogBO;
import com.sinco.carnation.user.model.IntegralLog;
import com.sinco.carnation.user.service.IntegralLogService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.vo.IntegralLogVO;
import com.sinco.dal.common.MyPage;

/**
 * 
 * 
 * <p>
 * Title:IntegralOrderBuyerAction.java
 * </p>
 * 
 * <p>
 * Description: 积分商城买家控制器
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
 * @date 2014年5月19日
 * 
 * @version 1.0.1
 */
@Controller
public class IntegralOrderBuyerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private IntegralGoodsService integralGoodsService;
	@Autowired
	private IntegralGoodsOrderService integralGoodsOrderService;
	@Autowired
	private UserService userService;
	@Autowired
	private IntegralLogService integralLogService;
	@Autowired
	private IntegralViewTools integralViewTools;
	@Autowired
	private ExpressCompanyService expressCompanyService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	UserCustomerService userCustomerService;

	@SecurityMapping(title = "买家积分明细", value = "/buyer/integral_log_list.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/integral_log_list.htm")
	public ModelAndView integral_log_list(HttpServletRequest request, HttpServletResponse response,
			IntegralLogVO vo, MyPage<IntegralLogBO> page) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/integral_log_list.html",
				configService.getSysConfig(), 0, request, response);
		if (configService.getSysConfig().getIntegralStore()) {
			vo.setUserId(SecurityUserHolder.getCurrentUserId());
			integralLogService.queryByVO(vo, page);
			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "买家订单列表", value = "/buyer/integral_order_list.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/integral_order_list.htm")
	public ModelAndView integral_order_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/integral_order_list.html",
				configService.getSysConfig(), 0, request, response);
		if (configService.getSysConfig().getIntegralStore()) {
			MyPage<IntegralGoodsOrderBO> page = new MyPage<IntegralGoodsOrderBO>();
			page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 0 : Integer.parseInt(currentPage));
			integralGoodsOrderService.selectByUser(SecurityUserHolder.getCurrentUser().getId(), page);
			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
			mv.addObject("orderFormTools", orderFormTools);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "取消订单", value = "/buyer/integral_order_cancel.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/integral_order_cancel.htm")
	public ModelAndView integral_order_cancel(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		IntegralGoodsOrder obj = integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
		if (obj != null && obj.getIgoUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
			obj.setIgoStatus(-1);
			this.integralGoodsOrderService.update(obj);
			List<IntegralGoods> igs = orderFormTools.query_integral_all_goods(CommUtil.null2String(obj
					.getId()));
			for (IntegralGoods ig : igs) {
				IntegralGoods goods = ig;
				int sale_count = orderFormTools.query_integral_one_goods_count(obj,
						CommUtil.null2String(ig.getId()));
				goods.setIgGoodsCount(goods.getIgGoodsCount() + sale_count);
				integralGoodsService.update(goods);
			}
			userCustomerService.addIntegral(obj.getIgoUserId(), obj.getIgoTotalIntegral());

			IntegralLog log = new IntegralLog();
			log.setAddtime(new Date());
			log.setContent("取消" + obj.getIgoOrderSn() + "积分兑换，返还积分");
			log.setIntegral(obj.getIgoTotalIntegral());
			log.setIntegralUserId(obj.getIgoUserId());
			log.setType("integral_order");
			integralLogService.save(log);
			mv.addObject("op_title", "积分兑换取消成功");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/integral_order_list.htm");
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "参数错误，无该订单");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/integral_order_list.htm");
		}

		return mv;
	}

	@SecurityMapping(title = "积分订单详情", value = "/buyer/integral_order_view.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/integral_order_view.htm")
	public ModelAndView integral_order_view(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/integral_order_view.html",
				configService.getSysConfig(), 0, request, response);
		IntegralGoodsOrderBO obj = integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
		if (obj != null && obj.getIgoUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
			mv.addObject("integralViewTools", integralViewTools);
			mv.addObject("orderFormTools", orderFormTools);
			boolean query_ship = false;// 是否查询物流
			if (!CommUtil.null2String(obj.getIgoShipCode()).equals("")) {
				query_ship = true;
			}
			mv.addObject("query_ship", query_ship);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "参数错误，无该订单");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/integral_order_list.htm");
		}

		return mv;
	}

	@SecurityMapping(title = "确认收货", value = "/buyer/integral_order_cofirm.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/integral_order_cofirm.htm")
	public ModelAndView integral_order_cofirm(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/integral_order_cofirm.html",
				configService.getSysConfig(), 0, request, response);
		IntegralGoodsOrder obj = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
		if (obj != null && obj.getIgoUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
			mv.addObject("obj", obj);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "参数错误，无该订单");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/integral_order_list.htm");
		}

		return mv;
	}

	@SecurityMapping(title = "确认收货保存", value = "/buyer/integral_order_cofirm_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/integral_order_cofirm_save.htm")
	public ModelAndView integral_order_cofirm_save(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		IntegralGoodsOrder obj = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
		if (obj != null && obj.getIgoUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
			obj.setIgoStatus(40);
			integralGoodsOrderService.update(obj);
			mv.addObject("op_title", "确认收货成功");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/integral_order_list.htm");
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "参数错误，无该订单");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/integral_order_list.htm?currentPage="
					+ currentPage);
		}

		return mv;
	}

	@SecurityMapping(title = "物流ajax", value = "/buyer/integral_ship_ajax.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/integral_ship_ajax.htm")
	public ModelAndView integral_ship_ajax(HttpServletRequest request, HttpServletResponse response,
			String order_id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/integral_ship_ajax.html",
				configService.getSysConfig(), 0, request, response);
		IntegralGoodsOrder order = integralGoodsOrderService.getObjById(CommUtil.null2Long(order_id));
		TransInfo transInfo = query_ship_getData(CommUtil.null2String(order_id));
		if (transInfo != null) {
			transInfo.setExpress_company_name(orderFormTools.queryExInfo(order.getIgoExpressInfo(),
					"express_company_name"));
			transInfo.setExpress_ship_code(order.getIgoShipCode());
		}
		mv.addObject("transInfo", transInfo);

		return mv;
	}

	@SuppressWarnings("static-access")
	private TransInfo query_ship_getData(String id) {
		TransInfo info = null;
		IntegralGoodsOrder obj = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
		if (obj != null && !CommUtil.null2String(obj.getIgoShipCode()).equals("")) {
			info = new TransInfo();
			try {
				ExpressCompany ec = queryExpressCompany(obj.getIgoExpressInfo());
				String query_url = "http://api.kuaidi100.com/api?id="
						+ configService.getSysConfig().getKuaidiId() + "&com="
						+ (ec != null ? ec.getCompanyMark() : "") + "&nu=" + obj.getIgoShipCode()
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
		}

		return info;
	}

	@SuppressWarnings("rawtypes")
	private ExpressCompany queryExpressCompany(String json) {
		ExpressCompany ec = null;
		if (json != null && !json.equals("")) {
			HashMap map = Json.fromJson(HashMap.class, json);
			ec = this.expressCompanyService.getObjById(CommUtil.null2Long(map.get("express_company_id")));
		}

		return ec;
	}
}
