package com.sinco.carnation.sys.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.bo.ArticleClassBO;
import com.sinco.carnation.sys.dao.ArticleClassDao;
import com.sinco.carnation.sys.dao.ArticleDao;
import com.sinco.carnation.sys.model.ArticleClass;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class ArticleClassService {

	@Autowired
	private ArticleClassDao articleClassDao;

	@Autowired
	private ArticleDao articleDao;

	/**
	 * 根据标识查找
	 * 
	 * @param mark
	 * @return
	 */
	public ArticleClassBO findByMark(String mark) {
		ArticleClassBO BO = articleClassDao.findByMark(mark);
		if(BO == null){
			return new ArticleClassBO();
		}
		return articleClassDao.findByMark(mark);
	}

	/**
	 * 得到商城首页的
	 * 
	 * @return
	 */
	public List<ArticleClassBO> findShopHome() {
		List<String> marks = new ArrayList<String>();// 排除首页有商家4个分类及商家独享的文章信息，erikzhang
		/*marks.add("zhifu");
		marks.add("guize");
		marks.add("zhinan");
		marks.add("anquan");
		marks.add("gonggao");
		marks.add("new_func");
		marks.add("sellernotice");
		marks.add("shanjiaxuzhi");
		marks.add("shangjiafuwu");
		marks.add("chatting_article");
		marks.add("o2osellernotice");
		marks.add("operatornotice");*/
		marks.add("wuliu");
		marks.add("about");
		marks.add("shouhou");
		marks.add("gouwuxuzhi");
		return findByParentIsNull(marks, 4, true);
	}

	/**
	 * 按级别整理好的对象
	 * 
	 * @return
	 */
	public List<ArticleClassBO> findLevelAll() {
		return articleClassDao.findLevelAll(true);
	}

	/**
	 * 按级别整理好的对象 ,排除运营商公告/商户公告/店铺公告【这些公告不对会员，只针对管理者】
	 * 
	 * @return
	 */
	public List<ArticleClassBO> findLevelAllWithOutManager() {
		return articleClassDao.findLevelAll(false);
	}

	/**
	 * 得到根节点
	 * 
	 * @return
	 */
	public List<ArticleClassBO> findByParentIsNull() {
		return articleClassDao.findByParentIsNull();
	}

	/**
	 * 得到根节点
	 * 
	 * @return
	 */
	public List<ArticleClassBO> findByParentIsNull(List<String> marks, Integer count, boolean isLoadArticle) {
		List<ArticleClassBO> list = articleClassDao.findByParentIsNull(marks, count);
		if (isLoadArticle) {
			for (ArticleClassBO articleClassBO : list) {
				articleClassBO.setArticles(articleDao.findByClass(articleClassBO.getId()));
			}
		}
		return list;
	}

	/**
	 * 所有顶级分类
	 * 
	 * @return
	 */
	public List<ArticleClassBO> topClass() {
		return articleClassDao.topClass();
	}

	/**
	 * 根据name 是到数量
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	public int countByName(String name, Long id) {
		return articleClassDao.countByName(name, id);
	}

	public List<ArticleClassBO> findByParent(Long parnetId) {
		return articleClassDao.findByParent(parnetId);
	}

	public List<ArticleClassBO> findAllOrder() {
		return articleClassDao.findAllOrder();
	}

	/**
	 * 分布查询
	 * 
	 * @param page
	 * @return
	 */
	public List<ArticleClassBO> findByPage(MyPage<ArticleClassBO> page) {
		return articleClassDao.findByPage(page);
	}

	public boolean save(ArticleClass articleClass) {
		this.articleClassDao.save(articleClass);
		return true;
	}

	public ArticleClass getObjById(Long id) {
		ArticleClass articleClass = this.articleClassDao.get(id);
		if (articleClass != null) {
			return articleClass;
		}
		return null;
	}

	/**
	 * 得到所有子对象id
	 * 
	 * @return
	 */
	public List<Long> findChildId(Long id) {
		List<ArticleClassBO> list = articleClassDao.findAllChild(id);
		List<Long> ids = new ArrayList<Long>();
		for (ArticleClassBO ac : list) {
			ids.add(ac.getId());
		}
		return ids;
	}

	/**
	 * 删除，并删除所有子节点
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Long id) {
		int result = this.articleClassDao.remove(id);
		if (result > 0) {
			List<ArticleClassBO> list = articleClassDao.findAllChild(id);
			List<Long> ids = new ArrayList<Long>();
			for (ArticleClassBO ac : list) {
				ids.add(ac.getId());
			}
			if (ids.size() > 0) {
				articleClassDao.deleteByIds(ids);
			}
		}
		return true;
	}

	/**
	 * 删除，并删除所有子节点
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Long... ids) {
		for (Long id : ids) {
			delete(id);
		}
		return true;
	}

	public List<ArticleClassBO> findArticleClassByParentId(Long parentClassId) {
		return articleClassDao.findArticleClassByParentId(parentClassId);
	}

	public boolean batchDelete(List<Serializable> articleClassIds) {
		// TODO Auto-generated method stub
		for (Serializable id : articleClassIds) {
			delete((Long) id);
		}
		return true;
	}

//	public IPageList list(IQueryObject properties) {
//		if (properties == null) {
//			return null;
//		}
//		String query = properties.getQuery();
//		String construct = properties.getConstruct();
//		Map params = properties.getParameters();
//		GenericPageList pList = new GenericPageList(ArticleClass.class,
//				construct, query, params, this.articleClassDao);
//		if (properties != null) {
//			PageObject pageObj = properties.getPageObj();
//			if (pageObj != null)
//				pList.doList(
//						pageObj.getCurrentPage() == null ? 0 : pageObj
//								.getCurrentPage(),
//						pageObj.getPageSize() == null ? 0 : pageObj
//								.getPageSize());
//		} else
//			pList.doList(0, -1);
//		return pList;
//	}

	public boolean update(ArticleClass articleClass) {
		try {
			this.articleClassDao.update(articleClass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ArticleClassBO> queryArticleList(String mark) {
		return articleClassDao.queryArticleList(mark);
	}

//	public List<ArticleClass> query(String query, Map params, int begin, int max) {
//		return this.articleClassDao.query(query, params, begin, max);
//
//	}
//
//	@Override
//	public ArticleClass getObjByPropertyName(String construct,
//			String propertyName, Object value) {
//		// TODO Auto-generated method stub
//		return this.articleClassDao.getBy(construct, propertyName, value);
//	}
}
