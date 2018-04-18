package vc.thinker.b2b2c.action.seller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.goods.bo.GoodsLogBO;
import com.sinco.carnation.goods.service.GoodsLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.vo.OrderFormVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.service.StatisticsService;
import com.sinco.common.utils.DateUtils;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: StoreStatSellerAction.java
 * </p>
 * 
 * <p>
 * Description: 商家中心店铺统计控制器
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
 * @date 2014-12-30
 */
@Controller
public class StoreStatSellerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsLogService goodsLogService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private StatisticsService statisticsService;

	@SecurityMapping(title = "店铺统计", value = "/seller/stat_store.htm*", rtype = "seller", rname = "店铺统计", rcode = "seller_stat_store", rgroup = "店铺统计")
	@RequestMapping("/seller/stat_store.htm")
	public ModelAndView stat_store(HttpServletRequest request, HttpServletResponse response,
			String startDate, String endDate) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/stat_store.html",
				configService.getSysConfig(), 0, request, response);
		Date begin;
		Date end;
		if (StringUtils.isNotBlank(startDate) || StringUtils.isNotBlank(endDate)) {
			end = CommUtil.formatDate(endDate);
			begin = CommUtil.formatDate(startDate);
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			end = CommUtil.formatDate(CommUtil.formatShortDate(cal.getTime()));
			cal.add(Calendar.DAY_OF_MONTH, -30);
			begin = CommUtil.formatDate(CommUtil.formatShortDate(cal.getTime()));
		}

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		Map<String, Object> mapRebate = statisticsService.getShopRebateStatistics(userDetails.getUser()
				.getId(), begin, end);
		mv.addObject("mapRebate", mapRebate);

		// 商品点击量排行
		List<GoodsLogBO> click_desc_List = this.goodsLogService.selectGoodsTop(userDetails.getStoreId(),
				begin, end, "desc", 10, 0, "goods_click");
		mv.addObject("click_desc_List", click_desc_List);
		List<GoodsLogBO> click_asc_List = this.goodsLogService.selectGoodsTop(userDetails.getStoreId(),
				begin, end, "asc", 10, 0, "goods_click");
		mv.addObject("click_asc_List", click_asc_List);

		// 商品销量排名
		List<GoodsLogBO> salenum_desc_List = this.goodsLogService.selectGoodsTop(userDetails.getStoreId(),
				begin, end, "desc", 10, 0, "goods_salenum");
		mv.addObject("salenum_desc_List", salenum_desc_List);
		List<GoodsLogBO> salenum_asc_List = this.goodsLogService.selectGoodsTop(userDetails.getStoreId(),
				begin, end, "asc", 10, 0, "goods_salenum");
		mv.addObject("salenum_asc_List", salenum_asc_List);
		// =================================订单成交金额============================================
		// 近期统计
		OrderFormVO vo = new OrderFormVO();
		vo.setOrderForm(0);
		vo.setStoreId(CommUtil.null2String(userDetails.getStoreId()));
		vo.setBeginTime(DateUtils.formatDate(begin));
		vo.setEndTime(DateUtils.formatDate(end));
		vo.setOrderStatus("40");
		BigDecimal of_totalPrice = orderFormService.selectSumTotlePriceByVO(vo);
		mv.addObject("of_totalPrice", of_totalPrice == null ? 0 : of_totalPrice);
		// =================================订单成交总数===========================================
		vo = new OrderFormVO();
		vo.setOrderForm(0);
		vo.setStoreId(CommUtil.null2String(userDetails.getStoreId()));
		vo.setBeginTime(DateUtils.formatDate(begin));
		vo.setEndTime(DateUtils.formatDate(end));
		int orderFormAllCount = orderFormService.selectCountByVO(vo);
		mv.addObject("orderFormAllCount", orderFormAllCount);

		mv.addObject("startDate", startDate);
		mv.addObject("endDate", endDate);
		return mv;
	}

//	@SecurityMapping(title = "地域分布", value = "/seller/stat_formArea.htm*", rtype = "seller", rname = "店铺统计", rcode = "seller_stat_store", rgroup = "店铺统计")
//	@RequestMapping("/seller/stat_formArea.htm")
//	public ModelAndView stat_formArea(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView(
//				"user/default/sellercenter/stat_formArea.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		Date end =CommUtil.formatDate(CommUtil.formatShortDate(cal.getTime()));
//		cal.add(Calendar.DAY_OF_MONTH, -30);
//		Date begin = CommUtil.formatDate(CommUtil.formatShortDate(cal.getTime()));
//		
//		StringBuilder lineDistrictData = new StringBuilder();
//		StringBuilder lineCountData = new StringBuilder();
//		StringBuilder mapCityData = new StringBuilder("{");
//		
//		Map params = new HashMap();
//		params.put("order_form", 0);
//		params.put("store_id", user.getStore().getId().toString());
//		params.put("beginDate", begin);
//		params.put("endDate",end);
//		params.put("order_status",40);
//		//订单地域分布
//		Object formAreaDataTemp = this.orderFormService.query(
//				"select substring(receiver_area,1,2),count(*) from OrderForm obj where obj.order_form =:order_form and obj.store_id=:store_id " +
//				"and obj.order_status>=:order_status and obj.finishTime>=:beginDate and obj.finishTime<:endDate " +
//				"group by substring(receiver_area,1,2) order by count(*) desc",
//				params, -1, -1);
//		List<Object> formAreaDatas = (List<Object>)formAreaDataTemp;
//		
//		List<Map> addAreaData = new ArrayList<Map>();
//		//此处所截取的地名前两个字用以对应前端页面中，SVG地图js文件中的相应地域。
//		for (int i = 0; i < formAreaDatas.size(); i++) {
//			if(i<6){
//				Object[] formAreaData = (Object[]) formAreaDatas.get(i);
//				for (int j = 0; j < formAreaData.length; j++) {
//					if(j==0){
//						if(formAreaData[j].equals("黑龙")){
//							lineDistrictData.append("'").append("黑龙江").append("',");					
//						}else{
//							lineDistrictData.append("'").append(formAreaData[j]).append("',");	
//						}
//						mapCityData.append("'").append(formAreaData[j]).append("':'").append(this.getDistrictColor(i)).append("',");
//					}
//					else{
//						lineCountData.append(formAreaData[j]).append(",");
//					}
//				}				
//			}
//			Map<String,String> map = new HashMap();
//			Object[] formAreaData = (Object[]) formAreaDatas.get(i);
//			String str = CommUtil.null2String(formAreaData[0]);
//			str = str.equals("黑龙")?"黑龙江":str;
//			map.put("name", str);
//			map.put("count",CommUtil.null2String(formAreaData[1]));
//			addAreaData.add(map);
//		}
//		mv.addObject("addAreaData", addAreaData);
//		mv.addObject("lineCityData", lineDistrictData);
//		mv.addObject("lineCountData", lineCountData);
//		mv.addObject("mapCityData", mapCityData.append("}"));
//		return mv;
//	}
//	
//	public String getDistrictColor(int i){
//		switch (i) {
//			case 0:
//			case 1:
//				return "#f00";
//			case 2:
//			case 3:
//				return "#9aff04";
//			case 4:
//			case 5:	
//				return "#fbb688";
//		}
//		return "#BBB";
//	}
//	
}
