package com.sinco.carnation.resource.web.actions.o2o;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.JsoupUtils;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.o2o.bo.GroupCaseBO;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.constants.GroupOrderConstants;
import com.sinco.carnation.o2o.service.GroupCaseService;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupCaseShowVO;
import com.sinco.carnation.o2o.vo.GroupGoodsListShowVO;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.resource.bo.integral.IntegralOrderDetailsBO;
import com.sinco.carnation.resource.bo.o2o.GroupAreaBO;
import com.sinco.carnation.resource.bo.o2o.GroupClassMO;
import com.sinco.carnation.resource.bo.o2o.GroupServiceBO;
import com.sinco.carnation.resource.bo.o2o.OGroupGoodsBO;
import com.sinco.carnation.resource.bo.paymet.WeiXinPaymetBO;
import com.sinco.carnation.resource.bo.personal.MyselfGroupOrderBO;
import com.sinco.carnation.resource.bo.personal.MyselfGroupOrderLineBO;
import com.sinco.carnation.resource.bo.personal.PGroupBO;
import com.sinco.carnation.resource.bo.personal.PGroupGoodsBO;
import com.sinco.carnation.resource.bo.personal.POrderDetailsBO;
import com.sinco.carnation.resource.bo.personal.PStoreInfoBO;
import com.sinco.carnation.resource.bo.personal.PayPageBO;
import com.sinco.carnation.resource.bo.personal.PserviceBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.personal.GroupStoreCommentVO;
import com.sinco.carnation.resource.vo.personal.MyselfGroupOrderLineVO;
import com.sinco.carnation.resource.vo.personal.MyselfGroupOrderVO;
import com.sinco.carnation.resource.vo.personal.PGroupDetailsVO;
import com.sinco.carnation.resource.vo.personal.PGroupGoodsVO;
import com.sinco.carnation.resource.vo.personal.PayPageVO;
import com.sinco.carnation.resource.vo.personal.PayVO;
import com.sinco.carnation.resource.vo.personal.PromotionGoodVO;
import com.sinco.carnation.resource.vo.shop.ShopGoodsClassVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.integral.IntegralResponse;
import com.sinco.carnation.resource.web.response.o2o.GroupClassResponse;
import com.sinco.carnation.resource.web.response.personal.GroupTradePaymetResponse;
import com.sinco.carnation.resource.web.response.personal.GroupTradePaymetViewResponse;
import com.sinco.carnation.resource.web.response.personal.IntegralSwapResponse;
import com.sinco.carnation.resource.web.response.personal.PersonalResponse;
import com.sinco.carnation.shop.bo.IntegralGoodsOrderBO;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.tools.DistanceUtils;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.orcl.IntegralSwapBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.carnation.user.service.OrclUserBaseService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.dal.common.MyPage;
import com.weixin.utils.Signature;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.pay.tenpay.util.MD5Util;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "o2o个人", namespace = "personal")
public class ApiPersonalAction extends BasicApiController {

	@Autowired
	private GroupCaseService groupCaseService;

	@Autowired
	private GroupGoodsService groupGoodsService;

	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private AlbumService albumService;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@Autowired
	private GroupOrderService groupOrderService;

	@Autowired
	private UserMoneyService userMoneyService;

	@Autowired
	PaymentService paymentService;

	@Autowired
	PredepositService predepositService;

	@Autowired
	private OrderFormService orderFormService;

	@Autowired
	private PayTools payTools;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private UserCustomerService userCustomerService;

	@Autowired
	private Mapper mapper;

	@Autowired
	private SellerService sellerService;

	@Autowired
	private IntegralGoodsOrderService integralGoodsOrderService;

	@Autowired
	private GroupClassService groupClassService;
	
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private OrclUserBaseService orclUserBaseService;

