package vc.thinker.b2b2c.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sinco.carnation.activity.service.ActivityGoodsService;
import com.sinco.carnation.activity.service.ActivityService;
import com.sinco.carnation.activity.tools.ActivityViewTools;
import com.sinco.carnation.buygift.service.BuyGiftService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.sales.service.EnoughReduceService;
import com.sinco.carnation.sys.bo.orcl.CnUserMoneyBO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;

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
	@Autowired
	private CnPayBaseService cnPayBaseService;

	@RequestMapping("/test/test.htm")
	public void test(HttpServletRequest request, HttpServletResponse response) {
		configService.refreshSysConfig();
		CnUserMoneyBO u1 = cnPayBaseService.getCnUserBounsMoney("CN33054686");
		System.out.println("奖金账户余额====" + u1.getBONUS() + "是否可支付" + u1.getISPAY());
		CnUserMoneyBO u2 = cnPayBaseService.getCnUserRepeatMoney("CN33054686");
		System.out.println("重消账户余额====" + u2.getBONUS_REPEAT() + "是否可支付" + u2.getISPAY());
		/*
		//重消账户测试
		CnUserPayBO u3=cnPayBaseService.OrderPay(3,"CN33054686","N2O00232321",BigDecimal.valueOf(40),"123456","192.168.1.102");
		CnUserMoneyBO u5=cnPayBaseService.getCnUserRepeatMoney("CN33054686");
		System.out.println("重消账户扣款后余额"+u5.getBONUS_REPEAT()+"支付交易号===="+u3.getDEAL_NUMBER()+"是否可支付=="+u3.getISPAY());
		CnUserRefundBO u4=cnPayBaseService.orderRefund("CN33054686","N2O0071",BigDecimal.valueOf(40),u3.getDEAL_NUMBER(),3,"192.168.1.102");
		CnUserMoneyBO u6=cnPayBaseService.getCnUserRepeatMoney("CN33054686");
		System.out.println("重消账户退款后余额"+u6.getBONUS_REPEAT()+"是否退款=="+u4.getISREFUND()+"退款流水号=="+u4.getREFUNFNO());
		
		//奖金账户测试
		CnUserPayBO u7=cnPayBaseService.OrderPay(1,"CN33054686","N2O0044441",BigDecimal.valueOf(50),"123456","192.168.1.102");
		CnUserMoneyBO u8=cnPayBaseService.getCnUserBounsMoney("CN33054686");
		System.out.println("奖金账户扣款后余额"+u8.getBONUS()+"支付交易号===="+u7.getDEAL_NUMBER()+"是否可支付=="+u7.getISPAY());
		CnUserRefundBO u9=cnPayBaseService.orderRefund("CN33054686","N2O0081",BigDecimal.valueOf(50),u7.getDEAL_NUMBER(),1,"192.168.1.102");
		CnUserMoneyBO u10=cnPayBaseService.getCnUserBounsMoney("CN33054686");
		System.out.println("奖金账户退款后余额"+u10.getBONUS()+"是否可退款=="+u9.getISREFUND()+"退款流水号=="+u9.getREFUNFNO());
		*/
	}
}
