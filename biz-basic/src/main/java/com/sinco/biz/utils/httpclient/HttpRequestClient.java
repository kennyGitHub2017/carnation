package com.sinco.biz.utils.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.GsonBuilder;

/**
 * HTTP请求客户端
 * 
 * @author yuanming
 * 
 * @param <T>
 */
public class HttpRequestClient<T> implements Httpclient<T> {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public T get(String remoteURL, Map<String, String> arguments, Class<T> clazz) {
		logger.debug("remote request url=" + remoteURL);
		logger.debug("argument=" + JSONObject.fromObject(arguments).toString());
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			StringBuffer remoteURLBF = new StringBuffer(remoteURL);
			if (null != arguments && arguments.size() > 0) {
				if (remoteURL.contains("?")) {
					remoteURLBF.append("&");
				} else {
					remoteURLBF.append("?");
				}
				Set<Entry<String, String>> entrySet = arguments.entrySet();
				for (Entry<String, String> entry : entrySet) {
					remoteURLBF.append(entry.getKey()).append("=")
							.append(entry.getValue()).append("&");
				}
				remoteURLBF.deleteCharAt(remoteURLBF.length() - 1);
			}
			// 根据地址获取请求
			HttpGet request = new HttpGet(remoteURLBF.toString());
			// 通过请求对象获取响应对象
			HttpResponse response = httpClient.execute(request);
			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				logger.error("remote request url=" + remoteURL);
				logger.error("argument="
						+ JSONObject.fromObject(arguments).toString());
				logger.error("remote service execute error! http status="
						+ response.getStatusLine().getStatusCode());
				throw new RuntimeException("remote service execute error!");
			}
			HttpEntity entity = response.getEntity();
			if (entity == null) {
				logger.warn("remote request url=" + remoteURL);
				logger.warn("argument="
						+ JSONObject.fromObject(arguments).toString());
				logger.warn("remote service result empty!");
				return null;
			}
			String resultJson = EntityUtils.toString(response.getEntity(),
					"UTF-8");
			if (StringUtils.isEmpty(resultJson)) {
				logger.error("remote request url=" + remoteURL);
				logger.error("argument="
						+ JSONObject.fromObject(arguments).toString());
				logger.error("remote service execute error! http status="
						+ response.getStatusLine().getStatusCode());
				return null;
			}
			logger.debug("remote result=" + resultJson);
			JSONObject jsonobj = JSONObject.fromObject(resultJson);
			JsonResult jsonResult = (JsonResult) JSONObject.toBean(jsonobj,
					JsonResult.class);
			if (!"1000".equals(jsonResult.getCode())) {
				logger.warn("remote request url=" + remoteURL);
				logger.warn("argument="
						+ JSONObject.fromObject(arguments).toString());
				logger.warn("remote service result code="
						+ jsonResult.getCode());
				throw new RuntimeException();
			}
			JSONObject resultJSONOBJ = jsonobj.getJSONObject("data");
			if (null == resultJSONOBJ) {
				logger.warn("remote request url=" + remoteURL);
				logger.warn("argument="
						+ JSONObject.fromObject(arguments).toString());
				logger.warn("remote service result empty!");
				return null;
			}
			return (T) new GsonBuilder().setPrettyPrinting()
					.disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss")
					.serializeNulls().create()
					.fromJson(resultJSONOBJ.toString(), clazz);
			// JSONObject.toBean(resultJSONOBJ, clazz);
		} catch (UnsupportedEncodingException e) {
			logger.error("", e);
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			if (null != httpResponse) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					logger.error("", e);
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (IOException e) {
					logger.error("", e);
				}
			}
		}
		return null;
	}

	public T post(String remoteURL, Map<String, String> arguments,
			Class<T> clazz) {
		logger.debug("remote request url=" + remoteURL);
		logger.debug("argument=" + JSONObject.fromObject(arguments).toString());
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(remoteURL);
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		Set<Entry<String, String>> entrySet = arguments.entrySet();
		for (Entry<String, String> entry : entrySet) {
			formparams.add(new BasicNameValuePair(entry.getKey(), entry
					.getValue()));
		}
		UrlEncodedFormEntity uefEntity;
		CloseableHttpResponse response = null;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httppost.setEntity(uefEntity);
			response = httpclient.execute(httppost);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				logger.error("remote request url=" + remoteURL);
				logger.error("argument="
						+ JSONObject.fromObject(arguments).toString());
				logger.error("remote service execute error! http status="
						+ response.getStatusLine().getStatusCode());
				throw new RuntimeException("remote service execute error!");
			}
			HttpEntity entity = response.getEntity();
			if (entity == null) {
				logger.warn("remote request url=" + remoteURL);
				logger.warn("argument="
						+ JSONObject.fromObject(arguments).toString());
				logger.warn("remote service result empty!");
				return null;
			}
			String resultJson = EntityUtils.toString(entity, "UTF-8");
			if (StringUtils.isEmpty(resultJson)) {
				logger.error("remote request url=" + remoteURL);
				logger.error("argument="
						+ JSONObject.fromObject(arguments).toString());
				logger.error("remote service execute error! http status="
						+ response.getStatusLine().getStatusCode());
				return null;
			}
			logger.debug("remote result=" + resultJson);
			JSONObject jsonobj = JSONObject.fromObject(resultJson);
			/*
			 * JsonResult jsonResult = (JsonResult) JSONObject.toBean(jsonobj,
			 * JsonResult.class); if (!"1000".equals(jsonResult.getCode())) {
			 * logger.warn("remote request url=" + remoteURL);
			 * logger.warn("argument=" +
			 * JSONObject.fromObject(arguments).toString());
			 * logger.warn("remote service result code=" +
			 * jsonResult.getCode()); throw new RuntimeException(); } JSONObject
			 * resultJSONOBJ = jsonobj.getJSONObject("result"); if (null ==
			 * resultJSONOBJ) { logger.warn("remote request url=" + remoteURL);
			 * logger.warn("argument=" +
			 * JSONObject.fromObject(arguments).toString());
			 * logger.warn("remote service result empty!"); return null; }
			 */
			return (T) new GsonBuilder().setPrettyPrinting()
					.setDateFormat("yyyy-MM-dd HH:mm:ss").create()
					.fromJson(jsonobj.toString(), clazz);

		} catch (IOException e) {
			logger.error("", e);
			throw new RuntimeException();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
				response.close();
			} catch (IOException e) {
				logger.error("", e);
			}
		}
	}

}
