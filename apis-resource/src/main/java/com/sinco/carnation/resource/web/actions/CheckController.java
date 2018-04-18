package com.sinco.carnation.resource.web.actions;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.lucene.GoodsDocument;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.check.service.CheckGroupResultService;
import com.sinco.carnation.check.service.CheckGroupService;
import com.sinco.carnation.check.service.CheckResultHistoryService;
import com.sinco.carnation.resource.bo.o2o.RecommendStoreBO;
import com.sinco.carnation.resource.bo.shop.RecommendGoodsBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.RecommenGoodAndStoreVO;
import com.sinco.carnation.resource.vo.favorites.CheckGroupVO;
import com.sinco.carnation.resource.vo.favorites.CheckResultVO;
import com.sinco.carnation.resource.web.response.favorites.CheckGroupResponse;
import com.sinco.carnation.resource.web.response.favorites.CheckResultHistoryResponse;
import com.sinco.carnation.resource.web.response.favorites.CheckResultResponse;
import com.sinco.carnation.sns.bo.CheckGroupBO;
import com.sinco.carnation.sns.bo.CheckGroupResultBO;
import com.sinco.carnation.sns.model.CheckGroup;
import com.sinco.carnation.store.search.StoreDocument;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.model.IntegralReg;
import com.sinco.carnation.sys.service.IntegralRegService;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.user.bo.CheckResultHistoryBO;
import com.sinco.carnation.user.bo.IntegralLogBO;
import com.sinco.carnation.user.service.IntegralLogService;
import com.sinco.dal.common.MyPage;
import com.sinco.data.core.Page;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "自测题", namespace = "check")
public class CheckController extends BasicApiController {

	@Autowired
	private CheckGroupService checkGroupService;

	@Autowired
	private CheckGroupResultService checkGroupResultService;

	@Autowired
	private CheckResultHistoryService checkResultHistoryService;

	@Autowired
	private IntegralService integralService;

	@Autowired
	private IntegralRegService integralRegService;
	@Autowired
	private StoreSearchService storeSearchervice;

	@Autowired
	private IntegralLogService integralLogService;

	@Autowired
	private Mapper mapper;

	Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 自测历史
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/users/check/history", method = RequestMethod.POST)
	@MethodMapping(desc = "自测历史")
	public @ResponseBody
	CheckResultHistoryResponse usersCheckHistory(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			BindingResult result, HttpServletRequest request) {

		CheckResultHistoryResponse response = new CheckResultHistoryResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<CheckResultHistoryBO> page = new MyPage<CheckResultHistoryBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		checkResultHistoryService.findPageByUserId(ActionsUtil.getOwnerUid(), page);

		List<com.sinco.carnation.resource.bo.CheckResultHistoryBO> checkResultHistoryList = MapperUtils.map(
				mapper, page.getContent(), com.sinco.carnation.resource.bo.CheckResultHistoryBO.class);
		if (checkResultHistoryList != null && checkResultHistoryList.size() > 0) {
			for (int i = 0; i < checkResultHistoryList.size(); i++) {
				checkResultHistoryList.get(i).setDesc(
						Jsoup.parse(checkResultHistoryList.get(i).getResultDesc()).text());
				CheckGroup group = checkGroupService.selectByPrimaryKey(checkResultHistoryList.get(i)
						.getGroupId());
				if (group != null) {
					checkResultHistoryList.get(i).setImgUrl(group.getThumbnail());
				}
			}
		}
		response.setCheckResults(checkResultHistoryList);
		response.setTotalCount(page.getTotalElements());
		return response;
	}

