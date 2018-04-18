package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.mapper.GoodsCaseMapper;
import com.sinco.carnation.goods.model.GoodsCase;
import com.sinco.carnation.goods.bo.GoodsCaseBO;
import com.sinco.carnation.goods.model.GoodsCaseExample;
import com.sinco.carnation.goods.vo.GoodsCaseVO;
import com.sinco.dal.common.MyPage;

@Repository
public class GoodsCaseDao {

	@Autowired
	private GoodsCaseMapper mapper;

	/**
	 * 根据标识查找
	 * 
	 * @param caseId
	 * @param display
	 * @param count
	 * @return
	 */
	public List<GoodsCaseBO> findCaseId(String caseId, Boolean display, Integer count) {
		GoodsCaseExample example = new GoodsCaseExample();
		// 查询其他类型为0的橱窗
		GoodsCaseExample.Criteria c = example.createCriteria().andCaseIdEqualTo(caseId)
				.andOtherCaseEqualTo(0);
		if (display != null) {
			c.andDisplayEqualTo(display ? 0 : 1);
		}
		example.setOrderByClause(" sequence asc");
		example.setCount(count);

		return mapper.selectByExampleWithBLOBs(example);
	}

	/** generate code begin **/
	public List<GoodsCaseBO> findAll() {
		GoodsCaseExample example = new GoodsCaseExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsCaseExample example = new GoodsCaseExample();
		return mapper.countByExample(example);
	}

	public List<GoodsCase> save(Iterable<GoodsCase> entities) {
		List<GoodsCase> list = new ArrayList<GoodsCase>();
		for (GoodsCase GoodsCase : entities) {
			list.add(save(GoodsCase));
		}
		return list;
	}

	public GoodsCase save(GoodsCase record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsCase record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsCaseBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsCaseBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsCaseExample example = new GoodsCaseExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsCaseBO> findAll(Iterable<Long> ids) {
		GoodsCaseExample example = new GoodsCaseExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsCase entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsCase> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsCase entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsCaseExample example = new GoodsCaseExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsCaseExample example = new GoodsCaseExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<GoodsCaseBO> findPageByVO(GoodsCaseVO vo, MyPage<GoodsCaseBO> page) {
		return mapper.findPageByVO(vo, page);
	}
}
