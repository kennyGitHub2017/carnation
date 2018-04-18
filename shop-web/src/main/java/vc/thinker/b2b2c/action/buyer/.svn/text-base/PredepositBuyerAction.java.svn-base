package vc.thinker.b2b2c.action.buyer;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositLogService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.bo.PredepositBO;
import com.sinco.carnation.shop.bo.PredepositLogBO;
import com.sinco.carnation.shop.bo.ShopBonusRepeatLogBO;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.shop.vo.ShopBonusRepeatLogVO;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.orcl.CnUserMoneyBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: PredepositBuyerAction.java
 * </p>
 * 
 * <p>
 * Description: 前端买家充值管理控制器，用来处理买家充值等
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
 * @date 2014-5-21
 * 
 * @version 1.0.1
 */
@Controller
public class PredepositBuyerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private PredepositService predepositService;
	@Autowired
	private PredepositLogService predepositLogService;
	@Autowired
	private UserService userService;
	@Autowired
	UserMoneyService userMoneyService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private PayTools payTools;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private CnPayBaseService cnPayBaseService;

	@SecurityMapping(title = "会员充值", value = "/buyer/predeposit.htm*", rtype = "buyer", rname = "云豆管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/predeposit.htm")
	public ModelAndView predeposit(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_predeposit.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			String[] notMarks = new String[] {"alipay_wap", "balance", "payafter", "alipay_app", "wx_app",
					"wx_pay", "mch_wxqrpay"};

			List<PaymentBO> payments = this.paymentService.findByMark(notMarks, true);

			mv.addObject("payments", payments);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启云豆");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
		}
		mv.addObject("user", this.customerService.findSessionUser(SecurityUserHolder.getCurrentUserId()));
		return mv;
	}

	@SecurityMapping(title = "会员充值保存", value = "/buyer/predeposit_save.htm*", rtype = "buyer", rname = "云豆管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/predeposit_save.htm")
	public ModelAndView predeposit_save(HttpServletRequest request, HttpServletResponse response, String id,
			String pdPayment) {
		ModelAndView mv = new JModelAndView("line_pay.html", configService.getSysConfig(), 1, request,
				response);
		SysConfigBO config = this.configService.getSysConfig();
		if (this.configService.getSysConfig().getDeposit()) {
			WebForm wf = new WebForm();
			Predeposit obj = wf.toPo(request, Predeposit.class);
			if (StringUtils.isBlank(id)) {
				if (PaymentConstants.PAYMENT_MARK_OUTLINE.equals(pdPayment)) {
					obj.setPdPayStatus(UserContants.PD_PAY_STATUS_1);
				} else {
					obj.setPdPayStatus(UserContants.PD_PAY_STATUS_0);
				}
				obj.setPdPayment(pdPayment);
				obj.setPdUserId(SecurityUserHolder.getCurrentUserId());
			} else {
				obj.setId(CommUtil.null2Long(id));
			}

			this.predepositService.save(obj, SecurityUserHolder.getCurrentUserId());

			if (PaymentConstants.PAYMENT_MARK_OUTLINE.equals(pdPayment)) {
				mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "线下支付提交成功，等待审核");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/predeposit_list.htm");
			} else {
				mv.addObject("payType", pdPayment);
				mv.addObject("type", "cash");
				mv.addObject("url", config.getAddress());
				mv.addObject("payTools", payTools);
				mv.addObject("cash_id", obj.getId());
				Payment payment = this.paymentService.findByMark(obj.getPdPayment(), true);
				mv.addObject("payment_id", payment != null ? payment.getId() : null);
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启云豆");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "会员充值列表", value = "/buyer/predeposit_list.htm*", rtype = "buyer", rname = "云豆管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/predeposit_list.htm")
	public ModelAndView predeposit_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<PredepositBO> page) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/predeposit_list.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {

			this.predepositService.findPageByUid(SecurityUserHolder.getCurrentUserId(), page);

			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启云豆");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "会员充值详情", value = "/buyer/predeposit_view.htm*", rtype = "buyer", rname = "云豆管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/predeposit_view.htm")
	public ModelAndView predeposit_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/predeposit_view.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			Predeposit obj = this.predepositService.getObjById(CommUtil.null2Long(id));
			if (obj.getPdUserId().equals(SecurityUserHolder.getCurrentUserId())) {
				mv.addObject("obj", obj);
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "参数错误，您没有该充值信息！");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/predeposit_list.htm");
			}

		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启云豆");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "会员充值结果", value = "/buyer/predeposit_finish.htm*", rtype = "buyer", rname = "云豆管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/predeposit_finish.htm")
	public ModelAndView predeposit_finish(HttpServletRequest request, HttpServletResponse response,
			String orderNo) {
		PredepositBO bo = this.predepositService.findByPdSn(orderNo);
		if (bo != null && bo.getPdPayStatus() == UserContants.PD_PAY_STATUS_2) {
			ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "恭喜您，成功充值" + bo.getPdAmount() + "元");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/predeposit_list.htm");
			return mv;
		} else {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "该充值没有成功，请返回重新充值");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/predeposit.htm");
			return mv;
		}
	}

	@SecurityMapping(title = "会员充值支付", value = "/buyer/predeposit_pay.htm*", rtype = "buyer", rname = "云豆管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/predeposit_pay.htm")
	public ModelAndView predeposit_pay(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/predeposit_pay.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			Predeposit obj = this.predepositService.getObjById(CommUtil.null2Long(id));
			if (obj.getPdUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
				mv.addObject("obj", obj);
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "参数错误，您没有该充值信息！");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/predeposit_list.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启云豆");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "会员收入明细", value = "/buyer/predeposit_log.htm*", rtype = "buyer", rname = "云豆管理", rcode = "predeposit_set", rgroup = "用户中心")
	@RequestMapping("/buyer/predeposit_log.htm")
	public ModelAndView predeposit_log(HttpServletRequest request, HttpServletResponse response,
			MyPage<PredepositLogBO> page) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_predeposit_log.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			this.predepositLogService.findPageByUid(SecurityUserHolder.getCurrentUserId(), page,
					UserContant.USER_CODE_USER);
			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		}
		UserCustomerBO userCustomerBO = this.customerService.findSessionUser(SecurityUserHolder
				.getCurrentUser().getId());
		double recordBalance = userMoneyService.getRecordBalance(SecurityUserHolder.getCurrentUserId());
		UserAccountBO user = new UserAccountBO();
		user.setUid(SecurityUserHolder.getCurrentUserId());
		user.setAccountType(UserContant.ACCOUNT_TYPE_8);
		UserAccount user_ = userAccountService.findAccountByVo(user);
		double cnBonus = 0.0;
		if (user_ != null) {
			CnUserMoneyBO cnUserMoneyBO = this.cnPayBaseService.getCnUserBounsMoney(user_.getLoginName());// 奖金
			if (cnUserMoneyBO != null) {
				if (null != cnUserMoneyBO.getISPAY() && 1 == cnUserMoneyBO.getISPAY().intValue()) {
					if (null != cnUserMoneyBO.getBONUS()) {
						cnBonus = cnUserMoneyBO.getBONUS();
					}
				}
			}
		}
		BigDecimal bous = new BigDecimal(cnBonus).add(new BigDecimal(recordBalance));
		BigDecimal availableBalance = (null == userCustomerBO.getAvailableBalance()) ? new BigDecimal(0)
				: userCustomerBO.getAvailableBalance();
		double availableBalance_ = bous.add(availableBalance).doubleValue();
		mv.addObject("availableBalance", availableBalance_);
		return mv;
	}

	/***
	 * 用户云购币明细
	 * 
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("/buyer/yungouMoney_log.htm")
	public ModelAndView yungouMoney_log(HttpServletRequest request, HttpServletResponse response,
			MyPage<ShopBonusRepeatLogBO> page) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_yungouMoney_log.html",
				configService.getSysConfig(), 0, request, response);
		Long userId = SecurityUserHolder.getCurrentUserId();
		ShopBonusRepeatLogVO vo = new ShopBonusRepeatLogVO();
		vo.setUid(userId);
		vo.setPayType(3);// 表示云购币
		this.predepositLogService.getPageRepeatByVo(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

}
