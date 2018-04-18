package com.sinco.carnation.resource.web.actions;

import java.util.List;

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

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.resource.bo.PhysicalBO;
import com.sinco.carnation.resource.bo.PhysicalTypeApiBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.physical.PhysicalVO;
import com.sinco.carnation.resource.web.response.physical.PhysicalByCodeResponse;
import com.sinco.carnation.resource.web.response.physical.PhysicalResponse;
import com.sinco.carnation.resource.web.response.physical.PhysicalSevenTimesResponse;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.user.bo.PhysicalResultBO;
import com.sinco.carnation.user.bo.PhysicalTypeBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.model.PhysicalResult;
import com.sinco.carnation.user.service.PhysicalService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.utils.DateUtils;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "体检宝", namespace = "physical")
public class PhysicalController extends BasicApiController {

	@Autowired
	private PhysicalService physicalService;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private Mapper mapper;

	@Autowired
	private StoreSearchService searchService;

	@Autowired
	private GroupGoodsService groupGoodsService;

	@Autowired
	private IntegralService integralService;

	/**
	 * 保存
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/physical/save", method = RequestMethod.POST)
	@MethodMapping(desc = "保存体检数据")
	public @ResponseBody
	PhysicalResponse savePhysicalInfo(@Valid @ModelAttribute @Param PhysicalVO vo, BindingResult result,
			HttpServletRequest request) {
		PhysicalResponse response = new PhysicalResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		// uid = 375L;
		Long valuationId = 0l;
		Integer terminalType = vo.getTerminalType() != null && vo.getTerminalType() >= 0 ? vo
				.getTerminalType() : 0;
		Long num = physicalService.savePhysicalInfo(vo.getMinValue(), vo.getMaxValue(), vo.getMiddleValue(),
				vo.getType(), vo.getTime(), uid, terminalType, valuationId);
//		integralService.addIntegral(IntegralConstants.INTEGRAL_HEALTH_TIJIAN, uid, null);
		// 根据检测值查找结果说明
		UserCustomerBO userCustomerBO = customerService.findBOByUserId(uid);
		if (userCustomerBO != null) {
			String nowDateStr = DateUtils.getDate();

			if (userCustomerBO.getBirthdate() != null) /* add by yuleijia 2016.08.23 */
			{
				String birthDateStr = DateUtils.formatDate(userCustomerBO.getBirthdate(), "yyyy-MM-dd");
				int currentAge = Integer.parseInt(birthDateStr.split("-")[0])
						- Integer.parseInt(nowDateStr.split("-")[0]);
				// physicalService.queryPhysicalResultByCond(vo.getMinValue(),
				// vo.getMaxValue(),vo.getMiddleValue(), vo.getType(),
				// userCustomerBO.getSex().intValue(),currentAge );
			}
		}
		if (null != num) {
			return response;
		}
		response.putErrorMessage("4.physical.savePhysicalInfo.save_error");
		return response;
	}

	@RequestMapping(value = "/physical/query", method = RequestMethod.POST)
	@MethodMapping(desc = "查询某天某一项体检数据")
	public @ResponseBody
	PhysicalResponse queryPhsicalByUidAnDay(
			@Valid @RequestParam(value = "time") @Param(desc = "体检时间") String time,
			@Valid @RequestParam(value = "type") @Param(desc = "体检项目类型") Integer type,
			HttpServletRequest request) {
		PhysicalResponse response = new PhysicalResponse();
		if (StringUtils.isBlank(time)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		PhysicalResult physical = physicalService.queryPhysicalResult(uid, CommUtil.null2String(type), time);
		if (null != physical) {
			PhysicalBO result = new PhysicalBO();
			result.setCreateBy(physical.getCreateBy());
			result.setRangeMin(physical.getRangeMin());
			result.setRangeMax(physical.getRangeMax());
			result.setTime(CommUtil.formatShortDate(physical.getCreateTime()));
			result.setItemCode(physical.getItemCode());
			result.setMiddleValue(physical.getRangeMiddle());
			response.setPhysical(result);
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/physical/list/query", method = RequestMethod.POST)
	@MethodMapping(desc = "查询某天所有项体检数据")
	public @ResponseBody
	PhysicalResponse queryPhsicalByUidAnDayList(
			@Valid @RequestParam(value = "time") @Param(desc = "体检时间") String time, HttpServletRequest request) {
		PhysicalResponse response = new PhysicalResponse();
		if (StringUtils.isBlank(time)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		List<PhysicalResultBO> physical = physicalService.queryPhysicalResultList(uid, time);
		if (null != physical && physical.size() > 0) {
			List<PhysicalBO> physicalArr = MapperUtils.map(mapper, physical, PhysicalBO.class);
			response.setPhysicalArr(physicalArr);
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/physical/list/select/seven", method = RequestMethod.POST)
	//
	@MethodMapping(desc = "查询所有项体检最近七次数据")
	public @ResponseBody
	PhysicalSevenTimesResponse queryPhsicalSevenTimesList(HttpServletRequest request) {
		PhysicalSevenTimesResponse response = new PhysicalSevenTimesResponse();
		Long uid = ActionsUtil.getOwnerUid();
		List<PhysicalResultBO> physicalBloodPressure = physicalService.selectPhysicalResultList(uid, "6", 7);
		List<PhysicalResultBO> physicalHeartRate = physicalService.selectPhysicalResultList(uid, "7", 7);
		List<PhysicalResultBO> physicalVision = physicalService.selectPhysicalResultList(uid, "2", 7);
		List<PhysicalResultBO> physicalHearing = physicalService.selectPhysicalResultList(uid, "5", 7);
		List<PhysicalResultBO> physicalVitalCapacity = physicalService.selectPhysicalResultList(uid, "8", 7);
		List<PhysicalResultBO> physicalBloodOxygen = physicalService.selectPhysicalResultList(uid, "9", 7);

		if (null != physicalBloodPressure && physicalBloodPressure.size() > 0) {
			List<PhysicalBO> bloodPressure = MapperUtils.map(mapper, physicalBloodPressure, PhysicalBO.class);
			response.setPhysicalBloodPressure(bloodPressure);
		}
		if (null != physicalHeartRate && physicalHeartRate.size() > 0) {
			List<PhysicalBO> heartRate = MapperUtils.map(mapper, physicalHeartRate, PhysicalBO.class);
			response.setPhysicalBloodPressure(heartRate);
		}
		if (null != physicalVision && physicalVision.size() > 0) {
			List<PhysicalBO> vision = MapperUtils.map(mapper, physicalVision, PhysicalBO.class);
			response.setPhysicalBloodPressure(vision);
		}
		if (null != physicalHearing && physicalHearing.size() > 0) {
			List<PhysicalBO> hearing = MapperUtils.map(mapper, physicalHearing, PhysicalBO.class);
			response.setPhysicalBloodPressure(hearing);
		}
		if (null != physicalVitalCapacity && physicalVitalCapacity.size() > 0) {
			List<PhysicalBO> vitalCapacity = MapperUtils.map(mapper, physicalVitalCapacity, PhysicalBO.class);
			response.setPhysicalBloodPressure(vitalCapacity);
		}
		if (null != physicalBloodOxygen && physicalBloodOxygen.size() > 0) {
			List<PhysicalBO> bloodOxygen = MapperUtils.map(mapper, physicalBloodOxygen, PhysicalBO.class);
			response.setPhysicalBloodPressure(bloodOxygen);
		}
		return response;
	}

	@RequestMapping(value = "/physical/list/select/code", method = RequestMethod.POST)
	//
	@MethodMapping(desc = "查询项体检数据")
	public @ResponseBody
	/*PhysicalResponse*/PhysicalByCodeResponse queryPhsicalByUidAndCodeList(
			@Valid @RequestParam(value = "itemCode") @Param(desc = "体检项目") String itemCode,
			HttpServletRequest request) {
		PhysicalByCodeResponse response = new PhysicalByCodeResponse();
		// String itemCode = "2";
		if (StringUtils.isBlank(itemCode)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		List<PhysicalResultBO> physicalseven = physicalService.selectPhysicalResultList(uid, itemCode, 7);
		List<PhysicalResultBO> physicalall = physicalService.selectPhysicalResultList(uid, itemCode, null);
		if (null != physicalseven && physicalseven.size() > 0) {
			List<PhysicalBO> physicalSeven = MapperUtils.map(mapper, physicalseven, PhysicalBO.class);
			response.setPhysicalSeven(physicalSeven);
			List<PhysicalBO> physicalArr = MapperUtils.map(mapper, physicalall, PhysicalBO.class);
			response.setPhysicalAll(physicalArr);
			response.setMsg("test");
			return response;
		}
		return response;

	}

	/**
	 * 体检项目详情介绍
	 */
	@RequestMapping(value = "/physical/description", method = RequestMethod.POST)
	@MethodMapping(desc = "体检项目详情介绍")
	public @ResponseBody
	PhysicalResponse queryPhsicalDescByType(
			@Valid @RequestParam(value = "phySicalTypeId") @Param(desc = "体检项目类型id") Long phySicalTypeId,
			HttpServletRequest request) {
		PhysicalResponse response = new PhysicalResponse();
		if (phySicalTypeId == 0) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		PhysicalTypeBO physicalTypeBO = physicalService.queryPhysicalTypeById(phySicalTypeId);
		if (null != physicalTypeBO) {
			PhysicalTypeApiBO apiBO = new PhysicalTypeApiBO();
			apiBO.setProfile(physicalTypeBO.getProfile());
			apiBO.setMemo(physicalTypeBO.getMemo());
			response.setPhysicalType(apiBO);
			return response;
		}
		return response;
	}

	/*@RequestMapping(value = "/physical/resultDetail", method = RequestMethod.GET)
	public String physicalCheckResult(HttpServletRequest request, PhysicalVO vo, Model model) {
		
		//所需要的参数用户id，分值，体检项目id
		Long uid = ActionsUtil.getOwnerUid();
		uid = 375l;
		UserCustomerBO userCustomerBO = customerService.findBOByUserId(uid);
		int sex = 0;
		if(userCustomerBO != null){
			 sex = userCustomerBO.getSex();
		}
		//1.根据体检检测结果值查询检测结果（check_physical_result,check_physical_valuation）
		PhysicalValuationBO valuationBO = physicalService.queryPhysicalResultByCond(vo.getMinValue(), vo.getMaxValue(), vo.getMiddleValue(), vo.getType(), sex);
		model.addAttribute("valuationBO", valuationBO);
		
		//2.查询用户的七天体检测试记录（体检项目类型和uid）
		List<PhysicalResultBO> physicalHisList = physicalService.selectPhysicalResultList(uid,vo.getType().toString(), 7);
		model.addAttribute("physicalHisList", physicalHisList);
		
		
		//3.改善建议(体检类型id和枚举类结果id)
		PhysicalSuggestVO suggestVO = new PhysicalSuggestVO();
		suggestVO.setIsEnabled(1);//开启
		suggestVO.setDeleteStatus((byte)0);//正常数据
		suggestVO.setPhysicalTypeId(valuationBO.getPhysicalTypeId());//体检项目类型
		suggestVO.setResultType(valuationBO.getResultType());//结果值id
		Map<Integer, List<PhysicalSuggestBO>> suggestMap = physicalService.queryPhysicalSuggestByCond(suggestVO);
		model.addAttribute("suggestMap", suggestMap);
		
		//4.精华推荐
		//首次默认是帖子
		//physicalService.queryRecommendService(suggestMap,3);//根据体检建议
		
		long suggestTypeCode = EmSysKeyWordMapType.PhysicalSuugestType.getValue();
		if(EmSysKeyWordMapType.SnsArticleType.getValue() == 3){//（帖子）
			List<Article> articleList =  physicalService.queryArticleBySuggest(suggestMap, EmSysKeyWordMapType.SnsArticleType.getValue(),suggestTypeCode );
			
			model.addAttribute("articleList", articleList);
		}else if(EmSysKeyWordMapType.GoodsType.getValue() == 4){//商品
			List<Goods> goodsList = physicalService.queryGoodsBySuggest(suggestMap, EmSysKeyWordMapType.GoodsType.getValue(), suggestTypeCode);
			
			model.addAttribute("goodsList", goodsList);
		}else if(EmSysKeyWordMapType.O2oServiceType.getValue() == 5){//服务
			MyPage<StoreDocument> page = new MyPage<StoreDocument>();
			page.setPageNumber(1);
			page.setPageSize(4);
			page.setOrderBy("DISTANCE");
			page.setOrder("asc");

			StoreSearchVO vo1 = new StoreSearchVO();
			// 默认深圳市
			if (vo != null) {
				vo1.setCityId(vo.getAreaId());
				if (vo.getStoreLat() != null || vo.getStoreLon() != null) {
					vo1.setStoreLat(vo.getStoreLat());// 经度
					vo1.setStoreLon(vo.getStoreLon());// 纬度
				}
			}
			// 查找有服务上架的
			vo1.setIsGoods(true);

			StoreSearchResult storeResult = searchService.search(vo1, page);
			List<AwayStoreBO> storeList = new ArrayList<AwayStoreBO>();
			if (storeResult.getPage() != null) {
				List<GroupGoodsBO> groupGoodsList = physicalService.queryO2oGoodsBySuggest(suggestMap, EmSysKeyWordMapType.O2oServiceType.getValue(), suggestTypeCode);
				storeList = MapperUtils.map(mapper, storeResult.getPage().getContent(), AwayStoreBO.class);
				for (AwayStoreBO awayStoreBO : storeList) {
					for(GroupGoodsBO groupGoodsBO : groupGoodsList){
						if(groupGoodsBO.getId() == awayStoreBO.getId()){
							GroupGoodsBO goods = groupGoodsService.queryAwayStoreInfo(awayStoreBO.getId());
							if (goods != null) {
								awayStoreBO.setGoodsId(goods.getId());
								awayStoreBO.setGoodsName(goods.getGgName());
								awayStoreBO.setGoodsPath(goods.getGroupAccPath());
								awayStoreBO.setPrice(goods.getGroupPrice());
								awayStoreBO.setSales(goods.getSelledCount());
							}
						}
							
						
					}
					
				}
				
				//过滤掉没有goodsId（服务）的集合
				Iterator<AwayStoreBO> awayStoreIter = storeList.iterator();
				while (awayStoreIter.hasNext()) {
					AwayStoreBO awayStore = awayStoreIter.next();
					if (awayStore.getGoodsId() == null)
						awayStoreIter.remove();
				}
				
				
			}
			model.addAttribute("storeList", storeList);
		}
		
		
		//5.任务提醒
		
		return "circle/circle_invitation.htm";
	}*/
}
