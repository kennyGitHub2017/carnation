/**   
 * @(#)HotelService.java	2016年11月21日	下午3:58:15	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.service.remote.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.elasticsearch.common.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.elong.api.HotelDetailApi;
import com.sinco.carnation.elong.api.HotelListApi;
import com.sinco.carnation.elong.api.HotelOrderRecentApi;
import com.sinco.carnation.elong.model.elong.BookingRule;
import com.sinco.carnation.elong.model.elong.DrrRule;
import com.sinco.carnation.elong.model.elong.EnumHotelImageType;
import com.sinco.carnation.elong.model.elong.EnumPaymentType;
import com.sinco.carnation.elong.model.elong.EnumQueryType;
import com.sinco.carnation.elong.model.elong.EnumSortType;
import com.sinco.carnation.elong.model.elong.Gift;
import com.sinco.carnation.elong.model.elong.GuaranteeRule;
import com.sinco.carnation.elong.model.elong.HAvailPolicy;
import com.sinco.carnation.elong.model.elong.Hotel;
import com.sinco.carnation.elong.model.elong.HotelDetailCondition;
import com.sinco.carnation.elong.model.elong.HotelImg;
import com.sinco.carnation.elong.model.elong.HotelListCondition;
import com.sinco.carnation.elong.model.elong.ListRatePlan;
import com.sinco.carnation.elong.model.elong.Position;
import com.sinco.carnation.elong.model.elong.PrepayRule;
import com.sinco.carnation.elong.model.elong.RecentOrderedHotel;
import com.sinco.carnation.elong.model.elong.Room;
import com.sinco.carnation.elong.model.elong.ValueAdd;
import com.sinco.carnation.elong.model.h5.result.HotelListResult;
import com.sinco.carnation.elong.model.h5.result.HotelOrderRecentResult;
import com.sinco.carnation.elong.model.h5.viewmodel.common.CommonConstant;
import com.sinco.carnation.elong.model.h5.viewmodel.common.PagerDateResult;
import com.sinco.carnation.elong.model.h5.viewmodel.common.ResultInfo;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.HotelDetailViewModel;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.HotelImage;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.HotelRoom;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.ListPagerRequest;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.RoomRatePlan;
import com.sinco.carnation.elong.service.remote.IHotelService;
import com.sinco.carnation.elong.util.DateUtil;

/**
 * 酒店业务逻辑层
 * 
 * <p>
 * 修改历史: <br>
 * 修改日期 修改人员 版本 修改内容<br>
 * -------------------------------------------------<br>
 * 2016年11月21日 下午3:58:15 user 1.0 初始化创建<br>
 * </p>
 * 
 * @author user
 * @version 1.0
 * @since JDK1.7
 */
@Service
public class HotelService implements IHotelService {

	@Autowired
	private HotelListApi hotelListApi;

	@Autowired
	private HotelDetailApi hotelDetailApi;

	@Autowired
	private HotelOrderRecentApi hotelOrderRecentApi;

