package com.sinco.carnation.resource.web.actions;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.lucene.WordFind;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.IPUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.circle.service.InvitationServiceImpl;
import com.sinco.carnation.constant.TipConstant;
import com.sinco.carnation.resource.bo.CircleListBO;
import com.sinco.carnation.resource.bo.LookInvitationBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.FoodClassVO;
import com.sinco.carnation.resource.vo.TipsVO;
import com.sinco.carnation.resource.vo.favorites.AddInvitationVO;
import com.sinco.carnation.resource.vo.favorites.CircleInfoVO;
import com.sinco.carnation.resource.vo.favorites.CircleVO;
import com.sinco.carnation.resource.vo.favorites.CommentVO;
import com.sinco.carnation.resource.vo.favorites.InvitationAllListVO;
import com.sinco.carnation.resource.vo.favorites.MyselfInvitationVO;
import com.sinco.carnation.resource.vo.favorites.PraiseVO;
import com.sinco.carnation.resource.vo.favorites.ReplyVO;
import com.sinco.carnation.resource.vo.favorites.SearchInvitationVO;
import com.sinco.carnation.resource.vo.favorites.ShareInvitationDetailsVO;
import com.sinco.carnation.resource.web.response.favorites.AddInvitationResponse;
import com.sinco.carnation.resource.web.response.favorites.CircleListResponse;
import com.sinco.carnation.resource.web.response.favorites.CircleResponse;
import com.sinco.carnation.resource.web.response.favorites.CommentResponse;
import com.sinco.carnation.resource.web.response.favorites.InvitationAllListResponse;
import com.sinco.carnation.resource.web.response.favorites.InvitationDetailsResponse;
import com.sinco.carnation.resource.web.response.favorites.InvitationExtendResponse;
import com.sinco.carnation.resource.web.response.favorites.MyselfInvitationResponse;
import com.sinco.carnation.resource.web.response.favorites.PraiseResponse;
import com.sinco.carnation.resource.web.response.favorites.ReplyResponse;
import com.sinco.carnation.resource.web.response.favorites.SearchInvitationResponse;
import com.sinco.carnation.sns.bo.CircleInvitationBO;
import com.sinco.carnation.sns.bo.FoodCaloriesBO;
import com.sinco.carnation.sns.bo.FoodClassBO;
import com.sinco.carnation.sns.model.Circle;
import com.sinco.carnation.sns.model.CircleInvitation;
import com.sinco.carnation.sns.model.Tips;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.tips.service.TipsServiceImpl;
import com.sinco.carnation.user.service.CircleInvitationService;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "帖子", namespace = "invitation")
public class CircleInvitationController extends BasicApiController {

	@Autowired
	private CircleInvitationService circleService;
	@Autowired
	private TipsServiceImpl tipsService;
	@Autowired
	private InvitationServiceImpl invitationService;
	@Autowired
	private WordFind wordFind;

	@Autowired
	private Mapper mapper;

	@Autowired
	private UserService userService;

