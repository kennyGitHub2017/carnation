package com.sinco.carnation.resource.web.actions.healthcircle;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.tools.DateFormatUtil;
import vc.thinker.b2b2c.lucene.WordFind;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.healthcircle.bo.BlacklistBO;
import com.sinco.carnation.healthcircle.model.Post;
import com.sinco.carnation.healthcircle.model.PostEvaluate;
import com.sinco.carnation.healthcircle.model.PostPraise;
import com.sinco.carnation.healthcircle.service.BlacklistService;
import com.sinco.carnation.healthcircle.service.PostEvaluateService;
import com.sinco.carnation.healthcircle.service.PostService;
import com.sinco.carnation.label.model.Label;
import com.sinco.carnation.label.vo.LabelVO;
import com.sinco.carnation.resource.bo.healthcircle.PostBO;
import com.sinco.carnation.resource.bo.healthcircle.PostEvaluateBO;
import com.sinco.carnation.resource.bo.healthcircle.UserBO;
import com.sinco.carnation.resource.constant.LabelCenterConstant;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.healthcircle.LabelAddVO;
import com.sinco.carnation.resource.vo.healthcircle.PostAddVO;
import com.sinco.carnation.resource.vo.healthcircle.PostDeleteVO;
import com.sinco.carnation.resource.vo.healthcircle.PostEvalueteVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.healthcircle.EvaluateResponse;
import com.sinco.carnation.resource.web.response.healthcircle.IsLoginResponse;
import com.sinco.carnation.resource.web.response.healthcircle.PostDelResponse;
import com.sinco.carnation.resource.web.response.healthcircle.PostLabelResponse;
import com.sinco.carnation.resource.web.response.healthcircle.PostResponse;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.service.LabelService;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.common.utils.StringUtils;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "健康圈帖子", namespace = "post")
public class PostController extends BasicApiController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PostService postService;

	@Autowired
	private Mapper mapper;

	@Autowired
	private PostEvaluateService postEvaluateService;

	@Autowired
	private UserCustomerService userCustomerService;

	@Autowired
	private LabelService postLabelService;

	@Autowired
	private WordFind wordFind;

	@Autowired
	private IntegralService integralService;

	@Autowired
	private BlacklistService blacklistService;

	/**
	 * 健康圈首页帖子列表全部/原生态开发|未登录
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/post/page_post_list", method = RequestMethod.POST)
	@MethodMapping(desc = "帖子分页查询全部")
	public @ResponseBody
	PostResponse postList(@Valid @ModelAttribute @Param BasicPageParamVo vo, BindingResult result,
			@RequestParam(value = "postType") @Param(desc = "类型0:全部,1:热门") Integer postType,
			HttpServletRequest request) {
		PostResponse response = new PostResponse();
		Long userId = ActionsUtil.getOwnerUid();// 当前用户
		MyPage<Post> page = new MyPage<Post>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		// PostVO postVo = null;
		List<Post> list = postService.findPageByType(page, postType, userId, null);
		if (null != list && list.size() > 0) {
			list = getImages(list);
			List<com.sinco.carnation.resource.bo.healthcircle.PostBO> posts = MapperUtils.map(mapper, list,
					com.sinco.carnation.resource.bo.healthcircle.PostBO.class);
			response.setPostList(posts);
		}
		logger.info("userId=========================首页" + userId);
		if (null != userId) {
			response.setIslogin(1);
		} else {
			response.setIslogin(0);
		}
		return response;
	}

	/**
	 * 根据标签id查询所有帖子列表/原生开发
	 * 
	 * @param labelId标签id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/post/page_post_listBylabelId", method = RequestMethod.POST)
	@MethodMapping(desc = "根据标签名称查询所有帖子列表")
	public @ResponseBody
	PostResponse postListBylabelId(
			@Valid @ModelAttribute @RequestParam(value = "labelName") @Param(desc = "标签名称labelName必传") String labelName,
			@Param BasicPageParamVo vo, BindingResult result, HttpServletRequest request) {
		PostResponse response = new PostResponse();
		Long userId = ActionsUtil.getOwnerUid();// 当前用户
		MyPage<Post> page = new MyPage<Post>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		List<Post> list = postService.findPageByLabel(page, labelName, userId,
				LabelCenterConstant.LABELCENTER_TYPE_1);
		if (null != list && list.size() > 0) {
			list = getImages(list);
			List<com.sinco.carnation.resource.bo.healthcircle.PostBO> posts = MapperUtils.map(mapper, list,
					com.sinco.carnation.resource.bo.healthcircle.PostBO.class);
			response.setPostList(posts);
		}
		if (null != userId) {
			response.setIslogin(1);
		} else {
			response.setIslogin(0);
		}
		return response;
	}

	/**
	 * 帖子点赞
	 * 
	 * @param 帖子id
	 *            /原生态开发
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/post/post_updatePraiseNum", method = RequestMethod.POST)
	@MethodMapping(desc = "帖子点赞")
	public @ResponseBody
	PostResponse updatePraiseNum(
			@Valid @ModelAttribute @RequestParam(value = "id") @Param(desc = "帖子id必传") Long id,
			HttpServletRequest request) {
		PostResponse response = new PostResponse();
		Long userId = ActionsUtil.getOwnerUid();
		if (userId == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		PostPraise vo = new PostPraise();
		vo.setPostId(id);
		vo.setFromUserid(userId);
		int num = postService.updatePraiseNum(vo);
		if (num == 400) {// 该用户已点过赞
			response.putErrorMessage("5.invitation.usersPraise.praise_fail");
			return response;
		}
//		if (num == 100) {
//			integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_DIANZAN, userId, null);
//			// 被点赞送积分
//			Post post = postService.findById(id);
//			integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_BEIDIANZAN, post.getUserId(),
//					null);
//		}
		// 获取点赞数
		Post post = postService.getObjById(id);
		int praiseNum = null != post ? post.getPraiseNum() : 0;
		response.setPraiseNum(praiseNum);
		response.setIslogin(1);
		return response;
	}

	/**
	 * 帖子点赞/帖子id/原生态开发
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/post/post_canclePraise", method = RequestMethod.POST)
	@MethodMapping(desc = "取消点赞")
	public @ResponseBody
	PostResponse updatePraise(
			@Valid @ModelAttribute @RequestParam(value = "id") @Param(desc = "帖子id") Long id,
			HttpServletRequest request) {
		PostResponse response = new PostResponse();
		Long userId = ActionsUtil.getOwnerUid();
		if (userId == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		PostPraise vo = new PostPraise();
		vo.setPostId(id);
		vo.setFromUserid(userId);
		int num = postService.cancleUsersPraise(vo);
		if (num == 400) {
			response.putErrorMessage("5.invitation.usersPraise.praise_fail");
			return response;
		}
		// 获取点赞数
		Post post = postService.getObjById(id);
		int praiseNum = null != post ? post.getPraiseNum() : 0;
		response.setPraiseNum(praiseNum);
		response.setIslogin(1);
		return response;
	}

	/**
	 * 发帖/原生态开发
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/post/post_postsave", method = RequestMethod.POST)
	@MethodMapping(desc = "发帖")
	public @ResponseBody
	PostResponse save_post(@Valid @ModelAttribute @Param PostAddVO postVo, BindingResult result,
			HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		PostResponse response = new PostResponse();
		Long userId = ActionsUtil.getOwnerUid();
		logger.info("userId=========================发帖" + userId + "====content====" + postVo.getContent());
		if (userId == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		// 验证是否为黑名单
		BlacklistBO blacklist = blacklistService.getBlacklistByUid(userId);
		if (null != blacklist) {
			response.putErrorMessage(MsgCodeConstant.POST_FAILED);
			return response;
		}
		int re = postService.limitAddPost(userId);
		if (re == 101) {
			response.putErrorMessage("4.post.post_postsave.addPostLimtOne");
			return response;
		} else if (re == 102) {
			response.putErrorMessage("4.post.post_postsave.addPostLimtOne");
			return response;
		} else if (re == 103) {
			response.putErrorMessage("4.post.post_postsave.addPostLimtOne");
			return response;
		}
		SimpleDateFormat todayDf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("敏感词过滤开始时间==" + todayDf.format((new Date())));
		// 帖子内容有敏感词
		if (wordFind.find(postVo.getContent()).length > 0) {
			response.putErrorMessage("5.invitation.addInvitation.word_fail");
			return response;
		}
		logger.info("敏感词过滤结束时间==" + todayDf.format((new Date())));
		Post post = postService.addPost(userId, postVo.getContent(), postVo.getLabelIds(),
				postVo.getLocation(), postVo.getThumbnail(), postVo.getLabelName());
		if (null == post) {
			response.putErrorMessage("5.invitation.addInvitation.add_fail");
			return response;
		}
		com.sinco.carnation.resource.bo.healthcircle.PostBO responseBO = mapper.map(post,
				com.sinco.carnation.resource.bo.healthcircle.PostBO.class);
		response.setPost(responseBO);
		response.setIslogin(1);
		logger.info("发帖结束时间====" + todayDf.format((new Date())));
		// 发帖送积分
//		integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_FATIE, userId, null);
		return response;
	}

	/**
	 * 我的个人帖子列表
	 * 
	 * @param
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/post/page_post_listByMyUser", method = RequestMethod.POST)
	@MethodMapping(desc = "根据用户查询所有帖子列表")
	public @ResponseBody
	PostResponse postListByMyUser(@Valid @ModelAttribute @Param BasicPageParamVo vo, BindingResult result,
			HttpServletRequest request) {
		PostResponse response = new PostResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		UserCustomer user = userCustomerService.findById(uid);
		MyPage<Post> page = new MyPage<Post>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		List<Post> list = postService.findPageByUserId(page, uid);
		if (null != list && list.size() > 0) {
			list = getImages(list);
			List<com.sinco.carnation.resource.bo.healthcircle.PostBO> posts = MapperUtils.map(mapper, list,
					com.sinco.carnation.resource.bo.healthcircle.PostBO.class);
			response.setPostList(posts);
		}
		if (user != null) {
			UserBO userbo = mapper.map(user, UserBO.class);
			response.setUserBO(userbo);
		}
		response.setIslogin(1);
		return response;
	}

	/**
	 * 我的个人帖子列表
	 * 
	 * @param
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/post/post_list_muid", method = RequestMethod.POST)
	@MethodMapping(desc = "根据用户查询所有帖子列表")
	public @ResponseBody
	PostResponse postListByMyuid(@Valid @ModelAttribute @Param BasicPageParamVo vo, BindingResult result,
			HttpServletRequest request) {
		PostResponse response = new PostResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		UserCustomer user = userCustomerService.findById(uid);
		MyPage<Post> page = new MyPage<Post>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		List<Post> list = postService.findPageByUserId(page, uid);
		if (null != list && list.size() > 0) {
			list = getImages(list);
			List<com.sinco.carnation.resource.bo.healthcircle.PostBO> posts = MapperUtils.map(mapper, list,
					com.sinco.carnation.resource.bo.healthcircle.PostBO.class);
			response.setPostList(posts);
		}
		if (user != null) {
			UserBO userbo = mapper.map(user, UserBO.class);
			response.setUserBO(userbo);
		}
		response.setIslogin(1);
		return response;
	}

	/**
	 * 个人首页帖子列表/原生态开发
	 * 
	 * @param labelId标签id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/post/page_post_listByUserId", method = RequestMethod.POST)
	@MethodMapping(desc = "根据用户查询所有帖子列表")
	public @ResponseBody
	PostResponse postListByUserId(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			@RequestParam(value = "userId") @Param(desc = "用户userId|必传") Long userId, BindingResult result,
			HttpServletRequest request) {
		PostResponse response = new PostResponse();
		if (userId == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		UserCustomer user = userCustomerService.findById(userId);
		MyPage<Post> page = new MyPage<Post>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		// 获取当前用户ID
		Long currentUserId = ActionsUtil.getOwnerUid();
		List<Post> list = postService.findPageByUserId(page, userId, currentUserId);
		if (null != list && list.size() > 0) {
			list = getImages(list);
			List<com.sinco.carnation.resource.bo.healthcircle.PostBO> posts = MapperUtils.map(mapper, list,
					com.sinco.carnation.resource.bo.healthcircle.PostBO.class);
			response.setPostList(posts);
		}
		if (user != null) {
			UserBO userbo = mapper.map(user, UserBO.class);
			response.setUserBO(userbo);
		}
		response.setIslogin(1);
		return response;
	}

	/**
	 * app展示标签列表ispush=1表示显示,ispush=0默认不显示,模糊查询/h5
	 * 
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/post/push_label_list", method = RequestMethod.POST)
	@MethodMapping(desc = "系统推送标签列表")
	public @ResponseBody
	PostLabelResponse pushlabelList(HttpServletRequest request) {
		PostLabelResponse postLabelResponse = new PostLabelResponse();
		LabelVO labelvo = new LabelVO();
		labelvo.setState(LabelCenterConstant.LABEL_STATE_1);
		labelvo.setServiceType(LabelCenterConstant.LABEL_SERVICETYPE_0);
		labelvo.setIspush(1);
		List<Label> list = postLabelService.selectList(labelvo);
		if (null != list && list.size() > 0) {
			List<com.sinco.carnation.resource.bo.healthcircle.healthLabelBO> labels = MapperUtils.map(mapper,
					list, com.sinco.carnation.resource.bo.healthcircle.healthLabelBO.class);
			postLabelResponse.setLabellist(labels);
		}
		return postLabelResponse;
	}

	/**
	 * 模糊查询；参数传labelName/原生
	 * 
	 * @param result
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/post/page_label_list", method = RequestMethod.POST)
	@MethodMapping(desc = "模糊查询标签列表")
	public @ResponseBody
	PostLabelResponse labelList(@Valid @ModelAttribute @Param LabelAddVO VO, BindingResult result,
			HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		PostLabelResponse postLabelResponse = new PostLabelResponse();
		LabelVO vo = new LabelVO();
		vo.setLabelName(VO.getLabelName());
		vo.setState(LabelCenterConstant.LABEL_STATE_1);
		vo.setServiceType(LabelCenterConstant.LABEL_SERVICETYPE_0);
		List<Label> list = postLabelService.selectList(vo);
		if (null != list && list.size() > 0) {
			List<com.sinco.carnation.resource.bo.healthcircle.healthLabelBO> labels = MapperUtils.map(mapper,
					list, com.sinco.carnation.resource.bo.healthcircle.healthLabelBO.class);
			postLabelResponse.setLabellist(labels);
		}
		return postLabelResponse;
	}

	/**
	 * 用户新增自定义标签
	 * 
	 * @param labelName
	 *            /原生
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/post/page_label_add", method = RequestMethod.POST)
	@MethodMapping(desc = "用户自定义标签")
	public @ResponseBody
	PostLabelResponse saveLabel(@Valid @ModelAttribute @Param LabelAddVO labelVO, BindingResult result,
			HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		PostLabelResponse postLabelResponse = new PostLabelResponse();
		Long userId = ActionsUtil.getOwnerUid();
		if (userId == null) {
			postLabelResponse.putErrorMessage("3.user.feedList.rid_null");
			return postLabelResponse;
		}
		Label label = new Label();
		label.setLabelName(labelVO.getLabelName());
		label.setType(LabelCenterConstant.LABEL_TYPE_1);
		label.setUserId(userId);
		label.setAddTime(new Date());
		label.setServiceType(LabelCenterConstant.LABEL_SERVICETYPE_0);
		label.setState(LabelCenterConstant.LABEL_STATE_1);
		int num = postLabelService.save(label);
		com.sinco.carnation.resource.bo.healthcircle.healthLabelBO labelBO = mapper.map(label,
				com.sinco.carnation.resource.bo.healthcircle.healthLabelBO.class);
		if (num == 400) {
			postLabelResponse.putErrorMessage("3.post.page_label_add.labelname_null");
			return postLabelResponse;
		} else if (num == 300) {
			postLabelResponse.putErrorMessage("3.post.page_label_add.fail");
			return postLabelResponse;
		} else {
			postLabelResponse.setLabelBO(labelBO);
		}
		return postLabelResponse;
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

	/**
	 * 判断token是否有效
	 */
	@RequestMapping(value = "/post/is_login", method = RequestMethod.POST)
	@MethodMapping(desc = "是否登录")
	public IsLoginResponse islogin(HttpServletRequest request) {
		IsLoginResponse response = new IsLoginResponse();
		Long userId = ActionsUtil.getOwnerUid();
		logger.info("userId=========================登录" + userId);
		if (null != userId) {
			response.setIslogin(1);
		} else {
			response.setIslogin(0);
		}
		return response;
	}

	/**
	 * 健康圈首页帖子列表全部/原生态开发|已登录
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/post/page_postlist_login", method = RequestMethod.POST)
	@MethodMapping(desc = "已登录帖子分页查询全部")
	public @ResponseBody
	PostResponse postListlogin(@Valid @ModelAttribute @Param BasicPageParamVo vo, BindingResult result,
			@RequestParam(value = "postType") @Param(desc = "类型0:全部,1:热门") Integer postType,
			HttpServletRequest request) {
		PostResponse response = new PostResponse();
		Long userId = ActionsUtil.getOwnerUid();// 当前用户
		if (userId == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		MyPage<Post> page = new MyPage<Post>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		// PostVO postVo = null;
		List<Post> list = postService.findPageByType(page, postType, userId, null);
		if (null != list && list.size() > 0) {
			list = getImages(list);
			List<com.sinco.carnation.resource.bo.healthcircle.PostBO> posts = MapperUtils.map(mapper, list,
					com.sinco.carnation.resource.bo.healthcircle.PostBO.class);
			response.setPostList(posts);
		}
		logger.info("userId=========================已登录首页" + userId);
		if (null != userId) {
			response.setIslogin(1);
		} else {
			response.setIslogin(0);
		}
		return response;
	}

	/**
	 * 根据id查询帖子详情/h5开发
	 * 
	 * @param Id
	 * @param request
	 * @return
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	@RequestMapping(value = "/post/page_post_detail", method = RequestMethod.GET)
	public ModelAndView postDetail(HttpServletRequest request, HttpServletResponse response, Long Id, Long uid) {
		logger.info("============ 帖子详情 ============== ");
		ModelAndView model = new ModelAndView("healthCircle/postDetail.html");
		String result = "success";
		if (Id == null) {
			result = "fail";
		}
		Post post = postService.selectById(Id, uid);
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
			model.addObject("postBO", post);
		}
		// 根据帖子id查询所有评论信息
		MyPage<PostEvaluate> page = new MyPage<PostEvaluate>();
		page.setPageNumber(1);
		page.setPageSize(1000);
		List<PostEvaluate> evaluatelist = postEvaluateService.selectPageByPostId(page, Long.valueOf(Id));
		model.addObject("evaluateList", evaluatelist);
		// model.addObject("headImageSize", ImageConstants.USER_HEAD);
		// String webPath = CommUtil.getURL(request);
		// model.addObject("apiPath", webPath);
		model.addObject("result", result);
		return model;
	}

	/**
	 * 帖子评论/h5开发
	 * 
	 * @param 帖子id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/post/post_postEvaluete", method = RequestMethod.POST)
	public void uodate_postEvaluete(HttpServletRequest request, HttpServletResponse response, Long postId,
			String content, Long uid) throws Exception {
		Map<String, Object> resp = new HashMap<>();
		PostEvaluate eval = new PostEvaluate();
		eval.setPostId(postId);
		eval.setContent(content);
		eval.setFromUserid(uid);
		// eval.setToUserid(vo.getToUserId());
		eval.setType(0);// 评论
		eval.setPid(Long.valueOf(-1));// 评论时全为-1
		int num = postService.updatePostEvaluete(eval);
		eval.setAddtiemFormat("刚刚");
		UserCustomerBO user = userCustomerService.searchCustomer(uid);
		if (user != null) {
			eval.setHeadImgPath(user.getHeadImgPath());
		}
//		// 评论回帖送积分
//		integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_PINGLUN, uid, null);
//		// 被评论送积分
//		if (null != postId) {
//			Post post = postService.findById(postId);
//			if (post != null){
//				integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_BEIPINGLUN,
//						post.getUserId(), null);
//			}else{
//				logger.debug("[uodate_postEvaluete] post = null ,postId="+postId+" ,uid="+uid);
//			}
//		}else{
//			logger.debug("[uodate_postEvaluete] postId=null ,uid="+uid);
//		}
		resp.put("evalBO", eval);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(resp, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 评论回复/h5开发
	 * 
	 * @param 帖子id
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/post/post_replyEvaluete", method = RequestMethod.POST)
	public void uodate_replyEvaluete(HttpServletRequest request, HttpServletResponse response, Long postId,
			String content, Long PID, Long uid) {
		Map<String, Object> resp = new HashMap<>();
		PostEvaluate eval = new PostEvaluate();
		eval.setPostId(postId);
		eval.setContent(content);
		eval.setFromUserid(uid);
		eval.setType(1);// 回复
		eval.setPid(PID);// 回复某条评论的id
		int num = postService.updateReplyEvaluete(eval);
		eval.setAddtiemFormat("刚刚");
		resp.put("evalBO", eval);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
//		// 评论回帖送积分
//		integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_PINGLUN, uid, null);
//		// 被评论送积分
//		if (null != postId) {
//			Post post = postService.findById(postId);
//			if (post != null)
//				integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_BEIPINGLUN,
//						post.getUserId(), null);
//		}
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(resp, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用户删除帖子
	 * 
	 * @param result
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/post/post_delete", method = RequestMethod.POST)
	@MethodMapping(desc = "用户删除帖子")
	public @ResponseBody
	PostDelResponse post_delete(@Valid @ModelAttribute @Param PostDeleteVO VO, BindingResult result,
			HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		PostDelResponse response = new PostDelResponse();
		Long userId = ActionsUtil.getOwnerUid();
		if (userId == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		if (VO.getPostId() == null) {
			response.putErrorMessage("3.post.post_delete.postId_null");
			return response;
		}
		postService.deleteByUIdPId(userId, VO.getPostId());
		response.setIsdelete(1);
		return response;
	}

	/**
	 * 根据id查询帖子详情/原生开发
	 * 
	 * @param Id
	 * @param request
	 * @return
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	@RequestMapping(value = "/post/post_detail", method = RequestMethod.POST)
	@MethodMapping(desc = "原生帖子详情")
	public @ResponseBody
	PostResponse post_detail(@Valid @RequestParam(value = "Id") @Param(desc = "帖子Id|必传") Long Id,
			HttpServletRequest request) {
		logger.info("============ 原生帖子详情 ============== ");
		PostResponse postResponse = new PostResponse();
		Long uid = ActionsUtil.getOwnerUid();
		/*if (uid == null) {
			postResponse.putErrorMessage("3.user.feedList.rid_null");
			return postResponse;
		}*/
		Post post = postService.selectById(Id, uid);
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
			PostBO postBO = mapper.map(post, PostBO.class);
			// 根据帖子id查询所有评论信息
			MyPage<PostEvaluate> page = new MyPage<PostEvaluate>();
			page.setPageNumber(1);
			page.setPageSize(1000);
			List<PostEvaluate> evaluatelist = postEvaluateService.selectPageByPostId(page, Long.valueOf(Id));
			if (evaluatelist != null && evaluatelist.size() > 0) {
				List<PostEvaluateBO> evaluatelistBO = MapperUtils.map(mapper, evaluatelist,
						PostEvaluateBO.class);
				postBO.setEvaluateList(evaluatelistBO);
			}
			postResponse.setPost(postBO);
		}
		return postResponse;
	}

	/**
	 * 帖子评论/原生开发
	 * 
	 * @param 帖子id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/post/post_evaluete", method = RequestMethod.POST)
	@MethodMapping(desc = "评论帖子")
	public @ResponseBody
	EvaluateResponse post_evaluete(@Valid @ModelAttribute @Param PostEvalueteVO VO, BindingResult result,
			HttpServletRequest request) {
		EvaluateResponse evaluateResponse = new EvaluateResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), evaluateResponse);
			return evaluateResponse;
		}
		if (uid == null) {
			evaluateResponse.putErrorMessage("3.user.feedList.rid_null");
			return evaluateResponse;
		}
		// 验证是否为黑名单
		BlacklistBO blacklist = blacklistService.getBlacklistByUid(uid);
		if (null != blacklist) {
			evaluateResponse.putErrorMessage(MsgCodeConstant.EVALUATE_FAILED);
			return evaluateResponse;
		}
		PostEvaluate eval = new PostEvaluate();
		eval.setPostId(VO.getPostId());
		eval.setContent(VO.getContent());
		eval.setFromUserid(uid);
		eval.setType(0);// 评论
		eval.setPid(Long.valueOf(-1));// 评论时全为-1
		int num = postService.updatePostEvaluete(eval);
		if (num == 100) {
			evaluateResponse.setResult(1);
		}
		UserCustomerBO user = userCustomerService.searchCustomer(uid);
		if (user != null) {
			eval.setHeadImgPath(user.getHeadImgPath());
		}
//		// 评论回帖送积分
//		integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_PINGLUN, uid, null);
//		// 被评论送积分
//		if (null != VO.getPostId()) {
//			Post post = postService.findById(VO.getPostId());
//			if (post != null)
//				integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_BEIPINGLUN,
//						post.getUserId(), null);
//		}
		eval.setAddtiemFormat("刚刚");
		PostEvaluateBO evalBO = mapper.map(eval, PostEvaluateBO.class);
		evaluateResponse.setEvalBO(evalBO);
		return evaluateResponse;

	}

	/**
	 * 评论回复原生
	 * 
	 * @param 帖子id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/post/post_reply", method = RequestMethod.POST)
	@MethodMapping(desc = "回复帖子原生")
	public @ResponseBody
	EvaluateResponse post_reply(@Valid @ModelAttribute @Param PostEvalueteVO VO, BindingResult result,
			HttpServletRequest request) {
		EvaluateResponse evaluateResponse = new EvaluateResponse();
		Long uid = ActionsUtil.getOwnerUid();
		PostEvaluate eval = new PostEvaluate();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), evaluateResponse);
			return evaluateResponse;
		}
		if (uid == null) {
			evaluateResponse.putErrorMessage("3.user.feedList.rid_null");
			return evaluateResponse;
		}
		// 验证是否为黑名单
		BlacklistBO blacklist = blacklistService.getBlacklistByUid(uid);
		if (null != blacklist) {
			evaluateResponse.putErrorMessage(MsgCodeConstant.EVALUATE_FAILED);
			return evaluateResponse;
		}

		eval.setPostId(VO.getPostId());
		eval.setContent(VO.getContent());
		eval.setFromUserid(uid);
		eval.setType(1);// 回复
		eval.setPid(VO.getPid());// 回复某条评论的id
		eval.setToUserid(VO.getToUserId());
		int num = postService.updateReplyEvaluete(eval);
		if (num == 100) {
			evaluateResponse.setResult(1);
		}
		// 评论回帖赠送积分
//		integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_PINGLUN, uid, null);
		// 被评论送积分
//		if (null != VO.getPostId()) {
//			Post post = postService.findById(VO.getPostId());
//			if (post != null)
//				integralService.addIntegral(IntegralConstants.INTEGRAL_JIANKANGQUAN_BEIPINGLUN,
//						post.getUserId(), null);
//		}
		eval.setAddtiemFormat("刚刚");
		PostEvaluateBO evalBO = mapper.map(eval, PostEvaluateBO.class);
		evaluateResponse.setEvalBO(evalBO);
		return evaluateResponse;
	}
	/**
	 * 评论分页处理
	 */
	/*
	@RequestMapping(value = "/post/evaluateList", method = RequestMethod.POST)
	@MethodMapping(desc = "评论分页处理")
	public String evaluateList(@Valid @ModelAttribute @Param BasicPageParamVo vo,BindingResult result,Model model,@RequestParam(value = "postId") @Param(desc = "自定义标签名称") Long postId){
		String result_ = ApiConstants.SUCC;
		MyPage<PostEvaluate> page=new MyPage<PostEvaluate>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(1000);
		List<PostEvaluate> evaluatelist=postEvaluateService.selectPageByPostId(page,postId);
		List<com.sinco.carnation.resource.bo.healthcircle.PostEvaluateBO> resevaluatelist=null;
		if(null!=evaluatelist&&evaluatelist.size()>0){
		    resevaluatelist=MapperUtils.map(mapper,evaluatelist,com.sinco.carnation.resource.bo.healthcircle.PostEvaluateBO.class);			
		}
		model.addAttribute("evaluateList", resevaluatelist);
		long remainNum=page.getTotalElements()-vo.getPageNum()*vo.getPageNum();
		if(remainNum<=0){
			remainNum=0;
		}
		model.addAttribute("remainNum",remainNum);
		return "";
	}*/
}
