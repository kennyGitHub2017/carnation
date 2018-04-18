package vc.thinker.b2b2c.foundation.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class kuaidi100 {

	public static void main(String[] agrs) {

		System.err.println(getOrderExpressByApi("803990371143", "yuantong"));

//		try {
//			String str = "http://api.kuaidi100.com/api?id=c662ed6131ea48ad&com=yuantong&nu=803990371143&show=0&muti=1&order=desc";
////			String str = "http://api.kuaidi100.com/api?id=4c68365adbe58d72&com=shunfeng&nu=024389982053&show=0&muti=1&order=desc";
//			URL url = new URL(str);
//			URLConnection con = url.openConnection();
//			con.setAllowUserInteraction(false);
//			InputStream urlStream = url.openStream();
//			String type = con.guessContentTypeFromStream(urlStream);
//			String charSet = null;
//			if (type == null)
//				type = con.getContentType();
//
//			if (type == null || type.trim().length() == 0
//					|| type.trim().indexOf("text/html") < 0)
//				return;
//
//			if (type.indexOf("charset=") > 0)
//				charSet = type.substring(type.indexOf("charset=") + 8);
//			System.out.println(charSet);
//			byte b[] = new byte[10000];
//			int numRead = urlStream.read(b);
//			String content = new String(b, 0, numRead,charSet);
//			while (numRead != -1) {
//				numRead = urlStream.read(b);
//				if (numRead != -1) {
//					// String newContent = new String(b, 0, numRead);
//					String newContent = new String(b, 0, numRead, charSet);
//					content += newContent;
//				}
//			}
//			System.out.println("content:" + content);
//			urlStream.close();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@SuppressWarnings("static-access")
	public static String getOrderExpressByApi(String oid, String code) {
		try {
			URL url = new URL("http://api.kuaidi100.com/api?id=c662ed6131ea48ad&com=" + code + "&nu=" + oid
					+ "&show=2&muti=1&order=desc");
			URLConnection con = url.openConnection();
			con.setAllowUserInteraction(false);
			InputStream urlStream = url.openStream();
			String type = con.guessContentTypeFromStream(urlStream);
			String charSet = null;
			if (type == null)
				type = con.getContentType();

			if (type == null || type.trim().length() == 0 || type.trim().indexOf("text/html") < 0)
				return "";

			if (type.indexOf("charset=") > 0)
				charSet = type.substring(type.indexOf("charset=") + 8);

			byte b[] = new byte[10000];
			int numRead = urlStream.read(b);
			String content = new String(b, 0, numRead);
			while (numRead != -1) {
				numRead = urlStream.read(b);
				if (numRead != -1) {
					// String newContent = new String(b, 0, numRead);
					String newContent = new String(b, 0, numRead, charSet);
					content += newContent;
				}
			}
//			   System.out.println("content:" + content);
			urlStream.close();

			return content;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getOrderExpress(String oid, String code) {
		if (null != oid && !code.isEmpty()) {
			/**
			 * 目前由于后台导入数据中缺失shipping_type,暂时先根据物流公司名称进行判断 根据物流方式和物流单号，在快递100中进行查询
			 */
			if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(oid)) {
				String url = "http://m.kuaidi100.com/query?type=" + code + "&postid=" + oid;
				try {
					Document doc = Jsoup
							.connect(url)
							.userAgent(
									"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:37.0) Gecko/20100101 Firefox/37.0")
							.timeout(3000).get();
					Elements elements = doc.select("body");
					if (null != elements && !elements.isEmpty() && StringUtils.isNotBlank(elements.text())) {
						JSONObject json = JSON.parseObject(elements.text());
						if (StringUtils.isNotBlank(json.getString("status"))) {
							return elements.text();
						}
					}
				} catch (Exception e) {
					// logger.error("根据物流单号去http://m.kuaidi100.com查询物流信息出错：", e);
				}
			}
		}
		JSONObject express = new JSONObject();
		express.put("status", "500");
		express.put("message", "暂时无法查询快递记录");
		return express.toJSONString();
	}

}