	/**
	 * 帖子点赞
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/users/praise", method = RequestMethod.POST)
	@MethodMapping(desc = "点赞")
	public @ResponseBody
	PraiseResponse usersPraise(@Valid @ModelAttribute @Param PraiseVO vo, BindingResult result,
			HttpServletRequest request) {

		PraiseResponse response = new PraiseResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();
		if (circleService.usersPraise(vo.getFid(), userId) < 1) {
			response.putErrorMessage("5.invitation.usersPraise.praise_fail");
			return response;
		}
		return response;
	}

	/**
	 * 圈子的帖子列表
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/users/circle_invitation/list", method = RequestMethod.POST)
	@MethodMapping(desc = "圈子的帖子列表")
	public @ResponseBody
	CircleResponse circleByInvitationList(@Valid @ModelAttribute @Param CircleVO vo, BindingResult result,
			HttpServletRequest request) {

		CircleResponse response = new CircleResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		MyPage<CircleInvitationBO> page = new MyPage<CircleInvitationBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		circleService.circleByInvitationList(uid, vo.getCircleId(), vo.getInvitationType(), vo.getTimes(),
				page);
		if (null != page.getContent() && page.getContent().size() > 0) {
			List<LookInvitationBO> invitationBOs = MapperUtils.map(mapper, page.getContent(),
					LookInvitationBO.class);
			for (LookInvitationBO look : invitationBOs) {
				if (look.getCircleType() == 2) {
					look.setUserName("官方");
				}
			}
			response.setCircle(invitationBOs);
			// 设置总记录数
			response.setTotalCount(page.getTotalElements());
			// 设置最后一条记录时间
			if (null != page.getContent().get(page.getContent().size() - 1).getAddTime()) {
				response.setTimes(page.getContent().get(page.getContent().size() - 1).getAddTime().getTime());
			}
			return response;
		}
		response.setTotalCount(0L);
		return response;
	}

	@RequestMapping(value = "/users/myself_invitation/list", method = RequestMethod.POST)
	@MethodMapping(desc = "用户发布的帖子列表")
	public @ResponseBody
	MyselfInvitationResponse myselfInvitationList(@Valid @ModelAttribute @Param MyselfInvitationVO vo,
			BindingResult result, HttpServletRequest request) {

		MyselfInvitationResponse response = new MyselfInvitationResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<CircleInvitationBO> page = new MyPage<CircleInvitationBO>();

		page.setPageSize(vo.getPageSize());
		page.setPageNumber(vo.getPageNum());

		Long uid = ActionsUtil.getOwnerUid();
		circleService.circleInvitationList(uid, page);
		if (null != page.getContent() && page.getContent().size() > 0) {
			List<LookInvitationBO> myInvitationList = MapperUtils.map(mapper, page.getContent(),
					LookInvitationBO.class);
			response.setInvitations(myInvitationList);
			response.setTotalCount(page.getTotalElements());
			return response;
		}
		response.setTotalCount(0L);
		return response;
	}

	@RequestMapping(value = "/users/invitation/add", method = RequestMethod.POST)
	@MethodMapping(desc = "添加帖子")
	public @ResponseBody
	AddInvitationResponse addInvitation(@Valid @ModelAttribute @Param AddInvitationVO vo,
			BindingResult result, HttpServletRequest request) {

		AddInvitationResponse response = new AddInvitationResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		// 帖子内容有敏感词
		if (wordFind.find(vo.getContext()).length > 0 || wordFind.find(vo.getTitle()).length > 0) {
			response.putErrorMessage("5.invitation.addInvitation.word_fail");
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();
		CircleInvitation circleInvitation = circleService.addInvitation(userId, vo.getCircleId(),
				vo.getTitle(), vo.getContext(), vo.getImages());
		if (null == circleInvitation) {
			response.putErrorMessage("5.invitation.addInvitation.add_fail");
			return response;
		}
		response.setUid(circleInvitation.getUserId());
		response.setId(circleInvitation.getId());
		response.setTitle(circleInvitation.getTitle());
		response.setUserName(circleInvitation.getUserName());
		return response;
	}

	@RequestMapping(value = "/users/circle/list", method = RequestMethod.POST)
	@MethodMapping(desc = "圈子列表")
	public @ResponseBody
	CircleListResponse queryCircleList() {
		CircleListResponse response = new CircleListResponse();
		List<Circle> circles = circleService.searchCircleList();
		List<CircleListBO> list = MapperUtils.map(mapper, circles, CircleListBO.class);
		response.setCircleListBOs(list);
		return response;
	}

	@RequestMapping(value = "/users/comment/add", method = RequestMethod.POST)
	@MethodMapping(desc = "评论")
	public @ResponseBody
	CommentResponse commentInvitation(@Valid @ModelAttribute @Param CommentVO vo, BindingResult result,
			HttpServletRequest request) {

		CommentResponse response = new CommentResponse();
		// 帖子内容有敏感词
		if (wordFind.find(vo.getContent()).length > 0) {
			response.putErrorMessage("5.invitation.commentInvitation.word_fail");
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();
		if (circleService.addCommentInvitation(userId, vo.getInvitationId(), vo.getContent(), vo.getPic()) <= 0) {
			response.putErrorMessage("5.invitation.commentInvitation.add_fail");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/users/repyl/add", method = RequestMethod.POST)
	@MethodMapping(desc = "帖子回复")
	public @ResponseBody
	ReplyResponse replyInvitation(@Valid @ModelAttribute @Param ReplyVO vo, BindingResult result,
			HttpServletRequest request) {

		ReplyResponse response = new ReplyResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		// 帖子内容有敏感词
		if (wordFind.find(vo.getContent()).length > 0) {
			response.putErrorMessage("5.invitation.replyInvitation.word_fail");
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();
		if (circleService.replyInvitation(userId, vo.getInvitationId(), vo.getReplyId(), vo.getContent(),
				vo.getPic()) <= 0) {
			response.putErrorMessage("5.invitation.replyInvitation.add_fail");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/users/invitation_all/list", method = RequestMethod.POST)
	@MethodMapping(desc = "帖子列表")
	public @ResponseBody
	InvitationAllListResponse invitationAllListPage(@Valid @ModelAttribute @Param InvitationAllListVO vo,
			BindingResult result, HttpServletRequest request) {

		InvitationAllListResponse response = new InvitationAllListResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();

		MyPage<CircleInvitationBO> page = new MyPage<CircleInvitationBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		circleService.invitationAllListPage(uid, vo.getInvitationType(), vo.getTimes(), page);
		if (null != page.getContent() && page.getContent().size() > 0) {
			List<LookInvitationBO> list = MapperUtils.map(mapper, page.getContent(), LookInvitationBO.class);
			response.setInvitation(list);
			// 总记录数
			response.setTotalCount(page.getTotalElements());
			// 最后一条时间
			if (null != page.getContent().get(page.getContent().size() - 1).getAddTime()) {
				response.setTimes(page.getContent().get(page.getContent().size() - 1).getAddTime().getTime());
			}
			return response;
		}
		response.setTimes(0L);
		return response;
	}

	@RequestMapping(value = "/users/invitation/search", method = RequestMethod.POST)
	@MethodMapping(desc = "搜索帖子")
	public @ResponseBody
	SearchInvitationResponse invationSearch(@Valid @ModelAttribute @Param SearchInvitationVO vo,
			BindingResult result, HttpServletRequest request) {

		SearchInvitationResponse response = new SearchInvitationResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		MyPage<CircleInvitationBO> page = new MyPage<CircleInvitationBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		circleService.searchInvitation(uid, vo.getTitle(), vo.getTimes(), page);
		if (null != page.getContent() && page.getContent().size() > 0) {
			List<LookInvitationBO> list = MapperUtils.map(mapper, page.getContent(), LookInvitationBO.class);
			response.setInvitation(list);
			response.setTotal(page.getTotalElements());
			if (null != page.getContent().get(page.getContent().size() - 1).getUpdateTime()) {
				response.setTimes(page.getContent().get(page.getContent().size() - 1).getUpdateTime()
						.getTime());
			}
			return response;
		}
		response.setTotal(0L);
		return response;
	}

	/**
	 * 帖子点赞
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/users/cancle/praise", method = RequestMethod.POST)
	@MethodMapping(desc = "取消点赞")
	public @ResponseBody
	PraiseResponse canceUsersPraise(@Valid @ModelAttribute @Param PraiseVO vo, BindingResult result,
			HttpServletRequest request) {

		PraiseResponse response = new PraiseResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long userId = ActionsUtil.getOwnerUid();
		if (circleService.cancleUsersPraise(userId, vo.getFid()) < 0) {
			response.putErrorMessage("5.invitation.usersPraise.praise_fail");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/users/circle/query", method = RequestMethod.POST)
	@MethodMapping(desc = "圈子信息")
	public @ResponseBody
	CircleListResponse circleInfo(@Valid @ModelAttribute @Param CircleInfoVO vo, BindingResult result,
			HttpServletRequest request) {

		CircleListResponse response = new CircleListResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		List<Circle> circle = circleService.queryCircle(vo.getCircleId());
		if (null != circle && circle.size() > 0) {
			List<CircleListBO> list = MapperUtils.map(mapper, circle, CircleListBO.class);
			response.setCircleInfo(list.get(0));
		}
		return response;
	}

	/**
	 * 帖子内容(分享时调用)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users/invitation/details", method = RequestMethod.POST)
	@MethodMapping(desc = "帖子内容,分享时调用")
	public @ResponseBody
	InvitationDetailsResponse detailsInvitationQuery(
			@Valid @ModelAttribute @Param ShareInvitationDetailsVO vo, BindingResult result,
			HttpServletRequest request) {

		InvitationDetailsResponse response = new InvitationDetailsResponse();
		if (result.hasErrors()) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		CircleInvitationBO circleInvitationBO = circleService.selectInvitationDetail(vo.getInvnId());
		if (null != circleInvitationBO) {
			response.setId(circleInvitationBO.getId());
			response.setThumbnail(circleInvitationBO.getThumbnail());
			if (StringUtils.isNotBlank(circleInvitationBO.getContent())) {
				String content = Jsoup.parse(circleInvitationBO.getContent()).text();
				content = content.replaceAll(" ", "").replaceAll("\r", "").replaceAll("\t", "")
						.replaceAll("\n", "");
				if (content.length() > 30) {
					response.setContent(content.substring(0, 30) + "...");
				} else {
					response.setContent(content);
				}
			}

			// 获取登陆人的邀请码信息
			Long uid = ActionsUtil.getOwnerUid();
			String invitationCode = null;
			// uid = (long) 192;//test
			if (uid != null) {
				// 查询当前用户的邀请码
				UserBO userBO = userService.findById(uid);
				invitationCode = userBO.getInvitationCode();
				// model.addAttribute("invitationCode", invitationCode);
			}
			response.setInvitationCode(invitationCode);
			response.setJgAppType(vo.getJgyes_app());

			return response;
		}
		return response;
	}

	/**
	 * 帖子扩展，是否点赞，是否收藏
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users/invitation/extend", method = RequestMethod.POST)
	@MethodMapping(desc = "帖子扩展信息，是否收藏，是否点赞")
	public @ResponseBody
	InvitationExtendResponse extendInvitation(
			@Valid @RequestParam(value = "invitationId") @Param(desc = "帖子id") Long invitationId) {

		InvitationExtendResponse response = new InvitationExtendResponse();
		if (null == invitationId) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		Map<String, Boolean> resultMap = circleService.userIsPraiseAndFavorite(ActionsUtil.getOwnerUid(),
				invitationId);
		response.setPraise(resultMap.get("p"));
		response.setFavorites(resultMap.get("f"));
		return response;
	}

	@RequestMapping(value = "/users/report/list", method = RequestMethod.POST)
	@MethodMapping(desc = "举报类型列表")
	public @ResponseBody
	InvitationExtendResponse reportList() {
		InvitationExtendResponse response = new InvitationExtendResponse();
		response.setReportList(TipConstant.tipList);
		return response;
	}

	@RequestMapping(value = "/users/report/save", method = RequestMethod.POST)
	@MethodMapping(desc = "举报")
	public @ResponseBody
	InvitationExtendResponse reportSave(@Valid @ModelAttribute @Param TipsVO vo, BindingResult result,
			HttpServletRequest request) {
		InvitationExtendResponse response = new InvitationExtendResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		String ip = IPUtil.getIpAddr(request);

		Tips tips = new Tips();
		tips.setAddTime(new Date());
		tips.setTargetId(vo.getTargetId());
		if (vo.getTipsType().equals("0")) {
			tips.setTipsType("诈骗");
		} else if (vo.getTipsType().equals("1")) {
			tips.setTipsType("色情");
		} else if (vo.getTipsType().equals("2")) {
			tips.setTipsType("政治");
		} else if (vo.getTipsType().equals("3")) {
			tips.setTipsType("侵权");
		} else if (vo.getTipsType().equals("4")) {
			tips.setTipsType("其他");
		}
		tips.setType(vo.getType());
		tips.setFromIp(ip);
		tips.setFromUserId(uid);
		boolean flag = tipsService.save(tips);
		response.setFlag(flag);
		return response;
	}

	@RequestMapping(value = "/sns/food/list", method = RequestMethod.POST)
	@MethodMapping(desc = "食物")
	public @ResponseBody
	InvitationExtendResponse foodList(@Valid @ModelAttribute @Param FoodClassVO vo, BindingResult result) {
		InvitationExtendResponse response = new InvitationExtendResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<FoodClassBO> page = new MyPage<FoodClassBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		invitationService.queryFoodList(0, page);
		List<com.sinco.carnation.resource.bo.FoodClassBO> food = MapperUtils.map(mapper, page.getContent(),
				com.sinco.carnation.resource.bo.FoodClassBO.class);
		response.setFoodClassList(food);
		return response;
	}

	@RequestMapping(value = "/sns/food_calories/list", method = RequestMethod.POST)
	@MethodMapping(desc = "食物")
	public @ResponseBody
	InvitationExtendResponse foodCaloriesList(
			@Valid @RequestParam(value = "classId") @Param(desc = "分类id") Long classId) {
		InvitationExtendResponse response = new InvitationExtendResponse();
		if (classId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		List<FoodCaloriesBO> list = invitationService.queryFoodCaloriesById(classId);
		List<com.sinco.carnation.resource.bo.FoodClassBO> food = MapperUtils.map(mapper, list,
				com.sinco.carnation.resource.bo.FoodClassBO.class);
		response.setFoodClassList(food);
		return response;
	}
}
