package com.sinco.carnation.pay.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vc.thinker.b2b2c.core.tools.Md5Encrypt;

import com.sinco.biz.common.orcl.OrclService;
import com.sinco.carnation.pay.tools.OrclJsonTools;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.sys.bo.orcl.CnMoneyBO;
import com.sinco.carnation.sys.bo.orcl.CnRenturnYgOrderBO;
import com.sinco.carnation.sys.bo.orcl.CnUserMoneyBO;
import com.sinco.carnation.sys.bo.orcl.CnUserPayBO;
import com.sinco.carnation.sys.bo.orcl.CnUserRefundBO;
import com.sinco.carnation.sys.bo.orcl.CnValidatPasswordBO;
import com.sinco.carnation.sys.bo.orcl.CnWirteOrderBO;
import com.sinco.carnation.sys.bo.orcl.CnYgOrderPayBO;
import com.sinco.carnation.sys.constant.OrclSchmaNameConstants;
import com.sinco.common.utils.StringUtils;

/**
 * CN账户支付相关服务
 * 
 * @author Administrator
 * 
 */
@Service
public class CnPayBaseService {
	private static Logger logger = LoggerFactory.getLogger(CnPayBaseService.class);
	@Autowired
	private OrclService orclService;

	/**
	 * 0:不可支付,1可支付 获取CN账户的奖金余额
	 */
	@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
	public CnUserMoneyBO getCnUserBounsMoney(String user_alias) {
		Map map = new HashMap();
		map.put("USER_ALIAS", user_alias);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_ACCOUNT_1, map);
		return (CnUserMoneyBO) OrclJsonTools.handeljson(result, CnUserMoneyBO.class);
	}

	/**
	 * 0:不可支付,1可支付 获取Cn账户的重消余额
	 * 
	 * @param user_alias
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "static-access", "unchecked"})
	public CnUserMoneyBO getCnUserRepeatMoney(String user_alias) {
		Map map = new HashMap();
		map.put("USER_ALIAS", user_alias);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_ACCOUNT_3, map);
		return (CnUserMoneyBO) OrclJsonTools.handeljson(result, CnUserMoneyBO.class);

		/*		CnUserMoneyBO cnUserMoneyBO = new CnUserMoneyBO();//此方法备用
				Map map_2 = new HashMap();
				map_2.put("USER_ALIAS", user_alias);
				map_2.put("WALLETTYPE", OrclSchmaNameConstants.WALLET_TYPE_YG);
				CnMoneyBO moneyBO = this.getCnUserCxWalletView(map_2);
				if (null != moneyBO && null != moneyBO.getMONEY()
						&& null != moneyBO.getWALLET_STATUS()) {
					Double cnRecharge = moneyBO.getMONEY();
					if (moneyBO.getWALLET_STATUS().equals("5")) {// 账户被冻结
						cnRecharge = 0.0;
					}
					cnUserMoneyBO.setBONUS_REPEAT(cnRecharge);
					
					if (moneyBO.getWALLET_STATUS().equals("0")) {
						cnUserMoneyBO.setISPAY(1);
					}
				}
				return cnUserMoneyBO;*/
	}

	/**
	 * CN账户奖金或者重消支付逻辑处理 return 0:不可支付成功,1可支付成功
	 * 
	 * @param pay_type
	 *            奖金：1 重消3 充值2
	 * @param user_alias
	 *            :用户编号
	 * @param order_no
	 *            :订单号
	 * @param money
	 *            :订单话费奖金或重消金额
	 * @param password2
	 *            :支付密码
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
	public CnUserPayBO OrderPay(int pay_type, String user_alias, String order_no, BigDecimal money,
			String password2, String pay_ip) {
		Map map = new HashMap();
		map.put("USER_ALIAS", user_alias);
		map.put("ORDER_NO", order_no);
		map.put("MONEY", money);
		password2 = Md5Encrypt.md5(password2).toLowerCase();
		map.put("PASSWORD2", password2);
		map.put("PAY_TYPE", pay_type);
		map.put(" PAY_IP", pay_ip);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_ACCOUNT_PAY, map);
		CnUserPayBO userPay = (CnUserPayBO) OrclJsonTools.handeljson(result, CnUserPayBO.class);
		if (userPay != null) {
			String[] str = handString(userPay.getISPAY());
			// System.out.println(str);
			logger.info("OrderPay方法:userPay" + str);
			if (str.length == 2) {
				userPay.setISPAY(str[0]);
				userPay.setDEAL_NUMBER(str[1]);
			} else {
				userPay.setISPAY("0");
			}
		} else {
			logger.info("OrderPay方法:支付结果失败");
			userPay = new CnUserPayBO();
			userPay.setISPAY("0");
		}
		return userPay;
	}

	/**
	 * 重消或奖金退款0:不可退款,1退款成功
	 * 
	 * @param order_no订单号
	 * @param amount退款金额
	 * @param orderPayNumber支付时结算系统返回的交易号
	 * @param type
	 *            奖金：1 重消：3
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
	public CnUserRefundBO orderRefund(String user_alias, String order_no, BigDecimal amount,
			String orderPayNumber, int type, String pay_ip) {
		Map map = new HashMap();
		map.put("ORDER_NO", order_no);
		map.put("MONEY", amount);
		map.put("DEAL_NUMBER", orderPayNumber);
		map.put("PAY_TYPE", type);
		map.put("USER_ALIAS", user_alias);
		map.put(" PAY_IP", pay_ip);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_ACCOUNT_RETURN, map);
		CnUserRefundBO refund = (CnUserRefundBO) OrclJsonTools.handeljson(result, CnUserRefundBO.class);
		if (refund != null) {
			String[] str = handString(refund.getISREFUND());
			logger.info("orderRefund方法:refund" + str);
			if (str.length == 2) {
				refund.setISREFUND(str[0]);
				refund.setREFUNFNO(str[1]);
			} else {
				refund.setISREFUND("0");
			}
		} else {
			logger.info("orderRefund方法:退款结果结果失败");
			refund = new CnUserRefundBO();
			refund.setISREFUND("0");
		}
		return refund;
	}

	/**
	 * 处理支付与退款返回的结果，进行字符串分割，{"ISREFUND":"1|T02080046"}，:{"ISPAY":"1|T02080045"}
	 * 
	 * @return
	 */
	public String[] handString(String str) {
		String[] result = {};
		if (StringUtils.isNotEmpty(str)) {
			result = str.split("\\|");
		}
		return result;
	}

	/***
	 * 单独验证支付密码 返回结果:0支付密码错误,1支付密码正确
	 */
	@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
	public CnValidatPasswordBO validatPassword2(String user_alias, String password) {
		Map map = new HashMap();
		password = Md5Encrypt.md5(password).toLowerCase();
		map.put("pPassword2", password);
		map.put("pUserAlias", user_alias);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_PWD2_ABLE, map);
		return (CnValidatPasswordBO) OrclJsonTools.handeljson(result, CnValidatPasswordBO.class);
	}

	/**
	 * 获取CN账户的余额
	 */
	@SuppressWarnings({"rawtypes", "static-access"})
	public CnMoneyBO getCnUserCxWalletView(Map map) {
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_CX_WALLET_VIEW, map);
		return (CnMoneyBO) OrclJsonTools.handeljson(result, CnMoneyBO.class);
	}

	/**
	 * 云购币+现金支付
	 */
	@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
	public CnYgOrderPayBO ygOrderPay(String user_alias, String password, Double moneyone, Double moneytwo,
			String orderno, int payType) {
		Map map = new HashMap();
		map.put("USER_ALIAS", user_alias);
		password = Md5Encrypt.md5(password).toLowerCase();
		map.put("PASSWORD", password);
		map.put("ORDERNO", orderno);
		map.put("MONEYONE", moneyone);
		map.put("MONEYTWO", moneytwo);
		map.put("PAY_TYPE", payType);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_CX_WALLET_PAY, map);
		CnYgOrderPayBO userPay = (CnYgOrderPayBO) OrclJsonTools.handeljson(result, CnYgOrderPayBO.class);
		if (userPay != null) {
			String[] str = handString(userPay.getPAY_STATUS());
			// System.out.println(str);
			logger.info("OrderPay方法:userPay" + str);
			if (null != str && str.length > 0) {
				String payStaus = str[0];
				userPay.setPAY_STATUS_1(Double.valueOf(payStaus).intValue());
				if (OrderFormConstants.GET_USER_CX_WALLET_PAY_100 == Double.valueOf(payStaus).intValue()
						&& str.length == 3) {
					userPay.setDEAL_NUMBER_1(str[1]);
					userPay.setDEAL_NUMBER_2(str[2]);
				} else if (OrderFormConstants.GET_USER_CX_WALLET_PAY_100 == Double.valueOf(payStaus)
						.intValue() && str.length == 2) {
					userPay.setDEAL_NUMBER_1(str[1]);
				}
			} else {
				logger.info("ygOrderPay方法:支付结果失败,返回结果为空");
				userPay = null;// 支付失败，返回结果为空
			}
		} else {
			logger.info("ygOrderPay方法:支付结果失败,返回结果为空");
			userPay = null;
		}
		return userPay;
	}

	/**
	 * 云购订单写入直销系统
	 * 
	 * @param loginName
	 * @param doubleValue
	 * @param orderId
	 */
	@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
	public CnWirteOrderBO writeYgOrder(String loginName, double bv, String orderId) {
		Map map = new HashMap();
		map.put("USER_ALIAS", loginName);
		map.put("ORDER_MONEY", bv);
		map.put("ORDERNO", orderId);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_CX_ORDER_BV, map);
		return (CnWirteOrderBO) OrclJsonTools.handeljson(result, CnWirteOrderBO.class);
	}

	/**
	 * 云购币订单待付现金状态的订单超48小时未付款，退回云购币接口
	 * 
	 * @param user_alias
	 * @param type
	 * @param money
	 * @param orderNo
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
	public CnRenturnYgOrderBO return_ygOrder(String user_alias, int type, BigDecimal money, String orderNo) {
		Map map = new HashMap();
		map.put("USER_ALIAS", user_alias);
		map.put("WALLETTYPE", type);
		map.put("MONEY", money);
		map.put("ORDERNO", orderNo);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_CX_WALLET_RETURN, map);
		return (CnRenturnYgOrderBO) OrclJsonTools.handeljson(result, CnRenturnYgOrderBO.class);
	}

	/**
	 * 查询CN账户的购物积分
	 */
	@SuppressWarnings({"rawtypes", "static-access"})
	public CnMoneyBO getCnUserShopPv(Map map) {
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_SHOP_PV_SUM, map);

		return (CnMoneyBO) OrclJsonTools.handeljson(result, CnMoneyBO.class);
	}

	/***
	 * 购物积分支付
	 * 
	 * @param userAlias
	 * @param pwd
	 * @param money
	 * @param orderNo
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
	public CnUserPayBO cnUserIntegralPay(String userAlias, String pwd, Double money, String orderNo) {
		Map map = new HashMap();
		map.put("USER_ALIAS", userAlias);
		String password = Md5Encrypt.md5(pwd).toLowerCase();
		map.put("PASSWORD", password);
		map.put("MONEYONE", money);
		map.put("ORDERNO", orderNo);
		String res = this.orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_SHOP_PV_PAY, map);
		CnUserPayBO userPay = (CnUserPayBO) OrclJsonTools.handeljson(res, CnUserPayBO.class);
		if (null != userPay) {
			String[] status = handString(userPay.getPAY_STATUS());
			if (null != status && status.length > 0) {
				userPay.setPAY_STATUS(status[0]);
				userPay.setDEAL_NUMBER(status[1]);
			}

		} else {
			userPay = null;
		}

		return userPay;
	}

	/**
	 * 积分+现金支付，下发重消
	 * 
	 * @param loginName
	 * @param amout
	 * @param orderId
	 * @param payNo
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked", "static-access"})
	public CnWirteOrderBO shopPy(String loginName, double amout, String orderId, String payNo) {
		Map map = new HashMap();
		map.put("USER_ALIAS", loginName);
		map.put("MONEYONE", amout);
		map.put("PAYNO", payNo);
		map.put("ORDERNO", orderId);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_CALC_SHOP_PV, map);
		return (CnWirteOrderBO) OrclJsonTools.handeljson(result, CnWirteOrderBO.class);
	}

	/***
	 * 购物积分退还
	 * 
	 * @param money
	 *            积分值
	 * @param payNo
	 *            支付时的交易码
	 * @param orderNo
	 *            订单编号
	 * @return
	 */
	@SuppressWarnings({"unchecked", "rawtypes", "static-access"})
	public CnRenturnYgOrderBO returnIntegralPay(String userAlias, double money, String payNo, String orderNo) {
		Map map = new HashMap();
		map.put("USER_ALIAS", userAlias);
		map.put("MONEYONE", money);
		map.put("PAYNO", payNo);
		map.put("ORDERNO", orderNo);
		String result = orclService.getOrclResult(OrclSchmaNameConstants.GET_USER_SHOP_PV_RETURN, map);
		return (CnRenturnYgOrderBO) OrclJsonTools.handeljson(result, CnRenturnYgOrderBO.class);
	}
}
