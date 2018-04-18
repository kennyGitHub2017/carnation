package com.sinco.carnation.goods.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vc.thinker.b2b2c.core.tools.Md5Encrypt;
import vc.thinker.b2b2c.pay.alipay.util.UtilDate;

import com.sinco.carnation.goods.dao.GoodsDao;
import com.sinco.carnation.goods.model.Goods;

import edu.emory.mathcs.backport.java.util.Arrays;

/***
 * 根据淘宝链接添加商品
 * 
 * @author kenny
 * 
 * 
 */
@Service
public class GoodsTaoBaoService {

	@Autowired
	private GoodsDao goodsDao;

	private static final String appSecret = "c4777d35e80dcd24186d576f0a81f68b";

	private static final String appKey = "23425455";

	private static final String appMethod = "taobao.item.seller.get";

	private static final String requestUrl = "http://gw.api.taobao.com/router/rest";

	private static final String testPid = "536018838516";

	private static final String fields = "product_id";

	/***
	 * 
	 对所有API请求参数（包括公共参数和业务参数，但除去sign参数和byte[]类型的参数），根据参数名称的ASCII码表的顺序排序。 如：foo=1, bar=2, foo_bar=3,
	 * foobar=4排序后的顺序是bar=2, foo=1, foo_bar=3, foobar=4。
	 * 将排序好的参数名和参数值拼装在一起，根据上面的示例得到的结果为：bar2foo1foo_bar3foobar4。
	 * 把拼装好的字符串采用utf-8编码，使用签名算法对编码后的字节流进行摘要。如果使用MD5算法，则需要在拼装的字符串前后加上app的secret后，再进行摘要，
	 * 如：md5(secret+bar2foo1foo_bar3foobar4+secret)；如果使用HMAC_MD5算法，则需要用app的secret初始化摘要算法后，再进行摘要，
	 * 如：hmac_md5(bar2foo1foo_bar3foobar4)。 将摘要得到的字节流结果使用十六进制表示，如：hex(“helloworld”.getBytes(“utf-8”)) =
	 * “68656C6C6F776F726C64”
	 * 
	 * 
	 * 
	 */
	@SuppressWarnings("unused")
	private void test() {
		Map<String, String> map = this.commonParam();
		String param = this.sortParam(map);
		System.out.println("参数排除无sign->" + param);

		// 得到sing秘钥-md5(secret+bar2foo1foo_bar3foobar4+secret)
		String paramSecret = appSecret + param + appSecret;
		System.out.println("生成秘钥的参数->" + paramSecret);
		String resSign = this.getSign(paramSecret);
		System.out.println("秘钥" + resSign);

		// 请求拼装参数-app_key=23425455&fields=product_id
		String param2 = this.sortParam2(map);
		String params = param2 + "sign=" + resSign;
		System.out.println(params);

		// 发送请求
		String res = this.sendHttpPost(params);
		System.out.println(res);
	}

