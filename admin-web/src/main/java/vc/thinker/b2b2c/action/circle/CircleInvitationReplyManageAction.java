package vc.thinker.b2b2c.action.circle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.circle.service.InvitationReplyServiceImpl;
import com.sinco.carnation.sns.model.CircleInvitationReply;
import com.sinco.carnation.sns.vo.CircleInvitationReplyVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

@Controller
public class CircleInvitationReplyManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private InvitationReplyServiceImpl invitationReplyService;

	/**
	 * invitationReply列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "帖子回复列表", value = "/admin/invitation_reply.htm*", rtype = "admin", rname = "资讯回复", rcode = "invitation_reply", rgroup = "内容管理")
	@RequestMapping("/admin/invitation_reply.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response,
			MyPage<CircleInvitationReply> page, CircleInvitationReplyVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/circle_invitation_reply.html",
				configService.getSysConfig(), 0, request, response);

		page.setPageSize(10);

		invitationReplyService.selectPageByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		mv.addObject("vo", vo);

		return mv;
	}

	@SecurityMapping(title = "资讯回复删除", value = "/admin/invitation_reply_del.htm*", rtype = "admin", rname = "资讯回复", rcode = "invitation_reply", rgroup = "内容管理")
	@RequestMapping("/admin/invitation_reply_del.htm")
	public String delete(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				this.invitationReplyService.delete(Long.parseLong(id));
			}
		}
		return "redirect:invitation_reply.htm?currentPage=" + currentPage;
	}

}