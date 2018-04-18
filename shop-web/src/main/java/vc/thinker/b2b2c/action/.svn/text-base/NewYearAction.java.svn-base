package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinco.carnation.market.bo.ActMarketCouponBO;
import com.sinco.carnation.market.bo.ActivityHotSaleGoodsInfoBO;
import com.sinco.carnation.market.service.ActMarketCouponGetService;
import com.sinco.carnation.market.service.ActMarketCouponService;
import com.sinco.carnation.market.service.SaleActivityService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.common.utils.StringUtils;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: NewYearAction.java
 * </p>
 * 
 * <p>
 * Description:2016春节活动
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author rc
 * 
 * @date 2016/1/11
 * 
 * @version 1.0.1
 */
@Controller
public class NewYearAction {

	// 通用日志记录
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private static final ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private SaleActivityService saleActivityService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private ActMarketCouponService actMarketCouponService;

	@Autowired
	private ActMarketCouponGetService actMarketCouponGetService;

	/**
	 * 2016春节活动页面
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 */
	@RequestMapping("/newyear/cash_coupon.htm")
	public ModelAndView cashCoupon(HttpServletRequest request, HttpServletResponse response,
			MyPage<ActivityHotSaleGoodsInfoBO> page) {
		ModelAndView mv = new JModelAndView("newyear/cash_coupon.html", configService.getSysConfig(), 1,
				request, response);

		String vcode = "APP_HOT_SALE";
		page.setPageSize(2);

		saleActivityService.findActHotSaleGoodsListByPage((long) 1, vcode, page);
		MyPage<ActivityHotSaleGoodsInfoBO> pageTemp = page;
		for (int i = 0; i < pageTemp.getContent().size(); i++) {
			ActivityHotSaleGoodsInfoBO entity = pageTemp.getContent().get(i);

			if (entity.getGoodsPrice() != null && entity.getGoodsPrice().toString().trim().length() > 0) {

				BigDecimal a = new BigDecimal(entity.getGoodsPrice().intValue());
				entity.setGoodsPrice(a);

			}

			if (entity.getGoodsMobilePrice() != null
					&& entity.getGoodsMobilePrice().toString().trim().length() > 0) {
				BigDecimal b = new BigDecimal(entity.getGoodsMobilePrice().intValue());
				entity.setGoodsMobilePrice(b);
			}

		}

		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		// ActMarketCouponBO act=actMarketCouponService.getActMarketCouponMax();
		// mv.addObject("id", act.getId());
		if (pageTemp.getContent().size() > 0) {

			mv.addObject("goodsList", pageTemp.getContent().size());
			mv.addObject("maxId", pageTemp.getContent().get(0).getAdId());
		}

		ActMarketCouponBO act = actMarketCouponService.getActMarketCouponMax();
		mv.addObject("obj", act);
		return mv;
	}

	/**
	 * 抢券
	 * 
	 * @param request
	 * @param response
	 * @param id
	 *            活动id
	 * @param userId
	 *            用户id
	 */
	@RequestMapping("/newyear/grab_cash_coupon.htm")
	public void grabCashCoupon(HttpServletRequest request, HttpServletResponse response, Long id, Long userId) {

		writeJson(response, actMarketCouponService.grabCashCoupon(id, userId));
	}

	@RequestMapping(value = "/newyear/ajax_goods_list", method = RequestMethod.GET)
	public @ResponseBody
	String ajaxGoodsList(HttpServletRequest request, String maxId, String actCode, String start) {
		/*if (vo.getStart() == null) 
		{
			vo.setStart(0);
		}
		vo.setPageSize(WebConstant.INVITATION_REPAY_PAGE_SIZE);
		List<CircleInvitationReplyBO> repayList = circleService.queryInvitationReplyList(vo.getMaxId(), vo.getInvitationId(), vo.getStart(), vo.getPageSize());
		if (!CollectionUtils.isEmpty(repayList)) 
		{
			String jsonString = JSON.toJSONString(repayList);
			return jsonString;
		}
		else
		{
			return "no";
		}*/
		Integer startIndex = 0, pageSize;
		Long intMaxId = 0L;
		if (StringUtils.isBlank(start)) {
			startIndex = 0;
		} else {
			startIndex = Integer.parseInt(start);
		}
		pageSize = 2;

		// Integer.valueOf(start);
		if (StringUtils.isNotBlank(maxId)) {
			intMaxId = Long.valueOf(maxId);
		}

		List<ActivityHotSaleGoodsInfoBO> goodsList = saleActivityService.queryActHotSaleGoodsListByPage(
				intMaxId, actCode, startIndex, pageSize);

		if (!CollectionUtils.isEmpty(goodsList)) {
			String jsonString = JSON.toJSONString(goodsList);
			return jsonString;
		} else {
			return JSON.toJSONString("");
		}
	}

	/**
	 * 输出json
	 * 
	 * @param response
	 * @param msg
	 */
	private void writeJson(HttpServletResponse response, Map<String, String> msg) {
		/************ 以下是解决避免ie下载文件 *************/
		response.reset(); // 重置浏览器头信息
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.println(objectMapper.writeValueAsString(msg));
			writer.flush();
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}
	}
}
