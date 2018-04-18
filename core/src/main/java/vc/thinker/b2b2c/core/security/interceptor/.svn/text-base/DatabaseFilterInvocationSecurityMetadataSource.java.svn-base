package vc.thinker.b2b2c.core.security.interceptor;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.ConfigAttributeEditor;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import vc.thinker.b2b2c.core.constant.Globals;

@SuppressWarnings({"rawtypes", "deprecation"})
public class DatabaseFilterInvocationSecurityMetadataSource implements FactoryBean {

	@Autowired
	private JedisPool jedisPool;

	private String authKey = "AUTH:";

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	@Override
	public Object getObject() throws Exception {
		return new DefaultFilterInvocationSecurityMetadataSource(this.buildRequestMap());
	}

	@SuppressWarnings("unchecked")
	protected LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> buildRequestMap() {
		LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = null;
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();

			requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();

			ConfigAttributeEditor editor = new ConfigAttributeEditor();

			Set<String> authorities = jedis.smembers(authKey + "AUTHORITIES_CACHE_KEY");
			for (String author : authorities) {
				String[] authors = author.split("->");
				if (authors.length >= 2) {
					// System.out.println(authors[0] + authors[1]);
					editor.setAsText(authors[1]);
					requestMap.put(new AntPathRequestMatcher(authors[0]),
							(Collection<ConfigAttribute>) editor.getValue());
				}
			}
			// 设置权限检查
			jedis.set(authKey + "check", Globals.DEFAULT_CHECK_NAME);
			/*Map<String, String> resourceMap = Maps.newHashMap();//getUrlAuthorities(servletContext);// Maps.newHashMap();//getUrlAuthorities();

			for (Map.Entry<String, String> entry : resourceMap.entrySet()) {
				String key = entry.getKey();
				editor.setAsText(entry.getValue());
				requestMap.put(new AntPathRequestMatcher(key),
						(Collection<ConfigAttribute>) editor.getValue());
			}*/

			return requestMap;
		} finally {
			jedisPool.returnResource(jedis);
		}
	}

	@SuppressWarnings({"unchecked", "unused"})
	private Map<String, String> getUrlAuthorities(ServletContext servletContext) {
		/*ServletContext servletContext = filterInvocation.getHttpRequest()
				.getSession().getServletContext();*/
		return (Map<String, String>) servletContext.getAttribute("urlAuthorities");
	}

	@Override
	public Class getObjectType() {
		return FilterInvocationSecurityMetadataSource.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}
}
