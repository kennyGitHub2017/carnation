package vc.thinker.b2b2c.action.check;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.RequestResult;
import net.weedfs.client.WeedFSClient;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

import com.sinco.carnation.check.service.CheckClassService;
import com.sinco.carnation.check.service.CheckGroupService;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.sns.bo.CheckClassBO;
import com.sinco.carnation.sns.bo.CheckGroupBO;
import com.sinco.carnation.sns.model.CheckClass;
import com.sinco.carnation.sns.vo.CheckClassVO;
import com.sinco.carnation.sns.vo.CheckGroupVO;
import com.sinco.carnation.sys.model.User;
//import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
//import com.sinco.carnation.sys.service.UserService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: CircleManageAction.java
 * </p>
 * 
 * <p>
 * Description: 自测题管理，
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
public class CheckManageAction {
	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private AccessoryServiceImpl accessoryService;
	@Autowired
	private CheckClassService checkClassService;
	@Autowired
	private CheckGroupService checkGroupService;

	@Autowired
	private WeedFSClient fsClient;

	/**
	 * 自测题组列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "自测题组列表", value = "/admin/check_group_list.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_group_list.htm")
	public ModelAndView check_group_list(HttpServletRequest request, HttpServletResponse response,
			CheckGroupVO vo, MyPage<CheckGroupBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/check_group_list.html", configService.getSysConfig(),
				0, request, response);
		page.setPageSize(20);

		checkGroupService.findPageByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		List<CheckClassBO> classList = checkClassService.findAll();
		mv.addObject("vo", vo);
		mv.addObject("classList", classList);
		return mv;
	}

	@SecurityMapping(title = "套题删除", value = "/admin/check_group_delete.htm*", rtype = "admin", rname = "自测题管理", rcode = "admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_group_delete.htm")
	public String check_group_delete(HttpServletRequest request, HttpServletResponse response,
			String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");
		User user = SecurityUserHolder.getCurrentUser();
		checkGroupService.batchDelete(ids, user.getId());
		return "redirect:check_group_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "套题添加", value = "/admin/check_group_add.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_group_add.htm")
	public ModelAndView check_group_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("/admin/blue/check_group_add.html", configService.getSysConfig(),
				0, request, response);
		List<CheckClassBO> classList = checkClassService.findAll();
		mv.addObject("classList", classList);
		return mv;
	}

	@SecurityMapping(title = "套题关闭", value = "admin/check_group_close.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_group_close.htm")
	@ResponseBody
	public String check_group_close(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String mulitId) {
		String[] ids = mulitId.split(",");
		User user = SecurityUserHolder.getCurrentUser();
		try {
			checkGroupService.batchUpdateIsClosed(ids, user.getId(), 1);
			return "1";// 更新成功
		} catch (Exception e) {
			log.error("套题更新状态值更新异常{}", CommUtil.getStackTrace(e));
			return "0";
		}
		// return "redirect:check_group_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "套题启用", value = "admin/check_group_open.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_group_open.htm")
	@ResponseBody
	public String check_group_open(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String mulitId) {
		String[] ids = mulitId.split(",");
		User user = SecurityUserHolder.getCurrentUser();
		try {
			checkGroupService.batchUpdateIsClosed(ids, user.getId(), 0);
			return "1";// 更新成功
		} catch (Exception e) {
			log.error("套题更新状态值更新异常{}", CommUtil.getStackTrace(e));
			return "0";
		}
	}

	private static final Logger log = LoggerFactory.getLogger(CheckManageAction.class);

	@SecurityMapping(title = "套题更新权重值", value = "admin/check_group_update_ajax.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_group_update_ajax.htm")
	@ResponseBody
	public String check_group_update_ajax(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id, String checkGroupSequence) {
		try {

			String code;
			if (StringUtils.isBlank(checkGroupSequence)) {
				code = "4";// 不能为空
				return code;
			}

			User user = SecurityUserHolder.getCurrentUser();
			CheckGroupVO vo = new CheckGroupVO();
			vo.setId(CommUtil.null2Long(id));
			vo.setCheckGroupSequence(CommUtil.null2Int(checkGroupSequence));
			if (checkGroupService.findBySequence(CommUtil.null2Long(checkGroupSequence)) != null) {// 判断权重值是否存在
				code = "0";// 已存在
				return code;
			}
			checkGroupService.updateCheckGroup(vo, user.getId());
			return "1";// 更新成功
		} catch (Exception e) {
			log.error("套题更新权重值更新异常{}", CommUtil.getStackTrace(e));
			return "3";
		}

	}

	@SecurityMapping(title = "套题编辑", value = "/admin/check_group_edit.htm*", rtype = "admin", rname = "自测题管理", rcode = "information_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_group_edit.htm")
	public ModelAndView check_group_edit(HttpServletRequest request, HttpServletResponse response, Long id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/check_group_add.html", configService.getSysConfig(),
				0, request, response);
		List<CheckClassBO> classList = checkClassService.findAll();
		mv.addObject("classList", classList);
		if (id != null && !id.equals("")) {
			CheckGroupBO checkGroupBO = checkGroupService.findById(id);
			mv.addObject("obj", checkGroupBO);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "套题保存", value = "/admin/check_group_save.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_group_save.htm")
	public ModelAndView check_group_save(HttpServletRequest request, HttpServletResponse response,
			CheckGroupVO vo, String listUrl, String addUrl, @RequestParam("cover") MultipartFile file) {
		User user = SecurityUserHolder.getCurrentUser();

		if (file != null && file.getSize() != 0) {
			RequestResult result;
			try {
				String fileUrl = FileUploadTools.fileUpload(file, UploadConstants.EDITOR);
				vo.setThumbnail(fileUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (vo.getId() != null) {
			checkGroupService.updateCheckGroup(vo, user.getId());
		} else {
			checkGroupService.addCheckGroup(vo, user.getId());
		}

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", listUrl);
		mv.addObject("op_title", "保存自测套题成功");
		if (addUrl != null) {
			mv.addObject("add_url", addUrl);
		}
		return mv;
	}

	/**
	 * 自测题类别列表
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param page
	 * @return
	 */
	@SecurityMapping(title = "自测题类别列表", value = "/admin/check_class_list.htm*", rtype = "admin", rname = "自测题类别管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_class_list.htm")
	public ModelAndView check_class_list(HttpServletRequest request, HttpServletResponse response,
			CheckClassVO vo, MyPage<CheckClassBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/check_class_list.html", configService.getSysConfig(),
				0, request, response);
		page.setPageSize(20);
		vo.setParentId(new Long(0));

