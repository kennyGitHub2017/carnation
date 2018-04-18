package com.varicom.resource;

import org.junit.Test;

import com.sinco.api.sdk.SDKResourceIOSGenerator;

public class TestIOSSDK {

	SDKResourceIOSGenerator generator = new SDKResourceIOSGenerator(
			new String[] {"com.sinco.carnation.resource.bo"},
			new String[] {"com.sinco.carnation.resource.web.actions"}, "account", "F:/Code/API/IOS",
			"http://api.jgclub.cn");

	// api.jgclub.cn
	@Test
	public void generatorDomain() throws Exception {
		generator.generatorSDKDomain();
		generator.generatorSDKRequest();
		generator.generatorSDKResponse();
	}

}
