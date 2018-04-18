package vc.thinker.b2b2c.core.security.token;

import java.io.IOException;
import java.util.Properties;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.UniformInterfaceException;

public class TokenAuthenticationUtils {
	private final static Logger log = LoggerFactory.getLogger(TokenAuthenticationUtils.class);
	private static JerseyClientFactory clientFactory = new JerseyClientFactory();
	private static String authorizationServerUrl = "http://192.168.1.209:8080/v1/tokeninfo";
	private static String key = "3d512f70-d6ce-4d43-bd9e-5559a1cdc5d5";
	private static String secret = "fc0cc545-8e8d-463b-8fb6-7f8db51e9d79";
	private static String authorizationValue;
	private final static ObjectMapper mapper = new ObjectMapperProvider().getContext(ObjectMapper.class);

	static {
		Resource resource = new ClassPathResource("application.properties");
		Properties properties = new Properties();
		try {
			properties.load(resource.getInputStream());
			authorizationServerUrl = String.valueOf(properties.get("auth.authorizationServerUrl"));
			key = String.valueOf(properties.get("auht.key"));
			secret = String.valueOf(properties.get("auth.secret"));
			authorizationValue = "Basic ".concat(new String(Base64.encodeBase64(key.concat(":")
					.concat(secret).getBytes())));
		} catch (Exception e) {
			log.error("init application.properties error.", e);
		}
	}

	public static void main(String args[]) {
		System.out.println(TokenAuthenticationUtils.authenticate("818cc804-2fae-4b2b-a7c4-af477c67f84f"));
	}

	public static String authenticate(String authToken) {
		if (StringUtils.isBlank(authToken)) {
			throw new RuntimeException();
		}
		try {
			String json = clientFactory
					.createClient(String.format(authorizationServerUrl.concat("?access_token=%s"), authToken))
					.header("Authorization", authorizationValue).accept("application/json").get(String.class);
			VerifyTokenResponse tokenResponse = mapper.readValue(json, VerifyTokenResponse.class);
			if (tokenResponse.getPrincipal() == null) {
				log.error("[authorized] accesstoken is error,authToken=" + authToken
						+ ",authorization server url:" + authorizationServerUrl);
				throw new RuntimeException("[authorized] toke is error.");
			}
			JSONObject jsonObject = JSONObject.fromObject(json);
			String uid = jsonObject.getJSONObject("principal").getJSONObject("attributes").getString("uid");
			return uid;
		} catch (UniformInterfaceException e) {
			log.error("[authorized] accesstoken is error,authToken=" + authToken
					+ ",authorization server url:" + authorizationServerUrl);
			throw new RuntimeException("[authorized] toke is error.");
		} catch (IOException e) {
			log.error("[authorized] toke is error.", e);
			throw new RuntimeException("[authorized] toke is error.");
		}
	}

	public JerseyClientFactory getClientFactory() {
		return clientFactory;
	}

	@SuppressWarnings("static-access")
	public void setClientFactory(JerseyClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
}