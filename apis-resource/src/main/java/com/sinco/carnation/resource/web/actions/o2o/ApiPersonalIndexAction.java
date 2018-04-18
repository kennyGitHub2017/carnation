package com.sinco.carnation.resource.web.actions.o2o;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.WordFind;

import com.alibaba.fastjson.JSON;
import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.model.GroupEvaluation;
import com.sinco.carnation.o2o.service.GroupEvaluationService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.resource.bo.o2o.GroupAreaBO;
import com.sinco.carnation.resource.bo.o2o.GroupServiceBO;
import com.sinco.carnation.resource.bo.o2o.OGroupGoodsBO;
import com.sinco.carnation.resource.bo.personal.AwayStoreBO;
import com.sinco.carnation.resource.bo.personal.FavaGroupGoodsBO;
import com.sinco.carnation.resource.bo.personal.GroupStoreFavaBO;
import com.sinco.carnation.resource.bo.personal.RecommStoreInfoBO;
import com.sinco.carnation.resource.bo.personal.StoreSearchBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.personal.AwayStoreVO;
import com.sinco.carnation.resource.vo.personal.ClassFindVO;
import com.sinco.carnation.resource.vo.personal.CommentVO;
import com.sinco.carnation.resource.vo.personal.FavaCancelVO;
import com.sinco.carnation.resource.vo.personal.FavaGroupGoodsVO;
import com.sinco.carnation.resource.vo.personal.KeyWordVO;
import com.sinco.carnation.resource.vo.personal.PfavoritesVO;
import com.sinco.carnation.resource.vo.personal.RecommendStoreVO;
import com.sinco.carnation.resource.vo.personal.YouLikeGoodsVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.NullResponse;
import com.sinco.carnation.resource.web.response.personal.HotCityResponse;
import com.sinco.carnation.resource.web.response.personal.PersonalIndexResponse;
import com.sinco.carnation.resource.web.util.MyDistanceUtil;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.search.StoreDocument;
import com.sinco.carnation.store.search.StoreSearchResult;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreSearchVO;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.model.UserCustomerFavorites;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

import edu.emory.mathcs.backport.java.util.Collections;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "个人o2o", namespace = "personal")
public class ApiPersonalIndexAction {

	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private StoreSearchService searchService;

	@Autowired
	private GroupOrderService groupOrderService;

	@Autowired
	private GroupEvaluationService evaluationService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private GroupGoodsService groupGoodsService;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private GroupInfoService groupInfoService;
	@Autowired
	private WordFind wordFind;

	@Autowired
	private Mapper mapper;

	@Autowired
	private AreaServiceImpl areaServiceImpl;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private AccessoryServiceImpl accessoryService;

