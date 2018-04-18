package com.sinco.carnation.resource.web.actions.physical;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.resource.bo.personal.AwayStoreBO;
import com.sinco.carnation.resource.vo.physical.PhysicalVO;
import com.sinco.carnation.sns.model.CircleInvitation;
import com.sinco.carnation.store.search.StoreDocument;
import com.sinco.carnation.store.search.StoreSearchResult;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.vo.StoreSearchVO;
import com.sinco.carnation.sys.bo.SysReminderTaskBO;
import com.sinco.carnation.sys.enums.EmSysKeyWordMapType;
import com.sinco.carnation.sys.vo.SysReminderTaskVO;
import com.sinco.carnation.sys.vo.SysTaskLogVO;
import com.sinco.carnation.user.bo.PhysicalResultBO;
import com.sinco.carnation.user.bo.PhysicalSuggestBO;
import com.sinco.carnation.user.bo.PhysicalValuationBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.enums.EmPhysicalResultType;
import com.sinco.carnation.user.service.CircleInvitationService;
import com.sinco.carnation.user.service.PhysicalService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.vo.PhysicalSuggestVO;
import com.sinco.dal.common.MyPage;

@Controller
public class WebPhysicalController {

	@Autowired
	private CircleInvitationService circleService;

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

	@SuppressWarnings("unused")
	@RequestMapping(value = "/physical/resultDetail", method = RequestMethod.GET)
	public String physicalCheckResult(HttpServletRequest request, PhysicalVO vo, Model model) {

		// 所需要的参数用户id，分值，体检项目id
		Long uid = ActionsUtil.getOwnerUid();
		uid = 375l;
		UserCustomerBO userCustomerBO = customerService.findBOByUserId(uid);
		int sex = 0;
		if (userCustomerBO != null) {
			sex = userCustomerBO.getSex() != null ? userCustomerBO.getSex() : 1;
		}
		// 1.根据体检检测结果值查询检测结果（check_physical_result,check_physical_valuation）
		PhysicalValuationBO valuationBO = physicalService.queryPhysicalResultByCond(vo.getMinValue(),
				vo.getMaxValue(), vo.getMiddleValue(), vo.getType(), sex);
		model.addAttribute("valuationBO", valuationBO);

		// 保存用户体检结果数据
		Long valuationId = valuationBO != null && valuationBO.getId() != null && valuationBO.getId() > 0L ? valuationBO
				.getId() : 0L;
		// Long num = physicalService.savePhysicalInfo(vo.getMinValue(), vo.getMaxValue(),vo.getMiddleValue(),
		// vo.getType(),vo.getTime(), uid,vo.getTerminalType(),valuationId);

		// 2.查询用户的七天体检测试记录（体检项目类型和uid）
		List<PhysicalResultBO> physicalHisList = physicalService.fullPhysicalResultList(uid, vo.getType()
				.toString(), 7);
		model.addAttribute("physicalHisList", physicalHisList);

		// 3.改善建议(体检类型id和枚举类结果id)
		PhysicalSuggestVO suggestVO = new PhysicalSuggestVO();
		Map<Integer, List<PhysicalSuggestBO>> suggestMap = null;
		if (valuationBO != null) {

			suggestVO.setIsEnabled(1);// 开启
			suggestVO.setDeleteStatus((byte) 0);// 正常数据
			suggestVO.setPhysicalTypeId(valuationBO.getPhysicalTypeId());// 体检项目类型
			suggestVO.setResultType(valuationBO.getResultType());// 体检结果值id
			suggestMap = physicalService.queryPhysicalSuggestByCond(suggestVO);
		}
		model.addAttribute("suggestMap", suggestMap);

		// 建议->关键字->任务信息
		// List<SysReminderTask> = physicalService.queryCircleBySuggest(suggestMap,
		// EmSysKeyWordMapType.SnsCircleType.getValue(),suggestTypeCode );

		// 4.精华推荐
		// physicalService.queryRecommendService(suggestMap,3);//根据体检建议

		long suggestTypeCode = EmSysKeyWordMapType.PhysicalSuugestType.getValue();
		if (EmSysKeyWordMapType.SnsCircleType.getValue() == 3) {// （帖子）
			List<CircleInvitation> circleList = physicalService.queryCircleBySuggest(suggestMap,
					EmSysKeyWordMapType.SnsCircleType.getValue(), suggestTypeCode);

			model.addAttribute("circleList", circleList);
		}/*else if(EmSysKeyWordMapType.GoodsType.getValue() == 4){//商品
			*/
		List<Goods> goodsList = physicalService.queryGoodsBySuggest(suggestMap,
				EmSysKeyWordMapType.GoodsType.getValue(), suggestTypeCode);

		model.addAttribute("goodsList", goodsList);
		if (EmSysKeyWordMapType.O2oServiceType.getValue() == 6) {// 服务
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
				List<GroupGoodsBO> groupGoodsList = physicalService.queryO2oGoodsBySuggest(suggestMap,
						EmSysKeyWordMapType.O2oServiceType.getValue(), suggestTypeCode);
				storeList = MapperUtils.map(mapper, storeResult.getPage().getContent(), AwayStoreBO.class);
				for (AwayStoreBO awayStoreBO : storeList) {
					for (GroupGoodsBO groupGoodsBO : groupGoodsList) {
						if (groupGoodsBO.getId() == awayStoreBO.getId()) {
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

				// 过滤掉没有goodsId（服务）的集合
				Iterator<AwayStoreBO> awayStoreIter = storeList.iterator();
				while (awayStoreIter.hasNext()) {
					AwayStoreBO awayStore = awayStoreIter.next();
					if (awayStore.getGoodsId() == null)
						awayStoreIter.remove();
				}

			}
			model.addAttribute("storeList", storeList);
		}

		model.addAttribute("physicalValue",
				vo.getMaxValue() != null && vo.getMaxValue() > 0F ? vo.getMaxValue() : 0);
		model.addAttribute("physicalMinValue",
				vo.getMinValue() != null && vo.getMinValue() > 0F ? vo.getMinValue() : 0);
		model.addAttribute("physicalType", vo.getType());

		// 5.任务提醒

		return "physical/physicalCheck_result.htm";
	}

	/**
	 * 根据taskId获取任务信息
	 * 
	 * @param request
	 * @param vo
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/physical/getTaskInfoById", method = RequestMethod.POST)
	@ResponseBody
	public String getPhysicalTaskInfoById(HttpServletRequest request, SysReminderTaskVO vo, Model model) {
		String resultMsg = "";
		// 保存用户任务数据
		Map<Integer, SysReminderTaskBO> map = Maps.newHashMap();
		try {
			SysReminderTaskBO sysTaskBO = physicalService.getPhysicalTaskInfoById(vo.getId());
			String taskData = JSON.toJSONString(sysTaskBO);
			return taskData;
		} catch (Exception e) {
			e.printStackTrace();
			map.put(0, null);// 保存失败或者出现异常
			return "";
		}

	}

	/**
	 * 创建/修改用户任务
	 * 
	 * @param request
	 * @param vo
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/physical/saveTaskByUser", method = RequestMethod.POST)
	@ResponseBody
	public String physicalSaveTaskByUsert(HttpServletRequest request, SysTaskLogVO vo, Model model) {
		String resultMsg = "";
		Long uid = ActionsUtil.getOwnerUid();
		// 保存用户任务数据
		uid = 375L;// test
		vo.setUserId(uid);
		// vo.setRemindDay();
		// vo.setTaskId(taskId);//任务id
		try {
			vo.setRemindTime(CommUtil.formatDate(vo.getReminderTimeStr(), "yyyy-MM-dd HH:mm:ss"));
			physicalService.saveUserTaskData(vo);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";// 保存失败或者出现异常
		}

	}

	/**
	 * 逻辑删除用户任务数据
	 * 
	 * @param request
	 * @param vo
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/physical/deleteTaskByUser", method = RequestMethod.GET)
	@ResponseBody
	public String physicalDeleteByUsert(HttpServletRequest request, SysTaskLogVO vo, Model model) {
		String resultMsg = "", result = "";
		Long uid = ActionsUtil.getOwnerUid();
		vo.setUserId(uid);
		// 保存用户任务数据
		try {
			boolean flag = physicalService.updateTaskLogByIdForIsDel(vo);// sys_task_log:id
			result = true ? "1" : "0";
		} catch (Exception e) {
			e.printStackTrace();
			return result;// 保存失败或者出现异常
		}
		return result;

	}

	/*@RequestMapping(value = "/physical/resultDetail", method = RequestMethod.GET)
	public String physicalCheckResult(HttpServletRequest request, PhysicalVO vo, Model model) {*/
	@RequestMapping(value = "/physical/physicalHistorySix.htm", method = RequestMethod.GET)
	//
	public String queryPhsicalResultSevenTimes(HttpServletRequest request, Model model) {
		// 用户id
		Long uid = ActionsUtil.getOwnerUid();
		/** 测试 **/
		uid = 138L;
		/** end **/
		// 根据用户id查询各项体检最近7次记录
		List<PhysicalResultBO> list = physicalService.selectPhysicalResultByIdSix(uid);
		List<PhysicalResultBO> physicalBloodPressure = new ArrayList<PhysicalResultBO>();// 血压 6
		List<PhysicalResultBO> physicalHeartRate = new ArrayList<PhysicalResultBO>();// 心率 7
		List<PhysicalResultBO> physicalVision = new ArrayList<PhysicalResultBO>();// 视觉 2
		List<PhysicalResultBO> physicalHearing = new ArrayList<PhysicalResultBO>();// 听力 5
		List<PhysicalResultBO> physicalVitalCapacity = new ArrayList<PhysicalResultBO>();// 肺活量 8
		List<PhysicalResultBO> physicalBloodOxygen = new ArrayList<PhysicalResultBO>();// 血氧 9

		for (PhysicalResultBO physicalResultbo : list) {
			if (physicalResultbo.getItemCode().equals("6")) {
				physicalBloodPressure.add(physicalResultbo);
			} else if (physicalResultbo.getItemCode().equals("7")) {
				physicalHeartRate.add(physicalResultbo);
			} else if (physicalResultbo.getItemCode().equals("2")) {
				physicalVision.add(physicalResultbo);
			} else if (physicalResultbo.getItemCode().equals("5")) {
				physicalHearing.add(physicalResultbo);
			} else if (physicalResultbo.getItemCode().equals("8")) {
				physicalVitalCapacity.add(physicalResultbo);
			} else if (physicalResultbo.getItemCode().equals("9")) {
				physicalBloodOxygen.add(physicalResultbo);
			}
		}

		model.addAttribute("physicalBloodPressure", physicalBloodPressure);
		model.addAttribute("physicalHeartRate", physicalHeartRate);
		model.addAttribute("physicalVision", physicalVision);
		model.addAttribute("physicalHearing", physicalHearing);
		model.addAttribute("physicalVitalCapacity", physicalVitalCapacity);
		model.addAttribute("physicalBloodOxygen", physicalBloodOxygen);

		return "physical/physicalHistorySix.htm";
	}

	/**
	 * 查询某项体检数据历史记录
	 */
	@RequestMapping(value = "/physical/physicalHistory", method = RequestMethod.GET)
	//
	public String queryPhsicalResultByUidHistory(String itemCode, HttpServletRequest request, Model model) {
		if (StringUtils.isBlank(itemCode)) {
			// response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
		}
		Long uid = ActionsUtil.getOwnerUid();

		/** 测试 **/
		uid = 138L;
		/** end **/
		// 正常记录数
		Integer healthNo = 0;
		List<PhysicalResultBO> physicalall = physicalService.selectPhysicalResultList(uid, itemCode, null);
		for (PhysicalResultBO physicalResultBO : physicalall) {
			if (physicalResultBO.getValuationId() != null
					&& EmPhysicalResultType.getPhysicalResultStatusMap(physicalResultBO.getValuationId()
							.intValue())) {
				/** 测试 **/
				// if(EmPhysicalResultType.getPhysicalResultStatusMap(2)){
				/** end **/
				healthNo++;
			}
		}
		// 工具类
		CommUtil com = new CommUtil();
		model.addAttribute("CommUtil", com);
		model.addAttribute("unHealthNo", physicalall.size() - healthNo);
		model.addAttribute("physicalall", physicalall);
		model.addAttribute("physicalResult", EmPhysicalResultType.getPhysicalResultTypeMap());
		return "physical/physicalHistory.html";
	}
}
