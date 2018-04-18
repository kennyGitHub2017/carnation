package vc.thinker.b2b2c.action.elong;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.elong.model.ElongGeo;
import com.sinco.carnation.elong.model.h5.viewmodel.common.PagerDateResult;
import com.sinco.carnation.elong.model.h5.viewmodel.common.ResultInfo;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.HotelDetailRequest;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.HotelDetailViewModel;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.ListPagerRequest;
import com.sinco.carnation.elong.service.ElongGeoService;
import com.sinco.carnation.elong.service.remote.IHotelService;
import com.sinco.carnation.elong.util.DateUtil;
import com.sinco.carnation.sys.service.SysConfigService;

/**
 * 艺龙酒店模块
 * 
 * @author yuanming
 * 
 */
@Controller
public class ElongHotelAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private ElongGeoService elongGeoService;

	
	/**
	 * 酒店首页
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/elong_hotel_index.htm")
	public ModelAndView getElongHotelIndex(ListPagerRequest pagerReq, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("hotel/hotel_index.html", configService.getSysConfig(), 1,
				request, response);
		
		return mv;
	}
	
	
	/**
	 * 酒店列表
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/elong_hotel_list.htm")
	public ModelAndView getElongHotelList(ListPagerRequest pagerReq, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("hotel/hotel_list.html", configService.getSysConfig(), 1,
				request, response);
		// 参数验证与处理
		if (null == pagerReq) {
			pagerReq = new ListPagerRequest();
		}
		if (pagerReq.getArrivalDate() == null) {
			pagerReq.setArrivalDate(new Date());
		}
		if (pagerReq.getDepartureDate() == null) {
			pagerReq.setDepartureDate(DateUtil.addDate(new Date(), 1));
		}
		if (pagerReq.getCityId() == null || "".equals(pagerReq.getCityId())) {
			pagerReq.setCityId("0101");// 默认设置为北京
		}
		if (pagerReq.getPageIndex() == null || pagerReq.getPageIndex() <= 0) {
			pagerReq.setPageIndex(1);// 默认设置为第一页
		}
		if (pagerReq.getPageSize() == null || pagerReq.getPageSize() <= 0) {
			pagerReq.setPageSize(10);// 默认每页显示10条数据
		}
		if (CommUtil.isNotNull(pagerReq.getCityName())) {

			List<ElongGeo> elongGeos = elongGeoService.getGeoByAreaName(pagerReq.getCityName().replace("市",
					""));
			if (null != elongGeos && elongGeos.size() > 0) {
				pagerReq.setCityId(elongGeos.get(0).getAreaCode().toString());
			}
		}
		if (pagerReq.getArrivalDate().getTime() >= pagerReq.getDepartureDate().getTime()) {
			mv.addObject("errorMsg", "离店日期必须大于入店日期");
			return mv;
		}
		Date nowDay = DateUtil.getDateTimeFormat(DateUtil.getCurrentDateStr("yyyy-MM-dd") + " 00:00:00",
				"yyyy-MM-dd");
		if (pagerReq.getArrivalDate().getTime() < DateUtil.addDate(nowDay, -1).getTime()) {
			mv.addObject("errorMsg", "入店日期必须大于等于昨天");
			return mv;
		}
		if (DateUtil.getDifferenceBetweenDay(pagerReq.getDepartureDate(), pagerReq.getArrivalDate()) > 20) {
			mv.addObject("errorMsg", "入离店时间距离不能大于20天");
			return mv;
		}

		// 获取艺龙酒店列表数据
		ResultInfo<PagerDateResult<HotelDetailViewModel>> hotelListRet = hotelService.getHotelList(pagerReq);
		if (hotelListRet.getIsSuccess()) {
			mv.addObject("hotelList", hotelListRet.getData().getList());
		} else {
			System.out.print(hotelListRet.getMsg());
		}
		ElongGeo elongGeos = elongGeoService.getGeoByAreaCode(CommUtil.null2Long(pagerReq.getCityId()));
		if(null != elongGeos){
			mv.addObject("cityName",  elongGeos.getAreaName());
		}
		mv.addObject("cityId", pagerReq.getCityId());
		
		
		return mv;
	}

	/**
	 * 酒店列表（ajax）
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/hotel_list.htm")
	public void getHotelList(ListPagerRequest pagerReq, HttpServletRequest request,
			HttpServletResponse response) {
		// 参数验证与处理
		if (null == pagerReq) {
			pagerReq = new ListPagerRequest();
		}
		if (pagerReq.getArrivalDate() == null) {
			pagerReq.setArrivalDate(new Date());
		}
		if (pagerReq.getDepartureDate() == null) {
			pagerReq.setDepartureDate(DateUtil.addDate(new Date(), 1));
		}
		if (pagerReq.getCityId() == null || "".equals(pagerReq.getCityId())) {
			pagerReq.setCityId("0101");// 默认设置为北京
		}
		if (pagerReq.getPageIndex() == null || pagerReq.getPageIndex() <= 0) {
			pagerReq.setPageIndex(1);// 默认设置为第一页
		}
		if (pagerReq.getPageSize() == null || pagerReq.getPageSize() <= 0) {
			pagerReq.setPageSize(10);// 默认每页显示10条数据
		}

		if (pagerReq.getArrivalDate().getTime() >= pagerReq.getDepartureDate().getTime()) {
			return;
		}
		Date nowDay = DateUtil.getDateTimeFormat(DateUtil.getCurrentDateStr("yyyy-MM-dd") + " 00:00:00",
				"yyyy-MM-dd");
		if (pagerReq.getArrivalDate().getTime() < DateUtil.addDate(nowDay, -1).getTime()) {
			return;
		}
		if (DateUtil.getDifferenceBetweenDay(pagerReq.getDepartureDate(), pagerReq.getArrivalDate()) > 20) {
			return;
		}

		// 获取艺龙酒店列表数据
		ResultInfo<PagerDateResult<HotelDetailViewModel>> hotelListRet = hotelService.getHotelList(pagerReq);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(null != hotelListRet.getData() ? hotelListRet.getData().getList()
					: new HotelDetailViewModel(), JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 酒店详情
	 * 
	 * @param pagerReq
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1/elong_hotel_detail.htm")
	public ModelAndView getElongHotelDetail(HotelDetailRequest detailReq, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("hotel/hotel_detail.html", configService.getSysConfig(), 1,
				request, response);
		try {
			// 参数判断
			if (detailReq == null || detailReq.getHotelId() == null
					|| "".equals(detailReq.getHotelId().trim())) {
				mv.addObject("errorMsg", "请求参数有误");
				return mv;
			}
			if (detailReq.getArrivalDate() == null) {
				detailReq.setArrivalDate(new Date());
			}
			if (detailReq.getDepartureDate() == null) {
				detailReq.setDepartureDate(DateUtil.addDate(new Date(), 1));
			}
			/*测试用的默认值 start*/
