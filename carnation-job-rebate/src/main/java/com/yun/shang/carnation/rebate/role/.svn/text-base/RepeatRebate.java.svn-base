package com.yun.shang.carnation.rebate.role;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.common.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.biz.common.orcl.OrclService;
import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.sys.constant.OrclSchmaNameConstants;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.constant.MoneyUserTypeEnum;
import com.yun.shang.carnation.rebate.constant.JobConstant;
import com.yun.shang.carnation.rebate.constant.RebateType;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;
import com.yun.shang.carnation.rebate.money.MoneyService;
import com.yun.shang.carnation.rebate.money.RebateMoneyService;
import com.yun.shang.carnation.rebate.tools.RebateTools;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 云购币购买，重复分润
 * 
 * @author xing.wen
 * 
 */
public class RepeatRebate extends RoleRebate {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private OrclService orclService;
	// 用户的基本信息
	@SuppressWarnings("unused")
	private UserAccountService userAccountService;

	public RepeatRebate(OrclService orclService, UserAccountService userAccountService,
			MoneyService moneyService) {
		this.orclService = orclService;
		this.userAccountService = userAccountService;
		super.moneyService = moneyService;
	}

	@Override
	public Map<String,AddMoneyMO> rebate(long orderUserId, long selleruserId, long orderId, String orderNo, BigDecimal BVAmount,
			RebateType rebatetype) {
		Map<String,AddMoneyMO> resultMP = new HashMap<String,AddMoneyMO>();
		if (!(moneyService instanceof RebateMoneyService)) {
			return null;
		}
		UserAccount userAccount = RebateTools.getAccount(orderUserId, "8");
		if (null == userAccount || StringUtils.isBlank(userAccount.getLoginName())
				|| !userAccount.getLoginName().startsWith(JobConstant.OTHER_REBATE_ACCOUNT_START)) {
			return null;
		}
		// 待获取
		String deal_number = "";
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("PAY_TYPE", "1");
		parameter.put("MONEY", String.valueOf(BVAmount.doubleValue()));
		parameter.put("ORDER_NO", String.valueOf(orderNo));
		parameter.put("DEAL_NUMBER", deal_number);
		parameter.put("USER_ALIAS", userAccount.getLoginName());
		@SuppressWarnings("static-access")
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_ORDER_REPEAT, parameter);
		logger.info("remote method.remote result =" + result);
		try {
			JSONObject jsonobject = JSONObject.fromObject(result);
			if ("success".equals(jsonobject.getString("result"))) {
				JSONArray jsonarray = jsonobject.getJSONArray("data");
				if ("0|".equals(jsonarray.getJSONObject(0).getString("ISORDER"))) {
					logger.error("[rebate] repeat error.orderid=" + orderId + ",seller id =" + selleruserId
							+ "order user id=" + orderUserId);
					return null;
				}
				logger.info("[rebate] repeat success. orderid=" + orderId + ",seller id =" + selleruserId
						+ "order user id=" + orderUserId);
				AddMoneyMO addMoney = new AddMoneyMO();
				addMoney.setUserRefereeAmount(new BigDecimal(0));
				addMoney.setRelateUserId(orderUserId);
				addMoney.setOrderId(orderId);
				addMoney.setOrderNo(orderNo);
				addMoney.setOrderUserId(orderUserId);
				addMoney.setSelleruserId(selleruserId);
				addMoney.setBVAmount(BVAmount);
				addMoney.setRebateType(RebateConstants.REPEAT_REBATE);
				addMoney.setUserType(MoneyUserTypeEnum.BUYER);
				resultMP.put(orderNo+"_"+RebateConstants.REPEAT_REBATE, addMoney);
				return null;
			}
			logger.error("[rebate] repeat error.orderid=" + orderId + ",seller id =" + selleruserId
					+ "order user id=" + orderUserId);
		} catch (Exception e) {
			logger.error("[rebate] repeat error.orderid=" + orderId + ",seller id =" + selleruserId
					+ "order user id=" + orderUserId, e);
		}
		throw new RuntimeException("[rebate] repeat error.");
	}

	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("PAY_TYPE", "1");
		parameter.put("MONEY", String.valueOf(20));
		parameter.put("ORDER_NO", "15142201609051445098");
		parameter.put("DEAL_NUMBER", "");
		parameter.put("USER_ALIAS", "CN54130243");
		String code = "YUNSHANG";
		String key = "123456";
		String url = "http://112.175.238.122:8010/DataInterface.aspx";
		OrclService orclService = new OrclService();
		orclService.setCode(code);
		orclService.setKey(key);
		orclService.setUrl(url);
		String resultJsonStr = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_ORDER_REPEAT,
				parameter);
		System.out.println(resultJsonStr);
	}
}
