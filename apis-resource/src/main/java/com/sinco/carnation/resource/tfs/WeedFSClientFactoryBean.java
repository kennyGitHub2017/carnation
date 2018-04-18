package com.sinco.carnation.resource.tfs;

import net.weedfs.client.WeedFSClient;

import org.springframework.beans.factory.FactoryBean;

public class WeedFSClientFactoryBean implements FactoryBean<WeedFSClient> {

	private String host;

	private String port;

	public WeedFSClient getObject() throws Exception {
		return new WeedFSClient(host, port);
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public Class<?> getObjectType() {
		return WeedFSClient.class;
	}

	public boolean isSingleton() {
		return true;
	}
}
