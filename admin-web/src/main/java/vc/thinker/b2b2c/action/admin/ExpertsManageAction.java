package vc.thinker.b2b2c.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.RoleService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.SysLogServiceImpl;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.vo.ExpertsVO;
import com.sinco.carnation.user.bo.UserExpertsBO;
import com.sinco.carnation.user.model.UserExperts;
import com.sinco.carnation.user.service.ExpertsService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.common.utils.IPUtil;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: CircleManageAction.java
 * </p>
 * 
 * <p>
 * Description: 专家管理
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
 * @date 2014-11-20
 * 
 * @version 1.0.1
 */
@Controller
public class ExpertsManageAction {

	@Autowired
	private SysConfigService configService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@Autowired
	private SysLogServiceImpl syslogService;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private ExpertsService expertService;

	@Autowired
	private UserAccountService accountService;

	@Autowired
	private WeedFSClient fsClient;

	@SecurityMapping(title = "专家添加", value = "/admin/experts_add.htm*", rtype = "admin", rname = "专家管理", rcode = "expert_manage", rgroup = "系统管理")
	@RequestMapping("/admin/experts_add.htm")
	public ModelAndView experts_add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/experts_add.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("flag", true);
		return mv;
	}

	@SecurityMapping(title = "专家保存", value = "/admin/experts_save.htm*", rtype = "admin", rname = "专家管理", rcode = "expert_manage", rgroup = "系统管理")
	@RequestMapping("/admin/experts_save.htm")
	public ModelAndView experts_save(HttpServletRequest request, HttpServletResponse response, ExpertsVO vo,
			@RequestParam("advertImg") MultipartFile file) {

		if (file != null && file.getSize() != 0) {
			try {
				String fileUrl=FileUploadTools.fileUpload(file, UploadConstants.EDITOR);
				vo.setHeadImgPath(fileUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String requestIp = IPUtil.getIpAddr(request);
		expertService.createExperts(requestIp, vo);

		ModelAndView mv = new JModelAndView("/admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/experts_list.htm");
		if (null != vo.getUid())
			mv.addObject("op_title", "修改成功!");
		else
			mv.addObject("op_title", "添加成功!");
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/experts_add.htm");
		return mv;
	}

	@SecurityMapping(title = "专家列表", value = "/admin/experts_list.htm*", rtype = "admin", rname = "专家管理", rcode = "expert_manage", rgroup = "系统管理")
	@RequestMapping("/admin/experts_list.htm")
	public ModelAndView experts_list(HttpServletRequest request, HttpServletResponse response, ExpertsVO vo,
			MyPage<UserExpertsBO> page, Integer currentPage) {

		ModelAndView mv = new JModelAndView("admin/blue/experts_list.html", configService.getSysConfig(), 0,
				request, response);

		page.setPageSize(10);
		expertService.queryExpertsList(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		mv.addObject("objs", page.getContent());
		return mv;
	}

	@SecurityMapping(title = "专家编辑", value = "/admin/experts_edit.htm*", rtype = "admin", rname = "专家管理", rcode = "expert_manage", rgroup = "系统管理")
	@RequestMapping("/admin/experts_edit.htm")
	public ModelAndView user_edit(HttpServletRequest request, HttpServletResponse response, Long id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/experts_edit.html", configService.getSysConfig(), 0,
				request, response);
		if (null != id && !id.equals("")) {
			UserExpertsBO experts = expertService.selectById(id);
			mv.addObject("exp", experts);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	@SecurityMapping(title = "专家删除", value = "/admin/expert_del.htm*", rtype = "admin", rname = "专家管理", rcode = "expert_manage", rgroup = "系统管理")
	@RequestMapping("/admin/expert_del.htm")
	public String expert_del(HttpServletRequest request, String mulitId, String currentPage) throws Exception {
		expertService.delExpert(mulitId);
		return "redirect:experts_list.htm?currentPage=1";
	}

	@SecurityMapping(title = "抗衰老专家排序", value = "/admin/experts_sort.htm*", rtype = "admin", rname = "专家管理", rcode = "expert_manage", rgroup = "系统管理")
	@RequestMapping("/admin/experts_sort.htm")
	public ModelAndView experts_sort(Integer expertType, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new JModelAndView("admin/blue/experts_sort.html", configService.getSysConfig(), 0,
				request, response);

		List<UserExpertsBO> list = expertService.findList(1);
		mv.addObject("objs", list);

		return mv;
	}

	@SecurityMapping(title = "健康管理师排序", value = "/admin/experts_division_sort.htm*", rtype = "admin", rname = "专家管理", rcode = "expert_manage", rgroup = "系统管理")
	@RequestMapping("/admin/experts_division_sort.htm")
	public ModelAndView experts_division_sort(Integer expertType, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new JModelAndView("admin/blue/experts_division_sort.html",
				configService.getSysConfig(), 0, request, response);

		List<UserExpertsBO> list = expertService.findList(2);
		mv.addObject("objs", list);

		return mv;
	}

	@SecurityMapping(title = "专家排序保存", value = "/admin/experts_sort_save.htm*", rtype = "admin", rname = "专家管理", rcode = "expert_manage", rgroup = "系统管理")
	@RequestMapping("/admin/experts_sort_save.htm")
	public ModelAndView experts_sort_save(HttpServletRequest request, HttpServletResponse response,
			String idVals) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);

		List<UserExperts> list = null;
		if (idVals != null && idVals.length() > 0) {
			String[] idValArr = idVals.split(";");
			list = new ArrayList<UserExperts>(idValArr.length);
			for (String idValStrs : idValArr) {
				String[] idValStr = idValStrs.split(",");
				UserExperts userExperts = new UserExperts();
				userExperts.setUid(CommUtil.null2Long(idValStr[0]));
				userExperts.setExpertIndex(CommUtil.null2Int(idValStr[1]));
				list.add(userExperts);
			}
			expertService.batchUpdate(list);
		}

		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/experts_sort.htm");
		mv.addObject("op_title", "保存推荐顺序成功");

		return mv;
	}

}
