package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.jiuye.bo.JiuyeOrderBO;
import com.sinco.carnation.jiuye.bo.JiuyeTotalDataBO;
import com.sinco.carnation.jiuye.service.JiuyeOrderFormService;
import com.sinco.carnation.jiuye.vo.JiuyeOrderManageVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

import freemarker.core.ParseException;

/**
 * <p>
 * Title: GoodsCaseManageAction.java
 * </p>
 * 
 * <p>
 * Description: 酒业管理控制器
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
 * @date 2014-9-16
 * @version 1.0.1
 */
@Controller
public class JiuyeManageAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private JiuyeOrderFormService jiuyeOrderFormService;

	/**
	 * 酒业 订单管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "订单管理", value = "/admin/jiuye_order.htm*", rtype = "admin", rname = "订单管理", rcode = "jiuye_order", rgroup = "订单管理")
	@RequestMapping("/admin/jiuye_order.htm")
	public ModelAndView jiuye_order(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView(
				"admin/blue/jiuye/jiuye_order.html",
				configService.getSysConfig(), 0, request, response);

		return mv;
	}

	/**
	 * 酒业 订单管理 》 详情
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "订单详情", value = "/admin/jiuye_order_detail.htm*", rtype = "admin", rname = "订单详情", rcode = "jiuye_order_detail", rgroup = "订单详情")
	@RequestMapping("/admin/jiuye_order_detail.htm")
	public ModelAndView jiuye_order_detail(HttpServletRequest request,
			HttpServletResponse response, Integer orderId) {
		ModelAndView mv = new JModelAndView(
				"admin/blue/jiuye/jiuye_order_detail.html",
				configService.getSysConfig(), 0, request, response);

		return mv;
	}

	/**
	 * 酒业 结算管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "结算管理", value = "/admin/jiuye_settlement.htm*", rtype = "admin", rname = "结算管理", rcode = "jiuye_settlement", rgroup = "结算管理")
	@RequestMapping("/admin/jiuye_settlement.htm")
	public ModelAndView jiuye_settlement(HttpServletRequest request,
			HttpServletResponse response, JiuyeOrderManageVO vo,
			MyPage<JiuyeOrderBO> page) {
		ModelAndView mv = new JModelAndView(
				"admin/blue/jiuye/jiuye_settlement.html",
				configService.getSysConfig(), 0, request, response);
		// 获取订单列表
		jiuyeOrderFormService.getJiuyeOrderList(vo, page);
		// 获取订单总数据
		JiuyeTotalDataBO orderTotalData = getTotalData(vo);

		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		mv.addObject("orderTotalData", orderTotalData);
		return mv;
	}

	/**
	 * 酒业 结算管理 》 详情
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "订单详情", value = "/admin/jiuye_settlement_detail.htm*", rtype = "admin", rname = "订单详情", rcode = "jiuye_settlement_detail", rgroup = "订单详情")
	@RequestMapping("/admin/jiuye_settlement_detail.htm")
	public ModelAndView jiuye_settlement_detail(HttpServletRequest request,
			HttpServletResponse response, Integer orderId) {
		ModelAndView mv = new JModelAndView(
				"admin/blue/jiuye/jiuye_settlement_detail.html",
				configService.getSysConfig(), 0, request, response);

		return mv;
	}

	/**
	 * 酒业结算统计
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "结算统计", value = "/admin/jiuye_total.htm*", rtype = "admin", rname = "结算管理", rcode = "jiuye_settlement", rgroup = "结算管理")
	@RequestMapping("/admin/jiuye_total.htm")
	public void jiuye_total(HttpServletRequest request,
			HttpServletResponse response, JiuyeOrderManageVO vo) {
		// 获取订单总数据
		JiuyeTotalDataBO orderTotalData = getTotalData(vo);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(orderTotalData));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取订单总数据
	 * 
	 * @param vo
	 * @return
	 */
	private JiuyeTotalDataBO getTotalData(JiuyeOrderManageVO vo) {
		// 总销售金额
		JiuyeTotalDataBO totalSalesBO = jiuyeOrderFormService
				.findOrderTotalPayMoney(vo);
		BigDecimal totalSales = null != totalSalesBO ? totalSalesBO
				.getTotalSales() : BigDecimal.ZERO;
		// 总佣金金额(酒业商品给平台佣金是商品价格的15%)
		BigDecimal totalCommission = totalSales == BigDecimal.ZERO ? BigDecimal.ZERO
				: totalSales.multiply(new BigDecimal(0.15)).setScale(2,
						BigDecimal.ROUND_HALF_UP);
		// 总退款金额
		JiuyeTotalDataBO totalRefundsBO = jiuyeOrderFormService
				.findOrderTotalRefundsMoney(vo);
		BigDecimal totalRefunds = null != totalRefundsBO ? totalRefundsBO
				.getTotalRefunds() : BigDecimal.ZERO;

		JiuyeTotalDataBO orderTotalData = new JiuyeTotalDataBO(totalSales,
				totalCommission, totalRefunds);
		return orderTotalData;
	}

}