	// post 发送请求
	public String sendHttpPost(String param) {
		param = "http://container.open.taobao.com/container?appkey=23425455";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String result = null;
		HttpPost httpPost = new HttpPost(requestUrl);
		StringEntity postEntity = new StringEntity(param, "UTF-8");
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		httpPost.setEntity(postEntity);
		try {

			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();

			if (response.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(entity, "UTF-8");
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	/***
	 * 公共参 公共参数组装Map,除sign外
	 * 
	 * @return
	 */
	public Map<String, String> commonParam() {
		Map<String, String> map = new HashMap<String, String>();
		// 公共参数
		map.put("method", appMethod);
		map.put("app_key", appKey);
		map.put("timestamp", UtilDate.getDateFormatter());
		map.put("v", "2.0");
		map.put("sign_method", "md5");

		// 业务参数
		map.put("fields", fields);
		map.put("product_id", testPid);
		return map;
	}

	/***
	 * 讲参数拼装成 字符串
	 * 
	 * 例如 ： bar2foo1foo_bar3foobar4
	 * 
	 * @param params
	 * @return
	 */
	public String sortParam(Map<String, String> params) {
		String[] keys = params.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		StringBuilder strBuilder = new StringBuilder();
		for (String key : keys) {
			String thisValue = params.get(key);
			strBuilder.append(key).append(thisValue);
		}
		return strBuilder.toString();
	}

	/***
	 * 讲参数拼装成 字符串2
	 * 
	 * 例如：app_key=23425455&fields=product_id&method=taobao.product.get
	 * 
	 * @param params
	 * @return
	 */
	public String sortParam2(Map<String, String> params) {
		String[] keys = params.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		StringBuilder strBuilder2 = new StringBuilder();
		for (String key : keys) {
			String thisValue = params.get(key);
			strBuilder2.append(key).append("=").append(thisValue).append("&");
		}
		return strBuilder2.toString();
	}

	/***
	 * 公共参数拼接完成
	 * 
	 * @param param
	 * @return
	 */
	public String getSign(String param) {
		// 参数加密,转16进制
		String sign = Md5Encrypt.md5(param);
		return sign;
	}

	/*public static void main(String[] args) {
		GoodsTaoBaoService sc = new GoodsTaoBaoService();
		sc.sendHttpPost("");
		
		
		TaobaoClient client = new DefaultTaobaoClient(requestUrl, appKey, appSecret);
		System.out.println(client);
		ProductGetRequest req = new ProductGetRequest();
		req.setFields("product_id,outer_id");
		req.setProductId("86126527L");
		req.setCid("50012286L");
		req.setProps("10005:10027;10006:29729");
		req.setCustomerProps("20000:优衣库:型号:001:632501:1234");
		req.setMarketId("2");
		 
		//TaobaoRequest<ProductGetResponse> rsp = client.execute(req);
		//System.out.println(rsp.getBody());
		
		

	      String url="https://oauth.taobao.com/token";
	      Map<String,String> props=new HashMap<String,String>();
	      
	      props.put("grant_type","authorization_code");
	      测试时，需把test参数换成自己应用对应的值
	      props.put("code","code");
	      
	      props.put("client_id",appKey);
	      props.put("client_secret",appSecret);
	      
	      props.put("redirect_uri","http://locaohost");
	      props.put("view","web");
	      String s="";
	      try{s=WebUtils.doPost(url, props, 30000, 30000);
	      System.out.println(s);
	      }catch(IOException e){
	          e.printStackTrace();
	          
	      }*/

	/*
	}*/

	public static void main1() {
		String url = "https://detail.tmall.com/item.htm?spm=a223v.7914393.2320796782.2.DWctFW?&id=536018838516"
				+ "&abbucket=_AB-M972_B7&acm=03683.1003.1.670563"
				+ "&aldid=36NCdwsN&abtest=_AB-LR972-PR972&scm=1003.1.03683.ITEM_536018838516_670563&pos=2";

		Pattern pattern = Pattern.compile("[?|&]id=(\\d+)&");
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			String productId = matcher.group(1);
			System.out.println(productId);
		}

	}

	/**
	 * 添加产品头信息
	 * 
	 */
	public void insertGoodsInfo() {
		Goods record = new Goods();
		record.setAddTime(new Date());
		// record.setActivityGoodsId();// 活动商品id

		// record.setActivityStatus(activityStatus);//** 活动状态 0为无活动，1为待审核，2为审核通过，3为活动商品已经卖完 **/
		// record.setAdvanceDate(advanceDate);// /** 预售时间 **/
		// record.setAdvanceSaleType(advanceSaleType);// /** 是否为预售商品 **/
		// record.setBadEvaluate(badEvaluate);///** 商品差评率 **/
		// record.setBuyGiftAmount(buyGiftAmount);///** 满就送条件金额 **/
		// record.setBuyGiftId(buyGiftId);///** 满就送id **/
		// record.setCombinPartsId(combinPartsId);// /** 组合配件方案id **/
		// record.setCombinStatus(combinStatus);// /** 组合销售商品 0为无组合销售，1为有组合销售，当该商品参加组合销售时
		// record.setCombinSuitId(combinSuitId);///** 组合套装方案id **/
		// record.setDeleteStatus(deleteStatus);//删除状态
		// record.setDeliveryArea(deliveryArea);// /** 发货地址 **/
		// record.setDeliveryAreaId(deliveryAreaId);// /** 发货地址idf **/
		// record.setDescriptionEvaluate(descriptionEvaluate);///** 商品描述评分 **/
		// record.setEmsTransFee(emsTransFee);// /** ems费用 **/
		// record.setEnoughReduce(enoughReduce);///** 是否参加满就减 **/
		// record.setEvaluateCount(evaluateCount);///** 评论数 **/

		this.goodsDao.save(record);
	}

}
