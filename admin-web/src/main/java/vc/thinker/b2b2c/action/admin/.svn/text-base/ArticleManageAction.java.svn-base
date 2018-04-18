package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.bo.ArticleClassBO;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.service.ArticleClassService;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: ArticleManageAction.java
 * </p>
 * 
 * <p>
 * Description:系统文章管理控制器，用来发布、修改系统文章信息
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-5-21
 * 
 * @version 1.0.1
 */
@Controller
public class ArticleManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleClassService articleClassService;
	@Autowired
	private WeedFSClient fsClient;

	/**
	 * Article列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "文章列表", value = "/admin/article_list.htm*", rtype = "admin", rname = "文章管理", rcode = "article", rgroup = "内容管理")
	@RequestMapping("/admin/article_list.htm")
	public ModelAndView article_list(HttpServletRequest request, MyPage<ArticleBO> page,
			HttpServletResponse response, String title, String currentPage, String orderBy, String orderType,
			String articleClassName) {
		ModelAndView mv = new JModelAndView("admin/blue/article_list.html", configService.getSysConfig(), 0,
				request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		this.articleService.findByPage(title, articleClassName, page);

		mv.addObject("title", title);
		mv.addObject("articleClassName", articleClassName);

		CommUtil.saveIPageList2ModelAndView(url + "/admin/article_list.htm", "", "", page, mv);
		return mv;
	}

	/**
	 * article添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "文章添加", value = "/admin/article_add.htm*", rtype = "admin", rname = "文章管理", rcode = "article", rgroup = "内容管理")
	@RequestMapping("/admin/article_add.htm")
	public ModelAndView article_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String class_id) {
		ModelAndView mv = new JModelAndView("admin/blue/article_add.html", configService.getSysConfig(), 0,
				request, response);
		List<ArticleClassBO> acs = this.articleClassService.findLevelAll();
		Article obj = new Article();
		obj.setDisplay(true);
		if (class_id != null && !class_id.equals(""))
			obj.setArticleClassId(Long.parseLong(class_id));
		mv.addObject("obj", obj);
		mv.addObject("acs", acs);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * article编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "文章编辑", value = "/admin/article_edit.htm*", rtype = "admin", rname = "文章管理", rcode = "article", rgroup = "内容管理")
	@RequestMapping("/admin/article_edit.htm")
	public ModelAndView article_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/article_add.html", configService.getSysConfig(), 0,
				request, response);
		if (id != null && !id.equals("")) {
			Article article = this.articleService.getObjById(Long.parseLong(id));
			List<ArticleClassBO> acs = this.articleClassService.findLevelAll();
			mv.addObject("acs", acs);
			mv.addObject("obj", article);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * article保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "文章保存", value = "/admin/article_save.htm*", rtype = "admin", rname = "文章管理", rcode = "article", rgroup = "内容管理")
	@RequestMapping("/admin/article_save.htm")
	public ModelAndView article_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String cmd, String list_url, String add_url, String class_id, String content,
			@RequestParam("thumImg") MultipartFile file, String artDesc, String keywords, String description) {
		WebForm wf = new WebForm();
		Article article = wf.toPo(request, Article.class);
		article.setId(StringUtils.isNotBlank(id) ? Long.parseLong(id) : null);

		article.setArticleClassId(Long.parseLong(class_id));

		if (file != null && file.getSize() != 0) {
			try {
				String fileUrl=FileUploadTools.fileUpload(file, UploadConstants.ARTICLE);
				article.setImg(fileUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		this.articleService.save(article);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存文章成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?currentPage=" + currentPage + "&class_id=" + class_id);
		}
		return mv;
	}

	@SecurityMapping(title = "文章删除", value = "/admin/article_del.htm*", rtype = "admin", rname = "文章管理", rcode = "article", rgroup = "内容管理")
	@RequestMapping("/admin/article_del.htm")
	public String article_del(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		List<Long> idList = Lists.newArrayList();
		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}
		articleService.batchDelete(idList);

		return "redirect:article_list.htm";
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "文章AJAX更新", value = "/admin/article_ajax.htm*", rtype = "admin", rname = "文章管理", rcode = "article", rgroup = "内容管理")
	@RequestMapping("/admin/article_ajax.htm")
	public void article_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
		Article obj = this.articleService.getObjById(Long.parseLong(id));
		Field[] fields = Article.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(obj);
		Object val = null;
		for (Field field : fields) {
			if (field.getName().equals(fieldName)) {
				Class clz = Class.forName("java.lang.String");
				if (field.getType().getName().equals("int")) {
					clz = Class.forName("java.lang.Integer");
				}
				if (field.getType().getName().equals("boolean")) {
					clz = Class.forName("java.lang.Boolean");
				}
				if (!value.equals("")) {
					val = BeanUtils.convertType(value, clz);
				} else {
					val = !CommUtil.null2Boolean(wrapper.getPropertyValue(fieldName));
				}
				wrapper.setPropertyValue(fieldName, val);
			}
		}
		this.articleService.update(obj);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(val.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("/admin/article_mark.htm")
	public void article_mark(HttpServletRequest request, HttpServletResponse response, String mark, Long id) {
		int count = this.articleService.countBymMark(mark.trim(), id);
		boolean ret = true;
		if (count > 0) {
			ret = false;
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}