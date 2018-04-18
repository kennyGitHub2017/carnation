package vc.thinker.b2b2c.security;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import vc.thinker.b2b2c.core.security.token.JerseyClientFactory;
import vc.thinker.b2b2c.core.security.token.ObjectMapperProvider;
import vc.thinker.b2b2c.core.security.token.VerifyTokenResponse;
import vc.thinker.b2b2c.exception.AuthTokenException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * 
 * token 的管理类
 * 
 * 用于验证token
 * 
 * @author dengwei
 * @date 2014年6月17日 上午10:31:28
 * 
 */
public class TokenAuthenticationManager implements AuthenticationManager {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private JerseyClientFactory clientFactory;

	private String authorizationServerUrl;

	private String authorizationValue;

	private ObjectMapper mapper = new ObjectMapperProvider().getContext(ObjectMapper.class);

	public TokenAuthenticationManager(String authorizationServerUrl, String key, String secret) {
		this.authorizationServerUrl = authorizationServerUrl;
		authorizationValue = "Basic ".concat(new String(Base64.encodeBase64(secret.concat(":").concat(key)
				.getBytes())));
	}

	@Override
	public Authentication authenticate(Authentication authentication) {
		String authToken = authentication.getCredentials().toString();
		log.debug("[authorized] request , token=" + authToken + ",url=" + authorizationServerUrl
				+ ",authorizationValue=" + authorizationValue);
		String uid = null;
		String source = null;
		if (StringUtils.isBlank(authToken)) {
			return null;
		}
		try {
			String json = clientFactory
					.createClient(String.format(authorizationServerUrl.concat("?access_token=%s"), authToken))
					.header(CustomTokenAuthenticationFilter.AUTHORIZATION, authorizationValue)
					.accept("application/json").get(String.class);
			VerifyTokenResponse tokenResponse = mapper.readValue(json, VerifyTokenResponse.class);
			if (tokenResponse.getPrincipal() == null) {
				log.error("[authorized] accesstoken is error,authToken=" + authToken
						+ ",authorization server url:" + authorizationServerUrl);
				throw new AuthTokenException("2.401", null);
			}
			// 设置Principal,如果需其它属性在这里修改
			AuthenticationToken authenticationToken = (AuthenticationToken) authentication;
			uid = tokenResponse.getPrincipal().getAttribute("uid");
			source = tokenResponse.getPrincipal().getAttribute("source");
			authenticationToken.setPrincipal(uid);
			authenticationToken.setSource(source);
			log.debug("login source:" + source);
		} catch (UniformInterfaceException e) {
			// 根据类型返回错误
			ClientResponse cr = e.getResponse();
			log.error("[authorized] accesstoken is error,code=" + cr.getStatus() + ",authToken=" + authToken
					+ ",uid=" + uid + ",authorization server url:" + authorizationServerUrl);
			switch (cr.getStatus()) {
				case 401:
					throw new AuthTokenException("2.401", null);
				case 404:
					throw new AuthTokenException("2.404", null);
				case 410:
					throw new AuthTokenException("2.410", null);
				default:
					throw new AuthTokenException("2.401", null);
			}
		} catch (IOException e) {
			log.error("[authorized] verify token response readValue Error" + ",authorization server url:"
					+ authorizationServerUrl, e);
			throw new AuthTokenException("2.401", null);
		} catch (Exception e) {
			log.error("[authorized] verify token response readValue Error" + ",authorization server url:"
					+ authorizationServerUrl, e);
			throw new AuthTokenException("2.401", null);
		}
		return authentication;
	}

	public JerseyClientFactory getClientFactory() {
		return clientFactory;
	}

	public void setClientFactory(JerseyClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
}