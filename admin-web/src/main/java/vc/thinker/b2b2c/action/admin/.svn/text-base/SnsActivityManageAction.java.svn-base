package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.SnsActivityBO;
import com.sinco.carnation.sns.model.SnsActivity;
import com.sinco.carnation.sns.vo.SnsActivityVO;
import com.sinco.carnation.sys.bo.ActApplyBO;
import com.sinco.carnation.sys.bo.ArticleClassBO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.service.ActApplyService;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.ArticleClassService;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.sys.service.SnsActivityService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.tools.SnsActivityTools;
import com.sinco.carnation.sys.vo.ActApplyVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicBase;

@Controller
public class SnsActivityManageAction {
	private final Logger logger = LoggerFactory.getLogger(SnsActivityManageAction.class);
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleClassService articleClassService;
	@Autowired
	private WeedFSClient fsClient;
	@Autowired
	private DicContent dicContant;

	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private SnsActivityService snsActivityService;
	@Autowired
	private ActApplyService actApplyService;

	@Autowired
	private SnsActivityTools snsActivityTools;

	/**
	 * Article列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "活动新闻列表", value = "/admin/snsactivity_list.htm*", rtype = "admin", rname = "活动新闻", rcode = "business_activities", rgroup = "内容管理")
	@RequestMapping("/admin/snsactivity_list.htm")
	public ModelAndView snsactivity_list(HttpServletRequest request, MyPage<SnsActivityBO> myPage,
			HttpServletResponse response, String currentPage, String orderBy, String orderType,
			String articleClassName, String area1, String area2, String area3, SnsActivityVO vo,
			Integer size, Integer page) {
		ModelAndView mv = new JModelAndView("admin/blue/business_activities/snsactivity_list.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotBlank(area1)) {
			Area provinceArea = areaService.findOneById(Long.parseLong(area1));
			mv.addObject("provinceArea", provinceArea);
		}
		if (StringUtils.isNotBlank(area2)) {
			Area cityArea = areaService.findOneById(Long.parseLong(area2));
			mv.addObject("cityArea", cityArea);
		}
		if (StringUtils.isNotBlank(area3)) {
			Area countyArea = areaService.findOneById(Long.parseLong(area3));
			mv.addObject("countyArea", countyArea);
		}

		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}

		if (page == null)
			page = 1;
		if (size == null)
			size = myPage.getPageSize();
		myPage.setPageSize(size);
		myPage.setPageNumber(page);
		List<SnsActivityBO> list = snsActivityService.findbyVO(vo, myPage, area1, area2, area3, null, null);

		mv.addObject("vo", vo);
		mv.addObject("articleClassName", articleClassName);
		mv.addObject("areas", areaService.queryParentArea());
		mv.addObject("snsActivityTools", snsActivityTools);
		if (StringUtils.isEmpty(area1)) {
			CommUtil.saveIPageList2ModelAndView("", "", "", myPage, mv);
			return mv;
		}
		// snsActivityService.saveIPageList2ModelAndView("", "", "", myPage, mv,list);
		myPage.setContent(list);
		CommUtil.saveIPageList2ModelAndView("", "", "", myPage, mv);
		return mv;
	}

	/**
	 * article添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "活动新闻添加", value = "/admin/snsactivity_add.htm*", rtype = "admin", rname = "活动新闻", rcode = "business_activities", rgroup = "内容管理")
	@RequestMapping("/admin/snsactivity_add.htm")
	public ModelAndView snsactivity_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String class_id) {
		ModelAndView mv = new JModelAndView("admin/blue/business_activities/snsactivity_add.html",
				configService.getSysConfig(), 0, request, response);
		List<ArticleClassBO> acs = this.articleClassService.findLevelAll();
		Article obj = new Article();
		obj.setDisplay(true);
		if (class_id != null && !class_id.equals(""))
			obj.setArticleClassId(Long.parseLong(class_id));
		mv.addObject("areas", areaService.queryParentArea());
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
	@SecurityMapping(title = "活动新闻编辑", value = "/admin/snsactivity_edit.htm*", rtype = "admin", rname = "活动新闻", rcode = "business_activities", rgroup = "内容管理")
	@RequestMapping("/admin/snsactivity_edit.htm")
	public ModelAndView snsactivity_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/business_activities/snsactivity_add.html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && !id.equals("")) {
			SnsActivity snsActivity = this.snsActivityService.findOne(Long.parseLong(id));
			/*			List<ArticleClassBO> acs =this.articleClassService.findLevelAll();
						mv.addObject("acs", acs);*/
			mv.addObject("areas", areaService.queryParentArea());
			mv.addObject("area", areaService.fetchAndAllParent(snsActivity.getAreaId()));
			mv.addObject("obj", snsActivity);
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
	@SecurityMapping(title = "活动新闻保存", value = "/admin/snsactivity_save.htm*", rtype = "admin", rname = "活动新闻", rcode = "business_activities", rgroup = "内容管理")
	@RequestMapping("/admin/snsactivity_save.htm")
	public ModelAndView snsactivity_save(HttpServletRequest request, String area3,
			HttpServletResponse response, String id, String currentPage, String list_url, String add_url,
//			String cmd,  String class_id,String artDesc, String keywords, String description,
			String content, @RequestParam("thumImg") MultipartFile file, SnsActivityVO vo) {
		/*		WebForm wf = new WebForm();
				Article article = wf.toPo(request, Article.class);
			//	SnsActivity snsActivity = wf.toPo(request, SnsActivity.class);
			//	snsActivityService
				article.setId(StringUtils.isNotBlank(id) ? Long.parseLong(id) : null);
				
				article.setArticleClassId(Long.parseLong(class_id));
				
				if (file != null && file.getSize() != 0) {
					RequestResult result;
					try {
						result = fsClient.upload(file.getInputStream(), file.getName(),
								URLConnection.guessContentTypeFromName((file.getOriginalFilename())));
						if (result.isSuccess())
							article.setImg(result.getUrl());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}*/

		// this.articleService.save(article);
		try {
			if (file != null && file.getSize() != 0) {
				try {
					String fileUrl=FileUploadTools.fileUpload(file, UploadConstants.SNSACTIVITY);
					vo.setImg(fileUrl);// 活动图片url
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			Date enrollBg = null;
			Date enrollEnd = null;
			Date actBg = null;
			Date actEnd = null;
			if (vo.getStrenrollBg() != null && vo.getStrenrollBg() != "") {
				enrollBg = CommUtil.formatDate(vo.getStrenrollBg(), "yyyy-MM-dd HH:mm:ss");
			}
			if (vo.getStrenrollEnd() != null && vo.getStrenrollEnd() != "") {
				enrollEnd = CommUtil.formatDate(vo.getStrenrollEnd(), "yyyy-MM-dd HH:mm:ss");
			}
			if (vo.getStractBg() != null && vo.getStractBg() != "") {
				actBg = CommUtil.formatDate(vo.getStractBg(), "yyyy-MM-dd HH:mm:ss");
			}
			if (vo.getStractEnd() != null && vo.getStractEnd() != "") {
				actEnd = CommUtil.formatDate(vo.getStractEnd(), "yyyy-MM-dd HH:mm:ss");
			}
			vo.setEnrollBg(enrollBg);
			vo.setEnrollEnd(enrollEnd);
			vo.setActBg(actBg);
			vo.setActEnd(actEnd);
			vo.setAreaId(Long.parseLong(area3));

			if (vo.getDisplay() == null) {
				vo.setDisplay(true);// 是否启用
			}

			/*AdminUserDetails user = (AdminUserDetails) SecurityUserHolder
					.getCurrentUserDetails();
			if(vo.getId() == null&&user!=null){
				vo.setCreateBy(user.getId());
				vo.setCreateTime(new Date());
			}else if(vo.getId() !=null&&user!=null){
				vo.setModifyBy(user.getId());
				vo.setModifyTime(new Date());
			}*/
			if (snsActivityService.save(vo)) {
				ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(),
						0, request, response);

				mv.addObject("list_url", list_url);
				mv.addObject("op_title", "保存成功");
				if (add_url != null) {
					mv.addObject("add_url", add_url + "?currentPage=" + currentPage + "&id=" + id);
				}
				return mv;
			}
			// saleActivityService.getActivityHotSaleDao().save(vo);

		} catch (Exception e) {
			logger.error("[snsactivity_save] error e: "+e);
			e.printStackTrace();
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);

		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存失败");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?currentPage=" + currentPage + "&id=" + id);
		}
		return mv;
	}

	@SecurityMapping(title = "活动新闻删除", value = "/admin/snsactivity_del.htm*", rtype = "admin", rname = "活动新闻", rcode = "business_activities", rgroup = "内容管理")
	@RequestMapping("/admin/snsactivity_del.htm")
	public String snsactivity_del(HttpServletRequest request, String mulitId, SnsActivityVO vo) {
		String[] ids = mulitId.split(",");
		List<Long> idList = Lists.newArrayList();
		for (String id : ids) {
			if (!id.equals("")) {
				SnsActivityBO bo = snsActivityService.findByIdOne(Long.parseLong(id), null);
				if (bo.getDeleteStatus())
					bo.setDeleteStatus(false);
				else
					bo.setDeleteStatus(true);
				snsActivityService.save(bo);
				idList.add(Long.parseLong(id));
			}
		}
		articleService.batchDelete(idList);

		return "redirect:snsactivity_list.htm";
	}

	@RequestMapping("/admin/snsactivity_mark.htm")
	public void snsactivity_mark(HttpServletRequest request, HttpServletResponse response, String mark,
			Long id) {
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

	/**
	 * 根据父id加载下级区域，返回json格式数据，这里只返回id和areaName，根据需要可以修改返回数据
	 * 
	 * @param request
	 * @param response
	 * @param pid
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping("/load_areaAct")
	public void load_area(HttpServletRequest request, HttpServletResponse response, String pid) {

		Collection<DicBase> areas = this.dicContant.getDicsByParentCode(Area.class, pid);

		List<Map> list = new ArrayList<Map>();
		for (DicBase area : areas) {
			Map map = new HashMap();
			map.put("id", area.getCode());
			map.put("areaName", area.getName());
			list.add(map);
		}
		String temp = Json.toJson(list, JsonFormat.compact());
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(temp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "活动申请列表", value = "/admin/actapply_list.htm*", rtype = "admin", rname = "活动新闻", rcode = "business_activities", rgroup = "内容管理")
	@RequestMapping("/admin/actapply_list.htm")
	public ModelAndView actapply_list(HttpServletRequest request, MyPage<ActApplyBO> myPage,
			HttpServletResponse response, String title, String currentPage, String orderBy,
			// String orderType,String articleClassName,
			String areaid1, String areaid2, String areaid3, ActApplyVO vo, Integer size, Integer page) {
		ModelAndView mv = new JModelAndView("admin/blue/business_activities/actapply_list.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("areas", areaService.queryParentArea());
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}

		if (page == null)
			page = 1;
		if (size == null)
			size = myPage.getPageSize();

		myPage.setPageSize(size);
		myPage.setPageNumber(page);

		if (StringUtils.isNotBlank(areaid3)) {
			System.out.println("33333333333");
			List<ActApplyBO> listbo = actApplyService.selectListByVo(vo, myPage);
		} else if (StringUtils.isNotBlank(areaid2)) {
			System.out.println("222222222222");
			List<ActApplyBO> listbo = actApplyService.selectListByVo(vo, myPage);
		} else if (StringUtils.isNotBlank(areaid1)) {
			System.out.println("11111111111");
			List<ActApplyBO> listbo = actApplyService.selectListByVo(vo, myPage);
		} else {
			System.out.println("kkkkkkkkkk");
			List<ActApplyBO> listbo = actApplyService.selectListByVo(vo, myPage);
		}
		// this.articleService.findByPage(title,articleClassName,page);

		System.out.println(String.format("size:%s currentPage:%s", size, page));
		// mv.addObject("title", title);
		// mv.addObject("articleClassName", articleClassName);

		/*
		CommUtil.saveIPageList2ModelAndView(url + "/admin/actapply_list.htm",
				"", "", myPage, mv);*/
		CommUtil.saveIPageList2ModelAndView("", "", "", myPage, mv);
		return mv;
	}

	@SecurityMapping(title = "申请删除", value = "/admin/actapply_del.htm*", rtype = "admin", rname = "活动新闻", rcode = "business_activities", rgroup = "内容管理")
	@RequestMapping("/admin/actapply_del.htm")
	public String actapply_del(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		List<Long> idList = Lists.newArrayList();
		for (String id : ids) {
			if (!id.equals("")) {
				ActApplyBO bo = actApplyService.findOne(Long.parseLong(id));
				if (bo.getDeleteStatus())
					bo.setDeleteStatus(false);
				else
					bo.setDeleteStatus(true);
				actApplyService.save(bo);
				idList.add(Long.parseLong(id));
			}
		}
		articleService.batchDelete(idList);

		return "redirect:actapply_list.htm";
	}

}