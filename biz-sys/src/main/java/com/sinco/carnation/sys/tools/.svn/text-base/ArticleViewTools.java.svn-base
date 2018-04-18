package com.sinco.carnation.sys.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.contants.SysContants;
import com.sinco.carnation.sys.dao.ArticleDao;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.vo.ArticleShopVO;

/**
 * 
 * <p>
 * Title: ArticleViewTools.java
 * </p>
 * 
 * <p>
 * Description: 文章查询工具类，用于前端velocity模板中的信息查询
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-9-29
 * 
 * @version 1.0.1
 */
@Component
public class ArticleViewTools {
	@Autowired
	private ArticleDao articleDao;

	/**
	 * 根据postion参数查询谋id文章的上一篇、下一篇文章，position为-1为上一篇，position为1为下一篇
	 * 
	 * @param id
	 * @param position
	 * @return
	 */
	@SuppressWarnings({"unused", "unchecked", "rawtypes"})
	public Article queryArticle(Long id, int position) {
		String query = "select obj from Article obj where obj.articleClass.id=:class_id "
				+ "and obj.display=:display and obj.type=:type and ";

		Article article = this.articleDao.findOne(id);

		if (article != null) {
			Map params = new HashMap();
			params.put("addTime", article.getAddTime());
			params.put("class_id", article.getArticleClassId());
			params.put("type", "user");
			params.put("display", true);

			ArticleShopVO vo = new ArticleShopVO();
			vo.setClassId(article.getArticleClassId());
			vo.setType(SysContants.ARTICLE_TYPE_USER);
			vo.setDisplay(true);
			if (position > 0) {
				vo.setGtAddTime(article.getAddTime());
			} else {
				vo.setLtAddTime(article.getAddTime());
			}

			List<ArticleBO> objs = this.articleDao.findShopByVO(vo);
			if (objs.size() > 0) {
				return objs.get(0);
			} else {
				Article obj = new Article();
				obj.setTitle("没有了");
				return obj;
			}
		} else {
			Article obj = new Article();
			obj.setTitle("没有了");
			return obj;
		}
	}
}
