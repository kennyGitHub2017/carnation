package com.sinco.carnation.resource.web.actions;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.service.JuanpiGoodsService;
import com.sinco.carnation.recommend.service.AdvertService;
import com.sinco.carnation.resource.bo.InformationBO;
import com.sinco.carnation.resource.bo.LookInvitationBO;
import com.sinco.carnation.resource.bo.PositionAdvertBO;
import com.sinco.carnation.resource.bo.personal.PGroupGoodsBO;
import com.sinco.carnation.resource.bo.personal.PStoreInfoBO;
import com.sinco.carnation.resource.bo.shop.ShopGoodsBo;
import com.sinco.carnation.resource.bo.shop.ShopStoreBO;
import com.sinco.carnation.resource.vo.favorites.RecommendVO;
import com.sinco.carnation.resource.web.response.favorites.RecommendResponse;
import com.sinco.carnation.sns.bo.AdvertBO;
import com.sinco.carnation.sns.bo.AdvertExBO;
import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.store.tools.DistanceUtils;
import com.sinco.carnation.user.service.CircleInvitationService;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "广告推荐相关", namespace = "recommend")
public class RecommendController extends BasicApiController {

	@Autowired
	private Mapper mapper;

	@Autowired
	private AdvertService advertService;

	@Autowired
	private CircleInvitationService circleService;

	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private JuanpiGoodsService juanpiGoodsService;