	/**
	 * 
	 * 获取酒店列表数据
	 * 
	 * @param req
	 * @return
	 * 
	 * @see com.elong.nb.service.IHotelService#getHotelList(com.elong.nb.model.h5.viewmodel.hotel.ListPagerRequest)
	 */
	@Override
	public ResultInfo<PagerDateResult<HotelDetailViewModel>> getHotelList(ListPagerRequest req) {
		ResultInfo<PagerDateResult<HotelDetailViewModel>> result = new ResultInfo<PagerDateResult<HotelDetailViewModel>>();

		// 请求参数赋值
		HotelListCondition hotelListCondition = new HotelListCondition();
		hotelListCondition.setArrivalDate(req.getArrivalDate());
		hotelListCondition.setDepartureDate(req.getDepartureDate());
		hotelListCondition.setCityId(req.getCityId());
		hotelListCondition.setPageIndex(req.getPageIndex());
		hotelListCondition.setPageSize(req.getPageSize());
		hotelListCondition.setCustomerType("None");// 宾客类型默认为全部
		hotelListCondition.setResultType("3,4");// 返回的数据默认为仅仅酒店详情
		if (StringUtils.isNoneBlank(req.getStarRate())) {
			hotelListCondition.setStarRate(req.getStarRate());
		}
		if (null != req.getLowRate() && req.getLowRate() != 0) {
			hotelListCondition.setLowRate(req.getLowRate());
		}
		if (null != req.getHighRate() && req.getHighRate() != 0) {
			hotelListCondition.setHighRate(req.getHighRate());
		}

		if (StringUtils.isNoneBlank(req.getSort())) {
			hotelListCondition.setSort(EnumSortType.fromValue(req.getSort()));
		}

		if (req.getLatitude() != null && req.getLongitude() != null) {
			Position position = new Position();
			position.setLatitude(req.getLatitude());
			position.setLongitude(req.getLongitude());
			position.setRadius(1000);// 默认搜索附近1000米的酒店
			hotelListCondition.setPosition(position);
		}
		if (req.getQueryText() != null && "".equals(req.getQueryText().trim()) == false) {
			hotelListCondition.setQueryText(req.getQueryText().trim());
			hotelListCondition.setQueryType(EnumQueryType.Intelligent);// 智能搜索：支持酒店名称、位置搜索
		}

		// 调用elong API
		HotelListResult rawResult = hotelListApi.Invoke(hotelListCondition);
		if ("0".equals(rawResult.getCode()) && rawResult.getResult() != null) {
			// 返回参数整理
			PagerDateResult<HotelDetailViewModel> data = new PagerDateResult<HotelDetailViewModel>();
			data.setTotalCount(rawResult.getResult().getCount());
			int totalPage = (rawResult.getResult().getCount() / req.getPageSize())
					+ ((rawResult.getResult().getCount() % req.getPageSize()) == 0 ? 0 : 1);
			data.setIsHaveNextPage((int) req.getPageIndex() < totalPage);
			data.setList(convertToDetailForListPagers(rawResult.getResult().getHotels()));

			result.setData(data);
			result.setIsSuccess(true);
			result.setMsg("获取酒店列表成功");
		} else {
			result.setMsg("API获取酒店列表失败");
			System.out.print(rawResult.getCode());
		}
		return result;
	}

	/**
	 * 
	 * 获取页面使用到的数据实体
	 * 
	 * @param rawHotelList
	 * @return
	 */
	private List<HotelDetailViewModel> convertToDetailForListPagers(List<Hotel> rawHotelList) {
		List<HotelDetailViewModel> vmHotelList = null;
		if (rawHotelList != null && rawHotelList.size() > 0) {
			vmHotelList = new ArrayList<HotelDetailViewModel>();
			for (Hotel hotel : rawHotelList) {
				HotelDetailViewModel vmInfo = convertToDetailViewModel(hotel);
				vmHotelList.add(vmInfo);
			}
		}

		return vmHotelList;
	}

	/**
	 * 
	 * 获取酒店详情
	 * 
	 * @param hotelId
	 *            酒店ID
	 * @param arrivalDate
	 *            到店日期
	 * @param departdDate
	 *            离店日期
	 * @return
	 */
	@Override
	public ResultInfo<HotelDetailViewModel> getHotelDetail(String hotelId, Date arrivalDate, Date departdDate) {
		return getHotelDetail(hotelId, arrivalDate, departdDate, null, null);
	}

	/**
	 * 
	 * 获取酒店详情数据
	 * 
	 * @param hotelId
	 *            酒店ID
	 * @param arrivalDate
	 *            到店日期
	 * @param departdDate
	 *            离店日期
	 * @param ratePlanId
	 *            产品ID
	 * @param roomTypeId
	 *            房型ID
	 * @return
	 */
	@Override
	public ResultInfo<HotelDetailViewModel> getHotelDetail(String hotelId, Date arrivalDate,
			Date departdDate, Integer ratePlanId, String roomTypeId) {
		ResultInfo<HotelDetailViewModel> result = new ResultInfo<HotelDetailViewModel>();

		// 请求参数整理
		HotelDetailCondition condition = new HotelDetailCondition();
		condition.setArrivalDate(arrivalDate);
		condition.setDepartureDate(departdDate);
		condition.setHotelIds(hotelId);
		condition.setOptions("0,1,2,3,4,5,8");
		if (ratePlanId != null) {
			condition.setRatePlanId(ratePlanId);
		}
		if (roomTypeId != null) {
			condition.setRoomTypeId(roomTypeId);
		}

		// 请求elongAPI
		HotelListResult rawResult = hotelDetailApi.Invoke(condition);
		if ("0".equals(rawResult.getCode()) && rawResult.getResult() != null) {
			if (rawResult.getResult().getHotels() != null && rawResult.getResult().getHotels().size() > 0) {
				HotelDetailViewModel data = convertToDetailViewModel(rawResult.getResult().getHotels().get(0));
				data.setArrivalDate(DateUtil.getDateStrByParam("yyyy-MM-dd", arrivalDate));
				data.setDepartureDate(DateUtil.getDateStrByParam("yyyy-MM-dd", departdDate));
				data.setIntervalDay((int) DateUtil.getDifferenceBetweenDay(departdDate, arrivalDate));
				result.setData(data);
			}
			result.setIsSuccess(true);
		} else {
			result.setMsg(rawResult.getCode());
		}
		return result;
	}

