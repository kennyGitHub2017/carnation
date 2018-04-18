package vc.thinker.b2b2c.action.buyer;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.pay.service.PredepositCashService;
import com.sinco.carnation.pay.service.PredepositLogService;
import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.vo.PredepositCashVO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.service.StatisticsService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: PredepositCashBuyerAction.java
 * </p>
 * 
 * <p>
 * Description:用户中心提现管理控制器，用户可以在这里申请提现，查看提现明细、提现列表
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2015-3-16
 * 
 * @version 1.0.1
 */
@Controller
public class PredepositCashBuyerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private PredepositCashService predepositCashService;
	@Autowired
	private PredepositLogService predepositLogService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private UserMoneyService moneyService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private StatisticsService statisticsService;

	@SuppressWarnings("unused")
	@SecurityMapping(title = "提现管理", value = "/buyer/buyer_cash.htm*", rtype = "buyer", rname = "预存款管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/buyer_cash.htm")
	public ModelAndView buyer_cash(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_cash.html",
				configService.getSysConfig(), 0, request, response);
		Long uid = SecurityUserHolder.getCurrentUserId();
		String source = UserContant.ACCOUNT_TYPE_RESOURCE;
		UserAccount account = userAccountService.findByUid(uid, UserContant.ACCOUNT_TYPE_8);
		Map<String, Object> moneyMap = statisticsService.getUserMoneyV2(uid, source);
		boolean pwdNotNull = (boolean) moneyMap.get("pwdNotNull");// 是否设置了云豆
		if (account == null) {
			if (!pwdNotNull) {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "你需要先设置取款密码！");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/money_password.htm");
				return mv;
			}
		}
		if (!this.configService.getSysConfig().getDeposit()) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
		} else {
			Double cnBonus = (Double) moneyMap.get("cnBonus");// 奖金
			Double cnRepeat = (Double) moneyMap.get("cnRepeat");// 冲销币
			Double availableBalance = (Double) moneyMap.get("availableBalance"); // 云豆
			Double recordBalance = (Double) moneyMap.get("recordBalance");// 预分润云豆
			
			double poundage = predepositCashService.getFreePoundage(uid, source);
			int line = predepositCashService.getLineByUid(uid, source);
			
			PredepositCashBO predepositCash = predepositCashService.queryOnlyOneByUid(uid);//提现记录
//			pwdNotNull = (String) moneyMap.get("pwdNotNull");//是否设置了云豆 
//			Double availableBalance = moneyService.getAvailableBalance(uid);
//			double recordBalance = moneyService.getRecordBalance(uid); 
			// PredepositCashBO cash = predepositCashService.getObjById(id)
			// mv.addObject("user", user);
			// mv.addObject("user",customer);
			// mv.addObject("availableBalance",
			// CommUtil.null2Double(user.getAvailableBalance()));
			mv.addObject("predepositCash", predepositCash);
			mv.addObject("cnBonus", new BigDecimal(cnBonus).setScale(2, RoundingMode.DOWN));
			mv.addObject("uid", uid);
			mv.addObject("availableBalance", new BigDecimal(availableBalance).setScale(2, RoundingMode.DOWN));
			mv.addObject("recordBalance", new BigDecimal(recordBalance).setScale(2, RoundingMode.DOWN));
			mv.addObject("poundage", poundage);//剩余免费额度 
			mv.addObject("line", line);//当月提现次数
		}

		return mv;
	}

	@SecurityMapping(title = "提现管理保存", value = "/buyer/buyer_cash_save.htm*", rtype = "buyer", rname = "预存款管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/buyer_cash_save.htm")
	public void buyer_cash_save(HttpServletRequest request, HttpServletResponse response, PredepositCashVO vo) {
		//会员 供应商 商户提现
		String result = "提现申请成功！";
		String source = UserContant.ACCOUNT_TYPE_RESOURCE; 
		try {
			//pc获取角色标识
			source = SecurityUserHolder.getCurrentUserDetails().getSource();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(source == null){
			source = UserContant.ACCOUNT_TYPE_RESOURCE; 
		}
		//0.个人 1.供应商 2.商户 3.运营商
/*		if(null != vo.getUserCode())
		if(vo.getUserCode()==1){
			source = UserContant.ACCOUNT_TYPE_SUPPLIER;
		}else if(vo.getUserCode()==2){
			source = UserContant.ACCOUNT_TYPE_MERCHANT;
		}*/
		try {
			result = moneyService.userCashApplyV2(SecurityUserHolder.getCurrentUserId(), vo,
					source);
		} catch (ServiceException e) {
			result = e.getErrorCode();
		} catch (Exception e) {
			result = "提现失败！请联系客服！";
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SecurityMapping(title = "提现管理", value = "/buyer/buyer_cash_list.htm*", rtype = "buyer", rname = "预存款管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/buyer_cash_list.htm")
	public ModelAndView buyer_cash_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<PredepositCashBO> page, OperatorVO vo) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_cash_list.html",
				configService.getSysConfig(), 0, request, response);
		if (!this.configService.getSysConfig().getDeposit()) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
		} else {
			// PredepositCashQueryObject qo = new
			// PredepositCashQueryObject(currentPage, mv, "addTime", "desc");
			// qo.addQuery("obj.cash_user.id", new SysMap("user_id",
			// SecurityUserHolder.getCurrentUser().getId()), "=");
			// IPageList pList = this.predepositCashService.list(qo);
			// CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
			predepositCashService.queryByUserId(SecurityUserHolder.getCurrentUserId(), vo, page);
			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		}
		return mv;
	}

	@SecurityMapping(title = "会员提现详情", value = "/buyer/buyer_cash_view.htm*", rtype = "buyer", rname = "预存款管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/buyer_cash_view.htm")
	public ModelAndView buyer_cash_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_cash_view.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			PredepositCashBO obj = this.predepositCashService.fetch(CommUtil.null2Long(id));
			mv.addObject("obj", obj);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
		}
		return mv;
	}
	
	/**
	 * 个人端 获取提现免费额度
	 * 
	 * @param request
	 * @param response
	 * @param pid
	 */
	@RequestMapping("/load_getPoundages.htm")
	public void load_getPoundages(HttpServletRequest request, HttpServletResponse response ,BigDecimal amount) {
		Long uid = SecurityUserHolder.getCurrentUserId();
		String source = UserContant.ACCOUNT_TYPE_RESOURCE; 
		double poundage = predepositCashService.getPoundage(uid, source, amount);
		Map<String, Object> maps = new HashMap<>();
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			maps.put("result", "success");
			maps.put("poundage", poundage);
			String temp = Json.toJson(maps, JsonFormat.compact());
//			String test = JSON.toJSONString(list);
			writer = response.getWriter();
			writer.print(temp);
//			writer.print(test);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			maps.put("result", "failure");
			e.printStackTrace();
		}
	}
}
