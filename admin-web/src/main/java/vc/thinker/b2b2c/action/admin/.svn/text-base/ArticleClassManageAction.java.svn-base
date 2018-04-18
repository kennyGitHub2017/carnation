package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.carnation.sys.bo.ArticleClassBO;
import com.sinco.carnation.sys.model.ArticleClass;
import com.sinco.carnation.sys.service.ArticleClassService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

@Controller
public class ArticleClassManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ArticleClassService articleClassService;

	/**
	 * ArticleClass列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "文章分类列表", value = "/admin/articleclass_list.htm*", rtype = "admin", rname = "文章分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/articleclass_list.htm")
	public ModelAndView list(HttpServletRequest request, MyPage<ArticleClassBO> page,
			HttpServletResponse response, String currentPage, String orderBy, String orderType) {
		ModelAndView mv = new JModelAndView("admin/blue/articleclass_list.html",
				configService.getSysConfig(), 0, request, response);

		articleClassService.findByPage(page);

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		return mv;
	}

	/**
	 * articleClass添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "文章分类添加", value = "/admin/articleclass_add.htm*", rtype = "admin", rname = "文章分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/articleclass_add.htm")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response, String pid) {
		ModelAndView mv = new JModelAndView("admin/blue/articleclass_add.html", configService.getSysConfig(),
				0, request, response);

		List<ArticleClassBO> acs = articleClassService.findAllOrder();

		if (pid != null && !pid.equals("")) {
			ArticleClass obj = new ArticleClass();
			obj.setParentId(Long.parseLong(pid));
			mv.addObject("obj", obj);
		}
		mv.addObject("acs", acs);
		return mv;
	}

	/**
	 * articleClass编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "文章分类编辑", value = "/admin/articleclass_edit.htm*", rtype = "admin", rname = "文章分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/articleclass_edit.htm")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/articleclass_add.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && !id.equals("")) {
			ArticleClass articleClass = this.articleClassService.getObjById(Long.parseLong(id));

			List<ArticleClassBO> acs = articleClassService.findAllOrder();

			mv.addObject("acs", acs);
			mv.addObject("obj", articleClass);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * articleClass保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "文章分类保存", value = "/admin/articleclass_save.htm*", rtype = "admin", rname = "文章分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/articleclass_save.htm")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response, String id, String pid,
			String currentPage, String cmd, String list_url, String add_url) {
		WebForm wf = new WebForm();

		ArticleClass articleClass = wf.toPo(request, ArticleClass.class);

		articleClass.setId(StringUtils.isNotBlank(id) ? Long.parseLong(id) : null);

		if (pid != null && !pid.equals("")) {
			articleClass.setParentId(Long.parseLong(pid));
		}
		this.articleClassService.save(articleClass);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url + "?currentPage="
				+ (StringUtils.isBlank(currentPage) ? "1" : currentPage));
		mv.addObject("op_title", "保存文章分类成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?pid=" + pid);
		}
		return mv;
	}

	@SecurityMapping(title = "文章分类删除", value = "/admin/articleclass_del.htm*", rtype = "admin", rname = "文章分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/articleclass_del.htm")
	public String delete(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		Long[] longIds = new Long[ids.length];
		for (int i = 0; i < ids.length; i++) {
			longIds[i] = Long.parseLong(ids[i]);
		}

		articleClassService.delete(longIds);

		return "redirect:articleclass_list.htm";
	}

	@SecurityMapping(title = "文章下级分类", value = "/admin/articleclass_data.htm*", rtype = "admin", rname = "文章分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/articleclass_data.htm")
	public ModelAndView articleclass_data(HttpServletRequest request, HttpServletResponse response,
			String pid, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/articleclass_data.html",
				configService.getSysConfig(), 0, request, response);
		List<ArticleClassBO> acs = this.articleClassService.findByParent(Long.parseLong(pid));
		mv.addObject("acs", acs);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "文章分类AJAX更新", value = "/admin/articleclass_ajax.htm*", rtype = "admin", rname = "文章分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/articleclass_ajax.htm")
	public void ajax(HttpServletRequest request, HttpServletResponse response, String id, String fieldName,
			String value) throws ClassNotFoundException {
		ArticleClass ac = this.articleClassService.getObjById(Long.parseLong(id));
		Field[] fields = ArticleClass.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(ac);
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
		this.articleClassService.update(ac);
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

	@RequestMapping("/admin/articleclass_verify.htm")
	public void articleclass_verify(HttpServletRequest request, HttpServletResponse response,
			String className, Long id) {
		boolean ret = true;
		int count = articleClassService.countByName(className, id);
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