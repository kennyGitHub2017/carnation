package com.weixin.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * @author louiseliu
 * 
 */
public class HttpsRequest {

	// 表示请求器是否已经做了初始化工作
	private boolean hasInit = false;

	// 连接超时时间，默认10秒
	private int socketTimeout = 10000;

	// 传输超时时间，默认30秒
	private int connectTimeout = 30000;

	// 请求器的配置
	private RequestConfig requestConfig;

	// HTTP请求器
	private CloseableHttpClient httpClient;

	public HttpsRequest(String mch_id) throws UnrecoverableKeyException, KeyManagementException,
			NoSuchAlgorithmException, KeyStoreException, IOException {
		init(mch_id);
	}

	private void init(String mch_id) throws IOException, KeyStoreException, UnrecoverableKeyException,
			NoSuchAlgorithmException, KeyManagementException {

		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		Resource resource = new ClassPathResource(Configure.getCertLocalPath());
		if (resource.exists()) {
			InputStream instream = resource.getInputStream();
			try {
				keyStore.load(instream, mch_id.toCharArray());// 设置证书密码
			} catch (CertificateException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} finally {
				instream.close();
			}
		}

		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mch_id.toCharArray()).build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] {"TLSv1"},
				null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

		httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

		requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout)
				.setConnectTimeout(connectTimeout).build();

		hasInit = true;
	}

	/**
	 * 通过Https往API post xml数据
	 * 
	 * @param url
	 *            API地址
	 * @param xmlObj
	 *            要提交的XML数据对象
	 * @return API回包的实际数据
	 * @throws IOException
	 * @throws KeyStoreException
	 * @throws UnrecoverableKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */

	public String sendPost(String url, String postDataXML, String mch_id) throws IOException,
			KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

		if (!hasInit) {
			init(mch_id);
		}

		String result = null;

		HttpPost httpPost = new HttpPost(url);

		StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(postEntity);

		httpPost.setConfig(requestConfig);

		try {
			HttpResponse response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();

			result = EntityUtils.toString(entity, "UTF-8");

		} catch (ConnectionPoolTimeoutException e) {
			// logger.info("http get throw ConnectionPoolTimeoutException(wait time out)");

		} catch (ConnectTimeoutException e) {
			// logger.info("http get throw ConnectTimeoutException");

		} catch (SocketTimeoutException e) {
			// logger.info("http get throw SocketTimeoutException");

		} catch (Exception e) {
			// logger.info("http get throw Exception");

		} finally {
			httpPost.abort();
		}

		return result;
	}

	public static String sendPost(String url, String postDataXML) throws IOException, KeyStoreException,
			UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException {

		String result = null;

		HttpPost httpPost = new HttpPost(url);

		StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(postEntity);

		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(30000)
				.build();
		httpPost.setConfig(requestConfig);

		try {
			CloseableHttpClient httpClient = HttpClients.custom().build();
			HttpResponse response = httpClient.execute(httpPost);

			HttpEntity entity = response.getEntity();

			result = EntityUtils.toString(entity, "UTF-8");

		} catch (ConnectionPoolTimeoutException e) {
			// logger.info("http get throw ConnectionPoolTimeoutException(wait time out)");

		} catch (ConnectTimeoutException e) {
			// logger.info("http get throw ConnectTimeoutException");

		} catch (SocketTimeoutException e) {
			// logger.info("http get throw SocketTimeoutException");

		} catch (Exception e) {
			// logger.info("http get throw Exception");

		} finally {
			httpPost.abort();
		}

		return result;
	}
	
	public static String getSessionid(String url){
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpClient httpClient = HttpClients.custom().build();
		try {
			HttpResponse response = httpClient.execute(httpGet);
			Header header = response.getFirstHeader("Set-Cookie");
			if(header != null){
				String value = CommUtil.null2String(header.getValue());
				String[] cookies = value.split(";");
				if(cookies.length > 0){
					for(String cookie : cookies){
						String[] ck = cookie.split("=");
						if("sessionid".equals(ck[0]) && ck.length == 2){
							return ck[1];
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public static String get(String url){
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpClient httpClient = HttpClients.custom().build();
		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * 设置连接超时时间
	 * 
	 * @param socketTimeout
	 *            连接时长，默认10秒
	 */
	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
		resetRequestConfig();
	}

	/**
	 * 设置传输超时时间
	 * 
	 * @param connectTimeout
	 *            传输时长，默认30秒
	 */
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
		resetRequestConfig();
	}

	private void resetRequestConfig() {
		requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout)
				.setConnectTimeout(connectTimeout).build();
	}

	/**
	 * 允许商户自己做更高级更复杂的请求器配置
	 * 
	 * @param requestConfig
	 *            设置HttpsRequest的请求器配置
	 */
	public void setRequestConfig(RequestConfig requestConfig) {
		this.requestConfig = requestConfig;
	}
}