	@RequestMapping(value = "/personal/city/get", method = RequestMethod.POST)
	@MethodMapping(desc = "获取城市")
	public @ResponseBody
	PersonalResponse getCityByName(
			@Valid @RequestParam(value = "cityName") @Param(desc = "城市名称") String cityName) {
		PersonalResponse response = new PersonalResponse();
		if (StringUtils.isBlank(cityName)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Area area = areaService.queryAreaByName(cityName);
		// 如果为空，默认深圳
		if (area == null) {
			area = areaService.queryAreaByName("深圳市");
		}
		GroupAreaBO groupAreaBO = mapper.map(area, GroupAreaBO.class);
		response.setAreaBO(groupAreaBO);
		return response;
	}

	@RequestMapping(value = "/personal/promotion_goods/list", method = RequestMethod.POST)
	@MethodMapping(desc = "促销推荐")
	public @ResponseBody
	PersonalResponse promotionGoods(@Valid @ModelAttribute @Param PromotionGoodVO vo, BindingResult result,
			HttpServletRequest request) {
		PersonalResponse response = new PersonalResponse();

		GroupCaseShowVO caseVO = new GroupCaseShowVO();
		caseVO.setCount(1);
		caseVO.setDisplay(true);
		List<GroupCaseBO> caseList = groupCaseService.findShow(caseVO);
		if (caseList != null && caseList.size() > 0) {
			GroupCaseBO groupCase = caseList.get(0);
			GroupGoodsListShowVO caseGoodsVO = new GroupGoodsListShowVO();
			caseGoodsVO.setCaseId(groupCase.getId());
			caseGoodsVO.setCityId(vo.getCityId());
			MyPage<GroupGoodsBO> page = new MyPage<GroupGoodsBO>();
			page.setPageNumber(vo.getPageNum());
			page.setPageSize(vo.getPageSize());
			List<GroupGoodsBO> caseGoodsList = groupGoodsService.findListPageShow(caseGoodsVO, page);
			if (caseGoodsList != null && caseGoodsList.size() > 0) {
				List<PGroupGoodsBO> goodsBOs = MapperUtils.map(mapper, caseGoodsList, PGroupGoodsBO.class);
				for (PGroupGoodsBO groupGoodsBO : goodsBOs) {
					StoreBO storeBO = storeService.getObjById(groupGoodsBO.getStoreId());
					groupGoodsBO.setStoreName(storeBO.getStoreName());
					Double distance = null;
					// 设置距离
					if (vo != null && vo.getStoreLat() != null && vo.getStoreLon() != null) {
						distance = DistanceUtils.GetDistance(CommUtil.null2Double(storeBO.getStoreLon()),
								CommUtil.null2Double(storeBO.getStoreLat()), vo.getStoreLon(),
								vo.getStoreLat());
					} else {
						distance = 0.00;
					}
					groupGoodsBO.setDistance(distance);
					// 设置服务评分
					groupGoodsBO.setEvaluationAverage(storeBO.getStoreEvaluationAverage());

				}
				response.setGroupGoodsBOs(goodsBOs);
			}
		}

		return response;
	}

	@RequestMapping(value = "/personal/hot_city/get", method = RequestMethod.POST)
	@MethodMapping(desc = "获取热门城市")
	public @ResponseBody
	PersonalResponse getHotCity() {
		PersonalResponse response = new PersonalResponse();
		List<Area> hotCitys = areaService.findGroupHotCity();
		if (hotCitys != null && hotCitys.size() > 0) {
			List<GroupAreaBO> hotCity = MapperUtils.map(mapper, hotCitys, GroupAreaBO.class);
			response.setHotCityList(hotCity);
		}
		return response;
	}

	@RequestMapping(value = "/personal/store/info", method = RequestMethod.POST)
	@MethodMapping(desc = "商户详情")
	public @ResponseBody
	PersonalResponse getStoreInfo(@Valid @ModelAttribute @Param PGroupGoodsVO vo, BindingResult result,
			HttpServletRequest request) {
		PersonalResponse response = new PersonalResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		PGroupBO groupBO = new PGroupBO();
		StoreBO storeBO = storeService.queryStoreById(vo.getStoreId());
		if (storeBO != null) {
			PStoreInfoBO storeInfoBO = mapper.map(storeBO, PStoreInfoBO.class);
			if (StringUtils.isNotBlank(storeBO.getStoreCoverPath())) {
				storeInfoBO.setPhotoPath(storeBO.getStoreCoverPath());
			} else {
				if (storeBO.getCreateUserId() != null) {
					AlbumBO albumBO = albumService.getStoreAlbum(storeBO.getCreateUserId());
					if (albumBO != null) {
						Accessory accessory = accessoryService.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
						if (accessory != null) {
							storeInfoBO.setPhotoPath(accessory.getPath());
						}
					}
				}
			}
			// 设置服务评分
			storeInfoBO.setStoreEvaluationAverage(storeBO.getStoreEvaluationAverage());
			List<Accessory> accessoryList = albumService.queryAccessories(storeBO.getCreateUserId());// 默认相册图片
			storeInfoBO.setPhotoSize(accessoryList.size());
			Double distance = null;
			// 设置距离
			if (vo != null && vo.getStoreLat() != null && vo.getStoreLon() != null) {
				distance = DistanceUtils.GetDistance(CommUtil.null2Double(storeBO.getStoreLon()),
						CommUtil.null2Double(storeBO.getStoreLat()), vo.getStoreLon(), vo.getStoreLat());
			} else {
				distance = 0.00;
			}
			storeInfoBO.setDistance(distance);
			groupBO.setStoreInfoBO(storeInfoBO);
			// response.setStoreInfo(storeInfoBO);
			// 套餐券服务列表
			List<GroupGoodsBO> goodsBOs = groupGoodsService.queryByStoreId(vo.getStoreId(), 1, 0);
			if (goodsBOs != null) {
				List<PGroupGoodsBO> packageList = MapperUtils.map(mapper, goodsBOs, PGroupGoodsBO.class);
				groupBO.setPackageList(packageList);
			}
			// 现金券服务列表
			List<GroupGoodsBO> cashBOs = groupGoodsService.queryByStoreId(vo.getStoreId(), 2, 0);
			if (cashBOs != null) {
				List<PGroupGoodsBO> cashList = MapperUtils.map(mapper, cashBOs, PGroupGoodsBO.class);
				groupBO.setCashList(cashList);
			}
		}
		response.setStoreInfo(groupBO);
		return response;
	}

	@RequestMapping(value = "/personal/group_goods/like", method = RequestMethod.POST)
	@MethodMapping(desc = "服务详细")
	public @ResponseBody
	PersonalResponse groupStoreComment(@Valid @ModelAttribute @Param GroupStoreCommentVO vo,
			BindingResult result, HttpServletRequest request) {
		PersonalResponse response = new PersonalResponse();
		// /PgoodsVO
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		GroupGoodsBO groupGoodsBO = groupGoodsService.queryGroupGoodsById(vo.getgId());
		if (groupGoodsBO != null) {
			OGroupGoodsBO groupBo = mapper.map(groupGoodsBO, OGroupGoodsBO.class);
			if (groupBo != null) {
				if (StringUtils.isBlank(groupBo.getGroupMobileDesc())) {
					groupBo.setGroupMobileDesc(groupGoodsBO.getGroupDesc());
				}
				groupBo.setGroupMobileDesc(JsoupUtils.queryHtml(groupBo.getGroupMobileDesc()));
			}
			Double distance = null;
			// 设置距离
			if (vo != null && vo.getStoreLat() != null && vo.getStoreLon() != null) {
				distance = DistanceUtils.GetDistance(CommUtil.null2Double(groupGoodsBO.getStoreLon()),
						CommUtil.null2Double(groupGoodsBO.getStoreLat()), vo.getStoreLon(), vo.getStoreLat());
			} else {
				distance = 0.00;
			}
			groupBo.setDistance(distance);

			// 主图+获取服务的图片
			String path = groupGoodsService.getGroupAccessoryByGoodId(vo.getgId());
			if (groupBo != null && StringUtils.isNotBlank(path)) {
				groupBo.setGroupAccPath(groupBo.getGroupAccPath() + ";" + path);
			}
			response.setGoodsDetails(groupBo);

			// 根据服务添加时间判断是否能购买
			SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
			int d1Number = Integer.parseInt(f.format(groupGoodsBO.getAddTime()).toString());
			if (d1Number < 20161028) {
				response.setOff(false);
			} else {
				response.setOff(true);
			}
			/*PGroupBO pgroupBO = new PGroupBO();
			StoreBO storeBO = storeService.queryStoreById(groupGoodsBO.getStoreId());
			if(storeBO != null){
				PStoreInfoBO storeInfoBO = mapper.map(storeBO, PStoreInfoBO.class);
				pgroupBO.setStoreInfoBO(storeInfoBO);
				response.setStoreInfo(pgroupBO);
			}*/
		}
		return response;
	}

	@RequestMapping(value = "/personal/group_order/all", method = RequestMethod.POST)
	@MethodMapping(desc = "个人订单列表")
	public @ResponseBody
	PersonalResponse myGroupOrderList(@Valid @ModelAttribute @Param MyselfGroupOrderVO vo,
			BindingResult result, HttpServletRequest request) {
		PersonalResponse response = new PersonalResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		MyPage<GroupOrderBO> page = new MyPage<GroupOrderBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		groupOrderService.queryAllGroupOrderPageList(vo.getStatus(), vo.getOrderType(), uid, page);
		if (page != null && page.getContent().size() > 0) {
			List<MyselfGroupOrderBO> list = MapperUtils.map(mapper, page.getContent(),
					MyselfGroupOrderBO.class);
			for (MyselfGroupOrderBO orderBO : list) {
				if (StringUtils.isNotBlank(orderBO.getGroupInfo())) {
					// 商品信息
					GroupServiceBO serviceBO = JSON.parseObject(orderBO.getGroupInfo(), GroupServiceBO.class);
					orderBO.setService(serviceBO);
					if (serviceBO != null) {
						orderBO.setGoodsCount(serviceBO.getGoods_count());
						GroupGoodsBO goodsBO = groupGoodsService.getObjById(serviceBO.getGoods_id());
						if (goodsBO != null) {
							orderBO.setGroupAccPath(goodsBO.getGroupAccPath());
							orderBO.setGgName(goodsBO.getGgName());
						}
					}
				} else {
					GroupServiceBO serviceBO = new GroupServiceBO();
					StoreBO storeBO = storeService.findObjById(CommUtil.null2Long(orderBO.getStoreId()));
					if (storeBO != null) {
						serviceBO.setGoods_name(storeBO.getStoreName());
						orderBO.setGgName(storeBO.getStoreName());
						if (StringUtils.isBlank(storeBO.getStoreCoverPath())) {
							AlbumBO albumBO = albumService.getStoreAlbum(storeBO.getCreateUserId());
							if (albumBO != null) {
								Accessory accessory = accessoryService.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
								if (accessory != null && StringUtils.isNotBlank(accessory.getPath())) {
									orderBO.setGroupAccPath(accessory.getPath());
								}
							}
						} else {
							orderBO.setGroupAccPath(storeBO.getStoreCoverPath());
						}
					}
					orderBO.setService(serviceBO);
					orderBO.setGoodsCount(1);
				}
				if (orderBO.getOrderType() != null) {
					if (orderBO.getOrderType() == 1) {
						orderBO.setLocalGroupName("线上订单");
					} else if (orderBO.getOrderType() == 2) {
						orderBO.setLocalGroupName("扫码支付");
					} else if (orderBO.getOrderType() == 3) {
						orderBO.setLocalGroupName("优惠买单");
					} else if (orderBO.getOrderType() == 4) {
						orderBO.setLocalGroupName("套餐券");
					} else if (orderBO.getOrderType() == 5) {
						orderBO.setLocalGroupName("代金券");
					}
				}
			}
			response.setMyselfOrderList(list);
		}
		return response;
	}

	@RequestMapping(value = "/personal/group_order/list", method = RequestMethod.POST)
	@MethodMapping(desc = "个人线上订单列表")
	public @ResponseBody
	PersonalResponse myselfGroupOrderList(@Valid @ModelAttribute @Param MyselfGroupOrderVO vo,
			BindingResult result, HttpServletRequest request) {
		PersonalResponse response = new PersonalResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		MyPage<GroupOrderBO> page = new MyPage<GroupOrderBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		groupOrderService.queryGroupOrderPageList(vo.getStatus(), uid, page);
		if (page != null && page.getContent().size() > 0) {
			List<MyselfGroupOrderBO> list = MapperUtils.map(mapper, page.getContent(),
					MyselfGroupOrderBO.class);
			for (MyselfGroupOrderBO orderBO : list) {
				if (StringUtils.isNotBlank(orderBO.getGroupInfo())) {
					// 商品信息
					GroupServiceBO serviceBO = JSON.parseObject(orderBO.getGroupInfo(), GroupServiceBO.class);
					orderBO.setService(serviceBO);
					if (serviceBO != null) {
						GroupGoodsBO goodsBO = groupGoodsService.getObjById(serviceBO.getGoods_id());
						if (goodsBO != null) {
							orderBO.setGroupAccPath(goodsBO.getGroupAccPath());
							orderBO.setGgName(goodsBO.getGgName());
						}
					}
				} else {
					// TODO
					// 扫码支付订单没有商品信息
					// 临时解决
					GroupServiceBO serviceBO = new GroupServiceBO();
					serviceBO.setGoods_name("");
					serviceBO.setGoods_count(1);
					if (orderBO.getLocalGroupName() != null) {
						if (orderBO.getLocalGroupName().indexOf("支付宝") != -1) {
							serviceBO.setGoods_name("商户专属码【支付宝支付】");
						} else if (orderBO.getLocalGroupName().indexOf("微信") != -1) {
							serviceBO.setGoods_name("商户专属码【微信支付】");
						} else {
							serviceBO.setGoods_name(orderBO.getLocalGroupName());
						}
					}
					orderBO.setGroupAccPath("http://f1.ysysgo.com/6,057a51603887e8");
					orderBO.setGgName(serviceBO.getGoods_name());
					orderBO.setService(serviceBO);

				}
				// 如果参数status等于100，则查退款已完成订单
				if (vo.getStatus() == 100) {
					orderBO.setOrderStatus(100l);
				}
			}
			response.setMyselfOrderList(list);
		}
		return response;
	}

	@RequestMapping(value = "/personal/order_line/list", method = RequestMethod.POST)
	@MethodMapping(desc = "个人线下订单列表")
	public @ResponseBody
	PersonalResponse myselfGroupOrderLineList(@Valid @ModelAttribute @Param MyselfGroupOrderLineVO vo,
			BindingResult result, HttpServletRequest request) {
		PersonalResponse response = new PersonalResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<GroupOrderBO> page = new MyPage<GroupOrderBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		Long uid = ActionsUtil.getOwnerUid();
		// groupOrderService.queryGroupOrderLinePageList(uid, vo.getOrderType(), page);
		groupOrderService.queryGroupOrderlist(uid, vo.getOrderType(), page);
		if (page != null && page.getContent().size() > 0) {
			List<MyselfGroupOrderLineBO> list = new ArrayList<MyselfGroupOrderLineBO>();
			for (GroupOrderBO orderBO : page.getContent()) {
				MyselfGroupOrderLineBO bo = new MyselfGroupOrderLineBO();
				StoreBO storeBO = storeService.findObjById(CommUtil.null2Long(orderBO.getStoreId()));
				if (storeBO != null) {
					AlbumBO albumBO = albumService.getStoreAlbum(storeBO.getCreateUserId());
					bo.setStoreName(storeBO.getName());
					if (albumBO != null) {
						Accessory accessory = accessoryService.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
						if (accessory != null && StringUtils.isNotBlank(accessory.getPath())) {
							bo.setGroupAccPath(accessory.getPath());
						}
					}
				}
				bo.setId(orderBO.getId());
				bo.setLocalGroupName(orderBO.getLocalGroupName());
				bo.setTotalPrice(orderBO.getTotalPrice());
				bo.setOriginalPrice(orderBO.getOriginalPrice());
				bo.setOrderStatus(orderBO.getOrderStatus());
				bo.setLocalReturnStatus(orderBO.getLocalReturnStatus());
				bo.setUserNickname(orderBO.getUserNickname());
				bo.setMobile(orderBO.getMobile());
				if (orderBO.getOrderType() != null) {
					if (orderBO.getOrderType() == 1) {
						bo.setLocalGroupName("线上订单");
					} else if (orderBO.getOrderType() == 2) {
						bo.setLocalGroupName("扫码支付");
					} else if (orderBO.getOrderType() == 3) {
						bo.setLocalGroupName("优惠买单");
					} else if (orderBO.getOrderType() == 4) {
						bo.setLocalGroupName("套餐券");
					} else if (orderBO.getOrderType() == 5) {
						bo.setLocalGroupName("代金券");
					}
				}

				list.add(bo);
			}
			response.setMyselfOrderLineList(list);
		}
		return response;
	}

	@RequestMapping(value = "/personal/order/details", method = RequestMethod.POST)
	@MethodMapping(desc = "个人订单详情")
	public @ResponseBody
	PersonalResponse orderDetails(@Valid @ModelAttribute @Param PGroupDetailsVO vo, BindingResult result,
			HttpServletRequest request) {
		PersonalResponse response = new PersonalResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		// POrderDetailsBO detailsBO = new POrderDetailsBO();
		GroupOrderBO orderBO = groupOrderService.queryGroupOrderId(vo.getOrderId());

		UserCustomer customer = userCustomerService.findById(orderBO.getUserId());

		Double distance = 0.00;
		// 设置距离
		if (vo != null && vo.getStoreLat() != null && vo.getStoreLon() != null) {
			distance = DistanceUtils.GetDistance(CommUtil.null2Double(orderBO.getStoreLon()),
					CommUtil.null2Double(orderBO.getStoreLat()), vo.getStoreLon(), vo.getStoreLat());
		} else {
			distance = 0.00;
		}

		// 商品信息
		POrderDetailsBO detailsBO = mapper.map(orderBO, POrderDetailsBO.class);
		detailsBO.setMobile(customer.getMobile());
		if (orderBO.getOrderType() != null) {
			if (orderBO.getOrderType() == 1) {
				detailsBO.setLocalGroupName("线上订单");
			} else if (orderBO.getOrderType() == 2) {
				detailsBO.setLocalGroupName("扫码支付");
			} else if (orderBO.getOrderType() == 3) {
				detailsBO.setLocalGroupName("优惠买单");
			} else if (orderBO.getOrderType() == 4) {
				detailsBO.setLocalGroupName("套餐券");
			} else if (orderBO.getOrderType() == 5) {
				detailsBO.setLocalGroupName("代金券");
			}
		}

		// 设置距离
		detailsBO.setDistance(distance);
		if (orderBO != null && StringUtils.isNotBlank(orderBO.getGroupInfo())
				&& orderBO.getGroupInfoBOList() != null && orderBO.getGroupInfoBOList().size() > 0) {
			GroupServiceBO serviceBO = JSON.parseObject(orderBO.getGroupInfo(), GroupServiceBO.class);

			detailsBO.setEndTime(serviceBO.getGoods_end_time());

			List<PserviceBO> pserviceBOs = MapperUtils.map(mapper, orderBO.getGroupInfoBOList(),
					PserviceBO.class);
			for (PserviceBO pservice : pserviceBOs) {
				pservice.setGroupAccPath(serviceBO.getGoods_mainphoto_path());
				pservice.setTotalPrice(serviceBO.getGoods_price());
				pservice.setGroupName(serviceBO.getGoods_name());
				pservice.setGroupId(serviceBO.getGoods_id());
				if (StringUtils.isBlank(pservice.getCheckReasion())) {
					pservice.setCheckReasion("");
				}
				if (StringUtils.isBlank(pservice.getRefusedInfo())) {
					pservice.setRefusedInfo("");
				}
				//单个核销码状态
				if (null != detailsBO.getOrderStatus()
						&& detailsBO.getOrderStatus().equals(GroupOrderConstants.ORDER_STATUS_OVERDUE)
						&& !pservice.getStatus().equals(1) && !pservice.getStatus().equals(7)) {
					pservice.setStatus(-1);
				}
			}
			detailsBO.setServiceList(pserviceBOs);
		}
		if (detailsBO != null && detailsBO.getOrderStatus() > 10) {
			// if (detailsBO.getOrderType() == 1) {
			if (PaymentConstants.PAYMENT_MARK_BALANCE.equals(detailsBO.getPaymentMark())) {
				detailsBO.setPaymentMark("云豆");
			} else if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(detailsBO.getPaymentMark())) {
				detailsBO.setPaymentMark("微信");
			} else if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(detailsBO.getPaymentMark())) {
				detailsBO.setPaymentMark("支付宝");
			} else if (PaymentConstants.PAYMENT_MARK_YG_WX.equals(detailsBO.getPaymentMark())) {
				detailsBO.setPaymentMark("云购币+微信");
			} else if (PaymentConstants.PAYMENT_MARK_YG_AL.equals(detailsBO.getPaymentMark())) {
				detailsBO.setPaymentMark("云购币+支付宝");
			} else {
				detailsBO.setPaymentMark("");
			}
			// }
		} else {
			detailsBO.setPaymentMark("未付款");
		}

