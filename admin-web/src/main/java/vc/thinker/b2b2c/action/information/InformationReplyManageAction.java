package vc.thinker.b2b2c.action.information;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;

import com.sinco.carnation.cms.service.InformationReplyServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;

@Controller
public class InformationReplyManageAction {
	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private IUserConfigService  userConfigService;
	@Autowired
	private InformationReplyServiceImpl informationreplyService;

	/**
	 * InformationReply列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "资讯回复列表", value = "/admin/information_reply.htm*", rtype = "admin", rname = "资讯回复", rcode = "information_reply", rgroup = "内容管理")
	@RequestMapping("/admin/information_reply.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, String currentPage,
			String orderBy, String orderType) {
		ModelAndView mv = new JModelAndView("admin/blue/information_reply.html",
				configService.getSysConfig(), 0, request, response);
//		InformationReplyQueryObject qo = new InformationReplyQueryObject(currentPage, mv, orderBy,
//				orderType);
//		IPageList pList = this.informationreplyService.list(qo);
//		CommUtil.saveIPageList2ModelAndView("","",null, pList, mv);
		return mv;
	}

	@SecurityMapping(title = "资讯回复删除", value = "/admin/information_reply_del.htm*", rtype = "admin", rname = "资讯回复", rcode = "information_reply", rgroup = "内容管理")
	@RequestMapping("/admin/information_reply_del.htm")
	public String delete(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
//			  InformationReply informationreply = this.informationreplyService.getObjById(Long.parseLong(id));
				this.informationreplyService.delete(Long.parseLong(id));
			}
		}
		return "redirect:information_reply.htm?currentPage=" + currentPage;
	}

}