	/**
	 * 自测题列表
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sns/check/list", method = RequestMethod.POST)
	@MethodMapping(desc = "自测题列表")
	public @ResponseBody
	CheckGroupResponse snsCheckList(@Valid @ModelAttribute @Param CheckGroupVO vo, BindingResult result,
			HttpServletRequest request) {

		CheckGroupResponse response = new CheckGroupResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<CheckGroupBO> page = new MyPage<CheckGroupBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		vo.setIsClosed((byte) 0);// 查询没关闭的自测题

		checkGroupService.findPageByVO(mapper.map(vo, com.sinco.carnation.sns.vo.CheckGroupVO.class), page);
		List<com.sinco.carnation.resource.bo.CheckGroupBO> checkGroupBOs = MapperUtils.map(mapper,
				page.getContent(), com.sinco.carnation.resource.bo.CheckGroupBO.class);
		response.setCheckGruops(checkGroupBOs);
		response.setTotalCount(page.getTotalElements());
		return response;
	}

	/**
	 * 自测题结果
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sns/check/result", method = RequestMethod.POST)
	@MethodMapping(desc = "自测测试完成后查看结果")
	public @ResponseBody
	CheckResultResponse snsCheckResult(@Valid @ModelAttribute @Param CheckResultVO vo, BindingResult result,
			HttpServletRequest request) {

		CheckResultResponse response = new CheckResultResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		int existResult = checkGroupResultService.findExistsRecordHistory(uid, vo.getGroupId());// 判断用户是否当天是否做过该自测题

		CheckGroupResultBO resultBO = checkGroupResultService.findGroupResult(vo.getGroupId(),
				vo.getResultScore(), ActionsUtil.getOwnerUid());

		if (resultBO == null) {
			response.putErrorMessage("4.sns.snsCheckResult.check_result_not_fund");
			return response;
		}

		// 针对自测题每人/每天/每套题/不能重复获取积分需求修改积分规则（只能每人每天第一次自测测试才有积分，当然内可重复做，但是不能获取积分）
		// 根据积分类型uid，IntegralConstants.INTEGRAL_SELF_TEST 和 当前日期 查看积分日志表是否存在自测题积分记录
		// int existResult = integralLogService.checkIntegralLog(regVo);

		int num = 0;
		boolean getDayIntegralFlag = false;
		if (existResult <= 0) {
			// 赠送积分
			num = integralService.addIntegral(IntegralConstants.INTEGRAL_HEALTH_ZICE, uid, null);
		} else {
			getDayIntegralFlag = true;
			// response.putErrorMessage("4.sns.snsCheckResult.check_result_integral_found");
			response.setSubMsg("你今天的该项任务已完成!");
		}
		response.setGetDayIntegralFlag(getDayIntegralFlag);// 用户当天是否已经获取自测题积分

		response.setCheckResult(resultBO.getResultDesc());
		response.setGroupId(resultBO.getGroupId());
		response.setResultId(resultBO.getId());
		response.setIntegral(num);

		return response;
	}

	@RequestMapping(value = "/sns/health_task/save", method = RequestMethod.POST)
	@MethodMapping(desc = "健康任务赠送积分")
	public @ResponseBody
	CheckResultResponse healthTask(
			@Valid @RequestParam(value = "integralType") @Param(desc = "积分类型|1健康任务2分享") Integer integralType,
			HttpServletRequest request) {
		CheckResultResponse response = new CheckResultResponse();
		if (integralType == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		String type = null;
		int num = 0;
		int second = 10;
		Date now = new Date();
		//10S内添加积分操作不算
		// 赠送积分
		if (integralType == 1) {
			type = IntegralConstants.INTEGRAL_HEALTH_RENWU;
			second = 1;
			// 分享
		} else if (integralType == 2) {
			type = IntegralConstants.INTEGRAL_SHARE;
			second = 3;
		}
		IntegralLogBO BO = integralService.getLastByUidType(uid, type);
		
		if(null != BO && null != BO.getAddtime()){
			Date addtime = BO.getAddtime();
			long interval = (now.getTime() - addtime.getTime()) / 1000;
			if(interval > second){
				num = integralService.addIntegral(type, uid, null);
			}
		}else{
			num = integralService.addIntegral(type, uid, null);
		}
		
		response.setIntegral(num);
		return response;
	}

	@RequestMapping(value = "/sns/integral/get", method = RequestMethod.POST)
	@MethodMapping(desc = "获取积分")
	public @ResponseBody
	CheckResultResponse getIntegral(
			@Valid @RequestParam(value = "type") @Param(desc = "类型|1注册") Integer type,
			HttpServletRequest request) {
		CheckResultResponse response = new CheckResultResponse();
		if (type == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		// 注册
		if (type == 1) {
			IntegralReg in = integralRegService.getObjByType(IntegralConstants.INTEGRAL_REGISTER);
			response.setIntegral(in.getIntegral());
		}
		return response;
	}

	@RequestMapping(value = "/sns/recommen_goods_and_store/list", method = RequestMethod.POST)
	@MethodMapping(desc = "自测推荐商品店铺列表")
	public @ResponseBody
	CheckResultResponse recommendGoodsAndStore(@Valid @ModelAttribute @Param RecommenGoodAndStoreVO vo,
			BindingResult result) {
		CheckResultResponse response = new CheckResultResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		CheckGroupResultBO resultBOs = checkGroupResultService.findById(vo.getGroupId());
		if (resultBOs != null && StringUtils.isNotBlank(resultBOs.getResultTarget())) {
			String[] targetArr = resultBOs.getResultTarget().split(",|，");
			// 商户
			Page<StoreDocument> page = new Page<StoreDocument>();
			page.setPageNumber(1);
			page.setPageSize(4);
			List<StoreDocument> searchStore = storeSearchervice.searchRecommedStore(targetArr,
					vo.getStoreLat(), vo.getStoreLon(), page);

			// 商品
			Page<GoodsDocument> goodPage = new Page<GoodsDocument>();
			goodPage.setPageNumber(1);
			goodPage.setPageSize(2);
			List<GoodsDocument> searchGoods = storeSearchervice.searchRecommedGoods(targetArr, goodPage);

			// 商品
			List<RecommendGoodsBO> goodsList = MapperUtils.map(mapper, searchGoods, RecommendGoodsBO.class);
			response.setRecommedGoodsList(goodsList);
			// 商户
			List<RecommendStoreBO> storeList = MapperUtils.map(mapper, searchStore, RecommendStoreBO.class);
			response.setRecommedStoreList(storeList);
		}

		return response;
	}

}
