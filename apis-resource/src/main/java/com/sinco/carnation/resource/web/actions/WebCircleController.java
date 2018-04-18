package com.sinco.carnation.resource.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sinco.carnation.pay.tools.WxShareTools;
import com.sinco.carnation.resource.constant.WebConstant;
import com.sinco.carnation.resource.vo.favorites.ReplyListVO;
import com.sinco.carnation.sns.bo.CircleInvitationBO;
import com.sinco.carnation.sns.bo.CircleInvitationReplyBO;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.service.CircleInvitationService;

@Controller
public class WebCircleController {

	@Autowired
	private CircleInvitationService circleService;

	@Autowired
	private UserService userService;

	@Autowired
	private WxShareTools wxTools;

	@Value(value = "${api.path}")
	private String apiPath;

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	@RequestMapping(value = "/circle/look_invitation", method = RequestMethod.GET)
	public String lookInvitation(HttpServletRequest request, ReplyListVO vo, Model model) {

		CircleInvitationBO circleInvitationBO = circleService.selectInvitationDetail(vo.getInvitationId());
		if (circleInvitationBO != null) {
			model.addAttribute("invitation", circleInvitationBO);
		} else {
			return "404";
		}

		if (vo.getStart() == null) {
			vo.setStart(0);
		}
		if (vo.getPageSize() == null) {
			vo.setPageSize(WebConstant.INVITATION_REPAY_FIRST_PAGE_SIZE);
		}

		List<CircleInvitationReplyBO> repayList = circleService.queryInvitationReplyList(null,
				vo.getInvitationId(), vo.getStart(), vo.getPageSize());
		if (repayList.size() > 0) {
//			for(CircleInvitationReplyBO cb : repayList){
//				 
//				 
//				StringBuffer strApp1 = new StringBuffer();
//				StringBuffer strApp2= new StringBuffer();
//				 if(cb.getPic()!=null)
//				 {
//					 for(int i = 0;i< cb.getPic().toString().split("\\|").length;i++)
//					 { 
//					      strApp1.append("&nbsp;&nbsp;");
//					 }
//				 }
//				 if(cb.getParentPic()!=null)
//				 {
//					 for(int i = 0;i< cb.getParentPic().toString().split("\\|").length;i++)
//					 {  
//					      strApp2.append("<a href='javascript:;' data-dialog='"+ cb.getParentPic().toString().split("\\|")[i]+"_300x400s'><img src='"+ cb.getParentPic().toString().split("\\|")[i]+"_60x80s' /></a>&nbsp;&nbsp;");
//					 }
//					 cb.setParentPic(strApp2.toString());
//					 cb.setPic(strApp1.toString());
//				 }
//			}
			model.addAttribute("repayList", repayList);
			model.addAttribute("maxId", repayList.get(0).getId());
		}
		model.addAttribute("vo", vo);

		// 获取登陆人的邀请码信息
		String invitationCode = null;
		// uid = (long) 192;//test
		if (vo != null && vo.getInvitationCode() != null) {
			invitationCode = vo.getInvitationCode();
		}
		model.addAttribute("invitationCode", invitationCode);

		// 帖子访问来源

		model.addAttribute("jgyes_app", vo.getJgyes_app() != 0 ? vo.getJgyes_app() : 0);

//		int favoriteFlag = 0;
//		if (userId != null && !StringUtils.isEmpty(circleInvitationBO.getFavoritesInfo())) 
//		{
//			String favoritesInfo = circleInvitationBO.getFavoritesInfo();
//			String [] info = favoritesInfo.split(",");
//			List<String> list = CollectionUtils.arrayToList(info);
//			if(list.contains(String.valueOf(userId)))
//			{
//				favoriteFlag = 1;
//			}
//		}
//		model.addAttribute("favoriteFlag", favoriteFlag);
//		int praiseFlag = 0;
//		if (userId != null && !StringUtils.isEmpty(circleInvitationBO.getPraiseInfo())) 
//		{
//			String praiseInfo = circleInvitationBO.getPraiseInfo();
//			String [] info = praiseInfo.split(",");
//			List<String> list = CollectionUtils.arrayToList(info);
//			if(list.contains(String.valueOf(userId)))
//			{
//				praiseFlag = 1;
//			}
//		}
//		model.addAttribute("praiseFlag", praiseFlag);

		wxTools.wxShareModel(model, request, apiPath);// 微信分享

		return "circle/circle_invitation.htm";
	}

	@RequestMapping(value = "/circle/ajax_invitation_repay", method = RequestMethod.GET)
	public @ResponseBody
	String ajaxInvitationRepay(HttpServletRequest request, ReplyListVO vo, Model model) {
		if (vo.getStart() == null) {
			vo.setStart(0);
		}
		vo.setPageSize(WebConstant.INVITATION_REPAY_PAGE_SIZE);
		List<CircleInvitationReplyBO> repayList = circleService.queryInvitationReplyList(vo.getMaxId(),
				vo.getInvitationId(), vo.getStart(), vo.getPageSize());
		if (!CollectionUtils.isEmpty(repayList)) {
			String jsonString = JSON.toJSONString(repayList);
			return jsonString;
		} else {
			return "no";
		}
	}

}
