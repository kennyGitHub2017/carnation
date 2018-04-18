package com.sinco.carnation.resource.web.actions;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.market.bo.ActivityHotSaleGoodsInfoBO;
import com.sinco.carnation.market.bo.ActivitySaleMessageBO;
import com.sinco.carnation.market.service.SaleActivityMessageService;
import com.sinco.carnation.market.service.SaleActivityService;
import com.sinco.carnation.resource.bo.market.ActivityHotSaleApiBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.market.ActHotSaleGoodsInfoVO;
import com.sinco.carnation.resource.web.response.market.ActHotSaleGoodsInfoResponse;
import com.sinco.carnation.resource.web.response.market.SaleActivityMainResponse;
import com.sinco.carnation.sys.contants.ActAppHotSaleContant;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "活动促销广告", namespace = "salePromotion")
public class ActivityHotSaleController extends BasicApiController {

	@Autowired
	private SaleActivityService saleActivityService;
	@Autowired
	private SaleActivityMessageService saleActivityMessageService;

	@Autowired
	private Mapper mapper;

	/**
	 * 首页活动
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/salePromotion/activityAd/mainInfo", method = RequestMethod.GET)
	@MethodMapping(desc = "app首页促销活动信息")
	public @ResponseBody SaleActivityMainResponse activityMainInfo(HttpServletRequest request) {
		SaleActivityMainResponse response = new SaleActivityMainResponse();
		Calendar now = Calendar.getInstance();
		int min = now.get(Calendar.HOUR_OF_DAY) * 60 + now.get(Calendar.MINUTE);
		ActivityHotSaleBO activityHotSaleBO = saleActivityService
				.findNewAppHotSaleInfo(ActAppHotSaleContant.act_vecode_6, now.getTime(), min);
		if (activityHotSaleBO != null) {
			ActivityHotSaleApiBO apiBo = mapper.map(activityHotSaleBO, ActivityHotSaleApiBO.class);
			//APP H5页面需要显示此标题
			ActivitySaleMessageBO saleMessageBO = saleActivityMessageService
					.getSaleMessageByActId(activityHotSaleBO.getId());
			if (saleMessageBO != null && saleMessageBO.getTitle() != null) {
				apiBo.setHotName(saleMessageBO.getTitle());
			}
			response.setActivityHotSaleApiBO(apiBo);
		}
		return response;
	}

	/*
	 * @RequestMapping(value = "/salePromotion/activityAd/mainInfo", method =
	 * RequestMethod.GET)
	 * 
	 * @MethodMapping(desc = "app首页促销活动信息") public @ResponseBody
	 * SaleActivityMainResponse activityMainInfo( HttpServletRequest request) {
	 * SaleActivityMainResponse response = new SaleActivityMainResponse();
	 * 
	 * //String code = "APP_HOT_SALE";//暂时hardcode处理一下
	 * 
	 * ActivityHotSaleBO activityHotSaleBO = saleActivityService.findTop();
	 * 
	 * ActivityHotSaleApiBO apiBo = null; if(activityHotSaleBO != null){ apiBo =
	 * mapper.map(activityHotSaleBO, ActivityHotSaleApiBO.class); } else{ //
	 * android 代码未判断为空的情况，目前接口调整下
	 * response.putErrorMessage(MsgCodeConstant.ERROR_PARAM); return response; }
	 * 
	 * response.setActivityHotSaleApiBO(apiBo);
	 * 
	 * return response;
	 * 
	 * }
	 */

	@RequestMapping(value = "/salePromotion/activityAd/goodsInfoList", method = RequestMethod.POST)
	@MethodMapping(desc = "app首页促销活动商品详细信息")
	public @ResponseBody ActHotSaleGoodsInfoResponse getAppHotSaleGoodsInfo(
			@Valid @ModelAttribute @Param ActHotSaleGoodsInfoVO vo, BindingResult result, HttpServletRequest request) {
		ActHotSaleGoodsInfoResponse response = new ActHotSaleGoodsInfoResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		String vcode = "APP_HOT_SALE";

		MyPage<ActivityHotSaleGoodsInfoBO> page = new MyPage<ActivityHotSaleGoodsInfoBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		saleActivityService.findActHotSaleGoodsListByPage(vo.getActHotSaleId(), vcode, page);

		List<com.sinco.carnation.resource.bo.market.ActHotSaleGoodsInfoApiBO> goodsList = MapperUtils.map(mapper,
				page.getContent(), com.sinco.carnation.resource.bo.market.ActHotSaleGoodsInfoApiBO.class);

		response.setGoodsList(goodsList);

		return response;
	}

	@RequestMapping(value = "/salePromotion/ad/info", method = RequestMethod.POST)
	@MethodMapping(desc = "app首页促销活动信息")
	public @ResponseBody SaleActivityMainResponse getBannerActInfo(
			@Valid @RequestParam(value = "actCode") @Param(desc = "活动代码") String actCode, HttpServletRequest request) {
		SaleActivityMainResponse response = new SaleActivityMainResponse();

		if (actCode == null) {// 2016-02-15，调整接口（针对ios弹窗没做隐藏处理）。
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		ActivityHotSaleBO activityHotSaleBO = saleActivityService.findTopByCode(actCode);

		ActivityHotSaleApiBO apiBo = null;
		if (activityHotSaleBO != null) {
			apiBo = mapper.map(activityHotSaleBO, ActivityHotSaleApiBO.class);
		} else {
			// android 代码未判断为空的情况，目前接口调整下
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		response.setActivityHotSaleApiBO(apiBo);

		return response;

	}

	/*
	 * @RequestMapping(value = "/salePromotion/ad/actInfo", method =
	 * RequestMethod.GET)
	 * 
	 * @MethodMapping(desc = "app首页弹出框信息") public @ResponseBody
	 * SaleActivityMainResponse popWindowInfo(@Valid @RequestParam(value =
	 * "actCode") @Param(desc = "活动代码") String actCode, HttpServletRequest
	 * request) { SaleActivityMainResponse response = new
	 * SaleActivityMainResponse();
	 * 
	 * if (actCode == null ) {
	 * response.putErrorMessage(MsgCodeConstant.ERROR_PARAM); return response; }
	 * 
	 * 
	 * ActivityHotSaleBO activityHotSaleBO =
	 * saleActivityService.queryInfoByCode(actCode);
	 * 
	 * ActivityHotSaleApiBO apiBo = null; if(activityHotSaleBO != null){ apiBo =
	 * mapper.map(activityHotSaleBO, ActivityHotSaleApiBO.class); } else{ //
	 * android 代码未判断为空的情况，目前接口调整下
	 * response.putErrorMessage(MsgCodeConstant.ERROR_PARAM); return response; }
	 * 
	 * response.setActivityHotSaleApiBO(apiBo);
	 * 
	 * return response;
	 * 
	 * }
	 */

}
