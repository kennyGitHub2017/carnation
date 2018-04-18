package com.sinco.carnation.resource.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.dozer.Mapper;
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
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.constant.WebConstant;
import com.sinco.carnation.resource.web.response.article.AritcleResponse;
import com.sinco.carnation.resource.web.response.favorites.ArticleClassListResponse;
import com.sinco.carnation.resource.web.response.favorites.ArticleListResponse;
import com.sinco.carnation.sns.SNSConstants;
import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.bo.ArticleClassBO;
import com.sinco.carnation.sys.service.ArticleClassService;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "系统文章相关", namespace = "article")
public class ArticleController extends BasicApiController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ArticleClassService articleClassService;

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private UserRelationService userRelationService;
	/**
	 * 系统文章列表
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sys/article/page_article_list", method = RequestMethod.POST)
	@MethodMapping(desc = "系统文章列表根据分类分页查询")
	public @ResponseBody
	AritcleResponse sysArticleNoticeList(@Valid @ModelAttribute @Param BasicPageParamVo vo,
			BindingResult result, HttpServletRequest request) {
		AritcleResponse response = new AritcleResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<ArticleBO> page = new MyPage<ArticleBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		articleService.selectPageByClassId(WebConstant.ARTICLE_NOTICE_ID, page,
				SNSConstants.ARTICLE_TYPE_USER);
		List<com.sinco.carnation.resource.bo.ArticleBO> articles = MapperUtils.map(mapper, page.getContent(),
				com.sinco.carnation.resource.bo.ArticleBO.class);

		response.setArticles(articles);
		// 设置总记录数
		response.setTotalCount(page.getTotalElements());

		return response;
	}

	@RequestMapping(value = "/sys/article/all_article_list", method = RequestMethod.POST)
	@MethodMapping(desc = "文章资讯根据分类查询全部")
	public @ResponseBody
	ArticleListResponse snsInfomationList(
			@Valid @RequestParam(value = "classId") @Param(desc = "帖子分类id，查询当前分类下的所有帖子") Long classId,
			HttpServletRequest request) {

		ArticleListResponse response = new ArticleListResponse();
		if (classId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		List<ArticleBO> listResult = articleService.selectByClassId(classId, SNSConstants.ARTICLE_TYPE_USER);
		List<com.sinco.carnation.resource.bo.ArticleBO> list = MapperUtils.map(mapper, listResult,
				com.sinco.carnation.resource.bo.ArticleBO.class);
		response.setArticles(list);
		return response;
	}

	@RequestMapping(value = "/sys/article/article_class", method = RequestMethod.POST)
	@MethodMapping(desc = "文章分类")
	public @ResponseBody
	ArticleClassListResponse snsInfomationClass(
			@Valid @RequestParam(value = "parentClassId") @Param(desc = "传入分类id，查询该分类下的一级子分类") Long parentClassId,
			HttpServletRequest request) {

		ArticleClassListResponse response = new ArticleClassListResponse();
		if (parentClassId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		List<ArticleClassBO> listClass = articleClassService.findArticleClassByParentId(parentClassId);

		List<com.sinco.carnation.resource.bo.ArticleClassBO> articleClasses = MapperUtils.map(mapper,
				listClass, com.sinco.carnation.resource.bo.ArticleClassBO.class);
		response.setArticleClasses(articleClasses);

		return response;
	}
	
	@RequestMapping(value = "/test/test/test", method = RequestMethod.GET)
	@MethodMapping(desc = "文章分类")
	public @ResponseBody
	ArticleClassListResponse testTestTest(
			@Valid @RequestParam(value = "uid") @Param(desc = "uid") Long uid) {

		ArticleClassListResponse response = new ArticleClassListResponse();
		
		UserRelationBO relation = userRelationService.findOneByUid(uid);
		
		userRelationService.addRelationLog(relation, relation.getRefereeUserId(), relation.getSellerUserId(), "我也不知道为什么要加日志", 1);
		return response;
	}

}
