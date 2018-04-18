package com.sinco.carnation.resource.web.actions.integral;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.integral.IntegralFlipCardsResponse;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.UserCustomerService;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "积分活动", namespace = "integralActivity")
public class IntegralActivityController extends BasicApiController {
	private static final Logger logger = LoggerFactory.getLogger(IntegralService.class);
	@Autowired
	private IntegralService integralService;

	@Autowired
	private UserCustomerService userCustomerService;

	@RequestMapping(value = "/integral/integral_flip_cards", method = RequestMethod.GET)
	public ModelAndView integralFlipCards(HttpServletRequest request,
			@Valid @RequestParam(value = "userID") @Param(desc = "用户ID") String userID) {
		Long uid = Long.valueOf(userID);
		String type = IntegralConstants.INTEGRAL_FLIP_CARDS;
		ModelAndView mv = new ModelAndView("integral/integral_flip_cards.html");
		if (uid != null) {
			boolean flag = integralService.isSignToday(uid, type);
			int signDay = integralService.getSignDay(uid, type);
			int yesterday = 0;// 昨日为止连续翻牌天数
			boolean flagyeyesterday = false;
			if (signDay < 1) {
				flagyeyesterday = integralService.isSignYesterday(uid, type);
				if (flagyeyesterday) {
					yesterday = integralService.getSignYesterday(uid, type);
				}
			}
			mv.addObject("flag", flag);// 是否已翻牌 true已翻牌
			mv.addObject("signDay", signDay);// 连续翻牌天数
			mv.addObject("flagyeyesterday", flagyeyesterday);// 昨日是否连续翻牌
			mv.addObject("yesterday", yesterday);// 昨日连续翻牌次数
			mv.addObject("uid", uid);// 昨日连续翻牌次数

		}
		return mv;
	}

	@RequestMapping(value = "/integral/integral_flip_cards_get", method = RequestMethod.GET)
	public String integralFlipCardsGet(String id, HttpServletRequest request, HttpServletResponse response,
			@Valid @RequestParam(value = "userID") @Param(desc = "用户ID") String userID, boolean flag) {
		Long uid = Long.valueOf(userID);
		int num = 0;
		if (userID != null) {
			num = integralService.flipCardsGetIntegral(uid, flag);
		}
		return String.valueOf(num);
	}

	@RequestMapping(value = "/integral/integral_flip_cards_lost", method = RequestMethod.GET)
	public void integralFlipCardsLost(String id, HttpServletRequest request, HttpServletResponse response,
			String userId, String yesterday) {
		Long uid = Long.valueOf(userId);
		int sign = Integer.valueOf(yesterday);
		String content = "拼手气赚积分补签,消耗积分";
		try {
			int num = integralService.addIntegral(IntegralConstants.INTEGRAL_FLIP_CARDS_REMEDIAL, uid, null);
			integralService.addIntegralLogFlipCards(content,
					IntegralConstants.INTEGRAL_FLIP_CARDS_REMEDIAL_MARK, uid, sign);// 减少积分，添加日志
			CommUtil.returnBody(response, String.valueOf(num));
		} catch (Exception e) {
			logger.error("FLIP_CARDS_REMEDIAL is unsuccess uid =" + uid);
		}
	}

