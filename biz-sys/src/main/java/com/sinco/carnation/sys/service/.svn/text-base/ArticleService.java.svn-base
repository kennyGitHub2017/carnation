package com.sinco.carnation.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.dao.ArticleDao;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.vo.ArticleShopVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;

	/**
	 * 根据 mark
	 * 
	 * @param mark
	 * @param id
	 * @return
	 */
	public ArticleBO findByMark(String mark) {
		return articleDao.findByMark(mark);
	}

	/**
	 * 根据 mark找公告，包含二级子目录的公告
	 * 
	 * @param mark
	 * @param page
	 * @return
	 */
	public List<ArticleBO> findByParentMark(String mark, MyPage<ArticleBO> page) {
		return articleDao.findByParentMark(mark, page);
	}

	/**
	 * 得到商城显示文章,分页
	 * 
	 * @param vo
	 * @return
	 */
	public List<ArticleBO> findShopPageByVO(ArticleShopVO vo, MyPage<ArticleBO> page) {
		return articleDao.findShopPageByVO(vo, page);
	}

	/**
	 * 得到商城前端文章
	 * 
	 * @param vo
	 * @return
	 */
	public List<ArticleBO> findShopByVO(ArticleShopVO vo) {
		return articleDao.findShopByVO(vo);
	}

	/**
	 * 根据文章分类查找
	 * 
	 * @param type
	 * @param marks
	 * @param display
	 * @param count
	 * @return
	 */
	public List<ArticleBO> findByParentClassMark(String type, List<String> marks, Boolean display,
			Integer count) {
		return articleDao.findByParentClassMark(type, marks, display, count);
	}

	/**
	 * 根据 mark
	 * 
	 * @param mark
	 * @param id
	 * @return
	 */
	public int countBymMark(String mark, Long id) {
		return articleDao.countBymMark(mark, id);
	}

	/**
	 * 分布查询
	 * 
	 * @param page
	 * @return
	 */
	public List<ArticleBO> findByPage(String title, String articleClassName, MyPage<ArticleBO> page) {
		return articleDao.findByPage(title, articleClassName, page);
	}

	public boolean save(Article article) {
		/**
		 * init other field here
		 */
		this.articleDao.save(article);
		return true;
	}

	public Article getObjById(Long id) {
		Article article = this.articleDao.get(id);
		if (article != null) {
			return article;
		}
		return null;
	}

	public List<ArticleBO> top6() {
		return articleDao.top6();
	}

	public boolean delete(Long id) {
		try {
			this.articleDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Long> articleIds) {
		this.articleDao.deleteByIds(articleIds);
		return true;
	}

	public void selectPageByClassId(Long classId, MyPage<ArticleBO> page, String type) {
		page.setContent(articleDao.selectPageByClassId(classId, type, page));
	}

	public List<ArticleBO> selectByClassId(Long classId, String type) {
		return articleDao.selectByClassId(classId, type);
	}

	public boolean update(Article article) {
		try {
			this.articleDao.update(article);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ArticleBO> selectViewPageListByMark(MyPage<ArticleBO> page, ArticleShopVO vo) {
		return articleDao.selectViewPageListByMark(page, vo);
	}

	public List<ArticleBO> selectViewPageList(MyPage<ArticleBO> page, ArticleShopVO vo) {
		return articleDao.selectViewPageList(page, vo);
	}

	public List<ArticleBO> selectViewDetailsPrevious(Long cid, Long aid) {
		return articleDao.selectViewDetailsPrevious(cid, aid);
	}

	public List<ArticleBO> selectViewDetailsNext(Long cid, Long aid) {
		return articleDao.selectViewDetailsNext(cid, aid);
	}

	public void queryMerchantNoticeList(String mark, MyPage<ArticleBO> page) {
		page.setContent(articleDao.queryMerchantNoticeList(mark, page));
	}

	public List<ArticleBO> selectPreNextById(Long aid) {
		List<ArticleBO> ls = new ArrayList<ArticleBO>();
		Article article = articleDao.get(aid);
		List<ArticleBO> next = articleDao.selectViewDetailsPrevious(article.getArticleClassId(), aid);
		List<ArticleBO> pre = articleDao.selectViewDetailsNext(article.getArticleClassId(), aid);

		if (null != pre && !pre.isEmpty()) {
			ls.addAll(pre);
		} else {
			ls.add(new ArticleBO());
		}
		ArticleBO bo = new ArticleBO();
		BeanUtils.copyProperties(article, bo);
		ls.add(bo);
		if (null != next && !next.isEmpty()) {
			ls.addAll(next);
		} else {
			ls.add(new ArticleBO());
		}

		return ls;
	}

	public List<ArticleBO> queryUserArticList(Long id, String user) {
		return articleDao.queryUserArticList(id, user);
	}

	/**
	 * 
	 */
	public List<ArticleBO> selectByClassId(Long classId, Integer count) {
		if(classId == null){
			return new ArrayList<ArticleBO>();
		}
		return articleDao.selectByClassIdcount(classId, count);
	}

	public List<ArticleBO> listByParentMarkAndCount(Long count,String mark){
		return articleDao.listByParentMarkAndCount(count, mark);
	}
}
