package com.varicom.resource;

import org.junit.Test;

import com.sinco.api.sdk.SDKResourceAndroidGenerator;

public class TestAndroidSDK {

	SDKResourceAndroidGenerator generator = new SDKResourceAndroidGenerator(
			new String[] {"com.sinco.carnation.resource.bo"},
			new String[] {"com.sinco.carnation.resource.web.actions"}, "account", "F:/Code/API/android/src");

	// http://api.jgclub.cn
	// http://192.168.1.104:8089||||http://api.ysysgo.com

	@Test
	public void generatorDomain() throws Exception {
		generator.generatorSDKDomain();
		generator.generatorSDKRequest();
		generator.generatorSDKResponse();
	}

}