	/**
	 * 拼手气
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/integral/flip_cards", method = RequestMethod.POST)
	@MethodMapping(desc = "拼手气赚积分")
	@ResponseBody
	public IntegralFlipCardsResponse integralFlipCards() {
		IntegralFlipCardsResponse response = new IntegralFlipCardsResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("5.user.userid.undefind");
			response.setSubMsg("用户信息异常，请重新登录");
			return response;
		}
		String type = IntegralConstants.INTEGRAL_FLIP_CARDS;
		boolean flag = integralService.isSignToday(uid, type);
		int signDay = integralService.getSignDay(uid, type);
		int yesterday = 0;// 昨日为止连续翻牌天数
		boolean ifRemedy = false;// 补签
		boolean ifsenior = false;// 高级牌
		if (signDay < 1) {
			boolean flagyeyesterday = integralService.isSignYesterday(uid, type);
			if (!flagyeyesterday) {
				yesterday = integralService.getSignYesterday(uid, type);
				if (yesterday > 1) {
					ifRemedy = true;
				}
			}
		}
		boolean remedyflag = integralService.isSignToday(uid,
				IntegralConstants.INTEGRAL_FLIP_CARDS_REMEDIAL_MARK);
		if (remedyflag) {// 已补救不需再次补救
			signDay = integralService.getSignDay(uid, IntegralConstants.INTEGRAL_FLIP_CARDS_REMEDIAL_MARK);
			ifRemedy = false;
		}
		if (signDay >= 7) {
			ifsenior = true;
		}
		response.setIfFlip(flag);// true 已签到 false 未签到
		response.setIfSenior(ifsenior);// true 高级牌 false 普通牌
		response.setSignDayFlip(signDay);// int 连续签到天数
		response.setIfRemedy(ifRemedy);// true 不需补签 false需要补签
		response.setYtdSignDay(yesterday);// 昨日的连续签到天数，用于补签显示

		return response;
	}

	@RequestMapping(value = "/integral/flip_cards_get", method = RequestMethod.POST)
	@MethodMapping(desc = "拼手气赚积分，翻牌")
	@ResponseBody
	public IntegralFlipCardsResponse integralFlipCardsGet() {
		IntegralFlipCardsResponse response = new IntegralFlipCardsResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (integralService.isSignToday(uid, IntegralConstants.INTEGRAL_FLIP_CARDS)) {
			response.putErrorMessage("5.integralActivity.flip_cards.is_completed");// 一天只能签到一次，请明日再来
			return response;
		}
		if (integralService.IntegralTodayRemaining(1, uid) == 0) {
			response.putErrorMessage("5.integral.get.is_ceiling");// 积分获取达到上限
			return response;
		}
		int num = 0;
		num = integralService.flipCardsGetIntegral(uid, false);
		if (num == 0) {
			response.putErrorMessage("5.integralActivity.flip_cards.abnormal");// 翻牌失败
			return response;
		}
		int signDay = integralService.getSignDay(uid, IntegralConstants.INTEGRAL_FLIP_CARDS);
		response.setSignDayFlip(signDay);
		response.setIfFlip(true);
		response.setFlipIntegral(num);
		return response;
	}

	@RequestMapping(value = "/integral/flip_cards_lost", method = RequestMethod.POST)
	@MethodMapping(desc = "拼手气赚积分，补签")
	@ResponseBody
	public IntegralFlipCardsResponse integralFlipCardsLost() {
		IntegralFlipCardsResponse response = new IntegralFlipCardsResponse();
		Long uid = ActionsUtil.getOwnerUid();
		/*Long uid = 15874L;*/
		if (uid == null) {
			response.putErrorMessage("5.user.userid.undefind");
		}
		int ytdSignDay = 0;
		boolean ifSenior = false;
		String type = IntegralConstants.INTEGRAL_FLIP_CARDS;
		ytdSignDay = integralService.getSignYesterday(uid, type);// 昨日的连续签到天数
		int sign = ytdSignDay;
		if (sign >= 7) {
			ifSenior = true;
		}
		if (ytdSignDay < 1) {
			response.putErrorMessage("5.integralActivity.flip_cards.Do_not_need_to_remedy");// 不需要补签
			response.setRemedy(false);
			return response;
		}
		UserCustomer user = userCustomerService.findById(uid);
		if (user == null) {
			response.putErrorMessage("5.integralActivity.flip_cards.user_info_unfind");// 查询用户信息失败,请重新登录
			response.setRemedy(false);
			return response;
		}
		if (integralService.isSignToday(uid, IntegralConstants.INTEGRAL_FLIP_CARDS_REMEDIAL_MARK)) {
			response.putErrorMessage("5.integralActivity.flip_cards.Do_not_need_to_remedy");// 已经补签
			response.setSignDayFlip(sign);
			response.setRemedy(true);
			response.setIfSenior(ifSenior);
			return response;
		}
		if (user.getIntegral() < 20) {
			response.putErrorMessage("5.integralActivity.flip_cards.user_integral_lack");// 积分不足
			response.setRemedy(false);
			return response;
		}
		// 开始补签
		String content = "拼手气赚积分补签,消耗积分";
		int rtnum = integralService.FlipCardsLost(uid, content, sign);
		if (rtnum == 0) {
			response.putErrorMessage("5.integralActivity.flip_cards.remedy_is_unsuccess");// 补签失败
			response.setRemedy(false);
		} else {
			response.setSignDayFlip(sign);
			response.setRemedy(true);
		}
		response.setIfSenior(ifSenior);
		return response;
	}

}