	/**
	 * 广告推荐查询
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sns/recommend/list", method = RequestMethod.POST)
	@MethodMapping(desc = "广告推荐查询")
	public @ResponseBody
	RecommendResponse snsRecommendList(@Valid @ModelAttribute @Param RecommendVO vo, BindingResult result,
			HttpServletRequest request) {

		RecommendResponse response = new RecommendResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		List<AdvertBO> listResult = advertService.findAdByCode(vo.getPosCode(), vo.getTimeStamp(),
				vo.getCityId());

		if (null != listResult && listResult.size() > 0) {
			List<PositionAdvertBO> list = MapperUtils.map(mapper, listResult, PositionAdvertBO.class);
			for (PositionAdvertBO obj : list) {
				obj.setBv(BigDecimal.ZERO);
			}
			if (vo.getPosCode().equalsIgnoreCase("INDEX_POPULAR_RECOMMEND")) {
				// 如果是此类型的code，根据itemId查找商品信息
				for (PositionAdvertBO bo : list) {
					
					if (bo.getItemId().contains("jp_")) {//卷皮商品
						String[] thisId = bo.getItemId().split("_");
						JuanpiGoodsBO juanpiGoodsBO = this.juanpiGoodsService.findOne(CommUtil.null2Long(thisId[1]));
						bo.setGoodsName(juanpiGoodsBO.getGoodsTitle());
						bo.setHasMobilePrice(false);
						bo.setGoodsCurrentPrice(juanpiGoodsBO.getGoodsCprice());
						bo.setVo_is_juanpi(1);
						bo.setVo_is_tuangou(juanpiGoodsBO.getIsTuangou());
						bo.setVo_target_url_m(juanpiGoodsBO.getTargetUrlM());
						bo.setVo_tuangou_price(juanpiGoodsBO.getTuanCprice());
						bo.setItemId(thisId[1]);
						
					} else {
						
					GoodsBO goods = goodsService.getGoodsBOById(CommUtil.null2Long(bo.getItemId()));// 此时itemId是商品id
					// 上架商品
					if (goods != null && goods.getGoodsStatus() == 0) {
						bo.setGoodsName(goods.getGoodsName());
						BigDecimal goodsMobilePrice = goods.getGoodsMobilePrice();
						BigDecimal zeroPrice = BigDecimal.valueOf(0.00);
						if (goods.getGoodsMobilePrice() != null
								&& !(goodsMobilePrice.compareTo(zeroPrice) == 0)) {
							bo.setHasMobilePrice(true);
						} else {
							bo.setHasMobilePrice(false);
						}
						bo.setGoodsMobilePrice(goods.getGoodsShowPrice());
						bo.setGoodsCurrentPrice(goods.getGoodsShowPrice());// list.add(goods);考虑手机专享价
					}
					if (goods != null) {
						boolean isCNProduct = goods.getExPriceFlag() != null && goods.getExPriceFlag() == 1 ? Boolean.TRUE
								: Boolean.FALSE;
						BigDecimal cnselfAddPrice = goods.getCnSelfAddPrice() != null ? goods
								.getCnSelfAddPrice() : BigDecimal.ZERO;
						int r = cnselfAddPrice.compareTo(BigDecimal.ZERO);
						BigDecimal BV = BigDecimal.ZERO;
						if (r == 1 && isCNProduct) // >0 && CN加价商品
						{
							BV = cnselfAddPrice;
						}
						bo.setBv(BV);
					}
					
					}
					
				}
				
			}
			if (vo.getPosCode().equalsIgnoreCase("APP_SHOP_INDEX")) {//健康商城 首页banner图
				for (PositionAdvertBO bo : list) {
					if (bo.getAdType().equals("8") && bo.getItemId().contains("jp_")) {//卷皮商品
						String[] thisId = bo.getItemId().split("_");
						JuanpiGoodsBO juanpiGoodsBO = this.juanpiGoodsService.findOne(CommUtil.null2Long(thisId[1]));
						if (juanpiGoodsBO != null) {
							bo.setVo_is_juanpi(1);
							bo.setVo_target_url_m(juanpiGoodsBO.getTargetUrlM());
							bo.setItemId(thisId[1]);
						}
					}
				}
			}
			response.setAdvList(list);

		}
		return response;
	}

	/**
	 * 广告推荐查询（new）
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sns/crc/list", method = RequestMethod.POST)
	@MethodMapping(desc = "广告推荐查询")
	public @ResponseBody
	RecommendResponse commonRecommendList(@Valid @ModelAttribute @Param RecommendVO vo, BindingResult result,
			HttpServletRequest request) {
		RecommendResponse response = new RecommendResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		List<AdvertExBO> listResult = advertService.findAdByCRC(vo.getPosCode(), vo.getTimeStamp(),
				vo.getCityId());
		List<PositionAdvertBO> list = new ArrayList<PositionAdvertBO>();
		if (null != listResult && listResult.size() > 0) {
			for (AdvertExBO bo : listResult) {
				PositionAdvertBO pbo = new PositionAdvertBO();
				String adType = bo.getAdType();
				pbo.setAdTitle(bo.getAdTitle());
				pbo.setAdText(bo.getAdText());
				pbo.setAdImgPath(bo.getAdImgPath());
				pbo.setAdType(bo.getAdType());
				pbo.setAdUrl(bo.getAdUrl());
				if (AdvertContant.ADVERT_TPYE_INFOMATION.equals(adType)) {
					LookInvitationBO bb = new LookInvitationBO();
					bb.setId(bo.getCircleInvitationBO().getId());
					bb.setTitle(bo.getCircleInvitationBO().getTitle());
					pbo.setLookInvitationBO(bb);
				} else if (AdvertContant.ADVERT_TPYE_GOODS.equals(adType) && bo.getGoodsBO() != null
						&& bo.getGoodsBO().getId() != null) {
					ShopGoodsBo bb = new ShopGoodsBo();
					bb.setId(bo.getGoodsBO().getId());
					bb.setGoodsName(bo.getGoodsBO().getGoodsName());
					bb.setHasMobilePrice(bo.getGoodsBO().getHasMobilePrice());
					bb.setMobilePrice(bo.getGoodsBO().getGoodsMobilePrice());
					bb.setGoodsCurrentPrice(bo.getGoodsBO().getGoodsCurrentPrice());
					bb.setGoodsShowPrice(bo.getGoodsBO().getGoodsShowPrice());
					pbo.setShopGoodsBo(bb);
				} else if (AdvertContant.ADVERT_TPYE_MERCHANT.equals(adType)) {
					ShopStoreBO bb = new ShopStoreBO();
					bb.setId(bo.getStoreBO().getId());
					bb.setStoreName(bo.getStoreBO().getStoreName());
					pbo.setShopStoreBO(bb);
				} else if (AdvertContant.ADVERT_TPYE_JG_PROJECT.equals(adType)) {
					InformationBO bb = new InformationBO();
					bb.setId(bo.getInformationBO().getId());
					bb.setTitle(bo.getInformationBO().getTitle());
					pbo.setInformationBO(bb);
				} else if (AdvertContant.ADVERT_TPYE_GROUP_MERCHANT.equals(adType)) {
					PStoreInfoBO bb = new PStoreInfoBO();
					bb.setId(bo.getStoreBO().getId());
					bb.setStoreName(bo.getStoreBO().getStoreName());
					bb.setStoreAddress(bo.getStoreBO().getStoreAddress());
					// 设置商户评分
					bb.setStoreEvaluationAverage(bo.getStoreBO().getEvaluationAverage());
					// 设置商户位置
					bb.setDistance(this.distance(bo.getStoreBO().getStoreLat(),
							bo.getStoreBO().getStoreLon(), vo));
					pbo.setpStoreInfoBO(bb);
				} else if (AdvertContant.ADVERT_TPYE_SERVE.equals(adType)) {
					PGroupGoodsBO bb = new PGroupGoodsBO();
					bb.setId(bo.getGroupGoodsBO().getId());
					bb.setGgName(bo.getGroupGoodsBO().getGgName());
					bb.setGroupPrice(bo.getGroupGoodsBO().getGroupPrice());
					bb.setStoreName(bo.getGroupGoodsBO().getStoreName());
					bb.setStoreAddress(bo.getGroupGoodsBO().getStoreAddress());
					// 设置商户评分
					bb.setEvaluationAverage(bo.getGroupGoodsBO().getStoreEvaluationAverage());
					// 设置商户位置
					bb.setDistance(this.distance(bo.getGroupGoodsBO().getStoreLat(), bo.getGroupGoodsBO()
							.getStoreLon(), vo));
					pbo.setpGroupGoodsBO(bb);
				}
				list.add(pbo);
			}

			response.setAdvList(list);
		}
		return response;
	}

	/**
	 * 根据经纬度计算距离
	 * 
	 * @param bo
	 * @param vo
	 * @return
	 */
	private Double distance(BigDecimal lat, BigDecimal lon, RecommendVO vo) {
		Double distance = null;
		// 设置距离
		if (lat != null && lon != null && vo.getLat() != null && vo.getLon() != null) {
			distance = DistanceUtils.GetDistance(CommUtil.null2Double(lon), CommUtil.null2Double(lat),
					vo.getLon(), vo.getLat());
		} else {
			distance = 0.00;
		}

		return distance;
	}

}
