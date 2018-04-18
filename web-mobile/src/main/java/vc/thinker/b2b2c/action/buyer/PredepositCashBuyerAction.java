package vc.thinker.b2b2c.action.buyer;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.pay.service.PredepositCashService;
import com.sinco.carnation.pay.service.PredepositLogService;
import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.vo.PredepositCashVO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

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

	@SecurityMapping(title = "提现管理", value = "/buyer/buyer_cash.htm*", rtype = "buyer", rname = "预存款管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/buyer_cash.htm")
	public ModelAndView buyer_cash(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_cash.html",
				configService.getSysConfig(), 0, request, response);
		String source = UserContant.ACCOUNT_TYPE_MERCHANT;
		if (moneyService.isPasswordNull(SecurityUserHolder.getCurrentUserId(), source)) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "你需要先设置取款密码！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/money_password.htm");
			return mv;
		}

		if (!this.configService.getSysConfig().getDeposit()) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
		} else {
			// User user =
			// this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
			// UserCustomer customer =
			// customerService.findById(SecurityUserHolder.getCurrentUserId());
			Double availableBalance = moneyService.getAvailableBalance(SecurityUserHolder.getCurrentUserId());
			// PredepositCashBO cash = predepositCashService.getObjById(id)
			// mv.addObject("user", user);
			// mv.addObject("user",customer);
			// mv.addObject("availableBalance",
			// CommUtil.null2Double(user.getAvailableBalance()));
			mv.addObject("availableBalance", new BigDecimal(availableBalance).setScale(2, RoundingMode.DOWN));
		}

		return mv;
	}

	@SecurityMapping(title = "提现管理保存", value = "/buyer/buyer_cash_save.htm*", rtype = "buyer", rname = "预存款管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/buyer_cash_save.htm")
	public void buyer_cash_save(HttpServletRequest request, HttpServletResponse response, PredepositCashVO vo) {
		String result = "提现申请成功！";
		if (vo.getCashAmount() % 100 > 0)
			result = "提现金额只能是100的整数倍";
		else {
			try {
				result = moneyService.userCashApply(SecurityUserHolder.getCurrentUserId(), vo);
			} catch (ServiceException e) {
				result = e.getErrorCode();
			} catch (Exception e) {
				result = "提现失败！请联系客服！";
			}

		}
//		else if (!moneyService.validatePassword(SecurityUserHolder.getCurrentUserId(), password))
//			ret = -200;
//		else {
//
//			// User user =
//			// this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
//			Double avaliableBalance = moneyService.getAvailableBalance(SecurityUserHolder.getCurrentUserId());
//			if (CommUtil.null2Double(cash_amount) <= avaliableBalance) {
//				PredepositCash obj = new PredepositCash();
//				obj.setCashPayment(cash_payment);
//				obj.setCashAccount(cash_account);
//				obj.setCashUserName(cash_userName);
//				obj.setCashBank(cash_bank);
//				obj.setCashAmount(BigDecimal.valueOf(CommUtil.null2Double(cash_amount)));
//				obj.setCashInfo(cash_info);
//				obj.setCashSn("cash" + CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + SecurityUserHolder.getCurrentUser().getId());
//				obj.setAddTime(new Date());
//				obj.setCashUserId(SecurityUserHolder.getCurrentUserId());
//				obj.setCashStatus(0);
//				obj.setCashPayStatus(0);
//				try {
//					this.predepositCashService.add(SecurityUserHolder.getCurrentUserId(), CommUtil.null2Double(cash_amount), obj);
//				} catch (ServiceException e) {
//					ret = -300;
//					e.printStackTrace();
//				}
//
//			} else {
//				ret = -100;
//			}
//		}
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
}
