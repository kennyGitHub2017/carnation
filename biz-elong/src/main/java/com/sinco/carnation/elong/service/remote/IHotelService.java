/**   
 * @(#)IHotelService.java	2016年11月21日	下午3:57:36	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.service.remote;

import java.util.Date;

import com.sinco.carnation.elong.model.h5.viewmodel.common.PagerDateResult;
import com.sinco.carnation.elong.model.h5.viewmodel.common.ResultInfo;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.HotelDetailViewModel;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.ListPagerRequest;


/**
 * (类型功能说明描述)
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年11月21日 下午3:57:36   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public interface IHotelService {

	/**
	 * 
	 * 获取酒店列表数据
	 *
	 * @param req
	 * @return
	 * @throws Exception 
	 */
	public ResultInfo<PagerDateResult<HotelDetailViewModel>> getHotelList(ListPagerRequest req);
	
	/**
	 * 
	 * 获取酒店详情 
	 *
	 * @param hotelId
	 * @param arrivalDate
	 * @param departdDate
	 * @return
	 */
	public ResultInfo<HotelDetailViewModel> getHotelDetail(String hotelId, Date arrivalDate, Date departdDate);
	
	/**
	 * 
	 * 获取酒店详情 
	 *
	 * @param hotelId
	 * @param arrivalDate
	 * @param departdDate
	 * @param ratePlanId
	 * @param roomTypeId
	 * @return
	 */
	public ResultInfo<HotelDetailViewModel> getHotelDetail(String hotelId, Date arrivalDate, Date departdDate, Integer ratePlanId, String roomTypeId);

}
