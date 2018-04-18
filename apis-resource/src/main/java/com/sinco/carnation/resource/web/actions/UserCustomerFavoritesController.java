package com.sinco.carnation.resource.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
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

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.resource.bo.ExpertsBO;
import com.sinco.carnation.resource.bo.LookInvitationBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.favorites.CancleFavoritesVO;
import com.sinco.carnation.resource.vo.favorites.QueryCircleInvitationVO;
import com.sinco.carnation.resource.vo.favorites.QueryExpertsVO;
import com.sinco.carnation.resource.vo.favorites.UserCustomerFavoritesVO;
import com.sinco.carnation.resource.web.response.favorites.CancleFavoritesResponse;
import com.sinco.carnation.resource.web.response.favorites.QueryCircleInvitationResponse;
import com.sinco.carnation.resource.web.response.favorites.QueryExpertsResponse;
import com.sinco.carnation.resource.web.response.favorites.UserCustomerFavoritesResponse;
import com.sinco.carnation.sns.bo.CircleInvitationBO;
import com.sinco.carnation.user.bo.UserExpertsBO;
import com.sinco.carnation.user.service.CircleInvitationService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "用户API", namespace = "user")
public class UserCustomerFavoritesController extends BasicApiController {

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private CircleInvitationService circleService;

	@Autowired
	private Mapper mapper;

	/**
	 * 添加用户收藏
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/users/favorites", method = RequestMethod.POST)
	@MethodMapping(desc = "用户收藏")
	public @ResponseBody
	UserCustomerFavoritesResponse userFavorites(@Valid @ModelAttribute @Param UserCustomerFavoritesVO vo,
			BindingResult result, HttpServletRequest request) {

		UserCustomerFavoritesResponse response = new UserCustomerFavoritesResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		try {
			customerService.addFavorites(uid, vo.getFid(), vo.getType());
		} catch (ServiceException e) {
			response.putErrorMessage("4.users.userFavorites.favorites_fail");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/users/favorites/cancle", method = RequestMethod.POST)
	@MethodMapping(desc = "取消收藏帖子")
	public @ResponseBody
	CancleFavoritesResponse usersCancleFavotites(@Valid @ModelAttribute @Param CancleFavoritesVO vo,
			BindingResult result, HttpServletRequest request) {

		CancleFavoritesResponse response = new CancleFavoritesResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long userid = ActionsUtil.getOwnerUid();
		if (customerService.cancleFavorites(userid, vo.getFid(), "1") <= 0) {
			response.putErrorMessage("5.favorites.usersCancleFavotites.cancle_fail");
			return response;
		}
		return response;

	}

	@RequestMapping(value = "/users/experts/cancle", method = RequestMethod.POST)
	@MethodMapping(desc = "取消收藏专家")
	public @ResponseBody
	CancleFavoritesResponse userExpertsCancle(
			@Valid @RequestParam(value = "expertsId") @Param(desc = "要取消收藏的专家id") String expertsId,
			HttpServletRequest request) {

		CancleFavoritesResponse response = new CancleFavoritesResponse();
		if (StringUtils.isEmpty(expertsId)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long userid = ActionsUtil.getOwnerUid();
		// customerService.cancleFavoritesExperts(userid, expertsId);
		if (customerService.cancleFavoritesExperts(userid, expertsId) <= 0) {
			response.putErrorMessage("5.favorites.usersCancleFavotites.cancle_fail");
			return response;
		}
		return response;

	}

	/**
	 * 查询帖子列表
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/users/invitation/query", method = RequestMethod.POST)
	@MethodMapping(desc = "用户查询收藏帖子列表")
	public @ResponseBody
	QueryCircleInvitationResponse queryInvitation(@Valid @ModelAttribute @Param QueryCircleInvitationVO vo,
			BindingResult result, HttpServletRequest request) {

		QueryCircleInvitationResponse response = new QueryCircleInvitationResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<CircleInvitationBO> page = new MyPage<CircleInvitationBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		Long userId = ActionsUtil.getOwnerUid();
		circleService.queryCircleInvatation(userId, vo.getType(), vo.getCircleType(), vo.getTimes(), page);
		if (null != page.getContent() && page.getContent().size() > 0) {
			List<LookInvitationBO> circle = MapperUtils
					.map(mapper, page.getContent(), LookInvitationBO.class);
			response.setCircle(circle);
			response.setTotalCount(page.getTotalElements());
			response.setTimes(page.getContent().get(page.getContent().size() - 1).getUpdateTime().getTime());
			return response;
		}
		response.setTotalCount(0L);
		return response;
	}

	@RequestMapping(value = "/users/experts/query", method = RequestMethod.POST)
	@MethodMapping(desc = "收藏的专家列表")
	public @ResponseBody
	QueryExpertsResponse usersQueryExperts(@Valid @ModelAttribute @Param QueryExpertsVO vo,
			BindingResult result, HttpServletRequest request) {

		QueryExpertsResponse response = new QueryExpertsResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<UserExpertsBO> page = new MyPage<UserExpertsBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		Long userId = ActionsUtil.getOwnerUid();
		customerService.queryExperts(userId, vo.getExpertsType(), vo.getType(), page);
		if (null != page.getContent() && page.getContent().size() > 0) {
			List<ExpertsBO> list = MapperUtils.map(mapper, page.getContent(), ExpertsBO.class);
			for (int i = 0; i < list.size(); i++) {
				if (StringUtils.isNotBlank(list.get(i).getDescription())) {
					list.get(i).setDesc(Jsoup.parse(list.get(i).getDescription()).text());
				}
			}
			response.setExperts(list);
			response.setTotalCount(page.getTotalElements());
			return response;
		}
		response.setTotalCount(0L);
		return response;
	}
}
