package com.sinco.carnation.resource.web.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.exception.ApiException;
import com.sinco.api.util.WebUtils;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "资讯 API", namespace = "news")
public class ViewController {

	@Value("#{prop['api.newsWebUrl']}")
	private String newsWebUrl;

	@Value("#{prop['api.feedWebUrl']}")
	private String feedWebUrl;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 查询文章详情页
	 * 
	 * @param id
	 * @param isApp
	 * @param request
	 * @param response
	 * @throws ApiException
	 */
	@RequestMapping(value = "/views/article_{id}_{isApp}", method = RequestMethod.GET)
	public void articlesList(@PathVariable("id") String id, @PathVariable("isApp") Integer isApp,
			HttpServletRequest request, HttpServletResponse response) throws ApiException {
		Map<String, String> params = new HashMap<String, String>();

		StringBuilder url = new StringBuilder(newsWebUrl);
		url.append("/article.query/").append(id).append("_").append(isApp);

		try {
			WebUtils.doGet(url.toString(), params, "utf-8", response);
		} catch (IOException e) {
			try {
				response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Server error");
			} catch (IOException e1) {
			}
			log.error("", e);
		}
	}

	/**
	 * 查询文章评论
	 * 
	 * @param id
	 * @param isApp
	 * @param request
	 * @param response
	 * @throws ApiException
	 */
	@RequestMapping(value = "/views/article_comment", method = RequestMethod.GET)
	public void comment(@RequestParam("id") String id,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			HttpServletResponse response) throws ApiException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("pageNo", String.valueOf(pageNo));
		params.put("pageSize", String.valueOf(pageSize));

		StringBuilder url = new StringBuilder(newsWebUrl);
		url.append("/articles/comments/view");

		try {
			WebUtils.doGet(url.toString(), params, "utf-8", response);
		} catch (IOException e) {
			try {
				response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Server error");
			} catch (IOException e1) {
			}
			log.error("", e);
		}
	}

	/**
	 * 用于评论分页
	 * 
	 * @param id
	 * @param isApp
	 * @param request
	 * @param response
	 * @throws ApiException
	 */
	@RequestMapping(value = "/views/article_comment_list", method = RequestMethod.GET)
	public void commentList(@RequestParam("id") String id,
			@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			HttpServletResponse response) throws ApiException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("pageNo", String.valueOf(pageNo));
		params.put("pageSize", String.valueOf(pageSize));

		StringBuilder url = new StringBuilder(newsWebUrl);
		url.append("/articles/comments/view_list");

		try {
			WebUtils.doGet(url.toString(), params, "utf-8", response);
		} catch (IOException e) {
			try {
				response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Server error");
			} catch (IOException e1) {
			}
			log.error("", e);
		}
	}

	/**
	 * 查询文章评论
	 * 
	 * @param id
	 * @param isApp
	 * @param request
	 * @param response
	 * @throws ApiException
	 */
	@RequestMapping(value = "/views/feeds/{id}", method = RequestMethod.GET)
	public void comment(@PathVariable("id") String id, HttpServletResponse response) throws ApiException {

		StringBuilder url = new StringBuilder(feedWebUrl);
		url.append("/feed.feedhtml/").append(id);

		try {
			WebUtils.doGet(url.toString(), null, "utf-8", response);
		} catch (IOException e) {
			try {
				response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Server error");
			} catch (IOException e1) {
			}
			log.error("", e);
		}
	}

}