	/**
	 * 
	 * 把API返回的实体转换为我们视图层的实体
	 * 
	 * @param hotel
	 * @return
	 */
	private HotelDetailViewModel convertToDetailViewModel(Hotel hotel) {
		HotelDetailViewModel vmInfo = new HotelDetailViewModel();

		// 赋值酒店基本信息
		vmInfo.setHotelId(hotel.getHotelId());
		vmInfo.setLowRate(hotel.getLowRate());
		vmInfo.setCurrencyFlag(hotel.getCurrencyCode() != null ? hotel.getCurrencyCode().getDescription()
				: "￥");
		// 优惠信息
		vmInfo.setHotelFlags(hotel.getHotelFlags());
		if (hotel.getDetail() != null) {
			vmInfo.setHotelName(hotel.getDetail().getHotelName());
			vmInfo.setDistrictName(hotel.getDetail().getDistrictName());
			vmInfo.setBusinessZoneName(hotel.getDetail().getBusinessZoneName());
			vmInfo.setReviewCount(Integer.valueOf(hotel.getDetail().getReview().getCount()));
			vmInfo.setThumbnailUrl(hotel.getDetail().getThumbNailUrl());
			vmInfo.setAddress(hotel.getDetail().getAddress());
			vmInfo.setPhone(hotel.getDetail().getPhone());
			vmInfo.setTraffic(hotel.getDetail().getTraffic());
			vmInfo.setCity(hotel.getDetail().getCity());
			vmInfo.setDistrict(hotel.getDetail().getDistrict());
			vmInfo.setBusinessZone(hotel.getDetail().getBusinessZone());
			// 艺龙推荐级别
			vmInfo.setCategory(hotel.getDetail().getCategory());
			// 评分
			if (null != hotel.getDetail().getReview()
					&& StringUtils.isNotBlank(hotel.getDetail().getReview().getScore())) {
				Integer grade = Integer.valueOf(hotel.getDetail().getReview().getScore().replace("%", "")) * 5 / 100;
				vmInfo.setGrade(grade);
			}
			// 经度
			vmInfo.setLatitude(hotel.getDetail().getLatitude());
			// 维度
			vmInfo.setLongitude(hotel.getDetail().getLongitude());
		} else {
			vmInfo.setHotelName("--");
			vmInfo.setDistrictName("--");
			vmInfo.setBusinessZoneName("--");
			vmInfo.setReviewCount(0);
			vmInfo.setThumbnailUrl(CommonConstant.DEFAULT_HOTEL_IMAGE_THUMBNAIL);
			vmInfo.setAddress("--");
		}
		if (vmInfo.getThumbnailUrl() == null || "".equals(vmInfo.getThumbnailUrl())) {
			vmInfo.setThumbnailUrl(CommonConstant.DEFAULT_HOTEL_IMAGE_THUMBNAIL);
		}
		// 获取酒店的图片
		vmInfo.setHotelImageList(getHotelImages(hotel));

		// 赋值房型属性
		if (hotel.getRooms() != null && hotel.getRooms().size() > 0) {
			List<HotelRoom> hotelRoomList = new ArrayList<HotelRoom>();
			for (Room rawRoom : hotel.getRooms()) {
				HotelRoom room = new HotelRoom();
				// 赋值房型基本信息
				room.setFloor(rawRoom.getFloor());
				room.setBroadnet(rawRoom.getBroadnet());
				room.setComments(rawRoom.getComments());
				room.setCapcity(rawRoom.getCapcity());
				room.setDescription(rawRoom.getDescription());
				room.setRoomId(rawRoom.getRoomId());
				room.setName(rawRoom.getName());
				room.setArea(rawRoom.getArea() != null ? rawRoom.getArea() : "--");
				room.setBedType(rawRoom.getBedType() != null ? rawRoom.getBedType() : "--");
				room.setImageUrl(rawRoom.getImageUrl() != null ? rawRoom.getImageUrl()
						: CommonConstant.DEFAULT_HOTEL_IMAGE_THUMBNAIL);

				BigDecimal lowRate = new BigDecimal(Integer.MAX_VALUE);

				// 赋值房型的产品
				if (rawRoom.getRatePlans() != null && rawRoom.getRatePlans().size() > 0) {
					List<RoomRatePlan> ratePlanList = new ArrayList<RoomRatePlan>();
					for (ListRatePlan rawRatePlan : rawRoom.getRatePlans()) {
						// 若不可销售，则不显示
						if (rawRatePlan.isStatus() == false) {
							continue;
						}

						// 赋值产品信息
						RoomRatePlan ratePlan = new RoomRatePlan();
						ratePlan.setInvoiceMode(rawRatePlan.getInvoiceMode());
						ratePlan.setRatePlanId(rawRatePlan.getRatePlanId());
						ratePlan.setRoomTypeId(rawRatePlan.getRoomTypeId());
						ratePlan.setHotelCode(rawRatePlan.getHotelCode());
						ratePlan.setRatePlanName(rawRatePlan.getRatePlanName());
						ratePlan.setStatus(rawRatePlan.isStatus());
						ratePlan.setTotalRate(rawRatePlan.getTotalRate());
						ratePlan.setAverageRate(rawRatePlan.getAverageRate());
						ratePlan.setGuestType(rawRatePlan.getCustomerType());
						ratePlan.setCurrencyCode(rawRatePlan.getCurrencyCode());
						ratePlan.setCurrencyFlag(rawRatePlan.getCurrencyCode().getDescription());
						ratePlan.setPaymentType(rawRatePlan.getPaymentType());
						ratePlan.setPaymenTypeDesc(rawRatePlan.getPaymentType().getDescriptio());
						// 是否立即确认
						ratePlan.setInstantConfirmation(rawRatePlan.isInstantConfirmation());
						// 是否特价
						ratePlan.setLastMinuteSale(rawRatePlan.isIsLastMinuteSale());

						// 赋值预订规则
						ratePlan.setBookingRuleIds(rawRatePlan.getBookingRuleIds());
						ratePlan.setBookingRulesDesc(getBookingRulesDesc(rawRatePlan.getBookingRuleIds(),
								hotel.getBookingRules()));

						// 赋值担保属性
						ratePlan.setGuaranteeRuleIds(rawRatePlan.getGuaranteeRuleIds());
						ratePlan.setGurantee("".equals(rawRatePlan.getGuaranteeRuleIds()) == false);
						ratePlan.setGuaranteeRuleDesc(getGuaranteeRuleDesc(rawRatePlan.getGuaranteeRuleIds(),
								hotel.getGuaranteeRules()));

						// 赋值预付规则
						ratePlan.setIsPrepay(rawRatePlan.getPaymentType() == EnumPaymentType.Prepay);
						ratePlan.setPrepayRuleIds(rawRatePlan.getPrepayRuleIds());
						ratePlan.setPrepayRuleDesc(getPrepayRuleDesc(rawRatePlan.getPrepayRuleIds(),
								hotel.getPrepayRules()));

						// 赋值促销规则
						ratePlan.setDrrRuleIds(rawRatePlan.getDrrRuleIds());
						ratePlan.setPromotion(rawRatePlan.getDrrRuleIds() != null ? true : false);
						ratePlan.setDrrRuleDesc(getDrrRuleDesc(rawRatePlan.getDrrRuleIds(),
								hotel.getDrrRules()));

						// 赋值增值服务
						ratePlan.setValueAddIds(rawRatePlan.getValueAddIds());
						ratePlan.setPlusValue(rawRatePlan.getValueAddIds() != null ? true : false);
						ratePlan.setValueDesc(getValueDesc(rawRatePlan.getValueAddIds(), hotel.getValueAdds()));

						// 赋值礼品信息
						ratePlan.setGiftIds(rawRatePlan.getGiftIds());
						ratePlan.setHaveGift(rawRatePlan.getGiftIds() != null ? true : false);
						ratePlan.setGiftDesc(getGiftDesc(rawRatePlan.getGiftIds(), hotel.getGifts()));

						// 赋值特殊提醒
						ratePlan.sethAvailPolicyIds(rawRatePlan.getHAvailPolicyIds());
						ratePlan.sethAvailPolicyDesc(getAvailPolicyDesc(rawRatePlan.getHAvailPolicyIds(),
								hotel.getHAvailPolicys()));

						ratePlanList.add(ratePlan);
						if (lowRate.compareTo(rawRatePlan.getAverageRate()) == 1) {
							lowRate = rawRatePlan.getAverageRate();
						}
					}
					// 设置最产品中房型最低价
					room.setLowRate(lowRate);
					room.setRatePlanList(ratePlanList);
				}
				hotelRoomList.add(room);
			}
			vmInfo.setRoomList(hotelRoomList);
			vmInfo.setBookingRules(hotel.getBookingRules());
			vmInfo.setGuaranteeRules(hotel.getGuaranteeRules());
			vmInfo.setPrepayRules(hotel.getPrepayRules());
			vmInfo.setValueAdds(hotel.getValueAdds());
			// 最近预定间隔
			// 在酒店列表页或详情页展示信息的时候，可以增加这个酒店上次预定的时间，提高客人下单率。
			// 暂时不需要 2017-06-14 Tivan
			/*Date recentDate = RecentOrder(hotel.getHotelId());
			if (null != recentDate) {
				Integer recentTimeInterval = DateUtil.getDifferenceBetweenMinutes(new Date(), recentDate);
				vmInfo.setRecentTimeInterval(recentTimeInterval);
			}*/
		}
		return vmInfo;
	}

