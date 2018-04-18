package vc.thinker.b2b2c.action.information;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.consulting.service.ConsultingService;
import com.sinco.carnation.sns.bo.ExpertKnowledgeBO;
import com.sinco.carnation.sns.bo.KnowledgeClassBO;
import com.sinco.carnation.sns.model.ExpertKnowledge;
import com.sinco.carnation.sns.model.KnowledgeClass;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

@Controller
public class ExpertKnowledgeController {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private ConsultingService consultingService;

	/**
	 * 专家咨询知识库列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unused")
	@SecurityMapping(title = "专家咨询知识库列表", value = "/admin/expert_knowledge*", rtype = "admin", rname = "专家咨询知识库", rcode = "expert_knowledge_admin", rgroup = "内容管理")
	@RequestMapping("/admin/expert_knowledge.htm")
	public ModelAndView expert_knowledge(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String title, MyPage<ExpertKnowledgeBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/expert_knowledge.html", configService.getSysConfig(),
				0, request, response);
		Long uid = SecurityUserHolder.getCurrentUser().getId();
		page.setPageSize(20);
		consultingService.queryExpertKnowledgeList(title, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("objs", page.getContent());
		mv.addObject("title", title);
		return mv;
	}

	/**
	 * 编辑专家知识库
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "咨询问题详情", value = "/admin/expert_knowledge_details*", rtype = "admin", rname = "专家咨询知识库", rcode = "expert_knowledge_admin", rgroup = "内容管理")
	@RequestMapping("/admin/expert_knowledge_details.htm")
	public ModelAndView expert_knowledge_details(HttpServletRequest request, HttpServletResponse response,
			String id) {
		ModelAndView mv = new JModelAndView("admin/blue/expert_knowledge_details.html",
				configService.getSysConfig(), 0, request, response);
		ExpertKnowledgeBO knowledge = consultingService.getByExpertKnowledge(CommUtil.null2Long(id));
		List<KnowledgeClassBO> list = consultingService.findAll();
		mv.addObject("obj", knowledge);
		mv.addObject("edit", true);
		mv.addObject("list", list);
		return mv;
	}

	/**
	 * 知识库增加
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "知识库增加", value = "/admin/expert_knowledge_add*", rtype = "admin", rname = "专家咨询知识库", rcode = "expert_knowledge_admin", rgroup = "内容管理")
	@RequestMapping("/admin/expert_knowledge_add.htm")
	public ModelAndView expert_knowledge_add(HttpServletRequest request, HttpServletResponse response,
			String id) {
		ModelAndView mv = new JModelAndView("admin/blue/expert_knowledge_details.html",
				configService.getSysConfig(), 0, request, response);
		List<KnowledgeClassBO> list = consultingService.findAll();
		mv.addObject("list", list);
		return mv;
	}

	/**
	 * 知识库保存
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "知识库增加", value = "/admin/expert_knowledge_save*", rtype = "admin", rname = "专家咨询知识库", rcode = "expert_knowledge_admin", rgroup = "内容管理")
	@RequestMapping("/admin/expert_knowledge_save.htm")
	public ModelAndView expert_knowledge_save(HttpServletRequest request, HttpServletResponse response,
			ExpertKnowledge knowledge) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		knowledge.setCreateTime(new Date());
		knowledge.setUserId(SecurityUserHolder.getCurrentUser().getId());
		consultingService.knowledgeSave(knowledge);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/expert_knowledge.htm");
		mv.addObject("op_title", "知识库保存成功");
		return mv;
	}

	/**
	 * 知识库删除
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "知识库删除", value = "/admin/expert_knowledge_delete*", rtype = "admin", rname = "专家咨询知识库", rcode = "expert_knowledge_admin", rgroup = "内容管理")
	@RequestMapping("/admin/expert_knowledge_delete.htm")
	public ModelAndView expert_knowledge_delete(HttpServletRequest request, HttpServletResponse response,
			String mulitId) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		if (StringUtils.isNotBlank(mulitId)) {
			consultingService.knowledgeSave(mulitId);
		}
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/expert_knowledge.htm");
		mv.addObject("op_title", "知识库删除成功");
		return mv;
	}

	/**
	 * 知识库分类列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "专家咨询知识库分类列表", value = "/admin/knowledge_class*", rtype = "admin", rname = "专家咨询知识库", rcode = "expert_knowledge_admin", rgroup = "内容管理")
	@RequestMapping("/admin/knowledge_class.htm")
	public ModelAndView expert_knowledge_class(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String className, MyPage<KnowledgeClassBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/knowledge_class.html", configService.getSysConfig(),
				0, request, response);
		page.setPageSize(20);
		consultingService.queryKnowClassAll(className, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("objs", page.getContent());
		mv.addObject("className", className);
		return mv;
	}

	/**
	 * 知识库分类列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "专家咨询知识库分类保存", value = "/admin/knowledge_class_save*", rtype = "admin", rname = "专家咨询知识库", rcode = "expert_knowledge_admin", rgroup = "内容管理")
	@RequestMapping("/admin/knowledge_class_save.htm")
	public ModelAndView knowledge_class_save(HttpServletRequest request, HttpServletResponse response,
			String currentPage, KnowledgeClass knownClass) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		knownClass.setCreateTime(new Date());
		knownClass.setUserId(SecurityUserHolder.getCurrentUser().getId());
		consultingService.knowledgeClassSave(knownClass);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/knowledge_class.htm");
		mv.addObject("op_title", "知识库分类保存成功");
		return mv;
	}

	/**
	 * 知识库分类增加
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "专家咨询知识库分类增加", value = "/admin/knowledge_class_add*", rtype = "admin", rname = "专家咨询知识库", rcode = "expert_knowledge_admin", rgroup = "内容管理")
	@RequestMapping("/admin/knowledge_class_add.htm")
	public ModelAndView knowledge_class_add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/knowledge_class_add.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	/**
	 * 知识库分类编辑
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "专家咨询知识库分类编辑", value = "/admin/knowledge_class_details*", rtype = "admin", rname = "专家咨询知识库", rcode = "expert_knowledge_admin", rgroup = "内容管理")
	@RequestMapping("/admin/knowledge_class_details.htm")
	public ModelAndView knowledge_class_details(HttpServletRequest request, HttpServletResponse response,
			String id) {
		ModelAndView mv = new JModelAndView("admin/blue/knowledge_class_add.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotBlank(id)) {
			KnowledgeClassBO knowClass = consultingService.knowledgeClassDetails(id);
			mv.addObject("obj", knowClass);
			mv.addObject("edit", true);
		}

		return mv;
	}

	/**
	 * 知识库分类删除
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "专家咨询知识库分类编辑", value = "/admin/knowledge_class_del*", rtype = "admin", rname = "专家咨询知识库", rcode = "expert_knowledge_admin", rgroup = "内容管理")
	@RequestMapping("/admin/knowledge_class_del.htm")
	public ModelAndView knowledge_class_del(HttpServletRequest request, HttpServletResponse response,
			String mulitId) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);

		if (StringUtils.isNotBlank(mulitId)) {
			consultingService.knowledgeClassDel(mulitId);
		}
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/knowledge_class.htm");
		mv.addObject("op_title", "知识库分类删除成功");

		return mv;
	}

	/**
	 * 根据分类查知识库
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "ajax专家咨询", value = "/admin/ajax_knowledge*", rtype = "admin", rname = "专家咨询知识库", rcode = "expert_knowledge_admin", rgroup = "内容管理")
	@RequestMapping(value = "/admin/ajax_knowledge.htm", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public ModelAndView ajax_knowledge(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/ajax_knowledge.html", configService.getSysConfig(),
				0, request, response);
		if (StringUtils.isNotBlank(id)) {
			List<ExpertKnowledgeBO> list = consultingService.query(id);

			mv.addObject("list", list);
		}
		return mv;
	}

	/**
	 * 根据分类查知识库
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "ajax专家咨询列表", value = "/admin/ajax_knowledge_search*", rtype = "admin", rname = "专家咨询知识库", rcode = "expert_knowledge_admin", rgroup = "内容管理")
	@RequestMapping(value = "/admin/ajax_knowledge_search.htm", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public ModelAndView ajax_knowledge_details(HttpServletRequest request, HttpServletResponse response,
			String id, String name) {

		ModelAndView mv = new JModelAndView("admin/blue/ajax_knowledge.html", configService.getSysConfig(),
				0, request, response);
		List<ExpertKnowledgeBO> list = consultingService.search(id, name);

		mv.addObject("list", list);
		return mv;
	}

}
