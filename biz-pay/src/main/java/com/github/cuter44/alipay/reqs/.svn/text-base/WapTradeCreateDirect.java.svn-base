package com.github.cuter44.alipay.reqs;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.github.cuter44.alipay.AlipayException;
import com.github.cuter44.alipay.resps.WapTradeCreateDirectResponse;

public class WapTradeCreateDirect extends WapRequestBase {
	// CONSTANTS
	public static final List<String> KEYS_PARAM_NAME = Arrays.asList("_input_charset", "anti_phishing_key",
			"body", "buyer_account_name", "buyer_email", "buyer_id", "default_login", "enable_paymethod",
			"err_notify_uri", "extend_param", "exter_invoke_ip", "extra_common_param", "it_b_pay",
			"item_order_info", "need_ctu_check", "notify_url", "out_trade_no", "partner", "payment_type",
			"paymethod", "price", "product_type", "qr_pay_mode", "quantity", "return_url",
			"royalty_parameters", "royalty_type", "seller_account_name", "seller_email", "seller_id",
			"service", "show_url", "sign_id_ext", "subject", "token", "total_fee");

	public static final List<String> TAGNAMES_REQ_DATA = Arrays.asList("call_back_url", "merchant_url",
			"notify_url", "out_trade_no", "pay_expire", "seller_account_name", "subject", "total_fee");
	public static final String TAGNAME_REQ_DATA_ROOT = "direct_trade_create_req";

	// CONSTRUCT
	public WapTradeCreateDirect(Properties prop) {
		super(prop);
		this.setProperty("service", "alipay.wap.create.direct.pay.by.user");
		/*.setProperty("format" , "xml")
		.setProperty("v"      , "2.0");*/
	}

	// BUILD
	@Override
	public WapTradeCreateDirect build() {
		this.buildReqData(TAGNAMES_REQ_DATA, TAGNAME_REQ_DATA_ROOT);
		return (this);
	}

	// SIGN
	@Override
	public WapTradeCreateDirect sign() throws UnsupportedEncodingException, IllegalStateException {
		this.sign(KEYS_PARAM_NAME);
		return (this);
	}

	// TO_URL
	@Override
	public String toURL() throws UnsupportedEncodingException {
		return (this.toSignedURL(KEYS_PARAM_NAME, "utf-8"));
	}

	// EXECUTE
	@Override
	public WapTradeCreateDirectResponse execute() throws AlipayException {
		return (new WapTradeCreateDirectResponse(super.execute()));
	}
}
