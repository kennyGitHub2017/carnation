package vc.thinker.b2b2c.core.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class StaticHtmlResponse extends HttpServletResponseWrapper {

	protected HttpServletResponse response;
	private PrintWriter writer;
	@SuppressWarnings("unused")
	private ServletOutputStream out;
	protected int contentLength;

	public StaticHtmlResponse(HttpServletResponse response) {
		super(response);
		this.response = response;
	}

	public void setContentLength(int len) {
		contentLength = len;
	}

	public PrintWriter getWriter() throws IOException {

		/*if (null == writer) {
			if (null != out) {
				throw new IllegalStateException(
						"getOutputStream() has already been called on this response.");
			}
			writer = new PrintWriter(compressedOut);
		}
		return writer;*/

		String str = "<script type=\"text/javascript\">  ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");document.write(unescape(\"%3Cspan style='display: none;' id='cnzz_stat_icon_1255206113'%3E%3C/span%3E%3Cscript src='\" + cnzz_protocol + \"s11.cnzz.com/z_stat.php%3Fid%3D1255206113' type='text/javascript'%3E%3C/script%3E\"));</script>";
		String str2 = "<script> var _hmt = _hmt || []; (function() { var hm = document.createElement(\"script\");   hm.src = \"//hm.baidu.com/hm.js?8b2f2c6656ec077454798a10e8660852\"; var s = document.getElementsByTagName(\"script\")[0]; s.parentNode.insertBefore(hm, s); })(); </script>";
		writer.write(str);
		writer.write(str2);
		return writer;

	}

}
