package com.sinco.api.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class JerseyClientFactory {

	private final ClientConfig cc = new DefaultClientConfig();

	private Integer readTimeout;

	private Integer connectTimeout;

	/**
	 * 创建JerseyClient
	 */
	public WebResource createClient(String baseUrl) {

		// 15秒
		cc.getProperties().put(ClientConfig.PROPERTY_READ_TIMEOUT, readTimeout);

		// 3秒
		cc.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, connectTimeout);

		Client jerseyClient = Client.create(cc);

		return jerseyClient.resource(baseUrl);
	}

	/**
	 * 创建JerseyClient
	 */
	public WebResource createClient(String baseUrl, Integer readTimeout, Integer connectTimeout) {

		// 15秒
		cc.getProperties().put(ClientConfig.PROPERTY_READ_TIMEOUT, readTimeout);

		// 3秒
		cc.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, connectTimeout);

		Client jerseyClient = Client.create(cc);

		return jerseyClient.resource(baseUrl);
	}

	public Integer getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(Integer readTimeout) {
		this.readTimeout = readTimeout;
	}

	public Integer getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(Integer connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

}
