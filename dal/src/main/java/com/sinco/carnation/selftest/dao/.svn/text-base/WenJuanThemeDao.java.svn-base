package com.sinco.carnation.selftest.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.selftest.mapper.WenJuanThemeMapper;
import com.sinco.carnation.selftest.model.WenJuanTheme;
import com.sinco.carnation.selftest.bo.WenJuanThemeBO;
import com.sinco.carnation.selftest.model.WenJuanThemeExample;
import com.sinco.carnation.selftest.vo.WenJuanThemeVO;
import com.sinco.dal.common.MyPage;

@Repository
public class WenJuanThemeDao {

	@Autowired
	private WenJuanThemeMapper mapper;

	/** generate code begin **/
	public List<WenJuanThemeBO> findAll() {
		WenJuanThemeExample example = new WenJuanThemeExample();
		return mapper.selectByExample(example);
	}

	List<WenJuanThemeBO> findAll(Iterable<Long> ids) {
		WenJuanThemeExample example = new WenJuanThemeExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		WenJuanThemeExample example = new WenJuanThemeExample();
		return mapper.countByExample(example);
	}

	public List<WenJuanTheme> save(Iterable<WenJuanTheme> entities) {
		List<WenJuanTheme> list = new ArrayList<WenJuanTheme>();
		for (WenJuanTheme WenJuanTheme : entities) {
			list.add(save(WenJuanTheme));
		}
		return list;
	}

	public WenJuanTheme save(WenJuanTheme record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WenJuanTheme record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public WenJuanThemeBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WenJuanThemeExample example = new WenJuanThemeExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(WenJuanTheme entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<WenJuanTheme> entities) {
		List<Long> ids = Lists.newArrayList();
		for (WenJuanTheme entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WenJuanThemeExample example = new WenJuanThemeExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WenJuanThemeExample example = new WenJuanThemeExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<WenJuanThemeBO> findByPage(MyPage<WenJuanTheme> page, WenJuanThemeVO vo) {
		return this.mapper.findByPage(page, vo);
	}
}
