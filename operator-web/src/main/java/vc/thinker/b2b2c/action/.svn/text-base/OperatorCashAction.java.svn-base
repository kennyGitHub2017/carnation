package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.utils.RebateUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.pay.service.PredepositCashService;
import com.sinco.carnation.rebate.service.RebateRecordService;
import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.vo.PredepositCashVO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.bo.RebateRecordBO;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.carnation.user.vo.RebateRecordVO;
import com.sinco.dal.common.MyPage;

/**
 * 
 * @ClassName: OperatorCashAction
 * @Description: TODO(运营商体现管理)
 * @author Tang
 * @date 2015年9月6日 下午3:06:17
 * 
 */
@Controller
public class OperatorCashAction {
	@Autowired
	private PredepositCashService predepositCashService;
	@Autowired
	private UserMoneyService moneyService;
	@Autowired
	private RebateRecordService rebateRecordService;
	@Autowired
	private UserAccountService userAccountService;

	@SecurityMapping(title = "运营商预期收益记录", value = "/operator/operator_expect_income_list.htm*", rtype = "operator", rname = "运营商预期收益记录", rcode = "operator_expect_income_list", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_expect_income_list.htm")
	public String operatorExpectIncomeList(Model model, MyPage<RebateRecordBO> page, RebateRecordVO vo) {
		vo.setUserType("operator");
		rebateRecordService.selectOperatorRebateRecordList(SecurityUserHolder.getCurrentUserId(),
				RebateConstants.REBATE_STATUS_0, vo, page);
		BigDecimal totle = rebateRecordService.selectOperatorRebateRecordTotal(
				SecurityUserHolder.getCurrentUserId(), RebateConstants.REBATE_STATUS_0);
		Calendar start = Calendar.getInstance();
		start.setTime(new Date());
		start.add(Calendar.MONTH, 1);
		start.set(Calendar.DAY_OF_MONTH, 28);

		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		model.addAttribute("totle", totle == null ? BigDecimal.ZERO : totle);
		model.addAttribute("sendTime", start.getTime());
		model.addAttribute("rebateConstants", new RebateConstants());
		return "operator_expect_income_list.html";
	}

	@SecurityMapping(title = "运营商收益记录", value = "/operator/operator_income_list.htm*", rtype = "operator", rname = "运营商收益记录", rcode = "operator_income_list", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_income_list.htm")
	public String operatorIncomeList(Model model, MyPage<RebateRecordBO> page, RebateRecordVO vo) {
		//vo.setUserType("operator");
		rebateRecordService.selectOperatorRebateRecordList(SecurityUserHolder.getCurrentUserId(),
				RebateConstants.REBATE_STATUS_1, vo, page);
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		model.addAttribute("rebateConstants", new RebateConstants());
		model.addAttribute("rabateTypeList", RebateUtil.getRebateTypeList());
		return "operator_income_list.html";
	}

	@SecurityMapping(title = "运营商提现列表", value = "/operator/operator_cash_list.htm*", rtype = "operator", rname = "运营商提现列表", rcode = "operator_cash_list", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_cash_list.htm")
	public String operatorCashList(Model model, MyPage<PredepositCashBO> page, OperatorVO vo) {
		predepositCashService.queryByUserId(SecurityUserHolder.getCurrentUserId(), vo, page);
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		model.addAttribute("cashPayment", vo.getCashPayment());
		model.addAttribute("cashStatus", vo.getCashStatus());
		model.addAttribute("cashPayStatus", vo.getCashPayStatus());
		model.addAttribute("startDate", vo.getStartDate());
		model.addAttribute("endDate", vo.getEndDate());
		return "operator_cash_list.html";
	}

	@SecurityMapping(title = "运营商提现", value = "/operator/operator_cash.htm*", rtype = "operator", rname = "运营商提现", rcode = "operator_cash", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_cash.htm")
	public String operatorCashForm(Model model, MyPage<PredepositCashBO> page, OperatorVO vo) {
		Long uid = SecurityUserHolder.getCurrentUserId();
		UserAccount account = userAccountService.findByUid(uid, UserContant.ACCOUNT_TYPE_8);
		String source = UserContant.ACCOUNT_TYPE_CN;
		if (account == null) {
			source = UserContant.ACCOUNT_TYPE_YY;
			if (moneyService.isPasswordNull(uid, source)) {
				model.addAttribute("op_title", "你需要先设置取款密码！");
				model.addAttribute("url", "/operator/currency_password.htm");
				return "tips.html";
			}
		} else {
			String loginName = account.getLoginName();
			String YY = loginName.substring(0, 2);
			if (YY.equalsIgnoreCase("yy")) {
				loginName = loginName.substring(2);
			}
			/*double cnRepeat = moneyService.getCNRepeat(loginName);*/
			double cnBonus = moneyService.getCNBonus(loginName);
			/*model.addAttribute("cnRepeat", new BigDecimal(cnRepeat).setScale(2, RoundingMode.DOWN));*/
			model.addAttribute("cnBonus", new BigDecimal(cnBonus).setScale(2, RoundingMode.DOWN));
		}
		double availableBalance = moneyService.getAvailableBalance(uid);
		availableBalance = moneyService.getMoneyByUidAndSource(uid, source);
		double recordBalance = moneyService.getRecordBalance(uid);
		model.addAttribute("availableBalance",
				new BigDecimal(availableBalance).setScale(2, RoundingMode.DOWN));
		model.addAttribute("recordBalance", new BigDecimal(recordBalance).setScale(2, RoundingMode.DOWN));
		return "operator_cash.html";
	}

	@SecurityMapping(title = "运营商提现保存", value = "/operator/operator_cash_save.htm*", rtype = "operator", rname = "运营商提现保存", rcode = "operator_cash_save", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_cash_save.htm")
	public void operatorCashSave(Model model, HttpServletRequest request, HttpServletResponse response,
			PredepositCashVO vo) {
		String result = "提现申请成功！";
		Long uid = SecurityUserHolder.getCurrentUserId();
		UserAccount account = userAccountService.findByUid(uid, UserContant.ACCOUNT_TYPE_8);
		String source = UserContant.ACCOUNT_TYPE_CN;
		if (account == null) {
			source = UserContant.ACCOUNT_TYPE_YY;
		}
		try {
			result = moneyService.userCashApplyV2(SecurityUserHolder.getCurrentUserId(), vo, source);
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
			e.printStackTrace();
		}
	}
}