	/**
	 * 获取酒店的图片
	 * 
	 * @param hotel
	 * @return
	 */
	private List<HotelImage> getHotelImages(Hotel hotel) {
		List<HotelImage> imageList = new ArrayList<HotelImage>();
		if (hotel.getImages() != null && hotel.getImages().size() > 0) {
			for (HotelImg rawImg : hotel.getImages()) {
				HotelImage image = new HotelImage();
				image.setImageTitle(EnumHotelImageType.getImageTitle(rawImg.getType()));
				image.setRoomId(rawImg.getRoomId());
				if (rawImg.getLocations() != null && rawImg.getLocations().size() > 0) {
					// 取第一张图片，即：SizeType = 1，350px*350px
					image.setUrl(rawImg.getLocations().get(0).getUrl());
				}
				imageList.add(image);
			}
		} else {
			imageList.add(new HotelImage(CommonConstant.DEFAULT_HOTEL_IMAGE));
		}
		return imageList;
	}

	/**
	 * 
	 * 获取预订规则描述
	 * 
	 * @param idList
	 * @param ruleList
	 * @return
	 */
	private List<String> getBookingRulesDesc(String idList, List<BookingRule> ruleList) {
		List<String> strList = null;
		if (idList != null && "".equals(idList) == false && ruleList != null && ruleList.size() > 0) {
			String[] ids = idList.split(",");
			strList = new ArrayList<String>();
			for (String id : ids) {
				for (BookingRule r : ruleList) {
					if (r.getBookingRuleId() == Long.parseLong(id)) {
						strList.add(r.getDescription());
						break;
					}
				}
			}
		}
		return strList;
	}