	/**
	 * 
	 * @param vo
	 *            // 默认深圳 // vo1.setAreaId(Long.valueOf(4524157)); vo1.setCityId(Long.valueOf(4524157));
	 *            vo1.setStoreLat(Double.valueOf(22.5362));// 经度 vo1.setStoreLon(Double.valueOf(114.075));//
	 *            纬度
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/personal/class_find/list", method = RequestMethod.POST)
	@MethodMapping(desc = "分类搜索")
	public @ResponseBody
	PersonalIndexResponse classificationFind(@Valid @ModelAttribute @Param ClassFindVO vo,
			BindingResult result, HttpServletRequest request) {
		PersonalIndexResponse response = new PersonalIndexResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<StoreDocument> page = new MyPage<StoreDocument>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		if (vo.getOrderType() != null) {
			switch (vo.getOrderType()) {
				case 1:
					page.setOrderBy("DISTANCE");
					page.setOrder("asc");
					break;
				case 2:
					page.setOrderBy("CREDIT");
					page.setOrder("desc");
					break;
				default:
					page.setOrderBy("DEFAULT");
					break;
			}
		} else {
			page.setOrderBy("DEFAULT");
		}

		StoreSearchVO vo1 = new StoreSearchVO();
		vo1.setAreaId(vo.getAreaId());// 地区
		vo1.setCityId(vo.getCityId());// 城市
		vo1.setClassId(vo.getClassId());// 分类
		vo1.setDistance(vo.getDistance());// 距离
		vo1.setStoreLat(vo.getStoreLat());// 经度
		vo1.setStoreLon(vo.getStoreLon());// 纬度
		StoreSearchResult storeResult = searchService.search(vo1, page);
		if (storeResult.getPage() != null) {
			List<StoreSearchBO> list = MapperUtils.map(mapper, storeResult.getPage().getContent(),
					StoreSearchBO.class);
			if (list != null && list.size() > 0) {
				for (StoreSearchBO storeSearchBO : list) {
					StoreBO store = storeService.getObjById(storeSearchBO.getId());
					if (store != null && store.getGroupDiscount() != null) {
						storeSearchBO.setGroupDiscount(store.getGroupDiscount().multiply(new BigDecimal(10)));
					}
					if(StringUtils.isNotBlank(store.getStoreCoverPath())){
						storeSearchBO.setStoreInfoPath(store.getStoreCoverPath());
					}else{
						if(store.getCreateUserId() != null){
							AlbumBO albumBO = albumService.getStoreAlbum(store.getCreateUserId());
							if (albumBO != null) {
								Accessory accessory = accessoryService.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
								if (accessory != null) {
									storeSearchBO.setStoreInfoPath(accessory.getPath());
								}
							}
						}
					}
				}
			}
			response.setSearchStoreList(list);
		}
		return response;
	}

	@RequestMapping(value = "/personal/all_city/list", method = RequestMethod.POST)
	@MethodMapping(desc = "所有城市")
	public @ResponseBody
	PersonalIndexResponse allCitys() {
		PersonalIndexResponse response = new PersonalIndexResponse();
		Map<String, List<Area>> cityAll = areaService.findPinyinMap();
		/*
		List<Area> allList = new ArrayList<Area>();
		for (Map.Entry<String, List<Area>> entry : cityAll.entrySet()) {
			allList.addAll(entry.getValue());
		}
		List<GroupAreaBO> areaListBos = MapperUtils.map(mapper, allList, GroupAreaBO.class);
		response.setAreaListBos(areaListBos);
		*/
		List<GroupAreaBO[]> allList = new ArrayList<GroupAreaBO[]>();
		for (String key : cityAll.keySet()) {
			List<Area> all = cityAll.get(key);
			List<GroupAreaBO> areaListBos = MapperUtils.map(mapper, all, GroupAreaBO.class);
			allList.add(areaListBos.toArray(new GroupAreaBO[0]));
		}
		response.setAreaListBos(allList);
		return response;
	}

	@RequestMapping(value = "/personal/keyword/search", method = RequestMethod.POST)
	@MethodMapping(desc = "关键字搜索")
	public @ResponseBody
	PersonalIndexResponse searchKeyword(@Valid @ModelAttribute @Param KeyWordVO vo, BindingResult result,
			HttpServletRequest request) {
		PersonalIndexResponse response = new PersonalIndexResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<StoreDocument> page = new MyPage<StoreDocument>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		if (vo.getOrderType() != null) {
			switch (vo.getOrderType()) {
				case 1:
					page.setOrderBy("DISTANCE");
					page.setOrder("asc");
					break;
				case 2:
					page.setOrderBy("CREDIT");
					page.setOrder("desc");
					break;
				default:
					page.setOrderBy("DEFAULT");
					break;
			}
		} else {
			page.setOrderBy("DEFAULT");
		}

		StoreSearchVO vo1 = new StoreSearchVO();
		vo1.setCityId(vo.getCityId());
		vo1.setKeyword(vo.getKeyWord());
		vo1.setStoreLat(vo.getStoreLat());
		vo1.setStoreLon(vo.getStoreLon());
		vo1.setDistance(vo.getDistance());
		vo1.setAreaId(vo.getAreaId());

		StoreSearchResult storeResult = searchService.search(vo1, page);
		if (storeResult.getPage() != null) {
			List<StoreSearchBO> list = MapperUtils.map(mapper, storeResult.getPage().getContent(),
					StoreSearchBO.class);
			if (list != null && list.size() > 0) {
				for (StoreSearchBO storeSearchBO : list) {
					StoreBO store = storeService.getObjById(storeSearchBO.getId());
					if (store != null) {
						if(store.getGroupDiscount() != null){
							storeSearchBO.setGroupDiscount(store.getGroupDiscount().multiply(new BigDecimal(10)));
						}
						//设置店铺封面
						if(StringUtils.isNotBlank(store.getStoreCoverPath())){
							storeSearchBO.setStoreInfoPath(store.getStoreCoverPath());
						}else{
							if(store.getCreateUserId() != null){
								AlbumBO albumBO = albumService.getStoreAlbum(store.getCreateUserId());
								if (albumBO != null) {
									Accessory accessory = accessoryService.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
									if (accessory != null) {
										storeSearchBO.setStoreInfoPath(accessory.getPath());
									}
								}
							}
						}
					}
				}
			}
			response.setKeyWordList(list);
		}
		return response;
	}

	@RequestMapping(value = "/personal/area_parent/list", method = RequestMethod.POST)
	@MethodMapping(desc = "根据父id取子集")
	public @ResponseBody
	PersonalIndexResponse queryAreaByParentId(
			@Valid @RequestParam(value = "areaId") @Param(desc = "地区id") Long areaId) {
		PersonalIndexResponse response = new PersonalIndexResponse();
		if (areaId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		List<Area> list = areaService.getCacheByParentId(areaId.toString());
		if (list != null && list.size() > 0) {
			List<GroupAreaBO> areaListBos = MapperUtils.map(mapper, list, GroupAreaBO.class);
			response.setAreaList(areaListBos);
		}

		return response;
	}

	@RequestMapping(value = "/personal/goods/details", method = RequestMethod.POST)
	@MethodMapping(desc = "订单评价")
	public @ResponseBody
	PersonalIndexResponse commentPage(
			@Valid @RequestParam(value = "orderId") @Param(desc = "订单id") Long orderId) {
		PersonalIndexResponse response = new PersonalIndexResponse();
		if (orderId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		GroupOrderBO orderBO = groupOrderService.getObjById(orderId);
		if (orderBO != null && StringUtils.isNotBlank(orderBO.getGroupInfo())) {
			GroupServiceBO serviceBO = JSON.parseObject(orderBO.getGroupInfo(), GroupServiceBO.class);

			response.setService(serviceBO);
		}
		return response;
	}

	@RequestMapping(value = "/personal/comment/save", method = RequestMethod.POST)
	@MethodMapping(desc = "评论保存")
	public @ResponseBody
	PersonalIndexResponse commentSave(@Valid @ModelAttribute @Param CommentVO vo, BindingResult result,
			HttpServletRequest request) {
		PersonalIndexResponse response = new PersonalIndexResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		// 帖子内容有敏感词
		if (wordFind.find(vo.getContent()).length > 0) {
			response.putErrorMessage("5.personal.commentSave.word_fail");
			return response;
		}

		GroupOrderBO orderBO = groupOrderService.getObjById(vo.getOrderId());
		if (orderBO == null) {
			response.putErrorMessage("4.personal.commentSave.order_not_exist");
			return response;
		}

		if (orderBO.getOrderStatus() >= 50) {
			response.putErrorMessage("4.personal.commentSave.order_evaluation_yes");
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		GroupEvaluation evaluation = new GroupEvaluation();
		evaluation.setContent(vo.getContent());
		evaluation.setEvaluateUserId(uid);
		evaluation.setOrderId(vo.getOrderId());
		evaluation.setScore(vo.getEvaluationAverage());
		evaluation.setPhotoUrls(vo.getPhoto());
		evaluation.setEvaluateTime(new Date());
		evaluation.setStatus(2);
		try {
			boolean flag = evaluationService.save(evaluation);
			response.setIsEvaluation(flag);
		} catch (Exception e) {
			response.setIsEvaluation(false);
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/personal/favorites/list", method = RequestMethod.POST)
	@MethodMapping(desc = "收藏的商户列表")
	public @ResponseBody
	PersonalIndexResponse myselfFavoritesList(@Valid @ModelAttribute @Param PfavoritesVO vo,
			BindingResult result, HttpServletRequest request) {
		PersonalIndexResponse response = new PersonalIndexResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		Double storelat = 0.0;
		Double storelon = 0.0;
		MyPage<StoreBO> page = new MyPage<StoreBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		if (null != vo.getStoreLat() && null != vo.getStoreLon()) {
			storelat = vo.getStoreLat();
			storelon = vo.getStoreLon();
		}
		storeService.queryStoreFavorites(uid, 6, storelat, storelon, page);
		if (page != null) {
			List<GroupStoreFavaBO> list = MapperUtils.map(mapper, page.getContent(), GroupStoreFavaBO.class);
			response.setFavaStoreList(list);
		}

		return response;
	}

	@RequestMapping(value = "/personal/order/refund", method = RequestMethod.POST)
	@MethodMapping(desc = "取消订单")
	public @ResponseBody
	PersonalIndexResponse refundOrder(
			@Valid @RequestParam(value = "orderId") @Param(desc = "订单id") Long orderId) {
		PersonalIndexResponse response = new PersonalIndexResponse();
		if (orderId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		try {
			groupOrderService.cancelOrder(orderId);
		} catch (ServiceException e) {
			response.putErrorMessage("4.personal.refundOrder.refundOrder_fail");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/personal/coupon/refund", method = RequestMethod.POST)
	@MethodMapping(desc = "服务消费券退款")
	public @ResponseBody
	NullResponse refundCoupon(@Valid @RequestParam(value = "groupSn") @Param(desc = "消费码") String groupSn,
			@Valid @RequestParam(value = "refundReasion") @Param(desc = "退款原因") String refundReasion) {
		NullResponse response = new NullResponse();

		GroupInfoBO info = this.groupInfoService.findByGroupSN(groupSn);

		Long uid = ActionsUtil.getOwnerUid();
		if (info == null) {
			response.putErrorMessage("4.personal.group_sn_not_find");
			return response;
		}

		try {
			groupInfoService.refundInfo(info.getId().toString(), refundReasion, uid);
			response.setSubMsg("服务消费券退款申请成功！");
		} catch (Exception e) {
			response.putErrorMessage("4.personal.group_sn_apply_failure");
		}

		return response;
	}

	@RequestMapping(value = "/personal/recomm_store/list", method = RequestMethod.POST)
	@MethodMapping(desc = "首页推荐店铺")
	public @ResponseBody
	PersonalIndexResponse recommendStore(@Valid @ModelAttribute @Param RecommendStoreVO vo,
			BindingResult result, HttpServletRequest request) {
		PersonalIndexResponse response = new PersonalIndexResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<StoreBO> page = new MyPage<StoreBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(10);
		if (vo.getAreaId() == null || vo.getAreaId() <= 0) {
			vo.setAreaId(null);
		}
		// storeService.queryRecommStore(vo.getAreaId(), vo.getStoreLat(),
		// vo.getStoreLon(), page);
		// 默认深圳，此处后期许修改
		// if(vo.getAreaId() == null){
		// vo.setAreaId(Long.valueOf(4524157));
		// }
		storeService.queryRecommStore(vo.getAreaId(), vo.getStoreLat(), vo.getStoreLon(), null, page);
		if (page.getContent() != null && page.getContent().size() > 0) {
			List<RecommStoreInfoBO> list = MapperUtils
					.map(mapper, page.getContent(), RecommStoreInfoBO.class);
			response.setRecommStoreInfo(list);
		}
		// 如果当前城市没有找到店铺或店铺不足pageSize，默认取深圳的店铺
		/*
		if(response.getRecommStoreInfo() == null || response.getRecommStoreInfo().size() < page.getPageSize()){
			page.setContent(null);
			page.setPageNumber(vo.getPageNum());
			if(response.getRecommStoreInfo() == null){
				page.setPageSize(vo.getPageSize());
			}else{
				page.setPageSize(vo.getPageSize() - response.getRecommStoreInfo().size());
			}
			storeService.queryRecommStore(vo.getAreaId(), vo.getStoreLat(), vo.getStoreLon(), false, page);
			if(page.getContent() != null && page.getContent().size() > 0){
				List<RecommStoreInfoBO> list = MapperUtils.map(mapper, page.getContent(), RecommStoreInfoBO.class);
				response.getRecommStoreInfo().addAll(list);
			}
		}
		*/
		// 按照距离升序
		if (vo.getAreaId() == null && response.getRecommStoreInfo() != null
				&& response.getRecommStoreInfo().size() > 0) {
			Collections.sort(response.getRecommStoreInfo(), new Comparator<RecommStoreInfoBO>() {
				public int compare(RecommStoreInfoBO arg0, RecommStoreInfoBO arg1) {
					return arg0.getDistance().compareTo(arg1.getDistance());
				}
			});
		}
		return response;
	}

	/*
	@RequestMapping(value = "/personal/away_store/list", method = RequestMethod.POST)
	@MethodMapping(desc = "离我最近")
	public @ResponseBody PersonalIndexResponse awayMeStore(@Valid @ModelAttribute @Param AwayStoreVO vo,
			BindingResult result, HttpServletRequest request) {
		PersonalIndexResponse response = new PersonalIndexResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<StoreDocument> page = new MyPage<StoreDocument>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		page.setOrderBy("DISTANCE");
		page.setOrder("asc");

		StoreSearchVO vo1 = new StoreSearchVO();
		if (vo != null) {
			 //vo1.setCityId(vo.getAreaId());
			// 默认深圳，此出后期许修改
	//			vo1.setCityId(Long.valueOf(4524157));
			if (vo.getStoreLat() != null || vo.getStoreLon() != null) {
				vo1.setStoreLat(vo.getStoreLat());// 经度
				vo1.setStoreLon(vo.getStoreLon());// 纬度
			}
		}
		// 查找有服务上架的
		vo1.setIsGoods(true);

		try{
			StoreSearchResult storeResult = searchService.search(vo1, page);
			
			if (storeResult.getPage() != null) {
				List<AwayStoreBO> list = MapperUtils.map(mapper, storeResult.getPage().getContent(), AwayStoreBO.class);
				for (AwayStoreBO awayStoreBO : list) {
					StoreBO storeBo = storeService.getObjById(awayStoreBO.getId());
					if(storeBo != null){
						//折扣*10，方便APP显示 
						if(storeBo.getGroupDiscount() != null){
							awayStoreBO.setGroupDiscount(storeBo.getGroupDiscount().multiply(new BigDecimal(10)));
						}
					}
					GroupGoodsBO goods = groupGoodsService.queryAwayStoreInfo(awayStoreBO.getId());
					if (goods != null) {
						awayStoreBO.setGoodsId(goods.getId());
						awayStoreBO.setGoodsName(goods.getGgName());
						awayStoreBO.setGoodsPath(goods.getGroupAccPath());
						awayStoreBO.setPrice(goods.getGroupPrice());
						awayStoreBO.setSales(goods.getSelledCount());
						awayStoreBO.setCostPrice(goods.getCostPrice());//增加原价
					}
				}
				
				// 按照距离升序
				if(vo.getStoreLat() != null && vo.getStoreLon() != null && list != null && list.size() > 0){
					Collections.sort(list, new Comparator<AwayStoreBO>() {
						public int compare(AwayStoreBO arg0, AwayStoreBO arg1) {
							return arg0.getDistance().compareTo(arg1.getDistance());
						}
					});
				}

				// 过滤掉没有goodsId（服务）的集合
				Iterator<AwayStoreBO> awayStoreIter = list.iterator();
				while (awayStoreIter.hasNext()) {
					AwayStoreBO awayStore = awayStoreIter.next();
					if (awayStore.getGoodsId() == null)
						awayStoreIter.remove();
				}
				response.setAwayStoreList(list);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return response;
	}*/

	@RequestMapping(value = "/personal/away_store/list", method = RequestMethod.POST)
	@MethodMapping(desc = "离我最近")
	public @ResponseBody
	PersonalIndexResponse awayMeStore(@Valid @ModelAttribute @Param AwayStoreVO vo, BindingResult result,
			HttpServletRequest request) {
		PersonalIndexResponse response = new PersonalIndexResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<StoreBO> page = new MyPage<StoreBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(10);
		if (vo.getAreaId() == null || vo.getAreaId() <= 0) {
			vo.setAreaId(null);
		}
		storeService.queryStoreGoods(vo.getAreaId(), vo.getStoreLat(), vo.getStoreLon(), null, page);
		if (page != null && page.getContent().size() > 0) {
			List<AwayStoreBO> list = new ArrayList<AwayStoreBO>();
			for (StoreBO storeBO : page.getContent()) {
				AwayStoreBO awayStoreBO = new AwayStoreBO();
				awayStoreBO.setId(storeBO.getId());
				awayStoreBO.setStoreName(storeBO.getStoreName());
				awayStoreBO.setDistance(storeBO.getDistance().intValue());
				awayStoreBO.setGroupDiscount(storeBO.getGroupDiscount());
				GroupGoodsBO goods = groupGoodsService.queryAwayStoreInfo(awayStoreBO.getId());
				if (goods != null) {
					awayStoreBO.setGoodsId(goods.getId());
					awayStoreBO.setGoodsName(goods.getGgName());
					awayStoreBO.setGoodsPath(goods.getGroupAccPath());
					awayStoreBO.setPrice(goods.getGroupPrice());
					awayStoreBO.setSales(goods.getSelledCount());
					awayStoreBO.setCostPrice(goods.getCostPrice());// 增加原价
				}
				list.add(awayStoreBO);
			}
			// 按照距离升序
			if (vo.getAreaId() == null && list != null && list.size() > 0) {
				Collections.sort(list, new Comparator<AwayStoreBO>() {
					public int compare(AwayStoreBO arg0, AwayStoreBO arg1) {
						return arg0.getDistance().compareTo(arg1.getDistance());
					}
				});
			}
			response.setAwayStoreList(list);
		}
		return response;
	}

	@RequestMapping(value = "/personal/youlike_store/list", method = RequestMethod.POST)
	@MethodMapping(desc = "猜你喜欢")
	public @ResponseBody
	PersonalIndexResponse youLike(@Valid @ModelAttribute @Param YouLikeGoodsVO vo, BindingResult result,
			HttpServletRequest request) {
		PersonalIndexResponse response = new PersonalIndexResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		List<GroupGoodsBO> your_like_goods = new ArrayList<GroupGoodsBO>();

		List<GroupGoodsBO> list = new ArrayList<GroupGoodsBO>();
		String[] goodsIds = null;
		if (StringUtils.isNotBlank(vo.getgId())) {
			goodsIds = vo.getgId().split(",");
		}
		Set<Long> setIds = new HashSet<Long>();
		if (goodsIds != null) {
			for (String id : goodsIds) {
				GroupGoodsBO goods = groupGoodsService.queryGroupGoodsById(CommUtil.null2Long(id));
				setIds.add(goods.getId());
				list.add(goods);
			}
		}
		your_like_goods.addAll(list);
		if (list.size() > 4) {
		} else {
			List<GroupGoodsBO> like_goods = this.groupGoodsService.selectGoodsYourLike(null, 0,
					6 - list.size(), setIds, vo.getAreaId());
			if (like_goods.size() > 0) {
				your_like_goods.addAll(like_goods);
			}
		}
		if (your_like_goods.size() == 0) {
			your_like_goods = this.groupGoodsService.selectGoodsYourLike(null, 0, -1, null, vo.getAreaId());
		}
		// 设置距离
		MyDistanceUtil.setDistance(your_like_goods, vo.getStoreLon(), vo.getStoreLat());

		List<OGroupGoodsBO> oBos = MapperUtils.map(mapper, your_like_goods, OGroupGoodsBO.class);

		// 按照距离升序
		Collections.sort(oBos, new Comparator<OGroupGoodsBO>() {
			public int compare(OGroupGoodsBO arg0, OGroupGoodsBO arg1) {
				return arg0.getDistance().compareTo(arg1.getDistance());
			}
		});

		response.setYouLike(oBos);
		return response;
	}

	@RequestMapping(value = "/personal/fava_goods/list", method = RequestMethod.POST)
	@MethodMapping(desc = "收藏的服务列表")
	public @ResponseBody
	PersonalIndexResponse favaGroupGoodsList(@Valid @ModelAttribute @Param FavaGroupGoodsVO vo,
			BindingResult result, HttpServletRequest request) {
		PersonalIndexResponse response = new PersonalIndexResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<GroupGoodsBO> page = new MyPage<GroupGoodsBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		Long uid = ActionsUtil.getOwnerUid();

		groupGoodsService.queryGroupGoodsFavaList(uid, page);
		if (page != null && page.getContent().size() > 0) {
			List<FavaGroupGoodsBO> favaList = MapperUtils.map(mapper, page.getContent(),
					FavaGroupGoodsBO.class);
			response.setFavaList(favaList);
		}
		return response;
	}

	@RequestMapping(value = "/personal/cancel", method = RequestMethod.POST)
	@MethodMapping(desc = "取消收藏|商户|商城|服务")
	public @ResponseBody
	PersonalIndexResponse cancelFava(@Valid @ModelAttribute @Param FavaCancelVO vo, BindingResult result,
			HttpServletRequest request) {
		PersonalIndexResponse response = new PersonalIndexResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		UserCustomerFavorites favorites = customerService.findFavoritesByFid(uid,
				CommUtil.null2String(vo.getFid()), CommUtil.null2String(vo.getType()));
		if (favorites != null) {
			try {
				customerService.cancleGoodsOrStoreFavoritesById(favorites.getId());
			} catch (ServiceException e) {
				response.putErrorMessage("4.personal.cancelFava.fava_fail");
				return response;
			}
			return response;
		}
		response.putErrorMessage("4.personal.cancelFava.cancel_fail");
		return response;
	}

	@RequestMapping(value = "/personal/hot/search", method = RequestMethod.POST)
	@MethodMapping(desc = "服务热门搜索")
	public @ResponseBody
	PersonalIndexResponse o2oHotSearch() {
		PersonalIndexResponse response = new PersonalIndexResponse();
		SysConfigBO str = configService.getSysConfig();
		String[] hotSearch = null;
		if (StringUtils.isNotBlank(str.getO2oHotSearch())) {
			hotSearch = str.getO2oHotSearch().split(",");
		}
		response.setHotSearch(hotSearch);
		return response;
	}

	@RequestMapping(value = "/personal/hot_city/list", method = RequestMethod.POST)
	@MethodMapping(desc = "热门城市")
	public @ResponseBody
	HotCityResponse HotCity() {
		HotCityResponse response = new HotCityResponse();
		List<Area> areas = areaServiceImpl.findGroupHotCity();
		List<GroupAreaBO> hotCity = MapperUtils.map(mapper, areas, GroupAreaBO.class);
		response.setHotCity(hotCity);
		return response;
	}

	/*@Autowired
	private UserMoneyService userMoneyService;
	@RequestMapping(value = "/personal/usermoneylog/list", method = RequestMethod.GET)
	@MethodMapping(desc = "预分润明细")
	public @ResponseBody HotCityResponse usermoneylog(Long uid, int num , int size) {
		HotCityResponse response = new HotCityResponse();
		MyPage<UserMoneyLogBO> page = new MyPage<UserMoneyLogBO>();
		page.setPageNumber(num);
		page.setPageSize(size);
		userMoneyService.getUserMoneylogByUid(uid, page);
		List<Area> areas = areaServiceImpl.findGroupHotCity();
		List<GroupAreaBO> hotCity = MapperUtils.map(mapper, areas, GroupAreaBO.class);
		response.setHotCity(hotCity);
		return response;
	}*/

}
