package vc.thinker.b2b2c.action.check;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.tools.WeekTools;

import com.sinco.carnation.sys.bo.SysTaskLogBO;
import com.sinco.carnation.sys.model.SysTaskLog;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.vo.SysTaskLogVO;
import com.sinco.carnation.user.bo.PhysicalResultBO;
import com.sinco.carnation.user.bo.PhysicalTypeBO;
import com.sinco.carnation.user.enums.EmPhysicalResultType;
import com.sinco.carnation.user.service.PhysicalService;
import com.sinco.carnation.user.vo.PhysicalResultVO;
import com.sinco.dal.common.MyPage;

/***
 * 体检相关
 * 
 * @author LKN
 * 
 */
@Controller
public class CheckPhysicalTypeAction {

	@Autowired
	private SysConfigService configService;

	@Autowired
	private PhysicalService physicalService;

	@Autowired
	private WeekTools weekTools;

	/**
	 * 体检项查询
	 * 
	 * @return
	 */
	@SecurityMapping(title = "体检项查询", value = "/admin/CheckPhysicalType.htm*", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("/admin/CheckPhysicalType.htm")
	public ModelAndView check_Configure_List(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/physical/check_physical_type_List.html",
				configService.getSysConfig(), 0, request, response);
		List<PhysicalTypeBO> list = physicalService.findPhysicalTypeAll();
		mv.addObject("list", list);
		return mv;
	}

	/**
	 * 体检记录管理
	 * 
	 * @return
	 */
	@SecurityMapping(title = "体检记录管理", value = "/admin/checkPhysicalResultList.htm*", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("/admin/checkPhysicalResultList.htm")
	public ModelAndView check_physical_result_list(HttpServletRequest request, HttpServletResponse response,
			PhysicalResultVO vo, MyPage<PhysicalResultBO> myPage, Integer size, Integer page) {
		ModelAndView mv = new JModelAndView("admin/blue/physical/check_physical_result_list.html",
				configService.getSysConfig(), 0, request, response);

		if (page == null)
			page = 1;
		if (size == null)
			size = myPage.getPageSize();
		myPage.setPageSize(size);
		myPage.setPageNumber(page);

		List<PhysicalResultBO> list = physicalService.selectPhysicalResultByVO(vo, myPage);
		mv.addObject("physicalResult", EmPhysicalResultType.getPhysicalResultTypeMap());
		mv.addObject("typeList", physicalService.findPhysicalTypeAll());
		mv.addObject("list", list);
		mv.addObject("vo", vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", myPage, mv);
		return mv;
	}

	/**
	 * 体检记录管理-删除体检记录
	 * 
	 * @return
	 */
	@SecurityMapping(title = "删除体检记录", value = "/admin/checkPhysicalResultDel.htm*", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("/admin/checkPhysicalResultDel.htm")
	public String check_physical_result_del(HttpServletRequest request, HttpServletResponse response,
			String id) {
		if (physicalService.updateResultByIdForIsDel(Integer.parseInt(id), true))
			System.out.println(123);
		return "redirect:checkPhysicalResultList.htm";
	}

	/**
	 * 用户任务记录
	 * 
	 * @return
	 */
	@SecurityMapping(title = "用户任务记录", value = "/admin/sys_task_log.htm*", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("/admin/sys_task_log.htm")
	public ModelAndView sys_task_log_list(HttpServletRequest request, HttpServletResponse response,
			SysTaskLogVO vo, MyPage<SysTaskLogBO> myPage, Integer size, Integer page) {
		ModelAndView mv = new JModelAndView("admin/blue/physical/sys_task_log.html",
				configService.getSysConfig(), 0, request, response);

		if (page == null)
			page = 1;
		if (size == null)
			size = myPage.getPageSize();
		myPage.setPageSize(size);
		myPage.setPageNumber(page);

		List<SysTaskLogBO> list = physicalService.selectByVO(vo, myPage);
		mv.addObject("list", list);
		mv.addObject("weekTools", weekTools);
		mv.addObject("vo", vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", myPage, mv);
		return mv;
	}

	/**
	 * 用户任务记录-删除用户任务记录
	 * 
	 * @return
	 */
	@SecurityMapping(title = "删除体检记录", value = "/admin/sys_task_log_del.htm*", rtype = "admin", rname = "体检管理", rcode = "check_report_admin", rgroup = "内容管理")
	@RequestMapping("/admin/sys_task_log_del.htm")
	public String sys_task_log_del(HttpServletRequest request, HttpServletResponse response, String id) {
		SysTaskLog record = new SysTaskLog();
		record.setId(Long.parseLong(id));
		record.setDeleteStatus((byte) 1);
		if (physicalService.updateTaskLogByIdForIsDel(record))
			System.out.println("成功");
		return "redirect:sys_task_log.htm";
	}
}
