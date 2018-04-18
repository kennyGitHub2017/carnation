package com.sinco.api.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author muxi
 * 
 */
public class JsoupUtils {

	private static Logger logger = LoggerFactory.getLogger(JsoupUtils.class);

	public static String queryHtml(String context) {
		Document doc = null;
		try {
			doc = Jsoup.connect("http://static.ysysgo.com/static/app/content.html").get();
			Element element = doc.getElementById("web_view_content");
			element.append(context);
		} catch (IOException e) {
			logger.error("jsoup请求模版异常!", e);
			return "";
		}
		return doc.toString();
	}
}
