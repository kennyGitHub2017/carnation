package vc.thinker.b2b2c.action.seller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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

import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.ReturnGoodsLogBO;
import com.sinco.carnation.goods.model.ReturnGoodsLog;
import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.goods.vo.ReturnGoodsLogVO;
import com.sinco.carnation.kuaidi100.service.TransInfoService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.TransInfo;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * 
 * <p>
 * Title: ReturnSellerAction.java
 * </p>
 * 
 * <p>
 * Description: 商品退货管理，查看商品的退货申请。以及对退货的一些操作。
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
 * @date 2014年5月15日
 * 
 * @version 1.0.1
 */
@Controller
@SuppressWarnings({"unchecked", "unused", "rawtypes"})
public class ReturnSellerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ReturnGoodsLogService returngoodslogService;
	@Autowired
	private ExpressCompanyService expressCompayService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderFormService orderformService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private OrderFormTools orderFormTools;

	@Autowired
	private TransInfoService transInfoService;

//
	/**
	 * return列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "退货列表", value = "/seller/return.htm*", rtype = "seller", rname = "退货管理", rcode = "seller_return", rgroup = "客户服务")
	@RequestMapping("/seller/return.htm")
	public ModelAndView seller_return(HttpServletRequest request, HttpServletResponse response,
			ReturnGoodsLogVO vo, MyPage<ReturnGoodsLogBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/return.html",
				configService.getSysConfig(), 0, request, response);
		// 获取商户的商铺
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				store = storeService.getObjById(userDetails.getStoreId());
				vo.setStoreId(userDetails.getStoreId() + "");
			}
		}
		returngoodslogService.findPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		mv.addObject("store", store);
		return mv;
	}

	/**
	 * return_check查看
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "退货列表查看", value = "/seller/return_check.htm*", rtype = "seller", rname = "退货管理", rcode = "seller_return", rgroup = "客户服务")
	@RequestMapping("/seller/return_check.htm")
	public ModelAndView return_check(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/return_check.html",
				configService.getSysConfig(), 0, request, response);
		ReturnGoodsLog obj = this.returngoodslogService.getObjById(CommUtil.null2Long(id));

		if (obj == null) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "用户已取消了退货申请");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/return.htm");

			return mv;
		}

		if (obj.getGoodsReturnStatus().equals(GoodsConstants.GOODS_RETURN_STATUS_7)) {// 退货中
			TransInfo transInfo = transInfoService.queryShipInfo(obj.getReturnExpressInfo(),
					obj.getExpressCode(), obj.getId());
			this.queryShipGetData(CommUtil.null2String(obj.getId()));
			mv.addObject("transInfo", transInfo);
			Map map = Json.fromJson(HashMap.class, obj.getReturnExpressInfo());
			mv.addObject("express_company_name", map.get("express_company_name"));
		}
		mv.addObject("obj", obj);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * return_check_save保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "退货列表查看保存", value = "/seller/return_check_save.htm*", rtype = "seller", rname = "退货管理", rcode = "seller_return", rgroup = "客户服务")
	@RequestMapping("/seller/return_check_save.htm")
	public void return_check_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String goodsReturnStatus, String selfAddress, String goodsGspIds) {
		Long uid = SecurityUserHolder.getCurrentUserId();
		returngoodslogService.sellerReturnCheckSave(id, goodsReturnStatus, selfAddress, uid, goodsGspIds);
		Map json = new HashMap();
		json.put("op_title", "审核为未通过");
		if (goodsReturnStatus.equals(GoodsConstants.GOODS_RETURN_STATUS_6)) {
			json.put("op_title", "审核为通过");
		}
		json.put("ret", true);
		json.put("url", CommUtil.getURL(request) + "/seller/return.htm?currentPage=" + currentPage);
		this.return_json(Json.toJson(json, JsonFormat.compact()), response);
	}

	/**
	 * self_return_confirm保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "确认退货收货", value = "/seller/return_confirm.htm*", rtype = "seller", rname = "退货管理", rcode = "seller_return", rgroup = "客户服务")
	@RequestMapping("/seller/return_confirm.htm")
	public ModelAndView return_confirm(HttpServletRequest request, HttpServletResponse response, String id) {
		returngoodslogService.sellerReturnConfirm(id);
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_success.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("op_title", "确认退货成功!");
		mv.addObject("url", CommUtil.getURL(request) + "/seller/return.htm");
		return mv;
	}

	@SuppressWarnings("static-access")
	private TransInfo queryShipGetData(String id) {
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

	private ExpressCompany queryExpressCompany(String json) {
		ExpressCompany ec = null;
		if (json != null && !json.equals("")) {
			HashMap map = Json.fromJson(HashMap.class, json);
			ec = this.expressCompayService.getObjById(CommUtil.null2Long(map.get("express_company_id")));
		}
		return ec;
	}

	public void return_json(String json, HttpServletResponse response) {
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