	/**
	 * 
	 * 获取担保规则描述
	 * 
	 * @param idList
	 * @param ruleList
	 * @return
	 */
	private List<String> getGuaranteeRuleDesc(String idList, List<GuaranteeRule> ruleList) {
		List<String> strList = null;
		if (idList != null && "".equals(idList) == false && ruleList != null && ruleList.size() > 0) {
			String[] ids = idList.split(",");
			strList = new ArrayList<String>();
			for (String id : ids) {
				for (GuaranteeRule r : ruleList) {
					if (r.getGuranteeRuleId() == Integer.parseInt(id)) {
						strList.add(r.getDescription());
						break;
					}
				}
			}
		}
		return strList;
	}

	/**
	 * 
	 * 获取预付规则
	 * 
	 * @param idList
	 * @param ruleList
	 * @return
	 */
	private List<String> getPrepayRuleDesc(String idList, List<PrepayRule> ruleList) {
		List<String> strList = null;
		if (idList != null && "".equals(idList) == false && ruleList != null && ruleList.size() > 0) {
			String[] ids = idList.split(",");
			strList = new ArrayList<String>();
			for (String id : ids) {
				for (PrepayRule r : ruleList) {
					if (r.getPrepayRuleId() == Integer.parseInt(id)) {
						strList.add(r.getDescription());
						break;
					}
				}
			}
		}
		return strList;
	}

