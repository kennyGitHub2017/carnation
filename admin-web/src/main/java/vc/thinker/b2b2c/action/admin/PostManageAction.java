package vc.thinker.b2b2c.action.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.DateFormatUtil;

import com.google.common.collect.Lists;
import com.sinco.carnation.healthcircle.bo.PostBO;
import com.sinco.carnation.healthcircle.model.BlacklistPO;
import com.sinco.carnation.healthcircle.model.Post;
import com.sinco.carnation.healthcircle.service.BlacklistService;
import com.sinco.carnation.healthcircle.service.PostService;
import com.sinco.carnation.healthcircle.vo.PostSelectVO;
import com.sinco.carnation.label.model.Label;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.service.LabelService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.common.utils.StringUtils;
import com.sinco.dal.common.MyPage;

@Controller
@SuppressWarnings({"unchecked", "rawtypes"})
public class PostManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private LabelService labelService;
	@Autowired
	private PostService postService;
	@Autowired
	private BlacklistService blacklistService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private UserCustomerService userCustomerService;

	@SecurityMapping(title = "健康圈管理", value = "/admin/post_list.htm*", rtype = "admin", rname = "健康圈管理", rcode = "post", rgroup = "健康圈管理")
	@RequestMapping("/admin/post_list.htm")
	public ModelAndView post_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<PostBO> page, String currentPage, String labelName, String nickName, String acount) {
		ModelAndView mv = new JModelAndView("admin/blue/post_list.html", configService.getSysConfig(), 0,
				request, response);
		PostSelectVO vo = new PostSelectVO();
		if (StringUtils.isNotEmpty(labelName)) {
			vo.setLabelName(labelName.trim());
		}
		if (StringUtils.isNotEmpty(nickName)) {
			vo.setNickName(nickName.trim());
		}
		if (StringUtils.isNotEmpty(acount)) {
			vo.setAccountNo(acount.trim());
		}
		postService.findByPage(page, vo);
		if (page.getContent() != null && !page.getContent().isEmpty()) {
			page.setContent(this.getLabel(page.getContent()));
		}
		mv.addObject("labelName", labelName);
		mv.addObject("nickName", nickName);
		mv.addObject("acount", acount);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	/**
	 * 推荐到健康管理首页
	 * 
	 * @param list
	 * @return
	 */
	@SecurityMapping(title = "健康圈管理", value = "/admin/post_push.htm*", rtype = "admin", rname = "健康圈管理", rcode = "post", rgroup = "健康圈管理")
	@RequestMapping("/admin/post_push.htm")
	public ModelAndView post_push(HttpServletRequest request, HttpServletResponse response,
			MyPage<PostBO> page, String currentPage, String id, String ispush) {
		ModelAndView mv = new JModelAndView("admin/blue/post_list.html", configService.getSysConfig(), 0,
				request, response);
		postService.ispush(id, ispush);
		PostSelectVO vo = new PostSelectVO();
		postService.findByPage(page, vo);
		if (page.getContent() != null && !page.getContent().isEmpty()) {
			page.setContent(this.getLabel(page.getContent()));
		}
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	/**
	 * 删除帖子
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "删除帖子", value = "/admin/post_del.htm*", rtype = "admin", rname = "健康圈管理", rcode = "post", rgroup = "健康圈管理")
	@RequestMapping("/admin/post_del.htm")
	public String post_del(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String[] ids = mulitId.split(",");
		List<Long> idList = Lists.newArrayList();
		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}
		postService.batchDelete(idList);

		return "redirect:post_list.htm";
	}

	/**
	 * 贴子预览
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "贴子预览", value = "/admin/post_preview.htm*", rtype = "admin", rname = "健康管理", rcode = "circle_admin", rgroup = "内容管理")
	@RequestMapping("/admin/post_preview.htm")
	public ModelAndView post_preview(HttpServletRequest request, HttpServletResponse response, Post obj,
			String id) {
		ModelAndView mv = new JModelAndView("admin/blue/post_preview.html", configService.getSysConfig(), 0,
				request, response);
		/*if(StringUtils.isNotEmpty(id)){
			Post post = this.postService.getObjById(Long.parseLong(id));
			if(post!=null){
				
			}
		}
		*/
		mv.addObject("id", id);
		return mv;
	}

	@SecurityMapping(title = "贴子预览", value = "/admin/post_detail.htm*", rtype = "admin", rname = "健康管理", rcode = "circle_admin", rgroup = "内容管理")
	@RequestMapping("/admin/post_detail.htm")
	public ModelAndView post_detail(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/postDetail.html", configService.getSysConfig(), 0,
				request, response);
		// if(StringUtils.isNotEmpty(id)){
		Post post = this.postService.getObjById(Long.parseLong(id));
		// }
		List<Post> list = new ArrayList();
		SimpleDateFormat todayDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (post != null) {
			Date date = post.getAddTime();
			list.add(post);
			list = getImages(list);
			post = list.get(0);
			String addtimeFormat = DateFormatUtil.formatDisplayTime(todayDf.format(date),
					"yyyy-MM-dd HH:mm:ss");
			post.setAddtiemFormat(addtimeFormat);
		}
		mv.addObject("postBO", post);
		return mv;
	}

	public List<PostBO> getLabel(List<PostBO> list) {
		Map<String, String> map = new HashMap();
		List<Label> labelList = labelService.getIdNameMap();
		for (Label label : labelList) {
			map.put(String.valueOf(label.getId()), label.getLabelName());
		}
		if (map.size() > 0) {
			for (PostBO bo : list) {
				bo = this.getName(bo, map);
			}
		}
		return list;
	}

	public PostBO getName(PostBO bo, Map<String, String> map) {
		if (StringUtils.isNotEmpty(bo.getLabelIds())) {
			String[] Ids = bo.getLabelIds().split("\\|");// labelid集合
			String labelNames = null;
			if (ArrayUtils.isNotEmpty(Ids)) {
				for (int i = 0; i < Ids.length; i++) {
					if (i == 0) {
						labelNames = map.get(Ids[i]);
					} else {
						labelNames = labelNames + "," + map.get(Ids[i]);
					}
				}
			}
			if (StringUtils.isNotEmpty(labelNames)) {
				bo.setLabelNames(labelNames);
			}
		}
		return bo;
	}

	/**
	 * 对图片字符串进行相应的处理
	 */
	public List<Post> getImages(List<Post> list) {
		for (Post post : list) {
			String[] images = null;
			String thumbnail = post.getThumbnail();
			if (StringUtils.isNotEmpty(thumbnail)) {
				images = thumbnail.split("\\|");
				post.setImagesList(images);
			}
		}
		return list;
	}

	@SecurityMapping(title = "黑名单管理", value = "/admin/post_blacklist.htm*", rtype = "admin", rname = "健康圈管理", rcode = "post", rgroup = "内容管理")
	@RequestMapping("/admin/post_blacklist.htm")
	public ModelAndView postBlackList(HttpServletRequest request, HttpServletResponse response,
			MyPage<BlacklistPO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/post_blacklist.html", configService.getSysConfig(),
				0, request, response);
		blacklistService.findByPage(page);

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	@SecurityMapping(title = "添加黑名单", value = "/admin/post_add_blacklist.htm*", rtype = "admin", rname = "健康圈管理", rcode = "post", rgroup = "内容管理")
	@RequestMapping("/admin/post_add_blacklist.htm")
	public String postSaveBlackList(HttpServletRequest request, HttpServletResponse response, String userId,
			String cnAccount, String mobile) {
		Long uid = null;
		if (StringUtils.isNotEmpty(mobile)) {
			UserCustomerBO userCustomer = userCustomerService.findByMobile(mobile);
			uid = userCustomer.getUid();
		} else if (StringUtils.isNotEmpty(cnAccount) && cnAccount.startsWith(UserContant.ACCOUNT_TYPE_CN)) {
			UserAccountBO userAccount = userAccountService.findByLoginName(cnAccount);
			uid = userAccount.getUid();
		} else if (StringUtils.isNotEmpty(userId)) {
			uid = CommUtil.null2Long(userId);
		}
		blacklistService.save(uid);

		return "redirect:post_blacklist.htm";
	}

	@SecurityMapping(title = "批量删除黑名单", value = "/admin/post_del_blacklist.htm*", rtype = "admin", rname = "健康圈管理", rcode = "post", rgroup = "内容管理")
	@RequestMapping("/admin/post_del_blacklist.htm")
	public String postDelBlackList(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			blacklistService.deleteBlacklist(CommUtil.null2Long(id));
		}
		return "redirect:post_blacklist.htm";
	}
}
