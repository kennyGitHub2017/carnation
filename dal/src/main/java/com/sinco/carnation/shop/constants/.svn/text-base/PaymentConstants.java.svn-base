package com.sinco.carnation.shop.constants;

public class PaymentConstants {
	/**
	 * 支付方式标识代码,alipay为支付宝，alipayB 网银支付,alipayC 信用卡支付 alipay_wap为支付宝手机网页支付， alipay_app为支付宝APP版，99bill为快钱，
	 * tenpay为财付通,balance为预存款，payafter为货到付款(V2.0版本增加商品是否支持货到付款属性，取消该付款方式)，
	 * outline为线下支付(已经取消该付款方式，只接受在线付款、货到付款、预存款付款) wx_app为手机端微信支付 wx_pay为手机端微信支付 wxqrpay 微信扫码支付
	 */
	public static final String PAYMENT_MARK_ALIPAY = "alipay";
	public static final String PAYMENT_MARK_ALIPAYB = "alipayB";
	public static final String PAYMENT_MARK_ALIPAYC = "alipayC";
	public static final String PAYMENT_MARK_ALIPAY_WAP = "alipay_wap";
	public static final String PAYMENT_MARK_ALIPAY_APP = "alipay_app";
	public static final String PAYMENT_MARK_99BILL = "99bill";
	public static final String PAYMENT_MARK_TENPAY = "tenpay";
	public static final String PAYMENT_MARK_BALANCE = "balance";
	public static final String PAYMENT_MARK_OUTLINE = "outline";
	public static final String PAYMENT_MARK_PAYAFTER = "payafter";
	public static final String PAYMENT_MARK_WX_APP = "wx_app";
	public static final String PAYMENT_MARK_WX_PAY = "wx_pay";
	public static final String PAYMENT_MARK_WX_QR_PAY = "wxqrpay";
	public static final String PAYMENT_MARK_YG_MONEY = "yungoumoney";
	public static final String PAYMENT_MARK_BONUS = "bonus";

	/**
	 * 云购币+工资
	 */
	public static final String PAYMENT_MARK_YG_JJ = "yg_jj";

	/**
	 * 云购币+充值
	 */
	public static final String PAYMENT_MARK_YG_CZ = "yg_cz";

	/**
	 * 云购币+微信
	 */
	public static final String PAYMENT_MARK_YG_WX = "yg_wxqrpay";

	/**
	 * 云购币+支付宝
	 */
	public static final String PAYMENT_MARK_YG_AL = "yg_alipay";

	public static final String PAYMENT_MARK_MCH_WX_QR_PAY = "mch_wxqrpay";

	/***
	 * 云购币 + 云豆
	 */
	public static final String PAYMENT_MARK_YG_BALANCE = "yg_balance";
	public static final String PAYMENT_MARK_YG_JSWX = "yg_jswx";

	/**
	 * 充值需要处理的订单的类型: 商品: goods 积分商品:integral 云豆充值：cash 服务订单类型：group
	 */
	public final static String ORDER_TYPE_GOODS = "goods";
	public final static String ORDER_TYPE_INTEGRAL = "integral";
	public final static String ORDER_TYPE_GROUP = "group";
	public final static String ORDER_TYPE_GOLD = "gold";
	public final static String ORDER_TYPE_CASH = "cash";
	
	public static final String PAYMENT_MARK_JF_JJ = "jf_jj";
	public static final String PAYMENT_MARK_JF_CZ = "jf_cz";
	public static final String PAYMENT_MARK_JF_WX = "jf_wxqrpay";
	public static final String PAYMENT_MARK_JF_AL = "jf_alipay";
	
	public static final String PAYMENT_MARK_PTJF_AL = "ptjf_alipay";//平台积分+支付宝
	public static final String PAYMENT_MARK_PTJF_WX = "ptjf_wxqrpay";//平台积分+微信
	public static final String PAYMENT_MARK_PTJF_BL = "ptjf_balance";//平台积分+云豆

	
	

	/**
	 * 得到支付方式名称
	 * 
	 * @param mark
	 * @return
	 */
	public static String getPaymentName(String mark) {
		if (mark == null) {
			return "";
		}

		switch (mark) {
			case PAYMENT_MARK_MCH_WX_QR_PAY:
				return "商家微信扫码支付";
			case PAYMENT_MARK_WX_QR_PAY:
				return "微信扫码支付";
			case PAYMENT_MARK_WX_PAY:
				return "网页微信支付";
			case PAYMENT_MARK_WX_APP:
				return "微信APP支付";
			case PAYMENT_MARK_ALIPAY:
				return "支付宝";
			case PAYMENT_MARK_ALIPAYB:
				return "网银支付";
			case PAYMENT_MARK_ALIPAYC:
				return "信用卡支付";
			case PAYMENT_MARK_ALIPAY_WAP:
				return "手机网页支付宝";
			case PAYMENT_MARK_ALIPAY_APP:
				return "手机支付宝APP";
			case PAYMENT_MARK_BALANCE:
				return "云豆支付";
			case PAYMENT_MARK_YG_MONEY:
				return "重消支付";

			case PAYMENT_MARK_YG_JJ:
				return "重消+工资账户支付";
			case PAYMENT_MARK_YG_CZ:
				return "重消+充值账户支付";
			case PAYMENT_MARK_YG_WX:
				return "重消+微信";
			case PAYMENT_MARK_YG_AL:
				return "重消+支付宝";
			case PAYMENT_MARK_YG_BALANCE:
				return "重消+云豆";
			case  PAYMENT_MARK_YG_JSWX:
				return "重消+微信";
			case PAYMENT_MARK_JF_JJ:
				return "购物积分+奖金";
			case PAYMENT_MARK_JF_CZ:
				return "购物积分+充值";
			case PAYMENT_MARK_JF_WX:
				return "购物积分+微信";
			case PAYMENT_MARK_JF_AL:
				return "购物积分+支付宝";
			case PAYMENT_MARK_PTJF_AL:
				return "积分+支付宝";
			case PAYMENT_MARK_PTJF_WX:
				return "积分+微信";
			case PAYMENT_MARK_PTJF_BL:
				return "积分+云豆";
			default:
				return "";
		}
	}
}
