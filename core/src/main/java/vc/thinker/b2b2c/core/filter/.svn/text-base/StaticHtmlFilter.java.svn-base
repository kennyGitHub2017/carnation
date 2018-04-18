package vc.thinker.b2b2c.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 静态html 统计,使用过滤器添加
 * 
 * @author JG-yes
 * 
 */
public class StaticHtmlFilter implements Filter {

	protected Log log = LogFactory.getFactory().getInstance(this.getClass().getName());

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		try {

			if (request instanceof HttpServletRequest) {
				String url = ((HttpServletRequest) request).getRequestURI().toString();
				log.error("Static---------------------------" + url);

				HttpServletResponse httpResponse = (HttpServletResponse) response;
				String str = "<script type=\"text/javascript\">  ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");document.write(unescape(\"%3Cspan style='display: none;' id='cnzz_stat_icon_1255206113'%3E%3C/span%3E%3Cscript src='\" + cnzz_protocol + \"s11.cnzz.com/z_stat.php%3Fid%3D1255206113' type='text/javascript'%3E%3C/script%3E\"));</script>";
				String str2 = "<script> var _hmt = _hmt || []; (function() { var hm = document.createElement(\"script\");   hm.src = \"//hm.baidu.com/hm.js?8b2f2c6656ec077454798a10e8660852\"; var s = document.getElementsByTagName(\"script\")[0]; s.parentNode.insertBefore(hm, s); })(); </script>";

				httpResponse.getOutputStream().write(str.getBytes());
				httpResponse.getOutputStream().write(str2.getBytes());
				filterChain.doFilter(request, httpResponse);
			} else {

				filterChain.doFilter(request, response);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
