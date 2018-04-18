package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.mapper.ArticleMapper;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.model.ArticleExample;
import com.sinco.carnation.sys.vo.ArticleShopVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ArticleDao {

	@Autowired
	private ArticleMapper mapper;

	/**
	 * 得到商城显示文章,分页
	 * 
	 * @param vo
	 * @return
	 */
	public List<ArticleBO> findShopPageByVO(ArticleShopVO vo, MyPage<ArticleBO> page) {
		return mapper.findShopPageByVO(vo, page);
	}

	/**
	 * 得到商城前端文章
	 * 
	 * @param vo
	 * @return
	 */
	public List<ArticleBO> findShopByVO(ArticleShopVO vo) {
		return mapper.findShopByVO(vo);
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
		return mapper.findByParentClassMark(type, marks, display, count);
	}

	public List<ArticleBO> findByClass(Long classId) {
		return mapper.selectByClassId(null, classId, null);
	}

	/**
	 * 根据 mark
	 * 
	 * @param mark
	 * @param id
	 * @return
	 */
	public int countBymMark(String mark, Long id) {
		ArticleExample example = new ArticleExample();
		ArticleExample.Criteria c = example.createCriteria();
		c.andMarkEqualTo(mark);
		if (id != null) {
			c.andIdNotEqualTo(id);
		}
		return mapper.countByExample(example);
	}

	/**
	 * 根据 mark
	 * 
	 * @param mark
	 * @param id
	 * @return
	 */
	public ArticleBO findByMark(String mark) {
		ArticleExample example = new ArticleExample();
		ArticleExample.Criteria c = example.createCriteria();
		c.andMarkEqualTo(mark);
		List<ArticleBO> list = mapper.selectByExampleWithBLOBs(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * 根据 mark找公告，包含二级子目录的公告
	 * 
	 * @param mark
	 * @param id
	 * @return
	 */
	public List<ArticleBO> findByParentMark(String mark, MyPage<ArticleBO> page) {
		List<ArticleBO> list = mapper.findByParentMark(page, mark);
		return list;
	}

	public List<ArticleBO> findByPage(String title, String articleClassName, MyPage<ArticleBO> page) {
		List<ArticleBO> list = mapper.findByPage(title, articleClassName, page);
		page.setContent(list);
		return list;
	}

	public List<ArticleBO> top6() {
		return mapper.top6();
	}

	/** generate code begin **/
	public List<Article> findAll() {
		ArticleExample example = new ArticleExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ArticleExample example = new ArticleExample();
		return mapper.countByExample(example);
	}

	public List<Article> save(Iterable<Article> entities) {
		List<Article> list = new ArrayList<Article>();
		for (Article Article : entities) {
			list.add(save(Article));
		}
		return list;
	}

	public Article save(Article record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Article record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Article findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Article get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ArticleExample example = new ArticleExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Article> findAll(Iterable<Long> ids) {
		ArticleExample example = new ArticleExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public List<Article> findAllByIds(Iterable<Long> ids) {
		return this.findAll(ids);
	}

	public List<ArticleBO> selectPageByClassId(Long classId, String type, MyPage<ArticleBO> page) {
		return mapper.selectPageByClassId(type, classId, page);
	}

	public List<ArticleBO> selectByClassId(Long classId, String type) {
		return mapper.selectByClassId(type, classId, null);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Article entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Article> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Article entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ArticleExample example = new ArticleExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ArticleExample example = new ArticleExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/*
	 * show article view
	 */
	public List<ArticleBO> selectViewPageListByMark(MyPage<ArticleBO> page, ArticleShopVO vo) {
		List<ArticleBO> list = mapper.selectViewPageListByMark(page, vo);
		return list;
	}

	public List<ArticleBO> selectViewPageList(MyPage<ArticleBO> page, ArticleShopVO vo) {
		List<ArticleBO> list = mapper.selectViewPageList(page, vo);
		return list;
	}

	public List<ArticleBO> selectViewDetailsPrevious(Long cid, Long aid) {
		List<ArticleBO> list = mapper.selectViewDetailsPrevious(cid, aid);
		return list;
	}

	public List<ArticleBO> selectViewDetailsNext(Long cid, Long aid) {
		List<ArticleBO> list = mapper.selectViewDetailsNext(cid, aid);
		return list;
	}

	public List<ArticleBO> queryMerchantNoticeList(String mark, MyPage<ArticleBO> page) {
		return mapper.queryMerchantNoticeList(mark, page);
	}

	public List<ArticleBO> queryUserArticList(Long id, String user) {
		return mapper.queryUserArticList(id, user);
	}

	public List<ArticleBO> selectByClassIdcount(Long classId, Integer count) {
		return mapper.selectByClassId(null, classId, count);
	}
	

	public List<ArticleBO> listByParentMarkAndCount(Long count,String mark){
		return mapper.listByParentMarkAndCount(count, mark);
	}
}
