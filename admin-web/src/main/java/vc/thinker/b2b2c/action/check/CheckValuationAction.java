package vc.thinker.b2b2c.action.check;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.bo.SysReminderTaskBO;
import com.sinco.carnation.sys.model.SysReminderTask;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.TaskService;
import com.sinco.carnation.sys.vo.SysReminderTaskVO;
import com.sinco.carnation.user.bo.PhysicalValuationBO;
import com.sinco.carnation.user.enums.EmPhysicalResultType;
import com.sinco.carnation.user.service.PhysicalService;
import com.sinco.carnation.user.vo.PhysicalValuationVO;
import com.sinco.dal.common.MyPage;

/***
 * 体检相关设置
 * 
 * 体检对比参数 体检结果建议
 * 
 * @author LKN
 * 
 */
@Controller
@RequestMapping("/admin/checkValuation")
public class CheckValuationAction {

	@Autowired
	private SysConfigService configService;

	@Autowired
	private PhysicalService physicalService;
	@Autowired
	private TaskService taskService;

	/**
	 * 体检参数查询
	 * 
	 * @return
	 */
	@RequestMapping("pageList.htm")
	@SecurityMapping(title = "体检参考值列表", value = "/pageList.htm", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	public ModelAndView check_Configure_List(HttpServletRequest request, HttpServletResponse response,
			PhysicalValuationVO vo, MyPage<PhysicalValuationBO> page) {

		ModelAndView mv = new JModelAndView("admin/blue/physical/check_physical_valuation.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(20);
		this.physicalService.findPageByVO(vo, page);
		mv.addObject("physicalResult", EmPhysicalResultType.getPhysicalResultTypeMap());// 体检结果
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("vo", vo);
		mv.addObject("typeList", this.physicalService.findPhysicalTypeAll());
		return mv;
	}

	/***
	 * 体检参数添加页面
	 * 
	 * @return
	 */
	@RequestMapping("addPage.htm")
	@SecurityMapping(title = "体检编辑页面", value = "/addPage.htm", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	public ModelAndView add_valuation_page(HttpServletRequest request, HttpServletResponse response,
			String flag, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/physical/physical_valuation_add.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("typeList", this.physicalService.findPhysicalTypeAll());
		mv.addObject("physicalResult", EmPhysicalResultType.getPhysicalResultTypeMap());// 体检结果
		if (flag != null && flag.equals("1")) {
			PhysicalValuationBO valuation = this.physicalService.getValuationById(id);
			mv.addObject("valuation", valuation);
			mv.addObject("flag", flag);
		}
		return mv;
	}

	/***
	 * 编辑参考值 添加/修改
	 * 
	 * @return
	 */
	@SecurityMapping(title = "添加参考值", value = "/editValuation.htm", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("editValuation.htm")
	public String edit_valuation(Model model, PhysicalValuationVO vo) {
		this.physicalService.editValuation(vo);
		return "redirect:/admin/checkValuation/pageList.htm";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "删除参考值", value = "/deleteValuation.htm", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("deleteValuation.htm")
	public String delete(Long id) {
		this.physicalService.deleteValuationById(id);
		return "redirect:/admin/checkValuation/pageList.htm";
	}

	/**
	 * 体检管理>任务管理（体检任务列表）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "任务管理", value = "/admin/sys_task_manager_list.htm*", rtype = "admin", rname = "体检管理", rcode = "task_manage", rgroup = "内容管理")
	@RequestMapping("/sys_task_manager_list.htm")
	public ModelAndView sys_task_manager_list(HttpServletRequest request, HttpServletResponse response,
			SysReminderTaskVO vo, MyPage<SysReminderTaskBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/physical/sys_task_manager_list.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(10);
		taskService.findPageByVo(vo, page);
		mv.addObject("vo", vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}

	/**
	 * 体检管理>增加任务
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "增加任务", value = "/admin/sys_task_manager_add.htm*", rtype = "admin", rname = "体检管理", rcode = "task_manage", rgroup = "内容管理")
	@RequestMapping("/sys_task_manager_add.htm")
	public ModelAndView sys_task_manager_add(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/physical/sys_task_manager_add.html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && id > 0) {
			SysReminderTaskBO task = taskService.get(id);
			mv.addObject("task", task);
		}
		mv.addObject("keyWordType", this.physicalService.selectKeyWordTypeList());
		return mv;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@SecurityMapping(title = "保存任务", value = "/admin/sys_task_manager_save.htm*", rtype = "admin", rname = "体检管理", rcode = "task_manage", rgroup = "内容管理")
	@RequestMapping("/sys_task_manager_save.htm")
	public ModelAndView sys_task_manager_save(HttpServletRequest request, HttpServletResponse response,
			SysReminderTask task, String keyword) {
		taskService.save(task, keyword);
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/checkValuation/sys_task_manager_list.htm");
		mv.addObject("op_title", "保存任务成功");
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/checkValuation/sys_task_manager_add.htm");
		return mv;
	}

	@SecurityMapping(title = "删除任务", value = "/admin/sys_task_manager_delete.htm*", rtype = "admin", rname = "体检管理", rcode = "task_manage", rgroup = "内容管理")
	@RequestMapping("/sys_task_manager_delete.htm")
	public String sys_task_manager_delete(String mulitId, Integer currentPage) {
		String[] ids = mulitId.split(",");
		List<Long> temp_ids = new ArrayList<>(ids.length);// 绝对不会超过ids.length的长度
		for (String id : ids) {
			if (!"".equals(id)) {
				temp_ids.add(CommUtil.null2Long(id));
			}
		}
		this.taskService.batchDelete(temp_ids);
		return "redirect:sys_task_manager_list.htm?currentPage=" + currentPage;
	}
}
