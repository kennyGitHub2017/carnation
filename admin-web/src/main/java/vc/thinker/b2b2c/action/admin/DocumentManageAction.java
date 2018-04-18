package vc.thinker.b2b2c.action.admin;

import java.text.ParseException;
import java.util.Date;
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
import com.sinco.carnation.sys.bo.DocumentBO;
import com.sinco.carnation.sys.model.Document;
import com.sinco.carnation.sys.service.DocumentService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: DocumentManageAction.java
 * </p>
 * 
 * <p>
 * Description: 系统文章管理类
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
 * @date 2014年5月27日
 * 
 * @version 1.0.1
 */
@Controller
public class DocumentManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private DocumentService documentService;

	/**
	 * Document列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "系统文章列表", value = "/admin/document_list.htm*", rtype = "admin", rname = "系统文章", rcode = "document_manage", rgroup = "内容管理")
	@RequestMapping("/admin/document_list.htm")
	public ModelAndView document_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<DocumentBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/document_list.html", configService.getSysConfig(), 0,
				request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(20);
		documentService.queryDocumetAllList(page);
		CommUtil.saveIPageList2ModelAndView(url + "/admin/document_list.htm", "", "", page, mv);
		return mv;
	}

	/**
	 * document添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "系统文章新增", value = "/admin/document_add.htm*", rtype = "admin", rname = "系统文章", rcode = "document_manage", rgroup = "内容管理")
	@RequestMapping("/admin/document_add.htm")
	public ModelAndView document_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/document_add.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * document编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "系统文章编辑", value = "/admin/document_edit.htm*", rtype = "admin", rname = "系统文章", rcode = "document_manage", rgroup = "内容管理")
	@RequestMapping("/admin/document_edit.htm")
	public ModelAndView document_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/document_add.html", configService.getSysConfig(), 0,
				request, response);
		if (StringUtils.isNotBlank(id)) {
			Document document = documentService.queryDocumentById(CommUtil.null2Long(id));
			mv.addObject("obj", document);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * document保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "系统文章保存", value = "/admin/document_save.htm*", rtype = "admin", rname = "系统文章", rcode = "document_manage", rgroup = "内容管理")
	@RequestMapping("/admin/document_save.htm")
	public ModelAndView document_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String cmd, String list_url, String add_url) {
		WebForm wf = new WebForm();
		Document document = null;
		if (id.equals("")) {
			document = wf.toPo(request, Document.class);
			document.setAddTime(new Date());
		} else {
			Document obj = this.documentService.getObjById(Long.parseLong(id));
			document = (Document) wf.toPo(request, obj);
		}

		// 文章保存/编辑
		documentService.saveDocument(document);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存系统文章成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?currentPage=" + currentPage);
		}
		return mv;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "系统文章删除", value = "/admin/document_del.htm*", rtype = "admin", rname = "系统文章", rcode = "document_manage", rgroup = "内容管理")
	@RequestMapping("/admin/document_del.htm")
	public String document_del(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				Document document = this.documentService.getObjById(Long.parseLong(id));
				this.documentService.delete(Long.parseLong(id));
			}
		}
		return "redirect:document_list.htm";
	}

	// @SecurityMapping(title = "系统文章AJAX更新", value =
	// "/admin/document_ajax.htm*", rtype = "admin", rname = "系统文章", rcode =
	// "document_manage", rgroup = "网站")
	// @RequestMapping("/admin/document_ajax.htm")
	// public void document_ajax(HttpServletRequest request, HttpServletResponse
	// response,
	// String id, String fieldName, String value)
	// throws ClassNotFoundException {
	// Document obj = this.documentService.getObjById(Long.parseLong(id));
	// Field[] fields = Document.class.getDeclaredFields();
	// BeanWrapper wrapper = new BeanWrapper(obj);
	// Object val = null;
	// for (Field field : fields) {
	// // System.out.println(field.getName());
	// if (field.getName().equals(fieldName)) {
	// Class clz = Class.forName("java.lang.String");
	// if (field.getType().getName().equals("int")) {
	// clz = Class.forName("java.lang.Integer");
	// }
	// if (field.getType().getName().equals("boolean")) {
	// clz = Class.forName("java.lang.Boolean");
	// }
	// if (!value.equals("")) {
	// val = BeanUtils.convertType(value, clz);
	// } else {
	// val = !CommUtil.null2Boolean(wrapper
	// .getPropertyValue(fieldName));
	// }
	// wrapper.setPropertyValue(fieldName, val);
	// }
	// }
	// this.documentService.update(obj);
	// response.setContentType("text/plain");
	// response.setHeader("Cache-Control", "no-cache");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter writer;
	// try {
	// writer = response.getWriter();
	// writer.print(val.toString());
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
}