	/**
	 * 
	 * 获取促销规则说明
	 * 
	 * @param idList
	 * @param ruleList
	 * @return
	 */
	private List<String> getDrrRuleDesc(String idList, List<DrrRule> ruleList) {
		List<String> strList = null;
		if (idList != null && "".equals(idList) == false && ruleList != null && ruleList.size() > 0) {
			String[] ids = idList.split(",");
			strList = new ArrayList<String>();
			for (String id : ids) {
				for (DrrRule r : ruleList) {
					if (r.getDrrRuleId() == Integer.parseInt(id)) {
						strList.add(r.getDescription());
						break;
					}
				}
			}
		}
		return strList;
	}

	/**
	 * 
	 * 获取增值服务的描述
	 * 
	 * @param idList
	 * @param ruleList
	 * @return
	 */
	private List<String> getValueDesc(String idList, List<ValueAdd> ruleList) {
		List<String> strList = null;
		if (idList != null && "".equals(idList) == false && ruleList != null && ruleList.size() > 0) {
			String[] ids = idList.split(",");
			strList = new ArrayList<String>();
			for (String id : ids) {
				for (ValueAdd r : ruleList) {
					if (r.getValueAddId().equals(id)) {
						strList.add(r.getDescription());
						break;
					}
				}
			}
		}
		return strList;
	}

	/**
	 * 
	 * 获取礼品的描述
	 * 
	 * @param idList
	 * @param ruleList
	 * @return
	 */
	private List<String> getGiftDesc(String idList, List<Gift> ruleList) {
		List<String> strList = null;
		if (idList != null && "".equals(idList) == false && ruleList != null && ruleList.size() > 0) {
			String[] ids = idList.split(",");
			strList = new ArrayList<String>();
			for (String id : ids) {
				for (Gift r : ruleList) {
					if (r.getGiftId() == Integer.parseInt(id)) {
						strList.add(r.getGiftContent());
						break;
					}
				}
			}
		}
		return strList;
	}

	/**
	 * 
	 * 获取特殊说明的描述
	 * 
	 * @param idList
	 * @param ruleList
	 * @return
	 */
	private List<String> getAvailPolicyDesc(String idList, List<HAvailPolicy> ruleList) {
		List<String> strList = null;
		if (idList != null && "".equals(idList) == false && ruleList != null && ruleList.size() > 0) {
			String[] ids = idList.split(",");
			strList = new ArrayList<String>();
			for (String id : ids) {
				for (HAvailPolicy r : ruleList) {
					if (r.getId().equals(id)) {
						strList.add(r.getAvailPolicyText());
						break;
					}
				}
			}
		}
		return strList;
	}

	/**
	 * 
	 * 最近预定日期
	 * 
	 * @param orderId
	 * @return
	 */
	public Date RecentOrder(String hotelId) {
		RecentOrderedHotel recent = new RecentOrderedHotel();
		recent.setHotelId(hotelId);
		// 取消订单
		HotelOrderRecentResult rawResult = hotelOrderRecentApi.Invoke(recent);
		if (null != rawResult && null != rawResult.getResult() && null != rawResult.getResult().getHotels()
				&& rawResult.getResult().getHotels().size() > 0) {
			return rawResult.getResult().getHotels().get(0).getRecentBookingTime();
		}
		return null;
	}

}