//			if (null == detailReq) {
//				detailReq = new HotelDetailRequest();
//			}
//			if (detailReq.getArrivalDate() == null) {
//				detailReq.setArrivalDate(new Date());
//			}
//			if (detailReq.getDepartureDate() == null) {
//				detailReq.setDepartureDate(DateUtil.addDate(new Date(), 1));
//			}
//			if (StringUtils.isBlank(detailReq.getHotelId())) {
//				detailReq.setHotelId("40101006");// 默认设置为北京
//			}
			/*测试用的默认值 end*/
			// 数据查询
			ResultInfo<HotelDetailViewModel> detailRet = hotelService.getHotelDetail(detailReq.getHotelId(),
					detailReq.getArrivalDate(), detailReq.getDepartureDate());
			if (detailRet.getIsSuccess()) {
				HotelDetailViewModel data = detailRet.getData();
				mv.addObject("hotel", data);
				mv.addObject("roomList", data.getRoomList());
			} else {
				mv.addObject("errorMsg", "查询失败：" + detailRet.getMsg());
				System.out.print(detailRet.getMsg());
			}
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("errorMsg", "查询异常");
		}
		if(CommUtil.isNotNull(detailReq.getCityId())){
			mv.addObject("cityId", detailReq.getCityId());
		}
		return mv;
	}

}
