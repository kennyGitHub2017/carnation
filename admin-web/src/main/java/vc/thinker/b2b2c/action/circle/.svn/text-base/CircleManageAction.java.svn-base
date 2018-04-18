package vc.thinker.b2b2c.action.circle;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.weedfs.client.WeedFSClient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

//import com.sinco.carnation.circle.service.CircleClassServiceImpl;
import com.sinco.carnation.circle.service.CircleServiceImpl;
//import com.sinco.carnation.circle.service.InvitationReplyServiceImpl;
import com.sinco.carnation.circle.service.InvitationServiceImpl;
import com.sinco.carnation.recommend.service.AdvertPositionService;
//import com.sinco.carnation.recommend.service.AdvertService;
import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.sns.model.Circle;
import com.sinco.carnation.sns.model.CircleInvitation;
import com.sinco.carnation.sns.vo.CircleInvitationVO;
import com.sinco.carnation.sns.vo.CircleVO;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.MessageService;
//import com.sinco.carnation.sys.model.UserAccount;
//import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.service.PhysicalService;
//import com.sinco.carnation.sys.service.UserAccountService;
//import com.sinco.carnation.sys.service.UserService;
import com.sinco.dal.common.MyPage;

/**
 * <p>
 * Title: CircleManageAction.java
 * </p>
 * 
 * <p>
 * Description: 商城圈子管理类，用户可以申请圈子，由平台审核，审核通过后该用户成为该圈子管理员，其他用户可以进入该圈子发布帖子，帖子由圈子管理员审核，
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
public class CircleManageAction {
	@Autowired
	private SysConfigService configService;
	// @Autowired
	// private UserService userService;
	// @Autowired
	// private AccessoryServiceImpl accessoryService;
	@Autowired
	private CircleServiceImpl circleService;
	// @Autowired
	// private CircleClassServiceImpl circleclassService;
	@Autowired
	private InvitationServiceImpl invitationService;
	// @Autowired
	// private InvitationReplyServiceImpl invitationReplyService;
	@Autowired
	private WeedFSClient fsClient;
	// @Autowired
	// private UserAccountService userAccountService;
	@Autowired
	private AdvertPositionService advertPositionService;
	// @Autowired
	// private AdvertService advertService;
	@Autowired
	private PhysicalService physicalService;
	@Autowired
	private MessageService messageService;

	/**
	 * 圈子列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "圈子列表", value = "/admin/circle_list.htm*", rtype = "admin", rname = "圈子管理", rcode = "circle_admin", rgroup = "内容管理")
	@RequestMapping("/admin/circle_list.htm")
	public ModelAndView circle_list(HttpServletRequest request, HttpServletResponse response, CircleVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/circle_list.html", configService.getSysConfig(), 0,
				request, response);

		List<Circle> listCircle = circleService.findAllOrderByTimeDesc(vo);

		mv.addObject("vo", vo);
		mv.addObject("listCircle", listCircle);

		return mv;
	}

	/**
	 * 取得圈子详细
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "取得圈子详细", value = "/admin/get_circle_detail.htm*", rtype = "admin", rname = "圈子管理", rcode = "circle_admin", rgroup = "内容管理")
	@RequestMapping("/admin/get_circle_detail.htm")
	public ModelAndView get_circle_detail(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/circle_edit_content.html",
				configService.getSysConfig(), 0, request, response);

		if (id != null && id > 0) {
			Circle circle = this.circleService.getObjById(id);
			mv.addObject("obj", circle);
		}

		return mv;
	}

	/**
	 * 保存圈子相关内容
	 * 
	 * @param request
	 * @param response
	 * @param circle
	 * @return
	 */
	@SecurityMapping(title = "保存圈子相关内容", value = "/admin/circle_save.htm*", rtype = "admin", rname = "圈子管理", rcode = "circle_admin", rgroup = "内容管理")
	@RequestMapping("/admin/circle_save.htm")
	public ModelAndView circle_save(HttpServletRequest request, HttpServletResponse response, Circle circle) {
		ModelAndView mv = new JModelAndView("admin/blue/circle_list.html", configService.getSysConfig(), 0,
				request, response);

		Boolean resultFlag = Boolean.FALSE;
		if (circle != null) {
			resultFlag = this.circleService.save(circle);
		}

		if (resultFlag) {
			mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "保存圈子内容成功！");
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "保存圈子内容失败！");
		}
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/circle_list.htm");

		return mv;
	}

	/**
	 * 圈子列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "用户帖子列表", value = "/admin/circle_invitation.htm*", rtype = "admin", rname = "圈子管理", rcode = "circle_admin", rgroup = "内容管理")
	@RequestMapping("/admin/circle_invitation.htm")
	public ModelAndView circle_invitation(HttpServletRequest request, HttpServletResponse response,
			CircleInvitationVO vo, MyPage<CircleInvitation> page) {
		ModelAndView mv = new JModelAndView("admin/blue/circle_invitation.html",
				configService.getSysConfig(), 0, request, response);

		page.setPageSize(10);

		invitationService.selectPageByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		List<Circle> listCircle = circleService.findAllOrderByTimeDesc(new CircleVO());
		mv.addObject("listCircle", listCircle);
		mv.addObject("vo", vo);
		return mv;
	}

	/**
	 * 贴子预览
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "贴子预览", value = "/admin/circle_preview.htm*", rtype = "admin", rname = "圈子管理", rcode = "circle_admin", rgroup = "内容管理")
	@RequestMapping("/admin/circle_preview.htm")
	public ModelAndView circle_preview(HttpServletRequest request, HttpServletResponse response,
			CircleInvitation obj, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/circle_preview.html", configService.getSysConfig(),
				0, request, response);
		if (StringUtils.isNotEmpty(id)) {
			CircleInvitation circleInvitation = this.invitationService.getObjById(Long.parseLong(id));
			if (circleInvitation != null) {
				obj = circleInvitation;
			}
		}
		mv.addObject("obj", obj);
		return mv;
	}

	/**
	 * 圈子列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "官方帖子列表", value = "/admin/circle_official_invitation.htm*", rtype = "admin", rname = "圈子管理", rcode = "circle_admin", rgroup = "内容管理")
	@RequestMapping("/admin/circle_official_invitation.htm")
	public ModelAndView circle_official_invitation(HttpServletRequest request, HttpServletResponse response,
			CircleInvitationVO vo, MyPage<CircleInvitation> page) {
		ModelAndView mv = new JModelAndView("admin/blue/circle_official_invitation.html",
				configService.getSysConfig(), 0, request, response);

		page.setPageSize(10);

		invitationService.selectPageByOfficVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		List<Circle> listCircle = circleService.findAllOrderByTimeDesc(new CircleVO());
		mv.addObject("listCircle", listCircle);
		mv.addObject("vo", vo);
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "帖子删除", value = "/admin/circle_invitation_delete.htm*", rtype = "admin", rname = "圈子管理", rcode = "circle_admin", rgroup = "内容管理")
	@RequestMapping("/admin/circle_invitation_delete.htm")
	public String circle_invitation_delete(HttpServletRequest request, HttpServletResponse response,
			String mulitId, String currentPage, String cid) {
		String[] ids = mulitId.split(",");
		List temp_ids = new ArrayList();
		for (String id : ids) {
			if (!id.equals("")) {
				temp_ids.add(CommUtil.null2Long(id));
			}
		}
		this.invitationService.batchDelete(temp_ids);
		Circle obj = this.circleService.getObjById(CommUtil.null2Long(cid));
		obj.setInvitationCount(obj.getInvitationCount() - temp_ids.size());
		this.circleService.update(obj);
		return "redirect:circle_invitation.htm?currentPage=" + currentPage + "&cid=" + cid;
	}

	/**
	 * information添加管理 TODO
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "帖子添加", value = "/admin/circle_invitation_add.htm*", rtype = "admin", rname = "帖子管理", rcode = "circle_admin", rgroup = "内容管理")
	@RequestMapping("/admin/circle_invitation_add.htm")
	public ModelAndView information_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/circle_invitation_add.html",
				configService.getSysConfig(), 0, request, response);

		List<Circle> listCircle = circleService.findAllOrderByTimeDesc(new CircleVO());
		mv.addObject("listCircle", listCircle);
		mv.addObject("keyWordType", this.physicalService.selectKeyWordTypeList());// 关键字类型
		return mv;
	}

	/**
	 * information编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "帖子编辑", value = "/admin/circle_invitation_edit.htm*", rtype = "admin", rname = "帖子管理", rcode = "circle_admin", rgroup = "内容管理")
	@RequestMapping("/admin/circle_invitation_edit.htm")
	public ModelAndView information_edit(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/circle_invitation_add.html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && !id.equals("")) {
			CircleInvitation circleInvitation = this.invitationService.getObjById(Long.parseLong(id));
			List<Circle> listCircle = circleService.findAllOrderByTimeDesc(new CircleVO());
			mv.addObject("listCircle", listCircle);
			mv.addObject("obj", circleInvitation);
			mv.addObject("edit", true);
			mv.addObject("keyWordType", this.physicalService.selectKeyWordTypeList());// 关键字类型
		}
		return mv;
	}

	/**
	 * information保存管理 TODO
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "帖子保存", value = "/admin/circle_invitation_save.htm*", rtype = "admin", rname = "帖子管理", rcode = "circle_admin", rgroup = "内容管理")
	@RequestMapping("/admin/circle_invitation_save.htm")
	public ModelAndView information_save(HttpServletRequest request, HttpServletResponse response,
			CircleInvitation circleInvitation, String listUrl, String addUrl,
			@RequestParam("cover") MultipartFile file, @RequestParam("filePic") MultipartFile filePic) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);

		if (circleInvitation != null) {
			String fileUrl=null;
			String secondeFileUrl=null;
			try {
				if (file != null && file.getSize() != 0) {
					fileUrl=FileUploadTools.fileUpload(file, UploadConstants.CIRCLE_INVITATION);
				}

				if (filePic != null && filePic.getSize() != 0) {
					fileUrl=FileUploadTools.fileUpload(filePic, UploadConstants.CIRCLE_INVITATION);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			circleInvitation.setThumbnail(fileUrl);
			circleInvitation.setAppDownloadPic(secondeFileUrl);
			User user = SecurityUserHolder.getCurrentUser();
			if (user.getId() != null && user.getId() > 0) {
				circleInvitation.setUserName(SecurityUserHolder.getCurrentUserDetails().getName());
				circleInvitation.setUserId(user.getId());
			}
			if (circleInvitation.getId() == null) {
				circleInvitation.setAddTime(new Date());
			}
			circleInvitation.setUpdateTime(new Date());
			circleInvitation.setPraiseInfo("");
			circleInvitation.setFavoritesInfo("");
			circleInvitation.setFavoritesCount(0);
			circleInvitation.setPraiseCount(0);
			this.invitationService.save(circleInvitation);
			// 更新排序
			messageService.updateInvitationRand();
			// 给圈子表的帖子数加1
			Circle circle = circleService.getObjById(circleInvitation.getCircleId());
			circle.setInvitationCount(circle.getInvitationCount() + 1);
			circleService.update(circle);

			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/circle_official_invitation.htm");
			mv.addObject("op_title", "保存资讯成功");
			mv.addObject("add_url", CommUtil.getURL(request) + "/admin/circle_invitation_add.htm");
		}
		return mv;
	}

	/**
	 * 进入推荐页面帖子
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "帖子推荐", value = "/admin/invitation_advert_view.htm*", rtype = "admin", rname = "帖子推荐", rcode = "advert_admin", rgroup = "内容管理")
	@RequestMapping("/admin/invitation_advert_view.htm")
	public ModelAndView invitation_advert_view(HttpServletRequest request, HttpServletResponse response,
			String id) {
		ModelAndView mv = new JModelAndView("admin/blue/advert_add.html", configService.getSysConfig(), 0,
				request, response);
		if (id != null && !id.equals("")) {
			List<AdvertPosition> apsList = advertPositionService.findByRelease(1);
			CircleInvitation circleInvitation = this.invitationService.getObjById(Long.parseLong(id));
			mv.addObject("adTypeInfomation", AdvertContant.ADVERT_TPYE_INFOMATION);
			mv.addObject("circleInvitationId", id);
			mv.addObject("circleInvitation", circleInvitation);
			mv.addObject("aps", apsList);
			mv.addObject("invitationAdvertFlag", true);
		}
		return mv;
	}
}