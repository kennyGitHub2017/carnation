package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Lists;
import com.sinco.carnation.selftest.bo.WenJuanThemeBO;
import com.sinco.carnation.selftest.model.WenJuanTheme;
import com.sinco.carnation.selftest.vo.WenJuanThemeVO;
import com.sinco.carnation.sns.bo.WenJuanGroupBO;
import com.sinco.carnation.sns.bo.WenJuanGroupResultBO;
import com.sinco.carnation.sns.bo.WenJuanQuestionBO;
import com.sinco.carnation.sns.bo.WenJuanQuestionOptionBO;
import com.sinco.carnation.sns.model.WenJuanGroup;
import com.sinco.carnation.sns.vo.WenJuanGroupResultVO;
import com.sinco.carnation.sns.vo.WenJuanGroupVO;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.wenjuan.service.WenJuanGropService;
import com.sinco.carnation.wenjuan.service.WenJuanGroupResultService;
import com.sinco.carnation.wenjuan.service.WenJuanManageService;
import com.sinco.carnation.wenjuan.service.WenJuanQuestionService;
import com.sinco.dal.common.MyPage;

/**
 * 问卷管理
 * 
 * @author yuleijia
 */
@Controller
public class WenJuanManageAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private WenJuanManageService wenJuanManageService;
	@Autowired
	private WenJuanGropService wenJuanGroupService;
	@Autowired
	private WenJuanGroupResultService WenJuanGroupResultService;
	@Autowired
	private WenJuanQuestionService wenJuanQuestionService;

	// ///////////////////////////////////主题模块//////////////////////////////////////
	/**
	 * 问卷主题列表
	 * 
	 * @return
	 */
	@SecurityMapping(title = "问卷主题", value = "/admin/wj_theme_list.htm*", rtype = "admin", rname = "问卷主题", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/wj_theme_list.htm")
	public ModelAndView get_WenJuan_Theme_List(HttpServletRequest request, HttpServletResponse response,
			MyPage<WenJuanTheme> page, String currentPage, String labelName) {
		ModelAndView mv = new JModelAndView("admin/blue/wj_theme_list.html", configService.getSysConfig(), 0,
				request, response);
		WenJuanThemeVO vo = new WenJuanThemeVO();

		wenJuanManageService.findByPage(page, vo);

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		com.sinco.dal.utils.DateUtils dataUtile = new com.sinco.dal.utils.DateUtils();
		mv.addObject("dataUtile", dataUtile);

		return mv;
	}

	/**
	 * 添加主题界面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "添加问卷主题界面", value = "/admin/wj_theme_add.htm*", rtype = "admin", rname = "添加问卷主题界面", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/wj_theme_add.htm")
	public ModelAndView add_WenJuanTheme_Page(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/wj_theme_add.html", configService.getSysConfig(), 0,
				request, response);

		return mv;
	}

	/**
	 * 添加主题
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @return
	 */
	@SecurityMapping(title = "添加问卷主题", value = "/admin/add_wj_Theme.htm*", rtype = "admin", rname = "添加问卷主题", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/add_wj_Theme.htm")
	public ModelAndView add_WenJuanTheme(HttpServletRequest request, HttpServletResponse response,
			WenJuanThemeVO vo, String list_url, String add_url) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		vo.setCreateUserid(0L);
		this.wenJuanManageService.save_wj_Theme(vo);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存问卷主题成功");
		return mv;
	}

	/**
	 * 删除问卷主题
	 * 
	 * @param request
	 * @param response
	 * @param mulitId
	 * @return
	 */
	@SecurityMapping(title = "删除问卷主题", value = "/admin/add_wj_Theme.htm*", rtype = "admin", rname = "删除问卷主题", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/del_wj_Theme.htm")
	public String del_wj_Theme(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String[] ids = mulitId.split(",");
		List<Long> idList = Lists.newArrayList();
		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}
		this.wenJuanManageService.del_wj_Theme(idList);
		return "redirect:wj_theme_list.htm";
	}

	/**
	 * 编辑问卷主题
	 * 
	 * @param request
	 * @param id
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value = "/admin/edit_wj_Theme.htm")
	public ModelAndView edit_wj_Theme(HttpServletRequest request, String id, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/wj_theme_add.html", configService.getSysConfig(), 0,
				request, response);
		if (id != null && !id.equals("")) {
			long id_ = Long.parseLong(id);
			WenJuanTheme result = this.wenJuanManageService.query_wj_ThemeOne(id_);
			mv.addObject("obj", result);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	// ///////////////////////////////////题组模块//////////////////////////////////////
	/**
	 * 问卷题组列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "问卷题组列表", value = "/admin/wj_Group_list.htm*", rtype = "admin", rname = "问卷题组列表", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/wj_Group_list.htm")
	public ModelAndView query_wj_group_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<WenJuanGroupVO> page, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/wj_group_list.html", configService.getSysConfig(), 0,
				request, response);

		WenJuanGroupVO vo = new WenJuanGroupVO();

		this.wenJuanManageService.query_WenJuanGroup_byPage(page, vo);

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		com.sinco.dal.utils.DateUtils dataUtile = new com.sinco.dal.utils.DateUtils();
		mv.addObject("dataUtile", dataUtile);
		return mv;
	}

	/**
	 * 结果管理
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param currentPage
	 * @return
	 */
	@SuppressWarnings("null")
	@SecurityMapping(title = "问卷主题", value = "/admin/wj_GroupResult_list.htm*", rtype = "admin", rname = "问卷主题", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/wj_GroupResult_list.htm")
	public ModelAndView get_WenJuan_GroupResult_list(HttpServletRequest request,
			HttpServletResponse response, MyPage<WenJuanGroupResultVO> page, String currentPage,
			String themeID, String groupID) {
		ModelAndView mv = new JModelAndView("admin/blue/wj_group_result_list.html",
				configService.getSysConfig(), 0, request, response);

		Long themeID_ = null;
		Long groupID_ = null;
		if (themeID != null && themeID.trim().length() > 0) {
			themeID_ = Long.parseLong(themeID);
		} else if (groupID != null || groupID.trim().length() > 0) {
			groupID_ = Long.parseLong(groupID);
		}
		WenJuanGroupResultVO vo = new WenJuanGroupResultVO();
		vo.setWjGroupId(groupID_);
		vo.setWjThemeID(themeID_);
		this.wenJuanManageService.query_WenJuanGroupResult_findByPage(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("groupID", groupID_);
		mv.addObject("themeID", themeID_);
		return mv;
	}

	/**
	 * 题目管理
	 * 
	 * @param request
	 * @param response
	 * @param groupID
	 * @return
	 */
	@SecurityMapping(title = "问卷主题", value = "/admin/wj_question_list.htm*", rtype = "admin", rname = "问卷主题", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/wj_question_list.htm")
	public ModelAndView query_WenJuan_Question_List(HttpServletRequest request, HttpServletResponse response,
			String groupID) {
		ModelAndView mv = new JModelAndView("admin/blue/wj_question_list.html", configService.getSysConfig(),
				0, request, response);

		Long groupID_ = 0L;
		if (groupID != null && groupID.trim().length() > 0) {
			groupID_ = Long.parseLong(groupID);
		}
		List<WenJuanQuestionBO> list = this.wenJuanManageService.query_WenJuanQuestion_ByGroupID(groupID_);
		mv.addObject("list", list);
		mv.addObject("groupID", groupID_);
		return mv;
	}

	@SecurityMapping(title = "添加题目", value = "/admin/wj_question_add.htm*", rtype = "admin", rname = "添加题目", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/wj_question_add.htm")
	public ModelAndView add_WenJuan_Question_Page(HttpServletRequest request, HttpServletResponse response,
			String groupID, String questionID) {
		ModelAndView mv = new JModelAndView("admin/blue/wj_question_add.html", configService.getSysConfig(),
				0, request, response);
		boolean isOption = false;
		if (questionID != null && questionID.trim().length() > 0) {
			Long questionIDL = Long.parseLong(questionID);
			WenJuanQuestionBO questionBO = this.wenJuanManageService.queryQuestionByID(questionIDL);
			List<WenJuanQuestionOptionBO> list = this.wenJuanManageService.queryQuestionOpetion(questionIDL);
			for (WenJuanQuestionOptionBO option : list) {
				if (option.getOptionIndex() == null) {
					option.setOptionIndex(0);
				}
			}
			mv.addObject("list", list);
			mv.addObject("question", questionBO);
		} else {
			isOption = true;
		}
		mv.addObject("isOption", isOption);
		mv.addObject("groupID", groupID);
		return mv;
	}

	@SecurityMapping(title = "添加题目", value = "/admin/save_WenJuan_Question.htm*", rtype = "admin", rname = "添加题目", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/save_WenJuan_Question.htm")
	public ModelAndView save_WenJuan_Question(HttpServletRequest request, HttpServletResponse response,
			Long id, Long groupId, String questionTitle, Integer questionIndex, Long[] optionId,
			Integer[] optionIndex, String[] optionDesc, Integer[] score, String list_url) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		String op_title = "保存题目成功";
		User user = SecurityUserHolder.getCurrentUser();
		Long userID = user.getId();
		if (id == null) {
			this.wenJuanQuestionService.addQuestion(id, groupId, questionTitle, questionIndex, optionIndex,
					optionDesc, score, userID);
		} else {
			this.wenJuanQuestionService.updateQuestion(id, groupId, questionTitle, questionIndex, optionId,
					optionIndex, optionDesc, score, userID);
		}
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", op_title);
		return mv;
	}

	/**
	 * 题组-新增界面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "新增题组", value = "/admin/wj_group_add.htm*", rtype = "admin", rname = "问卷题组", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/wj_group_add.htm")
	public ModelAndView wenJuanGroup_Add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/wj_group_add.html", configService.getSysConfig(), 0,
				request, response);

		List<WenJuanThemeBO> themeList = this.wenJuanManageService.queryWenJuanThemeList();
		// List<WenJuanGroupBO> groupList = this.wenJuanManageService.queryWenJuanGroupList();
		mv.addObject("themeList", themeList);
		// mv.addObject("groupList", groupList);
		return mv;
	}

	/**
	 * 根据主题ID获取题组
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "附属题组", value = "/admin/wj_groupByThemeID_Ajax.htm*", rtype = "admin", rname = "问卷题组", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/wj_groupByThemeID_Ajax.htm")
	public void query_WenJuanGroup_By_ThemeID_Ajax(HttpServletRequest request, HttpServletResponse response,
			String themeID) {
		String ret = "";
		if (themeID != null && themeID.trim().length() > 0) {
			List<WenJuanGroupBO> wenJuanGroup_List = wenJuanGroupService.getWenJuanList(Long
					.parseLong(themeID));
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			for (WenJuanGroupBO wenJuanGroup : wenJuanGroup_List) {
				Map<String, String> mapTemp = new HashMap<String, String>();
				mapTemp.put("id", String.valueOf(wenJuanGroup.getId()));
				mapTemp.put("title", wenJuanGroup.getGroupTitle());
				list.add(mapTemp);
			}
			JSONObject json = new JSONObject();
			json.element("result", list);
			ret = json.toString();
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
	 * 题组-新增操作
	 * 
	 * @param request
	 * @param response
	 * @param list_url
	 * @return
	 */
	@SecurityMapping(title = "新增题组", value = "/admin/do_group_add.htm*", rtype = "admin", rname = "问卷题组", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/do_group_add.htm")
	public ModelAndView add_WenJuanGroup(HttpServletRequest request, HttpServletResponse response,
			String list_url, WenJuanGroupVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		Long id = vo.getId();
		String op_title = "保存问卷组成功";
		if (id != null) {
			op_title = "更新问卷组成功";
			this.wenJuanGroupService.updateWenJuanGroupByID(vo);
		} else {
			WenJuanGroup result = this.wenJuanManageService.saveWenJuanGroup(vo);
			if (result.getId() != null && result.getId() != 0l) {

			} else {
				op_title = "保存问卷组失败";
				mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
						response);
			}
		}
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", op_title);
		return mv;
	}

	/**
	 * 编辑题组界面
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "新增题组", value = "/admin/edit_WenJuangroup.htm*", rtype = "admin", rname = "问卷题组", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/edit_WenJuangroup.htm")
	public ModelAndView edit_WenJuanGroup(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/wj_group_add.html", configService.getSysConfig(), 0,
				request, response);
		WenJuanGroupBO bo = null;
		if (id != null && id.trim().length() > 0) {
			Long idL = Long.parseLong(id);
			bo = wenJuanGroupService.query_WenJuanGroupByID(idL);
		}
		List<WenJuanThemeBO> themeList = this.wenJuanManageService.queryWenJuanThemeList();
		mv.addObject("themeList", themeList);
		mv.addObject("wenJuanGroup", bo);
		mv.addObject("edit", true);
		return mv;
	}

	/**
	 * 删除题组
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "删除题组", value = "/admin/del_WenJuangroup.htm*", rtype = "admin", rname = "问卷题组", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/del_WenJuangroup.htm")
	public ModelAndView del_WenJuanGroup(HttpServletRequest request, HttpServletResponse response,
			String mulitId) {
		ModelAndView mv = new ModelAndView("redirect:wj_Group_list.htm");
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			this.wenJuanGroupService.deleteByID(Long.parseLong(id));
		}
		return mv;
	}

	/**
	 * 问卷结果界面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "问卷结果界面", value = "/admin/add_WenJuanGroupResult.htm*", rtype = "admin", rname = "问卷题组", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/add_WenJuanGroupResult.htm")
	public ModelAndView addPage_WenJuanGroupResult(HttpServletRequest request, HttpServletResponse response,
			String themeID, String groupID) {
		ModelAndView mv = new JModelAndView("admin/blue/wj_group_result_add.html",
				configService.getSysConfig(), 0, request, response);
		Integer maxScore = 0;
		Integer minScore = 0;
		WenJuanGroupResultBO bo = null;
		if (themeID != null && themeID.trim().length() > 0) {
			Long themeIDL = Long.parseLong(themeID);
			bo = this.WenJuanGroupResultService.queryResultMaxAndMinSoreByThemeID(themeIDL);
		} else if (groupID != null && groupID.trim().length() > 0) {
			Long groupIDL = Long.parseLong(groupID);
			bo = this.WenJuanGroupResultService.queryResultMaxAndMinSoreByGroupID(groupIDL);
		}
		maxScore = bo.getMaxScore();
		minScore = bo.getMinScore();
		mv.addObject("maxScore", maxScore);
		mv.addObject("minScore", minScore);
		mv.addObject("startScore", maxScore + 1);
		mv.addObject("themeID", themeID);
		mv.addObject("groupID", groupID);
		return mv;
	}

	/**
	 * 添加问卷评分结果
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "问卷评分结果", value = "/admin/save_WenJuanGroupResult.htm*", rtype = "admin", rname = "问卷题组", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/save_WenJuanGroupResult.htm")
	public ModelAndView save_WenJuanGroupResult(HttpServletRequest request, HttpServletResponse response,
			WenJuanGroupResultVO vo, String id, String listUrl) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		String op_title = "保存评分结果成功";
		if (id != null && id.trim().length() > 0) {

		} else {
			String healthStatus = vo.getHealthStatus();
			if ("chronic".equals(healthStatus)) {
				vo.setIsChronic(true);
			} else if ("high".equals(healthStatus)) {
				vo.setIsHigh(true);
			} else if ("yjk".equals(healthStatus)) {
				vo.setIsYjk(true);
			} else if ("healthy".equals(healthStatus)) {
				vo.setIsHealthy(true);
			}
			vo.setIsDeleted(false);
			Long resultID = this.WenJuanGroupResultService.saveWenJuanGroupResult(vo);
			if (resultID == null || resultID == 0L) {
				op_title = "保存评分结果失败";
			}
		}
		mv.addObject("list_url", listUrl);
		mv.addObject("op_title", op_title);
		return mv;
	}

	/**
	 * 删除问卷评分结果
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param themeID
	 * @param groupID
	 * @return
	 */
	@SecurityMapping(title = "删除问卷评分结果", value = "/admin/del_WenJuanGroupResult.htm*", rtype = "admin", rname = "问卷题组", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/del_WenJuanGroupResult.htm")
	public ModelAndView del_WenJuanGroupResult(HttpServletRequest request, HttpServletResponse response,
			String id, String themeID, String groupID) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		String op_title = "删除操作成功";
		if (id != null && id.trim().length() > 0) {
			Long idL = Long.parseLong(id);
			this.WenJuanGroupResultService.deleteByID(idL);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			op_title = "删除操作失败，参数有误";
		}
		String webPath = CommUtil.getURL(request);
		String listUrl = webPath + "/admin/wj_GroupResult_list.htm?groupID=" + groupID + "&themeID="
				+ themeID;
		mv.addObject("list_url", listUrl);
		mv.addObject("op_title", op_title);
		return mv;
	}

	/**
	 * 删除问卷题目
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param groupID
	 * @return
	 */
	@SecurityMapping(title = "删除问卷题目", value = "/admin/deleteWenJuanQuestion.htm*", rtype = "admin", rname = "问卷题组", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/deleteWenJuanQuestion.htm")
	public ModelAndView del_WenJuanQuestion(HttpServletRequest request, HttpServletResponse response,
			String questionID, String groupID) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		String op_title = "删除操作成功";
		this.wenJuanQuestionService.deleteQuestionAndOption(Long.parseLong(questionID));
		String webPath = CommUtil.getURL(request);
		String listUrl = webPath + "/admin/wj_question_list.htm?groupID=" + groupID;
		mv.addObject("list_url", listUrl);
		mv.addObject("op_title", op_title);
		return mv;
	}

	/**
	 * 删除问卷题目选项
	 * 
	 * @param request
	 * @param response
	 * @param groupID
	 * @param questionID
	 * @return
	 */
	@SecurityMapping(title = "删除问卷题目选项", value = "/admin/deleteWenJuanQuestionOption.htm*", rtype = "admin", rname = "问卷题组", rcode = "wenjuan", rgroup = "问卷管理")
	@RequestMapping(value = "/admin/deleteWenJuanQuestionOption.htm")
	public void del_WenJuanQuestionOption(HttpServletRequest request, HttpServletResponse response, String id) {
		/*ModelAndView mv = new JModelAndView("admin/blue/success.html",configService.getSysConfig(), 0, request, response);
		String op_title = "删除操作成功";
		this.wenJuanQuestionService.delteQuestionOptionByID(Long.parseLong(id));
		String webPath = CommUtil.getURL(request);
		String listUrl = webPath + "/admin/wj_question_add.htm?groupID="+ groupID+"&questionID="+questionID;
		mv.addObject("list_url", listUrl);
		mv.addObject("op_title", op_title);
		return mv;*/
		this.wenJuanQuestionService.delteQuestionOptionByID(Long.parseLong(id));
	}
}