		GroupServiceBO serviceBO = JSON.parseObject(orderBO.getGroupInfo(), GroupServiceBO.class);
		if (serviceBO != null) {
			Long groupId = serviceBO.getGoods_id();
			detailsBO.setGroupId(groupId);
		}

		response.setOrderDetails(detailsBO);
		return response;
	}

	/**
	 * 查询未消费的订单
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/personal/unUsedorder/details", method = RequestMethod.POST)
	@MethodMapping(desc = "个人订单详情")
	public @ResponseBody
	PersonalResponse unUsedOrderDetails(@Valid @ModelAttribute @Param PGroupDetailsVO vo,
			BindingResult result, HttpServletRequest request) {
		PersonalResponse response = new PersonalResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		// POrderDetailsBO detailsBO = new POrderDetailsBO();
		GroupOrderBO orderBO = groupOrderService.queryGroupOrderIdBySpecifiyStatus(vo.getOrderId());
		// GroupOrderBO orderBO = groupOrderService.queryGroupOrderId(vo.getOrderId());

		UserCustomer customer = userCustomerService.findById(orderBO.getUserId());

		// 商品信息
		POrderDetailsBO detailsBO = mapper.map(orderBO, POrderDetailsBO.class);
		detailsBO.setMobile(customer.getMobile());
		if (orderBO.getOrderType() != null) {
			if (orderBO.getOrderType() == 1) {
				detailsBO.setLocalGroupName("线上订单");
			} else if (orderBO.getOrderType() == 2) {
				detailsBO.setLocalGroupName("扫码支付");
			} else if (orderBO.getOrderType() == 3) {
				detailsBO.setLocalGroupName("优惠买单");
			} else if (orderBO.getOrderType() == 4) {
				detailsBO.setLocalGroupName("套餐券");
			} else if (orderBO.getOrderType() == 5) {
				detailsBO.setLocalGroupName("代金券");
			}
		}

		// 设置距离
		// detailsBO.setDistance(distance);
		if (orderBO != null && orderBO.getGroupInfoBOList() != null
				&& orderBO.getGroupInfoBOList().size() > 0) {
			GroupServiceBO serviceBO = JSON.parseObject(orderBO.getGroupInfo(), GroupServiceBO.class);

			detailsBO.setEndTime(serviceBO.getGoods_end_time());

			List<PserviceBO> pserviceBOs = MapperUtils.map(mapper, orderBO.getGroupInfoBOList(),
					PserviceBO.class);
			for (PserviceBO pservice : pserviceBOs) {
				pservice.setGroupAccPath(serviceBO.getGoods_mainphoto_path());
				pservice.setTotalPrice(serviceBO.getGoods_price());
				pservice.setGroupName(serviceBO.getGoods_name());
				pservice.setGroupId(serviceBO.getGoods_id());
			}
			detailsBO.setServiceList(pserviceBOs);
		}
		if (detailsBO != null && detailsBO.getOrderStatus() > 10) {
			// if (detailsBO.getOrderType() == 1) {
			if (PaymentConstants.PAYMENT_MARK_BALANCE.equals(detailsBO.getPaymentMark())) {
				detailsBO.setPaymentMark("云豆");
			} else if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(detailsBO.getPaymentMark())) {
				detailsBO.setPaymentMark("微信");
			} else if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(detailsBO.getPaymentMark())) {
				detailsBO.setPaymentMark("支付宝");
			} else if (PaymentConstants.PAYMENT_MARK_YG_WX.equals(detailsBO.getPaymentMark())) {
				detailsBO.setPaymentMark("云购币+微信");
			} else if (PaymentConstants.PAYMENT_MARK_YG_AL.equals(detailsBO.getPaymentMark())) {
				detailsBO.setPaymentMark("云购币+支付宝");
			} else {
				detailsBO.setPaymentMark("");
			}
			// }
		} else {
			detailsBO.setPaymentMark("未付款");
		}
		response.setOrderDetails(detailsBO);
		return response;
	}

	@RequestMapping(value = "/personal/service/buy", method = RequestMethod.POST)
	@MethodMapping(desc = "立即购买")
	public @ResponseBody
	PersonalResponse buy(@Valid @RequestParam("id") @Param(desc = "服务id") Long id) {
		PersonalResponse response = new PersonalResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		GroupGoodsBO goodsBO = groupGoodsService.getObjById(id);
		if (goodsBO != null) {
			PGroupGoodsBO groupGoodsBO = mapper.map(goodsBO, PGroupGoodsBO.class);
			response.setGroupGoods(groupGoodsBO);
		}
		return response;
	}

	@RequestMapping(value = "/personal/pay/view", method = RequestMethod.POST)
	@MethodMapping(desc = "订单支付需的的详情")
	public @ResponseBody
	GroupTradePaymetViewResponse paymetView(
			@Valid @RequestParam("orderId") @Param(desc = "订单id") Long orderId, HttpServletRequest request) {
		GroupTradePaymetViewResponse response = new GroupTradePaymetViewResponse();

		GroupOrderBO order = groupOrderService.getGroupOrderBOById(orderId);

		response.setOrder(mapper.map(order, com.sinco.carnation.resource.bo.o2o.GroupOrderBO.class));

		return response;
	}

	@RequestMapping(value = "/personal/pay/viewIntegralOrder", method = RequestMethod.POST)
	@MethodMapping(desc = "订单支付需的的详情")
	public @ResponseBody
	IntegralResponse paymetViewIntegralOrder(
			@Valid @RequestParam("orderId") @Param(desc = "订单id") Long orderId, HttpServletRequest request) {
		IntegralResponse response = new IntegralResponse();

		IntegralGoodsOrderBO order = integralGoodsOrderService.getById(orderId);

		IntegralOrderDetailsBO detail = mapper.map(order, IntegralOrderDetailsBO.class);

		response.setDetails(detail);

		return response;
	}

	@RequestMapping(value = "/personal/pay/page", method = RequestMethod.POST)
	@MethodMapping(desc = "支付页面")
	public @ResponseBody
	PersonalResponse payPage(@Valid @ModelAttribute @Param PayPageVO vo, BindingResult result,
			HttpServletRequest request) {
		PersonalResponse response = new PersonalResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		GroupGoodsBO groupGoodsBO = groupGoodsService.getObjById(vo.getId());
		if (groupGoodsBO != null) {
			if (groupGoodsBO.getGroupCount() < vo.getCount()) {
				response.putErrorMessage("4.personal.payPage.Inventory_problem");
				return response;
			}
			if (groupGoodsBO.getGroupStatus().intValue() == -1) {
				response.putErrorMessage("4.group_shop_audit_ailure");
				return response;
			}
			Long flag = groupOrderService.appCreateOrder(vo.getId(), vo.getCount(), uid,
					groupGoodsBO.getStoreId());
			if (flag > 0) {
				GroupOrderBO gBo = groupOrderService.getObjById(flag);
				PayPageBO pageBO = new PayPageBO();
				pageBO.setId(groupGoodsBO.getId());
				pageBO.setGoodsName(groupGoodsBO.getGgName());
				pageBO.setTotalPrice(groupGoodsBO.getGroupPrice().multiply(new BigDecimal(vo.getCount())));
				pageBO.setAvailableBalance(new BigDecimal(userMoneyService.getAvailableBalance(uid)));
				pageBO.setOrderId(gBo.getOrderId());
				pageBO.setId(flag);
				response.setPayPage(pageBO);
				return response;
			} else {
				response.putErrorMessage("创建订单失败");
				return response;
			}
		}
		return response;
	}

	/**
	 * 优惠买单支付页面
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/personal/pay/yhBuy", method = RequestMethod.POST)
	@MethodMapping(desc = "优惠买单")
	public @ResponseBody
	PersonalResponse yhBuy(@Valid @ModelAttribute @Param PayPageVO vo, BindingResult result,
			HttpServletRequest request) {
		PersonalResponse response = new PersonalResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		if (vo.getMoney() == null || vo.getMoney().compareTo(BigDecimal.ZERO) <= 0) {
			response.putErrorMessage("订单金额错误");
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		// SellerBO sellerBO = sellerService.findByUid(vo.getId());
		SellerBO sellerBO = this.sellerService.findSessionById(uid, true, false);
		if (sellerBO != null) {
			Long orderId = groupOrderService.createGroupOrder(uid, sellerBO.getStoreId(), "优惠买单",
					vo.getMoney(), 3);
			if (orderId != null) {
				GroupOrderBO gBo = groupOrderService.getObjById(orderId);
				PayPageBO pageBO = new PayPageBO();
				pageBO.setId(gBo.getId());
				pageBO.setGoodsName(gBo.getLocalGroupName());
				pageBO.setTotalPrice(gBo.getTotalPrice());
				pageBO.setAvailableBalance(new BigDecimal(userMoneyService.getAvailableBalance(uid)));
				pageBO.setOrderId(gBo.getOrderId());
				response.setPayPage(pageBO);
				return response;
			} else {
				response.putErrorMessage("创建订单失败");
				return response;
			}
		} else {
			response.putErrorMessage("卖家信息不存在");
			return response;
		}
	}

	@RequestMapping(value = "/personal/order/pay", method = RequestMethod.POST)
	@MethodMapping(desc = "提交订单")
	public @ResponseBody
	GroupTradePaymetResponse pay(@Valid @ModelAttribute @Param PayVO vo, BindingResult result,
			HttpServletRequest request) {
		GroupTradePaymetResponse response = new GroupTradePaymetResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();

		SysConfigBO config = configService.getSysConfig();

		// 验证是否为用户云豆支付
		Map<String, String> errorParam = new HashMap<>();
		if (vo.getIsAvailableBalance() != null && vo.getIsAvailableBalance()) {
			// 支付密码是否为空
			if (StringUtils.isBlank(vo.getPaymentPassword())) {
				errorParam.put("param", "paymetPassword");
				response.putErrorMessage(MsgCodeConstant.ERROR_PARAM, errorParam);
				return response;
			}
		} else {
			// 支付方式是否正确
			if (StringUtils.isBlank(vo.getPayType())
					|| !(PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(vo.getPayType()) || PaymentConstants.PAYMENT_MARK_WX_APP
							.equals(vo.getPayType()))) {
				errorParam.put("param", "paymetType");
				response.putErrorMessage(MsgCodeConstant.ERROR_PARAM, errorParam);
				return response;
			}
		}

		try {
			GroupOrderBO order = groupOrderService.orderPay(vo.getPayType(), vo.getOrderId(), uid,
					vo.getIsAvailableBalance(), vo.getPaymentPassword(), null);
			Payment payment = null;

			// 如果完成支付
			if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
				response.setIsCompletePay(true);
				return response;
			} else {
				// 如果云豆支付
				if (OrderFormConstants.ORDER_PAY_TYPE_BALANCE.equals(order.getPaymentMark())) {

					Predeposit pr = predepositService.getObjById(order.getCashId());

					// 如果使用云豆支付，找云豆充值记录上的支付方式
					payment = this.paymentService.findByMark(pr.getPdPayment());
				} else if (OrderFormConstants.ORDER_PAY_TYPE_ONLINE.equals(order.getPaymentMark())) {
					// 如果没有使用云豆支付，找订单上的支付方式
					payment = this.paymentService.findById(order.getId());
				}

				String paySignature = payTools.appPay(config.getAddress(), payment.getId().toString(),
						PaymentConstants.ORDER_TYPE_GOODS, order.getId().toString());

				if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(payment.getMark())) {
					response.setWeiXinPaymet(makeWeixinPaymet(payment, paySignature));
				} else if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(payment.getMark())) {
					response.setPaySignature(paySignature);
				}
				response.setPaymetType(payment.getMark());
				return response;
			}
		} catch (ServiceException e) {
			errorParam.put("msg", e.getErrorCode());
			// response.putErrorMessage("4.shop_trade.tradePaymet.failure",
			// errorParam);
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	private WeiXinPaymetBO makeWeixinPaymet(Payment payment, String content) {
		Document doc = Jsoup.parse(content, "", Parser.xmlParser());

		WeiXinPaymetBO weiXinPaymet = new WeiXinPaymetBO();
		weiXinPaymet.setAppid(payment.getWxAppid());
		weiXinPaymet.setPrepayid(doc.select("prepay_id").text());
		weiXinPaymet.setNoncestr(UUID.randomUUID().toString().replace("-", ""));
		weiXinPaymet.setPartnerid(payment.getTenpayPartner());
		weiXinPaymet.setTimestamp(String.valueOf(new Date().getTime() / 1000));

		Map<String, String> map = null;
		try {
			map = BeanUtils.describe(weiXinPaymet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("package", map.get("package1"));
		map.remove("class");
		map.remove("package1");

		String sign = Signature.generateSign(map, payment.getWxPaysignkey());
		weiXinPaymet.setSign(sign);
		return weiXinPaymet;
	}

	@RequestMapping(value = "/personal/order/payment", method = RequestMethod.POST)
	@MethodMapping(desc = "订单列表付款接口")
	public @ResponseBody
	PersonalResponse orderPayment(@Valid @RequestParam(value = "orderId") @Param(desc = "订单id") Long orderId) {
		PersonalResponse response = new PersonalResponse();
		if (orderId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		GroupOrderBO orderBO = groupOrderService.getObjById(orderId);
		if (orderBO != null) {
			GroupServiceBO serviceBO = JSON.parseObject(orderBO.getGroupInfo(), GroupServiceBO.class);
			PayPageBO pageBO = new PayPageBO();
			pageBO.setGoodsName(serviceBO.getGoods_name());
			pageBO.setOrderId(orderBO.getOrderId());
			pageBO.setId(orderBO.getId());
			pageBO.setTotalPrice(orderBO.getTotalPrice());
			pageBO.setAvailableBalance(new BigDecimal(userMoneyService.getAvailableBalance(uid)));
			response.setPayPage(pageBO);
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/group/class/list", method = RequestMethod.POST)
	@MethodMapping(desc = "服务分类列表")
	public @ResponseBody
	GroupClassResponse goodsClassList(@Valid @ModelAttribute @Param ShopGoodsClassVO vo,
			BindingResult result, HttpServletRequest request) {
		GroupClassResponse response = new GroupClassResponse();
		// 第一级分类
		if (vo.getClassNum() == 1) {
			List<GroupClassBO> list = groupClassService.findAllParents();
			List<GroupClassBO> resultList = new ArrayList<>();
			for (GroupClassBO bo : list) {// 过滤类型为不显示的
				if (bo.getDisplay()) {
					if (StringUtils.isBlank(bo.getUrl())) {
						bo.setUrl("url");
					}
					resultList.add(bo);
				}
			}
			List<GroupClassMO> firstGoodsClassList = MapperUtils.map(mapper, resultList, GroupClassMO.class);
			response.setGroupClassList(firstGoodsClassList);
		}
		// 第二三级分类
		if (vo.getClassNum() == 2 || vo.getClassNum() == 3) {
			if (null != vo.getClassId()) {
				List<GroupClassBO> list = groupClassService.findByParent(vo.getClassId());
				List<GroupClassBO> resultList = new ArrayList<>();
				for (GroupClassBO bo : list) {// 过滤类型为不显示的
					if (bo.getDisplay()) {
						if (StringUtils.isBlank(bo.getUrl())) {
							bo.setUrl("url");
						}
						resultList.add(bo);
					}
				}
				List<GroupClassMO> listGoodsClass = MapperUtils.map(mapper, resultList, GroupClassMO.class);
				response.setGroupClassList(listGoodsClass);
			}
		}
		return response;
	}
	
	@RequestMapping(value = "/personal/integral/myIntegral", method = RequestMethod.POST)
	@MethodMapping(desc = "我的积分")
	@ResponseBody
	public IntegralSwapResponse myIntegral(){
		IntegralSwapResponse integral = new IntegralSwapResponse();
		//判断用户身份
		Long uid = ActionsUtil.getOwnerUid();
		//平台积分
		UserCustomer userCustomer = userCustomerService.findOneByUserId(uid);
		if(userCustomer != null){
			integral.setIntegral(userCustomer.getIntegral());
			integral.setNickName(StringUtils.isEmpty(userCustomer.getNickname()) ? userCustomer.getName() : userCustomer.getNickname());
			integral.setHeadImgPath(userCustomer.getHeadImgPath());
		}
		//购物积分
		UserAccount userAccount = userAccountService.findByUid(uid, UserContant.ACCOUNT_TYPE_8);
		if(userAccount != null){
			//CN用户
			integral.setCN(true);
			IntegralSwapBO integralBO = orclUserBaseService.getMyIntegral(userAccount.getLoginName());
			integral.setCnIntegral((integralBO == null || integralBO.getSHOP_PV() == null) ? 0 : integralBO.getSHOP_PV());
			integralBO = orclUserBaseService.getMyCXB(userAccount.getLoginName());
			integral.setBonusRepeat((integralBO == null || integralBO.getBONUS_REPEAT() == null) ? 0d : integralBO.getBONUS_REPEAT());
		}
		return integral;
	}
	
	@RequestMapping(value = "/personal/integral/swap", method = RequestMethod.POST)
	@MethodMapping(desc = "积分兑换")
	@ResponseBody
	public IntegralSwapResponse integralSwap(@Valid @RequestParam(value = "pwd") String pwd, 
			@Valid @RequestParam(value = "exchangeIntegral") @Param(desc = "兑换积分") Integer exchangeIntegral){
		IntegralSwapResponse integral = new IntegralSwapResponse();
		if(exchangeIntegral == null || exchangeIntegral <= 0){
			integral.setStatus(12);
			return integral;
		}
		if(StringUtils.isEmpty(pwd)){
			integral.setStatus(90);
			return integral;
		}
		//判断用户身份
		Long uid = ActionsUtil.getOwnerUid();
		//积分兑换
		pwd = MD5Util.MD5Encode(pwd, "UTF-8");
		IntegralSwapBO integralBO = userCustomerService.integralSwap(uid, pwd, exchangeIntegral);
		integral.setStatus(integralBO.getRETURN_STATUS());
		integral.setStatusMsg(integralBO.getStatusMsg());
		return integral;
	}
	
}
