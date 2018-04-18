package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;

import com.sinco.carnation.activity.service.ActivityGoodsService;
import com.sinco.carnation.activity.service.ActivityService;
import com.sinco.carnation.activity.tools.ActivityViewTools;
import com.sinco.carnation.buygift.service.BuyGiftService;
import com.sinco.carnation.goods.bo.GoodsCaseBO;
import com.sinco.carnation.goods.service.GoodsCaseService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.vo.GoodsCaseVO;
import com.sinco.carnation.sales.service.EnoughReduceService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.WxshareTools;

/**
 * 
 * <p>
 * Title: ActivityViewAction.java
 * </p>
 * 
 * <p>
 * Description:商城活动前台管理控制控制器
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
 * @date 2014-9-24
 * 
 * @version 1.0.1
 */
@Controller
public class ActivityViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private ActivityGoodsService activityGoodsService;
	@Autowired
	private ActivityViewTools activityViewTools;
	@Autowired
	private BuyGiftService buyGiftService;
	@Autowired
	private EnoughReduceService enoughReduceService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserService userService;
	@Autowired
	private GoodsCaseService goodsCaseService;

//	@RequestMapping("/activity/index.htm")
//	public ModelAndView activity(HttpServletRequest request,
//			HttpServletResponse response, String id, String currentPage) {
//		ModelAndView mv = new JModelAndView("activity.html",
//				configService.getSysConfig(),
//				 1, request, response);
//		Map params = new HashMap();
//		params.put("ac_begin_time", new Date());
//		params.put("ac_end_time", new Date());
//		params.put("ac_status", 1);
//		
//		
//		List<Activity> acts = this.activityService
//				.query("select obj from Activity obj where obj.ac_status=:ac_status and obj.ac_begin_time<=:ac_begin_time and obj.ac_end_time>=:ac_end_time",
//						params, -1, -1);
//		if (acts.size()>0) {
//			if (id == null) {
//				id = CommUtil.null2String(acts.get(0).getId());
//				mv.addObject("op", "true");
//			}
//			Activity act = this.activityService.getObjById(CommUtil.null2Long(id));
//			if (act != null) {
//				if (act.getAc_status() == 1) {
//					ActivityGoodsQueryObject qo = new ActivityGoodsQueryObject(
//							currentPage, mv, "addTime", "desc");
//					qo.setPageSize(20);
//					qo.addQuery("obj.ag_status", new SysMap("ag_status", 1), "=");// 审核是否通过
//					qo.addQuery("obj.act.id", new SysMap("act_id", act.getId()),
//							"=");
//					qo.addQuery("obj.ag_goods.goods_status", new SysMap(
//							"goods_status", 0), "=");// 商品状态为上架
//					IPageList pList = this.activityGoodsService.list(qo);
//					CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
//					mv.addObject("act", act);
//					mv.addObject("activityViewTools", activityViewTools);
//				} else {
//					mv = new JModelAndView("error.html",
//							configService.getSysConfig(),
//							 1, request,
//							response);
//					mv.addObject("op_title", "活动尚未开启");
//					mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
//					return mv;
//				}
//			}else{
//				mv = new JModelAndView("error.html",
//						configService.getSysConfig(),
//						 1, request,
//						response);
//				mv.addObject("op_title", "参数错误，活动查看失败");
//				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
//				return mv;
//			}
//			mv.addObject("acts", acts);
//		}else{
//			mv = new JModelAndView("error.html",
//					configService.getSysConfig(),
//					 1, request,
//					response);
//			mv.addObject("op_title", "系统未开启任何商城活动");
//			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
//			return mv;
//		}
//		return mv;
//	}
//
//	@RequestMapping("/buygift/index.htm")
//	public ModelAndView buygift(HttpServletRequest request,
//			HttpServletResponse response, String id, String currentPage) {
//		ModelAndView mv = new JModelAndView("buygift.html",
//				configService.getSysConfig(),
//				 1, request, response);
//		BuyGift bg = this.buyGiftService.getObjById(CommUtil.null2Long(id));
//		if (bg != null) {
//			if (bg.getGift_status() == 10) {
//				mv.addObject("obj", bg);
//			} else {
//				mv = new JModelAndView("error.html",
//						configService.getSysConfig(),
//						 1, request,
//						response);
//				mv.addObject("op_title", "参数错误，活动查看失败");
//				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
//				return mv;
//			}
//		} else {
//			mv = new JModelAndView("error.html", configService.getSysConfig(),
//					 1, request,
//					response);
//			mv.addObject("op_title", "参数错误，活动查看失败");
//			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
//			return mv;
//		}
//		return mv;
//	}
//
//	@RequestMapping("/enoughreduce/index.htm")
//	public ModelAndView enoughreduce(HttpServletRequest request,
//			HttpServletResponse response, String id, String currentPage) {
//		ModelAndView mv = new JModelAndView("enoughreduceview.html",
//				configService.getSysConfig(),
//				 1, request, response);
//		User user = SecurityUserHolder.getCurrentUser();
//		EnoughReduce er = this.enoughReduceService.getObjById(CommUtil
//				.null2Long(id));
//		if (er == null || er.getErstatus() != 10) {
//			return null;
//		}
//		GoodsQueryObject qo = new GoodsQueryObject(currentPage, mv, null, null);
//		qo.addQuery("obj.order_enough_reduce_id", new SysMap(
//				"order_enough_reduce_id", id), "=");
//		qo.setPageSize(20);
//		IPageList pList = this.goodsService.list(qo);
//		CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
//		mv.addObject("currentPage", currentPage);
//		mv.addObject("user", user);
//		mv.addObject("er", er);
//		return mv;
//	}
	/***
	 * 年货H5页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/activity/newYearPage")
	public ModelAndView newYearPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("activity/year_goods_page.html", configService.getSysConfig(), 1,
				request, response);
		WxshareTools wxshareTools = new WxshareTools();
		wxshareTools.wxShareMv(mv, request);
		String isflag = request.getParameter("isflag");
		mv.addObject("isflag", isflag);
		return mv;
	}

	/***
	 * 年货产品
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping("/activity/yearGoodsList")
	public void yearGoodsList(HttpServletRequest request, HttpServletResponse response) {
		List goodsList = new ArrayList();
		GoodsCaseVO vo = new GoodsCaseVO();
		vo.setOtherCase(1);// 1年货会
		List<GoodsCaseBO> page = this.goodsCaseService.getPageByVO(vo, null);
		if (null != page && page.size() > 0) {
			page.get(0).getCaseContent();
			List list = (List) Json.fromJson(page.get(0).getCaseContent());
			if (null != list && list.size() > 0) {
				Set set = new HashSet();
				for (Object id : list) {
					set.add(id);
				}
				goodsList = this.goodsService.getByIds(set);
			}
		}

		JSONArray json = JSONArray.fromObject(goodsList);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/***
	 * 年货H5页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/testCallUI.htm")
	public ModelAndView liuLiyTest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("test/testCallUI.html", configService.getSysConfig(), 1, request,
				response);
		return mv;
	}

}
