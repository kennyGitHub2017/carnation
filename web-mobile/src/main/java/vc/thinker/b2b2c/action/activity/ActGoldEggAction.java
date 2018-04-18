package vc.thinker.b2b2c.action.activity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.sinco.carnation.goldEgg.bo.ActGlodEggBO;
import com.sinco.carnation.goldEgg.bo.GlodEggItemBO;
import com.sinco.carnation.goldEgg.bo.GlodEggRecordBO;
import com.sinco.carnation.goldEgg.service.ActGlodEggService;
import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.service.SysConfigService;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;

/**
 * 砸金蛋活动控制器
 * 
 * @author tw
 * 
 */
@Controller
@RequestMapping("/activity/gold_egg")
public class ActGoldEggAction {
	private static final Logger LOG = LoggerFactory.getLogger(ActGoldEggAction.class);
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ActGlodEggService actGlodEggService;

	/**
	 * 跳转到砸金蛋活动首页
	 * 
	 * @param invitationCode
	 *            邀请码，如果是分享链接会带此参数
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/view.htm", method = RequestMethod.GET)
	public ModelAndView view(String invitationCode, HttpServletRequest request, HttpServletResponse response) {
		// 判断用户是否登陆，没有跳转到微信授权
		LOG.debug("正在进入砸金蛋活动页面。。。");
		UserBO user = SecurityUserHolder.getCurrentUser();
		if (user == null) {
			LOG.debug("微信授权中。。。");
			String domainName = this.getDomainName(request);
			ModelAndView mv = new ModelAndView("redirect:/weChatUrl.htm");
			mv.addObject("url", domainName + "gold_egg/to_act.htm");
			mv.addObject("invitationCode", invitationCode);
			mv.addObject("login", "0");
			return mv;
		}
		// 进入活动页面
		LOG.debug("进入砸金蛋活动页面。。。");
		List<GlodEggRecordBO> records = actGlodEggService.getGlodEggRecord(user.getId());
		ModelAndView mv = new JModelAndView("gold_egg/to_act.html", configService.getSysConfig(), 1, request,
				response);
		mv.addObject("indexOneUsed", false);
		mv.addObject("indexTwoUsed", false);
		mv.addObject("indexThreeUsed", false);
		mv.addObject("hasEgg", 0);
		if (records != null && records.size() > 0) {
			for (GlodEggRecordBO record : records) {
				switch (record.getEggIndex()) {
					case 0:
						mv.addObject("indexOneUsed", true);
						break;
					case 1:
						mv.addObject("indexTwoUsed", true);
					case 2:
						mv.addObject("indexThreeUsed", true);
					default:
						break;
				}
			}
			// 取出当前活动
			ActGlodEggBO actGlodEggBo = actGlodEggService.getActGlodEgg();
			if (actGlodEggBo != null && actGlodEggBo.getActivityHotSale() != null) {
				ActivityHotSaleBO activityHotSaleBO = actGlodEggBo.getActivityHotSale();
				// 判断当前用户是否有砸金蛋的条件
				mv.addObject("hasEgg", actGlodEggService.allowGetGlodEggCount(user.getId(),
						activityHotSaleBO.getStartTime()));
			}
		}
		return mv;
	}

	/**
	 * 砸金蛋
	 * 
	 * @param index
	 *            指定砸哪一个0-2，共三个金蛋
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/act.htm", method = RequestMethod.POST)
	@ResponseBody
	public String act(int index, HttpServletRequest request) {
		Map<String, Object> resp = new HashMap<String, Object>();
		// 验证参数有效性
		if (index < 0 || index > 2) {
			resp.put("code", 1);
			resp.put("message", "参数index错误, 允许范围0-2");
			return JSON.toJSONString(resp);
		}
		// 取出当前活动
		ActGlodEggBO actGlodEggBo = actGlodEggService.getActGlodEgg();
		// 验证活动的有效性
		if (actGlodEggBo == null || actGlodEggBo.getActivityHotSale() == null) {
			resp.put("code", 2);
			resp.put("message", "活动不存在");
			return JSON.toJSONString(resp);
		}
		ActivityHotSaleBO activityHotSaleBO = actGlodEggBo.getActivityHotSale();
		if (activityHotSaleBO.getDeleteStatus() != 0 || activityHotSaleBO.getIsEnabled() != 0) {
			resp.put("code", 3);
			resp.put("message", "活动无效");
			return JSON.toJSONString(resp);
		}
		Date now = new Date();
		if (activityHotSaleBO.getStartTime() != null
				&& activityHotSaleBO.getStartTime().getTime() > now.getTime()) {
			resp.put("code", 4);
			resp.put("message", "活动还没有开始");
			return JSON.toJSONString(resp);
		}
		if (activityHotSaleBO.getEndTime() != null
				&& activityHotSaleBO.getEndTime().getTime() < now.getTime()) {
			resp.put("code", 5);
			resp.put("message", "活动已经结束");
			return JSON.toJSONString(resp);
		}
		// 开始砸蛋
		long userId = 1;
		// 判断当前用户是否有砸金蛋的条件
		if (!actGlodEggService.isAllowGetGlodEgg(userId, index, activityHotSaleBO.getStartTime())) {
			resp.put("code", 6);
			resp.put("message", "想要继续拆蛋，快请您的好友帮帮忙！");
			return JSON.toJSONString(resp);
		}
		// 计算中奖率，发放奖品
		GlodEggItemBO item = actGlodEggService.calGlodEggItem(actGlodEggBo, userId, index);
		if (item == null) {
			resp.put("code", 7);
			resp.put("message", "很遗憾，请继续努力");
			return JSON.toJSONString(resp);
		}
		// 返回奖品
		resp.put("code", 0);
		resp.put("message", "中奖啦");
		resp.put("index", index);
		resp.put("money", item.getTotalMoney());
		return JSON.toJSONString(resp);
	}

	/**
	 * 获取域名
	 * 
	 * @param request
	 * @return
	 */
	private String getDomainName(HttpServletRequest request) {
		int endIndex = request.getRequestURL().length() - request.getPathInfo().length() + 1;
		String domainName = request.getRequestURL().substring(0, endIndex);
		return domainName;
	}

}
