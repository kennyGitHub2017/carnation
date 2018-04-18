/**   
 * @(#)ValidateService.java	2016年11月30日	下午4:44:50	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.service.remote.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.elong.api.HotelDataValidateApi;
import com.sinco.carnation.elong.model.elong.EnumValidateResult;
import com.sinco.carnation.elong.model.elong.ValidateCondition;
import com.sinco.carnation.elong.model.h5.result.HotelDataValidateResult;
import com.sinco.carnation.elong.model.h5.viewmodel.common.ResultInfo;
import com.sinco.carnation.elong.model.h5.viewmodel.order.CreateOrderRequest;
import com.sinco.carnation.elong.service.remote.IValidateService;
import com.sinco.carnation.elong.util.DateUtil;

/**
 * (类型功能说明描述)
 * 
 * <p>
 * 修改历史: <br>
 * 修改日期 修改人员 版本 修改内容<br>
 * -------------------------------------------------<br>
 * 2016年11月30日 下午4:44:50 user 1.0 初始化创建<br>
 * </p>
 * 
 * @author user
 * @version 1.0
 * @since JDK1.7
 */
@Service
public class ValidateService implements IValidateService{

	@Autowired
	private HotelDataValidateApi hotelDataValidateApi;

	/**
	 * 进入创建订单页面之前的可预定性验证 该验证包含了产品的可用性验证、库存验证以及价格验证
	 * 
	 * @param orderRequest
	 * @return
	 * 
	 * @see com.elong.nb.service.IValidateService#validateRoom(com.elong.nb.model.h5.viewmodel.order.CreateOrderRequest)
	 */
	@Override
	public ResultInfo<Boolean> validateData(CreateOrderRequest orderRequest) {
		ResultInfo<Boolean> result = new ResultInfo<Boolean>();
		ValidateCondition validateCondition = new ValidateCondition();

		validateCondition.setArrivalDate(orderRequest.getArrivalDate());
		validateCondition.setDepartureDate(orderRequest.getDepartureDate());
		validateCondition.setHotelId(orderRequest.getHotelId());
		validateCondition.setRoomTypeId(orderRequest.getRoomTypeId());
		validateCondition.setRatePlanId(orderRequest.getRatePlanId());
		validateCondition.setTotalPrice(orderRequest.getTotalPrice());
		validateCondition.setNumberOfRooms(1);// 默认设置为1
		validateCondition.setEarliestArrivalTime(getEarliesArrivalTime(orderRequest.getArrivalDate()));
		validateCondition.setLatestArrivalTime(getLatestArrivalTime(orderRequest.getArrivalDate()));

		HotelDataValidateResult validateRet = hotelDataValidateApi.Invoke(validateCondition);
		if ("0".equals(validateRet.getCode())) {
			if (validateRet.getResult() != null
					&& validateRet.getResult().getResultCode() == EnumValidateResult.OK) {
				result.setIsSuccess(true);
				result.setMsg("验证成功");
			} else {
				result.setMsg(validateRet.getResult().getErrorMessage());
			}
		} else {
			result.setMsg("库存验证失败");
			System.out.println(validateRet.getCode());
		}
		return result;
	}

	/**
	 * 
	 * 获取最早入住时间：可选的最早时间内的最早值
	 * 
	 * @param arrivalDate
	 * @return
	 */
	private Date getEarliesArrivalTime(Date arrivalDate) {
		Date retDate;
		Date nowDay = DateUtil.getDateTimeFormat(DateUtil.getCurrentDateStr("yyyy-MM-dd") + " 00:00:00",
				"yyyy-MM-dd");
		String timeString;
		if (arrivalDate.getTime() > nowDay.getTime()) {
			// 入住日期 == 明天、明天以后
			timeString = "07:00:00";
		} else if (arrivalDate.getTime() == nowDay.getTime()) {
			// 入住日期 == 今天
			@SuppressWarnings("deprecation")
			int nowHour = new Date().getHours();
			timeString = nowHour == 23 ? "23:59:00" : ((nowHour + 1) + ":00:00");
		} else {
			// 入住日期 == 昨天
			timeString = "23:59:00";
		}
		retDate = DateUtil.getDateTimeFormat(DateUtil.getDateStrByParam("yyyy-MM-dd", arrivalDate) + " "
				+ timeString, "yyyy-MM-dd HH:mm:ss");
		return retDate;
	}

	/**
	 * 
	 * 获取最晚到店时间：允许的最晚的可选项中最晚的时间
	 * 
	 * @param arrivalDate
	 * @return
	 */
	private Date getLatestArrivalTime(Date arrivalDate) {
		Date retDate;
		String timeString = " 06:00:00";
		Date nextDay = DateUtil.addDate(arrivalDate, 1);
		retDate = DateUtil.getDateTimeFormat(DateUtil.getDateStrByParam("yyyy-MM-dd", nextDay) + timeString,
				"yyyy-MM-dd HH:mm:ss");
		return retDate;
	}
}
