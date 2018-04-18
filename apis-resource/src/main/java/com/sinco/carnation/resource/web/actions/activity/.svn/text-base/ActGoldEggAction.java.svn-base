package com.sinco.carnation.resource.web.actions.activity;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.util.ActionsUtil;
import com.sinco.carnation.goldEgg.bo.ActGlodEggBO;
import com.sinco.carnation.goldEgg.bo.GlodEggItemBO;
import com.sinco.carnation.goldEgg.bo.GlodEggRecordBO;
import com.sinco.carnation.goldEgg.service.ActGlodEggService;
import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.activity.ActGoldEggResponse;

/**
 * 砸金蛋活动控制器
 * 
 * @author tw
 * 
 */
@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "砸金蛋活动", namespace = "activity")
public class ActGoldEggAction {
	@Autowired
	private ActGlodEggService actGlodEggService;

	/**
	 * 获取已砸金蛋
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/activity/gold_egg/record", method = RequestMethod.GET)
	@MethodMapping(desc = "获取已砸金蛋")
	@ResponseBody
	public ActGoldEggResponse record(HttpServletRequest request) {
		Long uid = ActionsUtil.getOwnerUid();
		ActGoldEggResponse result = new ActGoldEggResponse();
		List<GlodEggRecordBO> records = actGlodEggService.getGlodEggRecord(uid);
		result.setIndexOneUsed(false);
		result.setIndexTwoUsed(false);
		result.setIndexThreeUsed(false);
		result.setHasEgg(0);
		if (records != null && records.size() > 0) {
			for (GlodEggRecordBO record : records) {
				switch (record.getEggIndex()) {
					case 0:
						result.setIndexOneUsed(true);
						break;
					case 1:
						result.setIndexTwoUsed(true);
					case 2:
						result.setIndexThreeUsed(true);
					default:
						break;
				}
			}
		}
		// 取出当前活动
		ActGlodEggBO actGlodEggBo = actGlodEggService.getActGlodEgg();
		if (actGlodEggBo != null && actGlodEggBo.getActivityHotSale() != null) {
			ActivityHotSaleBO activityHotSaleBO = actGlodEggBo.getActivityHotSale();
			// 判断当前用户是否有砸金蛋的条件
			result.setHasEgg(actGlodEggService.allowGetGlodEggCount(uid, activityHotSaleBO.getStartTime()));
		}
		return result;
	}

	/**
	 * 砸金蛋
	 * 
	 * @param index
	 *            指定砸哪一个0-2，共三个金蛋
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/activity/gold_egg/act", method = RequestMethod.POST)
	@MethodMapping(desc = "开始砸金蛋")
	@ResponseBody
	public ActGoldEggResponse act(int index, HttpServletRequest request) {
		ActGoldEggResponse result = new ActGoldEggResponse();
		// 验证参数有效性
		if (index < 0 || index > 2) {
			result.putErrorMessage("参数index错误, 允许范围0-2");
			return result;
		}
		// 取出当前活动
		ActGlodEggBO actGlodEggBo = actGlodEggService.getActGlodEgg();
		// 验证活动的有效性
		if (actGlodEggBo == null || actGlodEggBo.getActivityHotSale() == null) {
			result.putErrorMessage("活动不存在");
			return result;
		}
		ActivityHotSaleBO activityHotSaleBO = actGlodEggBo.getActivityHotSale();
		if (activityHotSaleBO.getDeleteStatus() != 0 || activityHotSaleBO.getIsEnabled() != 0) {
			result.putErrorMessage("活动无效");
			return result;
		}
		Date now = new Date();
		if (activityHotSaleBO.getStartTime() != null
				&& activityHotSaleBO.getStartTime().getTime() > now.getTime()) {
			result.putErrorMessage("活动还没有开始");
			return result;
		}
		if (activityHotSaleBO.getEndTime() != null
				&& activityHotSaleBO.getEndTime().getTime() < now.getTime()) {
			result.putErrorMessage("活动已经结束");
			return result;
		}
		// 开始砸蛋
		Long userId = ActionsUtil.getOwnerUid();
		// 判断当前用户是否有砸金蛋的条件
		if (!actGlodEggService.isAllowGetGlodEgg(userId, index, activityHotSaleBO.getStartTime())) {
			result.putErrorMessage("想要继续拆蛋，快请您的好友帮帮忙！");
			return result;
		}
		// 计算中奖率，发放奖品
		GlodEggItemBO item = actGlodEggService.calGlodEggItem(actGlodEggBo, userId, index);
		if (item == null) {
			result.putErrorMessage("很遗憾，请继续努力");
			return result;
		}
		// 返回中奖金额
		result.setIndex(index);
		result.setMoney(item.getTotalMoney());
		return result;
	}

}
