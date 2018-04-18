package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
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
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.carnation.label.bo.LabelClassBO;
import com.sinco.carnation.label.model.LabelClass;
import com.sinco.carnation.sys.service.LabelClassService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

@Controller
public class LabelClassManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private LabelClassService labelClassService;

	/**
	 * LabelClass列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "标签分类列表", value = "/admin/labelclass_list.htm*", rtype = "admin", rname = "标签分类列表", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/labelclass_list.htm")
	public ModelAndView list(HttpServletRequest request, MyPage<LabelClassBO> page,
			HttpServletResponse response, String currentPage, String orderBy, String orderType) {
		ModelAndView mv = new JModelAndView("admin/blue/labelclass_list.html", configService.getSysConfig(),
				0, request, response);

		labelClassService.findByPage(page);

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		return mv;
	}

	/**
	 * LabelClass添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "标签分类添加", value = "/admin/labelclass_add.htm*", rtype = "admin", rname = "标签分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/labelclass_add.htm")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response, String pid) {
		ModelAndView mv = new JModelAndView("admin/blue/labelclass_add.html", configService.getSysConfig(),
				0, request, response);

		List<LabelClassBO> acs = labelClassService.findAllOrder();

		if (pid != null && !pid.equals("")) {
			LabelClass obj = new LabelClass();
			obj.setParentId(Long.parseLong(pid));
			mv.addObject("obj", obj);
		}
		mv.addObject("acs", acs);
		return mv;
	}

	/**
	 * LabelClass编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "标签分类编辑", value = "/admin/labelclass_edit.htm*", rtype = "admin", rname = "标签分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/labelclass_edit.htm")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/labelclass_add.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && !id.equals("")) {
			LabelClass articleClass = this.labelClassService.getObjById(Long.parseLong(id));

			List<LabelClassBO> acs = labelClassService.findAllOrder();
			mv.addObject("acs", acs);
			mv.addObject("obj", articleClass);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * LabelClass保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "标签分类保存", value = "/admin/labelclass_save.htm*", rtype = "admin", rname = "标签分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/labelclass_save.htm")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response, String id, String pid,
			String currentPage, String cmd, String list_url, String add_url, String level) {
		WebForm wf = new WebForm();

		LabelClass articleClass = wf.toPo(request, LabelClass.class);

		articleClass.setId(StringUtils.isNotBlank(id) ? Long.parseLong(id) : null);

		if (StringUtils.isNotEmpty(pid)) {
			articleClass.setParentId(Long.parseLong(pid));
			articleClass.setLevel(1);
		} else {
			articleClass.setLevel(0);
		}
		this.labelClassService.save(articleClass);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url + "?currentPage="
				+ (StringUtils.isBlank(currentPage) ? "1" : currentPage));
		mv.addObject("op_title", "保存标签分类成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?pid=" + pid);
		}
		return mv;
	}

	@SecurityMapping(title = "标签分类删除", value = "/admin/labelclass_del.htm*", rtype = "admin", rname = "标签分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/labelclass_del.htm")
	public String delete(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		Long[] longIds = new Long[ids.length];
		for (int i = 0; i < ids.length; i++) {
			longIds[i] = Long.parseLong(ids[i]);
		}

		labelClassService.delete(longIds);

		return "redirect:labelclass_list.htm";
	}

	@SecurityMapping(title = "标签下级分类", value = "/admin/labelclass_data.htm*", rtype = "admin", rname = "标签分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/labelclass_data.htm")
	public ModelAndView labelclass_data(HttpServletRequest request, HttpServletResponse response, String pid,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/labelclass_data.html", configService.getSysConfig(),
				0, request, response);
		List<LabelClassBO> acs = this.labelClassService.findByParent(Long.parseLong(pid));
		mv.addObject("acs", acs);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/*@SecurityMapping(title = "标签分类AJAX更新", value = "/admin/labelclass_ajax.htm*", rtype = "admin", rname = "标签分类", rcode = "article_class", rgroup = "内容管理")
	@RequestMapping("/admin/labelclass_ajax.htm")
	public void ajax(HttpServletRequest request, HttpServletResponse response,
			String id, String fieldName, String value)
			throws ClassNotFoundException {
		LabelClass ac = this.labelClassService.getObjById(Long
				.parseLong(id));
		Field[] fields = LabelClass.class.getDeclaredFields();
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
					val = !CommUtil.null2Boolean(wrapper
							.getPropertyValue(fieldName));
				}
				wrapper.setPropertyValue(fieldName, val);
			}
		}
		this.labelClassService.update(ac);
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

	}*/

	@RequestMapping("/admin/labelclass_verify.htm")
	public void labelclass_verify(HttpServletRequest request, HttpServletResponse response, String className,
			Long id) {
		boolean ret = true;
		int count = labelClassService.countByName(className, id);
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