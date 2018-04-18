package cn.eeepay;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.weixin.utils.MapUtil;
import com.weixin.utils.Signature;

import vc.thinker.b2b2c.http.WS;
import vc.thinker.b2b2c.pay.tenpay.util.MD5Util;

public class EeePayUtils {
	private static final String EEEPAY_GATEWAY_URL = "http://bag.eeepay.cn:9809";

	private static final String EEEPAY_API_ORDER_STATUS_FIND_URL = EEEPAY_GATEWAY_URL
			+ "/eeepayAction/find.do";
	private static final String EEEPAY_API_CREATE_ORDER_URL = EEEPAY_GATEWAY_URL
			+ "/eeepayAction/createOrder.do";

	private static final Logger log = LoggerFactory.getLogger(EeePayUtils.class);

	public static String generateMchPayNativeRequestURL(Map<String, String> payPackage, String mch_id,
			String key) {
		// Map<String, String> map = new HashMap<String, String>();
		payPackage.put("merchant_no", mch_id);

		/*
		out_trade_no外部商户网站唯一订单号
		subject订单标题
		body商品描述
		total_fee订单金额
		sign_type签名方式（必须为MD5）
		key商户密钥
		notify_url 异步通知地址（交易后系统将会将交易结果异步通知到该地址）
		merchant_no商户编号（商户密钥与商户编号都是我们给商户的）
		sign签名
		*/
		String sign = Signature.generateSign(payPackage, key);
		payPackage.put("sign", sign);
		payPackage.put("key", key);
		String url = EEEPAY_API_CREATE_ORDER_URL + "?" + MapUtil.mapJoin(payPackage, false, false);
		System.out.println(url);
		try {
			Document doc = Jsoup.connect(url).get();
			String ssuc = doc.select("success").text();
			boolean suc = false;
			if ("true".equals(ssuc))
				suc = true;
			if (suc) {
				if (doc.select("tradeno") != null) {
					return doc.select("tradeno").text();
				} else {
					return "";
				}
			} else {
				System.err.println(doc.select("msg").text());
				return "";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}

	/**
	 * 第三方支付注册商户
	 * 
	 * @param url
	 * @param vo
	 * @return
	 */
	public static EeePayRegisterResult registerEeePay(String url, EeePayRegisterVO vo) throws IOException {
		String postUrl = url + "/api/externalRegMer";

		HttpClient httpClient = HttpClientBuilder.create().build();
		// 图片 url + IMAGE_REQ
		// 音频 url + AUDIO_REQ
		// 视频 url + VIDEO_REQ
		HttpPost post = new HttpPost(postUrl);

		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();

		int index = 1;
		for (String fileUrl : vo.getFiles()) {
			// 如果需要重构代码，只需要选择支持MultipartEntity上传的类库即可，默认BianryBody名为file
			try {
				multipartEntityBuilder.addBinaryBody("file" + index, download(fileUrl),
						ContentType.APPLICATION_OCTET_STREAM, "file" + index + ".png");
				index++;
			} catch (IOException e) {
				log.error("download {} error", fileUrl);
				throw e;
			}
		}
//        vo.setRatioValue(2.0f);
//        vo.setMobile("18575541912");

		multipartEntityBuilder.addTextBody("add_type", vo.getAddType(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("appType", vo.getAppType(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder
				.addTextBody("name", vo.getName(), ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("mobile", vo.getMobile(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("password", vo.getPassword(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("sn", vo.getSn(), ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("pos_type", vo.getPosType(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("id_card_no", vo.getIdCardNo(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("bank_name", vo.getBankName(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("account_name", vo.getAccountName(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("account_no", vo.getAccountNo(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("account_province", vo.getAccountProvince(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("account_city", vo.getAccountCity(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("cnaps_no", vo.getCnapsNo(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("querstion", vo.getQuerstion(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("account_no", vo.getAccountNo(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("answer", vo.getAnswer(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("province", vo.getProvince(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder
				.addTextBody("city", vo.getCity(), ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("address", vo.getAddress(),
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("checktStatus", "QUICK",
				ContentType.create("text/xml", Consts.UTF_8));
		multipartEntityBuilder.addTextBody("ratio_value", String.valueOf(vo.getRatioValue()),
				ContentType.create("text/xml", Consts.UTF_8));
//		//测试写死
//		multipartEntityBuilder.addTextBody("ratio_value", "2",
//				ContentType.create("text/xml", Consts.UTF_8));
		// hmac值
		multipartEntityBuilder.addTextBody("HMAC", getHMACMD5(vo),
				ContentType.create("text/xml", Consts.UTF_8));

		post.setEntity(multipartEntityBuilder.build());

		// 将参数加入到请求方法中
		HttpResponse response = httpClient.execute(post);

		String body = WS.getResponseAsString(response);

		log.info("eeppay register body:{}", body);

		EeePayRegisterResult result = new EeePayRegisterResult();
		try {
			JSONObject entity = JSON.parseObject(body);
			JSONObject header = entity.getJSONObject("header");

			if (header != null) {
				result.setSucceed(header.getBooleanValue("succeed"));
				result.setErrMsg(header.getString("errMsg"));
				result.setError(header.getString("error"));
			} else {
				result.setSucceed(false);
				result.setError("调用失败");
			}
			if (result.isSucceed()) {
				JSONObject bodyJson = entity.getJSONObject("body");
				result.setSucceed(bodyJson.getBooleanValue("success"));
				result.setError(bodyJson.getString("sdkMsg"));
				result.setMerchantNo(bodyJson.getString("merchantNo"));
				result.setSdkKey(bodyJson.getString("sdk_key"));
			}
		} catch (JSONException e) {
			throw new IOException(body);
		}
		return result;
	}

	/**
	 * 获取SDK Key接口
	 * 
	 * @param url
	 * @param vo
	 * @return
	 */
	public static EeePayGetSDKKeyResult getEeePaySDKKey(String url, String agentNo, String mobile, String sn)
			throws IOException {
		StringBuffer getUrl = new StringBuffer(url);
		getUrl.append("/api/querySDKKey?");

		HttpClient httpClient = HttpClientBuilder.create().build();

		getUrl.append("agent_no=").append(agentNo);
		getUrl.append("&mobile=").append(mobile);
		getUrl.append("&sn=").append(sn);

		HttpGet get = new HttpGet(getUrl.toString());

		// 将参数加入到请求方法中
		HttpResponse response = httpClient.execute(get);

		String body = WS.getResponseAsString(response);
		log.info("eeppay get body:{}", body);

		EeePayGetSDKKeyResult result = new EeePayGetSDKKeyResult();
		try {
			JSONObject entity = JSON.parseObject(body);
			JSONObject header = entity.getJSONObject("header");
			if (header != null) {
				result.setSucceed(header.getBooleanValue("succeed"));
				result.setErrMsg(header.getString("errMsg"));
				result.setError(header.getString("error"));
			} else {
				result.setSucceed(false);
				result.setError("调用失败");
			}
			if (result.isSucceed()) {
				JSONObject bodyJson = entity.getJSONObject("body");
				result.setSucceed(bodyJson.getBooleanValue("success"));
				result.setError(bodyJson.getString("sdkMsg"));
				result.setMerchantNo(bodyJson.getString("merchant_no"));
				result.setSdkKey(bodyJson.getString("sdk_key"));
			}
		} catch (JSONException e) {
			throw new IOException(body);
		}
		return result;
	}

	private static String getHMACMD5(EeePayRegisterVO vo) {
		String prefix = "API";
		String account_no = vo.getAccountNo();
		String id_card_no = vo.getIdCardNo();
		String mobile = vo.getMobile();
		String sn = vo.getSn();
		String suffix = "MERADD";
		StringBuffer sb = new StringBuffer(prefix);
		sb.append("account_no").append(account_no);
		sb.append("id_card_no").append(id_card_no);
		sb.append("mobile").append(mobile);
		sb.append("sn").append(sn);
		sb.append("suffix").append(suffix);
		// MD5两次计算
		return MD5Util.MD5Encode(MD5Util.MD5Encode(sb.toString(), "utf-8"), "utf-8");
	}

	public static InputStream download(String urlString) throws IOException {
		// 构造URL
		URL url = new URL(urlString);
		// 打开连接
		URLConnection con = url.openConnection();
		// 设置请求超时为5s
		con.setConnectTimeout(5 * 1000);
		// 输入流
		InputStream is = con.getInputStream();
		return is;
	}

	public static String validateCallbackNotify(String tradeNo, double totalfee) {
		String url = EEEPAY_API_ORDER_STATUS_FIND_URL + "?trade_no=" + tradeNo;
		HttpResponse response = WS.url(url).get();
		String body = WS.getResponseAsString(response);
		JSONObject validateEntity = JSON.parseObject(body);
		if (validateEntity.getBooleanValue("success")) {
			JSONObject trade = validateEntity.getJSONObject("trade");
			double mount = trade.getDoubleValue("totalFee");
			return totalfee == mount ? trade.getString("outTradeNo") : "";
		} else {
			return "";
		}

	}

	public static void main(String[] args) throws IOException {
//		Map<String,String> payPackage = Maps.newHashMap();
//		payPackage.put("out_trade_no", "P_" + new Date().getTime());
//		payPackage.put("subject","测试订单2");
//		payPackage.put("body", "12343");
//		payPackage.put("total_fee", "0.04");
//		payPackage.put("sign_type","MD5");
//		payPackage.put("notify_url","http://thinkervc.imwork.net:44011/eeepay_notify.htm");
//		String tradeno = EeePayUtils.generateMchPayNativeRequestURL(payPackage, "255410000256155", "EEEPAY888144116081363145537");
//		System.out.println(tradeno);

		EeePayRegisterVO vo = new EeePayRegisterVO();
		vo.setAppType(EeePayConstants.APP_TYPE_24);
		vo.setPosType(EeePayConstants.POS_TYPE_5);
		vo.setName("广州市云尚美容院");
		vo.setMobile("18718804041");
		vo.setPassword("111111");
		vo.setSn("CA03669155407023");
		vo.setIdCardNo("440881199101133824");
		vo.setBankName("招商银行深圳爱华支行");
		vo.setAccountName("邓皓轩");
		vo.setAccountNo("755916657123123610901");
		vo.setRatioValue(2);
		vo.setAccountProvince("广东");
		vo.setAccountCity("深圳市");
		vo.setCnapsNo("123456");
		vo.setQuerstion("云尚");
		vo.setAnswer("云尚");
		vo.setProvince("广东");
		vo.setCity("广州市");
		vo.setAddress("科兴科学园");
		List<String> files = Lists.newArrayList();
		files.add("http://i1.hexunimg.cn/2015-10-25/180079855.jpg");
		files.add("http://i1.hexunimg.cn/2015-10-25/180079855.jpg");
		files.add("http://i1.hexunimg.cn/2015-10-25/180079855.jpg");
		files.add("http://i1.hexunimg.cn/2015-10-25/180079855.jpg");
		files.add("http://i1.hexunimg.cn/2015-10-25/180079855.jpg");
		files.add("http://i1.hexunimg.cn/2015-10-25/180079855.jpg");
		files.add("http://i1.hexunimg.cn/2015-10-25/180079855.jpg");
		files.add("http://i1.hexunimg.cn/2015-10-25/180079855.jpg");
		files.add("http://i1.hexunimg.cn/2015-10-25/180079855.jpg");
		vo.setFiles(files);

		EeePayGetSDKKeyResult getSDKKeyResult = EeePayUtils.getEeePaySDKKey("http://120.237.91.166:4567",
				"4028", vo.getMobile(), vo.getSn());
		System.out.println(getSDKKeyResult);
		EeePayRegisterResult result = EeePayUtils.registerEeePay("http://120.237.91.166:4567", vo);
		System.out.println(result);

	}

	public static Map<String, String> getQueryMap(String query) {
		String[] params = query.split("&");
		Map<String, String> map = new HashMap<String, String>();
		for (String param : params) {
			if (param.indexOf("=") > 0) {
				String name = param.split("=")[0];
				String value = param.split("=")[1];
				map.put(name, value);
			}
		}
		return map;
	}

}