		this.checkClassService.findPageByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		return mv;
	}

	/**
	 * 自测题类别下级加载
	 * 
	 * @param request
	 * @param response
	 * @param pid
	 * @return
	 */
	@SecurityMapping(title = "自测题类别下级加载", value = "/admin/check_class_data.htm*", rtype = "admin", rname = "自测题类别管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_class_data.htm")
	public ModelAndView check_class_data(HttpServletRequest request, HttpServletResponse response, Long pid) {
		ModelAndView mv = new JModelAndView("admin/blue/check_class_data.html", configService.getSysConfig(),
				0, request, response);
		if (pid != null && pid > 0) {
			List<CheckClass> list = this.checkClassService.findListByParentId(pid);
			mv.addObject("gcs", list);
		}
		return mv;
	}

	/**
	 * 自测题分类Ajax更新
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param fieldName
	 * @param value
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "自测题分类Ajax更新", value = "/admin/check_class_ajax.htm*", rtype = "admin", rname = "自测题类别管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_class_ajax.htm")
	public ModelAndView check_class_ajax(HttpServletRequest request, HttpServletResponse response, Long id,
			String fieldName, String value) throws ClassNotFoundException {
		ModelAndView mv = new JModelAndView("admin/blue/check_class_data.html", configService.getSysConfig(),
				0, request, response);

		Object val = null;
		if (id != null && id > 0) {
			CheckClass gc = this.checkClassService.getById(id);
			Field[] fields = GoodsClass.class.getDeclaredFields();
			BeanWrapper wrapper = new BeanWrapper(gc);
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

			this.checkClassService.update(gc);
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(val.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return mv;
	}

	/**
	 * 自测题分类添加
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "自测题分类添加", value = "/admin/check_class_add.htm*", rtype = "admin", rname = "自测题类别管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_class_add.htm")
	public ModelAndView check_class_add(HttpServletRequest request, HttpServletResponse response,
			CheckClass checkClass) {

		ModelAndView mv = new JModelAndView("admin/blue/check_class_add.html", configService.getSysConfig(),
				0, request, response);

		List<CheckClass> list = this.checkClassService.findListByParentId(new Long(0));
		mv.addObject("gcs", list);

		if (checkClass != null) {
			mv.addObject("obj", checkClass);
		}

		return mv;
	}

	/**
	 * 自测题分类编辑
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "自测题分类编辑", value = "/admin/check_class_edit.htm*", rtype = "admin", rname = "自测题类别管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_class_edit.htm")
	public ModelAndView check_class_edit(HttpServletRequest request, HttpServletResponse response, Long id) {

		ModelAndView mv = new JModelAndView("admin/blue/check_class_add.html", configService.getSysConfig(),
				0, request, response);
		List<CheckClass> list = this.checkClassService.findListByParentId(new Long(0));
		mv.addObject("gcs", list);
		if (id != null && id > 0) {
			CheckClass checkClass = this.checkClassService.getById(id);
			mv.addObject("obj", checkClass);
		}

		mv.addObject("edit", true);
		return mv;
	}

	/**
	 * 自测题分类保存
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "自测题分类保存", value = "/admin/check_class_save.htm*", rtype = "admin", rname = "自测题类别管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_class_save.htm")
	public ModelAndView check_class_save(HttpServletRequest request, HttpServletResponse response,
			String listUrl, String addUrl, CheckClass checkClass) {
		ModelAndView mv = null;

		if (checkClass != null) {
			if (checkClass.getParentId() == null) {
				checkClass.setParentId(new Long(0));
				checkClass.setLevel(0);
			} else {
				checkClass.setLevel(1);
			}
			checkClass.setIsDeleted(Boolean.FALSE);
			if (checkClass.getId() == null) {
				checkClass.setCreateTime(new Date());
				checkClass.setCreateBy(CommUtil.null2Long(SecurityUserHolder.getCurrentUser().getId()));
				this.checkClassService.save(checkClass);
			} else {
				checkClass.setUpdateTime(new Date());
				checkClass.setUpdateBy(CommUtil.null2Long(SecurityUserHolder.getCurrentUser().getId()));
				this.checkClassService.update(checkClass);
			}

			mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "保存商品分类成功");
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "自测题分类保存失败！");
		}
		mv.addObject("list_url", listUrl);
		if (addUrl != null) {
			mv.addObject("add_url", addUrl);
		}

		return mv;
	}

	@RequestMapping("/admin/check_class_verify.htm")
	public void check_class_verify(HttpServletRequest request, HttpServletResponse response,
			String className, String id, String pid) {
		boolean ret = true;
		int count = this.checkClassService.countByName(className,
				StringUtils.isNotBlank(id) ? Long.parseLong(id) : null,
				StringUtils.isNotBlank(pid) ? Long.parseLong(pid) : null);
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
			e.printStackTrace();
		}
	}

	/**
	 * 自测题分类删除
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "自测题分类删除", value = "/admin/check_class_del.htm*", rtype = "admin", rname = "自测题类别管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/check_class_del.htm")
	public String check_class_del(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String[] ids = mulitId.split(",");
		List<Long> idList = new ArrayList<Long>();
		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}
		this.checkClassService.delete(idList.toArray(new Long[idList.size()]));

		return "redirect:check_class_list.htm";
	}
}